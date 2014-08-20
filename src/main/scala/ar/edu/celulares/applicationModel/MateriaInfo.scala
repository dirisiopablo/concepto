package ar.edu.celulares.applicationModel
import collection.JavaConversions._
import ar.edu.utn.concepto.domain.Materia
import ar.edu.utn.concepto.home.HomeUbicaciones
import ar.edu.utn.concepto.domain.Nota
import org.uqbar.commons.utils.Observable
import ar.edu.utn.concepto.home.HomeNotas
import java.util.ArrayList

@org.uqbar.commons.utils.Observable
class MateriaInfo(_materia: Materia) extends Serializable {

	var materia: Materia = _materia
	var notaSeleccionada: Nota = _
	
	// ********************************************************
	// ** Acciones
	// ********************************************************

	def getUbicaciones = HomeUbicaciones.ubicaciones

	def eliminarNotaSeleccionada() = {
		HomeNotas.delete(notaSeleccionada)
//		materia.eliminarNota(notaSeleccionada)
	}

	def search() = {
		materia.notas = HomeNotas.search(materia)
	}

}