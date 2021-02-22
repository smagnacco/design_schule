package pattern.structural.adapter
import scala.util.{Failure, Success, Try}
import scala.util.control.Exception._

/**
 * Example: 
 * 
 * The idea behind adapter patterns is to adapt your logic with your interface api against an external api, during
 * library updates, if there is a change it will be encapsulated inside the adapter. Proxy patterns is quite similar,
 * however it uses the same interface that the target class, so you can extend functionality without having to introduce
 * another interface
 * 
 */
object AntiBlowUpAdapter {

  def main(args: Array[String]): Unit = {
    val geoPosition = GeoPosition(999, 28)
    
    val externalLib = new GeoPositionLibrary()
    
    val geoPositionAdapter: ExternalApiLibraryForGeoPositionAdapter = ExternalApiLibraryForGeoPositionAdapterImpl(externalLib)
    
    val result = geoPositionAdapter.calculateBeachDistance(geoPosition)
    
    printResultMessage(result)
  }
  
  def printResultMessage(triedDistance: Try[GeoDistance]) = {
    triedDistance match {
      case Failure(exception) => println(s"\n\nError in distance calculation due to ${exception}")
      case Success(distance) => println(s"\n\nThe distance is $distance")
    }
  }
}

class ExternalApiLibraryForGeoPositionAdapterImpl(library: GeoPositionLibrary) 
  extends ExternalApiLibraryForGeoPositionAdapter {
  
  def calculateBeachDistance(geoPosition: GeoPosition): Try[GeoDistance] = {
    Try {
      
      val distance = library.getBeachDistance(geoPosition.latitude, geoPosition.longitude)
      
      GeoDistance(distance)
    
    }
  }
}



trait ExternalApiLibraryForGeoPositionAdapter {
  def calculateBeachDistance(geoPosition: GeoPosition): Try[GeoDistance]
}

case class GeoDistance(distance: Int)
case class GeoPosition(latitude: Float, longitude: Float)
