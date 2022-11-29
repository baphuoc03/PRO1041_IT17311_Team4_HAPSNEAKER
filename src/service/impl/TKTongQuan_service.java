/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.Date;
import java.util.List;
import model.TKTongQuan_Model;
import repository.TKTongQuan_Repos;
import viewmodel.TKDoanhThu_View;
import viewmodel.TKTongQuan_View;
import service.ITKDoanhThu_service;
import service.ITKTongQuan_Service;
import repository.ITKTongQuan_Repo;

/**
 *
 * @author baphuoc
 */
public class TKTongQuan_service implements ITKTongQuan_Service{
    ITKTongQuan_Repo repo = new TKTongQuan_Repos();

    @Override
    public TKTongQuan_View tkHomNay() {
        TKTongQuan_View tk = new TKTongQuan_View();
        tk.setDoanhthu(repo.tkHomNay().getDoanhThu());
        tk.setDonHang(repo.tkHomNay().getDonHang());
        tk.setSanPham(repo.tkHomNay().getSanPham());
        return tk;
    }

    @Override
    public TKTongQuan_View tkTheoNgay(Date batDau, Date ketThuc) {
        TKTongQuan_View tk = new TKTongQuan_View();
        tk.setDoanhthu(repo.tkTheoNgay(batDau, ketThuc).getDoanhThu());
        tk.setDonHang(repo.tkTheoNgay(batDau, ketThuc).getDonHang());
        tk.setSanPham(repo.tkTheoNgay(batDau, ketThuc).getSanPham());
        return tk;
    }
    
}
