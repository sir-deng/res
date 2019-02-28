package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.ac.n;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class PluginPreference extends Preference implements a {
    private MMActivity fnF;
    private ImageView hxJ;
    int mql;
    String qnk;
    String qnl;
    private String qnm;
    private int qnn;
    private int qno;
    boolean qnp;

    public PluginPreference(Context context) {
        this(context, null);
    }

    public PluginPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qnm = "";
        this.qnn = -1;
        this.qno = 8;
        this.qnp = false;
        this.hxJ = null;
        this.mql = 255;
        this.fnF = (MMActivity) context;
        setLayoutResource(R.i.dnz);
        n.JF().a((a) this);
    }

    public final boolean JE(String str) {
        as.Hm();
        ag Xv = c.Ff().Xv(str);
        if (Xv == null || ((int) Xv.gKO) == 0) {
            x.e("MicroMsg.PluginPreference", "plugin do not exist");
            return false;
        }
        this.qnk = Xv.field_username;
        this.qnl = Xv.AW();
        setKey("settings_plugins_list_#" + this.qnk);
        return true;
    }

    private void bow() {
        if (this.hxJ != null) {
            b.a(this.hxJ, this.qnk);
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnO, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.hxJ = (ImageView) view.findViewById(R.h.cpm);
        this.hxJ.setAlpha(this.mql);
        TextView textView = (TextView) view.findViewById(R.h.cQL);
        if (textView != null) {
            textView.setVisibility(this.qno);
            textView.setText(this.qnm);
            if (this.qnn != -1) {
                textView.setBackgroundDrawable(com.tencent.mm.bu.a.b(this.fnF, this.qnn));
            }
        }
        textView = (TextView) view.findViewById(R.h.czr);
        if (textView != null) {
            textView.setVisibility(this.qnp ? 0 : 8);
        }
        bow();
    }

    public final void jk(String str) {
        if (this.qnk != null && this.qnk.equals(str)) {
            new com.tencent.mm.sdk.platformtools.ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    PluginPreference.this.bow();
                }
            });
        }
    }
}
