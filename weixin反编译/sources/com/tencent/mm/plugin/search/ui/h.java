package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.protocal.c.bem;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class h extends LinearLayout implements OnClickListener {
    String fEe = null;
    String iVa = null;
    private TextView ikn = null;
    private List<View> qiw = new LinkedList();
    b qix = null;
    List<bem> qiy = null;

    private class a {
        public int position;
        public bem qiA;

        public a(bem bem, int i) {
            this.qiA = bem;
            this.position = i;
        }
    }

    public interface b {
        void a(bem bem, String str, int i);
    }

    static /* synthetic */ void a(h hVar) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        hVar.setOrientation(1);
        hVar.setGravity(16);
        hVar.setVisibility(8);
        try {
            dimensionPixelSize = hVar.getResources().getDimensionPixelSize(R.f.buX);
            dimensionPixelSize2 = hVar.getResources().getDimensionPixelSize(R.f.buW);
        } catch (Exception e) {
            dimensionPixelSize = com.tencent.mm.bu.a.fromDPToPix(hVar.getContext(), 48);
            dimensionPixelSize2 = com.tencent.mm.bu.a.fromDPToPix(hVar.getContext(), 13);
        }
        hVar.setMinimumHeight(dimensionPixelSize);
        LayoutParams layoutParams = (LayoutParams) hVar.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.leftMargin = dimensionPixelSize2;
        layoutParams.rightMargin = dimensionPixelSize2;
        hVar.setLayoutParams(layoutParams);
    }

    public h(Context context) {
        super(context);
        post(new Runnable() {
            public final void run() {
                h.a(h.this);
            }
        });
    }

    public final void onClick(View view) {
        if (this.qix != null && view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            this.qix.a(aVar.qiA, this.iVa, aVar.position);
        }
    }

    public final boolean a(bdc bdc, String str, String str2) {
        if (bdc == null || bdc.vPo == null) {
            x.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas param nil!");
            return false;
        }
        List<bem> list = bdc.vPo;
        List linkedList = new LinkedList();
        for (bem bem : list) {
            if (!bi.oN(bem.wRb)) {
                linkedList.add(bem);
            }
        }
        if (linkedList.size() <= 0) {
            x.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas size 0 items!");
            return false;
        }
        int i;
        this.fEe = str2;
        this.iVa = str;
        this.qiy = bdc.vPo;
        if (this.ikn == null) {
            this.ikn = new TextView(new ContextThemeWrapper(getContext(), R.m.eZf));
            this.ikn.setTextSize(15.0f);
            this.ikn.setPadding(0, com.tencent.mm.bu.a.fromDPToPix(getContext(), 10), 0, com.tencent.mm.bu.a.fromDPToPix(getContext(), 2));
            addView(this.ikn);
        }
        if (bi.oN(bdc.fpg)) {
            this.ikn.setText(R.l.eJl);
        } else {
            this.ikn.setText(bdc.fpg);
        }
        int size = ((linkedList.size() + 1) / 2) - this.qiw.size();
        for (i = 0; i < size; i++) {
            View inflate = View.inflate(getContext(), R.i.djg, null);
            addView(inflate);
            this.qiw.add(inflate);
            inflate.findViewById(R.h.ctN).setOnClickListener(this);
            inflate.findViewById(R.h.ctO).setOnClickListener(this);
        }
        int i2 = 0;
        for (View view : this.qiw) {
            if (i2 < linkedList.size()) {
                i = 0;
                int i3 = i2;
                while (true) {
                    int i4 = i;
                    if (i4 < 2) {
                        int i5;
                        a aVar = i3 < linkedList.size() ? new a((bem) linkedList.get(i3), i3 + 1) : null;
                        i = i3 % 2;
                        switch (i) {
                            case 0:
                                i = R.h.ctL;
                                i5 = R.h.ctN;
                                break;
                            case 1:
                                i = R.h.ctM;
                                i5 = R.h.ctO;
                                break;
                            default:
                                x.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configItemLinearLayout wrong Index:" + i);
                                break;
                        }
                        if (aVar == null) {
                            view.findViewById(i).setVisibility(8);
                        } else {
                            view.findViewById(i).setVisibility(0);
                            TextView textView = (TextView) view.findViewById(i5);
                            textView.setText(aVar.qiA.wRb);
                            textView.setTag(aVar);
                        }
                        i = i4 + 1;
                        i3++;
                    } else {
                        view.setVisibility(0);
                        i2 = i3;
                    }
                }
            } else {
                view.setVisibility(8);
            }
        }
        requestLayout();
        return true;
    }
}
