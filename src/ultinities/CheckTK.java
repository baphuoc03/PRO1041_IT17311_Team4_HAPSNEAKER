/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultinities;

import model.NhanVien_Model;
import viewmodel.NhanVien_View;

/**
 *
 * @author phamtuananh
 */
public class CheckTK {
    public static NhanVien_Model user = null ;
    public static void clear(){
        CheckTK.user = null;
        
    }
    public static boolean islogin(){
        return CheckTK.user != null;
    }
}
