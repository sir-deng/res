package com.tencent.mm.ac;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public final class d {
    private static int hmG = 150;
    private static int hmH = 150;
    static final Map<String, Integer> hmI;
    private static a hmM = new a(hmH);
    private k<a, String> hmJ = new k<a, String>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((a) obj).jk((String) obj2);
        }
    };
    private Vector<WeakReference<a>> hmK = new Vector();
    private final a hmL = new a() {
        public final void jk(String str) {
            Collection vector = new Vector();
            x.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", str, Integer.valueOf(d.this.hmK.size()), Integer.valueOf(d.this.hmK.size()));
            Vector vector2 = new Vector();
            synchronized (d.this.hmK) {
                for (int i = 0; i < d.this.hmK.size(); i++) {
                    WeakReference weakReference = (WeakReference) d.this.hmK.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            vector2.add(aVar);
                        } else {
                            vector.add(weakReference);
                        }
                    }
                }
                d.this.hmK.removeAll(vector);
            }
            for (int i2 = 0; i2 < vector2.size(); i2++) {
                ((a) vector2.get(i2)).jk(str);
            }
        }
    };

    public interface a {
        void jk(String str);
    }

    public static class b {
        public static boolean jl(String str) {
            Bitmap jm = jm(str);
            if (jm == null || jm.isRecycled()) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = FileOp.iH(str);
                jm.compress(CompressFormat.PNG, 100, outputStream);
                FileOp.deleteFile(str + ".bm");
                if (outputStream == null) {
                    return true;
                }
                try {
                    outputStream.close();
                    return true;
                } catch (IOException e) {
                    return true;
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.AvatarStorage", e2, "Cannot write avatar file: %s", str);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }

        public static Bitmap jm(String str) {
            Exception e;
            OutOfMemoryError e2;
            String str2 = str + ".bm";
            InputStream openRead;
            ReadableByteChannel newChannel;
            try {
                if (FileOp.bO(str2)) {
                    int mi = (int) FileOp.mi(str2);
                    if (mi <= 0 || !(mi == 36864 || mi == 36880)) {
                        es(str);
                        x.e("MicroMsg.AvatarStorage", "SmallBM get bm invalid size:%d file:%s", Integer.valueOf(mi), str2);
                        return null;
                    }
                    openRead = FileOp.openRead(str2);
                    try {
                        newChannel = Channels.newChannel(openRead);
                        try {
                            boolean z;
                            Buffer allocateDirect = ByteBuffer.allocateDirect(36864);
                            newChannel.read(allocateDirect);
                            allocateDirect.position(0);
                            if (mi == 36880) {
                                ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(16);
                                newChannel.read(allocateDirect2);
                                if (allocateDirect2.getLong(0) != 1) {
                                    x.e("MicroMsg.AvatarStorage", "SmallBM get bm header invalid flag:%d size:%d file:%s", Long.valueOf(allocateDirect2.getLong(0)), Integer.valueOf(mi), str2);
                                    newChannel.close();
                                    openRead.close();
                                    es(str);
                                    return null;
                                }
                                z = false;
                            } else {
                                z = true;
                            }
                            x.d("MicroMsg.AvatarStorage", "SmallBM get bm size:%d shouldRemoveCorner:%b file:%s", Integer.valueOf(mi), Boolean.valueOf(z), str2);
                            newChannel.close();
                            openRead.close();
                            Bitmap createBitmap = Bitmap.createBitmap(96, 96, Config.ARGB_8888);
                            createBitmap.copyPixelsFromBuffer(allocateDirect);
                            if (!z) {
                                return createBitmap;
                            }
                            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 9, 9, 78, 78);
                            x.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", createBitmap.toString());
                            createBitmap.recycle();
                            return createBitmap2;
                        } catch (Exception e3) {
                            e = e3;
                            x.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                            if (newChannel != null) {
                                try {
                                    newChannel.close();
                                } catch (Exception e4) {
                                    return null;
                                }
                            }
                            if (openRead == null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        } catch (OutOfMemoryError e5) {
                            e2 = e5;
                            x.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                            if (newChannel != null) {
                                newChannel.close();
                            }
                            if (openRead == null) {
                                return null;
                            }
                            openRead.close();
                            return null;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        newChannel = null;
                        x.e("MicroMsg.AvatarStorage", "SmallBM get exception e:%s file:%s", e.getMessage(), str2);
                        if (newChannel != null) {
                            newChannel.close();
                        }
                        if (openRead == null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    } catch (OutOfMemoryError e7) {
                        e2 = e7;
                        newChannel = null;
                        x.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                        if (newChannel != null) {
                            newChannel.close();
                        }
                        if (openRead == null) {
                            return null;
                        }
                        openRead.close();
                        return null;
                    }
                }
                x.w("MicroMsg.AvatarStorage", "SmallBM get bm file not exsit:%s", str2);
                return null;
            } catch (Exception e8) {
                e = e8;
                newChannel = null;
                openRead = null;
            } catch (OutOfMemoryError e9) {
                e2 = e9;
                newChannel = null;
                openRead = null;
                x.e("MicroMsg.AvatarStorage", "SmallBM get OutOfMemoryError e:%s file:%s", e2.getMessage(), str2);
                if (newChannel != null) {
                    newChannel.close();
                }
                if (openRead == null) {
                    return null;
                }
                openRead.close();
                return null;
            }
        }

        static boolean es(String str) {
            FileOp.deleteFile(str + ".bm");
            FileOp.deleteFile(str);
            return true;
        }
    }

    static {
        Map hashMap = new HashMap();
        hmI = hashMap;
        hashMap.put("voipapp", Integer.valueOf(g.lua));
        hmI.put("qqmail", Integer.valueOf(g.ltU));
        hmI.put("fmessage", Integer.valueOf(g.ltM));
        hmI.put("floatbottle", Integer.valueOf(g.ltJ));
        hmI.put("lbsapp", Integer.valueOf(g.ltQ));
        hmI.put("shakeapp", Integer.valueOf(g.ltX));
        hmI.put("medianote", Integer.valueOf(g.ltP));
        hmI.put("qqfriend", Integer.valueOf(g.ltT));
        hmI.put("masssendapp", Integer.valueOf(g.ltO));
        hmI.put("feedsapp", Integer.valueOf(g.ltL));
        hmI.put("facebookapp", Integer.valueOf(g.dyw));
        hmI.put("newsapp", Integer.valueOf(g.ltV));
        hmI.put("helper_entry", Integer.valueOf(g.ltS));
        hmI.put("voicevoipapp", Integer.valueOf(g.ltZ));
        hmI.put("voiceinputapp", Integer.valueOf(g.ltY));
        hmI.put("officialaccounts", Integer.valueOf(g.ltK));
        hmI.put("service_officialaccounts", Integer.valueOf(g.ltW));
        hmI.put("linkedinplugin", Integer.valueOf(g.ltN));
        hmI.put("notifymessage", Integer.valueOf(g.ltR));
        hmI.put("appbrandcustomerservicemsg", Integer.valueOf(g.ltI));
    }

    public static void a(Context context, ImageView imageView, int i) {
        try {
            imageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.compatible.g.a.decodeResource(context.getResources(), i), true, 1.0f));
        } catch (Throwable e) {
            x.e("MicroMsg.AvatarStorage", "exception:%s", bi.i(e));
        }
    }

    public d() {
        reset();
        this.hmJ.a(this.hmL, null);
    }

    public final void a(a aVar) {
        synchronized (this.hmK) {
            this.hmK.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        synchronized (this.hmK) {
            this.hmK.remove(c(aVar));
        }
    }

    private WeakReference<a> c(a aVar) {
        synchronized (this.hmK) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hmK.size()) {
                    WeakReference<a> weakReference = (WeakReference) this.hmK.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            return weakReference;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return null;
                }
            }
        }
    }

    @Deprecated
    public final void d(a aVar) {
        this.hmJ.a(aVar, Looper.getMainLooper());
    }

    @Deprecated
    public final void e(a aVar) {
        this.hmJ.remove(aVar);
    }

    public static void reset() {
        if (hmM == null) {
            hmM = new a(hmH);
        }
    }

    public static Bitmap jf(String str) {
        if (bi.oN(str)) {
            return null;
        }
        a aVar = hmM;
        Bitmap bitmap = aVar.hmo != null ? (Bitmap) aVar.hmo.get(str) : (Bitmap) com.tencent.mm.cache.e.a.D("avatar_cache", str);
        if (bitmap == null) {
            return null;
        }
        if (!bitmap.isRecycled()) {
            return bitmap;
        }
        aVar = hmM;
        if (aVar.hmo != null) {
            aVar.hmo.remove(str);
        } else {
            com.tencent.mm.cache.e.a.E("avatar_cache", str);
        }
        return null;
    }

    public final void d(String str, Bitmap bitmap) {
        a aVar = hmM;
        if (aVar.hmo != null) {
            aVar.hmo.l(str, bitmap);
        } else {
            com.tencent.mm.cache.e.a.a("avatar_cache", str, (Object) bitmap);
        }
        this.hmJ.cb(str);
        this.hmJ.doNotify();
        x.d("MicroMsg.AvatarStorage", "setToCache %s", str);
    }

    public final Bitmap bg(Context context) {
        context.getResources();
        Bitmap jf = jf("I_AM_NO_SDCARD_USER_NAME");
        if (m(jf) || jf == null) {
            return jf;
        }
        x.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", Boolean.valueOf(jf.isRecycled()), "I_AM_NO_SDCARD_USER_NAME");
        jf = com.tencent.mm.sdk.platformtools.d.a(jf, true, 1.0f);
        d("I_AM_NO_SDCARD_USER_NAME", jf);
        return jf;
    }

    public static String x(String str, boolean z) {
        if (bi.oN(str)) {
            return null;
        }
        String a = i.a(com.tencent.mm.plugin.f.a.aoL(), "user_" + (z ? "hd_" : ""), com.tencent.mm.a.g.s(str.getBytes()), ".png", 1, false);
        if (a == null) {
            return null;
        }
        return !FileOp.ml(new File(a).getParent()) ? null : a;
    }

    public static boolean y(String str, boolean z) {
        String x = x(str, z);
        x.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", str, Boolean.valueOf(z), x);
        boolean deleteFile = FileOp.deleteFile(x);
        if (z) {
            return deleteFile;
        }
        return deleteFile | b.es(x);
    }

    public static Bitmap jg(String str) {
        return jj(x(str, false));
    }

    public static Bitmap e(String str, byte[] bArr) {
        Throwable e;
        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(bArr, 96, 96, 0, 0, 1);
        if (m(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
            OutputStream iH;
            try {
                iH = FileOp.iH(x(str, false));
                try {
                    iH.write(bArr, 0, bArr.length);
                    if (iH != null) {
                        try {
                            iH.close();
                        } catch (IOException e2) {
                        }
                    }
                    x.i("MicroMsg.AvatarStorage", "Saved avatar: %s", str);
                    return a;
                } catch (IOException e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                        if (iH != null) {
                            try {
                                iH.close();
                            } catch (IOException e4) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (iH != null) {
                            try {
                                iH.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                iH = null;
                x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                if (iH != null) {
                    iH.close();
                }
                return null;
            } catch (Throwable th2) {
                e = th2;
                iH = null;
                if (iH != null) {
                    iH.close();
                }
                throw e;
            }
        }
        x.e("MicroMsg.AvatarStorage", "Failed to decode avatar: %s", str);
        return null;
    }

    public final boolean f(String str, byte[] bArr) {
        Bitmap e = e(str, bArr);
        if (!m(e)) {
            return false;
        }
        d(str, e);
        return true;
    }

    public final boolean ac(String str, String str2) {
        int i = 96;
        try {
            int i2;
            Options Vq = com.tencent.mm.sdk.platformtools.d.Vq(str);
            int i3 = Vq.outWidth;
            int i4 = Vq.outHeight;
            if (i4 < i3) {
                i2 = (i3 * 96) / i4;
            } else {
                i2 = 96;
                i = (i4 * 96) / i3;
            }
            x.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(1));
            Options options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            options.inSampleSize = Math.min(i3 / i2, i4 / i);
            return e(str2, com.tencent.mm.sdk.platformtools.d.a(str, options, 0, 0, 1));
        } catch (Throwable e) {
            x.e("MicroMsg.AvatarStorage", "exception:%s", bi.i(e));
            return false;
        }
    }

    boolean e(String str, Bitmap bitmap) {
        Throwable e;
        OutputStream outputStream;
        if (!m(bitmap)) {
            return false;
        }
        Bitmap bitmap2;
        if (bitmap.getWidth() == 96 && bitmap.getHeight() == 96) {
            bitmap2 = bitmap;
        } else {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width != height) {
                    if (width > height) {
                        bitmap2 = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
                    } else {
                        bitmap2 = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
                    }
                    bitmap2 = Bitmap.createScaledBitmap(bitmap2, 96, 96, true);
                } else {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, 96, 96, true);
                }
            } catch (OutOfMemoryError e2) {
                x.e("MicroMsg.AvatarStorage", "kevin updateAvatar fail  %s ", str);
                if (m(bitmap)) {
                    x.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                return false;
            }
        }
        if (!(bitmap2 == null || bitmap2 == bitmap)) {
            x.i("MicroMsg.AvatarStorage", "recycle bitmap:%s", bitmap.toString());
            bitmap.recycle();
            bitmap = bitmap2;
        }
        OutputStream outputStream2 = null;
        try {
            outputStream2 = FileOp.iH(x(str, false));
            try {
                bitmap.compress(CompressFormat.PNG, 100, outputStream2);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                d(str, bitmap);
                return true;
            } catch (IOException e4) {
                e = e4;
                outputStream = outputStream2;
                try {
                    x.printErrStackTrace("MicroMsg.AvatarStorage", e, "Failed to save avatar: %s", str);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                outputStream = outputStream2;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e;
            }
        } catch (IOException e7) {
            e = e7;
            outputStream = outputStream2;
        } catch (Throwable th3) {
            e = th3;
            outputStream = outputStream2;
            if (outputStream != null) {
                outputStream.close();
            }
            throw e;
        }
    }

    public static Bitmap jh(String str) {
        x.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", str);
        if (bi.oN(str)) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.d.a(x(str, true), 480, 480, null, 0, 0, 1);
    }

    public static Bitmap ji(String str) {
        Bitmap decodeResource;
        int i = 0;
        if (hmI.containsKey(str)) {
            i = ((Integer) hmI.get(str)).intValue();
        }
        if (i != 0) {
            n.JV();
            decodeResource = com.tencent.mm.compatible.g.a.decodeResource(n.getContext().getResources(), i);
        } else {
            decodeResource = null;
        }
        return com.tencent.mm.sdk.platformtools.d.a(decodeResource, true, 1.0f, true);
    }

    private static boolean m(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public static Bitmap jj(String str) {
        Bitmap a = FileOp.bO(str) ? com.tencent.mm.sdk.platformtools.d.a(str, null, 0, 0, 1) : null;
        if (a == null) {
            a = b.jm(str);
        }
        if (m(a)) {
            int width = a.getWidth();
            int height = a.getHeight();
            if (width != height) {
                if (width > height) {
                    a = Bitmap.createBitmap(a, (width - height) / 2, 0, height, height);
                } else {
                    a = Bitmap.createBitmap(a, 0, (height - width) / 2, width, width);
                }
            }
        }
        return m(a) ? a : null;
    }
}
