package com.company;

public class Lugar {
    private String label;
    private int quantidadeMarcas;
    private int tempMarcas;

    public Lugar(String label) {
        this.label = label;
        this.quantidadeMarcas = 0;
        this.tempMarcas = 0;
    }

    public Lugar(int quantidadeMarcas, String label) {
        this.label = label;
        this.quantidadeMarcas = quantidadeMarcas;
        this.tempMarcas = 0;
    }

    public void adicionaMarca() {
        quantidadeMarcas++;
    }

    public void adicionaMarcas(int i) {
        tempMarcas += i;
    }

    public void removeMarca() {
        quantidadeMarcas--;
        if (quantidadeMarcas < 0) {
            System.out.println("Erro, marcas negativos em lugar");
        }
    }

    public void removeMarcas(int i) {
        quantidadeMarcas -= i;
        if (quantidadeMarcas < 0) {
            System.out.println("Erro, marcas negativos em lugar");
        }
    }

    public int getQuantidadeMarcas() {
        return quantidadeMarcas;
    }

    public void setQuantidadeMarcas(int quantidadeMarcas) {
        this.quantidadeMarcas = quantidadeMarcas;
    }

    public String getLabel() {
        return label;
    }

    //Carrega marcas de tempMarcas para quantidadeMarcas e zera tempMarcas
    public void carregaMarcas(){
        quantidadeMarcas += tempMarcas;
        tempMarcas = 0;
    }
}
