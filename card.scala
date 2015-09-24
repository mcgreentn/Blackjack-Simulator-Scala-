package blackjack;

object Card {
  private val rankNames = Array("A", "2", "3", "4", "5", "6", "7", "8", "9", 
                                "10", "J", "Q", "K")  
  private val suitNames = Array("C", "H", "S", "D")
  
  val cardFaces = Array(
    "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC",
    "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH",
    "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS",
    "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD")

  val CLUBS = 0;
  val HEARTS = 1;
  val SPADES = 2;
  val DIAMONDS = 3;
  
  val ACE = 0;
  val TWO = 1;
  val THREE = 2;
  val FOUR = 3;
  val FIVE = 4;
  val SIX = 5;
  val SEVEN = 6;
  val EIGHT = 7;
  val NINE = 8;
  val TEN = 9;
  val JACK = 10;
  val QUEEN = 11;
  val KING = 12;
  
  def rank(card:Int) = card % 13
  def suit(card:Int) = card / 13
  
}