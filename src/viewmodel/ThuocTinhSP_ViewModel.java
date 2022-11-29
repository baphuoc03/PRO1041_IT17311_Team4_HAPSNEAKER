/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author 84353
 */
public class ThuocTinhSP_ViewModel {
    private int stt;
    private String id;
    private String maSP;
    private String maKT;
    private int sL;

    public ThuocTinhSP_ViewModel() {
    }

    public ThuocTinhSP_ViewModel(int stt, String id, String maSP, String maKT, int sL) {
        this.stt = stt;
        this.id = id;
        this.maSP = maSP;
        this.maKT = maKT;
        this.sL = sL;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getMaKT() {
        return maKT;
    }

    public void setMaKT(String maKT) {
        this.maKT = maKT;
    }

    public int getsL() {
        return sL;
    }

    public void setsL(int sL) {
        this.sL = sL;
    }

    
    
    
}
