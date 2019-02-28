package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class a {
    static c moI = new c();
    TextView moA = null;
    TextView moB = null;
    Button moC = null;
    Button moD = null;
    TextView moE = null;
    Animation moF = null;
    Animation moG = null;
    WeakReference<FaceDetectPrepareUI> moH = null;
    RelativeLayout mox = null;
    Button moy = null;
    ImageView moz = null;

    public static class b {
        boolean moM = false;
        public boolean moN = true;
        boolean moO = true;
        boolean moP = false;
        boolean moQ = false;
        boolean moR = false;
        boolean moS = false;
        int moT = 0;
        Bitmap moU = null;
        public String moV = null;
        String moW = null;
        String moX = null;
        String moY = null;
        int moZ = -1;
        String mpa = null;
        a mpb = null;
        OnClickListener mpc;
        OnClickListener mpd;
        OnClickListener mpe;
        OnClickListener mpf;

        public final String toString() {
            return "JumperConfig{isShowMainButton=" + this.moM + ", isShowStatusWordingTv=" + this.moN + ", isShowUploadStatusIv=" + this.moO + ", isShowCancelBtn=" + this.moP + ", isShowSubButton=" + this.moQ + ", isShowOneByOne=" + this.moR + ", oneByOneIndexStart=" + this.moT + ", statusWording='" + this.moV + '\'' + ", mainBtnText='" + this.moW + '\'' + ", subBtnText='" + this.moX + '\'' + ", cancelBtnText='" + this.moY + '\'' + ", statusIvRes=" + this.moZ + '}';
        }
    }

    public static class c extends CountDownTimer {
        WeakReference<TextView> mpg = null;
        WeakReference<TextView> mph = null;
        String mpi = null;
        int mpj = 0;
        int mpk = 0;

        public c() {
            super(Long.MAX_VALUE, 500);
        }

        public final void onTick(long j) {
            if (this.mpg == null || this.mpg.get() == null || this.mph == null || this.mph.get() == null) {
                x.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
                cancel();
            } else {
                TextView textView = (TextView) this.mph.get();
                ((TextView) this.mpg.get()).setText(this.mpi.substring(0, this.mpj));
                textView.setText(this.mpi.substring(this.mpj, this.mpj + (this.mpk % ((this.mpi.length() - this.mpj) + 1))));
            }
            this.mpk++;
        }

        public final void onFinish() {
        }
    }

    interface a {
    }

    a(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.moH = new WeakReference(faceDetectPrepareUI);
    }

    public final void dismiss() {
        moI.cancel();
        if (this.mox.getVisibility() == 0) {
            ah.y(new Runnable() {
                public final void run() {
                    a.this.moG.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            a.this.mox.setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    a.this.mox.startAnimation(a.this.moG);
                }
            });
        }
    }

    public final void w(Bitmap bitmap) {
        this.mox.setBackgroundDrawable(new BitmapDrawable(bitmap));
    }

    public final void a(final b bVar) {
        if (moI != null) {
            moI.cancel();
        }
        if (bVar != null) {
            x.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", bVar.toString());
            if (bVar.moP) {
                this.moC.setVisibility(0);
                this.moC.setText(bVar.moY);
                this.moC.setOnClickListener(bVar.mpf);
            } else {
                this.moC.setVisibility(4);
            }
            if (bVar.moM) {
                this.moy.setVisibility(0);
                this.moy.setText(bVar.moW);
                this.moy.setOnClickListener(bVar.mpc);
            } else {
                this.moy.setVisibility(4);
            }
            if (bVar.moQ) {
                this.moD.setVisibility(0);
                this.moD.setText(bVar.moX);
                this.moD.setOnClickListener(bVar.mpd);
            } else {
                this.moD.setVisibility(4);
            }
            if (bVar.moN) {
                this.moA.setVisibility(0);
                if (bVar.moR) {
                    this.moB.setVisibility(0);
                    int i = bVar.moT;
                    CharSequence charSequence = bVar.moV;
                    if (bi.oN(charSequence) || i >= charSequence.length() || i < 0) {
                        x.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
                        this.moA.setText(charSequence);
                        this.moB.setText("");
                    } else {
                        moI.cancel();
                        c cVar = moI;
                        WeakReference weakReference = new WeakReference(this.moA);
                        WeakReference weakReference2 = new WeakReference(this.moB);
                        cVar.mpi = charSequence;
                        cVar.mpj = i;
                        cVar.mpg = weakReference;
                        cVar.mph = weakReference2;
                        moI.start();
                    }
                } else {
                    this.moB.setVisibility(4);
                    this.moA.setText(bVar.moV);
                }
            } else {
                this.moA.setVisibility(4);
                this.moB.setVisibility(4);
            }
            if (bVar.moO) {
                this.moz.setVisibility(0);
                this.moz.setImageResource(bVar.moZ);
            } else {
                this.moz.setVisibility(4);
            }
            if (bVar.moS) {
                this.moE.setVisibility(0);
                this.moE.setText(bVar.mpa);
                this.moE.setOnClickListener(bVar.mpe);
            } else {
                this.moE.setVisibility(4);
            }
            if (bVar.moU != null) {
                this.mox.setBackgroundDrawable(new BitmapDrawable(bVar.moU));
            }
            if (this.mox.getVisibility() != 0) {
                this.mox.setVisibility(0);
                this.mox.startAnimation(this.moF);
                this.moF.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        x.i("MicroMsg.FaceDetectJumper", "showJumperEnd: %d", Long.valueOf(System.currentTimeMillis()));
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
            }
        }
    }

    public final boolean aHO() {
        return this.mox.getVisibility() != 8;
    }

    public static b pS(int i) {
        return a(i, null, null, null, null, null, null);
    }

    public static b a(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(i, str, str2, null, str3, onClickListener, onClickListener2);
    }

    public static b a(int i, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z = true;
        b bVar = new b();
        bVar.moZ = i;
        bVar.moV = str;
        bVar.moM = str2 != null;
        bVar.moW = str2;
        bVar.moQ = false;
        bVar.moX = null;
        if (str4 == null) {
            z = false;
        }
        bVar.moP = z;
        bVar.moY = str4;
        bVar.moS = false;
        bVar.mpa = null;
        bVar.mpc = onClickListener;
        bVar.mpd = null;
        bVar.mpf = onClickListener2;
        bVar.mpe = null;
        return bVar;
    }

    public static b a(b bVar, String str, OnClickListener onClickListener) {
        bVar.moS = str != null;
        bVar.mpa = str;
        bVar.mpe = onClickListener;
        return bVar;
    }

    public static b a(Context context, OnClickListener onClickListener) {
        b a = a(d.mio, context.getString(h.mjL), null, context.getString(h.dEy), null, onClickListener);
        a.moR = true;
        a.moT = context.getString(h.mjL).length() - 3;
        return a;
    }
}
