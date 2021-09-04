package com.company;

import java.util.ArrayList;

public class Rede {
    private ArrayList<Lugar> lugares = new ArrayList<Lugar>();
    private ArrayList<Transicao> transicoes = new ArrayList<Transicao>();

    public Rede() {
    }

    public void adicionaLugar(Lugar l) {
        lugares.add(l);
    }

    public void adicionaLugar(String label, int quantidadeMarcas){
        lugares.add(new Lugar(quantidadeMarcas, label));
    }

    public void adicionaLugar(String label){
        lugares.add(new Lugar(0, label));
    }

    public void adicionaTransicao(Transicao t) {
        transicoes.add(t);
    }

    public void adicionaTransicao(String label){
        transicoes.add(new Transicao(label));
    }

    public void mostraLugares() {
        int i = 0;
        for (Lugar lugar : lugares) {
            System.out.println("    Lugar " + lugar.getLabel() + ": " + lugar.getQuantidadeMarcas() + " marcas");
            i++;
        }
    }

    public void adicionaConexao(String origemLabel, String destinoLabel){
        Object origem = null;
        Object destino = null;
        for (Lugar l: lugares){
            if (origemLabel.equals(l.getLabel())){
                origem = l;
            } else if (destinoLabel.equals(l.getLabel())){
                destino = l;
            }
        }

        for (Transicao t: transicoes){
            if (origemLabel.equals(t.getLabel())){
                origem = t;
                if (destino != null){
                    Arco a = new Arco(1, origem, destino);
                    t.adicionaSaida(a);
                    return;
                }
            } else if (destinoLabel.equals(t.getLabel())){
                destino = t;
                if (origem != null){
                    Arco a = new Arco(1, origem, destino);
                    t.adicionaEntrada(a);
                    return;
                }
            }
        }
        System.out.println("Erro ao gerar conexao"  + " " + origemLabel + " " + destinoLabel);
    }

    public void adicionaConexao(String origemLabel, String destinoLabel, int peso){
        Object origem = null;
        Object destino = null;
        for (Lugar l: lugares){
            if (origemLabel.equals(l.getLabel())){
                origem = l;
            } else if (destinoLabel.equals(l.getLabel())){
                destino = l;
            }
        }

        for (Transicao t: transicoes){
            if (origemLabel.equals(t.getLabel())){
                origem = t;
                if (destino != null){
                    Arco a = new Arco(peso, origem, destino);
                    t.adicionaSaida(a);
                    return;
                }
            } else if (destinoLabel.equals(t.getLabel())){
                destino = t;
                if (origem != null){
                    Arco a = new Arco(peso, origem, destino);
                    t.adicionaEntrada(a);
                    return;
                }
            }
        }
        System.out.println("Erro ao gerar conexao"  + " " + origemLabel + " " + destinoLabel);
    }

    public void executar(int ciclos) {
        Teclado tec = new Teclado();
        for (int i = 0; i < ciclos + 1; i++) {
            System.out.println("Ciclo: " + i);
            mostraLugares();

            for (Transicao t : transicoes) {
                t.executar();
            }

            for (Lugar l: lugares){
                l.carregaMarcas();
            }

            if (i == ciclos){
                System.out.println("Fim da simulação");
            } else {
                tec.leString("Aperte ENTER para continuar...");
            }
        }
    }
}
