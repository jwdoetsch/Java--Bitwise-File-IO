package com.doetsch.io.unittest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.doetsch.io.bitwise.*;

public class UnitTest {
	
	public static void main (String[] args) {
		
		try {
			FileInputBitStream in = new FileInputBitStream(new File("test.txt"));
			FileOutputBitStream out = new FileOutputBitStream(new File("bar.txt"));
			int bit;
			int i = 0;
			
			while ((bit = in.readBit()) != -1) {
				if (i % 8 == 0) {
					System.out.print("\n");
				}
				i++;
				System.out.print(bit);
				out.writeBit(bit);
			}

			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
