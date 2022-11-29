/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.KmSp_MoDel;
import viewmodel.KhuyenMaiSP_view;

/**
 *
 * @author baphuoc
 */
public interface IKhuyenMaiSP_Service {
    List<KhuyenMaiSP_view> getSanPhamByKM(String maKM);
    int add(KmSp_MoDel kmsp);
    int deleteByMaKM(String MaKM);
}
