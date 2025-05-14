import java.util.Scanner;
public class roulette{
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

        //rules & bets
        System.out.println("Welcome to Roulette!!!\n\nThe rules of roulette go as follows:\nA wheel with numbers 1-36, 0, and 00 is spun.\nA ball is placed in the spinning wheel.\nOnce the wheel stops spinning and the ball comes to a stop it has landed on a random number.\nEach number has a certain color\n\tred or black for numbers 1-36 and green for 0 and 00.\n\nPlayers can bet on a number of outcomes, all with different payouts.\nThis is what the betting table looks like:");

        //what table looks like
        System.out.println("   0\t   00\n1\t2\t3\tRow\n4\t5\t6\n7\t8\t9\n10\t11\t12\n13\t14\t15\n16\t17\t18\n19\t20\t21\n22\t23\t24\n25\t26\t27\n28\t29\t30\n31\t32\t33\n34\t35\t36\nColumn\n");

        //start balance
        double startVal = bank;

        //bet type
        int betType = 0;

        //playing until player leaves table
        int firstPlay = 1;
        int play = 1;
        while(play==1 && bank>0){
            //on first play they have to enter bet type
            //on not first play they can either change or keep their previous bet
            int changeBet;
            if(firstPlay==0){
                System.out.println("Would you like to keep your bet the same or change your bet? Enter 1 to change your bet: ");
                changeBet = reader.nextInt();
            }
            else{
                changeBet = 1;
            }

            //eliminate first play
            firstPlay = 0;

            //changing or intitating bets
            if(changeBet == 1){
                //bet types
                System.out.println("Bets include:\n1:\tBetting on a single number, \"straight up,\" with a 35:1 payout.\n2:\tBetting on two numbers that are touching, \"split,\" with a 17:1 payout.\n3:\tBetting on three numbers in a row, \"street,\" pays 11:1.\n4:\tBetting on four numbers that touch, \"corner bet,\" pays 8:1.\n5:\tBetting on the top 5 numbers, 0, 00, 1, 2, and 3, pays 6:1.\n6:\tBetting on two rows, 6 numbers, \"line,\" pays 5:1.\n7:\tBetting on the first (1-12), second (13-24), or third (25-36) dozen, pays 2:1.\n8:\tBetting on the first, second, or third column of numbers, pays 2:1.\n9:\tBetting on the first (1-18) or second (19-36) set of numbers, pays 1:1.\n10:\tBetting on red or black, pays 1:1.\n11:\tBetting on odd or even, pays 1:1.\n\nWhat type of bet would you like to play? Enter bet type number: ");
                betType = reader.nextInt();
            }

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

            //play
            switch(betType){
                case 1:
                    bank = betOne(bank, bet);
                    break;
                case 2:
                    bank = betTwo(bank, bet);    
                    break;
                case 3:
                    bank = betThree(bank, bet);
                    break;
                case 4:
                    bank = betFour(bank, bet);
                    break;
                case 5:
                    bank = betFive(bank, bet);
                    break;
                case 6:
                    bank = betSix(bank, bet);
                    break;
                case 7:
                    bank = betSeven(bank, bet);
                    break;
                case 8: 
                    bank = betEight(bank, bet);
                    break;
                case 9:
                    bank = betNine(bank, bet);
                    break;
                case 10: 
                    bank = betTen(bank, bet);
                    break;
                case 11: 
                    bank = betEleven(bank, bet);
                    break;
                default: System.out.println("Looks like your bet type is not valid. You will need to try again.\n");
            }

            //ask if they would like to continue playing
            System.out.println("Would you like to play again? Enter 1 to continue playing Roulette!!");
            play = reader.nextInt();
        }

        //goodbye return bank
        System.out.println("\nWe hope you had fun playing Roulette!! Your earned a total of $"+(bank-startVal)+". Your ending balance is $"+bank+".\n");
        return bank;
    }

    public static int spin(){
        int spin = (int)(Math.random()*38);
        return spin;
    }

    public static double betOne(double bank, double bet){
        //scanner
        Scanner reader = new Scanner(System.in);

        //initiate num
        int num = -1;

        //use while loop to make sure the enter valid number 
        int again = 1;
        while(again == 1){
            //number
            System.out.println("Enter which number you would like to bet on (1-36, 0, 00): **For 00 enter 37** ");
            num = reader.nextInt();

            //make sure they entered right number 
            if(num<0 || num>37){
                System.out.println("Invalid number. SMH! Try again.");
                again = 1;
            }
            else{
                again = 0;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //result
        if(spin == num){
            bank+=(bet*36);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*36)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }

    public static double betTwo(double bank, double bet){
        //scanner 
        Scanner reader = new Scanner(System.in);

        //initiate picks
        int num01 = -1;
        int num02 = -1;
        int num1 = -1;
        int num2 = -1;

        //while loop with if statement with every single two numbers that they could bet on and make them reenter numbers if they weren't touching 
        int again = 1;
        while(again == 1){
            //numbers 
            System.out.println("What two touching numbers would you like to bet on? **Enter 37 for 00**: ");
            num01 = reader.nextInt();
            num02 = reader.nextInt();

            //make lower number num1
            num1 = num01;
            num2 = num02;
            if(Math.min(num1,num2) == num2){
                num1 = num02;
                num2 = num01;
            }

            if((num1 == 0 && num2 == 37) || (num1 == 0 && num2 == 1) || (num1 == 0 && num2 == 2) || (num1 == 2 && num2 == 37) || (num1 == 3 && num2 == 37) || (num1 == 1 && num2 == 2) || (num1 == 1 && num2 == 4) || (num1 == 2 && num2 == 3) || (num1 == 2 && num2 == 5) || (num1 == 3 && num2 == 6) || (num1 == 4 && num2 == 5) || (num1 == 4 && num2 == 7) || (num1 == 5 && num2 == 6) || (num1 == 5 && num2 == 8) || (num1 == 6 && num2 == 9) || (num1 == 7 && num2 == 8) || (num1 == 7 && num2 == 10) || (num1 == 8 && num2 == 11) || (num1 == 8 && num2 == 9) || (num1 == 9 && num2 == 12) || (num1 == 10 && num2 == 11) || (num1 == 10 && num2 == 13) || (num1 == 11 && num2 == 14) || (num1 == 11 && num2 == 12) || (num1 == 12 && num2 == 15) || (num1 == 13 && num2 == 14) || (num1 == 13 && num2 == 16) || (num1 == 14 && num2 == 17) || (num1 == 14 && num2 == 15) || (num1 == 15 && num2 == 18) || (num1 == 16 && num2 == 17) || (num1 == 16 && num2 == 19) || (num1 == 17 && num2 == 20) || (num1 == 17 && num2 == 18) || (num1 == 18 && num2 == 21) || (num1 == 19 && num2 == 20) || (num1 == 19 && num2 == 22) || (num1 == 20 && num2 == 23) || (num1 == 20 && num2 == 21) || (num1 == 21 && num2 == 24) || (num1 == 22 && num2 == 23) || (num1 == 22 && num2 == 25) || (num1 == 23 && num2 == 26) || (num1 == 23 && num2 == 24) || (num1 == 24 && num2 == 27) || (num1 == 25 && num2 == 28) || (num1 == 25 && num2 == 26) || (num1 == 26 && num2 == 29) || (num1 == 26 && num2 == 27) || (num1 == 27 && num2 == 30) || (num1 == 31 && num2 == 32) || (num1 == 31 && num2 == 34) || (num1 == 32 && num2 == 33) || (num1 == 32 && num2 == 35) || (num1 == 33 && num2 == 36) || (num1 == 34 && num2 == 35) || (num1 == 35 && num2 == 36)){
                again = 0;
            }
            else{
                System.out.println("Those are invaldi inputs, try again. ");
                again = 1;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //result
        if((spin == num1) || (spin == num2)){
            bank+=(bet*18);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*18)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }

    public static double betThree(double bank, double bet){
        //scanner
        Scanner reader = new Scanner(System.in);

        //initiate picks 
        int row = -1;

        //while loop to keep get the right numbers 
        int again = 1;
        while(again == 1){
            //take row
            System.out.println("Which row would you like to bet on? Row 1 starts with the number 1 and row 12 starts with 34: ");
            row = reader.nextInt();

            //re enter number if invalid input
            if(row<1 || row>12){
                System.out.println("That's not a valid row. Try again. ");
                again = 1;
            }
            else{
                again = 0;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //what row the number lands in 
        int spinRow = (int)(Math.ceil(spin/3.0));
        
        //print row
        System.out.println("(row "+spinRow+")\n");

        //result
        if(spinRow == row){
            bank+=(12*bet);
            System.out.println("You won! You won $"+(bet*12)+". Your new balance is $"+bank);
        }
        else{
            System.out.println("You lost! :( You won $0. Your new balance is $"+bank);
        }

        //return bank
        return bank;
    }

    public static double betFour(double bank, double bet){
        //scanner 
        Scanner reader = new Scanner(System.in);

        //initiate picks
        int num = -1;

        //while loop with if statement with every single two numbers that they could bet on and make them reenter numbers if they weren't touching 
        int again = 1;
        while(again == 1){
            //table 
            System.out.println("Here is what the table looks like:\n   0\t   00\n1\t2\t3\tRow\n4\t5\t6\n7\t8\t9\n10\t11\t12\n13\t14\t15\n16\t17\t18\n19\t20\t21\n22\t23\t24\n25\t26\t27\n28\t29\t30\n31\t32\t33\n34\t35\t36\nColumn\n");
            //numbers 
            System.out.println("What four touching numbers would you like to bet on? **Enter the number in the top left corner of your four numbers**: ");
            num = reader.nextInt();

            //if statement verifying validity of number
            if((num%3 != 0) && (num > -1) && (num < 30)){
                again = 0;
            }
            else{
                System.out.println("Those are invaldi inputs, try again. ");
                again = 1;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //result
        if((spin == num) || (spin == (num+1)) || (spin == (num+3)) || (spin == (num+4))){
            bank+=(bet*9);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*9)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }

    public static double betFive(double bank, double bet){
        //tell what they bet on
        System.out.println("You bet on the numbers 0, 00, 1, 2, and 3. ");

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //result
        if((spin == 0) || (spin == 37) || (spin == 1) || (spin == 2) || (spin == 3)){
            bank+=(bet*7);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*7)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }

    public static double betSix(double bank, double bet){
        //scanner 
        Scanner reader = new Scanner(System.in);

        //initiate picks
        int num = -1;

        //while loop with if statement with every single two numbers that they could bet on and make them reenter numbers if they weren't touching 
        int again = 1;
        while(again == 1){
            //table 
            System.out.println("Here is what the table looks like:\n   0\t   00\n1\t2\t3\tRow\n4\t5\t6\n7\t8\t9\n10\t11\t12\n13\t14\t15\n16\t17\t18\n19\t20\t21\n22\t23\t24\n25\t26\t27\n28\t29\t30\n31\t32\t33\n34\t35\t36\nColumn\n");
            //numbers 
            System.out.println("What two rows would you like to bet on? **Enter the lowest number in your rows**: ");
            num = reader.nextInt();

            //if statement verifying validity of number
            if(((num+2)%3 == 0) && (num > 0) && (num < 35)){
                again = 0;
            }
            else{
                System.out.println("Those are invaldi inputs, try again. ");
                again = 1;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //result
        if((spin == num) || (spin == (num+1)) || (spin == (num+2)) || (spin == (num+3)) || (spin == (num+4)) || (spin == (num+5))){
            bank+=(bet*6);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*6)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }

    public static double betSeven(double bank, double bet){
        //scanner
        Scanner reader = new Scanner(System.in);

        //initiate picks
        int num = -1;

        //while loop with if statement with every single two numbers that they could bet on and make them reenter numbers if they weren't touching 
        int again = 1;
        while(again == 1){
            //what dozen
            System.out.println("Which dozen would you like to bet on? **Enter 1 for the first dozen (1-12), 2 for the second dozen (13-24), or 3 for the third dozen (25-36)**:");
            num = reader.nextInt();

            //if statement verifying validity of number
            if((num > 0) && (num < 4)){
                again = 0;
            }
            else{
                System.out.println("Those are invaldi inputs, try again. ");
                again = 1;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //result
        if(((spin%12 != 0) && (spin/12 == (num-1)) && (spin > 0 && spin < 37)) || ((spin%12 == 0) && (spin/12 == num))){
            bank+=(bet*3);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*3)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }

    public static double betEight(double bank, double bet){
        //scanner
        Scanner reader = new Scanner(System.in);

        //initiate picks
        int num = -1;

        //while loop with if statement with every single two numbers that they could bet on and make them reenter numbers if they weren't touching 
        int again = 1;
        while(again == 1){
            //what dozen
            System.out.println("Which column would you like to bet on? **Enter 1 for the first column, 2 for the second column, or 3 for the third column**:");
            num = reader.nextInt();

            //if statement verifying validity of number
            if((num > 0) && (num < 4)){
                again = 0;
            }
            else{
                System.out.println("Those are invaldi inputs, try again. ");
                again = 1;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //result
        if((spin%3 == num) || (spin%3 == (num-3))){
            bank+=(bet*3);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*3)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }

    public static double betNine(double bank, double bet){
        //scanner
        Scanner reader = new Scanner(System.in);

        //initiate picks
        int num = -1;

        //while loop with if statement with every single two numbers that they could bet on and make them reenter numbers if they weren't touching 
        int again = 1;
        while(again == 1){
            //what 18
            System.out.println("Which set of 18 would you like to bet on? **Enter 1 for the first set (1-18) or 2 for the second set (19-36)**:");
            num = reader.nextInt();

            //if statement verifying validity of number
            if((num > 0) && (num < 3)){
                again = 0;
            }
            else{
                System.out.println("Those are invaldi inputs, try again. ");
                again = 1;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //result
        if(spin > 0 && spin < 37 && ((spin%18 != 0 && (spin/18)+1 == num) || (spin%18 == 0 && spin/18 == num))) {
            bank+=(bet*2);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*2)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }

    public static double betTen(double bank, double bet){
        //scanner 
        Scanner reader = new Scanner(System.in);

        //say which nums are red/ black
        System.out.println("\nHere is a list of all the colors of each number:\nRed:\t1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, and 36\nBlack:\t2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, and 35");

        //initiate picks
        int num = -1;

        //while loop with if statement with every single two numbers that they could bet on and make them reenter numbers if they weren't touching 
        int again = 1;
        while(again == 1){
            //what color
        System.out.println("Would you like to bet on red or black? **Enter 1 for red or 2 for black**:");
            num = reader.nextInt();

            //if statement verifying validity of number
            if((num > 0) && (num < 3)){
                again = 0;
            }
            else{
                System.out.println("Those are invaldi inputs, try again. ");
                again = 1;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //color spun
        int color = -1;
        if((spin == 1) || (spin == 3) || (spin == 5) || (spin == 7)  || (spin == 9)  || (spin == 12) || (spin == 14) || (spin == 16) || (spin == 18) || (spin == 19) || (spin == 21) || (spin == 23) || (spin == 25) || (spin == 27) || (spin == 30) || (spin == 32) || (spin == 34) || (spin == 36)){
            System.out.println("Red was spun. \n");
            color = 1;
        }
        else{
            System.out.println("Black was spun. \n");
            color = 2;
        }

        //result
        if(color == num) {
            bank+=(bet*2);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*2)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }

    public static double betEleven(double bank, double bet){
        //scanner
        Scanner reader = new Scanner(System.in);

        //initiate picks
        int num = -1;

        //while loop with if statement with every single two numbers that they could bet on and make them reenter numbers if they weren't touching 
        int again = 1;
        while(again == 1){
            //what dozen
            System.out.println("Would you like to bet on odd or even? **Enter 1 for odd or 2 for even**:");
            num = reader.nextInt();

            //if statement verifying validity of number
            if((num > 0) && (num < 3)){
                again = 0;
            }
            else{
                System.out.println("Those are invaldi inputs, try again. ");
                again = 1;
            }
        }

        //spin
        int spin = spin();
        if(spin == 37){
            System.out.println("\n00 was spun\n");
        }
        else{
            System.out.println("\n"+spin+" was spun\n");
        }

        //odd or even
        int odd = -1;
        if(spin%2 == 0){
            odd = 2;
        }
        else{
            odd = 1;
        }

        //result
        if(num == odd) {
            bank+=(bet*2);
            System.out.println("You won!!! Congradulations! You have earned $"+(bet*2)+". You have $"+bank+".\n");
        }
        else{
            System.out.println("You lose! :(. You won $0. You have $"+bank+".\n");
        }

        //return new bank
        return bank;
    }
}
