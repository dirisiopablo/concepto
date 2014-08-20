package ar.edu.utn.concepto.controller

import com.uqbar.commons.collections.Transformer
import ar.edu.utn.concepto.domain.Nota

class NotaAprobadaSiNoTransformer extends Transformer[Nota, String] {

	override def transform(nota: Nota) : String = 
	    if (nota.estaAprobada) "SI" else "NO"
}