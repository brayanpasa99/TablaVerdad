/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablaverdad2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author braya
 */
public class Interface extends JFrame implements ActionListener {

    JLabel lfirst_operator = new JLabel("Ingrese el primer operando:");
    JTextField bfirst_operator = new JTextField();
    JLabel lsecond_operator = new JLabel("Ingrese el segundo operando:");
    JTextField bsecond_operator = new JTextField();
    JLabel loperator = new JLabel("Ingrese el operador:");
    JTextField boperator = new JTextField();
    JButton sentdata = new JButton("Enviar los datos");

    public Interface() {

        JFrame marco = new JFrame();

        marco.setBounds(10, 10, 600, 500);
        lfirst_operator.setBounds(20, 20, 200, 20);
        bfirst_operator.setBounds(70, 50, 50, 20);
        lsecond_operator.setBounds(380, 20, 200, 20);
        bsecond_operator.setBounds(440, 50, 50, 20);
        loperator.setBounds(220, 20, 150, 20);
        boperator.setBounds(250, 50, 50, 20);
        sentdata.setBounds(180, 100, 200, 20);

        marco.add(lfirst_operator);
        marco.add(bfirst_operator);
        marco.add(lsecond_operator);
        marco.add(bsecond_operator);
        marco.add(loperator);
        marco.add(boperator);
        marco.add(sentdata);

        sentdata.addActionListener(this);

        marco.setLayout(null);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sentdata) {

        }
    }

}
