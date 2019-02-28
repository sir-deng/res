package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.be.h;
import com.tencent.mm.be.l;
import com.tencent.mm.f.a.iq;
import com.tencent.mm.f.a.it;
import com.tencent.mm.f.a.iu;
import com.tencent.mm.f.a.iv;
import com.tencent.mm.f.a.jz;
import com.tencent.mm.f.a.ka;
import com.tencent.mm.f.a.rd;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aoz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements ap {
    private c leJ = new c<rd>() {
        {
            this.xmG = rd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rd rdVar = (rd) bVar;
            if (rdVar.fJL.fJM.equals(jz.class.getName())) {
                if (rdVar.fJL.fvo == 1) {
                    f.this.oTG.bYW();
                } else {
                    f.this.oTG.aVz();
                }
            } else if (rdVar.fJL.fJM.equals(ka.class.getName())) {
                if (rdVar.fJL.fvo == 1) {
                    f.this.oTH.bYW();
                } else {
                    f.this.oTH.aVz();
                }
            } else if (rdVar.fJL.fJM.equals(iq.class.getName())) {
                if (rdVar.fJL.fvo == 1) {
                    f.this.oTI.abp();
                } else {
                    f.this.oTI.unregister();
                }
            }
            return false;
        }
    };
    private c oTE = new c<iu>() {
        {
            this.xmG = iu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            int i = 3;
            iu iuVar = (iu) bVar;
            bb.b bVar2 = iuVar.fAe.fAf;
            cg cgVar = iuVar.fAe.fou;
            if (bVar2.his != null && bVar2.scene == 1) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(73729, Integer.valueOf(1));
                h hVar = new h();
                hVar.field_content = cgVar.field_content;
                hVar.field_createtime = bi.Wx();
                hVar.field_imgpath = "";
                hVar.field_sayhicontent = ad.getContext().getString(R.l.exM);
                hVar.field_sayhiuser = cgVar.field_talker;
                hVar.field_scene = 18;
                if (cgVar.field_status > 3) {
                    i = cgVar.field_status;
                }
                hVar.field_status = i;
                hVar.field_svrid = cgVar.field_msgSvrId;
                hVar.field_talker = cgVar.field_talker;
                hVar.field_type = 34;
                hVar.field_isSend = 0;
                hVar.field_sayhiencryptuser = cgVar.field_talker;
                hVar.field_ticket = bVar2.his;
                l.TF().a(hVar);
                b itVar = new it();
                itVar.fAc.fAd = cgVar.field_talker;
                a.xmy.m(itVar);
            }
            return false;
        }
    };
    private c oTF = new c<iv>() {
        {
            this.xmG = iv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iv ivVar = (iv) bVar;
            switch (ivVar.fAg.fvo) {
                case 1:
                    b.bP(ivVar.fAg.fAi, ivVar.fAg.fAj);
                    break;
                case 2:
                    b.uf(ivVar.fAg.fAj);
                    break;
                case 3:
                    ivVar.fAh.fqR = b.bfw();
                    break;
                case 4:
                    b.bfx();
                    break;
                case 5:
                    b.bfy();
                    break;
                case 6:
                    b.He(ivVar.fAg.fAi);
                    break;
                case 7:
                    iv.b bVar2 = ivVar.fAh;
                    as.Hm();
                    Long l = (Long) com.tencent.mm.y.c.Db().get(8210, null);
                    boolean z = l == null ? true : System.currentTimeMillis() > l.longValue();
                    bVar2.fqR = z;
                    break;
                default:
                    x.e("MicroMsg.SubCoreNearby", "LbsroomLogicEvent unkown opcode!");
                    break;
            }
            return false;
        }
    };
    com.tencent.mm.pluginsdk.d.c<jz> oTG = new com.tencent.mm.pluginsdk.d.c<jz>() {
        public final /* synthetic */ b a(int i, k kVar, b bVar) {
            jz jzVar = (jz) bVar;
            c cVar = (c) kVar;
            jzVar.fBW.fCc = cVar.bfz();
            jzVar.fBW.fCe = cVar.bfA();
            jzVar.fBW.fCd = cVar.bfB();
            jzVar.fBW.fvo = jzVar.fBV.fvo;
            return jzVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            jz jzVar = (jz) bVar;
            if (jzVar.fBV.fBE) {
                com.tencent.mm.pluginsdk.d.c.k(jzVar);
            } else {
                l(jzVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            jz jzVar = (jz) bVar;
            return new c(jzVar.fBV.fvo, jzVar.fBV.fBX, jzVar.fBV.fAo, jzVar.fBV.fBY, jzVar.fBV.fBZ, jzVar.fBV.fCa, jzVar.fBV.fCb);
        }

        public final int ayd() {
            return JsApiScanCode.CTRL_INDEX;
        }
    };
    com.tencent.mm.pluginsdk.d.c<ka> oTH = new com.tencent.mm.pluginsdk.d.c<ka>() {
        public final /* synthetic */ b a(int i, k kVar, b bVar) {
            ka kaVar = (ka) bVar;
            e eVar = (e) kVar;
            kaVar.fCg.fAL = ((aoz) eVar.gLB.hnR.hnY).lfj;
            ka.b bVar2 = kaVar.fCg;
            LinkedList linkedList = ((aoz) eVar.gLB.hnR.hnY).vNu;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    aox aox = (aox) it.next();
                    as.Hm();
                    com.tencent.mm.y.c.FP().fH(aox.kyG, aox.woW);
                }
            }
            bVar2.fBS = linkedList;
            return kaVar;
        }

        public final /* synthetic */ boolean a(b bVar) {
            ka kaVar = (ka) bVar;
            if (kaVar.fCf.fBE) {
                com.tencent.mm.pluginsdk.d.c.k(kaVar);
            } else {
                l(kaVar);
            }
            return false;
        }

        public final /* synthetic */ k b(b bVar) {
            return new e(((ka) bVar).fCf.fAi);
        }

        public final int ayd() {
            return 377;
        }
    };
    d oTI = new d() {
        public final b CH(String str) {
            b iqVar = new iq();
            iqVar.fzU.fpd = str;
            return iqVar;
        }

        public final j aRS() {
            return l.TF();
        }
    };
    private ar.a oTJ = new ar.a() {
        public final void a(ar arVar, com.tencent.mm.storage.x xVar) {
            if (arVar != null && xVar != null && xVar.AM()) {
                l.TF().nd(xVar.field_username);
            }
        }
    };

    public final void onAccountRelease() {
        as.Hm();
        com.tencent.mm.y.c.Ff().b(this.oTJ);
        a.xmy.c(this.oTF);
        a.xmy.c(this.leJ);
        a.xmy.c(this.oTG);
        a.xmy.c(this.oTH);
        this.oTE.dead();
    }

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        as.Hm();
        com.tencent.mm.y.c.Ff().a(this.oTJ);
        a.xmy.b(this.leJ);
        a.xmy.b(this.oTF);
        a.xmy.b(this.oTG);
        a.xmy.b(this.oTH);
        this.oTE.cfB();
    }

    public final void bt(boolean z) {
    }
}
