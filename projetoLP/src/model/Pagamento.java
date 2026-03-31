package model;

import java.io.Serializable;

public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private Internacao internacao;
    private FormaPagamento formaPagamento;
    private double valorPago;

    public Pagamento(Internacao internacao, FormaPagamento formaPagamento) {
        this.internacao = internacao;
        this.formaPagamento = formaPagamento;
        this.valorPago = internacao.calcularValor();
    }

    public Internacao getInternacao() {
        return internacao;
    }

    public double getValorPago() {
        return valorPago;
    }

    @Override
    public String toString() {
        return "Pagamento [Internação ID=" + internacao.getId() +
                ", Forma=" + formaPagamento +
                ", Valor Pago=" + valorPago + "]";
    }
}