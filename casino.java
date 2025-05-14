import java.util.Scanner;
public class casino{
    public static void main(String [] args){
        //scanner
        Scanner reader = new Scanner(System.in);

        //welcome && games avaliable
        System.out.println("Hello!!! Welcome to Jamo Club Casino!! We have exclusive casino game's for you to play.\nOur current roster of games that you can play is:\n1:\tCraps\n2:\tBlackjack\n3:\tRoulette\n");

        int play = 1;

        //bank
        System.out.println("Please enter how much money you are starting with today: ");
        double bank = reader.nextDouble();
        double startVal = bank;

        //loop
        while(bank>0 && play==1){
            System.out.println("\nEnter what game you would like to enter into:\n1:\tCraps\n2:\tBlackjack\n3:\tRoulette\n");
            int game = reader.nextInt();
            if(game == 1){
                bank = craps.start(bank);
            }
            else if(game == 2){
                bank = blackjack.start(bank);
            }
            else if(game == 3){
                bank = roulette.start(bank);
            }
            System.out.println("\nWelcome Back to the lobby of Jamo Club Casino!\n\nYou currently have $"+bank+".\n\nWould you like to continue gambling at our casino today? Enter 1 to continue: ");
            play = reader.nextInt();
        }
        System.out.println("\nThank you for gambling at Jamo Club Casino!! We hope you enjoyed your time. You earned a total of $"+(bank-startVal)+". Your ending balance is $"+bank+".\nPlease come back again!!!");
    }
}
