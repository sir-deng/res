package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference extends Preference {
    private TextView ikq;
    int status;
    Region zwF;
    Region zwG;
    Region zwH;
    private TextView zwI;
    private ImageView zwJ;

    public ZoneRecommandPreference(Context context) {
        this(context, null);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
        setLayoutResource(R.i.dnz);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnW, viewGroup2);
        this.zwI = (TextView) onCreateView.findViewById(R.h.dab);
        this.ikq = (TextView) onCreateView.findViewById(R.h.status);
        this.zwJ = (ImageView) onCreateView.findViewById(R.h.cPx);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        cyW();
    }

    final void cyW() {
        if (this.zwI != null && this.ikq != null) {
            switch (this.status) {
                case 0:
                    this.zwI.setVisibility(8);
                    this.ikq.setVisibility(0);
                    this.ikq.setText(R.l.eKV);
                    this.zwJ.setImageResource(R.k.dyW);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                case 1:
                    this.zwI.setVisibility(0);
                    this.ikq.setVisibility(8);
                    this.zwJ.setImageResource(R.k.dyW);
                    CharSequence charSequence = "";
                    if (!(this.zwF == null || t.oN(this.zwF.getName()))) {
                        charSequence = charSequence + this.zwF.getName();
                    }
                    if (!(this.zwG == null || t.oN(this.zwG.getName()))) {
                        charSequence = charSequence + " " + this.zwG.getName();
                    }
                    if (!(this.zwH == null || t.oN(this.zwH.getName()))) {
                        charSequence = charSequence + " " + this.zwH.getName();
                    }
                    this.zwI.setText(charSequence);
                    setEnabled(true);
                    setSelectable(true);
                    return;
                case 2:
                    this.zwI.setVisibility(8);
                    this.ikq.setVisibility(0);
                    this.ikq.setText(R.l.eKS);
                    this.zwJ.setImageResource(R.k.dyV);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                default:
                    return;
            }
        }
    }

    public final void cyX() {
        this.status = 2;
        cyW();
    }
}
