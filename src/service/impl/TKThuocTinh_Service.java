/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.TKThuocTinhSP_Model;
import repository.TKThuocTinhSP_repos;
import viewmodel.TKThuocTinhSP_View;
import service.ITKThuocTinh_Service;
import repository.ITKThuocTinhSP_repo;

/**
 *
 * @author baphuoc
 */
public class TKThuocTinh_Service implements ITKThuocTinh_Service{
    ITKThuocTinhSP_repo repo = new TKThuocTinhSP_repos();
    List<TKThuocTinhSP_Model> list;
    public List<TKThuocTinhSP_View> tkByMa(String ma) {
        list = repo.tkByMa(ma);
        List<TKThuocTinhSP_View> list_view = new ArrayList<>();
        int stt=1;
        for (TKThuocTinhSP_Model t : this.list) {
            list_view.add(new TKThuocTinhSP_View(stt, t.getMaSP(), t.getTenSP(),t.getSize(),t.getSlBan(), t.getSlCon()));
            stt++;
        }
        return list_view;
    }
    
}