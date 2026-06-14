/**
 * Representa uma recepcionista da unidade de saúde.
 * Estende Funcionario. Responsável por cadastrar pacientes
 * e encaminhá-los para a fila de atendimento.
 *
 * Disciplina: Programação de Computadores - UFERSA 2026.1
 * Prof.ª Welliana Benevides Ramalho
 */
public class Recepcionista extends Funcionario {

    // Atributo específico
    private String turno; // "Manhã", "Tarde" ou "Noite"

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Cria uma nova Recepcionista.
     *
     * @param nome           Nome completo
     * @param cpf            CPF
     * @param telefone       Telefone de contato
     * @param dataNascimento Data de nascimento (dd/MM/aaaa)
     * @param matricula      Matrícula interna
     * @param salario        Salário em reais
     * @param setor          Setor (ex.: "Recepção")
     * @param turno          Turno de trabalho
     */
    public Recepcionista(String nome, String cpf, String telefone,
                         String dataNascimento, String matricula,
                         double salario, String setor, String turno) {
        super(nome, cpf, telefone, dataNascimento, matricula, salario, setor);
        this.turno = turno;
    }

    // -------------------------------------------------------------------------
    // Getters e Setters
    // -------------------------------------------------------------------------

    public String getTurno()              { return turno; }
    public void   setTurno(String turno)  { this.turno = turno; }

    // -------------------------------------------------------------------------
    // Método exclusivo
    // -------------------------------------------------------------------------

    /**
     * Cadastra um paciente no sistema, delegando ao SistemaAtendimento.
     *
     * @param paciente Paciente a ser cadastrado
     * @param sistema  Instância do sistema de atendimento
     */
    public void cadastrarPaciente(Paciente paciente, SistemaAtendimento sistema) {
        sistema.cadastrarPaciente(paciente);
        System.out.println("[RECEPÇÃO] Paciente '" + paciente.getNome()
                         + "' cadastrado por " + getNome() + ".\n");
    }

    // -------------------------------------------------------------------------
    // Implementações abstratas
    // -------------------------------------------------------------------------

    @Override public String getCargo() { return "Recepcionista"; }
    @Override public String getTipo()  { return "Recepcionista"; }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString() + " | Turno: " + turno;
    }
}
