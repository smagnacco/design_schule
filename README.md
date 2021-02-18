# Design Schule

## Advanced Design Technics Course

The excuse of this project is to teach different design patterns with Scala.

Each file will be present a problem, some strategies to solve them, and a design approach to target software quality of flexibility.

(WIP)
## SOLID principles:
1.1 Single Responsibility
1.2 Open/Closed
1.3 Liskov Substitution
1.4 Interface Segregation
1.5 Dependency Inversion

## Design Patterns
### Behavioral
2.1 Command
2.2 Observer
2.3 Strategy
2.4 Visitor

### Creational
3.1 Factory
3.2 Builder
3.3 Singleton
3.4 Dependency Injection

### Structural
4.1 Adapter
4.2 Composite
4.3 Decorator
4.4 Proxy

### Usage
WIP
This is a normal sbt project, you can compile code with `sbt compile` and run it
with `sbt run`, `sbt console` will start a Dotty REPL.

### Environment setup (prerequisite)
1. Install coursier [Install Coursier](https://get-coursier.io/docs/cli-installation)
2. [Setup coursier](https://get-coursier.io/docs/cli-setup) ``` cs setup ```
3. Close and reopen terminal
4. Go to project and run sbt compile, it should start downloading dependencies
5. Intellij configuration
5.1 Download Intellij Community Edition
5.2 Settings -> Plugins -> Scala
5.3 Restart Intellij
5.4 File -> New Project from existing Source, and select project

