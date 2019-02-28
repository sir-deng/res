package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.v;

public final class e extends LinearLayout {
    ImageView kVY;
    private Context mContext;
    TextView maU;
    public i nfA;
    private a nfB;
    public i nfC = null;
    b nfy;
    ImageView nfz;

    public e(b bVar) {
        super(bVar.getContext());
        this.mContext = bVar.getContext();
        this.nfy = bVar;
        this.nfA = new g(bVar);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        setLayoutParams(new LayoutParams(-1, displayMetrics.widthPixels > displayMetrics.heightPixels ? this.mContext.getResources().getDimensionPixelSize(R.f.buG) : this.mContext.getResources().getDimensionPixelSize(R.f.buH)));
        setBackgroundResource(R.e.bre);
        View inflate = v.fw(getContext()).inflate(R.i.dlx, this, false);
        addView(inflate);
        this.kVY = (ImageView) inflate.findViewById(R.h.bIT);
        this.kVY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!e.this.aPV()) {
                    e.this.nfy.aPG();
                }
            }
        });
        this.maU = (TextView) inflate.findViewById(R.h.title);
        this.nfz = (ImageView) inflate.findViewById(R.h.bIU);
        this.nfz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                e.this.nfA.aQg();
            }
        });
    }

    public final void yb(String str) {
        this.maU.setText(str);
    }

    public final void aQg() {
        if (this.nfA != null) {
            this.nfA.aQg();
        }
    }

    public final void B(Bundle bundle) {
        this.nfB = bundle == null ? null : new a(bundle);
    }

    public final boolean aPV() {
        if (this.nfB != null) {
            a aVar = this.nfB;
            boolean z = (!aVar.ndR || bi.oN(aVar.aPz()) || bi.oN(aVar.aPA()) || bi.oN(aVar.aPB())) ? false : true;
            if (z) {
                x.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", this.nfB.aPz(), this.nfB.aPA(), this.nfB.aPB());
                View inflate = View.inflate(getContext(), R.i.dns, null);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cwh);
                checkBox.setChecked(false);
                checkBox.setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(R.h.cwj);
                textView.setText(r6);
                textView.setTextColor(getResources().getColor(R.e.btv));
                textView = (TextView) inflate.findViewById(R.h.cwi);
                textView.setTextColor(getResources().getColor(R.e.btv));
                textView.setVisibility(8);
                this.nfC = h.a(getContext(), true, "", inflate, r4, r5, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        e.this.nfC = null;
                        e.this.nfy.aPG();
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        e.this.nfC = null;
                    }
                });
                return true;
            }
        }
        return false;
    }
}
