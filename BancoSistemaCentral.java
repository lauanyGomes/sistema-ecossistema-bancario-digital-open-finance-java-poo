import java.util.ArrayList;
import java.util.List;

public class BancoSistemaCentral {
    private String nomeInstituicao;
    private List<Cliente> clientes;
    private List<ContaBancaria> contas;
    private List<Cartao> cartoes;
    private List<EmprestimoFinanciamento> emprestimos;
    private AuditoriaSeguranca auditoria;

    public BancoSistemaCentral(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.cartoes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
        this.auditoria = new AuditoriaSeguranca();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        auditoria.registrarLog("Novo cliente cadastrado: " + cliente.getNomeCompleto() + " (KYC: " + cliente.getNivelKyc() + ")");
    }

    public void abrirConta(ContaBancaria conta) {
        contas.add(conta);
        auditoria.registrarLog("Conta aberta: " + conta.getNumeroConta() + " para " + conta.getTitular().getNomeCompleto());
    }

    public void emitirCartao(Cartao cartao) {
        cartoes.add(cartao);
        auditoria.registrarLog("Cartão emitido: " + cartao.getNumeroCartao() + " para " + cartao.getNomeImpresso());
    }

    public void registrarEmprestimo(EmprestimoFinanciamento emp) {
        emprestimos.add(emp);
        auditoria.registrarLog("Solicitação de crédito processada -> " + emp.getStatusAprovacao());
    }

    public void transferirPix(ContaBancaria origem, ContaBancaria destino, double valor, String senha) {
        if (!origem.validarSenha(senha)) {
            auditoria.registrarLog("ALERTA DE SEGURANÇA: Tentativa de PIX com senha inválida na conta " + origem.getNumeroConta());
            System.out.println("[SEGURANÇA] Senha incorreta! Transferência bloqueada.");
            return;
        }
        if (origem.sacar(valor)) {
            destino.depositar(valor);
            origem.registrarTransacao(-valor, "PIX Enviado para " + destino.getTitular().getNomeCompleto());
            destino.registrarTransacao(valor, "PIX Recebido de " + origem.getTitular().getNomeCompleto());
            auditoria.registrarLog("Transferência PIX de R$ " + valor + " concluída entre " + origem.getNumeroConta() + " e " + destino.getNumeroConta());
        }
    }

    public void exibirConsolidadoGeral() {
        System.out.println("\n");
        System.out.println("   CONSOLIDADO DO ECOSSISTEMA: " + nomeInstituicao);
        System.out.println("");

        System.out.println("\n CLIENTES CADASTRADOS ");
        for (Cliente c : clientes) System.out.println(c);

        System.out.println("\n CONTAS ATIVAS ");
        for (ContaBancaria cb : contas) System.out.println(cb);

        System.out.println("\n CARTÕES EMITIDOS ");
        for (Cartao ct : cartoes) System.out.println(ct);

        System.out.println("\n ANÁLISES DE CRÉDITO ");
        for (EmprestimoFinanciamento ef : emprestimos) System.out.println(ef);

        System.out.println("\n EXTRATO DETALHADO DAS CONTAS ");
        for (ContaBancaria cb : contas) {
            System.out.println("Extrato Conta " + cb.getNumeroConta() + " (" + cb.getTitular().getNomeCompleto() + "):");
            for (Transacao t : cb.getExtrato()) {
                System.out.println("   " + t);
            }
        }

        auditoria.exibirRelatorioAuditoria();
    }
}