/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ChiTietDH_model;
import model.KhuyenMai_Model;
import repository.ChiTietDH_repos;
import viewmodel.ChiTietDH_View;
import repository.IChiTietDH_repos;
import service.IChiTietDH_Service;
import service.IKhuyenMaiSP_Service;
import service.IKhuyenMai_Service;
import viewmodel.KhuyenMaiSP_view;

/**
 *
 * @author baphuoc
 */
public class ChiTietDH_Service implements IChiTietDH_Service{
    IChiTietDH_repos ctDH_repos = new ChiTietDH_repos();
    IKhuyenMai_Service km_sv = new KhuyenMai_Service();
    IKhuyenMaiSP_Service kmsp_sv = new KhuyenMaiSP_Service();
    DecimalFormat fm = new DecimalFormat("#");
    @Override
    public List<ChiTietDH_View> getChiTietDHByMaDH(String maHD) {
        List<ChiTietDH_model> list = ctDH_repos.getChiTietDHByMaDH(maHD);
        List<ChiTietDH_View> list_view = new ArrayList<>();
        List<KhuyenMaiSP_view> sp_KM = kmsp_sv.getSanPhamByGetDate(getDateNow());
        int stt=1;
        for (ChiTietDH_model c : list) {
            float donGia =  c.getDonGia();
            float tienSauGiam = c.getDonGiaSauGiam();
            int khuyenmai =100-  Integer.parseInt(fm.format(((tienSauGiam/ donGia) *100)));
            
            list_view.add(new ChiTietDH_View(c.getId(),stt,c.getThuocTinh().getId(),c.getThuocTinh().getSanPham().getMa(), c.getThuocTinh().getSanPham().getTen(),c.getThuocTinh().getKichThuoc().getMa(), c.getSl(), c.getThuocTinh().getSanPham().getGiaBan(),donGia, khuyenmai, tienSauGiam));
            stt++;
        }
        return list_view;
        
        
    }
    public ChiTietDH_model getChiTietDHById(String id){
        return ctDH_repos.getChiTietDHById(id);
    }
    @Override
    public int add(ChiTietDH_model dh) {
        return ctDH_repos.add(dh);
    }

    @Override
    public int updateSL(ChiTietDH_model dh) {
        return ctDH_repos.updateSL(dh);
    }

    @Override
    public List<ChiTietDH_model> getChiTietDHMolByMaDH(String maHD) {
        return ctDH_repos.getChiTietDHByMaDH(maHD);
    }

    @Override
    public int delete(ChiTietDH_model dh) {
        return ctDH_repos.delete(dh);
    }
    public Date getDateNow() {
        SimpleDateFormat DateFM = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d = DateFM.format(date);
        try {
            return DateFM.parse(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        IChiTietDH_Service sv = new ChiTietDH_Service();
        for (ChiTietDH_View c: sv.getChiTietDHByMaDH("DH25")) {
            System.out.println(c.toString());
        }
    }
}
