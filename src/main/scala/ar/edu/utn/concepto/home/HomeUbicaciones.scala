package ar.edu.utn.concepto.home

import org.uqbar.commons.model.CollectionBasedHome
import ar.edu.utn.concepto.domain.Ubicacion
import org.uqbar.commons.utils.Observable

object HomeUbicaciones extends CollectionBasedHome[Ubicacion]{
	this.create("Cuatrimestre 1 - Nivel 1")
	this.create("Cuatrimestre 1 - Nivel 2")
	this.create("Cuatrimestre 1 - Nivel 3")
	this.create("Cuatrimestre 1 - Nivel 4")
	this.create("Cuatrimestre 1 - Nivel 5")
	this.create("Cuatrimestre 2 - Nivel 1")
	this.create("Cuatrimestre 2 - Nivel 2")
	this.create("Cuatrimestre 2 - Nivel 3")
	this.create("Cuatrimestre 2 - Nivel 4")
	this.create("Cuatrimestre 2 - Nivel 5")
	this.create("Anual - Nivel 1")
	this.create("Anual - Nivel 2")
	this.create("Anual - Nivel 3")
	this.create("Anual - Nivel 4")
	this.create("Anual - Nivel 5")
	
	def create(str:String):Unit ={
	  var ubicacion = new Ubicacion()
	  ubicacion.descripcion = str
	  this.create(ubicacion)
	}
	
	def ubicaciones = allInstances
	
	override def getEntityType = classOf[Ubicacion]

	override def createExample = new Ubicacion

	override def getCriterio(example: Ubicacion) = null
}