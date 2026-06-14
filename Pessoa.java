/**
 * Classe abstrata que representa uma pessoa no sistema de saúde.
 * Serve como base para Paciente e Funcionario, centralizando
 * os atributos comuns e obrigando subclasses a definir getTipo().
 *
 * Disciplina: Programação de Computadores - UFERSA 2026.1
 * Prof.ª Welliana Benevides Ramalho
 */
public abstract class Pessoa {

    // Atributos encapsulados (modificador private)
    private String nome;
    private String cpf;
    private String telefone;
    private String dataNascimento;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Constrói uma Pessoa com os dados identificadores básicos.
     *
     * @param nome           Nome completo
     * @param cpf            CPF (apenas dígitos)
     * @param telefone       Telefone de contato
     * @param dataNascimento Data de nascimento no formato dd/MM/aaaa
     */
    public Pessoa(String nome, String cpf, String telefone, String dataNascimento) {
        this.nome            = nome;
        this.cpf             = cpf;
        this.telefone        = telefone;
        this.dataNascimento  = dataNascimento;
    }

    // -------------------------------------------------------------------------
    // Getters e Setters (Encapsulamento)
    // -------------------------------------------------------------------------

    public String getNome()            { return nome; }
    public void   setNome(String nome) { this.nome = nome; }

    public String getCpf()           { return cpf; }
    public void   setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone()                { return telefone; }
    public void   setTelefone(String telefone) { this.telefone = telefone; }

    public String getDataNascimento()                      { return dataNascimento; }
    public void   setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    // -------------------------------------------------------------------------
    // Método abstrato (obriga subclasses a implementar)
    // -------------------------------------------------------------------------

    /**
     * Retorna o tipo da pessoa no sistema (ex.: "Paciente", "Médico").
     * @return String com o tipo
     */
    public abstract String getTipo();

    // -------------------------------------------------------------------------
    // toString padrão
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return "[" + getTipo() + "] " + nome + " | CPF: " + cpf
             + " | Tel: " + telefone + " | Nasc: " + dataNascimento;
    }
}
