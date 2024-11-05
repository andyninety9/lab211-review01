/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import utils.MyLib;

/**
 *
 * @author andymai
 */
public class MainProgram {
    
    public static void main(String[] args) {

        int choice = 0;
        do{
            Menu.displayMainMenu();
            while (true) {                
                try {
                    choice = MyLib.getIntegerNumber("Enter your choice[1-6]: ");
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            switch(choice){
                case 1: {
                    
                   
                    break;
                }
                case 2: {
                    
                    break;
                }
                case 3: {
                    
                    break;
                }
                case 4:{
                    
                    break;
                }
                case 5:{
                    
                    break;
                }
                case 6:{
                    
                    break;
                }
                default:{
                    System.out.println("Thank you!!!");
                    return;
                }
            }
            
        }while(choice >= 1 && choice <= 6);
    }
}
