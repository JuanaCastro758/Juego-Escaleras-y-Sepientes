/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;



/**
 *
 * @author Chiko malo
 */

import leerArchivo.LeerArchivo;
import java.awt.Color;
import java.io.File;
import static java.lang.Math.random;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class JuegoPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JuegoPrincipal
     */
    private int FILS=8;
    private int COLS=8;
    JButton[][] CUADRO;
    String[][] juego=new String[8][8];
    private int contadorf;
    private int contadorc;
    private int contadorf2;
    private int contadorc2;
    public JuegoPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        setLeer();
        setMatriz();
        contadorf=0;
        contadorc=0;
        contadorf2=0;
        contadorc2=0;
    }
    public void setLeer(){
        File archivo =new File ("posicion.txt");
        LeerArchivo nc=new LeerArchivo();
        String[] arreglo=nc.leer(archivo);
        int x=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                juego[i][j]=arreglo[x];
                x++;
            /*if(arreglo[i].equals("fin")){
            System.out.println(arreglo[i]);}
                */
            }
        }
    }
    public void setMatriz(){
        CUADRO=new JButton[FILS][COLS];
        int x=15;
        int y=15;
        for(int i=0;i<FILS;i++){
            for(int j=0;j<COLS;j++){
                if(juego[i][j].equals("fin")){
                    boton(CUADRO,i,j,x,y,Color.red);
                    CUADRO[i][j].setName("fin");
                    CUADRO[i][j].setText("fin");
                }else if(juego[i][j].equals("libre")){
                    boton(CUADRO,i,j,x,y,Color.green );
                    CUADRO[i][j].setName("libre");
                    CUADRO[i][j].setText("libre");
                }else if(juego[i][j].equals("tiro")){
                    boton(CUADRO,i,j,x,y,Color.white);
                    CUADRO[i][j].setName("tiro");
                    CUADRO[i][j].setText("dadoGanador");
                }else if(juego[i][j].equals("pierde")){
                    boton(CUADRO,i,j,x,y,Color.black);
                    CUADRO[i][j].setName("pierde");
                    CUADRO[i][j].setText("paroTurno");
                }else if(juego[i][j].equals("s4inicio")||juego[i][j].equals("s3inicio")||juego[i][j].equals("s2inicio")||juego[i][j].equals("s1inicio")||juego[i][j].equals("s4fin")||juego[i][j].equals("s3fin")||juego[i][j].equals("s2fin")||juego[i][j].equals("s1fin")){
                    boton(CUADRO,i,j,x,y,Color.blue);
                    //inicio de la cabeza
                    if(juego[i][j].equals("s4inicio")){CUADRO[i][j].setName("s4inicio"); CUADRO[i][j].setText("4colaSer");}
                    if(juego[i][j].equals("s3inicio")){CUADRO[i][j].setName("s3inicio"); CUADRO[i][j].setText("3colaSer");}
                    if(juego[i][j].equals("s2inicio")){CUADRO[i][j].setName("s2inicio"); CUADRO[i][j].setText("2colaSer");}
                    if(juego[i][j].equals("s1inicio")){CUADRO[i][j].setName("s1inicio"); CUADRO[i][j].setText("1colaSer");}
                    //fin de la cola
                    if(juego[i][j].equals("s4fin")){CUADRO[i][j].setName("s4fin"); CUADRO[i][j].setText("4cabeSe");}
                    if(juego[i][j].equals("s3fin")){CUADRO[i][j].setName("s3fin"); CUADRO[i][j].setText("3cabeSe");}
                    if(juego[i][j].equals("s2fin")){CUADRO[i][j].setName("s2fin"); CUADRO[i][j].setText("2cabeSe");}
                    if(juego[i][j].equals("s1fin")){CUADRO[i][j].setName("s1fin"); CUADRO[i][j].setText("1cabeSe");}
                }else if(juego[i][j].equals("inicio")){
                    boton(CUADRO,i,j,x,y,Color.yellow );
                    CUADRO[i][j].setName("inicio");
                    CUADRO[i][j].setText("Inicio");
                }else{
                    boton(CUADRO,i,j,x,y,Color.cyan );
                    //inicio de la cabeza
                    if(juego[i][j].equals("e4inicio")){CUADRO[i][j].setName("e4inicio"); CUADRO[i][j].setText("4EscFin");}
                    if(juego[i][j].equals("e3inicio")){CUADRO[i][j].setName("e3inicio"); CUADRO[i][j].setText("3EscFin");}
                    if(juego[i][j].equals("e2inicio")){CUADRO[i][j].setName("e2inicio"); CUADRO[i][j].setText("2EscFin");}
                    if(juego[i][j].equals("e1inicio")){CUADRO[i][j].setName("e1inicio"); CUADRO[i][j].setText("1EscFin");}
                    //fin de la cola
                    if(juego[i][j].equals("e4fin")){CUADRO[i][j].setName("e4fin"); CUADRO[i][j].setText("4EscaIn");}
                    if(juego[i][j].equals("e3fin")){CUADRO[i][j].setName("e3fin"); CUADRO[i][j].setText("3EscaIn");}
                    if(juego[i][j].equals("e2fin")){CUADRO[i][j].setName("e2fin"); CUADRO[i][j].setText("2EscaIn");}
                    if(juego[i][j].equals("e1fin")){CUADRO[i][j].setName("e1fin"); CUADRO[i][j].setText("1EscaIn");}
                }
                x+=80;
            }
            x=15;
            y+=80;
        }
    }
    public void boton(JButton[][] C,int i,int j,int x,int y, Color c){
        C[i][j]=new JButton();
        C[i][j].setBackground(c);
        C[i][j].setBounds(x, y, 75, 75);
                
        panelBotones.add(C[i][j]);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTurno = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        dos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dos1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTurno.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        getContentPane().add(txtTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        getContentPane().add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 730, 690));

        jButton1.setText("jugador uno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 130, 50));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 150, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 110, -1));

        jButton2.setText("Jugador dos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 130, 60));
        getContentPane().add(dos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 150, 30));

        jLabel1.setText("Posicion del Jugador 2: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel2.setText("Posicion del Jugador 1: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));
        getContentPane().add(dos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 150, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        try{
            Random random=new Random();
            int x=random.nextInt(6-1+1)+1;
            jTextField2.setText(""+x);
            //jTextField1.setText(""+CUADRO[contadorf][contadorc].getName());
            
            actualizarPosicionJugador1(x);
            verificarEscalera1();
            verificarSerpiente1();
            mensaje1();
            recuperarColor();
            verificar(contadorf,contadorc,Color.pink);
            verificar(contadorf2,contadorc2,Color.ORANGE);
            dos1.setText(""+CUADRO[contadorf][contadorc].getName());
            
        }catch(Exception e){
            System.out.println(e.getMessage()+"Error en el boton Jugador 1 o ya no hay espacio");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            Random random=new Random();
            int x=random.nextInt(6-1+1)+1;
            jTextField2.setText(""+x);
            //jTextField1.setText(""+CUADRO[contadorf][contadorc].getName());
            actualizarPosicionJugador2(x);
            verificarEscalera2();
            verificarSerpiente1();
            mensaje2();
            recuperarColor();
            verificar(contadorf2,contadorc2,Color.ORANGE);
            verificar(contadorf,contadorc,Color.pink);
            dos.setText(""+CUADRO[contadorf2][contadorc2].getName());
        }catch(Exception e){
            System.out.println(e.getMessage()+"Error en el boton o ya no hay espacio");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
       
    public void mensaje2(){
        if(juego[contadorf2][contadorc2].equals("tiro")){
            JOptionPane.showMessageDialog(panelBotones, "Tire nuevamente los dados");
        }else if(juego[contadorf2][contadorc2].equals("pierde")){
            JOptionPane.showMessageDialog(panelBotones, "A perdidio un turno");
        }
    }
    public void mensaje1(){
        if(juego[contadorf][contadorc].equals("tiro")){
            JOptionPane.showMessageDialog(panelBotones, "Tire nuevamente los dados");
        }else if(juego[contadorf][contadorc].equals("pierde")){
            JOptionPane.showMessageDialog(panelBotones, "A perdidio un turno");
        }
    }
    public void verificarEscalera1(){
        if(juego[contadorf][contadorc].equals("e4fin")){
            JOptionPane.showMessageDialog(panelBotones, "Felicidades a caido en la Escalera");
            escalera1("e4inicio");
        }else if(juego[contadorf][contadorc].equals("e3fin")){
            JOptionPane.showMessageDialog(panelBotones, "Felicidades a caido en la Escalera");
            escalera1("e3inicio");
        }else if(juego[contadorf][contadorc].equals("e2fin")){
            JOptionPane.showMessageDialog(panelBotones, "Felicidades a caido en la Escalera");
            escalera1("e2inicio");
        }else if(juego[contadorf][contadorc].equals("e1fin")){
            JOptionPane.showMessageDialog(panelBotones, "Felicidades a caido en la Escalera");
            escalera1("e1inicio");
        }
    }
    public void escalera1(String buscado){
        boolean res=false;
        do{
            pos1();
            if(juego[contadorf][contadorc].equals(buscado)){ res=true; }
        }while(res==false);
    }
   public void verificarEscalera2(){
        if(juego[contadorf2][contadorc2].equals("e4fin")){
            JOptionPane.showMessageDialog(panelBotones, "Felicidades a caido en la Escalera");
            escalera2("e4inicio");
        }else if(juego[contadorf2][contadorc2].equals("e3fin")){
            JOptionPane.showMessageDialog(panelBotones, "Felicidades a caido en la Escalera");
            escalera2("e3inicio");
        }else if(juego[contadorf2][contadorc2].equals("e2fin")){
            JOptionPane.showMessageDialog(panelBotones, "Felicidades a caido en la Escalera");
            escalera2("e2inicio");
        }else if(juego[contadorf2][contadorc2].equals("e1fin")){
            JOptionPane.showMessageDialog(panelBotones, "Felicidades a caido en la Escalera");
            escalera2("e1inicio");
        }
    }
    public void escalera2(String buscado){
        boolean res=false;
        do{
            pos2();
            if(juego[contadorf2][contadorc2].equals(buscado)){ res=true; }
        }while(res==false);
        
    }
    public void verificarSerpiente1(){
        if(juego[contadorf][contadorc].equals("s4fin")){
            JOptionPane.showMessageDialog(panelBotones, "O no le ha caido en la boca de la Serpiente");
            contadorf=0;
            contadorc=0;
            serpiente1("s4inicio");
        }else if(juego[contadorf][contadorc].equals("s3fin")){
            JOptionPane.showMessageDialog(panelBotones, "O no le ha caido en la boca de la Serpiente");
            contadorf=0;
            contadorc=0;
            serpiente1("s3inicio");
        }else if(juego[contadorf][contadorc].equals("s2fin")){
            JOptionPane.showMessageDialog(panelBotones, "O no le ha caido en la boca de la Serpiente");
            contadorf=0;
            contadorc=0;
            serpiente1("s2inicio");
        }else if(juego[contadorf][contadorc].equals("s1fin")){
            JOptionPane.showMessageDialog(panelBotones, "O no le ha caido en la boca de la Serpiente");
            contadorf=0;
            contadorc=0;
            serpiente1("s1inicio");
        }
    }
    public void serpiente1(String buscado){
        boolean res=false;
        do{
            pos1();
            if(juego[contadorf][contadorc].equals(buscado)){ res=true; }
        }while(res==false);
        dos1.setText(""+CUADRO[contadorf][contadorc].getName());
    }
   public void verificarSepiente2(){
        if(juego[contadorf2][contadorc2].equals("s4fin")){
            JOptionPane.showMessageDialog(panelBotones, "O no le ha caido en la boca de la Serpiente");
            contadorf2=0;
            contadorc2=0;
            sepiente2("s4inicio");
        }else if(juego[contadorf2][contadorc2].equals("s3fin")){
            JOptionPane.showMessageDialog(panelBotones, "O no le ha caido en la boca de la Serpiente");
            contadorf2=0;
            contadorc2=0;
            sepiente2("s3inicio");
        }else if(juego[contadorf2][contadorc2].equals("s2fin")){
            JOptionPane.showMessageDialog(panelBotones, "O no le ha caido en la boca de la Serpiente");
            contadorf2=0;
            contadorc2=0;
            sepiente2("s2inicio");
        }else if(juego[contadorf2][contadorc2].equals("s1fin")){
            JOptionPane.showMessageDialog(panelBotones, "O no le ha caido en la boca de la Serpiente");
            contadorf2=0;
            contadorc2=0;
            sepiente2("s1inicio");
        }
    }
    public void sepiente2(String buscado){
        boolean res=false;
        do{
            pos2();
            if(juego[contadorf2][contadorc2].equals(buscado)){ res=true; }
        }while(res==false);
        dos.setText(""+CUADRO[contadorf2][contadorc2].getName());
    }
    public void actualizarPosicionJugador1(int x){
        for(int i=0;i<x;i++){
            pos1();
        }
    }
    public void actualizarPosicionJugador2(int x){
        for(int i=0;i<x;i++){
                pos2();
        }
    }
    public void pos2(){
        if(contadorf2==0 || contadorf2==2 ||contadorf2==4 || contadorf2==6){
                if(contadorc2==7){
                    contadorf2++;
                }else{contadorc2++;}
            }else if(contadorf2==1 || contadorf2==3 ||contadorf2==5 || contadorf2==7){
                if(contadorc2==0){
                    contadorf2++;
                }else{contadorc2--;}
            }
    }
    public void pos1(){
        if(contadorf==0 || contadorf==2 ||contadorf==4 || contadorf==6){
            if(contadorc==7){
                contadorf++;
            }else{contadorc++;}
        }else if(contadorf==1 || contadorf==3 ||contadorf==5 || contadorf==7){
            if(contadorc==0){
                contadorf++;
            }else{contadorc--;}
        }
    }
    public void verificar(int contadorfila,int contadorcolumna,Color color){
        if(contadorfila==0 || contadorfila==2 ||contadorfila==4 || contadorfila==6){
            CUADRO[contadorfila][contadorcolumna].setBackground(color);
                
        }else if(contadorfila==1 || contadorfila==3 ||contadorfila==5 || contadorfila==7){
            CUADRO[contadorfila][contadorcolumna].setBackground(color);
        }
    }
    
    public void recuperarColor(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(juego[i][j].equals("fin")){
                    CUADRO[i][j].setBackground(Color.red);
                }else if(juego[i][j].equals("libre")){
                    CUADRO[i][j].setBackground(Color.green);
                }else if(juego[i][j].equals("tiro")){
                    CUADRO[i][j].setBackground(Color.white);
                }else if(juego[i][j].equals("pierde")){
                    CUADRO[i][j].setBackground(Color.black);
                }else if(juego[i][j].equals("s4inicio")||juego[i][j].equals("s3inicio")||juego[i][j].equals("s2inicio")||juego[i][j].equals("s1inicio")||juego[i][j].equals("s4fin")||juego[i][j].equals("s3fin")||juego[i][j].equals("s2fin")||juego[i][j].equals("s1fin")){
                    CUADRO[i][j].setBackground(Color.blue);
                }else if(juego[i][j].equals("inicio")){
                    CUADRO[i][j].setBackground(Color.yellow);
                }else{
                    CUADRO[i][j].setBackground(Color.cyan);
                }
            }
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JuegoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dos;
    private javax.swing.JTextField dos1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JLabel txtTurno;
    // End of variables declaration//GEN-END:variables
}
