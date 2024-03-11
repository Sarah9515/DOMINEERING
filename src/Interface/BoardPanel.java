/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Interface;
 
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.JTextField;
import java.awt.Point;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import Tools.Outils;
import Tools.Pion;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
public class BoardPanel extends javax.swing.JPanel {
      public static int TAILLE_CELL = 50; // Adjust this as needed
    public static int TAILLE_BOARD = 400;
   // public static Cellu board [];          //------ Tables des cellule qui vont construire notre othellier
   // public static int TAILLE_BOARD = 400;    //------ Dimension de notre plateau   
        private List<Point> whitePawnPositions = new ArrayList<>();
        private List<Point> blackPawnPositions=new ArrayList<>();
     private List<Rectangle> rectangles = new ArrayList<>();
    //------- Constructeur -----------
   private List<Point> pionPositions = new ArrayList<>(); 
   
     private boolean isPionOfOppositeColor(int x, int y, Color color) {
        for (Point position : pionPositions) {
            int pionX = position.x;
            int pionY = position.y;

            if (pionX == x+1 && pionY == y+1 && getColorAtPosition(x, y).equals(color)) {
                return true;
            }
        }

        return false;
    }

    private Color getColorAtPosition(int x, int y) {
        for (Point position : pionPositions) {
            int pionX = position.x;
            int pionY = position.y;

            if (pionX == x && pionY == y) {
                return Color.BLACK; // Assuming the default color is black
            }
        }

        return Color.WHITE; // Assuming the default color is white
    } 
    
      
        private boolean isPionAlreadyExistse(int x, int y ) {
         
       // System.out.println("Checking position: x = " + x + ", y = " + y);
       // return pionPositions.contains(new Point(x, y));
           for (Point position : pionPositions) {
           //  if(getColorAtPosition(x, y).equals(Color.BLACK)){
        int pionX = position.x;
        int pionY = position.y;

          if (pionX == x+1 && pionY == y     && isblackPawnAtPosition(x+1, y)||
                pionX == x && pionY == y     && isblackPawnAtPosition(x, y)   ||
                  pionX == x+1 && pionY == y-1     && isblackPawnAtPosition(x+1, y-1)
                  || pionX == x && pionY == y-1     && isblackPawnAtPosition(x, y-1)
                  ||   pionX == x && pionY == y    
                ) {

            // Check if the current position allows placing a black pion
             
             
               
                 
                return true;
            
        }
          
            if(pionX== x-1 &&pionY==y && isWhitePawnAtPosition(x-1,y) || pionX== x+1 &&pionY==y && isWhitePawnAtPosition(x+1,y) ){
            return true;
        }
           
          
    }
         //  }    
    return false;
           
    }
   
   private boolean isWhitePawnAtPosition(int x, int y) {
    for (Point whitePawnPosition : whitePawnPositions) {
        if (whitePawnPosition.x == x && whitePawnPosition.y == y) {
            return true;
        }
    }
    return false;
}
   
   
     private boolean isblackPawnAtPosition(int x, int y) {
    for (Point blackPawnPosition : blackPawnPositions) {
        if (blackPawnPosition.x == x && blackPawnPosition.y == y) {
            return true;
        }
    }
    return false;
}
  
   
    
    public BoardPanel() {
         
        initComponents();
      
       // creation();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / TAILLE_CELL;
                int y = e.getY() / TAILLE_CELL;
             
   if (isPionAlreadyExists(x, y)  || isAtEdge(x,y) ) {
                    JOptionPane.showMessageDialog(BoardPanel.this, "Pion already exists at this position!");
                    return;  // Exit the method if pion already exists
                }
 
    
Color randomColor = Color.BLACK;
             
               Graphics g = getGraphics();
                g.setColor(randomColor);
                  int rectangleWidth = TAILLE_CELL;
                int rectangleHeight = TAILLE_CELL * 2;

                g.fillRect(x * TAILLE_CELL, y * TAILLE_CELL, rectangleWidth, rectangleHeight);
                 g.setColor(Color.WHITE);
                g.drawRect(x * TAILLE_CELL, y * TAILLE_CELL, rectangleWidth, rectangleHeight);
                 
                pionPositions.add(new Point(x, y));
                System.out.println("Machine added black  pawn at position: x = " + x + ", y = " + y);
                checkGameOver();
                blackPawnPositions.add(new Point(x, y));
               makeMachineMove();
       
            }
            
        });
      //  creation();
       
    }
         
        private void makeMachineMove() {
        // Implement logic for the computer's move
        // For simplicity, let's make a random move
        
         
        Random random = new Random();
      //  Color randomc = Color.BLACK;
        int x, y;
           int rectangleWidthe = TAILLE_CELL *2;
                int rectangleHeighte = TAILLE_CELL ;

               
                
        do {
            x = random.nextInt(8);
            y = random.nextInt(8);
        } while (isPionAlreadyExistse(x, y) || isAtEdgee(x,y)  );
      /* if (isPionAlreadyExistse(x, y)  || isAtEdge(x,y) ) {
                    JOptionPane.showMessageDialog(BoardPanel.this, "Pion already exists at this position!");
                    return;  // Exit the method if pion already exists
                }*/

//


Color randomColor = Color.WHITE;
             
               Graphics g = getGraphics();
                g.setColor(randomColor);
                  int rectangleWidth = TAILLE_CELL;
                int rectangleHeight = TAILLE_CELL *2;
 
                g.fillRect(x * TAILLE_CELL, y * TAILLE_CELL, rectangleWidthe, rectangleHeighte);
                 
              g.setColor(Color.BLACK);
                g.drawRect(x * TAILLE_CELL, y * TAILLE_CELL, rectangleWidthe, rectangleHeighte);
                pionPositions.add(new Point(x, y));
        System.out.println("Machine added white pawn at position: x = " + x + ", y = " + y);
       
      //  repaint();
whitePawnPositions.add(new Point(x, y));
        checkGameOver();
  
         // Trigger a repaint to draw the new pawn
    
 
      //  isPlayerTurn = true;
    
        
        }    
   
     private boolean isAtEdge(int x, int y) {
    int rectangleWidthe = TAILLE_CELL * 2;
    int rectangleHeighte = TAILLE_CELL;

    return     y == 7  ;
}   
          private boolean isAtEdgee(int x, int y) {
    int rectangleWidthe = TAILLE_CELL * 2;
    int rectangleHeighte = TAILLE_CELL;

    return     x == 7  ;
} 
          
   private boolean isAtEdgeee(int x, int y) {
    return   x == 7  ||  y == 7;
}       
        
private void checkGameOver() {
    
  
    
    if (!hasAvailableMoves()) {
        JOptionPane.showMessageDialog(BoardPanel.this, "Game Over! It's a draw.");
        System.exit(0);
    }
   
   
   
   
   
   
   
   
}
private boolean hasAvailableMoves() {
    
  
    
    
    
    
    
    
    
    
   for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (!isPionAlreadyExists(i, j)  ||!isPionAlreadyExistse(i, j) || !(j== 7 && isPionAlreadyExists(i + 1, j-1))   ) {
                 
                return true; // Found an available move
                
            }
            
        
    
        }
    
    
    
    }
    return false; // No available moves
   
  
   


}
   

  @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw existing rectangles based on pionPositions
        for (Point position : pionPositions) {
            int x = position.x * TAILLE_CELL;
            int y = position.y * TAILLE_CELL;

            int rectangleWidth = TAILLE_CELL;
            int rectangleHeight = TAILLE_CELL *2;

            g.setColor(Color.PINK);
            g.fillRect(x, y, rectangleWidth, rectangleHeight);
        }
        
       
    }
 
    
        private boolean isPionAlreadyExists(int x, int y) {
         
       // System.out.println("Checking p-osition: x = " + x + ", y = " + y);
       // return pionPositions.contains(new Point(x, y));
           for (Point position : pionPositions) {
             
        int pionX = position.x;
        int pionY = position.y;
 
        if (pionX == x && pionY == y + 1    && isWhitePawnAtPosition(x, y+1)
                || pionX == x && pionY == y     && isWhitePawnAtPosition(x, y)
               // || (pionX == x && pionY == y - 1  )
                || pionX == x - 1 && pionY == y + 1 && isWhitePawnAtPosition(x-1, y+1 ) 
                || pionX == x - 1 && pionY == y && isWhitePawnAtPosition(x-1, y )
              //  || pionX == x + 1 && pionY == y  && isWhitePawnAtPosition(x+1, y )
               ||   pionX == x && pionY == y  
                
                ) {

            // Check if the current position allows placing a black pion
             
             
               
                 
                return true;
            
        }
        if(pionX== x &&pionY==y-1 && isblackPawnAtPosition(x,y-1) || pionX== x &&pionY==y+1 && isblackPawnAtPosition(x,y+1) ){
            return true;
        }
     
     /* if ( pionX == x && pionY == y - 1  && isWhitePawnAtPosition(x, y-1 )) {
            return true;
        }  */
   

//

}
          
           
    return false;
           
    }

  
 
    




    //----------- Getter--------------
  /*  public Cellu[] getBoard()
    {
        return board;
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    //------ Creation des cellules -----------
    /*
     public void creation() {

        int count = 0;
        int k = 0;

   
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                count++;
                if (count % 9 == 0)
                    break;
                Cellu cellu = new Cellu(k);
                cellu.setBounds(j * Cellu.TAILLE_CELL, i * Cellu.TAILLE_CELL, Cellu.TAILLE_CELL, Cellu.TAILLE_CELL);
                cellu.addMouseListener(cellu);
                this.add(cellu);
                k++;
            }
            count = 0;
        }

        // No need to draw the initial pions here

        this.repaint();
    }
    // Variables declaration - do not modify
    // End of variables declaration
} 
    /*
    public void creation() {
        
        //------ L'instanciation 
        board = new Cellu[64];     
        
        int count = 0;
        int k = 0;
      
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                count++;
                if(count % 9 == 0)
                    break;
                board[k] = new Cellu(k);
                board[k].setBounds(j * Cellu.TAILLE_CELL, i * Cellu.TAILLE_CELL, Cellu.TAILLE_CELL, Cellu.TAILLE_CELL);
                board[k].addMouseListener(board[k]);
                this.add(board[k]);
                k++;
            }
            count = 0;
        }
        
        //------- dessiner les 4 pions de debut
        board[27].drawPion(Color.white);
        board[28].drawPion(Color.black);
        board[35].drawPion(Color.black);
        board[36].drawPion(Color.white);
        
        this.repaint();
    }
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}








