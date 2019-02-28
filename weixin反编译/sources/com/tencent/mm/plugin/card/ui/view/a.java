package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class a extends i {
    private View lbS;

    public final void initView() {
        this.lbS = findViewById(R.h.bPy);
    }

    public final void update() {
        g awu = this.lcl.awu();
        b awp = this.lcl.awp();
        Context aws = this.lcl.aws();
        com.tencent.mm.plugin.card.ui.e.a aww = this.lcl.aww();
        f awx = this.lcl.awx();
        if (awu.axn()) {
            this.lbS.setVisibility(0);
            findViewById(R.h.bIk).setVisibility(0);
            ImageView imageView = (ImageView) findViewById(R.h.bIj);
            TextView textView = (TextView) findViewById(R.h.bIl);
            TextView textView2 = (TextView) findViewById(R.h.bIo);
            if (aww.kWh != null) {
                as.Hm();
                textView.setText(i.b(aws, c.Ff().Xv(aww.kWh).AW(), textView.getTextSize()));
            }
            if (aww.kKY == 23) {
                if (!TextUtils.isEmpty(awp.aui().vZm)) {
                    textView2.setText(awp.aui().vZm);
                } else if (TextUtils.isEmpty(awp.aui().kQK)) {
                    textView2.setText(aws.getString(R.l.dPe, new Object[]{awx.getTitle()}));
                } else {
                    textView2.setText(aws.getString(R.l.dPe, new Object[]{awp.aui().kQK}));
                }
            } else if (awp.auk() != null && !TextUtils.isEmpty(awp.auk().wTA)) {
                textView2.setText(awp.auk().wTA);
            } else if (TextUtils.isEmpty(awp.aui().kQK)) {
                textView2.setText(aws.getString(R.l.dOw, new Object[]{awx.getTitle()}));
            } else {
                textView2.setText(aws.getString(R.l.dOw, new Object[]{awp.aui().kQK}));
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, aww.kWh, 0.15f, false);
            imageView.setOnClickListener(this.lcl.awt());
        } else if (!awu.axo()) {
            axD();
        } else if (TextUtils.isEmpty(awp.aui().vZm)) {
            this.lbS.setVisibility(8);
        } else {
            this.lbS.setVisibility(0);
            findViewById(R.h.bIk).setVisibility(8);
            ((TextView) findViewById(R.h.bIo)).setText(awp.aui().vZm);
        }
    }

    public final void axD() {
        this.lbS.setVisibility(8);
    }
}
