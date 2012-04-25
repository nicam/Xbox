/** CommandInterpreter --  Praktikum Experimentierkasten -- SW3
 Dieses Interface muss von jedem Server implementiert werden.
 @author E. Mumprecht
 @version 1.0 -- Ger�st f�r irgendeinen Server
 @version 1.1 -- K. Rege Fehlerr�ckgabe hinzugef�gt
 */ 
package ch.zhaw.ads;

public interface CommandInterpreter {
   
/** interpret  --  
 nimmt eine Kommandozeile, tut irgendetwas gescheites, und berichtet das Resultat.
 @param command Kommandozeile, �blicherweise Kommandowort gefolgt von Argumenten
 @return Resultat, �blicherweise eine oder mehrere Zeilen.
 */
   
   public String interpret(String command) throws Exception;
   
}//interface CommandInterpreter