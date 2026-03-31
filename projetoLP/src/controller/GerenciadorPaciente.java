package controller;

import java.io.Serializable;
import java.util.ArrayList;
import model.Paciente;

public class GerenciadorPaciente implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Paciente> pacientes;

    public GerenciadorPaciente() {
        this.pacientes = new ArrayList<>();
    }

    public boolean cadastrarPaciente(Paciente paciente) {
        if (buscarPaciente(paciente.getCpf()) != null) {
            return false;
        }
        pacientes.add(paciente);
        return true;
    }

    public Paciente buscarPaciente(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public boolean atualizarPaciente(String cpf, String nome, int idade) {
        Paciente paciente = buscarPaciente(cpf);

        if (paciente != null) {
            paciente.setNome(nome);
            paciente.setIdade(idade);
            return true;
        }

        return false;
    }

    public ArrayList<Paciente> listarPacientes() {
        return pacientes;
    }
}