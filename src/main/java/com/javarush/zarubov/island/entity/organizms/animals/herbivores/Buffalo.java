package com.javarush.zarubov.island.entity.organizms.animals.herbivores;

import com.javarush.zarubov.island.abstraction.annotations.TypeData;
import com.javarush.zarubov.island.entity.organizms.Limit;

@TypeData(name = "Буйвол", icon = "\uD83D\uDC03", maxWeight = 700, maxCountInCell = 10,
        flockSize = 4, maxSpeed = 3, maxFood = 100)
public class Buffalo extends Herbivore {
    public Buffalo(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
