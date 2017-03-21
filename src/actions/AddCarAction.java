package actions;

import server.Car;

/**
 * Created by caoquan on 3/21/17.
 */
public class AddCarAction extends Action {
    private Car car;
    private String location;

    public AddCarAction(Car car, String location) {
        super(ActionType.ADD_CAR);
        this.car = car;
        this.location = location;
    }

    public String command() {
        return ActionType.ADD_CAR + " " + this.car.getId() + " " + this.location;
    }
}
