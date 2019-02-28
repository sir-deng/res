package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.text.TextUtils;
import android.util.SparseArray;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.f.i;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.tencentmap.lbssdk.service.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jdt.annotation.Nullable;

public final class de {
    public static final TencentLocationListener a = new TencentLocationListener() {
        public final void onStatusUpdate(String str, int i, String str2) {
        }

        public final void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        }
    };
    private static SparseArray<String> n;
    private HandlerThread A;
    private dj B;
    private ct C;
    private dn D;
    private dr E;
    private dr F;
    private do G;
    private final cr H;
    private TencentLocationListener I;
    private volatile boolean J = false;
    private volatile double K = 0.0d;
    private long L;
    private final Object M = new Object();
    private double N;
    private double O;
    private dz P;
    private long Q;
    private String R;
    private volatile boolean S = false;
    private cp T = null;
    public int b = 1;
    public dk c;
    public volatile int d = 0;
    public cs e;
    public List<TencentLocationListener> f;
    public long g = 0;
    public volatile long h = 0;
    public volatile int i = 0;
    public final TencentLocationRequest j = TencentLocationRequest.create();
    public dz k;
    public int l = TencentLocation.ERROR_UNKNOWN;
    public volatile b m = b.Stop;
    private volatile HandlerThread o;
    private a p;
    private c q;
    private Handler r;
    private da s;
    private dg t;
    private boolean u;
    private dd v;
    private dc w;
    private cy x;
    private df y;
    private di z;

    class a extends Handler {
        private long a = 0;
        private boolean b = false;
        private boolean c = false;
        private int d = 0;

        a(Looper looper) {
            super(looper);
        }

        public final void a() {
            this.d = 0;
            removeCallbacksAndMessages(null);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r14) {
            /*
            r13 = this;
            r12 = 2;
            r10 = 0;
            r7 = 1;
            r8 = 0;
            r0 = c.t.m.g.de.this;
            r1 = r0.M;
            monitor-enter(r1);
            r0 = c.t.m.g.de.this;	 Catch:{ all -> 0x007d }
            r0 = r0.I;	 Catch:{ all -> 0x007d }
            if (r0 != 0) goto L_0x0020;
        L_0x0014:
            r0 = c.t.m.g.de.this;	 Catch:{ all -> 0x007d }
            r0 = r0.m;	 Catch:{ all -> 0x007d }
            r2 = c.t.m.g.de.b.Normal;	 Catch:{ all -> 0x007d }
            if (r0 != r2) goto L_0x0020;
        L_0x001e:
            monitor-exit(r1);	 Catch:{ all -> 0x007d }
        L_0x001f:
            return;
        L_0x0020:
            r0 = c.t.m.g.de.this;	 Catch:{ all -> 0x007d }
            r0 = r0.I;	 Catch:{ all -> 0x007d }
            monitor-exit(r1);	 Catch:{ all -> 0x007d }
            r1 = c.t.m.g.de.this;
            r9 = r1.j;
            r1 = r9.getRequestLevel();
            r2 = c.t.m.g.de.this;
            r2 = r2.h;
            r4 = r14.what;	 Catch:{ Throwable -> 0x00cf }
            switch(r4) {
                case 554: goto L_0x003d;
                case 555: goto L_0x0482;
                case 3997: goto L_0x0252;
                case 3999: goto L_0x0139;
                case 4998: goto L_0x045f;
                case 4999: goto L_0x028c;
                case 7999: goto L_0x0108;
                case 11998: goto L_0x00d2;
                case 11999: goto L_0x0080;
                default: goto L_0x003c;
            };	 Catch:{ Throwable -> 0x00cf }
        L_0x003c:
            goto L_0x001f;
        L_0x003d:
            r0 = r14.getData();	 Catch:{ Throwable -> 0x00cf }
            if (r0 == 0) goto L_0x001f;
        L_0x0043:
            r1 = "WIFIS";
            r0 = r0.getString(r1);	 Catch:{ Throwable -> 0x00cf }
            r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x00cf }
            if (r1 != 0) goto L_0x001f;
        L_0x0050:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.z;	 Catch:{ Throwable -> 0x00cf }
            r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x007b }
            if (r2 != 0) goto L_0x001f;
        L_0x005c:
            r2 = "UTF-8";
            r2 = r0.getBytes(r2);	 Catch:{ Throwable -> 0x007b }
            r2 = c.t.m.g.eg.a(r2);	 Catch:{ Throwable -> 0x007b }
            r3 = 2;
            com.tencent.tencentmap.lbssdk.service.e.o(r2, r3);	 Catch:{ Throwable -> 0x007b }
            r3 = new c.t.m.g.di$a;	 Catch:{ Throwable -> 0x007b }
            r4 = 3;
            r5 = "http://ue.indoorloc.map.qq.com/?wl";
            r6 = 0;
            r3.<init>(r4, r2, r5, r6);	 Catch:{ Throwable -> 0x007b }
            r3.b = r0;	 Catch:{ Throwable -> 0x007b }
            r1.a(r3);	 Catch:{ Throwable -> 0x007b }
            goto L_0x001f;
        L_0x007b:
            r0 = move-exception;
            goto L_0x001f;
        L_0x007d:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x007d }
            throw r0;
        L_0x0080:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.k;	 Catch:{ Throwable -> 0x00cf }
            if (r1 == 0) goto L_0x00c4;
        L_0x0088:
            r4 = r9.getInterval();	 Catch:{ Throwable -> 0x00cf }
            r1 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
            if (r1 <= 0) goto L_0x00c4;
        L_0x0090:
            if (r0 == 0) goto L_0x00c4;
        L_0x0092:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.g();	 Catch:{ Throwable -> 0x00cf }
            if (r0 != 0) goto L_0x00c4;
        L_0x009a:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.k;	 Catch:{ Throwable -> 0x00cf }
            r0.a(r1);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.k;	 Catch:{ Throwable -> 0x00cf }
            r4 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r4 = r4.l;	 Catch:{ Throwable -> 0x00cf }
            r5 = 3101; // 0xc1d float:4.345E-42 double:1.532E-320;
            r0.a(r1, r4, r5);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.k;	 Catch:{ Throwable -> 0x00cf }
            r1 = "timed";
            a(r0, r1);	 Catch:{ Throwable -> 0x00cf }
        L_0x00c4:
            r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
            if (r0 <= 0) goto L_0x001f;
        L_0x00c8:
            r0 = 11999; // 0x2edf float:1.6814E-41 double:5.9283E-320;
            r13.sendEmptyMessageDelayed(r0, r2);	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x00cf:
            r0 = move-exception;
            goto L_0x001f;
        L_0x00d2:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.k;	 Catch:{ Throwable -> 0x00cf }
            if (r1 == 0) goto L_0x001f;
        L_0x00da:
            if (r0 == 0) goto L_0x001f;
        L_0x00dc:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.k;	 Catch:{ Throwable -> 0x00cf }
            r0.a(r1);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.k;	 Catch:{ Throwable -> 0x00cf }
            r2 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = r2.l;	 Catch:{ Throwable -> 0x00cf }
            r3 = 3101; // 0xc1d float:4.345E-42 double:1.532E-320;
            r0.a(r1, r2, r3);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.k;	 Catch:{ Throwable -> 0x00cf }
            r1 = "direct";
            a(r0, r1);	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x0108:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.f();	 Catch:{ Throwable -> 0x00cf }
            if (r0 != 0) goto L_0x001f;
        L_0x0110:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.j;	 Catch:{ Throwable -> 0x00cf }
            r2 = r0.getInterval();	 Catch:{ Throwable -> 0x00cf }
            r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
            r2 = java.lang.Math.max(r2, r4);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r4 = r0.L;	 Catch:{ Throwable -> 0x00cf }
            r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
            if (r0 == 0) goto L_0x001f;
        L_0x012a:
            r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r10 = r0.L;	 Catch:{ Throwable -> 0x00cf }
            r4 = r4 - r10;
            r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
            if (r0 < 0) goto L_0x001f;
        L_0x0139:
            r0 = 3999; // 0xf9f float:5.604E-42 double:1.976E-320;
            r13.removeMessages(r0);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.m;	 Catch:{ Throwable -> 0x00cf }
            r2 = c.t.m.g.de.b.Daemon;	 Catch:{ Throwable -> 0x00cf }
            if (r0 == r2) goto L_0x01a4;
        L_0x0148:
            false;	 Catch:{ Throwable -> 0x00cf }
        L_0x014b:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r10 = r0.b;	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.n(r0);	 Catch:{ Throwable -> 0x00cf }
            r2 = r0.a();	 Catch:{ Throwable -> 0x00cf }
            if (r2 == 0) goto L_0x01fe;
        L_0x015d:
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00cf }
            r4 = r13.a;	 Catch:{ Throwable -> 0x00cf }
            r2 = r2 - r4;
            r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 <= 0) goto L_0x01fe;
        L_0x016b:
            r2 = 1;
            r13.b = r2;	 Catch:{ Throwable -> 0x00cf }
            r2 = 0;
            r13.c = r2;	 Catch:{ Throwable -> 0x00cf }
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00cf }
            r13.a = r2;	 Catch:{ Throwable -> 0x00cf }
        L_0x0177:
            r2 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = r2.R;	 Catch:{ Throwable -> 0x00cf }
            r3 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r3 = r3.H;	 Catch:{ Throwable -> 0x00cf }
            r4 = r13.b;	 Catch:{ Throwable -> 0x00cf }
            r5 = r13.c;	 Catch:{ Throwable -> 0x00cf }
            r6 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r6 = r6.m;	 Catch:{ Throwable -> 0x00cf }
            r11 = c.t.m.g.de.b.Daemon;	 Catch:{ Throwable -> 0x00cf }
            if (r6 != r11) goto L_0x0203;
        L_0x0191:
            r6 = r7;
        L_0x0192:
            r2 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x00cf }
            r3 = c.t.m.g.eg.a(r2);	 Catch:{ Throwable -> 0x00cf }
            if (r3 != 0) goto L_0x0205;
        L_0x019c:
            if (r7 == 0) goto L_0x0207;
        L_0x019e:
            r0 = 2;
            r13.b(r0);	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x01a4:
            r0 = c.t.m.g.cl.a();	 Catch:{ Throwable -> 0x00cf }
            r2 = "up_daemon_delay";
            r2 = r0.c(r2);	 Catch:{ Throwable -> 0x00cf }
            r4 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 >= 0) goto L_0x01b9;
        L_0x01b6:
            r2 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        L_0x01b9:
            r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cf }
            r4 = "the daemonLocation,so we delay long time upload:";
            r0.<init>(r4);	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.append(r2);	 Catch:{ Throwable -> 0x00cf }
            r4 = ",";
            r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00cf }
            r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00cf }
            r4 = ",";
            r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00cf }
            r4 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r4 = r4.Q;	 Catch:{ Throwable -> 0x00cf }
            r0.append(r4);	 Catch:{ Throwable -> 0x00cf }
            r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r10 = r0.Q;	 Catch:{ Throwable -> 0x00cf }
            r4 = r4 - r10;
            r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
            if (r0 < 0) goto L_0x001f;
        L_0x01f3:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00cf }
            r0.Q = r2;	 Catch:{ Throwable -> 0x00cf }
            goto L_0x014b;
        L_0x01fe:
            r2 = 0;
            r13.b = r2;	 Catch:{ Throwable -> 0x00cf }
            goto L_0x0177;
        L_0x0203:
            r6 = r8;
            goto L_0x0192;
        L_0x0205:
            r7 = r8;
            goto L_0x019c;
        L_0x0207:
            r3 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r3 = r3.m;	 Catch:{ Throwable -> 0x00cf }
            r4 = c.t.m.g.de.b.Normal;	 Catch:{ Throwable -> 0x00cf }
            if (r3 != r4) goto L_0x023b;
        L_0x0211:
            r3 = com.tencent.map.geolocation.internal.TencentExtraKeys.isRequestRawData(r9);	 Catch:{ Throwable -> 0x00cf }
            if (r3 == 0) goto L_0x023b;
        L_0x0217:
            r0 = new c.t.m.g.dz$a;	 Catch:{ Throwable -> 0x00cf }
            r0.<init>();	 Catch:{ Throwable -> 0x00cf }
            r3 = 0;
            r0.b = r3;	 Catch:{ Throwable -> 0x00cf }
            r0.c = r1;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.a();	 Catch:{ Throwable -> 0x00cf }
            r1 = r2.getBytes();	 Catch:{ Throwable -> 0x00cf }
            com.tencent.map.geolocation.internal.TencentExtraKeys.setRawData(r0, r1);	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1.a(r0);	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = 0;
            r3 = 3101; // 0xc1d float:4.345E-42 double:1.532E-320;
            r1.a(r0, r2, r3);	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x023b:
            r1 = com.tencent.map.geolocation.internal.TencentExtraKeys.MOCK_LOCATION_FILTER;	 Catch:{ Throwable -> 0x00cf }
            if (r1 == 0) goto L_0x001f;
        L_0x023f:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.z;	 Catch:{ Throwable -> 0x00cf }
            r1.a(r2, r0, r10);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0.C;	 Catch:{ Throwable -> 0x00cf }
            java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x0252:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.n(r0);	 Catch:{ Throwable -> 0x00cf }
            r2 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = r2.R;	 Catch:{ Throwable -> 0x00cf }
            r3 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r3 = r3.H;	 Catch:{ Throwable -> 0x00cf }
            r4 = 0;
            r5 = 0;
            r6 = 0;
            r1 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x00cf }
            r2 = c.t.m.g.eg.a(r1);	 Catch:{ Throwable -> 0x00cf }
            if (r2 != 0) goto L_0x0279;
        L_0x0271:
            if (r7 == 0) goto L_0x027b;
        L_0x0273:
            r0 = 2;
            r13.b(r0);	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x0279:
            r7 = r8;
            goto L_0x0271;
        L_0x027b:
            r2 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = r2.z;	 Catch:{ Throwable -> 0x00cf }
            r3 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r3 = r3.b;	 Catch:{ Throwable -> 0x00cf }
            r2.a(r1, r0, r3);	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x028c:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.e;	 Catch:{ Throwable -> 0x00cf }
            r2 = r0.n;	 Catch:{ Throwable -> 0x00cf }
            r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
            if (r0 != 0) goto L_0x02ad;
        L_0x0298:
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.e;	 Catch:{ Throwable -> 0x00cf }
            r4 = r0.m;	 Catch:{ Throwable -> 0x00cf }
            r2 = r2 - r4;
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.e;	 Catch:{ Throwable -> 0x00cf }
            r0.n = r2;	 Catch:{ Throwable -> 0x00cf }
        L_0x02ad:
            r0 = 4998; // 0x1386 float:7.004E-42 double:2.4693E-320;
            r13.removeMessages(r0);	 Catch:{ Throwable -> 0x00cf }
            r0 = r14.obj;	 Catch:{ Throwable -> 0x00cf }
            r0 = (android.util.Pair) r0;	 Catch:{ Throwable -> 0x00cf }
            r2 = r0.first;	 Catch:{ Throwable -> 0x00cf }
            r4 = r2.toString();	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.second;	 Catch:{ Throwable -> 0x00cf }
            r0 = (c.t.m.g.di.a) r0;	 Catch:{ Throwable -> 0x00cf }
            r2 = r0.a;	 Catch:{ Throwable -> 0x00cf }
            r2 = (c.t.m.g.dp) r2;	 Catch:{ Throwable -> 0x00cf }
            r3 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r5 = r2.b;	 Catch:{ Throwable -> 0x00cf }
            r3.F = r5;	 Catch:{ Throwable -> 0x00cf }
            r5 = r0.b;	 Catch:{ Throwable -> 0x00cf }
            r3 = r2.a();	 Catch:{ Throwable -> 0x00cf }
            if (r3 == 0) goto L_0x043f;
        L_0x02d3:
            r3 = "gps";
        L_0x02d6:
            r6 = new c.t.m.g.dz$a;	 Catch:{ JSONException -> 0x0444 }
            r6.<init>();	 Catch:{ JSONException -> 0x0444 }
            r6.a = r4;	 Catch:{ JSONException -> 0x0444 }
            r6.c = r1;	 Catch:{ JSONException -> 0x0444 }
            r6.d = r3;	 Catch:{ JSONException -> 0x0444 }
            r3 = r6.a();	 Catch:{ JSONException -> 0x0444 }
            r1 = r3.getExtra();	 Catch:{ JSONException -> 0x0444 }
            r6 = "resp_json";
            r1.putString(r6, r4);	 Catch:{ JSONException -> 0x0444 }
            r1 = r3.isMockGps();	 Catch:{ JSONException -> 0x0444 }
            if (r1 != r7) goto L_0x02f8;
        L_0x02f5:
            r1 = 1;
            r13.c = r1;	 Catch:{ JSONException -> 0x0444 }
        L_0x02f8:
            c.t.m.g.dz.a(r3);	 Catch:{ JSONException -> 0x0444 }
            com.tencent.map.geolocation.internal.TencentExtraKeys.setRawQuery(r3, r5);	 Catch:{ Throwable -> 0x044c }
            r1 = r2.c;	 Catch:{ Throwable -> 0x044c }
            if (r1 == 0) goto L_0x048e;
        L_0x0302:
            r1 = r2.c;	 Catch:{ Throwable -> 0x044c }
            r1 = r1.c;	 Catch:{ Throwable -> 0x044c }
        L_0x0306:
            r2 = r3.getExtra();	 Catch:{ Throwable -> 0x044c }
            r4 = "sat_num";
            r2.putInt(r4, r1);	 Catch:{ Throwable -> 0x044c }
            r1 = r3.getExtra();	 Catch:{ Throwable -> 0x044c }
            r2 = "req_cost";
            r4 = r14.arg1;	 Catch:{ Throwable -> 0x044c }
            r4 = (long) r4;	 Catch:{ Throwable -> 0x044c }
            r1.putLong(r2, r4);	 Catch:{ Throwable -> 0x044c }
            r1 = r3.getExtra();	 Catch:{ Throwable -> 0x044c }
            r2 = "req_start";
            r4 = r0.c;	 Catch:{ Throwable -> 0x044c }
            r1.putLong(r2, r4);	 Catch:{ Throwable -> 0x044c }
            r1 = c.t.m.g.cl.a();	 Catch:{ Throwable -> 0x044c }
            r2 = "callback_wifis";
            r1 = r1.d(r2);	 Catch:{ Throwable -> 0x044c }
            if (r1 == 0) goto L_0x0368;
        L_0x0336:
            r1 = r3.getExtra();	 Catch:{ Throwable -> 0x044c }
            r2 = "wifi_collect_time";
            r4 = r0.c;	 Catch:{ Throwable -> 0x044c }
            r1.putLong(r2, r4);	 Catch:{ Throwable -> 0x044c }
            r0 = r3.getExtra();	 Catch:{ Throwable -> 0x044c }
            r1 = "wlan";
            r2 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x044c }
            r2 = r2.H;	 Catch:{ Throwable -> 0x044c }
            r2 = c.t.m.g.eh.c(r2);	 Catch:{ Throwable -> 0x044c }
            r0.putString(r1, r2);	 Catch:{ Throwable -> 0x044c }
            r0 = r3.getExtra();	 Catch:{ Throwable -> 0x044c }
            r1 = "wifis";
            r2 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x044c }
            r2 = r2.c;	 Catch:{ Throwable -> 0x044c }
            r2 = r2.i;	 Catch:{ Throwable -> 0x044c }
            r0.putString(r1, r2);	 Catch:{ Throwable -> 0x044c }
        L_0x0368:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00cf }
            r0.L = r4;	 Catch:{ Throwable -> 0x00cf }
            r0 = r3.getIndoorBuildingId();	 Catch:{ Throwable -> 0x00cf }
            r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x00cf }
            if (r0 != 0) goto L_0x0452;
        L_0x037b:
            r0 = r7;
        L_0x037c:
            if (r0 == 0) goto L_0x03bb;
        L_0x037e:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.i;	 Catch:{ Throwable -> 0x00cf }
            if (r1 != r7) goto L_0x03bb;
        L_0x0386:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.c;	 Catch:{ Throwable -> 0x00cf }
            r4 = 0;
            r1.a(r4);	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.c;	 Catch:{ Throwable -> 0x00cf }
            r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
            r1.j = r4;	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.j;	 Catch:{ Throwable -> 0x00cf }
            r4 = r1.getInterval();	 Catch:{ Throwable -> 0x00cf }
            r6 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
            r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r1 <= 0) goto L_0x03b2;
        L_0x03ab:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
            r1.h = r4;	 Catch:{ Throwable -> 0x00cf }
        L_0x03b2:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = 2;
            r1.i = r2;	 Catch:{ Throwable -> 0x00cf }
            r1 = 0;
            r13.d = r1;	 Catch:{ Throwable -> 0x00cf }
        L_0x03bb:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.i;	 Catch:{ Throwable -> 0x00cf }
            if (r1 != r12) goto L_0x040d;
        L_0x03c3:
            if (r0 != 0) goto L_0x0455;
        L_0x03c5:
            r1 = r13.d;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1 + 1;
            r13.d = r1;	 Catch:{ Throwable -> 0x00cf }
        L_0x03cb:
            r1 = r13.d;	 Catch:{ Throwable -> 0x00cf }
            r2 = 5;
            if (r1 < r2) goto L_0x040d;
        L_0x03d0:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = r1.c;	 Catch:{ Throwable -> 0x00cf }
            r2 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = r2.e;	 Catch:{ Throwable -> 0x00cf }
            r4 = r2.l;	 Catch:{ Throwable -> 0x00cf }
            r1.j = r4;	 Catch:{ Throwable -> 0x00cf }
            r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cf }
            r2 = "indoor stop,";
            r1.<init>(r2);	 Catch:{ Throwable -> 0x00cf }
            r2 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = r2.j;	 Catch:{ Throwable -> 0x00cf }
            r4 = r2.getInterval();	 Catch:{ Throwable -> 0x00cf }
            r1.append(r4);	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = r2.j;	 Catch:{ Throwable -> 0x00cf }
            r4 = r2.getInterval();	 Catch:{ Throwable -> 0x00cf }
            r1.h = r4;	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = 1;
            r1.i = r2;	 Catch:{ Throwable -> 0x00cf }
            r1 = 0;
            r13.d = r1;	 Catch:{ Throwable -> 0x00cf }
        L_0x040d:
            c.t.m.g.dz.a(r3, r0);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r1 = 0;
            r0.a(r1, r3);	 Catch:{ Throwable -> 0x00cf }
            r0 = 0;
            r13.a(r0);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0.P = r3;	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.m;	 Catch:{ Throwable -> 0x00cf }
            r1 = c.t.m.g.de.b.Normal;	 Catch:{ Throwable -> 0x00cf }
            if (r0 != r1) goto L_0x001f;
        L_0x0429:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.S;	 Catch:{ Throwable -> 0x00cf }
            if (r0 != 0) goto L_0x001f;
        L_0x0431:
            r0 = c.t.m.g.ck.a();	 Catch:{ Throwable -> 0x00cf }
            r0.b();	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0.S = true;	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x043f:
            r3 = "network";
            goto L_0x02d6;
        L_0x0444:
            r0 = move-exception;
            r0 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
            r13.b(r0);	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x044c:
            r0 = move-exception;
            r0.toString();	 Catch:{ Throwable -> 0x00cf }
            goto L_0x0368;
        L_0x0452:
            r0 = r8;
            goto L_0x037c;
        L_0x0455:
            r1 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = 0;
            r4 = 3101; // 0xc1d float:4.345E-42 double:1.532E-320;
            r1.a(r3, r2, r4);	 Catch:{ Throwable -> 0x00cf }
            goto L_0x03cb;
        L_0x045f:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.e;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.n;	 Catch:{ Throwable -> 0x00cf }
            r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
            if (r0 != 0) goto L_0x0475;
        L_0x046b:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0 = r0.e;	 Catch:{ Throwable -> 0x00cf }
            r2 = -1;
            r0.n = r2;	 Catch:{ Throwable -> 0x00cf }
        L_0x0475:
            r0 = 1;
            r13.b(r0);	 Catch:{ Throwable -> 0x00cf }
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r2 = -1;
            r0.L = r2;	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x0482:
            r0 = c.t.m.g.de.this;	 Catch:{ Throwable -> 0x00cf }
            r0.E = null;	 Catch:{ Throwable -> 0x00cf }
            r0 = 3999; // 0xf9f float:5.604E-42 double:1.976E-320;
            r13.sendEmptyMessage(r0);	 Catch:{ Throwable -> 0x00cf }
            goto L_0x001f;
        L_0x048e:
            r1 = r8;
            goto L_0x0306;
            */
            throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.de.a.handleMessage(android.os.Message):void");
        }

        private void a(int i) {
            if (de.this.f != null) {
                if (de.this.l == 0) {
                    de.this.a(de.this.k, de.this.l, 3103);
                } else {
                    de.this.a(dz.a, i, 3103);
                }
                de.this.g = 0;
                if (de.this.m == b.Single) {
                    de.this.a();
                }
            }
        }

        private void b(int i) {
            double d = 0.0d;
            Location a = de.this.v.a();
            if (a != db.a && de.this.L == 0 && System.currentTimeMillis() - a.getTime() <= 120000) {
                double d2;
                Location location = new Location(a);
                Bundle extras = location.getExtras();
                if (extras != null) {
                    d2 = extras.getDouble("lat");
                    d = extras.getDouble("lng");
                } else {
                    d2 = 0.0d;
                }
                c.t.m.g.dz.a aVar = new c.t.m.g.dz.a();
                aVar.d = TencentLocation.NETWORK_PROVIDER;
                dz a2 = aVar.a(a).a();
                if (de.this.b == 1) {
                    location.setLatitude(d2);
                    location.setLongitude(d);
                    a2.a(location);
                }
                if (!de.this.g()) {
                    de.this.a(0, a2);
                }
                a(0);
            } else if (de.this.l != 0 || de.this.k == null || System.currentTimeMillis() - de.this.k.getTime() >= 60000) {
                de.this.a(i, dz.a);
                a(i);
            } else {
                a(0);
            }
        }

        private static void a(dz dzVar, String str) {
            String.format("%s,%.6f,%.6f,%.1f", new Object[]{str, Double.valueOf(dzVar.getLatitude()), Double.valueOf(dzVar.getLongitude()), Float.valueOf(dzVar.getAccuracy())});
        }
    }

    public enum b {
        Normal,
        Daemon,
        Single,
        Stop;

        static {
            Normal = new b("Normal", 0);
            Daemon = new b("Daemon", 1);
            Single = new b("Single", 2);
            Stop = new b("Stop", 3);
            b[] bVarArr = new b[]{Normal, Daemon, Single, Stop};
        }
    }

    class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            Bundle data = message.getData();
            if (data != null) {
                TencentLocationListener c;
                switch (message.what) {
                    case 3101:
                    case 3103:
                        TencentLocation tencentLocation;
                        int i = data.getInt("error_code");
                        dz dzVar = dz.a;
                        if (i == 0) {
                            tencentLocation = (dz) data.getParcelable("tx_location");
                        } else {
                            Object tencentLocation2 = dzVar;
                        }
                        if (message.what == 3101) {
                            synchronized (de.this.M) {
                                c = de.this.I;
                            }
                            if (c != null) {
                                c.onLocationChanged(tencentLocation2, i, (String) de.n.get(i));
                                return;
                            }
                            return;
                        } else if (message.what == 3103 && de.this.f != null) {
                            for (TencentLocationListener onLocationChanged : de.this.f) {
                                onLocationChanged.onLocationChanged(tencentLocation2, i, (String) de.n.get(i));
                            }
                            de.this.f.clear();
                            return;
                        } else {
                            return;
                        }
                    case 3102:
                        String string = data.getString("name");
                        int i2 = data.getInt(DownloadInfo.STATUS);
                        String string2 = data.getString("desc");
                        synchronized (de.this.M) {
                            c = de.this.I;
                        }
                        if (c != null) {
                            c.onStatusUpdate(string, i2, string2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static /* synthetic */ dp n(de deVar) {
        do doVar;
        List list = null;
        dr drVar = deVar.E;
        dn dnVar = deVar.D;
        do doVar2 = deVar.G;
        if (doVar2 == null || deVar.g()) {
            doVar = doVar2;
        } else {
            doVar = null;
        }
        if (dnVar == null) {
            cr crVar = deVar.H;
            dnVar = dn.a(crVar, ea.b(crVar), null);
            if (!ea.a(dnVar)) {
                dnVar = null;
            }
        }
        if (drVar != null) {
            Object obj;
            if (System.currentTimeMillis() - drVar.c < 60000) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                drVar = null;
            }
        }
        if (!(dnVar == null || doVar == null || VERSION.SDK_INT < 12)) {
            int i = dnVar.d;
            int i2 = dnVar.e;
            Parcelable parcelable = doVar.a;
            Bundle bundle = new Bundle();
            bundle.putString("cellkey", i + i2);
            bundle.putParcelable("location", parcelable);
            if (!deVar.H.a("cell").b(bundle)) {
                new StringBuilder("getFromLastKnownInfo: discard bad cell(").append(i).append(",").append(i2).append(")");
                dnVar = null;
            }
        }
        if (deVar.x != null) {
            list = deVar.x.a();
        }
        return new dp(drVar, dnVar, doVar, list);
    }

    static {
        SparseArray sparseArray = new SparseArray();
        n = sparseArray;
        sparseArray.put(0, "OK");
        n.put(1, "ERROR_NETWORK");
        n.put(2, "ERROR_NOCELL&WIFI_LOCATIONSWITCHOFF");
        n.put(4, "DEFLECT_FAILED");
        n.put(TencentLocation.ERROR_UNKNOWN, "ERROR_SERVER_NOT_LOCATION");
        HashMap hashMap = new HashMap();
        hashMap.put("https", "true");
        hashMap.put("up_apps", "true");
        hashMap.put("up_wifis", "true");
        hashMap.put("start_daemon", "true");
        hashMap.put("up_daemon_delay", "300000");
        hashMap.put("gps_kalman", "false");
        hashMap.put("callback_wifis", "true");
        hashMap.put("min_wifi_scan_interval", "8000");
        hashMap.put("collect_bles", "false");
        hashMap.put("start_event_track", "true");
        hashMap.put("f_coll_item", "0");
        ck.a(hashMap);
    }

    public de(cr crVar) {
        da daVar = null;
        this.H = crVar;
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
            } catch (Throwable th) {
                this.d = 3;
                return;
            }
        }
        try {
            if (!TextUtils.isEmpty(TencentLocationManagerOptions.getKey())) {
                this.e.g = TencentLocationManagerOptions.getKey();
            }
        } catch (Throwable th2) {
            th2.toString();
        }
        this.e = this.H.b;
        String b = j.b(this.e.g);
        this.R = a(b);
        if (TextUtils.isEmpty(this.R)) {
            new StringBuilder("requestLocationUpdates: illegal key [").append(b).append("]");
            this.d = 2;
            return;
        }
        this.H.a((Object) this);
        this.C = cu.b();
        this.B = new dj();
        this.f = new CopyOnWriteArrayList();
        this.y = new df(this.H);
        this.z = new di(this.H);
        this.w = dc.a(crVar.a);
        if (VERSION.SDK_INT >= 21) {
            this.x = new cy(this.H.a);
        }
        this.u = VERSION.SDK_INT >= 18;
        Object[] objArr;
        dd h;
        if (this.u) {
            dg dgVar;
            this.s = null;
            this.c = i();
            if (this.H.b()) {
                dgVar = new dg(this.H);
            } else {
                dgVar = null;
            }
            this.t = dgVar;
            objArr = new Object[1];
            h = h();
            this.v = h;
            objArr[0] = h;
        } else {
            this.t = null;
            this.c = i();
            if (this.H.b()) {
                daVar = new da(this.H);
            }
            this.s = daVar;
            objArr = new Object[1];
            h = h();
            this.v = h;
            objArr[0] = h;
        }
        try {
            ck.a(this.H.a, "txsdk", this.H.b.d());
            ck.a(this.R);
            ck.a().a = (cj) this.H.h;
        } catch (Throwable th3) {
        }
        int b2 = cl.a().b("f_coll_item");
        if (b2 == 1 || b2 == 2) {
            this.T = new cp(this.H);
        }
    }

    public final int a(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (this.d != 0) {
            return this.d;
        }
        e();
        if (this.e != null) {
            this.e.m = System.currentTimeMillis();
        }
        this.l = TencentLocation.ERROR_UNKNOWN;
        this.k = null;
        synchronized (this.M) {
            this.I = tencentLocationListener;
        }
        if (this.e != null && "0123456789ABCDEF".equals(this.e.a())) {
            this.H.a();
        }
        this.e.f = tencentLocationRequest.getQQ();
        TencentLocationRequest.copy(this.j, tencentLocationRequest);
        if (TextUtils.isEmpty(j.b(this.e.d))) {
            this.e.d = tencentLocationRequest.getPhoneNumber();
        }
        this.e.l = Math.max(cl.a().c("min_wifi_scan_interval"), tencentLocationRequest.getInterval());
        this.h = tencentLocationRequest.getInterval();
        this.m = b.Normal;
        if (this.A != null) {
            this.A.quit();
            this.A = null;
        }
        a(looper);
        return 0;
    }

    public final void a(dz dzVar) {
        if (dzVar != null) {
            if (this.w != null && this.j.isAllowDirection()) {
                dzVar.getExtra().putDouble(TencentLocation.EXTRA_DIRECTION, this.w.a());
            }
            try {
                dzVar.getExtra().putAll(this.j.getExtras());
            } catch (Exception e) {
            }
        }
    }

    public final void a() {
        Object obj;
        d();
        try {
            if (this.o != null) {
                if (this.p != null) {
                    this.p.a();
                    this.p = null;
                }
                this.o.quit();
                this.o = null;
            }
        } catch (Throwable th) {
        }
        synchronized (this.M) {
            this.I = null;
            if (this.f != null) {
                this.f.clear();
            }
        }
        if (this.C != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.C.a();
        }
        e();
        if (!cl.a().d("start_daemon")) {
            this.m = b.Stop;
        } else if (this.m == b.Normal && eh.c(this.H).equalsIgnoreCase("{}")) {
            this.A = new HandlerThread("daemon_thread");
            this.A.start();
            new Handler(this.A.getLooper()).postDelayed(new Runnable() {
                public final void run() {
                    try {
                        Looper looper = de.this.A == null ? null : de.this.A.getLooper();
                        if (looper != null && looper.getThread().isAlive()) {
                            de.this.m = b.Daemon;
                            de.this.a(looper);
                        }
                    } catch (Throwable th) {
                    }
                }
            }, 5000);
            this.Q = System.currentTimeMillis();
        } else {
            new StringBuilder("daemon not start! is wifi or running status=").append(this.m);
            this.m = b.Stop;
        }
    }

    private void d() {
        boolean z;
        BroadcastReceiver broadcastReceiver;
        ea.a = false;
        if (this.y != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            broadcastReceiver = this.y;
            if (broadcastReceiver.b) {
                broadcastReceiver.b = false;
                try {
                    broadcastReceiver.a.a.unregisterReceiver(broadcastReceiver);
                } catch (Exception e) {
                }
            }
        }
        if (this.z != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            di diVar = this.z;
            if (diVar.g) {
                diVar.g = false;
                diVar.a.clear();
                diVar.a.offer(a.d);
                if (diVar.f != 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - diVar.f;
                    String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", new Object[]{Long.valueOf(elapsedRealtime / 1000), Long.valueOf(diVar.d), Long.valueOf(diVar.e), Long.valueOf(diVar.c)});
                }
                diVar.c = 0;
                diVar.d = 0;
                diVar.e = 0;
                diVar.f = 0;
            }
        }
        if (this.B != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.B.a();
        }
        if (this.c != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            broadcastReceiver = this.c;
            synchronized (broadcastReceiver.k) {
                if (broadcastReceiver.a) {
                    broadcastReceiver.a = false;
                    try {
                        broadcastReceiver.b.a.unregisterReceiver(broadcastReceiver);
                    } catch (Exception e2) {
                    }
                    broadcastReceiver.c = null;
                    if (broadcastReceiver.g != null) {
                        broadcastReceiver.g.clear();
                    }
                    if (broadcastReceiver.c != null) {
                        broadcastReceiver.c.clear();
                    }
                    if (broadcastReceiver.f != null) {
                        broadcastReceiver.f.removeCallbacksAndMessages(null);
                        broadcastReceiver.f = null;
                    }
                }
            }
        }
        if (this.u) {
            if (this.t != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                dg dgVar = this.t;
                if (dgVar.a) {
                    dgVar.a = false;
                    dgVar.a(0);
                    synchronized (dgVar.b) {
                        if (dgVar.e != null) {
                            dgVar.e.a = true;
                            dgVar.e.removeCallbacksAndMessages(null);
                            dgVar.e = null;
                        }
                        if (dgVar.d != null) {
                            dgVar.d.quit();
                            dgVar.d = null;
                        }
                        dgVar.c = null;
                        if (dgVar.h != null) {
                            dgVar.h = null;
                        }
                    }
                }
            }
        } else {
            if (this.s != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                da daVar = this.s;
                if (daVar.a) {
                    daVar.a = false;
                    daVar.a(0);
                    synchronized (daVar.c) {
                        if (daVar.i != null) {
                            daVar.i.a = true;
                            daVar.i.removeCallbacksAndMessages(null);
                            daVar.i = null;
                        }
                        if (daVar.h != null) {
                            daVar.h.quit();
                            daVar.h = null;
                        }
                        daVar.d = null;
                        daVar.e = null;
                        daVar.f = null;
                        daVar.g = 0;
                    }
                }
            }
        }
        if (this.v != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Object obj = this.v;
            if (obj.k) {
                obj.k = false;
                obj.b = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                obj.e = false;
                obj.f = false;
                obj.i = 0;
                obj.h = 0;
                obj.g = 0;
                obj.j.clear();
                obj.n = -1;
                obj.l = false;
                Arrays.fill(obj.s, 0.0d);
                obj.a.b(obj);
                LocationManager locationManager = obj.a.g;
                try {
                    locationManager.removeGpsStatusListener(obj);
                } catch (Exception e3) {
                }
                try {
                    locationManager.removeUpdates(obj);
                } catch (Exception e4) {
                }
                obj.o = null;
                obj.c = null;
            }
        }
        if (this.w != null) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.j.isAllowDirection()) {
            SensorEventListener sensorEventListener = this.w;
            if (sensorEventListener.b && sensorEventListener.c) {
                sensorEventListener.c = false;
                sensorEventListener.d = Double.NaN;
                sensorEventListener.a.unregisterListener(sensorEventListener);
            }
        }
        if (this.x != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            cy cyVar = this.x;
            synchronized (cyVar.g) {
                if (cyVar.d && cyVar.e != null && cyVar.e.getLooper().getThread().isAlive()) {
                    cyVar.e.sendEmptyMessage(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
                    cyVar.e.postDelayed(new c.t.m.g.cy.AnonymousClass1(cyVar.e, cyVar.f), 50);
                    cyVar.e = null;
                    cyVar.f = null;
                }
            }
        }
        if (this.S) {
            ck.a().c();
            this.S = false;
        }
        if (this.T != null) {
            cp cpVar = this.T;
            if (cpVar.b) {
                cpVar.b = false;
                cpVar.a();
                if (cpVar.c != null) {
                    cq cqVar = cpVar.c;
                    if (cqVar.a()) {
                        cqVar.a(1005);
                        cqVar.a(1007);
                        cqVar.a(1006);
                        cqVar.a(true);
                        HandlerThread handlerThread = cqVar.d;
                        cqVar.e.postDelayed(new c.t.m.g.cq.AnonymousClass1(cqVar.e, handlerThread), 200);
                        cqVar.e = null;
                        cqVar.d = null;
                        cqVar.c = false;
                    }
                    cpVar.c = null;
                }
            }
        }
    }

    private void e() {
        this.i = 0;
        this.E = null;
        this.D = null;
        this.G = null;
        this.L = 0;
        dp.a = 0;
        if (VERSION.SDK_INT >= 12) {
            this.H.a("cell").a();
        }
        if (this.e != null) {
            this.e.p = "";
            this.e.o = 0;
            this.e.n = 0;
            this.e.m = 0;
        }
    }

    private void a(int i, dz dzVar) {
        Object obj = 1;
        if (dzVar != null) {
            Object obj2;
            if (!(i != 0 || dzVar.getLatitude() == 0.0d || dzVar.getLongitude() == 0.0d)) {
                int i2;
                if (this.b == 1 && eb.a(dzVar.getLatitude(), dzVar.getLongitude())) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                dz.a(dzVar, i2);
            }
            boolean z;
            if (f()) {
                if (dzVar.getAccuracy() < 5000.0f && dzVar.getAccuracy() > 0.0f) {
                    this.B.a((TencentLocation) dzVar);
                    z = this.J;
                }
                this.N = dzVar.getLatitude();
                this.O = dzVar.getLongitude();
                if (this.I != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null && this.j.getInterval() > 0) {
                    a(11999, this.j.getInterval());
                }
            } else if (i == 0 && dzVar.getLatitude() != 0.0d && dzVar.getLongitude() != 0.0d && Math.abs(dzVar.getLatitude() - this.N) >= 1.0E-8d && Math.abs(dzVar.getLongitude() - this.O) >= 1.0E-8d) {
                if (this.B.a((TencentLocation) dzVar, this.H, this.v.c())) {
                    this.N = dzVar.getLatitude();
                    this.O = dzVar.getLongitude();
                    if (dzVar.getAccuracy() < 5000.0f && dzVar.getAccuracy() > 0.0f) {
                        this.B.a(dzVar);
                        this.B.a((TencentLocation) dzVar);
                        z = this.J;
                    }
                } else {
                    new StringBuilder("discard ").append(dzVar);
                    return;
                }
            }
            if (this.l == 0 || i != 0) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            this.l = i;
            this.k = dzVar;
            if (this.j.getInterval() == 0) {
                Object obj3;
                if (this.I != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (!(obj3 == null || "gps" == this.k.getProvider())) {
                    a(11998);
                    return;
                }
            }
            if (obj2 != null) {
                if (this.I == null) {
                    obj = null;
                }
                if (obj != null) {
                    a(11998);
                }
            }
        }
    }

    private boolean f() {
        return this.l == TencentLocation.ERROR_UNKNOWN;
    }

    private boolean g() {
        if (this.v != null && this.v.c() && this.v.b()) {
            return true;
        }
        return false;
    }

    public final void a(int i) {
        if (this.p != null) {
            this.p.sendEmptyMessage(i);
        }
    }

    private void a(int i, long j) {
        if (this.p != null) {
            this.p.removeMessages(i);
            this.p.sendEmptyMessageDelayed(i, j);
        }
    }

    public final void onCellInfoEvent(dn dnVar) {
        int i;
        Object obj = null;
        this.D = dnVar;
        long max = Math.max(this.j.getInterval(), 20000);
        List emptyList = Collections.emptyList();
        if (this.c != null) {
            int i2;
            if (this.c.a()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            i = i2;
        } else {
            i = 1;
        }
        if (i != 0) {
            this.E = null;
        }
        List list;
        if (i == 1 || this.H == null) {
            list = emptyList;
        } else {
            list = eh.c(this.H.f);
            list.size();
        }
        if (i == 1 || list.size() == 0 || this.L == -1 || (this.L > 0 && System.currentTimeMillis() - this.L > max)) {
            a(3999);
        }
        new StringBuilder("cell change run prepare json,because status:").append(i).append(",mLastWF:").append(this.L).append(",current:").append(System.currentTimeMillis());
        if (this.T != null) {
            cp cpVar = this.T;
            if (cpVar.b && dnVar != null) {
                if (cpVar.d == null || !(cpVar.d == null || cpVar.d.b().equals(dnVar.b()))) {
                    obj = 1;
                }
                cpVar.d = dnVar;
                cpVar.e = ea.a(cpVar.a);
                if (obj != null) {
                    cpVar.c();
                }
            }
        }
    }

    public final void onWifiInfoEvent(dr drVar) {
        Object obj = null;
        if (this.F != null) {
            dr drVar2 = this.F;
            if (drVar != null) {
                List list = drVar.b;
                List list2 = drVar2.b;
                if (!(list.size() == 0 || list2.size() == 0)) {
                    boolean z;
                    int size = list.size();
                    int size2 = list2.size();
                    if (size == 0 && size2 == 0) {
                        z = true;
                    } else if (size == 0 || size2 == 0) {
                        z = false;
                    } else {
                        List list3;
                        if (list.size() > list2.size()) {
                            list3 = list;
                        } else {
                            list3 = list2;
                            list2 = list;
                        }
                        int i = 0;
                        for (ScanResult scanResult : list2) {
                            for (ScanResult scanResult2 : list3) {
                                if (scanResult2.BSSID.equals(scanResult.BSSID)) {
                                    i++;
                                    break;
                                }
                            }
                        }
                        int i2 = size + size2;
                        if (((double) (i << 1)) < ((double) i2) * 0.85d || i < 13) {
                            z = true;
                        } else {
                            z = false;
                        }
                        new StringBuilder("isDiffrent:c=").append(size).append(",k=").append(i).append(",f=").append(i2).append(",r=0.85,s=").append(z);
                    }
                    if (!z) {
                        int obj2 = 1;
                    }
                }
            }
        }
        if (obj2 != null) {
            this.L = System.currentTimeMillis();
        }
        if (this.E == null || this.i == 2 || drVar == dr.a || this.L == -1 || Collections.unmodifiableList(drVar.b).size() < 3 || obj2 == null) {
            a(3999);
        }
        this.E = drVar;
        if (this.T != null) {
            cp cpVar = this.T;
            if (cpVar.b && drVar != null) {
                cpVar.f = drVar;
                if (cpVar.b() && cpVar.f != null && cpVar.c != null) {
                    cpVar.c.a(cpVar.g, cpVar.f, cpVar.e);
                }
            }
        }
    }

    public final void onGpsInfoEvent(do doVar) {
        double d = 0.0d;
        if (doVar.a != db.a) {
            double d2;
            dz dzVar;
            this.G = doVar;
            int i = this.b;
            int requestLevel = this.j.getRequestLevel();
            dz dzVar2 = this.P;
            Location location = new Location(doVar.a);
            Bundle extras = location.getExtras();
            if (extras != null) {
                d2 = extras.getDouble("lat");
                d = extras.getDouble("lng");
            } else {
                d2 = 0.0d;
            }
            c.t.m.g.dz.a aVar;
            dz a;
            if (eg.a(i)) {
                aVar = new c.t.m.g.dz.a();
                aVar.b = dzVar2;
                aVar.d = "gps";
                aVar.c = requestLevel;
                a = aVar.a(new Location(doVar.a)).a();
                location.setLatitude(d2);
                location.setLongitude(d);
                a.a(location);
                a(0, a);
                dzVar = a;
            } else {
                if (f()) {
                    a(3999);
                }
                aVar = new c.t.m.g.dz.a();
                aVar.b = dzVar2;
                aVar.d = "gps";
                aVar.c = requestLevel;
                a = aVar.a(new Location(doVar.a)).a();
                location.setLatitude(d2);
                location.setLongitude(d);
                a.a(location);
                a(0, a);
                dzVar = a;
            }
            if (!(this.i == 2 || dzVar == null)) {
                a(dzVar, 0, 3101);
            }
            a((int) TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_FAILED, 3);
            if (this.v != null) {
                this.v.b();
            }
        }
        if (this.T != null) {
            cp cpVar = this.T;
            if (cpVar.b && doVar != null) {
                cpVar.g = doVar;
                if (cpVar.h == null || (cpVar.g != null && cpVar.g.a.distanceTo(cpVar.h) >= 50.0f)) {
                    cpVar.c();
                }
            }
        }
    }

    public final void onStatusEvent(Message message) {
        int i = message.what;
        a(message.arg1, message.arg2);
    }

    public final void onNetworkEvent(Integer num) {
        String str;
        cp cpVar;
        int intValue;
        int a = j.a(this.H.a);
        if (a != -1) {
            if (a == 0) {
                str = "mobile";
            } else if (a == 1) {
                str = "wifi";
            }
            switch (num.intValue()) {
                case 0:
                    new StringBuilder("onNetworkEvent: ").append(str).append(" disconnected");
                    return;
                case 1:
                    new StringBuilder("onNetworkEvent: ").append(str).append(" connected");
                    a(7999, 1000);
                    if (this.T != null) {
                        cpVar = this.T;
                        intValue = num.intValue();
                        if (cpVar.b && intValue == 1 && cpVar.c != null) {
                            cpVar.c.a(false);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        str = "none";
        switch (num.intValue()) {
            case 0:
                new StringBuilder("onNetworkEvent: ").append(str).append(" disconnected");
                return;
            case 1:
                new StringBuilder("onNetworkEvent: ").append(str).append(" connected");
                a(7999, 1000);
                if (this.T != null) {
                    cpVar = this.T;
                    intValue = num.intValue();
                    if (cpVar.b) {
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(int i, int i2) {
        String str;
        String str2 = null;
        switch (i) {
            case TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS /*12001*/:
                str = "wifi";
                switch (i2) {
                    case 0:
                        str2 = "wifi disabled";
                        break;
                    case 1:
                        str2 = "wifi enabled";
                        break;
                    case 5:
                        str2 = "location service switch is off";
                        break;
                    default:
                        str2 = "unknown";
                        break;
                }
                if (i2 != 5 && eh.a) {
                    str2 = "location permission denied";
                    i2 = 2;
                    break;
                }
            case 12002:
                str = "gps";
                switch (i2) {
                    case 0:
                        str2 = "gps disabled";
                        break;
                    case 1:
                        str2 = "gps enabled";
                        break;
                    default:
                        str2 = "unknown";
                        break;
                }
            case 12003:
                str = "cell";
                str2 = i2 == 1 ? "cell enabled" : i2 == 0 ? "cell disabled" : "unknown";
                if (ea.a) {
                    str2 = "location permission denied";
                    i2 = 2;
                    break;
                }
                break;
            case TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_FAILED /*12004*/:
                str = "gps";
                switch (i2) {
                    case 3:
                        str2 = "gps available";
                        break;
                    case 4:
                        str2 = "gps unavailable";
                        break;
                    default:
                        str2 = "unknown";
                        break;
                }
            default:
                str = null;
                break;
        }
        if (this.q != null) {
            Message obtainMessage = this.q.obtainMessage(3102);
            Bundle data = obtainMessage.getData();
            if (data == null) {
                data = new Bundle();
            }
            data.clear();
            data.putString("name", str);
            data.putInt(DownloadInfo.STATUS, i2);
            data.putString("desc", str2);
            obtainMessage.setData(data);
            obtainMessage.sendToTarget();
        }
    }

    public final void a(dz dzVar, int i, int i2) {
        if (dzVar != null && this.q != null) {
            Message obtainMessage = this.q.obtainMessage(i2);
            Bundle data = obtainMessage.getData();
            if (data == null) {
                data = new Bundle();
            }
            data.clear();
            data.putInt("error_code", i);
            data.putParcelable("tx_location", dzVar);
            obtainMessage.setData(data);
            obtainMessage.sendToTarget();
        }
    }

    @Nullable
    private dd h() {
        Object obj;
        if (this.H.g != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return new dd(this.H);
    }

    @Nullable
    private dk i() {
        Object obj;
        if (this.H.f != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return new dk(this.H);
    }

    private static String a(String str) {
        Object obj = 1;
        if (str.contains(",")) {
            try {
                String[] split = str.split(",");
                if (split == null || split.length <= 1 || split[0] == null || split[1] == null || e.w(split[0], split[1]) <= 0) {
                    obj = null;
                }
                return obj != null ? split[0] : "";
            } catch (UnsatisfiedLinkError e) {
                return null;
            }
        }
        int v = e.v(str);
        return v >= 0 ? Integer.toString(v) : "";
    }

    private void a(Looper looper) {
        Object obj;
        Object obj2;
        Handler handler;
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (this.q == null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (!(obj == null && this.q.getLooper() == looper)) {
            this.q = new c(looper);
        }
        this.q.removeCallbacksAndMessages(null);
        if (this.r == null || this.r.getLooper() != Looper.getMainLooper()) {
            this.r = new Handler(Looper.getMainLooper());
        }
        d();
        if (this.o == null) {
            this.o = new HandlerThread("loc_inner_thread");
            this.o.start();
            this.p = new a(this.o.getLooper());
        }
        if (this.p != null) {
            this.p.a();
        }
        boolean z = this.j.getExtras().getBoolean("use_network", true);
        boolean z2 = b.Daemon == this.m;
        Handler handler2 = this.p;
        di diVar = this.z;
        if (!diVar.g) {
            diVar.g = true;
            diVar.h = z2;
            diVar.b.c.execute(new c.t.m.g.di.AnonymousClass1(handler2));
            diVar.f = SystemClock.elapsedRealtime();
        }
        if (this.u) {
            if (z) {
                if (this.t != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    dg dgVar = this.t;
                    if (!dgVar.a) {
                        dgVar.g = handler2;
                        if (dgVar.h == null) {
                            dgVar.h = new ArrayList();
                        }
                        dgVar.d = new HandlerThread("new_cell_provider");
                        if (dgVar.d != null) {
                            try {
                                dgVar.d.start();
                                dgVar.e = new a(dgVar, dgVar.d.getLooper(), (byte) 0);
                            } catch (Throwable th) {
                                dgVar.e = new a(dgVar, dgVar.g.getLooper(), (byte) 0);
                            }
                            dgVar.e.post(dgVar.f);
                            if (!z2) {
                                dgVar.e.sendEmptyMessage(0);
                            }
                        }
                    }
                }
            }
        } else if (z) {
            if (this.s != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                da daVar = this.s;
                if (!daVar.a) {
                    daVar.a = true;
                    daVar.h = new HandlerThread("CellProvider");
                    daVar.h.start();
                    daVar.i = new a(daVar, daVar.h.getLooper(), (byte) 0);
                    daVar.i.sendEmptyMessageDelayed(0, 3000);
                    CellLocation b = ea.b(daVar.b);
                    if (daVar.a(b)) {
                        Object a = dn.a(daVar.b, b, null);
                        if (a != null) {
                            daVar.d = b;
                            daVar.b.c(a);
                        }
                    }
                    daVar.a((int) i.CTRL_INDEX);
                }
            }
        }
        if (z) {
            if (this.c != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                this.c.j = this.e.l;
                dk dkVar = this.c;
                handler = this.q;
                synchronized (dkVar.k) {
                    if (dkVar.a) {
                    } else {
                        dkVar.a = true;
                        dk.d = z2;
                        dkVar.e = handler2;
                        if (dkVar.f == null || dkVar.f.getLooper() != handler2.getLooper()) {
                            if (dkVar.f != null) {
                                dkVar.f.removeCallbacksAndMessages(null);
                            }
                            dkVar.f = new a(handler2.getLooper());
                        }
                        handler.post(dkVar.h);
                        if (!dk.d) {
                            dkVar.a(0);
                        }
                    }
                }
            }
        }
        if (this.v != null) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null && this.j.isAllowGPS()) {
            boolean z3;
            dd ddVar = this.v;
            if (this.b == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            ddVar.l = z3;
            dd ddVar2 = this.v;
            handler = this.q;
            long interval = this.j.getInterval();
            if (!ddVar2.k) {
                ddVar2.k = true;
                ddVar2.m = Math.max(interval, 1000);
                ddVar2.d = 0;
                if (ddVar2.o == null || ddVar2.o.getLooper() != handler2.getLooper()) {
                    ddVar2.o = new a(handler2.getLooper());
                }
                if (z2) {
                    handler2.post(ddVar2.r);
                } else {
                    handler2.post(ddVar2.p);
                    int i = VERSION.SDK_INT;
                    handler.post(ddVar2.q);
                }
                if (ddVar2.c()) {
                    ddVar2.b = 4;
                    ddVar2.d();
                }
            }
        }
        if (z2) {
            diVar = this.z;
            String d = this.H.d();
            try {
                if (!TextUtils.isEmpty(d)) {
                    byte[] a2 = eg.a(d.getBytes("UTF-8"));
                    e.o(a2, 2);
                    a aVar = new a(2, a2, "http://ue.indoorloc.map.qq.com/", null);
                    aVar.b = d;
                    diVar.a(aVar);
                }
            } catch (Throwable th2) {
            }
        } else {
            if (!cl.a().d("collect_bles")) {
                this.x = null;
            }
            if (this.x != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                cy cyVar = this.x;
                synchronized (cyVar.g) {
                    try {
                        cyVar.b = cyVar.a == null ? null : cyVar.a.getAdapter();
                        if (cyVar.b != null) {
                            cyVar.c = cyVar.b.getBluetoothLeScanner();
                        }
                    } catch (Throwable th3) {
                        th3.toString();
                    }
                    cyVar.f = new HandlerThread("ble_thread");
                    cyVar.f.start();
                    cyVar.e = new a(cyVar.f.getLooper());
                    cyVar.e.sendEmptyMessage(1000);
                }
            }
            BroadcastReceiver broadcastReceiver = this.y;
            if (!broadcastReceiver.b) {
                broadcastReceiver.b = true;
                try {
                    broadcastReceiver.a.a.registerReceiver(broadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, handler2);
                } catch (Exception e) {
                }
            }
            if (this.w != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null && this.j.isAllowDirection()) {
                obj2 = this.w;
                if (obj2.b && !obj2.c) {
                    try {
                        Sensor defaultSensor = obj2.a.getDefaultSensor(11);
                        if (defaultSensor != null) {
                            obj2.a.registerListener(obj2, defaultSensor, 3, handler2);
                            obj2.c = true;
                        }
                    } catch (Exception e2) {
                    } catch (Error e3) {
                    }
                }
            }
        }
        if (this.T != null) {
            int b2 = cl.a().b("f_coll_item");
            new StringBuilder("fc:dc.1.0.1_171109,set:").append(b2).append(",daemon:").append(z2);
            if (b2 == 2 || (b2 == 1 && !z2)) {
                cp cpVar = this.T;
                if (!cpVar.b) {
                    cpVar.a();
                    cq cqVar;
                    try {
                        String absolutePath = cpVar.a.a.getExternalFilesDir(SlookAirButtonFrequentContactAdapter.DATA).getAbsolutePath();
                        if (!TextUtils.isEmpty(absolutePath)) {
                            cpVar.c = new cq(cpVar.a, absolutePath);
                            cqVar = cpVar.c;
                            z2 = cqVar.b != null && (cqVar.b.exists() || cqVar.b.mkdirs());
                            cqVar.c = z2;
                            if (cqVar.c) {
                                cqVar.d = new HandlerThread("data_c", 10);
                                cqVar.d.start();
                                cqVar.e = new c.t.m.g.cq.a(cqVar.d.getLooper());
                                cqVar.i = System.currentTimeMillis() - 30000;
                            }
                            cpVar.b = true;
                        }
                    } catch (Throwable th4) {
                        th4.toString();
                    }
                }
            }
        }
    }
}
