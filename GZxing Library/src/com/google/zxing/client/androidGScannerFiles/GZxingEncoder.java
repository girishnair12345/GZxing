package com.google.zxing.client.androidGScannerFiles;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.pdf417.encoder.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;

public class GZxingEncoder {
	
	private static GZxingEncoder instance;
	private Activity activity;
	private Bitmap ImageBitmap;
	private String characterEncoding = "ISO-8859-1";
	private int bitmapHeight =250 ,bitmapWidth= 250;

	private GZxingEncoder(){}
	
	public static GZxingEncoder getInstance(){
		if(instance == null)
			instance = new GZxingEncoder();
		return instance;
	}
	
	public void initalize(Activity activity){
		this.activity = activity;
	}
	

	public int getBitmapHeight() {
		return bitmapHeight;
	}

	public void setBitmapHeight(int bitmapHeight) {
		this.bitmapHeight = bitmapHeight;
	}

	public int getBitmapWidth() {
		return bitmapWidth;
	}

	public void setBitmapWidth(int bitmapWidth) {
		this.bitmapWidth = bitmapWidth;
	}

	public Bitmap getImageBitmap() {
		return ImageBitmap;
	}

	public void setImageBitmap(Bitmap imageBitmap) {
		ImageBitmap = imageBitmap;
	}

	public void setBitmap_Width_Height(int width, int height){
		bitmapWidth = width;
		bitmapHeight = height;
	}
	
	public String getCharacterEncoding() {
		return characterEncoding;
	}

	public void setCharacterEncoding(String characterEncoding) {
		this.characterEncoding = characterEncoding;
	}
	
	
	
	public Bitmap generateQRCode_general(String data)throws WriterException {
		com.google.zxing.Writer writer = new QRCodeWriter();
		String finaldata = Uri.encode(data, characterEncoding);

		BitMatrix bm = writer.encode(finaldata, BarcodeFormat.QR_CODE,bitmapWidth, bitmapHeight);
		ImageBitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight,Config.ARGB_8888);
		
		for (int i = 0; i < bitmapWidth; i++) {
			for (int j = 0; j < bitmapHeight; j++) {
				ImageBitmap.setPixel(i, j, bm.get(i, j) ? Color.BLACK: Color.WHITE);
			}
		}

		return ImageBitmap;
	}
	
	public Bitmap generateBarCode_general(String data) throws WriterException{
		com.google.zxing.Writer c9 = new Code128Writer();	
		BitMatrix bm = c9.encode(data,BarcodeFormat.CODE_128,bitmapWidth, bitmapHeight);
		ImageBitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Config.ARGB_8888);
		
		for (int i = 0; i < bitmapWidth; i++) {
			for (int j = 0; j < bitmapHeight; j++) {
				
				ImageBitmap.setPixel(i, j, bm.get(i, j) ? Color.BLACK : Color.WHITE);
			}
		}

	return ImageBitmap;
}
	
	public Bitmap generate_EAN_8(String data, Map<EncodeHintType,?> hints) throws WriterException {
		return generateXXXcode(data,BarcodeFormat.EAN_8,hints);
	}
	public Bitmap generate_EAN_13(String data, Map<EncodeHintType,?> hints) throws WriterException {
		return generateXXXcode(data,BarcodeFormat.EAN_13,hints);
	}
	public Bitmap generate_UPC_A(String data, Map<EncodeHintType,?> hints) throws WriterException {
		return generateXXXcode(data,BarcodeFormat.UPC_A,hints);
	}
	public Bitmap generate_QR_CODE(String data, Map<EncodeHintType,?> hints) throws WriterException {
		return generateXXXcode(data,BarcodeFormat.QR_CODE,hints);
	}
	public Bitmap generate_CODE_39(String data, Map<EncodeHintType,?> hints) throws WriterException {
		return generateXXXcode(data,BarcodeFormat.CODE_39,hints);
	}
	public Bitmap generate_CODE_128(String data, Map<EncodeHintType,?> hints) throws WriterException {
		return generateXXXcode(data,BarcodeFormat.CODE_128,hints);
	}
	public Bitmap generate_ITF(String data, Map<EncodeHintType,?> hints) throws WriterException {
		return generateXXXcode(data,BarcodeFormat.ITF,hints);
	}
	public Bitmap generate_PDF_417(String data, Map<EncodeHintType,?> hints) throws WriterException {
		return generateXXXcode(data,BarcodeFormat.PDF_417,hints);
	}
	public Bitmap generate_CODABAR(String data, Map<EncodeHintType,?> hints) throws WriterException {
		return generateXXXcode(data,BarcodeFormat.CODABAR,hints);
	}
	
	
	private Bitmap generateXXXcode(String data, BarcodeFormat mBarcodeFormat, Map<EncodeHintType,?> hints) throws WriterException{
		com.google.zxing.Writer writer = null;
		
		if(mBarcodeFormat.toString().equals(BarcodeFormat.EAN_8.toString())){
			writer = new EAN8Writer();
		}else if(mBarcodeFormat.toString().equals(BarcodeFormat.EAN_13.toString())){
			writer = new EAN13Writer();	
		}else if(mBarcodeFormat.toString().equals(BarcodeFormat.UPC_A.toString())){
			writer = new UPCAWriter();
		}else if(mBarcodeFormat.toString().equals(BarcodeFormat.QR_CODE.toString())){
			writer = new QRCodeWriter();
		}else if(mBarcodeFormat.toString().equals(BarcodeFormat.CODE_39.toString())){
			writer = new Code39Writer();
		}else if(mBarcodeFormat.toString().equals(BarcodeFormat.CODE_128.toString())){
			writer = new Code128Writer();
		}else if(mBarcodeFormat.toString().equals(BarcodeFormat.ITF.toString())){
			writer = new ITFWriter();	
		}else if(mBarcodeFormat.toString().equals(BarcodeFormat.PDF_417.toString())){
			writer = new PDF417Writer();	
		}else if(mBarcodeFormat.toString().equals(BarcodeFormat.CODABAR.toString())){
			writer = new CodaBarWriter();
		}else{
			 throw new IllegalArgumentException("No encoder available for format => " + mBarcodeFormat.toString());
		}
		
		String finaldata = Uri.encode(data, characterEncoding);
		BitMatrix bm = writer.encode(finaldata, mBarcodeFormat, bitmapWidth,bitmapHeight);
		ImageBitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight,Config.ARGB_8888);
		
		for (int i = 0; i < bitmapWidth; i++) {
			for (int j = 0; j < bitmapHeight; j++) {
				ImageBitmap.setPixel(i, j, bm.get(i, j) ? Color.BLACK: Color.WHITE);
			}
		}

		return ImageBitmap;
	}
	
	public void saveFileToCard_JPEG(String FilePath,String FileName) throws IOException{
		//create a file to write bitmap data
		File f = new File(FilePath, FileName+".jpeg");
		f.createNewFile();
		
		//Convert bitmap to byte array
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageBitmap.compress(CompressFormat.JPEG, 100, bos);
		byte[] bytearray = bos.toByteArray();
		
		//Write bytes in file
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(bytearray);
		fos.flush();
		fos.close();
	}
	
	public void saveFileToCard_PNG(String FilePath,String FileName) throws IOException{
		//create a file to write bitmap data
		File f = new File(FilePath, FileName+".png");
		f.createNewFile();
		
		//Convert bitmap to byte array
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageBitmap.compress(CompressFormat.PNG, 0, bos);
		byte[] bytearray = bos.toByteArray();
		
		//Write bytes in file
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(bytearray);
		fos.flush();
		fos.close();
	}
}
