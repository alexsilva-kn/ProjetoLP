package controller;
import model.Internacao;

import java.time.LocalDate;
import java.util.*;

public class GerenciadorInternacao {

    private Map<String, Internacao> internacoes = new HashMap<>();

    public String cadastrar(Internacao i) {
        internacoes.put(i.getId(), i);
        return i.getId();
    }

    public void darAlta(String id, LocalDate dataAlta) {
        Internacao i = internacoes.get(id);

        if (i == null) {
            throw new RuntimeException("Internação não encontrada");
        }

        i.darAlta(dataAlta);
    }

    public double calcular(String id) {
        Internacao i = internacoes.get(id);

        if (i == null) {
            throw new RuntimeException("Internação não encontrada");
        }

        return i.calcularValor();
    }

    public List<Internacao> buscarPorCpf(String cpf) {

        List<Internacao> lista = new ArrayList<>();

        for (Internacao i : internacoes.values()) {
            if (i.getPaciente().getCpf().equals(cpf)) {
                lista.add(i);
            }
        }

        return lista;
    }

    public List<Internacao> listarAtivas() {

        List<Internacao> lista = new ArrayList<>();

        for (Internacao i : internacoes.values()) {
            if (i.isAtiva()) {
                lista.add(i);
            }
        }

        return lista;
    }
    public Internacao buscarInternacaoPorId(String id) {
        return internacoes.get(id);
    }
}