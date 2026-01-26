public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s.length() == 1) return s;
        int i=s.length()-1;
        StringBuilder result = new StringBuilder();
        while(i>=0){
            //Skip space and find last word
            while(i>=0 && s.charAt(i) == ' ') i--;
            if(i<0) break; //If all spaces just exit
            int j = i;
            //Find previous space of first position of word,
            while(i>=0 && s.charAt(i) != ' ') i--;
            result.append(s, i+1, j+1); //only add in range [i+1,j)
            result.append(" "); //Add a single space;
        }
        return ((result).substring(0,result.toString().length()-1));
    }
}
