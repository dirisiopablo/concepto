package ar.edu.utn.concepto.controller

import com.uqbar.commons.collections.Transformer
import ar.edu.utn.concepto.domain.Celular

class SiNoTransformer extends Transformer[Celular, String] {

	override def transform(celular: Celular) : String = 
	    if (celular.recibeResumenCuenta) "SI" else "NO"
	
}