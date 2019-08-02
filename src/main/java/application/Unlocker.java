package application;

import java.util.*;

public class Unlocker {

    private Random random = new Random();

    private SortedMap<Integer, List<Step>> steps;

    public List<Step> unlock(Lock lock) {
        lock.print();
        steps = new TreeMap<Integer, List<Step>>();
        for (int i = 0; i < 10000; i++) {
            steps.put(i, new ArrayList<Step>());
            Lock unlockingLock = lock.copy();
            unlock(unlockingLock, i);
        }
        return getShortestStepsList();
    }

    private List<Step> getShortestStepsList() {
        List<Step> shortList = steps.get(steps.firstKey());
        for (Map.Entry<Integer, List<Step>> entry : steps.entrySet()) {
            if (entry.getValue().size() < shortList.size()) {
                shortList = entry.getValue();
            }
        }
        return shortList;
    }

    private void unlock(Lock lock, int iteration) {
        while (!lock.isOpened()) {
            Step step = new Step(random.nextInt(lock.getMaxRows()), random.nextInt(lock.getMaxColumns()));
            lock.turnSwitcher(step.getRow(), step.getColumn());
            steps.get(iteration).add(step);
            if (steps.get(iteration).size() > 50) {
                steps.remove(iteration);
                break;
            }
        }
    }
}
