/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.PhanLoai_Model;
import viewmodel.PhanLoai_View;

/**
 *
 * @author baphuoc
 */
public interface IPhanLoai_Service {
    List<PhanLoai_View> getAllPhanLoai();
    PhanLoai_Model getByMa(String ma);
    int ADD(PhanLoai_Model p);
    int UPDATE(PhanLoai_Model p);
    int DELETE(String ma);
    PhanLoai_Model GetPhanLoaiByMa(String ma);
    List<PhanLoai_View> Search(String key);
}
