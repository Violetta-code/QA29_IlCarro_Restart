package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> loginValidFile() throws IOException {
        List<Object[]>listData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/validDataFromIlCarro.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]all =  line.split(",");
            listData.add(new Object[]{new User().withEmail(all[0]).withPassword(all[1])});
            line = reader.readLine();
        }
        return listData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginWrongEmailFile() throws IOException {
        List<Object[]>listData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/wrongEmailData.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]all =  line.split(",");
            listData.add(new Object[]{new User().withEmail(all[0]).withPassword(all[1])});
            line = reader.readLine();
        }
        return listData.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginWrongPasswordFile() throws IOException {
        List<Object[]>listData = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/wrongPasswordData.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[]all =  line.split(",");
            listData.add(new Object[]{new User().withEmail(all[0]).withPassword(all[1])});
            line = reader.readLine();
        }
        return listData.iterator();
    }
}
