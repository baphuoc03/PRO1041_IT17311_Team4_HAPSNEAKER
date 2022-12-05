/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.ChucVu_Model;
import viewmodel.ChucVu_View;

/**
 *
 * @author Ky Anh
 */
public interface IChucVu_Service {
    List<ChucVu_View> getALLChucVu();
    ChucVu_Model getByMa(String ma);
}
