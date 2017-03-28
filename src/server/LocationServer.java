package server;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by caoquan on 3/21/17.
 */
public class LocationServer {
    public static final int PORT = 55555;
    private ServerSocket serverSocket;
    private int port;
    private ExecutorService pool;
    private CompanyLocation companyLocation;


    LocationServer(int port) {
        this.companyLocation = new CompanyLocation();
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool = Executors.newFixedThreadPool(15);
    }

    public void start() {
        System.out.println("Server is listening at port " + this.port);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accept");
                LocationSlave slave = new LocationSlave(socket.getInputStream(), this.companyLocation);
                pool.execute(slave);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void convertXmlToObject() {
        try {
            JAXBContext context = JAXBContext.newInstance(Distances.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Distances distances = (Distances) unmarshaller.unmarshal(new File("distances.xml"));
            for (Distance d : distances.getDistances()) {
                System.out.println(d);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LocationServer server = new LocationServer(PORT);
        server.start();

//        convertXmlToObject();


//        Date arrivalDate = null;
//        Date departureDate = null;
//        try {
//            arrivalDate = new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-28");
//            departureDate = new SimpleDateFormat("yyyy-MM-dd").parse("2017-03-21");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        Location location =
//                new Location("1", "hanoi",
//                        "hcm", departureDate, arrivalDate);
//        Location location1 =
//                new Location("2", "hanoi",
//                        "hcm", departureDate, arrivalDate);
//        Locations locations = new Locations();
//        List<Location> locationsList = new ArrayList<>();
//        locationsList.add(location);
//        locationsList.add(location1);
//        locations.setLocations(locationsList);
//        try {
//            JAXBContext context = JAXBContext.newInstance(Locations.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            marshaller.marshal(locations, System.out);
//            marshaller.marshal(locations, new FileOutputStream("localtions.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
