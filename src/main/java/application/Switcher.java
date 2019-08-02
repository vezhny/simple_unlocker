package application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Switcher {

    private boolean locked;

    public void trig() {
        locked = !locked;
    }

    /**
     * Возвращает 1, если тумблер открыт
     * 0 в противном случае
     */
    public int status() {
        if (locked) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return String.valueOf(status());
    }
}
