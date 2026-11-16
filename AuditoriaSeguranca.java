import java.util.ArrayList;
import java.util.List;

public class AuditoriaSeguranca {
    private List<String> logsSeguranca;

    public AuditoriaSeguranca() {
        this.logsSeguranca = new ArrayList<>();
    }

    public void registrarLog(String evento) {
        logsSeguranca.add("[BACEN/OPEN-FINANCE LOG] " + evento);
    }

    public void exibirRelatorioAuditoria() {
        System.out.println("\n RELATÓRIO DE AUDITORIA E SEGURANÇA ");
        for (String log : logsSeguranca) {
            System.out.println(log);
        }
    }
}