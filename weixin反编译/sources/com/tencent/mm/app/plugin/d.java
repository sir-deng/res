package com.tencent.mm.app.plugin;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.b;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class d implements b {
    private static d fhp = null;
    URISpanHandlerSet fhq;
    ArrayList<BaseUriSpanHandler> fhr = new ArrayList();
    ArrayList<BaseUriSpanHandler> fhs = new ArrayList();
    ArrayList<BaseUriSpanHandler> fht = new ArrayList();
    Context mContext = null;

    public static d uC() {
        if (fhp == null) {
            fhp = new d();
        }
        return fhp;
    }

    private d() {
        long Wy = bi.Wy();
        x.d("MicroMsg.URISpanHandler", "init URISpanHandler");
        this.mContext = ad.getContext();
        this.fhq = new URISpanHandlerSet(this.mContext);
        for (Class cls : URISpanHandlerSet.class.getDeclaredClasses()) {
            if (cls != null && cls.getSuperclass() != null && cls.isAnnotationPresent(a.class) && cls.getSuperclass().getName().equals(BaseUriSpanHandler.class.getName())) {
                try {
                    a aVar = (a) cls.getAnnotation(a.class);
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{URISpanHandlerSet.class});
                    if (declaredConstructor != null) {
                        BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) BaseUriSpanHandler.class.cast(declaredConstructor.newInstance(new Object[]{this.fhq}));
                        PRIORITY uE = aVar.uE();
                        if (uE == PRIORITY.LOW) {
                            this.fht.add(baseUriSpanHandler);
                        } else if (uE == PRIORITY.NORMAL) {
                            this.fhs.add(baseUriSpanHandler);
                        } else if (uE == PRIORITY.HIGH) {
                            this.fhr.add(baseUriSpanHandler);
                        }
                        x.d("MicroMsg.URISpanHandler", "successfully add: %s", cls.getName());
                    } else {
                        x.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", cls.getName());
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.URISpanHandler", e, "", new Object[0]);
                    x.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", cls.getName(), e.getMessage(), e.getClass().getName());
                }
            }
        }
        x.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", Long.valueOf(bi.Wy() - Wy));
    }

    public final k p(Context context, String str) {
        x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", str, Integer.valueOf(this.fhr.size()), Integer.valueOf(this.fhs.size()), Integer.valueOf(this.fht.size()));
        if (context == null) {
            x.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
            this.fhq.mContext = null;
            return null;
        }
        this.mContext = context;
        this.fhq.mContext = this.mContext;
        if (bi.oN(str)) {
            x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
            this.mContext = null;
            this.fhq.mContext = null;
            return null;
        }
        k cH;
        Iterator it = this.fhr.iterator();
        while (it.hasNext()) {
            cH = ((BaseUriSpanHandler) it.next()).cH(str);
            if (cH != null) {
                x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(cH.type));
                this.mContext = null;
                this.fhq.mContext = null;
                return cH;
            }
        }
        it = this.fhs.iterator();
        while (it.hasNext()) {
            cH = ((BaseUriSpanHandler) it.next()).cH(str);
            if (cH != null) {
                x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(cH.type));
                this.mContext = null;
                this.fhq.mContext = null;
                return cH;
            }
        }
        it = this.fht.iterator();
        while (it.hasNext()) {
            cH = ((BaseUriSpanHandler) it.next()).cH(str);
            if (cH != null) {
                x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(cH.type));
                this.mContext = null;
                this.fhq.mContext = null;
                return cH;
            }
        }
        this.mContext = null;
        this.fhq.mContext = null;
        x.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
        return null;
    }

    public final boolean a(Context context, k kVar, f fVar) {
        if (kVar == null) {
            x.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
            return false;
        }
        boolean z;
        String str = "MicroMsg.URISpanHandler";
        String str2 = "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(kVar.type);
        if (fVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(this.fhr.size());
        objArr[3] = Integer.valueOf(this.fhs.size());
        objArr[4] = Integer.valueOf(this.fht.size());
        x.d(str, str2, objArr);
        if (context == null) {
            x.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
            this.fhq.mContext = null;
            return false;
        }
        BaseUriSpanHandler baseUriSpanHandler;
        this.mContext = context;
        this.fhq.mContext = this.mContext;
        Iterator it = this.fhr.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.uD(), kVar.type) && baseUriSpanHandler.a(kVar, fVar)) {
                x.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.fhq.mContext = null;
                return true;
            }
        }
        it = this.fhs.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.uD(), kVar.type) && baseUriSpanHandler.a(kVar, fVar)) {
                x.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.fhq.mContext = null;
                return true;
            }
        }
        it = this.fht.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.uD(), kVar.type) && baseUriSpanHandler.a(kVar, fVar)) {
                x.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.fhq.mContext = null;
                return true;
            }
        }
        this.mContext = null;
        this.fhq.mContext = null;
        x.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
        return false;
    }

    private static boolean b(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
