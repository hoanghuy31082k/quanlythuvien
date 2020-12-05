/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

import GUI.Login;
import GUI.MainForm;
import UTILS.DBUtils;
import java.awt.EventQueue;

/**
 *
 * @author bunhu
 */
public class Quanlythuvien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Login frame = new Login();
                                        MainForm frame= new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
    
}
