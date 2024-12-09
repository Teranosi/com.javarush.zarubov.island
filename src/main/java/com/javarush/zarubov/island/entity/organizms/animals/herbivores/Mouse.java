package com.javarush.zarubov.island.entity.organizms.animals.herbivores;

import com.javarush.zarubov.island.abstraction.annotations.TypeData;
import com.javarush.zarubov.island.entity.organizms.Limit;

@TypeData(name = "Мышка", icon = "\uD83D\uDC01", maxWeight = 0.05, maxCountInCell = 500,
        flockSize = 50, maxSpeed = 1, maxFood = 0.01)
public class Mouse extends Herbivore {
    public Mouse(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
