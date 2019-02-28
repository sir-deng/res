package com.d.a.a;

import android.content.Context;
import android.location.LocationManager;
import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import java.lang.ref.WeakReference;

public final class t {
    private static boolean bgH = false;
    private static Context bks;
    private static WeakReference<b> bkt;
    private static WeakReference<d> bku;
    private static WeakReference<c> bkv;
    private static WeakReference<e> bkw;
    private static final a bkx = new a();
    private static String imei;

    public interface b {
        void a(double d, double d2, int i, int i2, long j);
    }

    public interface c {
    }

    public interface d {
        void onMessage(int i, String str);
    }

    public interface e {
    }

    private static class a implements m {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(com.d.a.a.p r11) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r10 = this;
            r0 = r11.what;
            switch(r0) {
                case 8901: goto L_0x0044;
                case 8902: goto L_0x0057;
                case 9901: goto L_0x0006;
                case 9902: goto L_0x0028;
                default: goto L_0x0005;
            };
        L_0x0005:
            return;
        L_0x0006:
            r0 = com.d.a.a.t.bkt;
            if (r0 == 0) goto L_0x0005;
        L_0x000c:
            r0 = com.d.a.a.t.bkt;
            r1 = r0.get();
            r1 = (com.d.a.a.t.b) r1;
            if (r1 == 0) goto L_0x0005;
        L_0x0018:
            r11 = (com.d.a.a.n.a) r11;
            r2 = r11.lat;
            r4 = r11.lng;
            r6 = r11.bji;
            r7 = r11.bjj;
            r8 = r11.bjk;
            r1.a(r2, r4, r6, r7, r8);
            goto L_0x0005;
        L_0x0028:
            r0 = com.d.a.a.t.bku;
            if (r0 == 0) goto L_0x0005;
        L_0x002e:
            r0 = com.d.a.a.t.bku;
            r0 = r0.get();
            r0 = (com.d.a.a.t.d) r0;
            if (r0 == 0) goto L_0x0005;
        L_0x003a:
            r11 = (com.d.a.a.n.b) r11;
            r1 = r11.code;
            r2 = r11.message;
            r0.onMessage(r1, r2);
            goto L_0x0005;
        L_0x0044:
            r0 = com.d.a.a.t.bkv;
            if (r0 == 0) goto L_0x0005;
        L_0x004a:
            r0 = com.d.a.a.t.bkv;
            r0 = r0.get();
            r0 = (com.d.a.a.t.c) r0;
            if (r0 == 0) goto L_0x0005;
        L_0x0056:
            goto L_0x0005;
        L_0x0057:
            r0 = com.d.a.a.t.bkv;
            if (r0 == 0) goto L_0x0005;
        L_0x005d:
            r0 = com.d.a.a.t.bkv;
            r0.get();
            goto L_0x0005;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.d.a.a.t.a.a(com.d.a.a.p):void");
        }
    }

    public static void a(Context context, q qVar) {
        bks = context.getApplicationContext();
        try {
            w.sz().a(context, bkx);
            r.sd().bjL = qVar;
            r.sd().bjM = imei;
        } catch (Exception e) {
        }
    }

    public static void setImei(String str) {
        imei = str;
    }

    public static boolean a(Handler handler, long j, b bVar, d dVar) {
        if (bks == null) {
            return false;
        }
        if (bgH) {
            return true;
        }
        bkt = new WeakReference(bVar);
        bku = new WeakReference(dVar);
        bkv = new WeakReference(null);
        try {
            w sz = w.sz();
            if (handler == null) {
                handler = new Handler(bks.getMainLooper());
            }
            sz.a(handler, new c(j, 5000));
            if (y.bmL) {
                y.bmS = o.sc();
                o.o("filter_input_log_" + y.bmS, "type,unixTime,latR,lngR,alt,acc,numWap,speed,maturity,numStep,stepLength,bearingR");
                o.o("filter_output_log_" + y.bmS, "time,lat,lng,err,speed");
                o.o("gps_log_" + y.bmS, "lat,lng,alt,accuracy,speed,numSatVisible,numSatUsedInFix,quality,timeSinceFixS");
                o.o("post_processing_log_" + y.bmS, "tag,lat,lng");
            }
            if (!(bkw == null || ((e) bkw.get()) == null)) {
                boolean isProviderEnabled;
                LocationManager locationManager = (LocationManager) bks.getSystemService("location");
                try {
                    isProviderEnabled = locationManager.isProviderEnabled("gps");
                } catch (SecurityException e) {
                    isProviderEnabled = false;
                }
                if (!isProviderEnabled) {
                    try {
                        locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                    } catch (SecurityException e2) {
                    }
                }
            }
            bgH = true;
            return true;
        } catch (Exception e3) {
            bgH = false;
            return false;
        }
    }

    public static void sq() {
        try {
            w.sz().stop();
        } catch (Exception e) {
        } finally {
            bgH = false;
        }
    }

    public static void finish() {
        try {
            w.sz().rV();
        } catch (Exception e) {
        }
    }
}
