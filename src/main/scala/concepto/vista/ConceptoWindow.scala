package concepto.vista

import java.awt.Color

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.Window
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.Application

import concepto.modelo.Concepto

/**
 * 
 * @author uqbar
 */
class ConceptoSimpleWindow(owner:WindowOwner) extends SimpleWindow[Concepto](owner, new Concepto()) {

	override def addActions(actionsPanel:Panel) = {
		new Button(actionsPanel) //
			.setCaption("Convertir a kilómetros")
			.onClick(new MessageSend(this.getModelObject(), "convertir"))
	}

	override def createFormPanel(mainPanel:Panel ) {
		this.setTitle("Conversor de millas a kilómetros")
		mainPanel.setLayout(new VerticalLayout())

		new Label(mainPanel).setText("Ingrese la longitud en millas")

		new TextBox(mainPanel).bindValueToProperty("millas")

		new Label(mainPanel) //
			.setBackground(Color.ORANGE)
			.bindValueToProperty("kilometros")

		new Label(mainPanel).setText(" kilómetros")
		new Label(mainPanel).bindValueToProperty("country")
	}
}

object ConceptoRunner extends Application with App {
	def createMainWindow():Window[_] = new ConceptoSimpleWindow(this)
	start()
}