package com.javarush.zarubov.island.services;

import com.javarush.zarubov.island.entity.map.Cell;
import com.javarush.zarubov.island.entity.map.GameMap;
import com.javarush.zarubov.island.entity.organizms.Organism;
import com.javarush.zarubov.island.entity.organizms.Organisms;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements Runnable {

    private final Organism prototype;
    private final GameMap gameMap;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public OrganismWorker(Organism prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                try {
                    processOneCell(cell);
                } catch (Exception e) {
                    //TODO replace it -> throw...
                    e.printStackTrace();
                    System.err.println("OMG. Debug it!");
                    System.exit(0);
                }
            }
        }
    }

    private void processOneCell(Cell cell) {
        String type = prototype.getType();
        Organisms organisms = cell.getResidents().get(type);
        if (Objects.nonNull(organisms)) {
            //build tasks (need correct iteration, without any modification)
            cell.getLock().lock(); //ONLY READ
            try {
                organisms.forEach(organism -> {
                    //here possible action-cycle for entity (enum, collection or array)
                    tasks.add(new Task(organism, cell));
                });
            } finally {
                cell.getLock().unlock();
            }

            //run tasks
            //see CQRS pattern or CommandBus pattern and Producer-Consumer problem.
            //This cycle can to run in other thread or threads (pool)
            tasks.forEach(Task::doTask);
            tasks.clear();
        }
    }
}
