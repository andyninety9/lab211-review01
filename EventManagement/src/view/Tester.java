/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Event;
import utils.MyLib;

/**
 *
 * @author andymai
 */
public class Tester {
    public static void main(String[] args) {
        try {
            Event e = new Event();
            e.create_new_event();
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
