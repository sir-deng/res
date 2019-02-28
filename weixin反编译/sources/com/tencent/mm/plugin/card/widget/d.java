package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends a {
    private View ldU;
    private TextView ldV;
    private TextView ldW;
    private View ldX;
    private TextView ldY;
    private TextView ldZ;
    private View lea;
    private View leb;
    private View lec;

    public d(Context context) {
        super(context);
    }

    protected final void axU() {
        this.ldU = this.ldH.findViewById(R.h.cCv);
        this.ldV = (TextView) this.ldH.findViewById(R.h.cCx);
        this.ldW = (TextView) this.ldH.findViewById(R.h.cCw);
        this.ldX = this.ldH.findViewById(R.h.bNa);
        this.ldY = (TextView) this.ldH.findViewById(R.h.bNc);
        this.ldZ = (TextView) this.ldH.findViewById(R.h.bNb);
        this.leb = this.ldH.findViewById(R.h.bSw);
        this.lec = this.ldH.findViewById(R.h.bPP);
    }

    protected final void axV() {
        oy oyVar;
        if (this.kOv.aui().vYM == null || this.kOv.aui().vYM.size() <= 0) {
            x.i("MicroMsg.CardWidgetInvoice", "primary_fields is null");
        } else {
            LinkedList linkedList = this.kOv.aui().vYM;
            oy oyVar2 = null;
            if (linkedList.size() == 1) {
                oyVar = (oy) linkedList.get(0);
            } else {
                oyVar = (oy) linkedList.get(0);
                oyVar2 = (oy) linkedList.get(1);
            }
            if (oyVar != null) {
                this.ldU.setVisibility(0);
                this.ldV.setText(oyVar.title);
                this.ldW.setText(oyVar.kPB);
                if (!TextUtils.isEmpty(oyVar.vZR)) {
                    this.ldV.setTextColor(l.xu(oyVar.vZR));
                }
                if (!TextUtils.isEmpty(oyVar.vZS)) {
                    this.ldW.setTextColor(l.xu(oyVar.vZS));
                }
            }
            if (oyVar2 != null) {
                this.ldX.setVisibility(0);
                this.ldY.setText(oyVar2.title);
                this.ldZ.setText(oyVar2.kPB);
                if (!TextUtils.isEmpty(oyVar2.vZR)) {
                    this.ldY.setTextColor(l.xu(oyVar2.vZR));
                }
                if (!TextUtils.isEmpty(oyVar2.vZS)) {
                    this.ldZ.setTextColor(l.xu(oyVar2.vZS));
                }
            }
        }
        if (this.kOv.atN() && !this.kOv.atT()) {
            x.i("MicroMsg.CardWidgetInvoice", "is not invoice, don't updateCardSecondaryFieldListView");
        } else if (this.kOv.auj().vYj == null || this.kOv.auj().vYj.size() <= 0) {
            if (this.lea != null) {
                this.lea.setVisibility(8);
            }
            this.ldH.findViewById(R.h.bPP).setVisibility(8);
        } else {
            if (this.lea == null) {
                this.lea = ((ViewStub) this.ldH.findViewById(R.h.bRS)).inflate();
            }
            this.ldH.findViewById(R.h.bPP).setVisibility(8);
            View view = this.lea;
            b bVar = this.kOv;
            OnClickListener onClickListener = this.iqi;
            LinkedList linkedList2 = bVar.auj().vYj;
            if (linkedList2.size() == 1) {
                view.findViewById(R.h.bRW).setVisibility(0);
                oyVar = (oy) linkedList2.get(0);
                ((TextView) view.findViewById(R.h.cKv)).setText(oyVar.title);
                ((TextView) view.findViewById(R.h.cKs)).setText(oyVar.kPB);
                view.findViewById(R.h.bRW).setOnClickListener(onClickListener);
                if (!TextUtils.isEmpty(oyVar.vZR)) {
                    ((TextView) view.findViewById(R.h.cKv)).setTextColor(l.xu(oyVar.vZR));
                }
                if (!TextUtils.isEmpty(oyVar.vZS)) {
                    ((TextView) view.findViewById(R.h.cKs)).setTextColor(l.xu(oyVar.vZS));
                }
                view.findViewById(R.h.bRX).setVisibility(8);
            } else if (linkedList2.size() >= 2) {
                oyVar = (oy) linkedList2.get(0);
                ((TextView) view.findViewById(R.h.cKv)).setText(oyVar.title);
                ((TextView) view.findViewById(R.h.cKs)).setText(oyVar.kPB);
                if (!TextUtils.isEmpty(oyVar.vZR)) {
                    ((TextView) view.findViewById(R.h.cKv)).setTextColor(l.xu(oyVar.vZR));
                }
                if (!TextUtils.isEmpty(oyVar.vZS)) {
                    ((TextView) view.findViewById(R.h.cKs)).setTextColor(l.xu(oyVar.vZS));
                }
                oyVar = (oy) linkedList2.get(1);
                ((TextView) view.findViewById(R.h.cKw)).setText(oyVar.title);
                ((TextView) view.findViewById(R.h.cKt)).setText(oyVar.kPB);
                if (!TextUtils.isEmpty(oyVar.vZR)) {
                    ((TextView) view.findViewById(R.h.cKw)).setTextColor(l.xu(oyVar.vZR));
                }
                if (!TextUtils.isEmpty(oyVar.vZS)) {
                    ((TextView) view.findViewById(R.h.cKt)).setTextColor(l.xu(oyVar.vZS));
                }
                view.findViewById(R.h.bRW).setOnClickListener(onClickListener);
                view.findViewById(R.h.bRX).setOnClickListener(onClickListener);
            }
        }
        if (this.kOv.aue()) {
            this.leb.setVisibility(8);
        } else {
            this.leb.setVisibility(0);
            TextView textView = (TextView) this.leb.findViewById(R.h.bSf);
            if (TextUtils.isEmpty(this.kOv.aui().vZk)) {
                m.b(textView, this.kOv.auj().status);
            } else {
                textView.setText(this.kOv.aui().vZk);
            }
        }
        if (this.kOv.auj().vYs == null && this.kOv.aue()) {
            this.lec.setVisibility(0);
        } else {
            this.lec.setVisibility(8);
        }
    }
}
