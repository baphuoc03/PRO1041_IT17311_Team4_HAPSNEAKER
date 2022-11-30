/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.KhachHang_Model;
import viewmodel.KhachHang_View;

/**
 *
 * @author admin
 */
public interface IKhachHang_Service {
    List<KhachHang_View> getAllKhachHang();
    List<KhachHang_View> FindKhachHang(String keyWord);
    KhachHang_Model getBySĐT(String SĐT);
    int addKH(KhachHang_Model kh);
    int delKH(String sdt);
    int updateKH(KhachHang_Model kh);
}
