/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.KichThuoc_Model;
import model.MauSac_Model;

/**
 *
 * @author baphuoc
 */
public interface IKichThuoc_repos {
    List<KichThuoc_Model> getAllKichThuoc();
    KichThuoc_Model getByMa(String ma);
    List<KichThuoc_Model> Search(String key);
}
