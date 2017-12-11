/**
 * 
 * APDPlat - Application Product Development Platform
 * Copyright (c) 2013, 杨尚川, yang-shangchuan@qq.com
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.nju.nlp.wordsegment;

import java.util.ArrayList;
import java.util.List;

import com.nju.iip.utils.ReadDictionary;
import com.nju.nlp.word.dictionaryImpl.DictionaryTrie;

/**
 * 基于词典的正向最大匹配算法
 * Dictionary-based maximum matching algorithm
 * @author 杨尚川
 */
public class MaximumMatching {

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
            String tryWord = text.substring(0, 0+len);  
            while(!DIC.contains(tryWord)){  
                //如果长度为一且在词典中未找到匹配，则按长度为一切分  
                if(tryWord.length()==1){  
                    break;  
                }  
                //如果匹配不到，则长度减一继续匹配  
                tryWord=tryWord.substring(0, tryWord.length()-1);  
            }  
            result.add(tryWord);  
            //从待分词文本中去除已经分词的文本  
            text=text.substring(tryWord.length());  
        }  
        return result;  
    }  
	
/*    public static void main(String[] args){
        String text = "我喜欢打游戏";
        if(args !=null && args.length == 1){
            text = args[0];
        }
        MaximumMatching m = new MaximumMatching();
        System.out.println(m.seg(text).toString());
    }*/
}
