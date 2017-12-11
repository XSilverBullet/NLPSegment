package com.nju.nlp.wordsegment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.nju.iip.utils.ReadDictionary;
import com.nju.nlp.word.dictionaryImpl.DictionaryTrie;

public class ReverseMaximumMatching {
	private static final int MAX_LENGTH=6;
	public  static List<String> seg(String text){          
        List<String> result = new ArrayList<>(); 
        DictionaryTrie DIC = ReadDictionary.readDictionary("ce(ms-word).txt");
        while(text.length()>0){  
            int len=MAX_LENGTH;  
            if(text.length()<len){  
                len=text.length();  
            }  
            //取指定的最大长度的文本去词典里面匹配  
            String tryWord = text.substring(text.length()-len, text.length());  
            while(!DIC.contains(tryWord)){  
                //如果长度为一且在词典中未找到匹配，则按长度为一切分  
                if(tryWord.length()==1){  
                    break;  
                }  
                //如果匹配不到，则长度减一继续匹配  
                tryWord=tryWord.substring(1, tryWord.length());  
            }  
            result.add(tryWord);  
            //从待分词文本中去除已经分词的文本  
            text=text.substring(0,text.length()-tryWord.length());  
        } 
        Collections.reverse(result);
        return result;  
    }  
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in); 
        
        while (true) { 
        	System.out.println("请输入一串中文，输入  'exit' 退出程序："); 
            String text = s.nextLine(); 
            if (text.equals("exit")) break; 
            ReverseMaximumMatching m = new ReverseMaximumMatching();
            System.out.println("中文分词结果如下： ");
            System.out.println(m.seg(text).toString());
            //System.out.println(">>>" + line); 
        } 
        
    }
}
