/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.NhanVien_Model;
import viewmodel.NhanVien_View;

/**
 *
 * @author admin
 */
public interface INhanVien_Service {
     List<NhanVien_View> getAllNhanVien();
     List<NhanVien_View> getNVbyCV(String maCV);
     NhanVien_Model getByMa(String ma);
     NhanVien_Model LoginNhanVien(String ma, String pass);
     List<NhanVien_View> FindNhanVien(String keyWord);
     int addNV(NhanVien_Model nv);
     int delNV(String manv);
     int updateNV(NhanVien_Model nv);
     int UpdatePassword(NhanVien_Model nv);
}
