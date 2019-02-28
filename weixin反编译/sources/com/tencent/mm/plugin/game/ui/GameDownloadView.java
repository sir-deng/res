package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

public class GameDownloadView extends FrameLayout implements OnClickListener {
    private b nuo = new b() {
        public final void h(int i, String str, boolean z) {
            if (z && !bi.oN(str) && GameDownloadView.this.nuq != null && GameDownloadView.this.nuq.nhC != null && GameDownloadView.this.nuq.nhC.field_appId.equals(str)) {
                GameDownloadView.this.nuq.cQ(ad.getContext());
                GameDownloadView.this.nuq.aQQ();
                GameDownloadView.this.aSg();
            }
        }
    };
    private o nuq;
    private Button nvt;
    private TextProgressBar nvu;
    private e nvv;

    public GameDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.i.dkm, this, true);
        this.nvt = (Button) inflate.findViewById(R.h.clZ);
        this.nvu = (TextProgressBar) inflate.findViewById(R.h.cmb);
        this.nvu.rv(14);
        this.nvt.setOnClickListener(this);
        this.nvu.setOnClickListener(this);
        this.nvv = new e(getContext());
        this.nvv.nre = new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                GameDownloadView.this.aSg();
            }
        };
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n.b(this.nuo);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n.a(this.nuo);
    }

    public final void a(o oVar) {
        this.nuq = oVar;
        c.Dt().F(new Runnable() {
            public final void run() {
                GameDownloadView.this.nuq.cQ(ad.getContext());
                GameDownloadView.this.nuq.aQQ();
                GameDownloadView.this.aSg();
            }
        });
        aSg();
    }

    private void aSg() {
        ah.y(new Runnable() {
            public final void run() {
                GameDownloadView.this.nvv.a(GameDownloadView.this.nvu, GameDownloadView.this.nvt, GameDownloadView.this.nuq.nhC, GameDownloadView.this.nuq);
            }
        });
    }

    public void onClick(View view) {
        this.nuq.cQ(ad.getContext());
        this.nvv.a(this.nuq.nhC, this.nuq);
    }
}
