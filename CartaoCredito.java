public class CartaoCredito extends Cartao {
    private double limiteTotal;
    private double limiteDisponivel;
    private double faturaAtual;
    private int melhorDiaCompra;

    public CartaoCredito(String numeroCartao, String nomeImpresso, String cvv, String validade,
                         double limiteTotal, int melhorDiaCompra) {
        super(numeroCartao, nomeImpresso, cvv, validade);
        this.limiteTotal = limiteTotal;
        this.limiteDisponivel = limiteTotal;
        this.faturaAtual = 0.0;
        this.melhorDiaCompra = melhorDiaCompra;
    }

    @Override
    public boolean realizarCompra(double valor, String estabelecimento) {
        if (!isAtivo()) {
            System.out.println("[ERRO] Cartão de crédito bloqueado.");
            return false;
        }
        if (valor > 0 && limiteDisponivel >= valor) {
            limiteDisponivel -= valor;
            faturaAtual += valor;
            System.out.println("[CRÉDITO] Compra aprovada em " + estabelecimento + " no valor de R$ " + String.format("%.2f", valor));
            return true;
        }
        System.out.println("[ERRO] Limite de crédito insuficiente no cartão " + getNumeroCartao());
        return false;
    }

    @Override
    public String toString() {
        return "[Crédito] " + super.toString() + " | Fatura: R$ " + String.format("%.2f", faturaAtual) + " | Limite Disp.: R$ " + String.format("%.2f", limiteDisponivel);
    }
}