package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactSocialInfoPreference extends Preference {
    private TextView kZb;
    private ImageView pnA;
    private ImageView pnB;
    private ImageView pnC;
    private ImageView pnD;
    private ImageView pnE;
    private int pnF = 8;
    private int pnG = 8;
    private int pnH = 8;
    private int pnI = 8;
    private int pnJ = 8;
    private int pnK = 8;
    private ImageView pnz;

    public ContactSocialInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactSocialInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnz);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnU, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.pnz = (ImageView) view.findViewById(R.h.cpu);
        this.pnA = (ImageView) view.findViewById(R.h.cpy);
        this.pnB = (ImageView) view.findViewById(R.h.cpq);
        this.pnC = (ImageView) view.findViewById(R.h.coZ);
        this.pnD = (ImageView) view.findViewById(R.h.cpi);
        this.pnE = (ImageView) view.findViewById(R.h.cpD);
        this.kZb = (TextView) view.findViewById(R.h.title);
        av();
        super.onBindView(view);
    }

    public final void vh(int i) {
        this.pnF = i;
        av();
    }

    public final void vd(int i) {
        this.pnG = i;
        av();
    }

    public final void ve(int i) {
        this.pnH = i;
        av();
    }

    public final void vf(int i) {
        this.pnJ = i;
        av();
    }

    public final void vg(int i) {
        this.pnK = i;
        av();
    }

    private void av() {
        if (this.pnz != null) {
            this.pnz.setVisibility(this.pnF);
        }
        if (this.pnA != null) {
            this.pnA.setVisibility(this.pnG);
        }
        if (this.pnB != null) {
            this.pnB.setVisibility(this.pnH);
        }
        if (this.pnC != null) {
            this.pnC.setVisibility(this.pnI);
        }
        if (this.pnD != null) {
            this.pnD.setVisibility(this.pnJ);
        }
        if (this.kZb != null) {
            LayoutParams layoutParams = this.kZb.getLayoutParams();
            layoutParams.width = a.aa(this.mContext, R.f.bvc);
            this.kZb.setLayoutParams(layoutParams);
        }
        if (this.pnE != null) {
            this.pnE.setVisibility(this.pnK);
        }
    }
}
