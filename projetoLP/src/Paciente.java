public class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private PlanoSaude plano;

    public Paciente(String nome, String cpf, String telefone, PlanoSaude plano) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.plano = plano;
    }
    public String getCpf() {
        return cpf;
    }

    public PlanoSaude getPlano() {
        return plano;
    }
    public void setPlano(PlanoSaude plano) {
        this.plano = plano;
    }
    public String toString() {
        return nome + " - cpf: " + cpf;
    }
}
