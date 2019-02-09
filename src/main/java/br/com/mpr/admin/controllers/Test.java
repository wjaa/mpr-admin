package br.com.mpr.admin.controllers;

/**
 * Created by wagner on 07/02/19.
 */
public class Test {

    public static void main(String args []){
        for (int i =0; i <= 10; i +=2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Olá Fernanda vc é nota " + i);
        }
    }

}
