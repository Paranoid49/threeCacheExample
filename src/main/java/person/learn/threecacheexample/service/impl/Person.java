package person.learn.threecacheexample.service.impl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import person.learn.threecacheexample.service.Nature;

@Getter
@Service
public class Person implements Nature {
    @Value("${person.sex}")
    private String sex;

    @Autowired
    private Animal animal;

    @Override
    public Person create() {
        if (sex.equals("male")) {
            return new Male(animal);
        }
        if (sex.equals("female")) {
            return new Female(animal);
        }
        return this;
    }
}
