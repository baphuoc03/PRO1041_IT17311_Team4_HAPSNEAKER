/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.MauSac_Model;
import repository.IMauSac_repos;
import repository.MauSac_repos;
import viewmodel.MauSac_View;
import service.IMauSac_Service;

/**
 *
 * @author baphuoc
 */
public class MauSac_Service implements IMauSac_Service{
    IMauSac_repos MS_repos = new MauSac_repos();
    List<MauSac_Model> list; 
    @Override   
    public List<MauSac_View> getAllMauSac() {
        list = MS_repos.getAllMauSac();
        List<MauSac_View> list_view = new ArrayList<>();
        int stt = 1;
        for (MauSac_Model m : list) {
            list_view.add(new MauSac_View(stt,m.getMa(), m.getTen()));
            stt++;
        }
        return list_view;
    }

    @Override
    public MauSac_Model getByMa(String ma) {
        return MS_repos.getByMa(ma);
    }
    
}
