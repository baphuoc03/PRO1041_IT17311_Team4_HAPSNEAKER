/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.ChucVu_Model;

/**
 *
 * @author Ky Anh
 */
public interface IChucVu_repos {
    List<ChucVu_Model> getAllChucVu();
    ChucVu_Model getByMa(String ma);
}
