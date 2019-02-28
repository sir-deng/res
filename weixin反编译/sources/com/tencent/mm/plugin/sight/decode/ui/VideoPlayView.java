package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.ah.a.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class VideoPlayView extends RelativeLayout implements f, com.tencent.mm.y.d.a {
    private int duration = 0;
    public String hFn;
    private ag hbP = new ag();
    private boolean kYN = false;
    public f kYP = null;
    public View kbO;
    private ProgressBar lvk;
    private int qBb = 320;
    private int qBc = 240;
    private boolean qBd = true;
    public a qBe;
    private ViewGroup qBf;
    public a qBg;
    private double qBh = 0.0d;
    public TextView qBi;
    public String qBj = "";
    public View qBk;
    public View qBl;
    public boolean qBm = true;
    private int qBn = 0;
    private int qBo = 0;
    private boolean qBp = false;
    private boolean qBq = false;
    private long qBr = 0;
    private Animation qBs = new AlphaAnimation(1.0f, 0.0f);
    private Animation qBt = new AlphaAnimation(0.0f, 1.0f);
    private Runnable qBu = new Runnable() {
        public final void run() {
            VideoPlayView.this.btP();
        }
    };
    public int qBv = 0;

    public interface a {
        void btS();

        void btT();

        void btU();

        void ij(boolean z);

        void wF(int i);
    }

    static /* synthetic */ void m(VideoPlayView videoPlayView) {
        if (videoPlayView.qBk.getVisibility() == 0) {
            videoPlayView.btP();
        } else {
            videoPlayView.btO();
        }
    }

    public final void setVideoPath(String str) {
        this.hFn = str;
        x.i("MicroMsg.VideoPlayView", "videoPath  %s", this.hFn);
        this.kYP.setVideoPath(this.hFn);
    }

    public VideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VideoPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.qBs.setDuration(200);
        this.qBt.setDuration(200);
        View.inflate(getContext(), com.tencent.mm.plugin.ah.a.f.qMg, this);
        this.qBk = findViewById(e.sjB);
        this.qBl = findViewById(e.sjA);
        this.lvk = (ProgressBar) findViewById(e.cEk);
        this.qBf = (ViewGroup) findViewById(e.cUP);
        this.kYP = n.es(getContext());
        this.kYP.cR(false);
        this.qBf.addView((View) this.kYP, 0, new LayoutParams(-1, -1));
        this.qBi = (TextView) findViewById(e.cOn);
        this.kbO = this.qBi;
        this.kYP.a(new com.tencent.mm.pluginsdk.ui.tools.f.a() {
            public final void hY() {
                x.d("MicroMsg.VideoPlayView", g.zn() + " onPrepared");
                VideoPlayView.this.ih(true);
            }

            public final void onError(int i, int i2) {
                x.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", Integer.valueOf(i), Integer.valueOf(i2));
                VideoPlayView.this.kYP.stop();
            }

            public final void vi() {
                x.d("MicroMsg.VideoPlayView", "on completion " + bi.chl().toString());
                if (VideoPlayView.this.qBp) {
                    VideoPlayView.this.qBg.dd(false);
                    VideoPlayView.this.wE((int) VideoPlayView.this.qBh);
                    VideoPlayView.this.btO();
                    if (VideoPlayView.this.qBe != null) {
                        VideoPlayView.this.qBe.btU();
                        return;
                    }
                    return;
                }
                VideoPlayView.this.qBh = 0.0d;
                VideoPlayView.this.q(0.0d);
                VideoPlayView.this.qBg.dd(false);
                VideoPlayView.this.wE(0);
                VideoPlayView.this.btO();
                if (System.currentTimeMillis() - VideoPlayView.this.qBr < 2000) {
                    x.i("MicroMsg.VideoPlayView", "Too short onCompletion");
                    return;
                }
                VideoPlayView.this.qBr = System.currentTimeMillis();
                if (VideoPlayView.this.qBe != null) {
                    VideoPlayView.this.qBe.btT();
                }
            }

            public final int ck(final int i, final int i2) {
                ah.y(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.VideoPlayView", "play time " + i + " video time " + i2);
                        if (i2 > 0) {
                            VideoPlayView.this.duration = i2;
                            if (VideoPlayView.this.qBg != null && VideoPlayView.this.qBd) {
                                VideoPlayView.this.qBd = false;
                            }
                            VideoPlayView.this.qBe.wF(i2);
                        }
                        if (VideoPlayView.this.qBg != null) {
                            if (VideoPlayView.this.qBg.btG() != i2) {
                                VideoPlayView.this.qBg.wD(i2);
                            }
                            VideoPlayView.this.qBg.seek(i);
                            VideoPlayView.this.qBg.dd(true);
                        }
                        if (VideoPlayView.this.lvk.getVisibility() == 0) {
                            VideoPlayView.this.lvk.setVisibility(8);
                        }
                        VideoPlayView.this.qBh = (double) i;
                    }
                });
                return 0;
            }

            public final void cl(int i, int i2) {
                VideoPlayView.this.qBb = i;
                VideoPlayView.this.qBc = i2;
                if (VideoPlayView.this.qBq) {
                    VideoPlayView.this.hbP.post(new Runnable() {
                        public final void run() {
                            VideoPlayView.this.update(VideoPlayView.this.qBv);
                        }
                    });
                }
            }
        });
        if (this.kYP instanceof VideoSightView) {
            ((VideoSightView) this.kYP).rsy = false;
        }
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    VideoPlayView.m(VideoPlayView.this);
                } else {
                    motionEvent.getAction();
                }
                return true;
            }
        });
        btP();
        ((View) this.kYP).post(new Runnable() {
            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (VideoPlayView.this.getContext() instanceof MMActivity) {
                    ((MMActivity) VideoPlayView.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    if (VideoPlayView.this.kYP instanceof VideoSightView) {
                        ((VideoSightView) VideoPlayView.this.kYP).wB(displayMetrics.widthPixels);
                    }
                }
                ((View) VideoPlayView.this.kYP).requestLayout();
                ((View) VideoPlayView.this.kYP).postInvalidate();
            }
        });
    }

    public final void ig(boolean z) {
        this.qBp = z;
        if (this.kYP != null && (this.kYP instanceof VideoSightView)) {
            VideoSightView videoSightView = (VideoSightView) this.kYP;
            if (videoSightView.qAD != null) {
                videoSightView.qAD.qzJ = !z;
            }
        }
    }

    public final void btN() {
        this.lvk.setVisibility(0);
    }

    private void btO() {
        ((View) this.qBg).setVisibility(0);
        this.qBk.setVisibility(0);
        if (this.qBm) {
            this.qBl.setVisibility(0);
        }
        int i = this.qBv == 2 ? 0 : bi.oN(this.qBj) ? 0 : 1;
        if (i != 0) {
            this.kbO.setVisibility(0);
        }
        this.hbP.removeCallbacks(this.qBu);
        this.hbP.postDelayed(this.qBu, 3000);
    }

    public final void btP() {
        if (this.qBg != null) {
            ((View) this.qBg).setVisibility(4);
        }
        this.qBk.setVisibility(8);
        this.qBl.setVisibility(8);
        this.kbO.setVisibility(8);
    }

    public final boolean start() {
        ih(true);
        return true;
    }

    public final void pause() {
        wE(-1);
    }

    private void ih(boolean z) {
        this.kYP.q(this.qBh);
        this.kYP.start();
        x.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.qBh);
        if (this.qBe != null) {
            this.qBe.ij(z);
        }
    }

    private void wE(int i) {
        this.qBh = i >= 0 ? (double) i : this.kYP.btQ();
        x.i("MicroMsg.VideoPlayView", "pause play " + this.qBh + " lastTime: " + i + " last " + this.kYP.btQ());
        this.kYP.pause();
        this.hbP.post(new Runnable() {
            public final void run() {
                if (VideoPlayView.this.qBg != null) {
                    VideoPlayView.this.qBg.dd(false);
                }
            }
        });
        if (this.qBe != null) {
            this.qBe.btS();
        }
    }

    public final boolean isPlaying() {
        return this.kYP.isPlaying();
    }

    public final String Uy() {
        return this.hFn;
    }

    public final boolean k(Context context, boolean z) {
        return this.kYP.k(context, z);
    }

    public final void stop() {
        this.kYP.stop();
    }

    public final void onDetach() {
        this.kYP.onDetach();
    }

    public final void cR(boolean z) {
        this.kYP.cR(z);
    }

    public final double btQ() {
        return Math.max(this.qBh, this.kYP.btQ());
    }

    public final void a(com.tencent.mm.pluginsdk.ui.tools.f.a aVar) {
        this.kYP.a(aVar);
    }

    public final int getCurrentPosition() {
        return this.kYP.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.duration == 0) {
            return this.kYP.getDuration();
        }
        return this.duration;
    }

    public final void q(double d) {
        this.kYP.q(d);
        this.qBg.seek((int) d);
    }

    public final void ii(boolean z) {
        this.kYP.ii(z);
    }

    public final void update(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.qBq = true;
        if (this.qBo == 0 || this.qBn == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.qBo = displayMetrics.heightPixels;
            this.qBn = displayMetrics.widthPixels;
            if (this.qBo < this.qBn) {
                this.qBo = displayMetrics.widthPixels;
                this.qBn = displayMetrics.heightPixels;
            }
            x.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.qBo + " screen_width:" + this.qBn);
        }
        ViewGroup.LayoutParams layoutParams2 = this.qBf.getLayoutParams();
        if (this.qBg == null) {
            layoutParams = null;
        } else {
            layoutParams = (LayoutParams) ((View) this.qBg).getLayoutParams();
        }
        ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        if (i == 1) {
            layoutParams3.width = this.qBn;
            layoutParams3.height = (int) (((((double) this.qBn) * 1.0d) * ((double) this.qBc)) / ((double) this.qBb));
            if (this.qBg != null) {
                layoutParams.bottomMargin = b.b(getContext(), 0.0f);
            }
        } else {
            layoutParams3.height = this.qBn;
            layoutParams3.width = (int) (((((double) this.qBn) * 1.0d) * ((double) this.qBb)) / ((double) this.qBc));
            if (this.qBg != null) {
                layoutParams.bottomMargin = b.b(getContext(), 0.0f);
            }
        }
        if (this.qBg != null) {
            this.qBg.btJ();
            ((View) this.qBg).setLayoutParams(layoutParams);
            if (this.qBg instanceof AdVideoPlayerLoadingBar) {
                this.hbP.postDelayed(new Runnable() {
                    public final void run() {
                        if (!VideoPlayView.this.kYP.isPlaying()) {
                            ((AdVideoPlayerLoadingBar) VideoPlayView.this.qBg).ahu();
                        }
                    }
                }, 500);
            }
        }
        x.i("MicroMsg.VideoPlayView", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.kYP).setLayoutParams(layoutParams3);
        if (this.kYP instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.kYP).dx(layoutParams3.width, layoutParams3.height);
        }
        layoutParams2.height = layoutParams3.height;
        layoutParams2.width = layoutParams3.width;
        this.qBf.setLayoutParams(layoutParams2);
        ((View) this.kYP).requestLayout();
    }

    public final long btR() {
        return 0;
    }

    public final void setMute(boolean z) {
        this.kYN = z;
    }

    public final void c(double d, boolean z) {
        q(d);
    }

    public final void a(f.e eVar) {
    }

    public final void a(c cVar) {
    }

    public final void a(f.b bVar) {
    }

    public final void a(d dVar) {
    }
}
