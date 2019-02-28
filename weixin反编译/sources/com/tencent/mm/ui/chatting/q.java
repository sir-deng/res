package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.viewitems.b;
import com.tencent.mm.ui.o;
import com.tencent.mm.x.h;
import com.tencent.mm.x.m;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public final class q extends o<au> implements e, com.tencent.mm.modelvideo.s.a, com.tencent.mm.pluginsdk.model.app.j.a {
    private static HashMap<String, com.tencent.mm.pluginsdk.ui.e> yCj = new HashMap();
    r.e AJd;
    boolean ffS;
    private int fzQ;
    public int hLP;
    public String hnt;
    public long kMn;
    ag lKV;
    public c liE;
    public int ljs;
    private LayoutInflater ntf;
    private short[] osV;
    public com.tencent.mm.pluginsdk.ui.e pGD;
    public String talker;
    private boolean vus;
    public com.tencent.mm.ui.chatting.ChattingUI.a yAN;
    private final int yBA;
    private final int yBB;
    public f yBC;
    f yBD;
    public r.e yBE;
    public l yBF;
    l yBG;
    public a yBH;
    a yBI;
    public c yBJ;
    c yBK;
    private long yBL;
    private long yBM;
    private long yBN;
    private int yBO;
    private int yBP;
    boolean yBQ;
    boolean yBR;
    private boolean yBS;
    public boolean yBT;
    boolean yBU;
    boolean yBV;
    boolean yBW;
    public TreeSet<Long> yBX;
    public long yBY;
    public Map<Long, View> yBZ;
    public long yBw;
    private HashSet<Long> yBx;
    public d yBy;
    String yBz;
    public Map<Long, Integer> yCa;
    private Map<Long, Long> yCb;
    private ArrayList<b> yCc;
    public au yCd;
    private boolean yCe;
    private boolean yCf;
    public boolean yCg;
    protected com.tencent.mm.plugin.messenger.foundation.a.a.c.a yCh;
    OnClickListener yCi;
    f yyB;

    class a implements OnClickListener {
        a() {
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof com.tencent.mm.ui.chatting.viewitems.c.f) {
                com.tencent.mm.ui.chatting.viewitems.c.f fVar = (com.tencent.mm.ui.chatting.viewitems.c.f) view.getTag();
                long j = fVar.frh;
                com.tencent.mm.au.a.a aVar;
                String valueOf;
                String str;
                if (fVar.ySy == -1) {
                    boolean z;
                    int g;
                    com.tencent.mm.modelstat.b bVar;
                    au auVar;
                    as.Hm();
                    cg dI = com.tencent.mm.y.c.Fh().dI(fVar.frh);
                    if (Jk(String.valueOf(j))) {
                        g.pWK.k(10231, "1");
                        com.tencent.mm.au.b.Qv();
                        if (dI.field_msgId == j) {
                            com.tencent.mm.modelstat.b bVar2 = com.tencent.mm.modelstat.b.hRo;
                            z = false;
                            g = h.g(dI);
                            bVar = bVar2;
                            auVar = dI;
                        }
                    } else {
                        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(fVar.fDn);
                        if (fV != null) {
                            g.pWK.k(10090, "0,1");
                            aVar = (com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class);
                            valueOf = String.valueOf(fVar.frh);
                            str = fVar.fAn;
                            as.Hm();
                            com.tencent.mm.au.b.b(aVar.a(fV, valueOf, str, com.tencent.mm.y.c.FJ(), fVar.fAn));
                        }
                        if (dI.field_msgId == j) {
                            bVar = com.tencent.mm.modelstat.b.hRo;
                            cg auVar2;
                            if (fV != null) {
                                g = fV.type;
                                z = true;
                                auVar2 = dI;
                            } else {
                                g = 0;
                                z = true;
                                auVar2 = dI;
                            }
                        }
                    }
                    bVar.a(auVar2, z, g);
                } else {
                    String str2 = fVar.frh + "_" + fVar.ySy;
                    as.Hm();
                    cg dI2 = com.tencent.mm.y.c.Fh().dI(fVar.frh);
                    com.tencent.mm.x.l wr = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.biz.a.a.class)).wr(fVar.fDn);
                    g gVar;
                    Object[] objArr;
                    if (Jk(str2)) {
                        g.pWK.k(10231, "1");
                        com.tencent.mm.au.b.Qv();
                        if (dI2.field_msgId == j) {
                            com.tencent.mm.modelstat.b.hRo.a((au) dI2, false, h.g(dI2));
                        }
                        if (!(wr == null || wr.hfI == null || wr.hfI.size() <= fVar.ySy)) {
                            m mVar = (m) wr.hfI.get(fVar.ySy);
                            gVar = g.pWK;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(mVar.type == 6 ? 1 : 0);
                            objArr[1] = Integer.valueOf(1);
                            gVar.h(14972, objArr);
                        }
                    } else {
                        if (!(wr == null || wr.hfI == null || wr.hfI.size() <= fVar.ySy)) {
                            g.pWK.k(10090, "0,1");
                            m mVar2 = (m) wr.hfI.get(fVar.ySy);
                            aVar = (com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class);
                            valueOf = fVar.fAn;
                            str = mVar2.title;
                            String str3 = mVar2.hgc;
                            String str4 = mVar2.url;
                            String str5 = mVar2.url;
                            String str6 = mVar2.hgb;
                            as.Hm();
                            com.tencent.mm.au.b.b(aVar.a(0, valueOf, str, str3, str4, str5, str6, str2, com.tencent.mm.y.c.FJ(), fVar.fAn, "", ""));
                            gVar = g.pWK;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(mVar2.type == 6 ? 1 : 0);
                            objArr[1] = Integer.valueOf(0);
                            gVar.h(14972, objArr);
                        }
                        if (dI2.field_msgId == j) {
                            com.tencent.mm.modelstat.b.hRo.a((au) dI2, true, h.g(dI2));
                        }
                    }
                }
                q.this.yAN.yAM.notifyDataSetChanged();
            }
        }

        private static boolean Jk(String str) {
            ati Qz = com.tencent.mm.au.b.Qz();
            if (Qz == null || Qz.wdd == null || Qz.wHt != 0 || !com.tencent.mm.au.b.Qx()) {
                return false;
            }
            try {
                if (bi.fA(Qz.wdd, str)) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
    }

    static /* synthetic */ void a(q qVar, k kVar) {
        int lastIndexOf;
        LinkedList linkedList = new LinkedList();
        if (s.eX(qVar.talker)) {
            lastIndexOf = kVar.url.lastIndexOf("/");
            if (lastIndexOf >= 0) {
                linkedList.add(kVar.url.substring(lastIndexOf + 1));
            } else {
                return;
            }
        }
        linkedList.add(qVar.talker);
        LinkedList linkedList2 = new LinkedList();
        for (lastIndexOf = 0; lastIndexOf < linkedList.size(); lastIndexOf++) {
            linkedList2.add(Integer.valueOf(6));
        }
        new com.tencent.mm.pluginsdk.ui.applet.q(qVar.yAN.getContext(), new com.tencent.mm.pluginsdk.ui.applet.q.a() {
            public final void ep(boolean z) {
            }
        }).g(linkedList, linkedList2);
    }

    public q(final com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar, final String str) {
        super(aVar.getContext(), auVar);
        this.yBw = -1;
        this.ffS = true;
        this.yBx = new HashSet();
        this.yBL = -1;
        this.yBM = -1;
        this.yBN = -1;
        this.yBO = 0;
        this.yBP = 0;
        this.yBQ = false;
        this.yBR = false;
        this.yBS = false;
        this.yBT = false;
        this.yBU = false;
        this.yBV = false;
        this.yBW = false;
        this.yBY = -1;
        this.yCc = new ArrayList();
        this.yCd = new au();
        this.vus = false;
        this.yCe = false;
        this.yCf = false;
        this.yCg = false;
        this.yCh = new com.tencent.mm.plugin.messenger.foundation.a.a.c.a() {
            public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
                if (cVar != null && cVar2 != null && cVar2.talker != null && q.this.talker != null && cVar2.talker.equals(q.this.talker)) {
                    q.this.csz();
                }
            }
        };
        this.yCi = null;
        this.pGD = null;
        this.liE = null;
        this.yBY = -1;
        this.yAN = aVar;
        this.fzQ = com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX;
        this.yBA = aVar.getResources().getDimensionPixelSize(R.f.bvW);
        this.yBB = aVar.getResources().getDimensionPixelSize(R.f.bvA);
        this.yyB = new f() {
            public final Object a(k kVar) {
                i.CU(6);
                switch (kVar.type) {
                    case 1:
                        return q.this.yBz;
                    case 2:
                    case 6:
                    case 7:
                    case 9:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        aVar.finish();
                        break;
                    case 4:
                        q.a(q.this, kVar);
                        break;
                    case 25:
                    case 30:
                    case 31:
                        return q.this.yBz;
                }
                return null;
            }

            public final Object b(k kVar) {
                switch (kVar.type) {
                    case org.xwalk.core.R.styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                        if (!(as.Hp() && (com.tencent.mm.af.f.eG(str) || com.tencent.mm.af.f.ka(str) || com.tencent.mm.af.f.jZ(str)))) {
                            x.i("MicroMsg.ChattingListAdapter", "appId:%s,path:%s", new String(Base64.decode(kVar.url, 0)), new String(Base64.decode(bi.aD((String) kVar.A(String.class), ""), 0)));
                            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                            appBrandStatObject.scene = 1082;
                            appBrandStatObject.foi = str;
                            ((d) com.tencent.mm.kernel.g.h(d.class)).a(aVar.getContext(), null, r3, 0, 0, r6, appBrandStatObject);
                            break;
                        }
                }
                return null;
            }
        };
        f fVar = new f();
        this.yBD = fVar;
        this.yBC = fVar;
        r.e eVar = new r.e(aVar);
        this.AJd = eVar;
        this.yBE = eVar;
        l lVar = new l(aVar.getContext());
        this.yBG = lVar;
        this.yBF = lVar;
        a aVar2 = new a();
        this.yBI = aVar2;
        this.yBH = aVar2;
        c cVar = new c(aVar);
        this.yBK = cVar;
        this.yBJ = cVar;
        Iterator it = this.yCc.iterator();
        while (it.hasNext()) {
            ((b) it.next()).yxU = aVar.yxU;
        }
        this.yBZ = new HashMap();
        this.yCa = new HashMap();
        this.yCb = new HashMap(5);
        if (this.liE == null) {
            com.tencent.mm.ap.a.a.c.a aVar3 = new com.tencent.mm.ap.a.a.c.a();
            aVar3.hFo = com.tencent.mm.af.a.e.kx(this.yAN.csn());
            aVar3.hFl = true;
            aVar3.hFI = true;
            aVar3.hFA = R.k.bBC;
            this.liE = aVar3.PQ();
        }
    }

    public final void csw() {
        if (this.yBX != null) {
            this.yBX.clear();
        }
        this.hLP = 0;
        this.ljs = -1;
        this.yBL = -1;
        this.yBM = -1;
        this.yBN = -1;
        this.yBw = -1;
        this.yBO = 0;
        this.yBP = 0;
        this.yBQ = false;
        this.yBR = false;
        this.yBS = false;
        this.yBT = false;
        this.yBW = false;
    }

    public final int r(long j, boolean z) {
        as.Hm();
        cg dI = com.tencent.mm.y.c.Fh().dI(j);
        if (dI.field_msgId != j) {
            x.w("MicroMsg.ChattingListAdapter", "get msg info by id %d error", Long.valueOf(j));
            return 0;
        }
        int n;
        long j2 = dI.field_createTime;
        if (j2 < this.yBL || j2 > this.yBM) {
            this.yBL = j2;
            this.yBN = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().Fy(this.talker);
            if (z) {
                this.yBM = this.yBN;
            } else {
                as.Hm();
                this.yBM = com.tencent.mm.y.c.Fh().W(this.talker, j2);
            }
            this.yBS = true;
            as.Hm();
            x.v("MicroMsg.ChattingListAdapter", "reset position, reload count %d", Integer.valueOf(com.tencent.mm.y.c.Fh().n(this.talker, this.yBL, this.yBM)));
            if (com.tencent.mm.y.c.Fh().n(this.talker, this.yBL, this.yBM) < 18) {
                x.d("MicroMsg.ChattingListAdapter", "reload count less than on scene, bottom not more data, try up to load more data, and reset selection, old top msg create time %d, old selection %d", Long.valueOf(this.yBL), Integer.valueOf(0));
                as.Hm();
                this.yBL = com.tencent.mm.y.c.Fh().V(this.talker, this.yBL);
                as.Hm();
                n = com.tencent.mm.y.c.Fh().n(this.talker, this.yBL, j2);
            } else {
                n = 0;
            }
        } else {
            as.Hm();
            n = com.tencent.mm.y.c.Fh().n(this.talker, this.yBL, j2);
        }
        x.v("MicroMsg.ChattingListAdapter", "set local message id, id[%d] top create time[%d] bottom create time[%d] last create time[%d] selection[%d]", Long.valueOf(j), Long.valueOf(this.yBL), Long.valueOf(this.yBM), Long.valueOf(this.yBN), Integer.valueOf(n));
        return n;
    }

    public static au a(au auVar, Cursor cursor) {
        if (auVar == null) {
            auVar = new au();
        }
        auVar.b(cursor);
        return auVar;
    }

    public final boolean csx() {
        if (this.yBS) {
            this.yBN = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().Fy(this.talker);
            if (this.yBN >= this.yBM) {
                this.yBM = this.yBN;
                XH();
                return true;
            }
        }
        return false;
    }

    protected final void XI() {
        as.Hm();
        setCursor(com.tencent.mm.y.c.Fh().aZY());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void XH() {
        /*
        r14 = this;
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.FQ();
        r1 = r14.talker;
        r2 = r0.EY(r1);
        r0 = r14.kMn;
        r4 = -1;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00ea;
    L_0x001a:
        r0 = r14.yAN;
        r0 = r0.yEL;
        r0 = r0.vus;
        if (r0 == 0) goto L_0x00ea;
    L_0x0022:
        r0 = 1;
        r14.vus = r0;
    L_0x0025:
        r0 = r14.yBS;
        if (r0 != 0) goto L_0x0437;
    L_0x0029:
        r0 = r14.vus;
        if (r0 == 0) goto L_0x00ef;
    L_0x002d:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r4 = r14.kMn;
        r0 = r0.as(r1, r4);
        r14.hLP = r0;
    L_0x003e:
        r0 = 0;
        r1 = r14.ljs;
        if (r1 < 0) goto L_0x0049;
    L_0x0043:
        r1 = r14.ljs;
        r4 = r14.hLP;
        if (r1 <= r4) goto L_0x0050;
    L_0x0049:
        r0 = 1;
        r1 = r14.hLP;
        r1 = r1 + -18;
        r14.ljs = r1;
    L_0x0050:
        r1 = "MicroMsg.ChattingListAdapter";
        r4 = "summerbadcr summerdel resetCursor restart:%b fromCount:%d totalcount:%d limit:%d, talker:%s isBizChat:%b, createTime:%s";
        r5 = 7;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Boolean.valueOf(r0);
        r5[r6] = r7;
        r6 = 1;
        r7 = r14.ljs;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 2;
        r7 = r14.hLP;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 3;
        r7 = r14.hLP;
        r8 = r14.ljs;
        r7 = r7 - r8;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 4;
        r7 = r14.talker;
        r5[r6] = r7;
        r6 = 5;
        r7 = r14.vus;
        r7 = java.lang.Boolean.valueOf(r7);
        r5[r6] = r7;
        r6 = 6;
        r7 = java.lang.Long.valueOf(r2);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        r1 = r14.vus;
        if (r1 == 0) goto L_0x0100;
    L_0x009a:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r2 = r14.kMn;
        r4 = r14.hLP;
        r5 = r14.ljs;
        r4 = r4 - r5;
        r4 = r0.i(r1, r2, r4);
    L_0x00ae:
        if (r4 == 0) goto L_0x00b6;
    L_0x00b0:
        r0 = r4.isClosed();
        if (r0 == 0) goto L_0x03eb;
    L_0x00b6:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "update pos fail, cursor is null";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
    L_0x00bf:
        r14.setCursor(r4);
    L_0x00c2:
        r0 = r14.getCount();
        if (r0 <= 0) goto L_0x00cc;
    L_0x00c8:
        r0 = new short[r0];
        r14.osV = r0;
    L_0x00cc:
        r0 = r14.yBZ;
        r0.clear();
        r0 = r14.yCa;
        r0.clear();
        r0 = r14.yCb;
        r0.clear();
        super.notifyDataSetChanged();
        r0 = r14.yBV;
        if (r0 == 0) goto L_0x00e9;
    L_0x00e2:
        r0 = com.tencent.mm.be.l.TF();
        r0.Tz();
    L_0x00e9:
        return;
    L_0x00ea:
        r0 = 0;
        r14.vus = r0;
        goto L_0x0025;
    L_0x00ef:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r0 = r0.Fs(r1);
        r14.hLP = r0;
        goto L_0x003e;
    L_0x0100:
        r1 = r14.yAN;
        r1 = r1.yAR;
        if (r1 != 0) goto L_0x0119;
    L_0x0106:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r4 = r14.hLP;
        r5 = r14.ljs;
        r4 = r4 - r5;
        r4 = r0.f(r1, r4, r2);
        goto L_0x00ae;
    L_0x0119:
        com.tencent.mm.y.as.Hm();
        r1 = com.tencent.mm.y.c.Fh();
        r4 = r14.talker;
        r5 = r14.hLP;
        r6 = r14.ljs;
        r5 = r5 - r6;
        r4 = r1.f(r4, r5, r2);
        r1 = r14.yAN;
        r1 = r1.yEw;
        r1 = r1.yJU;
        if (r1 == 0) goto L_0x00ae;
    L_0x0133:
        if (r4 != 0) goto L_0x01ea;
    L_0x0135:
        r1 = -1;
    L_0x0136:
        r2 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr resetCursor check fault count[%d], talker[%s]";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r1);
        r5[r6] = r7;
        r6 = 1;
        r7 = r14.talker;
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r5);
        if (r1 <= 0) goto L_0x00ae;
    L_0x0150:
        if (r0 == 0) goto L_0x01f0;
    L_0x0152:
        r1 = r4.moveToLast();
        if (r1 == 0) goto L_0x01f6;
    L_0x0158:
        r5 = 1;
        r6 = java.lang.System.currentTimeMillis();
        com.tencent.mm.y.as.Hm();
        r1 = com.tencent.mm.y.c.Fk();
        r2 = r14.talker;
        r1 = r1.XF(r2);
        if (r1 != 0) goto L_0x01f8;
    L_0x016c:
        r1 = 0;
    L_0x016d:
        r2 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr revisedCursor check fault first/last seq[%d], restart[%b], undeliver[%d]";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "msgSeq";
        r10 = r4.getColumnIndex(r10);
        r10 = r4.getInt(r10);
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = java.lang.Boolean.valueOf(r0);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.Integer.valueOf(r1);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r8);
        r2 = 0;
    L_0x019a:
        r3 = "flag";
        r3 = r4.getColumnIndex(r3);
        r3 = r4.getInt(r3);
        r8 = r3 & 2;
        if (r8 != 0) goto L_0x01fc;
    L_0x01a9:
        r8 = "isSend";
        r8 = r4.getColumnIndex(r8);
        r8 = r4.getInt(r8);
        if (r8 == 0) goto L_0x01fc;
    L_0x01b6:
        r2 = r2 + 1;
    L_0x01b8:
        if (r0 == 0) goto L_0x03e3;
    L_0x01ba:
        r3 = r4.moveToPrevious();
        if (r3 != 0) goto L_0x019a;
    L_0x01c0:
        r1 = r5;
        r0 = r4;
    L_0x01c2:
        if (r1 == 0) goto L_0x01e4;
    L_0x01c4:
        r1 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr resetCursor check fault traversal all not found take time[%d]ms, cursor index:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r8 = java.lang.System.currentTimeMillis();
        r6 = r8 - r6;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r2 = java.lang.Integer.valueOf(r2);
        r4[r5] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
    L_0x01e4:
        r1 = 0;
        r14.yBW = r1;
        r4 = r0;
        goto L_0x00ae;
    L_0x01ea:
        r1 = r4.getCount();
        goto L_0x0136;
    L_0x01f0:
        r1 = r4.moveToFirst();
        if (r1 != 0) goto L_0x0158;
    L_0x01f6:
        r0 = r4;
        goto L_0x01e4;
    L_0x01f8:
        r1 = r1.field_UnDeliverCount;
        goto L_0x016d;
    L_0x01fc:
        if (r1 != 0) goto L_0x0285;
    L_0x01fe:
        r8 = r3 & 2;
        if (r8 != 0) goto L_0x0285;
    L_0x0202:
        r3 = "type";
        r3 = r4.getColumnIndex(r3);
        r3 = r4.getInt(r3);
        r8 = 50;
        if (r3 > r8) goto L_0x0213;
    L_0x0211:
        if (r3 >= 0) goto L_0x0216;
    L_0x0213:
        r2 = r2 + 1;
        goto L_0x01b8;
    L_0x0216:
        r0 = r14.yAN;
        r0 = r0.yEw;
        r1 = 0;
        r0.yJU = r1;
        r0 = new com.tencent.mm.storage.au;
        r0.<init>();
        r0.b(r4);
        r4.moveToFirst();
        r1 = "MicroMsg.ChattingListAdapter";
        r3 = "summerbadcr revisedCursor check fault but not needCheckFault more break[%d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d";
        r5 = 8;
        r5 = new java.lang.Object[r5];
        r8 = 0;
        r9 = r0.field_flag;
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        r8 = 1;
        r9 = r0.field_isSend;
        r9 = java.lang.Integer.valueOf(r9);
        r5[r8] = r9;
        r8 = 2;
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 3;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 4;
        r10 = r0.field_msgSeq;
        r9 = java.lang.Long.valueOf(r10);
        r5[r8] = r9;
        r8 = 5;
        r0 = r0.getType();
        r0 = java.lang.Integer.valueOf(r0);
        r5[r8] = r0;
        r0 = 6;
        r8 = java.lang.System.currentTimeMillis();
        r8 = r8 - r6;
        r8 = java.lang.Long.valueOf(r8);
        r5[r0] = r8;
        r0 = 7;
        r8 = java.lang.Integer.valueOf(r2);
        r5[r0] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r5);
        r0 = 0;
        r1 = r0;
        r0 = r4;
        goto L_0x01c2;
    L_0x0285:
        r8 = r3 & 1;
        if (r8 != 0) goto L_0x028d;
    L_0x0289:
        r2 = r2 + 1;
        goto L_0x01b8;
    L_0x028d:
        if (r2 != 0) goto L_0x029c;
    L_0x028f:
        r2 = r2 + 1;
        r3 = "MicroMsg.ChattingListAdapter";
        r8 = "summerbadcr revisedCursor check fault index == 0 continue";
        com.tencent.mm.sdk.platformtools.x.i(r3, r8);
        goto L_0x01b8;
    L_0x029c:
        r3 = r3 & 4;
        if (r3 == 0) goto L_0x034d;
    L_0x02a0:
        r3 = 1;
    L_0x02a1:
        r8 = new com.tencent.mm.storage.au;
        r8.<init>();
        r8.b(r4);
        if (r0 == 0) goto L_0x03a7;
    L_0x02ab:
        if (r3 == 0) goto L_0x0350;
    L_0x02ad:
        r4.close();
        r0 = r14.hLP;
        r0 = r0 - r2;
        r0 = r0 + -1;
        r14.ljs = r0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r4 = r14.hLP;
        r5 = r14.ljs;
        r4 = r4 - r5;
        r10 = 0;
        r0 = r0.f(r1, r4, r10);
    L_0x02cb:
        r4 = "MicroMsg.ChattingListAdapter";
        r5 = "summerbadcr revisedCursor check fault faultUp[%b]  break[%d, %d, %d, %d, %d, %d, %d] take time[%d]ms, cursor index:%d, nowCount:%d, fromCount:%d";
        r1 = 12;
        r9 = new java.lang.Object[r1];
        r1 = 0;
        r3 = java.lang.Boolean.valueOf(r3);
        r9[r1] = r3;
        r1 = 1;
        r3 = r8.field_flag;
        r3 = java.lang.Integer.valueOf(r3);
        r9[r1] = r3;
        r1 = 2;
        r3 = r8.field_isSend;
        r3 = java.lang.Integer.valueOf(r3);
        r9[r1] = r3;
        r1 = 3;
        r10 = r8.field_msgId;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 4;
        r10 = r8.field_msgSvrId;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 5;
        r10 = r8.field_msgSeq;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 6;
        r3 = r8.getType();
        r3 = java.lang.Integer.valueOf(r3);
        r9[r1] = r3;
        r1 = 7;
        r10 = r8.field_createTime;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 8;
        r10 = java.lang.System.currentTimeMillis();
        r10 = r10 - r6;
        r3 = java.lang.Long.valueOf(r10);
        r9[r1] = r3;
        r1 = 9;
        r3 = java.lang.Integer.valueOf(r2);
        r9[r1] = r3;
        r3 = 10;
        if (r0 != 0) goto L_0x03dd;
    L_0x0336:
        r1 = -1;
    L_0x0337:
        r1 = java.lang.Integer.valueOf(r1);
        r9[r3] = r1;
        r1 = 11;
        r3 = r14.ljs;
        r3 = java.lang.Integer.valueOf(r3);
        r9[r1] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r9);
        r1 = 0;
        goto L_0x01c2;
    L_0x034d:
        r3 = 0;
        goto L_0x02a1;
    L_0x0350:
        r9 = "MicroMsg.ChattingListAdapter";
        r10 = "summerbadcr revisedCursor check fault faultUp[%s] upLoadMore[%s] but restart continue[%s, %s, %s, %s, %s, %s]";
        r11 = 8;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r3 = java.lang.Boolean.valueOf(r3);
        r11[r12] = r3;
        r3 = 1;
        r12 = r14.yBW;
        r12 = java.lang.Boolean.valueOf(r12);
        r11[r3] = r12;
        r3 = 2;
        r12 = r8.field_flag;
        r12 = java.lang.Integer.valueOf(r12);
        r11[r3] = r12;
        r3 = 3;
        r12 = r8.field_isSend;
        r12 = java.lang.Integer.valueOf(r12);
        r11[r3] = r12;
        r3 = 4;
        r12 = r8.field_msgId;
        r12 = java.lang.Long.valueOf(r12);
        r11[r3] = r12;
        r3 = 5;
        r12 = r8.field_msgSvrId;
        r12 = java.lang.Long.valueOf(r12);
        r11[r3] = r12;
        r3 = 6;
        r12 = r8.field_msgSeq;
        r12 = java.lang.Long.valueOf(r12);
        r11[r3] = r12;
        r3 = 7;
        r8 = r8.getType();
        r8 = java.lang.Integer.valueOf(r8);
        r11[r3] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r9, r10, r11);
        goto L_0x01b8;
    L_0x03a7:
        r4.close();
        if (r3 == 0) goto L_0x03c7;
    L_0x03ac:
        r0 = r14.ljs;
        r0 = r0 + r2;
        r14.ljs = r0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r4 = r14.hLP;
        r5 = r14.ljs;
        r4 = r4 - r5;
        r10 = 0;
        r0 = r0.f(r1, r4, r10);
        goto L_0x02cb;
    L_0x03c7:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r4 = r14.hLP;
        r5 = r14.ljs;
        r4 = r4 - r5;
        r10 = r8.field_createTime;
        r0 = r0.g(r1, r4, r10);
        goto L_0x02cb;
    L_0x03dd:
        r1 = r0.getCount();
        goto L_0x0337;
    L_0x03e3:
        r3 = r4.moveToNext();
        if (r3 != 0) goto L_0x019a;
    L_0x03e9:
        goto L_0x01c0;
    L_0x03eb:
        r0 = r4.moveToLast();
        if (r0 == 0) goto L_0x03ff;
    L_0x03f1:
        r0 = r14.yCd;
        r0 = a(r0, r4);
        r14.yCd = r0;
        r0 = r14.yCd;
        r0 = r0.field_createTime;
        r14.yBM = r0;
    L_0x03ff:
        r0 = -1;
        r14.yBY = r0;
        r0 = r4.moveToFirst();
        if (r0 == 0) goto L_0x0417;
    L_0x0409:
        r0 = r14.yCd;
        r0 = a(r0, r4);
        r14.yCd = r0;
        r0 = r14.yCd;
        r0 = r0.field_createTime;
        r14.yBL = r0;
    L_0x0417:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "update pos topCreateTime[%d] downCreateTime[%d]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r6 = r14.yBL;
        r5 = java.lang.Long.valueOf(r6);
        r2[r3] = r5;
        r3 = 1;
        r6 = r14.yBM;
        r5 = java.lang.Long.valueOf(r6);
        r2[r3] = r5;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
        goto L_0x00bf;
    L_0x0437:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "topLoadMore[%B] downLoadMore[%B]";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r14.yBQ;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r14.yBR;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r14.yBQ;
        if (r0 != 0) goto L_0x049a;
    L_0x0459:
        r0 = r14.yBR;
        if (r0 != 0) goto L_0x049a;
    L_0x045d:
        r0 = r14.yBM;
        r2 = r14.yBN;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x049a;
    L_0x0465:
        r0 = r14.vus;
        if (r0 == 0) goto L_0x0585;
    L_0x0469:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r2 = r14.kMn;
        r0 = r0.av(r1, r2);
        r14.yBN = r0;
        r8 = 0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r2 = r14.kMn;
        r4 = r14.yBM;
        r6 = r14.yBN;
        r0 = r0.b(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r14.yBP = r0;
    L_0x0496:
        r0 = r14.yBN;
        r14.yBM = r0;
    L_0x049a:
        r0 = r14.yBQ;
        if (r0 == 0) goto L_0x04d2;
    L_0x049e:
        r0 = 0;
        r14.yBQ = r0;
        r0 = r14.vus;
        if (r0 == 0) goto L_0x05b5;
    L_0x04a5:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r2 = r14.kMn;
        r4 = r14.yBL;
        r4 = r0.u(r1, r2, r4);
        r8 = 0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r2 = r14.kMn;
        r6 = r14.yBL;
        r0 = r0.b(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r14.yBO = r0;
    L_0x04d0:
        r14.yBL = r4;
    L_0x04d2:
        r0 = r14.yBR;
        if (r0 == 0) goto L_0x050a;
    L_0x04d6:
        r0 = 0;
        r14.yBR = r0;
        r0 = r14.vus;
        if (r0 == 0) goto L_0x05df;
    L_0x04dd:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r2 = r14.kMn;
        r4 = r14.yBM;
        r6 = r0.v(r1, r2, r4);
        r8 = 0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r2 = r14.kMn;
        r4 = r14.yBM;
        r0 = r0.b(r1, r2, r4, r6);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r8, r0);
        r14.yBP = r0;
    L_0x0508:
        r14.yBM = r6;
    L_0x050a:
        r0 = "MicroMsg.ChattingListAdapter";
        r1 = "query topCreateTime[%d] downCreateTime[%d], lastCreateTime[%d], topInc[%d], bottomInc[%d]";
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r14.yBL;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r14.yBM;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r14.yBN;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = r14.yBO;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 4;
        r4 = r14.yBP;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.v(r0, r1, r2);
        r0 = r14.vus;
        if (r0 == 0) goto L_0x0609;
    L_0x0547:
        r8 = "MicroMsg.ChattingListAdapter";
        r9 = "count([top, down]) = %d";
        r0 = 1;
        r10 = new java.lang.Object[r0];
        r11 = 0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r2 = r14.kMn;
        r4 = r14.yBL;
        r6 = r14.yBM;
        r0 = r0.b(r1, r2, r4, r6);
        r0 = java.lang.Integer.valueOf(r0);
        r10[r11] = r0;
        com.tencent.mm.sdk.platformtools.x.v(r8, r9, r10);
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fi();
        r1 = r14.talker;
        r2 = r14.kMn;
        r4 = r14.yBL;
        r6 = r14.yBM;
        r0 = r0.c(r1, r2, r4, r6);
        r14.setCursor(r0);
        goto L_0x00c2;
    L_0x0585:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.h.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.h) r0;
        r0 = r0.aZO();
        r1 = r14.talker;
        r0 = r0.Fy(r1);
        r14.yBN = r0;
        r6 = 0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r2 = r14.yBM;
        r4 = r14.yBN;
        r0 = r0.n(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r14.yBP = r0;
        goto L_0x0496;
    L_0x05b5:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r2 = r14.yBL;
        r2 = r0.V(r1, r2);
        r6 = 0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r4 = r14.yBL;
        r0 = r0.n(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r14.yBO = r0;
        r4 = r2;
        goto L_0x04d0;
    L_0x05df:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r2 = r14.yBM;
        r4 = r0.W(r1, r2);
        r6 = 0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r2 = r14.yBM;
        r0 = r0.n(r1, r2, r4);
        r0 = r0 + -1;
        r0 = java.lang.Math.max(r6, r0);
        r14.yBP = r0;
        r6 = r4;
        goto L_0x0508;
    L_0x0609:
        r6 = "MicroMsg.ChattingListAdapter";
        r7 = "count([top, down]) = %d";
        r0 = 1;
        r8 = new java.lang.Object[r0];
        r9 = 0;
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r2 = r14.yBL;
        r4 = r14.yBM;
        r0 = r0.n(r1, r2, r4);
        r0 = java.lang.Integer.valueOf(r0);
        r8[r9] = r0;
        com.tencent.mm.sdk.platformtools.x.v(r6, r7, r8);
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Fh();
        r1 = r14.talker;
        r2 = r14.yBL;
        r4 = r14.yBM;
        r0 = r0.o(r1, r2, r4);
        r14.setCursor(r0);
        goto L_0x00c2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.q.XH():void");
    }

    public final void mM(boolean z) {
        this.yCe = z;
        if (!z) {
            this.yCg = false;
        }
        if (!z && this.yCf) {
            a(null, null);
            this.yCf = false;
        }
    }

    public final void csy() {
        unlock();
        a(null, null);
    }

    public final void unlock() {
        this.yCf = false;
        this.yCe = false;
        this.yCg = false;
    }

    protected final void csz() {
        if (this.yCg) {
            this.yCg = false;
        } else if (this.yCe) {
            this.yCf = true;
        } else if (this.talker == null) {
        } else {
            if (this.ffS) {
                super.a(null, null);
            } else {
                x.i("MicroMsg.ChattingListAdapter", "is not resumeState ");
            }
        }
    }

    public final int getItemViewType(int i) {
        return com.tencent.mm.ui.chatting.viewitems.as.bt((au) getItem(i));
    }

    public final int getViewTypeCount() {
        return com.tencent.mm.ui.chatting.viewitems.as.cws();
    }

    public final int FO(int i) {
        if (this.yBS) {
            return this.yBO;
        }
        if (i <= 0) {
            return 0;
        }
        if (this.ljs < i) {
            i = this.ljs;
            this.ljs = 0;
            return i;
        }
        this.ljs -= i;
        return i;
    }

    public final boolean csA() {
        if (this.yBS) {
            return this.yBL <= ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().Fx(this.talker);
        } else if (this.ljs <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean csB() {
        if (!this.yBS) {
            return true;
        }
        return this.yBM >= ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().Fy(this.talker);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
        /*
        r10 = this;
        r0 = r10.getItem(r11);
        r0 = (com.tencent.mm.storage.au) r0;
        r1 = "MicroMsg.ChattingListAdapter";
        r2 = "shwen getview:%d, msgId %d, svrId %d, type:%d, send:%d, talker:%s, flag:%s position:%s";
        r3 = 8;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Integer.valueOf(r11);
        r3[r4] = r5;
        r4 = 1;
        r6 = r0.field_msgId;
        r5 = java.lang.Long.valueOf(r6);
        r3[r4] = r5;
        r4 = 2;
        r6 = r0.field_msgSvrId;
        r5 = java.lang.Long.valueOf(r6);
        r3[r4] = r5;
        r4 = 3;
        r5 = r0.getType();
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 4;
        r5 = r0.field_isSend;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 5;
        r5 = r0.field_talker;
        r3[r4] = r5;
        r4 = 6;
        r5 = r0.field_flag;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 7;
        r5 = java.lang.Integer.valueOf(r11);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        if (r11 != 0) goto L_0x005c;
    L_0x0057:
        r1 = r10.yAN;
        r1.cty();
    L_0x005c:
        if (r11 == 0) goto L_0x0090;
    L_0x005e:
        r1 = r10.osV;
        r1 = r1[r11];
        if (r1 != 0) goto L_0x0090;
    L_0x0064:
        r1 = r11 + -1;
        r1 = r10.getItem(r1);
        r1 = (com.tencent.mm.storage.au) r1;
        r2 = r1.field_createTime;
        r4 = r0.field_createTime;
        r6 = r4 - r2;
        r8 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 >= 0) goto L_0x0293;
    L_0x0079:
        r1 = 1;
    L_0x007a:
        r2 = r4 - r2;
        r4 = 180000; // 0x2bf20 float:2.52234E-40 double:8.8932E-319;
        r2 = r2 / r4;
        r4 = 1;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0296;
    L_0x0086:
        r2 = 1;
    L_0x0087:
        if (r1 != 0) goto L_0x008b;
    L_0x0089:
        if (r2 == 0) goto L_0x0299;
    L_0x008b:
        r1 = r10.osV;
        r2 = 2;
        r1[r11] = r2;
    L_0x0090:
        r1 = r10.osV;
        r1 = r1[r11];
        r2 = 1;
        if (r1 == r2) goto L_0x00a7;
    L_0x0097:
        if (r11 == 0) goto L_0x00a7;
    L_0x0099:
        r1 = r10.yBx;
        r2 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r1 = r1.contains(r2);
        if (r1 == 0) goto L_0x02a0;
    L_0x00a7:
        r2 = r0.field_createTime;
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 <= 0) goto L_0x02a0;
    L_0x00af:
        r1 = 1;
        r2 = r1;
    L_0x00b1:
        r4 = r0.field_msgId;
        r6 = r10.yBw;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 != 0) goto L_0x02a4;
    L_0x00b9:
        r1 = 1;
        r4 = r1;
    L_0x00bb:
        if (r12 != 0) goto L_0x02a8;
    L_0x00bd:
        r1 = r10.ntf;
        if (r1 != 0) goto L_0x00cd;
    L_0x00c1:
        r1 = r10.yAN;
        r1 = r1.getContext();
        r1 = com.tencent.mm.ui.v.fw(r1);
        r10.ntf = r1;
    L_0x00cd:
        r3 = com.tencent.mm.ui.chatting.viewitems.as.bs(r0);
        r1 = r10.ntf;
        r12 = r3.a(r1, r12);
        r1 = r12.getTag();
        r1 = (com.tencent.mm.ui.chatting.viewitems.b.a) r1;
        r1.yRq = r3;
        r3 = r1;
    L_0x00e0:
        if (r2 == 0) goto L_0x02b1;
    L_0x00e2:
        r1 = r3.ljv;
        r2 = 0;
        r1.setVisibility(r2);
        r1 = r3.ljv;
        r2 = r10.yAN;
        r2 = r2.getContext();
        r6 = r0.field_createTime;
        r5 = 0;
        r2 = com.tencent.mm.pluginsdk.h.n.c(r2, r6, r5);
        r1.setText(r2);
        r1 = r3.ljv;
        r1 = r1.getTextSize();
        r2 = r10.yAN;
        r2 = r2.getContext();
        r5 = 25;
        r2 = com.tencent.mm.bu.a.fromDPToPix(r2, r5);
        r2 = (float) r2;
        r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r1 <= 0) goto L_0x012a;
    L_0x0111:
        r1 = "MicroMsg.ChattingListAdapter";
        r2 = "WDF!!! TextSize:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r3.ljv;
        r7 = r7.getTextSize();
        r7 = java.lang.Float.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r5);
    L_0x012a:
        r1 = r3.yRm;
        if (r1 == 0) goto L_0x0136;
    L_0x012e:
        if (r4 == 0) goto L_0x02ba;
    L_0x0130:
        r1 = r3.yRm;
        r2 = 0;
        r1.setVisibility(r2);
    L_0x0136:
        r1 = r3.yRq;
        r2 = r10.xQL;
        if (r2 == 0) goto L_0x015c;
    L_0x013c:
        r2 = 0;
        r3.yRp = r2;
        r2 = com.tencent.mm.au.b.Qz();
        if (r2 == 0) goto L_0x0157;
    L_0x0145:
        r4 = r2.wdd;
        if (r4 == 0) goto L_0x0157;
    L_0x0149:
        r4 = r2.wHt;
        if (r4 != 0) goto L_0x0157;
    L_0x014d:
        r4 = com.tencent.mm.au.b.Qx();
        if (r4 == 0) goto L_0x0157;
    L_0x0153:
        r2 = r2.wdd;
        r3.yRp = r2;
    L_0x0157:
        r2 = r10.yAN;
        r1.a(r3, r11, r2, r0);
    L_0x015c:
        r1 = r3.ljv;
        r1 = r1.getVisibility();
        if (r1 != 0) goto L_0x01a2;
    L_0x0164:
        r1 = r10.pGD;
        if (r1 == 0) goto L_0x01a2;
    L_0x0168:
        r1 = r3.ljv;
        r2 = r10.pGD;
        r2 = r2.vqb;
        r1.setTextColor(r2);
        r1 = r10.pGD;
        r1 = r1.vqc;
        if (r1 == 0) goto L_0x02c3;
    L_0x0177:
        r1 = r3.ljv;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = 1067030938; // 0x3f99999a float:1.2 double:5.271833295E-315;
        r5 = 1067030938; // 0x3f99999a float:1.2 double:5.271833295E-315;
        r6 = r10.pGD;
        r6 = r6.vqd;
        r1.setShadowLayer(r2, r4, r5, r6);
    L_0x0188:
        r1 = r10.pGD;
        r1 = r1.vqe;
        if (r1 == 0) goto L_0x02ce;
    L_0x018e:
        r1 = r3.ljv;
        r2 = com.tencent.mm.R.g.bAP;
        r1.setBackgroundResource(r2);
        r1 = r3.ljv;
        r2 = r10.yBB;
        r4 = r10.yBA;
        r5 = r10.yBB;
        r6 = r10.yBA;
        r1.setPadding(r2, r4, r5, r6);
    L_0x01a2:
        r1 = r3.qng;
        if (r1 == 0) goto L_0x01d8;
    L_0x01a6:
        r1 = r3.qng;
        r1 = r1.getVisibility();
        if (r1 != 0) goto L_0x01d8;
    L_0x01ae:
        r1 = r10.pGD;
        if (r1 == 0) goto L_0x01d8;
    L_0x01b2:
        r1 = r10.talker;
        r2 = "qqmail";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x01d8;
    L_0x01bd:
        r1 = r0.getType();
        r2 = 318767153; // 0x13000031 float:1.6155966E-27 double:1.574918993E-315;
        if (r1 == r2) goto L_0x01d8;
    L_0x01c6:
        r1 = r3.qng;
        r2 = r10.pGD;
        r2 = r2.vqf;
        r1.setTextColor(r2);
        r1 = r3.qng;
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1.setShadowLayer(r2, r4, r5, r6);
    L_0x01d8:
        r1 = r10.yBT;
        if (r1 == 0) goto L_0x01e5;
    L_0x01dc:
        r1 = r0.isSystem();
        if (r1 == 0) goto L_0x02d6;
    L_0x01e2:
        r1 = 0;
    L_0x01e3:
        if (r1 != 0) goto L_0x01e9;
    L_0x01e5:
        r1 = r10.yBU;
        if (r1 == 0) goto L_0x02d9;
    L_0x01e9:
        r1 = r3.mXO;
        if (r1 == 0) goto L_0x01fe;
    L_0x01ed:
        r1 = r3.mXO;
        r2 = r10.yBX;
        r4 = r0.field_msgId;
        r4 = java.lang.Long.valueOf(r4);
        r2 = r2.contains(r4);
        r1.setChecked(r2);
    L_0x01fe:
        r1 = r3.kbO;
        if (r1 == 0) goto L_0x0214;
    L_0x0202:
        r1 = r3.kbO;
        r4 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r4);
        r1.setTag(r2);
        r1 = r3.kbO;
        r2 = r10.yCi;
        r1.setOnClickListener(r2);
    L_0x0214:
        r1 = 1;
        r3.nd(r1);
    L_0x0218:
        r1 = r10.yBZ;
        r1 = r1.entrySet();
        r2 = r1.iterator();
    L_0x0222:
        r1 = r2.hasNext();
        if (r1 == 0) goto L_0x0246;
    L_0x0228:
        r1 = r2.next();
        r1 = (java.util.Map.Entry) r1;
        r3 = r1.getValue();
        if (r3 != r12) goto L_0x0222;
    L_0x0234:
        r2 = r10.yBZ;
        r3 = r1.getKey();
        r2.remove(r3);
        r2 = r10.yCa;
        r1 = r1.getKey();
        r2.remove(r1);
    L_0x0246:
        r1 = r10.yBZ;
        r2 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r1.put(r2, r12);
        r1 = r0.cjT();
        if (r1 == 0) goto L_0x0268;
    L_0x0257:
        r1 = r10.yCa;
        r2 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r3 = r0.field_isSend;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r2, r3);
    L_0x0268:
        if (r11 == 0) goto L_0x0292;
    L_0x026a:
        r1 = r10.yAN;
        r1 = r1.yAR;
        if (r1 == 0) goto L_0x0292;
    L_0x0270:
        r1 = r0.field_flag;
        r1 = r1 & 1;
        if (r1 == 0) goto L_0x0292;
    L_0x0276:
        r1 = r10.yCb;
        r2 = r0.field_msgId;
        r2 = java.lang.Long.valueOf(r2);
        r1 = r1.get(r2);
        if (r1 != 0) goto L_0x0292;
    L_0x0284:
        r1 = com.tencent.mm.kernel.g.Dt();
        r2 = new com.tencent.mm.ui.chatting.q$4;
        r2.<init>(r0);
        r4 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r1.g(r2, r4);
    L_0x0292:
        return r12;
    L_0x0293:
        r1 = 0;
        goto L_0x007a;
    L_0x0296:
        r2 = 0;
        goto L_0x0087;
    L_0x0299:
        r1 = r10.osV;
        r2 = 1;
        r1[r11] = r2;
        goto L_0x0090;
    L_0x02a0:
        r1 = 0;
        r2 = r1;
        goto L_0x00b1;
    L_0x02a4:
        r1 = 0;
        r4 = r1;
        goto L_0x00bb;
    L_0x02a8:
        r1 = r12.getTag();
        r1 = (com.tencent.mm.ui.chatting.viewitems.b.a) r1;
        r3 = r1;
        goto L_0x00e0;
    L_0x02b1:
        r1 = r3.ljv;
        r2 = 8;
        r1.setVisibility(r2);
        goto L_0x012a;
    L_0x02ba:
        r1 = r3.yRm;
        r2 = 8;
        r1.setVisibility(r2);
        goto L_0x0136;
    L_0x02c3:
        r1 = r3.ljv;
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1.setShadowLayer(r2, r4, r5, r6);
        goto L_0x0188;
    L_0x02ce:
        r1 = r3.ljv;
        r2 = 0;
        r1.setBackgroundColor(r2);
        goto L_0x01a2;
    L_0x02d6:
        r1 = 1;
        goto L_0x01e3;
    L_0x02d9:
        r1 = 0;
        r3.nd(r1);
        goto L_0x0218;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.q.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final boolean fX(long j) {
        if (this.yBX.contains(Long.valueOf(j))) {
            x.d("MicroMsg.ChattingListAdapter", "remove select item, msgId = %d", Long.valueOf(j));
            this.yBX.remove(Long.valueOf(j));
        } else {
            x.d("MicroMsg.ChattingListAdapter", "add select item, msgId = %d", Long.valueOf(j));
            if (this.yBX.size() >= 100) {
                com.tencent.mm.ui.base.h.b(this.yAN.getContext(), this.yAN.getString(R.l.ecz, Integer.valueOf(100)), "", true);
                return false;
            }
            this.yBX.add(Long.valueOf(j));
        }
        a(null, null);
        return true;
    }

    public final void csC() {
        if (this.yBX != null) {
            this.yBX.clear();
        }
    }

    final void csD() {
        x.d("MicroMsg.ChattingListAdapter", "disable clickListener");
        this.yBC = null;
        this.yBE = null;
        this.yBF = null;
        this.yBH = null;
        this.yBJ = null;
    }

    public final void FP(int i) {
        au auVar = (au) getItem(i);
        if (auVar != null && auVar.field_msgId != 0) {
            this.yBx.add(Long.valueOf(auVar.field_msgId));
        }
    }

    public final boolean ZH(String str) {
        try {
            this.pGD = new com.tencent.mm.pluginsdk.ui.e(bi.convertStreamToString(new FileInputStream(str)));
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingListAdapter", e, "", new Object[0]);
            this.pGD = null;
            return false;
        }
    }

    public final boolean bw(Context context, String str) {
        if (yCj.containsKey(str)) {
            this.pGD = (com.tencent.mm.pluginsdk.ui.e) yCj.get(str);
            return true;
        }
        try {
            this.pGD = new com.tencent.mm.pluginsdk.ui.e(bi.convertStreamToString(context.getAssets().open(str)));
            yCj.put(str, this.pGD);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingListAdapter", e, "", new Object[0]);
            return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if (this.lKV != null) {
            this.lKV.post(new Runnable() {
                public final void run() {
                    q.this.notifyDataSetChanged();
                }
            });
        }
    }

    public final void a(long j, au auVar, boolean z) {
        if (this.yBZ.containsKey(Long.valueOf(j)) && this.yCa.containsKey(Long.valueOf(j))) {
            com.tencent.mm.ui.chatting.viewitems.x.a.a(this.yAN.getContext(), (com.tencent.mm.ui.chatting.viewitems.b.a) ((View) this.yBZ.get(Long.valueOf(j))).getTag(), auVar, z);
            return;
        }
        x.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
    }

    public final void bZy() {
        if (this.lKV != null) {
            this.lKV.post(new Runnable() {
                public final void run() {
                    q.this.notifyDataSetChanged();
                }
            });
        }
    }

    public final void a(com.tencent.mm.modelvideo.s.a.a aVar) {
        boolean z = false;
        if (!(aVar == null || aVar.hXC == 3 || (aVar.hXC != 2 && aVar.hXC != -1 && aVar.hXC != 1))) {
            z = com.tencent.mm.ui.chatting.viewitems.ag.d.b(aVar);
        }
        if (!z) {
            ah.y(new Runnable() {
                public final void run() {
                    q.this.a(null, null);
                }
            });
        }
    }

    public static void ag(String str, int i, int i2) {
        com.tencent.mm.ui.chatting.viewitems.h.b.j(str, i, i2);
    }
}
