/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ThuocTinhSP_Model;
import viewmodel.ThuocTinhSP_ViewModel;

/**
 *
 * @author 84353
 */
public interface IThuocTinhSP_Service {
    List<ThuocTinhSP_ViewModel> GetAllThuocTinhSP();
    ThuocTinhSP_Model getById(String id);
    int updateSL(ThuocTinhSP_Model sp,int SL);
    List<ThuocTinhSP_ViewModel> FilterThuocTinhSP(String keyWord, String maSize, String MaTH, String MaMau, String MaPL);
}
