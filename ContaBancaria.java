import java.util.ArrayList;
import java.util.List;

public abstract class ContaBancaria {
    private String agencia;
    private String numeroConta;
    protected double saldo;
    private String senha;
    private Cliente titular;
    private List<Transacao> extrato;

    public ContaBancaria(String agencia, String numeroConta, double saldoInicial, String senha, Cliente titular) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        this.senha = senha;
        this.titular = titular;
        this.extrato = new ArrayList<>();
        registrarTransacao(saldoInicial, "Abertura de Conta / Depósito Inicial");
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            registrarTransacao(valor, "Depósito em Conta");
        }
    }

    public abstract boolean sacar(double valor);

    public boolean validarSenha(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }

    protected void registrarTransacao(double valor, String descricao) {
        String codigo = "TRX-" + (extrato.size() + 1001);
        extrato.add(new Transacao(codigo, "16/11/2026 20:10", valor, descricao));
    }

    public String getAgencia() { return agencia; }
    public String getNumeroConta() { return numeroConta; }
    public double getSaldo() { return saldo; }
    public Cliente getTitular() { return titular; }
    public List<Transacao> getExtrato() { return extrato; }

    @Override
    public String toString() {
        return "Ag: " + agencia + " | CC: " + numeroConta + " | Titular: " + titular.getNomeCompleto() + " | Saldo: R$ " + String.format("%.2f", saldo);
    }
}