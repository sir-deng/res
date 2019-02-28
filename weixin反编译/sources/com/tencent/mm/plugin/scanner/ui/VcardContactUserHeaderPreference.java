package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference extends Preference {
    String bgo;
    private final Context context;
    private TextView nzO;
    String pZz;
    private ImageView qfr;
    private TextView qfs;
    private TextView qft;
    private TextView qfu;
    String qfv;
    String title;

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public VcardContactUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        x.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
        this.qfr = (ImageView) view.findViewById(R.h.cUz);
        this.nzO = (TextView) view.findViewById(R.h.cUA);
        if (this.qfv != null) {
            this.nzO.setText(this.qfv);
        }
        this.qfs = (TextView) view.findViewById(R.h.cUB);
        if (this.bgo != null) {
            this.qfs.setText(this.context.getString(R.l.eSL, new Object[]{this.bgo}));
            this.qfs.setVisibility(0);
        }
        this.qft = (TextView) view.findViewById(R.h.cUC);
        if (this.pZz != null) {
            this.qft.setText(this.context.getString(R.l.eSN, new Object[]{this.pZz}));
            this.qft.setVisibility(0);
        }
        this.qfu = (TextView) view.findViewById(R.h.cUD);
        if (this.title != null) {
            this.qfu.setText(this.context.getString(R.l.eSO, new Object[]{this.title}));
            this.qfu.setVisibility(0);
        }
    }
}
