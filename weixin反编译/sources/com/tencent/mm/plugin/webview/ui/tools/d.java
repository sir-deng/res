package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.bu.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d {
    private static final HashMap<String, WeakReference<Bitmap>> tDy = new HashMap();

    public static void a(com.tencent.mm.plugin.webview.stub.d dVar, int i, Object... objArr) {
        List arrayList = new ArrayList();
        if (objArr != null && objArr.length != 0) {
            try {
                for (Object valueOf : objArr) {
                    arrayList.add(String.valueOf(valueOf));
                }
                dVar.f(i, arrayList);
            } catch (Exception e) {
                x.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + e.getMessage());
            }
        }
    }

    public static void a(com.tencent.mm.plugin.webview.stub.d dVar, int i, List<String> list) {
        if (list != null && list.size() != 0) {
            try {
                dVar.f(i, list);
            } catch (Exception e) {
                x.w("MicroMsg.WebView.RemoteUtil", "kvReport, ex = " + e.getMessage());
            }
        }
    }

    public static Bitmap PH(String str) {
        WeakReference weakReference = (WeakReference) tDy.get(str);
        if (weakReference != null && weakReference.get() != null && !((Bitmap) weakReference.get()).isRecycled()) {
            return (Bitmap) weakReference.get();
        }
        Bitmap decodeFile;
        if (FileOp.bO(str)) {
            decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
        } else {
            decodeFile = null;
        }
        if (decodeFile != null) {
            tDy.put(str, new WeakReference(decodeFile));
            return decodeFile;
        }
        try {
            decodeFile = b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
            tDy.put(str, new WeakReference(decodeFile));
            return decodeFile;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e, "", new Object[0]);
            return decodeFile;
        }
    }

    public static int aM(String str, int i) {
        return (int) v(str, Long.valueOf((long) i).longValue());
    }

    private static long v(String str, long j) {
        if (bi.oN(str)) {
            return j;
        }
        if (str.startsWith("#") && str.length() == 4) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.insert(2, str.charAt(1));
            stringBuilder.insert(4, str.charAt(2));
            stringBuilder.insert(6, str.charAt(3));
            str = stringBuilder.toString();
        }
        try {
            return 4294967295L & ((long) Color.parseColor(str));
        } catch (Exception e) {
            x.e("MicroMsg.WebView.RemoteUtil", "Failed to parse color: %s", str);
            return j;
        }
    }

    public static Bitmap PI(String str) {
        if (bi.oN(str)) {
            return null;
        }
        WeakReference weakReference = (WeakReference) tDy.get(str);
        if (weakReference != null && weakReference.get() != null && !((Bitmap) weakReference.get()).isRecycled()) {
            return (Bitmap) weakReference.get();
        }
        byte[] decode = Base64.decode(str, 0);
        if (decode == null) {
            return null;
        }
        Bitmap decodeByteArray;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        int min = Math.min(options.outWidth, options.outHeight);
        options.inJustDecodeBounds = false;
        if (min > 96) {
            options.inSampleSize = Math.max((int) ((((float) min) * 1.0f) / 96.0f), 1);
            decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (decodeByteArray == null) {
                return null;
            }
            i = decodeByteArray.getWidth();
            i2 = decodeByteArray.getHeight();
            min = Math.min(i, i2);
        } else {
            decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (decodeByteArray == null) {
                return null;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, Math.max((i / 2) - (min / 2), 0), Math.max((i2 / 2) - (min / 2), 0), min, min);
        if (createBitmap != decodeByteArray) {
            decodeByteArray.recycle();
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, 96, 96, false);
        if (createBitmap != createScaledBitmap) {
            createBitmap.recycle();
        }
        if (createScaledBitmap == null || createScaledBitmap.isRecycled()) {
            return createScaledBitmap;
        }
        tDy.put(str, new WeakReference(createScaledBitmap));
        return createScaledBitmap;
    }

    public static int j(int i, float f) {
        return ae.d(i, WebView.NIGHT_MODE_COLOR, f);
    }

    public static void a(Bundle bundle, String str, String str2, e eVar, Runnable runnable) {
        if (eVar != null) {
            Bundle bundle2 = new Bundle(3);
            bundle2.putBundle("open_ui_with_webview_ui_extras", bundle);
            bundle2.putString("open_ui_with_webview_ui_plugin_name", str);
            bundle2.putString("open_ui_with_webview_ui_plugin_entry", str2);
            try {
                eVar.e(101, bundle2);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebView.RemoteUtil", e, "startUIWithWebViewUI, exp, pluginName %s, pluginEntry %s", str, str2);
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
