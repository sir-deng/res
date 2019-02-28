package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.c.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class g {
    List<a> gzt = new LinkedList();
    Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: com.tencent.wecall.talkroom.model.g$20 */
    class AnonymousClass20 implements Runnable {
        final /* synthetic */ MultiTalkGroup oMh;

        AnonymousClass20(MultiTalkGroup multiTalkGroup) {
            this.oMh = multiTalkGroup;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a b : g.this.gzt) {
                    b.b(this.oMh);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$14 */
    class AnonymousClass14 implements Runnable {
        final /* synthetic */ boolean oZx;

        AnonymousClass14(boolean z) {
            this.oZx = z;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a gQ : g.this.gzt) {
                    gQ.gQ(this.oZx);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$9 */
    class AnonymousClass9 implements Runnable {
        final /* synthetic */ int iYL;

        AnonymousClass9(int i) {
            this.iYL = i;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a onStateChanged : g.this.gzt) {
                    onStateChanged.onStateChanged(this.iYL);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ int fmv;

        AnonymousClass2(int i) {
            this.fmv = i;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a Jr : g.this.gzt) {
                    Jr.Jr(this.fmv);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$15 */
    class AnonymousClass15 implements Runnable {
        final /* synthetic */ int AxZ;

        AnonymousClass15(int i) {
            this.AxZ = i;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a Js : g.this.gzt) {
                    Js.Js(this.AxZ);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$17 */
    class AnonymousClass17 implements Runnable {
        final /* synthetic */ String Axy;
        final /* synthetic */ byte[] Aya;

        AnonymousClass17(String str, byte[] bArr) {
            this.Axy = str;
            this.Aya = bArr;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a y : g.this.gzt) {
                    y.y(this.Axy, this.Aya);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int AxV;

        AnonymousClass1(int i) {
            this.AxV = i;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a tx : g.this.gzt) {
                    tx.tx(this.AxV);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ MultiTalkGroup oMh;

        AnonymousClass6(MultiTalkGroup multiTalkGroup) {
            this.oMh = multiTalkGroup;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a p : g.this.gzt) {
                    p.p(this.oMh);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ MultiTalkGroup oMh;

        AnonymousClass7(MultiTalkGroup multiTalkGroup) {
            this.oMh = multiTalkGroup;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a q : g.this.gzt) {
                    q.q(this.oMh);
                }
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ boolean AxX;
        final /* synthetic */ String Axy;

        AnonymousClass8(String str, boolean z) {
            this.Axy = str;
            this.AxX = z;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                List<a> arrayList = new ArrayList(g.this.gzt);
            }
            for (a bv : arrayList) {
                bv.bv(this.Axy, this.AxX);
            }
        }
    }

    /* renamed from: com.tencent.wecall.talkroom.model.g$11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ List AxY;

        AnonymousClass11(List list) {
            this.AxY = list;
        }

        public final void run() {
            synchronized (g.this.gzt) {
                for (a bk : g.this.gzt) {
                    bk.bk(this.AxY);
                }
            }
        }
    }

    public interface a {
        void Jr(int i);

        void Js(int i);

        void a(int i, MultiTalkGroup multiTalkGroup);

        void aWH();

        void b(MultiTalkGroup multiTalkGroup);

        void bdi();

        void bk(List<am> list);

        void bv(String str, boolean z);

        void cIG();

        void cIH();

        void cII();

        void dN(String str, int i);

        void dO(List<MultiTalkGroup> list);

        void g(int i, Object obj);

        void g(MultiTalkGroup multiTalkGroup);

        void gQ(boolean z);

        void onStateChanged(int i);

        void p(MultiTalkGroup multiTalkGroup);

        void q(MultiTalkGroup multiTalkGroup);

        void tx(int i);

        void y(String str, byte[] bArr);
    }

    public final void dO(final List<MultiTalkGroup> list) {
        Runnable anonymousClass19 = new Runnable() {
            public final void run() {
                synchronized (g.this.gzt) {
                    for (a dO : g.this.gzt) {
                        dO.dO(list);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass19.run();
        } else {
            this.handler.post(anonymousClass19);
        }
    }

    public final void a(final int i, final MultiTalkGroup multiTalkGroup) {
        Runnable anonymousClass21 = new Runnable() {
            public final void run() {
                synchronized (g.this.gzt) {
                    for (a a : g.this.gzt) {
                        a.a(i, multiTalkGroup);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass21.run();
        } else {
            this.handler.post(anonymousClass21);
        }
    }

    public final void g(final int i, final Object obj) {
        Runnable anonymousClass4 = new Runnable() {
            public final void run() {
                synchronized (g.this.gzt) {
                    for (a g : g.this.gzt) {
                        g.g(i, obj);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass4.run();
        } else {
            this.handler.post(anonymousClass4);
        }
    }

    public final void g(final MultiTalkGroup multiTalkGroup) {
        Runnable anonymousClass5 = new Runnable() {
            public final void run() {
                synchronized (g.this.gzt) {
                    for (a g : g.this.gzt) {
                        g.g(multiTalkGroup);
                    }
                }
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            anonymousClass5.run();
        } else {
            this.handler.post(anonymousClass5);
        }
    }

    public final void dN(final String str, final int i) {
        h.ac(new Runnable() {
            public final void run() {
                synchronized (g.this.gzt) {
                    for (a dN : g.this.gzt) {
                        dN.dN(str, i);
                    }
                }
            }
        });
    }
}
