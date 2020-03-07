/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jchat;

import com.sun.glass.events.KeyEvent;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.E;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;


public class Jchat extends javax.swing.JFrame {

    
    
    
Timer timer;    
String nome=" Offline ", mensagem,mensagemRecebida,nomeb,mensagemb,frase="",urlImagem;
int i=0,i3=0;
Connection con;
Statement statement1=null;
ResultSet resultado=null;    


    public Jchat() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icone.png")));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoConectar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        statusConexao = new javax.swing.JLabel();
        nomeUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensagemUsuario = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jchar");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        botaoConectar.setText("Conectar");
        botaoConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConectarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Status");

        statusConexao.setText("Offline");

        jLabel4.setText(" Mensagem");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(166, 95));

        mensagemUsuario.setColumns(20);
        mensagemUsuario.setRows(5);
        mensagemUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mensagemUsuarioKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(mensagemUsuario);

        display.setEditable(false);
        display.setContentType("text/html"); // NOI18N
        display.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                displayKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(display);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(statusConexao))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoConectar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statusConexao))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConectarActionPerformed
    conectar();
    
    tarefa();
    nome=nomeUsuario.getText();
    
    
    }//GEN-LAST:event_botaoConectarActionPerformed

    private void mensagemUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mensagemUsuarioKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER){ 
        mensagem=mensagemUsuario.getText();
        escreveMensagem();
        mensagemUsuario.setText("");
        mensagemUsuario.setCaretPosition(1);
    
    
        }
    }//GEN-LAST:event_mensagemUsuarioKeyPressed

    private void displayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_displayKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_displayKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     try{                                                           //evento disparado quando fcha o programa
     //statement1.executeQuery("TRUNCATE TABLE chat");
     
     statement1.close();
     con.close();
     }
     catch(Exception e){
     JOptionPane.showMessageDialog(null,"Saiu Sem Conectar");
     }   
    
       
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Jchat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jchat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jchat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jchat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jchat().setVisible(true);
            }
        });
    }

void conectar() {
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://urldoseubancodedados/bancodedados","usuario","senha");
    statusConexao.setText("Conectado");
      
   }
   catch(Exception e){
   statusConexao.setText("erro ao conectar");
   }
          
}    
    
public void escreveMensagem(){
try{
statement1=con.createStatement();
statement1.executeUpdate("INSERT INTO `chat`(`nome`, `mensagem`) VALUES ('"+nome+"','"+mensagem+"')");

}

catch(Exception e){
JOptionPane.showMessageDialog(null, "erro em escrever mensagem");
}
}     
    
    
 
    
 
    
public void tarefa(){                           // função que executa tarefa em segundo plano
ActionListener task = new ActionListener() {    // requer ActionListener variavel task
  public void actionPerformed(ActionEvent evt) {// aqui fica a tarefa a ser executado em segundo plano
  
  try{ 
    statement1=con.createStatement();  
    resultado=statement1.executeQuery("SELECT *  FROM  `chat`  LIMIT 0 , 60");    //executa o comando que estava  o campo
    i=0;
    while(resultado.next()){i++; }
    
    resultado=statement1.executeQuery("SELECT *  FROM  `chat`  LIMIT 0 , 60");    //executa o comando que estava  o campo
    int i2=0;
    if(i>i3){
    while(resultado.next()){ 
    i2++;
    nomeb=resultado.getString("nome");            //str recebe o valor da variavel nome que estava englobada em resultado
    mensagem=resultado.getString("mensagem");              // i também recebe o valor de numero
    if(i2==i){
    i3=i;
    //appendString("<font color=GREEN>"+nomeb+"</font>"+ " disse: "+mensagemb+"<br>");
     frase=frase.concat("<font color=BLUE><b>"+nomeb+"</b></font>"+" disse: <b>"+mensagem+"</b><br>");
     display.setText(frase); 
     if(!nomeb.equals(nome)){
     AudioClip temp = Applet.newAudioClip(this.getClass().getResource("som.wav"));
     temp.play();
     }
    
    }
    
     
    
    }
    }
    
    }
    catch(Exception e){
    
    }
      
      
 
  }
  };
timer=new Timer(5000,task);                     // precisa dizer o tempo em ms, e indicar a tarefa
timer.start();                                  //precisa dar inicio á tarefa
}
 

 
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConectar;
    private javax.swing.JTextPane display;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea mensagemUsuario;
    private javax.swing.JTextField nomeUsuario;
    private javax.swing.JLabel statusConexao;
    // End of variables declaration//GEN-END:variables
}
