/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.PlSp_Model;
import repository.IPLSanPham;
import repository.PLSanPham_Repo;
import service.IPLSanPham_Service;
import viewmodel.PLSanPham_View;

/**
 *
 * @author baphuoc
 */
public class PLSanPham_Service implements IPLSanPham_Service{
    IPLSanPham repo = new PLSanPham_Repo();
    PLSanPham_View plv;
    List<PlSp_Model> lstPL ;

    @Override
    public List<PLSanPham_View> GetByMa(String ma){
        lstPL = repo.getByMa(ma);
        List<PLSanPham_View> lst = new ArrayList<>();
        for (PlSp_Model p : lstPL) {
            lst.add(new PLSanPham_View(p.getPhanLoai().getMa(),p.getSanPham().getMa()));
        }

        return lst;

    }

    @Override
    public int add(PlSp_Model p) {
        return repo.add(p);
    }

    @Override
    public int delete(String maSP) {
        return repo.delete(maSP);
    }

    @Override
    public List<PlSp_Model> GetPLByMa(String ma){
        return repo.getByMa(ma);
    }
}
