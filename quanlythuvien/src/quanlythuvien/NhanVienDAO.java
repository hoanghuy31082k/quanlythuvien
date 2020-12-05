/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLyNhanVien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {
    private final String user="root";
    private final String password="";
    private final String url="jdbc:mysql://localhost:3306/[ten database]?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    private Connection cn = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    protected NhanVienDAO(){
        if(cn == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // đăng kí driver
                cn = DriverManager.getConnection(url,user,password);
                
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null,"Lỗi kết nối database!");
            }
        }
    }
    
    protected ArrayList docDSNV(){
        ArrayList dsnv = new ArrayList<NhanVienDTO>();
        try {
            String qry = "SELECT * FROM [tên bảng NV]";
            st = cn.createStatement();
            rs = st.executeQuery(qry);
            while(rs.next()){
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNV(rs.getString(1));
                nv.setTenNV(rs.getString(2));
                nv.setNgaySinh(rs.getString(3));
                nv.setSDT(rs.getString(4));
                nv.setDiaChi(rs.getString(5));
                nv.setChucVu(rs.getString(6));
                dsnv.add(nv);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin sinh viên!");
        }
        
        return dsnv;
    }
    
    protected void them(NhanVienDTO nv){
        try {
            String qry = "INSERT INTO [bảng nv] VALUES (";
            qry = qry + "'" + nv.getMaNV()+ "'";
            qry = qry + "," + "'" + nv.getTenNV()+ "'";
            qry = qry + "," + "'" + nv.getNgaySinh()+ "'";
            qry = qry + "," + "'" + nv.getSDT()+ "'";
            qry = qry + "," + "'" + nv.getDiaChi()+ "'";
            qry = qry + "," + "'" + nv.getChucVu()+ "'";
            qry = qry + ")";
            System.out.println(qry);
            st = cn.createStatement();
            st.executeUpdate(qry);
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin nhân viên\n" + e.getMessage() );
        }
    }
    
    protected void xoa(String ma){
        try {
            String qry = "DELETE FROM [bảng nv] WHERE MaNV='" + ma + "'";
            System.out.println(qry);
            st = cn.createStatement();
            st.executeUpdate(qry);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi xóa nhân viên!");
        }
    }
    
    protected void sua(NhanVienDTO nv){
        try {
            String qry = "UPDATE [bảng nv] SET ";
            qry = qry + " TenNV=" + "'" + nv.getTenNV()+ "'";
            qry = qry + ",NgaySinh=" + "'" + nv.getNgaySinh()+ "'";
            qry = qry + ",SDT=" + "'" + nv.getSDT()+ "'";
            qry = qry + ",DiaChi=" + "'" + nv.getDiaChi()+ "'";
            qry = qry + ",ChucVu=" + "'" + nv.getChucVu()+ "'";
            qry = qry + " " + " WHERE MaNV='" + nv.getMaNV()+ "'";
            System.out.println(qry);
            st = cn.createStatement();
            st.executeUpdate(qry);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Lỗi sửa nhân viên\n" + e.getMessage());
        }
    }
}
