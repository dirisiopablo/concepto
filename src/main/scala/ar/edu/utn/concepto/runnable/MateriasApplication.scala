package ar.edu.utn.concepto.runnable

import ar.edu.utn.concepto.ui.BuscarCelularesWindow
import org.uqbar.arena.Application

object MateriasApplication extends Application with App {
	
	override def createMainWindow() = new BuscarCelularesWindow(this)
	start()
}