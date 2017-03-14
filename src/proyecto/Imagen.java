/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Guille Y Javi
 */
public class Imagen extends javax.swing.JPanel {
    int x,y;
    String c;
   
    public Imagen(JPanel jPanel1){
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x,y);
    }
    public void queImg(int n){
        if (n==1){
            c=("/Img/1.png");
        }else if(n==2){
            c=("/Img/2.png");
        }else if(n==3){
            c=("/Img/3.png");
        }else if(n==4){
            c=("/Img/4.png");
        }else if(n==5){
            c=("/Img/5.png");
        }else if(n==6){
            c=("/Img/6.png");
        }
    }
    @Override
    public void paint(Graphics g){
        ImageIcon Img = new ImageIcon(getClass().getResource(c));
        g.drawImage(Img.getImage(),0,0,x,y,null);
    }
}
