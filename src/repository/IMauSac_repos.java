/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.MauSac_Model;

/**
 *
 * @author baphuoc
 */
public interface IMauSac_repos {
    List<MauSac_Model> getAllMauSac();
    MauSac_Model getByMa(String ma);
    int add(MauSac_Model m);
    int delete(String ma);
    int update(MauSac_Model m);
    List<MauSac_Model> Search(String key);
}
