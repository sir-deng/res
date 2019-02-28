package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.Vending.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public final class ax extends BaseAdapter implements x {
    private static HashMap<Long, a> rPz = new HashMap();
    private boolean gRq = false;
    av rPx;
    public aw rPy;

    static class a {
        int hge;
        String id;
        int mTE;
        int networkType;
        HashSet<Integer> rPB;
        HashSet<Integer> rPC;
        HashSet<Integer> rPD;
        HashSet<Integer> rPE;
        int rPF;
        long rPG;
        int rPH;
        int rPI;

        a() {
        }
    }

    public final /* bridge */ /* synthetic */ Vending bAe() {
        return this.rPy;
    }

    public final /* synthetic */ Object getItem(int i) {
        return xL(i);
    }

    public ax(MMActivity mMActivity, ListView listView, b bVar, j jVar, String str) {
        this.rPx = new av(mMActivity, listView, bVar, jVar, 10, this);
        this.rPx.rFe = true;
        this.rPy = new aw();
        aw awVar = this.rPy;
        av avVar = this.rPx;
        awVar.mContext = mMActivity;
        awVar.rPn = avVar;
        awVar.rOd = str;
        g.Dr();
        awVar.hji = ((h) g.h(h.class)).Ff();
        com.tencent.mm.vending.base.b bVar2 = this.rPy;
        com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "Vending.setRangeSize(%s)", Integer.valueOf(10));
        bVar2.zKw = 10;
        this.rPy.addVendingDataChangedCallback(new d() {
            public final void bCG() {
                ax.this.notifyDataSetChanged();
            }
        });
    }

    public final void kt() {
        if (!this.gRq) {
            this.gRq = true;
            this.rPy.notifyVendingDataChangeSynchronize();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.rPx.i(i, view);
    }

    public final int getViewTypeCount() {
        return 13;
    }

    public final int getItemViewType(int i) {
        return this.rPx.getItemViewType(i);
    }

    public final void bAd() {
        this.rPy.notifyVendingDataChange();
    }

    public final m xL(int i) {
        ay ayVar = (ay) this.rPy.get(i);
        if (ayVar == null) {
            return null;
        }
        return ayVar.qEj;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getCount() {
        return this.rPy.mCount;
    }

    public static void C(m mVar) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (!rPz.containsKey(Long.valueOf(j))) {
                a aVar = new a();
                if (mVar.byF() != null && mVar.byF().wYj != null && mVar.byF().wYj.wfg == 1 && mVar.byF().wYj.wfh != null && mVar.byF().wYj.wfh.size() > 0) {
                    aVar.hge = mVar.byF().wYj.wfh.size();
                    aVar.rPB = new HashSet();
                    aVar.rPC = new HashSet();
                    aVar.rPD = new HashSet();
                    aVar.rPE = new HashSet();
                    aVar.id = mVar.byF().nMq;
                    try {
                        blf n = ai.n(mVar);
                        aVar.rPH = n.wUP;
                        aVar.rPI = n.wUS;
                    } catch (Exception e) {
                        aVar.rPH = 0;
                        aVar.rPI = 0;
                    }
                    try {
                        g.Dr();
                        aVar.mTE = ((h) g.h(h.class)).aZO().Fs(mVar.field_userName);
                        long currentTimeMillis = System.currentTimeMillis();
                        g.Dr();
                        aVar.rPG = (currentTimeMillis - ((h) g.h(h.class)).aZO().Fy(mVar.field_userName)) / 1000;
                    } catch (Exception e2) {
                        aVar.mTE = 0;
                        aVar.rPG = 0;
                    }
                    rPz.put(Long.valueOf(j), aVar);
                }
            }
        }
    }

    public static void b(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (rPz.containsKey(Long.valueOf(j))) {
                a aVar = (a) rPz.get(Long.valueOf(j));
                if (aVar.rPF == 0) {
                    aVar.rPF = i + 1;
                }
                if (aVar.rPB == null) {
                    aVar.rPB = new HashSet();
                }
                aVar.rPB.add(Integer.valueOf(i + 1));
            }
        }
    }

    public static void c(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (rPz.containsKey(Long.valueOf(j))) {
                a aVar = (a) rPz.get(Long.valueOf(j));
                if (aVar.rPC == null) {
                    aVar.rPC = new HashSet();
                }
                if (!aVar.rPC.contains(Integer.valueOf(i + 1))) {
                    aVar.rPC.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void d(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (rPz.containsKey(Long.valueOf(j))) {
                a aVar = (a) rPz.get(Long.valueOf(j));
                if (aVar.rPD == null) {
                    aVar.rPD = new HashSet();
                }
                if (!aVar.rPD.contains(Integer.valueOf(i + 1))) {
                    aVar.rPD.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void e(m mVar, int i) {
        if (mVar != null) {
            long j = mVar.field_snsId;
            if (rPz.containsKey(Long.valueOf(j))) {
                a aVar = (a) rPz.get(Long.valueOf(j));
                if (aVar.rPE == null) {
                    aVar.rPE = new HashSet();
                }
                if (!aVar.rPE.contains(Integer.valueOf(i + 1))) {
                    aVar.rPE.add(Integer.valueOf(i + 1));
                }
            }
        }
    }

    public static void bCF() {
        for (Entry value : rPz.entrySet()) {
            String str;
            String str2;
            String str3;
            a aVar = (a) value.getValue();
            aVar.networkType = i.buW();
            x.d("MicroMsg.SnsTimeLineVendingAdapter", "report big pic click, picNum:%d, clickPicNum:%d, firstClickPos:%d, networkType:%d, id:%s", Integer.valueOf(aVar.hge), Integer.valueOf(aVar.rPB.size()), Integer.valueOf(aVar.rPF), Integer.valueOf(aVar.networkType), aVar.id);
            String str4 = "";
            Iterator it = aVar.rPC.iterator();
            while (true) {
                str = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = str + ((Integer) it.next()) + "|";
            }
            if (str.length() >= 2) {
                str = str.substring(0, str.length() - 1);
            }
            str4 = "";
            Iterator it2 = aVar.rPD.iterator();
            while (true) {
                str2 = str4;
                if (!it2.hasNext()) {
                    break;
                }
                str4 = str2 + ((Integer) it2.next()) + "|";
            }
            if (str2.length() >= 2) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            str4 = "";
            Iterator it3 = aVar.rPE.iterator();
            while (true) {
                str3 = str4;
                if (!it3.hasNext()) {
                    break;
                }
                str4 = str3 + ((Integer) it3.next()) + "|";
            }
            if (str3.length() >= 2) {
                str3 = str3.substring(0, str3.length() - 1);
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(11599, Integer.valueOf(aVar.hge), Integer.valueOf(aVar.rPB.size()), Integer.valueOf(aVar.rPF), Integer.valueOf(aVar.networkType), Integer.valueOf(0), aVar.id, Long.valueOf(aVar.rPG), Integer.valueOf(aVar.mTE), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aVar.rPH), Integer.valueOf(aVar.rPI), Integer.valueOf(0), str, str2, str3);
        }
        rPz.clear();
    }
}
