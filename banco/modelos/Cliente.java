package banco.modelos;

// cuando una clase "extiende" a otra hereda sus atributos y sus m�todos
// la herencia hace m�s mantenible y reutilizable nuestro c�digo
// Gestor y Cliente comparten atributos ex�ctamente iguales
// ahora solo los tenemos que declarar una vez en Usuario
// adem�s podr�amos a�adir nuevas clases de Usuario (Ej. Asesor, Admin...) de forma totalmente compatible
public class Cliente extends Usuario {

	// a los atributos de esta clase se a�aden los de la clase de la que hereda (Usuario)
	private Integer idGestor;
	private Double saldo;

	public Cliente() {
		// con super hacemos referencia al constructor de la clase de la que hereda
		// Nota: para los constructores vac�os como este no es necesario
		super();
	}
	
	public Cliente(Integer id, String usuario, String password, String correo, Double saldo, Integer idGestor) {
		// en este caso llamamos al constructor del que hereda con los par�metros que necesita
		super(id, usuario, password, correo);
		// luego inicializamos los atributos propios de esta clase
		// con el resto de los par�metros o los valores que proceda en cada caso
		this.saldo = saldo;
		this.idGestor = idGestor;
	}

	// solo necesitamos declarar los m�todos consultores y modificadores de los atributos propios de esta clase
	public Integer getIdGestor() {
		return idGestor;
	}

	public void setIdGestor(Integer idGestor) {
		this.idGestor = idGestor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	// podemos sobreescibir m�todos de la clase de la que hereda si se llaman igual y tienen los mismos par�metros
	public String toString() {
		// los atributos de la clase de laque hereda son accesibles siempre que sean "protected" y no "private"
		return "Cliente{id: " + this.id + ", nombre: " + this.usuario + ", saldo: " + this.saldo + "}";
	}

}
