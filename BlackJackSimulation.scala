package blackjack
import scala.util.control.Breaks._

object BlackJackSimulation extends App{

	var s = new Shoe(5, 0.25)
	var d = new Dealer(s)
	var p1 = new Player(s)
	var p2 = new Player(s)

	for(i <- 0 to 5000)
	{		
		p1.reset()
		p2.reset()
		d.reset()
						
		p1.execute()
		p2.execute()
		d.execute()

		//Check for p1
		if(p1.didLose() == 1)
		{
			p1.playerLose()
		}
		else if(d.didLose() == 1)
		{
			p1.playerWin()
		}
		else
		{
			if(p1.hand.value() >= d.hand.value())
			{	
				p1.playerWin()
			}
			else
			{
				p1.playerLose()
			}
		}

		//Check for p2
		if(p2.didLose() == 1)
		{
			p2.playerLose()
		}
		else if(d.didLose() == 1)
		{
			p2.playerWin()
		}
		else
		{
			if(p2.hand.value() >= d.hand.value())
			{
				p2.playerWin()
			}
			else
			{
				p2.playerLose()
			}
		}


	}

	println("Player 1: " + p1.cashMoney())
	println("Player 2: " + p2.cashMoney())	
	// List players = new List(6)

}