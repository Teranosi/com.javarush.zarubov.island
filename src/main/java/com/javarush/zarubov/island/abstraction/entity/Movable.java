package com.javarush.zarubov.island.abstraction.entity;

import com.javarush.zarubov.island.entity.map.Cell;

@FunctionalInterface
public interface Movable {

    @SuppressWarnings("UnusedReturnValue")
    boolean move(Cell startCell);

}
