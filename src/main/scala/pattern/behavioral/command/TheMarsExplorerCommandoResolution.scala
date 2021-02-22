package pattern.behavioral.command

import scala.util.{Failure, Random, Success, Try}

/**
 * EXAMPLE
 * We have to design the Mars Explorer moving interface, the robot can move, turn LEFT, RIGHT, or BACK.
 * 
 * But, the mars map contains some issues, so you need to keep tracke where the robot is, and if a movement is not
 * possible, it should return an exception
 * 
 */
object TheMarsExplorerCommandoResolution {

  def main(args: Array[String]): Unit = {
    val marsMap = new MarsMap(100, 100, 0)
    val initialPosition = Position(50, 50)
    val rover = MarsRover(initialPosition, Heading.North, marsMap)
    
    val movements = List("MOVE", "MOVE", "LEFT", "MOVE", "RIGHT", "MOVE", "MOVE")
    
    val eitherRoverInTheNewPositionOrError: Try[MarsRover] = rover.process(movements)
    
    println(eitherRoverInTheNewPositionOrError.map(rover => s"Position: ${rover.position}  and Heading: ${rover.heading}" ))
  }
}

trait Command {
  def execute(rover: MarsRover, marsMap: MarsMap): Try[MarsRover]
}

case class Move() extends Command {
  override def execute(rover: MarsRover, marsMap: MarsMap): Try[MarsRover] = {
    val roverAfterMovement = rover.moveForeward()
    if (marsMap.isValid(roverAfterMovement.position))
      Success(roverAfterMovement)
    else
      Failure(ImpossibleToMoveException())
  }
}

case class TurnLeft() extends Command with Bearing {
  override def execute(rover: MarsRover, marsMap: MarsMap): Try[MarsRover] = Success(rover.turn(this))
  def turn(heading: Heading): Heading = heading match {
    case Heading.North => Heading.West
    case Heading.South => Heading.East
    case Heading.East => Heading.North
    case Heading.West => Heading.South
  }
}

case class TurnRight() extends Command with Bearing {
  override def execute(rover: MarsRover, marsMap: MarsMap): Try[MarsRover] = Success(rover.turn(this))
  def turn(heading: Heading): Heading = heading match {
    case Heading.North => Heading.East
    case Heading.South => Heading.West
    case Heading.East => Heading.South
    case Heading.West => Heading.North
  }
}

case class TurnBack() extends Command with Bearing {
  override def execute(rover: MarsRover, marsMap: MarsMap): Try[MarsRover] = Success(rover.turn(this))
  def turn(heading: Heading): Heading = heading match {
    case Heading.North => Heading.South
    case Heading.South => Heading.North
    case Heading.East => Heading.West
    case Heading.West => Heading.East
  }
}

case class MarsRover(position: Position, heading: Heading, marsMap: MarsMap) {
  private val step = 1
  
  def process(movements: List[String]): Try[MarsRover] = {
    val rover_commands: List[Command] = CommandFactory.create(movements) 
    val initial_position: Try[MarsRover] = Success(this)
    rover_commands.foldLeft(initial_position)(move(_, _))
  }
  
  def move(either_rover: Try[MarsRover], command: Command): Try[MarsRover] = {
    if (either_rover.isFailure) {
      either_rover
    } else {
      either_rover.flatMap(command.execute(_, marsMap))
    }
  }
  
  def moveForeward(): MarsRover = {
    this.copy(position = getPositionAfterMovement())
  }
  
  def turn(bearing: Bearing) = {
    this.copy(heading = bearing.turn(this.heading))
  }
  
  
  def getPositionAfterMovement() = {
    heading match {
      case Heading.North => position.copy(latitude = position.latitude + step)
      case Heading.South => position.copy(latitude = position.latitude - step)
      case Heading.East => position.copy(longitud = position.longitud + step)
      case Heading.West => position.copy(longitud = position.longitud - step)
    }
  }
}





object CommandFactory {
  def create(movements: List[String]): List[Command] = {
    movements.map( create(_))
  }
  private def create(movement: String) = movement match {
    case "LEFT" => TurnLeft()
    case "RIGHT" => TurnRight()
    case "MOVE" => Move()
    case "BACK" => TurnBack()
  }
}


case class Position(latitude: Int, longitud: Int)

class MarsMap(width: Int, height: Int, problems: Int) {
  val problematic_positions: List[Position] = createProblems(problems)
  
  def createProblems(i: Int): List[Position] = {
    for {
      range <- Range(0, i).toList
    } yield {
      Position(Random.between(0, width), Random.between(0, height))  
    }
  }
  
  def isValid(nextPosition: Position): Boolean = {
    val isBetweenHeight = nextPosition.latitude > 0 || nextPosition.latitude < height
    val isBetweenWidth = nextPosition.longitud > 0 || nextPosition.longitud < width
    isBetweenHeight && isBetweenWidth
  }
  
}

enum Heading {
  case North, South, East, West
}

trait Bearing {
  def turn(heading: Heading): Heading
}

case class ImpossibleToMoveException() extends RuntimeException