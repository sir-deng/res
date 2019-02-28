package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends o implements b {
    private Cursor ilb;
    private int pUr;
    private a yZH;
    private int yZI;
    private int yZJ;
    private int yZK;
    private int yZL;
    private int yZM;
    private int yZN;
    private HashMap<String, Integer> yZO;
    private SparseArray<String> yZP;

    public static class a {
        public String yYA = "@all.contact.without.chatroom";
        public boolean yZQ = false;
        public boolean yZR = false;
        public boolean yZS = false;
        public boolean yZT = false;
        public boolean yZU = false;
        public boolean yZV = false;
        public String yZW;
        public String yZX;
        public boolean yZY = false;
        public String yZZ = "";
        public String zaa = "";
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, a aVar, boolean z3) {
        super((l) mMBaseSelectContactUI, (List) list, z, z2, z3);
        this.yZI = Integer.MAX_VALUE;
        this.pUr = Integer.MAX_VALUE;
        this.yZJ = Integer.MAX_VALUE;
        this.yZK = Integer.MAX_VALUE;
        this.yZL = Integer.MAX_VALUE;
        this.yZM = Integer.MAX_VALUE;
        this.yZN = Integer.MAX_VALUE;
        this.yZO = null;
        this.yZP = null;
        x.i("MicroMsg.AlphabetContactAdapter", "create!");
        if (aVar != null) {
            this.yZH = aVar;
        } else {
            this.yZH = new a();
        }
        g.Dr();
        ((h) g.h(h.class)).Ff().a(this);
        aJO();
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, a aVar) {
        this(mMBaseSelectContactUI, list, true, z, aVar, false);
    }

    private void aJO() {
        this.yZI = Integer.MAX_VALUE;
        this.pUr = Integer.MAX_VALUE;
        this.yZJ = Integer.MAX_VALUE;
        this.yZK = Integer.MAX_VALUE;
        this.yZL = Integer.MAX_VALUE;
        this.yZN = Integer.MAX_VALUE;
        if (this.yZO != null) {
            this.yZO.clear();
        } else {
            this.yZO = new HashMap();
        }
        if (this.yZP != null) {
            this.yZP.clear();
        } else {
            this.yZP = new SparseArray();
        }
        List arrayList = new ArrayList();
        Cursor j;
        int count;
        int i;
        Cursor cR;
        List F;
        if (this.yZH.yZU) {
            g.Dr();
            j = ((h) g.h(h.class)).Ff().j(bi.F(this.yZH.yZX.split(",")), false);
            arrayList.add(j);
            count = j.getCount();
            x.d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", Integer.valueOf(count));
            if (count > 0) {
                this.yZN = 0;
                count = (count + 1) + 0;
                ba(this.yZN, "☆");
                i = count;
            } else {
                this.yZN = Integer.MAX_VALUE;
                i = 0;
            }
            if (this.yZH.yYA == "@all.contact.without.chatroom.without.openim") {
                g.Dr();
                cR = ((h) g.h(h.class)).Ff().cR(bi.F(this.yZH.yZW.split(",")));
            } else {
                g.Dr();
                cR = ((h) g.h(h.class)).Ff().cQ(bi.F(this.yZH.yZW.split(",")));
            }
            arrayList.add(cR);
            count = cR.getCount();
            if (count > 0) {
                this.yZJ = i;
                i += count + 1;
                ba(this.yZJ, "☆");
            } else {
                this.yZJ = Integer.MAX_VALUE;
            }
            F = bi.F(this.yZH.yZW.split(","));
            g.Dr();
            arrayList.add(((h) g.h(h.class)).Ff().j(F, true));
            String[] D = s.D(F);
            int[] C = s.C(F);
            if (!(D == null || C == null)) {
                for (count = 0; count < D.length; count++) {
                    if (count < C.length) {
                        ba(C[count] + i, D[count]);
                        i++;
                    }
                }
                j.getCount();
            }
        } else {
            int i2;
            ar Ff;
            String str;
            String str2;
            boolean z;
            String[] a;
            int[] b;
            if (this.yZH.yZV) {
                this.yZM = 0;
                ba(this.yZM, "nonLimit");
                i = 1;
            } else {
                i = 0;
            }
            List F2;
            if (this.yZH.yZY && this.yZH.yZZ != null) {
                F2 = bi.F(this.yZH.yZZ.split(";"));
                g.Dr();
                cR = ((h) g.h(h.class)).Ff().cM(F2);
                arrayList.add(cR);
                count = cR.getCount();
                if (count > 0) {
                    this.yZI = i;
                    i += count + 1;
                    ba(this.yZI, "↑");
                } else {
                    this.yZI = Integer.MAX_VALUE;
                }
            } else if (this.yZH.yZQ) {
                F2 = g.dw(this.koG);
                if (F2.size() == 0) {
                    g.Dr();
                    cR = ((h) g.h(h.class)).Ff().aZY();
                } else {
                    g.Dr();
                    cR = ((h) g.h(h.class)).Ff().cM(F2);
                }
                arrayList.add(cR);
                count = cR.getCount();
                if (count > 0) {
                    this.pUr = i;
                    i += count + 1;
                    ba(this.pUr, "↑");
                } else {
                    this.pUr = Integer.MAX_VALUE;
                }
            }
            if (this.yZH.yZR) {
                if (this.yZH.yYA == "@all.contact.without.chatroom.without.openim") {
                    g.Dr();
                    cR = ((h) g.h(h.class)).Ff().cT(this.koG);
                } else {
                    g.Dr();
                    cR = ((h) g.h(h.class)).Ff().cS(this.koG);
                }
                arrayList.add(cR);
                count = cR.getCount();
                if (count > 0) {
                    this.yZJ = i;
                    i += count + 1;
                    ba(this.yZJ, "☆");
                    i2 = i;
                    g.Dr();
                    Ff = ((h) g.h(h.class)).Ff();
                    str = this.yZH.yYA;
                    str2 = "";
                    F = this.koG;
                    if (this.zch) {
                        z = true;
                    } else {
                        z = false;
                    }
                    j = Ff.a(str, str2, F, false, z);
                    arrayList.add(j);
                    a = s.a(this.yZH.yYA, "", "", this.koG);
                    b = s.b(this.yZH.yYA, "", this.koG, "");
                    if (!(a == null || b == null)) {
                        i = i2;
                        for (count = 0; count < a.length; count++) {
                            if (count < b.length) {
                                ba(b[count] + i, a[count]);
                                i++;
                            }
                        }
                        i2 += j.getCount() + a.length;
                    }
                    if (this.yZH.yZS) {
                        g.Dr();
                        cR = ((h) g.h(h.class)).Ff().b("@all.chatroom.contact", "", this.koG);
                        arrayList.add(cR);
                        count = cR.getCount();
                        if (count <= 0) {
                            this.yZK = i2;
                            i2 += count + 1;
                            ba(this.yZK, this.zbQ.getActivity().getString(com.tencent.mm.plugin.selectcontact.a.h.dCY));
                        } else {
                            this.yZK = Integer.MAX_VALUE;
                        }
                    }
                    if (this.yZH.yZT) {
                        g.Dr();
                        cR = ((h) g.h(h.class)).Ff().b("@verify.contact", "", this.koG);
                        arrayList.add(cR);
                        if (cR.getCount() <= 0) {
                            this.yZL = i2;
                            ba(this.yZL, this.zbQ.getActivity().getString(com.tencent.mm.plugin.selectcontact.a.h.qlP));
                        } else {
                            this.yZL = Integer.MAX_VALUE;
                        }
                    }
                } else {
                    this.yZJ = Integer.MAX_VALUE;
                }
            }
            i2 = i;
            g.Dr();
            Ff = ((h) g.h(h.class)).Ff();
            str = this.yZH.yYA;
            str2 = "";
            F = this.koG;
            if (this.zch) {
                z = false;
            } else {
                z = true;
            }
            j = Ff.a(str, str2, F, false, z);
            arrayList.add(j);
            a = s.a(this.yZH.yYA, "", "", this.koG);
            b = s.b(this.yZH.yYA, "", this.koG, "");
            i = i2;
            for (count = 0; count < a.length; count++) {
                if (count < b.length) {
                    ba(b[count] + i, a[count]);
                    i++;
                }
            }
            i2 += j.getCount() + a.length;
            if (this.yZH.yZS) {
                g.Dr();
                cR = ((h) g.h(h.class)).Ff().b("@all.chatroom.contact", "", this.koG);
                arrayList.add(cR);
                count = cR.getCount();
                if (count <= 0) {
                    this.yZK = Integer.MAX_VALUE;
                } else {
                    this.yZK = i2;
                    i2 += count + 1;
                    ba(this.yZK, this.zbQ.getActivity().getString(com.tencent.mm.plugin.selectcontact.a.h.dCY));
                }
            }
            if (this.yZH.yZT) {
                g.Dr();
                cR = ((h) g.h(h.class)).Ff().b("@verify.contact", "", this.koG);
                arrayList.add(cR);
                if (cR.getCount() <= 0) {
                    this.yZL = Integer.MAX_VALUE;
                } else {
                    this.yZL = i2;
                    ba(this.yZL, this.zbQ.getActivity().getString(com.tencent.mm.plugin.selectcontact.a.h.qlP));
                }
            }
        }
        x.d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", this.yZO.toString());
        this.ilb = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
    }

    private void ba(int i, String str) {
        this.yZO.put(str, Integer.valueOf(i));
        this.yZP.put(i, str);
    }

    public final int aaf(String str) {
        if (str.equals("↑")) {
            return 0;
        }
        if (this.yZO == null || !this.yZO.containsKey(str)) {
            return -1;
        }
        return ((Integer) this.yZO.get(str)).intValue() + this.zbQ.buq().getHeaderViewsCount();
    }

    public final int getCount() {
        return this.ilb.getCount() + this.yZO.size();
    }

    protected final com.tencent.mm.ui.contact.a.a je(int i) {
        if (i == this.yZN) {
            return bb(i, this.zbQ.getActivity().getString(com.tencent.mm.plugin.selectcontact.a.h.qlR));
        }
        if (i == this.yZI) {
            return bb(i, this.yZH.zaa);
        }
        if (i == this.pUr) {
            return bb(i, this.zbQ.getActivity().getString(com.tencent.mm.plugin.selectcontact.a.h.qlN));
        }
        if (i == this.yZJ) {
            return bb(i, this.zbQ.getActivity().getString(com.tencent.mm.plugin.selectcontact.a.h.qlM));
        }
        if (i == this.yZK) {
            return bb(i, this.zbQ.getActivity().getString(com.tencent.mm.plugin.selectcontact.a.h.dCY));
        }
        if (i == this.yZL) {
            return bb(i, this.zbQ.getActivity().getString(com.tencent.mm.plugin.selectcontact.a.h.qlP));
        }
        if (i == this.yZM) {
            return new j(i);
        }
        if (this.yZP.indexOfKey(i) >= 0) {
            return bb(i, (String) this.yZP.get(i));
        }
        int i2 = i;
        int i3 = 0;
        while (i3 <= this.yZP.size()) {
            if (this.yZP.indexOfKey(i2) >= 0) {
                i3++;
            }
            i2--;
            if (i2 < 0) {
                break;
            }
        }
        if (this.ilb.moveToPosition(i - i3)) {
            x.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
            com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
            xVar.b(this.ilb);
            com.tencent.mm.ui.contact.a.a dVar = new d(i);
            dVar.jQP = xVar;
            dVar.zbR = buj();
            dVar.zbS = this.zbS;
            return dVar;
        }
        x.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
        return null;
    }

    private static com.tencent.mm.ui.contact.a.a bb(int i, String str) {
        com.tencent.mm.ui.contact.a.a gVar = new com.tencent.mm.ui.contact.a.g(i);
        gVar.mVt = str;
        return gVar;
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.AlphabetContactAdapter", "finish!");
        if (this.ilb != null) {
            this.ilb.close();
            this.ilb = null;
        }
        g.Dr();
        ((h) g.h(h.class)).Ff().b(this);
    }

    public final void a(int i, m mVar, Object obj) {
        aJO();
        notifyDataSetChanged();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.yZN, this.yZI, this.pUr, this.yZJ, this.yZK, this.yZL};
        for (int i2 = 0; i2 < 6; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        if (this.yZP.indexOfKey(i) < 0) {
            return false;
        }
        return true;
    }
}
