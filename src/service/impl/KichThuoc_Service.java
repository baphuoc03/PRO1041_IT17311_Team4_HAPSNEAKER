/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.KichThuoc_Model;
import repository.KichThuoc_repos;
import viewmodel.KichThuoc_View;
import repository.IKichThuoc_repos;
import service.IKichThuoc_service;

/**
 *
 * @author baphuoc
 */
public class KichThuoc_Service implements IKichThuoc_service{
    IKichThuoc_repos KT_repos = new KichThuoc_repos();
            List<KichThuoc_Model> list;
    @Override
    public List<KichThuoc_View> getAllKichThuoc() {
        list = KT_repos.getAllKichThuoc();
        List<KichThuoc_View> list_view = new ArrayList<>();
        int stt = 1;
        for (KichThuoc_Model k : list) {
            list_view.add(new KichThuoc_View(stt,k.getMa(), k.getUs(), k.getChieuDai()));
            stt++;
        }
        return list_view;
    }

    @Override
    public KichThuoc_Model getByMa(String ma) {
        return KT_repos.getByMa(ma);
    }
    @Override
    public List<KichThuoc_View> Search(String key){
        list = KT_repos.Search(key);
        List<KichThuoc_View> list_view = new ArrayList<>();
        int stt = 1;
        for (KichThuoc_Model k : list) {
            list_view.add(new KichThuoc_View(stt,k.getMa(), k.getUs(), k.getChieuDai()));
            stt++;
        }
        return list_view;
    }
    
}
