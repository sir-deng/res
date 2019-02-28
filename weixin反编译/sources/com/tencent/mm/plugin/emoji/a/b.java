package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public final class b {
    private final String TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    public TextView kZb;
    public View lzm;
    public String lzu;
    public ImageView lzv;
    public ImageView lzw;
    public Context mContext;

    public b(Context context, int i) {
        this.mContext = context;
        this.lzm = v.fw(this.mContext).inflate(i, null);
        aBj();
    }

    public b(Context context, View view) {
        this.mContext = context;
        this.lzm = view;
        aBj();
    }

    private void aBj() {
        if (this.lzm == null) {
            x.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
            return;
        }
        this.lzv = (ImageView) this.lzm.findViewById(R.h.crC);
        this.kZb = (TextView) this.lzm.findViewById(R.h.crX);
        this.lzw = (ImageView) this.lzm.findViewById(R.h.crA);
    }
}
