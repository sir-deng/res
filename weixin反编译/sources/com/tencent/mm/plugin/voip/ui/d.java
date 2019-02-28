package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;

public abstract class d extends Fragment {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] swh = new int[]{-1, R.l.eVU, R.l.eWe, R.l.eWd};
    protected String gBJ;
    protected ag jQE;
    protected int mStatus = -1;
    protected boolean srZ;
    protected WeakReference<c> svT;
    protected long svV = -1;
    protected RelativeLayout swi;
    protected ImageView swj;
    protected ImageView swk;
    protected int swl = Downloads.RECV_BUFFER_SIZE;
    protected d swm;
    protected c swn = new c();
    private a swo;
    private b swp;

    public class b implements Runnable {
        public final void run() {
            x.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
            final Bitmap Ds = com.tencent.mm.sdk.platformtools.d.Ds(R.g.bHO);
            x.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
            d.this.jQE.post(new Runnable() {
                public final void run() {
                    if (d.this.swk != null) {
                        d.this.swk.setBackgroundDrawable(new BitmapDrawable(Ds));
                        d.this.swk.getBackground().setAlpha(bs.CTRL_INDEX);
                        d.this.swk.getBackground().setFilterBitmap(true);
                    }
                    d.this.swp = null;
                }
            });
        }
    }

    public interface d {
        void D(boolean z, boolean z2);
    }

    protected static class c {
        al ind = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                int i = c.this.swu[c.this.sww % c.this.swu.length];
                if (c.this.kO != null) {
                    if (-1 == i) {
                        c.this.kO.setText(null);
                    } else {
                        c.this.kO.setText(i);
                    }
                }
                c cVar = c.this;
                cVar.sww++;
                return true;
            }
        }, true);
        TextView kO;
        int[] swu;
        private int swv;
        int sww;

        protected c() {
        }

        public final void a(TextView textView, int[] iArr) {
            if (iArr == null || textView == null) {
                x.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
                return;
            }
            bIQ();
            this.sww = 0;
            this.swu = iArr;
            this.kO = textView;
            this.swv = 500;
            if (this.ind != null) {
                long j = (long) this.swv;
                this.ind.K(j, j);
            }
            x.j("MicroMsg.DynamicTextWrap", "start textview:" + textView, new Object[0]);
        }

        public final void bIQ() {
            if (this.ind != null) {
                this.ind.TN();
            }
            x.j("MicroMsg.DynamicTextWrap", "stop textview: " + this.kO, new Object[0]);
            this.kO = null;
        }
    }

    public class a implements Runnable {
        public final void run() {
            x.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
            Bitmap a = com.tencent.mm.ac.b.a(d.this.gBJ, false, -1);
            if (a != null && d.this.swi != null) {
                int i = 0;
                while (true) {
                    if ((d.this.swi.getHeight() == 0 || d.this.swi.getWidth() == 0) && i < 10) {
                        try {
                            Thread.sleep(300);
                            i++;
                        } catch (InterruptedException e) {
                            x.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
                            return;
                        }
                    }
                }
                if (a.getHeight() <= a.getWidth() && a.getHeight() / 5 > 0 && ((int) (((double) a.getHeight()) * 0.6d)) > 0) {
                    a = Bitmap.createBitmap(a, a.getWidth() / 5, a.getHeight() / 5, (int) (((double) a.getHeight()) * 0.6d), (int) (((double) a.getHeight()) * 0.6d), null, false);
                }
                a = com.tencent.mm.sdk.platformtools.d.a(a, a.getHeight(), (int) (((float) a.getHeight()) / ((1.0f * ((float) d.this.swi.getHeight())) / ((float) d.this.swi.getWidth()))), true, false);
                if (a == null) {
                    x.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
                    return;
                }
                try {
                    a = com.tencent.mm.sdk.platformtools.d.c(a, 20);
                    x.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
                    d.this.jQE.post(new Runnable() {
                        public final void run() {
                            if (d.this.swj != null) {
                                d.this.swj.setBackgroundDrawable(new BitmapDrawable(a));
                                d.this.swj.getBackground().setAlpha(FileUtils.S_IWUSR);
                            }
                            d.this.swo = null;
                        }
                    });
                } catch (Exception e2) {
                    x.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + e2.getMessage());
                }
            }
        }
    }

    protected abstract void Ni(String str);

    public abstract void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void b(int i, int i2, int[] iArr);

    public abstract void b(CaptureView captureView);

    public abstract void bHJ();

    protected abstract void bIM();

    protected abstract void bIN();

    protected abstract void cr(String str, int i);

    public abstract void setMute(boolean z);

    public abstract void zc(int i);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.gBJ = arguments.getString("key_username");
        this.srZ = arguments.getBoolean("key_isoutcall");
        if (-1 == this.mStatus) {
            this.mStatus = arguments.getInt("key_status");
        }
        this.jQE = new ag();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Display defaultDisplay;
        if (VERSION.SDK_INT >= 23) {
            defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            mScreenWidth = displayMetrics.widthPixels;
            mScreenHeight = displayMetrics.heightPixels;
        } else if (mScreenWidth == 0) {
            defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            mScreenWidth = defaultDisplay.getWidth();
            mScreenHeight = defaultDisplay.getHeight();
        }
    }

    public void dU(int i, int i2) {
        this.swl = i;
        this.mStatus = i2;
    }

    public final void fg(long j) {
        this.svV = j;
    }

    public void uninit() {
        x.d("MicroMsg.VoipBaseFragment", "uninit");
        this.swn.bIQ();
        c cVar = this.swn;
        x.d("MicroMsg.DynamicTextWrap", "uninit");
        cVar.bIQ();
        cVar.ind = null;
        if (this.swo != null) {
            e.remove(this.swo);
            this.swo = null;
        }
        if (this.swp != null) {
            e.remove(this.swp);
            this.swp = null;
        }
    }

    public void onDetach() {
        if (this.jQE != null) {
            this.jQE.removeCallbacksAndMessages(null);
        }
        this.swm = null;
        super.onDetach();
    }

    public final void a(c cVar) {
        this.svT = new WeakReference(cVar);
    }

    public final void a(d dVar) {
        this.swm = dVar;
    }

    protected final void b(TextView textView, String str) {
        if (textView == null || bi.oN(str)) {
            x.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
            return;
        }
        textView.setText(str);
        textView.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        textView.setWidth(textView.getMeasuredWidth());
    }

    public void onStop() {
        super.onStop();
    }

    protected final void bIO() {
        if (this.gBJ != null && this.swj.getVisibility() != 0) {
            this.swj.setVisibility(0);
            this.swo = new a();
            e.post(this.swo, "VoipBaseFragment_blurbitmap");
        }
    }

    protected final void bIP() {
        this.swk.setVisibility(0);
        this.swp = new b();
        e.post(this.swp, "VoipBaseFragment_blurtransparentbitmap");
    }

    protected static String bq(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    protected static void F(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i;
            view.setLayoutParams(layoutParams);
        }
    }
}
