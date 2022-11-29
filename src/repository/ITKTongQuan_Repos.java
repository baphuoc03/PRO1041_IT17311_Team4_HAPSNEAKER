/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.Date;
import java.util.List;
import model.TKTongQuan_Model;

/**
 *
 * @author baphuoc
 */
public interface ITKTongQuan_Repos {
    TKTongQuan_Model tkHomNay();
    TKTongQuan_Model tkTheoNgay(Date batDau, Date ketThuc);
}
