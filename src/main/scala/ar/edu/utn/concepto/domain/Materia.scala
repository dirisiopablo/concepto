package ar.edu.utn.concepto.domain
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable


@Observable
class Materia extends Entity {
	var nombre: String =_
	var anioCursada: Integer = _
	var finalAprobado: Boolean = false
	var profCursada: String =_
	var notas: List[Nota] = List[Nota]() 
	var ubicacion: Ubicacion = _
}