package com.employeeManagementSystem.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class MainClass {

  public static void main(String args[]) {
    JFrame frame = new JFrame("Key Text Sample");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    KeyTextComponent keyTextComponent = new KeyTextComponent();
    final JTextField textField = new JTextField();

    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        String keyText = actionEvent.getActionCommand();
        textField.setText(keyText);
      }
    };
    keyTextComponent.addActionListener(actionListener);

    frame.add(keyTextComponent, BorderLayout.CENTER);
    frame.add(textField, BorderLayout.SOUTH);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}

class KeyTextComponent extends JComponent {
  private EventListenerList actionListenerList = new EventListenerList();

  public KeyTextComponent() {
    setBackground(Color.CYAN);
    KeyListener internalKeyListener = new KeyAdapter() {
      public void keyPressed(KeyEvent keyEvent) {
        if (actionListenerList != null) {
          int keyCode = keyEvent.getKeyCode();
          String keyText = KeyEvent.getKeyText(keyCode);
          ActionEvent actionEvent = new ActionEvent(this,
              ActionEvent.ACTION_PERFORMED, keyText);
          fireActionPerformed(actionEvent);
        }
      }
    };

    MouseListener internalMouseListener = new MouseAdapter() {
      public void mousePressed(MouseEvent mouseEvent) {
        requestFocusInWindow();
      }
    };

    addKeyListener(internalKeyListener);
    addMouseListener(internalMouseListener);
  }

  public void addActionListener(ActionListener actionListener) {
    actionListenerList.add(ActionListener.class, actionListener);
  }

  public void removeActionListener(ActionListener actionListener) {
    actionListenerList.remove(ActionListener.class, actionListener);
  }

  protected void fireActionPerformed(ActionEvent actionEvent) {
    EventListener listenerList[] = actionListenerList
        .getListeners(ActionListener.class);
    for (int i = 0, n = listenerList.length; i < n; i++) {
      ((ActionListener) listenerList[i]).actionPerformed(actionEvent);
    }
  }

  public boolean isFocusable() {
    return true;
  }
}