package com.nju.iip.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nju.nlp.word.dictionaryImpl.DictionaryTrie;

public class ReadDictionary {
	private static final Logger logger = LoggerFactory.getLogger(ReadDictionary.class);
	public static DictionaryTrie readDictionary(String filename){
		logger.info("开始初始化字典");
		 try {  
			 DictionaryTrie trie = new DictionaryTrie();
			 String fileContent=null;
			 File f = new File(filename);
			 if(f.isFile()&&f.exists()){
			    InputStreamReader read = new InputStreamReader(new FileInputStream(f),"gbk");
			    BufferedReader reader=new BufferedReader(read);
			    String line;
			    int cnt=0;
			    while ((line = reader.readLine()) != null) {
			     //fileContent;
			    	String[] cword = line.split(",");
			    	trie.add(cword[0].trim());
			    	//logger.info(cword[0]);
			    	cnt ++;
			    }   
			    //trie.show();
			    read.close();
			    return trie;
			   }
			  } catch (Exception e) {
			   logger.error("读取文件内容操作出错");
			   e.printStackTrace();
			   return null;
			  }
		return null; 
	}
	
/*	public static void main(String[] args){
		ReadDictionary test = new ReadDictionary();
		test.readDictionary("ce(ms-word).txt");
	}*/
}
