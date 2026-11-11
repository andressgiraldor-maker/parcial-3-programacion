import java.util.ArrayList;
import java.util.List;
public class Cliente {

    //Atributos de la clase
    private int documento;
    private String nombre;
    private int telefono;
    private String gmail;
    private String direccion;

    //Relaciones de la clase Cliente
    private List<Pedido> listClientePedidos;

    /**
     * metodo constructor de la clase Cliente
     * @param documento del cliente
     * @param nombre del cliente
     * @param telefono del cliente
     * @param gmail del cliente
     * @param direccion del cliente
     */
    public Cliente(int documento, String nombre, int telefono, String gmail, String direccion) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.gmail = gmail;
        this.direccion = direccion;

        this.listClientePedidos = new ArrayList<>();
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Pedido> getListClientePedidos() {
        return listClientePedidos;
    }

    public void setListClientePedidos(List<Pedido> listClientePedidos) {
        this.listClientePedidos = listClientePedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento=" + documento + "\n" +
                ", nombre='" + nombre + "\n" +
                ", telefono=" + telefono + "\n" +
                ", gmail='" + gmail + "\n" +
                ", direccion='" + direccion + "\n" +
                ", listClientePedidos=" + listClientePedidos + "\n" +
                '}';
    }
}
