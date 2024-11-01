package exercicio_03_interface;

public class QuartoDuplo implements Acomodacao, ServicoAdicional {
    private static final double diaria = 180.0;
    private static final double cafe_manha = 20.0;
    private static final double limpeza_extra = 30.0;
    private int numeroPessoas;

    public QuartoDuplo(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }

    @Override
    public double calcularDiaria() {
        return diaria;
    }

    @Override
    public double calcularServico(int numeroPessoas, int dias) {
        return (cafe_manha * numeroPessoas + limpeza_extra) * dias;
    }

    @Override
    public void exibirDetalhes(int dias) {
        double custoDiaria = calcularDiaria() * dias;
        double custoServico = calcularServico(numeroPessoas, dias);
        double custoTotal = custoDiaria + custoServico;
        System.out.println("--> Quarto Duplo \n- Diária: R$" + diaria + "\n- Dias: " + dias +
                "\n- Pessoas: " + numeroPessoas + "\n- Total: R$" + custoTotal);
    }
}
