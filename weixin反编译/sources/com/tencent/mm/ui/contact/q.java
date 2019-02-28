package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.c;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q extends m {
    private int count = 0;
    private String fEe;
    private ag handler = new ag(Looper.getMainLooper());
    private a mRL;
    private e mRM;
    private List<j> mTR = null;
    private List<j> osM = null;
    private int yZK = Integer.MAX_VALUE;
    private int yZL = Integer.MAX_VALUE;
    private List<String> zci;
    private int zcj = Integer.MAX_VALUE;
    private int zck = Integer.MAX_VALUE;
    private int zcl = Integer.MAX_VALUE;
    private boolean zcm = true;
    private int zcn = Integer.MAX_VALUE;
    private boolean zco = true;
    private int zcp = Integer.MAX_VALUE;
    private List<j> zcq = null;
    private List<j> zcr = null;
    private List<Integer> zcs;
    private k zct = new k() {
        public final void b(h hVar) {
            switch (hVar.bjW) {
                case -3:
                case -2:
                case -1:
                    if (hVar.mON.fEe.equals(q.this.fEe)) {
                        q.c(q.this);
                        return;
                    }
                    return;
                case 0:
                    if (q.this.mRL != null && q.this.mRL.equals(q.this.mRL)) {
                        q.this.cwY();
                        q.this.mRM = hVar.mRM;
                        q.a(q.this, hVar.mRN);
                        q.this.zcq = hVar.mRN;
                        d.aU(hVar.mRN);
                        q.this.f(hVar.mON.fEe, q.c(q.this), true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    protected k zcu = new k() {
        public final void b(h hVar) {
            switch (hVar.bjW) {
                case -3:
                case -2:
                case -1:
                    if (hVar.mON.fEe.equals(q.this.fEe)) {
                        q.c(q.this);
                        return;
                    }
                    return;
                case 0:
                    if (q.this.mRL != null && q.this.mRL.equals(q.this.mRL)) {
                        q.this.mRM = hVar.mRM;
                        q.a(q.this, hVar.mRN);
                        if (hVar.mRN.size() > 0) {
                            switch (((j) hVar.mRN.get(0)).type) {
                                case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                                    q.this.osM = hVar.mRN;
                                    break;
                                case 131075:
                                    q.this.mTR = hVar.mRN;
                                    break;
                                case 131076:
                                    q.this.zcr = hVar.mRN;
                                    break;
                                default:
                                    x.i("MicroMsg.MMSearchContactAdapter", "not support search");
                                    break;
                            }
                        }
                        q.this.f(hVar.mON.fEe, q.c(q.this), true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(q qVar, List list) {
        if (qVar.zci != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                j jVar = (j) list.get(size);
                if (!qVar.zci.contains(jVar.mRd)) {
                    int i = jVar.type;
                    Object obj = (i == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || i == 131075 || i == 131076) ? 1 : null;
                    if (obj != null) {
                    }
                }
                list.remove(size);
            }
        }
    }

    static /* synthetic */ boolean c(q qVar) {
        if (qVar.zcs.size() <= 0) {
            return true;
        }
        HashSet hashSet = new HashSet();
        if (qVar.zcq != null) {
            for (j jVar : qVar.zcq) {
                hashSet.add(jVar.mRd);
            }
        }
        int intValue = ((Integer) qVar.zcs.remove(0)).intValue();
        g gVar = new g();
        gVar.fEe = qVar.fEe;
        gVar.mRF = new int[]{intValue};
        gVar.mRI = hashSet;
        gVar.mRK = qVar.zcu;
        gVar.handler = qVar.handler;
        if (intValue == 131075) {
            gVar.mRC = 32;
            gVar.mRJ = com.tencent.mm.plugin.fts.a.c.a.mSj;
        } else {
            gVar.mRC = 16;
            gVar.mRJ = b.mSk;
        }
        qVar.mRL = ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
        return false;
    }

    public q(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, int i) {
        super(mMBaseSelectContactUI, z, i);
        this.zci = list;
        this.zcs = new ArrayList();
        x.i("MicroMsg.MMSearchContactAdapter", "Create!");
        Xc();
    }

    public void bp(String str, boolean z) {
        if (this.zbP != null) {
            this.zbP.r(str, getCount(), z);
        }
    }

    public void a(String str, int[] iArr, boolean z) {
        clearTask();
        this.fEe = str;
        this.zcs.clear();
        for (int valueOf : iArr) {
            this.zcs.add(Integer.valueOf(valueOf));
        }
        HashSet hashSet = new HashSet();
        if (!z) {
            hashSet.add("filehelper");
        }
        x.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", this.fEe);
        g gVar = new g();
        gVar.fEe = str;
        gVar.mRF = iArr;
        gVar.mRH = 3;
        gVar.mRK = this.zct;
        gVar.handler = this.handler;
        gVar.scene = 1;
        gVar.mRI = hashSet;
        this.mRL = ((m) com.tencent.mm.kernel.g.k(m.class)).search(1, gVar);
    }

    private void clearTask() {
        if (this.mRL != null) {
            ((m) com.tencent.mm.kernel.g.k(m.class)).cancelSearchTask(this.mRL);
            this.mRL = null;
        }
    }

    private void cwY() {
        this.zck = Integer.MAX_VALUE;
        this.zcl = Integer.MAX_VALUE;
        this.zcm = true;
        this.zcn = Integer.MAX_VALUE;
        this.yZK = Integer.MAX_VALUE;
        this.zco = true;
        this.zcp = Integer.MAX_VALUE;
        this.yZL = Integer.MAX_VALUE;
        this.zcq = null;
        this.osM = null;
        this.mTR = null;
        this.zcr = null;
        this.mRM = null;
        clearCache();
        notifyDataSetChanged();
    }

    private void Xc() {
        x.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.fEe = null;
        cwY();
        clearTask();
        clearCache();
    }

    public final void abi() {
        Xc();
    }

    private void f(String str, boolean z, boolean z2) {
        int dx = dx(this.zcq);
        int dx2 = dx(this.osM);
        int dx3 = dx(this.mTR);
        int dx4 = dx(this.zcr);
        if (dx > 0) {
            this.zck = 0;
            dx = (dx + 1) + 0;
        } else {
            this.zck = Integer.MAX_VALUE;
            dx = 0;
        }
        if (dx2 > 0) {
            this.zcl = dx;
            if (dx2 <= 3 || (dx3 <= 0 && dx4 <= 0)) {
                this.zcn = Integer.MAX_VALUE;
                dx += dx2 + 1;
            } else if (this.zcm) {
                dx += 4;
                this.zcn = dx;
                dx++;
            } else {
                dx += dx2 + 1;
                this.zcn = dx;
                dx++;
            }
        } else {
            this.zcl = Integer.MAX_VALUE;
        }
        if (this.mRM.mRn.length <= 1 || buj()) {
            this.zcj = Integer.MAX_VALUE;
        } else {
            this.zcj = dx;
            dx++;
        }
        if (dx3 > 0) {
            this.yZK = dx;
            if (dx3 <= 3 || dx4 <= 0) {
                this.zcp = Integer.MAX_VALUE;
                dx += dx3 + 1;
            } else if (this.zco) {
                dx += 4;
                this.zcp = dx;
                dx++;
            } else {
                dx += dx3 + 1;
                this.zcp = dx;
                dx++;
            }
        } else {
            this.yZK = Integer.MAX_VALUE;
        }
        if (dx4 > 0) {
            this.yZL = dx;
            dx += dx4 + 1;
        } else {
            this.yZL = Integer.MAX_VALUE;
        }
        x.i("MicroMsg.MMSearchContactAdapter", "setCount %d", Integer.valueOf(dx));
        this.count = dx;
        if (z2) {
            bp(str, z);
        }
        clearCache();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.count;
    }

    private static int dx(List<? extends Object> list) {
        return list == null ? 0 : list.size();
    }

    public com.tencent.mm.ui.contact.a.a je(int i) {
        com.tencent.mm.ui.contact.a.a fVar;
        int i2;
        com.tencent.mm.ui.contact.a.a dVar;
        if (i == this.zcj) {
            fVar = new f(i);
            fVar.sbt = true;
        } else if (i == this.zck) {
            fVar = fc(com.tencent.mm.plugin.selectcontact.a.h.mUW, i);
        } else if (i == this.zcl) {
            fVar = fc(com.tencent.mm.plugin.selectcontact.a.h.ekG, i);
        } else if (i == this.yZK) {
            fVar = fc(com.tencent.mm.plugin.selectcontact.a.h.mul, i);
        } else if (i == this.yZL) {
            fVar = fc(com.tencent.mm.plugin.selectcontact.a.h.qlF, i);
        } else if (i == this.zcn) {
            fVar = s(com.tencent.mm.plugin.selectcontact.a.h.ekG, i, this.zcm);
        } else if (i == this.zcp) {
            fVar = s(com.tencent.mm.plugin.selectcontact.a.h.mul, i, this.zco);
        } else if (i > this.yZL) {
            i2 = (i - this.yZL) - 1;
            dVar = new com.tencent.mm.ui.contact.a.d(i);
            dVar.iZi = (j) this.zcr.get(i2);
            dVar.zbR = buj();
            dVar.sbt = true;
            dVar.mVk = i2 + 1;
            dVar.cG(dVar.iZi.type, dVar.iZi.mRc);
            fVar = dVar;
        } else if (i > this.yZK) {
            i2 = (i - this.yZK) - 1;
            dVar = new c(i);
            dVar.iZi = (j) this.mTR.get(i2);
            dVar.zbR = buj();
            dVar.sbt = true;
            dVar.mVk = i2 + 1;
            dVar.cG(dVar.iZi.type, dVar.iZi.mRc);
            fVar = dVar;
        } else if (i > this.zcl) {
            i2 = (i - this.zcl) - 1;
            dVar = new com.tencent.mm.ui.contact.a.d(i);
            dVar.iZi = (j) this.osM.get(i2);
            dVar.zbR = buj();
            dVar.sbt = true;
            dVar.mVk = i2 + 1;
            dVar.cG(dVar.iZi.type, dVar.iZi.mRc);
            fVar = dVar;
        } else if (i > this.zck) {
            i2 = (i - this.zck) - 1;
            j jVar = (j) this.zcq.get(i2);
            if (jVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || jVar.type == 131076) {
                dVar = new com.tencent.mm.ui.contact.a.d(i);
                dVar.iZi = jVar;
                dVar.zbR = buj();
                dVar.zef = true;
                dVar.sbt = true;
                dVar.mVk = i2 + 1;
                dVar.cG(dVar.iZi.type, dVar.iZi.mRc);
                fVar = dVar;
            } else if (jVar.type == 131075) {
                dVar = new c(i);
                dVar.iZi = jVar;
                dVar.zbR = buj();
                dVar.zef = true;
                dVar.sbt = true;
                dVar.mVk = i2 + 1;
                dVar.cG(dVar.iZi.type, dVar.iZi.mRc);
                fVar = dVar;
            } else {
                x.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", Integer.valueOf(jVar.type));
                fVar = null;
            }
        } else {
            x.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", Integer.valueOf(i));
            fVar = null;
        }
        if (fVar != null) {
            fVar.fEe = this.fEe;
            fVar.mRM = this.mRM;
            fVar.scene = this.scene;
        }
        return fVar;
    }

    private static com.tencent.mm.ui.contact.a.a s(int i, int i2, boolean z) {
        com.tencent.mm.ui.contact.a.a iVar = new i(i2);
        iVar.jyc = i;
        iVar.mVb = z;
        return iVar;
    }

    private com.tencent.mm.ui.contact.a.a fc(int i, int i2) {
        com.tencent.mm.ui.contact.a.a gVar = new com.tencent.mm.ui.contact.a.g(i2);
        gVar.mVt = this.zbQ.getActivity().getResources().getString(i);
        return gVar;
    }

    public void finish() {
        super.finish();
        x.i("MicroMsg.MMSearchContactAdapter", "finish!");
        Xc();
    }

    protected boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.zck, this.zcl, this.yZK, this.yZL};
        for (int i2 = 0; i2 < 4; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        return false;
    }

    public final boolean GG(int i) {
        int headerViewsCount = i - this.zbQ.buq().getHeaderViewsCount();
        if (headerViewsCount == this.zcn) {
            if (this.zcm) {
                headerViewsCount = this.zbQ.buq().getSelectedItemPosition();
                this.zcm = false;
                f(this.fEe, true, false);
                this.zbQ.buq().setSelection(headerViewsCount);
                return true;
            }
            this.zcm = true;
            f(this.fEe, true, false);
            this.zbQ.buq().setSelection(this.zcn);
            return true;
        } else if (headerViewsCount != this.zcp) {
            com.tencent.mm.ui.contact.a.a GF = GF(headerViewsCount);
            if (!(GF == null || !GF.sbt || this.zcj == Integer.MAX_VALUE)) {
                if (GF.position == this.zcj) {
                    x.GH(1);
                    return false;
                }
                x.GH(0);
            }
            return false;
        } else if (this.zco) {
            headerViewsCount = this.zbQ.buq().getSelectedItemPosition();
            this.zco = false;
            f(this.fEe, true, false);
            this.zbQ.buq().setSelection(headerViewsCount);
            return true;
        } else {
            this.zco = true;
            f(this.fEe, true, false);
            this.zbQ.buq().setSelection(this.zcp);
            return true;
        }
    }
}
