package com.tencent.mm.plugin.appbrand.share.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.g;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a implements g {
    private final Map<String, SoftReference<e>> jOR = new ConcurrentHashMap();
    private final Map<String, SoftReference<f>> jOS = new ConcurrentHashMap();
    private final Map<Integer, a> jOT = new ConcurrentHashMap();
    private final Map<Integer, Bundle> jOU = new ConcurrentHashMap();

    private interface a {
        void x(Bundle bundle);
    }

    public a() {
        a(1, new a() {
            public final void x(Bundle bundle) {
                a.this.jOU.remove(Integer.valueOf(2));
            }
        });
    }

    public final View be(Context context) {
        Assert.assertNotNull(context);
        return new WxaShareMessagePage(context);
    }

    public final boolean a(String str, View view, Bundle bundle) {
        Bitmap bitmap = null;
        Assert.assertNotNull(view);
        Assert.assertNotNull(bundle);
        if (!(view instanceof WxaShareMessagePage)) {
            return false;
        }
        x.i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", str, Integer.valueOf(view.hashCode()));
        final WxaShareMessagePage wxaShareMessagePage = (WxaShareMessagePage) view;
        boolean z = bundle.getBoolean("is_dynamic_page");
        wxaShareMessagePage.jOY.setText(bundle.getString("title", ""));
        if (z) {
            wxaShareMessagePage.jvL.setVisibility(4);
            View view2 = wxaShareMessagePage.jPa;
            view2.setVisibility(0);
            bundle.putInt("view_init_width", WxaShareMessagePage.akM());
            bundle.putInt("view_init_height", WxaShareMessagePage.akN());
            ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.e.class)).a(str, view2, bundle, new r(new com.tencent.mm.modelappbrand.f() {
                public final void q(View view, int i) {
                    switch (i) {
                        case 0:
                            wxaShareMessagePage.jPb.setVisibility(0);
                            wxaShareMessagePage.jOZ.setVisibility(4);
                            wxaShareMessagePage.jPa.setVisibility(4);
                            wxaShareMessagePage.jPb.czW();
                            return;
                        case 1:
                            wxaShareMessagePage.jPb.ajR();
                            wxaShareMessagePage.jPb.setVisibility(4);
                            wxaShareMessagePage.jOZ.setVisibility(0);
                            wxaShareMessagePage.jPa.setVisibility(4);
                            wxaShareMessagePage.jOZ.setImageResource(i.dyF);
                            return;
                        case 4:
                            wxaShareMessagePage.jPb.setVisibility(4);
                            wxaShareMessagePage.jOZ.setVisibility(4);
                            wxaShareMessagePage.jPa.setVisibility(0);
                            return;
                        default:
                            wxaShareMessagePage.jPb.ajR();
                            wxaShareMessagePage.jPb.setVisibility(4);
                            wxaShareMessagePage.jOZ.setVisibility(0);
                            wxaShareMessagePage.jPa.setVisibility(4);
                            wxaShareMessagePage.jOZ.setImageResource(i.dvT);
                            return;
                    }
                }
            }));
        } else {
            wxaShareMessagePage.jPa.setVisibility(4);
            wxaShareMessagePage.jvL.setVisibility(0);
            byte[] byteArray = bundle.getByteArray("image_data");
            if (byteArray != null && byteArray.length > 0) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                    wxaShareMessagePage.s(decodeByteArray);
                    return true;
                }
            }
            String string = bundle.getString("delay_load_img_path");
            if (bi.oN(string)) {
                String string2 = bundle.getString("image_url");
                if (string2 == null || !(string2.startsWith("http://") || string2.startsWith("https://"))) {
                    if (string2 != null && string2.startsWith("file://")) {
                        Bitmap a = b.Jp().a(string2, null);
                        if (!(a == null || a.isRecycled())) {
                            wxaShareMessagePage.s(a);
                            return true;
                        }
                    }
                    wxaShareMessagePage.Jt();
                } else {
                    wxaShareMessagePage.uK(string2);
                }
            } else {
                if (!string.startsWith("delayLoadFile://")) {
                    bitmap = b.Jp().a(string, null);
                    x.i("MicroMsg.WxaShareMessageService", "findCachedLocal(%s)", string);
                } else if (this.jOU.containsKey(Integer.valueOf(2))) {
                    bitmap = d.Vs(string.replace("delayLoadFile://", ""));
                    x.i("MicroMsg.WxaShareMessageService", "getBitmapNative(%s)", string);
                }
                if (bitmap != null) {
                    if (bitmap.isRecycled()) {
                        wxaShareMessagePage.uK(string);
                    } else {
                        wxaShareMessagePage.s(bitmap);
                    }
                    return true;
                }
                x.i("MicroMsg.WxaShareMessageService", "delay loadImage(%s)", string);
                wxaShareMessagePage.jPb.setVisibility(0);
                wxaShareMessagePage.jOZ.setVisibility(4);
                wxaShareMessagePage.jvL.setVisibility(4);
                wxaShareMessagePage.jPb.czW();
                a(2, new a() {
                    public final void x(final Bundle bundle) {
                        com.tencent.mm.by.a.Z(new Runnable() {
                            public final void run() {
                                wxaShareMessagePage.uK(bundle.getString("delay_load_img_path"));
                                x.i("MicroMsg.WxaShareMessageService", "onLoadImageFinishedAction(%s)", r0);
                            }
                        });
                    }
                });
            }
        }
        return true;
    }

    public final void a(String str, View view) {
        Assert.assertNotNull(view);
        if (view instanceof WxaShareMessagePage) {
            x.i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", str, Integer.valueOf(view.hashCode()));
            ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.g.h(com.tencent.mm.modelappbrand.e.class)).a(str, ((WxaShareMessagePage) view).jPa);
            this.jOT.remove(Integer.valueOf(2));
        }
    }

    public final synchronized void c(int i, Bundle bundle) {
        a aVar = (a) this.jOT.get(Integer.valueOf(i));
        if (aVar != null) {
            aVar.x(bundle);
        }
        this.jOU.put(Integer.valueOf(i), bundle);
        x.i("MicroMsg.WxaShareMessageService", "onAction(%d, %s)", Integer.valueOf(i), bundle);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.modelappbrand.a.b.e aZ(int r5, int r6) {
        /*
        r4 = this;
        r0 = "%d-%d-dp";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r5);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r6);
        r1[r2] = r3;
        r1 = java.lang.String.format(r0, r1);
        r0 = r4.jOR;
        r0 = r0.get(r1);
        r0 = (java.lang.ref.SoftReference) r0;
        if (r0 == 0) goto L_0x002a;
    L_0x0022:
        r0 = r0.get();
        r0 = (com.tencent.mm.modelappbrand.a.b.e) r0;
        if (r0 != 0) goto L_0x005d;
    L_0x002a:
        monitor-enter(r4);
        r0 = r4.jOR;	 Catch:{ all -> 0x005e }
        r0 = r0.get(r1);	 Catch:{ all -> 0x005e }
        r0 = (java.lang.ref.SoftReference) r0;	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x003d;
    L_0x0035:
        r0 = r0.get();	 Catch:{ all -> 0x005e }
        r0 = (com.tencent.mm.modelappbrand.a.b.e) r0;	 Catch:{ all -> 0x005e }
        if (r0 != 0) goto L_0x005c;
    L_0x003d:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x005e }
        r2 = com.tencent.mm.bu.a.fromDPToPix(r0, r5);	 Catch:{ all -> 0x005e }
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x005e }
        r3 = com.tencent.mm.bu.a.fromDPToPix(r0, r6);	 Catch:{ all -> 0x005e }
        r0 = new com.tencent.mm.plugin.appbrand.share.a;	 Catch:{ all -> 0x005e }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x005e }
        r2 = r4.jOR;	 Catch:{ all -> 0x005e }
        r3 = new java.lang.ref.SoftReference;	 Catch:{ all -> 0x005e }
        r3.<init>(r0);	 Catch:{ all -> 0x005e }
        r2.put(r1, r3);	 Catch:{ all -> 0x005e }
    L_0x005c:
        monitor-exit(r4);	 Catch:{ all -> 0x005e }
    L_0x005d:
        return r0;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x005e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.share.a.a.aZ(int, int):com.tencent.mm.modelappbrand.a.b$e");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.modelappbrand.a.b.f Je() {
        /*
        r5 = this;
        r3 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r4 = 90;
        r0 = "%d-%d-dp";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r4);
        r1[r2] = r3;
        r1 = java.lang.String.format(r0, r1);
        r0 = r5.jOS;
        r0 = r0.get(r1);
        r0 = (java.lang.ref.SoftReference) r0;
        if (r0 == 0) goto L_0x002e;
    L_0x0026:
        r0 = r0.get();
        r0 = (com.tencent.mm.modelappbrand.a.b.f) r0;
        if (r0 != 0) goto L_0x0065;
    L_0x002e:
        monitor-enter(r5);
        r0 = r5.jOS;	 Catch:{ all -> 0x0066 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0066 }
        r0 = (java.lang.ref.SoftReference) r0;	 Catch:{ all -> 0x0066 }
        if (r0 == 0) goto L_0x0041;
    L_0x0039:
        r0 = r0.get();	 Catch:{ all -> 0x0066 }
        r0 = (com.tencent.mm.modelappbrand.a.b.f) r0;	 Catch:{ all -> 0x0066 }
        if (r0 != 0) goto L_0x0064;
    L_0x0041:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x0066 }
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r2 = com.tencent.mm.bu.a.fromDPToPix(r0, r2);	 Catch:{ all -> 0x0066 }
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ all -> 0x0066 }
        r3 = 90;
        r3 = com.tencent.mm.bu.a.fromDPToPix(r0, r3);	 Catch:{ all -> 0x0066 }
        r0 = new com.tencent.mm.plugin.appbrand.share.b;	 Catch:{ all -> 0x0066 }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x0066 }
        r2 = r5.jOS;	 Catch:{ all -> 0x0066 }
        r3 = new java.lang.ref.SoftReference;	 Catch:{ all -> 0x0066 }
        r3.<init>(r0);	 Catch:{ all -> 0x0066 }
        r2.put(r1, r3);	 Catch:{ all -> 0x0066 }
    L_0x0064:
        monitor-exit(r5);	 Catch:{ all -> 0x0066 }
    L_0x0065:
        return r0;
    L_0x0066:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0066 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.share.a.a.Je():com.tencent.mm.modelappbrand.a.b$f");
    }

    private void a(int i, a aVar) {
        this.jOT.put(Integer.valueOf(i), aVar);
        if (this.jOU.containsKey(Integer.valueOf(i))) {
            aVar.x((Bundle) this.jOU.get(Integer.valueOf(i)));
        }
    }
}
