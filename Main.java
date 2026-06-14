/**
 * Classe principal do Sistema de Gerenciamento de Atendimentos de Saúde.
 * Demonstra o uso de todos os conceitos de POO exigidos no projeto:
 *   - Classes e Objetos
 *   - Encapsulamento (atributos private + getters/setters)
 *   - Herança (Pessoa → Funcionario → Medico/Enfermeiro/Recepcionista)
 *   - Classes Abstratas (Pessoa, Funcionario)
 *   - Interfaces (Atendivel, Registravel)
 *   - Polimorfismo (listas de Funcionario, chamadas via interface)
 *
 */
public class Main {

    public static void main(String[] args) {

        // =====================================================================
        // 1. INICIALIZA O SISTEMA
        // =====================================================================
        SistemaAtendimento sistema = new SistemaAtendimento("Unimed Natal");

        // =====================================================================
        // 2. CADASTRA FUNCIONÁRIOS
        // =====================================================================

        // Recepcionista
        Recepcionista recep = new Recepcionista(
            "Ana Lima", "111.222.333-44", "(84) 99001-0001",
            "15/03/1990", "REC-001", 2500.00, "Recepção", "Manhã"
        );
        sistema.cadastrarFuncionario(recep);

        // Enfermeiro
        Enfermeiro enf = new Enfermeiro(
            "Carlos Souza", "222.333.444-55", "(84) 99001-0002",
            "20/07/1988", "ENF-001", 4200.00, "Triagem",
            "COREN-RN 123456", "Manhã"
        );
        sistema.cadastrarFuncionario(enf);

        // Médico - Clínica Geral
        Medico medicoClinico = new Medico(
            "Dra. Beatriz Nunes", "333.444.555-66", "(84) 99001-0003",
            "05/11/1980", "MED-001", 12000.00, "Clínica Geral",
            "CRM-RN 54321", "Clínica Geral"
        );
        sistema.cadastrarFuncionario(medicoClinico);

        // Médico - Cardiologia
        Medico medicoCardio = new Medico(
            "Dr. Fernando Costa", "444.555.666-77", "(84) 99001-0004",
            "12/01/1975", "MED-002", 15000.00, "Cardiologia",
            "CRM-RN 98765", "Cardiologia"
        );
        sistema.cadastrarFuncionario(medicoCardio);

        // =====================================================================
        // 3. CADASTRA PACIENTES (via Recepcionista)
        // =====================================================================

        Paciente p1 = new Paciente(
            "João Pedro Alves", "555.666.777-88", "(84) 98800-1111",
            "30/04/1965", "PRONT-0001", "Unimed"
        );
        Paciente p2 = new Paciente(
            "Maria das Graças", "666.777.888-99", "(84) 98800-2222",
            "14/09/1978", "PRONT-0002", "Particular"
        );
        Paciente p3 = new Paciente(
            "Lucas Ferreira", "777.888.999-00", "(84) 98800-3333",
            "22/02/1995", "PRONT-0003", "Unimed"
        );

        // A recepcionista realiza o cadastro (demonstra responsabilidade de classe)
        recep.cadastrarPaciente(p1, sistema);
        recep.cadastrarPaciente(p2, sistema);
        recep.cadastrarPaciente(p3, sistema);

        // =====================================================================
        // 4. TRIAGENS (realizadas pelo Enfermeiro)
        // =====================================================================

        System.out.println("========== TRIAGENS ==========");

        // João: febre alta + pressão elevada → risco LARANJA/VERMELHO
        Triagem t1 = enf.realizarTriagem(
            p1, "04/06/2026 08:15",
            175, 105,   // pressão sistólica / diastólica
            39.8,       // temperatura
            82.0, 1.72  // peso / altura
        );
        sistema.registrarTriagem(t1);

        // Maria: sinais normais → risco AZUL
        Triagem t2 = enf.realizarTriagem(
            p2, "04/06/2026 08:30",
            120, 80,
            36.6,
            65.0, 1.65
        );
        sistema.registrarTriagem(t2);

        // Lucas: febre moderada → risco AMARELO
        Triagem t3 = enf.realizarTriagem(
            p3, "04/06/2026 08:45",
            138, 88,
            39.2,
            70.0, 1.78
        );
        sistema.registrarTriagem(t3);

        // =====================================================================
        // 5. POLIMORFISMO — atendimento via interface Atendivel
        // =====================================================================

        System.out.println("\n========== ATENDIMENTOS (POLIMORFISMO) ==========");

        // Array de Atendivel — Medico e Enfermeiro tratados pelo mesmo tipo
        Atendivel[] profissionais = { medicoClinico, enf, medicoCardio };

        // Paciente com prioridade (João — risco VERMELHO)
        for (Atendivel prof : profissionais) {
            prof.realizarAtendimento(p1);
        }

        // =====================================================================
        // 6. CONSULTAS MÉDICAS
        // =====================================================================

        System.out.println("========== CONSULTAS ==========");

        Consulta c1 = new Consulta(
            p1, medicoClinico,
            "04/06/2026 09:00",
            "Hipertensão arterial sistêmica + síndrome gripal",
            "Losartana 50mg 1x/dia. Dipirona 500mg se febre. Repouso 3 dias."
        );
        sistema.registrarConsulta(c1);

        Consulta c2 = new Consulta(
            p2, medicoClinico,
            "04/06/2026 09:30",
            "Check-up de rotina. Paciente sem queixas.",
            "Manter hábitos saudáveis. Retorno em 6 meses."
        );
        sistema.registrarConsulta(c2);

        Consulta c3 = new Consulta(
            p3, medicoCardio,
            "04/06/2026 10:00",
            "Taquicardia paroxística supraventricular",
            "Encaminhar para ECG. Atenolol 25mg 1x/dia. Retorno em 15 dias."
        );
        sistema.registrarConsulta(c3);

        // =====================================================================
        // 7. RELATÓRIOS CLÍNICOS
        // =====================================================================

        System.out.println("\n========== RELATÓRIOS CLÍNICOS ==========");
        System.out.println(c1.gerarRelatorio());
        System.out.println(c3.gerarRelatorio());
        System.out.println(t1.gerarRelatorio());

        // =====================================================================
        // 8. HISTÓRICO COMPLETO DO PACIENTE 1
        // =====================================================================

        p1.exibirHistorico();

        // =====================================================================
        // 9. LISTAGENS DO SISTEMA
        // =====================================================================

        sistema.listarPacientes();
        sistema.listarFuncionarios();

        // =====================================================================
        // 10. RELATÓRIO GERAL DO SISTEMA
        // =====================================================================

        System.out.println(sistema.gerarRelatorioGeral());

        // =====================================================================
        // 11. BUSCA DE ENTIDADES (demonstração dos métodos de busca)
        // =====================================================================

        System.out.println("========== BUSCA ==========");
        Paciente encontrado = sistema.buscarPacientePorCpf("555.666.777-88");
        if (encontrado != null) {
            System.out.println("Paciente encontrado: " + encontrado.getNome()
                             + " | Prontuário: " + encontrado.getNumeroProntuario());
        }

        Funcionario funcEncontrado = sistema.buscarFuncionarioPorMatricula("MED-002");
        if (funcEncontrado != null) {
            System.out.println("Funcionário encontrado: " + funcEncontrado.getNome()
                             + " | Cargo: " + funcEncontrado.getCargo());
        }

        System.out.println("\nTotal de consultas registradas: " + Consulta.getTotalConsultas());
        System.out.println("\nSistema encerrado. Até logo!\n");
    }
}
