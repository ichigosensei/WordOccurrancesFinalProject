//Created By: Trinidad, Strawberry Ann
//Subject: CEN-3024C Software Development I
//Date: February 8, 2022

package Module2;

import java.util.Scanner;

/**
 * @author s.trinidad
 *
 */
public class VCTextAnalyzer {

	public VCTextAnalyzer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main (String [] args){
		@SuppressWarnings("resource")
		Scanner textAnalyzer = new Scanner(System.in); // this makes textAnalyzer a scanner
		
		openingMsg(); // this prints the opening message for the VCTextAnalyzer
		
		String wordLine= textAnalyzer.nextLine();
		int wordDoc=0; // this creates a variable that starts with zero and its called wordDoc
		HashMap hashArray = new HashMap(10000); 
		
		while(!(wordLine.equals("STOP"))){ // these are used to STOP or add NEW documents on the analyzer
			if(wordLine.equals("NEW")){ 
				wordDoc++;
				
			} else {
				String[] lineArray = wordLine.toLowerCase().split("\\W+"); 
				
				for(int i=0;i<lineArray.length;i++){
					hashArray.insert(lineArray[i],wordDoc);  
				}	
			} wordLine= textAnalyzer.nextLine(); 

		}
		
		TextBinaries binaryOne =new TextBinaries(); // this makes a binary tree
		
		HashMap.Node[] currHash= hashArray.getTableInfo(); 
		for(int i=0;i<currHash.length;i++){ 
			if(!(currHash[i]==null)){ 
				HashMap.Node n = currHash[i]; 
				
				while(n!=null){ 
					binaryOne.insert(n); 
					n=n.next; 
				}
			}
		} binaryOne.printWordDoc(wordDoc); // this prints the words stored in the variable wordDoc
	}
	
	public static void openingMsg(){
		System.out.println("Welcome to the Valencia Text Analyzer!\n\nYou may now copy and paste or type the text you want to be analyzed below." +
		" You can type (NEW) to add a new separate text or (STOP) to quit the text analyzer. \nYou may load up to (3) text documents in the analyzer. \n\nHave fun!\n");
	}

}