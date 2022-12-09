/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baphuoc
 */
public class TestDate {

    public static void main(String[] args) {
        String fmPass = "\\w";
        String pass = "011223a23.vn";
        if (pass.matches("[a-zA-Z0-9]{1,}@[a-zA-Z0-9.]{1,}.[a-zA-Z0-9]{1,}")) {
            System.out.println("Đúng");
        } else {
            System.out.println("Sai");
        }
    }
}
