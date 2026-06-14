/**
 * Representa um médico da unidade de saúde.
 * Estende Funcionario e implementa Atendivel, demonstrando
 * herança múltipla de interface e polimorfismo.
 */
public class Medico extends Funcionario implements Atendivel {

    // Atributos específicos do médico
    private String crm;
    private String especialidade;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Cria um novo Médico.
     *
     * @param nome           Nome completo
     * @param cpf            CPF
     * @param telefone       Telefone de contato
     * @param dataNascimento Data de nascimento (dd/MM/aaaa)
     * @param matricula      Matrícula interna
     * @param salario        Salário em reais
     * @param setor          Setor (ex.: "Clínica Geral")
     * @param crm            Número do CRM
     * @param especialidade  Especialidade médica
     */
    public Medico(String nome, String cpf, String telefone,
                  String dataNascimento, String matricula,
                  double salario, String setor,
                  String crm, String especialidade) {
        super(nome, cpf, telefone, dataNascimento, matricula, salario, setor);
        this.crm           = crm;
        this.especialidade = especialidade;
    }

    // -------------------------------------------------------------------------
    // Getters e Setters
    // -------------------------------------------------------------------------

    public String getCrm()                    { return crm; }
    public void   setCrm(String crm)          { this.crm = crm; }

    public String getEspecialidade()          { return especialidade; }
    public void   setEspecialidade(String e)  { this.especialidade = e; }

    // -------------------------------------------------------------------------
    // Implementação de Atendivel (Polimorfismo via interface)
    // -------------------------------------------------------------------------

    /**
     * Realiza consulta médica ao paciente informado.
     * Exibe mensagem de atendimento no console.
     */
    @Override
    public void realizarAtendimento(Paciente paciente) {
        System.out.println("\n[CONSULTA MÉDICA]");
        System.out.println("Médico   : " + getNome() + " | " + especialidade);
        System.out.println("CRM      : " + crm);
        System.out.println("Paciente : " + paciente.getNome()
                         + " (Prontuário: " + paciente.getNumeroProntuario() + ")");
        System.out.println("Status   : Atendimento iniciado.\n");
    }

    /** Retorna o CRM como registro profissional. */
    @Override
    public String getRegistroProfissional() {
        return "CRM: " + crm;
    }

    // -------------------------------------------------------------------------
    // Implementações abstratas de Funcionario e Pessoa
    // -------------------------------------------------------------------------

    @Override public String getCargo() { return "Médico"; }
    @Override public String getTipo()  { return "Médico"; }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString()
             + " | CRM: " + crm
             + " | Especialidade: " + especialidade;
    }
}
