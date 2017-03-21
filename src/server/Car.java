package server;

/**
 * Created by caoquan on 3/21/17.
 */
public class Car {
    private String id;
    public Car(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                '}';
    }
}
