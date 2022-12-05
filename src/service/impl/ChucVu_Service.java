/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.ChucVu_Model;
import repository.IChucVu_repos;
import repository.ChucVu_repos;
import service.IChucVu_Service;
import viewmodel.ChucVu_View;

/**
 *
 * @author Ky Anh
 */
public class ChucVu_Service implements IChucVu_Service{
    IChucVu_repos CV_repos = new ChucVu_repos();
    List<ChucVu_Model> list;
    
    @Override
    public List<ChucVu_View> getALLChucVu() {
        list = CV_repos.getAllChucVu();
        List<ChucVu_View> list_view = new ArrayList<>();
        for(ChucVu_Model cv : list){
            list_view.add(new ChucVu_View(cv.getMa(),cv.getTen()));
        }
        return list_view;
    }

    @Override
    public ChucVu_Model getByMa(String ma) {
        return CV_repos.getByMa(ma);
    }
    public static void main(String[] args) {
        IChucVu_Service sv = new ChucVu_Service();
        System.out.println(sv.getByMa("CV01").toString());
    }
}
