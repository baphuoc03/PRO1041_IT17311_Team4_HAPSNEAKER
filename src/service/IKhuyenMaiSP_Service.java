/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.Date;
import java.util.List;
import model.KmSp_Model;
import viewmodel.KhuyenMaiSP_view;

/**
 *
 * @author baphuoc
 */
public interface IKhuyenMaiSP_Service {
    List<KhuyenMaiSP_view> getSanPhamByKM(String maKM);
    int add(KmSp_Model kmsp);
    int deleteByMaKM(String MaKM);
    List<KhuyenMaiSP_view> getSanPhamByGetDate(Date getDate);
}
