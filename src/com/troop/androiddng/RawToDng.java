/**
  * Generated by smali2java 1.0.0.558
  * Copyright (C) 2013 Hensence.com
  */

package com.troop.androiddng;

import java.nio.ByteBuffer;
import com.android.camera.util.DeviceUtils;
import android.location.Location;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import android.util.Log;
import android.os.Build;

public class RawToDng {
    public static final int Qcom = 0x1;
    public static String RGGb = "rggb";
    private static final String TAG = RawToDng.class.getSimpleName();
    String bayerpattern;
    String filepath;
    private static final int getG3_rowSizeL = 0x1490;
    
    private static native ByteBuffer Create();
    
    
    private static native long GetRawBytesSize(ByteBuffer p1);
    
    
    private static native int GetRawHeight(ByteBuffer p1);
    
    
    private static native void Release(ByteBuffer p1);
    
    
    private static native void SetBayerData(ByteBuffer p1, byte[] p2, String p3);
    
    
    private static native void SetBayerInfo(ByteBuffer p1, float[] p2, float[] p3, float[] p4, float[] p5, float[] p6, float[] p7, float[] p8, float[] p9, int p10, String p11, int p12, String p13, int p14, int p15, int p16);
    
    
    private static native void SetExifData(ByteBuffer p1, int p2, double p3, int p4, float p5, float p6, String p7, String p8, double p9);
    
    
    private static native void SetGPSData(ByteBuffer p1, double p2, float[] p3, float[] p4, String p5, long p6);
    
    
    private static native void SetModelAndMake(ByteBuffer p1, String p2, String p3);
    
    
    private static native void SetRawHeight(ByteBuffer p1, int p2);
    
    
    private static native void SetThumbData(ByteBuffer p1, byte[] p2, int p3, int p4);
    
    
    private static native void WriteDNG(ByteBuffer p1);
    
    
    static {
        System.loadLibrary("RawToDng");
    }
    
    private static int Calculate_rowSize(int fileSize, int height) {
        return (fileSize / height);
    }
    private ByteBuffer nativeHandler = null;
    
    private RawToDng() {
        if(nativeHandler != null) {
            Release(nativeHandler);
            nativeHandler = null;
        }
        nativeHandler = Create();
    }
    
    public static RawToDng GetInstance() {
        return new RawToDng();
    }
    
    public long GetRawSize() {
        return GetRawBytesSize(nativeHandler);
    }
    
    public void SetGPSData(double Altitude, double Latitude, double Longitude, String Provider, long gpsTime) {
        Log.d(RawToDng.TAG, "Latitude:" + Latitude + "Longitude:" + Longitude);
        if (this.nativeHandler != null) {
            SetGPSData(this.nativeHandler, Altitude, this.parseGpsvalue(Latitude), this.parseGpsvalue(Longitude), Provider, gpsTime);
        }
    }

    public void setExifData(int iso, double expo, int flash, float fNum, float focalL, String imagedescription, String orientation, double exposureIndex) {
        if(nativeHandler != null) {
            SetExifData(nativeHandler, iso, expo, flash, fNum, focalL, imagedescription, orientation, exposureIndex);
        }
    }
    
    private float[] parseGpsvalue(double val) {
        String[] sec = Location.convert(val, 0x2).split(":");
        double dd = Double.parseDouble(sec[0x0]);
        double dm = Double.parseDouble(sec[0x1]);
        double ds = Double.parseDouble(sec[0x2].replace(",", "."));
        float[] Longitudear = {(float)dd,
        (float)dm,
        (float)ds};
        return Longitudear;
    }
    
    public void SetThumbData(byte[] mThumb, int widht, int height) {
        if(nativeHandler != null) {
            SetThumbData(nativeHandler, mThumb, widht, height);
        }
    }
    
    public void SetModelAndMake(String model, String make) {
        if(nativeHandler != null) {
            SetModelAndMake(nativeHandler, model, make);
        }
    }
    
    public void SetBayerData(byte[] fileBytes, String fileout) {
        filepath = fileout;
        if(filepath.contains("bayer")) {
            bayerpattern = filepath.substring((filepath.length() - 0x8), (filepath.length() - 0x4));
        }
        if(nativeHandler != null) {
            SetBayerData(nativeHandler, fileBytes, fileout);
        }
    }
    
    private void SetBayerInfo(float[] colorMatrix1, float[] colorMatrix2, float[] neutralColor, float[] fowardMatrix1, float[] fowardMatrix2, float[] reductionMatrix1, float[] reductionMatrix2, float[] noise, int blacklevel, String bayerformat, int rowSize, String devicename, int tight, int width, int height) {
        if(nativeHandler != null) {
            SetBayerInfo(nativeHandler, colorMatrix1, colorMatrix2, neutralColor, fowardMatrix1, fowardMatrix2, reductionMatrix1, reductionMatrix2, noise, blacklevel, bayerformat, rowSize, devicename, tight, width, height);
        }
    }
    
    public void RELEASE() {
        if(nativeHandler != null) {
            Release(nativeHandler);
            nativeHandler = null;
        }
    }
    
    private void setRawHeight(int height) {
        if(nativeHandler != null) {
            SetRawHeight(nativeHandler, height);
        }
    }
    
    private DngSupportedDevices.SupportedDevices getDevice() {
        if(DeviceUtils.isYureka()) {
            return DngSupportedDevices.SupportedDevices.yureka;
        }
        if(DeviceUtils.isLG_G3()) {
            return DngSupportedDevices.SupportedDevices.LG_G3;
        }
        if(DeviceUtils.isGioneE7()) {
            return DngSupportedDevices.SupportedDevices.Gione_E7;
        }
        if(DeviceUtils.isHTC_M8()) {
            return DngSupportedDevices.SupportedDevices.HTC_One_m8;
        }
        if(DeviceUtils.isHTC_M9()) {
            return DngSupportedDevices.SupportedDevices.HTC_One_m9;
        }
        if(DeviceUtils.isHtc_One_SV()) {
            return DngSupportedDevices.SupportedDevices.HTC_One_Sv;
        }
        if(DeviceUtils.isHtc_One_XL()) {
            return DngSupportedDevices.SupportedDevices.HTC_One_XL;
        }
        if(DeviceUtils.isLenovoK910()) {
            return DngSupportedDevices.SupportedDevices.Lenovo_k910;
        }
        if(DeviceUtils.isG2()) {
            return DngSupportedDevices.SupportedDevices.LG_G2;
        }
        if(DeviceUtils.hasIMX135()) {
            return DngSupportedDevices.SupportedDevices.zteAdv;
        }
        if(DeviceUtils.isXperiaL()) {
            return DngSupportedDevices.SupportedDevices.Sony_XperiaL;
        }
        if(DeviceUtils.hasIMX214()) {
            return DngSupportedDevices.SupportedDevices.OnePlusOne;
        }
        if(DeviceUtils.isRedmiNote()) {
            return DngSupportedDevices.SupportedDevices.Xiaomi_Redmi_Note;
        }
        if(DeviceUtils.isXiaomiMI3W()) {
            return DngSupportedDevices.SupportedDevices.Xiaomi_mi3;
        }
        if(DeviceUtils.isMeizuMX4()) {
            return DngSupportedDevices.SupportedDevices.Meizu_Mx4;
        }
        if(DeviceUtils.isTHL5000()) {
            return DngSupportedDevices.SupportedDevices.THL5000;
        }
        if(DeviceUtils.isXiaomiMI_Note_Pro()) {
            return DngSupportedDevices.SupportedDevices.Xiaomi_mi_note_pro;
        }
        if(DeviceUtils.isAlcatel_Idol3()) {
            return DngSupportedDevices.SupportedDevices.Alcatel_Idol3;
        }
        return null;
    }
    
    public void WriteDNG(DngSupportedDevices.SupportedDevices device) {
        DngSupportedDevices.SupportedDevices devices = device;
        if(device == null) {
            devices = getDevice();
        } else {
            devices = device;
        }
        if(devices != null) {
            DngSupportedDevices.DngProfile profile = new DngSupportedDevices().getProfile(devices, (int)GetRawSize());
            if (profile == null)
            {
                RELEASE();
                return;
            }
            SetModelAndMake(Build.MODEL, Build.MANUFACTURER);
            //SetBayerInfo(this, this, this, this, this, this, this, this, this, this, this, Build.MODEL, this, this, this);
            SetBayerInfo(profile.matrix1, profile.matrix2, profile.neutral,profile.fowardmatrix1,profile.fowardmatrix2,profile.reductionmatrix1,profile.reductionmatrix2,profile.noiseprofile,profile.blacklevel, profile.BayerPattern, profile.rowsize, Build.MODEL,profile.rawType,profile.widht,profile.height);
            WriteDNG(nativeHandler);
            RELEASE();
        }
    }
    
    public static byte[] readFile(File file) throws IOException {
        RandomAccessFile f = new RandomAccessFile(file, "r");
        try {
          long longlength = f.length();
          int length = (int)longlength;
          if (length != longlength)
              throw new IOException("File size >= 2 GB");
          byte[] data = new byte[length];
          f.readFully(data);
          return data;
        } finally {
          f.close();
        }
    }
}
