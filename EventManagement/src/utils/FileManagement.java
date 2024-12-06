/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Event;

/**
 *
 * @author andymai
 */
public class FileManagement implements IDataLayer{
    private String filepath;

    public FileManagement(String filepath) {
        this.filepath = filepath;
    }
    
    
    
    @Override
    public List<Event> readFile() {
        List<Event> result = new ArrayList<>();
        File file = new File(filepath);
        if(!file.exists()){
            System.out.println("File at " + filepath + " does not exist!");
        }else{
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                Event temp;
                while(true){
                    try {
                        temp = (Event)ois.readObject();
                        result.add(temp);
                    } catch (Exception e) {
                        break;
                    }
                }
                
                System.out.println("Read data successfully!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally{
                try {
                    ois.close();
                    fis.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
          
            }
        }
        
        return result;
    }

    @Override
    public void writeFile(List<Event> listData) {
        if(listData.isEmpty()){
            System.out.println("Nothing to save...?");
            return;
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filepath);
            oos = new ObjectOutputStream(fos);
            for (Event event : listData) {
                oos.writeObject(event);
            }
            System.out.println("Save file to " + filepath + " successfully!");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    
}
