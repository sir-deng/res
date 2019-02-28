package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class d {
    private static d bbD;
    final ad bbA;
    final ConcurrentMap<am, Boolean> bbB;
    private final an bbC;
    private final a bby;
    private final c bbz;
    private final Context mContext;

    public interface a {
    }

    /* renamed from: com.google.android.gms.tagmanager.d$4 */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] bbF = new int[a.qZ().length];

        static {
            try {
                bbF[a.bbR - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                bbF[a.bbS - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                bbF[a.bbT - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private d(Context context, a aVar, c cVar, ad adVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.bbA = adVar;
        this.bby = aVar;
        this.bbB = new ConcurrentHashMap();
        this.bbz = cVar;
        this.bbz.a(new b() {
            public final void g(Map<String, Object> map) {
                Object obj = map.get("event");
                if (obj != null) {
                    d.a(d.this, obj.toString());
                }
            }
        });
        this.bbz.a(new ag(this.mContext));
        this.bbC = new an();
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new ComponentCallbacks2() {
                public final void onConfigurationChanged(Configuration configuration) {
                }

                public final void onLowMemory() {
                }

                public final void onTrimMemory(int i) {
                    if (i == 20) {
                        d.this.bbA.rb();
                    }
                }
            });
        }
    }

    public static d T(Context context) {
        d dVar;
        synchronized (d.class) {
            if (bbD == null) {
                if (context == null) {
                    m.qD();
                    throw new NullPointerException();
                }
                bbD = new d(context, new a() {
                }, new c(new ap(context)), ae.rc());
            }
            dVar = bbD;
        }
        return dVar;
    }

    static /* synthetic */ void a(d dVar, String str) {
        for (am bg : dVar.bbB.keySet()) {
            bg.bg(str);
        }
    }

    final synchronized boolean e(Uri uri) {
        boolean z;
        w qY = w.qY();
        if (qY.e(uri)) {
            String str = qY.bbk;
            switch (AnonymousClass4.bbF[qY.bbO - 1]) {
                case 1:
                    for (am amVar : this.bbB.keySet()) {
                        if (amVar.rg().equals(str)) {
                            amVar.rh();
                            amVar.refresh();
                        }
                    }
                    break;
                case 2:
                case 3:
                    for (am amVar2 : this.bbB.keySet()) {
                        String str2;
                        if (amVar2.rg().equals(str)) {
                            str2 = qY.bbP;
                            amVar2.rh();
                            amVar2.refresh();
                        } else {
                            if (amVar2.bcU) {
                                m.qD();
                                str2 = "";
                            } else {
                                str2 = amVar2.bcT.ri();
                            }
                            if (str2 != null) {
                                amVar2.rh();
                                amVar2.refresh();
                            }
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
