package com.javarush.zarubov.island.entity.organizms.animals.herbivores;

import com.javarush.zarubov.island.abstraction.annotations.TypeData;
import com.javarush.zarubov.island.entity.organizms.Limit;

@TypeData(name = "Кабан", icon = "\uD83D\uDC17", maxWeight = 400, maxCountInCell = 50,
        flockSize = 7, maxSpeed = 2, maxFood = 50)
public class Boar extends Herbivore {
    public Boar(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
