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
				System.out.println("Nombre del producto");
				String nombre = lectura.nextLine();
				System.out.println("precio del producto");
				double precio = lectura.nextDouble();
				System.out.println("cantidad de producto");
				int cantidad = lectura.nextInt();

				producto p = new producto(codigo, nombre, precio, cantidad);

				inventario.agregarProducto(p);
				
				break;

			case 2:

				List<producto> productos = inventario.listarProductos();

				if (productos.isEmpty()) {
					System.out.println("La lista está vacía");
				} else {
					for (producto producto : productos) {
						System.out.println(producto);
					}
				}
				
				break;
			case 3:
				
				String codigo1 = lectura.nextLine();
                producto p1 = inventario.buscarProductoPorCodigo(codigo1);
                
                if (p1 == null) {
                	System.out.println("Producto no encontrado");
                } else {
                	System.out.println(p1);
                }
                break;
                
			case 4:
				

				System.out.println("Código del producto");
				String codigo2 = lectura.nextLine();
				System.out.println("Introduce el nuevo precio del producto");
				double nuevoprecio = lectura.nextDouble();
				lectura.nextLine();
				System.out.println("Introduce las cantidades de este producto");
				int nuevacantidad = lectura.nextInt();
				lectura.nextLine();
				
				inventario.actualizarProducto(codigo2, nuevoprecio, nuevacantidad);
				
				break;
			case 5:
			    System.out.println("Código del producto a eliminar:");
			    String codigoEliminar = lectura.nextLine();
			    
			    inventario.eliminarProducto(codigoEliminar);
			    break;
				
				
			}

		} while (opcion != 6);

	}
}

//cvometario
