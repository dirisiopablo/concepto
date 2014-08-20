package ar.edu.celulares.applicationModel

import scala.collection.JavaConversions.asScalaBuffer
import java.util.ArrayList
import collection.JavaConversions._
import ar.edu.utn.concepto.domain.Materia
import ar.edu.utn.concepto.home.HomeMaterias

@org.uqbar.commons.utils.Observable
class SeguidorCarrera extends Serializable {

	var nombre : String = _
	var resultados : java.util.List[Materia] = _
	var materiaSeleccionada : Materia = _

	
	// ********************************************************
	// ** Acciones
	// ********************************************************
	def getMaterias = { 
		// WORKAROUND para que refresque la grilla en las actualizaciones
		resultados = new ArrayList[Materia]

		// FIN WORKAROUND
		resultados = HomeMaterias.materias 
	}

	def clear() = {
		nombre = null
	}

}