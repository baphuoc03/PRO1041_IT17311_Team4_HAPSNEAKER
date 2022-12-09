/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author baphuoc
 */
public class ThuocTinhSP_Model {
    private String id;
    private SanPham_Model sanPham;
    private KichThuoc_Model kichThuoc;
    private int sl;

    public ThuocTinhSP_Model() {
    }

    public ThuocTinhSP_Model(String id, SanPham_Model sanPham, KichThuoc_Model kichThuoc, int sl) {
        this.id = id;
        this.sanPham = sanPham;
        this.kichThuoc = kichThuoc;
        this.sl = sl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham_Model getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham_Model sanPham) {
        this.sanPham = sanPham;
    }

    public KichThuoc_Model getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(KichThuoc_Model kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    @Override
    public String toString() {
        return "ThuocTinhSP_Model{" + "id=" + id + ", sanPham=" + sanPham + ", kichThuoc=" + kichThuoc + ", sl=" + sl + '}';
    }
    
}
