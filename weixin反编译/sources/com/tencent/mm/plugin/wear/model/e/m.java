package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.mm.f.a.tl;
import com.tencent.mm.f.a.tn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bzy;
import com.tencent.mm.protocal.c.cas;
import com.tencent.mm.protocal.c.cat;
import com.tencent.mm.protocal.c.cau;
import com.tencent.mm.protocal.c.cav;
import com.tencent.mm.protocal.c.caz;
import com.tencent.mm.protocal.c.cbz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class m extends a {

    private static class a extends d {
        private cav tpu;

        public a(cav cav) {
            this.tpu = cav;
        }

        protected final void execute() {
            String nZ = q.nZ(this.tpu.xgB);
            x.i("MicroMsg.Wear.HttpReplyServer", "get fileName=%s", nZ);
            x.i("MicroMsg.Wear.HttpReplyServer", "get fullPath=%s", q.M(nZ, false));
            InputStream byteArrayInputStream = new ByteArrayInputStream(this.tpu.vPr.toByteArray());
            com.tencent.mm.audio.c.d dVar = new com.tencent.mm.audio.c.d(8000, 16000);
            dVar.cL(r0);
            byte[] bArr = new byte[320];
            int i = 0;
            while (true) {
                try {
                    i = byteArrayInputStream.read(bArr, 0, 320);
                } catch (IOException e) {
                }
                if (i > 0) {
                    dVar.a(new com.tencent.mm.audio.b.g.a(bArr, i), 0, false);
                } else {
                    dVar.vK();
                    x.i("MicroMsg.Wear.HttpReplyServer", "amr compress finish");
                    q.aa(nZ, (int) this.tpu.xgW);
                    com.tencent.mm.modelvoice.m.UM().run();
                    x.i("MicroMsg.Wear.HttpReplyServer", "run service to send the voice");
                    as.Hm();
                    c.Fk().XH(this.tpu.xgB);
                    return;
                }
            }
        }

        public final String getName() {
            return "SendVioceMsgTask";
        }
    }

    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11022));
        arrayList.add(Integer.valueOf(11023));
        arrayList.add(Integer.valueOf(11025));
        arrayList.add(Integer.valueOf(11024));
        arrayList.add(Integer.valueOf(11026));
        arrayList.add(Integer.valueOf(11029));
        return arrayList;
    }

    protected final boolean zU(int i) {
        switch (i) {
            case 11023:
            case 11025:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] n(int i, byte[] bArr) {
        switch (i) {
            case 11022:
                cav cav = new cav();
                try {
                    cav.aH(bArr);
                } catch (IOException e) {
                }
                com.tencent.mm.plugin.wear.model.a.bPh().tor.a(new a(cav));
                com.tencent.mm.plugin.wear.model.a.bPh().tom.Oo(cav.xgB);
                com.tencent.mm.plugin.wear.model.c.a.ei(2, cav.sfa);
                com.tencent.mm.plugin.wear.model.c.a.zS(2);
                break;
            case 11023:
                cau cau = new cau();
                try {
                    cau.aH(bArr);
                } catch (IOException e2) {
                }
                f.aZN().C(cau.xgB, cau.wmc, s.hs(cau.xgB));
                as.Hm();
                c.Fk().XH(cau.xgB);
                com.tencent.mm.plugin.wear.model.c.a.ei(3, cau.sfa);
                com.tencent.mm.plugin.wear.model.c.a.zS(5);
                break;
            case 11024:
                cas cas = new cas();
                try {
                    cas.aH(bArr);
                } catch (IOException e3) {
                }
                ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().n(ad.getContext(), cas.xgB, cas.wgY);
                as.Hm();
                c.Fk().XH(cas.xgB);
                com.tencent.mm.plugin.wear.model.c.a.ei(7, cas.sfa);
                com.tencent.mm.plugin.wear.model.c.a.zS(3);
                break;
            case 11025:
                cat cat = new cat();
                try {
                    cat.aH(bArr);
                } catch (IOException e4) {
                }
                f.aZN().C(cat.xgB, cat.wmc, s.hs(cat.xgB));
                ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().n(ad.getContext(), cat.xgB, cat.wgY);
                as.Hm();
                c.Fk().XH(cat.xgB);
                com.tencent.mm.plugin.wear.model.c.a.ei(8, cat.sfa);
                com.tencent.mm.plugin.wear.model.c.a.zS(4);
                break;
            case 11026:
                caz caz = new caz();
                try {
                    caz.aH(bArr);
                } catch (IOException e5) {
                }
                com.tencent.mm.plugin.wear.model.a.bPh();
                bzy bzy = com.tencent.mm.plugin.wear.model.a.bPh().tok.toC.tps;
                if (bzy != null) {
                    x.i("MicroMsg.Wear.WearBizLogic", "receive step count %d | time %s", Integer.valueOf(caz.xhb), n.ak("yyyy-MM-dd HH:mm:ss", caz.xhc / 1000));
                    cbz cbz = new cbz();
                    bnk bnk = new bnk();
                    bnk.kzx = caz.xhb > 0 ? caz.xhb : 0;
                    bnk.wid = (int) (caz.xhc / 1000);
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(caz.xhc);
                    bnk.wXs = instance.get(1);
                    bnk.wXt = instance.get(2) + 1;
                    bnk.wXu = instance.get(5);
                    bnk.wXv = instance.get(11);
                    bnk.wXw = instance.get(12);
                    bnk.wXx = instance.get(13);
                    cbz.xhR.add(bnk);
                    b tnVar = new tn();
                    try {
                        tnVar.fMV.data = cbz.toByteArray();
                    } catch (IOException e6) {
                    }
                    tnVar.fMV.fql = 4;
                    tnVar.fMV.ffG = bzy.xgu;
                    tnVar.fMV.fsb = "gh_43f2581f6fd6";
                    com.tencent.mm.sdk.b.a.xmy.m(tnVar);
                    break;
                }
                x.e("MicroMsg.Wear.WearBizLogic", "logicRequest is null");
                break;
            case 11029:
                if (com.tencent.mm.plugin.wear.model.a.bPh().tok.bPm() && com.tencent.mm.j.g.Af().getInt("WearLuckyBlock", 0) == 0) {
                    long j = 0;
                    try {
                        j = Long.valueOf(new String(bArr)).longValue();
                    } catch (Exception e7) {
                    }
                    b tlVar = new tl();
                    tlVar.fMJ.action = 1;
                    tlVar.fMJ.fqB = j;
                    com.tencent.mm.sdk.b.a.xmy.a(tlVar, Looper.getMainLooper());
                    com.tencent.mm.plugin.wear.model.c.a.ei(11, 0);
                    com.tencent.mm.plugin.wear.model.c.a.zS(11);
                    break;
                }
                return null;
                break;
        }
        return null;
    }
}
