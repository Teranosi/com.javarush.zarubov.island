package com.javarush.zarubov.island.abstraction.entity;

import com.javarush.zarubov.island.entity.map.Cell;

@SuppressWarnings("unused")
@FunctionalInterface
public interface Eating {

    boolean eat(Cell currentCell);

}
