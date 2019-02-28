package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.q;

public final class a {
    private static final int[] kJJ = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] kJK = new int[]{R.g.byD, R.g.byE, R.g.byF, R.g.byG, R.g.byH, R.g.byI, R.g.byJ};
    private Context context;
    private ImageView kJS;
    private final ag kKj = new ag() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            a.this.sit.dismiss();
        }
    };
    private View mEs;
    private View mEt;
    private View mEv;
    private q sit;
    private TextView siu;
    private ImageView siv;
    private View siw;
    private int six;

    public a(Context context) {
        this.context = context;
        this.six = b.b(context, 180.0f);
        this.sit = new q(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.i.dtQ, null), -1, -2);
        this.kJS = (ImageView) this.sit.getContentView().findViewById(R.h.cWP);
        this.mEv = this.sit.getContentView().findViewById(R.h.cWS);
        this.siu = (TextView) this.sit.getContentView().findViewById(R.h.cWU);
        this.siv = (ImageView) this.sit.getContentView().findViewById(R.h.cWT);
        this.siw = this.sit.getContentView().findViewById(R.h.cWV);
        this.mEs = this.sit.getContentView().findViewById(R.h.cWW);
        this.mEt = this.sit.getContentView().findViewById(R.h.cWX);
    }
}
