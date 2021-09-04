package com.company;

import java.util.ArrayList;

public class Transicao {
    private String label;
    private ArrayList<Arco> entradas = new ArrayList<Arco>();
    private ArrayList<Arco> saidas = new ArrayList<Arco>();

    public Transicao(String label) {
        this.label = label;
    }

    public Transicao() {

    }

    public void adicionaEntrada(Arco a) {
        entradas.add(a);
    }

    public void adicionaSaida(Arco a) {
        saidas.add(a);
    }

    public void executar() {
        boolean permitida = true;
        for (Arco entrada : entradas) {
            if (!entrada.isValido()) {
                permitida = false;
                break;
            }
        }
        if (permitida) {
            for (Arco entrada : entradas) {
                entrada.executar();
            }
            for (Arco saida : saidas) {
                saida.executar();
            }
        }
    }

    public String getLabel(){
        return label;
    }

}
