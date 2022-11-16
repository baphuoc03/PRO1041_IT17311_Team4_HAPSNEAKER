/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.ChiTietDH_model;

/**
 *
 * @author baphuoc
 */
public interface IChiTietDH_repos {
    List<ChiTietDH_model> getChiTietDHByMaDH(String maHD);
    int add(ChiTietDH_model dh);
    int updateSL(ChiTietDH_model dh);
    int delete(ChiTietDH_model dh);
}
