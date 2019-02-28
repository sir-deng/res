package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final String hlB;
    private final g hlA;
    private final Map<h, String> hlv;
    private final Map<String, h> hlw;
    private final Map<Integer, String> hlx;
    private final d hly;
    private final i hlz;

    public interface i {
        void c(String str, Bitmap bitmap);

        void g(Bitmap bitmap);

        Bitmap iJ(String str);
    }

    private static class j implements h {
        final String aAM;
        private final WeakReference<ImageView> hlN;
        private final b hlO;
        boolean hlP;

        /* synthetic */ j(ImageView imageView, b bVar, byte b) {
            this(imageView, bVar);
        }

        final ImageView Jx() {
            return (ImageView) this.hlN.get();
        }

        private j(ImageView imageView, b bVar) {
            this.hlP = false;
            this.hlN = new WeakReference(imageView);
            this.hlO = bVar;
            this.aAM = "ImageView#" + imageView.hashCode();
        }

        private void Jy() {
            if (this.hlN.get() != null) {
                this.hlO.hlx.remove(Integer.valueOf(((ImageView) this.hlN.get()).hashCode()));
            }
        }

        public void Js() {
        }

        public final void j(Bitmap bitmap) {
            Jy();
            ImageView imageView = (ImageView) this.hlN.get();
            if (imageView != null) {
                if (!ah.isMainThread()) {
                    x.j("MicroMsg.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
                }
                imageView.setImageDrawable(new e(imageView.getResources(), bitmap));
            }
            this.hlP = true;
        }

        public final void Jt() {
            Jy();
        }

        public final String Ju() {
            return this.aAM;
        }
    }

    private static final class l {
        static final b hma = new b();
    }

    private static final class k implements a {
        final g hlA;
        final b hlO;
        final String hlQ;
        private final f hlR;
        private final i hlS;
        private final e hlT;
        private final String hlU;
        boolean hlV;

        /* synthetic */ k(String str, f fVar, b bVar, i iVar, g gVar, e eVar, String str2, byte b) {
            this(str, fVar, bVar, iVar, gVar, eVar, str2);
        }

        private k(String str, f fVar, b bVar, i iVar, g gVar, e eVar, String str2) {
            this.hlV = true;
            this.hlQ = str;
            this.hlR = fVar;
            this.hlO = bVar;
            this.hlS = iVar;
            this.hlA = gVar;
            this.hlT = eVar;
            this.hlU = str2;
        }

        final String Jz() {
            return b.Z(this.hlU, JA());
        }

        final String JA() {
            return b.a(this.hlQ, this.hlR, this.hlT);
        }

        final void JB() {
            try {
                Bitmap JC = JC();
                if (JC != null && !JC.isRecycled()) {
                    this.hlO.hly.iL(b.iG(this.hlQ));
                    this.hlO.hly.a(b.iG(this.hlQ), this);
                    l(JC);
                    this.hlO.hly.iK(b.iG(this.hlQ));
                }
            } catch (d e) {
                x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", e);
                this.hlO.hly.iL(b.iG(this.hlQ));
                this.hlO.hly.iM(b.iG(this.hlQ));
                l(null);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " doIOJobImpl, io exp ", new Object[0]);
                this.hlO.hly.iL(b.iG(this.hlQ));
                this.hlO.hly.a(b.iG(this.hlQ), this);
                this.hlO.hly.iK(b.iG(this.hlQ));
            }
        }

        public final void Jv() {
            final Bitmap iJ = this.hlS.iJ(JA());
            if (iJ == null || iJ.isRecycled()) {
                d d = this.hlO.hly;
                String access$1500 = b.iG(this.hlQ);
                if (bi.oN(access$1500) ? false : d.hlM.containsKey(access$1500)) {
                    d d2 = this.hlO.hly;
                    String access$15002 = b.iG(this.hlQ);
                    if (!(bi.oN(access$15002) || this == null)) {
                        List list = (List) d2.hlL.get(access$15002);
                        if (list == null) {
                            list = new LinkedList();
                            d2.hlL.put(access$15002, list);
                        }
                        list.add(this);
                    }
                    x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", b.iG(this.hlQ));
                    return;
                }
                d = this.hlO.hly;
                String access$15003 = b.iG(this.hlQ);
                if (!bi.oN(access$15003)) {
                    d.hlM.put(access$15003, Boolean.valueOf(true));
                }
                JB();
                return;
            }
            x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", JA());
            ah.y(new Runnable() {
                public final void run() {
                    k.this.j(iJ);
                }
            });
        }

        public final void Jw() {
            h hVar = (h) this.hlO.hlw.remove(Jz());
            if (hVar != null) {
                this.hlO.hlv.remove(hVar);
            }
        }

        final void j(Bitmap bitmap) {
            h hVar = (h) this.hlO.hlw.remove(Jz());
            if (hVar != null) {
                hVar.j(bitmap);
                this.hlO.hlv.remove(hVar);
            }
        }

        private void l(Bitmap bitmap) {
            boolean z = false;
            String str = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            String str2 = "postLoadInWorkerThread bitmap ok %b";
            Object[] objArr = new Object[1];
            boolean z2 = (bitmap == null || bitmap.isRecycled()) ? false : true;
            objArr[0] = Boolean.valueOf(z2);
            x.d(str, str2, objArr);
            if (!(this.hlR == null || bitmap == null || bitmap.isRecycled())) {
                Bitmap k = this.hlR.k(bitmap);
                x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", bitmap, k);
                if (k != bitmap) {
                    this.hlS.g(bitmap);
                }
                bitmap = k;
            }
            this.hlS.c(JA(), bitmap);
            String str3 = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            str = "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b";
            Object[] objArr2 = new Object[2];
            objArr2[0] = bitmap;
            if (!(bitmap == null || bitmap.isRecycled())) {
                z = true;
            }
            objArr2[1] = Boolean.valueOf(z);
            x.d(str3, str, objArr2);
            ah.y(new Runnable() {
                public final void run() {
                    k kVar = k.this;
                    Bitmap bitmap = bitmap;
                    if (bitmap == null || bitmap.isRecycled()) {
                        x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", bitmap);
                        h hVar = (h) kVar.hlO.hlw.remove(kVar.Jz());
                        if (hVar != null) {
                            hVar.Jt();
                            kVar.hlO.hlv.remove(hVar);
                            return;
                        }
                        return;
                    }
                    x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", bitmap);
                    kVar.j(bitmap);
                }
            });
        }

        private Bitmap JC() {
            Bitmap bitmap = null;
            if (com.tencent.mm.compatible.util.f.zl()) {
                InputStream openRead;
                if (this.hlQ == null || !this.hlQ.startsWith("file://")) {
                    openRead = this.hlA.openRead(b.iG(this.hlQ));
                    if (openRead == null) {
                        x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", Boolean.valueOf(this.hlV));
                        if (this.hlV) {
                            com.tencent.mm.sdk.f.e.post(new Runnable() {
                                public final void run() {
                                    Throwable e;
                                    Closeable closeable = null;
                                    k kVar = k.this;
                                    Closeable iH;
                                    try {
                                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(kVar.hlQ).openConnection();
                                        iH = kVar.hlA.iH(b.iG(kVar.hlQ));
                                        if (iH == null) {
                                            bi.d(iH);
                                            bi.d(null);
                                        } else {
                                            Closeable bufferedInputStream;
                                            try {
                                                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                                            } catch (Exception e2) {
                                                e = e2;
                                                try {
                                                    x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", kVar.hlQ);
                                                    kVar.hlA.iI(b.iG(kVar.hlQ));
                                                    bi.d(iH);
                                                    bi.d(closeable);
                                                    k.this.hlO.hly.i(new Runnable() {
                                                        public final void run() {
                                                            k.this.hlV = false;
                                                            k.this.JB();
                                                        }
                                                    });
                                                } catch (Throwable th) {
                                                    e = th;
                                                    bi.d(iH);
                                                    bi.d(closeable);
                                                    throw e;
                                                }
                                            }
                                            try {
                                                byte[] bArr = new byte[16384];
                                                while (true) {
                                                    int read = bufferedInputStream.read(bArr, 0, 16384);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    iH.write(bArr, 0, read);
                                                }
                                                iH.flush();
                                                bi.d(iH);
                                                bi.d(bufferedInputStream);
                                            } catch (Exception e3) {
                                                e = e3;
                                                closeable = bufferedInputStream;
                                                x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "download image url %s ", kVar.hlQ);
                                                kVar.hlA.iI(b.iG(kVar.hlQ));
                                                bi.d(iH);
                                                bi.d(closeable);
                                                k.this.hlO.hly.i(/* anonymous class already generated */);
                                            } catch (Throwable th2) {
                                                e = th2;
                                                closeable = bufferedInputStream;
                                                bi.d(iH);
                                                bi.d(closeable);
                                                throw e;
                                            }
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        iH = null;
                                    } catch (Throwable th3) {
                                        e = th3;
                                        iH = null;
                                        bi.d(iH);
                                        bi.d(closeable);
                                        throw e;
                                    }
                                    k.this.hlO.hly.i(/* anonymous class already generated */);
                                }
                            }, "AppBrandSimpleImageLoaderDownloadThread");
                        } else {
                            this.hlO.hly.iM(b.iG(this.hlQ));
                            this.hlO.hly.iL(b.iG(this.hlQ));
                        }
                    }
                } else {
                    try {
                        openRead = new FileInputStream(this.hlQ.replaceFirst("file://", ""));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "load from local file ", new Object[0]);
                    }
                }
                if (openRead != null) {
                    try {
                        bitmap = g(openRead);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " decode ", new Object[0]);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", bitmap);
                        throw new a();
                    }
                    x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", bitmap, Integer.valueOf(android.support.v4.b.a.b(bitmap) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), this.hlQ);
                }
                return bitmap;
            }
            x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
            throw new b();
        }

        private Bitmap g(InputStream inputStream) {
            try {
                Bitmap f;
                if (this.hlT != null) {
                    f = this.hlT.f(inputStream);
                } else {
                    f = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                    bi.d(inputStream);
                }
                return f;
            } finally {
                bi.d(inputStream);
            }
        }
    }

    public interface e extends c {
        Bitmap f(InputStream inputStream);
    }

    public interface g {
        OutputStream iH(String str);

        boolean iI(String str);

        InputStream openRead(String str);
    }

    private static final class a implements g {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final OutputStream iH(String str) {
            try {
                return new FileOutputStream(b.hlB + str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e, "openWrite fileName %s", str);
                return null;
            }
        }

        public final InputStream openRead(String str) {
            try {
                return new FileInputStream(b.hlB + str);
            } catch (IOException e) {
                x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", str, e);
                return null;
            }
        }

        public final boolean iI(String str) {
            return !bi.oN(str) && com.tencent.mm.loader.stub.b.deleteFile(b.hlB + str);
        }
    }

    public static class b implements h {
        public final void Js() {
        }

        public void j(Bitmap bitmap) {
        }

        public final void Jt() {
        }

        public final String Ju() {
            return "DefaultLoadTarget";
        }
    }

    public static final class c implements i {
        final com.tencent.mm.a.f<String, Reference<Bitmap>> hlH = new AnonymousClass1(31457280);

        /* renamed from: com.tencent.mm.modelappbrand.a.b$c$1 */
        class AnonymousClass1 extends com.tencent.mm.a.f<String, Reference<Bitmap>> {
            private final Map<Reference<Bitmap>, Integer> hlI = new ConcurrentHashMap();

            AnonymousClass1(int i) {
                super(31457280);
            }

            protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                String str = (String) obj;
                Reference reference = (Reference) obj2;
                Reference reference2 = (Reference) obj3;
                String str2 = "MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache";
                String str3 = "entryRemoved, curSize %d KB, maxSize %d KB, oldBmp %s, newBmp %s";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(c.this.hlH.size() / 10);
                objArr[1] = Integer.valueOf(c.this.hlH.maxSize() / 10);
                objArr[2] = reference == null ? "null-ref" : reference.get();
                objArr[3] = reference2 == null ? "null-ref" : reference2.get();
                x.d(str2, str3, objArr);
                super.entryRemoved(z, str, reference, reference2);
                Bitmap bitmap = reference == null ? null : (Bitmap) reference.get();
                if (bitmap != (reference2 == null ? null : (Bitmap) reference2.get())) {
                    c.this.g(bitmap);
                }
                this.hlI.remove(reference);
            }

            protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                Reference reference = (Reference) obj2;
                if (reference == null) {
                    return 0;
                }
                Integer num = (Integer) this.hlI.get(reference);
                if (num != null && num.intValue() >= 0) {
                    return num.intValue();
                }
                Bitmap bitmap = (Bitmap) reference.get();
                int b = (bitmap == null || bitmap.isRecycled()) ? 0 : android.support.v4.b.a.b(bitmap);
                this.hlI.put(reference, Integer.valueOf(b));
                return b;
            }

            public final void clear() {
                x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
                super.clear();
                this.hlI.clear();
            }

            public final void a(com.tencent.mm.a.f.a<String, Reference<Bitmap>> aVar) {
                x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear(OnClearListener)");
                super.a(aVar);
                this.hlI.clear();
            }
        }

        public final Bitmap iJ(String str) {
            if (bi.oN(str)) {
                return null;
            }
            Reference reference = (Reference) this.hlH.get(str);
            if (reference == null) {
                return null;
            }
            Bitmap bitmap = (Bitmap) reference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                return bitmap;
            }
            this.hlH.remove(str);
            return null;
        }

        public final void c(String str, Bitmap bitmap) {
            if (!bi.oN(str) && bitmap != null) {
                x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", str, bitmap);
                this.hlH.put(str, new SoftReference(bitmap));
            }
        }

        public final void g(Bitmap bitmap) {
            x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", bitmap);
            if (bitmap != null) {
                bitmap.isRecycled();
            }
        }
    }

    private static final class d {
        private final ag hlK;
        final Map<String, List<a>> hlL;
        final Map<String, Boolean> hlM;

        interface a {
            void Jv();

            void Jw();
        }

        /* synthetic */ d(ag agVar, byte b) {
            this(agVar);
        }

        private d(ag agVar) {
            this.hlL = new HashMap();
            this.hlM = new HashMap();
            this.hlK = agVar;
        }

        final void iK(String str) {
            if (!bi.oN(str)) {
                List<a> list = (List) this.hlL.remove(str);
                if (!bi.cC(list)) {
                    for (a Jv : list) {
                        Jv.Jv();
                    }
                }
            }
        }

        final void iL(String str) {
            if (!bi.oN(str)) {
                this.hlM.remove(str);
            }
        }

        final void a(String str, a aVar) {
            if (!bi.oN(str) && aVar != null) {
                List list = (List) this.hlL.get(str);
                if (list != null) {
                    list.remove(aVar);
                }
            }
        }

        final void iM(String str) {
            if (!bi.oN(str)) {
                List<a> list = (List) this.hlL.remove(str);
                if (!bi.cC(list)) {
                    for (a Jw : list) {
                        Jw.Jw();
                    }
                    list.clear();
                }
            }
        }

        final void i(Runnable runnable) {
            this.hlK.post(runnable);
        }
    }

    public interface f extends c {
        String Ju();

        Bitmap k(Bitmap bitmap);
    }

    public interface h extends c {
        void Js();

        void Jt();

        String Ju();

        void j(Bitmap bitmap);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b Jp() {
        return l.hma;
    }

    private b() {
        this.hlv = new ConcurrentHashMap();
        this.hlw = new ConcurrentHashMap();
        this.hlx = new ConcurrentHashMap();
        this.hlz = new c();
        this.hlA = new a();
        this.hly = new d(new ag(new ah("AppBrandSimpleImageLoaderDiskIOHandlerThread").oFY.getLooper()), (byte) 0);
    }

    public final Bitmap iF(String str) {
        Bitmap iJ = this.hlz.iJ(str);
        if (iJ == null || iJ.isRecycled()) {
            return null;
        }
        return iJ;
    }

    public final Bitmap a(String str, e eVar) {
        Closeable fileInputStream;
        Throwable e;
        Throwable th;
        if (bi.oN(str)) {
            return null;
        }
        String a = a(str, null, eVar);
        Bitmap iJ = this.hlz.iJ(a);
        if (iJ != null) {
            return iJ;
        }
        try {
            if (str.startsWith("file://")) {
                try {
                    fileInputStream = new FileInputStream(str.replaceFirst("file://", ""));
                } catch (FileNotFoundException e2) {
                    x.e("MicroMsg.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                    bi.d(null);
                    return null;
                }
            }
            fileInputStream = this.hlA.openRead(iG(str));
            if (eVar != null) {
                try {
                    iJ = eVar.f(fileInputStream);
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                iJ = com.tencent.mm.sdk.platformtools.d.decodeStream(fileInputStream);
            }
            if (iJ != null) {
                this.hlz.c(a, iJ);
            }
            bi.d(fileInputStream);
            return iJ;
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
        } catch (Throwable e5) {
            fileInputStream = null;
            th = e5;
            bi.d(fileInputStream);
            throw th;
        }
        try {
            x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e5, "findCachedLocal", new Object[0]);
            bi.d(fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            bi.d(fileInputStream);
            throw th;
        }
    }

    public final String a(h hVar, String str, f fVar, e eVar) {
        String str2 = null;
        if (hVar != null) {
            if (bi.oN(str)) {
                hVar.Jt();
            } else {
                x.d("MicroMsg.AppBrandSimpleImageLoader", "load before start LoadTask url %s", str);
                k kVar = new k(str, fVar, this, this.hlz, this.hlA, eVar, hVar.Ju(), (byte) 0);
                str2 = kVar.JA();
                final h hVar2 = hVar;
                final String str3 = str;
                final k kVar2 = kVar;
                Runnable anonymousClass1 = new Runnable() {
                    public final void run() {
                        Bitmap iF = b.this.iF(str2);
                        if (iF != null) {
                            hVar2.j(iF);
                            x.d("MicroMsg.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", str3, iF);
                            return;
                        }
                        String Jz = kVar2.Jz();
                        b.this.hlv.put(hVar2, Jz);
                        b.this.hlw.put(Jz, hVar2);
                        hVar2.Js();
                        k kVar = kVar2;
                        kVar.hlO.hly.i(new Runnable() {
                            public final void run() {
                                k.this.Jv();
                            }
                        });
                    }
                };
                if (ah.isMainThread()) {
                    anonymousClass1.run();
                } else {
                    ah.y(anonymousClass1);
                }
            }
        }
        return str2;
    }

    public final String a(h hVar, String str, f fVar) {
        return a(hVar, str, fVar, null);
    }

    public final String a(ImageView imageView, String str, Drawable drawable, f fVar) {
        return a(imageView, str, drawable, fVar, null);
    }

    public final String a(ImageView imageView, String str, final Drawable drawable, f fVar, e eVar) {
        if (imageView == null) {
            return null;
        }
        String str2;
        if (imageView != null) {
            str2 = (String) this.hlx.get(Integer.valueOf(imageView.hashCode()));
            if (str2 != null) {
                h hVar = (h) this.hlw.get(str2);
                if (hVar != null) {
                    str2 = (String) this.hlv.get(hVar);
                    if (!bi.oN(str2)) {
                        this.hlw.remove(str2);
                    }
                }
            }
        }
        if (bi.oN(str)) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            return null;
        }
        h anonymousClass2 = new j(imageView, this) {
            public final void Js() {
                if (Jx() != null && drawable != null) {
                    Jx().setImageDrawable(drawable);
                }
            }
        };
        str2 = a(anonymousClass2, str, fVar, eVar);
        if (anonymousClass2.hlP) {
            return str2;
        }
        this.hlx.put(Integer.valueOf(imageView.hashCode()), Z(anonymousClass2.aAM, str2));
        return str2;
    }

    private static String Z(String str, String str2) {
        return str + str2;
    }

    private static String a(String str, f fVar, e eVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (fVar != null) {
            stringBuilder.append("|transformation:");
            stringBuilder.append(fVar.Ju());
        }
        if (eVar != null) {
            stringBuilder.append("|decoder:");
            stringBuilder.append(eVar.Ju());
        }
        return stringBuilder.toString();
    }

    static {
        String str = com.tencent.mm.compatible.util.e.bnF;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        hlB = str;
        com.tencent.mm.sdk.platformtools.i.QZ(str);
    }

    private static String iG(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return com.tencent.mm.a.g.s(str.getBytes());
    }
}
