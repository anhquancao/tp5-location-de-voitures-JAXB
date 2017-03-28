package server;

import actions.ActionType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by caoquan on 3/21/17.
 */
public class LocationSlave implements Runnable {
    private InputStream inputStream;
    private CompanyLocation companyLocation;

    LocationSlave(InputStream inputStream, CompanyLocation companyLocation) {
        this.companyLocation = companyLocation;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream));
        try {
            String data = reader.readLine();
            System.out.println(data);
            String[] strs = data.split(" ");
            String cmd = strs[0];
            switch (cmd) {
                case ActionType.ADD_AGENCY:
                    String location = strs[1];
                    this.companyLocation.addAgency(new Agency(location));
                    break;
                case ActionType.ADD_CAR:
                    String id = strs[1];
                    String agencyLocation = strs[2];
                    Car car = new Car(id);
                    this.companyLocation.addCar(agencyLocation, car);
                    break;
                case ActionType.ADD_DISTANCE:
                    String fromLocation = strs[1];
                    String toLocation = strs[2];
                    int distance = Integer.parseInt(strs[3]);
                    Distance newDistance = new Distance(fromLocation, toLocation, distance);
                    this.companyLocation.addDistance(newDistance);
                    break;
                case ActionType.CONVERT_DISTANCES_TO_XML:
                    Distances.convertToXml(this.companyLocation.getDistances());
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
