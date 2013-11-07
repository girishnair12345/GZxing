package com.google.zxing.client.android;

import com.google.zxing.client.android.R;
import com.google.zxing.client.android.R.id;
import com.google.zxing.client.android.R.layout;
import com.google.zxing.client.androidGScannerFiles.GZxingDecoder;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MyBarcodeScanner extends Activity implements com.google.zxing.client.androidGScannerFiles.OnScanCompleted{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mybarcodereader);
		
		Button btnScan = (Button) findViewById(R.id.btnMyScanner);
		btnScan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				GZxingDecoder.getInstance().initlialize(MyBarcodeScanner.this,1);
				GZxingDecoder.getInstance().StartCaptureActivity();
			}
		});
	}

	@Override
	public void onScanCompleted() {
		Toast.makeText(getApplicationContext(), "HA HA HA HA", 35).show();
	}

	


}
