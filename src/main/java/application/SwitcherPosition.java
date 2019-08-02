package application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SwitcherPosition {

    private int column;
    private int row;

    public SwitcherPosition(String position) {
        String[] numbers = position.split("\\D+");
        column = Integer.parseInt(numbers[0]);
        row = Integer.parseInt(numbers[1]);
    }

    @Override
    public String toString() {
        return "[" + column + "-" + row + "]";
    }
}
