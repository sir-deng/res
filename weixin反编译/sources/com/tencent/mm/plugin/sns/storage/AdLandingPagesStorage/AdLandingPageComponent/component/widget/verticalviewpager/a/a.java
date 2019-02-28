package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public final class a extends android.support.v7.widget.RecyclerView.a<t> implements b {
    int bgColor;
    private Context context;
    private int kJB;
    private int kJC;
    private LinearLayoutManager roJ;
    c rsR;
    LinkedHashMap<String, i> rsS = new LinkedHashMap();
    private LayoutInflater rsT;

    public class a extends t {
        private LinearLayout iYQ;

        public a(View view) {
            super(view);
            this.iYQ = (LinearLayout) view.findViewById(f.cIB);
        }
    }

    public a(c cVar, int i, Context context, LinearLayoutManager linearLayoutManager) {
        this.roJ = linearLayoutManager;
        this.rsR = cVar;
        this.bgColor = i;
        this.context = context;
        this.rsT = (LayoutInflater) this.context.getSystemService("layout_inflater");
        int[] dw = ac.dw(this.context);
        this.kJB = dw[0];
        this.kJC = dw[1];
    }

    public final t a(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(g.qMr, viewGroup, false));
    }

    public final void a(t tVar, int i) {
        x.i("ContentAdapter", "display page " + this.rsR.id + ", pos " + i);
        a aVar = (a) tVar;
        aVar.iYQ.removeAllViews();
        s sVar = (s) this.rsR.rtT.get(i);
        i iVar = (i) this.rsS.get(sVar.rmN);
        int i2 = this.bgColor;
        if (sVar.rmW != null && sVar.rmW.length() > 0) {
            try {
                i2 = Color.parseColor(sVar.rmW);
                aVar.iYQ.setBackgroundColor(i2);
            } catch (Exception e) {
                x.e("ContentAdapter", "parse cellBackgroundColor error: %s", sVar.rmW);
            }
        }
        if (iVar != null) {
            iVar.a((s) this.rsR.rtT.get(i));
        } else {
            iVar = am.a(aVar.iYQ.getContext(), sVar, aVar.iYQ, i2);
            if (iVar != null) {
                this.rsS.put(sVar.rmN, iVar);
            }
        }
        if (iVar != null) {
            if (iVar.getView().getParent() != null && (iVar.getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) iVar.getView().getParent()).removeView(iVar.getView());
            }
            aVar.iYQ.addView(iVar.getView());
        }
    }

    public final int getItemViewType(int i) {
        return i;
    }

    public final int getItemCount() {
        return this.rsR.rtT.size();
    }

    public final boolean xv(int i) {
        if (i < this.roJ.fa() || i > this.roJ.fb()) {
            x.v("ContentAdapter", "index %d not visible");
            return false;
        }
        i iVar = (i) this.rsS.get(((s) this.rsR.rtT.get(i)).rmN);
        if (iVar == null) {
            return false;
        }
        x.v("ContentAdapter", "comp %s, inScreenH %d", iVar, Integer.valueOf(a(iVar)));
        return a(iVar) >= (iVar.getView().getHeight() >>> 1);
    }

    private int a(i iVar) {
        if (iVar != null) {
            View view = iVar.getView();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[1];
            int height = view.getHeight() + i;
            x.v("ContentAdapter", "comp %s , top %d,bottom %d ", iVar, Integer.valueOf(i), Integer.valueOf(height));
            if (i >= 0 && height <= this.kJC) {
                return view.getHeight();
            }
            if (i < 0 && height > 0 && height <= this.kJC) {
                return height;
            }
            if (i < 0 && height > this.kJC) {
                return this.kJC;
            }
            if (i < this.kJC && height > this.kJC) {
                return this.kJC - i;
            }
        }
        return 0;
    }

    public final void a(int i, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b bVar) {
        s sVar = (s) this.rsR.rtT.get(i);
        i iVar = (i) this.rsS.get(sVar.rmN);
        if (iVar != null) {
            iVar.bxr();
            iVar.X(a(iVar), iVar.getView().getHeight(), this.kJC);
            if (sVar.type == 61 || sVar.type == 62) {
                List<Integer> arrayList = new ArrayList();
                for (Entry entry : bVar.roI.entrySet()) {
                    if (((a) entry.getValue()).rlH) {
                        arrayList.add(entry.getKey());
                    }
                }
                for (Integer intValue : arrayList) {
                    int intValue2 = intValue.intValue();
                    if (intValue2 != i && xv(intValue2)) {
                        i iVar2 = (i) this.rsS.get(((s) this.rsR.rtT.get(intValue2)).rmN);
                        if (iVar2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar2;
                            if (aVar.rlF && this.rsR.rtU && intValue2 == 0) {
                                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).bxp();
                            } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).rlF) {
                                aVar.bxp();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void xu(int i) {
        if (i < 0 || i >= this.rsR.rtT.size()) {
            x.w("ContentAdapter", "endExposure index[%d], size[%d]", Integer.valueOf(i), Integer.valueOf(this.rsR.rtT.size()));
            return;
        }
        i iVar = (i) this.rsS.get(((s) this.rsR.rtT.get(i)).rmN);
        if (iVar != null) {
            iVar.bxs();
        }
    }

    public final void onDestroy() {
        for (Entry value : this.rsS.entrySet()) {
            ((i) value.getValue()).bxq();
        }
    }
}
