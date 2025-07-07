package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import model.*;

public class ProductoDAO {

	public void guardarProducto(producto producto) {
		Transaction transaction = null;

		if (producto.getProduct_code() == null || producto.getProduct_name() == null) {
			System.err.println("Error: El usuario debe tener un nombre y un email válidos.");
			return;
		}

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(producto);
			transaction.commit();
		} catch (Exception e) {
			// Si hubo un error y la transacción está activa, intenta hacer rollback
			if (transaction != null && transaction.getStatus().canRollback()) {
				try {
					transaction.rollback();
				} catch (Exception rollbackEx) {
					System.err.println("Error durante el rollback: " + rollbackEx.getMessage());
				}
			}
			System.err.println("Error en guardarProducto: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public producto obtenerProductoPorCodigo(int product_code) {

		producto producto = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			producto = session.get(producto.class, product_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producto;
	}

	public List<producto> obtenerTodosLosProductos() {

		List<producto> productos = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			productos = session.createQuery("from producto", producto.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return productos;
	}
	
	public void actualizarProducto(producto producto) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(producto);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarProducto(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			producto producto = session.get(producto.class, id); // Se intenta obtener el producto con el ID
																	// proporcionado usando el método get. Si no existe,
																	// devuelve null
			if (producto != null) {
				session.delete(producto); // Si el producto existe, se procede a eliminarlo con session.delete(producto).
											// Si no existe, no se hace nada (lo cual evita un error)
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		}
	}
}
