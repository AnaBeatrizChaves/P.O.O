package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFuncionarioView {

    public MenuFuncionarioView (){
    	 // Criando o frame do menu do funcionário
        JFrame frame = new JFrame("Menu Funcionário - Banco Malvader");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);

        // Painel para os botões do menu
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));

        // Botões das funcionalidades
        JButton abrirContaButton = new JButton("Abertura de Conta");
        JButton encerrarContaButton = new JButton("Encerramento de Conta");
        JButton consultaDadosButton = new JButton("Consulta de Dados");
        JButton alterarDadosButton = new JButton("Alteração de Dados");
        JButton cadastroFuncionarioButton = new JButton("Cadastro de Funcionários");
        JButton gerarRelatorioButton = new JButton("Geração de Relatórios");
        JButton sairButton = new JButton("Sair");

        // Adicionando ação para cada botão
        abrirContaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Abertura de Conta selecionada.");
                // Aqui você pode chamar o método para abrir conta
            }
        });

        encerrarContaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Encerramento de Conta selecionado.");
                // Aqui você pode chamar o método para encerrar conta
            }
        });

        consultaDadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Consulta de Dados selecionada.");
                // Aqui você pode abrir uma nova janela para o submenu de consulta de dados
            }
        });

        alterarDadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Alteração de Dados selecionada.");
                // Aqui você pode abrir uma nova janela para o submenu de alteração de dados
            }
        });

        cadastroFuncionarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Cadastro de Funcionários selecionado.");
                // Aqui você pode chamar o método para cadastrar um novo funcionário
            }
        });

        gerarRelatorioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Geração de Relatórios selecionada.");
                // Aqui você pode chamar o método para gerar relatório e exportar para Excel
            }
        });

        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  // Fecha o menu do funcionário e retorna ao menu principal
            }
        });

        // Adicionando botões ao painel
        panel.add(abrirContaButton);
        panel.add(encerrarContaButton);
        panel.add(consultaDadosButton);
        panel.add(alterarDadosButton);
        panel.add(cadastroFuncionarioButton);
        panel.add(gerarRelatorioButton);
        panel.add(sairButton);

        // Adicionando o painel ao frame
        frame.add(panel);
        frame.setVisible(true);
    }
}