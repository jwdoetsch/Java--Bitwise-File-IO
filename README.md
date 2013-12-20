#Java -- Bitwise File IO#

##com.doetsch.io.bitwise##

This Java package provides classes to assist in reading and writing individual bits from and to files.

###Contents###

This package contains two classes `FileInputBitStream` and `FileOutputBitStream`.

*   `FileInputBitStream` extends `java.util.FileInputStream` and implements functionality to enable the ability to read
individual bits from the file input stream.

*   `FileOutputBitStream` extends `java.util.FileOutputStream` and implements functionality to enable the ability to read individual bits from the file input stream.

###Usage###

####Download####

Download the repository .zip archive on the right nagivation-pane of this GitHub page.

####Installation & Configuration####

Extract the .zip and add the .jar from the `lib/` directory to your build path in your favorite Java IDE.
    
#####Eclipse#####
    
1. Select your project from the `Package Explorer` pane
2. From the menu bar, follow `Project > Properties > Java Build Path > Libraries` and select `Add External JARs...`
3. Navigate to the `lib/` directory of the extracted repository .zip, select `com.doetsch.io.bitwise.jar`, select `Open`

####Examples####

#####Reading bits from a file#####

    import com.doetsch.io.bitwise.FileInputBitStream;
    import java.util.File;
    
	class FileBitReader {
	    
	    public static void main (String[] args) {
	        int bit = 0;

	        try {
		        /* 
		         * FileInputBitStream operates like a FileInputStream.
		         * In fact, it extends FileInputStream and is constructed
		         * similarly.
		         */
		        FileInputBitStream in = new FileInputBitStream(new File("foo.txt"));
		        
		        /*
		         * Read bits from foo.txt until the end-of-file has
		         * been reached.
		         */
		        while ((bit = in.readBit()) != -1) {
		            System.out.print(bit);
		        }
		        
		        in.close();
		        
	        } catch (FileNotFoundException e) {
	        	e.printStackTrace();
	        	
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	      
	    }
	
	}



#####Writing bits to a file#####
    
    import com.doetsch.io.bitwise.FileOutputBitStream;
    import java.util.File;
	
	class FileBitWriter {
	    
	    public static void main (String[] args) {
	        int bit = 0;

	        try {
		        /* 
		         * FileOutputBitStream operates like a FileOutputBitStream.
		         * In fact, it extends FileOutputStream and is constructed
		         * similarly.
		         */
		        FileOutputBitStream out = new FileOutputBitStream(new File("bar.txt"));
		        
		        /*
		         * Writes the bit string 1000 0001 (129) to bar.txt.
		         */
		        out.writeBit(1);
		        out.writeBit(0);
		        out.writeBit(0);
		        out.writeBit(0);
		        out.writeBit(0);
		        out.writeBit(0);
		        out.writeBit(0);
		        out.writeBit(1);
		        
		        out.close();
		        
	        } catch (FileNotFoundException e) {
	        	e.printStackTrace();
	        	
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	      
	    }
	
	}

    
    
