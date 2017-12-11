package com.nju.nlp.wordsegment;

import java.util.List;
import java.util.Scanner;

public class SegMentation {
	
	public static List<String> segMent(String phrase){
		List<String> fmm = MaximumMatching.seg(phrase);
		List<String> rmm = ReverseMaximumMatching.seg(phrase);
		System.out.println(fmm.toString());
		System.out.println(rmm.toString());
		if (fmm.size() != rmm.size()){
			if(fmm.size() > rmm.size()){
				return  rmm;
			}else{
				return fmm;
			}
		} else{
			int FSingle = 0, RSingle = 0; 
			boolean isSame = true;
			for(int i=0; i<fmm.size(); i++){
				if(!fmm.get(i).equals(rmm.get(i))){
					isSame = false;
				}
				if(fmm.get(i).length()==1){
					FSingle +=1;
				}
				if(rmm.get(i).length()==1){
					RSingle += 1;
				}
			}
			
			
			if(isSame)return fmm;
			else{
				if(FSingle > RSingle) return rmm;
				else return fmm;
			}
		}
		
	}
	

}
