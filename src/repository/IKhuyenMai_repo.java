/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.KhuyenMai_Model;

/**
 *
 * @author phamtuananh
 */
public interface IKhuyenMai_repo {

    List<KhuyenMai_Model> getAllKhuyenMai();

    int add(KhuyenMai_Model km);

    int delete(KhuyenMai_Model km);

    int update(KhuyenMai_Model km);

}
