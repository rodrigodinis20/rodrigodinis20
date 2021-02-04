package org.academiadecodigo.carcrash.cars;

import com.googlecode.lanterna.terminal.Terminal;
import org.academiadecodigo.carcrash.field.Position;

public class CarFactory {

    public static Car getNewCar() {
        if ((Math.random()) > 0.7) {
            return new Mustang(2);

        }
        return new Fiat(1);
    }


}
