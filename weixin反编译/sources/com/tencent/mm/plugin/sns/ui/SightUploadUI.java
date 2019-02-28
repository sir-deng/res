package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.bu.a;
import com.tencent.mm.f.a.pk;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SightUploadUI extends MMActivity {
    private String desc = "";
    DisplayMetrics pHh;
    private SnsEditText rCS;
    private z rCT = null;
    private LinearLayout rCU;
    private SnsSightUploadSayFooter rCV;
    private int rCW = 0;
    private int rCX = 0;
    private ArrayList<String> rCY;
    private boolean rCZ = false;
    private String rCy = "";
    private String rCz = "";
    private int rDa = 0;
    private boolean rDb = false;
    private long rDc = 0;

    public void onCreate(Bundle bundle) {
        e.h(this);
        super.onCreate(bundle);
        this.pHh = getResources().getDisplayMetrics();
        this.rCT = new al(this);
        this.rCT.F(bundle);
        this.rCU = (LinearLayout) findViewById(f.qMm);
        this.rCU.addView(this.rCT.bzU());
        setMMTitle(j.qSy);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(c.black));
        this.rDb = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.rDc = getIntent().getLongExtra("KTouchCameraTime", 0);
        initView();
        e.i(this);
    }

    protected final int getLayoutId() {
        return g.qNT;
    }

    protected final void initView() {
        this.rCS = (SnsEditText) findViewById(f.qKv);
        this.rCS.setTextSize(1, (ac.ev(this.mController.xRr) * this.rCS.getTextSize()) / a.getDensity(this.mController.xRr));
        final int paddingLeft = this.pHh.widthPixels - (this.rCS.getPaddingLeft() + this.rCU.getPaddingRight());
        this.rCS.postDelayed(new Runnable() {
            public final void run() {
                SightUploadUI.this.rCS.setWidth((int) (((double) paddingLeft) * 0.7d));
                SightUploadUI.this.rCU.setLayoutParams(new LayoutParams((int) (((double) paddingLeft) * 0.3d), SightUploadUI.this.rCU.getHeight()));
            }
        }, 100);
        if (!bi.oN(getIntent().getStringExtra("Kdescription"))) {
            this.rCS.setText(getIntent().getStringExtra("Kdescription"));
        }
        this.rCS.zCT = new MMEditText.a() {
            public final void aYi() {
                SightUploadUI.this.aWY();
                b pkVar = new pk();
                pkVar.fIc.type = 0;
                pkVar.fIc.fIe = false;
                com.tencent.mm.sdk.b.a.xmy.m(pkVar);
                SightUploadUI.this.finish();
            }
        };
        this.rCV = (SnsSightUploadSayFooter) findViewById(f.cIM);
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rCV;
        MMEditText mMEditText = this.rCS;
        snsSightUploadSayFooter.rMD = mMEditText;
        mMEditText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i = 0;
                if (SnsSightUploadSayFooter.this.getVisibility() == 8) {
                    SnsSightUploadSayFooter.this.setVisibility(0);
                }
                if (SnsSightUploadSayFooter.this.oqc.getVisibility() == 0) {
                    i = 1;
                }
                if (i != 0) {
                    SnsSightUploadSayFooter.this.hideSmileyPanel();
                }
            }
        });
        mMEditText.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        ah.h(new Runnable() {
            public final void run() {
                SnsSightUploadSayFooter.this.rMD.performClick();
                SnsSightUploadSayFooter.this.rMD.requestFocus();
                SnsSightUploadSayFooter.this.fnF.showVKB();
            }
        }, 200);
        this.rCV.setVisibility(0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                b pkVar = new pk();
                pkVar.fIc.type = 0;
                pkVar.fIc.fIe = false;
                com.tencent.mm.sdk.b.a.xmy.m(pkVar);
                SightUploadUI.this.aWY();
                SightUploadUI.this.finish();
                return true;
            }
        });
        if (getIntent().getBooleanExtra("KSightDraftEntrance", true)) {
            addIconOptionMenu(1, i.qOV, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    h.a(SightUploadUI.this.mController.xRr, null, new String[]{SightUploadUI.this.getString(j.qPT)}, null, new h.c() {
                        public final void jo(int i) {
                            switch (i) {
                                case 0:
                                    b pkVar = new pk();
                                    pkVar.fIc.type = 0;
                                    pkVar.fIc.fIg = true;
                                    pkVar.fIc.fIe = true;
                                    com.tencent.mm.sdk.b.a.xmy.m(pkVar);
                                    SightUploadUI.this.aWY();
                                    SightUploadUI.this.finish();
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return false;
                }
            });
        }
        a(0, getString(j.dGL), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!SightUploadUI.this.isFinishing()) {
                    SightUploadUI.this.desc = SightUploadUI.this.rCS.getText().toString();
                    final int i = SightUploadUI.this.rCS.rHB;
                    com.tencent.mm.ui.tools.a.c Hg = com.tencent.mm.ui.tools.a.c.d(SightUploadUI.this.rCS).Hg(com.tencent.mm.j.b.zH());
                    Hg.zwQ = true;
                    Hg.a(new com.tencent.mm.ui.tools.a.c.a() {
                        public final void vE(String str) {
                            PInt pInt = new PInt();
                            SightUploadUI.this.rCT.a(SightUploadUI.this.rDa, 0, null, SightUploadUI.this.desc, null, SightUploadUI.this.rCV.rMF.bAk(), i, SightUploadUI.this.rCZ, SightUploadUI.this.rCY, pInt, "", SightUploadUI.this.rCW, SightUploadUI.this.rCX);
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            Object[] objArr = new Object[4];
                            objArr[0] = Long.valueOf(SightUploadUI.this.rDc);
                            objArr[1] = Long.valueOf(bi.Wx());
                            objArr[2] = Integer.valueOf(SightUploadUI.this.rDb ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            gVar.h(13303, objArr);
                            String str2 = "MicroMsg.SightUploadUI";
                            String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                            objArr = new Object[4];
                            objArr[0] = Long.valueOf(SightUploadUI.this.rDc);
                            objArr[1] = Long.valueOf(bi.Wx());
                            objArr[2] = Integer.valueOf(SightUploadUI.this.rDb ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            x.d(str2, str3, objArr);
                        }

                        public final void anp() {
                        }

                        public final void aeD() {
                            h.h(SightUploadUI.this, j.qSK, j.qSL);
                        }
                    });
                }
                return false;
            }
        }, p.b.xSg);
        enableOptionMenu(true);
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.SightUploadUI", "onResume");
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rCV;
        if (snsSightUploadSayFooter.oqc.getVisibility() == 8) {
            snsSightUploadSayFooter.fnF.showVKB();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.rCT.bzV();
        this.rCV.rMF.stop();
        SnsSightUploadSayFooter snsSightUploadSayFooter = this.rCV;
        if (snsSightUploadSayFooter.oqc != null) {
            snsSightUploadSayFooter.oqc.tj();
            snsSightUploadSayFooter.oqc.destroy();
        }
    }

    protected void onPause() {
        super.onPause();
        aWY();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 6 || i == 5 || i == 10) {
                SnsSightUploadSayFooter snsSightUploadSayFooter = this.rCV;
                if (intent != null) {
                    if (i == 10) {
                        snsSightUploadSayFooter.rMF.U(intent);
                    } else if (i == 5) {
                        snsSightUploadSayFooter.rME.a(i, i2, intent, null);
                    }
                }
            }
            if (i == 5 && intent != null) {
                int intExtra = intent.getIntExtra("Ktag_range_index", 0);
                if (intExtra >= 2) {
                    this.rCy = intent.getStringExtra("Klabel_name_list");
                    this.rCz = intent.getStringExtra("Kother_user_name_list");
                    List<String> asList = Arrays.asList(this.rCy.split(","));
                    List list;
                    if (bi.oN(this.rCz)) {
                        list = null;
                    } else {
                        list = Arrays.asList(this.rCz.split(","));
                    }
                    this.rCY = new ArrayList();
                    if (asList != null && asList.size() > 0) {
                        for (String DU : asList) {
                            List<String> DX = com.tencent.mm.plugin.label.a.a.aVD().DX(com.tencent.mm.plugin.label.a.a.aVD().DU(DU));
                            if (DX == null || DX.size() == 0) {
                                x.e("MicroMsg.SightUploadUI", "dz: getContactNamesFromLabels,namelist get bu label is null");
                                break;
                            }
                            for (String DU2 : DX) {
                                if (!this.rCY.contains(DU2)) {
                                    this.rCY.add(DU2);
                                    x.d("MicroMsg.SightUploadUI", "dz:name : %s", DU2);
                                }
                            }
                        }
                    }
                    if (asList != null) {
                        int i3 = 0;
                        for (String DU22 : asList) {
                            int i4;
                            if (bi.oN(DU22)) {
                                i4 = i3;
                            } else {
                                i4 = i3 + 1;
                            }
                            i3 = i4;
                        }
                        this.rCW = i3;
                    }
                    this.rCX = 0;
                    if (list != null && list.size() > 0) {
                        for (String DU222 : list) {
                            if (!this.rCY.contains(DU222)) {
                                this.rCY.add(DU222);
                                this.rCX++;
                            }
                        }
                    }
                    if (intExtra == 2) {
                        this.rCZ = false;
                    } else {
                        this.rCZ = true;
                    }
                }
                if (1 == intExtra) {
                    this.rDa = 1;
                } else {
                    this.rDa = 0;
                }
            }
        }
    }
}
