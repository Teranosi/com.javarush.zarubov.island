package com.javarush.zarubov.island.entity.organizms.animals.predators;

import com.javarush.zarubov.island.abstraction.annotations.TypeData;
import com.javarush.zarubov.island.entity.organizms.Limit;

@TypeData(name = "Волк", icon = "\uD83D\uDC3A", maxWeight = 50, maxCountInCell = 30,
        flockSize = 15, maxSpeed = 3, maxFood = 8)
public class Wolf extends Predator {


    public Wolf(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
