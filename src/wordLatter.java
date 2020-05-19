import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordLatter {
    public static int ladderLength(String beginWord, String endWord, List<String> wordAsList) {
        if(!wordAsList.contains(endWord)) return 0;// if it doesn't contain the end word it isn't going ot work

        Set<String> wordList = new HashSet<String>(wordAsList);  // we have the set of words
        Set<String> start = new HashSet<String>();  // start seen words
        Set<String> end = new HashSet<String>();    // end seen words
        int length = 1;                                               // length is how far we have gone thus far. there is a first and an end word
        start.add(beginWord); end.add(endWord);
        wordList.remove(beginWord); wordList.remove(endWord); // we can no longer use these words obviously since htis is antural

        while(!start.isEmpty()){  // why is this the condition
            Set<String> next = new HashSet<String>(); //
            for(String word: start){
                char[] wordArray = word.toCharArray();
                for(int i=0; i<word.length(); i++){
                    char old = wordArray[i];
                    for(char c='a'; c<='z'; c++){
                        wordArray[i] = c;        // we change each value once
                        String str = String.valueOf(wordArray); // create the string
                        if(end.contains(str))            // if it contains it then we continue with it
                            return length+1;
                        if(wordList.contains(str)){
                            next.add(str); // this is the next thing that we can see
                            wordList.remove(str); // why do we remove it from wordlist?
                        }
                    }
                    wordArray[i] = old;
                }
            }
            start = next.size() < end.size() ? next: end; // next is obviously going to be greater than end, thus start is going ot ebe end
            end = start.size() < end.size() ? end : next; // end is obviously going to be
            length++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordAsList = new ArrayList<>();
        wordAsList.add("hot");
        wordAsList.add("dot");
        wordAsList.add("dog");
        wordAsList.add("lot");
        wordAsList.add("log");
        wordAsList.add("cog");
        ladderLength("hit", "cog", wordAsList );
    }

}
