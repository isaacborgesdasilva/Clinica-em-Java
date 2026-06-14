/**
 * Classe abstrata que representa um funcionário da unidade de saúde.
 * Estende Pessoa e adiciona atributos funcionais (matrícula, salário, setor).
 * Obriga subclasses a definir getCargo() e getTipo().
 */
public abstract class Funcionario extends Pessoa {

    // Atributos encapsulados
    private String matricula;
    private double salario;
    private String setor;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Constrói um Funcionario com dados pessoais e funcionais.
     *
     * @param nome           Nome completo
     * @param cpf            CPF (apenas dígitos)
     * @param telefone       Telefone de contato
     * @param dataNascimento Data de nascimento (dd/MM/aaaa)
     * @param matricula      Matrícula interna
     * @param salario        Salário em reais
     * @param setor          Setor de atuação
     */
    public Funcionario(String nome, String cpf, String telefone,
                       String dataNascimento, String matricula,
                       double salario, String setor) {
        super(nome, cpf, telefone, dataNascimento);
        this.matricula = matricula;
        this.salario   = salario;
        this.setor     = setor;
    }

    // -------------------------------------------------------------------------
    // Getters e Setters (Encapsulamento)
    // -------------------------------------------------------------------------

    public String getMatricula()               { return matricula; }
    public void   setMatricula(String m)       { this.matricula = m; }

    public double getSalario()                 { return salario; }
    public void   setSalario(double s)         { this.salario = s; }

    public String getSetor()                   { return setor; }
    public void   setSetor(String s)           { this.setor = s; }

    // -------------------------------------------------------------------------
    // Método abstrato
    // -------------------------------------------------------------------------

    /**
     * Retorna o cargo do funcionário (ex.: "Médico", "Enfermeiro").
     * @return String com o cargo
     */
    public abstract String getCargo();

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString()
             + " | Cargo: " + getCargo()
             + " | Matrícula: " + matricula
             + " | Setor: " + setor;
    }
}
