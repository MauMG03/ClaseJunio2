/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.synth.ColorType;

import modelo.Triangulo;

/**
 *
 * @author Admin
 */
public class VentanaTriangulo extends JFrame
       /*implements ActionListener*/{
    
    private JLabel lblBase;
    private JLabel lblAltura;
    private JLabel lblArea;
    private JTextField txtBase;
    private JTextField txtAltura;
    private JTextField txtArea;
    private JButton btnCalcular;
    private Container contenedorPpal;
    private JButton btnNuevo;
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
        txtAltura  = new JTextField(15);
        txtArea  = new JTextField(15);
        
        txtArea.setEnabled(false);
        txtBase.setEnabled(false);
        txtAltura.setEnabled(false);
        txtArea.setDisabledTextColor(Color.red);
        txtArea.setBackground(new Color(253,255,176));
        txtArea.setFont(new Font("", Font.BOLD,18));
        txtArea.setHorizontalAlignment(JTextField.RIGHT);
        btnCalcular = new JButton("Calcular");
        btnNuevo = new JButton ("Nuevo");
        btnCalcular.setEnabled(false);
        contenedorPpal = getContentPane();
        
        contenedorPpal.setLayout(new GridLayout(4,2));
        
        contenedorPpal.add(lblBase);
        contenedorPpal.add(txtBase);
        
        contenedorPpal.add(lblAltura);
        contenedorPpal.add(txtAltura);
        
        contenedorPpal.add(lblArea);
        contenedorPpal.add(txtArea);
        contenedorPpal.add(btnNuevo);
        contenedorPpal.add(btnCalcular);
        
        btnNuevo.requestFocus();
        //btnNuevo.addActionListener(this);
        //btnCalcular.addActionListener(this);
               
        btnCalcular.addMouseListener(new ManejadorDeEventos());
        btnNuevo.addMouseListener(new ManejadorDeEventos());
        
        txtBase.addKeyListener(new ManejadorDeEventos());
        txtAltura.addKeyListener(new ManejadorDeEventos());
        
    }
    
    public void calcular(){
        try{
            float base = Float.parseFloat(txtBase.getText());
            float altura = Float.parseFloat(txtAltura.getText());
            
            Triangulo tri1 = new Triangulo(base,altura);
            tri1.calcularArea();

            txtArea.setText(tri1.getArea()+ "");
            btnCalcular.setEnabled(false);
            txtAltura.setEnabled(false);
            txtBase.setEnabled(false);
            btnNuevo.setEnabled(true);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Introduce numeros validos");
        }
        
        
    }
    
    /*
    @Override
    public void actionPerformed(ActionEvent ae) {
         //JOptionPane.showMessageDialog(null,"Buena noshe ");
         if (ae.getSource()==btnCalcular){
             float base = Float.parseFloat(txtBase.getText());
             float altura = Float.parseFloat(txtAltura.getText());
             Triangulo tri1 = new Triangulo(base,altura);
             tri1.calcularArea();
             txtArea.setText(tri1.getArea()+ "");
             btnCalcular.setEnabled(false);
             txtAltura.setEnabled(false);
             txtBase.setEnabled(false);
             btnNuevo.setEnabled(true);
         }
         if (ae.getSource()==btnNuevo)
         { 
             txtAltura.setText("");
             txtBase.setText("");
             txtArea.setText("");
             
             btnNuevo.setEnabled(false);
             btnCalcular.setEnabled(true);
             txtAltura.setEnabled(true);
             txtBase.setEnabled(true);
         }
    }
    */
    class ManejadorDeEventos extends MouseAdapter 
            implements KeyListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if(me.getSource()==btnNuevo){
                txtAltura.setText("");
                txtBase.setText("");
                txtArea.setText("");

                btnNuevo.setEnabled(false);
                btnCalcular.setEnabled(true);
                txtAltura.setEnabled(true);
                txtBase.setEnabled(true);
            }
            if(me.getSource()==btnCalcular){
                calcular();
            }
        }  

        @Override
        public void keyTyped(KeyEvent ke) {
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getSource()==txtBase){
                if(txtBase.getText().equals("")){
                    
                }else{
                   if(ke.getKeyCode() == 10){   
                        txtAltura.requestFocus(); 
                    } 
                }
            }
            
            if(ke.getSource()==txtAltura){
                if(txtAltura.getText().equals("")){
                    
                }else{
                   if(ke.getKeyCode() == 10){   
                        txtBase.requestFocus();
                        calcular(); 
                    } 
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
           
        }
    }

}
