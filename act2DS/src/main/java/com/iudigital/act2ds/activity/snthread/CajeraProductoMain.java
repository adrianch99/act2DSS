package com.iudigital.act2ds.activity.snthread;

import com.iudigital.act2ds.activity.domain.ClienteProducto;
import com.iudigital.act2ds.activity.domain.Producto;
import java.util.ArrayList;
import java.util.List;

public class CajeraProductoMain {
    
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        setProductos(productos);
        
        ClienteProducto cliente1 = new ClienteProducto("tony stark", productos);
        ClienteProducto cliente2 = new ClienteProducto("sperman" , productos);
        ClienteProducto cliente3 = new ClienteProducto("aquaman" , productos);
        
        long inicialTime = System.currentTimeMillis();
        CajeraProducto cajeraUno = new CajeraProducto("valentina");
        CajeraProducto cajeraDos = new CajeraProducto("paola");
        CajeraProducto cajeraTres = new CajeraProducto("franchesca");
        
        cajeraUno.procesarCompra(cliente1, inicialTime);
        cajeraDos.procesarCompra(cliente2, inicialTime);
        cajeraTres.procesarCompra(cliente3, inicialTime);
    }
    
    private static void setProductos(List<Producto> productos) {
        Producto productoUno = new Producto("zapatos", 500, 6);
        Producto productoDos = new Producto("pantalones", 800, 18);
        Producto productoTres = new Producto("camisas", 600, 40);
        
        productos.add(productoUno);
        productos.add(productoDos);
        productos.add(productoTres);
    }
}
