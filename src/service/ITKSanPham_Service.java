/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Date;
import java.util.List;
import viewmodel.TKSanPham_View;

/**
 *
 * @author baphuoc
 */
public interface ITKSanPham_Service {
    List<TKSanPham_View> getTKSanPham();
    List<TKSanPham_View> getTKSanPham(String batDau,String ketThuc);
}
