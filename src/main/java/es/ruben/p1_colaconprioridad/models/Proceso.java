package es.ruben.p1_colaconprioridad.models;

public class Proceso {

    private int id;
    private String nombre;
    private int prioridad;
    private Estado estado = Estado.PENDIENTE;

    public Proceso(int id, String nombre, int prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proceso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", prioridad=" + prioridad +
                ", estado=" + estado +
                '}';
    }
}
