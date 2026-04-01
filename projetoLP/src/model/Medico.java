package model;

import java.io.Serializable;

public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String crm;

    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Medico:\n" +
                "Nome : " + nome + '\n' +
                "CRM : " + crm;
    }
}