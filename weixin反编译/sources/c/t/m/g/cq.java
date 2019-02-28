package c.t.m.g;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.Nullable;

public final class cq {
    final cr a;
    public final File b;
    public boolean c;
    public HandlerThread d;
    public Handler e;
    volatile List<dn> f;
    volatile dr g;
    volatile do h;
    public long i;

    /* renamed from: c.t.m.g.cq$1 */
    public class AnonymousClass1 implements Runnable {
        private /* synthetic */ Handler a;
        private /* synthetic */ HandlerThread b;

        public AnonymousClass1(Handler handler, HandlerThread handlerThread) {
            this.a = handler;
            this.b = handlerThread;
        }

        public final void run() {
            try {
                if (this.a != null) {
                    this.a.removeCallbacksAndMessages(null);
                }
                if (this.b != null) {
                    this.b.quit();
                }
            } catch (Throwable th) {
            }
        }
    }

    public class a extends Handler {
        private byte[] a = new byte[0];
        private File b;
        private BufferedOutputStream c;
        private StringBuffer d;

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1001:
                    case 1002:
                    case HardCoderJNI.FUNC_REG_ANR_CALLBACK /*1010*/:
                        synchronized (this.a) {
                            int i = message.what;
                            b();
                            String str = "";
                            if (i == 1002) {
                                str = co.a(cq.this.a, cq.this.h.a, null, cq.this.f);
                            } else if (i == 1001) {
                                List list;
                                if (cq.this.g == null) {
                                    list = null;
                                } else {
                                    list = Collections.unmodifiableList(cq.this.g.b);
                                }
                                str = co.a(cq.this.a, cq.this.h.a, list, cq.this.f);
                                dr drVar = cq.this.g;
                            }
                            if (!(this.c == null || TextUtils.isEmpty(str))) {
                                if (this.d == null) {
                                    this.d = new StringBuffer(20480);
                                }
                                if (this.d.length() + str.length() > 20480) {
                                    a();
                                    if (!(this.b == null || this.b.length() <= 102400 || cq.this.d == null)) {
                                        sendEmptyMessage(1007);
                                    }
                                }
                                this.d.append(str).append("\n");
                                new StringBuilder("write: ").append(str.substring(0, 60)).append("***");
                            }
                        }
                        return;
                    case 1003:
                        if (cq.this.a()) {
                            File[] listFiles = cq.this.b.listFiles();
                            if (listFiles != null && listFiles.length != 0) {
                                for (File file : listFiles) {
                                    if (file.isFile() && file.exists() && file.getName().startsWith("dc3_")) {
                                        new StringBuilder("upload:").append(file.getName()).append(",len=").append(file.length());
                                        cn cnVar = new cn(cq.this.a, file.getAbsolutePath());
                                        if (!cnVar.b) {
                                            cnVar.b = true;
                                            new Thread(new Runnable() {
                                                public final void run() {
                                                    try {
                                                        File file = new File(cn.this.a);
                                                        if (file.exists() && file.isFile()) {
                                                            byte[] a = j.a(file);
                                                            if (a != null && a.length > 0) {
                                                                Bundle a2 = cn.this.c.a("http://analytics.map.qq.com/?sf3", a);
                                                                if (a2 != null && !a2.isEmpty()) {
                                                                    file.delete();
                                                                    new StringBuilder("upload ").append(file.getName()).append(" succeed and deleted.");
                                                                }
                                                            }
                                                        }
                                                    } catch (Throwable th) {
                                                    }
                                                }
                                            }, "th_upload_dc").start();
                                        }
                                        cq.this.i = System.currentTimeMillis();
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 1004:
                        cq.this.a(false);
                        return;
                    case 1005:
                        try {
                            if (this.c != null) {
                                this.c.flush();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            this.b = null;
                            j.a(this.c);
                            return;
                        }
                    case 1006:
                        a();
                        if (this.d != null) {
                            this.d.setLength(0);
                        }
                        this.b = null;
                        j.a(this.c);
                        return;
                    case 1007:
                        b();
                        if (cq.this.b != null && this.b != null && this.b.exists()) {
                            if (this.b.length() > 102400 || System.currentTimeMillis() - c() > 259200000) {
                                try {
                                    if (this.b != null && this.b.length() >= 1024) {
                                        File file2 = new File(cq.this.b, "dc3_" + System.currentTimeMillis());
                                        this.b.renameTo(file2);
                                        new StringBuilder("rename:").append(this.b.getName()).append(" to ").append(file2.getName());
                                        j.a(this.c);
                                        this.b = null;
                                        this.c = null;
                                        d();
                                        a(0);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th3) {
                new StringBuilder("handle msg:").append(message.what).append(" error.");
            }
            new StringBuilder("handle msg:").append(message.what).append(" error.");
        }

        private void a() {
            if (this.d != null && this.d.length() != 0 && this.c != null) {
                byte[] a = eg.a(this.d.toString(), "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
                new StringBuilder("write buf to file: buf size:").append(this.d.length()).append(",enc size:").append(a.length);
                this.d.setLength(0);
                if (a != null && a.length != 0) {
                    try {
                        this.c.write(a);
                    } catch (Throwable th) {
                        this.b = null;
                        j.a(this.c);
                    }
                }
            }
        }

        private void b() {
            if (this.b == null || !this.b.exists() || this.c == null || !"dc3".equals(this.b.getName())) {
                File file = cq.this.b;
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.b = new File(file, "dc3");
                try {
                    boolean exists = this.b.exists();
                    this.c = new BufferedOutputStream(new FileOutputStream(this.b, true), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    if (!exists) {
                        a(System.currentTimeMillis());
                    }
                } catch (Throwable th) {
                }
            }
        }

        private void a(long j) {
            try {
                cq.this.a.a.getSharedPreferences("LocationSDK", 0).edit().putLong("dc_create", j).apply();
            } catch (Throwable th) {
            }
        }

        private long c() {
            long j = 0;
            try {
                return cq.this.a.a.getSharedPreferences("LocationSDK", 0).getLong("dc_create", 0);
            } catch (Throwable th) {
                return j;
            }
        }

        private void d() {
            File[] listFiles = cq.this.b.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                for (File file : listFiles) {
                    if (file.isFile() && file.exists() && !"dc3".equals(file.getName()) && (currentTimeMillis - file.lastModified() > 2592000000L || file.length() == 0)) {
                        new StringBuilder("delete expired file:").append(file.getName());
                        file.delete();
                    }
                }
            }
        }
    }

    public cq(cr crVar, @Nullable String str) {
        this(crVar, new File(str + "/d_c"));
    }

    private cq(cr crVar, @Nullable File file) {
        this.i = 0;
        this.a = crVar;
        this.b = file;
    }

    public final boolean a() {
        return this.c && this.e != null;
    }

    @SuppressLint({"NewApi"})
    public final void a(boolean z) {
        if (z || System.currentTimeMillis() - this.i >= 60000) {
            a(1007);
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.a.a.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || 1 != activeNetworkInfo.getType()) {
                    return;
                }
                if ((VERSION.SDK_INT < 16 || !connectivityManager.isActiveNetworkMetered()) && a()) {
                    a(1003);
                    this.i = System.currentTimeMillis();
                    if (!z && this.e != null && this.d != null) {
                        this.e.sendMessageDelayed(this.e.obtainMessage(1004), 1800000);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public final synchronized void a(do doVar, dr drVar, List<dn> list) {
        if (doVar != null) {
            if (System.currentTimeMillis() - doVar.b <= 10000) {
                this.h = doVar;
                this.g = drVar;
                this.f = list;
                if (a()) {
                    if (drVar != null) {
                        a(1001);
                    } else if (list != null && list.size() > 0) {
                        a(1002);
                    }
                }
            }
        }
    }

    public final void a(int i) {
        if (this.e != null && this.d != null) {
            this.e.obtainMessage(i).sendToTarget();
        }
    }
}
