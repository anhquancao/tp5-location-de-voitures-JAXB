package actions;

import server.Agency;

/**
 * Created by caoquan on 3/21/17.
 */
public class AddAgencyAction extends Action {
    private Agency agency;

    public AddAgencyAction(Agency agency) {
        super(ActionType.ADD_AGENCY);
        this.agency = agency;
    }

    public String command() {
        return ActionType.ADD_AGENCY + " " + this.agency.getLocation();
    }
}
