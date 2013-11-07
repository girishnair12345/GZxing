/*
 Add these permissions to the Manifest file
 
  	<uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.FLASHLIGHT" />
    <uses-permission android:name="android.permission.READ_CONTACTS" />
    <uses-permission android:name="com.android.browser.permission.READ_HISTORY_BOOKMARKS" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
   
    <uses-feature android:name="android.hardware.camera"/>
  	<uses-feature android:name="android.hardware.camera.autofocus" android:required="false"/>
  	<uses-feature android:name="android.hardware.camera.flash" android:required="false"/>
  	<uses-feature android:name="android.hardware.screen.landscape"/>
  	<uses-feature android:name="android.hardware.wifi" android:required="false"/>
  	<uses-feature android:name="android.hardware.touchscreen" android:required="false"/>
    
AND
    
     <activity android:name="com.google.zxing.client.android.CaptureActivity"
              android:screenOrientation="landscape"
              android:clearTaskOnLaunch="true"
              android:stateNotNeeded="true"
              android:configChanges="orientation|keyboardHidden"
              android:theme="@android:style/Theme.NoTitleBar.Fullscreen"
              android:windowSoftInputMode="stateAlwaysHidden">
      <intent-filter>
	  
	  
EXTRA'S (optional)
        <action android:name="com.google.zxing.client.android.SCAN"/>
        <category android:name="android.intent.category.DEFAULT"/>
      </intent-filter>
      <!-- Allow web apps to launch Barcode Scanner by linking to http://zxing.appspot.com/scan. -->
      <intent-filter>
        <action android:name="android.intent.action.VIEW"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <category android:name="android.intent.category.BROWSABLE"/>
        <data android:scheme="http" android:host="zxing.appspot.com" android:path="/scan"/>
      </intent-filter>
      <!-- We also support a Google Product Search URL. -->
      <intent-filter>
        <action android:name="android.intent.action.VIEW"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <category android:name="android.intent.category.BROWSABLE"/>
        <data android:scheme="http" android:host="www.google.com" android:path="/m/products/scan"/>
      </intent-filter>
      <!-- And the UK version. -->
      <intent-filter>
        <action android:name="android.intent.action.VIEW"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <category android:name="android.intent.category.BROWSABLE"/>
        <data android:scheme="http" android:host="www.google.co.uk" android:path="/m/products/scan"/>
      </intent-filter>
      <!-- Support zxing://scan/?... like iPhone app -->
      <intent-filter>
        <action android:name="android.intent.action.VIEW"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <category android:name="android.intent.category.BROWSABLE"/>
        <data android:scheme="zxing" android:host="scan" android:path="/"/>
      </intent-filter>
    </activity>
    <activity android:name="com.google.zxing.client.android.PreferencesActivity"
              android:label="@string/preferences_name"
              android:stateNotNeeded="true">
    </activity>
    <activity android:name="com.google.zxing.client.android.encode.EncodeActivity"
              android:label="@string/share_name"
              android:stateNotNeeded="true">
      <intent-filter>
        <action android:name="com.google.zxing.client.android.ENCODE"/>
        <category android:name="android.intent.category.DEFAULT"/>
      </intent-filter>
      <!-- This allows us to handle the Share button in Contacts. -->
      <intent-filter>
        <action android:name="android.intent.action.SEND"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <data android:mimeType="text/x-vcard"/>
      </intent-filter>
      <!-- This allows us to handle sharing any plain text . -->
      <intent-filter>
        <action android:name="android.intent.action.SEND"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <data android:mimeType="text/plain"/>
      </intent-filter>
    </activity>
    <activity android:name="com.google.zxing.client.android.book.SearchBookContentsActivity"
              android:label="@string/sbc_name"
              android:stateNotNeeded="true"
              android:screenOrientation="landscape"
              android:configChanges="orientation|keyboardHidden">
      <intent-filter>
        <action android:name="com.google.zxing.client.android.SEARCH_BOOK_CONTENTS"/>
        <category android:name="android.intent.category.DEFAULT"/>
      </intent-filter>
    </activity>
    <activity android:name="com.google.zxing.client.android.share.ShareActivity"
              android:label="@string/share_name"
              android:stateNotNeeded="true"
              android:screenOrientation="user"
              android:theme="@android:style/Theme.Light">
      <intent-filter>
        <action android:name="com.google.zxing.client.android.SHARE"/>
        <category android:name="android.intent.category.DEFAULT"/>
      </intent-filter>
    </activity>
    <activity android:name="com.google.zxing.client.android.history.HistoryActivity"
              android:label="@string/history_title"
              android:stateNotNeeded="true">
      <intent-filter>
        <action android:name="android.intent.action.VIEW"/>
        <category android:name="android.intent.category.DEFAULT"/>
      </intent-filter>
    </activity>
    <activity android:name="com.google.zxing.client.android.share.BookmarkPickerActivity"
              android:label="@string/bookmark_picker_name"
              android:stateNotNeeded="true">
      <intent-filter>
        <action android:name="android.intent.action.PICK"/>
        <category android:name="android.intent.category.DEFAULT"/>
      </intent-filter>
    </activity>
    <activity android:name="com.google.zxing.client.android.share.AppPickerActivity"
              android:label="@string/app_picker_name"
              android:stateNotNeeded="true"
              android:configChanges="orientation">
      <intent-filter>
        <action android:name="android.intent.action.PICK"/>
        <category android:name="android.intent.category.DEFAULT"/>
      </intent-filter>
    </activity>
    <activity android:name="com.google.zxing.client.android.HelpActivity"
              android:screenOrientation="user">
      <intent-filter>
        <action android:name="android.intent.action.VIEW"/>
        <category android:name="android.intent.category.DEFAULT"/>
      </intent-filter>
    </activity>
 */

package com.example.zxing.sample;

import java.util.List;

import com.google.zxing.client.android.history.HistoryItem;
import com.google.zxing.client.androidGScannerFiles.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnScanCompleted{

	TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
	GZxingDecoder captureInstance;
	private static final String LOG_TAG = "MainActivityScanner";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.textView1);
        txt2 = (TextView) findViewById(R.id.textView2);
        txt3 = (TextView) findViewById(R.id.textView3);
        txt4 = (TextView) findViewById(R.id.textView4);
        txt5 = (TextView) findViewById(R.id.textView5);
        txt6 = (TextView) findViewById(R.id.textView6);
        txt7 = (TextView) findViewById(R.id.textView7);
        txt8 = (TextView) findViewById(R.id.textView8);
        
		// Get The instance
        // I have not initialized here because i may need this instance later in different codes
		captureInstance = GZxingDecoder.getInstance();
		
		// Initialize the Scanner
		// @param : ScannedActivity => This is needed for the interface
		// @param : Activity => The current activity
		// @param : AllowedCaptures => The number of captures allowed default is 1 if not initialized
		captureInstance.initlialize(MainActivity.this);
		
		// You can also assign the captures manually - 0 is for unlimited
		captureInstance.setAllowedCaptures(1);

		// Should sound be played while capture default is true
		captureInstance.setBeepSound(false);
		
		// Should phone be vibrated while capture default is false
		captureInstance.setVibratePhone(true);  
		
		// decode 1D codes default is true
		// captureInstance.setDecode1D(false);
		
		 //decode QR codes default is true
		 captureInstance.setDecodeQR(true);
		
		// decodeDataMatrix codes default is true
		// captureInstance.setDecodeDataMatrix(false);
		
		// copy to Clip board default is true
		// Use captureInstance.getDisplayContents() to access clip board contents
		// captureInstance.setCopyToClipboard(false); 
		
		
        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				captureInstance.StartCaptureActivity();
			}
		});
    }
    
    
	@Override
	public void onScanCompleted() {
		Toast.makeText(getApplicationContext(), "Scan Done", 35).show();
		txt1.setText("Format: " + captureInstance.getFormat());
		txt2.setText("Meta: " + captureInstance.getMetaText());
		txt3.setText("Time Now: " + captureInstance.getTimeNow());
		txt4.setText("Type: " + captureInstance.getType());
		txt5.setText("Display Contents: " + captureInstance.getDisplayContents());
		txt6.setText("Status: " + captureInstance.getStatusView());
		txt7.setText("Items Scanned: " + captureInstance.getHistoryList().size());
		txt6.setText("Captures: " + captureInstance.getAllowedCaptures());
		List<HistoryItem> item = captureInstance.getHistoryList();
		for(HistoryItem h : item){
			Log.d(LOG_TAG,"History" + h.getDisplayAndDetails());
			Log.d(LOG_TAG,"Result Text" + h.getResult().getText());
			Log.d(LOG_TAG,"Result TimeStamp" + h.getResult().getTimestamp());
			Log.d(LOG_TAG,"Result BarcodeFormat" + h.getResult().getBarcodeFormat());
		}
	}

 
}
