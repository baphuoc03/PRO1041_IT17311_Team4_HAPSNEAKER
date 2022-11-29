/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.ThuocTinhSP_Model;
import viewmodel.ThuocTinhSP_ViewModel;
import repository.ThuocTinhSP_repos;
import service.IThuocTinhSP_Service;
import repository.IThuocTinhSP_Repo;

/**
 *
 * @author 84353
 */

public class ThuocTinhSP_service implements IThuocTinhSP_Service{
    IThuocTinhSP_Repo repo = new ThuocTinhSP_repos();
    List<ThuocTinhSP_Model> list;
    
    public List<ThuocTinhSP_ViewModel> GetAllThuocTinhSP(){
        List<ThuocTinhSP_ViewModel> lst_view = new ArrayList<>();
        list = repo.GetAllThuocTinhSP();
        int stt = 1;
        for(ThuocTinhSP_Model t : list){
            lst_view.add(new ThuocTinhSP_ViewModel(stt, t.getId(), t.getSanPham().getMa(), t.getSanPham().getTen(), t.getSanPham().getThuongHieu().getTen(), t.getSanPham().getMauSac().getTen(), t.getKichThuoc().getMa()+"",t.getSl(), t.getSanPham().getGiaBan()));
            stt++;
        }
        return lst_view;
    }

    @Override
    public ThuocTinhSP_Model getById(String id) {
        return repo.getById(id);
    }

    @Override
    public int updateSL(ThuocTinhSP_Model sp, int SL) {
        return repo.undateSL(sp, SL);
    }

    @Override
    public List<ThuocTinhSP_ViewModel> FilterThuocTinhSP(String keyWord, String maSize, String MaTH, String MaMau, String MaPL) {
        List<ThuocTinhSP_ViewModel> lst_view = new ArrayList<>();
        list = repo.FilterThuocTinhSP(keyWord, maSize, MaTH, MaMau, MaPL);
        int stt = 1;
        for(ThuocTinhSP_Model t : list){
            lst_view.add(new ThuocTinhSP_ViewModel(stt, t.getId(), t.getSanPham().getMa(), t.getSanPham().getTen(), t.getSanPham().getThuongHieu().getTen(), t.getSanPham().getMauSac().getTen(), t.getKichThuoc().getMa()+"",t.getSl(), t.getSanPham().getGiaBan()));
            stt++;
        }
        return lst_view;
    }
    
    
}
