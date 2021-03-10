package pattern.structural.decorator

/**
 * Decorator, o mamushka pattern for friends and foes
 * The idea behind decorator is that the caller sees only a api call interface, however, operations will be applied in
 * runtime defined in a builder or factory class. 
 *
 * todo: El problema se divide en dos, en poder aplicar distintas promociones y poder crear que promociones queremos usar
 * Inicialmente nos dan una no promocion, es decir devuelve el mismo precio
 * Desarrollar como podemos hacer los siguientes descuentos
 * - Descuento 10%
 * - Descuento 15% adicional si el precio es mayor a 100
 * - Descuento Fijo, restar 10 si el precio es mayor a 20
 * - Descuento Combinado, Fijo y Porcentaje, te descontamos 10 y sumale un 20% de descuento después de los 10
 *
 * Poder combinarlos por ejemplo: Descuento 10% + Descuento 15%
 * Descuento Fijo + Descuento 15% + Descuento 10%
 * Descuento Combinado + Descuento 10% aplicado 2 veces
 *
 */
object PromotionMamushkaDecorator {

  def main(args: Array[String]): Unit = {
   val price = 100.0

    val promotions = createPromotions()

    val priceAfterApplyingPromotions = promotions.calculate(price)

    println(s"\n\nPrice after applying promotions $priceAfterApplyingPromotions")
  }

  def createPromotions(): Promotion = {
    NoPromotion()
  }
}

trait Promotion {
  def calculate(price: Double): Double
}

case class NoPromotion() extends Promotion {
  def calculate(price: Double): Double = price
}