package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.l;

public final class m extends AlertDialog {
    private ListView Fv;
    private View kTo;
    public BaseAdapter kUZ;
    private Context mContext;
    private CharSequence uU;
    public OnItemClickListener vDf;

    public m(Context context) {
        super(context, l.eZl);
        this.mContext = context;
        if (a.ez(this.mContext)) {
            this.kTo = View.inflate(this.mContext, h.gZm, null);
        } else {
            this.kTo = View.inflate(this.mContext, h.gZl, null);
        }
        this.Fv = (ListView) this.kTo.findViewById(g.list);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.kTo);
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.uU = charSequence;
        } else {
            this.uU = null;
        }
    }

    public final void show() {
        if (this.uU != null) {
            this.uU.length();
        }
        if (this.vDf != null) {
            this.Fv.setOnItemClickListener(this.vDf);
        }
        if (this.kUZ != null) {
            this.Fv.setAdapter(this.kUZ);
        }
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.MMListDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
