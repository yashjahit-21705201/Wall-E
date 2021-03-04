import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class TestWallE {

    @Test
    fun testSemEscreverLetra() {
        val wallE = WallE(0, 0)
        assertEquals(1, wallE.leConsola(""))
    }

    @Test
    fun testStringComEspaco() {
        val wallE = WallE(0, 0)
        assertEquals(4, wallE.leConsola("N     E     S     O"))
    }

    @Test
    fun testComNumeros() {
        val wallE = WallE(0, 0)
        assertEquals(1, wallE.leConsola("000001112222333444"))
    }

    @Test
    fun testGrandeString() {
        val wallE = WallE(0, 0)
        val string = "N".repeat(Short.MAX_VALUE.toInt())
        assertEquals(Short.MAX_VALUE.toInt() + 1, wallE.leConsola(string))
    }

    @Test
    fun testTresPercusos() {
        val wallE = WallE(0, 0)
        Assertions.assertAll(
            Executable { assertEquals(4, wallE.leConsola("NESO")) },
            Executable { assertEquals(4, wallE.leConsola("0000")) },
            Executable { assertEquals(5, wallE.leConsola("000AAASAAA000")) }
        )
    }
}