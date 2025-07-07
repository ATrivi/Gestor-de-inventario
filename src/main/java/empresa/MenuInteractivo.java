package empresa;

import java.util.List;
import java.util.Scanner;

import DAO.*;
import model.producto;

public class MenuInteractivo {
	public static void main(String[] args) {

		ProductoDAO inventario = new ProductoDAO();
		producto NuevoProducto = new producto();
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
				int codigo = lectura.nextInt();
				lectura.nextLine();
				System.out.println("Nombre del producto");
				String nombre = lectura.nextLine();
				System.out.println("precio del producto");
				
				producto nuevoProducto = new producto(codigo, nombre);
				inventario.guardarProducto(nuevoProducto);
				
				break;

			case 2:
				
				List<producto> productos = inventario.obtenerTodosLosProductos();
		        System.out.println("Lista de productos:");
		        for (producto u : productos) {
		            System.out.println(u.getProduct_code() + " - " + u.getProduct_name());
		        }

				inventario.obtenerTodosLosProductos();
				
				break;
				
			case 3:
				
				System.out.println("Introduce el código del producto:");
				int cod = lectura.nextInt();
				lectura.nextLine();
				producto encontrado = inventario.obtenerProductoPorCodigo(cod);
				
				if (encontrado != null) {
					System.out.println("Producto encontrado:");
					System.out.println("Código del producto:" + encontrado.getProduct_code());
					System.out.println("Nombre del producto:" + encontrado.getProduct_name());
				} else {
					System.out.println("No se ha encontrado el producto");
				}
                break;
                
			case 4:
				
				System.out.println("Código del producto a actualizar:");
				int actualizarCod = lectura.nextInt();
				lectura.nextLine();

				producto prodActualizar = inventario.obtenerProductoPorCodigo(actualizarCod);
				if (prodActualizar != null) {
					System.out.println("Nuevo nombre:");
					String nuevoNombre = lectura.nextLine();
					prodActualizar.setProduct_name(nuevoNombre);
					inventario.actualizarProducto(prodActualizar);
				} else {
					System.out.println("Producto no encontrado");
				}
				break;
			case 5:
				
				System.out.println("Introduce el código del producto a eliminar:");
				int idEliminar = lectura.nextInt();
				lectura.nextLine();
				inventario.eliminarProducto(idEliminar);
				
				break;
				
			}

		} while (opcion != 6);

	}
}
