package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class h {
    private int bgColor;
    private Context context;
    private int kJB;
    private int kJC;
    private ViewGroup pxU;
    private LinkedHashMap<String, i> rsS;
    private LayoutInflater rsT;
    private List<s> ruA;

    public h(List<s> list, Context context, int i, ViewGroup viewGroup) {
        this.ruA = list;
        this.context = context;
        this.bgColor = i;
        this.pxU = viewGroup;
    }

    public final void bR(List<s> list) {
        if (list != null && !list.equals(this.ruA)) {
            this.ruA = list;
            layout();
        }
    }

    public final void layout() {
        if (this.ruA != null && !this.ruA.isEmpty()) {
            if (this.rsS == null) {
                this.rsS = new LinkedHashMap();
            }
            if (this.rsT == null) {
                this.rsT = (LayoutInflater) this.context.getSystemService("layout_inflater");
                WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
                this.kJB = windowManager.getDefaultDisplay().getWidth();
                this.kJC = windowManager.getDefaultDisplay().getHeight();
            }
            for (int i = 0; i < this.ruA.size(); i++) {
                s sVar = (s) this.ruA.get(i);
                i iVar = (i) this.rsS.get(sVar.rmN);
                if (iVar != null) {
                    iVar.a(sVar);
                } else {
                    iVar = am.a(this.context, sVar, this.pxU, this.bgColor);
                    if (iVar != null) {
                        this.rsS.put(sVar.rmN, iVar);
                    }
                }
                try {
                    if (this.pxU != iVar.getView().getParent()) {
                        if (this.pxU.getChildCount() > i) {
                            this.pxU.addView(iVar.getView(), i);
                        } else {
                            this.pxU.addView(iVar.getView());
                        }
                    }
                } catch (Throwable e) {
                    x.e("CompRenderer", "component may have same id %s,%s", sVar.rmN, bi.i(e));
                }
            }
        }
    }

    public final Collection<i> byr() {
        return this.rsS == null ? Collections.EMPTY_LIST : this.rsS.values();
    }
}
