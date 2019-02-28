package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.m;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.y.ak.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class j extends LinearLayout {
    private Context context;
    private String hpQ;

    public j(Context context, String str) {
        super(context);
        this.context = context;
        this.hpQ = str;
        View inflate = View.inflate(getContext(), R.i.dgr, this);
        View findViewById = findViewById(R.h.ceD);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("enterprise_from_scene", 2);
                intent.putExtra("enterprise_biz_name", j.this.hpQ);
                d.b(view.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", intent);
            }
        });
        findViewById.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (j.this.context instanceof MMActivity) {
                    ((MMActivity) j.this.context).aWY();
                }
                return false;
            }
        });
        as.Hm();
        ag Xt = c.Ff().Xt(this.hpQ);
        if (Xt == null || ((int) Xt.gKO) <= 0) {
            x.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", this.hpQ);
            return;
        }
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.h.bNP);
        b.a((ImageView) maskLayout.view, this.hpQ);
        if (Xt.field_verifyFlag == 0) {
            maskLayout.cqD();
        } else if (a.hhx != null) {
            String gQ = a.hhx.gQ(Xt.field_verifyFlag);
            if (gQ != null) {
                maskLayout.d(m.ki(gQ), MaskLayout.a.ynF);
            } else {
                maskLayout.cqD();
            }
        } else {
            maskLayout.cqD();
        }
        ((TextView) findViewById(R.h.ceE)).setText(Xt.AW());
    }
}
