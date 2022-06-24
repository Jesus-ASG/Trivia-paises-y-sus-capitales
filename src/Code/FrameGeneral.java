
package Code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;

public class FrameGeneral extends JFrame implements ActionListener{
    JButton btnAmerica, btnAsia, btnAfrica, btnEuropa, btnOceania;
    JButton btnVolverAMenu, okButton, btnSalir;
    
    public static String fondoFrame = "", fondoBanderas = "";
    
    PnlBanderas pnlBanderas = new PnlBanderas();
    Panel pnlBanderas2 = new Panel();
    
    Panel pnlSimple;
    
    JLabel lblSeleccionar; //Titulo al principio
    JLabel lblPais, lblCapital;
    JTextArea jtaPais, jtaCapital;
    
    Color colorFondo = new Color(162, 230, 255);
    Font fuente=new Font("Arial", Font.BOLD, 20);
    
    int xInicio = 100, yInicio = 20;
    int tamBtnX = 200, tamBtnY = 60;
    
    LDL lActual = new LDL();
    Nodo nodoDatos;   //Apunta a quien se desee para obtener información
    
    String continente;
    String varL, varT, varL1, varT1;
    
    int puntos = 0; //inicia con 0 puntos
    int ronda = 1; //ronda 1
    
    boolean terminado=false;
    


    public FrameGeneral(){
        setLayout(null);
        this.setTitle("¡Conti-Trivia!");
        
        
        Cursor cursor; //Coloca cursor
        ImageIcon imgCursor = new ImageIcon ("src/Cursores/estandar.png");
        Toolkit t = Toolkit.getDefaultToolkit();
        cursor = t.createCustomCursor(imgCursor.getImage(), new Point(1,1), "aprovechar");
        setCursor(cursor);
                
        initComponents();
        
        fondoFrame = "/plantilla1.png"; //Fondo inicial
        getContentPane().add(pnlBanderas , BorderLayout.CENTER);
        pnlBanderas.repaint();
        pnlBanderas.setBounds(0, 0, 1000, 625);
        pnlBanderas.setVisible(true);
        
        metMouseListener();
        
    }
    

    private void initComponents() {
        
        btnVolverAMenu = new JButton("Menú");
        okButton = new JButton("Ok");
        btnSalir = new JButton("Salir");
        
        btnAmerica = new JButton("América");
        btnAsia = new JButton("Asia");
        btnAfrica = new JButton("Africa");
        btnEuropa = new JButton("Europa");
        btnOceania = new JButton("Oceanía");
        lblSeleccionar = new JLabel("Selecione:");
        
        lblPais = new JLabel("País");
        lblCapital = new JLabel("Capital");
        jtaPais = new JTextArea();
        jtaCapital = new JTextArea();
        
        
        btnVolverAMenu.setBounds(25, 500, 150, 100);
        okButton.setBounds(450, 500, 100, 100);
        btnSalir.setBounds(825, 500, 150, 100);
        
        lblSeleccionar.setBounds(320+xInicio, 50+yInicio, tamBtnX, tamBtnY);
        btnAmerica.setBounds(300+xInicio, 120+yInicio, tamBtnX, tamBtnY);
        btnAsia.setBounds(300+xInicio, 190+yInicio, tamBtnX, tamBtnY);
        btnAfrica.setBounds(300+xInicio, 260+yInicio, tamBtnX, tamBtnY);
        btnEuropa.setBounds(300+xInicio, 330+yInicio, tamBtnX, tamBtnY);
        btnOceania.setBounds(300+xInicio, 400+yInicio, tamBtnX, tamBtnY);
        
        lblPais.setBounds(650, 330, 100, 70);
        lblCapital.setBounds(650, 420, 100, 70);
        jtaPais.setBounds(250, 330, 380, 70);
        jtaCapital.setBounds(250, 420, 380, 70);
        
        btnAmerica.setOpaque(false);
        btnAmerica.setContentAreaFilled(true);
        
        btnAmerica.setBorderPainted(false);
        btnAsia.setBorderPainted(false);
        btnAfrica.setBorderPainted(false);
        btnEuropa.setBorderPainted(false);
        btnOceania.setBorderPainted(false);
        
        
        
        btnAmerica.setVisible(true);
        btnAsia.setVisible(true);
        btnAfrica.setVisible(true);
        btnEuropa.setVisible(true);
        btnOceania.setVisible(true);
        
        btnVolverAMenu.setVisible(false);
        okButton.setVisible(false);
        btnSalir.setVisible(true);
        
        lblPais.setVisible(false);
        lblCapital.setVisible(false);
        jtaPais.setVisible(false);
        jtaCapital.setVisible(false);
        
        
        //Agregar botones
        add(btnAmerica);
        add(btnAsia);
        add(btnAfrica);
        add(btnEuropa);
        add(btnOceania);
        add(lblSeleccionar);
                    
        add(btnVolverAMenu);
        add(okButton);
        add(btnSalir);
        
        
        add(lblPais);
        add(lblCapital);
        add(jtaPais);
        add(jtaCapital);
        
        
        btnVolverAMenu.setFont(new Font("Arial", Font.BOLD, 30));
        okButton.setFont(new Font("Arial", Font.BOLD, 30));
        btnSalir.setFont(new Font("Arial", Font.BOLD, 30));
        
        btnAmerica.setFont(fuente);
        btnAsia.setFont(fuente);
        btnAfrica.setFont(fuente);
        btnEuropa.setFont(fuente);
        btnOceania.setFont(fuente);
        lblSeleccionar.setFont(new Font("Arial", Font.BOLD, 30));
        
        lblPais.setFont(new Font("Arial", Font.BOLD, 28));
        lblCapital.setFont(new Font("Arial", Font.BOLD, 28));
        jtaPais.setFont(new Font("Arial", Font.BOLD, 28));
        jtaCapital.setFont(new Font("Arial", Font.BOLD, 28));
        
        
        btnVolverAMenu.addActionListener(this);
        okButton.addActionListener(this);
        btnSalir.addActionListener(this);
        
        btnAmerica.addActionListener(this);
        btnAsia.addActionListener(this);
        btnAfrica.addActionListener(this);
        btnEuropa.addActionListener(this);
        btnOceania.addActionListener(this);
        
    }
    
    
        //Funciones del boton
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnVolverAMenu)
            Principal.main(null);
                
        if(e.getSource() == btnSalir)
            System.exit(0);
        
        if (e.getSource() == okButton){
            
            if (terminado==false){
            
            if (nodoDatos.sig == null){         //Último dato de la lista, entonces dejar el país en blanco
                
                if(ronda<2){   //Ronda 1
                    boolean primerCaso=true;

                    System.out.println("ultimo dato");
                    varL = nodoDatos.nCapital;
                    varT = jtaCapital.getText();
                    varT = varT.toUpperCase();

                    if(varL.equals(varT)){  //es el último dato, entonces se borra y 
                        puntos++;
                        System.out.println("puntos "+puntos);
                        if(!lActual.unDato()){
                            lActual.eliminar(nodoDatos.nPais);
                        }
                        else {
                            primerCaso = false;
                            ronda++;
                        }
                    }
                    if (primerCaso) {
                        System.out.println("pais raiz: "+lActual.getRaiz().nPais);
                        nodoDatos = lActual.resetRaiz();
                        jtaPais.setText(nodoDatos.nPais);
                        fondoBanderas = "/Banderas/"+continente+"/"+eliminarEspacios(nodoDatos.nPais)+".PNG"; //Cambia imagen de bandera
                        pnlBanderas2.repaint();
                        jtaCapital.setText("");
                        ronda++;
                        jtaPais.setText("");
                        jtaPais.setEditable(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Felicidades, usted conoce " +puntos +" paises de "+tipoOracion(continente), "Aciertos: ", JOptionPane.DEFAULT_OPTION);
                        terminado = true;
                    }

                    
                }
                else if (ronda==2){
                    
                    varL = nodoDatos.nCapital;      //Obtiene capital
                    varT = jtaCapital.getText();
                    varT = varT.toUpperCase();
                    
                    varL1 = nodoDatos.nPais;        //obtiene pais
                    varT1 = jtaPais.getText();
                    varT1 = varT1.toUpperCase();
                    
                    if(varL.equals(varT) && varL1.equals(varT1)){ //Compara tener correcto pais y capital
                        puntos++;
                        System.out.println("puntos "+puntos);
                        if(!lActual.unDato()){
                            lActual.eliminar(nodoDatos.nPais);
                            System.out.println("borrado ronda 2");
                            //ronda--;
                        }
                    }
                    int numaux = puntos;
                    JOptionPane.showMessageDialog(this, "Felicidades, usted conoce " +puntos +" paises de "+tipoOracion(continente), "Aciertos: ", JOptionPane.DEFAULT_OPTION);
                    terminado = true;
                    
                    System.out.println("ultimo dato ronda 2");
                }
                
            }
            else{
                
                if(ronda<2){    //En la primera ronda se muestra el nombre del país
                    System.out.println("dato ronda 1");
                    varL = nodoDatos.nCapital;
                    varT = jtaCapital.getText();
                    varT = varT.toUpperCase();

                    if(varL.equals(varT)){  //Compara tener bien la capital
                        puntos++;
                        System.out.println("puntos "+puntos);
                        if(!lActual.unDato()){
                            lActual.eliminar(nodoDatos.nPais);
                        }
                        else lActual.resetRaiz();
                    }
                    
                    lActual.pushNodoMastil();
                    nodoDatos = lActual.getNodoMastil();

                    jtaPais.setText(nodoDatos.nPais);
                    jtaPais.setEditable(false);

                    fondoBanderas = "/Banderas/"+continente+"/"+eliminarEspacios(nodoDatos.nPais)+".PNG"; //Cambia imagen de bandera
                    pnlBanderas2.repaint();
                    jtaCapital.setText(""); //Pintar texto en blanco
                    
                }
                else if (ronda==2){     //En la segunda ronda no se muestra ni el pais ni la capital
                    System.out.println("dato ronda 2");
                    
                    varL = nodoDatos.nCapital;      //Obtiene capital
                    varT = jtaCapital.getText();
                    varT = varT.toUpperCase();
                    
                    varL1 = nodoDatos.nPais;        //obtiene pais
                    varT1 = jtaPais.getText();
                    varT1 = varT1.toUpperCase();
                    
                    if(varL.equals(varT) && varL1.equals(varT1)){ //Compara tener correcto pais y capital
                        puntos++;
                        System.out.println("puntos "+puntos);
                        if(!lActual.unDato()){
                            lActual.eliminar(nodoDatos.nPais);
                            System.out.println("borrado ronda 2");
                            //ronda--;
                        }
                    }
                    lActual.pushNodoMastil();
                    nodoDatos = lActual.getNodoMastil();

                    jtaPais.setText(nodoDatos.nPais);
                    jtaPais.setEditable(false);

                    fondoBanderas = "/Banderas/"+continente+"/"+eliminarEspacios(nodoDatos.nPais)+".PNG"; //Cambia imagen de bandera
                    pnlBanderas2.repaint();
                    jtaCapital.setText(""); //Pintar texto en blanco
                    jtaPais.setText("");
                    jtaPais.setEditable(true);
                }
            }
            } else{
                JOptionPane.showMessageDialog(this, "Felicidades, usted conoce " +puntos +" paises de "+tipoOracion(continente), "Aciertos: ", JOptionPane.DEFAULT_OPTION);
            }
            
        }
        
        if (e.getSource() == btnAmerica){
            continente = "AMERICA";
            opcionElegida();
        }
        if (e.getSource() == btnAsia){
            continente = "ASIA";
            opcionElegida();
        }
        if (e.getSource() == btnAfrica){
            continente = "AFRICA";
            opcionElegida();
        }
        if (e.getSource() == btnEuropa){
            continente = "EUROPA";
            opcionElegida();
        }
        if (e.getSource() == btnOceania){
            continente = "OCEANIA";
            opcionElegida();
        }
        
        
        
        
    }

    private void metMouseListener() {
        MouseListener objML = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
                Cursor cursor; //Coloca cursor
                ImageIcon imgCursor = new ImageIcon ("src/Cursores/seleccionar.png");
                Toolkit t = Toolkit.getDefaultToolkit();
                cursor = t.createCustomCursor(imgCursor.getImage(), new Point(1,1), "aprovechar");
                setCursor(cursor);
                
            }

            @Override
            public void mouseExited(MouseEvent me) {                
                Cursor cursor; //Coloca cursor
                ImageIcon imgCursor = new ImageIcon ("src/Cursores/estandar.png");
                Toolkit t = Toolkit.getDefaultToolkit();
                cursor = t.createCustomCursor(imgCursor.getImage(), new Point(1,1), "aprovechar");
                setCursor(cursor);                
            }
        };
        
        btnAmerica.addMouseListener(objML);
        btnAsia.addMouseListener(objML);
        btnAfrica.addMouseListener(objML);
        btnEuropa.addMouseListener(objML);
        btnOceania.addMouseListener(objML);
        btnVolverAMenu.addMouseListener(objML);
        okButton.addMouseListener(objML);
        btnSalir.addMouseListener(objML);       
        
    }
    
    public String eliminarEspacios(String cad){
        char l; 
        String aux = "";
        for(int i=0; i<cad.length(); i++){
            l = cad.charAt(i);
            if(l != ' ')
                aux = aux + l;
        }
        return aux;
    }
    
    public void opcionElegida(){
            lblSeleccionar.setText(tipoOracion(continente));
            lblSeleccionar.setBounds(30, 10, 150, 70);
            //Lee 
            FileReader leer;
            File archivo = new File("src/CONTINENTES/"+continente+".txt");
            String cad, dPaises = "";
            try {
                leer = new FileReader(archivo);
                BufferedReader almacenamiento = new BufferedReader(leer);
                cad = "";
                while (cad!=null){
                    try {
                        cad = almacenamiento.readLine(); //Lee una linea del texto
                        String[] dat = cad.split("-", 2);  //Separa el contenido en país y capital
                        lActual.insertar(dat[0], dat[1]);
                        if (cad!=null)
                            dPaises = dPaises + cad + '\n';
                        } catch (Exception ee) {
                    }
                }
                try {
                    almacenamiento.close();
                    leer.close();
                } catch (Exception ee) {
                }
            } catch (Exception ee) {}
            
            okButton.setVisible(true);
            btnVolverAMenu.setVisible(true);
            lblPais.setVisible(true);
            lblCapital.setVisible(true);
            jtaPais.setVisible(true);
            jtaCapital.setVisible(true);
            
            nodoDatos = lActual.resetRaiz();
            jtaPais.setText(nodoDatos.nPais);
            jtaPais.setEditable(false);
            
            fondoBanderas = "/Banderas/"+continente+"/"+eliminarEspacios(nodoDatos.nPais)+".PNG";       
            getContentPane().add(pnlBanderas2, BorderLayout.CENTER);
            pnlBanderas2.repaint();
            pnlBanderas2.setBounds(250, 20, 500, 280);
            pnlBanderas2.setVisible(true);
            
            fondoFrame = "/plantilla2.png";
            getContentPane().add(pnlBanderas , BorderLayout.CENTER);
            pnlBanderas.repaint();
            pnlBanderas.setBounds(0, 0, 1000, 625);
            pnlBanderas.setVisible(true);
            
            //Esconder botones y layout
            btnAmerica.setVisible(false);
            btnAsia.setVisible(false);
            btnAfrica.setVisible(false);
            btnEuropa.setVisible(false);
            btnOceania.setVisible(false);
    }
    
    public String tipoOracion(String cad){
        char a;
        String cadAux = "";
        cadAux = cadAux + cad.charAt(0);
        
        for(int i=1; i<cad.length(); i++){
            a = cad.charAt(i);
            a = (char) (a+32);
            cadAux = cadAux + a;
        }
        return cadAux;
    }
    
    
}
