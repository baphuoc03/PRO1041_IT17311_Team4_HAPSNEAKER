/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.Date;
import java.util.List;
import model.TKTongQuan_Model;
import viewmodel.TKTongQuan_View;

/**
 *
 * @author baphuoc
 */
public interface ITKTongQuan_Service {
    TKTongQuan_View tkHomNay();
    TKTongQuan_View tkTheoNgay(Date batDau, Date ketThuc);
}
