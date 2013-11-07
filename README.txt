This project is based on Zxing bar code library for android
This simplifies the usage of Zxing library

Right click on your project and GZxing Library to your project to use it

Scanning Barcode
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
	
	
Add this activity also
     <activity android:name="com.google.zxing.client.android.CaptureActivity"
              android:screenOrientation="landscape"
              android:clearTaskOnLaunch="true"
              android:stateNotNeeded="true"
              android:configChanges="orientation|keyboardHidden"
              android:theme="@android:style/Theme.NoTitleBar.Fullscreen"
              android:windowSoftInputMode="stateAlwaysHidden">
			  

Create an instance
	GZxingDecoder captureInstance = GZxingDecoder.getInstance();
	// Initialize the Scanner
	// @param : ScannedActivity => This is needed for the interface
	// @param : Activity => The current activity
	// @param : AllowedCaptures => The number of captures allowed default is 1 if not initialized
	captureInstance.initlialize(MainActivity.this);
	//Number of captures to be taken
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
	
Now to scan the barcode by using
captureInstance.StartCaptureActivity();

Now to get the result you must implement the OnScanCompleted interface
Now you can access the details
captureInstance.getFormat()
captureInstance.getType()
captureInstance.getMetaText()
etc

To Create a barcode
Get the instance
GZxingEncoder 	Encoder = GZxingEncoder.getInstance();
Encoder.initalize(this);

To generate bar code use this
Bitmap bitmap = Encoder.generateBarCode_general("some text")
for more specific types of bar codes use
generate_EAN_8 , generate_EAN_13, generate_QR_CODE, generate_CODABAR, etc

You can aslo save the file as JPEG or PNG using the methods
saveFileToCard_JPEG() and saveFileToCard_PNG