/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author andymai
 */
public class MyLib {
    public static Scanner sc = new Scanner(System.in);
    
    public static int getIntegerNumber(String message) throws Exception{
        int result = 0;
        String regex = "^\\d+$";
//        Sử dụng regex để validate xem input nhập vào có phải là số không
        System.out.print(message);
        String input = sc.nextLine();
        
        if(!input.matches(regex)){
            throw new Exception("Please enter a number follow instructor...");
        }else{
            result = Integer.parseInt(input);
        }
        
        return result;
    }
    public static double getDoubleNumber(String message) throws Exception{
        double result = 0;
        String regex = "^[0-9]+\\.?[0-9]*$";
//        Sử dụng regex để validate xem input nhập vào có phải là số không
        System.out.print(message);
        String input = sc.nextLine();
        
        if(!input.matches(regex)){
            throw new Exception("Please enter a number follow instructor...");
        }else{
            result = Double.parseDouble(input);
        }
        
        return result;
    }
    
    public static String getString(String mess){
        System.out.println(mess);
        return sc.nextLine();
    }
    
    public static String generateID(String prefix){
        String result = prefix;
//        Sử dụng dữ liệu giờ trong máy tính để tạo 1 chuỗi ngẫu nhiên(Lấy đến milisecond)
        String tmp = Integer.toString(Math.abs((int) System.currentTimeMillis() % (int) (1000000 * Math.random())));
        result += tmp;
//        SE182823
        return result;
    }
    
}
