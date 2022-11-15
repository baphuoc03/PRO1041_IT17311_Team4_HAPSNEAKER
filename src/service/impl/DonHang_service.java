/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.DonHang_Model;
import repository.DonHang_Repos;
import repository.IDonHang_Repos;
import viewmodel.DonHang_view;
import service.IDonHang_service;

/**
 *
 * @author baphuoc
 */
public class DonHang_service implements IDonHang_service {

    IDonHang_Repos DH_repos = new DonHang_Repos();
    List<DonHang_Model> list;

    @Override
    public List<DonHang_view> getAllDonHang() {
        List<DonHang_view> list_view = new ArrayList<>();
        list = DH_repos.getAllDonHang();
        int stt = 1;
        String tt = "";
        for (DonHang_Model d : list) {
            if (d.getTrangThai() == 0) {
                tt = "Chưa thanh toán";
            } else {
                tt = "Đã Thanh Toán";
            }
            list_view.add(new DonHang_view(stt, d.getMa(), d.getNhanVien().getHoTen(), d.getKhachHang().getHoTen(), d.getNgayTao(), tt));
            stt++;
        }
        return list_view;
    }

}
