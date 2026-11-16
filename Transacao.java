public class Transacao {
    private String codigo;
    private String dataHora;
    private double valor;
    private String descricao;

    public Transacao(String codigo, String dataHora, double valor, String descricao) {
        this.codigo = codigo;
        this.dataHora = dataHora;
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "[" + dataHora + "] " + codigo + " - " + descricao + ": R$ " + String.format("%.2f", valor);
    }
}