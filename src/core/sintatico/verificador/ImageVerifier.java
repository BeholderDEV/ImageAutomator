/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.sintatico.verificador;

import core.util.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 5663296
 */
public class ImageVerifier {
    
    //retorna o próximo estado, dado o estado atual e o símbolo lido
    public int proximo_estado(char[] alfabeto, int[][] matriz,int estado_atual,char simbolo){
        
        if(estado_atual == 2 && simbolo != '.' && simbolo != '\"'){
            simbolo = 'L';
        }
        if(estado_atual == 3 && simbolo != 'j' && simbolo != 'p' && simbolo != '"'){
            simbolo = 'L';
        }
        if(estado_atual == 4 && simbolo != 'p' && simbolo != '"'){
            simbolo = 'L';
        }
        if(estado_atual == 5 && simbolo != 'g' && simbolo != '"'){
            simbolo = 'L';
        }
        if(estado_atual == 6 && simbolo != 'n' && simbolo != '"'){
            simbolo = 'L';
        }

        
        int simbol_indice = ArrayAdapter.get_char_ref(alfabeto, simbolo);
        
        if (simbol_indice != -1){
            return matriz[estado_atual][simbol_indice];
        }else{
            return -1;
        }
    }

    public List<String> getSources(String codigoHTML){
        //mapa do alfabeto
        char[] alfabeto = new char[8];
        alfabeto[0] = '.';
        alfabeto[1] = 'j';
        alfabeto[2] = 'p';
        alfabeto[3] = 'g';
        alfabeto[4] = 'n';
        alfabeto[5] = '"';
        alfabeto[6] = 'L';
        alfabeto[7] = '=';

        //mapa de estados
        String[] estados = new String[10];
        estados[0] = "q0";
        estados[1] = "q1";
        estados[2] = "q2";
        estados[3] = "q3";
        estados[4] = "q4";
        estados[5] = "q5";
        estados[6] = "q6";
        estados[7] = "q7";
        estados[8] = "q8";
        estados[9] = "q9";
        
        String estado_inicial = "q0";

        //estados finais
        String[] estados_finais = new String[1];
        estados_finais[0] = "q9";

        //tabela de transição de AFD para reconhecimento números de dois dígitos
        int[][] matriz = new int[10][8];
        
        //transições de q0
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, '"')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, '.')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q0")][ArrayAdapter.get_char_ref(alfabeto, '=')] = ArrayAdapter.get_string_ref(estados, "q1");
        
        //transições de q1
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, '"')] = ArrayAdapter.get_string_ref(estados, "q2");
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, '.')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q1")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        
        //transições de q2
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, '"')] = ArrayAdapter.get_string_ref(estados, "q7");
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, '.')] = ArrayAdapter.get_string_ref(estados, "q3");
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = ArrayAdapter.get_string_ref(estados, "q2");
        matriz[ArrayAdapter.get_string_ref(estados, "q2")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        
        //transições de q3
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, '"')] = ArrayAdapter.get_string_ref(estados, "q7");
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, '.')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = ArrayAdapter.get_string_ref(estados, "q4");
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = ArrayAdapter.get_string_ref(estados, "q6");
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = ArrayAdapter.get_string_ref(estados, "q2");;
        matriz[ArrayAdapter.get_string_ref(estados, "q3")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        
        //transições de q4
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, '"')] = ArrayAdapter.get_string_ref(estados, "q7");
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, '.')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = ArrayAdapter.get_string_ref(estados, "q5");;
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = ArrayAdapter.get_string_ref(estados, "q2");
        matriz[ArrayAdapter.get_string_ref(estados, "q4")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        
        //transições de q5
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, '"')] = ArrayAdapter.get_string_ref(estados, "q7");
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, '.')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = ArrayAdapter.get_string_ref(estados, "q8");;
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = ArrayAdapter.get_string_ref(estados, "q2");
        matriz[ArrayAdapter.get_string_ref(estados, "q5")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        
        //transições de q6
        matriz[ArrayAdapter.get_string_ref(estados, "q6")][ArrayAdapter.get_char_ref(alfabeto, '"')] = ArrayAdapter.get_string_ref(estados, "q7");
        matriz[ArrayAdapter.get_string_ref(estados, "q6")][ArrayAdapter.get_char_ref(alfabeto, '.')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q6")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q6")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q6")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q6")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = ArrayAdapter.get_string_ref(estados, "q5");;
        matriz[ArrayAdapter.get_string_ref(estados, "q6")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = ArrayAdapter.get_string_ref(estados, "q2");;
        matriz[ArrayAdapter.get_string_ref(estados, "q6")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        
        //transições de q7
        matriz[ArrayAdapter.get_string_ref(estados, "q7")][ArrayAdapter.get_char_ref(alfabeto, '"')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q7")][ArrayAdapter.get_char_ref(alfabeto, '.')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q7")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q7")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q7")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q7")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q7")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q7")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        
        //transições de q8
        matriz[ArrayAdapter.get_string_ref(estados, "q8")][ArrayAdapter.get_char_ref(alfabeto, '"')] = ArrayAdapter.get_string_ref(estados, "q9");;
        matriz[ArrayAdapter.get_string_ref(estados, "q8")][ArrayAdapter.get_char_ref(alfabeto, '.')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q8")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q8")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q8")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q8")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q8")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q8")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        
        //transições de q9
        matriz[ArrayAdapter.get_string_ref(estados, "q9")][ArrayAdapter.get_char_ref(alfabeto, '"')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q9")][ArrayAdapter.get_char_ref(alfabeto, '.')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q9")][ArrayAdapter.get_char_ref(alfabeto, 'j')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q9")][ArrayAdapter.get_char_ref(alfabeto, 'p')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q9")][ArrayAdapter.get_char_ref(alfabeto, 'g')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q9")][ArrayAdapter.get_char_ref(alfabeto, 'n')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q9")][ArrayAdapter.get_char_ref(alfabeto, 'L')] = -1;
        matriz[ArrayAdapter.get_string_ref(estados, "q9")][ArrayAdapter.get_char_ref(alfabeto, '=')] = -1;
        
        
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
        return palavras_reconhecidas;

    }
}
