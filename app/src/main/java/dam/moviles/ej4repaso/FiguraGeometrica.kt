package dam.moviles.ej4repaso

interface FiguraGeometrica {
    fun calcularArea(): Double
    fun calcularVolumen(): Double
}

class Cubo(private val lado: Double) : FiguraGeometrica {
    override fun calcularArea() = 6 * lado * lado
    override fun calcularVolumen() = lado * lado * lado
}

class Cono(private val radio: Double, private val altura: Double, private val generatriz: Double) : FiguraGeometrica {
    override fun calcularArea() = Math.PI * radio * (radio + generatriz)
    override fun calcularVolumen() = (1.0 / 3) * Math.PI * radio * radio * altura
}

class Cilindro(private val radio: Double, private val altura: Double) : FiguraGeometrica {
    override fun calcularArea() = 2 * Math.PI * radio * (radio + altura)
    override fun calcularVolumen() = Math.PI * radio * radio * altura
}
