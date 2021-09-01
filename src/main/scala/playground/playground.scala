package playground

import akka.actor.ActorSystem

object playground extends App {

  val actorSystem: ActorSystem = ActorSystem("HelloAkka")
  println(actorSystem.name)
}
