package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class DataLoader {
    public static <T> HashMap<Integer, T> load(String filePath, String fileName){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath + fileName))){
            return (HashMap<Integer, T>) in.readObject();
        }catch (Exception e){
            System.out.println("Error loading data from: " + fileName +": "+ e.getMessage());
            return new HashMap<>();
        }
    }

    public static <T> void save(String filePath, String fileName, HashMap<Integer, T> data){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath+fileName))){
            out.writeObject(data);
        }catch (Exception e){
            System.out.println("Error saving data to: " + fileName +": "+ e.getMessage());
        }

    }

}
