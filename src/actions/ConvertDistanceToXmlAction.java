package actions;

/**
 * Created by caoquan on 3/21/17.
 */
public class ConvertDistanceToXmlAction extends Action {

    public ConvertDistanceToXmlAction() {
        super(ActionType.CONVERT_DISTANCES_TO_XML);
    }

    public String command() {
        return this.getType();
    }
}
