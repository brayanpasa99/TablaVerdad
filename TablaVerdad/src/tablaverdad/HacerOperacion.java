/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablaverdad;

/**
 *
 * @author braya
 */
public class HacerOperacion {

    String prueba = "(((p˅q)˄(!q^!p))→p)"; //↔
    int numOperaciones = 0;
    String[] operaciones;
    int[] posParentesis;
    String nueva = "";
    boolean[] p = {true, true, false, false};
    boolean[] q = {true, false, true, false};
    boolean[] np = {false, false, true, true};
    boolean[] nq = {false, true, false, true};
    boolean[] resultado = new boolean[4];

    public HacerOperacion() {

        NotacionPolaca();

    }

    private void NotacionPolaca() {

        int k = 0;

        for (int i = 0; i < prueba.length(); i++) {

            if (prueba.charAt(i) == '(') {

                numOperaciones++;

            }

        }
        
        System.out.println(numOperaciones);

        posParentesis = new int[numOperaciones * 2];

        for (int i = 0; i < prueba.length(); i++) {

            if (prueba.charAt(i) == '(') {

                posParentesis[k] = i;
                k++;

            }

        }

        for (int i = 0; i < prueba.length(); i++) {

            if (prueba.charAt(i) == ')') {

                posParentesis[k] = i;
                k++;

            }

        }

        k = 0;

        int ini = 0;
        int fin = (posParentesis.length) - 1;

        operaciones = new String[numOperaciones];

        for (int i = 0; i < (operaciones.length); i++) {

            operaciones[i] = prueba.substring(posParentesis[ini] + 1, posParentesis[fin]);
            ini++;
            fin--;
        }
     
    }

}
