public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimentoDiario;
    private int diaAniversario;

    public ContaPoupanca(String agencia, String numeroConta, double saldoInicial, String senha, Cliente titular,
                         double taxaRendimentoDiario, int diaAniversario) {
        super(agencia, numeroConta, saldoInicial, senha, titular);
        this.taxaRendimentoDiario = taxaRendimentoDiario;
        this.diaAniversario = diaAniversario;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            registrarTransacao(-valor, "Saque Conta Poupança");
            return true;
        }
        System.out.println("[ERRO] Saldo insuficiente na poupança " + getNumeroConta());
        return false;
    }

    public void aplicarRendimento() {
        double rendimento = saldo * taxaRendimentoDiario;
        saldo += rendimento;
        registrarTransacao(rendimento, "Rendimento Poupança (Aniversário dia " + diaAniversario + ")");
    }

    @Override
    public String toString() {
        return "[Conta Poupança] " + super.toString() + " | Aniversário: Dia " + diaAniversario;
    }
}