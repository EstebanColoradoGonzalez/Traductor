package co.edu.uco.traductor.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Traductor
{
    private final String texto;
    private final String codigoAscii;
    private final String[] ascii = {"32", "37", "40", "41", "42", "43", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "60", "61", "62", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "94", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122"};
    private final char[] caracteres = {' ', '%', '(', ')', '*', '+', '-', '.', '/', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '<', '=', '>', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '^', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public Traductor(String texto, String codigoAscii)
    {
        this.texto = texto;
        this.codigoAscii = codigoAscii;
    }

    private List<String> generarAscii()
    {
        List<String> codigos = new ArrayList<>();

        for(int i = 0; i < this.texto.length(); i++)
        {
            for(int j = 0; j < this.caracteres.length; j++)
            {
                if(this.texto.charAt(i) == this.caracteres[j])
                {
                    codigos.add(this.ascii[j]);
                }
            }
        }

        return codigos;
    }

    public void imprimirResultadoAscii()
    {
        System.out.println("El resultado de " + this.texto + " en codigo ASCII es ");

        for (String codigo : generarAscii())
        {
            System.out.print(codigo + " ");
        }
    }

    private List<Character> generarTexto()
    {
        List<Character> cadena = new ArrayList<>();
        String[] split = this.codigoAscii.split(" ");
        List<String> codigos = new ArrayList<>(Arrays.asList(split));

        for(int i = 0; i < codigos.size(); i++)
        {
            for(int j = 0; j < this.ascii.length; j++)
            {
                if(Objects.equals(codigos.get(i), this.ascii[j]))
                {
                    cadena.add(this.caracteres[j]);
                }
            }
        }

        return cadena;
    }

    public void imprimirResultadoTexto()
    {
        System.out.println("El resultado de " + this.codigoAscii + " en texto es ");

        this.generarTexto().forEach(System.out::print);
    }
}