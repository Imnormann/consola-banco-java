package banco.modelos;

public class Usuario {

	// los atributos protected act�an como private
	// pero son accesibles en las clase que heredan de esta (Gestor y Cliente)
	// dentro de la misma clase podemos acceder a ellos con "this."
	// si el nombre del atributo no es el mismo que el de otra variable o par�metro
	// no es necesario usar "this"
	// pero puede hacer m�s legible y sem�ntico el c�digo
	protected Integer id;
	protected String usuario;
	protected String password;
	protected String correo;

	// constructor vac�o
	// crear� un objeto o instancia de Usuario
	// con los atributos sin inicializar (sin valor o con su valor por defecto)
	public Usuario() {

	}

	// constructor parametrizado (con par�metros)
	// recibe valores declarados como par�metros (entre par�ntesis)
	// en este caso inicializa los atribudos (marcados con "this") asign�ndoles los
	// valores que se reciban en los par�metros
	public Usuario(Integer id, String usuario, String password, String correo) {
		// en este caso el "this" es necesario
		// de otro modo no distinguimos entre el id "atributo de clase" y el id
		// "par�metro del m�todo"
		// el resultado de id = id ser�a que el atributo de clase no se inicializa
		// (spoiler: muchos problemas)
		// una alternativa ser�a que el par�tro se llamara nuevoId y hacer id = nuevoId.
		// No es lo habitual.
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
	}

	// los m�todos consultores (getters) p�blicos (public)
	// permiten leer los atributos privados o protegidos fuera de la clase
	public Integer getId() {
		return id;
	}

	// los m�todos modificadores (setters) p�blicos (public)
	// permiten modificar los atributos privados o protegidos fuera de la clase
	// no suelen retornar nada (void), ya que su �nica funci�n es modificar
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	// los m�todos toString y equals se heredan en todas las clases, aunque no lo
	// utilicemos
	// ya que todas las clases herdan por defecto de Object
	// podemos sobreescribir estos m�todos para que se ajusten a nuestras
	// necesidades

	// toString traducir� los objetos de esta clase a un texto (String) que podemos
	// personalizar
	public String toString() {
		return "Usuario{id: " + this.id + ", nombre: " + this.usuario + "}";
	}

	// equals se utiliza para comparar dos objetos de esta clase
	// podemos sobreescribirlo para que compare los atributos que prefiramos
	// en este caso podemos decir que dos usuarios son el mismo si tienen el mismo
	// id
	public boolean equals(Object o) {
		// como los par�metros deben ser los mismos para sobreescribir una funci�n
		// tenemos que convertir del tipo gen�rico "Object" a nuestro tipo Usuario
		// esta operaci�n se conoce como "casting" o conversi�n forzada
		Usuario g = (Usuario) o;
		boolean mismoId = this.id == g.id;
		return mismoId;
	}
}
