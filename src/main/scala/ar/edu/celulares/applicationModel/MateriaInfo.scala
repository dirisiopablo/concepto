package ar.edu.celulares.applicationModel

import scala.collection.JavaConversions.asScalaBuffer
import java.util.ArrayList
import collection.JavaConversions._
import ar.edu.utn.concepto.domain.Materia
import ar.edu.utn.concepto.home.HomeMaterias
import ar.edu.utn.concepto.home.HomeUbicaciones
import ar.edu.utn.concepto.domain.Nota

@org.uqbar.commons.utils.Observable
class MateriaInfo(_materia: Materia) extends Serializable {

	var materia : Materia = _materia
	var notaSeleccionada : Nota =_
	
	// ********************************************************
	// ** Acciones
	// ********************************************************

	def getUbicaciones = HomeUbicaciones.ubicaciones

}