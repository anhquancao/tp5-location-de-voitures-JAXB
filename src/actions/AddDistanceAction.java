package actions;

import server.Distance;

/**
 * Created by caoquan on 3/21/17.
 */
public class AddDistanceAction extends Action {
    private Distance distance;

    public AddDistanceAction(Distance distance) {
        super(ActionType.ADD_DISTANCE);
        this.distance = distance;
    }

    public String command() {
        return this.getType() + " "
                + this.distance.getFromLocation() + " "
                + this.distance.getToLocation() + " "
                + this.distance.getDistance();
    }
}
