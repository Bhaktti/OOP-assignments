package headfirst;

/**
 * Created by bhakti on 12/20/17.
 */
public class phraseOMatic {
    public static void main (String args[]){

//make a list of few word you want to select randamly

        String [] wordListOne = {"24/07", "30000" , "this" , "isto generate" ,"some random" , "words"};
        String[] wordListTwo = {"empowered" , "Sticky" , "Dynamic" , "Critical path fisrt" , "web based" , "mindsahre"};
        String[] wordListThree = { "process" , " tipping poing" , "solution" , "cooperative" , "portal" , "mission"};

       //find out how many word are in each list
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        //Generate three random numbers

        int rand1 = (int)(Math.random()* oneLength);
        int rand2 = (int)(Math.random()* twoLength);
        int rand3 = (int)(Math.random()* threeLength);

        //Build a phradse

        String phrase = wordListOne[rand1]+ " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        //print out the phrase
        System.out.println("what we need is a " + phrase);

        }
    }

