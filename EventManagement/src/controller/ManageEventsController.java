/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Event;
import utils.MyLib;

/**
 *
 * @author andymai
 */
public class ManageEventsController implements Serializable{
    private List<Event> listEvent;

    public ManageEventsController() {
        this.listEvent = new ArrayList<>();
    }

    public ManageEventsController(List<Event> listEvent) {
        this.listEvent = listEvent;
    }

    public List<Event> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<Event> listEvent) {
        this.listEvent = listEvent;
    }
//    -=====================================================================================-
//    1. addNewEvent(): bool 
    public boolean add_new_event(){
        Event temp = new Event();
        boolean isValid = temp.create_new_event();
        if(isValid){
            this.listEvent.add(temp);
            return true;
        }
        
        return false;
    }
//    -=====================================================================================-
    
//    2. searchEvent(): bool
    public boolean search_event(String event_id){
        for (Event event : listEvent) {
            if(event.getEvent_id().equalsIgnoreCase(event_id)){
                return true;
            }
        }
        return false;
    }
    
//    3. display_event_list(): void
    public void display_event_list() {
        for (Event event : listEvent) {
            System.out.printf("|%10s|%15s|%10s|%15s|%5d|%15s|\n",
                    event.getEvent_id(), event.getEvent_name(), event.getEvent_date(), event.getLocation(),
                     event.getNumber_of_attendees(), event.getEvent_status());
        }
    }
//    Ho Chi Minh -> Ho
//    4. Search event information by location
    public List<Event> search_event_by_location(String location){
        List<Event> result = new ArrayList<>();
        for (Event event : listEvent) {
            if(event.getLocation().contains(location)){
                result.add(event);
            }
        }
        return result;
    }
//    5. Update
//    input: ID
    public boolean update_event_by_id(String id){
//    Lấy ra event có id cần update
//update thông tin trên thằng đã lấy ra
//ghi đè lại vào danh sách
        boolean is_found = false;
        Event update_item = null;
        for (Event event : listEvent) {
            if(event.getEvent_id().equalsIgnoreCase(id)){
                update_item = event;
                is_found = true;
                break;
            }
        }
        if(!is_found){
            System.out.println("Id not found!!!");
            return false;
        }else{
            if (MyLib.confirmOption("Do you want to update name?[Yes/No]")) {
                String new_name = MyLib.getString("Enter new name: ");
                while (true) {
                    if (!utils.Validation.validate_name(new_name)) {
                        if (MyLib.confirmOption("Do you want to continue[Yes/No]?")) {
                            new_name = MyLib.getString("Enter event's name again: ");
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if(update_item != null){
                   update_item.setEvent_name(new_name); 
                }
                System.out.println("Updated event's name successfully!");
            }
            
            if(MyLib.confirmOption("Do you want to update date?[Yes/No]")){
                String new_dateString = MyLib.getString("Enter new date: ");
                while (true) {
                    if (!utils.Validation.validate_date(new_dateString)) {
                        if (MyLib.confirmOption("Do you want to continue[Yes/No]?")) {
                            new_dateString = MyLib.getString("Enter event's date again: ");
                        } else {
                            break;
                        }

                    } else {
                        break;
                    }
                }
                if(update_item != null){
                   update_item.setEvent_date(new_dateString);
                } 
            }
            
//            CRUD -> Create - Read - Update - Delete
            if(MyLib.confirmOption("Do you want to update location?[Yes/No]")){
                String newLocation = MyLib.getString("Enter new location: ");
                if(update_item != null){
                   update_item.setLocation(newLocation);
                } 
            }
            
            if (MyLib.confirmOption("Do you want to update number_of_attendees?[Yes/No]")) {
                try {
                    int newAttendees;
                    while (true) {
                        try {
                            newAttendees = MyLib.getIntegerNumber("Enter num of attendees: ");
                            //        Check Number of attendees must be greater than 0
                            while (true) {
                                if (!utils.Validation.validate_number_of_attendees(newAttendees)) {
                                    if (MyLib.confirmOption("Do you want to continue[Yes/No]?")) {
                                        newAttendees = MyLib.getIntegerNumber("Enter num of attendees again: ");
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
                    if (update_item != null) {
                        update_item.setNumber_of_attendees(newAttendees);
                    }
                } catch (Exception e) {
                    System.out.println("Error message: Number of attendees must be greater than 0");
                }

            }
            
            if (MyLib.confirmOption("Do you want to update status?[Yes/No]")) {
                String new_status = MyLib.getString("Enter new status: ");
                while (true) {
                    if (!utils.Validation.validate_status(new_status)) {
                        if (MyLib.confirmOption("Do you want to continue[Yes/No]?")) {
                            new_status = MyLib.getString("Enter event's status again: ");
                        } else {
                            update_item.setEvent_status(new_status);
                            break;
                        }

                    } else {
                        break;
                    }
                }
            }
            
            for (int i = 0; i< listEvent.size(); i++) {
                if(listEvent.get(i).getEvent_id().equalsIgnoreCase(id)){
                    listEvent.set(i, update_item);
                }
            }
            return true;
        }
    }
}
// private String event_id; -> unique khong cho update
//    private String event_name;
//    private String event_date;
////    yyyy/mm/dd
//    private String location;
//    private int number_of_attendees;
//    private String event_status;
