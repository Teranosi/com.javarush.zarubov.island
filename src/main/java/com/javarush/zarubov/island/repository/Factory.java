package com.javarush.zarubov.island.repository;

import com.javarush.zarubov.island.entity.map.Cell;
import com.javarush.zarubov.island.entity.organizms.Organism;

import java.util.List;

public interface Factory {

    Cell createRandomCell(boolean empty);

    List<Organism> getAllPrototypes();

}
