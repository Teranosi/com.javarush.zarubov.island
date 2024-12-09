package com.javarush.zarubov.island.entity.organizms.animals.herbivores;

import com.javarush.zarubov.island.entity.organizms.Limit;
import com.javarush.zarubov.island.entity.organizms.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
