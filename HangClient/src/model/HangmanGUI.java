
package model;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;

/**
 *
 * @author Carlo
 */
class HangManDraw {
    HashMap <Integer, String[]> mapeo;
    public static String s[] = {
        "       ",
        "       ",       
        "       ", 		
        "       ",
        "       ",
        "---------------"};
     public static String s2[] = {
        "        ",
        "|       ",       
        "|       ", 		
        "|       ",
        "|       ",
        "---------------"};
      public static String s3[] = {
        "--------",
        "|       ",       
        "|       ", 		
        "|       ",
        "|       ",
        "---------------"};
       public static String s4[] = {
        "--------",
        "|      |",       
        "|       ", 		
        "|       ",
        "|       ",
        "---------------"};
       public static String s5[] = {
        "--------",
        "|      |",       
        "|      o", 		
        "|       ",
        "|       ",
        "---------------"};
        public static String s6[] = {
        "--------",
        "|      |",       
        "|      o", 		
        "|      |",
        "|       ",
        "---------------"};
        public static String s7[] = {
        "--------",
        "|      |",       
        "|      o", 		
        "|      |\\",
        "|       ",
        "---------------"};
       public static String s8[] = {
        "--------",
        "|      |",       
        "|      o", 		
        "|     /|\\",
        "|       ",
        "---------------"};
       public static String s9[] = {
        "--------",
        "|      |",       
        "|      o", 		
        "|     /|\\",
        "|       \\",
        "---------------"};
        public static String s10[] = {
        "--------",
        "|      |",       
        "|      o", 		
        "|     /|\\",
        "|     / \\",
        "---------------"};
        public String s0[] = {""};
        public HangManDraw() {
         mapeo = new HashMap<Integer, String[]>();
         mapeo.put(0, s0);
         mapeo.put(1, s);
         mapeo.put(2, s2);
         mapeo.put(3, s3);
         mapeo.put(4, s4);
         mapeo.put(5, s5);
         mapeo.put(6, s6);
         mapeo.put(7, s7);
         mapeo.put(8, s8);
         mapeo.put(9, s9);
         mapeo.put(10, s10);
         
        }
        public void printHangMan(int position) {
            for(int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
        }
        public String[] getHangmanDraw(int pos) {
            return mapeo.get(pos);
        }
}
public class HangmanGUI extends javax.swing.JFrame {
   
	
    Client clhm;
    Set <String> used;
    char words[];
    public HangmanGUI() {
        
        
        initComponents();
        clhm = new Client();
        used = new HashSet<String>();
        clhm.init();
    }
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_word = new javax.swing.JLabel();
        try_btn = new javax.swing.JButton();
        used_lbl = new javax.swing.JLabel();
        used_letters_lbl = new javax.swing.JLabel();
        letter_txt = new javax.swing.JTextField();
        lbl_message = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        draw_text = new javax.swing.JTextArea();
        reset_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_word.setText("_");

        try_btn.setText("Try Letter");
        try_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try_btnActionPerformed(evt);
            }
        });

        used_lbl.setText("Used letters:");

        used_letters_lbl.setText("_");

        letter_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letter_txtActionPerformed(evt);
            }
        });
        letter_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                letter_txtKeyReleased(evt);
            }
        });

        draw_text.setEditable(false);
        draw_text.setColumns(20);
        draw_text.setRows(5);
        jScrollPane1.setViewportView(draw_text);

        reset_btn.setText("Reset");
        reset_btn.setEnabled(false);
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_message, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(letter_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(lbl_word))
                            .addComponent(try_btn)
                            .addComponent(used_lbl)
                            .addComponent(used_letters_lbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reset_btn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(try_btn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(reset_btn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_word))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(letter_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_message, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(used_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(used_letters_lbl)
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void try_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_try_btnActionPerformed
       String current = letter_txt.getText();
       if(current.equals(""))
           return;
       if(used.contains(current)) {
           System.out.println("Word already used");
           lbl_message.setForeground(Color.red);
           lbl_message.setText("Letter already in use");
       } else {
           lbl_message.setText("");
           used.add(current);
           clhm.getLetter(current);
           int mistakes = clhm.getMistakes();
           int correct = clhm.getCorrect();
           if(mistakes >= 10) {
               JOptionPane.showMessageDialog(null, "You lost, better luck next time");
               reset_btn.setEnabled(true);
           }
           else if(correct == clhm.len_word) {
               JOptionPane.showMessageDialog(null, "You win, congratulations!");
               reset_btn.setEnabled(true);
           }
           
           HangManDraw hmd = new HangManDraw();
           
           System.out.println("mistakes: " + mistakes);
           String draw[] = hmd.getHangmanDraw(mistakes);
           draw_text.setText("");
           String hangcomplete = "";
           for(int i = 0; i < draw.length; i++) {
              hangcomplete += (draw[i])+"\n";
           }
            draw_text.setText(hangcomplete);
       }
       
       String useds = "";
       for(String c: used) {
           useds = useds + " " + c;
       }
       used_letters_lbl.setText(useds + "\n");
       
       words = clhm.getCurrentWord();
       lbl_word.setText("");
       useds = "";
       for(int i = 0; i < words.length; i++){
           useds += words[i]+"";
       }
       lbl_word.setText(useds);
       letter_txt.setText("");
    }//GEN-LAST:event_try_btnActionPerformed

    private void letter_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letter_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_letter_txtActionPerformed

    private void letter_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_letter_txtKeyReleased
        if(letter_txt.getText().length() >= 2) {
            letter_txt.setText(letter_txt.getText().charAt(0)+"");
        }
    }//GEN-LAST:event_letter_txtKeyReleased

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
       used = new HashSet<String>();
       draw_text.setText("");
       lbl_message.setText("");
       used_letters_lbl.setText("");
       lbl_word.setText("");
       clhm.closeAll();
       clhm = new Client();
       clhm.init();
       reset_btn.setEnabled(false);
    }//GEN-LAST:event_reset_btnActionPerformed
    
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
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangmanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HangmanGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea draw_text;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_message;
    private javax.swing.JLabel lbl_word;
    private javax.swing.JTextField letter_txt;
    private javax.swing.JButton reset_btn;
    private javax.swing.JButton try_btn;
    private javax.swing.JLabel used_lbl;
    private javax.swing.JLabel used_letters_lbl;
    // End of variables declaration//GEN-END:variables
}
