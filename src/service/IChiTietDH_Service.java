/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.ChiTietDH_View;

/**
 *
 * @author baphuoc
 */
public interface IChiTietDH_Service {
    List<ChiTietDH_View> getChiTietDHByMaDH(String maHD);
}
