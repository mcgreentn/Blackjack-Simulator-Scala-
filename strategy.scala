package blackjack

//abstract base class for representing a player (or perhaps dealer)
//strategy
class Strategy ()
{

	def action() : Int = 
	{
		return 0
		//action player takes next: Hit, Stand, Split a Pair
		//Double Down, Buy Insurance
	}

	def bet(amount: Int)
	{
		//the amount the player bets
	}
}