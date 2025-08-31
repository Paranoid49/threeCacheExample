package person.learn.threecacheexample.service.impl;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Female extends Person {
    private Animal animal;
    public Female(Animal animal) {
        this.animal = animal;
    }
}
