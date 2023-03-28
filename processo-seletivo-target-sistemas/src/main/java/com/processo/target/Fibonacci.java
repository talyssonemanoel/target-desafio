//Desenvolvido por: Talysson Emanoel Medeiros da Costa
package com.processo.target;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = input.nextInt();
        int fib1 = 0, fib2 = 1, fib = 0;
        boolean pertence = false;
        while (fib <= numero) {
            if (numero == fib) {
                pertence = true;
                break;
            }
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        if (pertence) {
            System.out.println(numero + " pertence à sequência de Fibonacci");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci");
        }
    }
}
