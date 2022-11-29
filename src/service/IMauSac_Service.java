/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.MauSac_Model;
import viewmodel.MauSac_View;

/**
 *
 * @author baphuoc
 */
public interface IMauSac_Service {
    List<MauSac_View> getAllMauSac();
    MauSac_Model getByMa(String ma);
    int ADD(MauSac_Model m);
    int DELETE(String ma);
    int UPDATE(MauSac_Model m);
    MauSac_Model GetMauSacByMa(String ma);
}
