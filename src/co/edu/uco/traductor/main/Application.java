package co.edu.uco.traductor.main;

import co.edu.uco.traductor.domain.Traductor;

public class Application
{
    public static void main(String[] args)
    {
        Traductor traductor = new Traductor("hola", "104 111 108 97");

        traductor.imprimirResultadoAscii();
        System.out.println(" ");
        traductor.imprimirResultadoTexto();
    }
}