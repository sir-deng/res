package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference extends Preference {
    private String fEw;
    private String ggL;
    Bitmap hmD = null;
    private TextView kKL = null;
    ImageView mDI = null;
    private TextView qng = null;
    int qnh = -1;
    String qni = null;
    private OnClickListener qnj;
    private String username;

    public PersonalPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonalPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnz);
        setWidgetLayoutResource(R.i.doj);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.i.dnN, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        if (this.mDI == null) {
            this.mDI = (ImageView) view.findViewById(R.h.cpm);
        }
        if (this.hmD != null) {
            this.mDI.setImageBitmap(this.hmD);
        } else if (this.qnh > 0) {
            this.mDI.setImageResource(this.qnh);
        } else if (this.qni != null) {
            b.a(this.mDI, this.qni);
        }
        this.mDI.setOnClickListener(this.qnj);
        if (!(this.kKL == null || this.fEw == null)) {
            this.kKL.setText(i.b(this.mContext, this.fEw, this.kKL.getTextSize()));
        }
        if (this.qng != null) {
            String str = bi.oN(this.ggL) ? this.username : this.ggL;
            if (bi.oN(this.ggL) && x.Xi(this.username)) {
                this.qng.setVisibility(8);
            }
            this.qng.setText(this.mContext.getString(R.l.dFp) + str);
        }
        super.onBindView(view);
    }
}
