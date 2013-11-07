package com.example.encode;

import java.io.IOException;

import com.google.zxing.WriterException;
import com.google.zxing.client.androidGScannerFiles.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	GZxingEncoder Encoder;
	ImageView img;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Encoder = GZxingEncoder.getInstance();
		Encoder.initalize(MainActivity.this);
		img = (ImageView) findViewById(R.id.imageView1);
		Button btnscan = (Button) findViewById(R.id.btnScanButton);
		btnscan.setOnClickListener(this);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);
		findViewById(R.id.button4).setOnClickListener(this);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Toast.makeText(getApplicationContext(), "onActivityResult",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnScanButton:
			try {
				img.setImageBitmap(Encoder.generateBarCode_general("some text"));
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case R.id.button1:
			try {
				img.setImageBitmap(Encoder.generateQRCode_general("some text"));
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

//		case R.id.button2:
//			try {
//				Encoder.generateBarCode_general("some text", img);
//			} catch (WriterException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case R.id.button3:
//			try {
//				Encoder.generateBarCode_general("some text", img);
//			} catch (WriterException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
//		case R.id.button4:
//			try {
//				Encoder.generateBarCode_general("some text", img);
//			} catch (WriterException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			break;
		}
	}

}
