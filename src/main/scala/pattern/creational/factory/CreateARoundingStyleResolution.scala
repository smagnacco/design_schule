package pattern.creational.factory

import java.math.{MathContext, RoundingMode}


object RoundingStyleFactory {
  def create(style: String): RoundingMode = ???
}

object CreateARoundingStyleResolution {
  def main(args: Array[String]): Unit = {

    val roundCeiling = RoundingStyleFactory.create("CEILING")
    
    test(99.9, roundCeiling)
    
    val roundFloor = RoundingStyleFactory.create("FLOOR")

    test(99.9, roundFloor)
    
    val roundUp = RoundingStyleFactory.create("UP") // NO CONFUNDIR CON EL ROUNDUP A BASE DE GLIFOSATO DE f*** MONSANTO
    test(99.9, roundUp)
        
  }
  
  def test(number: BigDecimal, rm: RoundingMode) = println(number.round(MathContext(2, rm)).toDouble)
}

//TODO: VER COMO COMBINARLO CON GatherInformationForReport para poder elegir que estilo de rounding usar
