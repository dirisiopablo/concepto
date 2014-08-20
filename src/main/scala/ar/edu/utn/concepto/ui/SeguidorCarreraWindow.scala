package ar.edu.utn.concepto.ui

import java.awt.Color
import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.bindings.NotNullObservable
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import ar.edu.utn.concepto.runnable.MateriasApplication
import ar.edu.utn.concepto.domain.Celular
import ar.edu.utn.concepto.controller.SiNoTransformer
import ar.edu.celulares.applicationModel.BuscadorCelular
import ar.edu.utn.concepto.domain.Materia
import org.uqbar.arena.widgets.Selector
import javafx.beans.property.SetProperty
import ar.edu.celulares.applicationModel.SeguidorCarrera
import ar.edu.utn.concepto.home.HomeMaterias

/**
 * Ventana de búsqueda de celulares.
 *
 * @see BuscadorCelular el modelo subyacente.
 *
 * @author ?
 */
class BuscarCelularesWindow(parent: WindowOwner) extends SimpleWindow[SeguidorCarrera](parent, new SeguidorCarrera) {

	getModelObject.getMaterias

	override def createMainTemplate(mainPanel: Panel) = {
		this.setTitle("Seguidor de carrera")

		super.createMainTemplate(mainPanel)

		this.createMateriasPanel(mainPanel)
	}

	// *************************************************************************
	// * FORMULARIO DE BUSQUEDA
	// *************************************************************************
	/**
	 * El panel principal de búsuqeda permite filtrar por número o nombre
	 */
	override def createFormPanel(mainPanel: Panel) = {
		var materiasPanel = new Panel(mainPanel)
		materiasPanel.setLayout(new ColumnLayout(1))

		var labelMateria = new Label(materiasPanel)
		labelMateria.setText("Materias")
		labelMateria.setForeground(Color.BLUE)

	}

	override def addActions(actionsPanel: Panel) {
		new Button(actionsPanel)
			.setCaption("Nueva materia")
			.onClick(new MessageSend(this, "crearMateria"))

		var ver = new Button(actionsPanel)
			.setCaption("Ver materia")
			.onClick(new MessageSend(this, "verMateria"))

		var elementSelected = new NotNullObservable("materiaSeleccionada")
		ver.bindEnabled(elementSelected)
	}

	// *************************************************************************
	// ** RESULTADOS DE LA BUSQUEDA
	// *************************************************************************

	def createMateriasPanel(mainPanel: Panel) {
		var list = new Selector[Materia](mainPanel)
		list.bindItemsToProperty("resultados")
		list.bindValueToProperty("materiaSeleccionada")
	}

	// ********************************************************
	// ** Acciones
	// ********************************************************

	def openDialog(dialog: Dialog[_]) {
		dialog.onAccept(new MessageSend(getModelObject, "getMaterias"))
		dialog.open
	}

	def verMateria() {
		this.openDialog(new VerMateriaWindow(this, getModelObject.materiaSeleccionada))
	}

	def crearMateria() {
		this.openDialog(new CrearMateriaWindow(this))
	}

}