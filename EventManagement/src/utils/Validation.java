/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author andymai
 */
public class Validation {
    public static boolean validate_name(String name){
        if (name.length() < 5) {
            System.out.println("Error message: Event name is at least five characters long");
            return false;
        }
//        Check name does not contain spaces
        String temp_name = name;
        char[] tmp_name_arr = temp_name.toCharArray();
        for (char c : tmp_name_arr) {
            if (c == ' ') {
                System.out.println("Error message: Event name does not contain spaces");
                return false;
            }
        }
        return true;
    }
    public static boolean validate_date(String date) {
        String temp_date = date;
        if (!temp_date.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            System.out.println("Error message: Event date must be follow instructor (yyyy-mm-dd)");
            return false;
        }
        return true;
    }
    
    public static boolean validate_number_of_attendees(int attendees){
        if (attendees <= 0) {
                System.out.println("Error message: Number of attendees must be greater than 0");
                return false;
        }
        return true;
    }
    
    public static boolean validate_status(String status){
        if(!status.equals("Available") 
                && !status.equals("Not Available")){
            System.out.println("Error message: Status is either Available or Not Available");
            return false;
        }
        return true;
    }
}
