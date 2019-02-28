package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.mm.a.e;
import com.tencent.mm.bp.b;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ar;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class o {

    public static class a {
        public static byte[] f(byte[] bArr, String str) {
            int i;
            int i2;
            int i3 = 0;
            byte[] bytes = str.getBytes();
            byte[] bArr2 = new byte[256];
            for (i = 0; i < 256; i++) {
                bArr2[i] = (byte) i;
            }
            if (bytes == null || bytes.length == 0) {
                bArr2 = null;
            } else {
                i2 = 0;
                int i4 = 0;
                for (i = 0; i < 256; i++) {
                    i2 = (i2 + ((bytes[i4] & 255) + (bArr2[i] & 255))) & 255;
                    byte b = bArr2[i];
                    bArr2[i] = bArr2[i2];
                    bArr2[i2] = b;
                    i4 = (i4 + 1) % bytes.length;
                }
            }
            byte[] bArr3 = new byte[bArr.length];
            if (bArr2 != null) {
                i = 0;
                i2 = 0;
                while (i3 < bArr.length) {
                    i2 = (i2 + 1) & 255;
                    i = (i + (bArr2[i2] & 255)) & 255;
                    byte b2 = bArr2[i2];
                    bArr2[i2] = bArr2[i];
                    bArr2[i] = b2;
                    int i5 = ((bArr2[i2] & 255) + (bArr2[i] & 255)) & 255;
                    bArr3[i3] = (byte) (bArr2[i5] ^ bArr[i3]);
                    i3++;
                }
            }
            return bArr3;
        }
    }

    public static String a(FaceResult faceResult) {
        if (faceResult == null || faceResult.result != 0) {
            x.e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
            return null;
        }
        try {
            String str = aHw() + File.separator + "release_out.fd";
            hj hjVar = new hj();
            hjVar.vTF = b.be(faceResult.sidedata);
            hjVar.vTG = b.be(faceResult.data);
            byte[] toByteArray = hjVar.toByteArray();
            try {
                if (FileOp.mm(str)) {
                    FileOp.j(str, toByteArray);
                    return str;
                }
                x.e("MicroMsg.FaceUtils", "hy: create file failed!");
                return str;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in save debug jpeg", new Object[0]);
                return str;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.FaceUtils", e2, "", new Object[0]);
            return null;
        }
    }

    public static Bitmap Aq(String str) {
        try {
            if (bi.oN(str)) {
                x.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
                return null;
            }
            String str2 = com.tencent.mm.plugin.facedetect.model.a.a.mlE + ac.VF(str);
            if (new File(str2).exists()) {
                byte[] d = FileOp.d(str2, 0, -1);
                if (d != null) {
                    d = a.f(d, Ar(str));
                    if (d.length > 0) {
                        return com.tencent.mm.compatible.g.a.decodeByteArray(d, 0, d.length);
                    }
                    x.w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
                    return null;
                }
                x.w("MicroMsg.FaceUtils", "hy: nothing in file");
                return null;
            }
            x.w("MicroMsg.FaceUtils", "hy: no last file. return");
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in encrypt", new Object[0]);
            return null;
        }
    }

    public static boolean b(Bitmap bitmap, String str) {
        if (bitmap == null) {
            try {
                x.w("MicroMsg.FaceUtils", "hy: bm is null. abort");
                return false;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in encrypt", new Object[0]);
                return false;
            }
        } else if (bi.oN(str)) {
            x.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
            return false;
        } else {
            File file = new File(com.tencent.mm.plugin.facedetect.model.a.a.mlE);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = com.tencent.mm.plugin.facedetect.model.a.a.mlE + ac.VF(str);
            File file2 = new File(str2);
            if (!file2.exists()) {
                x.i("MicroMsg.FaceUtils", "hy: last file already exists. del");
                file2.createNewFile();
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (toByteArray != null) {
                byte[] f = a.f(toByteArray, Ar(str));
                if (f.length <= 0) {
                    x.w("MicroMsg.FaceUtils", "hy: enc err. return null");
                    return false;
                }
                FileOp.j(str2, f);
                return true;
            }
            x.w("MicroMsg.FaceUtils", "hy: nothing in stream");
            return false;
        }
    }

    private static String Ar(String str) {
        return Base64.encodeToString((str + str.hashCode()).getBytes(), 0);
    }

    public static boolean o(Activity activity) {
        boolean aZ = com.tencent.mm.pluginsdk.g.a.aZ(activity, "android.permission.CAMERA");
        boolean aZ2 = com.tencent.mm.pluginsdk.g.a.aZ(activity, "android.permission.RECORD_AUDIO");
        x.d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", Boolean.valueOf(aZ), Boolean.valueOf(aZ2), bi.chl(), activity);
        ArrayList arrayList = new ArrayList();
        if (!aZ) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!aZ2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (aZ && aZ2) {
            return true;
        }
        x.i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
        android.support.v4.app.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 23);
        return false;
    }

    public static void p(Activity activity) {
        activity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }

    public static boolean aHv() {
        boolean z;
        String aHx = aHx();
        String aHy = aHy();
        if (bi.oN(aHx) || bi.oN(aHy)) {
            x.w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
            z = false;
        } else {
            File file = new File(aHx);
            File file2 = new File(aHy);
            if (file.exists() || pP(0)) {
                z = true;
            } else {
                x.e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
                z = false;
            }
            if (!(file2.exists() || pP(1))) {
                x.e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
                z = false;
            }
        }
        if (!z) {
            x.i("MicroMsg.FaceUtils", "hy: trigger start download model file");
            g.CN().a(new m(42), 0);
        }
        return z;
    }

    public static String aHw() {
        String str;
        if (a.mlC) {
            str = h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "face_detect";
        } else {
            str = ad.getContext().getFilesDir().getParent() + File.separator + "face_detect";
        }
        File file = new File(str);
        if (!file.exists()) {
            x.i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
            file.mkdirs();
        }
        return str;
    }

    public static String aHx() {
        return aHw() + File.separator + "ufdmtcc.bin";
    }

    public static String aHy() {
        return aHw() + File.separator + "ufat.bin";
    }

    public static boolean pP(int i) {
        String str = "";
        switch (i) {
            case 0:
                str = ar.hhz.H("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
                break;
            case 1:
                str = ar.hhz.H("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
                break;
        }
        if (bi.oN(str)) {
            x.w("MicroMsg.FaceUtils", "hy: no such path for type: %d", Integer.valueOf(i));
            return false;
        } else if (new File(str).exists()) {
            File file = new File(pQ(i));
            if (file.exists()) {
                file.delete();
            }
            e.x(str, pQ(i));
            return true;
        } else {
            x.e("MicroMsg.FaceUtils", "originFile file not exist");
            return false;
        }
    }

    public static String pQ(int i) {
        switch (i) {
            case 0:
                return aHx();
            case 1:
                return aHy();
            default:
                return "";
        }
    }

    public static void m(Context context, String str, String str2) {
        Throwable e;
        InputStream inputStream = null;
        x.i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets src: %s, dst: %s", str, str2);
        InputStream open;
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str2);
            open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    x.i("MicroMsg.FaceUtils", "alvinluo copyFileFromAssets %s successfully, file len: %d", str, Long.valueOf(file.length()));
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    inputStream = open;
                    try {
                        x.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e4) {
                                return;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        e = th;
                        open = inputStream;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Exception e5) {
                                throw e;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (open != null) {
                        open.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                inputStream = open;
                x.printErrStackTrace("MicroMsg.FaceUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                if (open != null) {
                    open.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
        } catch (Throwable th4) {
            e = th4;
            fileOutputStream = null;
            open = null;
            if (open != null) {
                open.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }

    public static Bitmap n(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            bitmap2 = null;
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * 0.1f), Math.round(((float) bitmap.getHeight()) * 0.1f), false);
            bitmap2 = bitmap2.copy(bitmap2.getConfig(), true);
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            int[] iArr = new int[(width * height)];
            x.e("pix", width + " " + height + " " + iArr.length);
            bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
            int i = width - 1;
            int i2 = height - 1;
            int i3 = width * height;
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            int[] iArr4 = new int[i3];
            int[] iArr5 = new int[Math.max(width, height)];
            int[] iArr6 = new int[246016];
            for (int i4 = 0; i4 < 246016; i4++) {
                iArr6[i4] = i4 / 961;
            }
            int i5 = 0;
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{61, 3});
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int i8 = i5;
                int i9 = i6;
                int i10;
                int i11;
                int i12;
                int i13;
                int i14;
                int i15;
                int i16;
                int i17;
                int i18;
                if (i9 < height) {
                    i5 = 0;
                    if (b.cR(currentTimeMillis2)) {
                        bitmap2 = null;
                        break;
                    }
                    int[] iArr8;
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                    i13 = 0;
                    i14 = 0;
                    i15 = 0;
                    i16 = 0;
                    i6 = 0;
                    for (i17 = -30; i17 <= 30; i17++) {
                        i18 = iArr[Math.min(i, Math.max(i17, 0)) + i8];
                        iArr8 = iArr7[i17 + 30];
                        iArr8[0] = (16711680 & i18) >> 16;
                        iArr8[1] = (65280 & i18) >> 8;
                        iArr8[2] = i18 & 255;
                        i18 = 31 - Math.abs(i17);
                        i16 += iArr8[0] * i18;
                        i15 += iArr8[1] * i18;
                        i14 += i18 * iArr8[2];
                        if (i17 > 0) {
                            i10 += iArr8[0];
                            i6 += iArr8[1];
                            i5 += iArr8[2];
                        } else {
                            i13 += iArr8[0];
                            i12 += iArr8[1];
                            i11 += iArr8[2];
                        }
                    }
                    i17 = 30;
                    if (b.cR(currentTimeMillis2)) {
                        bitmap2 = null;
                        break;
                    }
                    for (i18 = 0; i18 < width; i18++) {
                        iArr2[i8] = iArr6[i16];
                        iArr3[i8] = iArr6[i15];
                        iArr4[i8] = iArr6[i14];
                        i16 -= i13;
                        i15 -= i12;
                        i14 -= i11;
                        iArr8 = iArr7[((i17 - 30) + 61) % 61];
                        i13 -= iArr8[0];
                        i12 -= iArr8[1];
                        i11 -= iArr8[2];
                        if (i9 == 0) {
                            iArr5[i18] = Math.min((i18 + 30) + 1, i);
                        }
                        int i19 = iArr[iArr5[i18] + i7];
                        iArr8[0] = (16711680 & i19) >> 16;
                        iArr8[1] = (65280 & i19) >> 8;
                        iArr8[2] = i19 & 255;
                        i10 += iArr8[0];
                        i6 += iArr8[1];
                        i5 += iArr8[2];
                        i16 += i10;
                        i15 += i6;
                        i14 += i5;
                        i17 = (i17 + 1) % 61;
                        iArr8 = iArr7[i17 % 61];
                        i13 += iArr8[0];
                        i12 += iArr8[1];
                        i11 += iArr8[2];
                        i10 -= iArr8[0];
                        i6 -= iArr8[1];
                        i5 -= iArr8[2];
                        i8++;
                    }
                    i5 = i7 + width;
                    i6 = i9 + 1;
                } else {
                    for (i17 = 0; i17 < width; i17++) {
                        i6 = 0;
                        i10 = width * -30;
                        if (b.cR(currentTimeMillis2)) {
                            bitmap2 = null;
                            break;
                        }
                        int[] iArr9;
                        i11 = 0;
                        i12 = 0;
                        i13 = 0;
                        i8 = 0;
                        i14 = 0;
                        i15 = 0;
                        i16 = 0;
                        i5 = i10;
                        i10 = 0;
                        for (i18 = -30; i18 <= 30; i18++) {
                            i7 = Math.max(0, i5) + i17;
                            iArr9 = iArr7[i18 + 30];
                            iArr9[0] = iArr2[i7];
                            iArr9[1] = iArr3[i7];
                            iArr9[2] = iArr4[i7];
                            i = 31 - Math.abs(i18);
                            i16 += iArr2[i7] * i;
                            i15 += iArr3[i7] * i;
                            i14 += iArr4[i7] * i;
                            if (i18 > 0) {
                                i11 += iArr9[0];
                                i10 += iArr9[1];
                                i6 += iArr9[2];
                            } else {
                                i8 += iArr9[0];
                                i13 += iArr9[1];
                                i12 += iArr9[2];
                            }
                            if (i18 < i2) {
                                i5 += width;
                            }
                        }
                        if (b.cR(currentTimeMillis2)) {
                            bitmap2 = null;
                            break;
                        }
                        i7 = i16;
                        i16 = i15;
                        i15 = i14;
                        i18 = 30;
                        i5 = i6;
                        i6 = i10;
                        i10 = i11;
                        i11 = i12;
                        i12 = i13;
                        i13 = i8;
                        i8 = i17;
                        for (i14 = 0; i14 < height; i14++) {
                            iArr[i8] = (((WebView.NIGHT_MODE_COLOR & iArr[i8]) | (iArr6[i7] << 16)) | (iArr6[i16] << 8)) | iArr6[i15];
                            i7 -= i13;
                            i16 -= i12;
                            i15 -= i11;
                            iArr9 = iArr7[((i18 - 30) + 61) % 61];
                            i13 -= iArr9[0];
                            i12 -= iArr9[1];
                            i11 -= iArr9[2];
                            if (i17 == 0) {
                                iArr5[i14] = Math.min(i14 + 31, i2) * width;
                            }
                            i = iArr5[i14] + i17;
                            iArr9[0] = iArr2[i];
                            iArr9[1] = iArr3[i];
                            iArr9[2] = iArr4[i];
                            i10 += iArr9[0];
                            i6 += iArr9[1];
                            i5 += iArr9[2];
                            i7 += i10;
                            i16 += i6;
                            i15 += i5;
                            i18 = (i18 + 1) % 61;
                            iArr9 = iArr7[i18];
                            i13 += iArr9[0];
                            i12 += iArr9[1];
                            i11 += iArr9[2];
                            i10 -= iArr9[0];
                            i6 -= iArr9[1];
                            i5 -= iArr9[2];
                            i8 += width;
                        }
                    }
                    x.e("pix", width + " " + height + " " + i3);
                    bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
                }
            }
        }
        x.i("MicroMsg.FaceUtils", "hy: blur using %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        Object obj = 1;
        if (bitmap2 == null) {
            x.w("MicroMsg.FaceUtils", "hy: null on blur. use default");
            obj = null;
            bitmap2 = Aq(str);
            if (bitmap2 == null) {
                bitmap2 = d.Ds(com.tencent.mm.plugin.facedetect.a.d.mim);
            }
        }
        if (obj != null) {
            final String str2 = str;
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    long Wz = bi.Wz();
                    o.b(bitmap2, str2);
                    x.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", Long.valueOf(bi.bB(Wz)));
                }
            }, "FaceUtils_SaveFile");
        }
        return bitmap2;
    }

    public static String tu(String str) {
        return com.tencent.mm.a.g.s((bi.Wz() + ", " + str).getBytes());
    }
}
