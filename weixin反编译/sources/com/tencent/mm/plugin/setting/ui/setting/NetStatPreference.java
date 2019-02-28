package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;

public class NetStatPreference extends Preference {
    boolean qnd;

    public NetStatPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatPreference(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.qnd = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fbc, i, 0);
        if (obtainStyledAttributes.getInt(R.n.fbd, 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.qnd = z;
        obtainStyledAttributes.recycle();
        setSummary(context.getString(R.l.eMo, new Object[]{Integer.valueOf(15)}));
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dnM, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        View netStatGroup;
        super.onBindView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.atY);
        linearLayout.removeAllViews();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        for (int i = 15; i > 0; i -= 5) {
            netStatGroup = new NetStatGroup(this.mContext);
            int i2 = (currentTimeMillis - i) + 1;
            boolean z = this.qnd;
            Object charSequence = DateFormat.format(netStatGroup.getContext().getString(R.l.eiJ, new Object[]{""}), ((long) i2) * 86400000).toString();
            netStatGroup.pGU.setText(charSequence);
            x.d("MicroMsg.NetStatGroup", "NetStat dataTime = " + charSequence);
            netStatGroup.qnc.removeAllViews();
            for (int i3 = 0; i3 < 5; i3++) {
                View netStatUnit = new NetStatUnit(netStatGroup.getContext());
                k iC = q.Tn().iC(i2 + i3);
                if (iC != null) {
                    if (z) {
                        x.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d wifi : %d %d %d %d", Integer.valueOf(iC.hTq), Integer.valueOf(iC.hTM), Integer.valueOf(iC.hTA), Integer.valueOf(iC.hTO), Integer.valueOf(iC.hTC));
                        netStatUnit.dv(iC.hTM + iC.hTA, iC.hTC + iC.hTO);
                    } else {
                        x.i("MicroMsg.NetStatUnit", "dknetflow peroid:%d mobile : %d %d %d %d", Integer.valueOf(iC.hTq), Integer.valueOf(iC.hTL), Integer.valueOf(iC.hTz), Integer.valueOf(iC.hTN), Integer.valueOf(iC.hTB));
                        netStatUnit.dv(iC.hTL + iC.hTz, iC.hTB + iC.hTN);
                    }
                }
                netStatUnit.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
                netStatGroup.qnc.addView(netStatUnit);
            }
            linearLayout.addView(netStatGroup, -2, -1);
        }
        linearLayout = (LinearLayout) view.findViewById(R.h.cIK);
        linearLayout.removeAllViews();
        View netStatGroup2 = new NetStatGroup(this.mContext);
        boolean z2 = this.qnd;
        netStatGroup2.removeAllViews();
        View.inflate(netStatGroup2.getContext(), R.i.doX, netStatGroup2);
        netStatGroup2.qnc = (LinearLayout) netStatGroup2.findViewById(R.h.atY);
        netStatGroup = new NetStatRuler(netStatGroup2.getContext());
        netStatGroup.setTag(z2 ? "wifi" : "mobile");
        netStatGroup.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        netStatGroup2.qnc.addView(netStatGroup);
        linearLayout.addView(netStatGroup2);
    }
}
