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
public interface IDonHang_Repos {
    List<DonHang_Model> getAllDonHang();
    List<DonHang_Model> FindDonHang(String keyWord);
}
