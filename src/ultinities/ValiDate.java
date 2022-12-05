/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultinities;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author baphuoc
 */
public class ValiDate {
    public static boolean isInt(JTextField txt,String mess){
        try {
            int testInt = Integer.parseInt(txt.getText());
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mess,"Lỗi", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }public static boolean isFlaot(JTextField txt,String mess){
        try {
            float testInt = Float.parseFloat(txt.getText());
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mess,"Lỗi", JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }
}
