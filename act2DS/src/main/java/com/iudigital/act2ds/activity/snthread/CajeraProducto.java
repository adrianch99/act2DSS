package com.iudigital.act2ds.activity.snthread;

import com.iudigital.act2ds.activity.domain.ClienteProducto;
import com.iudigital.act2ds.activity.domain.Producto;

public class CajeraProducto {
    
    private String nombreCajera;

    public CajeraProducto(String nombreCajera) {
        this.nombreCajera = nombreCajera;
    }

    
    public void procesarCompra(ClienteProducto cliente, long timeStanp) {
        System.out.println("la cajera " + this.nombreCajera + " comienza a procesar la compra del cliente "
            + cliente.getNombre() + " en el tiempo " + (System.currentTimeMillis() - timeStanp) / 1000
            + " seg ");
        int contCliente = 1;
        for (Producto producto : cliente.getProductos()) {
            this.esperarxsegundos();
            System.out.println(" procesando el producto " + contCliente 
                    + " nombre producto " + producto.getNombre()
                    + " precio producto " + producto.getPrecio()
                    + " cantidad de productos " + producto.getCantidad()
                    + " costo total del producto " + producto.getCantidad() * producto.getPrecio()
                    + " tiempo: " + (System.currentTimeMillis() - timeStanp) / 1000 + "seg ");
            System.out.println("==================================================================");
        }
        System.out.println(" la cajera " + this.nombreCajera + " ha terminado de procesar a " + cliente.getNombre()
                  + " en el tiempo: " + (System.currentTimeMillis() - timeStanp) / 1000 + " seg ");
    }

    private void esperarxsegundos() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
