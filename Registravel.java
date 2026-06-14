/**
 * Interface que define o contrato para registros clínicos
 * (consultas, triagens, etc.) dentro do sistema.
 */
public interface Registravel {

    /**
     * Registra o evento clínico no sistema,
     * exibindo uma confirmação no console.
     */
    void registrar();

    /**
     * Gera um relatório textual completo do evento clínico.
     * @return String formatada com os dados do registro
     */
    String gerarRelatorio();
}
