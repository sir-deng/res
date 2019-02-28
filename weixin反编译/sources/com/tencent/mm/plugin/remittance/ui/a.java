package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    wd pRu = null;
    iu pRv;

    class a implements Comparator {
        a() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((wd) obj).wmM - ((wd) obj2).wmM > 0 ? -1 : 1;
        }
    }

    public final void boj() {
        x.i("MicroMsg.FavorInfoPicked", "cleanBusiF2FFavor");
        this.pRv = null;
        this.pRu = null;
    }

    public final List<we> bok() {
        if (this.pRv != null) {
            return this.pRv.vVE;
        }
        return new LinkedList();
    }

    public final boolean bol() {
        if (this.pRv != null) {
            return true;
        }
        return false;
    }

    public final boolean bom() {
        if (this.pRv == null || this.pRv.vVE == null || this.pRv.vVE.size() <= 0) {
            return false;
        }
        return true;
    }

    public final void IY(String str) {
        this.pRu = null;
        if (str == null) {
            this.pRu = null;
        } else if (this.pRv == null) {
            x.e("MicroMsg.FavorInfoPicked", "error setSelectFavorComposeId currentFavorResp is null");
            this.pRu = null;
        } else {
            Iterator it = this.pRv.vVF.iterator();
            while (it.hasNext()) {
                wd wdVar = (wd) it.next();
                if (str.equals(wdVar.wmI)) {
                    this.pRu = wdVar;
                    return;
                }
            }
        }
    }

    public final boolean a(List<we> list, we weVar) {
        if (this.pRv == null) {
            x.e("MicroMsg.FavorInfoPicked", "error setFavorInfoList currentFavorResp is null");
            return false;
        }
        wd wdVar;
        CharSequence bigInteger;
        if (weVar != null) {
            bigInteger = new BigInteger(Long.toBinaryString(weVar.wmR), 2).toString();
        } else {
            bigInteger = null;
        }
        List<wd> linkedList = new LinkedList();
        Iterator it = this.pRv.vVF.iterator();
        while (it.hasNext()) {
            wdVar = (wd) it.next();
            if (weVar == null || (!bi.oN(bigInteger) && wdVar.wmI.contains(bigInteger))) {
                linkedList.add(wdVar);
            }
        }
        List linkedList2 = new LinkedList();
        for (wd wdVar2 : linkedList) {
            if (a((List) list, wdVar2)) {
                linkedList2.add(wdVar2);
            }
        }
        if (linkedList2.size() > 0) {
            Collections.sort(linkedList2, new a());
            this.pRu = (wd) linkedList2.get(0);
            return true;
        }
        this.pRu = null;
        return false;
    }

    private static boolean a(List<we> list, wd wdVar) {
        if (wdVar.vVE.size() == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (we weVar : list) {
            hashSet.add(Long.valueOf(weVar.wmR));
        }
        Iterator it = wdVar.vVE.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(((we) it.next()).wmR))) {
                return false;
            }
        }
        return true;
    }
}
