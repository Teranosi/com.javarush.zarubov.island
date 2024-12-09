package com.javarush.zarubov.island.entity.organizms.plants;

import com.javarush.zarubov.island.abstraction.annotations.TypeData;
import com.javarush.zarubov.island.config.Setting;
import com.javarush.zarubov.island.entity.map.Cell;
import com.javarush.zarubov.island.entity.organizms.Limit;
import com.javarush.zarubov.island.entity.organizms.Organism;
import com.javarush.zarubov.island.entity.organizms.Organisms;
import com.javarush.zarubov.island.util.Rnd;

@TypeData(name = "Трава", icon = "\uD83E\uDEB4", maxWeight = 1, maxCountInCell = 200, flockSize = 20, maxSpeed = 0, maxFood = 0)
public class Plant extends Organism {
    public Plant(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

    @Override
    public boolean spawn(Cell cell) {
        this.safeChangeWeight(cell, Setting.get().getPercentPlantGrow());
        boolean born = false;
        for (int i = 0; i < 6; i++) {
            Cell neighborCell = cell.getNextCell(Rnd.random(0, 2));
            born |= safePlantPropagation(neighborCell);
        }

        return born;
    }

    private boolean safePlantPropagation(Cell cell) {
        Limit limit = getLimit();
        cell.getLock().lock();
        try {
            Organisms plants = cell.getResidents().get(getType());
            if (plants.size() < limit.getMaxCountInCell() &&
                    getWeight() > limit.getMaxWeight() / 2
            ) {
                Organism newPlant = Organism.clone(this);
                double childWeight = getWeight() / 10;
                newPlant.setWeight(childWeight);
                return plants.add(newPlant);
            }
        } finally {
            cell.getLock().unlock();
        }
        return false;
    }
}
