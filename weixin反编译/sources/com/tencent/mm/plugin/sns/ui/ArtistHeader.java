package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.ui.base.k;

public class ArtistHeader extends LinearLayout implements b {
    Context context = null;
    private View kbO;
    private k mFB = null;
    dt rwL = null;
    a rwQ;
    private ImageView rwR;
    private ProgressBar rwS;

    class a {
        ImageView ikl;
        TextView ikn;
        TextView jbl;
        TextView rwV;
        TextView rwW;

        a() {
        }
    }

    public ArtistHeader(Context context) {
        super(context);
        init(context);
    }

    public ArtistHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(g.qNe, this, true);
        this.context = context;
        this.rwQ = new a();
        this.rwQ.ikl = (ImageView) inflate.findViewById(f.qHq);
        this.rwQ.jbl = (TextView) inflate.findViewById(f.qGa);
        this.rwQ.rwV = (TextView) inflate.findViewById(f.qGd);
        this.rwQ.rwW = (TextView) inflate.findViewById(f.qGb);
        this.rwQ.ikn = (TextView) inflate.findViewById(f.qGc);
        this.rwQ.ikl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if ((ArtistHeader.this.mFB == null || !ArtistHeader.this.mFB.isShowing()) && ArtistHeader.this.rwL != null) {
                    View inflate = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(g.ltH, null);
                    ArtistHeader.this.mFB = new k(ArtistHeader.this.getContext(), i.k.qSU);
                    inflate.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            ArtistHeader.this.mFB.dismiss();
                        }
                    });
                    ArtistHeader.this.mFB.setCanceledOnTouchOutside(true);
                    ArtistHeader.this.mFB.setContentView(inflate);
                    ArtistHeader.this.mFB.show();
                    ArtistHeader.this.rwR = (ImageView) inflate.findViewById(f.ltz);
                    ArtistHeader.this.rwS = (ProgressBar) inflate.findViewById(f.ltA);
                    ArtistHeader.this.kbO = inflate.findViewById(f.ltB);
                }
            }
        });
    }

    public final void Ky(String str) {
    }

    public final void aE(String str, boolean z) {
        if (this.rwL != null && this.mFB != null && this.mFB.isShowing() && !z) {
            are are = this.rwL.vPG.vPH;
            if (are.nMq != null && are.nMq.equals(str)) {
                Toast.makeText(this.context, this.context.getString(j.qQA), 0).show();
            }
        }
    }

    public final void aF(String str, boolean z) {
    }

    public final void buX() {
    }
}
