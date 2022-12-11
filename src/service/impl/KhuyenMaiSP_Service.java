/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;
import model.KmSp_Model;
import repository.IKhuyenMai_repos;
import repository.KhuyenmaiSP_repos;
import viewmodel.KhuyenMaiSP_view;
import repository.IKhuyenmaiSP_repos;
import repository.KhuyenMai_repos;
import service.IKhuyenMaiSP_Service;

/**
 *
 * @author baphuoc
 */
public class KhuyenMaiSP_Service implements IKhuyenMaiSP_Service{
        IKhuyenmaiSP_repos repo = new KhuyenmaiSP_repos();
        IKhuyenMai_repos KM_repo = new KhuyenMai_repos();
        List<KmSp_Model> list = new ArrayList<>();
    @Override
    public List<KhuyenMaiSP_view> getSanPhamByKM(String maKM) {
        list = repo.getSanPhamByKM(maKM);
        List<KhuyenMaiSP_view> list_view = new ArrayList<>();
        for (KmSp_Model k : list) {
            list_view.add(new KhuyenMaiSP_view(k.getSanPham().getMa(),k.getKhuyenMai().getMa()));
        }
        return list_view;
    }

    @Override
    public int add(KmSp_Model kmsp) {
        return repo.add(kmsp);
    }

    @Override
    public int deleteByMaKM(String MaKM) {
        if(KM_repo.getKhuyenMaiByMa(MaKM)==null){
            JOptionPane.showMessageDialog(null, "Khuyến Mãi Không Tồn Tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }else{
        return repo.deleteByMaKM(MaKM);
        }
    }

    @Override
    public List<KhuyenMaiSP_view> getSanPhamByGetDate(Date getDate) {
        list = repo.getSanPhamByGetDate(getDate);
        List<KhuyenMaiSP_view> list_view = new ArrayList<>();
        for (KmSp_Model k : list) {
            list_view.add(new KhuyenMaiSP_view(k.getSanPham().getMa(),k.getKhuyenMai().getMa()));
        }
        return list_view;
    }
    
}
