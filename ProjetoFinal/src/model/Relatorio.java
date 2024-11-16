package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class Relatorio {
	//variaveis
    private String tipo;
    private LocalDateTime dataGeracao;
    private List<String> dados;
    
    //construtor
    public Relatorio(String tipo, LocalDateTime dataGeracao, List<String> dados) {
		this.tipo = tipo;
		this.dataGeracao = dataGeracao;
		this.dados = dados;
	}

    //getters e setters
    public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(LocalDateTime dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public List<String> getDados() {
		return dados;
	}

	public void setDados(List<String> dados) {
		this.dados = dados;
	}
	
	//metodos
    public void gerarRelatorioGeral() {
    	System.out.println("Gerando relatório do tipo: " + tipo);
        for (String linha : dados) {
            System.out.println(linha);
        }
       
    }

	public void exportarParaExcel(String caminhoArquivo) {
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
		        // Cabeçalhos do relatório
		        writer.write("Tipo,Data de Geração,Dados");
		        writer.newLine();

		        // Dados do relatório
		        for (String linha : dados) {
		            writer.write(tipo + "," + dataGeracao + "," + linha);
		            writer.newLine();
		        }
		        System.out.println("Relatório exportado com sucesso para: " + caminhoArquivo);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
    }
}



