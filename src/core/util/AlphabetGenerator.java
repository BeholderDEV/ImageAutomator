/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.util;

/**
 *
 * @author Alisson
 */
public class AlphabetGenerator {
    public static String leters="";
    public static String alphabet="";

    public AlphabetGenerator() {
        
    }
    
    public static String generateAlphabet(){
        
        String arrays="";
        for(int i=0; i<alphabet.length();i++){
            String line = "alfabeto["+i+"] = '"+alphabet.charAt(i)+"';\n";
            arrays = arrays.concat(line);
        }
        return arrays;
    }
    public static String generateMatrix(String estado, int indexTroca, String proximoEstado){
        
        String arrays="";
        for(int i=0; i<alphabet.length();i++){
            String line = "matriz[ArrayAdapter.get_string_ref(estados, \""+estado+"\")][ArrayAdapter.get_char_ref(alfabeto, '"+alphabet.charAt(i)+"')] = -1;\n";
            if(i==indexTroca){
                line = "matriz[ArrayAdapter.get_string_ref(estados, \""+estado+"\")][ArrayAdapter.get_char_ref(alfabeto, '"+alphabet.charAt(i)+"')] = ArrayAdapter.get_string_ref(estados, \""+proximoEstado+"\");\n";
            }
            
            arrays = arrays.concat(line);
        }
        return arrays;
    }
    public static String generateLoopMatrix(String estado, int indexTroca, String proximoEstado){
        
        String arrays="";
        for(int i=0; i<alphabet.length();i++){
            String line = "matriz[ArrayAdapter.get_string_ref(estados, \""+estado+"\")][ArrayAdapter.get_char_ref(alfabeto, '"+alphabet.charAt(i)+"')] = ArrayAdapter.get_string_ref(estados, \""+proximoEstado+"\");\n"; 
            if(i==indexTroca){
                line = "matriz[ArrayAdapter.get_string_ref(estados, \""+estado+"\")][ArrayAdapter.get_char_ref(alfabeto, '"+alphabet.charAt(i)+"')] = ArrayAdapter.get_string_ref(estados, \"q6\");\n";
            }
            
            arrays = arrays.concat(line);
        }
        return arrays;
    }
    
    public static void main(String[] args) {
        String site = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
        leters = site.toLowerCase().replace(" ", "");
        alphabet = leters.concat("=\"");
//        System.out.println(generateAlphabet());
//        System.out.println("--------------");
        
        System.out.println("//transições de q0");
        System.out.println(generateMatrix("q0", 18, "q1"));
        
        System.out.println("//transições de q1");
        System.out.println(generateMatrix("q1", 17, "q2"));
        
        System.out.println("//transições de q2");
        System.out.println(generateMatrix("q2", 2, "q3"));
        
        System.out.println("//transições de q3");
        System.out.println(generateMatrix("q3", 26, "q4"));
        
        System.out.println("//transições de q4");
        System.out.println(generateMatrix("q4", 27, "q5"));
        
        System.out.println("//transições de q5");
        System.out.println(generateLoopMatrix("q5", 27, "q5"));
        
        System.out.println("//transições de q6");
        System.out.println(generateMatrix("q6", 100, "q5"));
    }
}
