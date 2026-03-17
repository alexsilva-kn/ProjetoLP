public class Medico {
    private String nome;
    private String crm;
    private Especialidade especialidade;
    private boolean ativo;

    public Medico(String nome, String crm, Especialidade especialidade, boolean ativo){
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.ativo = ativo;
    }

    public String getCrm() {
        return crm;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void desativar(){
        this.ativo = false;
    }
    public String toString(){
        return nome + " - " + crm;
    }
}
