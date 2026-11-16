public class Programa {
    public static void main(String[] args) {
        
        BancoSistemaCentral fintech = new BancoSistemaCentral("GreenTech OpenBank S.A.");

    
        ClientePessoaFisica pf = new ClientePessoaFisica(
            "CLI-01", "Mariana Costa", "111.222.333-44", "Belo Horizonte - MG", "Aprovado",
            "15/05/1995", 8500.00, "Solteira"
        );
        ClientePessoaJuridica pj = new ClientePessoaJuridica(
            "CLI-02", "EcoEnergy Soluções Ltda", "12.345.678/0001-99", "São Paulo - SP", "Aprovado",
            1200000.00, "EcoEnergy Brasil", "Energia Renovável"
        );

        fintech.cadastrarCliente(pf);
        fintech.cadastrarCliente(pj);

       
        ContaCorrente ccMariana = new ContaCorrente("0001", "10020-1", 3000.00, "1234", pf, 1500.00, 29.90);
        ContaPoupanca cpMariana = new ContaPoupanca("0001", "10020-2", 5000.00, "1234", pf, 0.0002, 15);
        ContaInvestimento ciEmpresa = new ContaInvestimento("0001", "90050-9", 50000.00, "9999", pj, "Moderado", 15.00);

        fintech.abrirConta(ccMariana);
        fintech.abrirConta(cpMariana);
        fintech.abrirConta(ciEmpresa);

       
        CartaoDebito debitoMariana = new CartaoDebito("4532-XXXX-XXXX-1111", "MARIANA COSTA", "888", "10/30", ccMariana);
        CartaoCredito creditoMariana = new CartaoCredito("5412-XXXX-XXXX-2222", "MARIANA COSTA", "777", "11/31", 6000.00, 10);

        fintech.emitirCartao(debitoMariana);
        fintech.emitirCartao(creditoMariana);

        debitoMariana.realizarCompra(250.00, "Supermercado Verde");
        creditoMariana.realizarCompra(1200.00, "Passagens Aéreas");
        creditoMariana.realizarCompra(7500.00, "Compra Acima do Limite");

        
        fintech.transferirPix(ccMariana, ciEmpresa, 500.00, "0000");
        fintech.transferirPix(ccMariana, ciEmpresa, 500.00, "1234"); 

        cpMariana.aplicarRendimento();
        ciEmpresa.investirFundoVerde(15000.00);

        EmprestimoFinanciamento empAprovado = new EmprestimoFinanciamento(pf, 10000.00, 0.015, 12);
        EmprestimoFinanciamento empReprovado = new EmprestimoFinanciamento(pf, 80000.00, 0.02, 12);
        
        fintech.registrarEmprestimo(empAprovado);
        fintech.registrarEmprestimo(empReprovado);

    
        fintech.exibirConsolidadoGeral();
    }
}