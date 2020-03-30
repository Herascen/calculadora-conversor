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
    @Test
    public void testConvertir(){
OperacionesSet esperado = new OperacionesSet("111101", "75", "61", "3D");
obj.convertir("75", 8, 1);
        Assertions.assertTrue(esperado.equals(obj.getOperaciones()));
       }
    
}

