package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.k.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RangeWidget extends RelativeLayout {
    private View contentView;
    private Activity iTL;
    private TextView rCu;
    private boolean rCv = true;
    int rCw = 0;
    String rCx = "";
    private String rCy = "";
    private String rCz = "";
    private ImageView rxm;
    SnsUploadConfigView rxp;
    public int style = 0;

    public RangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public RangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.iTL = (Activity) context;
        this.contentView = View.inflate(context, getLayoutResource(), this);
        this.rCu = (TextView) this.contentView.findViewById(f.qLz);
        this.rxm = (ImageView) this.contentView.findViewById(f.qJe);
        this.contentView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(RangeWidget.this.iTL, SnsLabelUI.class);
                intent.putExtra("KLabel_range_index", RangeWidget.this.rCw);
                intent.putExtra("Klabel_name_list", RangeWidget.this.rCy);
                intent.putExtra("Kother_user_name_list", RangeWidget.this.rCz);
                intent.putExtra("k_sns_label_ui_style", RangeWidget.this.style);
                RangeWidget.this.iTL.startActivityForResult(intent, 5);
            }
        });
    }

    private static List<String> at(List<String> list) {
        List<String> linkedList = new LinkedList();
        g.Dr();
        if (!g.Do().CF()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            g.Dr();
            a Xv = ((h) g.h(h.class)).Ff().Xv(obj2);
            if (!(Xv == null || ((int) Xv.gKO) == 0)) {
                obj2 = Xv.AX();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        String d;
        this.rCw = intent.getIntExtra("Ktag_range_index", 0);
        this.rCy = intent.getStringExtra("Klabel_name_list");
        this.rCz = intent.getStringExtra("Kother_user_name_list");
        int bAJ = bAJ();
        Object obj = "";
        if (!bi.oN(this.rCy)) {
            obj = obj + this.rCy;
        }
        if (!bi.oN(this.rCz)) {
            d = bi.d(at(Arrays.asList(this.rCz.split(","))), ",");
            if (obj.length() > 0) {
                obj = obj + "," + d;
            } else {
                obj = obj + d;
            }
        }
        if (!(bAJ == -1 || obj == null || obj.length() <= bAJ)) {
            obj = obj.substring(0, bAJ) + "...";
        }
        bAJ = this.rCw;
        if (this.rxm != null) {
            this.rxm.setImageResource(i.qPm);
        }
        if (this.rxp != null) {
            this.rxp.iS(false);
        }
        switch (bAJ) {
            case 0:
                if (this.rxm != null) {
                    this.rxm.setImageResource(i.qPl);
                }
                this.rCu.setText(j.qRu);
                break;
            case 1:
                if (this.rxp != null) {
                    this.rxp.iS(true);
                }
                if (!(atContactWidget == null || this.rxp == null || atContactWidget.bzI().size() <= 0)) {
                    com.tencent.mm.ui.base.h.h(this.iTL, j.qSr, j.dGZ);
                    atContactWidget.bzJ();
                    this.rxp.bCJ();
                }
                this.rCu.setText(j.qRs);
                break;
            case 2:
                this.rCu.setText(obj);
                break;
            case 3:
                TextView textView = this.rCu;
                d = this.iTL.getString(j.qRg);
                obj = d + "  " + obj;
                CharSequence spannableString = new SpannableString(obj);
                spannableString.setSpan(new ForegroundColorSpan(-65536), d.length() + 2, obj.length(), 33);
                textView.setText(spannableString);
                break;
        }
        return true;
    }

    protected int getLayoutResource() {
        return com.tencent.mm.plugin.sns.i.g.qMI;
    }

    protected int bAJ() {
        return -1;
    }
}
