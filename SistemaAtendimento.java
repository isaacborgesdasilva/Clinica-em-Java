import java.util.ArrayList;

/**
 * Classe central que gerencia pacientes, funcionários,
 * consultas e triagens da unidade de saúde.
 * Atua como repositório e ponto de controle do sistema.
 *
 * Disciplina: Programação de Computadores - UFERSA 2026.1
 * Prof.ª Welliana Benevides Ramalho
 */
public class SistemaAtendimento {

    // Atributo de identificação
    private String nomeSistema;

    // Coleções de entidades (polimorfismo: Funcionario é tipo base)
    private ArrayList<Paciente>   pacientes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Consulta>   consultas;
    private ArrayList<Triagem>    triagens;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Cria o sistema de atendimento com o nome da unidade de saúde.
     * @param nomeSistema Nome da unidade (ex.: "Unimed Natal")
     */
    public SistemaAtendimento(String nomeSistema) {
        this.nomeSistema   = nomeSistema;
        this.pacientes     = new ArrayList<>();
        this.funcionarios  = new ArrayList<>();
        this.consultas     = new ArrayList<>();
        this.triagens      = new ArrayList<>();
        System.out.println("=================================================");
        System.out.println("  Sistema de Atendimento - " + nomeSistema);
        System.out.println("  Iniciado com sucesso.");
        System.out.println("=================================================\n");
    }

    // -------------------------------------------------------------------------
    // Cadastros
    // -------------------------------------------------------------------------

    /** Cadastra um paciente no sistema. */
    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    /** Cadastra um funcionário no sistema (aceita Medico, Enfermeiro ou Recepcionista). */
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("[SISTEMA] Funcionário cadastrado: "
                         + funcionario.getNome() + " (" + funcionario.getCargo() + ")");
    }

    // -------------------------------------------------------------------------
    // Registro de eventos clínicos
    // -------------------------------------------------------------------------

    /**
     * Registra uma consulta no sistema e no histórico do paciente.
     * @param consulta Consulta a ser registrada
     */
    public void registrarConsulta(Consulta consulta) {
        consultas.add(consulta);
        consulta.getPaciente().adicionarConsulta(consulta);
        consulta.registrar();
    }

    /**
     * Registra uma triagem no sistema e no histórico do paciente.
     * @param triagem Triagem a ser registrada
     */
    public void registrarTriagem(Triagem triagem) {
        triagens.add(triagem);
        // Triagens criadas via Enfermeiro.realizarTriagem() já são
        // adicionadas ao paciente; este método só insere na lista do sistema.
    }

    // -------------------------------------------------------------------------
    // Buscas
    // -------------------------------------------------------------------------

    /**
     * Busca um paciente pelo CPF.
     * @param cpf CPF a ser pesquisado
     * @return Paciente encontrado ou null se não existir
     */
    public Paciente buscarPacientePorCpf(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) return p;
        }
        return null;
    }

    /**
     * Busca um funcionário pela matrícula.
     * @param matricula Matrícula a ser pesquisada
     * @return Funcionario encontrado ou null se não existir
     */
    public Funcionario buscarFuncionarioPorMatricula(String matricula) {
        for (Funcionario f : funcionarios) {
            if (f.getMatricula().equals(matricula)) return f;
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // Listagens
    // -------------------------------------------------------------------------

    /** Lista todos os pacientes cadastrados. */
    public void listarPacientes() {
        System.out.println("\n--- PACIENTES CADASTRADOS (" + pacientes.size() + ") ---");
        if (pacientes.isEmpty()) {
            System.out.println("  Nenhum paciente cadastrado.");
        } else {
            for (Paciente p : pacientes) {
                System.out.println("  " + p);
            }
        }
        System.out.println();
    }

    /** Lista todos os funcionários cadastrados (polimorfismo em ação). */
    public void listarFuncionarios() {
        System.out.println("\n--- FUNCIONÁRIOS CADASTRADOS (" + funcionarios.size() + ") ---");
        if (funcionarios.isEmpty()) {
            System.out.println("  Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : funcionarios) {
                // Polimorfismo: getCargo() chama o método da subclasse correta
                System.out.println("  [" + f.getCargo() + "] " + f.getNome()
                                 + " | Matrícula: " + f.getMatricula());
            }
        }
        System.out.println();
    }

    /** Gera um relatório consolidado do sistema. */
    public String gerarRelatorioGeral() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔══════════════════════════════════════╗\n");
        sb.append("  RELATÓRIO GERAL - ").append(nomeSistema).append("\n");
        sb.append("╠══════════════════════════════════════╣\n");
        sb.append("  Pacientes cadastrados : ").append(pacientes.size()).append("\n");
        sb.append("  Funcionários          : ").append(funcionarios.size()).append("\n");
        sb.append("  Triagens realizadas   : ").append(triagens.size()).append("\n");
        sb.append("  Consultas realizadas  : ").append(consultas.size()).append("\n");
        sb.append("╚══════════════════════════════════════╝\n");
        return sb.toString();
    }

    // -------------------------------------------------------------------------
    // Getters auxiliares
    // -------------------------------------------------------------------------

    public String              getNomeSistema()  { return nomeSistema; }
    public ArrayList<Paciente> getPacientes()    { return pacientes; }
    public ArrayList<Consulta> getConsultas()    { return consultas; }
    public ArrayList<Triagem>  getTriagens()     { return triagens; }
}
