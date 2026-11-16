public class ClientePessoaFisica extends Cliente {
    private String dataNascimento;
    private double rendaMensal;
    private String estadoCivil;

    public ClientePessoaFisica(String id, String nomeCompleto, String documento, String endereco, String nivelKyc,
                               String dataNascimento, double rendaMensal, String estadoCivil) {
        super(id, nomeCompleto, documento, endereco, nivelKyc);
        this.dataNascimento = dataNascimento;
        this.rendaMensal = rendaMensal;
        this.estadoCivil = estadoCivil;
    }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public double getRendaMensal() { return rendaMensal; }
    public void setRendaMensal(double rendaMensal) { this.rendaMensal = rendaMensal; }

    public String getEstadoCivil() { return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) { this.estadoCivil = estadoCivil; }

    @Override
    public double getCapacidadeFinanceira() {
        return rendaMensal;
    }

    @Override
    public String toString() {
        return "[PF] " + super.toString() + " | Renda Mensal: R$ " + String.format("%.2f", rendaMensal);
    }
}