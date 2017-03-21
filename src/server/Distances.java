package server;

/**
 * Created by caoquan on 3/21/17.
 */
public class Distances {
    private String fromLocation;
    private String toLocation;
    private int distance;

    public Distances(String fromLocation, String toLocation, int distance) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.distance = distance;
    }
}
