package com.employeeManagementSystem.ui;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employeeManagementSystem.dao.ILoginDao;
import com.employeeManagementSystem.dao.LoginDaoImpl1;
import com.employeeManagementSystem.domain.Employee;

/** * @version 1.0 11/09/98 */
public class ButtonEditor extends DefaultCellEditor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton button;
	private String label;
	private boolean isPushed;
	ApplicationContext applicationContext;

	public ButtonEditor(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value == null) ? "" : value.toString();
		button.setText(label);
		isPushed = true;
		return button;
	}

	public Object getCellEditorValue() {
		if (isPushed) {
			JOptionPane.showMessageDialog(button, label + ": Ouch!");
			applicationContext = new ClassPathXmlApplicationContext(
			"application-context.xml");
			ILoginDao loginDao = applicationContext.getBean("loginDao", LoginDaoImpl1.class);
			int id = 1;
			Employee employee = loginDao.searchEmployeeById( id);
			EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem();
			employeeManagementSystem.registrationSucessful(employee);
		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}
}