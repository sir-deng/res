package com.tencent.mm.af;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class m {

    public static final class a {
        List<a> hrJ = new ArrayList();
        Map<String, Integer> hrK = new HashMap();
        Map<String, WeakReference<Bitmap>> hrL = new HashMap();
        at hrM = null;

        public interface a {
            void kl(String str);
        }

        public final void a(a aVar) {
            this.hrJ.add(aVar);
        }

        public final void b(a aVar) {
            this.hrJ.remove(aVar);
        }

        public final void Mf() {
            this.hrJ.clear();
        }

        public static String kk(String str) {
            if (g.Do().CF()) {
                return ((o) g.h(o.class)).FC() + "/brand_" + com.tencent.mm.a.g.s(str.getBytes());
            }
            return "";
        }

        final void f(String str, Bitmap bitmap) {
            Bitmap bitmap2 = this.hrL.containsKey(str) ? (Bitmap) ((WeakReference) this.hrL.get(str)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                try {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, FileUtils.S_IWUSR, FileUtils.S_IWUSR, true);
                    bitmap2 = d.a(bitmap2, true, (float) (bitmap2.getWidth() >> 1));
                } catch (OutOfMemoryError e) {
                    bitmap2 = bitmap;
                }
                this.hrL.remove(str);
                this.hrL.put(str, new WeakReference(bitmap2));
            }
            if (bitmap2 != bitmap) {
                x.i("MicroMsg.BrandLogic", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        }
    }

    private static class b implements com.tencent.mm.sdk.platformtools.at.a {
        public byte[] hmC = null;
        private final String hrN;
        private final String url;

        public b(String str, String str2) {
            this.hrN = str;
            this.url = str2;
        }

        public final boolean JH() {
            if (bi.oN(this.hrN) || bi.oN(this.url)) {
                return false;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream l = com.tencent.mm.network.b.l(this.url, 3000, 5000);
                if (l == null) {
                    return false;
                }
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = l.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                l.close();
                this.hmC = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (bi.by(this.hmC)) {
                    x.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.hrN);
                    return false;
                }
                if (g.Do().CF()) {
                    com.tencent.mm.y.ak.a.hhw.aV(this.hmC.length, 0);
                    a Mt = y.Mt();
                    String str = this.hrN;
                    String str2 = this.url;
                    byte[] bArr2 = this.hmC;
                    try {
                        str2 = str + str2;
                        Bitmap bn = d.bn(bArr2);
                        d.a(bn, 100, CompressFormat.PNG, a.kk(str2), false);
                        Mt.f(str, bn);
                        x.i("MicroMsg.BrandLogic", "update brand icon for  " + str + ", done");
                        Mt.hrK.remove(str);
                    } catch (Throwable e) {
                        x.e("MicroMsg.BrandLogic", "exception:%s", bi.i(e));
                    }
                }
                return true;
            } catch (Throwable e2) {
                x.e("MicroMsg.BrandLogic", "exception:%s", bi.i(e2));
                x.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
                this.hmC = null;
                return false;
            }
        }

        public final boolean JI() {
            a Mt = y.Mt();
            String str = this.hrN;
            int i = 0;
            while (i < Mt.hrJ.size()) {
                try {
                    ((a) Mt.hrJ.get(i)).kl(str);
                    i++;
                } catch (Throwable e) {
                    x.e("MicroMsg.BrandLogic", "exception:%s", bi.i(e));
                }
            }
            return false;
        }
    }

    public static Bitmap ki(String str) {
        boolean z = false;
        if (bi.oN(str) || !g.Dq().isSDCardAvailable() || !g.Do().CF()) {
            return null;
        }
        Bitmap bitmap;
        a Mt = y.Mt();
        String format = String.format("%s%f", new Object[]{str, Float.valueOf(1.5f)});
        if (Mt.hrL.containsKey(format)) {
            bitmap = (Bitmap) ((WeakReference) Mt.hrL.get(format)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(str, 1.5f);
                Mt.hrL.remove(format);
                Mt.hrL.put(format, new WeakReference(bitmap));
            }
        } else {
            bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(str, 1.5f);
            Mt.hrL.put(format, new WeakReference(bitmap));
        }
        String str2 = "MicroMsg.BrandLogic";
        format = "get verify user icon = %s, is null ? %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (bitmap == null) {
            z = true;
        }
        objArr[1] = String.valueOf(z);
        x.i(str2, format, objArr);
        return bitmap;
    }

    public static Bitmap d(final String str, String str2, int i) {
        if (!g.Dq().isSDCardAvailable()) {
            return hw(i);
        }
        if (str == null || !g.Do().CF()) {
            return null;
        }
        Bitmap bitmap;
        if (str2 == null) {
            str2 = ag(str, null);
            if (str2 == null) {
                return null;
            }
        }
        a Mt = y.Mt();
        WeakReference weakReference;
        if (Mt.hrL.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) Mt.hrL.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = d.Vs(a.kk(str + ag(str, str2)));
                if (bitmap == null) {
                    x.i("MicroMsg.BrandLogic", "not found brand icon local");
                } else {
                    Mt.f(str, bitmap);
                }
            }
            weakReference = (WeakReference) Mt.hrL.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                ah.y(new Runnable() {
                    public final void run() {
                        a Mt = y.Mt();
                        String str = str;
                        String str2 = str2;
                        if (bi.oN(str) || bi.oN(str2)) {
                            x.e("MicroMsg.BrandLogic", "pushing for brand " + str + ", url " + str2);
                        } else if (bi.bz((long) bi.e((Integer) Mt.hrK.get(str))) < 300) {
                            x.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for " + str);
                        } else {
                            Mt.hrK.put(str, Integer.valueOf((int) bi.Wx()));
                            if (Mt.hrM == null || Mt.hrM.cgG()) {
                                Mt.hrM = new at(1, "brand-logic");
                            }
                            Mt.hrM.c(new b(str, m.ag(str, str2)));
                        }
                    }
                });
                return null;
            }
        }
        bitmap = d.Vs(a.kk(str + ag(str, str2)));
        if (bitmap == null) {
            x.i("MicroMsg.BrandLogic", "not found brand icon local");
        } else {
            Mt.f(str, bitmap);
            weakReference = (WeakReference) Mt.hrL.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                ah.y(/* anonymous class already generated */);
                return null;
            }
        }
        bitmap = null;
        if (bitmap == null) {
            return bitmap;
        }
        ah.y(/* anonymous class already generated */);
        return null;
    }

    public static Bitmap kj(String str) {
        if (!g.Dq().isSDCardAvailable()) {
            return hw(0);
        }
        if (str == null || !g.Do().CF()) {
            return null;
        }
        Bitmap bitmap;
        a Mt = y.Mt();
        if (Mt.hrL.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) Mt.hrL.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
        }
        bitmap = null;
        return bitmap;
    }

    private static Bitmap hw(int i) {
        Throwable th;
        if (i <= 0) {
            return null;
        }
        Options options = new Options();
        d.c(options);
        InputStream openRawResource;
        try {
            openRawResource = ad.getContext().getResources().openRawResource(i);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(openRawResource, null, options);
                if (openRawResource != null) {
                    try {
                        openRawResource.close();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BrandLogic", e, "", new Object[0]);
                    }
                }
                if (decodeStream != null) {
                    return d.a(decodeStream, false, (float) (decodeStream.getWidth() >> 1));
                }
                return decodeStream;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable e2) {
            Throwable th3 = e2;
            openRawResource = null;
            th = th3;
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.BrandLogic", e22, "", new Object[0]);
                }
            }
            throw th;
        }
    }

    static String ag(String str, String str2) {
        if (str == null || !g.Do().CF()) {
            return null;
        }
        d jN = y.Ml().jN(str);
        if (jN.field_brandIconURL != null) {
            return jN.field_brandIconURL;
        }
        return str2;
    }
}
