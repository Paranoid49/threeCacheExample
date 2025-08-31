/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package person.learn.threecacheexample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import person.learn.threecacheexample.service.impl.Animal;
import person.learn.threecacheexample.service.impl.Person;

@Slf4j
@RestController
public class BasicController {

    @Autowired
    private Animal animal;

    @Autowired
    private Person person;

    // http://127.0.0.1:8080/
    @RequestMapping("/")
    public String hello() {
        log.info(animal.getClass().getSimpleName());
        log.info(animal.getClass().getName());
        log.info(person.getClass().getSimpleName());
        log.info(person.getClass().getName());
        return "";
    }
}
