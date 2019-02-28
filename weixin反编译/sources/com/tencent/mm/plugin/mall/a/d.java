package com.tencent.mm.plugin.mall.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.bt.a;
import com.tencent.mm.y.p;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class d implements e, ap {
    private ag mHandler = new ag(Looper.getMainLooper());
    private a oqA = new a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            final String a = n.a(aVar.hoa.vNO);
            x.d("MicroMsg.SubCoreMall", "WalletNotifyConfXml:" + a);
            d.this.mHandler.post(new Runnable() {
                public final void run() {
                    c bMQ = c.bMQ();
                    String str = a;
                    MallNews NH = c.NH(str);
                    if (NH == null) {
                        return;
                    }
                    if ("2".equals(NH.type)) {
                        x.d("MicroMsg.MallNewsManager", "removeNews : " + NH);
                        MallNews mallNews = (MallNews) bMQ.sWU.get(NH.sWK);
                        if (mallNews != null && mallNews.sbN.equals(NH.sbN) && mallNews.fsK.equals(NH.fsK)) {
                            x.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + NH.sWK);
                            bMQ.sWU.remove(NH.sWK);
                            return;
                        }
                        x.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
                        return;
                    }
                    bMQ.sWU.put(NH.sWK, NH);
                    x.i("MicroMsg.MallNewsManager", "onRecieveMsg : " + str);
                    bMQ.bjN();
                    if (c.a(NH)) {
                        x.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
                        return;
                    }
                    if (NH.showType == 0) {
                        x.d("MicroMsg.MallNewsManager", "showType New");
                        com.tencent.mm.r.c.Bx().o(262156, true);
                        g.Dr();
                        g.Dq().Db().a(w.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                    } else if (NH.showType == 1) {
                        x.d("MicroMsg.MallNewsManager", "showType Dot");
                        com.tencent.mm.r.c.Bx().p(262156, true);
                        g.Dr();
                        g.Dq().Db().a(w.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
                    }
                    c.bMS();
                }
            });
        }
    };
    private a oqB = new a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            final String a = n.a(aVar.hoa.vNO);
            x.d("MicroMsg.SubCoreMall", "receive pay msg: %s", a);
            d.this.mHandler.post(new Runnable() {
                public final void run() {
                    c.bMQ();
                    c.NE(a);
                }
            });
        }
    };
    ConcurrentHashMap<Integer, t> oqy = new ConcurrentHashMap();
    private boolean oqz = false;

    public static d aYD() {
        return (d) p.s(d.class);
    }

    public final t sF(int i) {
        Object obj = null;
        if (!this.oqy.contains(Integer.valueOf(i))) {
            com.tencent.mm.plugin.wallet_core.d.e bMh = o.bMh();
            String str = "select * from WalletFunciontList where wallet_region = " + i;
            Cursor a = bMh.gLA.a(str, null, 2);
            x.i("MicroMsg.WalletFunctionListStg", "getWalletFunciontListInfo " + str);
            if (a != null) {
                if (a.moveToNext()) {
                    obj = new t();
                    obj.b(a);
                }
                a.close();
            }
            if (obj != null) {
                this.oqy.put(Integer.valueOf(i), obj);
            }
        }
        t tVar = (t) this.oqy.get(Integer.valueOf(i));
        if (tVar == null) {
            return new t();
        }
        return tVar;
    }

    public final ArrayList<MallFunction> sG(int i) {
        return sF(i).oqr;
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("mallactivity", this.oqA, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("paymsg", this.oqB, true);
        c.bMQ().Xc();
        com.tencent.mm.plugin.wallet_core.model.mall.d.bMU().Xc();
        if (q.Gl() && q.Gh()) {
            b.zC(b.sWH);
        } else {
            b.zC(b.sWG);
        }
        g.Dr();
        g.Dp().gRu.a((int) HardCoderJNI.SCENE_QUIT_CHATTING, (e) this);
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("mallactivity", this.oqA, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("paymsg", this.oqB, true);
        g.Dr();
        g.Dp().gRu.b((int) HardCoderJNI.SCENE_QUIT_CHATTING, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i2 == 0 && i == 0 && !this.oqz && q.Gl()) {
            this.oqz = true;
            b.zC(b.sWH);
        }
    }
}
