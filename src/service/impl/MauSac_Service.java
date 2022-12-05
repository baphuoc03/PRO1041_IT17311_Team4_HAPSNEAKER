/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
    
    @Override
    public int ADD(MauSac_Model m){
        if(m.getMa().length() == 0){
            JOptionPane.showMessageDialog(null, "Không được để trống mã");
            return 0;
        }else if(m.getTen().length() == 0){
            JOptionPane.showConfirmDialog(null, "Không được để trống tên");
            return 0;
        }
        return MS_repos.add(m);
        
        
    }
        
    
    @Override
    public int DELETE(String ma){
        return MS_repos.delete(ma);
    }
    
    @Override
    public int UPDATE(MauSac_Model m){
        if(m.getMa().length() == 0){
            JOptionPane.showMessageDialog(null, "Không được để trống mã");
            return 0;
        }else if(m.getTen().length() == 0){
            JOptionPane.showConfirmDialog(null, "Không được để trống tên");
            return 0;
        }
        return MS_repos.update(m);
    }
    
    @Override
    public MauSac_Model GetMauSacByMa(String ma){
        for(MauSac_Model m : list){
            if(m.getMa().equals(ma)){
            return m;
            }
        }
        return null;
    }
    
    @Override
    public List<MauSac_View> Search(String key){
        list = MS_repos.Search(key);
        List<MauSac_View> list_view = new ArrayList<>();
        int stt = 1;
        for (MauSac_Model m : list) {
            list_view.add(new MauSac_View(stt,m.getMa(), m.getTen()));
            stt++;
        }
        return list_view;
    
    }
}
