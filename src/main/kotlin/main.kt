fun main() {

    val wallE = WallE(0, 0)

    var consola = ""
    while (consola != "EXIT") {
        println("Escreva os movimentos (N/S/E/O)")
        consola = readLine()!!.toUpperCase()

        println("${wallE.leConsola(consola)}")
    }

}