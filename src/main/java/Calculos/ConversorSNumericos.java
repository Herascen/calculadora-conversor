
package Calculos;




public class ConversorSNumericos {
     OperacionesSet operaciones;
    public ConversorSNumericos(){
      
    }


 private int var=0;

    public OperacionesSet getOperaciones() {
        return operaciones;
    }

   

    public int getVar() {
        return var;
    }
 
 public String basesAdeci(String num, int basei){
  var++;
   
     double base = basei;
     double result = 0.0;
     int nume;
     double exp=0;
     if (basei==10) {
         result = 10.0;
      }else{
         for (int i = 0; i <= num.length()-1; i++) {
             exp = num.length()-1-i;
             if (base==16) {
                 nume = letterToInt(""+num.charAt(i));
             }else{
            nume = Integer.parseInt(""+num.charAt(i));}
            result = result + nume*Math.pow(base, exp);
         }
     }
   
     return Integer.toString((int)result);
 }
  public String deciAbases(String num, int basef){
      var++;
      
      String result = "";
       int nume = Integer.parseInt(num);
       if (basef==10 || nume<basef) {
           if (basef>=10 || basef<=16) {
               result = result + IntToLetter(nume);
           }else{
          result=result+num;}
      }else{
    
          
               
           
      while (nume>=basef) {          
          result = result + IntToLetter(nume%basef);
          nume = nume/basef;
          if (nume<basef) {
             result = result + IntToLetter(nume);
          }
      }
       String invertido = "";
           for (int i = result.length()-1; i >=0; i--) {
               invertido = invertido + result.charAt(i);
           } result = invertido;
}
     return result;
 }
  public void convertir(String num, int basei, int basef){
      String numero = basesAdeci(num, basei);
      if (basef==1) {
          operaciones = new OperacionesSet(deciAbases(numero, 2),deciAbases(numero, 8), numero, deciAbases(numero, 16));
      }else{
          operaciones = new OperacionesSet(numero, deciAbases(numero, basef));
      }
      
  }
  public int letterToInt(String letter){
     
      int value = 0;
      switch(letter){
          case "A":
              value = 10;
              break;
          case "B":
              value = 11;
              break;
          case "C":
              value = 12;
              break;
          case "D":
              value = 13;
              break;
          case "E":
              value = 14;
              break;
          case "F":
              value = 15;
              break;
      }
      if (value==0) {
          for (int i = 0; i < 10; i++) {
              if (Integer.parseInt(letter)==i) {
               value = i;
              }
          }
      }
      return value;
  }
  public String IntToLetter(int num){
      String letra = "";
      if (num<10) {
          letra = letra + num;
      }else{
      switch(num){
          case 10:
              letra = letra + "A";
              break;
          case 11:
             letra = letra + "B";
              break;
          case 12:
              letra = letra + "C";
              break;
          case 13:
             letra = letra + "D";
              break;
          case 14:
              letra = letra + "E";
              break;
          case 15:
             letra = letra + "F";
              break;
      }}
      return letra;
  }
}
