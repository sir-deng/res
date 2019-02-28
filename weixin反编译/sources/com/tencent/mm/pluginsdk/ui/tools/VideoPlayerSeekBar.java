package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.ab.a.a;
import com.tencent.mm.plugin.ab.a.b;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;

public class VideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements g {
    public boolean fwB = false;
    private int txc = -1;
    private int txd = -1;
    private int txe = -1;
    private PInt vEQ = new PInt();

    static /* synthetic */ int a(VideoPlayerSeekBar videoPlayerSeekBar, int i, PInt pInt) {
        int cdt = ((LayoutParams) videoPlayerSeekBar.qAp.getLayoutParams()).leftMargin - videoPlayerSeekBar.cdt();
        pInt.value = (int) (((((double) (i - cdt)) * 1.0d) / ((double) videoPlayerSeekBar.btI())) * ((double) videoPlayerSeekBar.qAu));
        if (pInt.value <= 0) {
            pInt.value = 0;
            return i - cdt > cdt ? i - cdt : cdt;
        } else if (pInt.value < videoPlayerSeekBar.qAu) {
            return i - cdt;
        } else {
            pInt.value = videoPlayerSeekBar.qAu;
            return videoPlayerSeekBar.btI() - (((videoPlayerSeekBar.btK() - videoPlayerSeekBar.cdt()) - videoPlayerSeekBar.cdu()) / 2);
        }
    }

    public VideoPlayerSeekBar(Context context) {
        super(context);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init() {
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.qAo = (ImageView) this.contentView.findViewById(a.pji);
        this.qAp = (ImageView) this.contentView.findViewById(a.pjh);
        this.qAq = (ImageView) this.contentView.findViewById(a.pjj);
        this.qAr = (ImageView) this.contentView.findViewById(a.cCK);
        this.qAs = (TextView) this.contentView.findViewById(a.pjf);
        this.qAt = (TextView) this.contentView.findViewById(a.pjg);
        this.qAq.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    x.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
                    VideoPlayerSeekBar.this.ktS = false;
                    VideoPlayerSeekBar.this.qAx = motionEvent.getX();
                    if (VideoPlayerSeekBar.this.qAn != null) {
                        VideoPlayerSeekBar.this.qAn.ahn();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) VideoPlayerSeekBar.this.qAq.getLayoutParams();
                    int a = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, ((int) (x - VideoPlayerSeekBar.this.qAx)) + layoutParams.leftMargin, VideoPlayerSeekBar.this.vEQ);
                    layoutParams.leftMargin = a;
                    VideoPlayerSeekBar.this.qAq.setLayoutParams(layoutParams);
                    int i = VideoPlayerSeekBar.this.vEQ.value;
                    if (VideoPlayerSeekBar.this.qAu > 0) {
                        layoutParams = (LayoutParams) VideoPlayerSeekBar.this.qAo.getLayoutParams();
                        layoutParams.width = a;
                        VideoPlayerSeekBar.this.qAo.setLayoutParams(layoutParams);
                    }
                    VideoPlayerSeekBar.this.qAs.setText(AdVideoPlayerLoadingBar.kJ(i / 60) + ":" + AdVideoPlayerLoadingBar.kJ(i % 60));
                    VideoPlayerSeekBar.this.ktS = true;
                } else {
                    int m = VideoPlayerSeekBar.this.mPosition;
                    if (VideoPlayerSeekBar.this.ktS) {
                        m = VideoPlayerSeekBar.this.mPosition = VideoPlayerSeekBar.this.vEQ.value;
                    }
                    if (VideoPlayerSeekBar.this.qAn != null) {
                        x.i("MicroMsg.VideoPlayerSeekBar", "current time : " + m);
                        VideoPlayerSeekBar.this.qAn.kK(m);
                    }
                    VideoPlayerSeekBar.this.ktS = false;
                }
                return true;
            }
        });
    }

    protected final int btK() {
        if (this.txc == -1) {
            this.txc = this.qAq.getWidth();
        }
        return this.txc;
    }

    private int cdt() {
        if (this.txd == -1) {
            this.txd = this.qAq.getPaddingLeft();
        }
        return this.txd;
    }

    private int cdu() {
        if (this.txe == -1) {
            this.txe = this.qAq.getPaddingRight();
        }
        return this.txe;
    }

    public final int eF(int i, int i2) {
        if (i <= 0) {
            this.qAp.getLayoutParams();
            return 0;
        } else if (i >= this.qAu) {
            return i2 - (((btK() - cdt()) - cdu()) / 2);
        } else {
            return (int) (((((double) i) * 1.0d) / ((double) this.qAu)) * ((double) i2));
        }
    }

    public int getLayoutId() {
        return b.cVp;
    }

    public final void seek(int i) {
        x.d("MicroMsg.VideoPlayerSeekBar", "seek position : " + i);
        if (i < 0) {
            i = 0;
        }
        if (i >= this.qAu) {
            i = this.qAu;
        }
        if (this.mPosition != i) {
            this.mPosition = i;
            ahu();
        }
    }

    public final void wD(int i) {
        this.qAu = i;
        this.mPosition = 0;
        this.qAt.setText(AdVideoPlayerLoadingBar.kJ(this.qAu / 60) + ":" + AdVideoPlayerLoadingBar.kJ(this.qAu % 60));
        ahu();
    }

    public void ahu() {
        if (this.qAu != 0 && !this.ktS && this.qAq != null && btI() != 0) {
            this.qAs.setText(AdVideoPlayerLoadingBar.kJ(this.mPosition / 60) + ":" + AdVideoPlayerLoadingBar.kJ(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qAq.getLayoutParams();
            int btI = btI();
            layoutParams.leftMargin = eF(this.mPosition, btI);
            this.qAq.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qAo.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qAu)) * ((double) btI));
            this.qAo.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void m(OnClickListener onClickListener) {
        if (this.qAr != null) {
            this.qAr.setOnClickListener(onClickListener);
        }
    }

    public void dd(boolean z) {
        this.fwB = z;
        super.dd(z);
    }

    public final void xr(int i) {
        seek(i);
    }

    public final void kq(boolean z) {
        dd(z);
    }
}
