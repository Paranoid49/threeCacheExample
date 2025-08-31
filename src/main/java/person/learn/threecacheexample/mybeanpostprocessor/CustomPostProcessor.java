package person.learn.threecacheexample.mybeanpostprocessor;

import com.fasterxml.jackson.databind.BeanProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import person.learn.threecacheexample.service.impl.Animal;
import person.learn.threecacheexample.service.impl.Person;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    private Map<String, Object> alreadyCreateObj = new HashMap<>();

    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return createObj(bean, beanName);
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return createObj(bean, beanName);
    }

    private Object createObj(Object bean, String beanName) {
        if (!(bean instanceof Animal || bean instanceof Person)) {
            return bean;
        }
        if (alreadyCreateObj.containsKey(beanName)) {
            Object obj = alreadyCreateObj.get(beanName);
            BeanUtils.copyProperties(bean, obj); // 没找到好方法，就先从父类copy过去
            return obj;
        }
        try {
            Method method = bean.getClass().getDeclaredMethod("create");
            method.setAccessible(true);
            Object obj = method.invoke(bean);
            if (obj != null) {
                alreadyCreateObj.put(beanName, obj);
            }
            BeanUtils.copyProperties(bean, obj);
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
