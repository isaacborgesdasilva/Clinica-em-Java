import java.util.ArrayList;

/**
 * Representa um paciente atendido pela unidade de saúde.
 * Herda de Pessoa e armazena histórico de consultas e triagens.
 *
 * Disciplina: Programação de Computadores - UFERSA 2026.1
 * Prof.ª Welliana Benevides Ramalho
 */
public class Paciente extends Pessoa {

    // Atributos encapsulados
    private String numeroProntuario;
    private String convenio;

    // Relacionamentos (composição)
    private ArrayList<Consulta> historicoConsultas;
    private ArrayList<Triagem>  historicoTriagens;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Cria um novo Paciente.
     *
     * @param nome             Nome completo
     * @param cpf              CPF (apenas dígitos)
     * @param telefone         Telefone de contato
     * @param dataNascimento   Data de nascimento (dd/MM/aaaa)
     * @param numeroProntuario Número do prontuário no sistema
     * @param convenio         Convênio ou "Particular"
     */
    public Paciente(String nome, String cpf, String telefone,
                    String dataNascimento, String numeroProntuario,
                    String convenio) {
        super(nome, cpf, telefone, dataNascimento);
        this.numeroProntuario   = numeroProntuario;
        this.convenio           = convenio;
        this.historicoConsultas = new ArrayList<>();
        this.historicoTriagens  = new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // Getters e Setters (Encapsulamento)
    // -------------------------------------------------------------------------

    public String getNumeroProntuario()               { return numeroProntuario; }
    public void   setNumeroProntuario(String n)       { this.numeroProntuario = n; }

    public String getConvenio()                       { return convenio; }
    public void   setConvenio(String c)               { this.convenio = c; }

    // -------------------------------------------------------------------------
    // Manipulação do histórico
    // -------------------------------------------------------------------------

    /** Adiciona uma consulta ao histórico do paciente. */
    public void adicionarConsulta(Consulta c) {
        historicoConsultas.add(c);
    }

    /** Adiciona uma triagem ao histórico do paciente. */
    public void adicionarTriagem(Triagem t) {
        historicoTriagens.add(t);
    }

    /** Retorna o histórico de consultas (cópia defensiva). */
    public ArrayList<Consulta> getHistoricoConsultas() {
        return new ArrayList<>(historicoConsultas);
    }

    /** Retorna o histórico de triagens (cópia defensiva). */
    public ArrayList<Triagem> getHistoricoTriagens() {
        return new ArrayList<>(historicoTriagens);
    }

    /** Exibe o histórico completo do paciente no console. */
    public void exibirHistorico() {
        System.out.println("\n========== HISTÓRICO DO PACIENTE ==========");
        System.out.println("Paciente : " + getNome());
        System.out.println("Prontuário: " + numeroProntuario);

        System.out.println("\n--- Triagens (" + historicoTriagens.size() + ") ---");
        if (historicoTriagens.isEmpty()) {
            System.out.println("  Nenhuma triagem registrada.");
        } else {
            for (Triagem t : historicoTriagens) {
                System.out.println(t.gerarRelatorio());
            }
        }

        System.out.println("\n--- Consultas (" + historicoConsultas.size() + ") ---");
        if (historicoConsultas.isEmpty()) {
            System.out.println("  Nenhuma consulta registrada.");
        } else {
            for (Consulta c : historicoConsultas) {
                System.out.println(c.gerarRelatorio());
            }
        }
        System.out.println("===========================================\n");
    }

    // -------------------------------------------------------------------------
    // Implementação do método abstrato de Pessoa
    // -------------------------------------------------------------------------

    @Override
    public String getTipo() { return "Paciente"; }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString()
             + " | Prontuário: " + numeroProntuario
             + " | Convênio: "   + convenio;
    }
}
