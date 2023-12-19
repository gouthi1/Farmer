package com.marolix.dhalary.config;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.imageio.ImageIO;

import javax.imageio.ImageIO;

public class ImageUtility {

    public static byte[] compressImage(byte[] data) throws IOException {

    	BufferedImage originalImage = ImageIO.read(new File("path/to/original/image.jpg"));
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	try {
			ImageIO.write(originalImage, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	byte[] compressedBytes = baos.toByteArray();

        return baos.toByteArray();
    }

	

    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception exception) {
        }
    	
        return outputStream.toByteArray();
    }
}
