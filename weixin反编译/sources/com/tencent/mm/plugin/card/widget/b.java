package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.protocal.c.bsv;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class b extends a {
    private final String TAG = "MicroMsg.CardWidgetCommon";
    protected TextView jtn;
    private boolean lbI = false;
    protected TextView ldK;
    protected TextView ldL;
    protected Button ldM;
    protected LinearLayout ldN;
    protected TextView ldO;
    protected ImageView ldP;
    protected View ldQ;
    protected ImageView ldR;

    public b(Context context) {
        super(context);
    }

    protected final void axU() {
        this.jtn = (TextView) this.ldH.findViewById(R.h.bSn);
        this.ldK = (TextView) this.ldH.findViewById(R.h.bSh);
        this.ldL = (TextView) this.ldH.findViewById(R.h.bPI);
        this.ldM = (Button) this.ldH.findViewById(R.h.bQi);
        this.ldN = (LinearLayout) this.ldH.findViewById(R.h.cZM);
        this.ldP = (ImageView) this.ldN.findViewById(R.h.bKK);
        this.ldQ = this.ldH.findViewById(R.h.bPO);
        this.ldR = (ImageView) this.ldH.findViewById(R.h.bQd);
        this.ldO = (TextView) this.ldH.findViewById(R.h.bRB);
    }

    protected final void axV() {
        if (this.kOv.aui().vYM != null && this.kOv.aui().vYM.size() > 0) {
            oy oyVar = (oy) this.kOv.aui().vYM.get(0);
            if (!bi.oN(oyVar.title)) {
                this.jtn.setText(oyVar.title);
            }
            if (bi.oN(oyVar.kPB)) {
                this.ldK.setVisibility(8);
            } else {
                this.ldK.setText(oyVar.kPB);
                this.ldK.setVisibility(0);
            }
            LayoutParams layoutParams = (LayoutParams) this.ldK.getLayoutParams();
            if (bi.oN(oyVar.kPC)) {
                this.ldL.setVisibility(8);
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bvx);
            } else {
                this.ldL.setText(oyVar.kPC);
                this.ldL.setVisibility(0);
                layoutParams.bottomMargin = 0;
            }
            this.ldK.setLayoutParams(layoutParams);
            this.ldK.invalidate();
        }
        if (this.ldM == null || this.ldR == null) {
            x.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
        } else if (this.kOv.auj() == null) {
            x.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
            this.ldM.setVisibility(8);
            this.ldR.setVisibility(8);
        } else {
            if (this.kOv.auj().vYq != null) {
                x.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.kOv.auj().vYq.title);
                x.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.kOv.auj().vYq.url);
                x.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.kOv.auj().vYq.kPC);
            }
            oy oyVar2 = this.kOv.auj().vYr;
            if (oyVar2 != null) {
                x.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + oyVar2.title);
                x.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + oyVar2.vZQ);
                x.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + oyVar2.kPC);
            }
            bsv bsv = this.kOv.aui().vZf;
            LinearLayout linearLayout = (LinearLayout) this.ldN.findViewById(R.h.bQr);
            if (bsv == null || bi.cC(bsv.xaK)) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                linearLayout.removeAllViews();
                Iterator it = bsv.xaK.iterator();
                while (it.hasNext()) {
                    oy oyVar3 = (oy) it.next();
                    View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dcb, null);
                    TextView textView = (TextView) inflate.findViewById(R.h.bQq);
                    ((TextView) inflate.findViewById(R.h.bQu)).setText(oyVar3.title);
                    textView.setText(oyVar3.kPB);
                    linearLayout.addView(inflate);
                }
            }
            if (oyVar2 != null && !TextUtils.isEmpty(oyVar2.title) && oyVar2.vZQ != 0 && this.kOv.aue()) {
                this.ldM.setClickable(false);
                this.ldM.setVisibility(0);
                this.ldM.setTextColor(this.mContext.getResources().getColor(R.e.bum));
                this.ldM.setText(oyVar2.title);
                if (oyVar2 == null || TextUtils.isEmpty(oyVar2.kPB)) {
                    this.ldO.setVisibility(8);
                } else {
                    this.ldO.setText(oyVar2.kPB);
                    this.ldO.setVisibility(0);
                }
                this.ldR.setVisibility(8);
                if ((oyVar2.vZQ & 2) > 0) {
                    this.ldM.setBackgroundDrawable(l.z(this.mContext, l.bc(this.kOv.aui().hdx, 150)));
                    this.ldO.setTextColor(l.xu(this.kOv.aui().hdx));
                } else if ((oyVar2.vZQ & 4) > 0) {
                    this.ldM.setBackgroundDrawable(l.z(this.mContext, this.mContext.getResources().getColor(R.e.bsZ)));
                    this.ldO.setTextColor(this.mContext.getResources().getColor(R.e.bts));
                } else {
                    this.ldM.setBackgroundDrawable(l.z(this.mContext, l.xu(this.kOv.aui().hdx)));
                    this.ldO.setTextColor(this.mContext.getResources().getColor(R.e.bts));
                }
            } else if (this.kOv.auj().vYq != null && !TextUtils.isEmpty(this.kOv.auj().vYq.title) && !TextUtils.isEmpty(this.kOv.auj().vYq.url) && this.kOv.aue()) {
                this.ldM.setClickable(true);
                this.ldM.setVisibility(0);
                this.ldM.setBackgroundDrawable(l.z(this.mContext, l.xu(this.kOv.aui().hdx)));
                this.ldM.setTextColor(this.mContext.getResources().getColorStateList(R.e.bum));
                this.ldM.setText(this.kOv.auj().vYq.title);
                if (this.kOv.auj().vYq == null || TextUtils.isEmpty(this.kOv.auj().vYq.kPC)) {
                    this.ldO.setVisibility(8);
                } else {
                    this.ldO.setTextColor(this.mContext.getResources().getColor(R.e.bts));
                    this.ldO.setText(this.kOv.auj().vYq.kPC);
                    this.ldO.setVisibility(0);
                }
                if (TextUtils.isEmpty(this.kOv.auj().code)) {
                    this.ldR.setVisibility(8);
                } else {
                    this.ldR.setVisibility(0);
                }
            } else if (!TextUtils.isEmpty(this.kOv.auj().code) && this.kOv.aue()) {
                x.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
                this.ldR.setVisibility(8);
                this.ldO.setVisibility(8);
                this.ldM.setClickable(true);
                this.ldM.setVisibility(0);
                this.ldM.setBackgroundDrawable(l.z(this.mContext, l.xu(this.kOv.aui().hdx)));
                this.ldM.setTextColor(this.mContext.getResources().getColorStateList(R.e.bum));
                this.ldM.setText(R.l.dPN);
            } else if (this.kOv.aue()) {
                x.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
                this.ldM.setVisibility(8);
                this.ldO.setVisibility(8);
                this.ldR.setVisibility(8);
            } else {
                x.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.kOv.auj().status);
                this.ldR.setVisibility(8);
                this.ldO.setVisibility(8);
                this.ldM.setClickable(true);
                this.ldM.setVisibility(0);
                this.ldM.setTextColor(this.mContext.getResources().getColor(R.e.bsF));
                this.ldM.setBackgroundDrawable(l.z(this.mContext, this.mContext.getResources().getColor(R.e.brG)));
                if (TextUtils.isEmpty(this.kOv.aui().vZk)) {
                    m.b(this.ldM, this.kOv.auj().status);
                } else {
                    this.ldM.setText(this.kOv.aui().vZk);
                }
            }
        }
        axW();
        this.ldN.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bAC));
        axX();
        this.ldH.invalidate();
    }

    private void axW() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ldN.getLayoutParams();
        if (this.kOv.atN()) {
            this.ldI.setVisibility(0);
            this.ldP.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bwk);
        } else if (this.kOv.atO() && this.lbI) {
            this.ldI.setVisibility(8);
            this.ldP.setVisibility(8);
            layoutParams.topMargin = 0;
        } else if (this.kOv.atO()) {
            this.ldI.setVisibility(0);
            this.ldP.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bwk);
        }
        this.ldN.setLayoutParams(layoutParams);
    }

    public final void ot(int i) {
        RelativeLayout.LayoutParams layoutParams;
        this.ldN.setBackgroundResource(i);
        this.ldP.setVisibility(8);
        if (i == 0) {
            layoutParams = (RelativeLayout.LayoutParams) this.ldN.getLayoutParams();
            if (this.kOv.atN()) {
                this.ldI.setVisibility(8);
                layoutParams.topMargin = 0;
                this.ldP.setVisibility(0);
                m.a(this.ldP, this.kOv.aui().kPA, this.mContext.getResources().getDimensionPixelSize(R.f.bwg), R.g.bDU, false);
            } else if (this.kOv.atO() && this.lbI) {
                this.ldI.setVisibility(8);
                layoutParams.topMargin = 0;
            }
            this.ldN.setLayoutParams(layoutParams);
            this.ldN.invalidate();
        } else {
            axW();
        }
        axX();
        layoutParams = (RelativeLayout.LayoutParams) this.ldQ.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.f.buw);
            layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.f.buw);
        }
        this.ldQ.setLayoutParams(layoutParams);
        this.ldQ.invalidate();
        this.ldH.invalidate();
    }

    private void axX() {
        LayoutParams layoutParams = (LayoutParams) this.ldM.getLayoutParams();
        if (this.kOv.auj().vYq != null && !TextUtils.isEmpty(this.kOv.auj().vYq.kPC)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvK);
        } else if (this.kOv.auj().vYr != null && !TextUtils.isEmpty(this.kOv.auj().vYr.kPB)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvK);
        } else if (this.kOv.aui().vYM == null || this.kOv.aui().vYM.size() <= 0) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvx);
        } else {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvK);
        }
        this.ldM.setLayoutParams(layoutParams);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (this.ldM != null) {
            this.ldM.setOnClickListener(onClickListener);
        }
        if (this.ldR != null) {
            this.ldR.setOnClickListener(onClickListener);
        }
    }

    public final void r(boolean z, boolean z2) {
        if (this.ldM != null) {
            oy oyVar = this.kOv.auj().vYr;
            if (oyVar != null && !TextUtils.isEmpty(oyVar.title) && oyVar.vZQ != 0 && this.kOv.aue()) {
                this.ldM.setClickable(false);
                this.ldM.setVisibility(0);
                this.ldR.setVisibility(8);
            } else if (this.kOv.auj().vYq != null && !TextUtils.isEmpty(this.kOv.auj().vYq.title) && !TextUtils.isEmpty(this.kOv.auj().vYq.url) && this.kOv.aue()) {
                this.ldM.setVisibility(0);
                this.ldM.setEnabled(true);
                if (TextUtils.isEmpty(this.kOv.auj().code) || this.kOv.auj().vYi == 0) {
                    this.ldR.setVisibility(8);
                } else {
                    this.ldR.setVisibility(0);
                }
            } else if (z && !TextUtils.isEmpty(this.kOv.auj().code) && this.kOv.aue()) {
                this.ldM.setVisibility(0);
                this.ldM.setEnabled(z2);
                this.ldR.setVisibility(8);
            } else if (!z || this.kOv.aue()) {
                this.ldM.setVisibility(8);
                this.ldR.setVisibility(8);
            } else {
                this.ldM.setVisibility(0);
                this.ldM.setEnabled(false);
                this.ldR.setVisibility(8);
            }
        }
    }

    public final void axY() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ldN.getLayoutParams();
        if (this.kOv.atO()) {
            this.ldI.setVisibility(0);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.bwk);
        }
        this.ldN.setLayoutParams(layoutParams);
        this.ldN.invalidate();
    }

    public final void ek(boolean z) {
        this.lbI = z;
        if (z) {
            this.ldQ.setVisibility(0);
        } else {
            this.ldQ.setVisibility(8);
        }
    }
}
