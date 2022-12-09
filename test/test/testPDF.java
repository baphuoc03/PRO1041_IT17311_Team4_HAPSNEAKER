package test;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author baphuoc
 */
public class testPDF {

    public static void main(String[] args) throws BadElementException, BadElementException, IOException, IOException {
        Document document = new Document();
        SimpleDateFormat dateFM = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("../HoaDon/hoadon.pdf"));
            document.open();
            //title
            Paragraph title1 = new Paragraph("HOA DON THANH TOAN", new Font(Font.FontFamily.HELVETICA, 25, Font.BOLD));
            title1.setAlignment(Element.ALIGN_CENTER);
            Paragraph title2 = new Paragraph("\nHAP SNEAKER", new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD));
            title2.setAlignment(Element.ALIGN_CENTER);
            Paragraph title3 = new Paragraph(" Trinh Van Bo, Phuong Canh,\n Nam Tu Liem, Ha Noi\n------------------------------------------",
                    new Font(Font.FontFamily.HELVETICA, 13));
            title3.setAlignment(Element.ALIGN_CENTER);
            //image
            Image image1 = Image.getInstance("src/icon/logo_blue.png");
            image1.setAlignment(Element.ALIGN_CENTER);
            image1.scaleAbsolute(100, 60);
            //Thông tin hóa đơn
            Paragraph thongtinHD = new Paragraph("\n\nNhan Vien: NV01 - Nguyen Ba Phuoc\nKhach Hang: Khach Le\nNgày: " + dateFM.format(new Date())
                    + "\n\n------------------------------------------------------------------------------------------------------------------------",
                    new Font(Font.FontFamily.HELVETICA, 13));
            title3.setAlignment(Element.ALIGN_CENTER);
            //hóa đơn chi tiết - tạo table and cell
            PdfPTable table = new PdfPTable(9); // 3 columns.
            table.setWidthPercentage(100);
            PdfPCell stt = new PdfPCell(new Paragraph("STT"));
            PdfPCell maSP = new PdfPCell(new Paragraph("maSP"));
            PdfPCell tenSP = new PdfPCell(new Paragraph("Ten SP"));
            PdfPCell Size = new PdfPCell(new Paragraph("Size"));
            PdfPCell sl = new PdfPCell(new Paragraph("SL"));
            PdfPCell donGia = new PdfPCell(new Paragraph("donGia"));
            PdfPCell thanhTien = new PdfPCell(new Paragraph("thanhTien"));
            PdfPCell giamGia = new PdfPCell(new Paragraph("Giam Gia"));
            PdfPCell tienSauGiam = new PdfPCell(new Paragraph("tienSauGiam"));
            stt.setBorder( 0);
            maSP.setBorder( 0);
            tenSP.setBorder( 0);
            Size.setBorder( 0);
            sl.setBorder( 0);
            donGia.setBorder( 0);
            thanhTien.setBorder( 0);
            giamGia.setBorder( 0);
            tienSauGiam.setBorder( 0);
            float[] columnWidths = {0.5f, 1f, 1.5f,0.5f,0.5f,1f,1.5f,1f,1.5f};
            table.setWidths(columnWidths);
            table.addCell(stt);
            table.addCell(maSP);
            table.addCell(tenSP);
            table.addCell(Size);
            table.addCell(sl);
            table.addCell(donGia);
            table.addCell(thanhTien);
            table.addCell(giamGia);
            table.addCell(tienSauGiam);
            //thông tin thanh toán
            Paragraph thongtinTT = new Paragraph("\n\n------------------------------------------------------------------------------------------------------------------------"
                    + "\nTien Phai Tra: \nKhach Dua: \nTien Thua: ",
                    new Font(Font.FontFamily.HELVETICA, 13));
            Paragraph boder = new Paragraph("\n------------------------------------------\n"
                                             + "HAP SNEAKER CAM ON VA HEN GAP LAI KHACH HANG");
            boder.setAlignment(Element.ALIGN_CENTER);
            document.add(title1);
            document.add(title2);
            document.add(image1);
            document.add(title3);
            document.add(thongtinHD);
            document.add(table);
            document.add(thongtinTT);
            document.add(boder);
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
