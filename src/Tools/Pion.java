/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Interface.Cellu;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Polygon;
public class Pion {
    
    private int x;               // ----- L'abscisse
    private int y;              // ----- L'ordonée
    private Color color;       // ----- La variable qui prend la color de pion
                              // ----- Il sera soit la couleur blanc ou noir
    public ArrayList<Pion> pions = new ArrayList<Pion>(); // ----- liste des pions
    
    // ---------- Constructeur ------------
    public Pion(Color color) 
    {
        super();
        this.x = 0;
        this.y = 0;
        this.color = color;
    }

    // -------- Getters & Setters -----------
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Pion> getPions() {
        return pions;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPions(ArrayList<Pion> pions) {
        this.pions = pions;
    }
    
    //-------- ToString --------------
    @Override
    public String toString() {
        return "Pion{" + "x=" + x + ", y=" + y + ", color=" + color + '}';
    }

    
    //--------- Dessiner pion ---------
    public void dessinerPion(Graphics2D g)
    {
        g.setColor(color);
         int rectY2=y;
         
        int rectX2=x;

 g.fillRect(rectX2 ,rectY2 , Cellu.TAILLE_CELL, Cellu.TAILLE_CELL);
 




      //  g.fillRect(x-2,y+10,ule.TAILLE_CELL*2, Cellule.TAILLE_CELL*2);
    }

    //------- Supprimer pion ----------
    public void remove(Pion p)
    {
        this.remove(p);
    }
}
