package person.learn.threecacheexample.service.impl;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Male extends Person {
    private Animal animal;
    public Male(Animal animal) {
        this.animal = animal;
    }
}
