package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Conta;
import model.Funcionario;
import util.DataManager;

public class BancoController {
    // Atributos
    private List<Conta> contas;
    private List<Funcionario> funcionarios;

    // Construtor
    public BancoController() {
        this.contas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        carregarDados(); // Carrega dados ao iniciar a aplicação
    }

    // Métodos
    // Registrar uma nova conta
    public void abrirConta(Conta conta) {
        contas.add(conta);
        System.out.println("Conta adicionada com sucesso.");
    }

    // Encerrar uma conta
    public void encerrarConta(int numeroConta) {
        Conta conta = consultarConta(numeroConta);
        if (conta != null) {
            contas.remove(conta);
            System.out.println("Conta encerrada com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public Conta consultarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        System.out.println("Conta não encontrada.");
        return null;
    }

    public void salvarDados() {
        DataManager.salvarContas(contas, "contas.dat");
    }
    
    public void carregarDados() {
    	DataManager.carregarContas("contas.dat");
    }
}

