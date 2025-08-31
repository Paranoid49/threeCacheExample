package person.learn.threecacheexample.service.impl;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cat extends Animal {
    private Person person;
    public Cat(Person person) {
        this.person = person;
    }
}
