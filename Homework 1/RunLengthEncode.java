
package runlengthencode;


public class RunLengthEncode {
	
	
	
	public String encode(String s) {
		
		int count=1;
		char lastchar=' ';
		boolean repeat=true; 
		String newString="";
		String tmpString="";
		
		s = s+' ';
		
		
		for(int i=0;i< s.length()-1;i++) {
			
			
			tmpString = tmpString + s.charAt(i);
			lastchar = s.charAt(i);
			if(s.charAt(i)== s.charAt(i+1)) {
				
				count++;
				repeat=true;
				
			}else {
				
				
				
				
					if(count>=5) {
						
						
						
						
						newString = newString + "/0" + count+lastchar;
						tmpString ="";
					}else {
						
						newString = newString + tmpString;
					}
				
				count=1;
				repeat=false;
				tmpString="";
			}
			
		}
		
		
		
		
		newString = newString + tmpString;
		
		return newString;
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		RunLengthEncode r=new RunLengthEncode();
		
		
	
		
		String a="aaaaa";
		String b="aaaa";
		String c="abcabcabcabcabc";
		String d ="if(a) {if(b) {if(c) {if(d) {if(e) {5 deeeeeeep}}}}}";
		String e="";
		
		
		System.out.println(r.encode(a));
		System.out.println(r.encode(b));
		System.out.println(r.encode(c));
		System.out.println(r.encode(d));
		System.out.println(r.encode(e));
		
		
		
	}
	
	
	
	}