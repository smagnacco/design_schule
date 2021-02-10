package pattern.creational.builder

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
    
    val priceTransformationReport = reportBuilder.build()
    
    println( priceTransformationReport )
  }

}


class ReportBuilder(date: String) {
  def build(): PriceReport
}


class DiscountService() {
    def discount(priceRequest: PriceRequest): PriceRequest = {
      
    }
}

class TaxService() {
  def addTaxes(priceRequest: PriceRequest): PriceRequest = {
    
  }
}

class RoundService() {
  def round(priceRequest: PriceRequest): PriceRequest = {
    
  }
}

case class PriceRequest(value: Double)
case class PriceReport(report: List[String])