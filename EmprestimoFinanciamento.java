public class EmprestimoFinanciamento {
    private Cliente solicitante;
    private double valorSolicitado;
    private double taxaJurosMensal;
    private int quantidadeParcelas;
    private String statusAprovacao;

    public EmprestimoFinanciamento(Cliente solicitante, double valorSolicitado, double taxaJurosMensal, int quantidadeParcelas) {
        this.solicitante = solicitante;
        this.valorSolicitado = valorSolicitado;
        this.taxaJurosMensal = taxaJurosMensal;
        this.quantidadeParcelas = quantidadeParcelas;
        analisarCredito();
    }

    private void analisarCredito() {
        double valorParcela = (valorSolicitado * (1 + (taxaJurosMensal * quantidadeParcelas))) / quantidadeParcelas;
        double capacidade = solicitante.getCapacidadeFinanceira();

       
        if (valorParcela <= capacidade * 0.30 && solicitante.getNivelKyc().equalsIgnoreCase("Aprovado")) {
            this.statusAprovacao = "APROVADO (Parcela: R$ " + String.format("%.2f", valorParcela) + ")";
        } else {
            this.statusAprovacao = "REPROVADO (Renda insuficiente ou KYC pendente)";
        }
    }

    public String getStatusAprovacao() { return statusAprovacao; }

    @Override
    public String toString() {
        return "Empréstimo para " + solicitante.getNomeCompleto() + " | Valor: R$ " + String.format("%.2f", valorSolicitado) + " em " + quantidadeParcelas + "x | Status: " + statusAprovacao;
    }
}