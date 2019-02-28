package com.tencent.mm.plugin.facedetect;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;

public class FaceProNative {
    public static final int ROTFLIPHOR = 3;
    public static final int ROTFLIPLEFT = 4;
    public static final int ROTFLIPRIGHT = 5;
    public static final int ROTLEFT = 1;
    public static final int ROTRIGHT = 2;
    public static final int ROTSTABLE = 0;
    private static final String TAG = "MicroMsg.FaceProNative";
    private static final long TIMEOUT_CHECKER = 3600000;
    private static String[] cachedStr = null;
    public static boolean hasDetectInit = false;
    private static long lastCheckTime = -1;
    private long nativePtr;

    public static class FaceResult implements Parcelable {
        public static final Creator<FaceResult> CREATOR = new Creator<FaceResult>() {
            public final FaceResult createFromParcel(Parcel parcel) {
                return new FaceResult(parcel);
            }

            public final FaceResult[] newArray(int i) {
                return new FaceResult[i];
            }
        };
        public byte[] data;
        public int result;
        public byte[] sidedata;

        protected FaceResult(Parcel parcel) {
            this.result = parcel.readInt();
            this.data = parcel.createByteArray();
            this.sidedata = parcel.createByteArray();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.result);
            parcel.writeByteArray(this.data);
            parcel.writeByteArray(this.sidedata);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            int i = 0;
            StringBuilder append = new StringBuilder("FaceResult{result=").append(this.result).append(", sidedataLen=").append(this.sidedata == null ? 0 : this.sidedata.length).append(", dataLen=");
            if (this.data != null) {
                i = this.data.length;
            }
            return append.append(i).append('}').toString();
        }
    }

    public static class FaceStatus implements Parcelable {
        public static final Creator<FaceStatus> CREATOR = new Creator<FaceStatus>() {
            public final FaceStatus createFromParcel(Parcel parcel) {
                return new FaceStatus(parcel);
            }

            public final FaceStatus[] newArray(int i) {
                return new FaceStatus[i];
            }
        };
        public Rect facerect;
        public float pitch;
        public int result;
        public float roll;
        public float[] xys;
        public float yaw;

        protected FaceStatus(Parcel parcel) {
            this.result = parcel.readInt();
            this.facerect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.xys = parcel.createFloatArray();
            this.pitch = parcel.readFloat();
            this.yaw = parcel.readFloat();
            this.roll = parcel.readFloat();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.result);
            parcel.writeParcelable(this.facerect, i);
            parcel.writeFloatArray(this.xys);
            parcel.writeFloat(this.pitch);
            parcel.writeFloat(this.yaw);
            parcel.writeFloat(this.roll);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "FaceStatus{result=" + this.result + ", facerect=" + this.facerect + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + '}';
        }
    }

    private native void NativeConstructor();

    private native void NativeDestructor();

    public static native int engineVersion();

    public static native int nativeFacedetectInitBin(byte[] bArr);

    public static native void nativeFacedetectRelease();

    public static native int nativeFacedetectWithBitmap(Object obj);

    public static native boolean nativeInit();

    public native FaceStatus engineFaceProcess(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int[] engineGetAllMotions();

    public native int engineGetCurrMotion();

    public native String engineGetCurrMotionData();

    public native int engineGroupChange();

    public native int engineInit(String str, byte[] bArr, String str2, String str3);

    public native int engineNextMotion();

    public native int engineRelease();

    public native int engineReleaseCurrMotion();

    public native FaceResult engineReleaseOut();

    public native int engineSetVoiceData(byte[] bArr);

    public native int engineStartRecord();

    public FaceProNative() {
        NativeConstructor();
    }

    public void destroy() {
        NativeDestructor();
    }

    protected void finalize() {
        super.finalize();
        NativeDestructor();
    }

    static {
        k.b("FacePro", FaceProNative.class.getClassLoader());
        k.b("wechatvoicereco", FaceProNative.class.getClassLoader());
        k.b("wechatxlog", FaceProNative.class.getClassLoader());
        nativeInit();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int detectFaceCnt(java.lang.String r8) {
        /*
        r6 = -1;
        r1 = 1;
        r2 = 0;
        r3 = com.tencent.mm.plugin.facedetect.FaceProNative.class;
        monitor-enter(r3);
        r0 = hasDetectInit;	 Catch:{ all -> 0x0084 }
        if (r0 != 0) goto L_0x004d;
    L_0x000a:
        r0 = com.tencent.mm.plugin.facedetect.model.o.aHx();	 Catch:{ all -> 0x0084 }
        r4 = 0;
        r5 = -1;
        r0 = com.tencent.mm.modelsfs.FileOp.d(r0, r4, r5);	 Catch:{ all -> 0x0084 }
        r0 = nativeFacedetectInitBin(r0);	 Catch:{ all -> 0x0084 }
        if (r0 != r6) goto L_0x0030;
    L_0x001a:
        r0 = "MicroMsg.FaceProNative";
        r1 = "detectFaceCnt init failed: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0084 }
        r5 = 0;
        r6 = com.tencent.mm.plugin.facedetect.model.o.aHx();	 Catch:{ all -> 0x0084 }
        r4[r5] = r6;	 Catch:{ all -> 0x0084 }
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r4);	 Catch:{ all -> 0x0084 }
        monitor-exit(r3);	 Catch:{ all -> 0x0084 }
        r0 = r2;
    L_0x002f:
        return r0;
    L_0x0030:
        r4 = "MicroMsg.FaceProNative";
        r5 = "detectFaceCnt init:%d, %s";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0084 }
        r7 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0084 }
        r6[r7] = r0;	 Catch:{ all -> 0x0084 }
        r0 = 1;
        r7 = com.tencent.mm.plugin.facedetect.model.o.aHx();	 Catch:{ all -> 0x0084 }
        r6[r0] = r7;	 Catch:{ all -> 0x0084 }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ all -> 0x0084 }
        r0 = 1;
        hasDetectInit = r0;	 Catch:{ all -> 0x0084 }
    L_0x004d:
        monitor-exit(r3);	 Catch:{ all -> 0x0084 }
        r0 = com.tencent.mm.sdk.platformtools.d.Vq(r8);
        r3 = r0.outWidth;
        r0 = r0.outHeight;
        r0 = r0 * r3;
        r3 = 270000; // 0x41eb0 float:3.7835E-40 double:1.333977E-318;
        r0 = r0 / r3;
        r3 = 4;
        if (r0 < r3) goto L_0x008c;
    L_0x005e:
        r4 = (double) r0;
        r4 = java.lang.Math.sqrt(r4);
        r0 = (int) r4;
    L_0x0064:
        r3 = new android.graphics.BitmapFactory$Options;
        r3.<init>();
        r4 = android.graphics.Bitmap.Config.ARGB_8888;
        r3.inPreferredConfig = r4;
        r3.inSampleSize = r0;
        r0 = android.graphics.BitmapFactory.decodeFile(r8, r3);
        if (r0 != 0) goto L_0x0087;
    L_0x0075:
        r0 = "MicroMsg.FaceProNative";
        r3 = "detectFaceCnt  bitmap is null: %s";
        r1 = new java.lang.Object[r1];
        r1[r2] = r8;
        com.tencent.mm.sdk.platformtools.x.e(r0, r3, r1);
        r0 = r2;
        goto L_0x002f;
    L_0x0084:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0084 }
        throw r0;
    L_0x0087:
        r0 = nativeFacedetectWithBitmap(r0);
        goto L_0x002f;
    L_0x008c:
        r0 = r1;
        goto L_0x0064;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.FaceProNative.detectFaceCnt(java.lang.String):int");
    }

    @Keep
    public static String[] getDynamicValue(String str) {
        if (System.currentTimeMillis() - lastCheckTime >= TIMEOUT_CHECKER) {
            lastCheckTime = System.currentTimeMillis();
            String value = ((a) g.h(a.class)).Af().getValue(str);
            if (!bi.oN(value)) {
                try {
                    JSONArray jSONArray = new JSONArray(value);
                    ArrayList arrayList = new ArrayList(5);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    cachedStr = new String[length];
                    arrayList.toArray(cachedStr);
                } catch (Throwable e) {
                    x.printErrStackTrace(TAG, e, "hy: array resolve failed", new Object[0]);
                }
            }
        }
        return cachedStr;
    }
}
