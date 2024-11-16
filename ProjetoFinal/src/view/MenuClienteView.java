package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuClienteView {

    public MenuClienteView() {
       
    	JFrame frame = new JFrame("Menu Cliente - Banco Malvader");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);

       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        
        JButton saldoButton = new JButton("Consultar Saldo");
        JButton depositoButton = new JButton("Depósito");
        JButton saqueButton = new JButton("Saque");
        JButton extratoButton = new JButton("Consultar Extrato");
        JButton limiteButton = new JButton("Consultar Limite");
        JButton sairButton = new JButton("Sair");

        
        saldoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String senha = JOptionPane.showInputDialog(frame, "Digite sua senha:");
                if (validarSenha(senha)) {
                    JOptionPane.showMessageDialog(frame, "Seu saldo é de: R$1000.00");
                   
                } else {
                    JOptionPane.showMessageDialog(frame, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        depositoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String valor = JOptionPane.showInputDialog(frame, "Digite o valor para depósito:");
                JOptionPane.showMessageDialog(frame, "Depósito de R$" + valor + " realizado com sucesso.");
                
            }
        });

        saqueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String senha = JOptionPane.showInputDialog(frame, "Digite sua senha:");
                if (validarSenha(senha)) {
                    String valor = JOptionPane.showInputDialog(frame, "Digite o valor para saque:");
                   
                    JOptionPane.showMessageDialog(frame, "Saque de R$" + valor + " realizado com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        extratoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Exibindo extrato...");
                // fazer lógica para exibir o extrato e exportá-lo para o Excel
                
            }
        });

        limiteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String senha = JOptionPane.showInputDialog(frame, "Digite sua senha:");
                if (validarSenha(senha)) {
                    JOptionPane.showMessageDialog(frame, "Seu limite disponível é de: R$500.00");
                    // fazer lógica para consultar e exibir o limite real que consta no banco de dados
                } else {
                    JOptionPane.showMessageDialog(frame, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
            }
        });

       
        panel.add(saldoButton);
        panel.add(depositoButton);
        panel.add(saqueButton);
        panel.add(extratoButton);
        panel.add(limiteButton);
        panel.add(sairButton);

       
        frame.add(panel);
        frame.setVisible(true);
    }

   
    private boolean validarSenha(String senha) {
       
        return senha != null && senha.equals("12345"); 
    }
}