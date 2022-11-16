/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.DonHang_Model;
import viewmodel.DonHang_view;

/**
 *
 * @author baphuoc
 */
public interface IDonHang_service {
    List<DonHang_view> getAllDonHang();
    DonHang_Model getDHByMa(String ma);
    List<DonHang_view> FindDonHang(String keyWord);
    int add(DonHang_Model dh);
    int update(DonHang_Model dh);
}
