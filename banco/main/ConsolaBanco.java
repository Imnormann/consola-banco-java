package banco.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banco.modelos.Cliente;
import banco.modelos.Gestor;
import banco.util.Utiles;

public class ConsolaBanco {

	private List<Gestor> gestores;
	private List<Cliente> clientes;
	private Integer siguienteIdGestor;
	private Scanner teclado;
	private int siguienteIdCliente;

	ConsolaBanco() {
		this.gestores = new ArrayList<>();
		this.siguienteIdGestor = 1;
		this.teclado = new Scanner(System.in);
		this.clientes = new ArrayList<>();
		this.siguienteIdCliente = 1;
	}

	private void mostrarMenu() {
		System.out.println("1. Insertar gestor");
		System.out.println("2. Insertar gestores de prueba");
		System.out.println("3. Consultar gestor");
		System.out.println("4. Ver todos los gestores");
		System.out.println("5. Actualizar gestor");
		System.out.println("6. Eliminar un gestor");
		System.out.println("7. Insertar cliente");
		System.out.println("8. Consultar cliente");
		System.out.println("9. Ver todos los clientes");
		System.out.println("10. Actualizar cliente");
		System.out.println("11. Eliminar un cliente");
		System.out.println("18. Login");
		System.out.println("0. Salir\n");

	}

	private void insertarGestor() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Oficina: ");
		String oficina = teclado.next();
		Gestor nuevoGestor = new Gestor(siguienteIdGestor, nombre, pass, email, oficina);
		gestores.add(nuevoGestor);
		siguienteIdGestor++;
		System.out.println("Gestor creado con éxito.");
	}

	private void insertarGestoresDePrueba() {
		System.out.print("Número de gestores: ");
		int numeroGestores = teclado.nextInt();
		for (int i = 0; i < numeroGestores; i++) {
			String usuario = Utiles.nombreAleatorio();
			String correo = Utiles.correoAleatorio();
			Gestor gestor = new Gestor(siguienteIdGestor, usuario, "", correo, "Valencia");
			gestores.add(gestor);
			siguienteIdGestor++;
		}
	}

	private void consultarGestor() {
		System.out.print("Id del gestor a consultar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);

		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}

	private Gestor buscarGestorPorId(int idGestor) {
		Gestor gestorResultado = null;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				return gestorResultado;
			}
		}
		return null;
	}

	private void mostrarGestores() {
		if (gestores.isEmpty()) {
			System.out.println("Todavía no hay gestores.");
		}
		gestores.forEach(gestor -> {
			System.out.println(gestor);
		});
	}

	private void actualizarGestor() {
		System.out.print("Id del gestor a actualizar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = buscarGestorPorId(idGestor);
		// si se ha encontrado
		if (gestorResultado != null) {
			System.out.println(gestorResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[o] Oficina");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				gestorResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				gestorResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				gestorResultado.setPassword(pass);
				break;
			case 'o':
				System.out.print("Oficina: ");
				String oficina = teclado.next();
				gestorResultado.setOficina(oficina);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el gestor con el id " + idGestor);
			}
		} else {
			System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
		}
	}

	private void eliminarGestor() {
		System.out.print("Id del gestor a eliminar: ");
		int idGestor = teclado.nextInt();
		Gestor gestorResultado = null;
		int posicionGestor = -1;
		for (int i = 0; i < gestores.size(); i++) {
			Gestor gestor = gestores.get(i);
			if (gestor.getId() == idGestor) {
				gestorResultado = gestor;
				posicionGestor = i;
			}
			if (gestorResultado != null) {
				gestores.remove(posicionGestor);
				System.out.println("Se eliminó el gestor con el id " + idGestor);
			} else {
				System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
			}
		}
	}

	private void login() {
		System.out.print("Id gestor: ");
		int idGestor = teclado.nextInt();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		Gestor gestor = buscarGestorPorId(idGestor);
		// si el gestor existe
		if (gestor != null) {
			// si la contraseña coincide
			if (gestor.getPassword().equals(pass)) {
				System.out.println("Login correcto!");
			} else {
				System.out.println("Login incorrecto!");
			}
		} else {
			System.out.println("El usuario no existe...");
		}
	}

	private void cerrar() {
		System.out.println("¡Hasta pronto!");
	}

	private void iniciar() {

		int opcion = -1;

		do {
			mostrarMenu();

			System.out.print("Selecciona una opción: ");
			try {
				opcion = teclado.nextInt();
			} catch (Exception e) {
				opcion = 0;
			}
			switch (opcion) {
			case 1:
				insertarGestor();
				break;
			case 2:
				insertarGestoresDePrueba();
				break;
			case 3:
				consultarGestor();
				break;
			case 4:
				mostrarGestores();
				break;
			case 5:
				actualizarGestor();
				break;
			case 6:
				eliminarGestor();
				break;
			case 7:
				insertarCliente();
				break;
			case 8:
				consultarCliente();
				break;
			case 9:
				mostrarClientes();
				break;
			case 10:
				actualizarCliente();
				break;
			case 11:
				eliminarCliente();
				break;
			case 18:
				login();
				break;
			case 0:
				cerrar();
				break;
			default:
				System.out.println("Opción desconocida...");
			}

		} while (opcion != 0);
	}

	public static void main(String[] args) {

		ConsolaBanco consola = new ConsolaBanco();
		consola.iniciar();
	}

	private void insertarCliente() {
		System.out.print("Nombre: ");
		String nombre = teclado.next();
		System.out.print("Email: ");
		String email = teclado.next();
		System.out.print("Contraseña: ");
		String pass = teclado.next();
		System.out.print("Saldo: ");
		double saldo = teclado.nextDouble();

		mostrarGestores();
		System.out.println("Elige un gestor");
		int idGestor = teclado.nextInt();

		Cliente nuevoCliente = new Cliente(siguienteIdCliente, nombre, pass, email, saldo, idGestor);
		clientes.add(nuevoCliente);
		siguienteIdCliente++;
		System.out.println("Cliente creado con éxito.");
	}

	private void consultarCliente() {
		System.out.print("Id del cliente a consultar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);

		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
	}

	private Cliente buscarClientePorId(int idCliente) {
		Cliente clienteResultado = null;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				return clienteResultado;
			}
		}
		return null;
	}

	private void mostrarClientes() {
		if (clientes.isEmpty()) {
			System.out.println("Todavía no hay clientes.");
		}
		clientes.forEach(cliente -> {
			System.out.println(cliente);
		});
	}

	private void actualizarCliente() {
		System.out.print("Id del cliente a actualizar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = buscarClientePorId(idCliente);
		// si se ha encontrado
		if (clienteResultado != null) {
			System.out.println(clienteResultado);
			System.out.println("[n] Nombre");
			System.out.println("[e] Email");
			System.out.println("[c] Contraseña");
			System.out.println("[s] Saldo");
			System.out.println("[x] Cancelar");
			System.out.print("Campo a actualizar: ");
			char opcionActualizar = teclado.next().charAt(0);
			switch (opcionActualizar) {
			case 'n':
				System.out.print("Nombre: ");
				String nombre = teclado.next();
				clienteResultado.setUsuario(nombre);
				break;
			case 'e':
				System.out.print("Email: ");
				String email = teclado.next();
				clienteResultado.setCorreo(email);
				break;
			case 'c':
				System.out.print("Contraseña: ");
				String pass = teclado.next();
				clienteResultado.setPassword(pass);
				break;
			case 'o':
				System.out.print("Saldo: ");
				double saldo = teclado.nextDouble();
				clienteResultado.setSaldo(saldo);
				break;
			case 'x':
				System.out.print("Cancelando actualización...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
			if (opcionActualizar != 'x') {
				System.out.println("Se actualizó el cliente con el id " + idCliente);
			}
		} else {
			System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
		}
	}

	private void eliminarCliente() {
		System.out.print("Id del cliente a eliminar: ");
		int idCliente = teclado.nextInt();
		Cliente clienteResultado = null;
		int posicionCliente = -1;
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente = clientes.get(i);
			if (cliente.getId() == idCliente) {
				clienteResultado = cliente;
				posicionCliente = i;
				break;
			}
			if (clienteResultado != null) {
				clientes.remove(posicionCliente);
				System.out.println("Se eliminó el cliente con el id " + idCliente);
			} else {
				System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
			}
		}
	}
}
