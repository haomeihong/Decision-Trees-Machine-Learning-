package Trees;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import Trees_ml.Entropy;

public class Trees_main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		if(args.length != 2)
		{
			System.out.println("You should give exactly 2 argumetns as input which are names of training data and test data files");
			System.exit(1);
			
		}
		System.out.println("Programm in Execution");
		String trainingData = args[0];
		String testData = args[1];

		BufferedReader in =
				new BufferedReader(new FileReader( trainingData ), 4096 /* buffsize */ );
		
		        
				String aLine=in.readLine() ;
				
				String [] columns=aLine.split("\\s+");
				
				LinkedList<String> attrnames=new LinkedList<>();
				for(int j=0;j<columns.length;j=j+2){
					attrnames.add(columns[j]);
				}
				
				
				
				BufferedReader in1 =
						new BufferedReader(new FileReader( testData ), 4096 /* buffsize */ );
				
				        
						String aLine1=in1.readLine() ;
						
						String [] columns1=aLine1.split("\\s+");
						
						LinkedList<String> attrnames1=new LinkedList<>();
						for(int j=0;j<columns1.length;j=j+2){
							attrnames1.add(columns1[j]);
						}
						
				
			   LinkedList<String> attr[]= new LinkedList[columns.length];
				
				LinkedList<String> attr1[]=new LinkedList[columns1.length];
				
				for(int i=0;i<columns.length;i++){
					attr[i]=new LinkedList();
				}
				
				
				for(int i=0;i<columns1.length;i++){
					attr1[i]=new LinkedList();
				}
				
				
				
				
				while ((aLine=in.readLine())!=null){
					
				
				 columns=aLine.split("\\s+");
				
				for(int i=0;i<columns.length;i++){
					
					attr[i].add(columns[i]);
				}
				
				}
				
				
				while ((aLine1=in1.readLine())!=null){
					
					
					 columns1=aLine1.split("\\s+");
					
					for(int i=0;i<columns1.length;i++){
						
						attr1[i].add(columns1[i]);
					}
					
					}
				
				
				//System.out.println(attr1[0].size());
	       
				Entropy e=new Entropy();
			    Growtrees g=new Growtrees(e,attr,columns.length);
				LinkedList<String> flag1=new LinkedList<String>();
			    flag1=g.getInitialFlag(attrnames);
			    
			  
			Node root=g.Grow(attr, columns.length, attrnames,flag1);
			
		
		     double acc=g.Findaccuracy(root, attr1, columns.length, attrnames, attrnames1);
		
		     System.out.println("Accuracy obtained on Test data is"+"  "+acc+" "+"%");
		     
		     System.out.println("The Decision Tree for the Training Data Set");
		
		      g.printTrees(root, 0);
			

			
		
		
		
		
		
		
	}
	
}

