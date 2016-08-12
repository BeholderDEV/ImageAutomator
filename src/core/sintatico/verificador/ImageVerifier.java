/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.sintatico.verificador;

import core.util.ArrayAdapter;
import core.web.ResourcesGetter;
import java.util.ArrayList;

/**
 *
 * @author 5663296
 */
public class ImageVerifier {
    
    //retorna o próximo estado, dado o estado atual e o símbolo lido
    public static int proximo_estado(char[] alfabeto, int[][] matriz,int estado_atual,char simbolo){
        int simbol_indice = ArrayAdapter.get_char_ref(alfabeto, simbolo);
        if (simbol_indice != -1){
            return matriz[estado_atual][simbol_indice];
        }else{
            return -1;
        }
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia e usa objeto que captura código-fonte de páginas Web
        ResourcesGetter crw = new ResourcesGetter();
        crw.getListaRecursos().add("http://lite.acad.univali.br/temideianarede");
        ArrayList<String> listaCodigos = crw.carregarRecursos();

        String codigoHTML = listaCodigos.get(0);

        //mapa do alfabeto
        char[] alfabeto = new char[5];
        alfabeto[0] = 's';
        alfabeto[1] = 'r';
        alfabeto[2] = 'c';
        alfabeto[3] = '=';
        alfabeto[4] = '"';


        //mapa de estados
        String[] estados = new String[7];
        estados[0] = "q0";
        estados[1] = "q1";
        estados[2] = "q2";
        estados[3] = "q3";
        estados[4] = "q4";
        estados[5] = "q5";
        estados[6] = "q6";

        String estado_inicial = "q0";

        //estados finais
        String[] estados_finais = new String[1];
        estados_finais[0] = "q5";

        //tabela de transição de AFD para reconhecimento números de dois dígitos
        int[][] matriz = new int[6][5];
        //transições de q0
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, 's')] = ArrayAdapter.get_string_ref(estados, "q1");
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, 'r')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, 'c')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, '"')] = -1;
        //transições de q1
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, 's')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, 'r')] = ArrayAdapter.get_string_ref(estados, "q2");
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, 'c')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, '"')] = -1;
        //transições de q2
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, 's')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, 'r')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, 'c')] = ArrayAdapter.get_string_ref(estados, "q3");
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, '"')] = -1;
        //transições de q3
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, 's')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, 'r')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, 'c')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, '=')] = ArrayAdapter.get_string_ref(estados, "q4");
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, '"')] = -1;
        //transições de q4
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, 's')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, 'r')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, 'c')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, '"')] = ArrayAdapter.get_string_ref(estados, "q5");
        //transições de q5
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, 's')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, 'r')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, 'c')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, '"')] = -1;


        
        int estado = ArrayAdapter.get_string_ref (estados, estado_inicial);
        int estado_anterior = -1;
        ArrayList<String> palavras_reconhecidas = new ArrayList();


        String palavra = "";

        //varre o código-fonte de um código
        for (int i=0; i<codigoHTML.length(); i++){

            estado_anterior = estado;
            estado = proximo_estado(alfabeto, matriz, estado, codigoHTML.charAt(i));
            //se o não há transição
            if (estado == -1){
                //pega estado inicial
                estado = ArrayAdapter.get_string_ref(estados, estado_inicial);
                // se o estado anterior foi um estado final
                if (ArrayAdapter.get_string_ref(estados_finais, estados[estado_anterior]) != -1){
                    //se a palavra não é vazia adiciona palavra reconhecida
                    if ( ! palavra.equals("")){
                        palavras_reconhecidas.add(palavra);
                    }
                    // se ao analisar este caracter não houve transição
                    // teste-o novamente, considerando que o estado seja inicial
                    i--;
                }
                //zera palavra
                palavra = "";
                
            }else{
                //se houver transição válida, adiciona caracter a palavra
                palavra += codigoHTML.charAt(i);
            }
        }


        //foreach no Java para exibir todas as palavras reconhecidas
        for (String p: palavras_reconhecidas){
            System.out.println (p);
        }


    }
}
