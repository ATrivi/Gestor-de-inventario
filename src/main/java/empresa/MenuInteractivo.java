package empresa;

import java.util.List;
import java.util.Scanner;

import model.producto;
import service.*;

public class MenuInteractivo {
	public static void main(String[] args) {

		inventarioService inventario = new inventarioService();
		Scanner lectura = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("--- MENÚ DE INVENTARIO ---");
			System.out.println("1. Agregar producto");
			System.out.println("2. Ver todos los productos");
			System.out.println("3. Buscar producto por código");
			System.out.println("4. Actualizar producto");
			System.out.println("5. Eliminar producto");
			System.out.println("6. Salir");
			opcion = lectura.nextInt();
			lectura.nextLine();

			switch (opcion) {
			case 1:

				System.out.println("Código del producto");
				String codigo = lectura.nextLine();
				System.out.println("");
				String nombre = lectura.nextLine();
				System.out.println("");
				String precio = lectura.nextLine();
				System.out.println("");
				String cantidad = lectura.nextLine();
				lectura.nextLine();

				producto p = new producto(codigo, nombre, opcion, opcion);

				inventario.agregarProducto(p);

			case 2:

				List<producto> productos = inventario.listarProductos();

				if (productos.isEmpty()) {
					System.out.println("La lista está vacía");
				} else {
					for (producto producto : productos) {
						System.out.println(productos);
					}
				}

			case 3:
				
				String codigo = lectura.nextLine();
                producto p = inventario.buscarProductoPorCodigo(codigo);
                
                if (codigo == null) {
                	System.out.println("Producto no encontrado");
                } else {
                	System.out.println(p);
                }
			}

		} while (opcion != 6);

	}
}
