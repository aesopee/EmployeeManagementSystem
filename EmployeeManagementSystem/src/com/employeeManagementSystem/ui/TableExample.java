/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TableExample.java
 *
 * Created on 5 Aug, 2011, 11:36:00 PM
 */
package com.employeeManagementSystem.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import com.employeeManagementSystem.dao.LoginDaoImpl;
import com.employeeManagementSystem.domain.Employee;

/**
 *
 * @author sourabh
 */
public class TableExample extends javax.swing.JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MainPage mainPage;
    /** Creates new form TableExample */
    public TableExample(MainPage mainPage) {
        this.mainPage= mainPage;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
    	List<Employee> employeeList = new ArrayList<Employee>();
    	LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
    	employeeList = loginDaoImpl.searchAllEmployee();
    	Object object[][] = new Object [employeeList.size()][];
    	
    	
    	for(int i=0; i<employeeList.size(); i++) {
    		Object object2[] = new Object[]{employeeList.get(i).getFirstName(), employeeList.get(i).getMiddleName(), employeeList.get(i).getLastName(), employeeList.get(i).getUserName(), employeeList.get(i).getPassword(), "button"+i};
    		object[i] = object2;
    	}
    	
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();


        jButton1 = new javax.swing.JButton();

       // setPreferredSize(new java.awt.Dimension(500, 500));
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
           object,
            new String [] {
                "First Name", "Middle Name", "Last Name", "UserName", "Password", "Button"
            }
        ));
        int vColIndex = 0;
        TableColumn col =jTable1.getColumnModel().getColumn(vColIndex);
        int width = 100;
        col.setPreferredWidth(width);

        jTable1.getColumn("Button").setCellRenderer(new ButtonRenderer());
		jTable1.getColumn("Button").setCellEditor(
				new ButtonEditor(new JCheckBox()));
		
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Go To login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	List<Boolean> value = new ArrayList<Boolean>();
            	int size = jTable1.getRowCount();
            	for(int i=0;i<size;i++){
            	 value.add(i,(Boolean) jTable1.getModel().getValueAt(i,1));
            	 System.out.println( jTable1.getModel().getValueAt(i,1));
            	}
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(319, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	mainPage.getCardLayout().show(mainPage.getCardPanel(), MainPage.LOGIN_PAGE);
    }                                        

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
