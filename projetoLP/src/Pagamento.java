public class Pagamento {
    private Internacao internacao;
    private FormaPagamento forma;
    private double valorPago;

    public Pagamento(Internacao internacao, FormaPagamento forma) {
        this.internacao = internacao;
        this.forma = forma;

        double valorBase = internacao.calcularValor();

        switch (forma) {
            case PIX:
            case DINHEIRO:
                valorPago = valorBase * 0.9;
                break;
            case PARCELADO:
                valorPago = valorBase * 1.08;
                break;
            case CARTAO:
                valorPago = valorBase;
                break;
        }
    }

    public double getValorPago() {
        return valorPago;
    }
}