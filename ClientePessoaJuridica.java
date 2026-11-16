public class ClientePessoaJuridica extends Cliente {
    private double faturamentoAnual;
    private String nomeFantasia;
    private String ramoAtividade;

    public ClientePessoaJuridica(String id, String nomeCompleto, String documento, String endereco, String nivelKyc,
                                 double faturamentoAnual, String nomeFantasia, String ramoAtividade) {
        super(id, nomeCompleto, documento, endereco, nivelKyc);
        this.faturamentoAnual = faturamentoAnual;
        this.nomeFantasia = nomeFantasia;
        this.ramoAtividade = ramoAtividade;
    }

    public double getFaturamentoAnual() { return faturamentoAnual; }
    public void setFaturamentoAnual(double faturamentoAnual) { this.faturamentoAnual = faturamentoAnual; }

    public String getNomeFantasia() { return nomeFantasia; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }

    public String getRamoAtividade() { return ramoAtividade; }
    public void setRamoAtividade(String ramoAtividade) { this.ramoAtividade = ramoAtividade; }

    @Override
    public double getCapacidadeFinanceira() {
        return faturamentoAnual / 12.0;
    }

    @Override
    public String toString() {
        return "[PJ] " + nomeFantasia + " (" + super.toString() + ") | Ramo: " + ramoAtividade;
    }
}