package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.n;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.mh;
import com.tencent.mm.f.a.tb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.product.b.h;
import com.tencent.mm.plugin.product.b.j;
import com.tencent.mm.plugin.product.b.l;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.protocal.c.ce;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.LinkedList;

public final class f implements e {
    static int itU = 0;
    Activity iTL;
    boolean pln = false;
    private boolean plo = false;
    c plp;
    private a plq;
    private com.tencent.mm.sdk.b.c plr = new com.tencent.mm.sdk.b.c<tb>() {
        {
            this.xmG = tb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            tb tbVar = (tb) bVar;
            if (tbVar instanceof tb) {
                if (tbVar.fMn.result != -1) {
                    x.i("MicroMsg.MallProductUI", "MallProduct pay result : cancel");
                } else if (!f.this.plo) {
                    x.i("MicroMsg.MallProductUI", "MallProduct pay result : ok");
                    f.this.bjT();
                    f.this.plo = true;
                }
                return true;
            }
            x.f("MicroMsg.MallProductUI", "mismatched event");
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.product.ui.f$1 */
    class AnonymousClass1 implements com.tencent.mm.sdk.platformtools.ah.a {
        final /* synthetic */ m pls;
        private volatile int result;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(Intent intent, m mVar) {
            this.val$intent = intent;
            this.pls = mVar;
        }

        public final boolean JH() {
            this.result = f.a(f.this, this.val$intent, this.pls);
            return true;
        }

        public final boolean JI() {
            switch (this.result) {
                case -1:
                    if (f.this.plq != null) {
                        f.this.plq.m(0, -1, f.this.iTL.getString(i.uRX));
                        break;
                    }
                    break;
                case 0:
                    if (f.this.plq != null) {
                        f.this.plq.m(0, 0, "");
                        break;
                    }
                    break;
            }
            return true;
        }

        public final String toString() {
            return super.toString() + "|initData";
        }
    }

    public interface a {
        void m(int i, int i2, String str);
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.f$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ mh plu;

        AnonymousClass2(mh mhVar) {
            this.plu = mhVar;
        }

        public final void run() {
            x.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", Integer.valueOf(this.plu.fEP.errCode), Boolean.valueOf(this.plu.fEP.fEQ));
            if (this.plu.fEP.errCode == 0) {
                c c = f.this.plp;
                mh mhVar = this.plu;
                ce ceVar = new ce();
                ceVar.kyG = mhVar.fEP.userName;
                ceVar.vOc = mhVar.fEP.fES;
                ceVar.vOd = mhVar.fEP.fET;
                ceVar.hxf = mhVar.fEP.fEU;
                ceVar.hxg = mhVar.fEP.fEV;
                ceVar.hxn = mhVar.fEP.fEW;
                ceVar.nlZ = mhVar.fEP.fEX;
                if (!(bi.oN(ceVar.kyG) || bi.oN(ceVar.vOc))) {
                    c.pjy = ceVar;
                }
            }
            f.this.pln = false;
        }
    }

    static /* synthetic */ int a(f fVar, Intent intent, m mVar) {
        itU = intent.getIntExtra("key_product_scene", 3);
        String stringExtra = intent.getStringExtra("key_product_info");
        String stringExtra2 = intent.getStringExtra("key_product_id");
        String stringExtra3 = intent.getStringExtra("key_source_url");
        c cVar = fVar.plp;
        if (!bi.oN(stringExtra3)) {
            cVar.pjv = stringExtra3;
        }
        int i = -2;
        x.i("MicroMsg.MallProductUI", "Scene : " + itU);
        switch (itU) {
            case 1:
            case 2:
            case 4:
                if (!bi.oN(stringExtra)) {
                    mVar = m.b(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.plp.a(mVar, null);
                    stringExtra2 = mVar.pjS;
                    i = 0;
                    break;
                }
                break;
            case 3:
                if (!bi.oN(stringExtra)) {
                    mVar = m.a(mVar, stringExtra);
                    if (mVar == null) {
                        i = -1;
                        break;
                    }
                    fVar.plp.a(mVar, null);
                    stringExtra2 = mVar.pjS;
                    i = 0;
                    break;
                }
                break;
        }
        if (bi.oN(stringExtra2)) {
            return -1;
        }
        g.Dr();
        g.Dp().gRu.a(new h(mVar, stringExtra2), 0);
        return i;
    }

    public f(Activity activity, a aVar) {
        this.iTL = activity;
        com.tencent.mm.plugin.product.a.a.bjs();
        this.plp = com.tencent.mm.plugin.product.a.a.bjt();
        this.plq = aVar;
    }

    public final void onStart() {
        g.Dr();
        g.Dp().gRu.a(553, (e) this);
        g.Dr();
        g.Dp().gRu.a(554, (e) this);
        g.Dr();
        g.Dp().gRu.a(555, (e) this);
        g.Dr();
        g.Dp().gRu.a(556, (e) this);
        g.Dr();
        g.Dp().gRu.a(557, (e) this);
        g.Dr();
        g.Dp().gRu.a(578, (e) this);
        g.Dr();
        g.Dp().gRu.a(579, (e) this);
    }

    public final void onStop() {
        g.Dr();
        g.Dp().gRu.b(553, (e) this);
        g.Dr();
        g.Dp().gRu.b(554, (e) this);
        g.Dr();
        g.Dp().gRu.b(555, (e) this);
        g.Dr();
        g.Dp().gRu.b(556, (e) this);
        g.Dr();
        g.Dp().gRu.b(557, (e) this);
        g.Dr();
        g.Dp().gRu.b(578, (e) this);
        g.Dr();
        g.Dp().gRu.b(579, (e) this);
    }

    public final void bjS() {
        m mVar = this.plp.pjs;
        b cgVar = new cg();
        vn vnVar = new vn();
        vt vtVar = new vt();
        vm vmVar = new vm();
        vtVar.UN(q.FY());
        vtVar.UO(q.FY());
        vtVar.Dl(11);
        vtVar.fD(bi.Wy());
        vmVar.UG(mVar.pjW.name);
        vmVar.UH(this.plp.bjM());
        vmVar.Di(mVar.pjT);
        vmVar.UJ(this.plp.a(mVar));
        vmVar.UI(mVar.bjO());
        cgVar.frk.title = mVar.pjW.name;
        cgVar.frk.desc = this.plp.bjM();
        cgVar.frk.frm = vnVar;
        cgVar.frk.type = 11;
        vnVar.a(vtVar);
        vnVar.b(vmVar);
        cgVar.frk.activity = this.iTL;
        cgVar.frk.frr = 5;
        com.tencent.mm.sdk.b.a.xmy.m(cgVar);
    }

    private void bjT() {
        d bju = com.tencent.mm.plugin.product.a.a.bjs().bju();
        bcn bjA = this.plp.bjA();
        if (!(bjA == null || bi.oN(bjA.nlZ) || bjA.nlZ.contains(";"))) {
            bju.pjK.remove(bjA.nlZ);
            bju.pjK.add(bjA.nlZ);
            bju.bjN();
        }
        Intent intent = new Intent(this.iTL, MallProductUI.class);
        intent.putExtra("key_go_finish", true);
        intent.addFlags(67108864);
        this.iTL.startActivity(intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.MallProductUI", "errCode: " + i2 + ", errMsg: " + str);
        h hVar;
        c cVar;
        String str2;
        LinkedList linkedList;
        if (i != 0 || i2 != 0) {
            switch (i2) {
                case -10010003:
                    x.i("MicroMsg.MallProductUI", "deal with MMBIZPAY_FUNC_ERR_NO_EXISTED_PRODUCT");
                    if (kVar instanceof h) {
                        hVar = (h) kVar;
                        this.plp.a(hVar.pjO, hVar.pjP);
                        if (this.plq != null) {
                            this.plq.m(i, i2, str);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    x.i("MicroMsg.MallProductUI", "unkown errCode " + i2);
                    if (bi.oN(str)) {
                        str = i2 + " : " + this.iTL.getString(i.uRX);
                    }
                    if (this.plq != null) {
                        this.plq.m(i, i2, str);
                        return;
                    }
                    return;
            }
        } else if (kVar instanceof h) {
            hVar = (h) kVar;
            this.plp.a(hVar.pjO, hVar.pjP);
            if (this.plq != null) {
                this.plq.m(i, i2, str);
            }
            if (bi.oN(hVar.pjO.pjS)) {
                com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE, this.plp.bjB(), hVar.pjN, Integer.valueOf(itU), Integer.valueOf(1));
                return;
            }
            com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE, this.plp.bjB(), hVar.pjO.pjS, Integer.valueOf(itU), Integer.valueOf(1));
        } else if (kVar instanceof j) {
            j jVar = (j) kVar;
            cVar = this.plp;
            str2 = jVar.pju;
            linkedList = jVar.pjF;
            LinkedList linkedList2 = jVar.pjG;
            cVar.pju = str2;
            cVar.pjG = linkedList2;
            cVar.pjF = linkedList;
            cVar.uU(0);
            this.iTL.startActivity(new Intent(this.iTL, MallProductSubmitUI.class));
            com.tencent.mm.plugin.report.service.g.pWK.h(11009, this.plp.bjB(), this.plp.pjs.pjS, Integer.valueOf(itU), Integer.valueOf(1));
        } else if (!(kVar instanceof com.tencent.mm.plugin.product.b.f)) {
            if (kVar instanceof l) {
                str2 = ((l) kVar).pjR;
                int i3 = 6;
                if (itU == 7) {
                    i3 = 1001;
                }
                x.d("MicroMsg.MallProductUI", "payScene:" + i3);
                com.tencent.mm.pluginsdk.wallet.h.a(this.iTL, str2, this.plp.getAppId(), i3, 3);
                com.tencent.mm.sdk.b.a.xmy.b(this.plr);
            } else if (kVar instanceof com.tencent.mm.plugin.product.b.k) {
                com.tencent.mm.ui.base.h.bu(this.iTL, this.iTL.getString(i.uSh));
                bjT();
            } else if (kVar instanceof com.tencent.mm.plugin.product.b.g) {
                try {
                    this.iTL.dismissDialog(-10002);
                } catch (Exception e) {
                    x.e("MicroMsg.MallProductUI", e.toString());
                }
                cVar = this.plp;
                cVar.pjF = ((com.tencent.mm.plugin.product.b.g) kVar).pjF;
                cVar.uU(0);
            } else if (kVar instanceof com.tencent.mm.plugin.product.b.i) {
                try {
                    this.iTL.dismissDialog(-10002);
                } catch (Exception e2) {
                    x.e("MicroMsg.MallProductUI", e2.toString());
                }
                com.tencent.mm.plugin.product.b.i iVar = (com.tencent.mm.plugin.product.b.i) kVar;
                cVar = this.plp;
                str2 = iVar.mUrl;
                linkedList = iVar.pjQ;
                if (!(bi.oN(str2) || linkedList == null || linkedList.size() <= 0)) {
                    if (cVar.pjJ == null) {
                        cVar.pjJ = new HashMap();
                    }
                    cVar.pjJ.put(str2, linkedList);
                }
                if (this.plq != null) {
                    this.plq.m(i, i2, str);
                }
            }
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    this.plp.S(intent);
                    if (this.plq != null) {
                        this.plq.m(0, 0, "");
                    }
                    g.Dr();
                    n nVar = g.Dp().gRu;
                    c cVar = this.plp;
                    nVar.a(new com.tencent.mm.plugin.product.b.g(cVar.pjs != null ? cVar.pjs.pjS : "", this.plp.pju, this.plp.pjy), 0);
                    return;
                }
                return;
            case 2:
                if (i2 == -1 && intent != null) {
                    this.plp.S(intent);
                    g.Dr();
                    g.Dp().gRu.a(new j(this.plp.bjI(), itU), 0);
                    return;
                }
                return;
            case 3:
                b tbVar = new tb();
                tbVar.fMn.result = i;
                tbVar.fMn.intent = intent;
                this.plr.a(tbVar);
                return;
            case 4:
                if (this.plq != null) {
                    this.plq.m(0, 0, "");
                    return;
                }
                return;
            case 10000:
                this.iTL.showDialog(-10002);
                g.Dr();
                g.Dp().gRu.a(new com.tencent.mm.plugin.product.b.i(this.plp.pju, this.plp.pjB), 0);
                return;
            default:
                return;
        }
    }
}
