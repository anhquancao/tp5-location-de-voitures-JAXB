import actions.AddAgencyAction;
import actions.AddCarAction;
import actions.AddDistanceAction;
import actions.ConvertDistanceToXmlAction;
import server.Agency;
import server.Car;
import server.Distance;
import server.LocationServer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * Created by caoquan on 3/21/17.
 */
public class LocationClient {
    public static void testAddAgency(Writer writer) {
        AddAgencyAction addAgencyAction = new AddAgencyAction(new Agency("paris"));
        try {
            writer.write(addAgencyAction.command());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testAddCar(Writer writer) {
        AddCarAction addCarAction = new AddCarAction(new Car("bmw"), "paris");
        try {
            writer.write(addCarAction.command());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testAddDistance(Writer writer) {

        AddDistanceAction addDistanceAction =
                new AddDistanceAction(new Distance("hanoi", "hcm", 12));
        try {
            writer.write(addDistanceAction.command());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testConvertToXml(Writer writer) {
        ConvertDistanceToXmlAction convertDistanceToXmlAction =
                new ConvertDistanceToXmlAction();
        try {
            writer.write(convertDistanceToXmlAction.command());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", LocationServer.PORT);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            testAddAgency(writer);
//            testAddCar(writer);
//            testAddDistance(writer);
            testConvertToXml(writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
