package recursion;

import java.io.File;

public class FindFile {
	
	public static boolean findFile( File file, String fileName) {
		

		
		if(file.isFile()) {
			System.out.println(file.getName());
			if(file.getName().equals(fileName)) {
				return true;
			}
		}
		if(file.isDirectory()) {
			  File[] files = file.listFiles();
	            if (files != null) {
	                for (File f : files) {
	                    if (findFile(f, fileName)) {
	                    	System.out.println("found the file "+ file.getName());
	                        return true;   // propagate success upward
	                    }
	                }
	            }
		}
			
			
			return false; 
		
	}

	public static void main(String[] args) {
		
		try {
			boolean found = findFile(new File("/Users/nirajkumar"), "Puri.pdf");
			System.out.println("Found: " + found);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
