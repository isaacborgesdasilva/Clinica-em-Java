/**
 * Representa uma consulta médica no sistema de saúde.
 * Implementa Registravel. Usa atributo estático para numerar
 * automaticamente as consultas.
 */
public class Consulta implements Registravel {

    // Contador estático compartilhado entre todas as instâncias
    private static int contadorConsultas = 0;

    // Identificador único da consulta
    private int numeroConsulta;

    // Referências
    private Paciente paciente;
    private Medico   medico;

    // Dados clínicos
    private String dataHora;
    private String diagnostico;
    private String prescricao;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Cria uma nova Consulta, incrementando o contador automático.
     *
     * @param paciente    Paciente atendido
     * @param medico      Médico responsável
     * @param dataHora    Data e hora (dd/MM/aaaa HH:mm)
     * @param diagnostico Diagnóstico formulado
     * @param prescricao  Prescrição ou conduta indicada
     */
    public Consulta(Paciente paciente, Medico medico, String dataHora,
                    String diagnostico, String prescricao) {
        contadorConsultas++;
        this.numeroConsulta = contadorConsultas;
        this.paciente       = paciente;
        this.medico         = medico;
        this.dataHora       = dataHora;
        this.diagnostico    = diagnostico;
        this.prescricao     = prescricao;
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public int     getNumeroConsulta()    { return numeroConsulta; }
    public Paciente getPaciente()         { return paciente; }
    public Medico   getMedico()           { return medico; }
    public String   getDataHora()         { return dataHora; }
    public String   getDiagnostico()      { return diagnostico; }
    public String   getPrescricao()       { return prescricao; }
    public static int getTotalConsultas() { return contadorConsultas; }

    // -------------------------------------------------------------------------
    // Implementação de Registravel
    // -------------------------------------------------------------------------

    @Override
    public void registrar() {
        System.out.println("[CONSULTA #" + numeroConsulta + " REGISTRADA] "
                         + paciente.getNome() + " | Dr. " + medico.getNome()
                         + " | " + dataHora);
    }

    @Override
    public String gerarRelatorio() {
        return  "\n==== RELATÓRIO DE CONSULTA ====" +
                "\nNº Consulta  : " + numeroConsulta +
                "\nPaciente     : " + paciente.getNome() +
                "\n               Prontuário: " + paciente.getNumeroProntuario() +
                "\n               Convênio  : " + paciente.getConvenio() +
                "\nMédico       : Dr(a). " + medico.getNome() +
                "\n               " + medico.getRegistroProfissional() +
                "\n               Especialidade: " + medico.getEspecialidade() +
                "\nData/Hora    : " + dataHora +
                "\nDiagnóstico  : " + diagnostico +
                "\nPrescrição   : " + prescricao +
                "\n================================";
    }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Consulta #" + numeroConsulta + " [" + dataHora + "] - "
             + paciente.getNome() + " | Dr. " + medico.getNome();
    }
}
