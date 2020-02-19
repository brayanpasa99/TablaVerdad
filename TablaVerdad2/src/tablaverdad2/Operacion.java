/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablaverdad2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author braya
 */
//OPERADORES: →, ↔, ˄, ˅, ~.
public class Operacion {

    String first_operator;
    String second_operator;
    String operation;
    int contador = 0;
    int contadorColumnas = 0;
    boolean[] firsttable = new boolean[4];
    boolean[] secondtable = new boolean[4];
    boolean[] result = new boolean[4];
    ArrayList<boolean[]> partialresults = new ArrayList<>();

    public void ComprobarPrimerOperador() {
        switch (first_operator) {
            case "p":
                firsttable[0] = true;
                firsttable[1] = true;
                firsttable[2] = false;
                firsttable[3] = false;
                break;
            case "q":
                firsttable[0] = true;
                firsttable[1] = false;
                firsttable[2] = true;
                firsttable[3] = false;
                break;
            case "~p":
                firsttable[0] = false;
                firsttable[1] = false;
                firsttable[2] = true;
                firsttable[3] = true;
                break;
            case "~q":
                firsttable[0] = false;
                firsttable[1] = true;
                firsttable[2] = false;
                firsttable[3] = true;
                break;
            case "ANS":
                firsttable[0] = result[0];
                firsttable[1] = result[1];
                firsttable[2] = result[2];
                firsttable[3] = result[3];
                break;
            default:
                System.out.println("Empiece con una expresión simple.");
                break;
        }

        System.out.print("Primer operador: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(firsttable[i] + " ");
        }
        System.out.println("");
    }

    public void ComprobarSegundoOperador() {
        switch (second_operator) {
            case "p":
                secondtable[0] = true;
                secondtable[1] = true;
                secondtable[2] = false;
                secondtable[3] = false;
                break;
            case "q":
                secondtable[0] = true;
                secondtable[1] = false;
                secondtable[2] = true;
                secondtable[3] = false;
                break;
            case "~p":
                secondtable[0] = false;
                secondtable[1] = false;
                secondtable[2] = true;
                secondtable[3] = true;
                break;
            case "~q":
                secondtable[0] = false;
                secondtable[1] = true;
                secondtable[2] = false;
                secondtable[3] = true;
                break;
            case "ANS":
                secondtable[0] = result[0];
                secondtable[1] = result[1];
                secondtable[2] = result[2];
                secondtable[3] = result[3];
                break;
            default:
                System.out.println("El segundo operador también debe ser una expresión simple.");
                break;
        }

        System.out.print("Segundo operador: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(secondtable[i] + " ");
        }
        System.out.println("");
    }

    public void Operar() {
        switch (operation) {
            case "↔":
                for (int i = 0; i < 4; i++) {
                    result[i] = bicondicional(i);
                }
                break;
            case "→":
                for (int i = 0; i < 4; i++) {
                    result[i] = condicional(i);
                }
                break;
            case "˄":
                for (int i = 0; i < 4; i++) {
                    result[i] = conjuncion(i);
                }
                break;
            case "˅":
                for (int i = 0; i < 4; i++) {
                    result[i] = disyuncion(i);
                }
                break;
            default:
                break;
        }
    }

    private boolean bicondicional(int i) {

        boolean[] resultaux1 = new boolean[4];
        boolean[] resultaux2 = new boolean[4];
        resultaux1[i] = !firsttable[i] || secondtable[i];
        resultaux2[i] = !secondtable[i] || firsttable[i];
        result[i] = resultaux1[i] && resultaux2[i];

        return result[i];

    }

    private boolean condicional(int i) {

        result[i] = !firsttable[i] || secondtable[i];

        return result[i];

    }

    private boolean conjuncion(int i) {

        result[i] = firsttable[i] && secondtable[i];

        return result[i];

    }

    private boolean disyuncion(int i) {

        result[i] = firsttable[i] || secondtable[i];

        return result[i];

    }

    public void saveResult(int j) {

        /*boolean[] auxresult;
        auxresult = result;*/
        partialresults.add(j, result);
        /*auxresult[0] = false;
        auxresult[1] = false;
        auxresult[2] = false;
        auxresult[3] = false;*/

        showPartialResults();

    }

    public boolean[] getResult() {
        
        boolean[] resultlocal;    
        resultlocal = result.clone();
        
        return resultlocal;
        
    }
    
    public ArrayList<boolean[]> getList() {

        return partialresults;    
        
    }

    public void showPartialResults() {

        for (int i = 0; i < partialresults.size(); i++) {

            System.out.println(Arrays.toString(partialresults.get(i)));

        }

    }

}
