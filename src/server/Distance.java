package server;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by caoquan on 3/21/17.
 */
@XmlRootElement(name = "distance")
public class Distance {
    @XmlElement
    private String fromLocation;

    @XmlElement
    private String toLocation;

    @XmlAttribute
    private int distance;

    public Distance() {
    }

    public Distance(String fromLocation, String toLocation, int distance) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.distance = distance;
    }


    public String getFromLocation() {
        return fromLocation;
    }


    public String getToLocation() {
        return toLocation;
    }


    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", distance=" + distance +
                '}';
    }
}
