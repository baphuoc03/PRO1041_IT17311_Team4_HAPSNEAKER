/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.KichThuoc_Model;
import model.SanPham_Model;
import repository.IThuocTinhSP_Repos;
import model.ThuocTinhSP_Model;
import repository.IKichThuoc_repos;
import repository.ISanPham_repos;
import repository.KichThuoc_repos;
import repository.SanPham_repos;
import viewmodel.ThuocTinhSP_ViewModel;
import repository.ThuocTinhSP_repos;
import service.IThuocTinhSP_Service;

/**
 *
 * @author 84353
 */

public class ThuocTinhSP_service implements IThuocTinhSP_Service{
    IThuocTinhSP_Repos repo = new ThuocTinhSP_repos();
    List<ThuocTinhSP_Model> list;
    ISanPham_repos SPrepo = new SanPham_repos();
    IKichThuoc_repos KTrepo = new KichThuoc_repos();
    
    @Override
    public List<ThuocTinhSP_ViewModel> GetAllThuocTinhSP(){
        List<ThuocTinhSP_ViewModel> lst_view = new ArrayList<>();
        list = repo.GetAllThuocTinhSP();
        int stt = 1;
        for(ThuocTinhSP_Model t : list){
            lst_view.add(new ThuocTinhSP_ViewModel(stt, t.getId(), t.getSanPham().getMa(), String.valueOf(t.getKichThuoc().getMa()), t.getSl()));
        }
        return lst_view;
    }
    
    @Override
    public ThuocTinhSP_Model GetThuongHieuSPByMa(String id){
        for(ThuocTinhSP_Model t : list){
            if(t.getId().equals(id)){
            return t;
            }
        }
        return null;
    }
    
    public List<ThuocTinhSP_ViewModel> GetByMaTT(String maSP){
        List<ThuocTinhSP_ViewModel> lst_view = new ArrayList<>();
        list = repo.GetByMaTT(maSP);
        int stt = 1;
        for(ThuocTinhSP_Model t : list){
            lst_view.add(new ThuocTinhSP_ViewModel(stt, t.getId(), t.getSanPham().getMa(), String.valueOf(t.getKichThuoc().getMa()), t.getSl()));
        }
        return lst_view;
    
    }
    
    @Override
    public int ADD(ThuocTinhSP_Model t){
       
        return repo.add(t);
    }
    
    @Override
    public int DELETE(String id){
        return repo.delete(id);
    }
    
    @Override
    public int UPDATE(ThuocTinhSP_Model t){
        return repo.undate(t);
    }
    
    @Override
    public List<SanPham_Model> GetAllSP(){
        return SPrepo.GetAllSanPham();
    }
    
    @Override
    public List<KichThuoc_Model> GetAllKT(){
        return KTrepo.getAllKichThuoc();
    }
}
