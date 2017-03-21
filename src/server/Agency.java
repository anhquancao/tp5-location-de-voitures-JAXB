package server;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoquan on 3/21/17.
 */
public class Agency {
    private String location;
    private List<Car> cars;

    public Agency() {
    }

    public Agency(String location) {
        this.location = location;
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public String getLocation() {
        return location;
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
