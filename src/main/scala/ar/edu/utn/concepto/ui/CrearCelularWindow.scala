package ar.edu.utn.concepto.ui

import ar.edu.utn.concepto.domain.Celular
import org.uqbar.arena.windows.WindowOwner
import ar.edu.utn.concepto.home.HomeCelulares
import ar.edu.utn.concepto.home.HomeCelulares

class CrearCelularWindow(owner: WindowOwner) extends EditarCelularWindow(owner, new Celular) {

	override def executeTask() = {
		HomeCelulares.create(getModelObject)
		super.executeTask()
	}

}