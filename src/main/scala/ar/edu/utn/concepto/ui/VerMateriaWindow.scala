package ar.edu.utn.concepto.ui

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.utils.Observable

import ar.edu.utn.concepto.domain.Materia

class VerMateriaWindow (owner: WindowOwner, model: Materia) extends Dialog[Materia](owner, model) {

	override def createMainTemplate(mainPanel: Panel) = {
		this.setTitle("Seguidor de carrera")

		super.createMainTemplate(mainPanel)

		this.createMateriasPanel(mainPanel)
	}
	
	override def createFormPanel(mainPanel: Panel) = {
		
		this.setTitle("Nueva materia")
		
		var form = new Panel(mainPanel)
		form.setLayout(new ColumnLayout(2))
		
		new Label(form)
			.setText(model.nombre)
			.setFontSize(18)
	
	}
	
	def createMateriasPanel(mainPanel: Panel) = {
		new Label(mainPanel)
			.setText("Año cursada: ")
		new TextBox(mainPanel)
			.bindValueToProperty("anioCursada")
			
		new CheckBox(mainPanel)
			.bindValueToProperty("finalAprobado")

	}

	override def addActions(actions: Panel) = {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this, "accept"))
			.setAsDefault.disableOnError

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick(new MessageSend(this, "cancel"))
	}

	
	override def executeTask() = {
//		HomeMaterias.create(getModelObject)
		super.executeTask()
	}

}