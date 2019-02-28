package com.tencent.mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.TypedValue;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipFile;

public class PluginResourceLoader extends Resources {
    public Resources gIC;
    private Method gID;
    private Method gIE;
    private HashMap<String, ZipFile> gIF;
    private final b<WeakReference<ConstantState>> gIG;

    private XmlResourceParser b(String str, int i, int i2, String str2) {
        try {
            return (XmlResourceParser) this.gIE.invoke(this.gIC, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PluginResourceLoader", e, "", new Object[0]);
            return null;
        }
    }

    Drawable loadDrawable(TypedValue typedValue, int i) {
        return a(typedValue, i);
    }

    Drawable loadDrawable(TypedValue typedValue, int i, boolean z) {
        return a(typedValue, i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        InputStream openRawResource;
        InputStream inputStream = null;
        getValue(i, typedValue, true);
        try {
            openRawResource = super.openRawResource(i, typedValue);
        } catch (Exception e) {
            openRawResource = null;
        }
        if (openRawResource != null) {
            return openRawResource;
        }
        for (Entry value : this.gIF.entrySet()) {
            inputStream = b((ZipFile) value.getValue(), typedValue);
            if (inputStream != null) {
                return inputStream;
            }
        }
        return inputStream;
    }

    private Drawable a(TypedValue typedValue, int i) {
        try {
            return (Drawable) this.gID.invoke(this.gIC, new Object[]{typedValue, Integer.valueOf(i)});
        } catch (Exception e) {
        } catch (StackOverflowError e2) {
            x.e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
        }
        Drawable createFromXml;
        try {
            if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
                Object b = b(typedValue.string.toString(), i, typedValue.assetCookie, "drawable");
                createFromXml = Drawable.createFromXml(this, b);
                b.close();
                return createFromXml;
            }
        } catch (Exception e3) {
        }
        for (Entry value : this.gIF.entrySet()) {
            createFromXml = a((ZipFile) value.getValue(), typedValue);
            if (createFromXml != null) {
                return createFromXml;
            }
        }
        x.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        return null;
        while (r1.hasNext()) {
            createFromXml = a((ZipFile) value.getValue(), typedValue);
            if (createFromXml != null) {
                return createFromXml;
            }
        }
        x.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(java.util.zip.ZipFile r12, android.util.TypedValue r13) {
        /*
        r11 = this;
        r7 = 1;
        r1 = 0;
        r0 = r13.string;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r0 = r13.assetCookie;
        r2 = (long) r0;
        r0 = 32;
        r2 = r2 << r0;
        r0 = r13.data;
        r4 = (long) r0;
        r4 = r4 | r2;
        r0 = r11.gIG;
        r2 = r0.wi;
        r3 = r0.hX;
        r2 = com.tencent.mm.compatible.loader.b.b(r2, r3, r4);
        if (r2 < 0) goto L_0x0025;
    L_0x001d:
        r3 = r0.wj;
        r3 = r3[r2];
        r6 = com.tencent.mm.compatible.loader.b.wg;
        if (r3 != r6) goto L_0x0043;
    L_0x0025:
        r0 = r1;
    L_0x0026:
        r0 = (java.lang.ref.WeakReference) r0;
        if (r0 == 0) goto L_0x0064;
    L_0x002a:
        r0 = r0.get();
        r0 = (android.graphics.drawable.Drawable.ConstantState) r0;
        if (r0 == 0) goto L_0x0048;
    L_0x0032:
        r0 = r0.newDrawable(r11);
    L_0x0036:
        if (r0 == 0) goto L_0x0066;
    L_0x0038:
        r1 = "MicroMsg.PluginResourceLoader";
        r2 = "get form cache";
        com.tencent.mm.sdk.platformtools.x.v(r1, r2);
        r1 = r0;
        goto L_0x0006;
    L_0x0043:
        r0 = r0.wj;
        r0 = r0[r2];
        goto L_0x0026;
    L_0x0048:
        r0 = r11.gIG;
        r2 = r0.wi;
        r3 = r0.hX;
        r2 = com.tencent.mm.compatible.loader.b.b(r2, r3, r4);
        if (r2 < 0) goto L_0x0064;
    L_0x0054:
        r3 = r0.wj;
        r3 = r3[r2];
        r6 = com.tencent.mm.compatible.loader.b.wg;
        if (r3 == r6) goto L_0x0064;
    L_0x005c:
        r3 = r0.wj;
        r6 = com.tencent.mm.compatible.loader.b.wg;
        r3[r2] = r6;
        r0.wh = r7;
    L_0x0064:
        r0 = r1;
        goto L_0x0036;
    L_0x0066:
        r2 = r13.string;
        r2 = r2.toString();
        r3 = "MicroMsg.PluginResourceLoader";
        r6 = "try load drawable from zip, entry=%s, file=%s";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00c8 }
        r8 = 0;
        r7[r8] = r2;	 Catch:{ Exception -> 0x00c8 }
        r8 = 1;
        r9 = r12.getName();	 Catch:{ Exception -> 0x00c8 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x00c8 }
        com.tencent.mm.sdk.platformtools.x.v(r3, r6, r7);	 Catch:{ Exception -> 0x00c8 }
        r3 = r12.getEntry(r2);	 Catch:{ Exception -> 0x00c8 }
        r1 = r12.getInputStream(r3);	 Catch:{ Exception -> 0x00b5, all -> 0x00be }
        r0 = android.graphics.drawable.Drawable.createFromResourceStream(r11, r13, r1, r2);	 Catch:{ Exception -> 0x00b5, all -> 0x00eb }
        if (r1 == 0) goto L_0x0093;
    L_0x0090:
        r1.close();	 Catch:{ Exception -> 0x00e5 }
    L_0x0093:
        if (r0 != 0) goto L_0x00e3;
    L_0x0095:
        r1 = r12.getInputStream(r3);	 Catch:{ Exception -> 0x00ce, all -> 0x00d9 }
        r0 = android.graphics.drawable.Drawable.createFromStream(r1, r2);	 Catch:{ Exception -> 0x00ce, all -> 0x00d9 }
        if (r1 == 0) goto L_0x00e3;
    L_0x009f:
        r1.close();	 Catch:{ Exception -> 0x00cb }
        r1 = r0;
    L_0x00a3:
        if (r1 == 0) goto L_0x0006;
    L_0x00a5:
        r0 = r11.gIG;
        r2 = new java.lang.ref.WeakReference;
        r3 = r1.getConstantState();
        r2.<init>(r3);
        r0.put(r4, r2);
        goto L_0x0006;
    L_0x00b5:
        r6 = move-exception;
        if (r1 == 0) goto L_0x0093;
    L_0x00b8:
        r1.close();	 Catch:{ Exception -> 0x00bc }
        goto L_0x0093;
    L_0x00bc:
        r6 = move-exception;
        goto L_0x0093;
    L_0x00be:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
    L_0x00c2:
        if (r2 == 0) goto L_0x00c7;
    L_0x00c4:
        r2.close();	 Catch:{ Exception -> 0x00e7 }
    L_0x00c7:
        throw r1;	 Catch:{ Exception -> 0x00c8 }
    L_0x00c8:
        r1 = move-exception;
        r1 = r0;
        goto L_0x00a3;
    L_0x00cb:
        r1 = move-exception;
        r1 = r0;
        goto L_0x00a3;
    L_0x00ce:
        r2 = move-exception;
        if (r1 == 0) goto L_0x00e3;
    L_0x00d1:
        r1.close();	 Catch:{ Exception -> 0x00d6 }
        r1 = r0;
        goto L_0x00a3;
    L_0x00d6:
        r1 = move-exception;
        r1 = r0;
        goto L_0x00a3;
    L_0x00d9:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
        if (r2 == 0) goto L_0x00e2;
    L_0x00df:
        r2.close();	 Catch:{ Exception -> 0x00e9 }
    L_0x00e2:
        throw r1;	 Catch:{ Exception -> 0x00c8 }
    L_0x00e3:
        r1 = r0;
        goto L_0x00a3;
    L_0x00e5:
        r6 = move-exception;
        goto L_0x0093;
    L_0x00e7:
        r2 = move-exception;
        goto L_0x00c7;
    L_0x00e9:
        r2 = move-exception;
        goto L_0x00e2;
    L_0x00eb:
        r2 = move-exception;
        r10 = r2;
        r2 = r1;
        r1 = r10;
        goto L_0x00c2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.loader.PluginResourceLoader.a(java.util.zip.ZipFile, android.util.TypedValue):android.graphics.drawable.Drawable");
    }

    private static InputStream b(ZipFile zipFile, TypedValue typedValue) {
        InputStream inputStream = null;
        if (typedValue.string == null) {
            return inputStream;
        }
        try {
            x.d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", typedValue.string.toString(), zipFile.getName());
            return zipFile.getInputStream(zipFile.getEntry(typedValue.string.toString()));
        } catch (Exception e) {
            return inputStream;
        }
    }
}
