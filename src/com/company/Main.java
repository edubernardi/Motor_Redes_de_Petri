package com.company;

public class Main {

    public static void main(String[] args) {
        Rede r = new Rede();
        /*
        r.adicionaLugar("L1", 5);
        r.adicionaLugar("L2");
        r.adicionaLugar("L3" );

        r.adicionaTransicao("T1");
        r.adicionaTransicao("T2");

        r.adicionaConexao("L1","T1",2);
        r.adicionaConexao("T1","L2",3);
        r.adicionaConexao("L2","T2",5);
        r.adicionaConexao("T2","L3",1);

        r.executar(3);*/

        r.adicionaLugar("L1", 1);
        r.adicionaTransicao("T1");
        r.adicionaConexao("L1", "T1");

        r.adicionaLugar("L2");
        r.adicionaConexao("T1", "L2");

        r.adicionaTransicao("T2");
        r.adicionaConexao("L1", "T2");

        r.adicionaLugar("L3");
        r.adicionaConexao("T2", "L3");

        r.executar(3);
    }
}

