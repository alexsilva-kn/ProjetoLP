package model;

import java.io.Serializable;

public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String crm;
    private String especialidade;

    public Medico(String nome, String especialidade, String crm) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Medicos cadastrados:\n" +
                "Nome : " + nome + '\n' +
                "Especialidade : " + especialidade + '\n' +
                "CRM : " + crm;
    }
}