package pattern.structural.proxy

/**
 * The idea behind proxy is to add behavior before or after calling a target object, like Spring framework.
 * 
 * Todo: Try to create a Proxy with a LogException trait, however, respect PhoneApi interface
 */
object YourPhoneIsYourProxy {

  def main(args: Array[String]): Unit = {
    val phoneApi: PhoneApiLibrary = createPhoneLibrary()
   
    val phoneNumber = phoneApi.getPhoneNumber("Sergio")
    
    println (phoneNumber)
  }
  
  
  def createPhoneLibrary(): PhoneApiLibrary = {
    new PhoneApiLibrary();
  }
}





trait LogException {
  def logException(throwable: Throwable, operation: String) = {
    println(s"An error was called ${throwable} in $operation")
  }
}