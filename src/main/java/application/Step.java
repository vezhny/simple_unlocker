package application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Step {

    private int row;
    private int column;

    @Override
    public String toString() {
        return "[" + row + "-" + column + "]";
    }
}
