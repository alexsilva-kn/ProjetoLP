package model;

import java.io.Serializable;

public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private int idade;
    private PlanoSaude plano;

    public Paciente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.plano = null;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public PlanoSaude getPlano() {
        return plano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPlano(PlanoSaude plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", plano=" + (plano != null ? plano : "Particular") +
                '}';
    }
}