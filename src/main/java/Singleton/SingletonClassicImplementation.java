package Singleton;

public class SingletonClassicImplementation {

	 private static SingletonClassicImplementation obj;
	 
	    // private constructor to force use of
	    // getInstance() to create Singleton object
	    private SingletonClassicImplementation() {}
	 
	    public static SingletonClassicImplementation getInstance()
	    {
	        if (obj==null)
	            obj = new SingletonClassicImplementation();
	        return obj;
	    }
	    
	    public static void main(String args[]){
	    
       int arr[] = {5,4,8,6,9,5,0};
       
	   int result[]=new int[6]; 
//	   int j=0;
	   int max=-1;
	   for(int i=0;i<arr.length-1;i++) {
		  if(arr[i]>arr[i+1]) {
			  int temp=arr[i+1];
			  arr[i+1]=arr[i];
		  }
	   }
	   for(int i=0;i<arr.length-1;i++) {
	    System.out.println(arr[i]);
	   }
	    }
	    
}

/*	    String s= "aaaddDDeeeeeffFF";
int counter=0;
char c='\0';
String result="";
boolean check=false;

for(int i=0;i<s.length()-1;i++) {
	
	if(s.charAt(i)==s.charAt(i+1)) {
		counter++;
		check=true;
		c=s.charAt(i);
	}
	else {
		counter=counter+1;
    	result=result+""+s.charAt(i)+counter;
    	counter=0;
	}
	
}
if(check) {
	counter=counter+1;
	result=result+""+c+counter;
}
System.out.println(result); */






