package com.tencent.mm.sdk.platformtools;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager.AssetInputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Process;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.wcdb.FileUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class MMBitmapFactory {
    public static final int DECODER_ID_MMJPEG_DECODER = 2;
    public static final int DECODER_ID_MMPNG_DECODER = 0;
    public static final int DECODER_ID_MMVCODEC_DECODER = 1;
    private static final Config DEFAULT_BITMAP_CONFIG = Config.ARGB_8888;
    private static final int DEFAULT_CHECK_STORAGE_SIZE = 8192;
    private static final int DEFAULT_DECODE_MARK_SIZE = 8388608;
    private static final int DEFAULT_DECODE_STORAGE_SIZE = 8192;
    public static final int DEFAULT_DECODE_STRATEGY = 1;
    public static final int ERROR_ALLOCATE_STRUCT_FAILED = 1001;
    public static final int ERROR_BEGIN_SAMPLE_FAILED = 1004;
    public static final int ERROR_GET_PIXEL_FORMAT_FAILED = 1003;
    public static final int ERROR_ILLEGAL_IDATA_CHUNK = 2003;
    public static final int ERROR_ILLEGAL_IMAGE_SIZE = 1008;
    public static final int ERROR_ILLEGAL_NPTC_CHUNK = 2002;
    public static final int ERROR_IMAGE_SIZE_IS_TOO_LARGE = 1007;
    public static final int ERROR_IMG_BUG_DETECTED_BEGIN = 2000;
    public static final int ERROR_IO_FAILED = 1005;
    public static final int ERROR_LOCK_BITMAP_FAILED = 1002;
    public static final int ERROR_PNG_BUG_DETECTED_BEGIN = 2001;
    public static final int ERROR_SUCCESS = 0;
    public static final int ERROR_UNSUPPORT_IMAGE_FORMAT = 1006;
    private static final int ERROR_USER_DEFINED_BEGIN = 3000;
    public static final int STRATEGY_AUTO_DETECT = 0;
    public static final int STRATEGY_FORCE_SYSTEM_DECODER = 1;
    private static final String TAG = "MicroMsg.MMBitmapFactory";
    private static boolean mIsInit = false;
    static Method mMthGetDefaultDensity = null;

    public static class DecodeResultLogger {
        private int mDecodeResultCode;
        private String mDecoderTag = null;
        private boolean mIsDecodeByMMDecoder;

        public DecodeResultLogger() {
            clear();
        }

        private void fillerForNative(int i, boolean z, String str) {
            this.mDecodeResultCode = i;
            this.mIsDecodeByMMDecoder = z;
            if (str == null || str.length() == 0) {
                str = "System";
            }
            this.mDecoderTag = str;
        }

        public int getDecodeResult() {
            return this.mDecodeResultCode;
        }

        public void setDecodeResult(int i) {
            this.mDecodeResultCode = i;
        }

        public boolean isDecodeByMMDecoder() {
            return this.mIsDecodeByMMDecoder;
        }

        public String getDecoderTag() {
            return this.mDecoderTag;
        }

        public void clear() {
            this.mDecodeResultCode = 0;
            this.mIsDecodeByMMDecoder = false;
            this.mDecoderTag = "System";
        }

        public String toLogString() {
            return this.mDecodeResultCode + "," + this.mIsDecodeByMMDecoder + "," + this.mDecoderTag + "," + "-";
        }

        public String toString() {
            return "{" + this.mDecodeResultCode + "," + this.mIsDecodeByMMDecoder + "," + this.mDecoderTag + "}";
        }
    }

    private static class DynamicConfigStorage {
        public static String PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY = "pref_key_is_enable_MMBitmapFactory";
        private static final String PREF_NAME = "pref_MMBitmapFactory_dyncfg";
        private static SharedPreferences mPref = an.bh(ad.getContext(), PREF_NAME);

        private DynamicConfigStorage() {
        }

        private static void reload() {
            mPref = an.bh(ad.getContext(), PREF_NAME);
        }

        public static boolean getValue(String str, boolean z) {
            reload();
            if (mPref == null) {
                x.w(MMBitmapFactory.TAG, "SharedPreferences in DynamicConfigStorage initialize failed.");
                return z;
            }
            x.d(MMBitmapFactory.TAG, "DynamicConfigStorage, getValue:%b", Boolean.valueOf(mPref.getBoolean(str, z)));
            return mPref.getBoolean(str, z);
        }

        public static void setValue(String str, boolean z) {
            if (mPref == null) {
                x.w(MMBitmapFactory.TAG, "SharedPreferences in DynamicConfigStorage initialize failed.");
                return;
            }
            Editor edit = mPref.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public static class HEVCKVStatHelper {
        private static final String KVSTAT_STRING_SEPERATOR = ",";
        public static final int SCENE_SNS = 0;
        private static final long STAT_INTERVAL = 60000;
        private static long mLastStatTick = 0;

        public static boolean isTimeToStat() {
            long Wz = bi.Wz();
            if (Wz - mLastStatTick <= STAT_INTERVAL) {
                return false;
            }
            mLastStatTick = Wz;
            return true;
        }

        public static String getKVStatString(Object obj, int i, long j, Options options, DecodeResultLogger decodeResultLogger) {
            StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
            long j2 = -1;
            if (obj instanceof File) {
                File file = (File) obj;
                if (file.exists() && file.isFile()) {
                    j2 = file.length();
                }
            } else if (obj instanceof String) {
                String str = (String) obj;
                if (FileOp.bO(str)) {
                    j2 = FileOp.mi(str);
                }
            } else if (obj instanceof byte[]) {
                j2 = (long) ((byte[]) obj).length;
            }
            stringBuilder.append(i).append(KVSTAT_STRING_SEPERATOR).append(decodeResultLogger.mDecodeResultCode).append(KVSTAT_STRING_SEPERATOR).append(j2).append(KVSTAT_STRING_SEPERATOR).append(j).append(KVSTAT_STRING_SEPERATOR).append(bi.oM(options.outMimeType));
            return stringBuilder.toString();
        }
    }

    public static class KVStatHelper {
        private static final String KVSTAT_STRING_SEPERATOR = ",";
        public static final int MMBMPFACTORY_SCENE_ADDTOFAV = 5;
        public static final int MMBMPFACTORY_SCENE_APPMSG_DECODE = 9;
        public static final int MMBMPFACTORY_SCENE_APPMSG_TRANS = 6;
        public static final int MMBMPFACTORY_SCENE_GALLERY_BROWSE = 1;
        public static final int MMBMPFACTORY_SCENE_GET_MSGIMG = 2;
        public static final int MMBMPFACTORY_SCENE_IMGMSG_TRANS = 7;
        public static final int MMBMPFACTORY_SCENE_NONE = 0;
        public static final int MMBMPFACTORY_SCENE_OTHERS = 8;
        public static final int MMBMPFACTORY_SCENE_SHAREIMG = 3;
        public static final int MMBMPFACTORY_SCENE_SHARE_TO_TIMELINE = 4;
        public static final int MMBMPFACTORY_SCENE_SNS_IMGRECV = 10;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.String getKVStatString(java.lang.Object r9, int r10, com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger r11) {
            /*
            r5 = new java.lang.StringBuilder;
            r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            r5.<init>(r0);
            r1 = "";
            r2 = -1;
            r0 = r9 instanceof java.io.File;
            if (r0 == 0) goto L_0x005a;
        L_0x0010:
            r9 = (java.io.File) r9;
            r0 = r9.exists();
            if (r0 == 0) goto L_0x00a9;
        L_0x0018:
            r0 = r9.isFile();
            if (r0 == 0) goto L_0x00a9;
        L_0x001e:
            r0 = com.tencent.mm.a.g.i(r9);
            r2 = com.tencent.mm.sdk.platformtools.bi.oM(r0);
            r0 = r9.length();
        L_0x002a:
            r7 = r0;
            r1 = r2;
            r2 = r7;
        L_0x002d:
            r0 = r5.append(r10);
            r4 = ",";
            r0 = r0.append(r4);
            r4 = r11.mDecodeResultCode;
            r0 = r0.append(r4);
            r4 = ",";
            r0 = r0.append(r4);
            r0 = r0.append(r2);
            r2 = ",";
            r0 = r0.append(r2);
            r0.append(r1);
            r0 = r5.toString();
            return r0;
        L_0x005a:
            r0 = r9 instanceof java.lang.String;
            if (r0 == 0) goto L_0x0095;
        L_0x005e:
            r0 = r9;
            r0 = (java.lang.String) r0;
            r4 = com.tencent.mm.modelsfs.FileOp.bO(r0);
            if (r4 == 0) goto L_0x002d;
        L_0x0067:
            r4 = 0;
            r9 = (java.lang.String) r9;	 Catch:{ FileNotFoundException -> 0x0084, all -> 0x008e }
            r4 = com.tencent.mm.modelsfs.FileOp.openRead(r9);	 Catch:{ FileNotFoundException -> 0x0084, all -> 0x008e }
            r6 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            r6 = com.tencent.mm.a.g.a(r4, r6);	 Catch:{ FileNotFoundException -> 0x00a6, all -> 0x008e }
            r1 = com.tencent.mm.sdk.platformtools.bi.oM(r6);	 Catch:{ FileNotFoundException -> 0x00a6, all -> 0x008e }
            r2 = com.tencent.mm.modelsfs.FileOp.mi(r0);	 Catch:{ FileNotFoundException -> 0x00a6, all -> 0x008e }
            if (r4 == 0) goto L_0x002d;
        L_0x007e:
            r4.close();	 Catch:{ Exception -> 0x0082 }
            goto L_0x002d;
        L_0x0082:
            r0 = move-exception;
            goto L_0x002d;
        L_0x0084:
            r0 = move-exception;
            r0 = r4;
        L_0x0086:
            if (r0 == 0) goto L_0x002d;
        L_0x0088:
            r0.close();	 Catch:{ Exception -> 0x008c }
            goto L_0x002d;
        L_0x008c:
            r0 = move-exception;
            goto L_0x002d;
        L_0x008e:
            r0 = move-exception;
            if (r4 == 0) goto L_0x0094;
        L_0x0091:
            r4.close();	 Catch:{ Exception -> 0x00a4 }
        L_0x0094:
            throw r0;
        L_0x0095:
            r0 = r9 instanceof byte[];
            if (r0 == 0) goto L_0x002d;
        L_0x0099:
            r9 = (byte[]) r9;
            r9 = (byte[]) r9;
            r1 = com.tencent.mm.a.g.s(r9);
            r0 = r9.length;
            r2 = (long) r0;
            goto L_0x002d;
        L_0x00a4:
            r1 = move-exception;
            goto L_0x0094;
        L_0x00a6:
            r0 = move-exception;
            r0 = r4;
            goto L_0x0086;
        L_0x00a9:
            r7 = r2;
            r2 = r1;
            r0 = r7;
            goto L_0x002a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper.getKVStatString(java.lang.Object, int, com.tencent.mm.sdk.platformtools.MMBitmapFactory$DecodeResultLogger):java.lang.String");
        }
    }

    private static native int nativeCheckIsImageLegal(InputStream inputStream, byte[] bArr, DecodeResultLogger decodeResultLogger);

    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, Options options, DecodeResultLogger decodeResultLogger, int... iArr);

    private static native Bitmap nativeDecodeStream(InputStream inputStream, byte[] bArr, Rect rect, Options options, DecodeResultLogger decodeResultLogger, int... iArr);

    private static native boolean nativeInit(String... strArr);

    private static native int nativePinBitmap(Bitmap bitmap);

    private static native boolean nativeSwitchDecoder(int i, boolean z);

    private static native int nativeUnPinBitmap(Bitmap bitmap);

    private static void checkIsInit() {
        if (!mIsInit) {
            x.w(TAG, "MMBitmapFactory is not initialized.");
        }
    }

    public static boolean init() {
        if (n.yD()) {
            d.t(ad.getContext(), "libvoipCodec_v7a.so");
        }
        try {
            mIsInit = nativeInit(new File(ad.getContext().getDir("lib", 0), "libvoipCodec_v7a.so").getAbsolutePath());
        } catch (Throwable th) {
            x.printErrStackTrace(TAG, th, "", new Object[0]);
            if (com.tencent.mm.compatible.util.d.fO(20)) {
                mIsInit = nativeInit(new File(ad.getContext().getDir("lib", 0), "libvoipCodec_v7a.so").getAbsolutePath());
            }
        }
        if (!mIsInit) {
            DynamicConfigStorage.setValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false);
            x.w(TAG, "MMBitmapFactory initialize failed, force use system BitmapFactory instead.");
        }
        return mIsInit;
    }

    public static void setUseMMBitmapFactory(boolean z) {
        if (mIsInit) {
            DynamicConfigStorage.setValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, z);
            if (!z) {
                x.i(TAG, "MMBitmapFactory is switched off, use system BitmapFactory directly.");
            }
        }
    }

    public static boolean switchDecoder(int i, boolean z) {
        return nativeSwitchDecoder(i, z);
    }

    public static boolean checkIsImageLegal(String str) {
        return checkIsImageLegal(str, null);
    }

    public static boolean checkIsImageLegal(byte[] bArr) {
        return checkIsImageLegal(bArr, null);
    }

    public static boolean checkIsImageLegal(InputStream inputStream) {
        return checkIsImageLegal(inputStream, null);
    }

    public static boolean checkIsImageLegal(String str, DecodeResultLogger decodeResultLogger) {
        Throwable e;
        Throwable th;
        if (str == null) {
            x.e(TAG, "filePath is null.");
            if (decodeResultLogger == null) {
                return false;
            }
            decodeResultLogger.mDecodeResultCode = 1005;
            return false;
        }
        Closeable bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                long currentTimeMillis = System.currentTimeMillis();
                x.d(TAG, "check [%s] res:%b, cost:%d ms", str, Boolean.valueOf(checkIsImageLegalInternal(bufferedInputStream, decodeResultLogger)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                bi.d(bufferedInputStream);
                return r1;
            } catch (FileNotFoundException e2) {
                e = e2;
                try {
                    x.printErrStackTrace(TAG, e, "An exception was thrown.", new Object[0]);
                    if (decodeResultLogger != null) {
                        decodeResultLogger.mDecodeResultCode = 1005;
                    }
                    bi.d(bufferedInputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bi.d(bufferedInputStream);
                    throw th;
                }
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            bufferedInputStream = null;
            x.printErrStackTrace(TAG, e, "An exception was thrown.", new Object[0]);
            if (decodeResultLogger != null) {
                decodeResultLogger.mDecodeResultCode = 1005;
            }
            bi.d(bufferedInputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            bi.d(bufferedInputStream);
            throw th;
        }
    }

    public static boolean checkIsImageLegal(byte[] bArr, DecodeResultLogger decodeResultLogger) {
        if (bArr != null) {
            return checkIsImageLegalInternal(new ByteArrayInputStream(bArr), decodeResultLogger);
        }
        x.e(TAG, "buf is null.");
        if (decodeResultLogger != null) {
            decodeResultLogger.mDecodeResultCode = 1005;
        }
        return false;
    }

    public static boolean checkIsImageLegal(InputStream inputStream, DecodeResultLogger decodeResultLogger) {
        return checkIsImageLegalInternal(inputStream, decodeResultLogger);
    }

    private static boolean checkIsImageLegalInternal(InputStream inputStream, DecodeResultLogger decodeResultLogger) {
        if (inputStream == null) {
            x.e(TAG, "InputStream is null.");
            if (decodeResultLogger == null) {
                return false;
            }
            decodeResultLogger.mDecodeResultCode = 1005;
            return false;
        } else if (!DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false)) {
            return true;
        } else {
            int nativeCheckIsImageLegal = nativeCheckIsImageLegal(inputStream, new byte[8192], decodeResultLogger);
            if (nativeCheckIsImageLegal == 0 || nativeCheckIsImageLegal == 1006) {
                return true;
            }
            return false;
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        return decodeByteArray(bArr, i, i2, null, null, 1, new int[0]);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, int i3) {
        return decodeByteArray(bArr, i, i2, null, null, i3, new int[0]);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, Options options) {
        return decodeByteArray(bArr, i, i2, options, null, 1, new int[0]);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, Options options, int i3) {
        return decodeByteArray(bArr, i, i2, options, null, i3, new int[0]);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, DecodeResultLogger decodeResultLogger) {
        return decodeByteArray(bArr, i, i2, null, decodeResultLogger, 1, new int[0]);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, DecodeResultLogger decodeResultLogger, int i3, int... iArr) {
        return decodeByteArray(bArr, i, i2, null, decodeResultLogger, i3, iArr);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, Options options, DecodeResultLogger decodeResultLogger) {
        return decodeByteArray(bArr, i, i2, options, decodeResultLogger, 1, new int[0]);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, Options options, DecodeResultLogger decodeResultLogger, int i3, int... iArr) {
        int startPerformance = HardCoderJNI.startPerformance(HardCoderJNI.hcDecodePicEnable, HardCoderJNI.hcDecodePicDelay, HardCoderJNI.hcDecodePicCPU, HardCoderJNI.hcDecodePicIO, HardCoderJNI.hcDecodePicThr ? Process.myTid() : 0, HardCoderJNI.hcDecodePicTimeout, 601, HardCoderJNI.hcDecodePicAction, TAG);
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap decodeByteArrayInternal = decodeByteArrayInternal(bArr, i, i2, options, decodeResultLogger, i3, iArr);
        x.i(TAG, "decode done, size:%d, cost:%d ms", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        HardCoderJNI.stopPerformace(HardCoderJNI.hcDecodePicEnable, startPerformance);
        return decodeByteArrayInternal;
    }

    private static Bitmap decodeByteArrayInternal(byte[] bArr, int i, int i2, Options options, DecodeResultLogger decodeResultLogger, int i3, int... iArr) {
        checkIsInit();
        if (DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false)) {
            switch (i3) {
                case 0:
                    return decodeByteArrayWithMMDecoderIfPossible(bArr, i, i2, options, decodeResultLogger, iArr);
                default:
                    x.i(TAG, "Decoded by system BitmapFactory directly, isEnabled:%b", Boolean.valueOf(r0));
                    return decodeByteArrayWithSystemDecoder(bArr, i, i2, options, decodeResultLogger);
            }
        }
        x.i(TAG, "Decoded by system BitmapFactory directly since strategy, isEnabled:%b", Boolean.valueOf(DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false)));
        return decodeByteArrayWithSystemDecoder(bArr, i, i2, options, decodeResultLogger);
    }

    private static Bitmap decodeByteArrayWithMMDecoderIfPossible(byte[] bArr, int i, int i2, Options options, DecodeResultLogger decodeResultLogger, int... iArr) {
        DecodeResultLogger decodeResultLogger2;
        Throwable e;
        Bitmap bitmap;
        if (decodeResultLogger == null) {
            try {
                decodeResultLogger2 = new DecodeResultLogger();
            } catch (Throwable e2) {
                e = e2;
                decodeResultLogger2 = decodeResultLogger;
                bitmap = null;
                x.printErrStackTrace(TAG, e, "An exception was thrown when decode image.", new Object[0]);
                decodeResultLogger2.mDecodeResultCode = 1005;
                x.i(TAG, decodeResultLogger2.toLogString());
                return bitmap;
            }
        }
        decodeResultLogger2 = decodeResultLogger;
        try {
            bitmap = nativeDecodeByteArray(bArr, i, i2, options, decodeResultLogger2, iArr);
            try {
                if (decodeResultLogger2.mDecodeResultCode == 0 || decodeResultLogger2.mDecodeResultCode >= ERROR_IMG_BUG_DETECTED_BEGIN) {
                    x.i(TAG, "decoder [%s] decodes done, ret:%d.", decodeResultLogger2.mDecoderTag, Integer.valueOf(decodeResultLogger2.mDecodeResultCode));
                    if (bitmap != null) {
                        if (!(options == null || !options.inScaled || options.inJustDecodeBounds)) {
                            Bitmap scaledBitmap = getScaledBitmap(bitmap, options);
                            if (scaledBitmap != bitmap) {
                                bitmap.recycle();
                            }
                            bitmap = scaledBitmap;
                        }
                        setDensityFromOptions(bitmap, options);
                    }
                    x.i(TAG, decodeResultLogger2.toLogString());
                    return bitmap;
                }
                x.i(TAG, "mmimgdec decoder decodes failed, try system BitmapFactory.");
                decodeResultLogger2.mIsDecodeByMMDecoder = false;
                bitmap = BitmapFactory.decodeByteArray(bArr, i, i2, options);
                if (bitmap != null || (options != null && options.inJustDecodeBounds && options.outWidth >= 0 && options.outHeight >= 0)) {
                    x.i(TAG, "System decoder decodes success.");
                    decodeResultLogger2.mDecodeResultCode = 0;
                    x.i(TAG, decodeResultLogger2.toLogString());
                    return bitmap;
                }
                x.w(TAG, "System decoder decodes failed.");
                decodeResultLogger2.mDecodeResultCode = 1006;
                x.i(TAG, decodeResultLogger2.toLogString());
                return bitmap;
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Throwable e22) {
            e = e22;
            bitmap = null;
        }
    }

    private static Bitmap decodeByteArrayWithSystemDecoder(byte[] bArr, int i, int i2, Options options, DecodeResultLogger decodeResultLogger) {
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i, i2, options);
        if (decodeResultLogger != null) {
            decodeResultLogger.clear();
            decodeResultLogger.mDecodeResultCode = decodeByteArray != null ? 0 : 1006;
            decodeResultLogger.mIsDecodeByMMDecoder = false;
        }
        String str = TAG;
        String str2 = "decode bytearray by system decoder done, res: %s";
        Object[] objArr = new Object[1];
        objArr[0] = decodeByteArray != null ? decodeByteArray.toString() : "null";
        x.i(str, str2, objArr);
        return decodeByteArray;
    }

    public static Bitmap decodeFile(String str) {
        return decodeFile(str, null, null, 1, new int[0]);
    }

    public static Bitmap decodeFile(String str, int i) {
        return decodeFile(str, null, null, i, new int[0]);
    }

    public static Bitmap decodeFile(String str, Options options) {
        return decodeFile(str, options, null, 1, new int[0]);
    }

    public static Bitmap decodeFile(String str, Options options, int i) {
        return decodeFile(str, options, null, i, new int[0]);
    }

    public static Bitmap decodeFile(String str, DecodeResultLogger decodeResultLogger) {
        return decodeFile(str, null, decodeResultLogger, 1, new int[0]);
    }

    public static Bitmap decodeFile(String str, DecodeResultLogger decodeResultLogger, int i) {
        return decodeFile(str, null, decodeResultLogger, i, new int[0]);
    }

    public static Bitmap decodeFile(String str, Options options, DecodeResultLogger decodeResultLogger, int i, int... iArr) {
        try {
            return decodeStream(FileOp.openRead(str), null, options, decodeResultLogger, i, iArr);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        return decodeStream(inputStream, null, null, null, 1, new int[0]);
    }

    public static Bitmap decodeStream(InputStream inputStream, int i) {
        return decodeStream(inputStream, null, null, null, i, new int[0]);
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, Options options) {
        return decodeStream(inputStream, rect, options, null, 1, new int[0]);
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, Options options, int i) {
        return decodeStream(inputStream, rect, options, null, i, new int[0]);
    }

    public static Bitmap decodeStream(InputStream inputStream, DecodeResultLogger decodeResultLogger) {
        return decodeStream(inputStream, null, null, decodeResultLogger, 1, new int[0]);
    }

    public static Bitmap decodeStream(InputStream inputStream, DecodeResultLogger decodeResultLogger, int i, int... iArr) {
        return decodeStream(inputStream, null, null, decodeResultLogger, i, iArr);
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger, int i, int... iArr) {
        long available;
        int startPerformance = HardCoderJNI.startPerformance(HardCoderJNI.hcDecodePicEnable, HardCoderJNI.hcDecodePicDelay, HardCoderJNI.hcDecodePicCPU, HardCoderJNI.hcDecodePicIO, HardCoderJNI.hcDecodePicThr ? Process.myTid() : 0, HardCoderJNI.hcDecodePicTimeout, 601, HardCoderJNI.hcDecodePicAction, TAG);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            available = (long) inputStream.available();
        } catch (IOException e) {
            available = -1;
        }
        Bitmap decodeStreamInternal = decodeStreamInternal(inputStream, rect, options, decodeResultLogger, i, iArr);
        x.i(TAG, "decode done, size:%d, cost:%d ms", Long.valueOf(available), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        HardCoderJNI.stopPerformace(HardCoderJNI.hcDecodePicEnable, startPerformance);
        return decodeStreamInternal;
    }

    private static Bitmap decodeStreamInternal(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger, int i, int... iArr) {
        checkIsInit();
        if (!DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false) || (inputStream instanceof AssetInputStream)) {
            x.i(TAG, "Decoded by system BitmapFactory directly, isEnabled:%b", Boolean.valueOf(r0));
            return decodeStreamWithSystemDecoder(inputStream, rect, options, decodeResultLogger);
        }
        switch (i) {
            case 0:
                return decodeStreamWithMMDecoderIfPossible(inputStream, rect, options, decodeResultLogger, iArr);
            default:
                x.i(TAG, "Decoded by system BitmapFactory directly, isEnabled:%b", Boolean.valueOf(r0));
                return decodeStreamWithSystemDecoder(inputStream, rect, options, decodeResultLogger);
        }
    }

    private static Bitmap decodeStreamWithMMDecoderIfPossible(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger, int... iArr) {
        byte[] bArr;
        InputStream inputStream2;
        DecodeResultLogger decodeResultLogger2;
        Bitmap bitmap;
        Throwable th;
        if (options != null) {
            bArr = options.inTempStorage;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            bArr = new byte[8192];
        }
        if (inputStream.markSupported()) {
            inputStream2 = inputStream;
        } else if (inputStream instanceof FileInputStream) {
            inputStream2 = new j((FileInputStream) inputStream);
        } else {
            inputStream2 = new BufferedInputStream(inputStream);
        }
        try {
            inputStream2.mark(DEFAULT_DECODE_MARK_SIZE);
            if (decodeResultLogger == null) {
                decodeResultLogger2 = new DecodeResultLogger();
            } else {
                decodeResultLogger2 = decodeResultLogger;
            }
            try {
                Bitmap nativeDecodeStream = nativeDecodeStream(inputStream2, bArr, rect, options, decodeResultLogger2, iArr);
                try {
                    if (decodeResultLogger2.mDecodeResultCode == 0 || decodeResultLogger2.mDecodeResultCode >= ERROR_IMG_BUG_DETECTED_BEGIN) {
                        x.i(TAG, "decoder [%s] decodes done, ret:%d.", decodeResultLogger2.mDecoderTag, Integer.valueOf(decodeResultLogger2.mDecodeResultCode));
                        if (nativeDecodeStream != null) {
                            if (!(options == null || !options.inScaled || options.inJustDecodeBounds)) {
                                Bitmap scaledBitmap = getScaledBitmap(nativeDecodeStream, options);
                                if (scaledBitmap != nativeDecodeStream) {
                                    nativeDecodeStream.recycle();
                                }
                                nativeDecodeStream = scaledBitmap;
                            }
                            setDensityFromOptions(nativeDecodeStream, options);
                        }
                    } else {
                        x.i(TAG, "mmimgdec decoder decodes failed, try system BitmapFactory.");
                        decodeResultLogger2.mIsDecodeByMMDecoder = false;
                        inputStream2.reset();
                        inputStream2.mark(DEFAULT_DECODE_MARK_SIZE);
                        nativeDecodeStream = BitmapFactory.decodeStream(inputStream2, rect, options);
                        if (nativeDecodeStream != null || (options != null && options.inJustDecodeBounds && options.outWidth >= 0 && options.outHeight >= 0)) {
                            x.i(TAG, "System decoder decodes success.");
                            decodeResultLogger2.mDecodeResultCode = 0;
                        } else {
                            x.w(TAG, "System decoder decodes failed.");
                            decodeResultLogger2.mDecodeResultCode = 1006;
                        }
                    }
                    inputStream2.reset();
                    inputStream2.mark(DEFAULT_DECODE_MARK_SIZE);
                    bitmap = nativeDecodeStream;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    bitmap = nativeDecodeStream;
                    th = th2;
                }
            } catch (Throwable e2) {
                th = e2;
                bitmap = null;
            }
        } catch (Throwable e22) {
            th = e22;
            decodeResultLogger2 = decodeResultLogger;
            bitmap = null;
            x.printErrStackTrace(TAG, th, "An exception was thrown when decode image.", new Object[0]);
            decodeResultLogger2.mDecodeResultCode = 1005;
            x.i(TAG, decodeResultLogger2.toLogString());
            return bitmap;
        }
        x.i(TAG, decodeResultLogger2.toLogString());
        return bitmap;
    }

    private static Bitmap decodeStreamWithSystemDecoder(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        int i = 1006;
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
        if (decodeResultLogger != null) {
            decodeResultLogger.clear();
            if (options == null || !options.inJustDecodeBounds) {
                if (decodeStream != null) {
                    i = 0;
                }
                decodeResultLogger.mDecodeResultCode = i;
            } else {
                if (options.outWidth >= 0 && options.outHeight >= 0) {
                    i = 0;
                }
                decodeResultLogger.mDecodeResultCode = i;
            }
            decodeResultLogger.mIsDecodeByMMDecoder = false;
        }
        String str = TAG;
        String str2 = "decode stream by system decoder done, res: %s";
        Object[] objArr = new Object[1];
        objArr[0] = decodeStream != null ? decodeStream.toString() : "null";
        x.i(str, str2, objArr);
        return decodeStream;
    }

    private static Bitmap getScaledBitmap(Bitmap bitmap, Options options) {
        float f;
        int i = options.inDensity;
        int i2 = options.inTargetDensity;
        int i3 = options.inScreenDensity;
        if (i == 0 || i2 == 0 || i == i3) {
            f = 1.0f;
        } else {
            f = ((float) i2) / ((float) i);
        }
        if (f != 1.0f) {
            return Bitmap.createScaledBitmap(bitmap, (int) ((((float) bitmap.getWidth()) * f) + 0.5f), (int) ((f * ((float) bitmap.getHeight())) + 0.5f), true);
        }
        return bitmap;
    }

    private static void setDensityFromOptions(Bitmap bitmap, Options options) {
        Object obj = 1;
        if (bitmap != null && options != null) {
            int i = options.inDensity;
            if (i != 0) {
                bitmap.setDensity(i);
                int i2 = options.inTargetDensity;
                if (i2 != 0 && i != i2 && i != options.inScreenDensity) {
                    byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                    if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
                        obj = null;
                    }
                    if (options.inScaled || obj != null) {
                        bitmap.setDensity(i2);
                    }
                }
            } else if (options.inBitmap != null) {
                try {
                    if (mMthGetDefaultDensity == null) {
                        Method declaredMethod = Bitmap.class.getDeclaredMethod("getDefaultDensity", null);
                        mMthGetDefaultDensity = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    bitmap.setDensity(((Integer) mMthGetDefaultDensity.invoke(null, new Object[0])).intValue());
                } catch (Exception e) {
                    bitmap.setDensity(JsApiSetBackgroundAudioState.CTRL_INDEX);
                }
            }
        }
    }

    public static Bitmap decodeRegion(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        BitmapRegionDecoder newInstance;
        Bitmap bitmap;
        Throwable e;
        BitmapRegionDecoder bitmapRegionDecoder = null;
        if (!checkIfHaveToUseMMDecoder(options)) {
            try {
                newInstance = BitmapRegionDecoder.newInstance(inputStream, true);
                try {
                    Bitmap decodeRegion = newInstance.decodeRegion(rect, options);
                    if (newInstance != null) {
                        newInstance.recycle();
                        bitmap = decodeRegion;
                    } else {
                        bitmap = decodeRegion;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                newInstance = bitmapRegionDecoder;
            } catch (Throwable th) {
                e = th;
                newInstance = bitmapRegionDecoder;
                if (newInstance != null) {
                    newInstance.recycle();
                }
                throw e;
            }
            if (bitmap == null) {
                x.d(TAG, "decodeRegion with inputStream, fallback");
                return decodeRegionFallback(inputStream, rect, options, decodeResultLogger);
            } else if (decodeResultLogger == null) {
                return bitmap;
            } else {
                decodeResultLogger.clear();
                decodeResultLogger.mDecodeResultCode = 0;
                decodeResultLogger.mIsDecodeByMMDecoder = false;
                return bitmap;
            }
        }
        Object bitmap2 = bitmapRegionDecoder;
        if (bitmap2 == null) {
            x.d(TAG, "decodeRegion with inputStream, fallback");
            return decodeRegionFallback(inputStream, rect, options, decodeResultLogger);
        } else if (decodeResultLogger == null) {
            return bitmap2;
        } else {
            decodeResultLogger.clear();
            decodeResultLogger.mDecodeResultCode = 0;
            decodeResultLogger.mIsDecodeByMMDecoder = false;
            return bitmap2;
        }
        try {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            if (newInstance != null) {
                newInstance.recycle();
                bitmap2 = bitmapRegionDecoder;
                if (bitmap2 == null) {
                    x.d(TAG, "decodeRegion with inputStream, fallback");
                    return decodeRegionFallback(inputStream, rect, options, decodeResultLogger);
                } else if (decodeResultLogger == null) {
                    return bitmap2;
                } else {
                    decodeResultLogger.clear();
                    decodeResultLogger.mDecodeResultCode = 0;
                    decodeResultLogger.mIsDecodeByMMDecoder = false;
                    return bitmap2;
                }
            }
            Object bitmap22 = bitmapRegionDecoder;
            if (bitmap22 == null) {
                x.d(TAG, "decodeRegion with inputStream, fallback");
                return decodeRegionFallback(inputStream, rect, options, decodeResultLogger);
            } else if (decodeResultLogger == null) {
                return bitmap22;
            } else {
                decodeResultLogger.clear();
                decodeResultLogger.mDecodeResultCode = 0;
                decodeResultLogger.mIsDecodeByMMDecoder = false;
                return bitmap22;
            }
        } catch (Throwable th2) {
            e = th2;
            if (newInstance != null) {
                newInstance.recycle();
            }
            throw e;
        }
    }

    public static Bitmap decodeRegion(FileDescriptor fileDescriptor, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        BitmapRegionDecoder newInstance;
        Bitmap decodeRegion;
        Throwable e;
        Closeable fileInputStream;
        Closeable closeable = null;
        if (!checkIfHaveToUseMMDecoder(options)) {
            try {
                newInstance = BitmapRegionDecoder.newInstance(fileDescriptor, true);
                try {
                    decodeRegion = newInstance.decodeRegion(rect, options);
                    if (newInstance != null) {
                        newInstance.recycle();
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                newInstance = null;
            } catch (Throwable th) {
                e = th;
                newInstance = null;
                if (newInstance != null) {
                    newInstance.recycle();
                }
                throw e;
            }
            if (decodeRegion == null) {
                x.d(TAG, "decodeRegion with FileDescriptor, fallback");
                try {
                    fileInputStream = new FileInputStream(fileDescriptor);
                    try {
                        decodeRegion = decodeRegionFallback(fileInputStream, rect, options, decodeResultLogger);
                        bi.d(fileInputStream);
                    } catch (Throwable th2) {
                        e = th2;
                        closeable = fileInputStream;
                        bi.d(closeable);
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    bi.d(closeable);
                    throw e;
                }
            } else if (decodeResultLogger != null) {
                decodeResultLogger.clear();
                decodeResultLogger.mDecodeResultCode = 0;
                decodeResultLogger.mIsDecodeByMMDecoder = false;
            }
            return decodeRegion;
        }
        decodeRegion = null;
        if (decodeRegion == null) {
            x.d(TAG, "decodeRegion with FileDescriptor, fallback");
            fileInputStream = new FileInputStream(fileDescriptor);
            decodeRegion = decodeRegionFallback(fileInputStream, rect, options, decodeResultLogger);
            bi.d(fileInputStream);
        } else if (decodeResultLogger != null) {
            decodeResultLogger.clear();
            decodeResultLogger.mDecodeResultCode = 0;
            decodeResultLogger.mIsDecodeByMMDecoder = false;
        }
        return decodeRegion;
        try {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            if (newInstance != null) {
                newInstance.recycle();
                decodeRegion = null;
                if (decodeRegion == null) {
                    x.d(TAG, "decodeRegion with FileDescriptor, fallback");
                    fileInputStream = new FileInputStream(fileDescriptor);
                    decodeRegion = decodeRegionFallback(fileInputStream, rect, options, decodeResultLogger);
                    bi.d(fileInputStream);
                } else if (decodeResultLogger != null) {
                    decodeResultLogger.clear();
                    decodeResultLogger.mDecodeResultCode = 0;
                    decodeResultLogger.mIsDecodeByMMDecoder = false;
                }
                return decodeRegion;
            }
            decodeRegion = null;
            if (decodeRegion == null) {
                x.d(TAG, "decodeRegion with FileDescriptor, fallback");
                fileInputStream = new FileInputStream(fileDescriptor);
                decodeRegion = decodeRegionFallback(fileInputStream, rect, options, decodeResultLogger);
                bi.d(fileInputStream);
            } else if (decodeResultLogger != null) {
                decodeResultLogger.clear();
                decodeResultLogger.mDecodeResultCode = 0;
                decodeResultLogger.mIsDecodeByMMDecoder = false;
            }
            return decodeRegion;
        } catch (Throwable th4) {
            e = th4;
            if (newInstance != null) {
                newInstance.recycle();
            }
            throw e;
        }
    }

    public static Bitmap decodeRegion(byte[] bArr, int i, int i2, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        BitmapRegionDecoder newInstance;
        Bitmap bitmap;
        Throwable e;
        BitmapRegionDecoder bitmapRegionDecoder = null;
        if (!checkIfHaveToUseMMDecoder(options)) {
            try {
                newInstance = BitmapRegionDecoder.newInstance(bArr, i, i2, true);
                try {
                    Bitmap decodeRegion = newInstance.decodeRegion(rect, options);
                    if (newInstance != null) {
                        newInstance.recycle();
                        bitmap = decodeRegion;
                    } else {
                        bitmap = decodeRegion;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                newInstance = bitmapRegionDecoder;
            } catch (Throwable th) {
                e = th;
                newInstance = bitmapRegionDecoder;
                if (newInstance != null) {
                    newInstance.recycle();
                }
                throw e;
            }
            if (bitmap == null) {
                x.d(TAG, "decodeRegion with bytes, fallback");
                return decodeRegionFallback(bArr, i, i2, rect, options, decodeResultLogger);
            } else if (decodeResultLogger == null) {
                return bitmap;
            } else {
                decodeResultLogger.clear();
                decodeResultLogger.mDecodeResultCode = 0;
                decodeResultLogger.mIsDecodeByMMDecoder = false;
                return bitmap;
            }
        }
        Object bitmap2 = bitmapRegionDecoder;
        if (bitmap2 == null) {
            x.d(TAG, "decodeRegion with bytes, fallback");
            return decodeRegionFallback(bArr, i, i2, rect, options, decodeResultLogger);
        } else if (decodeResultLogger == null) {
            return bitmap2;
        } else {
            decodeResultLogger.clear();
            decodeResultLogger.mDecodeResultCode = 0;
            decodeResultLogger.mIsDecodeByMMDecoder = false;
            return bitmap2;
        }
        try {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            if (newInstance != null) {
                newInstance.recycle();
                bitmap2 = bitmapRegionDecoder;
                if (bitmap2 == null) {
                    x.d(TAG, "decodeRegion with bytes, fallback");
                    return decodeRegionFallback(bArr, i, i2, rect, options, decodeResultLogger);
                } else if (decodeResultLogger == null) {
                    return bitmap2;
                } else {
                    decodeResultLogger.clear();
                    decodeResultLogger.mDecodeResultCode = 0;
                    decodeResultLogger.mIsDecodeByMMDecoder = false;
                    return bitmap2;
                }
            }
            Object bitmap22 = bitmapRegionDecoder;
            if (bitmap22 == null) {
                x.d(TAG, "decodeRegion with bytes, fallback");
                return decodeRegionFallback(bArr, i, i2, rect, options, decodeResultLogger);
            } else if (decodeResultLogger == null) {
                return bitmap22;
            } else {
                decodeResultLogger.clear();
                decodeResultLogger.mDecodeResultCode = 0;
                decodeResultLogger.mIsDecodeByMMDecoder = false;
                return bitmap22;
            }
        } catch (Throwable th2) {
            e = th2;
            if (newInstance != null) {
                newInstance.recycle();
            }
            throw e;
        }
    }

    private static Bitmap decodeRegionFallback(InputStream inputStream, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        Bitmap bitmap = null;
        Bitmap decodeStream = decodeStream(inputStream, null, options, decodeResultLogger, 0, new int[0]);
        if (decodeStream != null) {
            bitmap = Bitmap.createBitmap(decodeStream, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
            if (bitmap != decodeStream) {
                decodeStream.recycle();
            }
        }
        return bitmap;
    }

    private static Bitmap decodeRegionFallback(byte[] bArr, int i, int i2, Rect rect, Options options, DecodeResultLogger decodeResultLogger) {
        Bitmap decodeByteArray = decodeByteArray(bArr, i, i2, options, decodeResultLogger, 0, new int[0]);
        if (decodeByteArray == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
        if (createBitmap == decodeByteArray) {
            return createBitmap;
        }
        decodeByteArray.recycle();
        return createBitmap;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Options options, DecodeResultLogger decodeResultLogger) {
        Bitmap decodeFileDescriptor;
        Throwable e;
        Closeable fileInputStream;
        Bitmap decodeStream;
        Closeable closeable = null;
        if (!checkIfHaveToUseMMDecoder(options)) {
            try {
                decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            } catch (Throwable e2) {
                x.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
            if (decodeFileDescriptor != null) {
                x.d(TAG, "decodeFileDescriptor, fallback");
                try {
                    fileInputStream = new FileInputStream(fileDescriptor);
                    try {
                        decodeStream = decodeStream(fileInputStream, null, options, decodeResultLogger, 0, new int[0]);
                        bi.d(fileInputStream);
                        return decodeStream;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        closeable = fileInputStream;
                        e2 = th2;
                        bi.d(closeable);
                        throw e2;
                    }
                } catch (Throwable th3) {
                    e2 = th3;
                    bi.d(closeable);
                    throw e2;
                }
            } else if (decodeResultLogger != null) {
                return decodeFileDescriptor;
            } else {
                decodeResultLogger.clear();
                decodeResultLogger.mDecodeResultCode = 0;
                decodeResultLogger.mIsDecodeByMMDecoder = false;
                return decodeFileDescriptor;
            }
        }
        decodeFileDescriptor = null;
        if (decodeFileDescriptor != null) {
            x.d(TAG, "decodeFileDescriptor, fallback");
            fileInputStream = new FileInputStream(fileDescriptor);
            decodeStream = decodeStream(fileInputStream, null, options, decodeResultLogger, 0, new int[0]);
            bi.d(fileInputStream);
            return decodeStream;
        } else if (decodeResultLogger != null) {
            return decodeFileDescriptor;
        } else {
            decodeResultLogger.clear();
            decodeResultLogger.mDecodeResultCode = 0;
            decodeResultLogger.mIsDecodeByMMDecoder = false;
            return decodeFileDescriptor;
        }
    }

    private static boolean checkIfHaveToUseMMDecoder(Options options) {
        String str = TAG;
        String str2 = "mimetype: %s";
        Object[] objArr = new Object[1];
        objArr[0] = options != null ? options.outMimeType : "";
        x.d(str, str2, objArr);
        if (options == null || options.outMimeType == null || (!options.outMimeType.toLowerCase().endsWith("png") && !options.outMimeType.toLowerCase().endsWith("vcodec"))) {
            return false;
        }
        return true;
    }

    public static Bitmap pinBitmap(Bitmap bitmap) {
        if (!(bitmap == null || bitmap.isRecycled() || nativePinBitmap(bitmap) >= 0)) {
            x.e(TAG, "pinBitmap failed");
        }
        return bitmap;
    }

    public static Bitmap unPinBitmap(Bitmap bitmap) {
        if (!(bitmap == null || bitmap.isRecycled() || nativeUnPinBitmap(bitmap) >= 0)) {
            x.e(TAG, "unpinBitmap failed");
        }
        return bitmap;
    }
}
