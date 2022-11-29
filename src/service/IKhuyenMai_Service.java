/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.KhuyenMai_Model;
import viewmodel.KhuyenMai_View;

/**
 *
 * @author phamtuananh
 */
public interface IKhuyenMai_Service {

    List<KhuyenMai_View> getAllKhuyenMai();

    int add(KhuyenMai_Model km);

    int delete(KhuyenMai_Model km);

    int update(KhuyenMai_Model km);
}
