/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 *
 * @author Santiago
 */
public class ResourcesGetter {
    private ArrayList<String> listaRecursos = new ArrayList();
    

    public ArrayList<String> carregarRecursos(){
        ArrayList<String> resultado = new ArrayList();
        for (String stringURL: listaRecursos){
            String resposta = "";

            try {
                URL url = new URL(stringURL);
                URLConnection connection = url.openConnection();
                connection.addRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                        connection.getInputStream()));

                String inputLine;

                StringBuffer sb = new StringBuffer();
                while ((inputLine = in.readLine()) != null) sb.append(inputLine+"\n");
                resposta = sb.toString();
                resultado.add(resposta);
                in.close();
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    /**
     * @return the listaRecursos
     */
    public ArrayList<String> getListaRecursos() {
        return listaRecursos;
    }
}
