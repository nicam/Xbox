package ch.zhaw.ads.Stack;

/**
  Interface für Abstrakten Datentyp (ADT) Stack
*/
public interface Stack {
  /**
    Legt eine neues Objekt auf den Stack, falls noch nicht voll.
    @param x ist das Objekt, das dazugelegt wird.
   */
  public void push (Object x) throws StackOverflowError;

  /**
    Entfernt das oberste und damit das zuletzt eingefügte Objekt.
    Ist der Stack leer, wird null zurückgegeben.
    @return Gibt das oberste Objekt zurück oder null, falls leer.
  */
  public Object pop ();

  /**
    Testet, ob der Stack leer ist.
    @return Gibt true zurück, falls der Stack leer ist.
  */
  public boolean isEmpty();

  /**
    Gibt das oberste Objekt zurück, ohne es zu entfernen.
    Ist der Stack leer, wird null zurückgegeben.
    @return Gibt das oberste Objekt zurück oder null, falls leer.
  */
  public Object peek ();

  /**
    Entfernt alle Objekte vom Stack. Ein Aufruf von isEmpty() 
    ergibt nachher mit Sicherheit true.
  */
  public void makeEmpty ();

  /**
    Testet, ob der Stack voll ist.
    @return Gibt true zurück, falls der Stack voll ist.
  */
  public boolean isFull();
}

