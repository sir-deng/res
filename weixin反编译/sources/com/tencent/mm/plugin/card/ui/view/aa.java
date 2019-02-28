package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.pb.common.c.g;
import java.util.LinkedList;

public final class aa implements c {
    private BaseAdapter kUZ;
    private int kVd;
    protected LinkedList<CardTagTextView> kVh = new LinkedList();
    private int lbn;
    int lbo;
    int lbp;
    private Context mContext;

    public class a {
        public RelativeLayout kVl;
        public ImageView kVm;
        public TextView kVn;
        public TextView kVo;
        public TextView kVr;
        public ImageView laA;
        public View laz;
        public ImageView lbq;
        public LinearLayout lbr;
        public ImageView lbs;
        public ImageView lbt;
        public ImageView lbu;
        public TextView lcW;
        public TextView lcX;
        public TextView lcY;
        public TextView lcZ;
        public TextView lda;
    }

    public aa(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.kUZ = baseAdapter;
        this.lbn = this.mContext.getResources().getDimensionPixelSize(R.f.bvW);
        this.kVd = this.mContext.getResources().getDimensionPixelSize(R.f.bvC);
        this.lbo = this.mContext.getResources().getDimensionPixelOffset(R.f.bwq);
        this.lbp = this.mContext.getResources().getDimensionPixelOffset(R.f.bwr);
    }

    public final void release() {
        this.mContext = null;
        this.kUZ = null;
        if (this.kVh != null) {
            this.kVh.clear();
        }
    }

    public final View a(int i, View view, b bVar) {
        View inflate;
        a aVar;
        if (view == null) {
            switch (this.kUZ.getItemViewType(i)) {
                case 0:
                    inflate = View.inflate(this.mContext, R.i.dcr, null);
                    TextView textView;
                    if (!bVar.aum().equals("PRIVATE_TICKET_TITLE")) {
                        if (bVar.aum().equals("PRIVATE_INVOICE_TITLE")) {
                            textView = (TextView) inflate.findViewById(R.h.bRh);
                            if (textView != null) {
                                textView.setText(this.mContext.getString(R.l.dOD));
                                break;
                            }
                        }
                    }
                    textView = (TextView) inflate.findViewById(R.h.bRh);
                    if (textView != null) {
                        textView.setText(this.mContext.getString(R.l.dPW));
                        break;
                    }
                    break;
                case 1:
                    inflate = View.inflate(this.mContext, R.i.dcp, null);
                    break;
                case 2:
                    inflate = View.inflate(this.mContext, R.i.dcu, null);
                    break;
                default:
                    inflate = View.inflate(this.mContext, R.i.dcp, null);
                    break;
            }
            a aVar2 = new a();
            if (bVar.aum().equals("PRIVATE_TICKET_TITLE") || bVar.aum().equals("PRIVATE_INVOICE_TITLE")) {
                aVar2.lcW = (TextView) inflate.findViewById(R.h.bRh);
            } else if (bVar.atT()) {
                aVar2.lcX = (TextView) inflate.findViewById(R.h.bRm);
                aVar2.lcY = (TextView) inflate.findViewById(R.h.bRj);
                aVar2.lcZ = (TextView) inflate.findViewById(R.h.bRk);
                aVar2.lda = (TextView) inflate.findViewById(R.h.bRl);
            } else {
                aVar2.kVl = (RelativeLayout) inflate.findViewById(R.h.bQk);
                aVar2.kVm = (ImageView) inflate.findViewById(R.h.bQZ);
                aVar2.laz = inflate.findViewById(R.h.bSs);
                aVar2.laA = (ImageView) inflate.findViewById(R.h.bSr);
                aVar2.kVn = (TextView) inflate.findViewById(R.h.bPQ);
                aVar2.kVo = (TextView) inflate.findViewById(R.h.bRy);
                aVar2.kVr = (TextView) inflate.findViewById(R.h.bRz);
                aVar2.lbq = (ImageView) inflate.findViewById(R.h.bPE);
                aVar2.lbs = (ImageView) inflate.findViewById(R.h.bPL);
                aVar2.lbt = (ImageView) inflate.findViewById(R.h.bPN);
                aVar2.lbu = (ImageView) inflate.findViewById(R.h.bPM);
                aVar2.lbr = (LinearLayout) inflate.findViewById(R.h.bRR);
            }
            inflate.setTag(aVar2);
            aVar = aVar2;
            view = inflate;
        } else {
            a aVar3 = (a) view.getTag();
            if (aVar3.lcW != null) {
                if (bVar.aum().equals("PRIVATE_TICKET_TITLE")) {
                    aVar3.lcW.setText(this.mContext.getString(R.l.dPW));
                    aVar = aVar3;
                } else {
                    aVar3.lcW.setText(this.mContext.getString(R.l.dOD));
                }
            }
            aVar = aVar3;
        }
        if (aVar.kVo != null) {
            aVar.kVo.setTextSize(0, this.mContext.getResources().getDimension(R.f.buv));
        }
        if (bVar.atU()) {
            if (bVar.aum().equals("PRIVATE_TICKET_TITLE")) {
                aVar.lcW.setText(this.mContext.getString(R.l.dPW));
            } else if (bVar.aum().equals("PRIVATE_INVOICE_TITLE")) {
                aVar.lcW.setText(this.mContext.getString(R.l.dOD));
            } else if (bVar.atT()) {
                LinkedList linkedList = bVar.aui().vYM;
                aVar.lcX.setText(((oy) linkedList.get(0)).kPB);
                aVar.lcZ.setText(((oy) linkedList.get(1)).kPB);
                linkedList = bVar.auj().vYj;
                aVar.lda.setText(String.format(this.mContext.getString(R.l.bRl), new Object[]{((oy) linkedList.get(0)).kPB}));
                if (linkedList.size() >= 2) {
                    aVar.lcY.setText(((oy) linkedList.get(1)).kPB);
                }
            } else {
                if (this.kUZ.getItem(i) instanceof CardInfo) {
                    CardInfo cardInfo = (CardInfo) this.kUZ.getItem(i);
                    if (!(cardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE") || cardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE"))) {
                        CharSequence a;
                        boolean z;
                        if (cardInfo.field_stickyIndex % 10 != 0) {
                            if (cardInfo.field_stickyIndex > 0) {
                                a = j.a(this.mContext, cardInfo.field_stickyIndex, cardInfo);
                                z = true;
                            }
                            z = false;
                            a = null;
                        } else {
                            if (!g.Bf(cardInfo.field_label_wording)) {
                                Object a2 = cardInfo.field_label_wording;
                                z = true;
                            }
                            z = false;
                            a2 = null;
                        }
                        if (z) {
                            for (int i2 = 0; i2 < aVar.lbr.getChildCount(); i2++) {
                                this.kVh.add((CardTagTextView) aVar.lbr.getChildAt(i2));
                            }
                            aVar.lbr.removeAllViews();
                            aVar.lbr.setVisibility(0);
                            if (this.kVh.size() == 0) {
                                inflate = new CardTagTextView(this.mContext);
                            } else {
                                CardTagTextView cardTagTextView = (CardTagTextView) this.kVh.removeFirst();
                            }
                            inflate.setPadding(this.kVd, this.lbn, this.kVd, this.lbn);
                            inflate.setGravity(17);
                            inflate.setMinWidth(this.mContext.getResources().getDimensionPixelSize(R.f.bwt));
                            inflate.setMinHeight(this.mContext.getResources().getDimensionPixelSize(R.f.bws));
                            if (cardInfo.atP()) {
                                inflate.setTextColor(com.tencent.mm.bu.a.c(this.mContext, R.e.white));
                                inflate.fillColor = com.tencent.mm.bu.a.c(this.mContext, R.e.brP);
                            } else {
                                inflate.setTextColor(com.tencent.mm.bu.a.c(this.mContext, R.e.btd));
                                inflate.fillColor = 0;
                            }
                            inflate.setText(a2);
                            inflate.setTextSize(1, 10.0f);
                            aVar.lbr.addView(inflate);
                        } else {
                            aVar.lbr.setVisibility(8);
                        }
                    }
                }
                aVar.kVl.setVisibility(0);
                aVar.kVm.setVisibility(0);
                aVar.kVo.setVisibility(0);
                aVar.kVr.setVisibility(8);
                aVar.kVn.setVisibility(0);
                aVar.kVn.setText(bVar.aui().kQL);
                aVar.kVo.setText(bVar.aui().title);
                if (bVar.atR()) {
                    aVar.laz.setVisibility(0);
                    aVar.kVm.setVisibility(4);
                    ImageView imageView = aVar.laA;
                    if (TextUtils.isEmpty(bVar.aui().vYU)) {
                        m.a(imageView, R.g.bAw, l.xu(bVar.aui().hdx));
                    } else {
                        m.a(this.mContext, imageView, bVar.aui().vYU, this.mContext.getResources().getDimensionPixelSize(R.f.bwu), R.g.bAw, l.xu(bVar.aui().hdx));
                    }
                } else {
                    aVar.laz.setVisibility(8);
                    aVar.kVm.setVisibility(0);
                    m.a(aVar.kVm, bVar.aui().kPA, this.mContext.getResources().getDimensionPixelSize(R.f.bwu), R.g.bDU, true);
                }
                if (bVar.atP()) {
                    if (bi.oN(bVar.auj().vYt)) {
                        aVar.kVl.setBackgroundDrawable(l.cm(l.xu(bVar.aui().hdx), this.lbo));
                        aVar.lbs.setVisibility(8);
                        aVar.lbt.setVisibility(8);
                        aVar.lbu.setVisibility(0);
                    } else {
                        aVar.kVl.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bAr));
                        aVar.lbs.setVisibility(0);
                        aVar.lbt.setVisibility(0);
                        ImageView imageView2 = aVar.lbs;
                        String str = bVar.auj().vYt;
                        com.tencent.mm.ap.a.a.c.a aVar4 = new com.tencent.mm.ap.a.a.c.a();
                        aVar4.hFo = e.bnF;
                        o.PH();
                        aVar4.hFH = null;
                        aVar4.hFn = com.tencent.mm.plugin.card.model.m.wQ(str);
                        aVar4.hFl = true;
                        aVar4.hFL = true;
                        aVar4.hFj = true;
                        aVar4.hFA = R.g.bAr;
                        aVar4.hFs = com.tencent.mm.bu.a.aa(this.mContext, R.f.bwr);
                        aVar4.hFr = com.tencent.mm.bu.a.eB(this.mContext);
                        o.PG().a(str, imageView2, aVar4.PQ());
                        imageView2.setImageMatrix(new Matrix());
                        aVar.lbu.setVisibility(8);
                    }
                    aVar.kVn.setTextColor(this.mContext.getResources().getColor(R.e.white));
                    aVar.kVo.setTextColor(this.mContext.getResources().getColor(R.e.white));
                } else {
                    aVar.lbu.setVisibility(8);
                    aVar.lbs.setVisibility(8);
                    aVar.lbt.setVisibility(8);
                    aVar.kVl.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bAr));
                    aVar.kVo.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                    aVar.kVn.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                }
            }
        } else if (!(bVar.aum().equals("PRIVATE_TICKET_TITLE") || bVar.aum().equals("PRIVATE_INVOICE_TITLE") || bVar.atT())) {
            aVar.kVm.setVisibility(8);
            aVar.kVo.setVisibility(8);
            aVar.kVn.setVisibility(8);
            aVar.lbr.setVisibility(8);
            aVar.kVr.setVisibility(0);
            aVar.kVl.setBackgroundDrawable(l.cm(this.mContext.getResources().getColor(R.e.brO), this.lbo));
            aVar.kVr.setText(this.mContext.getResources().getString(R.l.dPc));
        }
        if (!(bVar.aum().equals("PRIVATE_TICKET_TITLE") || bVar.aum().equals("PRIVATE_INVOICE_TITLE") || bVar.atT())) {
            int i3 = bVar.aui().kPz;
            LayoutParams layoutParams;
            if (i != this.kUZ.getCount() - 1 || aVar.kVl == null) {
                layoutParams = (LayoutParams) aVar.kVl.getLayoutParams();
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    aVar.kVl.setLayoutParams(layoutParams);
                }
            } else {
                layoutParams = (LayoutParams) aVar.kVl.getLayoutParams();
                if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(R.f.bvA)) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvA);
                    aVar.kVl.setLayoutParams(layoutParams);
                }
            }
        }
        return view;
    }

    public final void u(View view, int i) {
        ((com.tencent.mm.plugin.card.ui.l.a) view.getTag()).lbq.setImageResource(i);
    }

    public final void v(View view, int i) {
        ((com.tencent.mm.plugin.card.ui.l.a) view.getTag()).lbq.setVisibility(i);
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
        CardInfo cardInfo = (CardInfo) this.kUZ.getItem(i);
        if (!cardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE") && !cardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            a aVar = (a) view.getTag();
            aVar.lbq.setTag(Integer.valueOf(i));
            aVar.lbq.setOnClickListener(onClickListener);
        }
    }
}
