package pattern.behavioral.memento

/**
 * The idea in a Memento, is to provide a safe way to rollback a change or changes before commiting
 * There are different ways to implement, usually there is a Register that keeps track of the history, and a Memento
 * 
 * Todo: Try to implement Redo Ctrl+y 
 * 
 */
object ComeUndoneMemento {

  def main(args: Array[String]): Unit = {
   val word = WordDocument()
      .execute(AddWord("Hola"))
      .execute(AddSpace())
      .execute(AddWord("Mundle"))
      .execute(CtrlZeta())
      .execute(AddWord("Mundo"))
      .execute(AddWord("?"))
      .execute(CtrlZeta())
      .execute(AddWord("!!!"))
     .execute(CtrlZeta())
     .execute(CtrlRedo())
    
    println(s"It should print: 'Hola Mundo!!!' and was '${word.getText()}''")
  }
}

trait MementoCommand {
  def execute(doc: WordDocument): WordDocument
}

case class CtrlRedo() extends MementoCommand {
  def execute(doc: WordDocument): WordDocument = {
    val lastCommandHistory = doc.history
    doc.copy(history = doc.lastCommandHistory, lastCommandHistory = lastCommandHistory)
  }
}


case class AddWord(word: String) extends MementoCommand {
  def execute(doc: WordDocument): WordDocument = {
    doc.copy(history = word :: doc.history, lastCommandHistory = doc.history )
  }
}
case class AddSpace() extends MementoCommand {
  val theWhiteSpace = " "
  def execute(doc: WordDocument): WordDocument = {
    AddWord(theWhiteSpace).execute(doc)
  }
}
case class CtrlZeta() extends MementoCommand {
  def execute(doc: WordDocument): WordDocument = {
    doc.copy(history = doc.history.tail, lastCommandHistory = doc.history)
  }
}

case class WordDocument(history: List[String] = Nil, lastCommandHistory: List[String] = Nil) {
  def execute(command: MementoCommand) = {
    command.execute(this)
  }
  
  def getText() = history.reverse.mkString("")
}