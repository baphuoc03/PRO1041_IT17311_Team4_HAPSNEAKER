/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.KichThuoc_Model;
import model.SanPham_Model;
import model.ThuocTinhSP_Model;
import viewmodel.ThuocTinhSP_ViewModel;

/**
 *
 * @author 84353
 */
public interface IThuocTinhSP_Service {
    List<ThuocTinhSP_ViewModel> GetAllThuocTinhSP();
    ThuocTinhSP_Model GetThuongHieuSPByMa(String id);
    int ADD(ThuocTinhSP_Model t);
    int DELETE(String id);
    int UPDATE(ThuocTinhSP_Model t);
    List<SanPham_Model> GetAllSP();
    List<KichThuoc_Model> GetAllKT();
    List<ThuocTinhSP_ViewModel> GetByMaTT(String maSP);
}
