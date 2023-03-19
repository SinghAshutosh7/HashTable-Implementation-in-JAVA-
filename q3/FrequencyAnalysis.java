import java.util.ArrayList;

import Includes.*;
public class FrequencyAnalysis {
    //sizes of hash-tables are updated
    static final int[] hashTableSizes = {173, 6733, 100003};
    COL106Dictionary<String, Integer> dict1 = new COL106Dictionary<String, Integer>(hashTableSizes[0]);
    COL106Dictionary<String, Integer> dict2 = new COL106Dictionary<String, Integer>(hashTableSizes[1]);
    COL106Dictionary<String, Integer> dict3 = new COL106Dictionary<String, Integer>(hashTableSizes[2]);


    void fillDictionaries(String inputString) throws NullKeyException, KeyAlreadyExistException, KeyNotFoundException {
        /*
         * To be filled in by the student
         */
        String a=inputString.trim();
        a=a.toLowerCase();
        String word="";
        ArrayList<String>  ab= new ArrayList<String>();
        for (int i=0; i<a.length();i++){
            if('a'<=a.charAt(i) && a.charAt(i)<='z'){
                word+=a.charAt(i);
            }
            else if(a.charAt(i)==32 && word!=""){
                ab.add(word);
                word="";
                while(a.charAt(i)==32){
                    i++;
                }
                i--;
            }
            else if ((i==a.length()-1) && word!=""  ){
                ab.add(word);
            }
            else{
                continue;
            }
        }
        for (int i = 0; i < ab.size(); i++) {
            try {
                dict1.insert(ab.get(i), 1);
                dict2.insert(ab.get(i), 1);
                dict3.insert(ab.get(i), 1);
            } catch (KeyAlreadyExistException e) {
                dict1.update(ab.get(i), dict1.get(ab.get(i))+1);
                dict2.update(ab.get(i), dict2.get(ab.get(i))+1);
                dict3.update(ab.get(i), dict3.get(ab.get(i))+1);
            }
        }
    }
    
    long[] profile() {
        /*
         * To be filled in by the student
         */
        return new long[4];
    }


    int[] noOfCollisions() {
        /*
         * To be filled in by the student
         */
        int[] result={0,0,0};
        for (int i = 0; i < 173; i++) {
            if(dict1.hashTable[i]!=null ){
                result[0]+=dict1.hashTable[i].size()-1;
            }
        }
        for (int i = 0; i < 6733; i++) {
            if(dict2.hashTable[i]!=null ){
                result[1]+=dict2.hashTable[i].size()-1;
            }
        }
        for (int i = 0; i < 100003; i++) {
            if(dict3.hashTable[i]!=null ){
                result[2]+=dict3.hashTable[i].size()-1;
            }
        }
        return result;
    }
    String hexcode(String s){
        String c="0";
        if (s=="0000"){
            c="0";
        }
        if (s=="0001"){
            c="1";
        }
        if (s=="0010"){
            c="2";
        }
        if (s=="0011"){
            c="3";
        }
        if (s=="0100"){
            c="4";
        }
        if (s=="0101"){
            c="5";
        }
        if (s=="0110"){
            c="6";
        }
        if (s=="0111"){
            c="7";
        }
        if (s=="1000"){
            c="8";
        }
        if (s=="1001"){
            c="9";
        }
        if (s=="1010"){
            c="A";
        }
        if (s=="1011"){
            c="B";
        }
        if (s=="1100"){
            c="C";
        }
        if (s=="1101"){
            c="D";
        }
        if (s=="1110"){
            c="E";
        }
        if (s=="1111"){
            c="F";
        }

        return c;
    }

    String[] hashTableHexaDecimalSignature() {
        /*
         * To be filled in by the student
         */
        String[] bN_Strings = {"" , "" , "" };
        for (int i = 0; i < 173; i++) {
            if(dict1.hashTable[i]!=null ){
                bN_Strings[0]=bN_Strings[0]+ "1";
            }
            else{bN_Strings[0]=bN_Strings[0]+"0";}
        }
        for (int i = 0; i < 6733; i++) {
            if(dict2.hashTable[i]!=null ){
                bN_Strings[1]=bN_Strings[1]+"1";
            }
            else{bN_Strings[1]=bN_Strings[1]+"0";}
        }
        for (int i = 0; i < 100003; i++) {
            if(dict3.hashTable[i]!=null ){
                bN_Strings[2]=bN_Strings[2]+"1";
            }
            else{bN_Strings[2]=bN_Strings[2]+"0";}
        }

        for(int i=0; i<3;i++){
            if(bN_Strings[i].length() %4==0){
                continue;
            }
            else if(bN_Strings[i].length() %4==1){
                bN_Strings[i]="000" +bN_Strings[i];
                if(bN_Strings[i].substring(0,4)=="0000"){
                    bN_Strings[i]=bN_Strings[i].substring(4,bN_Strings[i].length());
                }
            }
            else if(bN_Strings[i].length() %4==2){
                bN_Strings[i]="00" +bN_Strings[i];
                if(bN_Strings[i].substring(0,4)=="0000"){
                    bN_Strings[i]=bN_Strings[i].substring(4,bN_Strings[i].length());
                }
            }
            else {
                bN_Strings[i]="0" +bN_Strings[i];
                if(bN_Strings[i].substring(0,4)=="0000"){
                    bN_Strings[i]=bN_Strings[i].substring(4,bN_Strings[i].length());
                }
            }
        }


        String[] res= {"", "" , ""};

        for(int i=0;i<3;i++){
            for(int j=0;j<bN_Strings[i].length();j=j+4){
                
                    res[i]=res[i]+ hexcode(bN_Strings[i].substring(j,j+4));
                
            }
        }
        return res;
    }
    
    String[] distinctWords() {
        /*
         * To be filled in by the student
         */
        // String [] res=dict1.keys(String.class);
        
        return dict1.keys(String.class);
    }

    Integer[] distinctWordsFrequencies() {
        /*
         * To be filled in by the student
         */
        // Integer[] res = dict1.values(Integer.class);
        return dict1.values(Integer.class);
    }
    public static void main(String[] args) {
        FrequencyAnalysis q1 = new FrequencyAnalysis();
        FrequencyAnalysis q2 = new FrequencyAnalysis();

        String txt = "Hellow World's [] a@po90[] ap0o world hellow w[]o[]r[]l[]d   {apo} ' s'ss  World  ";
        String t1= "The Indian Institute of Technology Delhi (IIT Delhi) is a public institute of technology located in New Delhi, India. It is one of the twenty-three Indian Institutes of Technology created to be Centres of Excellence for India’s training, research and development in science, engineering and technology. ";
 
    try {

    
    q1.fillDictionaries(txt );
    q2.fillDictionaries(t1 );

    for(int i=0; i<5;i++ ){
    System.out.println(q1.dict1.keys(String.class)[i]+ " "+ q1.dict1.values(Integer.class)[i] + " keys :" +  q1.distinctWords()[i] + " Values :" +  q1.distinctWordsFrequencies()[i] );}

    for(int i=0; i<q2.distinctWords().length;i++ ){
        // System.out.println(q1.dict1.keys(String.class)[i]+ " "+ q1.dict1.values(Integer.class)[i] + " keys :" +  q1.distinctWords()[i] + " Values :" +  q1.distinctWordsFrequencies()[i] );}
        System.out.print(  q2.distinctWords()[i] + ", ");}
    for(int i=0; i<q2.distinctWords().length;i++ ){
        // System.out.println(q1.dict1.keys(String.class)[i]+ " "+ q1.dict1.values(Integer.class)[i] + " keys :" +  q1.distinctWords()[i] + " Values :" +  q1.distinctWordsFrequencies()[i] );}
        System.out.print(    q2.distinctWordsFrequencies()[i] + "," );}

    System.out.println("  -----");

    System.out.println( q1.hexcode("0011")+'1');

    


    } catch (NullKeyException e) {
    }catch (KeyAlreadyExistException e) {
    
    }catch (KeyNotFoundException e) {
        
    }
    }
}
