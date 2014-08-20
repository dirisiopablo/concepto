package ar.edu.utn.concepto.ui

import ar.edu.utn.concepto.domain.Celular
import org.uqbar.arena.windows.WindowOwner
import ar.edu.utn.concepto.home.HomeCelulares
import ar.edu.utn.concepto.home.HomeCelulares
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.windows.Dialog
import ar.edu.utn.concepto.domain.Materia
import ar.edu.utn.concepto.home.HomeMaterias

class CrearMateriaWindow(owner: WindowOwner) extends Dialog[Materia](owner, new Materia) {

	override def createFormPanel(mainPanel: Panel) = {
		
		this.setTitle("Nueva materia")
		
		var form = new Panel(mainPanel)
		form.setLayout(new ColumnLayout(2))
		
		new Label(form)
			.setText("Nombre: ")
			
		new TextBox(form)
			.bindValueToProperty("nombre")
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
		HomeMaterias.create(getModelObject)
		super.executeTask()
	}

}