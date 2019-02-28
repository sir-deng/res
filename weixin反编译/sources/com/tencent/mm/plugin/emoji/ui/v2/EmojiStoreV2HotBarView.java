package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class EmojiStoreV2HotBarView extends LinearLayout {
    private View kTo;
    View lLI;
    private TextView lLJ;
    View lLK;
    private TextView lLL;
    private OnClickListener lLM = new OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2RankUI.class);
            EmojiStoreV2HotBarView.this.getContext().startActivity(intent);
        }
    };

    public EmojiStoreV2HotBarView(Context context) {
        super(context);
        init();
    }

    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    @TargetApi(11)
    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.kTo = ((ViewGroup) v.fw(getContext()).inflate(R.i.dfX, this)).findViewById(R.h.cIB);
        this.lLI = this.kTo.findViewById(R.h.cdt);
        this.lLJ = (TextView) this.kTo.findViewById(R.h.cdH);
        this.lLJ.setText(getResources().getText(R.l.eaP) + " ");
        this.lLK = this.kTo.findViewById(R.h.cbd);
        this.lLK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(EmojiStoreV2HotBarView.this.getContext(), EmojiStoreV2SingleProductUI.class);
                EmojiStoreV2HotBarView.this.getContext().startActivity(intent);
            }
        });
        this.lLL = (TextView) this.kTo.findViewById(R.h.cAh);
        aEa();
        OnClickListener onClickListener = this.lLM;
        if (this.lLJ != null) {
            this.lLJ.setOnClickListener(onClickListener);
        }
    }

    public final void aEa() {
        as.Hm();
        boolean booleanValue = ((Boolean) c.Db().get(a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.valueOf(false))).booleanValue();
        if (this.lLL != null) {
            this.lLL.setVisibility(booleanValue ? 0 : 8);
        }
    }

    public View getRootView() {
        return this.kTo;
    }

    public void setVisibility(int i) {
        if (this.kTo != null) {
            this.kTo.setVisibility(i);
        } else {
            super.setVisibility(i);
        }
    }
}
