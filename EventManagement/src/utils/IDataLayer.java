/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;

import java.util.List;
import model.Event;

/**
 *
 * @author andymai
 */
public interface IDataLayer {
//    readFile:List<Event>
//    writeFile: void
    public List<Event> readFile();
    public void writeFile(List<Event> listData);
}
