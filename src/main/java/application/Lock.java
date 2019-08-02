package application;

import lombok.Getter;

@Getter
public class Lock {

    // row, column
    private Switcher[][] switchers;

    public Lock(Switcher[][] switchers) {
        this.switchers = switchers;
    }

    public void turnSwitcher(int row, int column) {
        System.out.println("Turning switcher [" + row + ", " + column + "]");
        for (int i = 0; i < getMaxRows(); i++) {
            switchers[i][column].trig();
        }
        for (int i = 0; i < getMaxColumns(); i++) {
            switchers[row][i].trig();
        }
        switchers[row][column].trig();
        print();
    }

    public int getMaxColumns() {
        return switchers[0].length;
    }

    public int getMaxRows() {
        return switchers.length;
    }

    public boolean isOpened() {
        for (int i = 0; i < getMaxRows(); i++) {
            for (int j = 0; j < getMaxColumns(); j++) {
                if (switchers[i][j].isLocked()) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getStringStatus(boolean isOpened) {
        if (isOpened) {
            return "OPEN";
        }
        return "CLOSED";
    }

    public void print() {
        for (int i = 0; i < getMaxRows(); i++) {
            for (int j = 0; j < getMaxColumns(); j++) {
                System.out.print(switchers[i][j].toString() + " ");
            }
            System.out.println();
        }
        System.out.println("Status: " + getStringStatus(isOpened()));
    }

    public Lock copy() {
        Switcher[][] switchers = new Switcher[getMaxRows()][getMaxColumns()];
        for (int i = 0; i < getMaxRows(); i++) {
            for (int j = 0; j < getMaxColumns(); j++) {
                switchers[i][j] = new Switcher(this.switchers[i][j].isLocked());
            }
        }
        Lock lock = new Lock(switchers);
        return lock;
    }
}
