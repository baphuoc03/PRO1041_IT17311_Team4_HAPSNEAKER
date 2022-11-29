/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.KmSp_Model;

/**
 *
 * @author phamtuananh
 */
public interface IKhuyenmaiSP_repo {
    List<KmSp_Model> getSanPhamByKM(String maKM);
    int add(KmSp_Model kmsp);
    int deleteByMaKM(String MaKM);
}
