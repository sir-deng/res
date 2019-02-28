package com.tencent.mm.plugin.facedetect.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.m;
import android.support.v4.app.p;
import android.support.v4.view.ViewPager;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;

public final class b {
    View lzm;
    Button moC;
    Animation moG;
    u mqr;
    a mqs;
    ViewPager xS;

    @SuppressLint({"ValidFragment"})
    public static class c extends Fragment {
        private View lzm = null;
        private Button mqv = null;
        private WeakReference<b> mqw;

        public c(b bVar) {
            x.d("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo constructed");
            this.mqw = new WeakReference(bVar);
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.lzm = layoutInflater.inflate(g.mjy, viewGroup, false);
            this.mqv = (Button) this.lzm.findViewById(e.mjb);
            this.mqv.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (c.this.mqw.get() != null) {
                        b bVar = (b) c.this.mqw.get();
                        if (bVar.mqs != null) {
                            bVar.mqs.aHT();
                        }
                        bVar.dismiss();
                        return;
                    }
                    x.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
                }
            });
            return this.lzm;
        }

        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        public final void onDestroy() {
            super.onDestroy();
            x.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
        }
    }

    private class b extends p {
        public b(m mVar) {
            super(mVar);
        }

        public final Fragment R(int i) {
            switch (i) {
                case 0:
                    return new c(b.this);
                default:
                    throw new InvalidParameterException("hy: invalid page status");
            }
        }

        public final int getCount() {
            return 1;
        }
    }

    interface a {
        void aHT();

        void onCancel();
    }

    public b() {
        this.lzm = null;
        this.moG = null;
        this.moG = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.bpP);
        this.moG.setDuration(500);
    }

    public final void dismiss() {
        if (this.lzm.getVisibility() == 0) {
            ah.y(new Runnable() {
                public final void run() {
                    b.this.moG.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            b.this.lzm.setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    b.this.lzm.startAnimation(b.this.moG);
                }
            });
        }
    }
}
