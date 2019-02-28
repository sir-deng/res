package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;
import junit.framework.Assert;

public class HelperHeaderPreference extends Preference {
    private ImageView ikl;
    private TextView ikq;
    private TextView ipT;
    private x jQP;
    private TextView ppG;
    private a ppH;
    private boolean ppI = false;

    public interface a {
        void a(HelperHeaderPreference helperHeaderPreference);

        CharSequence getHint();
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        this.ikl = (ImageView) view.findViewById(R.h.bXp);
        this.ikq = (TextView) view.findViewById(R.h.bYc);
        this.ppG = (TextView) view.findViewById(R.h.bXM);
        this.ipT = (TextView) view.findViewById(R.h.bXz);
        this.ppI = true;
        initView();
        super.onBindView(view);
    }

    public final void ho(boolean z) {
        if (this.ppH != null) {
            if (z) {
                this.ikq.setTextColor(r.gc(this.mContext));
                this.ikq.setText(R.l.eMM);
                this.ikq.setCompoundDrawablesWithIntrinsicBounds(R.g.bGy, 0, 0, 0);
                return;
            }
            this.ikq.setTextColor(r.gd(this.mContext));
            this.ikq.setText(R.l.eMT);
            this.ikq.setCompoundDrawablesWithIntrinsicBounds(R.g.bGx, 0, 0, 0);
        }
    }

    private void initView() {
        if (!this.ppI || this.jQP == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.HelperHeaderPreference", "initView : bindView = " + this.ppI + "contact = " + this.jQP);
            return;
        }
        String str = this.jQP.field_username;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.HelperHeaderPreference", "updateAvatar : user = " + str);
        if (this.ikl != null && this.jQP.field_username.equals(str)) {
            b.a(this.ikl, str);
        }
        if (this.ppG != null) {
            this.ppG.setText(this.jQP.AW());
        }
        if (this.ppH != null) {
            this.ppH.a(this);
            CharSequence hint = this.ppH.getHint();
            if (hint != null) {
                this.ipT.setText(hint);
                this.ipT.setVisibility(0);
                return;
            }
            this.ipT.setVisibility(8);
        }
    }

    public final void a(x xVar, a aVar) {
        Assert.assertTrue(xVar != null);
        this.jQP = xVar;
        this.ppH = aVar;
        initView();
    }
}
