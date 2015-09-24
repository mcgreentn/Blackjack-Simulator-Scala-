package blackjack

class Shoe(val ndecks: Int, val reshufflePercent: Double) {
	
	//The total number of cards in the deck
	private var numOfCards = ndecks * 52

	//The main deck of cards
	private var mainDeck = new Array[Int](numOfCards)
	
	//When we reach this percent, we will reshuffle the deck
	private val shufflePercent = reshufflePercent

	//used to initialize the deck
	var nCard = 0

	//keeps track of the current card in the deck we are dealing out
	private var currentCards = 0

	for(card <- mainDeck)
	{
		card = nCard
		nCard++;
		if(nCard == 13)
		{
			nCard = 0
		}
	}
	//shuffles the shoe
	def shuffle()
	{	

		var randomizedSpot = 0
		for(i <- 0 to numOfCards - 1)
		{
			randomizedSpot = Random.nextInt(numOfCards - 1)
			var tempCard = mainDeck(i)
			mainDeck(i) = mainDeck(randomizedSpot)
			mainDeck(randomizedSpot) = tempCard
		}	
		
	}
		
	//deals one card
	def dealCard()
	{
		var deltCard = mainDeck(currentCards)
		currentCards++

		var trigger = (numOfCards - currentCards)/numOfCards
		if(trigger < shufflePercent)
		{
			shuffle()
			currentCards = 0
		}
		return deltCard
	}
}