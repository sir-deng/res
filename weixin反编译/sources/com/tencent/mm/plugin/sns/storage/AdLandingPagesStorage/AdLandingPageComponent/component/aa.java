package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public final class aa extends a {
    private static final int rrI = Color.parseColor("#26eae9e2");
    private CountDownLatch lVE;
    private RadarChart rrJ;
    private Bitmap rrK;
    private Bitmap rrL;

    static /* synthetic */ void a(aa aaVar, Bitmap bitmap, Bitmap bitmap2) {
        y yVar = (y) aaVar.bxF();
        RadarChart radarChart = aaVar.rrJ;
        radarChart.roo = 0;
        radarChart.roq = null;
        radarChart.roh = null;
        radarChart.rof = null;
        aaVar.rrJ.rop = 5;
        c cVar = new c();
        cVar.rnK = 0;
        int parseColor = Color.parseColor(yVar.rnu);
        int i = 1442840575 & parseColor;
        parseColor &= Integer.MAX_VALUE;
        cVar.backgroundColor = i;
        cVar.rnP = rrI;
        cVar.rnT = 1.0f;
        cVar.roe = bitmap2;
        cVar.rnQ = rrI;
        cVar.rnR = rrI;
        cVar.rnS = (float) a.fromDPToPix(aaVar.context, 1);
        cVar.rnU = -1;
        cVar.rnW = 30.0f;
        cVar.rnV = 40.0f;
        cVar.roa = bitmap;
        cVar.rob = yVar.rnt;
        cVar.roc = Color.parseColor("#7feae9e2");
        cVar.rod = a.fromDPToPix(aaVar.context, 1);
        RadarChart radarChart2 = aaVar.rrJ;
        radarChart2.rog = cVar;
        if (radarChart2.roi != null) {
            RadarGrid radarGrid = radarChart2.roi;
            radarGrid.ros = cVar;
            radarGrid.invalidate();
        }
        b bVar = new b();
        bVar.rnE = rrI;
        bVar.rnF = 1.0f;
        bVar.rnG = parseColor;
        bVar.rnH = 127;
        bVar.rnI = Color.parseColor("#00fcff");
        bVar.rnJ = a.fromDPToPix(aaVar.context, 2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(yVar.rnv);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(yVar.rnx);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(yVar.rnw);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(yVar.rny);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a(bVar);
        StringBuilder stringBuilder = new StringBuilder();
        for (y.a aVar2 : yVar.qeK) {
            if (aVar2 != null) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(aVar2.label).append(":").append(aVar2.rnA);
                Spannable spannableString = new SpannableString(stringBuilder.toString());
                a(spannableString, 0, aVar2.label.length() + 1, foregroundColorSpan, absoluteSizeSpan);
                a(spannableString, aVar2.label.length() + 1, stringBuilder.length(), foregroundColorSpan2, absoluteSizeSpan2);
                aVar.put(spannableString, Float.valueOf(aVar2.value));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        try {
            aaVar.rrJ.a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[]) arrayList.toArray(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[arrayList.size()]));
        } catch (Throwable e) {
            Log.getStackTraceString(e);
        }
        aaVar.rrJ.ron = 2;
    }

    public aa(Context context, y yVar, ViewGroup viewGroup) {
        super(context, yVar, viewGroup);
    }

    public final View bxG() {
        this.rrJ = (RadarChart) this.contentView.findViewById(f.qHF);
        return this.contentView;
    }

    protected final void bxK() {
        this.lVE = new CountDownLatch(2);
        e.b(new Runnable() {
            public final void run() {
                try {
                    aa.this.lVE.await();
                } catch (InterruptedException e) {
                }
                aa.this.contentView.post(new Runnable() {
                    public final void run() {
                        aa.a(aa.this, aa.this.rrK, aa.this.rrL);
                    }
                });
            }
        }, "AdlandingRadarComp").start();
        y yVar = (y) bxF();
        if (yVar != null) {
            d.a(yVar.rns, yVar.rmO, new d.a() {
                public final void bxM() {
                }

                public final void bxN() {
                    aa.this.rrK = null;
                    aa.this.lVE.countDown();
                }

                public final void LD(String str) {
                    try {
                        aa.this.rrK = MMBitmapFactory.decodeFile(str);
                        aa.this.lVE.countDown();
                    } catch (Throwable e) {
                        x.e("AdlandingRadarChartComp", "%s" + bi.i(e));
                    }
                }
            });
            d.a(yVar.rnz, yVar.rmO, new d.a() {
                public final void bxM() {
                }

                public final void bxN() {
                    aa.this.rrL = null;
                    aa.this.lVE.countDown();
                }

                public final void LD(String str) {
                    try {
                        aa.this.rrL = MMBitmapFactory.decodeFile(str);
                        aa.this.lVE.countDown();
                    } catch (Throwable e) {
                        x.e("AdlandingRadarChartComp", "%s" + bi.i(e));
                    }
                }
            });
            return;
        }
        Log.wtf("AdlandingRadarChartComp", "null info");
    }

    protected final int bkr() {
        return g.qMM;
    }

    private static void a(Spannable spannable, int i, int i2, Object... objArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            spannable.setSpan(objArr[i3], i, i2, 18);
        }
    }
}
