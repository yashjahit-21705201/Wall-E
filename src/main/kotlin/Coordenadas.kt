class Coordenadas(var x: Int, var y: Int) {

    fun setLocalizacao(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    override fun hashCode(): Int {
        var result = 17
        result = 31 * result + x.hashCode()
        result = 31 * result + y.hashCode()

        return result
    }

    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Coordenadas) return false

        val coordenadas = other
        return (coordenadas.x == x &&
                coordenadas.y == y)
    }
}