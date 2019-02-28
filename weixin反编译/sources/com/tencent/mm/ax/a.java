package com.tencent.mm.ax;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.i;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private e gLE;
    public a hKx;
    public final List<com.tencent.mm.plugin.messenger.foundation.a.a.e.b> hKy = new ArrayList();

    public static class a extends i {
        public final c hKA = new c();
        private final b hKz = new b();

        public final d Hu() {
            return this.hKz;
        }

        public final com.tencent.mm.protocal.k.e Hv() {
            return this.hKA;
        }

        public final int getType() {
            return 681;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/oplog";
        }
    }

    public static class c extends com.tencent.mm.protocal.k.e implements com.tencent.mm.protocal.k.c {
        public awe hKC = new awe();

        public final int E(byte[] bArr) {
            this.hKC = (awe) new awe().aH(bArr);
            return this.hKC.vQL;
        }
    }

    static class b extends d implements com.tencent.mm.protocal.k.b {
        public awd hKB = new awd();

        b() {
        }

        public final byte[] Hw() {
            return this.hKB.toByteArray();
        }

        public final int Hx() {
            return 681;
        }
    }

    public a(List<com.tencent.mm.plugin.messenger.foundation.a.a.e.b> list) {
        this.hKy.addAll(list);
        this.hKx = new a();
        ((b) this.hKx.Kh()).hKB.wIF = R(list);
    }

    private static ou R(List<com.tencent.mm.plugin.messenger.foundation.a.a.e.b> list) {
        ou ouVar = new ou();
        for (com.tencent.mm.plugin.messenger.foundation.a.a.e.b bVar : list) {
            byte[] buffer = bVar.getBuffer();
            ot otVar = new ot();
            otVar.wet = bVar.getCmdId();
            otVar.weu = new bes().bl(buffer);
            ouVar.kyB.add(otVar);
        }
        ouVar.kyA = list.size();
        x.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + list.size());
        return ouVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        for (com.tencent.mm.plugin.messenger.foundation.a.a.e.b cmdId : this.hKy) {
            if (cmdId.getCmdId() == 1) {
                ad.getContext().getSharedPreferences(ad.cgf(), 0).edit().putBoolean(q.FY() + "_has_mod_userinfo", true).commit();
                break;
            }
        }
        this.gLE = eVar2;
        return a(eVar, this.hKx, this);
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 5;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 681;
    }
}
