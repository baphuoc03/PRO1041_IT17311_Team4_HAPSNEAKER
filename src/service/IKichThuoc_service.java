/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import repository.*;
import java.util.List;
import model.KichThuoc_Model;
import model.MauSac_Model;
import viewmodel.KichThuoc_View;

/**
 *
 * @author baphuoc
 */
public interface IKichThuoc_service {
    List<KichThuoc_View> getAllKichThuoc();
    KichThuoc_Model getByMa(String ma);
    List<KichThuoc_View> Search(String key);
}
