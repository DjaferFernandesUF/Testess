package cinefilos;


import cinefilos.bancoDeDados.BancoDeGerentes;

import java.io.*;

public class Teste {
    public static void main (String[] args) throws FileNotFoundException {
        Gerente gerente = new Gerente("senhaLinda");
        BancoDeGerentes gerentes = new BancoDeGerentes();
        gerentes.adicionarGerente(gerente);
    }
}
