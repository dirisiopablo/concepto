package ar.edu.celulares.applicationModel

import scala.collection.JavaConversions.asScalaBuffer
import java.util.ArrayList
import collection.JavaConversions._
import ar.edu.utn.concepto.domain.Materia
import ar.edu.utn.concepto.home.HomeMaterias

/**
 * Application model que representa la búsqueda de {@link Celular}.
 * Contiene:
 * <ul>
 * 	<li>El estado de los atributos por los cuales buscar: numero y nombre</li>
 *  <li>El comportamiento para realizar la búsqueda (en realidad delega en otros objetos)</li>
 *  <li>El estado del resultado de la búsqueda, es decir que recuerda la lista de Celulares resultado</li>
 *  <li>El estado de la selección de un Celular para poder utilizar el comportamiento que sigue...</li>
 *  <li>Comportamiento para eliminar un Celular seleccionado.</li>
 * </ul>
 *
 * Este es un objeto transiente, que contiene estado de la ejecución para un usuario en particular
 * en una ejecución de la aplicación en particular.
 *
 * @author npasserini
 */
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