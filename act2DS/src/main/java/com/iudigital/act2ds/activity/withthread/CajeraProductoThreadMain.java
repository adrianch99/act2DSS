package com.iudigital.act2ds.activity.withthread;

import com.iudigital.act2ds.activity.domain.ClienteProducto;
import com.iudigital.act2ds.activity.domain.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CajeraProductoThreadMain {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de clientes: ");
        int numeroClientes = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        List<ClienteProducto> clientes = new ArrayList<>();
        List<Producto> productos;
        String nombreCliente;
        String nombreProducto;
        float precioProducto;
        int cantidadProducto;
        
        for (int i = 0; i < numeroClientes; i++) {
            System.out.print("Ingrese el nombre del cliente " + (i + 1) + ": ");
            nombreCliente = scanner.nextLine();
            
            productos = new ArrayList<>();
            System.out.print("Ingrese el número de productos para el cliente " + (i + 1) + ": ");
            int numeroProductos = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            for (int j = 0; j < numeroProductos; j++) {
                System.out.print("Ingrese el nombre del producto " + (j + 1) + ": ");
                nombreProducto = scanner.nextLine();
                System.out.print("Ingrese el precio del producto " + (j + 1) + ": ");
                precioProducto = (float) scanner.nextDouble();
                System.out.print("Ingrese la cantidad del producto " + (j + 1) + ": ");
                cantidadProducto = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                productos.add(new Producto(nombreProducto, precioProducto, cantidadProducto));
            }

            clientes.add(new ClienteProducto(nombreCliente, productos));
        }

        System.out.print("Ingrese el número de cajeras: ");
        int numeroCajeras = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        String[] nombresCajeras = new String[numeroCajeras];
        for (int i = 0; i < numeroCajeras; i++) {
            System.out.print("Ingrese el nombre de la cajera " + (i + 1) + ": ");
            nombresCajeras[i] = scanner.nextLine();
        }

        long inicialTime = System.currentTimeMillis();
        
        List<Thread> cajeras = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            CajeraProductoThread cajeraProductoThread = new CajeraProductoThread(nombresCajeras[i % numeroCajeras], clientes.get(i), inicialTime);
            Thread cajeraThread = new Thread(cajeraProductoThread);
            cajeras.add(cajeraThread);
        }

        for (Thread cajera : cajeras) {
            cajera.start();
        }

        for (Thread cajera : cajeras) {
            try {
                cajera.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        scanner.close();
    }
}
