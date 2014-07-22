package project
import org.specs2.specification.Scope
import org.specs2.mutable.Specification
import twitter4j.TwitterObjectFactory

object FakeTwitterStream {
  val tweet1 = TwitterObjectFactory.createStatus("""{text="This is a test tweet 😂 💎 🐅 #test #yolo"}""")
  val tweet2 = TwitterObjectFactory.createStatus("""{text="This is an uninteresting tweet with nothing in it."}""")
}

object TwitterStreamSpec extends Specification with TwitterStreamHandling {
  import FakeTwitterStream._

  "Parsing for emojis" should {
    "find them when they are there" in {
      emojis(tweet1) === List("😂", "💎", "🐅")
    }
    "return an empty list when they are not there " in {
      emojis(tweet2) === List()
    }
  }

  "Parsing for hashtags" should {
    "find them when they are there" in {
      hashtags(tweet1) === List("test", "yolo")
    }
    "return an empty list when they are not there" in {
      hashtags(tweet2) === List()
    }
  }
  // cannot figure out how to test for pictures / domains
}
