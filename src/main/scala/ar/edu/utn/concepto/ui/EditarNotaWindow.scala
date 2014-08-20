package ar.edu.utn.concepto.ui

import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.actions.MessageSend
import collection.JavaConversions._
import ar.edu.utn.concepto.domain.Nota

class EditarNotaWindow(owner: WindowOwner, model: Nota) extends Dialog[Nota](owner, model) {

	override def createFormPanel(mainPanel: Panel) = {
		var form = new Panel(mainPanel)
		form.setLayout(new ColumnLayout(2))		
		new Label(form).setText("Fecha")
		new TextBox(form).bindValueToProperty("fecha")
		new Label(form).setText("Descripcion")
		new TextBox(form).bindValueToProperty("descripcion")
		new Label(form).setText("Aprobo la Materia")
		new CheckBox(form).bindValueToProperty("aprobada")
	}

	override def addActions(actions: Panel) = {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this,"accept"))
			.setAsDefault.disableOnError

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick(new MessageSend(this, "cancel"))
	}

}
