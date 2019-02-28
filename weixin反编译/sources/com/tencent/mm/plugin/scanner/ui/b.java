package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class b extends Preference implements a {
    f inW;
    String lFM;
    private Context mContext;
    private View mView = null;
    private ImageView pZK = null;

    public b(Context context) {
        super(context);
        setLayoutResource(R.i.dpD);
        j.a((a) this);
        this.mContext = context;
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
        this.pZK = (ImageView) view.findViewById(R.h.bMK);
        if (!bi.oN(this.lFM)) {
            Bitmap a = j.a(new o(this.lFM));
            if (a == null || a.isRecycled()) {
                this.pZK.setBackgroundColor(this.mContext.getResources().getColor(R.e.bsJ));
                this.pZK.setImageBitmap(null);
                return;
            }
            this.pZK.setImageBitmap(a);
            this.pZK.setBackgroundColor(0);
        }
    }

    public final void l(String str, Bitmap bitmap) {
        if (!bi.oN(str) && str.equals(this.lFM) && bitmap != null && !bitmap.isRecycled()) {
            this.pZK.setImageBitmap(bitmap);
            this.pZK.setBackgroundColor(0);
            if (this.inW != null) {
                this.inW.notifyDataSetChanged();
            }
        }
    }
}
