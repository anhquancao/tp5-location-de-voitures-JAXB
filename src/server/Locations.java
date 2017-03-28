package server;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by caoquan on 3/28/17.
 */
@XmlRootElement
public class Locations {

    private List<Location> locations;

    @XmlElement(name = "location")
    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
