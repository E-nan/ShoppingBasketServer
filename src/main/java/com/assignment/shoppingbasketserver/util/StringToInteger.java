package com.assignment.shoppingbasketserver.util;

public class StringToInteger {

    public static boolean isInteger(String s){

        if(s == null || s.equals("")) {
            return false;
        }

        try {
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e) {
        }
        return false;
    }
}
