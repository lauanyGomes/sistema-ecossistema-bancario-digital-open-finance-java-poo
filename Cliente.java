public abstract class Cliente {
    private String id;
    private String nomeCompleto;
    private String documento;
    private String endereco;
    private String nivelKyc;

    public Cliente(String id, String nomeCompleto, String documento, String endereco, String nivelKyc) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.documento = documento;
        this.endereco = endereco;
        this.nivelKyc = nivelKyc;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getNivelKyc() { return nivelKyc; }
    public void setNivelKyc(String nivelKyc) { this.nivelKyc = nivelKyc; }

    public abstract double getCapacidadeFinanceira();

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nomeCompleto + " | Doc: " + documento + " | KYC: " + nivelKyc;
    }
}