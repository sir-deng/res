package com.tencent.mm.view.f;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bt.a.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a {
    public int RT;
    private final String TAG;
    public int itU;
    public int kgS;
    public int kgT;
    public int lNH;
    public int mSW;
    private Context tI;
    public String vwC;
    public int zMM;
    public int zPB;
    public int zPC;
    public int zPD;
    public int zPE;
    public int zPF;
    public int zPG;
    public int zPH;
    private int zPI;
    public int zPJ;
    public int zPK;
    public int zPL;
    public int zPM;
    public String zPN;
    public int zPO;
    public boolean zPP;
    public boolean zPQ;
    public boolean zPR;
    public boolean zPS;
    public boolean zPT;
    public boolean zPU;
    public boolean zPV;
    public boolean zPW;
    public boolean zPX;
    public int[] zPY;
    public boolean zPZ;
    public boolean zQa;
    public ArrayList<com.tencent.mm.view.c.a> zQb;
    public HashMap<String, Integer> zQc;
    public c zQd;
    public volatile boolean zQe;
    public int znV;

    public enum a {
        RECOMMEND,
        DEFAULT,
        EMOJI
    }

    public a() {
        this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelStg";
        this.znV = 0;
        this.zPK = 0;
        this.RT = 0;
        this.mSW = 0;
        this.zPN = "";
        this.zPO = 0;
        this.zPW = false;
        this.zPX = false;
        this.zQb = new ArrayList();
        this.zQc = new HashMap();
        this.zQe = false;
        this.tI = ad.getContext();
        this.zPB = this.tI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.m.a.c.bxi);
        this.lNH = this.tI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.m.a.c.lOF);
        this.zPC = this.tI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.m.a.c.lOE);
        this.zPH = com.tencent.mm.bu.a.fromDPToPix(this.tI, 48);
        this.zPI = com.tencent.mm.bu.a.fromDPToPix(this.tI, 43);
        this.zPE = com.tencent.mm.bu.a.fromDPToPix(this.tI, 86);
        this.zPF = com.tencent.mm.bu.a.fromDPToPix(this.tI, 80);
        this.zPG = com.tencent.mm.bu.a.fromDPToPix(this.tI, 65);
        this.zPD = com.tencent.mm.bu.a.aa(this.tI, com.tencent.mm.plugin.m.a.c.bup);
        this.zPM = com.tencent.mm.bu.a.fromDPToPix(this.tI, 6);
        this.zPN = "TAG_DEFAULT_TAB";
        this.zPO = 0;
        this.zMM = com.tencent.mm.bu.a.aa(this.tI, com.tencent.mm.plugin.m.a.c.lOL);
        this.zPJ = com.tencent.mm.bu.a.aa(this.tI, com.tencent.mm.plugin.m.a.c.bup);
        cBV();
        cBM();
    }

    public final void onPause() {
        this.zPU = false;
        cBL();
        long currentTimeMillis = System.currentTimeMillis();
        bkc bkc = new bkc();
        if (!(this.zQc == null || this.zQc.isEmpty())) {
            for (String str : this.zQc.keySet()) {
                bkd bkd = new bkd();
                bkd.vPI = str;
                bkd.vRX = ((Integer) this.zQc.get(str)).intValue();
                bkc.wTU.add(bkd);
            }
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().a(bkc);
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save Smiley TabMap use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        cBU();
    }

    public static boolean cBI() {
        boolean Dq;
        boolean Dq2;
        Exception e;
        try {
            if (((h) g.Dn().CU()).DZ()) {
                com.tencent.mm.bt.a.ceF();
                b bVar = com.tencent.mm.bt.a.xjH;
                Dq = b.Dq(208913);
                try {
                    com.tencent.mm.bt.a.ceF();
                    b bVar2 = com.tencent.mm.bt.a.xjH;
                    Dq2 = b.Dq(208899);
                } catch (Exception e2) {
                    Exception exception = e2;
                    Dq2 = Dq;
                    e = exception;
                }
            } else {
                Dq = false;
                Dq2 = false;
            }
        } catch (Exception e3) {
            e = e3;
            Dq2 = false;
            x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", e.toString());
            Dq = Dq2;
            Dq2 = false;
            if (!Dq2) {
            }
            return true;
        }
        if (Dq2 || Dq) {
            return true;
        }
        return false;
    }

    public static boolean cBJ() {
        boolean aQ;
        Exception e;
        boolean aQ2;
        try {
            if (((h) g.Dn().CU()).DZ()) {
                aQ = com.tencent.mm.r.c.Bx().aQ(262147, 266244);
                try {
                    aQ2 = com.tencent.mm.r.c.Bx().aQ(262149, 266244);
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                aQ2 = false;
                aQ = false;
            }
        } catch (Exception e3) {
            e = e3;
            aQ = false;
            x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", e.toString());
            aQ2 = false;
            if (!aQ) {
            }
            return true;
        }
        if (aQ || aQ2) {
            return true;
        }
        return false;
    }

    public final int aba(String str) {
        if ("TAG_DEFAULT_TAB".equals(str)) {
            return this.zPH;
        }
        return this.zPE;
    }

    public final void HP(int i) {
        this.kgS = i;
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "set viewpager height px: %d mViewPagerHeightPx:%d ", Integer.valueOf(i), Integer.valueOf(this.kgS));
    }

    public final int cBK() {
        if (this.kgT <= 1) {
            this.kgT = alC()[0];
        }
        return this.kgT;
    }

    public final void abb(String str) {
        if (!bi.oN(str)) {
            this.zPN = str;
        }
    }

    public final void cBL() {
        if (!bi.oN(this.zPN) && !this.zPP) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save product Id:%s selected index:%d", this.zPN, Integer.valueOf(this.zPO));
            com.tencent.mm.bt.a.ceF();
            b bVar = com.tencent.mm.bt.a.xjH;
            b.Vg(this.zPN);
        }
    }

    public final void cBM() {
        if (!this.zPP) {
            com.tencent.mm.bt.a.ceF();
            b bVar = com.tencent.mm.bt.a.xjH;
            this.zPN = b.aW(-29414086, "TAG_DEFAULT_TAB");
            this.zPO = bi.a((Integer) this.zQc.get(this.zPN), 0);
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restoreShowProductId product id: %s selected index:%d", this.zPN, Integer.valueOf(this.zPO));
        } else if (!this.zPN.equals("TAG_DEFAULT_TAB")) {
            this.zPN = "TAG_DEFAULT_TAB";
            this.zPO = bi.a((Integer) this.zQc.get(this.zPN), 0);
        }
    }

    public static EmojiGroupInfo cBN() {
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = "TAG_DEFAULT_TAB";
        return emojiGroupInfo;
    }

    public static EmojiGroupInfo cBO() {
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = String.valueOf(EmojiGroupInfo.xIF);
        return emojiGroupInfo;
    }

    public static boolean d(EmojiGroupInfo emojiGroupInfo) {
        return emojiGroupInfo != null && emojiGroupInfo.field_packStatus == 1;
    }

    public final boolean cBP() {
        com.tencent.mm.bt.a.ceF();
        b bVar = com.tencent.mm.bt.a.xjH;
        return b.Dq(66832) && !this.zPV;
    }

    public final com.tencent.mm.view.c.a abc(String str) {
        if (this.zQb == null || str == null) {
            x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "getTab failed.");
            return null;
        }
        Iterator it = this.zQb.iterator();
        while (it.hasNext()) {
            com.tencent.mm.view.c.a aVar = (com.tencent.mm.view.c.a) it.next();
            if (aVar == null) {
                x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab");
            } else if (aVar.lEs == null) {
                x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab productId");
            } else if (aVar.lEs.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public final com.tencent.mm.view.c.a HQ(int i) {
        if (this.zQb == null) {
            return null;
        }
        return (com.tencent.mm.view.c.a) this.zQb.get(HR(i));
    }

    public final int HR(int i) {
        if (this.zPY == null || i >= this.zPY.length || i <= 0) {
            return 0;
        }
        return this.zPY[i];
    }

    public final int cBQ() {
        String str = this.zPN;
        if (this.zQb != null) {
            for (int i = 0; i < this.zQb.size(); i++) {
                com.tencent.mm.view.c.a aVar = (com.tencent.mm.view.c.a) this.zQb.get(i);
                if (aVar != null && aVar.lEs.equals(str)) {
                    return i;
                }
            }
        }
        return 0;
    }

    public final com.tencent.mm.view.c.a cBR() {
        return abc(this.zPN);
    }

    public final void cBS() {
        this.mSW = 0;
        if (this.zQb != null) {
            com.tencent.mm.view.c.a aVar;
            Iterator it = this.zQb.iterator();
            while (it.hasNext()) {
                aVar = (com.tencent.mm.view.c.a) it.next();
                this.mSW = aVar.cBA() + this.mSW;
            }
            if (this.zQb != null) {
                try {
                    this.zPY = new int[this.mSW];
                    int i = 0;
                    int i2 = 0;
                    loop1:
                    while (i < this.zQb.size()) {
                        aVar = (com.tencent.mm.view.c.a) this.zQb.get(i);
                        int i3 = i2;
                        i2 = 0;
                        while (i2 < aVar.cBA()) {
                            if (i3 >= this.mSW) {
                                break loop1;
                            }
                            int i4 = i3 + 1;
                            this.zPY[i3] = i;
                            i2++;
                            i3 = i4;
                        }
                        i++;
                        i2 = i3;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", e, "", new Object[0]);
                }
            }
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "refreshAllCount count: %d", Integer.valueOf(this.mSW));
        }
    }

    public final int abd(String str) {
        int i = 4;
        if (bi.oN(str)) {
            return 0;
        }
        if (str.equals("TAG_DEFAULT_TAB")) {
            if (cBT()) {
                return 7;
            }
            return cBK() / this.zPI;
        } else if (this.kgS <= 0) {
            return 0;
        } else {
            if (str.equals("TAG_STORE_TAB")) {
                return 3;
            }
            int cBK = cBK() / this.zPF;
            if (!cBT()) {
                i = cBK;
            } else if (cBK <= 4) {
                i = cBK;
            }
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", Integer.valueOf(i));
            return i;
        }
    }

    public final int dD(String str, int i) {
        return (this.kgS - (aba(str) * i)) / (i + 1);
    }

    public static boolean isSDCardAvailable() {
        if (!((h) g.Dn().CU()).DZ()) {
            return true;
        }
        g.Dr();
        return g.Dq().isSDCardAvailable();
    }

    public final boolean cBT() {
        if (this.RT == 0) {
            int[] alC = alC();
            if (alC[0] < alC[1]) {
                this.RT = 1;
            } else {
                this.RT = 2;
            }
        }
        return this.RT == 1;
    }

    private int[] alC() {
        int[] iArr = new int[2];
        if (this.tI instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.tI).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) this.tI.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    public final void cBU() {
        if (this.zQd != null) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "remove succeed send listener");
            com.tencent.mm.sdk.b.a.xmy.c(this.zQd);
            this.zQd = null;
        }
    }

    public final int getColumnWidth() {
        int i = 4;
        if (this.znV == 0) {
            int cBK = cBK() / this.zPF;
            if (!cBT()) {
                i = cBK;
            } else if (cBK <= 4) {
                i = cBK;
            }
            this.znV = cBK() / i;
        }
        return this.znV;
    }

    public final void cBV() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.zQc == null) {
            this.zQc = new HashMap();
        }
        this.zQc.clear();
        bkc aBG = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBG();
        if (!(aBG == null || aBG.wTU == null || aBG.wTU.isEmpty())) {
            Iterator it = aBG.wTU.iterator();
            while (it.hasNext()) {
                bkd bkd = (bkd) it.next();
                this.zQc.put(bkd.vPI, Integer.valueOf(bkd.vRX));
            }
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restore smiley tab map use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
