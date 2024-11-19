/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import utils.MyLib;

/**
 *
 * @author andymai
 */
public class Event {

    private String event_id;
    private String event_name;
    private String event_date;
//    yyyy/mm/dd
    private String location;
    private int number_of_attendees;
    private String event_status;

    public Event() {

    }

    public Event(String event_id, String event_name, String event_date, String location, int number_of_attendees, String event_status) {
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_date = event_date;
        this.location = location;
        this.number_of_attendees = number_of_attendees;
        this.event_status = event_status;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber_of_attendees() {
        return number_of_attendees;
    }

    public void setNumber_of_attendees(int number_of_attendees) {
        this.number_of_attendees = number_of_attendees;
    }

    public String getEvent_status() {
        return event_status;
    }

    public void setEvent_status(String event_status) {
        this.event_status = event_status;
    }

    public boolean create_new_event() {
        this.event_id = MyLib.generateID("E");

        this.event_name = MyLib.getString("Enter event's name: ");
//        Check name >= 5 character
        if (this.getEvent_name().length() < 5) {
            System.out.println("Error message: Event name is at least five characters long");
            return false;
        }
//        Check name does not contain spaces
        String temp_name = this.getEvent_name();
        char[] tmp_name_arr = temp_name.toCharArray();
        for (char c : tmp_name_arr) {
            if (c == ' ') {
                System.out.println("Error message: Event name does not contain spaces");
                return false;
            }
        }

        this.event_date = MyLib.getString("Enter event's date: ");
        //        Check date format "yyyy/mm/dd"
        String temp_date = this.getEvent_date();
        if (!temp_date.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            System.out.println("Error message: Event date must be follow instructor (yyyy-mm-dd)");
            return false;
        }

        this.location = MyLib.getString("Enter event's location: ");
        while (true) {
            try {
                this.number_of_attendees = MyLib.getIntegerNumber("Enter num of attendees: ");
                //        Check Number of attendees must be greater than 0
                if (this.getNumber_of_attendees() <= 0) {
                    System.out.println("Error message: Number of attendees must be greater than 0");
                    return false;
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        this.event_status = MyLib.getString("Enter event's status: ");
        //        Check Status is either \"Available\" or \"Not Available\"
        if(!this.getEvent_status().equals("Available") 
                && !this.getEvent_status().equals("Not Available")){
            System.out.println("Error message: Status is either Available or Not Available");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event{" + "event_id=" + event_id + ", event_name=" + event_name + ", event_date=" + event_date + ", location=" + location + ", number_of_attendees=" + number_of_attendees + ", event_status=" + event_status + '}';
    }

}
