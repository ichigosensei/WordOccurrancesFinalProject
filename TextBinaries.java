package Module2;

/**
 * @author s.trinidad
 *
 */
public class TextBinaries {

	private Node orgWord;	
	public TextBinaries(){
		this.orgWord=null;
	}
	
    static class Node {
        HashMap.Node finalBatch;
        Node firstBatch, secondBatch;
        
        // these are the node variables 
    public Node(HashMap.Node n) {
        firstBatch = null;
        secondBatch = null;
        finalBatch= n;
        
       }
    }
    
    // this is a function to store the words
    public void insert(HashMap.Node n){
    	orgWord= storeWord(orgWord,n);
    }
    
    
    private static Node storeWord(Node n,HashMap.Node finalBatch) { 
        if (n == null)
            return new Node(finalBatch);   
        if (n.finalBatch.compareTo(finalBatch)>0) {
            n.firstBatch = storeWord(n.firstBatch, finalBatch); 
            return n;
            
        } else if (n.finalBatch.compareTo(finalBatch)<0) { 
            n.secondBatch = storeWord(n.secondBatch, finalBatch);
            return n;
            
        	} else
        		return n;
    }
    
    // this helps prints the stored words on wordDoc
    public void printWordDoc(int wordDoc){
    	printWordCollector(orgWord,wordDoc);
    }
   
    
   // this helps print the words in correct format 
    private void printWordCollector(Node n,int wordDoc) {
           if( n != null ) {
        	   printWordCollector(n.firstBatch,wordDoc); //prints all left words first
                
        	   		System.out.print(n.finalBatch.word); 
               
                printBlankSpace(12-n.finalBatch.word.length()); //inserts correct space to be aligned properly
                for(int i=0;i<=wordDoc;i++){
                	
                	System.out.print("["+ n.finalBatch.count[i] + "]");
                	
                }	System.out.println(); 
                	printWordCollector(n.secondBatch,wordDoc); //print all right words
            }
         }
        
    	// this prints spaces in between the words and values  
      public void printBlankSpace(int blankSpace){
    	  
      	for(int i=0;i<blankSpace;i++ ){
      		System.out.print(" ");
      }
   }  
}
