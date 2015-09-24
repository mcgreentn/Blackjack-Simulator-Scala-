package blackjack

class Dealer(val s: Shoe){
	var hand = new Hand()
	var isLose = 0
	var isStay = 0	


	hand.addCard(s.dealCard())
	hand.addCard(s.dealCard())
	//myHand.addCard(shoe.dealCard())
	def reset()
	{
		hand = new Hand()

		hand.addCard(s.dealCard())
		hand.addCard(s.dealCard())
		Dealer.setTop(hand.get(0))
		//println("top: " + Dealer.getUp())
		isLose = 0
		isStay = 0
	}

	def execute() = {
		while(isLose == 0 && isStay == 0)
		{
			if(hand.value() < 17)
			{
				hit()
			}
			else
			{
				stay()
			}
		}
	}
	def stay() = {
		isStay = 1
	}
	def hit() = {
		hand.addCard(s.dealCard())
		if(hand.value() > 21)
		{
			isLose = 1
		}
	}
	def didLose(): Int =
	{
		return isLose
	}

	def getValue(): Int =
	{
		return hand.value()
	}
}

object Dealer
{
	var topCard = 0

	def setTop(card: Int)
	{
		topCard = card
	}
	def getUp(): Int =
	{
		return topCard
	}	
}
