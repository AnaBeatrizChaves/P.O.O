package exercicio_03_interface;

public class Suite implements Acomodacao, ServicoAdicional {
    private static final double DIARIA = 350.0;
    private static final double CAFE_DA_MANHA = 20.0;
    private static final double LIMPEZA_EXTRA = 30.0;
    private int numeroPessoas;

    public Suite(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }

    @Override
    public double calcularDiaria() {
        return DIARIA;
    }

    @Override
    public double calcularServico(int numeroPessoas, int dias) {
        return (CAFE_DA_MANHA * numeroPessoas + LIMPEZA_EXTRA) * dias;
    }

    @Override
    public void exibirDetalhes(int dias) {
        double custoDiaria = calcularDiaria() * dias;
        double custoServico = calcularServico(numeroPessoas, dias);
        double custoTotal = custoDiaria + custoServico;
        System.out.println("Suíte - Diária: R$" + DIARIA + ", Dias: " + dias +
                           ", Pessoas: " + numeroPessoas + ", Total: R$" + custoTotal);
    }
}
