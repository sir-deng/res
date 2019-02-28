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
import com.tencent.mm.ap.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class v extends LinearLayout {
    private String AJg;
    private Context context;

    public v(Context context, String str) {
        super(context);
        this.context = context;
        this.AJg = str;
        View inflate = View.inflate(getContext(), R.i.dpr, this);
        View findViewById = findViewById(R.h.ceD);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, OpenIMAddressUI.class);
                intent.addFlags(67108864);
                intent.putExtra("key_openim_acctype_id", v.this.AJg);
                context.startActivity(intent);
            }
        });
        findViewById.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (v.this.context instanceof MMActivity) {
                    ((MMActivity) v.this.context).aWY();
                }
                return false;
            }
        });
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.h.bNP);
        String J = ((b) g.h(b.class)).J(this.AJg, "openim_acct_type_icon", a.idw);
        if (J != null) {
            o.PG().a(J, (ImageView) maskLayout.view);
        }
        ((TextView) findViewById(R.h.ceE)).setText(((b) g.h(b.class)).J(this.AJg, "openim_acct_type_title", a.idv));
    }
}
