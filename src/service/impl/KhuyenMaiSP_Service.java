/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.KmSp_Model;
import repository.KhuyenmaiSP_repos;
import viewmodel.KhuyenMaiSP_view;
import service.IKhuyenMaiSP_Service;
import repository.IKhuyenmaiSP_repo;

/**
 *
 * @author baphuoc
 */
public class KhuyenMaiSP_Service implements IKhuyenMaiSP_Service{
        IKhuyenmaiSP_repo repo = new KhuyenmaiSP_repos();
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
    public static void main(String[] args) {
        IKhuyenMaiSP_Service km = new KhuyenMaiSP_Service();
        for (KhuyenMaiSP_view khuyenMaiSP_view : km.getSanPhamByKM("KM01")) {
            System.out.println(khuyenMaiSP_view.toString());
        }
    }

    @Override
    public int add(KmSp_Model kmsp) {
        return repo.add(kmsp);
    }

    @Override
    public int deleteByMaKM(String MaKM) {
        return repo.deleteByMaKM(MaKM);
    }
}
