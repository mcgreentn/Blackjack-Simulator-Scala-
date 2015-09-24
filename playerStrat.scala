package blackjack

//abstract base class for representing a player (or perhaps dealer)
//strategy
import scala.io.Source

class PlayerStrat(val h: Hand) extends Strategy 
{

	var hardread = Source.fromFile("strat.txt").getLines.toArray
	var softread = Source.fromFile("softStrat.txt").getLines.toArray
	var pairread = Source.fromFile("pairStrat.txt").getLines.toArray

	var hardStrat = Array.ofDim[Char](14, 10)
	var softStrat = Array.ofDim[Char](20, 20)
	var pairStrat = Array.ofDim[Char](20, 20)
	var dealerUp = Dealer.getUp()
	var hand = h


	for(i <- 0 to hardread.size - 1)
	{
		var split = hardread(i).split("\\|")
		var j = 0
		for(j <- 2 to split.size - 1)
		{
			hardStrat(i)(j-2) = split(j).charAt(0)
			//print(hardStrat(i)(j-2))
		}
		//hs(i) = split
		//print("\n")
	}

	for(i <- 0 to softread.size - 1)
	{
		var split = softread(i).split("\\|")
		var j = 0
		for(j <- 3 to split.size - 1)
		{
			softStrat(i)(j) = split(j).charAt(0)
		//	print(softStrat(i)(j))
		}
		//hs(i) = split
		//print("\n")
	}

	for(i <- 0 to pairread.size - 1)
	{
		var split = pairread(i).split("\\|")
		var j = 0
		for(j <- 1 to split.size - 1)
		{
			pairStrat(i)(j) = split(j).charAt(0)
		//	print(pairStrat(i)(j))
		}
		//hs(i) = split
		//print("\n")
	}		

	override def action() : Int = 
	{
		// if(hand.hardSoft() == "HARD")
		// {
			//use hard table
			var index = h.value() - 5
			var dealerindex = dealerUp

			// println("index: " + index)
			// println("dIndex: " + dealerindex)

			// if(hand.value() < 17)
			// {
			// 	return 1
			// }
			// else
			// {
			// 	return 2
			// }

		//	dealerUp = dealerUp - 2
			//right now since we dont handle pairs, we simply do the 
			//same action for 2,2 as we do 2,3
			if(index < 0)
			{
				index = 0
			}
			else if(index > 13)
			{
				index = 13
			}
			if(dealerindex > 9)
				{
					dealerindex = 9
				}
				
			var action = hardStrat(index)(dealerindex)
			if(action == 'H')
			{
				return 1
			}
			else if(action == 'S')
			{
				return 2
			}
			else
			{
				return 1
			}
					//}
		// else
		// {

		//  	//use soft table

		// }
		return 0
		//action player takes next: Hit, Stand, Split a Pair
		//Double Down, Buy Insurance
	}

	override def bet(amount: Int)
	{
		//the amount the player bets
	}
}