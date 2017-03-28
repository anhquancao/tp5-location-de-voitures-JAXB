package server;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caoquan on 3/28/17.
 */
@XmlRootElement(name = "distances")
public class Distances {
    @XmlElement(name = "distance")
    private List<Distance> distances;

    public Distances() {
        this.distances = new ArrayList<>();
    }


    public List<Distance> getDistances() {
        return distances;
    }


    public static void convertToXml(Distances distances) {
        try {
            JAXBContext context = JAXBContext.newInstance(Distances.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(distances, System.out);
            marshaller.marshal(distances, new FileOutputStream("distances.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
