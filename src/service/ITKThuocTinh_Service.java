/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.TKThuocTinhSP_Model;
import viewmodel.TKThuocTinhSP_View;

/**
 *
 * @author baphuoc
 */
public interface ITKThuocTinh_Service {
    List<TKThuocTinhSP_View> tkByMa(String ma);
    List<TKThuocTinhSP_View> tkByMaTheoNgay(String ma,String batDau,String ketThuc);
}
