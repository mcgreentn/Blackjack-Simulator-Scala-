package blackjack

//represents a generic blackjack player
class Player (val s: Shoe)
{

	//does everything a player needs to do in a blackjack game
	var shoe = s
	var hand = new Hand()

	var money = 0
	var bet = 1

	var isLose = 0
	var isStay = 0

	hand.addCard(s.dealCard())
	hand.addCard(s.dealCard())
//	println("HAND: " + (hand.get(0) + 1) + " " + (hand.get(1) + 1))
	def reset()
	{
		hand = new Hand()

		hand.addCard(s.dealCard())
		hand.addCard(s.dealCard())

		isLose = 0
		isStay = 0

		bet = 1

	}
	def execute()
	{
		while(true)
		{
			var strat = new PlayerStrat(hand)
			var t = strat.action()
			//println("action: " + t)
			
			if(t == 1)
			{
				hit()
			}
			else if(t == 2)
			{
				stand()
				return
			}
			else if(t == 3)
			{
				splitAPair()
			}
			else if(t == 4)
			{
				doubleDown()
				return
			}
			else if(t == 5)
			{
				buyInsurance()
			}
			else
			{
				println("Error out")
				return
				//why are we here, there is no type 6
			}
		}
	}	

	def didIlose()
	{
		if(hand.value() > 21)
		{
			//fold
			isLose = 1
		}
	}
	//adds card to player hand
	def hit()
	{
		hand.addCard(shoe.dealCard())
		didIlose()
	}

	//flips the isStay flag
	def stand()
	{
		isStay = 1
	}

	def splitAPair()
	{

	}

	def doubleDown()
	{	
		bet = bet * 2
		hand.addCard(s.dealCard())
		didIlose()
	}

	def buyInsurance()
	{

	}

	def playerLose()
	{
		money -= bet
	}

	def playerWin()
	{
		money += bet
	}
	def didLose(): Int =
	{
		if(isLose == 1)
		{
			return 1
		}
		else
		{
			return 0
		}
	}

	def cashMoney(): Int =
	{
		return money
	}
}
