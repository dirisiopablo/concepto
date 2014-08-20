package ar.edu.utn.concepto.ui

import org.uqbar.arena.windows.WindowOwner
import ar.edu.utn.concepto.domain.Nota
import ar.edu.utn.concepto.home.HomeNotas
import ar.edu.celulares.applicationModel.MateriaInfo

class CrearNotaWindow(owner: WindowOwner, model: MateriaInfo) extends EditarNotaWindow(owner, new Nota) {

	override def executeTask {
		getModelObject.materia = model.materia.nombre
		HomeNotas.create(getModelObject)
		super.executeTask
	}
	
}