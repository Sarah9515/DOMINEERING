/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;
import Interface.Cellu;
import java.util.ArrayList;
import java.util.List;
public class Outils {
    
      private static Cellu[][] grid = new Cellu[8][8];

    // This method returns a specific Cellule at the given coordinates
 public static Cellu getSpecificCellule(int x, int y) {
    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
        return grid[x][y];
    } else {
        System.out.println("Invalid indices: x=" + x + ", y=" + y);
        return null;
    }
}
    public static boolean isClicked = false; //---- un boolean qui retourne true 
    private static List<Cellu> listOfAllCellules = new ArrayList<>();                                      //si le joueur clique sur le board pour dessiner un pion
    
    public static int moveIndex = 0;       //----- la position de pion à dessiner
    public static Position position;
    public static int depth = 0;           //----- la profendeur
    public static boolean gameOver = false;         //----- Si le joueur depasse le timer, on va retourner True
    public static OthelloPosition lastPosition = new OthelloPosition();
     
    
    public static Cellu getCelluleById(int id) {
        // Assuming you have a list of all cellules in your application
        // Replace "listOfAllCellules" with your actual list of Cellule objects
        for (Cellu cellule : listOfAllCellules) {
            if (cellule.getId() == id) {
                return cellule;
            }
        }
        return null; // Return null if no Cellule with the specified ID is found
    }
}

