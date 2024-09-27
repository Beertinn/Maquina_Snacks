import java.util.ArrayList;
import java.util.List;

public class Snacks {

    private static final List<Snack> listaSnacks;

    //Agregando algunos productos a la lista con un bloque estatico inicializador
    static {
        listaSnacks = new ArrayList<>();
        listaSnacks.add(new Snack("Agua",15));
        listaSnacks.add(new Snack("Refresco",30));
        listaSnacks.add(new Snack("Papas",18.50));
    }

    public static void agregarSnack(Snack snack){
        listaSnacks.add(snack);
    }

    public static void mostrarSnacks(){
        System.out.println("--Snacks disponibles--");
        for(Snack s: listaSnacks){
            System.out.println(s);
        }
    }

    public static List<Snack> getSnacks(){
        return listaSnacks;
    }





}
