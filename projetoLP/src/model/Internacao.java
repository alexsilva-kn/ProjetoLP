package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Internacao implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private Paciente paciente;
    private Medico medico;
    private TipoInternacao tipo;
    private String local;
    private LocalDate entrada;
    private LocalDate alta;

    public Internacao(Paciente paciente, Medico medico, TipoInternacao tipo, String local, LocalDate entrada) {

        if (!planoPermite(paciente, tipo)) {
            throw new RuntimeException("Plano não permite esse tipo de internação");
        }

        this.id = UUID.randomUUID().toString();
        this.paciente = paciente;
        this.medico = medico;
        this.tipo = tipo;
        this.local = local;
        this.entrada = entrada;
    }

    private boolean planoPermite(Paciente p, TipoInternacao tipo) {

        if (p.getPlano() == null) return true;

        TipoInternacao permitido = p.getPlano().getTipoPermitido();

        if (permitido == TipoInternacao.APARTAMENTO) return true;

        if (permitido == TipoInternacao.ENFERMARIA) {
            return tipo == TipoInternacao.ENFERMARIA || tipo == TipoInternacao.UTI;
        }

        return true;
    }

    public void darAlta(LocalDate alta) {
        this.alta = alta;
    }

    public boolean isAtiva() {
        return alta == null;
    }

    public double calcularValor() {

        if (alta == null) return 0;

        long dias = ChronoUnit.DAYS.between(entrada, alta);

        double diaria = switch (tipo) {
            case ENFERMARIA -> 300;
            case APARTAMENTO -> 800;
            case UTI -> 2500;
        };

        double total = dias * diaria;

        double percentual = 1.0;

        if (paciente.getPlano() != null) {
            percentual = paciente.getPlano().getPercentualPagamento();
        }

        return total * percentual;
    }


    public String getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public TipoInternacao getTipo() {
        return tipo;
    }

    public String getLocal() {
        return local;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public LocalDate getAlta() {
        return alta;
    }


    @Override
    public String toString() {
        return "Internacao{" +
                "id='" + id + '\'' +
                ", paciente=" + paciente.getNome() +
                ", medico=" + medico.getNome() +
                ", tipo=" + tipo +
                ", local='" + local + '\'' +
                ", entrada=" + entrada +
                ", alta=" + alta +
                '}';
    }
}