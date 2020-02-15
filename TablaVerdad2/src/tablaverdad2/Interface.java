/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablaverdad2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author braya
 */
public class Interface extends JFrame implements ActionListener {

    JLabel lbFirst_operator = new JLabel("Ingrese el primer operando:");
    JLabel lbSecond_operator = new JLabel("Ingrese el segundo operando:");
    JLabel lbOperator = new JLabel("Ingrese el operador:");

    JComboBox cbOperator = new JComboBox();
    JComboBox cbFirst_operator = new JComboBox();
    JComboBox cbSecond_operator = new JComboBox();

    JButton sentdata = new JButton("Enviar los datos");
    JButton saveresult = new JButton("Guardar resultado");

    Operacion Operacion = new Operacion();

    JTable tbResultados;

    DefaultTableModel model = new DefaultTableModel();

    public Interface() {

        JFrame Cuadro = new JFrame();

        Cuadro.setBounds(10, 10, 600, 300);
        Cuadro.setTitle("Tablas de verdad");
        lbFirst_operator.setBounds(20, 20, 200, 20);
        lbSecond_operator.setBounds(380, 20, 200, 20);
        lbOperator.setBounds(220, 20, 150, 20);

        cbFirst_operator.setBounds(70, 50, 50, 20);
        cbFirst_operator.addItem("p");
        cbFirst_operator.addItem("q");
        cbFirst_operator.addItem("~p");
        cbFirst_operator.addItem("~q");
        cbFirst_operator.addItem("ANS");

        cbSecond_operator.setBounds(440, 50, 50, 20);
        cbSecond_operator.addItem("p");
        cbSecond_operator.addItem("q");
        cbSecond_operator.addItem("~p");
        cbSecond_operator.addItem("~q");
        cbSecond_operator.addItem("ANS");
        cbSecond_operator.setSelectedIndex(1);

        cbOperator.setBounds(250, 50, 50, 20);
        cbOperator.addItem("↔");
        cbOperator.addItem("→");
        cbOperator.addItem("˄");
        cbOperator.addItem("˅");
        cbOperator.setSelectedIndex(3);

        sentdata.setBounds(80, 100, 200, 20);
        saveresult.setBounds(300, 100, 200, 20);

        tbResultados = new JTable();
        tbResultados.setModel(model);

        tbResultados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbResultados.getTableHeader().setReorderingAllowed(false);

        tbResultados.setBounds(20, 150, 530, 80);

        Cuadro.add(lbFirst_operator);
        Cuadro.add(cbFirst_operator);
        Cuadro.add(lbSecond_operator);
        Cuadro.add(cbSecond_operator);
        Cuadro.add(lbOperator);
        Cuadro.add(cbOperator);
        Cuadro.add(sentdata);
        Cuadro.add(tbResultados);
        Cuadro.add(saveresult);

        sentdata.addActionListener(this);
        saveresult.addActionListener(this);

        Cuadro.setLayout(null);
        Cuadro.setVisible(true);
        Cuadro.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    int contadorAns = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sentdata) {
            System.out.println("Enviando datos");
            Operacion.first_operator = cbFirst_operator.getSelectedItem().toString();
            Operacion.second_operator = cbSecond_operator.getSelectedItem().toString();
            Operacion.operation = cbOperator.getSelectedItem().toString();

            System.out.println("Operacion a realizar: " + Operacion.first_operator + " " + Operacion.operation + " " + Operacion.second_operator);
            Operacion.ComprobarPrimerOperador();
            Operacion.ComprobarSegundoOperador();
            Operacion.Operar();
            System.out.print("Resultado: ");

            for (int i = 0; i < 4; i++) {
                System.out.print(Operacion.result[i] + " ");
            }

            if (Operacion.contador == 0) {
                model.addColumn(Operacion.first_operator);
                model.addColumn(Operacion.operation);
                model.addColumn(Operacion.second_operator);

                Operacion.contadorColumnas = Operacion.contadorColumnas + 3;

                model.addRow(new Object[]{Operacion.first_operator, Operacion.operation, Operacion.second_operator});

                for (int i = 0; i < 4; i++) {
                    model.addRow(new Object[]{Operacion.firsttable[i], Operacion.result[i], Operacion.secondtable[i]});
                }

                Operacion.contador = Operacion.contador + 1;

            } else {
                model.addColumn(Operacion.first_operator);
                model.addColumn(Operacion.operation);
                model.addColumn(Operacion.second_operator);

                model.setValueAt(Operacion.first_operator, 0, Operacion.contadorColumnas);
                model.setValueAt(Operacion.operation, 0, Operacion.contadorColumnas + 1);
                model.setValueAt(Operacion.second_operator, 0, Operacion.contadorColumnas + 2);

                for (int k = 0; k < 4; k++) {
                    model.setValueAt(Operacion.firsttable[k], k + 1, Operacion.contadorColumnas);
                }

                Operacion.contadorColumnas = Operacion.contadorColumnas + 1;

                for (int k = 0; k < 4; k++) {
                    model.setValueAt(Operacion.result[k], k + 1, Operacion.contadorColumnas);
                }

                Operacion.contadorColumnas = Operacion.contadorColumnas + 1;

                for (int k = 0; k < 4; k++) {
                    model.setValueAt(Operacion.secondtable[k], k + 1, Operacion.contadorColumnas);
                }

                Operacion.contadorColumnas = Operacion.contadorColumnas + 1;

            }

            model.fireTableDataChanged();

            System.out.println("");
            System.out.println("");
        } else if (e.getSource() == saveresult) {

            Operacion.saveResult(contadorAns);
            contadorAns++;

        }
    }

}
