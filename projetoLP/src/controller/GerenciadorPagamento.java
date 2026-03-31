package controller;
import model.FormaPagamento;
import model.Internacao;
import model.Pagamento;

import java.util.*;
import java.io.*;

public class GerenciadorPagamento {

    private List<Pagamento> pagamentos = new ArrayList<>();

    public void pagar(Internacao i, FormaPagamento forma) {

        if (i.isAtiva())
            throw new RuntimeException("Internação não finalizada");

        pagamentos.add(new Pagamento(i, forma));
    }

    public void gerarRelatorio() {

        double total = 0;

        try {
            PrintWriter w = new PrintWriter(new FileWriter("relatorio.txt"));

            for (Pagamento p : pagamentos) {

                Internacao i = p.getInternacao();

                w.println("ID: " + i.getId());
                w.println("CPF: " + i.getPaciente().getCpf());
                w.println("Entrada: " + i.getEntrada());
                w.println("Alta: " + i.getAlta());
                w.println("Valor: " + p.getValorPago());
                w.println("----------------");

                total += p.getValorPago();
            }

            w.println("TOTAL: " + total);
            w.close();

        } catch (Exception e) {
            System.out.println("Erro ao gerar relatório");
        }
    }
}