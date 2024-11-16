package view;

import controller.FuncionarioController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CadastroContaView extends JFrame {
    private FuncionarioController funcionarioController;

    public CadastroContaView(FuncionarioController controller) {
        this.funcionarioController = controller;
        setTitle("Cadastro de Conta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField txtCpf = new JTextField(15);
        JTextField txtAgencia = new JTextField(10);
        JTextField txtNumeroConta = new JTextField(10);
        JTextField txtSaldo = new JTextField(10);
        JTextField txtLimite = new JTextField(10);
        JTextField txtDataVencimento = new JTextField(10);
        JTextField txtTaxaRendimento = new JTextField(10);

        JButton btnCadastrarCorrente = new JButton("Cadastrar Conta Corrente");
        JButton btnCadastrarPoupanca = new JButton("Cadastrar Conta Poupança");

        btnCadastrarCorrente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    funcionarioController.abrirContaCorrente(
                        txtCpf.getText(),
                        txtAgencia.getText(),
                        Integer.parseInt(txtNumeroConta.getText()),
                        Double.parseDouble(txtSaldo.getText()),
                        Double.parseDouble(txtLimite.getText()),
                        LocalDate.parse(txtDataVencimento.getText())
                    );
                    JOptionPane.showMessageDialog(null, "Conta Corrente cadastrada com sucesso.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar conta corrente.");
                    ex.printStackTrace();
                }
            }
        });

        btnCadastrarPoupanca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    funcionarioController.abrirContaPoupanca(
                        txtCpf.getText(),
                        txtAgencia.getText(),
                        Integer.parseInt(txtNumeroConta.getText()),
                        Double.parseDouble(txtSaldo.getText()),
                        Double.parseDouble(txtTaxaRendimento.getText())
                    );
                    JOptionPane.showMessageDialog(null, "Conta Poupança cadastrada com sucesso.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar conta poupança.");
                    ex.printStackTrace();
                }
            }
        });

        panel.add(new JLabel("CPF do Cliente:"));
        panel.add(txtCpf);
        panel.add(new JLabel("Agência:"));
        panel.add(txtAgencia);
        panel.add(new JLabel("Número da Conta:"));
        panel.add(txtNumeroConta);
        panel.add(new JLabel("Saldo Inicial:"));
        panel.add(txtSaldo);
        panel.add(new JLabel("Limite (para Conta Corrente):"));
        panel.add(txtLimite);
        panel.add(new JLabel("Data de Vencimento (AAAA-MM-DD):"));
        panel.add(txtDataVencimento);
        panel.add(new JLabel("Taxa de Rendimento (para Poupança):"));
        panel.add(txtTaxaRendimento);
        panel.add(btnCadastrarCorrente);
        panel.add(btnCadastrarPoupanca);

        add(panel);
    }
}
