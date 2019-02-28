package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class ProfileDescribeView extends ProfileItemView {
    public TextView vro;
    public TextView vrp;

    public ProfileDescribeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileDescribeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int bkr() {
        return R.i.dpN;
    }

    public final void init() {
        this.vro = (TextView) findViewById(R.h.bXu);
        this.vrp = (TextView) findViewById(R.h.bXv);
        setClickable(true);
    }

    public final boolean bks() {
        if (this.vrp != null) {
            LayoutParams layoutParams = this.vrp.getLayoutParams();
            layoutParams.width = a.aa(getContext(), R.f.bvc);
            this.vrp.setLayoutParams(layoutParams);
        }
        if (this.lLc == null) {
            setVisibility(8);
            return false;
        }
        String str = this.lLc.fXt;
        if (bi.oN(this.lLc.fXu)) {
            boolean z = false;
        } else {
            int z2 = 1;
        }
        Drawable drawable;
        CharSequence spannableString;
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
            if (FF == null || bi.oN(FF.field_conDescription)) {
                setVisibility(8);
                return false;
            }
            this.vro.setText(i.b(getContext(), bi.oM(FF.field_conDescription), this.vro.getTextSize()));
            return true;
        } else if (!bi.oN(str) && z2 != 0) {
            drawable = getContext().getResources().getDrawable(R.k.dxx);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            e eVar = new e(drawable, 1);
            eVar.zCd = (int) ((((float) drawable.getIntrinsicHeight()) - this.vro.getTextSize()) / 2.0f);
            spannableString = new SpannableString("  " + str);
            spannableString.setSpan(eVar, 0, 1, 33);
            this.vro.setText(i.b(getContext(), spannableString, this.vro.getTextSize()));
            return true;
        } else if (!bi.oN(str) && z2 == 0) {
            this.vro.setText(i.b(getContext(), bi.oM(str), this.vro.getTextSize()));
            return true;
        } else if (bi.oN(str) && z2 != 0) {
            drawable = getContext().getResources().getDrawable(R.k.dxx);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            e eVar2 = new e(drawable, 1);
            eVar2.zCd = (int) ((((float) drawable.getIntrinsicHeight()) - this.vro.getTextSize()) / 2.0f);
            spannableString = new SpannableString("  " + getContext().getString(R.l.dWt));
            spannableString.setSpan(eVar2, 0, 1, 33);
            this.vro.setText(i.b(getContext(), spannableString, this.vro.getTextSize()));
            return true;
        } else if (bi.oN(str) && z2 == 0) {
            setVisibility(8);
            return false;
        } else {
            setVisibility(8);
            return false;
        }
    }
}
