### 参考SpringAop自己做的实践：
#### 在bean初始化后，通过自定义BeanPostProcessor，来更改三级缓存的行为，使其返回一个当前bean的子类
#### 最终效果为：spring容器中的类为controller中显式注入的类的子类
