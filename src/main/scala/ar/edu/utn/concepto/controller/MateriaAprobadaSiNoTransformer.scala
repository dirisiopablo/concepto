package ar.edu.utn.concepto.controller

import com.uqbar.commons.collections.Transformer
import ar.edu.utn.concepto.domain.Materia

class MateriaAprobadaSiNoTransformer extends Transformer[Materia,String] {
	override def transform(materia: Materia): String = {
	  if(materia.estaAprobada) "SI" else "NO"
	}

}