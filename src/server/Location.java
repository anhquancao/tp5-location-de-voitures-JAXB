package server;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by caoquan on 3/21/17.
 */
@XmlRootElement
public class Location {
    private String carId;
    private String departureLocation;
    private String arrivalLocation;
    private Date departureDate;
    private Date arrivalDate;

    public Location() {
    }

    public Location(String carId, String departureLocation, String arrivalLocation, Date departureDate, Date arrivalDate) {
        this.carId = carId;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    @XmlAttribute
    public String getCarId() {
        return carId;
    }

    @XmlElement
    public String getDepartureLocation() {
        return departureLocation;
    }

    @XmlElement
    public String getArrivalLocation() {
        return arrivalLocation;
    }

    @XmlElement
    public Date getDepartureDate() {
        return departureDate;
    }

    @XmlElement
    public Date getArrivalDate() {
        return arrivalDate;
    }
}
