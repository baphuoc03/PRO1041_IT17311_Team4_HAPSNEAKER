/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import service.ISanPham_Service;
import model.SanPham_Model;
import repository.ISanPham_repos;
import viewmodel.SanPham_ViewModel;
import repository.SanPham_repos;
import service.impl.SanPham_service;

/**
 *
 * @author 84353
 */
public class SanPham_service implements ISanPham_Service{
    List<SanPham_Model> list;
    ISanPham_repos repo = new SanPham_repos();
     
    public List<SanPham_ViewModel> GetAllSanPham(){
        List<SanPham_ViewModel> lst_view = new ArrayList<>();
        list = repo.GetAllSanPham();
        int stt = 1;
        for(SanPham_Model s : list){
            lst_view.add(new SanPham_ViewModel(stt++, s.getMa(), s.getTen(), s.getThuongHieu().getMa(), s.getMauSac().getMa(), s.getMoTa(), s.getGiaNhap(), s.getGiaBan(), s.getTrangThai()));
        }
        return lst_view;
    }
    
}
