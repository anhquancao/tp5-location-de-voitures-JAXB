package server;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by caoquan on 3/21/17.
 */
public class CompanyLocation {
    private List<Agency> agencies;

    public CompanyLocation() {
        this.agencies = new ArrayList<>();
    }

    public void addAgency(Agency agency) {
        this.agencies.add(agency);
        System.out.println("Agency added: " + agency);
    }

    public void addCar(String location, Car car) throws Exception {
        Supplier<Stream<Agency>> streamSupplier =
                () -> this.agencies.stream().filter(agency -> agency.getLocation().equals(location));
        long num = streamSupplier.get().count();
        if (num == 0) {
            throw new AgencyNotFoundException("Cannot find the agency with location " + location);
        }
        Agency agency = (Agency) streamSupplier.get().findFirst().get();
        agency.addCar(car);
        System.out.println("Car added: " + car + "\nAgency: " + agency);
    }
}
