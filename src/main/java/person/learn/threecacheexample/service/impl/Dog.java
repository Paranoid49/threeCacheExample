package person.learn.threecacheexample.service.impl;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Dog extends Animal {
    private Person person;
    public Dog(Person person) {
        this.person = person;
    }
}
