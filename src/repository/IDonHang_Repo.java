/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.DonHang_Model;

/**
 *
 * @author baphuoc
 */
public interface IDonHang_Repo {
    List<DonHang_Model> getAllDonHang();
    DonHang_Model getDHByMa(String ma);
    List<DonHang_Model> FindDonHang(String keyWord);
    int add(DonHang_Model dh);
    int update(DonHang_Model dh);
    int updateKH(DonHang_Model dh);
}
