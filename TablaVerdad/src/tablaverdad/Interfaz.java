/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablaverdad;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author braya
 */
public class Interfaz extends JFrame {
    
    public Interfaz(){
        
        JFrame pantalla = new JFrame();
        pantalla.setBounds(500, 500, 500, 500);
        pantalla.setLocation(10, 10);
        
        JTextField operacion = new JTextField();
        operacion.setBounds(20, 20, 300, 100);
        
        boolean p = true;
        boolean q = false;
        boolean prueba = p&&q;
                
        operacion.setText(""+prueba);
        
        pantalla.add(operacion);
        
        pantalla.setLayout(null);
        pantalla.setVisible(true);
        pantalla.setDefaultCloseOperation(EXIT_ON_CLOSE);
  
    }
    
}
