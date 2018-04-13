/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examenmaven;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

/**
 *
 * @author quique
 */
public class Tiempo {
    static Document doc;
    static String title,temp;
    static Element temperatura, pronostico;
    
    /**
     * @param doc Es un objeto de tipo Document para conectarse a la página web
     * @param title Es un string que recoge el titulo de la pagina web
     * @param temperatura Es un objeto de tipo element que recoge el elemento con la etiqueta indicada
     * @param pronostico Es un objeto de tipo element que recoge el elemento con la etiqueta indicada
     * @exception IOException que recoge una excepción al conectarse a la URL
     */

    public static void sacarTiempo() {

        try {
             
            //Iniciamos la conexion con la página web
            doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();
            //Recibimos el titulo
            title = doc.title();
             
            //Buscamos las etiquetas con ese valor
            temperatura = doc.select("div.today_nowcard-temp").first();
            pronostico = doc.select("div.today_nowcard-phrase").first();
            
            //Mostramos todo por pantalla
           JOptionPane.showMessageDialog(null, title+"\n"+temperatura.text()+"\n"+pronostico.text());

        } catch (IOException ex) {
            System.out.println("Excepcion al conectarse a la URL "+ex);
        }
        
    }
    
}
