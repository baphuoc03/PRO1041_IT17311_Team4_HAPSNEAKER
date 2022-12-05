/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.Date;
import java.util.List;
import model.TKSanPham_Model;

/**
 *
 * @author baphuoc
 */
public interface ITKSanPham_repos {
    List<TKSanPham_Model> getTKSanPham();
    List<TKSanPham_Model> getTKSanPhamTheoNgay(String batDau, String ketThuc);
}
