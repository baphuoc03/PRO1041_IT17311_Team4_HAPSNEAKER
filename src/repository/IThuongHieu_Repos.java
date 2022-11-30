/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.ThuongHieu_Model;

/**
 *
 * @author baphuoc
 */
public interface IThuongHieu_Repos {
    List<ThuongHieu_Model> getAllThuongHieu();
    ThuongHieu_Model getThuongHieuByMa(String ma);
    int Add(ThuongHieu_Model th);
    int update(ThuongHieu_Model th);
    int delete(String ma);
    List<ThuongHieu_Model> Search(String key);
}
