package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.q;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget extends LinearLayout {
    private View contentView;
    private Activity iTL;
    private ImageView rxm;
    private TextView rxn;
    private PreviewContactView rxo;
    SnsUploadConfigView rxp;
    private List<String> rxq = new LinkedList();
    private boolean rxr = false;

    static /* synthetic */ void a(AtContactWidget atContactWidget) {
        if (atContactWidget.rxq == null) {
            atContactWidget.rxq = new LinkedList();
        }
        if (atContactWidget.rxp == null || atContactWidget.rxp.bCM() <= 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Compose", true);
            intent.putExtra("List_Type", 1);
            intent.putExtra("Add_address_titile", atContactWidget.iTL.getString(j.qSR));
            intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
            intent.putExtra("Block_list", q.FY());
            intent.putExtra("Select_Contact", bi.d(atContactWidget.rxq, ","));
            intent.putExtra("sns_address_count", 0);
            a.ihN.a(intent, atContactWidget.iTL, 6);
            return;
        }
        h.h(atContactWidget.iTL, j.qSr, j.dGZ);
    }

    @TargetApi(11)
    public AtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public AtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final List<String> bzI() {
        if (this.rxq == null) {
            this.rxq = new LinkedList();
        }
        return this.rxq;
    }

    public final void bzJ() {
        if (this.rxq == null) {
            this.rxq = new LinkedList();
        }
        this.rxq.clear();
        if (this.rxo != null) {
            this.rxo.bX(this.rxq);
        }
        bzK();
        if (this.rxn != null) {
            this.rxn.setVisibility(8);
        }
    }

    private void init(Context context) {
        this.iTL = (Activity) context;
        this.contentView = v.fw(context).inflate(getLayoutResource(), this);
        this.rxo = (PreviewContactView) this.contentView.findViewById(f.qHs);
        this.rxm = (ImageView) this.contentView.findViewById(f.qHt);
        this.rxn = (TextView) this.contentView.findViewById(f.qHu);
        this.contentView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AtContactWidget.a(AtContactWidget.this);
            }
        });
    }

    public final boolean U(Intent intent) {
        String stringExtra = intent.getStringExtra("Select_Contact");
        LinkedList linkedList = new LinkedList();
        List linkedList2;
        if (stringExtra == null || stringExtra.equals("")) {
            linkedList2 = new LinkedList();
        } else {
            linkedList2 = bi.F(stringExtra.split(","));
        }
        if (this.rxq == null) {
            this.rxq = new LinkedList();
        }
        this.rxq.clear();
        for (String stringExtra2 : linkedList2) {
            if (!this.rxq.contains(stringExtra2)) {
                this.rxq.add(stringExtra2);
            }
        }
        if (this.rxo != null) {
            this.rxo.bX(this.rxq);
        }
        if (this.rxr) {
            x.d("MicroMsg.AtContactWiget", "withList count " + this.rxq.size());
            if (!this.rxr || this.rxn == null || this.rxq.size() <= 0) {
                this.rxn.setVisibility(8);
            } else {
                this.rxn.setVisibility(0);
                if (this.rxq.size() < 100) {
                    this.rxn.setText(this.rxq.size());
                } else {
                    this.rxn.setText(j.eSf);
                }
            }
        }
        bzK();
        return true;
    }

    private void bzK() {
        if (this.rxq.size() > 0) {
            this.rxm.setImageResource(bzL());
        } else {
            this.rxm.setImageResource(bzM());
        }
    }

    protected int getLayoutResource() {
        return g.qHv;
    }

    protected int bzL() {
        return i.qPg;
    }

    protected int bzM() {
        return i.qPf;
    }
}
