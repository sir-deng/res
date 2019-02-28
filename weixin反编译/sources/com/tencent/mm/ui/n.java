package com.tencent.mm.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.l;

final class n extends Dialog implements DialogInterface {
    private View kbj = this.xQD.findViewById(g.gXy);
    private Context mContext;
    private TextView maU = ((TextView) this.xQD.findViewById(g.gXx));
    private boolean qva;
    Button tbx = ((Button) this.xQD.findViewById(g.cwq));
    private LinearLayout xQD = ((LinearLayout) v.fw(this.mContext).inflate(h.gZa, null));
    TextView xQE = ((TextView) this.xQD.findViewById(g.cwk));
    private TextView xQF = ((TextView) this.xQD.findViewById(g.gXw));
    LinearLayout xQG = ((LinearLayout) this.xQD.findViewById(g.cwl));
    private LinearLayout xQH = ((LinearLayout) this.xQD.findViewById(g.gXv));

    /* renamed from: com.tencent.mm.ui.n$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ DialogInterface.OnClickListener xQI;
        final /* synthetic */ boolean xQJ = true;

        AnonymousClass1(DialogInterface.OnClickListener onClickListener, boolean z) {
            this.xQI = onClickListener;
        }

        public final void onClick(View view) {
            if (this.xQI != null) {
                this.xQI.onClick(n.this, -1);
            }
            if (this.xQJ) {
                n.this.dismiss();
            }
        }
    }

    public n(Context context) {
        super(context, l.eZl);
        this.mContext = context;
        setCanceledOnTouchOutside(true);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.xQD);
    }

    public final void setTitle(CharSequence charSequence) {
        this.kbj.setVisibility(0);
        this.maU.setVisibility(0);
        this.maU.setMaxLines(2);
        this.maU.setText(charSequence);
        Eh(d.gWh);
    }

    public final void setTitle(int i) {
        this.kbj.setVisibility(0);
        this.maU.setVisibility(0);
        this.maU.setMaxLines(2);
        this.maU.setText(i);
        Eh(d.gWh);
    }

    private void Eh(int i) {
        if (this.xQE != null) {
            this.xQE.setTextColor(this.xQE.getContext().getResources().getColor(i));
        }
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.qva = z;
        setCanceledOnTouchOutside(this.qva);
    }

    public final void cnB() {
        super.setCancelable(true);
    }

    public final void show() {
        try {
            super.show();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LiteDependDialog", e, "", new Object[0]);
        }
    }

    public final void dismiss() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ah.y(new Runnable() {
                public final void run() {
                    n.this.dismiss();
                }
            });
            x.e("MicroMsg.LiteDependDialog", bi.chl().toString());
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
