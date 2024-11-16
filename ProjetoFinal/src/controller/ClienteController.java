package controller;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteController {
    private Cliente cliente;
    private ClienteDAO clienteDAO = new ClienteDAO();

    public boolean login(String cpf, String senha) {
        Cliente cliente = clienteDAO.findClienteByCPF(cpf);
        if (cliente != null && cliente.login(senha)) {
            this.cliente = cliente;
            return true;
        }
        return false;
    }
    
    public double consultarSaldo() {
        return cliente.consultarSaldo();
    }

    public void depositar(double valor) {
        cliente.depositar(valor);
    }
}
