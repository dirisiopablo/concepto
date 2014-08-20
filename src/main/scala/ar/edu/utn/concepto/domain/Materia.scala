package ar.edu.utn.concepto.domain
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException
import java.util.ArrayList
import ar.edu.utn.concepto.home.HomeNotas

@Observable
class Materia extends Entity {
	var nombre: String = _
	var anioCursada: Integer = _
	var finalAprobado: Boolean = false
	var profCursada: String = _
	var notas: java.util.List[Nota] = new ArrayList[Nota]
	var ubicacion: Ubicacion = _

	def validar: Unit = {
		if (nombre == null)
			throw new UserException("El nombre no puede ser vacío.")
	}

	def estaAprobada = finalAprobado

	override def toString = nombre
	
	def eliminarNota(_nota: Nota) = {
//		notas.remove(_nota)
		var lista = new ArrayList[Nota];
		for (int i = 0; i < list.size(); i++) {
		    if(!n.equals(_nota ))
			lista.add(n)
		}
		
		notas = lista
	}
}