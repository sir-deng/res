package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a extends Preference implements com.tencent.mm.platformtools.j.a {
    private f jPY;
    private ImageView kbb;
    String lXl;
    private View mView = null;
    private TextView pZH = null;
    String pZI = null;

    public a(Context context) {
        super(context);
        setLayoutResource(R.i.drq);
        j.a((com.tencent.mm.platformtools.j.a) this);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.pZH = (TextView) view.findViewById(R.h.ccf);
        this.kbb = (ImageView) view.findViewById(R.h.bIY);
        if (bi.oN(this.pZI)) {
            this.pZH.setVisibility(8);
        } else {
            this.pZH.setText(this.pZI);
            this.pZH.setVisibility(0);
        }
        if (!bi.oN(this.lXl)) {
            Bitmap a = j.a(new o(this.lXl));
            if (a != null && !a.isRecycled()) {
                this.kbb.setImageBitmap(a);
                this.kbb.setVisibility(0);
            }
        }
    }

    public final void l(String str, final Bitmap bitmap) {
        if (!bi.oN(str) && str.equals(this.lXl) && bitmap != null && !bitmap.isRecycled() && this.kbb != null) {
            ah.y(new Runnable() {
                public final void run() {
                    a.this.kbb.setImageBitmap(bitmap);
                    a.this.kbb.setVisibility(0);
                    if (a.this.jPY != null) {
                        a.this.jPY.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
