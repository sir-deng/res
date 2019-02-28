package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.favorite.a.g;
import com.tencent.mm.plugin.favorite.a.i;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class FavVoiceBaseView extends LinearLayout implements com.tencent.mm.plugin.favorite.a.i.a {
    private int duration;
    private int fws;
    private TextView mBA;
    private a mBB;
    private ViewGroup mBx;
    private TextView mBy;
    private ImageButton mBz;
    public i mwG;
    private String path = "";

    private class a extends ag {
        boolean isPaused;
        float mBD;
        float mBE;
        int mBF;
        int mBG;

        private a() {
        }

        /* synthetic */ a(FavVoiceBaseView favVoiceBaseView, byte b) {
            this();
        }

        public final void qg(int i) {
            this.isPaused = false;
            this.mBD = j.bw((long) i);
            this.mBE = this.mBD;
            this.mBG = com.tencent.mm.bu.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
            FavVoiceBaseView.this.mBA.setText(g.v(FavVoiceBaseView.this.getContext(), (int) this.mBD));
            FavVoiceBaseView.this.mBz.setImageResource(R.k.dBJ);
            FavVoiceBaseView.this.mBz.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.l.dGv));
            FavVoiceBaseView.this.mBy.setWidth(this.mBG);
        }

        public final void begin() {
            stop();
            this.isPaused = false;
            FavVoiceBaseView.this.mBz.setImageResource(R.k.dBK);
            FavVoiceBaseView.this.mBz.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.l.dGg));
            sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
        }

        public final void stop() {
            this.isPaused = false;
            removeMessages(Downloads.RECV_BUFFER_SIZE);
            qg(FavVoiceBaseView.this.duration);
        }

        public final void aKj() {
            this.mBF = ((int) ((1.0f - (this.mBE / this.mBD)) * ((float) (FavVoiceBaseView.this.mBx.getWidth() - this.mBG)))) + this.mBG;
            FavVoiceBaseView.this.mBA.setText(g.v(FavVoiceBaseView.this.getContext(), Math.min((int) Math.ceil((double) this.mBE), (int) this.mBD)));
            FavVoiceBaseView.this.mBy.setWidth(this.mBF);
        }

        public final void fj(boolean z) {
            this.mBG = com.tencent.mm.bu.a.fromDPToPix(FavVoiceBaseView.this.getContext(), 3);
            FavVoiceBaseView.this.mBz.setImageResource(R.k.dBJ);
            FavVoiceBaseView.this.mBz.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.l.dGv));
            aKj();
            if (z) {
                FavVoiceBaseView.this.mBz.setImageResource(R.k.dBK);
                FavVoiceBaseView.this.mBz.setContentDescription(FavVoiceBaseView.this.getContext().getResources().getString(R.l.dGg));
                sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
            }
        }

        public final void handleMessage(Message message) {
            this.mBE = Math.max(0.0f, this.mBE - 0.256f);
            aKj();
            if (this.mBE > 0.1f) {
                sendEmptyMessageDelayed(Downloads.RECV_BUFFER_SIZE, 256);
            }
        }
    }

    static /* synthetic */ void i(FavVoiceBaseView favVoiceBaseView) {
        x.d("MicroMsg.FavVoiceBaseView", "start play, path[%s] voiceType[%d]", favVoiceBaseView.path, Integer.valueOf(favVoiceBaseView.fws));
        if (favVoiceBaseView.mwG.startPlay(favVoiceBaseView.path, favVoiceBaseView.fws)) {
            favVoiceBaseView.mBy.setKeepScreenOn(true);
            favVoiceBaseView.mBB.begin();
            return;
        }
        Toast.makeText(favVoiceBaseView.getContext(), R.l.ehi, 1).show();
    }

    static /* synthetic */ boolean j(FavVoiceBaseView favVoiceBaseView) {
        x.i("MicroMsg.FavVoiceBaseView", "resume play");
        boolean aJi = favVoiceBaseView.mwG.aJi();
        a aVar = favVoiceBaseView.mBB;
        aVar.isPaused = false;
        aVar.sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
        aVar.mBC.mBz.setImageResource(R.k.dBK);
        aVar.mBC.mBz.setContentDescription(aVar.mBC.getContext().getResources().getString(R.l.dGg));
        favVoiceBaseView.mBy.setKeepScreenOn(true);
        return aJi;
    }

    public FavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", Boolean.valueOf(this.mBB.isPaused));
        if (this.mBB.isPaused) {
            this.mBB.postDelayed(new Runnable() {
                public final void run() {
                    FavVoiceBaseView.this.mBB.aKj();
                }
            }, 128);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mBx = (ViewGroup) findViewById(R.h.cWI);
        this.mBA = (TextView) findViewById(R.h.cWG);
        this.mBy = (TextView) findViewById(R.h.cWH);
        this.mBz = (ImageButton) findViewById(R.h.cWF);
        this.mBB = new a();
        this.mBz.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!com.tencent.mm.o.a.aW(view.getContext()) && !com.tencent.mm.o.a.aU(view.getContext())) {
                    if (!f.zl() && !bi.oN(FavVoiceBaseView.this.path)) {
                        u.fJ(view.getContext());
                    } else if (!bi.aD(FavVoiceBaseView.this.path, "").equals(FavVoiceBaseView.this.mwG.path)) {
                        FavVoiceBaseView.i(FavVoiceBaseView.this);
                    } else if (FavVoiceBaseView.this.mwG.aJh()) {
                        FavVoiceBaseView.this.aJj();
                    } else if (!FavVoiceBaseView.j(FavVoiceBaseView.this)) {
                        FavVoiceBaseView.i(FavVoiceBaseView.this);
                    }
                }
            }
        });
    }

    public final void K(String str, int i, int i2) {
        this.path = bi.aD(str, "");
        this.fws = i;
        this.duration = i2;
        a aVar;
        if (!this.path.equals(this.mwG.path)) {
            this.mBB.qg(i2);
        } else if (this.mwG.aJh()) {
            x.i("MicroMsg.FavVoiceBaseView", "updateInfo .isPlay()");
            aVar = this.mBB;
            this.mwG.vg();
            aVar.fj(true);
        } else if (this.mwG.vh()) {
            x.i("MicroMsg.FavVoiceBaseView", "updateInfo .isPause()");
            aVar = this.mBB;
            this.mwG.vg();
            aVar.fj(false);
        } else {
            this.mBB.qg(i2);
        }
    }

    public final boolean aJj() {
        x.i("MicroMsg.FavVoiceBaseView", "pause play");
        boolean aJj = this.mwG.aJj();
        a aVar = this.mBB;
        aVar.isPaused = true;
        aVar.removeMessages(Downloads.RECV_BUFFER_SIZE);
        aVar.mBC.mBz.setImageResource(R.k.dBJ);
        aVar.mBC.mBz.setContentDescription(aVar.mBC.getContext().getResources().getString(R.l.dGv));
        this.mBy.setKeepScreenOn(false);
        return aJj;
    }

    public final void stopPlay() {
        x.d("MicroMsg.FavVoiceBaseView", "stop play");
        this.mwG.stopPlay();
        this.mBB.stop();
        this.mBy.setKeepScreenOn(false);
    }

    public final void bl(String str, int i) {
        x.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        if (bi.aD(str, "").equals(this.path)) {
            this.mBy.setKeepScreenOn(true);
            this.mBB.begin();
            return;
        }
        this.mBB.stop();
        this.mBy.setKeepScreenOn(false);
    }

    public final void onFinish() {
        stopPlay();
    }

    public final void onPause() {
        aJj();
    }
}
