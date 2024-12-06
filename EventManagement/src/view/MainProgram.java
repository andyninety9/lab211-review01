/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import constanst.Constanst;
import controller.ManageEventsController;
import java.util.List;
import model.Event;
import utils.FileManagement;
import utils.MyLib;

/**
 *
 * @author andymai
 */
public class MainProgram {

    public static void main(String[] args) {
        FileManagement manageFile = new FileManagement(Constanst.FILE_PATH);
        ManageEventsController manageEventsController = new ManageEventsController();
        manageEventsController.setListEvent(manageFile.readFile());

        int choice = 0;
        do {
            Menu.displayMainMenu();
            while (true) {
                try {
                    choice = MyLib.getIntegerNumber("Enter your choice[1-6]: ");
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            switch (choice) {
                case 1: {
                    do {
                        boolean isAdded = manageEventsController.add_new_event();
                        if (isAdded) {
                            System.out.println("Added successfully!");
                        } else {
                            System.out.println("Try again!");
                        }
                    } while (MyLib.confirmOption("Do you want to continue?[Yes-No]: "));

                    break;
                }
                case 2: {
                    do {
                        manageEventsController.display_event_list();
                        String input_event_id = MyLib.getString("Enter event id for searching: ");
                        boolean isFound = manageEventsController.search_event(input_event_id);
                        if (isFound) {
                            System.out.println("Exist Event");
                        } else {
                            System.out.println("No Event Found!");
                        }
                    } while (MyLib.confirmOption("Do you want to search more? [YES/NO]: "));
                    break;
                }
                case 3: {
                    do {
                        String location_key = MyLib.getString("Enter location's key for searching: ");
                        List<Event> list_result = manageEventsController.search_event_by_location(location_key);
                        if (list_result.isEmpty()) {
                            System.out.println("Nothing match with your key, try again...");
                        } else {
                            for (Event event : list_result) {
                                System.out.println(event);
                            }
                        }
                    } while (MyLib.confirmOption("Do you want to continue[YES/NO]: "));
                    break;
                }
                case 4: {
                    Menu.displaySubMenuUpdate();
                    int subChoice = 0;
                    try {
                        subChoice = utils.MyLib.getIntegerNumber("Enter your choice[1-2]: ");
                    } catch (Exception ex) {
                         System.out.println(ex.getMessage());
                    }
                    switch (subChoice) {
                        case 1:
                            String update_id = MyLib.getString("Enter ID to update: ");
                            boolean isSuccess = manageEventsController.update_event_by_id(update_id);
                            if (isSuccess) {
                                System.out.println("Updated " + update_id + " successfully!");
                                manageFile.writeFile(manageEventsController.getListEvent());
                            } else {
                                System.out.println("Updated false!!!");
                            }
                            break;
                        case 2: 
                            
                        default:
                            throw new AssertionError();
                    }

                    break;
                }
                case 5: {
                    manageFile.writeFile(manageEventsController.getListEvent());
                    break;
                }
                case 6: {
                    manageEventsController.display_event_list();
                    break;
                }
                default: {
                    System.out.println("Thank you!!!");
                    return;
                }
            }

        } while (choice >= 1 && choice <= 6);
    }
}
