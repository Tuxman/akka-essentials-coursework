package part2Actors

import akka.actor.{Actor, ActorSystem, Props}

object ActorsIntro extends App {

  // part 1 - actor systems
  val actorSystem = ActorSystem("firstActorSystem")
  println(actorSystem.name)

  // part 2 - create actors
  // word count actor

  class WordCountActor extends Actor {
    // internal data
    var totalWords = 0

    // behavior
    def receive: PartialFunction[Any, Unit] = {
      case message: String =>
        println(s"[word counter] I have received: $message")
        totalWords += message.split(" ").length
      case msg => println(s"[word counter] I cannot understand ${msg.toString}")
    }
  }

  // part 3 - instantiate our actor
  val wordCounter = actorSystem.actorOf(Props[WordCountActor], "wordCounter")
  val anotherWordCounter = actorSystem.actorOf(Props[WordCountActor], "anotherWordCounter")

  // part 4 - communicate!
  wordCounter ! "I am learning Akka and it's pretty damn cool!" // tell
  anotherWordCounter ! "A different message"
  // asynchronous!

  object Person {
    def props(name: String) = Props(new Person(name))
  }

  class Person(name: String) extends Actor {
    override def receive = {
      case "hi" => println(s"Hi, my name is $name")
      case _ =>
    }
  }

  val person = actorSystem.actorOf(Person.props("Bob"))
  person ! "hi"
}
