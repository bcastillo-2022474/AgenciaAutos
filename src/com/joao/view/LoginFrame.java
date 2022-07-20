package com.joao.view;

import com.joao.controller.UserController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class LoginFrame extends JFrame {
    LoginFrame() {
        customComponents();
        setVisible(true);
    }

    private void customComponents() {
        // declaring parent Panel
        JPanel parentPanel = new JPanel();
        parentPanel.setPreferredSize(new Dimension(300, 120));

        // panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 0, 10));

        // subpanels
        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // labels
        JLabel emailLabel = new JLabel("Correo :");
        JLabel passwordLabel = new JLabel("Contraseña :");

        // textFields
        JTextField emailTxt = new JTextField(20);
        JTextField passwordTxt = new JTextField(20);

        // adding labels and textfields to subpanels
        emailPanel.add(emailLabel);
        emailPanel.add(emailTxt);

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTxt);

        // Buttons
        JButton buttonSubmit = new JButton("Iniciar Sesion");

        // adding subPanels to panels
        panel.add(emailPanel);
        panel.add(passwordPanel);

        // adding panel to ParentPanel
        parentPanel.add(panel);

        // adding button to panel
        parentPanel.add(buttonSubmit);

        // adding parentPanel to Frame
        add(parentPanel);

        // frame
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // setting button EventListener
        buttonSubmit.addActionListener(e -> {
            // validate, log, and call MainFrame;
            UserController userController = new UserController();
            char rol = userController.verify(emailTxt.getText(), passwordTxt.getText());
            if (rol == 'A') {
                this.dispose();
                new MainFrame();
                return;
            }
            if (rol == 'B') {
                this.dispose();
                // here I should display a different Window, but for know is Okay
                new MainFrame();
                return;
            }
            // Display Error Message and Try again, at least I hope
        });
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}