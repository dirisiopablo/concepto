package ar.edu.utn.concepto.home

import scala.collection.JavaConversions.asScalaBuffer
import org.uqbar.commons.model.CollectionBasedHome
import ar.edu.utn.concepto.domain.Nota
import org.joda.time.DateTime
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.UserException

@Observable
object HomeNotas extends CollectionBasedHome[Nota] {
	
  def create(fecha: DateTime, descripcion:String, aprobada: Boolean): Unit = {
    var nota = new Nota()
    nota.fecha = fecha
    nota.descripcion = descripcion
    nota.aprobada = aprobada
    this.create(nota)
  }
  
  override def validateCreate(nota:Nota): Unit = {
    nota.validar()
    validarNotaDuplicada(nota)
  }
  
  def notas: Seq[Nota]= allInstances
  
  def validarNotaDuplicada(nota: Nota):Unit={
    val descripcion = nota.descripcion
    if (!this.search(descripcion).isEmpty) {
      throw new UserException("Ya existe una nota con descripcion: " + descripcion)
    }
  }
  
  def search(descripcion: String) = 
    notas.filter { nota => this.coincide(descripcion, nota.descripcion) }
  
  //Esto se fija si ya existía la nota por descripción. Se puede usar para cualquier tipo de parámetro.
  def coincide(expectedValue: Any, realValue: Any): Boolean = {
    if (expectedValue == null) {
      return true
    }
    if (realValue == null) {
      return false
    }
    return realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase())
  }
  
  	override def getEntityType = classOf[Nota]

	override def createExample = new Nota

	override def getCriterio(example: Nota) = null
}