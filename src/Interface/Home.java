/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Tools.ConnectionManager;
import Tools.OthelloPosition;
import Tools.Outils;
import Tools.PlayOthello;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Home extends javax.swing.JFrame {
    
    
    /***************************************************************************
     * Les élèments de connection à la base de données *************************
     **************************************************************************/
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
  
    public static int idUser = 0;      //----- La variable correspondant au id du joeur
    public static int idPartie = 0;    //----- La variable correspondant au id d'une partie d'un joueur
    public static BoardPanel board;     //---- L'othellier
    
    //------- Getters & Setters -----------
    public BoardPanel getBoard()
    {
        return this.board;
    }
    
    public void setBoard(BoardPanel board) {
        this.board = board;
    }
    
    public int getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
       
    
    //------- Constructeur -----------
    public Home() throws SQLException, ClassNotFoundException {
        initComponents();
        
        Outils.gameOver = false;
        noirTxt.setEditable(false);
        blancTxt.setEditable(false);
        playPositionBtn.setEnabled(false);
        
        //------- Se connecter à la BDD
        connection = ConnectionManager.getConnection();
        
        //------- Creer un nouveau plateau 
        board = new BoardPanel();
       // board.setSize(new Dimension(TAILLE_BOARD, TAILLE_BOARD));
        board.setBounds(0, 0, BoardPanel.TAILLE_BOARD, BoardPanel.TAILLE_BOARD);
        boardPane.add(board);
        boardPane.repaint();
        
        /***********************************************************************
         * La requete de selection l'id et l'etat d'une partie, un etat signifie
         * si la partie est terminé ou non
         * ********************************************************************/
        String qry = "select idPosition, etatPosition from position where idUser = ?";
        this.ps = this.connection.prepareStatement(qry);
        this.ps.setInt(1, this.idUser);
        this.rs = this.ps.executeQuery();
        
        while(this.rs.next())
        {
            this.positionUserCB.addItem(String.valueOf(this.rs.getInt(1)) + "  " + String.valueOf(this.rs.getInt(2) == 0 ? "Non" : "Oui"));
        }
        
        if(this.positionUserCB.getItemCount() != 0)
            playPositionBtn.setEnabled(true);
        else
            playPositionBtn.setEnabled(false);
         //----- Centrer la fenetre 
        Dimension screenSize,frameSize;
        int x,y;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize=getSize();
        x=(screenSize.width-frameSize.width)/2;
        y=(screenSize.height-frameSize.height)/2;
        setLocation(x, y);
        
        //------ mettre la fenetre non Resizable
        this.setResizable(false);
        
        //------ Icon de frame
        Image icon = Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/o3.png"));  
        this.setIconImage(icon); 
        
        //------ Titre de frame
        this.setTitle("Othello");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        boardPane = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        depthCB = new javax.swing.JComboBox<>();
        deconnexionBtn = new javax.swing.JButton();
        positionUserCB = new javax.swing.JComboBox<>();
        playPositionBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        hommeMachineCB = new javax.swing.JComboBox<>();
        playNewBtn = new javax.swing.JButton();
        noirTxt = new javax.swing.JTextField();
        blancTxt = new javax.swing.JTextField();
        blancLbl = new javax.swing.JLabel();
        noirLbl = new javax.swing.JLabel();
        timerLbl = new javax.swing.JLabel();
        second = new javax.swing.JLabel();
        millisecond = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        resultValueLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        resultValueLbl1 = new javax.swing.JLabel();
        undoBtn = new javax.swing.JButton();
        noirLbl1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setBackground(new java.awt.Color(204, 255, 204));

        contentPane.setBackground(new java.awt.Color(243, 241, 199));
        contentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boardPane.setBackground(new java.awt.Color(153, 102, 0));
        boardPane.setForeground(new java.awt.Color(51, 255, 0));
        boardPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boardPane.setMinimumSize(new java.awt.Dimension(400, 400));
        boardPane.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout boardPaneLayout = new javax.swing.GroupLayout(boardPane);
        boardPane.setLayout(boardPaneLayout);
        boardPaneLayout.setHorizontalGroup(
            boardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        boardPaneLayout.setVerticalGroup(
            boardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        contentPane.add(boardPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 6, -1, -1));

        exit.setBackground(new java.awt.Color(225, 7, 14));
        exit.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setText("Quitter");
        exit.setToolTipText("");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        contentPane.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 162, -1));

        depthCB.setBackground(new java.awt.Color(243, 241, 199));
        depthCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facile", "Moyen", "Difficile" }));
        contentPane.add(depthCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 123, -1));

        deconnexionBtn.setBackground(new java.awt.Color(0, 0, 255));
        deconnexionBtn.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        deconnexionBtn.setForeground(new java.awt.Color(255, 255, 255));
        deconnexionBtn.setText("Se déconnecter");
        deconnexionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexionBtnActionPerformed(evt);
            }
        });
        contentPane.add(deconnexionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 162, 30));

        contentPane.add(positionUserCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 123, 27));

        playPositionBtn.setBackground(new java.awt.Color(0, 153, 0));
        playPositionBtn.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        playPositionBtn.setForeground(new java.awt.Color(255, 255, 255));
        playPositionBtn.setText("Jouer");
        playPositionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPositionBtnActionPerformed(evt);
            }
        });
        contentPane.add(playPositionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 77, -1));

        saveBtn.setBackground(new java.awt.Color(0, 0, 255));
        saveBtn.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Enregistrer");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        contentPane.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 164, 30));

        hommeMachineCB.setBackground(new java.awt.Color(243, 241, 199));
        hommeMachineCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Homme/Machine", "Homme/Homme" }));
        contentPane.add(hommeMachineCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        playNewBtn.setBackground(new java.awt.Color(0, 153, 0));
        playNewBtn.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        playNewBtn.setForeground(new java.awt.Color(255, 255, 255));
        playNewBtn.setText("Nouvelle partie");
        playNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playNewBtnActionPerformed(evt);
            }
        });
        contentPane.add(playNewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 164, 30));

        noirTxt.setEditable(false);
        noirTxt.setBackground(new java.awt.Color(243, 241, 199));
        noirTxt.setText("2");
        contentPane.add(noirTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 50, -1));

        blancTxt.setEditable(false);
        blancTxt.setBackground(new java.awt.Color(243, 241, 199));
        blancTxt.setText("2");
        contentPane.add(blancTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 50, -1));

        blancLbl.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        blancLbl.setText("Blanc :");
        contentPane.add(blancLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 70, 20));

        noirLbl.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        noirLbl.setText("Annuler");
        contentPane.add(noirLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 70, 20));

        timerLbl.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        timerLbl.setText("Timer :");
        contentPane.add(timerLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 229, -1, -1));

        second.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        second.setText("00");
        contentPane.add(second, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, -1, -1));

        millisecond.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        millisecond.setText(":00");
        contentPane.add(millisecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 229, -1, 20));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel1.setText("Niveau");
        contentPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        jLabel2.setText(" Joueur :");
        contentPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel3.setText("Résultat ");
        contentPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, -1, -1));

        resultValueLbl.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        contentPane.add(resultValueLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 424, 131, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2_opt_opt.png"))); // NOI18N
        contentPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 50, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blanc.png"))); // NOI18N
        contentPane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 30, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b1_opt_opt.png"))); // NOI18N
        contentPane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 50, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/noir.png"))); // NOI18N
        contentPane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 30, 30));

        resultValueLbl1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        contentPane.add(resultValueLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 200, 40));

        undoBtn.setBackground(new java.awt.Color(243, 241, 199));
        undoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/undo-icon.png"))); // NOI18N
        undoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoBtnActionPerformed(evt);
            }
        });
        contentPane.add(undoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 50, 40));

        noirLbl1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        noirLbl1.setText("Noir :");
        contentPane.add(noirLbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 70, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //------ Methode Play() -------
    private void play() {
        
        new Thread(new PlayOthello()).start();
    }
    
    //-------- Button :  Quitter --------
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        setDefaultCloseOperation(Home.DISPOSE_ON_CLOSE);
        setVisible(false);  
    }//GEN-LAST:event_exitActionPerformed
    
    //-------- Button : Se deconnecter ---------
    private void deconnexionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexionBtnActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir se déconnecter ?");
        if (a == JOptionPane.YES_OPTION) {
            this.idUser = 0;
            dispose();
            
            try {
                Authentification auth = new Authentification();
                auth.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deconnexionBtnActionPerformed
   
        //--------- Button : jouer une ancienne partie ----------
    private void playPositionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPositionBtnActionPerformed

        resultValueLbl1.setText("No result yet !");
        saveBtn.setEnabled(true);
        
        try {
            String pos = this.positionUserCB.getSelectedItem().toString();
            int idPosition = Integer.parseInt(pos.split(" ")[0]);
            idPartie = idPosition;

            String br = "";
            String qry = "select board from position where idPosition = ?";
            this.ps = this.connection.prepareStatement(qry);
            ps.setInt(1, idPosition);
            this.rs = this.ps.executeQuery();
            while(this.rs.next())
            {
                br = this.rs.getString(1);
                break;
            }
            int [] brd = new int[64];
            for(int i = 0; i < 64; i++)
            {
                brd[i] = Integer.parseInt(br.split(" ")[i]);
            }

            OthelloPosition p = new OthelloPosition();
            p.setBoard(brd);
            Outils.position = p;

            play();
               
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_playPositionBtnActionPerformed

    
    //----------- Button : Enregistrer --------
    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
        OthelloPosition pos = (OthelloPosition) Outils.position;
        String br = "";
        int etat = 0;
        for(int i = 0; i < 64; i++)
            br = br + pos.getBoard()[i] + " ";
        
        etat = pos.etat() ? 1 : 0;
        
        //------- Enregister la partie s'elle est nouvelle
        if(idPartie == 0)
        {
            try {
                String qry = "insert into position (board, etatPosition, idUser) values (?, ?, ?)";
                this.ps = this.connection.prepareStatement(qry);
                this.ps.setString(1, br);
                this.ps.setInt(2, etat);
                this.ps.setInt(3, this.idUser);
                this.ps.execute();
                
                JOptionPane.showMessageDialog(this, "Enregistré", "Bien enregistrée !", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //------ Modifier la partie s'elle est ancienne
        else
        {
            try {
                String qry = "update position set board = ?, etatPosition = ? where idPosition = ?";
                this.ps = this.connection.prepareStatement(qry);
                this.ps.setString(1, br);
                this.ps.setInt(2, etat);
                this.ps.setInt(3, idPartie);
                this.ps.execute();

                JOptionPane.showMessageDialog(this, "Modifié", "Bien modifié !", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //------- Rafraîchir la ComboBox des parties de l'utilisateur
        this.positionUserCB.removeAllItems();
        try {
            String req = "select idPosition, etatPosition from position where idUser = ?";
            this.ps = this.connection.prepareStatement(req);
            this.ps.setInt(1, idUser);
            this.rs = this.ps.executeQuery();
            while(this.rs.next())
            {
                this.positionUserCB.addItem(String.valueOf(this.rs.getInt(1)) + "  " + String.valueOf(this.rs.getInt(2) == 0 ? "Non" : "Oui"));
            }
            if(this.positionUserCB.getItemCount() != 0)
                playPositionBtn.setEnabled(true);
            else
                playPositionBtn.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    
    //----------- Button : Nouvelle partie --------
    private void playNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playNewBtnActionPerformed
        idPartie = 0;
        Outils.gameOver = false;
        resultValueLbl1.setText("No result yet !");
        saveBtn.setEnabled(true);
        int indexDepth = this.depthCB.getSelectedIndex();
        switch(indexDepth) {
            case 0: // Facile
                Outils.depth = 0;
                break;
            case 1: // Moyen
                Outils.depth = 5;
                break;
            case 2: // Difficile
                Outils.depth = 8;
                break;
        }
        
        OthelloPosition p = new OthelloPosition();
        Outils.position = p;

        play();
    }//GEN-LAST:event_playNewBtnActionPerformed

    private void undoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoBtnActionPerformed
        Outils.position = Outils.lastPosition;
        play();
        
    }//GEN-LAST:event_undoBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blancLbl;
    public static javax.swing.JTextField blancTxt;
    private javax.swing.JPanel boardPane;
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton deconnexionBtn;
    private javax.swing.JComboBox<String> depthCB;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox<String> hommeMachineCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel millisecond;
    private javax.swing.JLabel noirLbl;
    private javax.swing.JLabel noirLbl1;
    public static javax.swing.JTextField noirTxt;
    private javax.swing.JButton playNewBtn;
    private javax.swing.JButton playPositionBtn;
    private javax.swing.JComboBox<String> positionUserCB;
    private javax.swing.JLabel resultValueLbl;
    public static javax.swing.JLabel resultValueLbl1;
    public static javax.swing.JButton saveBtn;
    public static javax.swing.JLabel second;
    private javax.swing.JLabel timerLbl;
    private javax.swing.JButton undoBtn;
    // End of variables declaration//GEN-END:variables
}
