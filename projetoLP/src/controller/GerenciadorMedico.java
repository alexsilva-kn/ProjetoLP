package controller;

import java.io.Serializable;
import java.util.ArrayList;
import model.Medico;

public class GerenciadorMedico implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Medico> medicos;

    public GerenciadorMedico() {
        this.medicos = new ArrayList<>();
    }

    public boolean cadastrarMedico(Medico medico) {
        if (buscarMedico(medico.getCrm()) != null) {
            return false;
        }
        medicos.add(medico);
        return true;
    }

    public Medico buscarMedico(String crm) {
        for (Medico m : medicos) {
            if (m.getCrm().equals(crm)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Medico> listarMedicos() {
        return medicos;
    }
}