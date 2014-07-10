package project
import com.ning.http.client._

case class StatusCode(result: String)

trait TwitterHttpClient {
  def getNumberOfTweets: Int
}

trait AsyncTwitterHttpClient extends TwitterHttpClient {
  def http = new AsyncHttpClient()

  def getNumberOfTweets = 3

}

trait TweetStreamRegister {
  def client: TwitterHttpClient
}

trait AsyncTweetStreamRegister extends TweetStreamRegister {
  def client = new AsyncTwitterHttpClient {}
}

trait TwitterCrawler extends AsyncTwitterHttpClient {
  self: TwitterHttpClient =>
}

object Driver {
  def main(args: Array[String]) = {
    println("working")
  }
}
