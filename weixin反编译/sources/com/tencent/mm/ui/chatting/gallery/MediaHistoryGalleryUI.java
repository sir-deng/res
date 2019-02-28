package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.chatting.c.a.b;
import com.tencent.mm.ui.chatting.c.a.c;
import com.tencent.mm.ui.chatting.e.e;

public class MediaHistoryGalleryUI extends MMActivity implements OnClickListener, b {
    private RecyclerView Va;
    private int hGs;
    private String jXh;
    private TextView liY;
    private ProgressDialog nFW;
    private long yGO;
    private boolean yMI = false;
    private View yMM;
    private View yMO;
    private View yMP;
    private View yMQ;
    private View yMR;
    private int yPA = -1;
    private boolean yPB;
    private int yPC;
    private com.tencent.mm.ui.chatting.c.a.a yPw;
    private TextView yPx;
    private boolean yPy;
    private boolean yPz;

    private static class a {
        public static com.tencent.mm.ui.chatting.c.a.a al(Context context, int i) {
            switch (AnonymousClass6.yPF[i - 1]) {
                case 1:
                    return new e(context);
                default:
                    return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI$6 */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] yPF = new int[c.cvd().length];

        static {
            try {
                yPF[c.yLC - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        com.tencent.mm.ui.chatting.c.a.a al;
        super.onCreate(bundle);
        this.yMI = true;
        Intent intent = getIntent();
        if (intent.getIntExtra("kintent_intent_source", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.yPy = z;
        this.jXh = intent.getStringExtra("kintent_talker");
        this.yPA = intent.getIntExtra("kintent_image_index", -1);
        this.yPz = intent.getBooleanExtra("key_is_biz_chat", false);
        this.yGO = getIntent().getLongExtra("key_biz_chat_id", -1);
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 1:
                al = a.al(this, c.yLC);
                break;
            default:
                al = a.al(this, c.yLC);
                break;
        }
        al.a(this);
        initView();
        this.yPw.y(true, this.yPA);
    }

    protected void onResume() {
        super.onResume();
        this.yPw.onResume();
        if (this.yMI) {
            if (this.yPw.cuY()) {
                cuW();
            } else {
                cuX();
            }
        }
        this.yMI = false;
    }

    protected void onPause() {
        super.onPause();
        HardCoderJNI.stopPerformace(HardCoderJNI.hcMediaGalleryScrollEnable, this.hGs);
        this.hGs = 0;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.yPw.onDetach();
    }

    protected final void initView() {
        super.initView();
        this.yMM = findViewById(R.h.cxo);
        this.yMP = findViewById(R.h.cSS);
        this.yMR = findViewById(R.h.bBF);
        this.yMQ = findViewById(R.h.cIL);
        this.yMO = findViewById(R.h.cgk);
        this.yMO.setTag(Integer.valueOf(1));
        this.yMP.setTag(Integer.valueOf(0));
        this.yMQ.setTag(Integer.valueOf(3));
        this.yMR.setTag(Integer.valueOf(2));
        this.yMO.setOnClickListener(this);
        this.yMP.setOnClickListener(this);
        this.yMQ.setOnClickListener(this);
        this.yMR.setOnClickListener(this);
        this.yPx = (TextView) findViewById(R.h.bJV);
        this.liY = (TextView) findViewById(R.h.cJY);
        this.Va = (RecyclerView) findViewById(R.h.coG);
        this.Va.setBackgroundColor(getResources().getColor(R.e.brl));
        findViewById(R.h.bYO).setBackgroundColor(getResources().getColor(R.e.brl));
        this.Va.a(this.yPw.fN(this));
        this.Va.a(this.yPw.fO(this));
        this.Va.a(this.yPw.aw(this.jXh, this.yGO));
        this.Va.Ub = true;
        this.Va.UC = new k() {
            public final void c(RecyclerView recyclerView, int i, int i2) {
                super.c(recyclerView, i, i2);
            }
        };
        this.Va.a(new k() {
            private Runnable mYD = new Runnable() {
                public final void run() {
                    MediaHistoryGalleryUI.this.yPx.startAnimation(AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.mController.xRr, R.a.bqa));
                    MediaHistoryGalleryUI.this.yPx.setVisibility(8);
                }
            };

            private void fu(boolean z) {
                if (z) {
                    MediaHistoryGalleryUI.this.yPx.removeCallbacks(this.mYD);
                    if (MediaHistoryGalleryUI.this.yPx.getVisibility() != 0) {
                        MediaHistoryGalleryUI.this.yPx.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(MediaHistoryGalleryUI.this.mController.xRr, R.a.bpZ);
                        MediaHistoryGalleryUI.this.yPx.setVisibility(0);
                        MediaHistoryGalleryUI.this.yPx.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                MediaHistoryGalleryUI.this.yPx.removeCallbacks(this.mYD);
                MediaHistoryGalleryUI.this.yPx.postDelayed(this.mYD, 256);
            }

            public final void c(RecyclerView recyclerView, int i, int i2) {
                super.c(recyclerView, i, i2);
                com.tencent.mm.ui.chatting.a.a aVar = (com.tencent.mm.ui.chatting.a.a) MediaHistoryGalleryUI.this.yPw.cuU();
                com.tencent.mm.ui.chatting.a.a.c FV = aVar.FV(((LinearLayoutManager) MediaHistoryGalleryUI.this.yPw.fN(MediaHistoryGalleryUI.this)).fa());
                if (FV != null) {
                    MediaHistoryGalleryUI.this.yPx.setText(bi.aD(aVar.gc(FV.hQu), ""));
                }
            }

            public final void e(RecyclerView recyclerView, int i) {
                if (1 == i) {
                    fu(true);
                    HardCoderJNI.stopPerformace(HardCoderJNI.hcMediaGalleryScrollEnable, MediaHistoryGalleryUI.this.hGs);
                    MediaHistoryGalleryUI.this.hGs = HardCoderJNI.startPerformance(HardCoderJNI.hcMediaGalleryScrollEnable, HardCoderJNI.hcMediaGalleryScrollDelay, HardCoderJNI.hcMediaGalleryScrollCPU, HardCoderJNI.hcMediaGalleryScrollIO, HardCoderJNI.hcMediaGalleryScrollThr ? Process.myTid() : 0, HardCoderJNI.hcMediaGalleryScrollTimeout, 703, HardCoderJNI.hcMediaGalleryScrollAction, "MicroMsg.MediaHistoryGalleryUI");
                } else if (i == 0) {
                    fu(false);
                }
                if (recyclerView.TV instanceof LinearLayoutManager) {
                    if (((LinearLayoutManager) recyclerView.TV).fa() == 0) {
                        MediaHistoryGalleryUI.this.yPw.y(false, -1);
                    }
                    o.PG().bp(i);
                }
            }
        });
        setMMTitle(this.yPw.Xf());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MediaHistoryGalleryUI.this.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dno;
    }

    public final void mY(boolean z) {
        if (z) {
            n(true, null);
        } else {
            this.yPC = ((GridLayoutManager) this.Va.TV).fb();
        }
    }

    public final void z(boolean z, int i) {
        x.i("MicroMsg.MediaHistoryGalleryUI", "[onDataLoaded] isFirst:%s addCount:%s mIntentPos:%s", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.yPA));
        if (z) {
            n(false, null);
            this.Va.fn().UR.notifyChanged();
            if (this.yPA != -1) {
                this.Va.TV.be(this.yPA);
            } else {
                this.Va.TV.be(this.Va.fn().getItemCount() - 1);
            }
            if (i <= 0) {
                this.liY.setVisibility(0);
                this.Va.setVisibility(8);
                this.liY.setText(getString(R.l.dSP));
                return;
            }
            this.liY.setVisibility(8);
            this.Va.setVisibility(0);
        } else if (i > 0) {
            this.Va.fn().W(0, i);
            this.Va.fn().U(i, this.yPC + i);
        } else {
            this.Va.fn().bj(0);
        }
    }

    public final View getChildAt(int i) {
        return this.Va.getChildAt(i);
    }

    public final void Ga(int i) {
        setMMTitle(getString(R.l.elR, new Object[]{Integer.valueOf(i)}));
        GB(i);
    }

    public void onClick(View view) {
        this.yPw.FZ(((Integer) view.getTag()).intValue());
    }

    public void onBackPressed() {
        super.onBackPressed();
        x.i("MicroMsg.MediaHistoryGalleryUI", "[onBackPressed] ");
        if (this.yPB) {
            this.yPw.cuZ();
        } else {
            finish();
        }
    }

    public final void cuW() {
        this.yPw.cuW();
        setMMTitle(getString(R.l.elR, new Object[]{Integer.valueOf(this.yPw.cuV())}));
        this.yMM.setVisibility(0);
        this.yMM.startAnimation(AnimationUtils.loadAnimation(this, R.a.bqo));
        GB(this.yPw.cuV());
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.l.elm), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MediaHistoryGalleryUI.this.cuX();
                return true;
            }
        });
    }

    public final void cuX() {
        this.yPw.cuX();
        setMMTitle(this.yPw.Xf());
        this.yMM.setVisibility(8);
        this.yMM.startAnimation(AnimationUtils.loadAnimation(this, R.a.bqm));
        removeOptionMenu(0);
        addTextOptionMenu(0, getString(R.l.eln), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MediaHistoryGalleryUI.this.cuW();
                return true;
            }
        });
    }

    public final void cva() {
        this.yPB = true;
        n(true, getString(R.l.epy));
    }

    public final void cuZ() {
        cuX();
        this.yPB = false;
        n(false, "");
    }

    public final void cvb() {
        cuX();
        this.yPB = false;
        n(false, "");
        String substring = com.tencent.mm.compatible.util.e.gJf.substring(com.tencent.mm.compatible.util.e.gJf.indexOf("tencent/MicroMsg"));
        Toast.makeText(this, getString(R.l.dSQ, new Object[]{substring}), 1).show();
    }

    public final void Gb(int i) {
        cuX();
        n(false, "");
        if (i == 0) {
            i = R.l.elP;
        }
        if (this.yPB) {
            h.a((Context) this, i, R.l.dGZ, true, null);
        }
        this.yPB = false;
    }

    public final boolean cvc() {
        return this.yPB;
    }

    private void GB(int i) {
        if (!this.yPw.cuY() || i <= 0) {
            this.yMO.setEnabled(false);
            this.yMP.setEnabled(false);
            this.yMQ.setEnabled(false);
            this.yMR.setEnabled(false);
            return;
        }
        this.yMO.setEnabled(true);
        this.yMP.setEnabled(true);
        this.yMQ.setEnabled(true);
        this.yMR.setEnabled(true);
    }

    private void n(boolean z, String str) {
        x.i("MicroMsg.MediaHistoryGalleryUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            CharSequence str2;
            if (str2 == null) {
                str2 = getString(R.l.ctG);
            }
            this.nFW = r.b(this, str2, true, 0, null);
        } else if (this.nFW != null && this.nFW.isShowing()) {
            this.nFW.dismiss();
            this.nFW = null;
        }
    }
}
