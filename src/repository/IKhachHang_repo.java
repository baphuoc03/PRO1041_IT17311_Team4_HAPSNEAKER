/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.KhachHang_Model;

/**
 *
 * @author admin
 */
public interface IKhachHang_repo {
    List<KhachHang_Model> getAllKhachHang();
    KhachHang_Model getBySĐT(String SĐT);
}
