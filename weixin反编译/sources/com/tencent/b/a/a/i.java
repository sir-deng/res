package com.tencent.b.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import org.json.JSONObject;

public class i {
    private static i bpt = null;
    static f bpu = null;
    public static volatile long bpv = 0;
    static h bpw = null;
    public static Context mContext = null;
    public static Handler mHandler = null;
    private g bpx = null;

    /* renamed from: com.tencent.b.a.a.i$1 */
    class AnonymousClass1 implements Runnable {
        private final /* synthetic */ String bpz;

        public AnonymousClass1(String str) {
            this.bpz = str;
        }

        public final void run() {
            try {
                new StringBuilder("receive data:").append(this.bpz);
                int i = 100;
                int i2 = 3;
                if (s.bJ(this.bpz)) {
                    JSONObject jSONObject = new JSONObject(this.bpz);
                    if (!jSONObject.isNull("mid")) {
                        String optString = jSONObject.optString("mid");
                        if (s.bK(optString) && !s.bK(i.this.sL())) {
                            i.this.bpx.bpr = optString;
                            i.this.bpx.bpq = s.ac(i.mContext);
                            i.this.bpx.bjM = s.ab(i.mContext);
                            if (jSONObject.isNull("ts")) {
                                i.this.bpx.bps = System.currentTimeMillis();
                            } else {
                                long optLong = jSONObject.optLong("ts");
                                if (optLong > 0) {
                                    i.this.bpx.bps = optLong;
                                }
                            }
                            new StringBuilder("new mid midEntity:").append(i.this.bpx.toString());
                            r.Z(i.mContext).b(i.this.bpx);
                        }
                    }
                    if (!jSONObject.isNull(a.boZ)) {
                        i = jSONObject.getInt(a.boZ);
                    }
                    if (!jSONObject.isNull(a.bpa)) {
                        i2 = jSONObject.getInt(a.bpa);
                    }
                    j.bpA = jSONObject.optInt("disable", 0);
                    j.bpB = jSONObject.optInt("limit", 0);
                }
                r Z = r.Z(i.mContext);
                a sR = Z.sR();
                if (i > 0) {
                    sR.boV = i;
                }
                if (i2 > 0) {
                    sR.boW = i2;
                }
                sR.boT = System.currentTimeMillis();
                sR.boU = 0;
                Z.b(sR);
            } catch (Throwable th) {
            }
        }
    }

    private i(Context context) {
        HandlerThread handlerThread = new HandlerThread(i.class.getSimpleName());
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());
        Context applicationContext = context.getApplicationContext();
        mContext = applicationContext;
        bpv = PreferenceManager.getDefaultSharedPreferences(applicationContext).getLong("__MID_LAST_CHECK_TIME__", 0);
    }

    public static i X(Context context) {
        if (bpt == null) {
            synchronized (i.class) {
                if (bpt == null) {
                    bpt = new i(context);
                }
            }
        }
        return bpt;
    }

    public static void a(f fVar) {
        bpu = fVar;
    }

    public final String sL() {
        if (this.bpx == null || !s.bK(this.bpx.bpr)) {
            int i;
            this.bpx = r.Z(mContext).sQ();
            if (s.bK(this.bpx.bpr)) {
                i = 2;
            } else {
                i = 1;
            }
            if (mHandler != null) {
                mHandler.post(new n(mContext, i));
            }
            new StringBuilder("wx get mid:").append(this.bpx.bpr);
        }
        return this.bpx.bpr;
    }

    public final String sM() {
        if (this.bpx == null || !s.bK(this.bpx.bpr)) {
            this.bpx = r.Z(mContext).sQ();
        }
        return this.bpx.bpr;
    }
}
