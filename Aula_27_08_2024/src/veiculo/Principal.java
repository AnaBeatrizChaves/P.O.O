package veiculo;

public class Principal {

	public static void main(String[] args) {
		
		// instanciar o objeto
		Carro meuCarro1 = new Carro();
		Carro meuCarro2 = new Carro();
		
		//utilizar os atributos
		meuCarro1.modelo = "SUV";
		meuCarro1.cor = "Azul";
		meuCarro1.ano = 2020;
		meuCarro1.placa = "DGT-1202";
		
		meuCarro2.modelo = "Sedan";
		meuCarro2.cor = "Ver;melho";
		meuCarro2.ano = 2024;
		meuCarro2.placa = "KIJ-5656";
		
		meuCarro1.exibirInformacoes();
		meuCarro2.exibirInformacoes();
	}

}