package com.company;

public class Arco {
    private int peso;
    private Object origem;
    private Object destino;

    public Arco(int peso, Object origem, Object destino) {
        this.peso = peso;
        this.origem = origem;
        this.destino = destino;
    }

    public boolean isValido() {
        if (origem instanceof Lugar) {
            if (((Lugar) origem).getQuantidadeMarcas() >= peso) {
                return true;
            }
        }
        return false;
    }

    public void executar() {
        if (origem instanceof Lugar) {
            if (((Lugar) origem).getQuantidadeMarcas() >= peso) {
                ((Lugar) origem).removeMarcas(peso);
            }
        }
        if (origem instanceof Transicao && destino instanceof Lugar) {
            ((Lugar) destino).adicionaMarcas(peso);
        }
    }
}
