import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {

    public static void main(String[] args) {
        maquinaSnacks();

    }

    public static void maquinaSnacks(){
        System.out.println("*** Maquina de Snacks ***");
        List<Snack> snacks = new ArrayList<>();
        var salir = false;
        var consola = new Scanner(System.in);
        while(!salir){
            try{
                Snacks.mostrarSnacks();
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola, snacks);
            }catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }finally {
                System.out.println();
            }
        }

    }

    public static int mostrarMenu(Scanner consola){
        System.out.print("""
                Menu:
                1) Comprar Snack
                2) Mostrar ticket
                3) Agregar nuevo Snack
                4) Salir
                
                Elige una opcion: \s""");
        return Integer.parseInt(consola.nextLine());
    }

    public static boolean ejecutarOpciones(int opcion, Scanner consola, List<Snack> snacks){
        var salida = false;
        switch(opcion){
            case 1 ->comprarSnack(consola,snacks);
            case 2 ->mostrarTicket(snacks);
            case 3 ->agregarSnack(consola);
            case 4 ->{
                System.out.println("*Saliendo . . . *");
                salida = true;
            }
            default -> System.out.println("Opcion no reconocida");
        }
        return salida;
    }

    public static void comprarSnack(Scanner consola, List<Snack> snacks){
        System.out.print("Ingresa el snack que deseas comprar (id): ");
        var idSnack = Integer.parseInt(consola.nextLine());
        boolean snackEncontrado = false;
        for(Snack snack : Snacks.getSnacks()){
            if(idSnack == snack.getIdSnack()) {
                //Se agrega el snack a la lista de compra
                snacks.add(snack);
                System.out.println("Snack agregado al Ticket de compra: " + snack);
                snackEncontrado = true;
                break; //Rompemos el ciclo ya que ya se encontró el id.
            }else{
                snackEncontrado = false;
            }
        }
        if(!snackEncontrado){
            System.out.println("Snack no encontrado (id "+idSnack+")");
        }
    }

    public static void mostrarTicket(List<Snack> snacks){
        double totalCompra = 0;
        System.out.println("-----Ticket de compra-----");
        for(Snack s : snacks){
            totalCompra += s.getPrecio();
            System.out.println(s.getNombre()+"\t$"+s.getPrecio());
        }
        System.out.println("\nTotal de compra: "+totalCompra);
        System.out.println("--------------------------");
    }

    public static void agregarSnack(Scanner consola){
        String nombreNuevo;
        double precioNuevo;
        System.out.print("Ingresa el nombre del producto a agregar: ");
        nombreNuevo = consola.nextLine();
        System.out.print("Ingresa su precio: ");
        precioNuevo = Double.parseDouble(consola.nextLine());
        Snack nuevoSnack = new Snack(nombreNuevo,precioNuevo);
        Snacks.agregarSnack(nuevoSnack);
        System.out.println("*Snack nuevo agregado*");
        Snacks.mostrarSnacks();
    }

}
