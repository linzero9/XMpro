package com.gotop.timeMachine.service.impl;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

public class ImageSize {

	/**
	 * @desc 压缩文件
	 * @author wujiajun
	 * @param 原始文件     处理过后的文件
	 */
	public static boolean compressPic(String srcFilePath, String descFilePath)
			throws IOException {
		File file = null;
		BufferedImage src = null;
		FileOutputStream out = null;
		ImageWriter imgWrier;
		ImageWriteParam imgWriteParams;

		imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
		imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(
				null);

		imgWriteParams.setCompressionMode(imgWriteParams.MODE_EXPLICIT);
		//啊祥  压缩的力度  调节这个参数即可 ！！！！！
		imgWriteParams.setCompressionQuality((float) 0.3);
		imgWriteParams.setProgressiveMode(imgWriteParams.MODE_DISABLED);
		ColorModel colorModel = ImageIO.read(new File(srcFilePath))
				.getColorModel();
		imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(
				colorModel, colorModel.createCompatibleSampleModel(16, 16)));

		try {
			if (isBlank(srcFilePath)) {
				return false;
			} else {
				file = new File(srcFilePath);
				System.out.println(file.length());
				src = ImageIO.read(file);
				out = new FileOutputStream(descFilePath);

				imgWrier.reset();

				imgWrier.setOutput(ImageIO.createImageOutputStream(out));

				imgWrier.write(null, new IIOImage(src, null, null),
						imgWriteParams);
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean isBlank(String string) {
		if (string == null || string.length() == 0 || string.trim().equals("")) {
			return true;
		}
		return false;
	}
    //已经完成测试！
	public static void main(String[] args) {

		try {
			compressPic("D:\\8888888\\1.JPG", "D:\\8888888\\2.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
