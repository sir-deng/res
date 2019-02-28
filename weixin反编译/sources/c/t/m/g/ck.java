package c.t.m.g;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class ck {
    private static String b = ("ACTION." + ck.class.getSimpleName() + "." + System.nanoTime());
    private static ck c = null;
    private static Context d = null;
    public cj a = null;
    private volatile boolean e = false;
    private PendingIntent f = null;
    private a g = null;

    class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(ck ckVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (ck.b.equals(action)) {
                    ch.a("CC_Receiver", "action=" + action);
                    try {
                        new Thread(new b(), "Th_CC").start();
                    } catch (Throwable th) {
                        ch.a("CC_Receiver", "new pull runnable failed!", th);
                        ck.this.a(1800000);
                    }
                }
            }
        }
    }

    class b implements Runnable {
        private final JSONObject a;
        private cl b;
        private cm c;

        public b() {
            this.a = new JSONObject();
            this.b = null;
            this.c = null;
            this.b = cl.a();
            this.c = cm.a();
        }

        public final void run() {
            boolean b;
            try {
                if (Math.abs(System.currentTimeMillis() - this.b.c("last_pull_time")) >= ck.g()) {
                    b = ck.this.e;
                    if (b) {
                        this.c.c();
                    }
                    Thread.currentThread().setPriority(1);
                    JSONObject a = a();
                    if (a != this.a) {
                        int parseInt = Integer.parseInt(a.optString(DownloadInfo.STATUS, "-5"));
                        ch.a("CC_Run", "status:" + parseInt);
                        switch (parseInt) {
                            case 0:
                                if (a.has("version")) {
                                    a(a);
                                    break;
                                }
                                break;
                        }
                        String str = "last_pull_time";
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        SharedPreferences b2 = this.c.b();
                        if (b2 != null) {
                            Editor edit = b2.edit();
                            edit.putString(str, valueOf);
                            edit.apply();
                        }
                        Thread.sleep(2000);
                        ch.a("CC_Run", "---> finish update xml");
                    }
                    this.b.b();
                    if (b) {
                        this.c.d();
                    }
                } else {
                    ch.a("CC_Run", "skip pull");
                }
            } catch (Throwable th) {
                ch.a("CC_Run", th.getMessage(), th);
                return;
            }
            if (ck.this.e) {
                ck.this.a(false);
            } else {
                ck.d(ck.this);
            }
        }

        private void a(JSONObject jSONObject) {
            SharedPreferences b = this.c.b();
            if (b != null) {
                int parseInt;
                int b2 = this.b.b("cc_version");
                try {
                    parseInt = Integer.parseInt(jSONObject.optString("version", this.b.e("cc_version")));
                } catch (Throwable th) {
                    parseInt = b2;
                }
                if (parseInt == b2) {
                    ch.a("CC_Run", "local version == server version");
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
                JSONObject jSONObject2 = optJSONObject == null ? this.a : optJSONObject;
                Editor edit = b.edit();
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    try {
                        String e = this.b.e(str);
                        if (!(e == null || e.length() == 0)) {
                            edit.putString(str, jSONObject2.optString(str, e));
                        }
                    } catch (Exception e2) {
                        ch.b("CC_Run", e2.getMessage());
                    }
                }
                edit.putString("cc_version", String.valueOf(parseInt));
                try {
                    long parseLong = Long.parseLong(jSONObject2.optString("cc_req_interval", this.b.e("cc_req_interval")));
                    if (parseLong < 3600000) {
                        parseLong = 3600000;
                    } else if (parseLong > 86400000) {
                        parseLong = 86400000;
                    }
                    edit.putString("cc_req_interval", String.valueOf(parseLong));
                } catch (Throwable th2) {
                }
                edit.apply();
            }
        }

        private JSONObject a() {
            if (ck.this.a == null) {
                return this.a;
            }
            String str = "https://cc.map.qq.com/?get_c3";
            ch.a("CC_Run", "cc_url:" + str);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cc_version", this.b.e("cc_version"));
                jSONObject.put("m_module", cl.a);
                jSONObject.put("m_channel", cl.b);
                jSONObject.put("m_version", cl.c);
                jSONObject.put("imei", b());
                String a = ci.a(jSONObject.toString(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
                ch.a("CC_Run", "req:" + a);
                a = ck.this.a.a(str, a.getBytes());
                if (TextUtils.isEmpty(a)) {
                    ch.a("CC_Run", "net work error! res = " + a);
                    return this.a;
                }
                Object obj;
                ch.a("CC_Run", "res:" + a);
                str = this.a.toString();
                if (str.equals(a)) {
                    ch.a("CC_Run", "network or server error,response empty json");
                    obj = str;
                } else {
                    ch.a("CC_Run", "start dec");
                    str = ci.b(a, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
                    ch.a("CC_Run", "end dec");
                    a = str;
                }
                if (TextUtils.isEmpty(obj)) {
                    return this.a;
                }
                return new JSONObject(obj);
            } catch (Throwable th) {
                ch.a("CC_Run", th.getMessage(), th);
                return this.a;
            }
        }

        @SuppressLint({"MissingPermission"})
        private static String b() {
            String deviceId;
            String str = "";
            try {
                deviceId = ((TelephonyManager) ck.d.getSystemService("phone")).getDeviceId();
            } catch (Throwable th) {
                deviceId = str;
            }
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
    }

    private ck() {
        if (d == null || d.getApplicationContext() == null) {
            throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
        }
        try {
            b = d.getPackageName() + ".cc." + System.nanoTime();
        } catch (Throwable th) {
        }
        this.g = new a();
        this.f = PendingIntent.getBroadcast(d, 0, i(), 134217728);
    }

    public static void a(HashMap<String, String> hashMap) {
        cl.a((HashMap) hashMap);
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || context.getApplicationContext() == null) {
            throw new NullPointerException("context cannot be null!");
        }
        Context applicationContext = context.getApplicationContext();
        d = applicationContext;
        cm.a(applicationContext, str);
        cl.a(str, str2);
        new Thread() {
            public final void run() {
                try {
                    ck.a();
                    cm.a();
                    cl.a();
                } catch (Throwable th) {
                }
            }
        }.start();
    }

    public static void a(String str) {
        cl.a(str);
    }

    public static synchronized ck a() {
        ck ckVar;
        synchronized (ck.class) {
            if (c == null) {
                synchronized (ck.class) {
                    if (c == null) {
                        c = new ck();
                    }
                }
            }
            ckVar = c;
        }
        return ckVar;
    }

    public final synchronized void b() {
        if (!this.e) {
            this.e = true;
            ch.a("CC_", "startUp()");
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(b);
                d.registerReceiver(this.g, intentFilter);
                a(true);
            } catch (Throwable th) {
            }
        }
    }

    public final synchronized void c() {
        if (this.e) {
            this.e = false;
            try {
                cl.a().d.clear();
                ch.a("CC_", "shutdown:pull immediately");
                a(0);
            } catch (Throwable th) {
            }
        }
    }

    private void a(boolean z) {
        try {
            int b = cl.a().b("cc_version");
            ch.a("CC_", "schedule :" + z + "," + b);
            long g = b == -1 ? z ? 5000 : 10800000 : g();
            a(g);
        } catch (Exception e) {
            ch.b("CC_", e.toString());
        }
    }

    private static long g() {
        long j = 86400000;
        long c = cl.a().c("cc_req_interval");
        if (c <= 86400000) {
            j = c;
        }
        if (j < 3600000) {
            return 3600000;
        }
        return j;
    }

    private void a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        ch.a("CC_", "startSchedule: delay: " + j + "ms,at: " + (System.currentTimeMillis() + j) + "ms");
        if (j <= 0) {
            new Thread(new b(), "Th_CC").start();
        } else {
            h().set(2, elapsedRealtime, this.f);
        }
    }

    private static AlarmManager h() {
        return (AlarmManager) d.getSystemService("alarm");
    }

    private static Intent i() {
        Intent intent = new Intent(b);
        try {
            intent.setPackage(d.getPackageName());
        } catch (Throwable th) {
            intent.setPackage(null);
        }
        return intent;
    }

    static /* synthetic */ void d(ck ckVar) {
        try {
            d.unregisterReceiver(ckVar.g);
        } catch (Throwable th) {
        }
        try {
            h().cancel(ckVar.f);
            ckVar.f.cancel();
        } catch (Throwable th2) {
            ch.a("CC_", th2.getMessage(), th2);
        } finally {
            ch.a("CC_", "shutdown:cc");
        }
    }
}
