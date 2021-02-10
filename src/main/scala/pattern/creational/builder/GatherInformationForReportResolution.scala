package pattern.creational.builder

import java.math.{MathContext, RoundingMode}

import scala.math.BigDecimal.RoundingMode.RoundingMode

/**
 * The idea is to gather information for a report during a chain of processes applied to a request
 * 
 * La idea es poder juntar información en distintas etapas de la transformación de un request que ingresa al sistema
 * para finalmente generar un reporte.
 *
 * Note: I take shortcuts in order to focus on the problem
 * Nota: Me tomo algunas licencias para enfocarme en el problema
 *
 */
object GatherInformationForReportResolution {
  def main(args: Array[String]): Unit = {
    val priceRequest = PriceRequest(300.0)

    val discountService = DiscountService()

    val taxService = TaxService()

    val roundService = RoundService()

    val priceAfterDiscount = discountService.discount(priceRequest)

    val priceAfterTaxes = taxService.addTaxes(priceAfterDiscount)

    val finalRoundedPrice = roundService.round(priceAfterTaxes)

    val priceTransformationReport = finalRoundedPrice

    println( priceTransformationReport )
  }

}


class ReportBuilder(date: String) {
  def build(): PriceReport = PriceReport(Nil)
}


class DiscountService(discount: Int = 10) {
    def discount(priceRequest: PriceRequest): PriceRequest = {
      priceRequest.copy(priceRequest.value * discount)
    }
}

class TaxService(tax: Int = 21 ) {
  def addTaxes(priceRequest: PriceRequest): PriceRequest = {
    priceRequest.copy(value = priceRequest.value + priceRequest.value * tax)
  }
}

class RoundService() {
  val mc: MathContext = new MathContext(2, RoundingMode.CEILING)
  
  def round(priceRequest: PriceRequest): PriceRequest = {
    priceRequest.copy(value = BigDecimal(priceRequest.value, mc).toDouble)
  }
  
}

case class PriceRequest(value: Double)
case class PriceReport(report: List[String])