package service;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class inventarioService {

	private final List<producto> inventario = new ArrayList<>();

	public void agregarProducto(producto p) {

		inventario.add(p);
		System.out.println("Producto agregado correctamente");
	}

	public List<producto> listarProductos() {
		return inventario;

	}

	public producto buscarProductoPorCodigo(String codigo) {

		for (producto p : inventario) {
			if (p.getCodigo().equalsIgnoreCase(codigo)) {
				return p;
			}
		}
		return null;
	}

	public void actualizarProducto(String codigo, double nuevoPrecio, int nuevaCantidad) {

		for (producto p : inventario) {

			if (p.getCodigo().equalsIgnoreCase(codigo)) {
				p.setPrecio(nuevoPrecio);
				p.setCantidad(nuevaCantidad);
			}
		}
		System.out.println("Producto actualizado correctamente");
	}

	public void eliminarProducto(String codigo) {

		for (producto p : inventario) {
			if (p != null) {
				inventario.remove(p);
			}

		}
	}
}
