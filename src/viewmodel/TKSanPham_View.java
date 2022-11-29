/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author baphuoc
 */
public class TKSanPham_View {
    private int stt;
    private String maSP;
    private String ten;
    private String mau;
    private String thuongHieu;
    private int slBan;

    public TKSanPham_View() {
    }

    public TKSanPham_View(int stt, String maSP, String ten, String mau, String thuongHieu, int slBan) {
        this.stt = stt;
        this.maSP = maSP;
        this.ten = ten;
        this.mau = mau;
        this.thuongHieu = thuongHieu;
        this.slBan = slBan;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public int getSlBan() {
        return slBan;
    }

    public void setSlBan(int slBan) {
        this.slBan = slBan;
    }

    @Override
    public String toString() {
        return "TKSanPham_View{" + "stt=" + stt + ", maSP=" + maSP + ", ten=" + ten + ", mau=" + mau + ", thuongHieu=" + thuongHieu + ", slBan=" + slBan + '}';
    }
    
}
