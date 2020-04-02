/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculos;

import java.util.logging.Logger;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import  static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;
/**
 *
 * @author herascen
 */
@DisplayName("ConversorSNumericoTest")

public class ConversorSNumericosTest {
 private Logger logger = Logger.getLogger("ConversorSNumericosTest.Logger");
    public ConversorSNumericosTest(){
        
    }
   
    static ConversorSNumericos obj;
    
    @BeforeAll
    static void setUpClass(){
        obj = new ConversorSNumericos();
    }
    @BeforeEach
    void setUp(){
       
    }
     /**
     * Test of getElementos method, of class OperacionesSet.
     */
    static Stream<Arguments> baseAdeciProvider(){
        return Stream.of(arguments(2,"1100"),
                arguments(8,"14"),
                arguments(16,"C"),
                arguments(3,"110"),
                arguments(6,"20"));
    }
    static Stream<Arguments> convertirProvider(){
        return Stream.of(
                arguments(8,1,"75",new String []{"111101", "75", "61", "3D"}),
                 arguments(16,1,"798",new String []{"11110011000","3630","1944","798"}),
                  arguments(2,1,"11010011",new String []{"11010011","323","211","D3"}),
                  arguments(16,2,"65F",new String []{"65F","11001011111"})
                  
        );
    }
  static Stream<Arguments> letterToIntProvider(){
      return Stream.of(
              arguments("A",10),
              arguments("7", 7),
              arguments("F", 15),
              arguments("1", 1),
              arguments("C", 12)
      
      );
  }
    @DisplayName("baseAdeciTest")
    @ParameterizedTest
    @MethodSource("baseAdeciProvider")
    public void testBaseAdeci(int base, String convertido){
        
        System.out.println("a punto de convertir a base " + base);
       assertEquals("12", obj.basesAdeci(convertido, base));
        // TODO review the generated test code and remove the default call to fail.
       
    }
    @DisplayName("deciAbasesTest")
    @ParameterizedTest
    @MethodSource("baseAdeciProvider")
    public void testDeciAbases(int base, String convertido){
      assertEquals(convertido, obj.deciAbases("12", base));
    }
    
  
    @ParameterizedTest
    @MethodSource("convertirProvider")
    public void testConvertir(int basei, int basef,String num, String[] numeros){
OperacionesSet esperado = new OperacionesSet(numeros);
obj.convertir(num, basei, basef);
        Assertions.assertTrue(esperado.equals(obj.getOperaciones()));
       }
    
    @ParameterizedTest
    @MethodSource("letterToIntProvider")
    public void testletterToInt(String input, int output){
        assertEquals(output, obj.letterToInt(input));
    }
    
    @ParameterizedTest
    @MethodSource("letterToIntProvider")
    public void testIntToLetter(String input, int output){
        assertEquals(input, obj.IntToLetter(output));
    }
}

