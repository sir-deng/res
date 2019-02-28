package com.tencent.mm.ad;

import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.network.r;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bf;
import junit.framework.Assert;

public abstract class k {
    public boolean aBT = false;
    private int asN = -99;
    public e hok;
    public long hol = bi.Wz();
    public int hom = -1;
    private q hon;
    e hoo;
    public boolean hop;
    public q hoq;
    int priority = 0;

    /* renamed from: com.tencent.mm.ad.k$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] hou = new int[b.Ko().length];

        static {
            try {
                hou[b.hoy - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hou[b.hoA - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hou[b.hoz - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    protected enum a {
        EStatusCheckFailed,
        EReachMaxLimit
    }

    protected enum b {
        ;

        public static int[] Ko() {
            return (int[]) hoB.clone();
        }

        static {
            hoy = 1;
            hoz = 2;
            hoA = 3;
            hoB = new int[]{hoy, hoz, hoA};
        }
    }

    public abstract int a(e eVar, e eVar2);

    public abstract int getType();

    public final void reset() {
        this.hol = bi.Wz();
        this.hom = -1;
        this.asN = -99;
    }

    public void a(a aVar) {
    }

    public int a(q qVar) {
        return b.hoy;
    }

    public boolean Kj() {
        return false;
    }

    public int Bo() {
        return 1;
    }

    public boolean Kk() {
        return this.asN <= 0;
    }

    public boolean Kl() {
        return false;
    }

    public final void c(e eVar) {
        this.hol = bi.Wz();
        this.hok = eVar;
    }

    public boolean Km() {
        return Bo() == 1;
    }

    public int a(e eVar, final q qVar, com.tencent.mm.network.k kVar) {
        c(eVar);
        this.hoq = qVar;
        final com.tencent.mm.network.k a = bf.a(kVar);
        if (this.asN == -99) {
            this.asN = Bo();
            x.i("MicroMsg.NetSceneBase", "initilized security limit count to " + this.asN);
        }
        if (Bo() > 1) {
            switch (AnonymousClass2.hou[a(qVar) - 1]) {
                case 1:
                    Assert.assertTrue("scene security verification not passed, type=" + qVar.getType() + ", uri=" + qVar.getUri() + ", CHECK NOW", false);
                    break;
                case 2:
                    x.e("MicroMsg.NetSceneBase", "scene security verification not passed, type=" + qVar.getType() + ", uri=" + qVar.getUri());
                    this.asN--;
                    a(a.EStatusCheckFailed);
                    this.hom = -1;
                    return this.hom;
                case 3:
                    break;
                default:
                    Assert.assertTrue("invalid security verification status", false);
                    break;
            }
        }
        if (Kk()) {
            x.e("MicroMsg.NetSceneBase", "dispatch failed, scene limited for security, current limit=" + Bo());
            a(a.EReachMaxLimit);
            this.hom = -1;
            return this.hom;
        }
        this.asN--;
        r sVar = new s(qVar);
        if (!(this.hon == null || Kl())) {
            this.hon.cancel();
        }
        this.hon = new q(qVar, a, this, this.hoo, eVar);
        this.hom = eVar.a(sVar, this.hon);
        x.i("MicroMsg.NetSceneBase", "dispatcher send, %s", Integer.valueOf(this.hom));
        if (this.hom < 0) {
            x.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(this.hom), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
            new ag().post(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(k.this.hom), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
                    a.a(-1, 3, -1, "send to network failed", qVar, null);
                    x.i("MicroMsg.NetSceneBase", "dispatcher send, %s, ThreadID:%s, getType:%s", Integer.valueOf(k.this.hom), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(qVar.getType()));
                }
            });
            return 99999999;
        }
        q qVar2 = this.hon;
        qVar2.handler.postDelayed(qVar2.hpd, 330000);
        return this.hom;
    }

    public final int Kn() {
        return this.hoq == null ? 0 : this.hoq.hashCode();
    }

    public void cancel() {
        x.i("MicroMsg.NetSceneBase", "cancel: %d, hash:%d, type:%d", Integer.valueOf(this.hom), Integer.valueOf(hashCode()), Integer.valueOf(getType()));
        this.aBT = true;
        if (this.hon != null) {
            this.hon.cancel();
        }
        if (this.hom != -1 && this.hok != null) {
            int i = this.hom;
            this.hom = -1;
            this.hok.cancel(i);
        }
    }

    public boolean a(k kVar) {
        return false;
    }

    public boolean b(k kVar) {
        return false;
    }

    public String getInfo() {
        return "";
    }
}
