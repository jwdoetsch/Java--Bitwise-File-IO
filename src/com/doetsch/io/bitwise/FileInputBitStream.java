package com.doetsch.io.bitwise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputBitStream extends the functionality
 * of FileInputStream by implementing the ability
 * to read file input streams by bits. It does
 * this by implementing an internal buffer
 * representing the bitwise representation of a
 * byte value.
 * 
 * @author Jacob Wesley Doetsch
 */
public class FileInputBitStream extends FileInputStream {
	private int representedByte;
	private int index;	
	
	/**
	 * Instantiates a new FileInputBitStream
	 * @param f The file which to open and read from.
	 * @throws FileNotFoundException
	 */
	public FileInputBitStream(File f) throws FileNotFoundException {
		super(f);
		representedByte = 0;
		index = 8;
	}
	
	/**
	 * Returns the next bit in the input stream.
	 * @return The next bit, 1 or 0, in the input
	 * stream. Returns -1 if end-of-file has been
	 * reached. 
	 * @throws IOException 
	 */
	public int readBit () throws IOException {
		if (index > 7){
			representedByte = super.read();
			index = 0;
		}
		
		if (representedByte == -1) {
			return -1;
		}
		
		if (representedByte - Math.pow(2, 7 - index) >= 0) {
			representedByte -= Math.pow(2, 7 - index);
			index++;
			return 1;
			
		} else {
			index++;
			return 0;
		}
	}
	
	/**
	 * @see java.io.FileInputStream#read()
	 */
	public int read () throws IOException {
		int returnByte = 0;
		int bit = 0;
		for (int i = 0; i < 8; i++) {
			bit = readBit();
			
			if (bit == -1) {
				return -1;
			
			} else if (bit == 1) {
				returnByte += Math.pow(2, 7 - i);
			
			} else {
				
			}
		}
		
		return returnByte;
	}
	
}
