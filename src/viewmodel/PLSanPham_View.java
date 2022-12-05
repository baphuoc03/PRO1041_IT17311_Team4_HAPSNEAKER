/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import model.PhanLoai_Model;
import model.SanPham_Model;

/**
 *
 * @author 84353
 */
public class PLSanPham_View {
    private String maPL;
    private String maSP;

    public PLSanPham_View() {
    }

    public PLSanPham_View(String maPL, String maSP) {
        this.maPL = maPL;
        this.maSP = maSP;
    }

    public String getMaPL() {
        return maPL;
    }

    public void setMaPL(String maPL) {
        this.maPL = maPL;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    
    
    
    
}
