package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bf;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.ArrayList;

public class ProfileLabelView extends ProfileItemView {
    public TextView poa;
    public TextView vry;

    public ProfileLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int bkr() {
        return R.i.dpQ;
    }

    public final void init() {
        this.poa = (TextView) findViewById(R.h.bXB);
        this.vry = (TextView) findViewById(R.h.bXC);
        setClickable(true);
    }

    public final boolean bks() {
        if (this.vry != null) {
            LayoutParams layoutParams = this.vry.getLayoutParams();
            layoutParams.width = a.aa(getContext(), R.f.bvc);
            this.vry.setLayoutParams(layoutParams);
        }
        String str;
        ArrayList arrayList;
        if (!com.tencent.mm.k.a.ga(this.lLc.field_type)) {
            bf FF;
            String str2 = this.lLc.field_encryptUsername;
            if (bi.oN(str2)) {
                as.Hm();
                FF = c.Fg().FF(this.lLc.field_username);
            } else {
                as.Hm();
                FF = c.Fg().FF(str2);
            }
            if (FF != null) {
                str = FF.field_contactLabels;
                arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aVD().DV(str);
                if (!(bi.oN(str) || arrayList == null || arrayList.size() <= 0)) {
                    this.poa.setText(i.a(getContext(), bi.d(arrayList, getContext().getResources().getString(R.l.dUe))));
                    return true;
                }
            }
            setVisibility(8);
            return false;
        } else if (q.gt(this.lLc.field_username)) {
            setVisibility(8);
            return false;
        } else {
            str = this.lLc.field_contactLabelIds;
            arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aVD().DW(str);
            if (bi.oN(str) || arrayList == null || arrayList.size() <= 0) {
                setVisibility(8);
                return false;
            }
            this.poa.setText(i.a(getContext(), bi.d(arrayList, getContext().getResources().getString(R.l.dUe))));
            return true;
        }
    }
}
