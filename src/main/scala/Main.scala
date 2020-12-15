import java.awt.Dimension
import scala.swing._
import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}

case class BallPosition(x: Int, y: Int)

class Ball extends Actor {
  private val areaMessenger: ActorSelection = context.actorSelection("../Area")
  var allowMoving = true
  var x, y: Int = 0

  /**
   * This methods changes position of "ball" on the "x" axis. Remember to disallow having x lower than 0
   * @param delta   Move delta
   */
  private def moveX(delta: Int): Unit = ???

  /**
   * This methods changes position of "ball" on the "y" axis. Remember to disallow having x lower than 0
   * @param delta Move delta
   */
  private def moveY(delta: Int): Unit = ???

  /**
   * Overrides receive method from actor class. Should be pattern matching over possible messages.
   * @return
   */
  override def receive: Receive = ???
}

class Area(val textPane: TextPane) extends Actor {
  /**
   * Overrides receive method from actor class. Moves "ball" accordingly to message
   * @return
   */
  override def receive: Receive = {
    ???
  }
}

object Main extends SimpleSwingApplication {
  val actorSystem: ActorSystem = ActorSystem("Default")

  val textPane = new TextPane
  textPane.text = "x"
  textPane.editable = false
  textPane.minimumSize = new Dimension(600, 300)

  val area: ActorRef = actorSystem.actorOf(Props(new Area(textPane)), name="Area")
  val ballMessenger: ActorRef = ???

  val leftButton = new Button(Action("a") {
    ???
  })
  val rightButton = new Button(Action("d") {
    ???
  })
  val upButton = new Button(Action("w") {
    ???
  })
  val downButton = new Button(Action("s") {
    ???
  })
  val toggleMove = new Button(Action("toggle move") {
    ???
  })

  def top: MainFrame = new MainFrame {
    title = "Pimp my ball"
    contents = new BoxPanel(Orientation.Vertical) {
      contents += textPane
      contents += new BoxPanel(Orientation.Vertical) {
        override def size: Dimension = new Dimension(600, 100)
        ???
      }
    }
    size = new Dimension(600, 400)
  }
}
