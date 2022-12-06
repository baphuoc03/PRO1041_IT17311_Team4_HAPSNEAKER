/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.PlSp_Model;
import viewmodel.PLSanPham_View;

/**
 *
 * @author baphuoc
 */
public interface IPLSanPham_Service {
    List<PLSanPham_View> GetByMa(String ma);
    int add(PlSp_Model p);
    int delete(String maSP);
    List<PlSp_Model> GetPLByMa(String ma);
}
