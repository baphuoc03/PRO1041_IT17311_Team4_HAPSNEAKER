/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.ThuocTinhSP_Model;

/**
 *
 * @author 84353
 */
public interface IThuocTinhSP_Repos {
    List<ThuocTinhSP_Model> GetAllThuocTinhSP();
    ThuocTinhSP_Model getById(String id);
}
