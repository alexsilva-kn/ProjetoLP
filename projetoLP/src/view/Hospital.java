package view;

import arquivos.Persistencia;
import java.io.Serializable;
import java.time.LocalDate;

import controller.GerenciadorPaciente;
import controller.GerenciadorMedico;
import controller.GerenciadorInternacao;
import controller.GerenciadorPagamento;

import model.Paciente;
import model.Medico;
import model.Internacao;
import model.Pagamento;
import model.TipoInternacao;
import model.FormaPagamento;

public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Persistencia<Hospital> persistencia = new Persistencia<>();

    private GerenciadorPaciente gerenciadorPaciente;
    private GerenciadorMedico gerenciadorMedico;
    private GerenciadorInternacao gerenciadorInternacao;
    private GerenciadorPagamento gerenciadorPagamento;

    public Hospital() {
        this.gerenciadorPaciente = new GerenciadorPaciente();
        this.gerenciadorMedico = new GerenciadorMedico();
        this.gerenciadorInternacao = new GerenciadorInternacao();
        this.gerenciadorPagamento = new GerenciadorPagamento();
    }

    // --- MÉTODOS DE PACIENTE E MÉDICO ---
    public boolean cadastrarPaciente(String nome, String cpf, int idade) {
        return gerenciadorPaciente.cadastrarPaciente(new Paciente(nome, cpf, idade));
    }

    public void listarPacientes() {
        for (Paciente p : gerenciadorPaciente.listarPacientes()) System.out.println(p);
    }

    public boolean cadastrarMedico(String nome, String crm) {
        return gerenciadorMedico.cadastrarMedico(new Medico(nome, crm));
    }

    public void listarMedicos() {
        for (Medico m : gerenciadorMedico.listarMedicos()) System.out.println(m);
    }

    public void registrarInternacao(String cpfPaciente, String crmMedico, TipoInternacao tipo, String local) {
        Paciente paciente = gerenciadorPaciente.buscarPaciente(cpfPaciente);
        Medico medico = gerenciadorMedico.buscarMedico(crmMedico);

        if (paciente != null && medico != null) {
            Internacao internacao = new Internacao(paciente, medico, tipo, local, LocalDate.now());

            gerenciadorInternacao.cadastrar(internacao);
        } else {
            System.out.println("Erro: Paciente ou Médico não encontrado.");
        }
    }

    public void listarInternacoes() {
        for (Internacao i : gerenciadorInternacao.listarAtivas()) {
            System.out.println(i);
        }
    }
    public void registrarPagamento(String idInternacao, FormaPagamento forma) {
        Internacao internacao = null;

        try {
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarPagamentos() {
        gerenciadorPagamento.gerarRelatorio();
        System.out.println("Relatório atualizado em 'relatorio.txt'.");
    }

    public void salvarHospital(String nomeArquivo) {
        persistencia.salvarEmArquivo(this, nomeArquivo);
    }

    public static Hospital carregarHospital(String nomeArquivo) {
        return persistencia.carregarDeArquivo(nomeArquivo);
    }
}