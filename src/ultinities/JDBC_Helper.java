/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ultinities;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author baphuoc
 */
public class JDBC_Helper {
    private static String user = "root";
    private static String pass = "mothaiba4";
    private static String url = "jdbc:mysql://localhost:3306/Sneaker_hap?zeroDateTimeBehavior=CONVERT_TO_NULL";
    static{
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBC_Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
     public static ResultSet Query(String sql,Object...args){
        Connection con = null;
        PreparedStatement psvm = null;
        ResultSet rs = null ;
        try {
            con = getConnection();
            psvm = con.prepareStatement(sql);
            for(int i =0; i<args.length;i++){
                psvm.setObject(i+1, args[i]);
            }
            return rs = psvm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC_Helper.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            close(psvm, con,rs);
            return null;
        }
    }
    public static int Update(String sql,Object...args){
        Connection con = null;
        PreparedStatement psvm = null;
        try {
             con = getConnection();
            psvm = con.prepareStatement(sql);
            for(int i =0; i<args.length;i++){
                psvm.setObject(i+1, args[i]);
            }
            return psvm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC_Helper.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            close(psvm, con);
            return 0;
        }
    }
    public static int Call(String sql,Object...args){
        Connection con = null;
        PreparedStatement psvm = null;
        try {
            con = getConnection();
            psvm = con.prepareCall(sql);
            for(int i =0; i<args.length;i++){
                psvm.setObject(i+1, args[i]);
            }
            return psvm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC_Helper.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            close(psvm, con);
            return 0;
        }
    }
    public static void close(PreparedStatement psvm,Connection con){
        try {
            con.close();
            psvm.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC_Helper.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    public static void close(PreparedStatement psvm,Connection con,ResultSet rs){
        try {
            rs.close();
            con.close();
            psvm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(JDBC_Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        Connection con = getConnection();
        if(con != null){
            System.out.println("Ket Noi Thanh Cong");
        }else{
            System.out.println("fail");
        }
    }
}
