/** AnyServer  --  Praktikum Experimentierkasten -- SW3
 @author E. Mumprecht
 @version 1.0 -- Gerüst für irgendeinen Server
 */ 
package ch.zhaw.ads;

public class AnyServer implements CommandInterpreter {
   
   private StringBuffer result;
      
   //----- Dies implementiert das CommandInterpreter Interface.

   public String interpret(String command) {
      result = new StringBuffer();
      result.append("Die Eingabe war: <");
      result.append(command);
      result.append(">\n");
      return(result.toString());
   }
   
}//AnyServer   
      