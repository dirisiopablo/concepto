package ar.edu.utn.concepto.ui

import org.uqbar.arena.windows.WindowOwner
import ar.edu.utn.concepto.domain.Nota
import ar.edu.utn.concepto.home.HomeNotas

class CrearNotaWindow(owner: WindowOwner) extends EditarNotaWindow(owner, new Nota) {
		
  override def executeTask() = {
		HomeNotas.create(getModelObject)
		super.executeTask()
  }
}