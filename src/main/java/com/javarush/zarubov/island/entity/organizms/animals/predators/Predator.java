package com.javarush.zarubov.island.entity.organizms.animals.predators;

import com.javarush.zarubov.island.entity.organizms.Limit;
import com.javarush.zarubov.island.entity.organizms.animals.Animal;

public abstract class Predator extends Animal {


    public Predator(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }


}
