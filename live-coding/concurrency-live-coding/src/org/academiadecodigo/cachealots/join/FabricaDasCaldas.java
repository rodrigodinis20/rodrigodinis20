package org.academiadecodigo.cachealots.join;

public class FabricaDasCaldas {

    public static void main(String[] args) {

        Thread trabalhador = new Thread(new TrabalhadorDasCaldas());
        trabalhador.start();

        try {

            System.out.println("GERENTE: À espera que estes colaboradores acabem ...");
            trabalhador.join();
            System.out.println("GERENTE: Finalmente acabaram, vou para casa!!!!!!!!!!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
