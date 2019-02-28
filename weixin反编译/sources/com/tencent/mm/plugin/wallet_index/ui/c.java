package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_index.c.g;
import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.protocal.c.alp;
import java.util.ArrayList;
import java.util.List;

public final class c {
    String lEs = null;
    public int mCount = 1;
    int pil;
    public String tgL = null;
    public String tgM = null;
    public alo tgQ;
    public alp tgR;
    public String thi = null;
    public ArrayList<String> thl = new ArrayList();
    public ArrayList<String> thm = new ArrayList();
    public String thn = null;
    public int tho = 0;
    List<String> thp = new ArrayList();
    boolean thq = false;
    public String thr;
    public String ths;

    public final boolean bOc() {
        return this.pil == 2;
    }

    public final k a(com.tencent.mm.plugin.wallet_index.b.a.c cVar, boolean z) {
        int i = z ? 2 : 1;
        if (!this.thq) {
            return new com.tencent.mm.wallet_core.c.k(cVar.lEs, i, this.pil, this.mCount, cVar.tgJ, cVar.tgK, cVar.rRn, cVar.tgL, cVar.tgM);
        }
        if (!bOc()) {
            this.tgQ.wzx = cVar.rRn;
            this.tgQ.wzu = cVar.tgJ;
            this.tgQ.pht = cVar.tgM;
            this.tgQ.wpq = cVar.tgL;
            this.tgQ.pjS = cVar.lEs;
            this.tgQ.wzw = cVar.tgK;
        }
        return new g(this.pil, i, cVar.lEs, this.tgR, this.tgQ);
    }
}
