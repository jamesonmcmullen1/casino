import java.util.Scanner;
public class craps{
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
        System.out.println("Welcome to The Game of Craps!!\n\nThe rules of craps go as follows:\nTwo die are rolled.\nIf the sum of the die is 7 or 11 you are an instant winner.\nIf the sum of the die is 2 or 10 you are an instant loser.\nIf the sum of the die is any other number, that number is used a set point.\nIf you do not win or lose on the first roll, the die are rolled again and again until the sum of the die is equal to 7 or the set point.\nYou win if the sum is equal to the set point, you lose if the sum is equal to 7.\n\nIf you win, you win double what you bet, so if you bet $1 you win back $2 and your total is +$1.\nIf you lose you get no money back, so if you bet $1 you win $0 and your total is -$1.\n");

        // //start balance
        double startVal = bank;

        //loop to continue the game as long as user wants
        int play = 1;
        while(play == 1){
            
            if(play == 1 && bank>0){
                //placed bet
                System.out.println("\nWhat is your bet? Enter a double, no dollar sign: ");
                double bet = reader.nextDouble();
                if(bet>bank){
                    System.out.println("\nOh no! You cannot bet with more money than you own!!! You have been kicked from the game and sent back to the casino. :'( \nYou should consider calling 1-800-GAMBLER");
                }

                //balance after bet
                bank-=bet;
                System.out.println("\nYour current balance is $"+bank+". ");

                //first roll
                int roll1 = roll();
                System.out.println("\nThe roll is "+roll1+".");
                
                //use if statement to see if the roll is a win, loss, or the roll is the set point
                int setPoint;
                if(roll1==7 || roll1==11){
                    bank+=(bet*2);
                    System.out.println("You win!! You win $"+(2*bet)+". Your new balance is $"+bank+".");
                }
                else if(roll1==2 || roll1==10){
                    System.out.println("You lose!! You win $0. Your new balance is $"+bank+".");
                }
                else{
                    System.out.println("The roll "+roll1+" is now the set point.\n");
                    bank=setPoint(roll1, bank, bet);
                }
            }
            else if(play != 1 || bank==0){
                play = 0;
            }
            if(bank==0){
                System.out.println("Your have run out of money :(, you can no longer play. Incases of excessive loss of money or addictiveness to gambling, please call 1-800-GAMBLER. ");
                break;
            }

            System.out.println("Would you like to play? Enter 1 to continue playing Craps!!");
            play = reader.nextInt();

        }

        //goodbye return bank
        System.out.println("\nWe hope you had fun playing Craps!! Your earned a total of $"+(bank-startVal)+". Your ending balance is $"+bank+".\n");
        return bank;
    }
    public static int roll(){
        int roll1 = (int)(Math.random()*6+1);
        int roll2 = (int)(Math.random()*6+1);
        int totalRoll = roll1+roll2;
        return totalRoll;
    }
    public static double setPoint(int setPoint, double bank, double bet){
        //use while loop to keep rolling until the set point is hit or a 7 is rolled
        int roll = (int)(Math.random()*12+1);
        while(setPoint!=roll && roll!=7){
            System.out.println("The roll is "+roll+".\n");
            roll = (int)(Math.random()*12+1);
        }
        System.out.println("The roll is "+roll+".\n");
        //print outcomes
        if(roll==7){
            System.out.println("You lose!! You win $0. Your new balance is $"+bank+".\n");
        }
        else if(roll==setPoint){
            bank+=(bet*2);
            System.out.println("You win!! You win $"+(2*bet)+". Your new balance is $"+bank+".\n");
        }
        return bank;
    }
}
