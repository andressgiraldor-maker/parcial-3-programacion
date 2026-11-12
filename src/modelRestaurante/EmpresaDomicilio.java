public interface EmpresaDomicilio {

    public String getNombre();

    /**
     * metodo para clacular el costo que sera utilizado por sus hijas
     * @param km del recorrido
     * @return
     */

    public double calcularCosto(double km);


    /**
     * metodo para aceptar el recorrido, el cual sera utilizado por sus hijas
     * @param km del recorrido
     * @return
     */

    public boolean aceptarRecorrido(double km);

    /**
     * metodo para aceptar el recorrido, el cual sera utilizado por sus hijas
     * @param km del recorrido
     * @return
     */

    public boolean solicitarServicio(double km);


}
