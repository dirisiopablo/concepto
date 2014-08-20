package ar.edu.utn.concepto.home

import scala.collection.JavaConversions.asScalaBuffer
import org.uqbar.commons.model.Entity
import org.uqbar.commons.utils.Observable
import ar.edu.utn.concepto.domain.Ubicacion
import ar.edu.utn.concepto.domain.Nota
import org.joda.time.DateTime
import ar.edu.utn.concepto.domain.Materia
import org.uqbar.commons.model.UserException
import org.uqbar.commons.model.CollectionBasedHome
import java.util.ArrayList
import java.util.Date

@Observable
object HomeMaterias extends CollectionBasedHome[Materia] {

	var ubi = new Ubicacion()
	ubi.descripcion = "Anual - Nivel 2"

	this.create("Análisis I", 2010, true, "VIEJA", ubi)

	def create(nombre: String, anioCursada: Integer, finalAprobado: Boolean, profCursada: String, ubicacion: Ubicacion): Unit = {
		var materia = new Materia()
		materia.nombre = nombre
		materia.anioCursada = anioCursada
		materia.finalAprobado = finalAprobado
		materia.profCursada = profCursada
		materia.ubicacion = ubicacion

		this.create(materia)
	}

	override def validateCreate(materia: Materia): Unit = {
		materia.validar
		validarMateriaDuplicada(materia)
	}

	def validarMateriaDuplicada(materia: Materia): Unit = {
		val nombre = materia.nombre
		if (!search(nombre).isEmpty) {
			throw new UserException("Ya existe una materia con descripcion: " + nombre)
		}
	}

	def materias: Seq[Materia] = allInstances

	def search(nombre: String) =
		materias.filter { materia => coincide(nombre, materia.nombre) }

	//Esto se fija si ya existía la nota por descripción. Se puede usar para cualquier tipo de parámetro.
	def coincide(expectedValue: Any, realValue: Any): Boolean = {
		if (expectedValue == null)
			return true
		if (realValue == null)
			return false
		return realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase())
	}

	override def getEntityType = classOf[Materia]

	override def createExample = new Materia

	override def getCriterio(example: Materia) = null
}