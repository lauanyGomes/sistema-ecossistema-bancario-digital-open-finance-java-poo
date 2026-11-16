public class CartaoDebito extends Cartao {
    private ContaBancaria contaVinculada;

    public CartaoDebito(String numeroCartao, String nomeImpresso, String cvv, String validade, ContaBancaria contaVinculada) {
        super(numeroCartao, nomeImpresso, cvv, validade);
        this.contaVinculada = contaVinculada;
    }

    @Override
    public boolean realizarCompra(double valor, String estabelecimento) {
        if (!isAtivo()) {
            System.out.println("[ERRO] Cartão de débito bloqueado.");
            return false;
        }
        if (contaVinculada.sacar(valor)) {
            contaVinculada.registrarTransacao(-valor, "Compra Débito: " + estabelecimento);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[Débito] " + super.toString() + " | Conta: " + contaVinculada.getNumeroConta();
    }
}