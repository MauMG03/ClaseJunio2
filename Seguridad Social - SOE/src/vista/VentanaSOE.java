/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author invitado
 */
public class VentanaSOE extends JFrame{
    private JLabel lblContrato;
    private JLabel lblMeses;
    private JLabel lblIBC;
    private JLabel lblSalud;
    private JLabel lblPension;
    private JLabel lblTotal;
    
    private JTextField txtContrato;
    private JTextField txtMeses;
    private JTextField txtIBC;
    private JTextField txtSalud;
    private JTextField txtPension;
    private JTextField txtTotal;
    
    private JButton btnCalcular;
    private JButton btnNuevo;
    
    private Container contenedorPpal;

    public VentanaSOE(){
        iniciarComponentes();
        setSize(400,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Seguridad Social - SOE");
    }
    
    public void iniciarComponentes(){
        lblContrato = new JLabel("Valor Contrato");
        lblContrato.setBounds(30,10,150,20);
        
        lblMeses = new JLabel("Cantidad Meses");
        lblMeses.setBounds(30,40,150,20);
        
        lblIBC = new JLabel("IBC");
        lblIBC.setBounds(30,130,150,20);
        
        lblSalud = new JLabel("Salud");
        lblSalud.setBounds(30,160,150,20);
        
        lblPension = new JLabel("Pension");
        lblPension.setBounds(30,190,150,20);
        
        lblTotal = new JLabel("Total");
        lblTotal.setBounds(30,220,150,20);
        
        txtContrato = new JTextField("");
        txtContrato.setBounds(200,10,150,20);
        
        txtMeses = new JTextField("");
        txtMeses.setBounds(200,40,150,20);
        
        txtIBC = new JTextField("");
        txtIBC.setBounds(200,130,150,20);
        
        txtSalud = new JTextField("");
        txtSalud.setBounds(200,160,150,20);
        
        txtPension = new JTextField("");
        txtPension.setBounds(200,190,150,20);
        
        txtTotal = new JTextField("");
        txtTotal.setBounds(200,220,150,20);
        
        contenedorPpal = getContentPane();
        contenedorPpal.setLayout(null);
        
        contenedorPpal.add(lblContrato);
        contenedorPpal.add(lblMeses);
        contenedorPpal.add(lblIBC);
        contenedorPpal.add(lblSalud);
        contenedorPpal.add(lblPension);
        contenedorPpal.add(lblTotal);
        contenedorPpal.add(txtContrato);
        contenedorPpal.add(txtMeses);
        contenedorPpal.add(txtIBC);
        contenedorPpal.add(txtSalud);
        contenedorPpal.add(txtPension);
        contenedorPpal.add(txtTotal);
    }
}
