/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author baphuoc
 */
public class TKThuocTinhSP_View {
    private int stt;
    private String maSP;
    private String tenSP;
    private float size;
    private int slBan;
    private int slCon;

    public TKThuocTinhSP_View() {
    }

    public TKThuocTinhSP_View(int stt, String maSP, String tenSP, float size, int slBan, int slCon) {
        this.stt = stt;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.size = size;
        this.slBan = slBan;
        this.slCon = slCon;
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

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    
    public int getSlBan() {
        return slBan;
    }

    public void setSlBan(int slBan) {
        this.slBan = slBan;
    }

    public int getSlCon() {
        return slCon;
    }

    public void setSlCon(int slCon) {
        this.slCon = slCon;
    }

    @Override
    public String toString() {
        return "TKThuocTinhSP_View{" + "stt=" + stt + ", maSP=" + maSP + ", tenSP=" + tenSP + ", size=" + size + ", slBan=" + slBan + ", slCon=" + slCon + '}';
    }
    
}
