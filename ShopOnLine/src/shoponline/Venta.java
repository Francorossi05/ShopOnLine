package shoponline;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {
    private ArrayList<Producto> listaProductos = new ArrayList();
    private Cliente comprador;
    private static int cantidadVentasRealizadas = 1091;
    private int numeroFactura;
    LocalDate fechaVenta;

    public Venta(Cliente comprador, LocalDate fechaVenta) {
        this.comprador = comprador;
        this.numeroFactura = cantidadVentasRealizadas++;
        this.fechaVenta = fechaVenta;
    }
 
    public void agregarProducto(Producto producto){
        listaProductos.add(producto);
    }
    
    public double calcularTotal(){
        double totalVenta = 0;
        for(Producto producto : listaProductos){   
            totalVenta += producto.costo;
        }
        return totalVenta;
    }
    
    public void imprimirRecibo(){
        System.out.println("Factura N°: " + this.numeroFactura + " - " + this.fechaVenta);       
        for (Producto producto : listaProductos){
            System.out.println(producto.toString());
        }
        System.out.println("Total a pagar:........... $" + calcularTotal() );
    } 

    void imprimirFactura() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
