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
        try {
            SimpleDateFormat dateFM = new SimpleDateFormat("yyyy-MM-dd");
            Date batdau = dateFM.parse("2022-12-7");
            Date ketThuc = dateFM.parse("2022-12-7");
            if(batdau.after(ketThuc)){
                System.out.println("Ngày Bắt Đầu Phải < Kết Thúc");
            } else {
                System.out.println("True");
            }
        } catch (ParseException ex) {
            Logger.getLogger(TestDate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
