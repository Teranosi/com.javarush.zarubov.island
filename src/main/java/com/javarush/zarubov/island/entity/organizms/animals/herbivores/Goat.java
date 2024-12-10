package com.javarush.zarubov.island.entity.organizms.animals.herbivores;

import com.javarush.zarubov.island.abstraction.annotations.TypeData;
import com.javarush.zarubov.island.entity.organizms.Limit;

@TypeData(name = "Коза", icon = "\uD83D\uDC10", maxWeight = 60, maxCountInCell = 140,
        flockSize = 5, maxSpeed = 3, maxFood = 10)
public class Goat extends Herbivore {
    public Goat(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
