/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ThuongHieu_Model;
import repository.IThuongHieu_Repos;
import repository.ThuongHieu_repos;
import service.IThuongHieu_Service;
import viewmodel.ThuongHieu_View;

/**
 *
 * @author baphuoc
 */
public class ThuongHieu_Service implements IThuongHieu_Service{
    IThuongHieu_Repos TH_repos = new ThuongHieu_repos();
    List<ThuongHieu_Model> lstTHM;
    @Override
    public List<ThuongHieu_View> getAllThuongHieu() {
        List<ThuongHieu_Model> list = TH_repos.getAllThuongHieu();
        List<ThuongHieu_View> list_view = new ArrayList<>();
        int stt = 1;
        for (ThuongHieu_Model t : list) {
            list_view.add(new ThuongHieu_View(stt, t.getMa(), t.getTen()));
            stt++;
        }
        return list_view;
    }

    @Override
    public ThuongHieu_Model GetThuongHieuByMa(String ma) {
        for(ThuongHieu_Model t : lstTHM){
            if(t.getMa().equals(ma)){
               return t; 
            }
        }
        return null;
    }
    
    @Override
    public int Add(ThuongHieu_Model th){
        if(th.getMa().length() == 0){
            JOptionPane.showMessageDialog(null, "Không được để trống mã thương hiệu!!!");
            return 0;
        }else if(th.getTen().length() == 0){
            JOptionPane.showMessageDialog(null, "Không được để trống tên thương hiệu!!!");
            return 0;
        }
        return TH_repos.Add(th);
    }
    
    @Override
    public int Update(ThuongHieu_Model th){
        if(th.getMa().length() == 0){
            JOptionPane.showMessageDialog(null, "Không được để trống mã thương hiệu!!!");
            return 0;
        }else if(th.getTen().length() == 0){
            JOptionPane.showMessageDialog(null, "Không được để trống tên thương hiệu!!!");
            return 0;
        }
        return TH_repos.update(th);
    }
    
    @Override
    public int Delete(String ma){
        return TH_repos.delete(ma);
    }
    @Override
    public ThuongHieu_Model getByMa(String ma) {
        return TH_repos.getThuongHieuByMa(ma);
    }
    
    public List<ThuongHieu_View> Search(String key){
        List<ThuongHieu_Model> list = TH_repos.Search(key);
        List<ThuongHieu_View> list_view = new ArrayList<>();
        int stt = 1;
        for (ThuongHieu_Model t : list) {
            list_view.add(new ThuongHieu_View(stt, t.getMa(), t.getTen()));
            stt++;
        }
        return list_view;
    }
    
}
