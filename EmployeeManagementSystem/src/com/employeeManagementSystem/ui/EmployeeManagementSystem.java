package com.employeeManagementSystem.ui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employeeManagementSystem.dao.ILoginDao;
import com.employeeManagementSystem.dao.LoginDaoImpl1;
import com.employeeManagementSystem.domain.Employee;

public class EmployeeManagementSystem extends JFrame {

	ApplicationContext applicationContext;
	private static final long serialVersionUID = 1L;
	/*********************************************
	 * Properties
	 *********************************************/
	/*********************************************
	 * Buttons
	 *********************************************/
	private JButton jButtonForgotPassword;
	private JButton jButtonLogin;
	private JButton jButtonRegister;
	private JButton jButtonBack;
	private JButton jButtonGoToLogin;
	private JButton jButtonLogOut;
	/*********************************************
	 * TextFields
	 *********************************************/
	private JPasswordField jPasswordFieldPassword;
	private JTextField jTextFieldUserName;
	private JTextField jTextFieldFirstName;
	private JTextField jTextFieldLastName;
	private JTextField jTextFieldMiddleName;
	private JTextField jTextFieldSecurityAnswer;
	private JTextField jTextFieldSecurityQuestion;
	/*********************************************
	 * Labels
	 *********************************************/
	private JLabel jLabelPassword;
	private JLabel jLabelUserName;
	private JLabel jLabelFirstName;
	private JLabel jLabelLastName;
	private JLabel jLabelMiddleName;
	private JLabel jLabelSecurityAnswer;
	private JLabel jLabelSecurityQuestion;
	private JLabel jLabelFirstNameToDisplay;
	private JLabel jLabelLastNameToDisplay;
	private JLabel jLabelMiddleNameToDisplay;
	private JLabel jLabelPasswordToDisplay;
	private JLabel jLabelSecurityAnswerToDisplay;
	private JLabel jLabelSecurityQuestionToDisplay;
	private JLabel jLabelUserNameToDisplay;
	private JLabel jLabelMessage;
	/*********************************************
	 * Pane and Tables
	 *********************************************/
	private  JScrollPane jScrollPane1;
	private  JTable jTableEmployees;

	/**
	 * Constructor
	 */
	public EmployeeManagementSystem() {
		login(null);
	}

	/**
	 * Utility Methods
	 */
	private void loadBlankPage() {
		/*********************************************
		 * Buttons
		 *********************************************/
		if(jButtonLogOut!=null) {
			remove(jButtonLogOut);
		}
		if(jButtonForgotPassword!=null) {
			remove(jButtonForgotPassword);
		}
		if(jButtonLogin!=null){
			remove(jButtonLogin);
		}
		if(jButtonRegister!=null){
			remove(jButtonRegister);
		}
		if(jButtonBack!=null){
			remove(jButtonBack);
		}
		if(jButtonGoToLogin!=null) {
			remove(jButtonGoToLogin);
		}

		/*********************************************
		 * TextFields
		 *********************************************/
		if(jPasswordFieldPassword!=null){
			remove(jPasswordFieldPassword);
		}
		if(jTextFieldUserName!=null){
			remove(jTextFieldUserName);
		}
		if(jTextFieldFirstName!=null){
			remove(jTextFieldFirstName);
		}
		if(jTextFieldLastName!=null){
			remove(jTextFieldLastName);
		}
		if(jTextFieldMiddleName != null){
			remove(jTextFieldMiddleName);
		}
		if(jTextFieldSecurityAnswer!=null){
			remove(jTextFieldSecurityAnswer);
		}
		if(jTextFieldSecurityQuestion!=null){
			remove(jTextFieldSecurityQuestion);
		}

		/*********************************************
		 * Labels
		 *********************************************/
		if(jLabelMessage!=null){
			remove(jLabelMessage);
		}
		if(jLabelPassword!=null){
			remove(jLabelPassword);
		}
		if(jLabelUserName!=null){
			remove(jLabelUserName);
		}
		if(jLabelFirstName!=null){
			remove(jLabelFirstName);
		}
		if(jLabelLastName!=null){
			remove(jLabelLastName);
		}
		if(jLabelMiddleName!=null){
			remove(jLabelMiddleName);
		}
		if(jLabelSecurityAnswer!=null){
			remove(jLabelSecurityAnswer);
		}
		if(jLabelSecurityQuestion!=null){
			remove(jLabelSecurityQuestion);
		}
		if(jLabelFirstNameToDisplay!=null) {
			remove(jLabelFirstNameToDisplay);
		}
		if(jLabelLastNameToDisplay!=null) {
			remove(jLabelLastNameToDisplay);
		}
		if(jLabelMiddleNameToDisplay!=null) {
			remove(jLabelMiddleNameToDisplay);
		}
		if(jLabelPasswordToDisplay!=null) {
			remove(jLabelPasswordToDisplay);
		}
		if(jLabelSecurityAnswerToDisplay!=null) {
			remove(jLabelSecurityAnswerToDisplay);
		}
		if(jLabelSecurityQuestionToDisplay!=null) {
			remove(jLabelSecurityQuestionToDisplay);
		}
		if(jLabelUserNameToDisplay!=null) {
			remove(jLabelUserNameToDisplay);
		}
		/*********************************************
		 * Pane and Tables
		 *********************************************/
		if(jScrollPane1!=null) {
			remove(jScrollPane1);
		}
		if(jTableEmployees!=null) {
			remove(jTableEmployees);
		}
	}
	
	/**
	 * Action Methods
	 */
	private void login(String message) {
		loadBlankPage();


		jLabelUserName = new JLabel();
		jLabelPassword = new JLabel();
		jTextFieldUserName = new JTextField();
		jPasswordFieldPassword = new JPasswordField();
		jButtonRegister = new JButton();
		jButtonForgotPassword = new JButton();
		jButtonLogin = new JButton();
		jLabelMessage = new JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		jLabelMessage.setText(message);
		jLabelUserName.setText("Username :");

		jLabelPassword.setText("Password :");

		jButtonRegister.setText("Register");
		
		jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goToRegistrationPageFromLogin(evt);
			}
		});

		jButtonForgotPassword.setText("Forgot Password?");
		jButtonForgotPassword.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonForgotPasswordActionPerformed(evt);
			}
		});

		jButtonLogin.setText("Login");
		jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonLoginActionPerformed(evt);
			}
		});

		jLabelMessage.setForeground(new java.awt.Color(153, 0, 51));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGap(95, 95, 95)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(jLabelPassword)
																		.addGap(18, 18, 18)
																		.addComponent(jPasswordFieldPassword))
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(jLabelUserName)
																				.addGap(18, 18, 18)
																				.addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(jButtonLogin, javax.swing.GroupLayout.Alignment.TRAILING)))
																				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																						.addContainerGap()
																						.addComponent(jButtonRegister)
																						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																						.addComponent(jButtonForgotPassword))))
																						.addContainerGap(126, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(47, 47, 47)
						.addComponent(jLabelMessage)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelUserName)
								.addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelPassword)
										.addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addComponent(jButtonLogin)
										.addGap(11, 11, 11)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButtonForgotPassword)
												.addComponent(jButtonRegister))
												.addContainerGap(116, Short.MAX_VALUE))
		);
		pack();
	}

	private void register() {
		loadBlankPage();
		jLabelFirstName = new JLabel();
		jLabelMiddleName = new JLabel();
		jLabelLastName = new JLabel();
		jLabelPassword = new JLabel();
		jLabelSecurityQuestion = new JLabel();
		jLabelSecurityAnswer = new JLabel();
		jTextFieldFirstName = new JTextField();
		jTextFieldMiddleName = new JTextField();
		jTextFieldLastName = new JTextField();
		jTextFieldSecurityQuestion = new JTextField();
		jTextFieldSecurityAnswer = new JTextField();
		jPasswordFieldPassword = new JPasswordField();
		jButtonBack = new JButton();
		jButtonRegister = new JButton();

		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

		jLabelFirstName.setText("First Name :");

		jLabelMiddleName.setText("Middle Name :");

		jLabelLastName.setText("Last Name :");

		jLabelPassword.setText("Password :");

		jLabelSecurityQuestion.setText("Security Question :");

		jLabelSecurityAnswer.setText("Security Answer :");

		jButtonBack.setText("Back To Login");
		jButtonBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonBackActionPerformed(evt);
			}
		});

		jButtonRegister.setText("Register Me");
		jButtonRegister.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				goToRegistrationSucessfulFromRegistration(evt);
			}
		});

		GroupLayout layout = new  GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup( GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(73, 73, 73)
						.addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jButtonBack)
										.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jButtonRegister))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
														.addComponent(jLabelFirstName)
														.addComponent(jLabelMiddleName)
														.addComponent(jLabelLastName)
														.addComponent(jLabelSecurityQuestion)
														.addComponent(jLabelSecurityAnswer)
														.addComponent(jLabelPassword))
														.addGap(22, 22, 22)
														.addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
																.addComponent(jPasswordFieldPassword)
																.addComponent(jTextFieldSecurityAnswer)
																.addComponent(jTextFieldSecurityQuestion)
																.addComponent(jTextFieldLastName)
																.addComponent(jTextFieldMiddleName)
																.addComponent(jTextFieldFirstName,  GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))))
																.addContainerGap(97, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup( GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(49, 49, 49)
						.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelFirstName)
								.addComponent(jTextFieldFirstName,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
								.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelMiddleName)
										.addComponent(jTextFieldMiddleName,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
										.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
												.addComponent(jLabelLastName)
												.addComponent(jTextFieldLastName,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
												.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
														.addComponent(jLabelPassword)
														.addComponent(jPasswordFieldPassword,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
														.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
																.addComponent(jLabelSecurityQuestion)
																.addComponent(jTextFieldSecurityQuestion,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
																.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
																		.addComponent(jLabelSecurityAnswer)
																		.addComponent(jTextFieldSecurityAnswer,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
																		.addGap(18, 18, 18)
																		.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
																				.addComponent(jButtonBack)
																				.addComponent(jButtonRegister))
																				.addContainerGap(60, Short.MAX_VALUE))
		);
		pack();

	}

	public void registrationSucessful(Employee employee) {
		loadBlankPage();
		jLabelUserName = new  JLabel();
		jLabelPassword = new  JLabel();
		jLabelFirstName = new  JLabel();
		jLabelMiddleName = new  JLabel();
		jLabelLastName = new  JLabel();
		jLabelSecurityQuestion = new  JLabel();
		jLabelSecurityAnswer = new  JLabel();
		jLabelUserNameToDisplay = new  JLabel();
		jLabelPasswordToDisplay = new  JLabel();
		jLabelFirstNameToDisplay = new  JLabel();
		jLabelMiddleNameToDisplay = new  JLabel();
		jLabelLastNameToDisplay = new  JLabel();
		jButtonGoToLogin = new  JButton();
		jLabelSecurityAnswerToDisplay = new  JLabel();
		jLabelSecurityQuestionToDisplay = new  JLabel();

		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);

		jLabelUserName.setText("Username :");
		jLabelUserNameToDisplay.setText(employee.getUserName());

		jLabelPassword.setText("Password :");
		jLabelPasswordToDisplay.setText(employee.getPassword());

		jLabelFirstName.setText("First Name :");
		jLabelFirstNameToDisplay.setText(employee.getFirstName());

		jLabelMiddleName.setText("Middle Name :");
		jLabelMiddleNameToDisplay.setText(employee.getMiddleName());

		jLabelLastName.setText("Last Name :");
		jLabelLastNameToDisplay.setText(employee.getLastName());

		jLabelSecurityQuestion.setText("Security Question :");
		jLabelSecurityQuestionToDisplay.setText(employee.getSecurityQuestion());

		jLabelSecurityAnswer.setText("Security Answer :");
		jLabelSecurityAnswerToDisplay.setText(employee.getSecurityAnswer());

		jButtonGoToLogin.setText("Go To Login");
		jButtonGoToLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonGoToLoginActionPerformed(evt);
			}
		});

		GroupLayout layout = new  GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup( GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(76, 76, 76)
						.addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
								.addComponent(jLabelSecurityAnswer)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLabelSecurityQuestion)
										.addGap(18, 18, 18)
										.addComponent(jLabelSecurityQuestionToDisplay))
										.addComponent(jLabelLastName)
										.addComponent(jLabelMiddleName)
										.addComponent(jLabelFirstName)
										.addComponent(jLabelPassword)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabelUserName)
												.addGap(57, 57, 57)
												.addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
														.addComponent(jLabelPasswordToDisplay)
														.addComponent(jLabelUserNameToDisplay)
														.addComponent(jLabelFirstNameToDisplay)
														.addComponent(jLabelMiddleNameToDisplay)
														.addComponent(jLabelLastNameToDisplay)
														.addComponent(jLabelSecurityAnswerToDisplay))))
														.addContainerGap(212, Short.MAX_VALUE))
														.addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addContainerGap(179, Short.MAX_VALUE)
																.addComponent(jButtonGoToLogin)
																.addGap(148, 148, 148))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup( GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(45, 45, 45)
						.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelUserName)
								.addComponent(jLabelUserNameToDisplay))
								.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
										.addComponent(jLabelPassword)
										.addComponent(jLabelPasswordToDisplay))
										.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
												.addComponent(jLabelFirstName)
												.addComponent(jLabelFirstNameToDisplay))
												.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
														.addComponent(jLabelMiddleName)
														.addComponent(jLabelMiddleNameToDisplay))
														.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
																.addComponent(jLabelLastName)
																.addComponent(jLabelLastNameToDisplay))
																.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
																		.addComponent(jLabelSecurityQuestion)
																		.addComponent(jLabelSecurityQuestionToDisplay))
																		.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
																				.addComponent(jLabelSecurityAnswer)
																				.addComponent(jLabelSecurityAnswerToDisplay))
																				.addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
																				.addComponent(jButtonGoToLogin)
																				.addContainerGap(87, Short.MAX_VALUE))
		);
		pack();
	}

	private void showEmployeeTable(List<Employee> employeeList) {

		loadBlankPage();
		jScrollPane1 = new JScrollPane();
		jTableEmployees = new  JTable();
		jButtonLogOut = new  JButton();

		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
		Object object[][] = new Object [employeeList.size()][];


		for(int i=0; i<employeeList.size(); i++) {
			Object object2[] = new Object[]{employeeList.get(i).getEmployeeId(),employeeList.get(i).getFirstName(), employeeList.get(i).getMiddleName(), employeeList.get(i).getLastName(), employeeList.get(i).getUserName(), employeeList.get(i).getPassword(),employeeList.get(i).getSecurityQuestion(),employeeList.get(i).getSecurityAnswer(),new JButton("Update")};
			object[i] = object2;
		}
		jTableEmployees.setModel(new DefaultTableModel(
				object,
				new String [] {
						"EmployeeId", "First Name", "Middle Name", "Last Name","userName","password", "Security Question", "Security Answer", "Button"
				}
		)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
					java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,void.class
			};
			boolean[] canEdit = new boolean [] {
					false, false, false, false, false, false, false, false, true, 
			};

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});

		jTableEmployees.getTableHeader().setResizingAllowed(true);

		// initial width of column 1
		jTableEmployees.setPreferredSize(new Dimension(9000,9000));
		//for(int i = 0; i<jTableEmployees.getColumnCount(); i++){
		jTableEmployees.getColumnModel().getColumn(0).setPreferredWidth(400);
		jTableEmployees.getColumnModel().getColumn(1).setPreferredWidth(400);
		jTableEmployees.getColumnModel().getColumn(2).setPreferredWidth(400);
		jTableEmployees.getColumnModel().getColumn(3).setPreferredWidth(400);
		jTableEmployees.getColumnModel().getColumn(4).setPreferredWidth(400);
		jTableEmployees.getColumnModel().getColumn(5).setPreferredWidth(400);
		jTableEmployees.getColumnModel().getColumn(6).setPreferredWidth(400);
		jTableEmployees.getColumnModel().getColumn(7).setPreferredWidth(400);
		jTableEmployees.getColumnModel().getColumn(8).setPreferredWidth(400);
		//}

		int vColIndex = 0;
		TableColumn col =jTableEmployees.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		jTableEmployees.getColumn("Button").setCellRenderer(new ButtonRenderer());
		jTableEmployees.getColumn("Button").setCellEditor(
				new ButtonEditor(new JCheckBox()));
		jTableEmployees.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		jTableEmployees.getTableHeader().setResizingAllowed(false);
		jTableEmployees.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(jTableEmployees);
		jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);



		jButtonLogOut.setText("LogOut");
		jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonLogOutActionPerformed(evt);
			}
		});

		GroupLayout layout = new  GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup( GroupLayout.Alignment.LEADING)
				.addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(15, Short.MAX_VALUE)
						.addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 375,  GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addGap(160, 160, 160)
								.addComponent(jButtonLogOut)
								.addContainerGap(173, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup( GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1,  GroupLayout.PREFERRED_SIZE, 275,  GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jButtonLogOut)
						.addContainerGap(13, Short.MAX_VALUE))
		);
		pack();
	}

	/**
	 * ActionListener Methods
	 */
	private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {
		login("LogOut Successful");
	}
	
	private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {
		List<Employee>  employeeList = new ArrayList<Employee>();
		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		ILoginDao loginDao = applicationContext.getBean("loginDao", LoginDaoImpl1.class);
		employeeList = loginDao.searchAllEmployee();
		showEmployeeTable(employeeList);
	}
	
	private void goToRegistrationPageFromLogin(java.awt.event.ActionEvent evt) {
		register();
	}
	
	@SuppressWarnings("deprecation")
	private void goToRegistrationSucessfulFromRegistration(java.awt.event.ActionEvent evt) {
		Employee employee= new Employee();
		employee.setFirstName(jTextFieldFirstName.getText());
		employee.setLastName(jTextFieldLastName.getText());
		employee.setMiddleName(jTextFieldMiddleName.getText());
		employee.setPassword(jPasswordFieldPassword.getText());
		employee.setSecurityQuestion(jTextFieldSecurityQuestion.getText());
		employee.setSecurityAnswer(jTextFieldSecurityAnswer.getText());

		applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		ILoginDao loginDao = applicationContext.getBean("loginDao", LoginDaoImpl1.class);
		loginDao.createEmployee(employee);
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = loginDao.searchAllEmployee();
		employee = employeeList.get(employeeList.size()-1);
		registrationSucessful(employee);
	}

	private void jButtonForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {
		login(null);
	}
	
	private void jButtonGoToLoginActionPerformed(java.awt.event.ActionEvent evt) {
		login(null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EmployeeManagementSystem().setVisible(true);
			}
		});
	}
}
