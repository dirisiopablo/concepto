package ar.edu.utn.concepto.domain
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException


@Observable
class Materia extends Entity {
	var nombre: String =_
	var anioCursada: Integer = _
	var finalAprobado: Boolean = false
	var profCursada: String =_
	var notas: List[Nota] = List[Nota]() 
	var ubicacion: Ubicacion = _
	
	def validar(): Unit = {
	  if(nombre == null)
	    throw new UserException("El nombre no puede ser vacío.")
	}
	
	def estaAprobada = finalAprobado
}