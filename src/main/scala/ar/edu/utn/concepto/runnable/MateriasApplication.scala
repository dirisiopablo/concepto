package ar.edu.utn.concepto.runnable

import org.uqbar.arena.Application
import ar.edu.utn.concepto.ui.SeguidorCarreraWindow

object MateriasApplication extends Application with App {
	
	override def createMainWindow() = new SeguidorCarreraWindow(this)
	start()
}