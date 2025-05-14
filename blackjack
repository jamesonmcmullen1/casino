import java.util.Scanner;
public class blackjack{
    public static void main(String [] args){
        //scanner
        Scanner reader = new Scanner(System.in);

        //bank
        System.out.println("Please enter how much money you are starting with today: ");
        double bank = reader.nextDouble();

        //start game
        start(bank);
    }
    
    public static double start(double bank){
        //scanner
        Scanner reader = new Scanner(System.in);
        
        //rules
        System.out.println("Welcome to Blackjack!!\n\nThe rules of Blackjack go as follows:\nThe dealer deals everyone at the table two cards, including themselves.\nThe value of the two cards added together is each player's score.\nA player can decide to hit, which means add another card to their score, or stand, which means they keep their score.\nIf your card total exceeds 21 you bust and lose your bet.\nIf your total is 21 you hit Blackjack.\nAfter everyone's turn is over, it is the dealer's turn.\nThe dealer has to hit until they have a total of 17, they hit Blackjack, or they bust.\nIf the dealer's hand is more than a players, the player loses their bet.\nIf the dealer busts and the player did not or if the player's point total is more than the dealer's, without the player hitting blackjack, the player wins and their winnings are 1:1.\nIf the player and the dealer have the same total and neither bust, the result is a push and the player gets their bet back.\nIf the player hits Blackjack and the dealer does not, the player wins and their winnings are 3:2.\n\nCard vlaues are:\n2-10 are worth their face value.\nFace cards are worth 10.\nAces' values are 11 unless this would cause the player to bust, in which case they are worth 1.\n");

        //start balance
        double startVal = bank;

        //cards
        String[] cards = {"2 of Spades","3 of Spades","4 of Spades","5 of Spades","6 of Spades","7 of Spades","8 of Spades","9 of Spades","10 of Spades","Jack of Spades","Queen of Spades","King of Spades","Ace of Spades","2 of Clubs","3 of Clubs","4 of Clubs","5 of Clubs","6 of Clubs","7 of Clubs","8 of Clubs","9 of Clubs","10 of Clubs","Jack of Clubs","Queen of Clubs","King of Clubs","Ace of Clubs","2 of Diamonds","3 of Diamonds","4 of Diamonds","5 of Diamonds","6 of Diamonds","7 of Diamonds","8 of Diamonds","9 of Diamonds","10 of Diamonds","Jack of Diamonds","Queen of Diamonds","King of Diamonds","Ace of Diamonds","2 of Hearts","3 of Hearts","4 of Hearts","5 of Hearts","6 of Hearts","7 of Hearts","8 of Hearts","9 of Hearts","10 of Hearts","Jack of Hearts","Queen of Hearts","King of Hearts","Ace of Hearts"};

        //card values
        int[] cardVals = {2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11};

        //card tracking
        int [] cardTracker = new int[52];
        for(int i = 0; i<cardVals.length; i++){
            cardTracker[i]=1;
        }

        //playing until player leaves table
        int play = 1;
        while(play==1){
            //if they say yes and have money let them play
            if(play==1 && bank>0){
                //place bet
                System.out.println("What would you like to bet? Enter double no dollar sign: ");
                double bet = reader.nextDouble();
                if(bet>bank){
                    System.out.println("\nOh no! You cannot bet with more money than you own!!! You have been kicked from the game and sent back to the casino. :'( \nYou should consider calling 1-800-GAMBLER");
                    return bank;
                }

                //balance after bet
                bank-=bet;
                System.out.println("\nYour current balance is $"+bank+".\n");

                //player hand
                //draw two cards and start point total
                int playerCard1 = dealCard(cardTracker);
                int playerCard2 = dealCard(cardTracker);
                int playerCardTot = cardVals[playerCard1]+cardVals[playerCard2];

                //blackjack hit means no decision
                if(playerCardTot==21){
                    System.out.println("You hit BLACKJACK!!!");
                }

                //if 2 aces are drawn make one of the aces worth a 1
                if(playerCardTot==22 && cardVals[playerCard1]==11){
                    playerCardTot-=10;
                    cardVals[playerCard1] = 1;
                    System.out.println("AH!! two Aces?? How lucky!! ");
                }
                if(playerCardTot==22 && cardVals[playerCard2]==11){
                    playerCardTot-=10;
                    cardVals[playerCard2] = 1;
                    System.out.println("AH!! two Aces?? How lucky!! ");
                }

                //tell user cards drawn and point total
                System.out.println("You were dealt "+cards[playerCard1]+" with a value of "+cardVals[playerCard1]+" and "+cards[playerCard2]+" wtih a value of "+cardVals[playerCard2]+".\nYour card point total is "+playerCardTot+".");

                //dealer hand
                
                //draw two cards and start point total for dealer
                int dealerCard1 = dealCard(cardTracker);
                int dealerCard2 = dealCard(cardTracker);
                int dealerCardTot = cardVals[dealerCard1]+cardVals[dealerCard2];

                //if 2 aces are drawn make one of the aces worth a 1
                if(dealerCardTot==22 && cardVals[dealerCard1]==11){
                    dealerCardTot-=10;
                    cardVals[dealerCard1] = 1;
                    System.out.println("\nAH!! two Aces?? How lucky!! ");
                }
                if(dealerCardTot==22 && cardVals[dealerCard2]==11){
                    dealerCardTot-=10;
                    cardVals[dealerCard2] = 1;
                    System.out.println("\nAH!! two Aces?? How lucky!! ");
                }

                //tell player cards drawn and point total of dealer
                System.out.println("\nThe dealer was dealt "+cards[dealerCard1]+" with a value of "+cardVals[dealerCard1]+". The dealer's second card is unknown.\n");

                //player decisions
                playerCardTot = playerDecisions(cards, cardVals, cardTracker, playerCard1, playerCard2, playerCardTot);
                System.out.println("Your final card point total is "+playerCardTot+".\n");

                //dealer decisions
                dealerCardTot = dealerDecisions(cards, cardVals, cardTracker, dealerCard1, dealerCard2, dealerCardTot);
                System.out.println("The dealer's final card point total is "+dealerCardTot+".\n");


                //outcomes
                if(dealerCardTot==playerCardTot && playerCardTot<22){
                    bank+=bet;
                    System.out.println("Push, your bet, $"+bet+", is returned. You have $"+bank+".\n");
                }
                else if(dealerCardTot<playerCardTot && playerCardTot==21){
                    bank+=(bet*5/2);
                    System.out.println("You beat the dealer, you win!!! You win $"+(bet*5/2)+". You have $"+bank+".\n");
                }
                else if((dealerCardTot<playerCardTot && playerCardTot<21) || (dealerCardTot>21 && playerCardTot<=21) ){
                    bank+=(bet*2);
                    System.out.println("You beat the dealer, you win!!! You win $"+(bet*2)+". You have $"+bank+".\n");
                }
                else{
                    System.out.println("The dealer beat you, you lose! You won $0. You have $"+bank+".\n");
                }
            }
            else if(bank==0){   //kick from casino if youre out of money
                System.out.println("Your have run out of money :(, you can no longer play. Incases of excessive loss of money or addictiveness to gambling, please call 1-800-GAMBLER. ");
                break;
            }

            //ask if they would like to play
            System.out.println("Would you like to play? Enter 1 to continue playing Blackjack!!");
            play = reader.nextInt();
        } 

        //goodbye return bank
        System.out.println("\nWe hope you had fun playing Blackjack!! Your earned a total of $"+(bank-startVal)+". Your ending balance is $"+bank+".\n");
        return bank;

    }

    public static int playerDecisions(String[] cards, int[] cardVals, int[] cardTracker, int playerCard1, int playerCard2, int playerCardTot){
        //initiate scanner
        Scanner reader = new Scanner(System.in);

        //blackjack hit means no decision
        if(playerCardTot==21){
            return playerCardTot;
        }

        //ask if they would like to hit or stand
        System.out.println("Would you like to hit or stand? Enter 1 for hit and 0 for stand: ");
        int call = reader.nextInt();

        //hit
        //use loop to keep drawing a new card if the user keeps hitting unless they bust
        while(call==1){
            playerCardTot = hit(playerCardTot, playerCard1, playerCard2, cardTracker, cardVals, cards);
            if(playerCardTot>21){
                System.out.println("Your total is "+playerCardTot+". You busted");
                call = 0;
            }
            else if(playerCardTot==21){     //blackjack hit means no decision
                System.out.println("You hit BLACKJACK!!!");
                return playerCardTot;
            }
            else{
                System.out.println("Your total is "+playerCardTot+".\nWould you like to hit or stand? Enter 1 for hit and 0 for stand: ");
                call = reader.nextInt();
            }
        }

        //on eventual stand return the card total
        return playerCardTot;
    }

    public static int dealCard(int cardTracker[]){
        //if all the cards have been dealt reactivate all cards
        int newDeck = 0;
        for(int i = 0; i<cardTracker.length; i++){
            newDeck+=cardTracker[i];
        }
        if(newDeck==0){
            for(int c = 0; c<cardTracker.length; c++){
                cardTracker[c]=1;
            }
        }

        //pick random card from 0-51 which are in an array
        int card = (int)(Math.random()*52);

        //use card tracker to see if the card was drawn and if so redraw card
        int newCard = 1;
        if(cardTracker[card]==0){
            newCard = 0;
        }
        while(newCard==0){
            card = (int)(Math.random()*52);
            if(cardTracker[card]!=0){
                newCard = 1;
            }
        }
        cardTracker[card]=0;
        return card;
    }

    public static int hit(int cardTot, int card1, int card2, int[] cardTracker, int[] cardVals, String[] cards){
        //on hit deal another card and add to the total
        int card3 = dealCard(cardTracker);
        cardTot+=cardVals[card3];
        System.out.println("\n"+cards[card3]+" is dealt with a value of "+cardVals[card3]+".\n");

        //make an ace 1 instead of an 11 if bust on hit
        if(cardTot>21 && (cardVals[card1]==11)){
            cardTot-=10; 
            cardVals[card1]=1;
            System.out.println("Your first card's ace value has been changed to 1.\n");
        }
        if(cardTot>21 && (cardVals[card2]==11)){
            cardTot-=10; 
            cardVals[card2]=1;
            System.out.println("Your second card's ace value has been changed to 1.\n");
        }
        if(cardTot>21 && (cardVals[card3]==11)){
            cardTot-=10; 
            cardVals[card3]=1;
            System.out.println("Your third card's ace value has been changed to 1.\n");
        }

        //return the point total
        return cardTot;
    }

    public static int dealerDecisions(String[] cards, int[] cardVals, int[] cardTracker, int dealerCard1, int dealerCard2, int dealerCardTot){
        System.out.println("The dealer's second card is "+cards[dealerCard2]+" with a value of "+cardVals[dealerCard2]+".\nThe dealer's point total is "+dealerCardTot+".\n");

        //blackjack hit means no decision
        if(dealerCardTot==21){
            System.out.println("The dealer hit BLACKJACK!!!");
            return dealerCardTot;
        }

        //if card total of dealer is less than 17 they have to hit
        int hit = 0;
        if(dealerCardTot<17){
            hit = 1;
        }
        while(hit == 1){
            System.out.println("Dealer hits. ");
            dealerCardTot = hit(dealerCardTot, dealerCard1, dealerCard2, cardTracker, cardVals, cards);
            if(dealerCardTot<17){
                hit = 1;
            }
            else{
                hit = 0;
            }
            //blackjack hit means no decision
            if(dealerCardTot==21){
                System.out.println("The dealer hit BLACKJACK!!!");
                return dealerCardTot;
            }
            System.out.println("The dealer's point total is "+dealerCardTot+".\n");
        }

        //dealer eventually stands or busts
        if(dealerCardTot<22){
            System.out.println("Dealer stands. \n");
        }
        else{
            System.out.println("Dealer busts. \n");
        }
        
        return dealerCardTot;
    }
}
