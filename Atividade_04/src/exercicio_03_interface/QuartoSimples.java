package exercicio_03_interface;

public class QuartoSimples implements Acomodacao, ServicoAdicional {
    private static final double diaria = 100.0;
    private static final double cafe_manha = 20.0;
    private static final double limpeza_extra = 30.0;
    private int numeroPessoas;

    public QuartoSimples(int numeroPessoas) {
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
        System.out.println("--> Quarto Simples \n- Diária: R$" + diaria + "\n- Dias: " + dias +
                           "\n- Pessoas: " + numeroPessoas + "\n- Total: R$" + custoTotal);
    }
}
