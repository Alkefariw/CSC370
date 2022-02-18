


import java.util.ArrayList;
import java.util.HashMap;


public class TreeAssignment {
    
    
      public void displayTreeToScreen(int[] mainIndexes, String[] listValues){
         int rootIndex ,i;
         rootIndex= i=0;
         while( i < mainIndexes.length){
             
             // only if its equal to -1 
    		  if(mainIndexes[i]==-1){
    			  rootIndex=i;
    		  }
                  
                  
                  i++;
    	  }
         
         String root = listValues[rootIndex];
         HashMap<String, ArrayList<String>> map = new HashMap<>(); 
         map = printRepeat(root, mainIndexes, listValues, map);

         
         ArrayList<String> output = new ArrayList<>();
         drawingTheMap("", root, 0, output, false, map);
         
         
        
         
      }
      
    
            
            
            
      
      public ArrayList<String> drawingTheMap(String initialVal, String coreVal, int depth, ArrayList<String> mainListOfDrawingFunction, boolean leafNodes, HashMap<String, ArrayList<String>> mainMap){
    	  
    	  String mainNod = initialVal;
          mainNod +=  "+-" ;
          mainNod += coreVal; 
          
    	  if(leafNodes==true){ 
              initialVal +=   "| "; } 
    	  else{  
              
              initialVal +=  "  ";
          
          } 
    	  
          
           System.out.print(mainNod);
    	  System.out.println("");
          
          
    	  mainListOfDrawingFunction.add(mainNod); 
          
    	  if(mainMap.containsKey(coreVal) == true){
    		  ArrayList<String> subValues = mainMap.get(coreVal);
    		  String lastSubVal = subValues.get(subValues.size()-1);
                  
                  
        	  if(subValues.isEmpty()){
        	
                      // do nothing
        	  }else{
                  
                      
                      	  for(String temp : subValues){
                              leafNodes = mainMap.containsKey(temp) & !temp.equals(lastSubVal); 
            		  mainListOfDrawingFunction = drawingTheMap(initialVal, temp, depth+1, mainListOfDrawingFunction, leafNodes, mainMap);
            	  }
                          
                          
                  }
                  
                  
                  
    	  }
 
    	  return mainListOfDrawingFunction; 
      }
      
      
      
      
      
      public HashMap<String, ArrayList<String>> printRepeat(String primaryS, int[] mainIndex, String[] listNames, HashMap<String, ArrayList<String>> mainMap){
    	  
    	  ArrayList<String> hierarchyLeafs = new ArrayList<>(); 
          int i=0; 
    	  while(i < mainIndex.length){
    		  if(mainIndex[i]!=-1){
    			  String headName = listNames[mainIndex[i]];
                          
                          // its equal to the primary variable value 
        		  if(headName.equals(primaryS)){
   
        			  hierarchyLeafs.add(listNames[i]);
        		  }
    		  }
    		  
                  
                  i++;
    	  }
          
          
          // if the value is not empty then we go recursive 
    	  if(!hierarchyLeafs.isEmpty()){
    		   
                   mainMap.put(primaryS, hierarchyLeafs);
    		  for(String child : hierarchyLeafs){
    			  mainMap = printRepeat(child, mainIndex, listNames, mainMap);
    		  }
    		  return mainMap;
    	  }
    	  else{
    		return mainMap; 
    	  }
    	  
      }
      
      
      
      
      
      
      
      
      
      public static void main(String[] args){
          
          
          // This is the main class where we run all code for test cases 
          
    	  TreeAssignment myClassObj = new TreeAssignment();
        
    	  int[] mainIndexes1 = {-1,0,1,1,0,0,5,5};
    	  String[] secondryIndexes1 = {"Root","SubB","LEAF1","LEAF2","LEAF3","SubA","LEAF4","LEAF5"};
          int[] mainIndexes2 = {1,2,3,4,5,6,-1};
    	  String[] secondryIndexes2 = {"A","B","C","D","E","F","G"};
          int[] mainIndexes3 = {1,2,3,4,6,6,-1};
    	  String[] secondryIndexes3 = {"A","B","C","D","E","F","G"};
          int[] mainIndexes4 = {6,2,3,4,5,6,-1};
    	  String[] secondryIndexes4 = {"A","B","C","D","E","F","G"};
          int[] mainIndexes5 = {-1,0,1,1,2,2,3,3,0,8,8,9,9,10,10};
    	  String[] secondryIndexes5 = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
          
          
         // calling all test cases here below once
    	 myClassObj.displayTreeToScreen(mainIndexes1, secondryIndexes1);  
    	 myClassObj.displayTreeToScreen(mainIndexes2, secondryIndexes2);
    	 myClassObj.displayTreeToScreen(mainIndexes3, secondryIndexes3);
    	 myClassObj.displayTreeToScreen(mainIndexes4, secondryIndexes4);
    	 myClassObj.displayTreeToScreen(mainIndexes5, secondryIndexes5);
    	  
      }
}

