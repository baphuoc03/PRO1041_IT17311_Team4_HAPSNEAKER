/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import repository.*;
import java.util.List;
import model.TKDoanhThu_Model;
import viewmodel.TKDoanhThu_View;

/**
 *
 * @author baphuoc
 */
public interface ITKDoanhThu_service {
    List<TKDoanhThu_View> getTKDoanhThu(Integer nam);
}
