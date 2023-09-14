/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.Triangulo;

/**
 *
 * @author Admin
 */
public class VentanaTriangulo extends JFrame
implements ActionListener{
    
    private JLabel lblBase;
    private JLabel lblAltura;
    private JLabel lblArea;
    private JTextField txtBase;
    private JTextField txtAltura;
    private JTextField txtArea;
    private JButton btnCalcular;
    private JButton btnLimpiar;
    private Container contenedorPpal;
    
    public VentanaTriangulo(){
        iniciarComponentes();   
        setSize(350,150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Área Triangulo");
    }
    
    private void iniciarComponentes(){
        lblBase = new JLabel("Base : ");
        lblAltura = new JLabel("Altura : ");
        lblArea = new JLabel("Area : ");
        
        txtBase = new JTextField(15);
        txtBase.setHorizontalAlignment(JTextField.RIGHT);
        
        txtAltura  = new JTextField(15);
        txtAltura.setHorizontalAlignment(JTextField.RIGHT);
        
        txtArea  = new JTextField(15);
        
        
        txtArea.setEnabled(false);
        txtArea.setBackground(Color.YELLOW);
        txtArea.setDisabledTextColor(Color.red);
        txtArea.setHorizontalAlignment(JTextField.RIGHT);
        
      
        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(this);
        contenedorPpal = getContentPane();
        
        contenedorPpal.setLayout(new GridLayout(4,2));
        
        contenedorPpal.add(lblBase);
        contenedorPpal.add(txtBase);
        
        contenedorPpal.add(lblAltura);
        contenedorPpal.add(txtAltura);
        
        contenedorPpal.add(lblArea);
        contenedorPpal.add(txtArea);
        contenedorPpal.add(btnLimpiar);
        contenedorPpal.add(btnCalcular);
                  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular){
            float base = Float.parseFloat(txtBase.getText());
            float altura = Float.parseFloat(txtAltura.getText());
            Triangulo obj = new Triangulo(base, altura);
            obj.calcularArea();
            txtArea.setText(obj.getArea()+"");
        }else if (e.getSource() == btnLimpiar){
           txtBase.setText("");
           txtAltura.setText("");
           txtArea.setText("");
           
        }
        // System.out.println(e);
    }
}
