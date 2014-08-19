package samples

import org.junit._
import Assert._
import concepto.modelo.Concepto

@Test
class AppTest {

    @Test
    def testOK() = assertTrue(true)

    @Test
    def convertirDeMillasAKilometros() = {
      var concepto = new Concepto();
      concepto.millas = 1;
      concepto.convertir;
      assertEquals(1 * concepto.factor_conversion_millas_kilometros, concepto.kilometros, 10);
    }
    
}


