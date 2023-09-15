package shoponline;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import shoponline.Accesorio.Metal;
import shoponline.Pantalon.ModeloPantalon;
import shoponline.Remera.Talla;

public class ShopOnLine {
    public static void main(String[] args) {
        Scanner entradaTeclado = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de ventas que desea realizar: ");
        int cantidadVentas = entradaTeclado.nextInt();
        
        for(int i = 0; i < cantidadVentas; i++) {
            crearNuevaVenta(entradaTeclado);
        }    
    }
    
    public static void crearNuevaVenta(Scanner entradaTeclado) {
        LocalDate fechaVenta = obtenerFechaDeVenta(entradaTeclado);
        Cliente cliente = cargarDatosDelCliente(entradaTeclado);
        ArrayList<Producto> listaProductos = cargarListaDeProductos(entradaTeclado);
        Venta ventaActual = new Venta(cliente, fechaVenta);
        
        for (Producto producto : listaProductos) {
            ventaActual.agregarProducto(producto);
        }
        
        ventaActual.imprimirFactura();
    }
    
    public static LocalDate obtenerFechaDeVenta(Scanner entradaTeclado) {
        System.out.println("Ingrese el año de la venta: ");
        int año = entradaTeclado.nextInt();
        System.out.println("Ingrese el mes de la venta: ");
        int mes = entradaTeclado.nextInt();
        System.out.println("Ingrese el día de la venta: ");
        int dia = entradaTeclado.nextInt();
        LocalDate fechaVenta = LocalDate.of(año, mes, dia);
        return fechaVenta;
    }
    
    public static ArrayList<Producto> cargarListaDeProductos(Scanner entradaTeclado) {
        ArrayList<Producto> productos = new ArrayList<>();
        
        System.out.println("Ingrese la cantidad de prendas que desea agregar: ");
        int cantidadPrendas = entradaTeclado.nextInt();
        
        for(int i = 0; i < cantidadPrendas; i++) {
            System.out.println("---------------Seleccione una opción: ----------------");
            Opciones[] opcionesDisponibles = Opciones.values();
            
            for(int k = 0; k < opcionesDisponibles.length; k++) {
                System.out.println((k + 1) + ")" + opcionesDisponibles[k]);
            }
            
            int opcionSeleccionada = entradaTeclado.nextInt();
            Opciones opcion = Opciones.values()[opcionSeleccionada - 1];
            System.out.println("Ingrese la descripción del producto: ");
            String descripcionProducto = entradaTeclado.next();
            System.out.println("Ingrese el precio del producto: ");
            double precioProducto = entradaTeclado.nextDouble();
            
            switch (opcionSeleccionada) {
                case 1: {
                    System.out.println("Seleccione la talla: ");
                    Talla[] tallasDisponibles = Talla.values();
                    
                    for(int s = 0; s < tallasDisponibles.length; s++) {
                        System.out.println((s + 1) + ")" + tallasDisponibles[s]);
                    }
                    
                    int opcionTalla = entradaTeclado.nextInt();
                    Talla tallaElegida = Talla.values()[opcionTalla - 1];
                    Producto remera = new Remera(tallaElegida, descripcionProducto, precioProducto);
                    productos.add(remera);
                    break;
                }
                case 2: {
                    System.out.println("Ingrese el tamaño de la prenda: ");
                    int tamañoPrenda = entradaTeclado.nextInt();
                    System.out.println("Seleccione el modelo: ");
                    ModeloPantalon[] modelosDisponibles =  ModeloPantalon.values();
                    
                    for(int j = 0; j < modelosDisponibles.length; j++) {
                        System.out.println((j + 1) + ")" + modelosDisponibles[j]);
                    }
                    
                    int opcionModelo = entradaTeclado.nextInt();
                     ModeloPantalon modeloElegido =  ModeloPantalon.values()[opcionModelo - 1];
                    Producto pantalon = new Pantalon(tamañoPrenda, descripcionProducto, precioProducto, modeloElegido);
                    productos.add(pantalon);
                    break;
                }
                default:
                    System.out.println("Ingrese el peso del accesorio: ");
                    double pesoAccesorio = entradaTeclado.nextDouble();
                    System.out.println("Seleccione el tipo de metal: ");
                    Metal[] metalesDisponibles = Metal.values();
                    
                    for(int j = 0; j < metalesDisponibles.length; j++) {
                        System.out.println((j + 1) + ")" + metalesDisponibles[j]);
                    }
                    
                    int opcionMetal = entradaTeclado.nextInt();
                    Metal tipoMetal = Metal.values()[opcionMetal - 1];
                    Producto accesorio = new Accesorio(pesoAccesorio, tipoMetal, descripcionProducto, precioProducto);
                    productos.add(accesorio);
                    break;
            }
        }
        
        return productos;
    }
    
    public static Cliente cargarDatosDelCliente(Scanner entradaTeclado) {
        System.out.println("----------------------------------Ingrese los datos del cliente------------------------------------");
        System.out.println("Nombre del cliente: ");
        String nombreCliente = entradaTeclado.next();
        System.out.println("Apellido del cliente: ");
        String apellidoCliente = entradaTeclado.next();
        System.out.println("Número de DNI del cliente: ");
        int dniCliente = entradaTeclado.nextInt();      
        System.out.println("Número de teléfono del cliente: ");
        String telefonoCliente = entradaTeclado.next();
        System.out.println("Dirección del cliente: ");
        String direccionCliente = entradaTeclado.next();
        Cliente cliente = new Cliente(nombreCliente, apellidoCliente, dniCliente, telefonoCliente, direccionCliente);
        return cliente;
    }
    
    public enum Opciones{
        Remera,
        Pantalón,
        Accesorios;
    }
}
