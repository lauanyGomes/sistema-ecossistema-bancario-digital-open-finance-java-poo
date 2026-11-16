public class ContaInvestimento extends ContaBancaria {
    private String perfilInvestidor;
    private double taxaCorretagem;

    public ContaInvestimento(String agencia, String numeroConta, double saldoInicial, String senha, Cliente titular,
                             String perfilInvestidor, double taxaCorretagem) {
        super(agencia, numeroConta, saldoInicial, senha, titular);
        this.perfilInvestidor = perfilInvestidor;
        this.taxaCorretagem = taxaCorretagem;
    }

    @Override
    public boolean sacar(double valor) {
        double valorTotal = valor + taxaCorretagem;
        if (valor > 0 && saldo >= valorTotal) {
            saldo -= valorTotal;
            registrarTransacao(-valorTotal, "Resgate Investimento (inclui corretagem de R$ " + taxaCorretagem + ")");
            return true;
        }
        System.out.println("[ERRO] Saldo insuficiente para resgate e taxa de corretagem.");
        return false;
    }

    public void investirFundoVerde(double valor) {
        if (saldo >= valor) {
            registrarTransacao(0, "Alocação de R$ " + valor + " em Fundo Verde ESG (ODS 8)");
        }
    }

    @Override
    public String toString() {
        return "[Conta Investimento] " + super.toString() + " | Perfil: " + perfilInvestidor;
    }
}