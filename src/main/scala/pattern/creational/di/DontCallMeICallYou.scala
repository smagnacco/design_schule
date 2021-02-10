package pattern.creational.di

import pattern.creational.builder.PriceRequest

import scala.util.{Failure, Success, Try}

/**
 * Dependency Inversion Pattern, instead of a class instancing another class to solve a problem, it will receive
 * an already created class (behind an interface if you want to change behavior like in a test).
 * 
 * Dependency Injection is how you will provide those already created objects.
 * 1. Not recommended but possible, through a parameter call (awfull), you will see as a smell due to long paramether
 * 2. Simple Old School, like me, using factories and provide the instance using the class constructor
 * 3. Java Old School, using the evil setters... 
 * 4. Up Front Big Design School (sobrediseño en español), use a heavy or lightweight Framework, 
 * because write xml or yamls is so nice... WTF! 
 * 
 */
object DontCallMeICallYou {
  /**
   * The excercise requires to provide 3 services to another service
   * @param args
   */
  def main(args: Array[String]): Unit = {
    val price = PriceRequest(300.0)
    val country = "AR"
    val priceService: PriceService = PriceServiceMock()
    val taxSnapshotService: TaxSnapshotService = TaxSnapshotServiceMock()
    val storePriceService: StorePriceService = StorePriceServiceMock()
    
    val mainProcess = new ProcessPriceWithLongParameterSmell()
    
    val result = mainProcess.process(price, country, priceService, taxSnapshotService, storePriceService)
    
    println(result)
  }
}

//Excercise refactor this in order to inject dependecies
// first option move params to constructor and instantiate in there, thinnk in the problem
// pass through constructor, my school
// try to change result of the mock (inject a result)

class ProcessPriceWithLongParameterSmell {

  def process(price: PriceRequest,
              country: String,
              priceService: PriceService,
              taxSnapshotService: TaxSnapshotService,
              storePriceService: StorePriceService): Try[Boolean] = {
    
    if ( ! priceService.isValid(price) ) 
      Failure(PriceInvalidException())
    else {
      val priceAfterTaxes = taxSnapshotService.calculate(price, country)
      storePriceService.save( price, priceAfterTaxes, country )
    }
  }
}

trait PriceService {
  def isValid(price: PriceRequest): Boolean
}

trait StorePriceService {
  def save(price: PriceRequest, priceAfterTax: PriceRequest, country: String): Try[Boolean]
}

trait TaxSnapshotService {
  def calculate(price: PriceRequest, country: String): PriceRequest
}

case class PriceServiceMock() extends PriceService {
  def isValid(price: PriceRequest): Boolean = true
}

case class StorePriceServiceMock() extends StorePriceService {
  def save(price: PriceRequest, priceAfterTax: PriceRequest, country: String): Try[Boolean] = Success(true)
}

case class TaxSnapshotServiceMock() extends TaxSnapshotService {
  def calculate(price: PriceRequest, country: String): PriceRequest = price
}

case class PriceInvalidException() extends RuntimeException

