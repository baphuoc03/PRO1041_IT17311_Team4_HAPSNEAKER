/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.PlSp_Model;

/**
 *
 * @author baphuoc
 */
public interface IPLSanPham {
    List<PlSp_Model> getByMa(String ma);
    int add(PlSp_Model p);
    int delete(String maSP);
}
