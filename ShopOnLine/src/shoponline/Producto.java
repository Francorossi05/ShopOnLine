package shoponline;

public abstract class Producto {
    protected String descripcion;
    protected double costo;

    public Producto(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return this.descripcion + "........ $ " + this.costo;
    }

    public String obtenerDescripcion() {
        return descripcion;
    }

    public void establecerDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract double obtenerCostoTotal();

    public void establecerCosto(double costo) {
        this.costo = costo;
    }
}
