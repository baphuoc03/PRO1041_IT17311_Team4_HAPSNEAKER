/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.SanPham_Model;

/**
 *
 * @author 84353
 */
public interface ISanPham_repos {
    List<SanPham_Model> GetAllSanPham();
    SanPham_Model GetSanPhamByMa(String ma);
    int add(SanPham_Model s);
    int delete(String s);
    int update(SanPham_Model s);
}
