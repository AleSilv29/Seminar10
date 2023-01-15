import domain.Auto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, List<String>> autos= Stream.of(
        new Auto("Dacia", "Papuc", 1990),
        new Auto("Dacia", "Duster", 2015),
        new Auto("Dacia", "Spring", 2015),
        new Auto("Fiat", "Punto", 2015)).filter(a -> a.getMarke().equals("Dacia")).collect(Collectors.groupingBy(Auto::getBaujahr, Collectors.mapping(Auto::getModell, Collectors.toList())));
        System.out.println(autos);

        Auto a1=new Auto("Dacia","Papuc", 1995);
        Auto a2=new Auto("Kia","None", 1997);
        Auto a3=new Auto("Ford","Fiesta", 1996);
        Auto a4=new Auto("VW","Lupo", 1993);
        ArrayList<Auto> cars=new ArrayList<Auto>();
        cars.add(a1);
        cars.add(a2);
        cars.add(a3);
        cars.add(a4);
        for (Auto a: cars){
            if (!Objects.equals(a.getModell(), "None"))
                System.out.println(a.getModell());
        }

        System.out.println("2.");
        String text="Ana are mere";
        String s;
        String[] splitStr = text.split("\\s+");
        for(int i=0; i<splitStr.length; i++){
            s="  "+splitStr[i];
            System.out.println(s);
        }

        System.out.println("3.");
        String text2="Ana are Mere";
        String s2;
        char c;
        String[] splitStr2 = text2.split("\\s+");
        for(int i=0; i<splitStr2.length; i++){
            c=splitStr2[i].charAt(0);
            if(c>='A' && c<='Z')
                System.out.println(splitStr2[i]);
        }//creates a new file instance

        System.out.println("4.");
        /*BufferedReader reader = new BufferedReader(new FileReader("datei.txt"));
        String line = reader.readLine();
        while (line != null){
            boolean ok=true;
            if (line.contains("ar") || line.contains("ere"))
                ok=false;
            for(int i=0; i<line.length() && ok; i++){
                c=line.charAt(i);
                if(c>='A' && c<='Z')
                    ok=false;
            }
            if (ok)
                System.out.println(line);
            line = reader.readLine();
        }*/

        List<String> matchingWords = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("datei.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                // Iterate through each word in the line
                for (String word : words) {
                    // Check if the word contains "ete" and "ar"
                    if (word.contains("ete") && word.contains("ar")) {
                        // Add the word to the list in uppercase and with "!" at the end
                        matchingWords.add(word.toUpperCase() + "!");
                    }
                }
                line = reader.readLine();
            }
            // Sort the list of matching words
            Collections.sort(matchingWords);

            // Print out the matching words
            for (String word : matchingWords) {
                System.out.println(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("5.");
        String text3="Something in the waaaaay";
        String cuvant;
        String[] splitStr3 = text3.split("\\s+");
        for(int i=0; i<splitStr3.length; i++) {
            cuvant=splitStr3[i];
            if(splitStr3[i].length()<=4) {
                if (!splitStr3[i].contains("E"))
                    cuvant = splitStr3[i].toUpperCase();
            }
            System.out.println(cuvant);
            /*if(cuvant.length()<=4)
            {
                for (int j=0; j<cuvant.length(); j++)
                {
                    c=splitStr3[i].charAt(j);
                    if (splitStr3[i].contains("E"))
                        c.
                }
            }*/
        }

        System.out.println("6.");
        // The given text as a string
        String text6 = "This is a test text";
        // Split the text into words
        String[] words = text6.split(" ");
        // Create a StringBuilder to build the final string
        StringBuilder sb = new StringBuilder();
        // Iterate through each word
        for (String word : words) {
            // Convert the word to uppercase and append it to the StringBuilder
            sb.append(word.toUpperCase() + "\t");
        }
        // Convert the StringBuilder to a string and print it
        System.out.println(sb.toString());

        System.out.println("7.");
        text6 = "This is a test text";
        words = text6.split(" ");
        // Create a StringBuilder to build the final string
        sb = new StringBuilder();
        // Iterate through each word
        sb.append("Start:");
        for (String word : words) {
            // Convert the word to uppercase and append it to the StringBuilder
            sb.append(word.toUpperCase() + "\t");
        }
        sb.append(":End");
        // Convert the StringBuilder to a string and print it
        System.out.println(sb.toString());

        System.out.println("8.");
        String[] wordsArray = new String[matchingWords.size()];
        wordsArray=matchingWords.toArray(wordsArray);
        for(String wa : wordsArray)
            System.out.println(wa);

        System.out.println("9.");
        List<String> passwordList=new ArrayList<>();
        String password1="123Ale*";
        String password2="12345Ale*";
        String password3="12345Ale";
        passwordList.add(password1);
        passwordList.add(password2);
        passwordList.add(password3);
        String symbols="@#$%^&*().";
        boolean ok1=false, ok2=false;
        for (String p : passwordList){
            ok1=false;
            ok2=false;
            if (p.length()>=8)
            {
                for (int k=0; k<symbols.length(); k++)
                {
                   String symb= String.valueOf(symbols.charAt(k));
                    if (p.contains(symb)){
                        ok1=true;
                        break;
                    }
                }
                if (ok1)
                {
                    for (int i=0; i<p.length(); i++){
                        if (p.charAt(i) >= 'A' && p.charAt(i) <= 'Z') {
                            ok2=true;
                            break;
                        }
                    }
                    if (ok2)
                        System.out.println(p);
                }
            }
        }


        System.out.println("10.");
        int sum=0;
        try {
            reader = new BufferedReader(new FileReader("einkaufListe.csv"));
            String line = reader.readLine();
            while (line != null) {
                String[] articles = line.split(" ");
                String price=articles[2];
                int priceInt=Integer.parseInt(price);
                sum=sum+priceInt;
                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }

        }

    }
