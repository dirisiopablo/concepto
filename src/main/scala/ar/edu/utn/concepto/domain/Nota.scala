package ar.edu.utn.concepto.domain
import org.uqbar.commons.model.UserException
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import org.joda.time.DateTime
import java.util.Date

@Observable
class Nota() extends Entity {
	var materia: String =_
	var fecha: Date =_
	var descripcion: String =_
	var aprobada: Boolean = false
	
	def esDeMateria(_mat: Materia) = _mat.nombre == materia
	
	def validar():Unit ={
	  if(fecha == null)
	    throw new UserException("Debés completar la fecha.")
	  if(descripcion == null)
	    throw new UserException("Tu nota debe tener una descripción.")
	}
	
	def estaAprobada = aprobada
	
	override def equals(other: Any) = other match { 
      case that: Nota => (	this.descripcion.toUpperCase.trim == that.descripcion.toUpperCase.trim &&
    		  				this.materia.toUpperCase.trim == that.materia.toUpperCase.trim)
      case _ => false 
	}
}