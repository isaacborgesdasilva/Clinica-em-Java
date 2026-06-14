/**
 * Representa um enfermeiro da unidade de saúde.
 * Estende Funcionario e implementa Atendivel.
 * Além de atendimentos, o enfermeiro realiza triagens de risco.
 */
public class Enfermeiro extends Funcionario implements Atendivel {

    // Atributos específicos
    private String coren;
    private String turno; // "Manhã", "Tarde" ou "Noite"

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Cria um novo Enfermeiro.
     *
     * @param nome           Nome completo
     * @param cpf            CPF
     * @param telefone       Telefone de contato
     * @param dataNascimento Data de nascimento (dd/MM/aaaa)
     * @param matricula      Matrícula interna
     * @param salario        Salário em reais
     * @param setor          Setor de atuação (ex.: "Triagem")
     * @param coren          Número do COREN
     * @param turno          Turno de trabalho
     */
    public Enfermeiro(String nome, String cpf, String telefone,
                      String dataNascimento, String matricula,
                      double salario, String setor,
                      String coren, String turno) {
        super(nome, cpf, telefone, dataNascimento, matricula, salario, setor);
        this.coren = coren;
        this.turno = turno;
    }

    // -------------------------------------------------------------------------
    // Getters e Setters
    // -------------------------------------------------------------------------

    public String getCoren()              { return coren; }
    public void   setCoren(String coren)  { this.coren = coren; }

    public String getTurno()              { return turno; }
    public void   setTurno(String turno)  { this.turno = turno; }

    // -------------------------------------------------------------------------
    // Implementação de Atendivel (Polimorfismo)
    // -------------------------------------------------------------------------

    /**
     * Realiza atendimento de enfermagem ao paciente.
     */
    @Override
    public void realizarAtendimento(Paciente paciente) {
        System.out.println("\n[ATENDIMENTO DE ENFERMAGEM]");
        System.out.println("Enfermeiro : " + getNome() + " | Turno: " + turno);
        System.out.println("COREN      : " + coren);
        System.out.println("Paciente   : " + paciente.getNome()
                         + " (Prontuário: " + paciente.getNumeroProntuario() + ")");
        System.out.println("Status     : Atendimento de enfermagem iniciado.\n");
    }

    /** Retorna o COREN como registro profissional. */
    @Override
    public String getRegistroProfissional() {
        return "COREN: " + coren;
    }

    // -------------------------------------------------------------------------
    // Método exclusivo do Enfermeiro
    // -------------------------------------------------------------------------

    /**
     * Realiza a triagem de risco de um paciente, coletando
     * sinais vitais e criando um objeto Triagem.
     *
     * @param paciente          Paciente a ser triado
     * @param dataHora          Data e hora da triagem (dd/MM/aaaa HH:mm)
     * @param pressaoSistolica  Pressão sistólica (mmHg)
     * @param pressaoDiastolica Pressão diastólica (mmHg)
     * @param temperatura       Temperatura corporal (°C)
     * @param peso              Peso (kg)
     * @param altura            Altura (m)
     * @return Objeto Triagem criado e já registrado no paciente
     */
    public Triagem realizarTriagem(Paciente paciente, String dataHora,
                                   double pressaoSistolica, double pressaoDiastolica,
                                   double temperatura, double peso, double altura) {
        Triagem triagem = new Triagem(paciente, this, dataHora,
                                      pressaoSistolica, pressaoDiastolica,
                                      temperatura, peso, altura);
        paciente.adicionarTriagem(triagem);
        triagem.registrar();
        return triagem;
    }

    // -------------------------------------------------------------------------
    // Implementações abstratas
    // -------------------------------------------------------------------------

    @Override public String getCargo() { return "Enfermeiro"; }
    @Override public String getTipo()  { return "Enfermeiro"; }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString()
             + " | COREN: " + coren
             + " | Turno: " + turno;
    }
}
