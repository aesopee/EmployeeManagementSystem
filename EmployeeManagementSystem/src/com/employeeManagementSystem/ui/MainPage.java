package com.employeeManagementSystem.ui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.employeeManagementSystem.domain.Employee;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sourabh
 */
public class MainPage extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
    private JPanel cardPanel;
    private Employee employee;
    public static final String LOGIN_PAGE = "loginPage";
    public static final String LOGIN_SUCESSFUL = "loginSucessfulPage";
    public static final String REGISTRATION = "registrationPage";
    public static final String REGISTRATION_SUCESSFUL = "registraionSucessfulPage";
    public static final String TABLE_EXAMPLE = "tableExample";

    public MainPage() {
        setSize(500, 500);
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        cardPanel.add(new LoginPage(this), LOGIN_PAGE);
        cardPanel.add(new LoginSucessfulPage(), LOGIN_SUCESSFUL);
        cardPanel.add(new RegistrationPage(this), REGISTRATION);
        cardPanel.add(new RegistrationSucessfulPage(this), REGISTRATION_SUCESSFUL);
        cardPanel.add(new TableExample(this),TABLE_EXAMPLE);
        cardLayout.show(cardPanel, TABLE_EXAMPLE);
        getContentPane().add(cardPanel);
    }

    public static void main(String args[]) {
    	
    	 java.awt.EventQueue.invokeLater(new Runnable() {

             public void run() {
            	 new MainPage().setVisible(true);
             }
         });
        
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public void setCardPanel(JPanel cardPanel) {
        this.cardPanel = cardPanel;
    }

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		if(employee == null) {
			employee = new Employee();
		}
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
    
}
