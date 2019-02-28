package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.ac.n;
import com.tencent.mm.af.d;
import com.tencent.mm.af.f;
import com.tencent.mm.af.m;
import com.tencent.mm.af.y;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public class BizInfoHeaderPreference extends Preference implements a, m.a.a, b {
    private MMActivity fnF;
    x jQP;
    d kKo;
    private boolean lXm = false;
    private TextView nwk;
    private ImageView pmW;
    private ImageView pmX;
    private View pmY;
    private TextView pmZ;
    String pna;

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnF = (MMActivity) context;
        this.lXm = false;
    }

    public BizInfoHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fnF = (MMActivity) context;
        this.lXm = false;
    }

    public final void onBindView(View view) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizInfoHeaderPreference", "onBindView");
        this.nwk = (TextView) view.findViewById(R.h.bXM);
        this.pmZ = (TextView) view.findViewById(R.h.bYd);
        this.pmX = (ImageView) view.findViewById(R.h.bNR);
        this.pmW = (ImageView) view.findViewById(R.h.bXp);
        this.pmY = view.findViewById(R.h.bXq);
        this.lXm = true;
        initView();
        super.onBindView(view);
    }

    private boolean bjX() {
        return this.lXm && this.jQP != null;
    }

    final void initView() {
        boolean z = true;
        if (bjX()) {
            Bitmap d;
            this.nwk.setText(i.b(this.fnF, bi.oM(this.jQP.AW()) + " ", this.nwk.getTextSize()));
            if (this.kKo == null) {
                this.kKo = f.jV(this.jQP.field_username);
            }
            if (this.kKo != null) {
                this.pna = this.kKo.field_brandIconURL;
                d = m.d(this.kKo.field_username, this.kKo.field_brandIconURL, R.g.bEl);
            } else {
                d = com.tencent.mm.ac.b.a(this.jQP.field_username, true, -1);
                if (!(d == null || d.isRecycled())) {
                    d = com.tencent.mm.sdk.platformtools.d.a(d, false, (float) (d.getWidth() / 2));
                }
                if (d == null && !TextUtils.isEmpty(this.pna)) {
                    d = m.d(this.jQP.field_username, this.pna, R.g.bEl);
                }
            }
            if (d == null) {
                d = BitmapFactory.decodeResource(this.fnF.getResources(), R.g.bAa);
            }
            if (!(d == null || d.isRecycled())) {
                this.pmW.setImageBitmap(d);
            }
            this.pmW.setTag(this.jQP.field_username);
            this.pmY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    new com.tencent.mm.pluginsdk.ui.f(BizInfoHeaderPreference.this.fnF, BizInfoHeaderPreference.this.jQP.field_username, BizInfoHeaderPreference.this.pna).caN();
                }
            });
            if (com.tencent.mm.k.a.ga(this.jQP.field_type)) {
                if (this.kKo != null) {
                    z = this.kKo.Lq();
                }
                if (z) {
                    if (!bi.oN(this.jQP.vU())) {
                        this.pmZ.setVisibility(0);
                        this.pmZ.setText(this.mContext.getString(R.l.dFp) + this.jQP.vU());
                    } else if (x.Xi(this.jQP.field_username) || s.gG(this.jQP.field_username)) {
                        this.pmZ.setVisibility(8);
                    } else {
                        this.pmZ.setText(this.mContext.getString(R.l.dFp) + bi.oM(this.jQP.AY()));
                        this.pmZ.setVisibility(0);
                    }
                    if (this.jQP.AO()) {
                        this.pmX.setVisibility(8);
                        return;
                    } else {
                        this.pmX.setVisibility(0);
                        return;
                    }
                }
            }
            this.pmZ.setVisibility(8);
            if (this.jQP.AO()) {
                this.pmX.setVisibility(8);
                return;
            } else {
                this.pmX.setVisibility(0);
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lXm + "contact = " + this.jQP);
    }

    public final void onDetach() {
        as.Hm();
        c.Ff().b(this);
        n.JF().e(this);
        y.Mt().b(this);
    }

    public final void jk(String str) {
        if (!bjX()) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lXm + "contact = " + this.jQP);
        } else if (bi.oM(str).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizInfoHeaderPreference", "notifyChanged: user = " + str);
        } else if (str.equals(this.jQP.field_username)) {
            initView();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BizInfoHeaderPreference", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
        } else if (bjX()) {
            String str = (String) obj;
            if (bi.oM(str).length() > 0 && this.jQP != null && this.jQP.field_username.equals(str)) {
                as.Hm();
                this.jQP = c.Ff().Xv(str);
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizInfoHeaderPreference", "initView : bindView = " + this.lXm + "contact = " + this.jQP);
        }
    }

    public final void kl(String str) {
        if (this.jQP != null && str != null && str.equals(this.jQP.field_username)) {
            initView();
        }
    }
}
