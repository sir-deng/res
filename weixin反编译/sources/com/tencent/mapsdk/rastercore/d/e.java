package com.tencent.mapsdk.rastercore.d;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.raster.model.QMapLanguage;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.g.a;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.mapsdk.rastercore.tile.f;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.g.j;
import java.net.HttpURLConnection;
import java.net.URL;

public final class e implements b {
    private static volatile int A = com.tencent.mapsdk.rastercore.b.a;
    private static volatile int B = com.tencent.mapsdk.rastercore.b.c;
    private static volatile int C = 1000;
    private static volatile int D = 1000;
    private static volatile int E = com.tencent.mapsdk.rastercore.b.d;
    private static volatile int F = com.tencent.mapsdk.rastercore.b.b;
    private static volatile String G = QMapLanguage.getLanguageCode(QMapLanguage.QMapLanguage_en);
    public static int a = 0;
    public static int b = 0;
    public static int c = 0;
    public static int d = 0;
    public static int e = 0;
    public static int f = 0;
    public static int g = 0;
    public static int h = 0;
    private static final byte[] i = new byte[0];
    private static volatile Context j;
    private static boolean x = true;
    private static boolean z = false;
    private boolean H = false;
    private boolean I = false;
    private MapView k;
    private a l;
    private b m;
    private f n;
    private com.tencent.mapsdk.rastercore.tile.a.AnonymousClass1 o;
    private f p;
    private c q;
    private com.tencent.mapsdk.rastercore.d.a.AnonymousClass1 r;
    private volatile com.tencent.mapsdk.rastercore.g.b s;
    private a t;
    private int u = 1;
    private j v = null;
    private boolean w = false;
    private Rect y = null;

    public e(MapView mapView) {
        Context applicationContext = mapView.getContext().getApplicationContext();
        j = applicationContext;
        z = applicationContext == null ? false : j.getSharedPreferences("mapsdk_pref", 0).getBoolean("worldEnable", false);
        com.tencent.mapsdk.rastercore.tile.a.a.a().a(j);
        if (j != null) {
            synchronized (i) {
                D = d.a.a().a(j.getPackageName(), false);
                A = d.a.a().a(D, 0);
                new StringBuilder("CurrentVersion in MapContext:").append(A);
                C = d.a.a().a(j.getPackageName(), true);
                B = d.a.a().a(C, 2);
                E = d.a.a().a(-1, 3);
            }
            F = d.a.a().a(-1, 1);
            new Thread(this) {
                public final void run() {
                    com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapSource.BING, e.B);
                    com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapSource.SATELLITE, e.E);
                }
            }.start();
        }
        this.k = mapView;
        this.r = new com.tencent.mapsdk.rastercore.d.a.AnonymousClass1(this);
        this.s = new com.tencent.mapsdk.rastercore.g.b(this);
        this.q = new c(this);
        this.t = new a(this);
        this.l = new a(this);
        this.m = new b(this);
        this.n = new f(this);
        this.o = new com.tencent.mapsdk.rastercore.tile.a.AnonymousClass1(this, A, B, E);
        this.p = new f(this);
        this.q.a();
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        mapView.addView(this.m, layoutParams);
        mapView.addView(this.t, layoutParams);
        mapView.addView(this.s, layoutParams);
        this.r.b(1);
        this.r.a(true);
        this.r.c(0);
        com.tencent.mapsdk.rastercore.a.a(this);
        new d(j, this).a();
    }

    public static int a(MapSource mapSource) {
        switch (mapSource) {
            case TENCENT:
                return y();
            case BING:
                return t();
            default:
                return 1000;
        }
    }

    public static Context a() {
        return j;
    }

    public static void a(String str) {
        G = str;
    }

    public static void c(boolean z) {
        x = false;
    }

    public static void d(boolean z) {
        z = z;
    }

    public static void e(boolean z) {
        if (j != null) {
            Editor edit = j.getSharedPreferences("mapsdk_pref", 0).edit();
            edit.putBoolean("worldEnable", z);
            edit.commit();
        }
    }

    public static void n() {
    }

    public static boolean q() {
        return x;
    }

    public static boolean r() {
        return z;
    }

    public static int s() {
        int i;
        synchronized (i) {
            i = B;
        }
        return i;
    }

    public static int t() {
        int i;
        synchronized (i) {
            i = C;
        }
        return i;
    }

    public static String u() {
        return G;
    }

    public static int v() {
        int i;
        synchronized (i) {
            i = A;
        }
        return i;
    }

    public static int w() {
        int i;
        synchronized (i) {
            i = E;
        }
        return i;
    }

    public static int x() {
        return F;
    }

    public static int y() {
        int i;
        synchronized (i) {
            i = D;
        }
        return i;
    }

    public final void a(int i) {
        if (i == 2) {
            this.s.a(true);
        } else {
            this.s.a(false);
        }
        this.u = i;
        a(false, false);
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, Bitmap bitmap) {
        synchronized (i) {
            D = i;
            A = i2;
            new StringBuilder("CurrentVersion in Update:").append(A);
            B = i4;
            C = i3;
            E = i5;
            F = i6;
            this.o.a(i2);
            this.o.b(i4);
            this.o.c(i5);
            if (this.s != null) {
                this.s.a(bitmap);
            }
            a(false, false);
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            this.r.e(bundle.getBoolean("ANIMATION_ENABLED", true));
            this.r.b(bundle.getBoolean("SCROLL_ENABLED", true));
            this.r.c(bundle.getBoolean("ZOOM_ENABLED", true));
            this.r.b(bundle.getInt("LOGO_POSITION", 0));
            this.r.c(bundle.getInt("SCALEVIEW_POSITION", 0));
            this.r.a(bundle.getBoolean("SCALE_CONTROLL_ENABLED", true));
            this.m.b(bundle.getDouble("ZOOM", this.m.c()), false, null);
            Double valueOf = Double.valueOf(bundle.getDouble("CENTERX", Double.NaN));
            Double valueOf2 = Double.valueOf(bundle.getDouble("CENTERY", Double.NaN));
            if (!valueOf.isNaN() && !valueOf2.isNaN()) {
                this.m.a(new c(valueOf.doubleValue(), valueOf2.doubleValue()));
            }
        }
    }

    public final void a(j jVar) {
        a(jVar, null);
    }

    public final void a(j jVar, Rect rect) {
        this.v = jVar;
        this.y = rect;
        com.tencent.mapsdk.rastercore.f.a.a(this.m, 1);
        if (this.w) {
            o();
            return;
        }
        this.m.a(true);
        a(false, false);
    }

    public final void a(boolean z) {
        if (z) {
            this.t.setVisibility(0);
            this.t.d();
            return;
        }
        a.b();
        a.c();
        this.t.setVisibility(8);
    }

    public final void a(boolean z, boolean z2) {
        this.w = false;
        this.o.a(z, z2);
        this.k.layout();
        this.k.postInvalidate();
    }

    public final c b() {
        return this.q;
    }

    public final void b(int i) {
        if (this.s != null) {
            this.s.a(i);
            this.s.invalidate();
            if (this.t.getVisibility() == 0) {
                this.t.invalidate();
            }
        }
    }

    public final void b(Bundle bundle) {
        bundle.putBoolean("ANIMATION_ENABLED", this.r.k());
        bundle.putBoolean("SCROLL_ENABLED", this.r.h());
        bundle.putBoolean("ZOOM_ENABLED", this.r.i());
        bundle.putInt("LOGO_POSITION", this.r.j());
        bundle.putInt("SCALEVIEW_POSITION", this.r.f());
        bundle.putBoolean("SCALE_CONTROLL_ENABLED", this.r.g());
        bundle.putDouble("ZOOM", this.m.c());
        bundle.putDouble("CENTERX", this.m.b().b());
        bundle.putDouble("CENTERY", this.m.b().a());
    }

    protected final void b(boolean z) {
        this.w = z;
    }

    public final b c() {
        return this.m;
    }

    public final void c(int i) {
        if (this.t != null && this.t.getVisibility() == 0) {
            this.t.a(i);
            this.t.invalidate();
        }
    }

    public final MapView d() {
        return this.k;
    }

    public final a e() {
        return this.l;
    }

    public final com.tencent.mapsdk.rastercore.d.a.AnonymousClass1 f() {
        return this.r;
    }

    protected final void f(boolean z) {
        this.H = z;
    }

    public final com.tencent.mapsdk.rastercore.tile.a.AnonymousClass1 g() {
        return this.o;
    }

    public final void g(boolean z) {
        if (z != this.I) {
            this.I = z;
            a(false, false);
        }
    }

    public final f h() {
        return this.n;
    }

    public final f i() {
        return this.p;
    }

    public final void j() {
        this.t.e();
    }

    public final void k() {
        this.t.d();
    }

    public final int l() {
        return this.u;
    }

    public final void m() {
        this.t.a();
        this.s.a();
        this.l.b();
        this.k.stopAnimation();
        this.k.removeAllViews();
        this.o.a();
        com.tencent.mapsdk.rastercore.tile.a.a.a().c();
        new Thread(this) {
            public final void run() {
                Throwable th;
                HttpURLConnection httpURLConnection = null;
                HttpURLConnection httpURLConnection2;
                try {
                    String str = Integer.toString(e.c) + "," + Integer.toString(e.d);
                    String str2 = Integer.toString(e.a) + "," + Integer.toString(e.b);
                    String str3 = Integer.toString(e.e) + "," + Integer.toString(0);
                    httpURLConnection2 = (HttpURLConnection) new URL("https://pr.map.qq.com/pingd?" + com.tencent.mapsdk.rastercore.a.a.toString() + "&appid=sdk&logid=ditu&miss=" + str + "&hit=" + str2 + "&keep=" + str3 + "&change=" + (Integer.toString(e.f) + "," + Integer.toString(0))).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.connect();
                        if (httpURLConnection2.getResponseCode() == 200) {
                            httpURLConnection2.getInputStream();
                            e.c = 0;
                            e.d = 0;
                            e.a = 0;
                            e.b = 0;
                            e.e = 0;
                            e.f = 0;
                            e.g = 0;
                            e.b = 0;
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Exception e) {
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        httpURLConnection = httpURLConnection2;
                        th = th3;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    httpURLConnection2 = null;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        }.start();
        System.gc();
    }

    protected final void o() {
        if (this.v != null) {
            this.k.setDrawingCacheEnabled(true);
            this.k.buildDrawingCache();
            if (this.y == null) {
                Bitmap.createBitmap(this.k.getDrawingCache());
            } else {
                Bitmap.createBitmap(this.k.getDrawingCache(), this.y.left, this.y.top, this.y.width(), this.y.height());
            }
            this.k.destroyDrawingCache();
            if (this.H) {
                com.tencent.mapsdk.rastercore.f.a.a(this.m, 2);
            }
        }
    }

    public final void p() {
        if (this.s != null) {
            this.s.invalidate();
        }
    }

    public final boolean z() {
        return this.I;
    }
}
