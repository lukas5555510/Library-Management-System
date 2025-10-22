package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class DataUtil {

    private static String FILE_PATH = System.getProperty("user.dir")+"/src/main/java/data/";

    public static <T> HashMap<Integer, T> load(String fileName){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH + fileName))){
            return (HashMap<Integer, T>) in.readObject();
        }catch (Exception e){
            System.out.println("Error loading data from: " + fileName +": "+ e.getMessage());
            return new HashMap<>();
        }
    }

    public static <T> void save(String fileName, HashMap<Integer, T> data){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH + fileName))){
            out.writeObject(data);
        }catch (Exception e){
            System.out.println("Error saving data to: " + fileName +": "+ e.getMessage());
        }
    }

}
