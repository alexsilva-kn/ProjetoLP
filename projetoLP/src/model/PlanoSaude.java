package model;

public class PlanoSaude {
    private String operadora;
    private TipoInternacao tipoPermitido;
    private double percentualPagamento;

    public PlanoSaude(String operadora, TipoInternacao tipoPermitido, double percentualPagamento) {
        this.operadora = operadora;
        this.tipoPermitido = tipoPermitido;
        this.percentualPagamento = percentualPagamento;
    }

    public double getPercentualPagamento() {
        return percentualPagamento;
    }

    public TipoInternacao getTipoPermitido() {
        return tipoPermitido;
    }
}