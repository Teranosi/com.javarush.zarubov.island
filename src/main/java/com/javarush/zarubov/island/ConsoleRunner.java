package com.javarush.zarubov.island;


import com.javarush.zarubov.island.config.Setting;
import com.javarush.zarubov.island.entity.Game;
import com.javarush.zarubov.island.entity.map.GameMap;
import com.javarush.zarubov.island.repository.EntityFactory;
import com.javarush.zarubov.island.repository.Factory;
import com.javarush.zarubov.island.repository.GameMapCreator;
import com.javarush.zarubov.island.services.GameWorker;
import com.javarush.zarubov.island.view.ConsoleView;
import com.javarush.zarubov.island.view.View;

public class ConsoleRunner {
    public static void main(String[] args) {

        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        int rows = Setting.get().getRows();
        int cols = Setting.get().getCols();
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(rows, cols, false);
        View view=new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory, view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start(); // +1 ПОБОЧНЫЙ ПОТОК

        // КОНТЕКСТ

    }
}
