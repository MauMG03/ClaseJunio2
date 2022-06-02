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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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
public class VentanaMotion extends JFrame
       implements MouseMotionListener, MouseWheelListener{
    
    private JLabel lblBase;
    
    private Container contenedorPpal;
    
    public VentanaMotion(){
        iniciarComponentes();   
        setSize(600,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Área Triangulo");
    }
    
    private void iniciarComponentes(){
        lblBase = new JLabel("Base : ");
        lblBase.setBounds(50,10,50,30);
        
        contenedorPpal = getContentPane();
        
        contenedorPpal.setLayout(null);
        
        
        contenedorPpal.add(lblBase);
        
        contenedorPpal.addMouseMotionListener(this);
        contenedorPpal.addMouseWheelListener(this);
        
        lblBase.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if(me.getSource()==lblBase){
            lblBase.setBounds(me.getX(),me.getY(),50,30);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        System.out.println("x: " + me.getX() + ".  y: " + me.getY());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        if(mwe.getSource() == contenedorPpal){
            int y = lblBase.getY();
            int x = lblBase.getX();
            
            if(mwe.getPreciseWheelRotation()==1.0){
                y += 10;
                
            }else{
                y -= 10;
            }
            lblBase.setBounds(x,y,50,30);
        }
    }

    
    class ManejadorDeEventos extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent me) {
            
            }
        }  
    }

