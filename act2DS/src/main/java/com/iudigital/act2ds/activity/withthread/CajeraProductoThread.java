package com.iudigital.act2ds.activity.withthread;

import com.iudigital.act2ds.activity.domain.ClienteProducto;
import com.iudigital.act2ds.activity.domain.Producto;

public class CajeraProductoThread implements Runnable {
    
    private String nombreCajera;
    private ClienteProducto cliente;
    private long timeStamp;

    public CajeraProductoThread(String nombreCajera, ClienteProducto cliente, long timeStamp) {
        this.nombreCajera = nombreCajera;
        this.cliente = cliente;
        this.timeStamp = timeStamp;
    }
    
    @Override
    public void run() {
        procesarCompra(cliente, timeStamp);
    }

    public void procesarCompra(ClienteProducto cliente, long timeStamp) {
        System.out.println("La cajera " + this.nombreCajera + " comienza a procesar la compra del cliente "
            + cliente.getNombre() + " en el tiempo " + (System.currentTimeMillis() - timeStamp) / 1000
            + " seg ");
        System.out.println("==================================================================");
        int contCliente = 1;
        for (Producto producto : cliente.getProductos()) {
            this.esperarxsegundos();
            System.out.println("Procesando el producto " + contCliente 
                    + " nombre producto " + producto.getNombre()
                    + " precio producto " + producto.getPrecio()
                    + " cantidad de productos " + producto.getCantidad()
                    + " costo total del producto " + producto.getCantidad() * producto.getPrecio()
                    + " tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + " seg ");
            System.out.println("==================================================================");
            contCliente++;
        }
        System.out.println("La cajera " + this.nombreCajera + " ha terminado de procesar a " + cliente.getNombre()
                  + " en el tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + " seg ");
        System.out.println("==================================================================");
    }

    private void esperarxsegundos() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

