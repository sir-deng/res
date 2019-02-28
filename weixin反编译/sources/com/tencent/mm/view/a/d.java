package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.view.SmileyGrid;
import com.tencent.mm.view.SmileySubGrid;

public final class d extends y {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter";
    private Context mContext;
    public int mCount;
    private com.tencent.mm.view.f.a zMB;
    public boolean zNC;
    private View zND;

    class a {
        RecommendView zNF;
        SmileySubGrid zNG;

        public a(View view, com.tencent.mm.view.f.a.a aVar) {
            switch (AnonymousClass1.zNE[aVar.ordinal()]) {
                case 1:
                    this.zNF = (RecommendView) view;
                    return;
                case 2:
                case 3:
                    this.zNG = (SmileySubGrid) view.findViewById(e.lPe);
                    return;
                default:
                    return;
            }
        }
    }

    public d(com.tencent.mm.view.f.a aVar, Context context) {
        this.mContext = context;
        this.zMB = aVar;
    }

    public final View d(int i, View view) {
        a aVar;
        com.tencent.mm.view.c.a HQ = this.zMB.HQ(i);
        String str = HQ.lEs;
        com.tencent.mm.view.f.a.a aVar2 = "TAG_DEFAULT_TAB".equals(str) ? com.tencent.mm.view.f.a.a.DEFAULT : (String.valueOf(EmojiGroupInfo.xIF).equals(str) || String.valueOf(EmojiGroupInfo.xIE).equals(str)) ? com.tencent.mm.view.f.a.a.EMOJI : !HQ.zPc ? com.tencent.mm.view.f.a.a.RECOMMEND : com.tencent.mm.view.f.a.a.EMOJI;
        if (view == null || view.getTag() == null || view.getTag(e.lPf) != aVar2) {
            View h;
            switch (aVar2) {
                case RECOMMEND:
                    h = com.tencent.mm.pluginsdk.ui.chat.e.vya.h(this.mContext, this.zMB.cBT());
                    break;
                default:
                    h = LayoutInflater.from(this.mContext).inflate(f.lPp, null);
                    break;
            }
            a aVar3 = new a(h, aVar2);
            h.setTag(aVar3);
            h.setTag(e.lPf, aVar2);
            aVar = aVar3;
            view = h;
        } else {
            a aVar4 = (a) view.getTag();
            view.setTag(e.lPf, aVar2);
            aVar = aVar4;
        }
        int i2;
        switch (aVar2) {
            case RECOMMEND:
                aVar.zNF.zt(HQ.lEs);
                break;
            case DEFAULT:
                com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a aVar5;
                b bVar = new b(this.mContext, this.zMB);
                aVar.zNG.setAdapter((ListAdapter) bVar);
                aVar.zNG.cBd();
                aVar.zNG.vyr = HQ.cBf();
                SmileyGrid smileyGrid = aVar.zNG;
                com.tencent.mm.view.e.a aVar6 = HQ.zOZ;
                if (aVar6.zPt == null) {
                    aVar5 = null;
                } else {
                    aVar5 = aVar6.zPt.cBe();
                }
                smileyGrid.zMx = aVar5;
                aVar.zNG.setNumColumns(HQ.tmv);
                aVar.zNG.setColumnWidth(HQ.getColumnWidth());
                aVar.zNG.setScrollbarFadingEnabled(false);
                aVar.zNG.setVerticalScrollBarEnabled(false);
                aVar.zNG.setSelector(com.tencent.mm.plugin.m.a.d.bDK);
                aVar.zNG.setHorizontalScrollBarEnabled(false);
                aVar.zNG.setVerticalScrollBarEnabled(false);
                aVar.zNG.setLongClickable(false);
                aVar.zNG.cBd();
                i2 = this.zMB.abc(HQ.lEs).zPb;
                aVar.zNG.setPadding(0, i2 == 0 ? this.zMB.zPM : i2, 0, 0);
                aVar.zNG.setVerticalSpacing(i2 / 2);
                aVar.zNG.j(HQ.getType(), i - HQ.kgz, HQ.zPa, HQ.aoa(), HQ.cBA());
                aVar.zNG.zNq = false;
                aVar.zNG.itU = this.zMB.itU;
                bVar.c(HQ.getType(), HQ.zPa, HQ.aoa(), HQ.cBA(), i - HQ.kgz, HQ.tmu, HQ.tmv);
                bVar.zNw = HQ.lEs;
                break;
            case EMOJI:
                c cVar = new c(this.mContext, this.zMB);
                aVar.zNG.setAdapter((ListAdapter) cVar);
                aVar.zNG.cBd();
                aVar.zNG.setNumColumns(HQ.tmv);
                aVar.zNG.setColumnWidth(HQ.getColumnWidth());
                aVar.zNG.setScrollbarFadingEnabled(false);
                aVar.zNG.setHorizontalScrollBarEnabled(false);
                aVar.zNG.setVerticalScrollBarEnabled(false);
                aVar.zNG.vyr = HQ.cBf();
                aVar.zNG.setFastScrollEnabled(false);
                aVar.zNG.zNk = HQ.zOZ.zPi;
                aVar.zNG.cBd();
                i2 = this.zMB.abc(HQ.lEs).zPb;
                aVar.zNG.setPadding(0, i2 == 0 ? this.zMB.zPM : i2, 0, 0);
                aVar.zNG.setVerticalSpacing(i2 / 2);
                aVar.zNG.zNq = true;
                aVar.zNG.itU = this.zMB.itU;
                aVar.zNG.j(HQ.getType(), i - HQ.kgz, HQ.zPa, HQ.aoa(), HQ.cBA());
                cVar.c(HQ.getType(), HQ.zPa, HQ.tmv * HQ.tmu, HQ.cBA(), i - HQ.kgz, HQ.tmu, HQ.tmv);
                cVar.zNw = HQ.lEs;
                if (cVar.zMu != 23) {
                    if (cVar.zMu == 25) {
                        cVar.lJz = ((c) g.k(c.class)).getProvider().aBK();
                        break;
                    }
                }
                cVar.lJz = ((c) g.k(c.class)).getProvider().yT(cVar.zNw);
                break;
                break;
        }
        this.zND = view;
        return view;
    }

    public final int getCount() {
        return this.mCount;
    }

    public final int k(Object obj) {
        if (!this.zNC) {
            return super.k(obj);
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "get item position always changed");
        return -2;
    }

    public final void cBi() {
        com.tencent.mm.view.f.a aVar = this.zMB;
        this.mCount = aVar.zPP ? aVar.abc("TAG_DEFAULT_TAB").cBA() : aVar.mSW;
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPagerAdapter", "refresh data mCount:%d", Integer.valueOf(this.mCount));
    }
}
