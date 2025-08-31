package person.learn.threecacheexample.service.impl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import person.learn.threecacheexample.service.Nature;

@Getter
@Service
public class Animal implements Nature {
    @Value("${animal.name}")
    private String name;

    @Autowired
    private Person person;

    @Override
    public Animal create() {
        if (name.equals("cat")) {
            return new Cat(person);
        }
        if (name.equals("dog")) {
            return new Dog(person);
        }
        return this;
    }
}
