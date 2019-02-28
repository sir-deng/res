package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.ToneGenerator;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;

public class ThrowBottleUI extends FrameLayout implements OnClickListener, a {
    private static final int[] kJJ = new int[]{0, 9, 18, 27, 37, 46, 55, 64, 74, 85, 93, 100};
    private static final int[] kJK = new int[]{R.g.byK, R.g.byN, R.g.byO, R.g.byP, R.g.byQ, R.g.byR, R.g.byS, R.g.byT, R.g.byU, R.g.byL, R.g.byM};
    ag handler = new ag();
    ImageView kIQ;
    BottleBeachUI kIt;
    boolean kJF = true;
    d kJL;
    ToneGenerator kJM;
    private long kJN = -1;
    Toast kJO;
    Vibrator kJP;
    ThrowBottleAnimUI kJQ;
    AnimationDrawable kJR;
    ImageView kJS;
    TextView kJT;
    ImageView kJU;
    MMEditText kJV;
    View kJW;
    Button kJX;
    ImageButton kJY;
    ThrowBottleFooter kJZ;
    boolean kKa = false;
    boolean kKb;
    LayoutParams kKc = null;
    private int kKd = 0;
    int kKe = 0;
    private ThrowBottleAnimUI.a kKf = new ThrowBottleAnimUI.a() {
        public final void asD() {
            ThrowBottleUI.this.kJQ.setVisibility(8);
            ThrowBottleUI.this.kIt.nE(0);
        }
    };
    final al kKg = new al(new al.a() {
        public final boolean uG() {
            int i = 0;
            if (ThrowBottleUI.this.kJL == null) {
                x.w("MM.Bottle.ThrowBottleUI", "bottle recder is null");
                return false;
            }
            int maxAmplitude = ThrowBottleUI.this.kJL.getMaxAmplitude();
            while (i < ThrowBottleUI.kJK.length) {
                if (maxAmplitude >= ThrowBottleUI.kJJ[i] && maxAmplitude < ThrowBottleUI.kJJ[i + 1]) {
                    ThrowBottleUI.this.kJS.setBackgroundDrawable(com.tencent.mm.bu.a.b(ThrowBottleUI.this.kIt, ThrowBottleUI.kJK[i]));
                    break;
                }
                i++;
            }
            return true;
        }
    }, true);
    final al kKh = new al(new al.a() {
        int count = 0;

        public final boolean uG() {
            if (ThrowBottleUI.this.kJN == -1) {
                ThrowBottleUI.this.kJN = bi.Wz();
            }
            if (this.count % 3 == 2) {
                ThrowBottleUI.this.kJT.setWidth(ThrowBottleUI.this.kJT.getWidth() + 1);
            }
            this.count++;
            this.count %= 3;
            long bB = bi.bB(ThrowBottleUI.this.kJN);
            if (bB >= 50000 && bB <= 60000) {
                int i;
                if (ThrowBottleUI.this.kJO == null) {
                    i = (int) ((60000 - bB) / 1000);
                    ThrowBottleUI.this.kJO = Toast.makeText(ThrowBottleUI.this.kIt, ThrowBottleUI.this.kIt.getResources().getQuantityString(R.j.duz, i, new Object[]{Integer.valueOf(i)}), 0);
                } else {
                    i = (int) ((60000 - bB) / 1000);
                    ThrowBottleUI.this.kJO.setText(ThrowBottleUI.this.kIt.getResources().getQuantityString(R.j.duz, i, new Object[]{Integer.valueOf(i)}));
                }
                ThrowBottleUI.this.kJO.show();
            }
            if (bB < 60000) {
                return true;
            }
            x.v("MM.Bottle.ThrowBottleUI", "bottle record stop on countdown");
            ThrowBottleUI.this.kKb = true;
            ThrowBottleUI.this.asM();
            ThrowBottleUI.this.kKa = false;
            as.H(ThrowBottleUI.this.kIt, R.l.eRw);
            return false;
        }
    }, true);
    boolean kKi = false;
    @SuppressLint({"HandlerLeak"})
    private final ag kKj = new ag() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ThrowBottleUI.this.kJX.setBackgroundDrawable(com.tencent.mm.bu.a.b(ThrowBottleUI.this.kIt, R.g.bFh));
            ThrowBottleUI.this.kJX.setEnabled(true);
        }
    };
    final h.a kKk = new h.a() {
        public final void onError() {
            ThrowBottleUI.this.kJL.reset();
            ThrowBottleUI.this.kKg.TN();
            ThrowBottleUI.this.kKh.TN();
            af.VJ("keep_app_silent");
            ThrowBottleUI.this.kKa = false;
            x.v("MM.Bottle.ThrowBottleUI", "bottle record stop on error");
            Toast.makeText(ThrowBottleUI.this.kIt, ThrowBottleUI.this.kIt.getString(R.l.dSO), 0).show();
        }
    };

    public ThrowBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIt = (BottleBeachUI) context;
    }

    public void setVisibility(int i) {
        this.kIQ.setVisibility(8);
        if (i == 0) {
            this.kJF = true;
            this.kJS.setVisibility(8);
            this.kJT.setVisibility(8);
            this.kJT.setWidth(b.b(this.kIt, 120.0f));
            this.kJU.setVisibility(0);
            ((View) this.kJV.getParent()).setVisibility(8);
            this.kJV.setText("");
            this.kJZ.setVisibility(0);
            c.d(this.kJV).Hg(com.tencent.mm.j.b.zG()).a(null);
            this.kJY.setImageDrawable(com.tencent.mm.bu.a.b(this.kIt, R.g.bBp));
            this.kJX.setBackgroundDrawable(com.tencent.mm.bu.a.b(this.kIt, R.g.bFh));
            this.kJX.setText(this.kJF ? R.l.dNj : R.l.dNg);
            ((LinearLayout) this.kIt.findViewById(R.h.bOL)).setVisibility(0);
            this.kIt.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            this.kIt.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        super.setVisibility(i);
    }

    public void onClick(View view) {
        if (R.h.bNX != view.getId()) {
            this.kIt.nE(0);
        } else if (this.kJF || this.kJV.getText().toString().trim().length() <= 0) {
            asK();
        } else {
            com.tencent.mm.ui.base.h.a(this.kIt, getResources().getString(R.l.dNd), null, getResources().getString(R.l.dNe), new com.tencent.mm.ui.base.h.c() {
                public final void jo(int i) {
                    if (i == 0) {
                        ThrowBottleUI.this.kJV.setText("");
                        ThrowBottleUI.this.asK();
                    }
                }
            }, null);
        }
    }

    private void asK() {
        boolean z;
        int i = 8;
        this.kJT.setVisibility(8);
        this.kJU.setVisibility(this.kJF ? 8 : 0);
        View view = (View) this.kJV.getParent();
        if (this.kJF) {
            i = 0;
        }
        view.setVisibility(i);
        if (this.kJF) {
            this.kJV.requestFocus();
        }
        if (this.kJF) {
            z = false;
        } else {
            z = true;
        }
        this.kJF = z;
        this.kJY.setImageDrawable(this.kJF ? com.tencent.mm.bu.a.b(this.kIt, R.g.bBp) : com.tencent.mm.bu.a.b(this.kIt, R.g.bBq));
        if (this.kJF) {
            dY(false);
        } else {
            dY(true);
        }
        this.kJX = (Button) this.kIt.findViewById(R.h.bOJ);
        this.kJX.setText(this.kJF ? R.l.dNj : R.l.dNg);
    }

    private void asL() {
        int left;
        int i;
        int width;
        if (this.kJF) {
            left = this.kJT.getLeft();
            i = left;
            left = this.kJT.getTop();
            width = this.kJT.getWidth();
        } else {
            width = this.kJV.getLeft();
            left = this.kJV.getTop();
            i = width;
            width = 0;
        }
        this.kJQ = (ThrowBottleAnimUI) this.kIt.findViewById(R.h.bOF);
        this.kJQ.kJE = this.kKf;
        ThrowBottleAnimUI throwBottleAnimUI = this.kJQ;
        throwBottleAnimUI.kJF = this.kJF;
        throwBottleAnimUI.Rn = i;
        throwBottleAnimUI.Ro = left;
        throwBottleAnimUI.kJD = width;
        throwBottleAnimUI.setVisibility(0);
        ah.h(new Runnable() {
            public final void run() {
                if (ThrowBottleAnimUI.this.kIt != null && !ThrowBottleAnimUI.this.kIt.isFinishing() && ThrowBottleAnimUI.this.kJw != null && ThrowBottleAnimUI.this.kJx != null) {
                    ThrowBottleAnimUI.this.kJw.setVisibility(0);
                    ThrowBottleAnimUI.this.kIt.kHe = false;
                    ThrowBottleAnimUI.this.kIt.nE(-1);
                    ThrowBottleAnimUI.this.asI();
                    ThrowBottleAnimUI.this.asG();
                    ThrowBottleAnimUI.f(ThrowBottleAnimUI.this);
                    ThrowBottleAnimUI.this.kJx.startAnimation(ThrowBottleAnimUI.this.kJy);
                }
            }
        }, 100);
    }

    private void dY(boolean z) {
        if (z) {
            ((InputMethodManager) this.kIt.getSystemService("input_method")).showSoftInput(this.kJV, 0);
        } else {
            ((InputMethodManager) this.kIt.getSystemService("input_method")).hideSoftInputFromWindow(this.kJV.getWindowToken(), 2);
        }
    }

    public final boolean asM() {
        x.d("MM.Bottle.ThrowBottleUI", "bottle record stop");
        if (this.kKi) {
            boolean vp;
            this.kIt.getWindow().getDecorView().setKeepScreenOn(false);
            if (this.kJR != null) {
                this.kJR.stop();
            }
            if (this.kJL != null) {
                vp = this.kJL.vp();
                af.VJ("keep_app_silent");
                this.kKg.TN();
                this.kKh.TN();
                this.kJN = -1;
            } else {
                vp = false;
            }
            if (vp) {
                asL();
            } else {
                this.kJX.setEnabled(false);
                this.kJX.setBackgroundDrawable(com.tencent.mm.bu.a.b(this.kIt, R.g.bFg));
                this.kJS.setVisibility(8);
                this.kJT.setVisibility(8);
                this.kKj.sendEmptyMessageDelayed(0, 500);
                com.tencent.mm.y.as.Hm();
                if (com.tencent.mm.y.c.isSDCardAvailable()) {
                    this.kIt.nD(R.l.dNf);
                }
            }
        }
        this.kKi = false;
        return false;
    }

    public final void ci(int i, int i2) {
        if (i2 == -2002) {
            this.kIt.nE(0);
            this.kIt.nD(R.l.dMN);
        }
    }
}
