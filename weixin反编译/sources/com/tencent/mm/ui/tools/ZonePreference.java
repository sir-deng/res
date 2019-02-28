package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZonePreference extends Preference {
    Region zwC;
    private CharSequence zwD;
    private TextView zwE;

    public ZonePreference(Context context) {
        this(context, null);
    }

    public ZonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZonePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnz);
    }

    public final void a(Region region) {
        if (region == null || t.oN(region.getName()) || t.oN(region.getCode())) {
            x.e("MicroMsg.ZonePreference", "setZoneItem item = null");
            return;
        }
        setKey(region.getCode() + region.isCity());
        this.zwC = region;
    }

    public final void setSummary(CharSequence charSequence) {
        this.zwD = charSequence;
        cyV();
    }

    private void cyV() {
        if (this.zwE != null) {
            if (this.zwD == null || t.oN(this.zwD.toString())) {
                this.zwE.setVisibility(8);
            } else {
                this.zwE.setVisibility(0);
            }
            this.zwE.setText(this.zwD);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnV, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.zwC != null) {
            ((TextView) view.findViewById(R.h.dab)).setText(this.zwC.getName());
            this.zwE = (TextView) view.findViewById(R.h.cPO);
            cyV();
        }
    }
}
