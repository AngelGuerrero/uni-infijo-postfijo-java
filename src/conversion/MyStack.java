/**
 * @Author: Luis Ángel De Santiago Guerrero <angelguerrero>
 * @Date:   2017-07-27T09:01:10-05:00
 * @Email:  _angelguerrero_@outlook.com
 * @Filename: Stack.java
 * @Last modified by:   angelguerrero
 * @Last modified time: 2017-07-30T15:06:36-05:00
 * @License: MIT
 */



package conversion;

public class MyStack {
  // Attributes
  private Node top;   // Obtiene el elemento de la cima
  private int size;   // Obtiene la longitud de la pila

  // Stack Constructor
  public MyStack()
  {
    top = null;
    size = 0;
  }

  /**
   * Apila un nuevo elemento
   *
   * Devuelve true si el elemento fue agregado, y false si falla
   *
   * @param  int data          Elemento para agregar a la pila
   *
   * @return     boolean
   */
  public boolean push(char data)
  {
    boolean val = false;

    try
    {

      Node el = new Node(data);
      el.next = top;
      top = el;

      size++;
      val = true;

    }
    catch (OutOfMemoryError e)
    {
      System.out.println("Error: insufficient space to allocate the object");
    }

    return val;
  }

  /**
   * Saca un elemento de la pila
   *
   * Específicamente el elemento de la cima
   *
   * @return char     Devuelve el elemento que ha sacado
   */
  public char pop()
  {
    char val = '\0';

    if ( size > 0 )
    {
      Node temp;

      val = top.getData();
      temp = top;
      top = top.next;
      size--;
    }

    return val;
  }

  /**
   * Muestra la pila
   *
   * @return char     Devuelve el contenido de la pila
   */
  public String show()
  {
    String val = "Pila vacía";

    if ( !isEmpty() )
    {
      val = "";
      Node iterator = top;
      while ( iterator != null )
      {
        val += iterator.getData();
        iterator = iterator.next;
      }
    }
    
    return val;
  }

  /**
   * Obtiene el elemento de la cima
   *
   * @return char
   */
  public char getTop()
  {
    char val = '\0';

    if (!isEmpty())
    {
      val = top.getData();
    }

    return val;
  }

  /**
   * Elimina toda la lista
   *
   * @return char Devuelve un mensaje si la lista ha sido eliminada
   */
  public char removeAll()
  {
    char val = '\0';

    if ( !isEmpty() )
    {
      while ( top != null )
      {
        val = pop();
      }
    }

    return val;
  }

  public boolean isEmpty() { return top == null; }

  public int getSize() { return size; }


  /*
  |-------------------------------------------------------------------
  | Helper de clase Stack Nodo
  |-------------------------------------------------------------------
  |
  | La siguiente clase es un helper para realizar los nodos
  |
  */
  private class Node {
    // Attributes
    private char data;
    public Node next;

    // Node Constructor
    public Node(char data)
    {
      this.data = data;
      this.next = null;
    }

    public char getData() { return this.data; }

    public void setData(char data) { this.data = data; }
  }
}
