package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.q;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.appusage.e;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.j.d;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

public final class AppBrandLauncherUI extends DrawStatusBarActivity {
    static final int jQu = n.iuA;
    private static final int jQv = g.iwK;
    private int jCE;
    private final com.tencent.mm.plugin.appbrand.appusage.i.b jQA = new com.tencent.mm.plugin.appbrand.appusage.i.b() {
        public final void abj() {
            i.b(this);
            if (!i.abh()) {
                AppBrandLauncherUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        if (!AppBrandLauncherUI.this.isFinishing() && !AppBrandLauncherUI.this.xQV) {
                            AppBrandLauncherUI.this.dj(true);
                        }
                    }
                });
            }
        }
    };
    public d jQB;
    private String jQw;
    private boolean jQx = false;
    private int jQy;
    private boolean jQz = true;

    public static abstract class a extends Fragment {
        public View Iv;
        public int itU;
        private final ag jQE = new ag(Looper.getMainLooper());
        public String jQF;

        public abstract void initView();

        public void alk() {
        }

        public void all() {
        }

        public void lO(int i) {
            this.itU = i;
        }

        public final int lP(int i) {
            Context activity = getActivity();
            if (activity == null) {
                activity = ad.getContext();
            }
            return com.tencent.mm.bu.a.fromDPToPix(activity, i);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.Iv = new FrameLayout(viewGroup.getContext());
            initView();
            return this.Iv;
        }

        public final void s(Runnable runnable) {
            if (runnable != null) {
                this.jQE.post(runnable);
            }
        }

        public final void runOnUiThread(Runnable runnable) {
            if (getActivity() != null) {
                getActivity().runOnUiThread(runnable);
            }
        }
    }

    private enum b {
        ;

        static {
            jQG = 1;
            jQH = 2;
            jQI = new int[]{jQG, jQH};
        }
    }

    public static abstract class c<T> extends com.tencent.mm.plugin.appbrand.r.j.a {
        public final List<T> jQJ;
        public final List<T> jQK;

        public c(List<T> list, List<T> list2) {
            this.jQJ = list;
            this.jQK = list2;
        }

        public final int alm() {
            return this.jQJ == null ? 0 : this.jQJ.size();
        }

        public final int aln() {
            return this.jQK == null ? 0 : this.jQK.size();
        }
    }

    public final void dj(boolean z) {
        Class cls = z ? com.tencent.mm.plugin.appbrand.ui.recents.a.class : c.class;
        Fragment N = super.getSupportFragmentManager().N(jQv);
        if ((N == null || !cls.isInstance(N)) && !isFinishing() && !this.xQV) {
            Fragment aVar;
            q aT = super.getSupportFragmentManager().aT();
            if (z) {
                aVar = new com.tencent.mm.plugin.appbrand.ui.recents.a();
            } else {
                aVar = c.bI(getString(j.dEe), getString(j.iCt));
            }
            aVar.lO(this.jCE);
            aVar.jQF = this.jQw;
            aT.b(jQv, aVar);
            aT.commit();
            if (z && this.jQB != null) {
                this.jQB.iMM[4] = "1";
            }
        }
    }

    protected final int getStatusBarColor() {
        if (VERSION.SDK_INT >= 23 && j.b(getWindow())) {
            return -1052684;
        }
        if (VERSION.SDK_INT >= 21) {
            return jQu;
        }
        return super.getStatusBarColor();
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        getWindow().setSoftInputMode(3);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
        } else if (com.tencent.mm.plugin.appbrand.appusage.b.aaR()) {
            overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.xSL, com.tencent.mm.ui.MMFragmentActivity.a.xSM);
            this.jQx = true;
            this.jCE = getIntent().getIntExtra("extra_enter_scene", 1);
            this.jQw = getIntent().getStringExtra("extra_enter_scene_note");
            if (getSupportActionBar() != null) {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(-1052684));
            }
            setTitleBarDoubleClickListener(new Runnable() {
                public final void run() {
                    if (!AppBrandLauncherUI.this.xQV && !AppBrandLauncherUI.this.isFinishing()) {
                        Fragment N = super.getSupportFragmentManager().N(AppBrandLauncherUI.jQv);
                        if (N != null && (N instanceof a)) {
                            ((a) N).alk();
                        }
                    }
                }
            });
            setMMTitle(getResources().getString(j.dEe));
            oj(WebView.NIGHT_MODE_COLOR);
            k.a(this);
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppBrandLauncherUI.this.onBackPressed();
                    return true;
                }
            }, f.ivE);
            if (com.tencent.mm.plugin.appbrand.m.a.akL()) {
                int i = b.jQG - 1;
                int i2 = j.eRz;
                Drawable c = com.tencent.mm.svg.a.a.c(ad.getResources(), com.tencent.mm.plugin.appbrand.q.i.dvm);
                if (c == null) {
                    c = null;
                } else {
                    c = c.mutate();
                    c.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
                }
                this.mController.a(i, getString(i2), c, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppBrandLauncherUI.this.startActivityForResult(((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.compat.a.a.class)).bK(AppBrandLauncherUI.this), 1);
                        return true;
                    }
                });
            }
            this.mController.contentView.setBackgroundColor(-1052684);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            View frameLayout = new FrameLayout(this);
            frameLayout.setId(jQv);
            ((ViewGroup) this.mController.contentView).addView(frameLayout, layoutParams);
            com.tencent.mm.plugin.report.service.g.pWK.a(465, 0, 1, false);
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(intent);
            if (com.tencent.mm.plugin.appbrand.appusage.j.abm()) {
                this.jQB = new d();
            }
            com.tencent.mm.plugin.appbrand.appusage.j.abo();
            com.tencent.mm.plugin.appbrand.appusage.b.aaS();
            com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getStatusBarColor(), true);
        } else {
            finish();
        }
    }

    protected final void onResume() {
        boolean z;
        super.onResume();
        getStatusBarColor();
        if (!this.jQx) {
            if (this.jQy == 1) {
                this.jCE = 7;
            } else if (this.jQy == 2) {
                this.jCE = 6;
            } else if (this.jQy == 3) {
                this.jCE = 9;
            } else if (this.jQy == 4) {
                this.jCE = 12;
            } else {
                this.jCE = 4;
            }
            this.jQw = "";
            this.jQy = 0;
            a aVar = (a) super.getSupportFragmentManager().N(jQv);
            if (aVar != null) {
                aVar.lO(this.jCE);
            }
        }
        this.jQx = false;
        if (com.tencent.mm.plugin.appbrand.appusage.b.aaU() || com.tencent.mm.plugin.appbrand.appusage.b.aaV()) {
            z = true;
        } else {
            z = false;
        }
        dj(z);
        if (!z && this.jQz) {
            i.a(this.jQA);
            if (!i.refresh()) {
                i.b(this.jQA);
            }
        }
        this.jQz = false;
    }

    protected final void onPause() {
        super.onPause();
    }

    protected final void onDestroy() {
        a aVar = (a) super.getSupportFragmentManager().N(jQv);
        if (aVar != null) {
            aVar.all();
        }
        super.onDestroy();
        i.b(this.jQA);
        i.abi();
        e.release();
        if (this.jQB != null) {
            com.tencent.mm.plugin.report.service.g.pWK.h(14113, (Object[]) this.jQB.iMM);
            this.jQB = null;
        }
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.jQy = i;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("key_session_id");
            int intExtra = intent.getIntExtra("ftsbizscene", 0);
            x.i("MicroMsg.AppBrandLauncherUI", "onActivityResult oreh report weAppSearchClickStream(13929) statSessionId:%s, StatKeyWordId:%s", stringExtra, com.tencent.mm.modelappbrand.b.hli);
            com.tencent.mm.plugin.report.service.g.pWK.h(13929, stringExtra, com.tencent.mm.modelappbrand.b.hli, Integer.valueOf(2), Integer.valueOf(intExtra));
        }
    }

    public final void setTitle(CharSequence charSequence) {
        P(charSequence);
    }

    public final void setTitle(int i) {
        setMMTitle(i);
    }

    public final void onBackPressed() {
        finish();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
