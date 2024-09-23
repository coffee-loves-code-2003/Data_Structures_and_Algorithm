import java.util.*;
public class Word_Ladder_2
{
    
        public List<List<String>> getOutput(String beginWord,String endWord,HashSet<String> wordsList,List<List<String>> answer)
        {
            Queue<List<String>> queue = new LinkedList<>();
            List<String> beginList = new ArrayList<>();
            beginList.add(beginWord);
            queue.add(beginList);
            int string_length = beginWord.length();
            int min_level = -1;
            while(!queue.isEmpty())
            {
                int level = queue.size();
                List<String> deleting_string = new ArrayList<>();
                for(int i = 0;i < level;i++)
                {
                  List<String> lists = queue.poll();
                //   System.out.println(lists);
                  StringBuilder last_word = new StringBuilder(lists.get(lists.size()-1));
                  for(int j = 0;j < string_length;j++)
                  {
                    char last_temp = last_word.charAt(j);
                    for(char alpha = 'a'; alpha <= 'z' ;alpha++)
                    {
                        last_word.replace(j,j+1,alpha+"");
                        if(wordsList.contains(last_word.toString()))
                        {
                            String temp_string = last_word.toString();
                            lists.add(temp_string);
                            deleting_string.add(temp_string);
                            queue.add(new ArrayList<>(lists));
                            if(temp_string.equals(endWord) && min_level == -1)
                            {
                                min_level = lists.size();
                                answer.add(new ArrayList<>(lists));
                            }
                            else if(temp_string.equals(endWord) && min_level == lists.size())
                            {
                                answer.add(new ArrayList<>(lists));
                            }
                            lists.remove(lists.size()-1);
                            
                            //break;
                        }
    
                    }
                    last_word.replace(j,j+1,last_temp+"");
     
                  }
                 
                }
                for(String word: deleting_string)
                {
                    wordsList.remove(word);
                }
            }
            return answer;
            
        }
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordsList = new HashSet<>();
            for(String word : wordList)
            {
                wordsList.add(word);
            }
            List<List<String>> answer = new ArrayList<>();
            return getOutput(beginWord,endWord,wordsList,answer);
        }
    public static void main(String[] args) {
        Word_Ladder_2 obj = new Word_Ladder_2();
        String beginWord  = "aaaaa";
        String endWord = "ggggg";
        List<String> wordList = new ArrayList<>();
        String words[] = {"aaaaa","caaaa","cbaaa","daaaa","dbaaa","eaaaa","ebaaa","faaaa","fbaaa","gaaaa","gbaaa","haaaa","hbaaa","iaaaa","ibaaa","jaaaa","jbaaa","kaaaa","kbaaa","laaaa","lbaaa","maaaa","mbaaa","naaaa","nbaaa","oaaaa","obaaa","paaaa","pbaaa","bbaaa","bbcaa","bbcba","bbdaa","bbdba","bbeaa","bbeba","bbfaa","bbfba","bbgaa","bbgba","bbhaa",
        "bbhba","bbiaa","bbiba","bbjaa","bbjba","bbkaa","bbkba",
        "bblaa","bblba","bbmaa","bbmba","bbnaa","bbnba","bboaa","bboba","bbpaa","bbpba","bbbba","abbba","acbba","dbbba","dcbba","ebbba","ecbba","fbbba","fcbba","gbbba","gcbba","hbbba","hcbba","ibbba","icbba","jbbba","jcbba","kbbba","kcbba","lbbba","lcbba","mbbba","mcbba","nbbba","ncbba","obbba","ocbba","pbbba","pcbba","ccbba","ccaba","ccaca","ccdba","ccdca","cceba","cceca","ccfba","ccfca","ccgba","ccgca","cchba","cchca","cciba","ccica","ccjba","ccjca",
        "cckba","cckca","cclba","cclca","ccmba","ccmca","ccnba","ccnca","ccoba","ccoca",
        "ccpba","ccpca","cccca","accca","adcca","bccca","bdcca","eccca","edcca","fccca",
        "fdcca","gccca","gdcca","hccca","hdcca","iccca","idcca","jccca","jdcca","kccca","kdcca","lccca","ldcca","mccca","mdcca","nccca","ndcca","occca","odcca","pccca","pdcca","ddcca","ddaca","ddada","ddbca","ddbda","ddeca","ddeda","ddfca","ddfda","ddgca","ddgda","ddhca","ddhda","ddica","ddida","ddjca","ddjda","ddkca","ddkda","ddlca","ddlda","ddmca","ddmda","ddnca","ddnda","ddoca","ddoda","ddpca","ddpda","dddda","addda","aedda","bddda","bedda","cddda","cedda","fddda","fedda","gddda","gedda","hddda","hedda","iddda","iedda","jddda","jedda","kddda","kedda","lddda","ledda","mddda","medda","nddda","nedda","oddda","oedda","pddda","pedda","eedda","eeada","eeaea","eebda","eebea","eecda","eecea","eefda","eefea","eegda","eegea","eehda","eehea","eeida","eeiea","eejda","eejea","eekda","eekea","eelda","eelea","eemda","eemea","eenda","eenea","eeoda","eeoea","eepda","eepea","eeeea","ggggg","agggg","ahggg","bgggg","bhggg","cgggg","chggg","dgggg","dhggg","egggg","ehggg","fgggg","fhggg","igggg","ihggg","jgggg","jhggg","kgggg","khggg","lgggg","lhggg","mgggg","mhggg","ngggg","nhggg","ogggg","ohggg","pgggg","phggg","hhggg","hhagg","hhahg","hhbgg","hhbhg","hhcgg","hhchg","hhdgg","hhdhg","hhegg","hhehg","hhfgg","hhfhg","hhigg","hhihg","hhjgg","hhjhg","hhkgg","hhkhg","hhlgg","hhlhg","hhmgg","hhmhg","hhngg","hhnhg","hhogg","hhohg","hhpgg","hhphg","hhhhg","ahhhg","aihhg","bhhhg","bihhg","chhhg","cihhg","dhhhg","dihhg","ehhhg","eihhg","fhhhg","fihhg","ghhhg","gihhg","jhhhg","jihhg","khhhg","kihhg","lhhhg","lihhg","mhhhg","mihhg","nhhhg","nihhg","ohhhg","oihhg","phhhg","pihhg","iihhg","iiahg","iiaig","iibhg","iibig","iichg","iicig","iidhg","iidig","iiehg","iieig","iifhg","iifig","iighg","iigig","iijhg","iijig","iikhg","iikig","iilhg","iilig","iimhg","iimig","iinhg","iinig","iiohg","iioig","iiphg","iipig","iiiig","aiiig","ajiig","biiig","bjiig","ciiig","cjiig","diiig","djiig","eiiig","ejiig","fiiig","fjiig","giiig","gjiig","hiiig","hjiig","kiiig","kjiig","liiig","ljiig","miiig","mjiig","niiig","njiig","oiiig","ojiig","piiig","pjiig","jjiig","jjaig","jjajg","jjbig","jjbjg","jjcig","jjcjg","jjdig","jjdjg","jjeig","jjejg","jjfig","jjfjg","jjgig","jjgjg","jjhig","jjhjg","jjkig","jjkjg","jjlig","jjljg","jjmig","jjmjg","jjnig","jjnjg","jjoig","jjojg","jjpig","jjpjg","jjjjg","ajjjg","akjjg","bjjjg","bkjjg","cjjjg","ckjjg","djjjg","dkjjg","ejjjg","ekjjg","fjjjg","fkjjg","gjjjg","gkjjg","hjjjg","hkjjg","ijjjg","ikjjg","ljjjg","lkjjg","mjjjg","mkjjg","njjjg","nkjjg","ojjjg","okjjg","pjjjg","pkjjg","kkjjg","kkajg","kkakg","kkbjg","kkbkg","kkcjg","kkckg","kkdjg","kkdkg","kkejg","kkekg","kkfjg","kkfkg","kkgjg","kkgkg","kkhjg","kkhkg","kkijg","kkikg","kkljg","kklkg","kkmjg","kkmkg","kknjg","kknkg","kkojg","kkokg","kkpjg","kkpkg","kkkkg","ggggx","gggxx","ggxxx","gxxxx","xxxxx","xxxxy","xxxyy","xxyyy","xyyyy","yyyyy","yyyyw","yyyww","yywww","ywwww","wwwww","wwvww","wvvww","vvvww","vvvwz","avvwz",
        "aavwz","aaawz","aaaaz"};
        for(int i = 0 ;i < words.length;i++)
        {
            wordList.add(words[i]);
        }
        System.out.println(obj.findLadders(beginWord,endWord,wordList));

    }
}