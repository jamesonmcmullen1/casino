import java.util.Scanner;
public class poker {

    public static void main(String[] args) {
        //initiate scanner
        Scanner reader = new Scanner(System.in);

        //start for loop that runs program 5 times
        for(int c = 0; c<5; c++){

            //input cards using while loop to get correct input
            //initiate input
            String input = "";
            //initiate int array of cards 
            int [] cards = {};

            int repeat = 1;
            while(repeat == 1){
                //gether input
                System.out.println("Input 5 numbers 1-52 seperated by commas (these will be the cards you are dealt): ");
                input = reader.nextLine();

                //gather and organize data from input
                String [] cardStr = input.split(",");
                cards = new int[cardStr.length];
                for(int i = 0; i<cardStr.length; i++){
                    cards[i] = Integer.parseInt(cardStr[i]);
                }

                //test to see if there is a correct number of cards
                if(cardStr.length == 5){
                    repeat = 0;
                }

                //check to see if each card value is valid
                for(int m = 0; m<5; m++){
                    if(cards[m] < 0 || cards[m] > 52){
                        repeat = 1;
                    }
                }

                //check to make sure they enter different cards
                for(int b = 0; b<5; b++){
                    for(int a = b+1; a<5; a++){
                        if(cards[b] == cards[a]){
                            repeat = 1;
                        }
                    }
                }
                
                //if one condition fails try again
                if(repeat == 1){
                    System.out.println("Input Error; try again. ");
                }
            }
            
            //send to method that returns the best hand and prints result
            System.out.println(bestHand(cards)+"\n");
        }
    }

    public static String bestHand(int [] cards){
        //use if statement to check if the hand has four of a kind then full house and so on
        //returns when one hand type is true
        if(fourOfAKind(cards)){
            return "FOUR OF A KIND";
        }
        else if(fullHouse(cards)){
            return "FULL HOUSE";
        }
        else if(flush(cards)){
            return "FLUSH";
        }
        else if(threeOfAKind(cards)){
            return "THREE OF A KIND";
        }
        else if(twoPair(cards)){
            return "TWO PAIRS";
        }
        else if(pair(cards)){
            return "PAIR";
        }
        else{
            return "NONE";
        }
    }

    public static boolean fourOfAKind(int [] cards){
        //initiate alike card count
        int alike = 0;

        //use nested for loops to check the number of cards that match a card 
        //only need to check with the first two since if four of a kind there will only be one unalike card
        for(int i = 0; i<2; i++){
            for(int c = i; c<5; c++){
                if(cards[i]%13 == cards[c]%13){
                    alike++;
                }
            }
            //if the number of cards that match card at index i are 3 plus itself (four of a kind) return true
            if(alike == 4){
                return true;
            }
            //otherwise reset alike value and try with next card
            alike = 0;
        }

        return false;
    }

    public static boolean threeOfAKind(int [] cards){
        //initiate alike card count
        int alike = 0;

        //use nested for loops to check the number of cards that match a card 
        //only need to check with the first three since if three of a kind there will only be two unalike cards
        for(int i = 0; i<3; i++){
            for(int c = i; c<5; c++){
                if(cards[i]%13 == cards[c]%13){
                    alike++;
                }
            }
            //if the number of cards that match are 2 plus itself, three of a kind, return true 
            if(alike == 3){
                return true;
            }
            //otherwise reset alike value and try with next card
            alike = 0;
        }

        return false;
    }

    public static boolean pair(int [] cards){
        //use nested for loops to check if there is a card that matches another card when they are not the same card
        for(int i = 0; i<2; i++){
            for(int c = i; c<5; c++){
                //returns that there is a pair when one is found
                if(cards[i]%13 == cards[c]%13 && i != c){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean fullHouse(int [] cards){
        //start array to keep track of index of triplet
        int [] tracker = new int[3];
        
        //initiate int to store the place the triplets in the array
        int alike = 0;

        //use for loop to find triplet
        for(int i = 0; i<3; i++){
            for(int c = i; c<5; c++){
                if(cards[i]%13 == cards[c]%13){
                    tracker[alike] = c;
                    alike++;
                }
            }
            if(alike == 3){
                break;
            }
            alike = 0;
        }

        //check to see if a triplet was found if not cannot be full house
        if(alike != 3){
            return false;
        }

        //find the index of cards not in triplet
        //initiate int array to store the cards in pair
        int [] pair = new int[2];
        int x = 0;
        for(int j = 0; j<5; j++){
            if(cards[j]%13 != cards[tracker[0]]%13){
                pair[x] = j;
                x++;
            }
        }
        
        //if the two remianing cards are a pair return true
        return cards[pair[0]]%13 == cards[pair[1]]%13;
    }

    public static boolean flush(int [] cards){
        //if all the cards are in the same suit return true
        //use for loop to check if each card is in the same suit as the one in the next index
        for(int i = 0; i<4; i++){
            //returns false if suits ever don't match
            if(cards[i]/13 != cards[i+1]/13){
                return false;
            }
        }
        return true;
    }

    public static boolean twoPair(int [] cards){
        //initiate pair numbers
        int pairs = 0;

        //use nested for loops to check if there is a card that matches another card when they are not the same card
        for(int i = 0; i<5; i++){
            for(int c = i; c<5; c++){
                if(cards[i]%13 == cards[c]%13 && i != c){
                    pairs++;
                }
            }
        }

        //if there are two pairs the pairs count will count each pair twice and therefore be 4
        //return if there are two pairs or not
        return pairs == 4;
    }
}
