package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class SwitchPhoneItemView extends RelativeLayout {
    private TextView tdM;
    private TextView tdN;
    ImageView tdO;
    private int tdP;

    public SwitchPhoneItemView(Context context) {
        this(context, 0);
    }

    public SwitchPhoneItemView(Context context, int i) {
        super(context);
        this.tdP = 0;
        this.tdP = i;
        ce(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tdP = 0;
        ce(context);
    }

    public SwitchPhoneItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tdP = 0;
        ce(context);
    }

    private void ce(Context context) {
        View inflate;
        if (this.tdP > 0) {
            inflate = inflate(context, this.tdP, this);
        } else {
            inflate = inflate(context, g.uMw, this);
        }
        this.tdM = (TextView) inflate.findViewById(f.uzW);
        this.tdN = (TextView) inflate.findViewById(f.uzT);
        this.tdO = (ImageView) inflate.findViewById(f.uzS);
    }

    public final void a(CharSequence charSequence, CharSequence charSequence2) {
        if (bi.N(charSequence)) {
            this.tdM.setVisibility(8);
        } else {
            if (charSequence.toString().startsWith("86")) {
                x.i("SwitchPhoneItemView", "cut 86 prefix");
                charSequence = charSequence.subSequence(2, charSequence.length());
            }
            this.tdM.setText(charSequence);
        }
        if (bi.N(charSequence2)) {
            this.tdN.setVisibility(8);
            return;
        }
        this.tdN.setMaxLines(2);
        this.tdN.setSelected(true);
        this.tdN.setEllipsize(TruncateAt.MIDDLE);
        this.tdN.setText(charSequence2);
        this.tdN.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
