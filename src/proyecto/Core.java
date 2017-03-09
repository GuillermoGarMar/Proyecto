/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Random;

/**
 *
 * @author Guille
 */
public class Core {
    private int d1,d2,d3,d4;
    Random rdn1 = new Random();
    Random rdn2 = new Random();
    Random rdn3= new Random();
    Random rdn4 = new Random();
    
    public void rdn(){
        d1 = rdn1.nextInt(6)+1;
        d2 = rdn2.nextInt(6)+1;
        d3 = rdn3.nextInt(6)+1;
        d4 = rdn4.nextInt(6)+1;
    }
}
