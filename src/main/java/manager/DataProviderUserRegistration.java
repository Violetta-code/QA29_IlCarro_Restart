package manager;

import models.User;
import models.UserRegistration;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUserRegistration {

    @DataProvider
    public Iterator<Object[]> registrationWrongEmailFile() throws IOException {
        List<Object[]> listData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/invalidEmailData.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]all =  line.split(",");
            listData.add(new Object[]{new UserRegistration().setFirstName(all[0]).setLastName(all[1]).setEmail(all[2]).setPassword(all[3])});
            line = reader.readLine();
        }
        return listData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationWrongPasswordFile() throws IOException {
        List<Object[]>listData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/invalidPasswordData.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]all =  line.split(",");
            listData.add(new Object[]{new UserRegistration().setFirstName(all[0]).setLastName(all[1]).setEmail(all[2]).setPassword(all[3])});
            line = reader.readLine();
        }
        return listData.iterator();
    }
}
