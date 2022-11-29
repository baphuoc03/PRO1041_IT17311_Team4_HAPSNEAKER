/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.NhanVien_Model;

/**
 *
 * @author admin
 */
public interface INhanVien_Repo {
    List<NhanVien_Model> getAllNhanVien();
    NhanVien_Model getByMa(String ma);
}
