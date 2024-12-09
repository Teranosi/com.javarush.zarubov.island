package com.javarush.zarubov.island.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.javarush.zarubov.island.entity.map.GameMap;
import com.javarush.zarubov.island.repository.Factory;
import com.javarush.zarubov.island.view.View;

@Getter
@RequiredArgsConstructor
public class Game {

    private final GameMap gameMap;
    private final Factory entityFactory;
    private final View view;

}
