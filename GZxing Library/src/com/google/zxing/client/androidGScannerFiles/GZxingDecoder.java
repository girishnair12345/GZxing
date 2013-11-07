package com.google.zxing.client.androidGScannerFiles;

import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.PreferencesActivity;
import com.google.zxing.client.android.history.HistoryItem;
import com.google.zxing.client.android.history.HistoryManager;


public class GZxingDecoder {
	private static GZxingDecoder instance;
	private Bitmap scannedImage;
	private String Format;
	private String Type;
	private Date date;
	private String TimeNow;
	private boolean MetaTextAvailable = false;
	private String MetaTex;
	private String DisplayContents;
	private Activity activity;
	//Number if captures allowed 0 for unlimited capture
	private int AllowedCaptures = 1;
	private OnScanCompleted Interfacescan;
	private boolean isScanCompletedInterfaceImplemented = false;
	private String statusView;
	
	//Settings
	private boolean beepSound;
	private boolean vibratePhone;
	private boolean decode1D;
	private boolean decodeQR;
	private boolean decodeDataMatrix;
	private boolean copyToClipboard;
	//private boolean isMenuEnabled ;
	private boolean isShopperButtonAvailable;
	
	SharedPreferences prefs;
	SharedPreferences.Editor editor;
	//SharedPreferences.Editor editor = prefs.edit();

	private GZxingDecoder(){
		//Singleton
	}
	
	public void initlialize(Activity activity){
		this.activity = activity;
		prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		editor = prefs.edit();
	}
	
	public void initlialize(Activity activity, int AllowedCaptures){
		
		this.activity = activity;
		this.AllowedCaptures = AllowedCaptures;
		prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		editor = prefs.edit();
	}
	
	public void StartCaptureActivity(){
		this.activity.startActivity(new Intent(this.activity,CaptureActivity.class));
	}
	
	public static GZxingDecoder getInstance(){
		if(instance == null)
			instance = new GZxingDecoder();
		return instance;
	}
	
	public int getAllowedCaptures() {
		return AllowedCaptures;
	}

	public void setAllowedCaptures(int allowedCaptures) {
		AllowedCaptures = allowedCaptures;
	}
	
	public Bitmap getScannedImage(){
		return scannedImage;
	}
	
	public void setScannedImage(Bitmap b){
		scannedImage = b;
	}
	
	public String getFormat() {
		return Format;
	}
	
	public void setFormat(String format) {
		Format = format;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTimeNow() {
		return TimeNow;
	}

	public void setTimeNow(String timeNow) {
		TimeNow = timeNow;
	}

	public boolean isMetaTextAvailable() {
		return MetaTextAvailable;
	}

	public void setMetaTextAvailable(boolean metaTextAvailable) {
		MetaTextAvailable = metaTextAvailable;
	}

	public String getMetaText() {
		return MetaTex;
	}

	public void setMetaText(String metaTex) {
		MetaTex = metaTex;
	}
	
	public String getDisplayContents() {
		return DisplayContents;
	}

	public void setDisplayContents(String displayContents) {
		DisplayContents = displayContents;
	}
	
	public void onScanCompletedListener(OnScanCompleted mScanCompleted){
		Interfacescan = mScanCompleted;
		isScanCompletedInterfaceImplemented = true;
	}
	
	public String getStatusView() {
		return statusView;
	}

	public void setStatusView(String statusView) {
		this.statusView = statusView;
	}
	
	public void onScanCompleted(){
		if(isScanCompletedInterfaceImplemented)
			Interfacescan.onScanCompleted();
	}
	
	public List<HistoryItem> getHistoryList(){
		return new HistoryManager(activity).buildHistoryItems();
	}
	
	public HistoryItem getHistoryItem(int number){
		return new HistoryManager(activity).buildHistoryItem(number);
	}
	
	//Settings
	public boolean isBeepSound() {
		beepSound = prefs.getBoolean(PreferencesActivity.KEY_PLAY_BEEP, true);
		return beepSound;
	}

	public void setBeepSound(boolean beepSound) {
		editor.putBoolean(PreferencesActivity.KEY_PLAY_BEEP, beepSound);
		editor.commit();
		this.beepSound = beepSound;
	}

	public boolean isVibratePhone() {
		vibratePhone = prefs.getBoolean(PreferencesActivity.KEY_VIBRATE, false);
		return vibratePhone;
	}

	public void setVibratePhone(boolean vibratePhone) {
		editor.putBoolean(PreferencesActivity.KEY_VIBRATE, vibratePhone);
		editor.commit();
		this.vibratePhone = vibratePhone;
	}
	
	public boolean isDecode1D() {
		decode1D = prefs.getBoolean(PreferencesActivity.KEY_DECODE_1D, true);
		return decode1D;
	}

	public void setDecode1D(boolean decode1d) {
		editor.putBoolean(PreferencesActivity.KEY_DECODE_1D, decode1d);
		editor.commit();
		this.decode1D = decode1d;
	}

	public boolean isDecodeQR() {
		decodeQR = prefs.getBoolean(PreferencesActivity.KEY_DECODE_QR, true);
		return decodeQR;
	}

	public void setDecodeQR(boolean decodeQR) {
		editor.putBoolean(PreferencesActivity.KEY_DECODE_QR, decodeQR);
		editor.commit();
		this.decodeQR = decodeQR;
	}

	public boolean isDecodeDataMatrix() {
		decodeDataMatrix = prefs.getBoolean(PreferencesActivity.KEY_DECODE_DATA_MATRIX, true);
		return decodeDataMatrix;
	}

	public void setDecodeDataMatrix(boolean decodeDataMatrix) {
		editor.putBoolean(PreferencesActivity.KEY_DECODE_DATA_MATRIX, decodeDataMatrix);
		editor.commit();
		this.decodeDataMatrix = decodeDataMatrix;
	}
	
	public boolean isCopyToClipboard() {
		copyToClipboard = prefs.getBoolean(PreferencesActivity.KEY_COPY_TO_CLIPBOARD, true);
		return copyToClipboard;
	}

	public void setCopyToClipboard(boolean copyToClipboard) {
		editor.putBoolean(PreferencesActivity.KEY_DECODE_DATA_MATRIX, copyToClipboard);
		editor.commit();
		this.copyToClipboard = copyToClipboard;
	}
	
	
	public boolean isShopperButtonAvailable() {
		return isShopperButtonAvailable;
	}

	public void setShopperButtonAvailable(boolean isShopperButtonAvailable) {
		this.isShopperButtonAvailable = isShopperButtonAvailable;
	}

}
