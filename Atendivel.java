/**
 * Interface que define o contrato para profissionais de saúde
 * */
public interface Atendivel {

    /**
     * Realiza o atendimento de um paciente.
     * @param paciente O paciente a ser atendido
     */
    void realizarAtendimento(Paciente paciente);

    /**
     * Retorna o número do registro profissional (CRM ou COREN).
     * @return Número do registro profissional
     */
    String getRegistroProfissional();
}
