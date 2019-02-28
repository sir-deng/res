package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.api.b;
import com.tencent.mm.api.e;
import com.tencent.mm.api.j;
import com.tencent.mm.api.k;
import com.tencent.mm.api.l;
import com.tencent.mm.api.m;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.plugin.mmsight.segment.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;

public final class a {
    MMActivity fnF;
    r ioc;
    VideoPlayerTextureView oDe;
    VideoSeekBarEditorView oDf;
    RecyclerThumbSeekBar oHh;
    boolean oHi = false;
    int oHj = -1;
    int oHk = -1;
    int oHl = -1;
    al oHm;
    ViewGroup oHn;
    m oHo;
    b oHp;
    com.tencent.mm.plugin.mmsight.api.a oHq;
    public a oHr;
    boolean oHs = false;
    public boolean oHt = false;
    private boolean oHu = false;
    private boolean oHv = false;
    public String oHw = null;
    public int oHx = -1;
    com.tencent.mm.plugin.mmsight.a.a.b oHy;
    VideoTransPara oxX;
    public int scene;
    String videoPath;

    public interface a {
        void bbK();

        void bbL();

        void onError();
    }

    static /* synthetic */ void a(a aVar) {
        int width = aVar.oDe.getWidth();
        int height = aVar.oDe.getHeight();
        int fromDPToPix = ((aVar.oDf.getHeight() <= 0 ? com.tencent.mm.bu.a.fromDPToPix(aVar.fnF, 100) : aVar.oDf.getHeight()) + com.tencent.mm.bu.a.fromDPToPix(aVar.fnF, 20)) + com.tencent.mm.bu.a.fromDPToPix(aVar.fnF, 12);
        if (ae.fz(aVar.fnF)) {
            fromDPToPix += ae.fy(aVar.fnF);
        }
        int i = height - fromDPToPix;
        if (aVar.oDe.getBottom() + fromDPToPix < d.dc(aVar.fnF).y) {
            i = (int) (((float) (width - (com.tencent.mm.bu.a.fromDPToPix(aVar.fnF, 32) * 2))) / (((float) width) / ((float) height)));
        }
        float f = ((float) ((int) ((((float) width) / ((float) height)) * ((float) i)))) / ((float) width);
        float f2 = ((float) i) / ((float) height);
        aVar.oDe.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300).setListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                if (a.this.oDe != null) {
                    a.this.oDe.requestLayout();
                }
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        aVar.oHp.animate().scaleX(f).scaleY(f2).translationY(-(((float) fromDPToPix) / 2.0f)).setDuration(300);
        aVar.oHp.aC(false);
        aVar.oHp.aD(false);
        aVar.oHp.aE(false);
        if (!aVar.oHi) {
            aVar.oHh.oEc = new com.tencent.mm.plugin.mmsight.segment.c.a() {
                public final void gJ(boolean z) {
                    if (z) {
                        x.e("MicroMsg.MMSightVideoEditor", "Not Supported init SegmentSeekBar failed.");
                        ah.y(new Runnable() {
                            public final void run() {
                                if (a.this.ioc != null) {
                                    a.this.ioc.dismiss();
                                }
                                if (a.this.oHr != null) {
                                    a.this.oHr.onError();
                                }
                            }
                        });
                    } else if (a.this.oHh != null) {
                        a.this.oHj = a.this.oHh.hQf;
                        x.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared success %d", Integer.valueOf(a.this.oHj));
                        try {
                            if (a.this.oDe != null) {
                                a.this.oHk = Math.round(((float) a.this.oHj) * a.this.oHh.bbF());
                                a.this.oHl = Math.round(((float) a.this.oHj) * a.this.oHh.bbG());
                                if (a.this.oHl <= 0) {
                                    if (a.this.oHj <= 10500) {
                                        a.this.oHl = a.this.oHj;
                                    } else {
                                        a.this.oHl = 10000;
                                    }
                                }
                                x.i("MicroMsg.MMSightVideoEditor", "thumbSeekBar onPrepared, start: %s, end: %s, duration: %s", Integer.valueOf(a.this.oHk), Integer.valueOf(a.this.oHl), Integer.valueOf(a.this.oHj));
                            }
                            a aVar = a.this;
                            aVar.oHm = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                                public final boolean uG() {
                                    if (a.this.oDe != null && a.this.oDe.isPlaying()) {
                                        if (a.this.oHl <= 0 || a.this.oDe.getCurrentPosition() < a.this.oHl) {
                                            a.this.oHh.al(((float) a.this.oDe.getCurrentPosition()) / ((float) a.this.oHj));
                                        } else {
                                            a.this.oDe.c((double) a.this.oHk, true);
                                            a.this.oHh.al(((float) a.this.oHk) / ((float) a.this.oHj));
                                        }
                                    }
                                    return true;
                                }
                            }, true);
                            aVar.oHm.K(20, 20);
                        } catch (Exception e) {
                        }
                    }
                }
            };
            aVar.oHh.oEd = new c.b() {
                public final void A(float f, float f2) {
                    if (a.this.oDe != null) {
                        int i = a.this.oHj;
                        a.this.oHk = Math.round(((float) i) * f);
                        a.this.oHl = Math.round(((float) i) * f2);
                        x.i("MicroMsg.MMSightVideoEditor", "onRecyclerChanged, start: %s, end: %s %s %s", Integer.valueOf(a.this.oHk), Integer.valueOf(a.this.oHl), Float.valueOf(f), Float.valueOf(f2));
                        a.this.oDe.c((double) a.this.oHk, true);
                    }
                }

                public final void bbH() {
                    if (a.this.oDe != null) {
                        a.this.oDe.pause();
                    }
                }

                public final void B(float f, float f2) {
                    if (a.this.oDe != null) {
                        int i = a.this.oHj;
                        a.this.oHk = Math.round(((float) i) * f);
                        a.this.oHl = Math.round(((float) i) * f2);
                        a.this.oDe.c((double) a.this.oHk, true);
                        x.i("MicroMsg.MMSightVideoEditor", "onUp, start: %s, end: %s %s %s", Integer.valueOf(a.this.oHk), Integer.valueOf(a.this.oHl), Float.valueOf(f), Float.valueOf(f2));
                    }
                }

                public final void C(float f, float f2) {
                }
            };
            aVar.oHh.FR(aVar.videoPath);
            aVar.oDe.qAJ = new com.tencent.mm.pluginsdk.ui.tools.f.a() {
                public final void hY() {
                }

                public final void vi() {
                    if (a.this.oHk > 0) {
                        a.this.oDe.c((double) a.this.oHk, true);
                    } else {
                        a.this.oDe.c(0.0d, true);
                    }
                }

                public final int ck(int i, int i2) {
                    return 0;
                }

                public final void cl(int i, int i2) {
                }

                public final void onError(int i, int i2) {
                }
            };
            aVar.oHi = true;
        }
        aVar.oDf.setVisibility(0);
        aVar.oDf.bringToFront();
        aVar.oDf.mpV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a.this.bcf();
                if (!a.this.oHs && a.this.oHj <= 10000) {
                    a aVar = a.this;
                    a.this.oHl = -1;
                    aVar.oHk = -1;
                    a.this.oDf.bco();
                    a.this.oHh = a.this.oDf.oJb;
                    a.this.oHi = false;
                }
            }
        });
        aVar.oDf.oJc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a.this.bcf();
                if (a.this.oHk >= 0 && a.this.oHl > 0) {
                    a.this.oHs = true;
                }
            }
        });
        aVar.oHv = true;
    }

    public final void a(MMActivity mMActivity, int i, String str, VideoSeekBarEditorView videoSeekBarEditorView, VideoPlayerTextureView videoPlayerTextureView, ViewGroup viewGroup, VideoTransPara videoTransPara, boolean z) {
        this.scene = i;
        this.videoPath = str;
        this.oDf = videoSeekBarEditorView;
        this.oHh = videoSeekBarEditorView.oJb;
        this.oDe = videoPlayerTextureView;
        this.oHn = viewGroup;
        this.fnF = mMActivity;
        this.oxX = videoTransPara;
        this.oHu = z;
        this.oHy = new com.tencent.mm.plugin.mmsight.a.a.b(i);
        this.oHo = m.fdT.sV();
        m mVar = this.oHo;
        com.tencent.mm.api.m.a.a aVar = new com.tencent.mm.api.m.a.a();
        aVar.fdV = false;
        aVar.fdX = true;
        aVar.fdU = m.c.fdZ;
        aVar.fdY = new Rect(this.oDe.getLeft(), this.oDe.getTop(), this.oDe.getRight(), this.oDe.getBottom());
        mVar.a(aVar.th());
        this.oHp = this.oHo.ai(this.oHn.getContext());
        this.oHp.a(new e() {
            public final void onFinish() {
                x.i("MicroMsg.MMSightVideoEditor", "photoEditor onFinish");
                a.this.oHo.a(new j() {
                    public final void b(Exception exception) {
                        x.e("MicroMsg.MMSightVideoEditor", "photoEditor onError: %s", exception);
                    }

                    public final void a(final Bitmap bitmap, boolean z) {
                        x.i("MicroMsg.MMSightVideoEditor", "photoEditor onSuccess: %s isNever：%s", bitmap, Boolean.valueOf(z));
                        if (z) {
                            if (!(bitmap == null || bitmap.isRecycled())) {
                                bitmap.recycle();
                            }
                            if (a.this.oHr == null || a.this.oHt) {
                                if (a.this.oHt) {
                                    ah.y(new Runnable() {
                                        public final void run() {
                                            a.this.ioc = h.a(a.this.fnF, a.this.fnF.getString(f.oKO), false, null);
                                            a.this.oDe.pause();
                                            com.tencent.mm.sdk.f.e.post(new Runnable(null) {
                                                public final void run() {
                                                    int i;
                                                    int i2;
                                                    int i3;
                                                    com.tencent.mm.plugin.sight.base.a JX = com.tencent.mm.plugin.sight.base.d.JX(a.this.videoPath);
                                                    if (JX != null) {
                                                        i = JX.width;
                                                        i2 = JX.height;
                                                        i3 = JX.videoBitrate;
                                                    } else {
                                                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                                                        mediaMetadataRetriever.setDataSource(a.this.videoPath);
                                                        i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), -1);
                                                        i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), -1);
                                                        i3 = bi.getInt(mediaMetadataRetriever.extractMetadata(20), -1);
                                                        mediaMetadataRetriever.release();
                                                    }
                                                    if (i <= 0 || i2 <= 0 || i3 <= 0) {
                                                        x.e("MicroMsg.MMSightVideoEditor", "doRemuxVideo, retrieve video metadata error, width: %s, height: %s, bitrate: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                                                        return;
                                                    }
                                                    int min;
                                                    String str;
                                                    long Wz;
                                                    com.tencent.mm.plugin.mmsight.a.a.b bVar;
                                                    boolean z;
                                                    if (a.this.oHt && a.this.oxX != null) {
                                                        Point point;
                                                        if (i3 > a.this.oxX.videoBitrate) {
                                                            i3 = a.this.oxX.videoBitrate;
                                                        }
                                                        int i4 = a.this.oxX.width;
                                                        int i5 = a.this.oxX.height;
                                                        x.d("MicroMsg.MMSightVideoEditor", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i4 + "], specHeight = [" + i5 + "]");
                                                        if (i > i4 || i2 > i5) {
                                                            int max = Math.max(i, i2);
                                                            min = Math.min(i, i2);
                                                            int max2 = Math.max(i4, i5);
                                                            int min2 = Math.min(i4, i5);
                                                            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                                                                x.i("MicroMsg.MMSightVideoEditor", "calc scale, same len divide by 16, no need scale");
                                                                point = null;
                                                            } else if (max / 2 == max2 && min / 2 == min2) {
                                                                x.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio");
                                                                i4 = i / 2;
                                                                i5 = i2 / 2;
                                                                if (i4 % 2 != 0) {
                                                                    i4++;
                                                                }
                                                                if (i5 % 2 != 0) {
                                                                    i5++;
                                                                }
                                                                point = new Point(i4, i5);
                                                            } else {
                                                                max /= 2;
                                                                min /= 2;
                                                                if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                                                                    Point point2 = new Point();
                                                                    if (i < i2) {
                                                                        i5 = Math.min(i4, i5);
                                                                        i4 = (int) (((double) i2) / ((1.0d * ((double) i)) / ((double) i5)));
                                                                    } else {
                                                                        i4 = Math.min(i4, i5);
                                                                        i5 = (int) (((double) i) / ((1.0d * ((double) i2)) / ((double) i4)));
                                                                    }
                                                                    if (i4 % 2 != 0) {
                                                                        i4++;
                                                                    }
                                                                    if (i5 % 2 != 0) {
                                                                        i5++;
                                                                    }
                                                                    x.i("MicroMsg.MMSightVideoEditor", "calc scale, outputsize: %s %s", Integer.valueOf(i5), Integer.valueOf(i4));
                                                                    point2.x = i5;
                                                                    point2.y = i4;
                                                                    point = point2;
                                                                } else {
                                                                    x.i("MicroMsg.MMSightVideoEditor", "calc scale, double ratio divide by 16");
                                                                    i4 = i / 2;
                                                                    i5 = i2 / 2;
                                                                    if (i4 % 2 != 0) {
                                                                        i4++;
                                                                    }
                                                                    if (i5 % 2 != 0) {
                                                                        i5++;
                                                                    }
                                                                    point = new Point(i4, i5);
                                                                }
                                                            }
                                                        } else {
                                                            x.i("MicroMsg.MMSightVideoEditor", "calc scale, small or equal to spec size");
                                                            point = null;
                                                        }
                                                        if (point != null) {
                                                            i = point.x;
                                                            i2 = point.y;
                                                            min = i3;
                                                            str = a.this.videoPath + "remuxOutput.mp4";
                                                            if (!bi.oN(a.this.oHw)) {
                                                                str = a.this.oHw;
                                                            }
                                                            if (a.this.oHk >= 0 || a.this.oHl <= 0) {
                                                                if (a.this.oHx == -1 && (a.this.oHx == 1 || a.this.oHx == 2)) {
                                                                    a.this.oHq = com.tencent.mm.plugin.mmsight.api.a.owC.a(a.this.oHx, a.this.videoPath, str, i, i2, min, a.this.oxX.fps);
                                                                } else {
                                                                    a.this.oHq = com.tencent.mm.plugin.mmsight.api.a.owC.a(a.this.videoPath, str, i, i2, min, a.this.oxX.fps);
                                                                }
                                                            } else if (a.this.oHx == -1 || !(a.this.oHx == 1 || a.this.oHx == 2)) {
                                                                a.this.oHq = com.tencent.mm.plugin.mmsight.api.a.owC.a(a.this.videoPath, str, i, i2, min, a.this.oxX.fps, (long) a.this.oHk, (long) a.this.oHl);
                                                            } else {
                                                                a.this.oHq = com.tencent.mm.plugin.mmsight.api.a.owC.a(a.this.oHx, a.this.videoPath, str, i, i2, min, a.this.oxX.fps, (long) a.this.oHk, (long) a.this.oHl);
                                                            }
                                                            x.i("MicroMsg.MMSightVideoEditor", "created remuxer, type: %s, remuxer: %s", Integer.valueOf(a.this.oHx), a.this.oHq);
                                                            if (a.this.oHq != null) {
                                                                ah.y(new Runnable() {
                                                                    public final void run() {
                                                                        if (a.this.ioc != null) {
                                                                            a.this.ioc.dismiss();
                                                                        }
                                                                        if (a.this.oHr != null) {
                                                                            a.this.oHr.onError();
                                                                        }
                                                                    }
                                                                });
                                                            }
                                                            com.tencent.mm.plugin.mmsight.segment.m.tn(a.this.oHq.getType());
                                                            Wz = bi.Wz();
                                                            if (r3 != null) {
                                                                a.this.oHq.z(r3);
                                                            }
                                                            if (a.this.oHq.baw() >= 0) {
                                                                x.e("MicroMsg.MMSightVideoEditor", "remux failed, ret: %s", Integer.valueOf(a.this.oHq.baw()));
                                                                ah.y(new Runnable() {
                                                                    public final void run() {
                                                                        if (a.this.ioc != null) {
                                                                            a.this.ioc.dismiss();
                                                                        }
                                                                        if (a.this.oHr != null) {
                                                                            a.this.oHr.onError();
                                                                        }
                                                                    }
                                                                });
                                                                com.tencent.mm.plugin.mmsight.segment.m.to(a.this.oHq.getType());
                                                                return;
                                                            }
                                                            if (bi.oN(a.this.oHw)) {
                                                                FileOp.at(str, a.this.videoPath);
                                                            }
                                                            com.tencent.mm.plugin.mmsight.segment.m.B(a.this.oHq.getType(), bi.bB(Wz));
                                                            bVar = a.this.oHy;
                                                            z = a.this.oHk < 0 && a.this.oHl > 0;
                                                            bVar.oCI = z;
                                                            a.this.oHy.oCF = a.this.oHl - a.this.oHk;
                                                            a.this.oHy.oCE = JX != null ? 0 : JX.mDe;
                                                            ah.y(new Runnable() {
                                                                public final void run() {
                                                                    if (a.this.ioc != null) {
                                                                        a.this.ioc.dismiss();
                                                                    }
                                                                    if (a.this.oHr != null) {
                                                                        a.this.oHr.bbK();
                                                                    }
                                                                }
                                                            });
                                                            return;
                                                        }
                                                    }
                                                    min = i3;
                                                    str = a.this.videoPath + "remuxOutput.mp4";
                                                    if (bi.oN(a.this.oHw)) {
                                                        str = a.this.oHw;
                                                    }
                                                    if (a.this.oHk >= 0) {
                                                    }
                                                    if (a.this.oHx == -1) {
                                                    }
                                                    a.this.oHq = com.tencent.mm.plugin.mmsight.api.a.owC.a(a.this.videoPath, str, i, i2, min, a.this.oxX.fps);
                                                    x.i("MicroMsg.MMSightVideoEditor", "created remuxer, type: %s, remuxer: %s", Integer.valueOf(a.this.oHx), a.this.oHq);
                                                    if (a.this.oHq != null) {
                                                        com.tencent.mm.plugin.mmsight.segment.m.tn(a.this.oHq.getType());
                                                        Wz = bi.Wz();
                                                        if (r3 != null) {
                                                            a.this.oHq.z(r3);
                                                        }
                                                        if (a.this.oHq.baw() >= 0) {
                                                            if (bi.oN(a.this.oHw)) {
                                                                FileOp.at(str, a.this.videoPath);
                                                            }
                                                            com.tencent.mm.plugin.mmsight.segment.m.B(a.this.oHq.getType(), bi.bB(Wz));
                                                            bVar = a.this.oHy;
                                                            if (a.this.oHk < 0) {
                                                            }
                                                            bVar.oCI = z;
                                                            a.this.oHy.oCF = a.this.oHl - a.this.oHk;
                                                            if (JX != null) {
                                                            }
                                                            a.this.oHy.oCE = JX != null ? 0 : JX.mDe;
                                                            ah.y(/* anonymous class already generated */);
                                                            return;
                                                        }
                                                        x.e("MicroMsg.MMSightVideoEditor", "remux failed, ret: %s", Integer.valueOf(a.this.oHq.baw()));
                                                        ah.y(/* anonymous class already generated */);
                                                        com.tencent.mm.plugin.mmsight.segment.m.to(a.this.oHq.getType());
                                                        return;
                                                    }
                                                    ah.y(/* anonymous class already generated */);
                                                }
                                            }, "MMSightVideoEditor_remux");
                                        }
                                    });
                                }
                            } else if (a.this.oHl <= 0 || a.this.oHj <= 0 || a.this.oHl > a.this.oHj) {
                                ah.y(new Runnable() {
                                    public final void run() {
                                        a.this.oHr.bbK();
                                    }
                                });
                            } else {
                                ah.y(new Runnable() {
                                    public final void run() {
                                        a.this.ioc = h.a(a.this.fnF, a.this.fnF.getString(f.oKO), false, null);
                                        a.this.oDe.pause();
                                        com.tencent.mm.sdk.f.e.post(/* anonymous class already generated */, "MMSightVideoEditor_remux");
                                    }
                                });
                            }
                        } else if (bitmap != null) {
                            ah.y(new Runnable() {
                                public final void run() {
                                    a.this.ioc = h.a(a.this.fnF, a.this.fnF.getString(f.oKO), false, null);
                                    a.this.oDe.pause();
                                    com.tencent.mm.sdk.f.e.post(/* anonymous class already generated */, "MMSightVideoEditor_remux");
                                }
                            });
                        }
                    }
                });
            }

            public final void sX() {
                x.i("MicroMsg.MMSightVideoEditor", "photoEditor onExit");
                a.this.release();
                if (a.this.oHr != null) {
                    ah.y(new Runnable() {
                        public final void run() {
                            a.this.oHr.bbL();
                        }
                    });
                }
            }
        });
        LayoutParams marginLayoutParams = new MarginLayoutParams(-1, -1);
        if (ae.fz(this.fnF)) {
            marginLayoutParams.height = d.bav().y - ae.fy(this.fnF);
        }
        this.oHn.addView(this.oHp, marginLayoutParams);
        this.oHp.fdI = new l() {
            public final void a(com.tencent.mm.api.d dVar) {
                x.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", dVar.name());
                if (dVar == com.tencent.mm.api.d.CROP_VIDEO) {
                    a.a(a.this);
                }
            }

            public final void a(com.tencent.mm.api.d dVar, int i) {
                x.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", dVar.name(), Integer.valueOf(i));
            }

            public final void aF(boolean z) {
                if (z) {
                    a.this.fnF.showVKB();
                } else {
                    a.this.fnF.df(a.this.oHn);
                }
            }
        };
        if (this.oHu) {
            this.oHp.post(new Runnable() {
                public final void run() {
                    a.this.oHp.aD(false);
                    a.this.oHp.aE(false);
                    a.this.oHp.setActivated(false);
                    a.a(a.this);
                }
            });
        }
    }

    final void bcf() {
        this.oDe.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.oDf.animate().alpha(0.0f).setDuration(100).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                a.this.oDf.setVisibility(8);
                a.this.oDf.setAlpha(1.0f);
            }
        });
        this.oHp.aD(true);
        this.oHp.aE(true);
        this.oHp.aC(true);
        this.oHp.animate().scaleX(1.0f).scaleY(1.0f).translationY(0.0f).setDuration(300);
        this.oHv = false;
    }

    public final void release() {
        try {
            if (this.oHm != null) {
                this.oHm.TN();
                this.oHm = null;
            }
            if (this.oHh != null) {
                this.oHh.release();
            }
            if (this.oHo != null) {
                this.oHo.onDestroy();
            }
            if (this.oHn != null) {
                this.oHn.removeView(this.oHp);
            }
            if (this.oDf != null) {
                this.oDf.bco();
            }
            this.oHi = false;
            com.tencent.mm.plugin.mmsight.model.a.j.oAr.Ez();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightVideoEditor", e, "release error: %s", e.getMessage());
        }
    }

    public final void gN(boolean z) {
        int i = 2;
        try {
            this.oHy.hpb = z;
            if (this.oHo == null) {
                x.e("MicroMsg.MMSightVideoEditor", "[report] null == photoEditor");
                return;
            }
            k sU = this.oHo.sU();
            this.oHy.oCG = sU.sZ();
            this.oHy.oCH = sU.sY();
            this.oHy.oCJ = sU.tb();
            this.oHy.gDf = sU.tc();
            this.oHy.oCK = sU.tf();
            this.oHy.textColor = sU.getTextColor();
            com.tencent.mm.plugin.mmsight.a.a.b bVar = this.oHy;
            g gVar = g.pWK;
            Object[] objArr = new Object[12];
            objArr[0] = Integer.valueOf(bVar.scene);
            if (!bVar.hpb) {
                i = 1;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(bVar.oCG);
            objArr[3] = Integer.valueOf(bVar.oCH);
            objArr[4] = Integer.valueOf(bVar.oCJ);
            objArr[5] = Boolean.valueOf(bVar.oCI);
            objArr[6] = Integer.valueOf(bVar.gDf);
            objArr[7] = Integer.valueOf(bVar.oCE);
            objArr[8] = Integer.valueOf(bVar.oCF);
            objArr[9] = Integer.valueOf(bVar.oCK);
            objArr[10] = Integer.valueOf(0);
            objArr[11] = Integer.valueOf(bVar.textColor);
            gVar.h(14362, objArr);
            x.i("MicroMsg.VideoEditReporter", "[report-VideoEditDetailData] %s", bVar.toString());
        } catch (Exception e) {
        }
    }

    public final boolean aeX() {
        if (this.oHv) {
            bcf();
            return true;
        } else if (this.oHo != null) {
            return this.oHo.sT();
        } else {
            return false;
        }
    }
}
