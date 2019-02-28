package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class VoiceHeaderPreference extends Preference {
    private MMActivity fnF;
    private TextView ikn;
    private TextView ipk;
    private ImageView jTd;
    private String mTitle;
    private int mql;
    private Button mqm;
    private View mqn;
    private OnClickListener mqo;
    private String mqp;
    private String mqq;

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fnF = (MMActivity) context;
    }

    public VoiceHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitle = "";
        this.mql = 255;
        this.mqo = null;
        this.mqp = "";
        this.mqq = "";
        this.fnF = (MMActivity) context;
        setLayoutResource(R.i.dtO);
    }

    public final void cC(String str, String str2) {
        this.mqp = str;
        this.mqq = str2;
        if (this.ikn != null) {
            if (bi.oN(this.mqp)) {
                this.ikn.setVisibility(8);
            } else {
                this.ikn.setText(this.mqp);
                this.ikn.setVisibility(0);
            }
        }
        if (this.ipk == null) {
            return;
        }
        if (bi.oN(this.mqq)) {
            this.ipk.setVisibility(8);
            return;
        }
        this.ipk.setText(this.mqq);
        this.ipk.setVisibility(0);
    }

    public final void e(OnClickListener onClickListener) {
        this.mqo = onClickListener;
        if (this.mqm != null && this.mqn != null) {
            if (this.mqm == null || this.mqo == null) {
                this.mqm.setVisibility(8);
                this.mqn.setVisibility(8);
                return;
            }
            this.mqm.setOnClickListener(onClickListener);
            this.mqm.setVisibility(0);
            this.mqn.setVisibility(0);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.jTd = (ImageView) view.findViewById(R.h.cWK);
        this.ikn = (TextView) view.findViewById(R.h.cWL);
        this.ipk = (TextView) view.findViewById(R.h.cWN);
        this.mqm = (Button) view.findViewById(R.h.cIk);
        this.mqn = view.findViewById(R.h.bPj);
        if (bi.oN(this.mqp)) {
            this.ikn.setVisibility(8);
        } else {
            this.ikn.setText(this.mqp);
            this.ikn.setVisibility(0);
        }
        if (bi.oN(this.mqq)) {
            this.ipk.setVisibility(8);
        } else {
            this.ipk.setText(this.mqq);
            this.ipk.setVisibility(0);
        }
        if (this.mqm == null || this.mqo == null) {
            this.mqm.setVisibility(8);
            this.mqn.setVisibility(8);
            return;
        }
        this.mqm.setOnClickListener(this.mqo);
        this.mqm.setVisibility(0);
        this.mqn.setVisibility(0);
    }
}
