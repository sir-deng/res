package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class al {
    AtomicInteger a = new AtomicInteger(0);
    public AtomicInteger b = new AtomicInteger(0);
    public Handler c;
    ar d;
    AtomicInteger e = new AtomicInteger(0);
    List<String> f = new ArrayList();
    volatile boolean g = false;
    volatile boolean h = false;
    public AtomicInteger i = new AtomicInteger(0);
    public int j;
    c.t.m.g.ar.a k = new ao(this);
    private final String l = a();
    private final Runnable m = new ap(this);
    private final Runnable n = new aq(this);

    final class c extends a {
        private d a;

        public c(d dVar) {
            super(al.this, (byte) 0);
            this.a = dVar;
        }

        public final void run() {
            int i = 0;
            super.run();
            al.this.g = false;
            int i2;
            if (this.a.d) {
                al.this.b.addAndGet(this.a.f);
                if (!this.a.b) {
                    int size = this.a.e.size();
                    List arrayList = new ArrayList();
                    for (i2 = 0; i2 < size; i2++) {
                        arrayList.add(Long.valueOf(((c.t.m.g.au.a) this.a.e.get(i2)).a));
                    }
                    au.a(al.this.c()).a(arrayList);
                    if (al.this.h) {
                        al.this.h = false;
                        al.this.a(true, this.a.c);
                        return;
                    }
                }
                if (!this.a.a) {
                    SystemClock.sleep(20);
                    al.this.a(this.a.b, this.a.c);
                }
            } else if (this.a.c && this.a.b) {
                i2 = this.a.e.size();
                while (i < i2) {
                    au.a(al.this.c()).b(((c.t.m.g.au.a) this.a.e.get(i)).b);
                    i++;
                }
            }
        }
    }

    public class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(al alVar, byte b) {
            this();
        }

        public final void a(boolean z) {
            if (!z) {
                al.this.c.post(this);
            } else if (!al.this.c.postAtFrontOfQueue(this)) {
                al.this.c.post(this);
            }
        }

        public void run() {
            Process.setThreadPriority(10);
        }
    }

    final class d extends a {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d = false;
        public List<c.t.m.g.au.a> e;
        int f;

        public d(boolean z, boolean z2) {
            super(al.this, (byte) 0);
            this.b = z;
            this.c = z2;
        }

        public final void run() {
            String str;
            List list = null;
            int i = 0;
            super.run();
            this.a = false;
            if (this.b) {
                int size = al.this.f.size();
                if (size != 0) {
                    List arrayList = new ArrayList();
                    List arrayList2 = new ArrayList();
                    int i2 = 0;
                    for (int i3 = 0; i3 < size && i2 < 10; i3++) {
                        str = (String) al.this.f.get(i3);
                        arrayList2.add(new c.t.m.g.au.a(0, str));
                        arrayList.add(str);
                        i2++;
                    }
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        al.this.f.remove(arrayList.get(i4));
                    }
                    if (al.this.f.size() == 0) {
                        this.a = true;
                    }
                    list = arrayList2;
                }
                this.e = list;
            } else {
                if (!au.a(al.this.c()).a(v.a("report_clear_db_num", 1, 10000, 1000))) {
                    list = au.a(al.this.c()).a();
                    if (list.size() < 10) {
                        this.a = true;
                    }
                }
                this.e = list;
            }
            if (this.e == null || this.e.size() == 0) {
                al.this.g = false;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (i < this.e.size()) {
                stringBuilder.append(((c.t.m.g.au.a) this.e.get(i)).b);
                i++;
            }
            str = stringBuilder.toString();
            if (stringBuilder.toString().contains("client_report_time")) {
                str = stringBuilder.toString().replace("client_report_time", cg.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
            }
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            this.f = length;
            byte[] a = v.a(bytes);
            al.this.d.a(a, length, this.b, this, al.this.k);
        }
    }

    public final class b extends a {
        private String a;
        private boolean b = true;

        public b(String str) {
            super(al.this, (byte) 0);
            this.a = str;
        }

        public final void run() {
            super.run();
            al.this.i.decrementAndGet();
            if (!TextUtils.isEmpty(this.a)) {
                StringBuilder stringBuilder = new StringBuilder(this.a);
                int a = v.a("report_new_record_num", 1, 50, 10);
                if (au.a(al.this.c()).b(stringBuilder.toString()) != -1 && al.this.e.incrementAndGet() >= a) {
                    al.this.a(false, this.b);
                }
            }
        }
    }

    public al() {
        as.a(m.a());
        HandlerThread handlerThread = new HandlerThread(this.l);
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
        this.d = new am();
        b(true, false);
        this.j = b();
    }

    public abstract String a();

    final synchronized void a(boolean z, boolean z2) {
        if (z && z2) {
            b(false, true);
        } else {
            b(false, false);
        }
        if (!this.g) {
            if (!z) {
                this.e.set(0);
            }
            this.g = true;
            try {
                new d(z, z2).a(true);
            } catch (Throwable th) {
                this.g = false;
            }
        } else if (z) {
            this.h = true;
        }
        return;
    }

    public abstract int b();

    final void b(boolean z, boolean z2) {
        ab a;
        Runnable runnable;
        long a2;
        if (!z2) {
            a = ab.a();
            runnable = this.n;
            a2 = z ? 10000 : (long) v.a("report_timer_interval", 30000, 600000, 60000);
        } else if (this.a.get() > 3) {
            this.a.set(0);
            return;
        } else {
            a = ab.a();
            runnable = this.m;
            a2 = (long) (v.a("report_real_timer_interval", 1, 60, 5) * 1000);
        }
        a.a(runnable, false, a2);
    }

    public abstract String c();
}
