import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Internacao {
    private String id;
    private Paciente paciente;
    private Medico medico;
    private TipoInternacao tipo;
    private LocalDate entrada;
    private LocalDate alta;

    public Internacao(Paciente paciente, Medico medico, TipoInternacao tipo, LocalDate entrada, LocalDate alta) {
        this.id = UUID.randomUUID().toString();
        this.paciente = paciente;
        this.medico = medico;
        this.tipo = tipo;
        this.entrada = entrada;
        this.alta = alta;
    }
    public String getId() {
        return id;
    }
    public void darAlta(LocalDate alta) {
        this.alta = alta;
    }
    public boolean isAtiva() {
        return alta == null;
    }
    public double calcularValor(){
        long dias = ChronoUnit.DAYS.between(entrada, alta);

        double diaria = switch (tipo) {
            case ENFERMARIA -> 300;
            case APARTAMENTO -> 800;
            case UTI -> 2500;
        };

        double total = dias * diaria;
        return total * paciente.getPlano().getPercentualPagamento();
    }
}
