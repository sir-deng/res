package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.s;
import com.tencent.qbar.QbarNative;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyF2FQRCodeUI extends LuckyMoneyBaseUI implements com.tencent.mm.sdk.platformtools.aw.a {
    private View Lr;
    private SensorManager bgR;
    private DisplayMetrics ieH;
    private TextView ikL;
    private g jRi;
    private al jcp;
    private String lUI;
    private d lrG = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    if (LuckyMoneyF2FQRCodeUI.this.oeY > 0) {
                        LuckyMoneyF2FQRCodeUI.this.b(new com.tencent.mm.plugin.luckymoney.f2f.a.a(LuckyMoneyF2FQRCodeUI.this.oeH), false);
                        return;
                    } else {
                        h.bu(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.this.getString(i.uQv));
                        return;
                    }
                default:
                    return;
            }
        }
    };
    private Bitmap mBitmap;
    private String oeH;
    private String oeX;
    private int oeY;
    private long ofA;
    private String ofB;
    private ValueAnimator ofC;
    private float ofD;
    private float ofE;
    private float ofF;
    private int[] ofG;
    private com.tencent.mm.y.bt.a ofH = new com.tencent.mm.y.bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            Map y = bj.y(n.a(aVar.hoa.vNO), "sysmsg");
            if (y != null) {
                String str = (String) y.get(".sysmsg.sendId");
                final String str2 = (String) y.get(".sysmsg.username");
                final String str3 = (String) y.get(".sysmsg.amount");
                final String str4 = (String) y.get(".sysmsg.receiveId");
                if (bi.getInt((String) y.get(".sysmsg.islucky"), 0) > 0) {
                    LuckyMoneyF2FQRCodeUI.this.ofB = str2;
                }
                if (!bi.G(str, str2, str3)) {
                    LuckyMoneyF2FQRCodeUI.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            if (!LuckyMoneyF2FQRCodeUI.this.ofl.contains(str4)) {
                                LuckyMoneyF2FQRCodeUI.this.ofl.add(0, str4);
                                if (!s.gH(str2)) {
                                    com.tencent.mm.ac.h hVar = new com.tencent.mm.ac.h();
                                    hVar.username = str2;
                                    com.tencent.mm.ac.n.JW().a(hVar);
                                }
                                LuckyMoneyF2FQRCodeUI.this.ofm.put(str4, str2);
                                ShuffleView c = LuckyMoneyF2FQRCodeUI.this.oft;
                                if (c.ogr.size() > 0) {
                                    if (c.ogw.isStarted()) {
                                        c.ogw.end();
                                    }
                                    if (c.ogv.isStarted()) {
                                        c.ogv.end();
                                    }
                                    if (c.ogB != null) {
                                        c.ogz = c.ogB;
                                        c.ogr.remove(c.ogz);
                                        if (c.ogt != null) {
                                            c.ogt.start();
                                        }
                                        c.sr(c.ogC);
                                        if (c.ogF > 0) {
                                            c.ogC = c.aXE();
                                            c.ogB = (View) c.ogr.get(c.ogC);
                                        } else {
                                            c.ogB = null;
                                            c.ogC = 0;
                                        }
                                    } else {
                                        c.sp(c.aXE());
                                        c.ogz = c.ogB;
                                        c.ogw.addListener(new AnimatorListener() {
                                            public final void onAnimationStart(Animator animator) {
                                            }

                                            public final void onAnimationEnd(Animator animator) {
                                                ShuffleView.this.ogr.remove(ShuffleView.this.ogz);
                                                if (ShuffleView.this.ogt != null) {
                                                    ShuffleView.this.ogt.start();
                                                }
                                                ShuffleView.this.sr(ShuffleView.this.ogC);
                                                if (ShuffleView.this.ogF > 0) {
                                                    ShuffleView.this.ogC = ShuffleView.this.aXE();
                                                    ShuffleView.this.ogB = (View) ShuffleView.this.ogr.get(ShuffleView.this.ogC);
                                                    return;
                                                }
                                                ShuffleView.this.ogB = null;
                                                ShuffleView.this.ogC = 0;
                                            }

                                            public final void onAnimationCancel(Animator animator) {
                                            }

                                            public final void onAnimationRepeat(Animator animator) {
                                            }
                                        });
                                    }
                                }
                                LuckyMoneyF2FQRCodeUI.this.ofv.remove(LuckyMoneyF2FQRCodeUI.this.oft.ogz);
                                LuckyMoneyF2FQRCodeUI.this.jcp.K(0, 60000);
                                LuckyMoneyF2FQRCodeUI.this.ofn.add(new Pair(str2, Integer.valueOf(bi.getInt(str3, 0))));
                            }
                        }
                    });
                }
            }
        }
    };
    private c ofI = new c() {
        public final void a(com.tencent.mm.ui.base.n nVar) {
            nVar.eT(1, i.uQu);
        }
    };
    private Bitmap ofJ;
    private Bitmap ofK;
    private Bitmap ofL;
    private Bitmap ofM;
    private Bitmap ofN;
    private Bitmap ofO;
    private Bitmap ofP;
    private Bitmap ofQ;
    private Bitmap ofR;
    private Bitmap ofS;
    private Bitmap ofT;
    private Bitmap ofU;
    private b ofV = new b() {
        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            int nextInt = random.nextInt(100);
            if (nextInt < 16) {
                if (LuckyMoneyF2FQRCodeUI.this.ofM == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofM = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujt), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofM);
            } else if (nextInt < 33) {
                if (LuckyMoneyF2FQRCodeUI.this.ofN == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofN = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.uju), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofN);
            } else if (nextInt < 50) {
                if (LuckyMoneyF2FQRCodeUI.this.ofO == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofO = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujv), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofO);
            } else if (nextInt < 70) {
                if (LuckyMoneyF2FQRCodeUI.this.ofJ == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofJ = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujo), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofJ);
            } else if (nextInt < 90) {
                if (LuckyMoneyF2FQRCodeUI.this.ofK == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofK = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujp), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofK);
            } else {
                if (LuckyMoneyF2FQRCodeUI.this.ofL == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofL = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujq), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofL);
            }
        }
    };
    private b ofW = new b() {
        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            int nextInt = random.nextInt(100);
            if (nextInt < 10) {
                if (LuckyMoneyF2FQRCodeUI.this.ofS == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofS = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujt), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofS);
            } else if (nextInt < 20) {
                if (LuckyMoneyF2FQRCodeUI.this.ofT == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofT = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.uju), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofT);
            } else if (nextInt < 30) {
                if (LuckyMoneyF2FQRCodeUI.this.ofU == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofU = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujv), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofU);
            } else if (nextInt < 50) {
                if (LuckyMoneyF2FQRCodeUI.this.ofP == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujo), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofP);
            } else if (nextInt < 75) {
                if (LuckyMoneyF2FQRCodeUI.this.ofQ == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofQ = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujp), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofQ);
            } else {
                if (LuckyMoneyF2FQRCodeUI.this.ofR == null) {
                    LuckyMoneyF2FQRCodeUI.this.ofR = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(LuckyMoneyF2FQRCodeUI.this.getResources(), e.ujq), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ofR);
            }
        }
    };
    final SensorEventListener ofX = new SensorEventListener() {
        float kHQ;
        final int ogc = 3;
        float ogd = ((float) com.tencent.mm.bu.a.aa(ad.getContext(), com.tencent.mm.plugin.wxpay.a.d.bvC));
        int oge;
        ValueAnimator ogf;

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = -3.0f;
            if (sensorEvent.sensor.getType() == 1 && LuckyMoneyF2FQRCodeUI.this.oeY > 0) {
                if (this.oge == 0) {
                    this.oge = com.tencent.mm.pluginsdk.e.cj(LuckyMoneyF2FQRCodeUI.this) + ((int) this.ogd);
                }
                float f2 = sensorEvent.values[1];
                if (((double) Math.abs(f2 - this.kHQ)) >= 0.05d) {
                    this.kHQ = f2;
                    x.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", Float.valueOf(f2));
                    if (f2 >= -3.0f) {
                        if (f2 > 0.0f) {
                            f = 0.0f;
                        } else {
                            f = f2;
                        }
                    }
                    f = ((f / 3.0f) * ((float) this.oge)) + ((float) this.oge);
                    x.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", Float.valueOf(f), Integer.valueOf(LuckyMoneyF2FQRCodeUI.this.ofc.getPaddingTop()));
                    if (this.ogf != null) {
                        this.ogf.cancel();
                    }
                    this.ogf = ValueAnimator.ofFloat(new float[]{(float) LuckyMoneyF2FQRCodeUI.this.ofc.getPaddingTop(), f}).setDuration(200);
                    this.ogf.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            LuckyMoneyF2FQRCodeUI.this.ofc.setPadding(LuckyMoneyF2FQRCodeUI.this.ofc.getPaddingLeft(), (int) floatValue, LuckyMoneyF2FQRCodeUI.this.ofc.getPaddingRight(), LuckyMoneyF2FQRCodeUI.this.ofc.getPaddingBottom());
                            floatValue /= (float) AnonymousClass8.this.oge;
                            if (floatValue <= 1.0f) {
                                LuckyMoneyF2FQRCodeUI.this.ofi.setAlpha((1.0f - floatValue) + LuckyMoneyF2FQRCodeUI.this.ofF);
                                LuckyMoneyF2FQRCodeUI.this.ofj.setAlpha(floatValue * LuckyMoneyF2FQRCodeUI.this.ofF);
                                return;
                            }
                            LuckyMoneyF2FQRCodeUI.this.ofi.setAlpha(LuckyMoneyF2FQRCodeUI.this.ofF);
                            LuckyMoneyF2FQRCodeUI.this.ofj.setAlpha(LuckyMoneyF2FQRCodeUI.this.ofF);
                        }
                    });
                    this.ogf.start();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
            x.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
        }
    };
    private View ofc;
    private View ofd;
    private ImageView ofe;
    private TextView off;
    private TextView ofg;
    private ImageView ofh;
    private TextView ofi;
    private TextView ofj;
    private HorizontalListViewV2 ofk;
    private List<String> ofl;
    private Map<String, String> ofm;
    private Queue<Pair<String, Integer>> ofn;
    private a ofo;
    private TextView ofp;
    private Button ofq;
    private View ofr;
    private View ofs;
    private ShuffleView oft;
    private c ofu;
    private List<View> ofv;
    private ViewGroup ofw;
    private ViewGroup ofx;
    private View ofy;
    private com.tencent.mm.plugin.luckymoney.f2f.a ofz;

    private class a extends BaseAdapter {

        class a {
            ImageView ilM;
            ImageView ogh;

            a() {
            }
        }

        private a() {
        }

        /* synthetic */ a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return kF(i);
        }

        public final int getCount() {
            return LuckyMoneyF2FQRCodeUI.this.ofl.size();
        }

        private String kF(int i) {
            return (String) LuckyMoneyF2FQRCodeUI.this.ofl.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(LuckyMoneyF2FQRCodeUI.this).inflate(com.tencent.mm.plugin.wxpay.a.g.uIV, null);
                ImageView imageView = (ImageView) view.findViewById(f.uul);
                ImageView imageView2 = (ImageView) view.findViewById(f.uuf);
                a aVar2 = new a();
                aVar2.ilM = imageView;
                aVar2.ogh = imageView2;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            String str = (String) LuckyMoneyF2FQRCodeUI.this.ofm.get(kF(i));
            com.tencent.mm.plugin.luckymoney.b.n.a(aVar.ilM, null, str);
            if (bi.oN(LuckyMoneyF2FQRCodeUI.this.ofB) || !LuckyMoneyF2FQRCodeUI.this.ofB.equals(str)) {
                aVar.ogh.setVisibility(4);
            } else {
                aVar.ogh.setVisibility(0);
            }
            return view;
        }
    }

    static /* synthetic */ void G(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        luckyMoneyF2FQRCodeUI.ofe = (ImageView) luckyMoneyF2FQRCodeUI.ofd.findViewById(f.uvM);
        luckyMoneyF2FQRCodeUI.off = (TextView) luckyMoneyF2FQRCodeUI.ofd.findViewById(f.uvN);
        luckyMoneyF2FQRCodeUI.ofg = (TextView) luckyMoneyF2FQRCodeUI.ofd.findViewById(f.uvJ);
        Pair pair = (Pair) luckyMoneyF2FQRCodeUI.ofn.poll();
        if (pair != null) {
            com.tencent.mm.plugin.luckymoney.b.n.a(luckyMoneyF2FQRCodeUI.ofe, null, (String) pair.first);
            com.tencent.mm.plugin.luckymoney.b.n.a((Context) luckyMoneyF2FQRCodeUI, luckyMoneyF2FQRCodeUI.off, com.tencent.mm.plugin.luckymoney.b.n.gv((String) pair.first));
            luckyMoneyF2FQRCodeUI.ofg.setText(com.tencent.mm.wallet_core.ui.e.t(((double) ((Integer) pair.second).intValue()) / 100.0d));
            if (!bi.oN(luckyMoneyF2FQRCodeUI.ofB) && luckyMoneyF2FQRCodeUI.ofB.equals(pair.first)) {
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.ofw, luckyMoneyF2FQRCodeUI.ofV).y(800, 100);
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.ofx, luckyMoneyF2FQRCodeUI.ofW).y(800, 100);
                luckyMoneyF2FQRCodeUI.ofz.ey("most_lucky.m4a");
                if (((Integer) pair.second).intValue() >= 19000) {
                    luckyMoneyF2FQRCodeUI.ofz.ey("whistle.m4a");
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.ieH = getResources().getDisplayMetrics();
        this.ofl = new ArrayList();
        this.ofm = new HashMap();
        this.ofn = new LinkedList();
        this.ofv = new ArrayList();
        this.ofG = new int[6];
        int[] iArr = this.ofG;
        iArr[0] = iArr[0] + 1;
        this.jcp = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                LuckyMoneyF2FQRCodeUI.this.b(new com.tencent.mm.plugin.luckymoney.f2f.a.d(), false);
                return true;
            }
        }, true);
        this.ikL = (TextView) findViewById(f.cSB);
        this.Lr = findViewById(f.uum);
        this.ofc = findViewById(f.uHi);
        this.ofj = (TextView) findViewById(f.uui);
        this.ofi = (TextView) findViewById(f.uuj);
        this.ofF = this.ofj.getAlpha();
        this.ofh = (ImageView) this.Lr.findViewById(f.uuh);
        this.ofk = (HorizontalListViewV2) findViewById(f.uuk);
        this.ofo = new a();
        this.ofk.setAdapter(this.ofo);
        this.ofk.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyDetailUI.class);
                intent.putExtra("key_sendid", LuckyMoneyF2FQRCodeUI.this.oeH);
                LuckyMoneyF2FQRCodeUI.this.startActivity(intent);
            }
        });
        this.ofk.ygZ = new HorizontalListViewV2.d() {
            public final void sm(int i) {
                if (i == com.tencent.mm.ui.base.HorizontalListViewV2.d.a.yhj && LuckyMoneyF2FQRCodeUI.this.ofl.size() >= 5 && ((long) LuckyMoneyF2FQRCodeUI.this.ofl.size()) < LuckyMoneyF2FQRCodeUI.this.ofA && LuckyMoneyF2FQRCodeUI.this.ofk.getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.this.ofl.size() - 1 && !bi.oN(LuckyMoneyF2FQRCodeUI.this.oeH)) {
                    LuckyMoneyF2FQRCodeUI.this.l(new v(LuckyMoneyF2FQRCodeUI.this.oeH, 5, LuckyMoneyF2FQRCodeUI.this.ofl.size(), null, "v1.0"));
                }
            }
        };
        this.ofq = (Button) findViewById(f.uug);
        this.ofq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyPrepareUI.class);
                intent.putExtra("key_from", 2);
                LuckyMoneyF2FQRCodeUI.this.startActivity(intent);
            }
        });
        this.ofp = (TextView) findViewById(f.uuo);
        this.ofd = findViewById(f.uun);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LuckyMoneyF2FQRCodeUI.this.finish();
                return true;
            }
        });
        setMMTitle(getString(i.uQF));
        this.ofr = findViewById(f.bLU);
        this.ofr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyF2FQRCodeUI.this.finish();
            }
        });
        this.ofs = findViewById(f.uyf);
        this.ofs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                LuckyMoneyF2FQRCodeUI.this.jRi = new g(LuckyMoneyF2FQRCodeUI.this, g.zCt, false);
                LuckyMoneyF2FQRCodeUI.this.jRi.rQF = LuckyMoneyF2FQRCodeUI.this.ofI;
                LuckyMoneyF2FQRCodeUI.this.jRi.rQG = LuckyMoneyF2FQRCodeUI.this.lrG;
                LuckyMoneyF2FQRCodeUI.this.jRi.bUX();
            }
        });
        this.ikL.setText(i.uQF);
        this.ofw = (ViewGroup) findViewById(f.uuc);
        this.ofx = (ViewGroup) findViewById(f.uub);
        this.ofy = findViewById(f.uue);
        this.ofy.setAlpha(0.0f);
        this.bgR = (SensorManager) getSystemService("sensor");
        this.bgR.registerListener(this.ofX, this.bgR.getDefaultSensor(1), 3);
        this.ofz = new com.tencent.mm.plugin.luckymoney.f2f.a();
        this.oft = (ShuffleView) findViewById(f.uup);
        this.ofu = new c();
        this.ofu.ogW = 4;
        this.ofu.ogU = 2;
        this.ofu.ogV = 4;
        this.ofu.ogZ = 300;
        this.ofu.ogY = 0.0f;
        ShuffleView shuffleView = this.oft;
        c cVar = this.ofu;
        shuffleView.ogs = cVar;
        shuffleView.ogv = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.ogZ);
        shuffleView.ogw = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.oha);
        ShuffleView.ieH = this.ieH;
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        ShuffleView shuffleView2 = this.oft;
        if (shuffleView2.ogt != null) {
            shuffleView2.ogt.removeAllListeners();
            shuffleView2.ogt.cancel();
        }
        shuffleView2.ogt = duration;
        if (shuffleView2.ogt != null) {
            shuffleView2.ogt.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (ShuffleView.this.ogx != null) {
                        ShuffleView.this.ogx.a(valueAnimator, ShuffleView.this.ogz);
                    }
                }
            });
        }
        this.oft.ogx = new a() {
            public final void a(ValueAnimator valueAnimator, View view) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue == 0.0f) {
                    LuckyMoneyF2FQRCodeUI.this.ofD = view.getTranslationX();
                    LuckyMoneyF2FQRCodeUI.this.ofE = view.getTranslationY();
                    view.findViewById(f.uuq).setVisibility(0);
                }
                view.setTranslationX((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.this.ofD);
                view.setTranslationY(((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.this.ofE) - ((((float) LuckyMoneyF2FQRCodeUI.this.oft.getHeight()) + (LuckyMoneyF2FQRCodeUI.this.ofE * 8.0f)) * floatValue));
                view.setScaleX((0.5f * floatValue) + 1.0f);
                view.setScaleY((0.5f * floatValue) + 1.0f);
                Pair pair = (Pair) LuckyMoneyF2FQRCodeUI.this.ofn.peek();
                if (!(pair == null || bi.oN(LuckyMoneyF2FQRCodeUI.this.ofB) || !LuckyMoneyF2FQRCodeUI.this.ofB.equals(pair.first))) {
                    LuckyMoneyF2FQRCodeUI.this.ofy.setAlpha(floatValue);
                }
                x.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", Float.valueOf(floatValue));
                if (floatValue >= 0.9f) {
                    view.setAlpha((1.0f - floatValue) * 10.0f);
                    LuckyMoneyF2FQRCodeUI.this.ofd.setAlpha(1.0f - ((1.0f - floatValue) * 10.0f));
                    LuckyMoneyF2FQRCodeUI.this.ofd.setScaleX(floatValue);
                    LuckyMoneyF2FQRCodeUI.this.ofd.setScaleY(floatValue);
                    LuckyMoneyF2FQRCodeUI.this.ofd.setVisibility(0);
                }
                if (floatValue == 1.0f) {
                    LuckyMoneyF2FQRCodeUI.this.ofz.ey("packet_received.m4a");
                    LuckyMoneyF2FQRCodeUI.this.oft.removeView(LuckyMoneyF2FQRCodeUI.this.oft.ogz);
                    LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this);
                    LuckyMoneyF2FQRCodeUI.this.ofC.start();
                }
            }
        };
        this.oft.ogy = new b() {
            public final void cN(int i, int i2) {
                int[] I;
                if (i2 == 8) {
                    LuckyMoneyF2FQRCodeUI.this.ofz.ey("music" + (i + 1) + ".m4a");
                    I = LuckyMoneyF2FQRCodeUI.this.ofG;
                    I[4] = I[4] + 1;
                    return;
                }
                LuckyMoneyF2FQRCodeUI.this.ofz.ey("touch_card.m4a");
                I = LuckyMoneyF2FQRCodeUI.this.ofG;
                I[2] = I[2] + 1;
            }

            public final void sl(int i) {
                LuckyMoneyF2FQRCodeUI.this.aXz();
                int[] I;
                if (i != 8) {
                    LuckyMoneyF2FQRCodeUI.this.ofz.ey("select_card.m4a");
                    I = LuckyMoneyF2FQRCodeUI.this.ofG;
                    I[3] = I[3] + 1;
                    return;
                }
                I = LuckyMoneyF2FQRCodeUI.this.ofG;
                I[5] = I[5] + 1;
            }

            public final void cO(int i, int i2) {
                if (i2 == 8) {
                    LuckyMoneyF2FQRCodeUI.this.ofz.ey("music" + (i + 1) + ".m4a");
                } else {
                    LuckyMoneyF2FQRCodeUI.this.ofz.ey("select_card.m4a");
                }
            }
        };
        aXA();
        this.ofC = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.ofC.setDuration(300);
        this.ofC.setStartDelay(3000);
        this.ofC.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LuckyMoneyF2FQRCodeUI.this.ofd.setTranslationY((-0.5f * floatValue) * ((float) LuckyMoneyF2FQRCodeUI.this.ieH.heightPixels));
                LuckyMoneyF2FQRCodeUI.this.ofy.setAlpha(1.0f - floatValue);
                if (floatValue == 1.0f) {
                    LuckyMoneyF2FQRCodeUI.this.ofd.setVisibility(8);
                    LuckyMoneyF2FQRCodeUI.this.ofd.setTranslationY(0.0f);
                    LuckyMoneyF2FQRCodeUI.this.aXB();
                    LuckyMoneyF2FQRCodeUI.this.ofo.notifyDataSetChanged();
                    LuckyMoneyF2FQRCodeUI.this.ofk.EL(0);
                }
            }
        });
        aXz();
        getWindow().addFlags(FileUtils.S_IWUSR);
    }

    private void aXz() {
        if (!bi.oN(this.lUI)) {
            Bitmap bitmap;
            byte[] bArr = new byte[40000];
            int[] iArr = new int[2];
            int a = QbarNative.a(bArr, iArr, this.lUI, 0, 1, "UTF-8");
            QbarNative.nativeRelease();
            if (a > 0) {
                int i;
                int i2;
                int i3;
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                if (i4 >= i5) {
                    i4 = i5;
                }
                int i6 = (int) (((double) iArr[0]) * 0.1d);
                i4 = ((int) (((double) i4) * 0.8d)) / (iArr[0] + (i6 * 2));
                if (i4 == 0) {
                    i = 1;
                } else {
                    i = i4;
                }
                int i7 = i6 * i;
                i5 = i * (iArr[0] + (i6 * 2));
                int i8 = (iArr[1] * i) + ((i * 2) * i6);
                Bitmap createBitmap = Bitmap.createBitmap(i5, i8, Config.ARGB_8888);
                int[] iArr2 = new int[(i5 * i8)];
                int i9 = (i * 2) + (i / 2);
                int i10 = (i * 3) + (i / 2);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                Arrays.fill(iArr2, -1);
                int[] iArr3 = new int[]{(i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[0] - 1) - 3) * i) + (i / 2), (i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[1] - 1) - 3) * i) + (i / 2)};
                i4 = 0;
                while (i4 < iArr[1]) {
                    int i11 = 0;
                    while (i11 < iArr[0]) {
                        if (bArr[(iArr[0] * i4) + i11] == (byte) 1) {
                            int i12;
                            if ((i4 < 0 || i4 > 6 || i11 < 0 || i11 > 6) && ((i4 < 0 || i4 > 6 || i11 < iArr[0] - 7 || i11 > iArr[0] - 1) && (i4 < iArr[1] - 7 || i4 > iArr[1] - 1 || i11 < 0 || i11 > 6))) {
                                boolean[] zArr = new boolean[10];
                                zArr[5] = true;
                                if (zArr[(int) (Math.random() * 10.0d)]) {
                                    for (i2 = 0; i2 < i; i2++) {
                                        for (i12 = 0; i12 < i; i12++) {
                                            iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -3041484;
                                        }
                                    }
                                } else {
                                    for (i2 = 0; i2 < i; i2++) {
                                        for (i12 = 0; i12 < i; i12++) {
                                            iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -2598591;
                                        }
                                    }
                                }
                            } else {
                                for (i2 = 0; i2 < i; i2++) {
                                    for (i12 = 0; i12 < i; i12++) {
                                        iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -1;
                                    }
                                }
                            }
                        }
                        i11++;
                    }
                    i4++;
                }
                createBitmap.setPixels(iArr2, 0, i5, 0, 0, i5, i8);
                for (i3 = 0; i3 < 3; i3++) {
                    paint.setColor(-2598591);
                    paint.setStyle(Style.FILL);
                    canvas = canvas;
                    canvas.drawCircle((float) ((i * i6) + iArr3[i3 * 2]), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) i10, paint);
                    paint.setColor(-1);
                    canvas = canvas;
                    canvas.drawCircle((float) ((i * i6) + iArr3[i3 * 2]), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) i9, paint);
                }
                i3 = 0;
                while (true) {
                    i2 = i3;
                    if (i2 >= 3) {
                        break;
                    }
                    paint.setColor(-3041484);
                    paint.setStyle(Style.FILL);
                    Canvas canvas2 = canvas;
                    canvas2.drawRect((float) ((((i * i6) + iArr3[i2 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i2 * 2) + 1]) - i) - ((i * 1) / 4)), (float) (((i * 1) / 4) + (((i * i6) + iArr3[i2 * 2]) + i)), (float) (((i * 1) / 4) + (((i * i6) + iArr3[(i2 * 2) + 1]) + i)), paint);
                    i3 = i2 + 1;
                }
                for (i3 = 0; i3 < 3; i3++) {
                    paint.setColor(-1);
                    paint.setStyle(Style.FILL_AND_STROKE);
                    Path path = new Path();
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.quadTo((float) ((i * i6) + iArr3[i3 * 2]), (float) (((i * i6) + iArr3[(i3 * 2) + 1]) - i), (float) ((((i * i6) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.quadTo((float) (((i * i6) + iArr3[i3 * 2]) - i), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) ((((i * i6) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.quadTo((float) ((i * i6) + iArr3[i3 * 2]), (float) (((i * i6) + iArr3[(i3 * 2) + 1]) + i), (float) ((((i * i6) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.quadTo((float) (((i * i6) + iArr3[i3 * 2]) + i), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) ((((i * i6) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                }
                if (createBitmap == null) {
                    x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", Integer.valueOf(a), bi.chl().toString());
                } else {
                    x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", createBitmap);
                }
                bitmap = createBitmap;
            } else {
                x.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", Integer.valueOf(a), bi.chl().toString());
                bitmap = null;
            }
            this.mBitmap = bitmap;
            this.ofh.setImageBitmap(this.mBitmap);
        }
        if (this.oeY <= 0) {
            this.ofh.setPadding(com.tencent.mm.bu.a.fromDPToPix(this, 5), com.tencent.mm.bu.a.fromDPToPix(this, 5), com.tencent.mm.bu.a.fromDPToPix(this, 5), com.tencent.mm.bu.a.fromDPToPix(this, 5));
            this.ofh.setImageResource(e.ujn);
            this.ofp.setVisibility(8);
            this.ofq.setVisibility(0);
            this.ofi.setVisibility(4);
            this.ofc.setPadding(this.ofc.getPaddingLeft(), com.tencent.mm.pluginsdk.e.cj(this), this.ofc.getPaddingRight(), this.ofc.getPaddingBottom());
            if (this.ofl.size() > 0) {
                this.ofj.setText(getString(i.uQy));
                return;
            } else {
                this.ofj.setText(getString(i.uQz));
                return;
            }
        }
        this.ofh.setPadding(0, 0, 0, 0);
        this.ofi.setText(getString(i.uQD));
        this.ofi.setVisibility(0);
        this.ofj.setText(getString(i.uQD));
        this.ofp.setText(getString(i.uQC, new Object[]{Integer.valueOf(this.oeY)}));
        this.ofp.setVisibility(0);
        this.ofq.setVisibility(8);
    }

    private void aXA() {
        Set hashSet = new HashSet();
        hashSet.add("touch_card.m4a");
        hashSet.add("select_card.m4a");
        for (int i = 1; i <= 8; i++) {
            hashSet.add("music" + i + ".m4a");
        }
        hashSet.add("packet_received.m4a");
        hashSet.add("most_lucky.m4a");
        hashSet.add("whistle.m4a");
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.ofz;
        com.tencent.mm.kernel.g.Dt().F(new com.tencent.mm.plugin.luckymoney.f2f.a.AnonymousClass1(hashSet, new WeakReference(this)));
        aVar.oex.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                if (i2 == 0) {
                    a.this.oez.put(Integer.valueOf(i), Boolean.valueOf(true));
                } else {
                    a.this.oez.put(Integer.valueOf(i), Boolean.valueOf(false));
                }
            }
        });
    }

    private void aXB() {
        int width = this.ofk.getWidth() - (this.ofl.size() * getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.buq));
        if (width > 0) {
            this.ofk.setPadding(width / 2, 0, width / 2, 0);
        } else {
            this.ofk.setPadding(0, 0, 0, 0);
        }
    }

    private void aXC() {
        if (this.ofv.size() != this.oeY) {
            int i;
            x.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", Integer.valueOf(this.ofv.size()), Integer.valueOf(this.oeY));
            this.ofv.clear();
            for (i = 0; i < this.oeY; i++) {
                View inflate = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uIS, this.oft, false);
                ((LayoutParams) inflate.getLayoutParams()).gravity = 81;
                this.ofv.add(inflate);
            }
            ShuffleView shuffleView = this.oft;
            Collection collection = this.ofv;
            shuffleView.ogr.clear();
            shuffleView.ogr.addAll(collection);
            shuffleView.ogC = 0;
            shuffleView.ogB = null;
            shuffleView.ogE = -1;
            shuffleView.ogD = null;
            shuffleView.removeAllViews();
            List list = shuffleView.ogr;
            if (list.size() > 100) {
                shuffleView.ogF = 100;
            } else {
                shuffleView.ogF = list.size();
                if (shuffleView.ogF == 1) {
                    ((View) list.get(0)).findViewById(f.uuq).setVisibility(0);
                }
            }
            for (i = shuffleView.ogF - 1; i >= 0; i--) {
                shuffleView.addView((View) list.get(i));
            }
            shuffleView.addOnLayoutChangeListener(new OnLayoutChangeListener() {
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    ShuffleView.this.aXD();
                    ShuffleView shuffleView = ShuffleView.this;
                    int i9 = 0;
                    while (true) {
                        int i10 = i9;
                        if (i10 < shuffleView.ogF) {
                            shuffleView.y((View) shuffleView.ogr.get(i10), i10);
                            i9 = i10 + 1;
                        } else {
                            ShuffleView.this.removeOnLayoutChangeListener(this);
                            return;
                        }
                    }
                }
            });
        }
    }

    protected void onResume() {
        super.onResume();
        b(new com.tencent.mm.plugin.luckymoney.f2f.a.d(), true);
        this.jcp.K(60000, 60000);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.ofH, true);
        jl(1642);
        jl(1990);
        jl(1987);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        aw.a(this);
        if (this.bgR != null) {
            this.bgR.registerListener(this.ofX, this.bgR.getDefaultSensor(1), 3);
        }
    }

    protected void onStop() {
        super.onStop();
        this.jcp.TN();
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.ofH, true);
        jm(1990);
        jm(1642);
        jm(1987);
        aw.a(null);
    }

    protected void onPause() {
        super.onPause();
        if (this.bgR != null) {
            this.bgR.unregisterListener(this.ofX);
        }
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.report.service.g.pWK.h(14007, Integer.valueOf(this.ofG[0]), Integer.valueOf(this.ofG[1]), Integer.valueOf(this.ofG[2]), Integer.valueOf(this.ofG[3]), Integer.valueOf(this.ofG[4]), Integer.valueOf(this.ofG[5]));
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.ofz;
        aVar.kuZ = true;
        aVar.oex.release();
        getWindow().clearFlags(FileUtils.S_IWUSR);
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uIT;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        x.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d) {
                x.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.oeH);
                if (!(bi.G(this.oeH, ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).oeH) || this.oeH.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).oeH))) {
                    this.ofl.clear();
                    this.ofm.clear();
                    this.ofn.clear();
                    this.ofo.notifyDataSetChanged();
                    this.ofB = "";
                }
                if (!bi.oN(((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).oeH)) {
                    this.oeH = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).oeH;
                }
                this.lUI = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).lUI;
                this.oeY = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).oeY;
                this.oeX = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).oeX;
                aXz();
                aXC();
                if (this.oeY == 0) {
                    this.jcp.TN();
                }
                if (this.ofl.size() == 0 && !bi.oN(this.oeH)) {
                    b(new v(this.oeH, 5, 0, null, "v1.0"), false);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a) {
                this.oeH = "";
                this.lUI = "";
                this.oeY = 0;
                this.ofl.clear();
                this.ofB = "";
                this.ofo.notifyDataSetChanged();
                aXz();
                aXC();
                this.jcp.TN();
                if (!bi.oN(this.oeX)) {
                    h.bu(this, this.oeX);
                }
            } else if (kVar instanceof v) {
                this.ofA = ((v) kVar).oiv.ohy;
                List list = ((v) kVar).oiv.ohN;
                if (list != null && list.size() > 0) {
                    while (i3 < list.size()) {
                        m mVar = (m) list.get(i3);
                        if (!(bi.oN(mVar.ohB) || this.ofl.contains(mVar.ohB))) {
                            this.ofl.add(mVar.ohB);
                            String je = com.tencent.mm.ac.n.JY().je(mVar.oij);
                            if (!bi.oN(mVar.oil)) {
                                this.ofB = je;
                            }
                            this.ofm.put(mVar.ohB, je);
                        }
                        i3++;
                    }
                    aXB();
                    this.ofo.notifyDataSetChanged();
                }
            }
        } else if (!bi.oN(str)) {
            h.b(this, str, getString(i.dGZ), true);
        }
        return true;
    }

    public final void amn() {
        x.i("LuckyMoneyF2FQRCodeUI", "screenShot");
        if (this.oeY > 0) {
            aXz();
            int[] iArr = this.ofG;
            iArr[1] = iArr[1] + 1;
            h.b(this, getString(i.uQE), null, true);
        }
    }
}
