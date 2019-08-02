package application;

import java.util.List;
import java.util.Random;
import java.util.SortedMap;

public class Runner {

    private static Random random = new Random();

    public static void main(String args[]) {
        Lock lock = new Lock(getMatrix());
        Unlocker unlocker = new Unlocker();
        List<Step> steps = unlocker.unlock(lock);
        System.out.println("Open steps: " + steps.toString());
    }

    private static Switcher[][] generateMatrix() {
        Switcher[][] switchers = new Switcher[4][4];
        for (int i = 0; i < switchers.length; i++) {
            for (int j = 0; j < switchers.length; j++) {
                switchers[i][j] = new Switcher(random.nextBoolean());
            }
        }
        return switchers;
    }

    private static Switcher[][] getMatrix() {
        Switcher[][] switchers = new Switcher[4][4];
        switchers[0][0] = new Switcher(true);
        switchers[0][1] = new Switcher(false);
        switchers[0][2] = new Switcher(false);
        switchers[0][3] = new Switcher(true);

        switchers[1][0] = new Switcher(true);
        switchers[1][1] = new Switcher(false);
        switchers[1][2] = new Switcher(false);
        switchers[1][3] = new Switcher(true);

        switchers[2][0] = new Switcher(true);
        switchers[2][1] = new Switcher(false);
        switchers[2][2] = new Switcher(true);
        switchers[2][3] = new Switcher(false);

        switchers[3][0] = new Switcher(false);
        switchers[3][1] = new Switcher(true);
        switchers[3][2] = new Switcher(false);
        switchers[3][3] = new Switcher(true);

        return switchers;
    }
}
