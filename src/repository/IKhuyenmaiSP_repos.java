/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.KmSp_MoDel;

/**
 *
 * @author phamtuananh
 */
public interface IKhuyenmaiSP_repos {
    List<KmSp_MoDel> getSanPhamByKM(String maKM);
    int add(KmSp_MoDel kmsp);
    int deleteByMaKM(String MaKM);
}
