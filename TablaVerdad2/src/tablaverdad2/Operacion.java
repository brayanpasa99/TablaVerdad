/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablaverdad2;

/**
 *
 * @author braya
 */
//OPERADORES: →, ↔, ˄, ˅, ~.
public class Operacion {

    String first_operator = "~p";
    String second_operator = "~q";
    String operation = "↔";
    int contador = 0;
    int contadorColumnas = 0;
    boolean[] firsttable = new boolean[4];
    boolean[] secondtable = new boolean[4];
    boolean[] result = new boolean[4];
    
    public void ComprobarPrimerOperador(){
        if (first_operator.equals("p")) {
            firsttable[0] = true;
            firsttable[1] = true;
            firsttable[2] = false;
            firsttable[3] = false;
        } else if (first_operator.equals("q")) {
            firsttable[0] = true;
            firsttable[1] = false;
            firsttable[2] = true;
            firsttable[3] = false;
        } else if (first_operator.equals("~p")) {
            firsttable[0] = false;
            firsttable[1] = false;
            firsttable[2] = true;
            firsttable[3] = true;
        } else if (first_operator.equals("~q")) {
            firsttable[0] = false;
            firsttable[1] = true;
            firsttable[2] = false;
            firsttable[3] = true;
        }
        else if (first_operator.equals("ANS")){
            firsttable[0] = result[0];
            firsttable[1] = result[1];
            firsttable[2] = result[2];
            firsttable[3] = result[3];
        } else {
            System.out.println("Empiece con una expresión simple.");
        }
        
        System.out.print("Primer operador: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(firsttable[i] + " ");
        }
        System.out.println("");
    }
    
    public void ComprobarSegundoOperador(){
        if (second_operator.equals("p")) {
            secondtable[0] = true;
            secondtable[1] = true;
            secondtable[2] = false;
            secondtable[3] = false;
        } else if (second_operator.equals("q")) {
            secondtable[0] = true;
            secondtable[1] = false;
            secondtable[2] = true;
            secondtable[3] = false;
        } else if (second_operator.equals("~p")) {
            secondtable[0] = false;
            secondtable[1] = false;
            secondtable[2] = true;
            secondtable[3] = true;
        } else if (second_operator.equals("~q")) {
            secondtable[0] = false;
            secondtable[1] = true;
            secondtable[2] = false;
            secondtable[3] = true;
        } else if (second_operator.equals("ANS")){
            secondtable[0] = result[0];
            secondtable[1] = result[1];
            secondtable[2] = result[2];
            secondtable[3] = result[3];
        }else {
            System.out.println("El segundo operador también debe ser una expresión simple.");
        }
        
        System.out.print("Segundo operador: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(secondtable[i] + " ");
        }
        System.out.println("");
    }
    
    public void Operar(){
        if (operation.equals("↔")) {
            for (int i = 0; i < 4; i++) {
                bicondicional(i);
            }
        } else if (operation.equals("→")) {
            for (int i = 0; i < 4; i++) {
                condicional(i);
            }
        } else if (operation.equals("˄")) {
            for (int i = 0; i < 4; i++) {
                conjuncion(i);
            }
        } else if (operation.equals("˅")) {
            for (int i = 0; i < 4; i++) {
                disyuncion(i);
            }
        }
    };
    
    private boolean[] bicondicional(int i) {

        boolean[] resultaux1 = new boolean[4];
        boolean[] resultaux2 = new boolean[4];
        resultaux1[i] = !firsttable[i] || secondtable[i];
        resultaux2[i] = !secondtable[i] || firsttable[i];
        result[i] = resultaux1[i] && resultaux2[i];

        return result;

    }

    private boolean[] condicional(int i) {

        result[i] = !firsttable[i] || secondtable[i];

        return result;

    }

    private boolean[] conjuncion(int i) {

        result[i] = firsttable[i] && secondtable[i];

        return result;

    }

    private boolean[] disyuncion(int i) {

        result[i] = firsttable[i] || secondtable[i];

        return result;

    }

}
