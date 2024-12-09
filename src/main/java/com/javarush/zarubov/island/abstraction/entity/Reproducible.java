package com.javarush.zarubov.island.abstraction.entity;

import com.javarush.zarubov.island.entity.map.Cell;

@FunctionalInterface
public interface Reproducible {

    @SuppressWarnings("UnusedReturnValue")
    boolean spawn(Cell currentCell);

}
