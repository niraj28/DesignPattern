package recursion;


import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

	public class FindFileQueue {

	    public static boolean findFile(File root, String fileName) {
	        if (root == null || !root.exists()) return false;

	        Deque<File> stack = new ArrayDeque<>();
	        stack.push(root);

	        while (!stack.isEmpty()) {
	            File current = stack.pop();

	            if (current.isFile()) {
	                System.out.println(current.getName());
	                if (current.getName().equalsIgnoreCase(fileName)) {
	                    System.out.println("Found at: " + current.getAbsolutePath());
	                    return true;
	                }
	            } else if (current.isDirectory()) {
	                File[] files = current.listFiles();
	                if (files == null) {
	                    // permission issue or unreadable directory
	                    continue;
	                }
	                for (File f : files) {
	                    stack.push(f);
	                }
	            }
	        }

	        return false;
	    }

	    public static void main(String[] args) {
	        boolean found = findFile(new File("/Users/nirajkumar"), "Puri.pdf");
	        System.out.println("Found: " + found);
	    }
	}

