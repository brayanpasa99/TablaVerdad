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
    boolean[] firsttable = new boolean[4];
    boolean[] secondtable = new boolean[4];
    boolean[] result = new boolean[4];

    public Operacion() {

        if (first_operator.equals("p") || first_operator.equals("q")) {

            firsttable[0] = true;
            firsttable[1] = true;
            firsttable[2] = false;
            firsttable[3] = false;

        } else if (first_operator.equals("~p") || first_operator.equals("~q")) {

            firsttable[0] = false;
            firsttable[1] = false;
            firsttable[2] = true;
            firsttable[3] = true;

        } else {

            System.out.println("Empiece con una expresión simple.");

        }

        if (first_operator.equals("p") || first_operator.equals("q")) {

            secondtable[0] = true;
            secondtable[1] = false;
            secondtable[2] = true;
            secondtable[3] = false;

        } else if (first_operator.equals("~p") || first_operator.equals("~q")) {

            secondtable[0] = false;
            secondtable[1] = true;
            secondtable[2] = false;
            secondtable[3] = true;

        } else {

            System.out.println("El segundo operador también debe ser una expresión simple.");

        }
        //operation.equals("~")
        if (operation.equals("↔")) {

            for (int i = 0; i < 4; i++) {

                bicondicional(i);

            }

            /*|| ||  || operation.equals("→") || 
                }){*/
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

    }

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
