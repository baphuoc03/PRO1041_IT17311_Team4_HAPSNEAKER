/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.MauSac_Model;
import model.SanPham_Model;
import model.ThuongHieu_Model;
import viewmodel.SanPham_ViewModel;

/**
 *
 * @author 84353
 */
public interface ISanPham_Service {
    List<SanPham_ViewModel> GetAllSanPham();
    SanPham_Model GetSanPhamByMa(String ma);
    int ADD(SanPham_Model s);
    int DELETE(String s);
    int UPDATE(SanPham_Model s);
    List<ThuongHieu_Model> GetAllTH();
    List<MauSac_Model> GetAllMS();
    SanPham_Model GetByMa(String ma);
}
