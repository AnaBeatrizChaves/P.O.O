package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnFuncionario, btnCliente;

    public LoginView() {
        setTitle("Banco Malvader - Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(20, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 30, 150, 25);
        add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(20, 70, 80, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 70, 150, 25);
        add(txtSenha);

        btnFuncionario = new JButton("Funcionário");
        btnFuncionario.setBounds(30, 120, 100, 25);
        btnCliente = new JButton("Cliente");
        btnCliente.setBounds(150, 120, 100, 25);

        add(btnFuncionario);
        add(btnCliente);

        btnFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implementar autenticação e redirecionar ao menu de funcionário
            }
        });

        btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implementar autenticação e redirecionar ao menu de cliente
            }
        });
    }

    public static void main(String[] args) {
        new LoginView().setVisible(true);
    }
}
