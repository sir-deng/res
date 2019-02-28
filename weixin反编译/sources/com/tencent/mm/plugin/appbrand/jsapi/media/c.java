package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 120;
    private static final String NAME = "getImageInfo";
    private static final Collection<b> jqO;

    private static final class c {
        public int height;
        public String iRe;
        public String type;
        public int width;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private enum e {
        FILE_NOT_FOUND,
        UNKNOWN_FAIL,
        RESOLVED
    }

    private static final class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final com.tencent.mm.vending.j.a i(com.tencent.mm.plugin.appbrand.e eVar, String str) {
            if (!str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                return null;
            }
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(eVar.mAppId, str);
            if (itemByLocalId == null || bi.oN(itemByLocalId.hjJ) || !com.tencent.mm.a.e.bO(itemByLocalId.hjJ)) {
                return com.tencent.mm.vending.j.a.cs(e.FILE_NOT_FOUND);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(itemByLocalId.hjJ, options);
            c cVar = new c();
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            cVar.type = com.tencent.mm.plugin.appbrand.r.a.b(options);
            cVar.iRe = com.tencent.mm.plugin.appbrand.r.a.a(options) ? com.tencent.mm.plugin.appbrand.r.a.mb(com.tencent.mm.plugin.appbrand.r.a.vj(itemByLocalId.hjJ)) : "up";
            return com.tencent.mm.vending.j.a.v(e.RESOLVED, cVar);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.c$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] jqR = new int[e.values().length];

        static {
            try {
                jqR[e.FILE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jqR[e.RESOLVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jqR[e.UNKNOWN_FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private interface b {
        com.tencent.mm.vending.j.a i(com.tencent.mm.plugin.appbrand.e eVar, String str);
    }

    private static final class d implements b {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final com.tencent.mm.vending.j.a i(com.tencent.mm.plugin.appbrand.e eVar, String str) {
            Closeable d = ao.d(eVar, str);
            if (d == null) {
                return com.tencent.mm.vending.j.a.cs(e.FILE_NOT_FOUND);
            }
            d.mark(0);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(d, new Rect(), options);
            c cVar = new c();
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            cVar.type = com.tencent.mm.plugin.appbrand.r.a.b(options);
            boolean a = com.tencent.mm.plugin.appbrand.r.a.a(options);
            try {
                d.reset();
            } catch (IOException e) {
            }
            cVar.iRe = a ? com.tencent.mm.plugin.appbrand.r.a.mb(com.tencent.mm.plugin.appbrand.r.a.l(d)) : "up";
            bi.d(d);
            return com.tencent.mm.vending.j.a.v(e.RESOLVED, cVar);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        final String optString = jSONObject.optString("src");
        if (bi.oN(optString)) {
            jVar.E(i, e("fail:invalid data", null));
            return;
        }
        final WeakReference weakReference = new WeakReference(jVar);
        final j jVar2 = jVar;
        final int i2 = i;
        com.tencent.mm.sdk.f.e.b(new Runnable() {
            public final void run() {
                com.tencent.mm.vending.j.a aVar = null;
                for (b i : c.jqO) {
                    aVar = i.i(jVar2.iuk, optString);
                    if (aVar != null) {
                        break;
                    }
                }
                com.tencent.mm.vending.j.a aVar2 = aVar;
                if (weakReference.get() != null && ((j) weakReference.get()).Vx) {
                    if (aVar2 != null) {
                        String e;
                        switch (AnonymousClass2.jqR[((e) aVar2.get(0)).ordinal()]) {
                            case 1:
                                e = c.this.e("fail:file not found", null);
                                break;
                            case 2:
                                Map hashMap = new HashMap(2);
                                hashMap.put("width", Integer.valueOf(((c) aVar2.get(1)).width));
                                hashMap.put("height", Integer.valueOf(((c) aVar2.get(1)).height));
                                hashMap.put("orientation", ((c) aVar2.get(1)).iRe);
                                hashMap.put(Columns.TYPE, ((c) aVar2.get(1)).type);
                                e = c.this.e("ok", hashMap);
                                break;
                            default:
                                e = c.this.e("fail", null);
                                break;
                        }
                        ((j) weakReference.get()).E(i2, e);
                        return;
                    }
                    ((j) weakReference.get()).E(i2, c.this.e("fail:src not support", null));
                }
            }
        }, String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", new Object[]{optString}), 10);
    }

    static {
        Collection linkedList = new LinkedList();
        linkedList.add(new a());
        linkedList.add(new d());
        jqO = Collections.unmodifiableCollection(linkedList);
    }
}
