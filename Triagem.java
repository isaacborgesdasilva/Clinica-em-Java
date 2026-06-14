/**
 * Representa uma triagem de risco realizada por um enfermeiro.
 * Implementa Registravel e aplica a Escala de Manchester simplificada
 * para classificar a urgência do paciente.
 */
public class Triagem implements Registravel {

    // Referências aos envolvidos
    private Paciente   paciente;
    private Enfermeiro enfermeiro;

    // Sinais vitais
    private double pressaoSistolica;   // mmHg
    private double pressaoDiastolica;  // mmHg
    private double temperatura;        // °C
    private double peso;               // kg
    private double altura;             // m

    // Dados do registro
    private String dataHora;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Cria um registro de triagem com sinais vitais do paciente.
     */
    public Triagem(Paciente paciente, Enfermeiro enfermeiro, String dataHora,
                   double pressaoSistolica, double pressaoDiastolica,
                   double temperatura, double peso, double altura) {
        this.paciente           = paciente;
        this.enfermeiro         = enfermeiro;
        this.dataHora           = dataHora;
        this.pressaoSistolica   = pressaoSistolica;
        this.pressaoDiastolica  = pressaoDiastolica;
        this.temperatura        = temperatura;
        this.peso               = peso;
        this.altura             = altura;
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public Paciente   getPaciente()          { return paciente; }
    public Enfermeiro getEnfermeiro()        { return enfermeiro; }
    public String     getDataHora()          { return dataHora; }
    public double     getPressaoSistolica()  { return pressaoSistolica; }
    public double     getPressaoDiastolica() { return pressaoDiastolica; }
    public double     getTemperatura()       { return temperatura; }
    public double     getPeso()              { return peso; }
    public double     getAltura()            { return altura; }

    // -------------------------------------------------------------------------
    // Lógica de classificação de risco (Escala de Manchester simplificada)
    // -------------------------------------------------------------------------

    /**
     * Classifica o risco do paciente com base nos sinais vitais.
     * Retorna uma das cores da Escala de Manchester:
     * VERMELHO (Emergência), LARANJA (Muito Urgente),
     * AMARELO (Urgente), VERDE (Pouco Urgente), AZUL (Não Urgente).
     *
     * @return String com a classificação de risco
     */
    public String classificarRisco() {
        // Critérios simplificados de triagem
        boolean temperaturaAlta    = temperatura >= 39.0;
        boolean temperaturaMuiAlta = temperatura >= 40.5;
        boolean hipertensao        = pressaoSistolica >= 180 || pressaoDiastolica >= 120;
        boolean hipotensao         = pressaoSistolica < 90;
        double  imc                = peso / (altura * altura);

        if (temperaturaMuiAlta || hipertensao || hipotensao) {
            return "🔴 VERMELHO - Emergência (atendimento imediato)";
        } else if (temperaturaAlta && (pressaoSistolica >= 160 || pressaoDiastolica >= 100)) {
            return "🟠 LARANJA  - Muito Urgente (até 10 minutos)";
        } else if (temperaturaAlta || pressaoSistolica >= 140) {
            return "🟡 AMARELO  - Urgente (até 30 minutos)";
        } else if (imc < 18.5 || imc > 30.0) {
            return "🟢 VERDE    - Pouco Urgente (até 60 minutos)";
        } else {
            return "🔵 AZUL     - Não Urgente (até 120 minutos)";
        }
    }

    /**
     * Calcula e retorna o IMC do paciente.
     * @return IMC formatado com 2 casas decimais
     */
    public double calcularIMC() {
        return Math.round((peso / (altura * altura)) * 100.0) / 100.0;
    }

    // -------------------------------------------------------------------------
    // Implementação de Registravel
    // -------------------------------------------------------------------------

    @Override
    public void registrar() {
        System.out.println("[TRIAGEM REGISTRADA] " + paciente.getNome()
                         + " em " + dataHora + " por " + enfermeiro.getNome()
                         + " | Risco: " + classificarRisco());
    }

    @Override
    public String gerarRelatorio() {
        return  "\n---- RELATÓRIO DE TRIAGEM ----" +
                "\nPaciente    : " + paciente.getNome() +
                "\nEnfermeiro  : " + enfermeiro.getNome() + " (" + enfermeiro.getRegistroProfissional() + ")" +
                "\nData/Hora   : " + dataHora +
                "\nPressão     : " + pressaoSistolica + "/" + pressaoDiastolica + " mmHg" +
                "\nTemperatura : " + temperatura + " °C" +
                "\nPeso/Altura : " + peso + " kg / " + altura + " m" +
                "\nIMC         : " + calcularIMC() +
                "\nClassif.    : " + classificarRisco() +
                "\n------------------------------";
    }

    // -------------------------------------------------------------------------
    // toString
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Triagem [" + dataHora + "] - " + paciente.getNome()
             + " | " + classificarRisco();
    }
}
