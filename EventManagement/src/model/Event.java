/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import utils.MyLib;

/**
 *
 * @author andymai
 */
public class Event implements Serializable{

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
        while (true) {
            if (!utils.Validation.validate_name(event_name)) {
                if (MyLib.confirmOption("Do you want to continue[Yes/No]?")) {
                    this.event_name = MyLib.getString("Enter event's name again: ");
                }else{
                    break;
                }
            } else {
                break;
            }
        }
        this.event_date = MyLib.getString("Enter event's date: ");
        //        Check date format "yyyy/mm/dd"
        while(true){
            if(!utils.Validation.validate_date(event_date)){
                if(MyLib.confirmOption("Do you want to continue[Yes/No]?")){
                    this.event_date = MyLib.getString("Enter event's date again: ");
                }else{
                    break;
                }

            }else{
                break;
            }
        }

        this.location = MyLib.getString("Enter event's location: ");
        while (true) {
            try {
                this.number_of_attendees = MyLib.getIntegerNumber("Enter num of attendees: ");
                //        Check Number of attendees must be greater than 0
                while (true) {
                    if (!utils.Validation.validate_number_of_attendees(number_of_attendees)) {
                        if (MyLib.confirmOption("Do you want to continue[Yes/No]?")) {
                            this.number_of_attendees = MyLib.getIntegerNumber("Enter num of attendees again: ");
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        this.event_status = MyLib.getString("Enter event's status: ");
        //        Check Status is either \"Available\" or \"Not Available\"
        while(true){
            if(!utils.Validation.validate_status(event_status)){
                if(MyLib.confirmOption("Do you want to continue[Yes/No]?")){
                    this.event_status = MyLib.getString("Enter event's status again: ");
                }else{
                    break;
                }

            }else{
                break;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event{" + "event_id=" + event_id + ", event_name=" + event_name + ", event_date=" + event_date + ", location=" + location + ", number_of_attendees=" + number_of_attendees + ", event_status=" + event_status + '}';
    }

}
