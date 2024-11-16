package model;

import javax.swing.*;

import view.MenuClienteView;
import view.MenuFuncionarioView;

public class BancoMalvader {
	private String nome = "Banco Malvader";
	
	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void main(String[] args) {
    	iniciarSistema();
    }

    public static void iniciarSistema() {
    	 JFrame frame = new JFrame("Banco Malvader - Sistema de Autenticação");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(400, 300);
         frame.setLocationRelativeTo(null);

         
         JPanel panel = new JPanel();
         frame.add(panel);
         panel.setLayout(null);

        
         JLabel nomeLabel = new JLabel("Nome:");
         nomeLabel.setBounds(80, 30, 80, 25);
         panel.add(nomeLabel);

         JTextField nomeTextField = new JTextField(20);
         nomeTextField.setBounds(150, 30, 160, 25);
         panel.add(nomeTextField);

         
         JLabel senhaLabel = new JLabel("Senha:");
         senhaLabel.setBounds(80, 70, 80, 25);
         panel.add(senhaLabel);

         JPasswordField senhaField = new JPasswordField(20);
         senhaField.setBounds(150, 70, 160, 25);
         panel.add(senhaField);

         
         JLabel cargoLabel = new JLabel("Cargo:");
         cargoLabel.setBounds(80, 110, 80, 25);
         panel.add(cargoLabel);

         String[] cargos = { "Selecione", "Funcionário", "Cliente" };
         JComboBox<String> cargoComboBox = new JComboBox<>(cargos);
         cargoComboBox.setBounds(150, 110, 160, 25);
         panel.add(cargoComboBox);

         
         JButton loginButton = new JButton("Login");
         loginButton.setBounds(150, 150, 160, 25);
         panel.add(loginButton);

       
         loginButton.addActionListener(e -> {
             String nome = nomeTextField.getText();
             String senha = new String(senhaField.getPassword());
             String cargoSelecionado = (String) cargoComboBox.getSelectedItem();

             if (nome.isEmpty()) {
                 JOptionPane.showMessageDialog(frame, "Nome não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
             } else if (senha.length() < 5) {
                 JOptionPane.showMessageDialog(frame, "Senha deve ter pelo menos 5 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);
             } else if ("Selecione".equals(cargoSelecionado)) {
                 JOptionPane.showMessageDialog(frame, "Por favor, selecione um cargo.", "Erro", JOptionPane.ERROR_MESSAGE);
             } else {
                 if ("Funcionário".equals(cargoSelecionado)) {
                     JOptionPane.showMessageDialog(frame, "Bem-vindo, " + nome + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                     frame.dispose();  
                     new MenuFuncionarioView();  
                 } else {
                     JOptionPane.showMessageDialog(frame, "Bem-vindo, " + nome + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                     frame.dispose();
                     new MenuClienteView();
                     
                 }
             }
         });
         frame.setVisible(true);
     }
 }
