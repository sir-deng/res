package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.ap.a.c.g;
import com.tencent.mm.ap.a.d.b;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.v.a.f;

@com.tencent.mm.ui.base.a(19)
public class GameGalleryUI extends MMActivity implements e {
    private String appId = "";
    private MMDotView kgN;
    private ViewPager lJI;
    private int mln = -1;
    private int nws = 0;

    private static class a extends u {
        Context mContext;
        private String[] nwt = new String[0];
        private View[] nwu;

        public a(Context context, String[] strArr) {
            this.mContext = context;
            if (strArr != null) {
                this.nwt = strArr;
            }
            this.nwu = new View[this.nwt.length];
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view = this.nwu[i];
            if (view == null) {
                View inflate = View.inflate(this.mContext, R.i.dkz, null);
                this.nwu[i] = inflate;
                ImageView imageView = (ImageView) inflate.findViewById(R.h.cmg);
                final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.h.cmi);
                progressBar.setVisibility(0);
                com.tencent.mm.ap.a.a PG = o.PG();
                String str = this.nwt[i];
                com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFk = true;
                PG.a(str, imageView, aVar.PQ(), new g() {
                    public final void lF(String str) {
                    }

                    public final Bitmap a(String str, b bVar) {
                        return null;
                    }

                    public final void a(String str, View view, b bVar) {
                        ah.y(new Runnable() {
                            public final void run() {
                                progressBar.setVisibility(8);
                            }
                        });
                    }
                });
                view = inflate;
            }
            viewGroup.addView(view);
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    ((MMActivity) a.this.mContext).finish();
                }
            });
            return view;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final int getCount() {
            return this.nwt.length;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.lJI = (ViewPager) findViewById(R.h.cmf);
        this.kgN = (MMDotView) findViewById(R.h.cmh);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("URLS");
        if (stringArrayExtra == null) {
            finish();
            return;
        }
        int intExtra = getIntent().getIntExtra("CURRENT", 0);
        if (intExtra < 0 || intExtra >= stringArrayExtra.length) {
            intExtra = 0;
        }
        this.appId = getIntent().getStringExtra("REPORT_APPID");
        this.mln = getIntent().getIntExtra("REPORT_SCENE", -1);
        this.nws = getIntent().getIntExtra("SOURCE_SCENE", 0);
        this.lJI.a(new a(this, stringArrayExtra));
        this.lJI.zo = this;
        this.lJI.d(intExtra, false);
        MMDotView mMDotView = this.kgN;
        mMDotView.yiD = f.bEy;
        mMDotView.yiE = f.gWG;
        this.kgN.Fa(stringArrayExtra.length);
        this.kgN.Fb(intExtra);
        if (intExtra == 0) {
            ap.a(this, this.mln, 1202, 1, 12, this.appId, this.nws, null);
        }
    }

    protected final int getLayoutId() {
        return R.i.cmf;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        this.kgN.Fb(i);
        ap.a(this, this.mln, 1202, i + 1, 12, this.appId, this.nws, null);
    }

    public final void af(int i) {
    }
}
