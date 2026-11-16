public abstract class Cartao {
    private String numeroCartao;
    private String nomeImpresso;
    private String cvv;
    private String validade;
    private boolean ativo;

    public Cartao(String numeroCartao, String nomeImpresso, String cvv, String validade) {
        this.numeroCartao = numeroCartao;
        this.nomeImpresso = nomeImpresso;
        this.cvv = cvv;
        this.validade = validade;
        this.ativo = true;
    }

    public abstract boolean realizarCompra(double valor, String estabelecimento);

    public String getNumeroCartao() { return numeroCartao; }
    public String getNomeImpresso() { return nomeImpresso; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    @Override
    public String toString() {
        return "Cartão: " + numeroCartao + " | Nome: " + nomeImpresso + " | Status: " + (ativo ? "Ativo" : "Bloqueado");
    }
}