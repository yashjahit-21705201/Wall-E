import java.awt.geom.Point2D

class WallE(x: Int, y: Int) {

    // Pontos que o WallE ja tem. Comeca com 1 porque o primeiro ja apanhou
    var pontos = 1

    // A variavel do tipo Coordenadas permite definir um ponto numa coordenada (x, y)
    var posicao: Coordenadas = Coordenadas(x, y)

    // Lista de casas que ja limpou
    val posicoesPrevias: MutableSet<Coordenadas> = HashSet()

    // Assim que inicializamos a classe, passamos as novas coordenadas e guardamos na lista
    init {
        guardaPosicao()
    }

    // Funcao verifica a direcao e faz o devido movimento
    fun move(direcao: Char) {
        when(direcao) {
            'N' -> this.posicao.setLocalizacao(this.posicao.x, this.posicao.y + 1)
            'S' -> this.posicao.setLocalizacao(this.posicao.x, this.posicao.y - 1)
            'E' -> this.posicao.setLocalizacao(this.posicao.x + 1, this.posicao.y)
            'O' -> this.posicao.setLocalizacao(this.posicao.x - 1, this.posicao.y)
        }

        // Caso a casa ja tenha sido limpa, nao adiciona ponto. Caso contrario aumenta 1 ponto
        if (!jaLimpouCasa()) {
            this.pontos++
        }

        // Guarda a posicao que esta. Como temos um HashSet entao casas repetidas nao iram aparecer duplicadas
        guardaPosicao()
    }

    fun leConsola(consola: String): Int {
        for (i in consola.toUpperCase()) {
            move(i)
        }
        val pontosAntes = this.pontos

        resetEverything()

        return pontosAntes
    }

    private fun guardaPosicao() {
        this.posicoesPrevias.add(Coordenadas(this.posicao.x, this.posicao.y))
    }

    // Funcao verifica no HashSet se a casa ja foi limpa
    private fun jaLimpouCasa(): Boolean {
        for (p in posicoesPrevias) {
            if (p.x == this.posicao.x && p.y == this.posicao.y) return true
        }

        return false
    }

    private fun resetEverything(): Int {
        posicao = Coordenadas(0, 0)
        this.posicoesPrevias.clear()
        this.pontos = 1
        guardaPosicao()
        return this.pontos
    }

}