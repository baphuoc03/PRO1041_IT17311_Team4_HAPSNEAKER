/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.PhanLoai_Model;

/**
 *
 * @author baphuoc
 */
public interface IPhanLoai_repos {
    List<PhanLoai_Model> getAllThuongHieu();
    PhanLoai_Model getByMa(String ma);
}
