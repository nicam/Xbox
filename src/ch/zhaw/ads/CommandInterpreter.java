/** CommandInterpreter --  Praktikum Experimentierkasten -- SW3
 Dieses Interface muss von jedem Server implementiert werden.
 @author E. Mumprecht
 @version 1.0 -- Gerüst für irgendeinen Server
 @version 1.1 -- K. Rege Fehlerrückgabe hinzugefügt
 */ 
package ch.zhaw.ads;

public interface CommandInterpreter {
   
/** interpret  --  
 nimmt eine Kommandozeile, tut irgendetwas gescheites, und berichtet das Resultat.
 @param command Kommandozeile, üblicherweise Kommandowort gefolgt von Argumenten
 @return Resultat, üblicherweise eine oder mehrere Zeilen.
 */
   
   public String interpret(String command) throws Exception;
   
}//interface CommandInterpreter