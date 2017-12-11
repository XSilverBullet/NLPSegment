package com.nju.nlp1;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.nju.nlp.wordsegment.SegMentation;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in); 
		while(true){
	    	System.out.println("请输入一串中文："); 
	    	try{
	            String text = s.nextLine();
	            //Date nowTime = new Date(System.currentTimeMillis());
	            List<String> seg = SegMentation.segMent(text);
	            //Date endTime = new Date(System.currentTimeMillis());
	            System.out.println("中文分词结果如下： ");
	            System.out.println(seg.toString());
	      
	    	}catch(Exception e){
	    		System.out.println("程序运行失败  ");
	    		e.printStackTrace();
	    	}
		}
        
     } 
}
