package manager;

import models.Car;
import models.UserRegistration;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCar {

    @DataProvider
    public Iterator<Car[]> validCarFile() throws IOException {
        List<Car[]> listData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/validDataCarModel.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]all =  line.split("/");
            listData.add(new Car[]{new Car().setLocation(all[0]).setManufacture(all[1]).setModel(all[2]).setYear(all[3])
                    .setFuel(all[4]).setSeats(Integer.parseInt(all[5])).setCarClass(all[6]).setCarRegNumber(all[7])
                    .setPrice(Double.parseDouble(all[8])).setAbout(all[9])});
            line = reader.readLine();
        }
        return listData.iterator();
    }
}
