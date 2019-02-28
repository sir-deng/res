package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.x;

public class GameBlockView extends LinearLayout {
    LayoutInflater DF;
    LinearLayout mAt;
    LayoutParams nrC;
    l nrD;

    private static class a {
        public ViewGroup nrG;
        public TextView nrH;
        public GameDownloadView nrI;
        public ImageView nrs;
        public TextView nrt;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameBlockView$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ int nrE;

        AnonymousClass1(int i) {
            this.nrE = i;
        }

        public final void onClick(View view) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                ap.a(GameBlockView.this.getContext(), 10, 1002, 99, c.p(GameBlockView.this.getContext(), (String) view.getTag(), "game_center_mygame_more"), this.nrE, null);
            }
        }
    }

    public GameBlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOrientation(1);
        this.DF = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.nrC = new LayoutParams(-1, -2);
        this.mAt = this;
        this.nrD = new l();
        x.i("MicroMsg.GameBlockView", "initView finished");
    }
}
