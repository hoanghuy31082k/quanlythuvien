/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanLyNhanVien;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class NhanVienBus {
    protected static ArrayList<NhanVienDTO> dsnv;
    
    public NhanVienBus(){
        
    }
    
    protected void docDSSV(){
        NhanVienDAO data = new NhanVienDAO();
        if(dsnv==null) dsnv = new ArrayList<NhanVienDTO>();
        dsnv = data.docDSNV();
    }
    
    protected int checkHopLe(NhanVienDTO nv){
        // Các dữ liệu bắt buộc ko dc để trống,
        if(nv.getTenNV().equals(" ") || nv.getNgaySinh().equals(" ") || nv.getSDT().equals(" ") || nv.getChucVu().equals(" ")) return 1;
        
        // Mã số nhân viên là duy nhất
        for(int i=0; i<dsnv.size(); i++){
            if(nv.getMaNV().equalsIgnoreCase(dsnv.get(i).getMaNV())) return 2;
        }
        
        // ... 
        return 0;
    }
    protected void them(NhanVienDTO nv){
        
        /*Kiểm tra dữ liệu hợp lệ*/
        int check=checkHopLe(nv);
        if(check==1){
            JOptionPane.showMessageDialog(null, "Những phần đánh dấu * là bắt buộc");
            return;
        }
        if(check==2){
            JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại");
            return;
        }
        
        //ADD
        try {
            NhanVienDAO data = new NhanVienDAO();
            data.them(nv);
            dsnv.add(nv);
        } catch (Exception e) {
            Logger.getLogger(NhanVienBus.class.getName()).log(Level.SEVERE, null, e.getMessage());
        }
        
    }
    
    protected void sua(NhanVienDTO nv){
        NhanVienDAO data = new NhanVienDAO();
        data.sua(nv);
        for(NhanVienDTO nvt: dsnv){
            if(nvt.getMaNV().equalsIgnoreCase(nv.getMaNV())){
                nvt.setTenNV(nv.getTenNV());
                nvt.setNgaySinh(nv.getNgaySinh());
                nvt.setSDT(nv.getSDT());
                nvt.setDiaChi(nv.getDiaChi());
                nvt.setChucVu(nv.getChucVu());
                return;
            }
        }
    }
    
    protected void xoa(NhanVienDTO nv){
        NhanVienDAO data = new NhanVienDAO();
        data.xoa(nv.getMaNV());
        
        for(NhanVienDTO nvt: dsnv){
            if(nv.getMaNV().equalsIgnoreCase(nvt.getMaNV())){
                dsnv.remove(nv);
            }
        }
    }
    
    protected NhanVienDTO timKiem(String ma){
        //duyệt array
        for(NhanVienDTO nv: dsnv){
            if(nv.getMaNV().equalsIgnoreCase(ma)){
                return nv;
            }
        }
        return null;
    }
}
