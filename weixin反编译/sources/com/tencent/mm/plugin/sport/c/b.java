package com.tencent.mm.plugin.sport.c;

import android.os.Looper;
import com.tencent.mm.f.a.ff;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import java.util.Calendar;
import org.json.JSONObject;

public final class b {
    public c<qq> rZH = new c<qq>() {
        {
            this.xmG = qq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qq qqVar = (qq) bVar;
            switch (qqVar.fJc.action) {
                case 1:
                case 2:
                case 3:
                    if (n.bEi()) {
                        boolean fd;
                        long chg = bi.chg() / 10000;
                        long K = i.K(513, 0);
                        long K2 = i.K(WXMediaMessage.TITLE_LENGTH_LIMIT, 0);
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(K);
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        if (chg != instance.getTimeInMillis() / 10000) {
                            K2 = 0;
                        }
                        if (qqVar.fJc.action == 1) {
                            fd = b.this.fd(K2);
                            com.tencent.mm.sdk.b.b ffVar = new ff();
                            ffVar.fvd.action = 1;
                            a.xmy.a(ffVar, Looper.getMainLooper());
                        } else {
                            fd = n.H(b.this.bDY(), K2) ? b.this.fd(K2) : false;
                        }
                        x.i("MicroMsg.Sport.ExtApiStepManager", "upload step %d %d %b", Integer.valueOf(qqVar.fJc.action), Long.valueOf(K2), Boolean.valueOf(fd));
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    public f rZI;
    public c rZO = new c<ff>() {
        {
            this.xmG = ff.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return b.this.i((ff) bVar);
        }
    };
    private long rZP;
    private long rZQ;

    public b() {
        this.rZO.cfB();
        this.rZH.cfB();
    }

    final boolean i(com.tencent.mm.sdk.b.b bVar) {
        ff ffVar = (ff) bVar;
        switch (ffVar.fvd.action) {
            case 2:
                int i;
                long j = ffVar.fvd.fvg;
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = ffVar.fvd.fvh;
                com.tencent.mm.f.a.ff.b bVar2 = ffVar.fve;
                if (!n.bDN()) {
                    i = 3906;
                } else if (n.bEi()) {
                    long K = i.K(513, 0);
                    long K2 = i.K(WXMediaMessage.TITLE_LENGTH_LIMIT, 0);
                    x.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", Long.valueOf(K), Long.valueOf(K2), Long.valueOf(currentTimeMillis), Long.valueOf(j));
                    if (currentTimeMillis - K < 300000) {
                        x.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
                        i = 3903;
                    } else {
                        JSONObject bEb = g.bEb();
                        if (!bi.w(currentTimeMillis, K)) {
                            K = bi.chg();
                            K2 = 0;
                        }
                        long j3 = currentTimeMillis - K;
                        x.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", Long.valueOf((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0))), Long.valueOf(j3), Long.valueOf(currentTimeMillis), Long.valueOf(K), Long.valueOf(((long) bEb.optInt("stepCounterMaxStep5m")) * ((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0)))));
                        K2 = j - K2;
                        if (K2 < 0 || K2 > r14) {
                            x.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", Long.valueOf(K2), Long.valueOf(r14));
                            i = 3904;
                        } else {
                            x.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", n.bq(currentTimeMillis), Long.valueOf(j));
                            i.L(513, currentTimeMillis);
                            i.L(WXMediaMessage.TITLE_LENGTH_LIMIT, j);
                            i.L(514, j2);
                            i = 1;
                        }
                    }
                } else {
                    i = 3902;
                }
                bVar2.fvk = i;
                if (ffVar.fve.fvk == 1) {
                    if (this.rZP == 0) {
                        this.rZP = i.K(515, 0);
                    }
                    boolean G = n.G(this.rZP, System.currentTimeMillis());
                    boolean H = n.H(bDY(), j);
                    if (G && H) {
                        fd(j);
                    }
                }
                ffVar.fve.fvj = true;
                break;
            case 3:
                try {
                    JSONObject optJSONObject = g.bEb().optJSONObject("extStepApiConfig");
                    if (optJSONObject != null) {
                        ffVar.fve.fvi = optJSONObject.toString();
                    }
                    if (bi.oN(ffVar.fve.fvi)) {
                        ffVar.fve.fvk = 3905;
                    } else {
                        ffVar.fve.fvk = 1;
                    }
                } catch (Exception e) {
                    ffVar.fve.fvk = 3905;
                }
                ffVar.fve.fvj = true;
                break;
        }
        return true;
    }

    final boolean fd(long j) {
        if (this.rZI != null) {
            g.CN().c(this.rZI);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        x.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", n.bq(currentTimeMillis), Long.valueOf(j));
        this.rZI = new f("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (currentTimeMillis / 1000), (int) j, be.ckL(), 2);
        g.CN().a(this.rZI, 0);
        this.rZP = currentTimeMillis;
        i.L(515, currentTimeMillis);
        this.rZQ = j;
        i.K(516, this.rZQ);
        return true;
    }

    public final long bDY() {
        if (this.rZQ == 0) {
            this.rZQ = i.K(516, 0);
        }
        return this.rZQ;
    }
}
