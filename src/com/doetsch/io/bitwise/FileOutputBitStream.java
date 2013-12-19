package com.doetsch.io.bitwise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputBitStream extends the functionality
 * of FileInputStream by implementing the ability
 * to read file input streams by byte. It does
 * this by implementing an internal buffer
 * representing the bitwise representation of a
 * byte value;
 * 
 * @author Jacob Wesley Doetsch
 */
public class FileOutputBitStream extends FileOutputStream {
	private int representedByte;
	private int index;
	
	/**
	 * Instantiates a new FileOutputBitStream.
	 * @param f The file which to open and read from.
	 * @throws FileNotFoundException
	 */
	public FileOutputBitStream(File f) throws FileNotFoundException {
		super(f);
		representedByte = -1;
		index = 8;		
	}
	
	/**
	 * Writes a bit to the output stream.
	 * @param bit The bit to write. If the bit is
	 * > 0 then 1 is written, otherwise 0 is written.
	 * @throws IOException
	 */
	public void writeBit (int bit) throws IOException {
		if (index > 7) {
			if (representedByte > -1) {
				super.write(representedByte);
			}
			
			representedByte = 0;
			index = 0;
		}
		
		if (bit == 1) {
			representedByte += Math.pow(2, 7 - index);
			index++;
		
		} else {
			index++;
		}
	}
	
	/**
	 * Closes the output stream.
	 */
	@Override
	public void close () throws IOException {
		flush();
		super.close();
	}
	
	/**
	 * Flushes the output buffer, writing any unwritten
	 * bits.
	 */
	@Override
	public void flush () throws IOException {
		if (representedByte > -1) {
			super.write(representedByte);
		}
		
		super.flush();
	}

}
