package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class e {
    private static Class<?> ffY = null;
    protected static Application ffZ;
    protected static Resources fga;
    private static boolean xLg = false;
    private static volatile a xLh;
    private static LongSparseArray<ConstantState>[] xLi;
    private static LongSparseArray<ConstantState> xLj;
    private static c<ConstantState> xLk;
    private static c<ConstantState> xLl;
    protected static String xLm;
    protected static Class<d> xLn;
    private static volatile boolean xLo = false;
    private static Map<WeakReference<Resources>, Map<Long, Integer>> xLp = new HashMap();
    private static boolean xLq = false;
    private static Method xjO = null;
    private static Method xjP = null;

    public static class a {
        Resources mResources;
        TypedValue xKM = new TypedValue();
        Map<Integer, com.tencent.mm.svg.c> xKR;
        Application xLr;

        public a(Map<Integer, com.tencent.mm.svg.c> map, Application application, Resources resources) {
            this.xKR = map;
            this.xLr = application;
            this.mResources = resources;
        }

        public final void a(Integer num, com.tencent.mm.svg.c cVar) {
            this.xKR.put(num, cVar);
            e.a(this.xLr, this.mResources, num.intValue(), this.xKM);
        }
    }

    protected static class b extends ConstantState {
        private int jxX = 0;
        private Resources mResources;
        private long xLs = 0;

        public b(int i, Resources resources, long j) {
            if (i == 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", Integer.valueOf(i));
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
            }
            this.jxX = i;
            this.mResources = resources;
            this.xLs = j;
        }

        public final Drawable newDrawable() {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable mResources:" + this.mResources, new Object[0]);
            return a.c(this.mResources, this.jxX);
        }

        public final Drawable newDrawable(Resources resources) {
            try {
                Map b = e.b(resources);
                if (b != null) {
                    int intValue = ((Integer) b.get(Long.valueOf(this.xLs))).intValue();
                    Drawable b2 = e.b(resources, intValue);
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "loadDrawableSkipCache id:" + Integer.toHexString(intValue) + ",drawable:" + b2, new Object[0]);
                    return b2;
                }
            } catch (Exception e) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable loadDrawableSkipCache error:" + e.getMessage(), new Object[0]);
            }
            return newDrawable();
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    @TargetApi(16)
    public static class c<T> extends LongSparseArray<T> {
        public static boolean xLt = false;
        LongSparseArray<T> xLj = null;

        public final T get(long j, T t) {
            synchronized (this.xLj) {
                if (this.xLj.indexOfKey(j) >= 0) {
                    T t2 = this.xLj.get(j, t);
                    return t2;
                }
                return super.get(j, t);
            }
        }

        public final void delete(long j) {
            super.delete(j);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", Long.valueOf(j));
        }

        public final void remove(long j) {
            super.remove(j);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", Long.valueOf(j));
        }

        public final void clear() {
            super.clear();
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
        }
    }

    static /* synthetic */ void a(Application application, Resources resources, int i, TypedValue typedValue) {
        if (i == 0) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "preloadDrawable Why this id is %d. TypedValue %s", Integer.valueOf(i), typedValue);
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
        }
        resources.getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        b bVar = new b(i, application.getResources(), j);
        synchronized (xLj) {
            xLj.put(j, bVar);
        }
    }

    static /* synthetic */ Map b(Resources resources) {
        for (WeakReference weakReference : xLp.keySet()) {
            Resources resources2 = (Resources) weakReference.get();
            if (resources2 != null && resources2 == resources) {
                return (Map) xLp.get(weakReference);
            }
        }
        return null;
    }

    public static void a(Resources resources, Map<Long, Integer> map) {
        int i;
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "addFilterResources:" + resources, new Object[0]);
        for (WeakReference weakReference : xLp.keySet()) {
            if (weakReference.get() == resources) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            xLp.put(new WeakReference(resources), map);
        }
    }

    public static void d(Class<?> cls) {
        ffY = cls;
    }

    public static void a(com.tencent.mm.svg.b.c.a aVar) {
        com.tencent.mm.svg.b.c.b(aVar);
    }

    public static void b(Application application, String str) {
        if (xLq) {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg initiated.", new Object[0]);
            return;
        }
        xLm = str;
        a.cu(str);
        com.tencent.mm.svg.b.b.cu(str);
        ffZ = application;
        fq(application);
    }

    public static void a(Application application, Resources resources, String str) {
        Throwable e;
        boolean z;
        long nanoTime;
        boolean z2;
        b(application, str);
        if (xLo) {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg loaded, skip this time.", new Object[0]);
            return;
        }
        String str2 = xLm + ".svg.SVGPreload";
        try {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "try to load SVGPreload", new Object[0]);
            Class cls = Class.forName(str2);
            long nanoTime2 = System.nanoTime();
            ffZ = application;
            xLn = cls;
            fga = resources;
            try {
                if (xLn != null) {
                    ((d) cls.newInstance()).load(b(application, fga));
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVGCode wrapper size %s", Integer.valueOf(b(application, fga).xKR.size()));
                    xLg = true;
                }
            } catch (Throwable e2) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "We found one NotFoundException.", new Object[0]);
                xLg = false;
            }
            try {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "load SVGPreload spent %s", Long.valueOf((System.nanoTime() - nanoTime2) / 1000));
                xLo = true;
            } catch (ClassNotFoundException e3) {
                z = true;
                try {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "ClassNotFoundException %s. Go fallback logic.", str2);
                    if (z) {
                        xLo = true;
                        return;
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    fq(application);
                    try {
                        c(application, resources);
                    } catch (ClassNotFoundException e4) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                } catch (Throwable th) {
                    Throwable th2 = th;
                    z2 = z;
                    e2 = th2;
                    if (z2) {
                        xLo = true;
                    } else {
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime = System.nanoTime();
                        fq(application);
                        try {
                            c(application, resources);
                        } catch (ClassNotFoundException e5) {
                        }
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    }
                    throw e2;
                }
            } catch (InstantiationException e6) {
                e2 = e6;
                z2 = true;
                try {
                    com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
                    if (z2) {
                        xLo = true;
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    fq(application);
                    try {
                        c(application, resources);
                    } catch (ClassNotFoundException e7) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                } catch (Throwable th3) {
                    e2 = th3;
                    if (z2) {
                        xLo = true;
                    } else {
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime = System.nanoTime();
                        fq(application);
                        c(application, resources);
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                    }
                    throw e2;
                }
            } catch (IllegalAccessException e8) {
                e2 = e8;
                z2 = true;
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                if (z2) {
                    xLo = true;
                }
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                fq(application);
                try {
                    c(application, resources);
                } catch (ClassNotFoundException e9) {
                }
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            } catch (Throwable th4) {
                e2 = th4;
                z2 = true;
                if (z2) {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    fq(application);
                    c(application, resources);
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                } else {
                    xLo = true;
                }
                throw e2;
            }
        } catch (ClassNotFoundException e10) {
            z = false;
        } catch (InstantiationException e11) {
            e2 = e11;
            z2 = false;
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
            if (z2) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                fq(application);
                c(application, resources);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
            xLo = true;
        } catch (IllegalAccessException e12) {
            e2 = e12;
            z2 = false;
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
            if (z2) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                fq(application);
                c(application, resources);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
            xLo = true;
        } catch (Throwable th5) {
            e2 = th5;
            z2 = false;
            if (z2) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                fq(application);
                c(application, resources);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            } else {
                xLo = true;
            }
            throw e2;
        }
    }

    private static a b(Application application, Resources resources) {
        if (xLh == null) {
            synchronized (e.class) {
                if (xLh == null) {
                    xLh = new a(a.clQ(), application, resources);
                }
            }
        }
        return xLh;
    }

    @TargetApi(16)
    private static void fq(Context context) {
        int i = 1;
        if (xLk == null) {
            try {
                Object obj;
                xLj = new LongSparseArray();
                c cVar = new c();
                xLk = cVar;
                cVar.xLj = xLj;
                cVar = new c();
                xLl = cVar;
                cVar.xLj = xLj;
                if (VERSION.SDK_INT >= 23) {
                    com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "mResourcesImpl");
                    aVar.prepare();
                    if (aVar.gIA == null) {
                        i = 0;
                    }
                    if (i != 0) {
                        obj = aVar.get();
                    } else {
                        obj = context.getResources();
                    }
                } else {
                    obj = context.getResources();
                }
                a(context, obj);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", context.getResources());
            } catch (Throwable e) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
            } catch (Throwable e2) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
            } catch (Throwable e22) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e22, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
            }
        }
    }

    @TargetApi(16)
    private static void a(Context context, Object obj) {
        Object obj2 = new com.tencent.mm.svg.b.a(obj, "sPreloadedDrawables").get();
        if (obj2 == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
        } else if (obj2 instanceof LongSparseArray[]) {
            int i;
            long keyAt;
            xLi = (LongSparseArray[]) obj2;
            com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", xLi[0]);
            for (i = 0; i < xLi[0].size(); i++) {
                keyAt = xLi[0].keyAt(i);
                xLk.put(keyAt, xLi[0].get(keyAt));
            }
            for (i = 0; i < xLi[1].size(); i++) {
                keyAt = xLi[1].keyAt(i);
                xLl.put(keyAt, xLi[1].get(keyAt));
            }
            xLi[0] = xLk;
            xLi[1] = xLl;
        } else if (obj2 instanceof LongSparseArray) {
            com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "sPreloadedDrawables");
            LongSparseArray longSparseArray = (LongSparseArray) aVar.get();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long keyAt2 = longSparseArray.keyAt(i2);
                xLk.put(keyAt2, longSparseArray.get(keyAt2));
            }
            c cVar = xLk;
            aVar.prepare();
            if (aVar.gIA == null) {
                throw new NoSuchFieldException();
            }
            aVar.gIA.set(aVar.obj, cVar);
            if (aVar.get() == null) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
            }
        } else {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
        }
    }

    private static Class<?> clU() {
        if (ffY != null) {
            return ffY;
        }
        Class<?> cls;
        try {
            cls = Class.forName(xLm + ".R$raw");
            if (cls != null) {
                return cls;
            }
        } catch (ClassNotFoundException e) {
        }
        cls = com.tencent.mm.svg.b.b.clX();
        return cls == null ? null : cls;
    }

    private static void c(Application application, Resources resources) {
        Class clU = clU();
        if (clU == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
            return;
        }
        Field[] declaredFields = clU.getDeclaredFields();
        a b = b(application, resources);
        try {
            a aVar = new a();
            for (Field field : declaredFields) {
                int i = field.getInt(null);
                if (aVar.d(application.getResources(), i)) {
                    a(b.xLr, b.mResources, i, b.xKM);
                }
            }
            xLg = true;
        } catch (IllegalAccessException e) {
            xLg = false;
        } catch (IllegalArgumentException e2) {
            xLg = false;
        }
    }

    public static Drawable b(Resources resources, int i) {
        Drawable colorDrawable;
        Method declaredMethod;
        NotFoundException notFoundException;
        boolean z = true;
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        }
        if (z) {
            colorDrawable = new ColorDrawable(typedValue.data);
        } else {
            colorDrawable = null;
        }
        if (xjO == null) {
            try {
                declaredMethod = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[]{String.class, Integer.TYPE, Integer.TYPE, String.class});
                xjO = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "", new Object[0]);
                return null;
            }
        }
        if (xjP == null) {
            try {
                declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[]{Integer.TYPE, String.class, Integer.TYPE});
                xjP = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                return null;
            }
        }
        if (colorDrawable == null) {
            if (typedValue.string == null) {
                throw new NotFoundException("Resource is not a Drawable (color or path): " + typedValue);
            }
            String charSequence = typedValue.string.toString();
            Drawable createFromXml;
            if (charSequence.endsWith(".xml")) {
                try {
                    XmlResourceParser xmlResourceParser = (XmlResourceParser) xjO.invoke(resources, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(typedValue.assetCookie), "drawable"});
                    createFromXml = Drawable.createFromXml(resources, xmlResourceParser);
                    xmlResourceParser.close();
                    colorDrawable = createFromXml;
                } catch (Throwable e22) {
                    notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e22);
                    throw notFoundException;
                }
            }
            try {
                InputStream inputStream = (InputStream) xjP.invoke(resources.getAssets(), new Object[]{Integer.valueOf(typedValue.assetCookie), charSequence, Integer.valueOf(2)});
                createFromXml = Drawable.createFromResourceStream(resources, typedValue, inputStream, charSequence, null);
                inputStream.close();
                colorDrawable = createFromXml;
            } catch (Throwable e222) {
                notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e222);
                throw notFoundException;
            }
        }
        return colorDrawable;
    }
}
