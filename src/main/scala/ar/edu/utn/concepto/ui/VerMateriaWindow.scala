package ar.edu.utn.concepto.ui

import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.lacar.ui.model.bindings.Binding
import ar.edu.celulares.applicationModel.MateriaInfo
import ar.edu.utn.concepto.domain.Materia
import ar.edu.utn.concepto.domain.Ubicacion
import com.uqbar.commons.collections.CollectionFactory
import org.uqbar.arena.widgets.tables.Table
import ar.edu.utn.concepto.domain.Nota
import org.uqbar.arena.widgets.tables.Column
import ar.edu.utn.concepto.controller.NotaAprobadaSiNoTransformer
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.bindings.NotNullObservable

class VerMateriaWindow(owner: WindowOwner, model: MateriaInfo) extends Dialog[MateriaInfo](owner, model) {
	getModelObject.search()
	override def createMainTemplate(mainPanel: Panel) = {

		this.setTitle("Nueva materia")
		super.createMainTemplate(mainPanel)
		this.createMateriasPanel(mainPanel)
		this.createGridActions(mainPanel)

	}

	override def createFormPanel(mainPanel: Panel) = {

		var form = new Panel(mainPanel)
		form.setLayout(new ColumnLayout(2))

		new Label(form)
			.setText(model.materia.nombre)
			.setFontSize(18)

	}

	def createMateriasPanel(mainPanel: Panel) = {

		var materiaInfoPanel = new Panel(mainPanel)
		materiaInfoPanel.setLayout(new ColumnLayout(2))

		new Label(materiaInfoPanel)
			.setText("Año cursada: ")
		new TextBox(materiaInfoPanel)
			.bindValueToProperty("materia.anioCursada")

		new Label(materiaInfoPanel)
			.setText("Final aprobado: ")
		new CheckBox(materiaInfoPanel)
			.bindValueToProperty("materia.finalAprobado")

		new Label(materiaInfoPanel)
			.setText("Profesor: ")
		new TextBox(materiaInfoPanel)
			.bindValueToProperty("materia.profCursada")

		new Label(materiaInfoPanel)
			.setText("Año cursada: ")

		var list = new Selector[Ubicacion](materiaInfoPanel)
		list.bindItemsToProperty("ubicaciones")
		list.bindValueToProperty("materia.ubicacion")

		var table = new Table[Nota](mainPanel, classOf[Nota])
		table.setHeigth(100)
		table.setWidth(275)
		table.bindItemsToProperty("materia.notas")
		table.bindValueToProperty("notaSeleccionada")
		this.describeResultsGrid(table)

	}

	def describeResultsGrid(table: Table[Nota]) = {
		new Column[Nota](table) //
			.setTitle("Fecha")
			.setFixedSize(100)
			.bindContentsToProperty("fecha")

		new Column[Nota](table) //
			.setTitle("Descripcion")
			.setFixedSize(100)
			.bindContentsToProperty("descripcion")

		new Column[Nota](table)
			.setTitle("Aprobada")
			.setFixedSize(75)
			.bindContentsToTransformer(new NotaAprobadaSiNoTransformer)
	}


	def createGridActions(mainPanel: Panel) = {
		var actionsPanel = new Panel(mainPanel)
		actionsPanel.setLayout(new HorizontalLayout)
		var crear = new Button(actionsPanel)
			.setCaption("Nuevo")
			.onClick(new MessageSend(this, "crearNota"))			
		
		var edit = new Button(actionsPanel)
			.setCaption("Editar")
			.onClick(new MessageSend(this, "modificarNota"))

		var remove = new Button(actionsPanel)
			.setCaption("Eliminar")
			.onClick(new MessageSend(getModelObject, "eliminarNotaSeleccionada"))

		// Deshabilitar los botones si no hay ningún elemento seleccionado en la grilla.
		var elementSelected = new NotNullObservable("notaSeleccionada")
		remove.bindEnabled(elementSelected)
		edit.bindEnabled(elementSelected)
	}
	
	//Aciones
	
	override def addActions(actions: Panel) = {
//		new Button(actions)
//			.setCaption("Aceptar")
//			.onClick(new MessageSend(this, "accept"))
//			.setAsDefault.disableOnError
//
//		new Button(actions) //
//			.setCaption("Cancelar")
//			.onClick(new MessageSend(this, "cancel"))
	}
	
	def crearNota() {
    this.openDialog(new CrearNotaWindow(this))
  }

  def modificarNota() {
    this.openDialog(new EditarNotaWindow(this, getModelObject.notaSeleccionada))
  }

  def openDialog(dialog: Dialog[_]) {
    dialog.onAccept(new MessageSend(getModelObject, "search"))
    dialog.open
  }

	override def executeTask() = {
		//		HomeMaterias.create(getModelObject)
		super.executeTask()
	}

}