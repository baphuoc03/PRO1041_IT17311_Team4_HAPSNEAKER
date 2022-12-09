/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author baphuoc
 */
public class KhuyenMaiSP_view {
    private String maSP;
    private String maKM;

    public KhuyenMaiSP_view() {
    }

    public KhuyenMaiSP_view(String maSP, String maKM) {
        this.maSP = maSP;
        this.maKM = maKM;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    @Override
    public String toString() {
        return "KhuyenMaiSP_view{" + "maSP=" + maSP + ", maKM=" + maKM + '}';
    }
    
}
