package blackjack
class Hand ()
{
	//represents the cards in the hand
	var cards = new Array[Int](22)
	var index = 0

	//adds a card to the hand
	for(i <- 0 to cards.size - 1)
	{
		cards(i) = -1
	}
	def addCard(newcard: Int)
	{
		if(index < cards.size)
		{
			cards(index) = newcard
			index += 1
		}	
	}
	
	//returns the current "value" of the hand
	def value() : Int = 
	{
		var value = 0
		var totalValue = 0
		var isSoft = hardSoft()
		//loop through cards in hand
		for(card <- cards)
		{
			//get card rank
			value = Card.rank(card) + 1
			//if card is 10 or higher (10, J, Q, K), add 10
			if(value > 10)
			{
				totalValue += 10
			}
			//if card is an Ace and isSoft, add 11
			else if (value == 1 && isSoft =="SOFT")
			{
				totalValue += 11
			}
			//otherwise just add the card value
			else if(value > 1)
			{
				totalValue += value
			}
		}
		//println("total value: " + totalValue)
		return totalValue
	}

	//returns whether the hand is hard or soft
	def hardSoft() : String =
	{
		//this represents the sum before we add aces in
		var totalBefore = 0

		for(card <- cards)
		{
			var value = Card.rank(card) + 1
			//if card is not an ace, add to totalBefore
			if(value != 1)
			{
				totalBefore += value
			}
		}
		if(totalBefore < 11)
		{
			return "SOFT"
		}
		else
		{
			return "HARD"
		}	
	}
	def get(i: Int): Int =
	{
		return cards(i)
	}


}