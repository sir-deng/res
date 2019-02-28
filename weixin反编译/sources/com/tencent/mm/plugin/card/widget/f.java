package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class f extends a {
    protected TextView ikL;
    public ArrayList<kr> kOB;
    private View lel;
    private ImageView lem;
    private TextView len;
    private TextView leo;
    private View lep;
    private TextView leq;
    private TextView ler;
    private ImageView les;
    private TextView let;

    public f(Context context) {
        super(context);
    }

    protected final void axU() {
        this.ikL = (TextView) axT().findViewById(R.h.bSn);
        this.lel = axT().findViewById(R.h.bPO);
        this.lem = (ImageView) axT().findViewById(R.h.cRt);
        this.len = (TextView) axT().findViewById(R.h.cRs);
        this.leo = (TextView) axT().findViewById(R.h.cRr);
        this.lep = axT().findViewById(R.h.cRv);
        this.leq = (TextView) axT().findViewById(R.h.cRx);
        this.ler = (TextView) axT().findViewById(R.h.cRw);
        this.les = (ImageView) axT().findViewById(R.h.cRu);
        this.let = (TextView) axT().findViewById(R.h.cRq);
    }

    protected final void axV() {
        if (this.kOv.aui().vZo != null && !TextUtils.isEmpty(this.kOv.aui().vZo.title)) {
            this.ldJ.setText(this.kOv.aui().vZo.title);
        } else if (TextUtils.isEmpty(this.kOv.aui().kQL)) {
            this.ldJ.setText("");
        } else {
            this.ldJ.setText(this.kOv.aui().kQL);
        }
        if (this.kOv.aui().vZo == null || TextUtils.isEmpty(this.kOv.aui().vZo.kPB)) {
            this.ikL.setText("");
            this.ikL.setVisibility(8);
        } else {
            this.ikL.setText(this.kOv.aui().vZo.kPB);
            this.ikL.setVisibility(0);
        }
        x.i("MicroMsg.CardWidgetTicket", "updateContentView()");
        if (bi.oN(this.kOv.aui().vYU)) {
            m.a(this.lem, R.g.bAw, l.xu(this.kOv.aui().hdx));
        } else {
            m.a(this.mContext, this.lem, this.kOv.aui().vYU, this.mContext.getResources().getDimensionPixelSize(R.f.bwH), R.g.bAw, l.xu(this.kOv.aui().hdx));
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        oy oyVar;
        if (this.kOv.aui().vYM != null && this.kOv.aui().vYM.size() >= 2) {
            x.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
            oyVar = (oy) this.kOv.aui().vYM.get(0);
            oy oyVar2 = (oy) this.kOv.aui().vYM.get(1);
            stringBuilder.append(oyVar.title).append(" - ").append(oyVar2.title);
            if (!(TextUtils.isEmpty(oyVar.kPC) || TextUtils.isEmpty(oyVar2.kPC))) {
                stringBuilder2.append(oyVar.kPC).append(" ").append(oyVar.kPB);
                stringBuilder2.append(" - ");
                stringBuilder2.append(oyVar2.kPC).append(" ").append(oyVar2.kPB);
            }
        } else if (this.kOv.aui().vYM != null && this.kOv.aui().vYM.size() == 1) {
            x.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
            oyVar = (oy) this.kOv.aui().vYM.get(0);
            stringBuilder.append(oyVar.title);
            stringBuilder2.append(oyVar.kPB);
        }
        if (TextUtils.isEmpty(stringBuilder.toString())) {
            this.len.setText("");
        } else {
            this.len.setText(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(stringBuilder2.toString())) {
            x.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
            this.leo.setText(stringBuilder2.toString());
            this.leo.setVisibility(0);
        } else if (TextUtils.isEmpty(this.kOv.aui().vZc)) {
            this.leo.setVisibility(8);
        } else {
            x.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
            this.leo.setText(this.kOv.aui().vZc);
            this.leo.setVisibility(0);
        }
        x.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.kOv.aui().vYQ);
        if (this.kOv.aui().vYQ <= 0) {
            this.lep.setVisibility(8);
            this.let.setVisibility(8);
        } else {
            kr krVar;
            this.lep.setVisibility(0);
            this.lep.setOnClickListener(this.iqi);
            m.a(this.les, R.g.bAx, l.xu(this.kOv.aui().hdx));
            if (this.kOB == null || this.kOB.size() <= 0) {
                krVar = null;
            } else {
                krVar = (kr) this.kOB.get(0);
            }
            if (this.kOv.aui().vYQ == 1 && krVar != null) {
                this.leq.setText(krVar.name);
                this.ler.setText(this.mContext.getString(R.l.dPE, new Object[]{l.f(this.mContext, krVar.vYA), krVar.hzf}));
                this.let.setVisibility(8);
                this.lep.setTag(krVar.name);
            } else if (this.kOv.aui().vYQ > 1 && krVar != null) {
                this.leq.setText(krVar.name);
                this.ler.setText(this.mContext.getString(R.l.dPE, new Object[]{l.f(this.mContext, krVar.vYA), krVar.hzf}));
                this.let.setVisibility(0);
                this.let.setOnClickListener(this.iqi);
                this.lep.setTag(krVar.name);
            } else if (this.kOv.aui().vYQ > 0) {
                this.leq.setText(R.l.dNV);
                this.ler.setText(this.mContext.getString(R.l.dPY, new Object[]{Integer.valueOf(this.kOv.aui().vYQ)}));
                this.let.setVisibility(8);
                this.let.setOnClickListener(null);
                this.lep.setTag(this.mContext.getString(R.l.dNV));
            }
        }
        if (this.kOv.auh()) {
            this.lel.setVisibility(8);
        } else {
            this.lel.setVisibility(0);
        }
    }
}
