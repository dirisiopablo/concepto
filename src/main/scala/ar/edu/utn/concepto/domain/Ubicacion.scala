package ar.edu.utn.concepto.domain

import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable

@Observable
class Ubicacion extends Entity {
	var descripcion: String =_
	
	override def toString:String = descripcion	  
}