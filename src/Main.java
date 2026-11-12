import javax.swing.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante("El buen comer", "123", "carrera 14 #10-4");
        int opcion = 0;
        while (opcion != 17) {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    
                    
                    -------------EL BUEN COMER-------------
                    1. Registrar producto
                    
                    2. Registrar cliente
                    
                    3. Registrar pedido
                    
                    4. Calcular total de un pedido
                    
                    5. Historial de pedidos de un cliente
                    
                    6. Entregar o cancelar un pedido
                    
                    7. Productos disponibles y no conformes
                    
                    8. Ingresos y reportes
                    
                    9. Salir"""));

            if (opcion == 1) {

                int categoria = Integer.parseInt(JOptionPane.showInputDialog(null, "categoría: 1. Plato fuerte  2. Bebida  3. Postre"));
                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el código"));
                String nombre = JOptionPane.showInputDialog(null, "ingrese el nombre");
                String descripcion = JOptionPane.showInputDialog(null, "ingrese la descripción");
                double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el precio base"));
                int tiempo = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el tiempo de preparación (minutos)"));
                Producto producto = null;

                if (categoria == 1) {
                    double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el peso (g)"));
                    int tipo = Integer.parseInt(JOptionPane.showInputDialog(null, "tipo de preparación: 1. Asado  2. Frito  3. Horneado  4. Plancha"));
                    String coccion = JOptionPane.showInputDialog(null, "¿superó el control de cocción? (true/false)");
                    producto = new PlatoFuerte(codigo, nombre, descripcion, precio, tiempo, peso, coccion);
                } else if (categoria == 2) {
                    double volumen = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el volumen (ml)"));
                    double temperatura = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese la temperatura (°C)"));
                    String tipo = JOptionPane.showInputDialog(null, "tipo de bebida (fria / caliente)");
                    boolean especial = Boolean.parseBoolean(JOptionPane.showInputDialog(null, "¿requiere preparación especial? (true/false)"));
                    producto = new Bebida(codigo, nombre, descripcion, precio, tiempo, volumen, temperatura, tipo, especial);
                } else if (categoria == 3) {
                    double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el peso (g)"));
                    double temperatura = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese la temperatura de almacenamiento (°C)"));
                    String refrigeracion = JOptionPane.showInputDialog(null, "¿requiere refrigeración? (true/false)");
                    producto = new Postre(codigo, nombre, descripcion, precio, tiempo, peso, temperatura, refrigeracion);
                }

                if (producto != null && restaurante.agregarProductoARestaurante(producto)) {
                    JOptionPane.showMessageDialog(null, "el producto fue agregado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "no se pudo agregar (categoría inválida o código repetido)");
                }

            } else if (opcion == 2) {

                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el documento"));
                String nombre = JOptionPane.showInputDialog(null, "ingrese el nombre completo");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el teléfono"));
                String correo = JOptionPane.showInputDialog(null, "ingrese el correo electrónico");
                String direccion = JOptionPane.showInputDialog(null, "ingrese la dirección");

                if (restaurante.agregarClienteARestaurante(documento, nombre, telefono, correo, direccion)) {
                    JOptionPane.showMessageDialog(null, "el cliente fue agregado exitosamente");
                } else {
                    JOptionPane.showMessageDialog(null, "ya existe un cliente con ese documento");
                }

            } else if (opcion == 3) {

                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el código del pedido"));
                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el documento del cliente"));
                Cliente cliente = restaurante.buscarClienteEnRestaurante(documento);

                if (cliente == null) {
                    JOptionPane.showMessageDialog(null, "el cliente no está registrado");
                } else {
                    int modalidad = Integer.parseInt(JOptionPane.showInputDialog(null, "modalidad: 1. En restaurante  2. Domicilio"));

                    ModalidaEntrega entrega;
                    if (modalidad == 2) {
                        entrega = ModalidaEntrega.DOMICILIO;
                    } else {
                        entrega = ModalidaEntrega.EN_RESTAURANTE;
                    }

                    Pedido pedido = new Pedido(codigo, LocalDate.now(), cliente, 0, false, 0, entrega, EstadoPedido.PENDIENTE);

                    int otro = 1;
                    while (otro == 1) {
                        int codigoProducto = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el código del producto"));
                        Producto producto = restaurante.buscarProductoEnRestaurante(codigoProducto);

                        if (producto == null) {
                            JOptionPane.showMessageDialog(null, "ese producto no está en el menú");
                        } else {
                            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad"));
                            pedido.agregarDetalle(producto, cantidad);
                        }
                        otro = Integer.parseInt(JOptionPane.showInputDialog(null, "¿agregar otro producto? 1. Sí  2. No"));
                    }

                    if (entrega == ModalidaEntrega.DOMICILIO) {
                        int eleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "empresa: 1. RápidoExpress  2. EntregaSegura"));

                        EmpresaDomicilio empresa;
                        if (eleccion == 1) {
                            empresa = new RapidoExpress();
                        } else {
                            empresa = new EntregaSegura();
                        }

                        double km = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese la distancia (km)"));

                        if (pedido.solicitarDomicilio(empresa, km)) {
                            JOptionPane.showMessageDialog(null, "la empresa aceptó el servicio");
                        } else {
                            JOptionPane.showMessageDialog(null, "la empresa no acepta ese recorrido");
                        }
                    }

                    if (restaurante.confirmarPedido(pedido)) {
                        JOptionPane.showMessageDialog(null, "pedido confirmado. Total: $" + pedido.calcularValorProductos());
                    } else {
                        JOptionPane.showMessageDialog(null, "no se pudo confirmar el pedido");
                    }
                }

            }else if (opcion == 4) {

                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el código del pedido"));
                Pedido pedido = restaurante.buscarPedidoEnRestaurante(codigo);

                if (pedido == null) {
                    JOptionPane.showMessageDialog(null, "el pedido no existe");
                } else {
                    double total = restaurante.calcularTotalPedido(codigo);
                    JOptionPane.showMessageDialog(null, "total del pedido " + codigo + ": $" + total);
                }

            }else if(opcion==5){
                int documento= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del cliente"));
                String historial= restaurante.consultarHistorialCliente(documento);
                JOptionPane.showMessageDialog(null, historial);

            }else if(opcion==6){
                int codigo= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del pedido"));
                Pedido pedido= restaurante.buscarPedidoEnRestaurante(codigo);

                if(pedido!=null){
                    int elijaOpcion= Integer.parseInt(JOptionPane.showInputDialog(null, """
                            Elija una opcion
                            1.Entregar
                            2.Cancelar
                            """));

                    if(elijaOpcion==1){
                        if(pedido.marcarEntregado()){
                            JOptionPane.showMessageDialog(null, "Pedido entregado");
                        } else{
                            JOptionPane.showMessageDialog(null, "El pedido aun no esta confirmado para entregar");
                        }
                    } else if(elijaOpcion==2){
                        if(pedido.cancelar()){
                            JOptionPane.showMessageDialog(null, "Pedido cancelado");
                        } else{
                            JOptionPane.showMessageDialog(null, "El pedido ya fue entregado");
                        }
                    }
                } else{
                    JOptionPane.showMessageDialog(null, "El pedido no existe");
                }

            } else if (opcion==7) {

                int mirarOpcion= Integer.parseInt(JOptionPane.showInputDialog(null, """
                        
                        Elija una opcion
                        1.Productos disponibles
                        2.No conformes
                        """));
                if(mirarOpcion==1){
                    JOptionPane.showMessageDialog(null, "Estos son los productos disponibles:"+ restaurante.consultarProductosDisponibles());
                } else if(mirarOpcion==2){
                    JOptionPane.showMessageDialog(null, "Estos son los productos que no cumplen con la calidad:"+ restaurante.consultarProductosNoCumplenCalidad());
                }

            } else if (opcion == 8) {

                int reporte = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        
                         Elija una opcion
                         1. Ingresos del restaurante
                         2. Ingresos por domicilios
                         3. Producto mas vendido
                         4. Categoria con mayor ingreso
                         """));

                if (reporte == 1) {
                    JOptionPane.showMessageDialog(null, "Ingresos del restaurante: $" + restaurante.calcularIngresos());
                } else if (reporte == 2) {
                    JOptionPane.showMessageDialog(null, "Ingresos por domicilios: $" + restaurante.calcularIngresosDomicilios());
                } else if (reporte == 3) {
                    Producto masVendido = restaurante.productoMasVendido();
                    if (masVendido == null) {
                        JOptionPane.showMessageDialog(null, "NO se ha realizado ninguna venta");
                    } else {
                        JOptionPane.showMessageDialog(null, " El Producto mas vendido es: " + masVendido.getNombre());
                    }
                } else if (reporte == 4) {
                    JOptionPane.showMessageDialog(null, "La Categoria con mayor ingreso es: " + restaurante.categoriaMayorIngreso());
                }
            } else if(opcion==9){
                JOptionPane.showMessageDialog(null, "Gracias por participar, Adios");
            }
            }

        }

        }



