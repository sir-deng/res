package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

public class DatePickerDialogView extends LinearLayout implements OnClickListener {
    private CollectRadioBtnView ltj;
    private CollectRadioBtnView ltk;
    private CollectRadioBtnView ltl;
    MMSpinnerDatePicker ltm;
    TextView ltn;
    TextView lto;
    int ltp = 0;

    public DatePickerDialogView(Context context) {
        super(context);
        init(context);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = v.fw(context).inflate(g.uHR, this);
        this.ltj = (CollectRadioBtnView) inflate.findViewById(f.gYF);
        this.ltk = (CollectRadioBtnView) inflate.findViewById(f.gXF);
        this.ltl = (CollectRadioBtnView) inflate.findViewById(f.gXd);
        this.ltn = (TextView) inflate.findViewById(f.upw);
        this.lto = (TextView) inflate.findViewById(f.bPp);
        this.ltj.setOnClickListener(this);
        this.ltk.setOnClickListener(this);
        this.ltl.setOnClickListener(this);
        this.ltj.yb("年");
        this.ltk.yb("月");
        this.ltl.yb("日");
        this.ltm = (MMSpinnerDatePicker) inflate.findViewById(f.upA);
        this.ltm.Ht(c.transparent);
        MMSpinnerDatePicker mMSpinnerDatePicker = this.ltm;
        int i = d.bvL;
        mMSpinnerDatePicker.a(mMSpinnerDatePicker.zDS, i);
        mMSpinnerDatePicker.a(mMSpinnerDatePicker.zDT, i);
        mMSpinnerDatePicker.a(mMSpinnerDatePicker.zDU, i);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == f.gYF) {
            this.ltp = 2;
        } else if (id == f.gXF) {
            this.ltp = 1;
        } else if (id == f.gXd) {
            this.ltp = 0;
        } else {
            x.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", view.getClass().toString());
        }
        aAh();
    }

    final void aAh() {
        if (this.ltp == 2) {
            this.ltj.oL(h.dAC);
            this.ltk.oL(h.dAB);
            this.ltl.oL(h.dAB);
        } else if (this.ltp == 1) {
            this.ltj.oL(h.dAB);
            this.ltk.oL(h.dAC);
            this.ltl.oL(h.dAB);
        } else {
            this.ltj.oL(h.dAB);
            this.ltk.oL(h.dAB);
            this.ltl.oL(h.dAC);
        }
        this.ltm.Hs(this.ltp);
    }
}
