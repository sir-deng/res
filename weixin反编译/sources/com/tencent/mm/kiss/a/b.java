package com.tencent.mm.kiss.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class b {
    private static b gUF;
    public LayoutInflater DF;
    private ConcurrentHashMap<String, c> gUE = new ConcurrentHashMap();
    public Looper gUG;
    public ag gUH;
    public boolean gUI = false;
    public boolean gUJ = false;
    public int mMode = 2;

    private static final class a implements OnAttachStateChangeListener {
        private String gUL;
        private b gUM;
        private b gUN = null;

        public a(String str, b bVar, b bVar2) {
            this.gUL = str;
            this.gUM = bVar;
        }

        public final void onViewAttachedToWindow(View view) {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onViewDetachedFromWindow(android.view.View r4) {
            /*
            r3 = this;
            r0 = r3.gUM;
            r0 = r0.gUE;
            r1 = r3.gUL;
            r0 = r0.get(r1);
            r0 = (com.tencent.mm.kiss.a.c) r0;
            r1 = r3.gUM;
            r1 = r1.mMode;
            r2 = 1;
            if (r1 != r2) goto L_0x0030;
        L_0x0017:
            if (r0 == 0) goto L_0x0029;
        L_0x0019:
            monitor-enter(r0);
            r1 = r0.gUP;	 Catch:{ all -> 0x002d }
            r1.remove(r4);	 Catch:{ all -> 0x002d }
            r1 = r0.gUO;	 Catch:{ all -> 0x002d }
            r1.add(r4);	 Catch:{ all -> 0x002d }
            monitor-exit(r0);	 Catch:{ all -> 0x002d }
            r0 = r3.gUN;
            if (r0 == 0) goto L_0x0029;
        L_0x0029:
            r4.removeOnAttachStateChangeListener(r3);
            return;
        L_0x002d:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x002d }
            throw r1;
        L_0x0030:
            r1 = r3.gUM;
            com.tencent.mm.kiss.a.b.a(r1, r0);
            goto L_0x0029;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kiss.a.b.a.onViewDetachedFromWindow(android.view.View):void");
        }
    }

    public interface b {
    }

    /* renamed from: com.tencent.mm.kiss.a.b$1 */
    class AnonymousClass1 extends ag {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            x.i("KISS.InflateRecycler", "InflateViewRecycler start %s", Long.valueOf(System.currentTimeMillis()));
            c cVar = (c) message.obj;
            int size = cVar.gUQ - cVar.gUO.size();
            int i = cVar.DD;
            x.i("KISS.InflateRecycler", "InflateViewRecycler for %s", cVar.gUL);
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    View inflate = b.this.DF.inflate(i, cVar.gUS, false);
                    synchronized (cVar) {
                        cVar.gUO.add(inflate);
                    }
                    if (!(cVar.gUR == null || cVar.gUR.length == 0)) {
                        for (int i3 = 0; i3 < cVar.gUR.length; i3 += 2) {
                            View findViewById = inflate.findViewById(cVar.gUR[i3]);
                            if (findViewById != null && (findViewById instanceof ViewStub)) {
                                int i4 = cVar.gUR[i3 + 1];
                                if (i4 != 0) {
                                    ((ViewStub) findViewById).setLayoutResource(i4);
                                }
                                ((ViewStub) findViewById).inflate();
                            }
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("KISS.InflateRecycler", e, "pre inflate failed.", new Object[0]);
                    com.tencent.mm.blink.a.j(11, 1);
                }
            }
            x.i("KISS.InflateRecycler", "InflateViewRecycler end %s", Long.valueOf(System.currentTimeMillis()));
            x.i("KISS.InflateRecycler", "preload done");
        }
    }

    static /* synthetic */ void a(b bVar, c cVar) {
        if (bVar.gUI && !bVar.gUJ && cVar.gUQ > cVar.gUO.size()) {
            bVar.gUH.sendMessage(bVar.gUH.obtainMessage(0, cVar));
        }
    }

    static {
        gUF = null;
        gUF = new b();
    }

    public static b Ef() {
        return gUF;
    }

    public final View a(Activity activity, String str, int i) {
        if (this.gUJ) {
            x.i("KISS.InflateRecycler", "not support application inflate");
            return activity.getLayoutInflater().inflate(i, null);
        } else if (!this.gUI) {
            return activity.getLayoutInflater().inflate(i, null);
        } else {
            c cVar = (c) this.gUE.get(str);
            if (cVar != null) {
                View view;
                synchronized (cVar) {
                    view = (View) cVar.gUO.poll();
                    if (this.mMode == 1) {
                        cVar.gUP.add(view);
                    }
                }
                if (view != null) {
                    x.i("KISS.InflateRecycler", "cache reach %s", str);
                    view.addOnAttachStateChangeListener(new a(str, this, null));
                    return view;
                }
            }
            x.i("KISS.InflateRecycler", "no cache reach %s", str);
            return this.DF.inflate(i, null);
        }
    }

    public final boolean a(String str, int i, int i2, int... iArr) {
        return a(str, i, i2, null, iArr);
    }

    public final boolean a(String str, int i, int i2, ViewGroup viewGroup, int... iArr) {
        if (!this.gUI) {
            return false;
        }
        if (this.gUJ) {
            x.i("KISS.InflateRecycler", "not support application inflate");
            return false;
        }
        if (viewGroup != null) {
            if (VERSION.SDK_INT >= 19) {
                Assert.assertFalse(viewGroup.isAttachedToWindow());
            }
            Assert.assertTrue(viewGroup.getParent() == null);
        }
        if (((c) this.gUE.get(str)) != null) {
            return false;
        }
        c cVar = new c();
        this.gUE.put(str, cVar);
        cVar.gUQ = i;
        cVar.gUL = str;
        cVar.DD = i2;
        cVar.gUR = iArr;
        cVar.gUS = viewGroup;
        this.gUH.sendMessage(this.gUH.obtainMessage(0, cVar));
        return true;
    }
}
