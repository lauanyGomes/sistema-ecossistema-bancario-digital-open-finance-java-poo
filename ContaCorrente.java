public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;
    private double taxaManutencaoMensal;

    public ContaCorrente(String agencia, String numeroConta, double saldoInicial, String senha, Cliente titular,
                         double limiteChequeEspecial, double taxaManutencaoMensal) {
        super(agencia, numeroConta, saldoInicial, senha, titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaManutencaoMensal = taxaManutencaoMensal;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && (saldo + limiteChequeEspecial) >= valor) {
            saldo -= valor;
            registrarTransacao(-valor, "Saque / Pagamento Conta Corrente");
            return true;
        }
        System.out.println("[ERRO] Saldo e limite de cheque especial insuficientes na conta " + getNumeroConta());
        return false;
    }

    public void cobrarTaxaManutencao() {
        saldo -= taxaManutencaoMensal;
        registrarTransacao(-taxaManutencaoMensal, "Cobrança Taxa de Manutenção Mensal");
    }

    @Override
    public String toString() {
        return "[Conta Corrente] " + super.toString() + " | Cheque Especial: R$ " + String.format("%.2f", limiteChequeEspecial);
    }
}