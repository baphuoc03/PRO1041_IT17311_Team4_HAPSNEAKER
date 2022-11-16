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
     NhanVien_Model getByMa(String ma);
}
