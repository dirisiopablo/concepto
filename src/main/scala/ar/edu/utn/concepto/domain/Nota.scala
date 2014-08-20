package ar.edu.utn.concepto.domain
import org.uqbar.commons.model.UserException
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import org.joda.time.DateTime

@Observable
class Nota() extends Entity {
	var fecha: DateTime =_
	var descripcion: String =_
	var aprobada: Boolean = false
	
	
	def validar():Unit ={
	  if(fecha == null)
	    throw new UserException("Debés completar la fecha.")
	  if(descripcion == null)
	    throw new UserException("Tu nota debe tener una descripción.")
	}
	
	def estaAprobada = aprobada
}