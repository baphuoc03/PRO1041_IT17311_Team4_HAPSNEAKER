/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.SanPham_Model;
import viewmodel.SanPham_ViewModel;
import repository.SanPham_repos;
import service.impl.SanPham_service;
import repository.ThuongHieu_repos;
import repository.MauSac_repos;
import model.ThuongHieu_Model;
import model.MauSac_Model;
import service.ISanPham_Service;
import repository.IMauSac_repo;
import repository.ISanPham_repo;
import repository.IThuongHieu_Repo;
/**
 *
 * @author 84353
 */
public class SanPham_service implements ISanPham_Service{
    List<SanPham_Model> list;
    ISanPham_repo repo = new SanPham_repos();
    IThuongHieu_Repo THrepo = new ThuongHieu_repos();
    IMauSac_repo MSrepo = new MauSac_repos();
     
    @Override
    public List<SanPham_ViewModel> GetAllSanPham(){
        List<SanPham_ViewModel> lst_view = new ArrayList<>();
        list = repo.GetAllSanPham();
        int stt = 1;
        for(SanPham_Model s : list){
            lst_view.add(new SanPham_ViewModel(stt++, s.getMa(), s.getTen(), s.getThuongHieu().getMa(), s.getMauSac().getMa(), s.getMoTa(), s.getGiaNhap(), s.getGiaBan(), s.getTrangThai()));
        }
        return lst_view;
    }
    
    
    
    @Override
    public int ADD(SanPham_Model s){
        return repo.add(s);
    }
    
    @Override
    public int DELETE(String s){
        return repo.delete(s);
    }
    
    @Override
    public int UPDATE(SanPham_Model s){
        return repo.update(s);
    }
    
    @Override
    public List<ThuongHieu_Model> GetAllTH(){
        return THrepo.getAllThuongHieu();
    }
    
    @Override
    public List<MauSac_Model> GetAllMS(){
        return MSrepo.getAllMauSac();
    }

    @Override
    public List<SanPham_Model> GetSanPhamByMaKM(String maKM) {
        return repo.GetSanPhamByMaKM(maKM);
    }

    @Override
    public SanPham_Model getSPByMa(String ma) {
        return repo.GetSanPhamByMa(ma);
    }

}
