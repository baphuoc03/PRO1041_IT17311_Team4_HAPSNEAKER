package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author baphuoc
 */
public class test {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat dateTimeFM = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = dateTimeFM.format(new Date());
            FileOutputStream file = new FileOutputStream("../TK_SP/" +"TKSP_"+date + ".xlsx");
            XSSFWorkbook worbook = new XSSFWorkbook();
            XSSFSheet worksheet = worbook.createSheet("Thống Kê Sản Phẩm");
            XSSFRow row;
            XSSFCell maSP,ten,thuongHieu,mauSac,size,slBan,slVCon;
            int i = 1;
            row = worksheet.createRow((short)i);
            maSP = row.createCell((short)0); 
            maSP.setCellValue("Mã Sản Phẩm");
            ten = row.createCell((short)1); 
            ten.setCellValue("Tên Sản Phẩm");
            thuongHieu = row.createCell((short)2); 
            thuongHieu.setCellValue("Thương Hiệu");
            mauSac = row.createCell((short)3); 
            mauSac.setCellValue("Màu Sắc");
            size = row.createCell((short)4); 
            size.setCellValue("Size");
            slBan = row.createCell((short)5); 
            slBan.setCellValue("Số Lượng Bán");
            slVCon = row.createCell((short)6); 
            slVCon.setCellValue("Số Lượng Còn");
            worbook.write(file);
            worbook.close();
            file.close();
    }
}
