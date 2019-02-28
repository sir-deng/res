package com.tencent.mm.plugin.sns.ui;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.aq.b;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.f.a.qn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(17)
public class SnsUploadUI extends MMActivity implements LocationWidget.a {
    private String desc;
    private SnsAdClick fFZ = null;
    private boolean rAC = false;
    private SnsEditText rCS;
    private z rCT = null;
    private LinearLayout rCU;
    private int rCW = 0;
    private int rCX = 0;
    private ArrayList<String> rCY;
    private boolean rCZ = false;
    private String rCy = "";
    private String rCz = "";
    private boolean rDb = false;
    private long rDc = 0;
    private AtContactWidget rRK;
    private LocationWidget rRL;
    private RangeWidget rRM;
    private SnsUploadSayFooter rRN;
    private KeyboardLinearLayout rRO;
    private boolean rRP = false;
    private boolean rRQ = false;
    private String rRR = null;
    private FrameLayout rRS = null;
    private long rRT = 0;
    private SnsUploadConfigView rxp;
    private int rzP = 0;

    static /* synthetic */ boolean b(SnsUploadUI snsUploadUI) {
        snsUploadUI.aWY();
        if (!snsUploadUI.rRN.bCO()) {
            return false;
        }
        snsUploadUI.rRN.bCP();
        return true;
    }

    static /* synthetic */ void i(SnsUploadUI snsUploadUI) {
        snsUploadUI.rCS.requestFocus();
        x.d("MicroMsg.SnsUploadUI", "request fouces");
        if (snsUploadUI.rRN.bCO()) {
            snsUploadUI.rRN.bCP();
        }
        snsUploadUI.mController.contentView.postInvalidate();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.rCS != null) {
            bundle.putString("contentdesc", this.rCS.getText().toString());
        }
        bundle.getString("contentdesc");
        this.rCT.G(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void onCreate(Bundle bundle) {
        View a;
        boolean z = true;
        e.h(this);
        super.onCreate(bundle);
        setMMTitle("");
        getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        this.rDb = getIntent().getBooleanExtra("KSnsPostManu", false);
        this.rDc = getIntent().getLongExtra("KTouchCameraTime", 0);
        this.rzP = getIntent().getIntExtra("Ksnsupload_type", 0);
        this.fFZ = (SnsAdClick) getIntent().getParcelableExtra("KsnsAdTag");
        this.rAC = getIntent().getBooleanExtra("Kis_take_photo", false);
        this.rRP = getIntent().getBooleanExtra("need_result", false);
        this.rRQ = getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false);
        this.rRR = getIntent().getStringExtra("Ksnsupload_canvas_info");
        this.rCS = (SnsEditText) findViewById(f.qKv);
        this.rCS.setTextSize(1, (ac.ev(this.mController.xRr) * this.rCS.getTextSize()) / com.tencent.mm.bu.a.getDensity(this.mController.xRr));
        if (!bi.oN(getIntent().getStringExtra("Kdescription"))) {
            this.rCS.setText(getIntent().getStringExtra("Kdescription"));
        } else if (!(this.rCS == null || bundle == null)) {
            CharSequence string = bundle.getString("contentdesc");
            if (string != null) {
                this.rCS.setText(string);
            }
        }
        if (this.rzP == 8) {
            this.rCS.setText(getIntent().getStringExtra("Kdescription"));
            this.rCS.setEnabled(false);
        }
        this.rRO = (KeyboardLinearLayout) findViewById(f.cIB);
        this.rRN = (SnsUploadSayFooter) findViewById(f.cIM);
        SnsUploadSayFooter snsUploadSayFooter = this.rRN;
        MMEditText mMEditText = this.rCS;
        snsUploadSayFooter.rMD = mMEditText;
        mMEditText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SnsUploadSayFooter.this.getVisibility() == 8) {
                    SnsUploadSayFooter.this.setVisibility(0);
                }
                if (SnsUploadSayFooter.this.bCO()) {
                    SnsUploadSayFooter.this.hideSmileyPanel();
                }
            }
        });
        mMEditText.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        this.rRN.setVisibility(8);
        this.rRS = (FrameLayout) findViewById(f.qJn);
        this.rRS.post(new Runnable() {
            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                SnsUploadUI.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                ae.bvU();
                r.dF(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        });
        this.rCS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SnsUploadUI.i(SnsUploadUI.this);
            }
        });
        this.rCS.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                SnsUploadUI.i(SnsUploadUI.this);
                return false;
            }
        });
        WrapScollview wrapScollview = (WrapScollview) findViewById(f.cJn);
        wrapScollview.contentView = this.rCS;
        wrapScollview.rTD = false;
        this.rxp = (SnsUploadConfigView) findViewById(f.qHN);
        com.tencent.mm.ui.i.a.a aVar = this.rxp;
        aVar.rRE.vXy = -1000.0f;
        aVar.rRE.vXx = -1000.0f;
        if (!aVar.rLT) {
            g.Dr();
            int e = bi.e((Integer) g.Dq().Db().get(68404, null));
            aVar.rRz = (e & 2) != 0;
            aVar.rRA = (e & 8) != 0;
            if (!b.PZ()) {
                aVar.rRA = false;
            }
            if (!q.Gx()) {
                aVar.rRz = false;
            }
        }
        aVar.iR(false);
        aVar.bCK();
        aVar.bCL();
        if (aVar.rRA) {
            aVar.rRF.a(aVar);
        }
        if (this.rzP != 0) {
            SnsUploadConfigView snsUploadConfigView = this.rxp;
            snsUploadConfigView.rRv.setVisibility(8);
            snsUploadConfigView.rRw.setVisibility(8);
            snsUploadConfigView.rRx.setVisibility(8);
        }
        if (this.rzP == 9) {
            this.rxp.rRx.setVisibility(0);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (SnsUploadUI.this.rzP == 9) {
                    SnsUploadUI.this.setResult(0, new Intent());
                    SnsUploadUI.this.finish();
                } else {
                    h.a(SnsUploadUI.this, j.qSI, 0, j.dDX, j.dEy, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (SnsUploadUI.this.fFZ != null) {
                                SnsUploadUI.this.fFZ.iw(10);
                            }
                            SnsUploadUI.this.setResult(0, new Intent());
                            SnsUploadUI.this.finish();
                        }
                    }, null, c.brm);
                }
                return true;
            }
        });
        a(0, getString(j.dGL), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!SnsUploadUI.this.isFinishing() && System.currentTimeMillis() - SnsUploadUI.this.rRT >= 500) {
                    SnsUploadUI.this.rRT = System.currentTimeMillis();
                    com.tencent.mm.plugin.report.service.f.vR(22);
                    com.tencent.mm.ui.tools.a.c Hg = com.tencent.mm.ui.tools.a.c.d(SnsUploadUI.this.rCS).Hg(com.tencent.mm.j.b.zH());
                    Hg.zwQ = true;
                    Hg.a(new com.tencent.mm.ui.tools.a.c.a() {
                        public final void vE(String str) {
                            int bCN = SnsUploadUI.this.rxp.bCN();
                            g.Dr();
                            g.Dq().Db().set(68404, Integer.valueOf(bCN));
                            SnsUploadUI.this.desc = SnsUploadUI.this.rCS.getText().toString();
                            int i = SnsUploadUI.this.rCS.rHB;
                            int bCM = SnsUploadUI.this.rxp.bCM();
                            int bCN2 = SnsUploadUI.this.rxp.bCN();
                            SnsUploadUI.this.rRM;
                            if (SnsUploadUI.this.rRP) {
                                SnsUploadUI.this.setResult(-1, new Intent());
                            }
                            if (SnsUploadUI.this.rCT instanceof ah) {
                                ah ahVar = (ah) SnsUploadUI.this.rCT;
                                LocationWidget o = SnsUploadUI.this.rRL;
                                apl apl = new apl();
                                apl.vXy = o.rAk;
                                apl.vXx = o.oVL;
                                apl.biF = o.biF;
                                apl.rAl = o.rAl;
                                ahVar.rBM = apl;
                            }
                            if (SnsUploadUI.this.rCT instanceof ae) {
                                SnsUploadUI.this.rCS.setText("");
                            }
                            PInt pInt = new PInt();
                            SnsUploadUI.this.rCT.a(bCM, bCN2, SnsUploadUI.this.rxp.rRF.zyZ, SnsUploadUI.this.desc, SnsUploadUI.this.rRK.bzI(), SnsUploadUI.this.rRL.bAk(), i, SnsUploadUI.this.rCZ, SnsUploadUI.this.rCY, pInt, SnsUploadUI.this.rRR, SnsUploadUI.this.rCW, SnsUploadUI.this.rCX);
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            Object[] objArr = new Object[4];
                            objArr[0] = Long.valueOf(SnsUploadUI.this.rDc);
                            objArr[1] = Long.valueOf(bi.Wx());
                            objArr[2] = Integer.valueOf(SnsUploadUI.this.rDb ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            gVar.h(13303, objArr);
                            String str2 = "MicroMsg.SnsUploadUI";
                            String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
                            objArr = new Object[4];
                            objArr[0] = Long.valueOf(SnsUploadUI.this.rDc);
                            objArr[1] = Long.valueOf(bi.Wx());
                            objArr[2] = Integer.valueOf(SnsUploadUI.this.rDb ? 0 : 1);
                            objArr[3] = Integer.valueOf(pInt.value);
                            x.d(str2, str3, objArr);
                            com.tencent.mm.plugin.report.service.g.pWK.k(10910, "1");
                            if (!bi.oN(SnsUploadUI.this.rCy)) {
                                if (SnsUploadUI.this.rCZ) {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11455, "", SnsUploadUI.this.rCy, Integer.valueOf(-1), Integer.valueOf(-1));
                                } else {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(11455, SnsUploadUI.this.rCy, "", Integer.valueOf(-1), Integer.valueOf(-1));
                                }
                            }
                            if (SnsUploadUI.this.fFZ != null) {
                                SnsUploadUI.this.fFZ.iw(9);
                            }
                            if (SnsUploadUI.this.rRQ) {
                                Intent intent = new Intent(SnsUploadUI.this, SnsTimeLineUI.class);
                                intent.putExtra("sns_resume_state", false);
                                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                                intent.addFlags(67108864);
                                SnsUploadUI.this.startActivity(intent);
                            }
                            com.tencent.mm.sdk.b.a.xmy.m(new qn());
                        }

                        public final void anp() {
                        }

                        public final void aeD() {
                            h.h(SnsUploadUI.this, j.qSK, j.qSL);
                        }
                    });
                }
                return false;
            }
        }, p.b.xSe);
        findViewById(f.qMe).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                x.d("MicroMsg.SnsUploadUI", "upload_content onTouch");
                if (SnsUploadUI.b(SnsUploadUI.this)) {
                    return true;
                }
                return false;
            }
        });
        this.rRK = (AtContactWidget) findViewById(f.qHv);
        this.rRK.rxp = this.rxp;
        this.rRL = (LocationWidget) findViewById(f.qIR);
        this.rRL.rAm = this;
        switch (this.rzP) {
            case 0:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
                this.rRM = (RangeWidget) findViewById(f.qJf);
                findViewById(f.qJg).setVisibility(8);
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.rRM = (RangeWidget) findViewById(f.qJf);
                findViewById(f.qJg).setVisibility(8);
                break;
            case 2:
            case 8:
                this.rRM = (RangeWidget) findViewById(f.qJf);
                findViewById(f.qJg).setVisibility(8);
                this.rRK.setVisibility(8);
                break;
        }
        this.rRM.rxp = this.rxp;
        aWY();
        x.d("MicroMsg.SnsUploadUI", "share type %d, isManuSnsPost:%b", Integer.valueOf(this.rzP), Boolean.valueOf(this.rDb));
        switch (this.rzP) {
            case 0:
                this.rCT = new ah(this);
                this.rCS.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        if (SnsUploadUI.this.rCS.getText().toString().trim().length() > 10) {
                            View findViewById = SnsUploadUI.this.findViewById(f.qKB);
                            if (findViewById != null) {
                                findViewById.setVisibility(8);
                            }
                        }
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                break;
            case 1:
            case 11:
            case 15:
            case 16:
                this.rCT = new aa(this);
                break;
            case 2:
                this.rCT = new ac(this);
                break;
            case 3:
                this.rCT = new ai(this, 9);
                break;
            case 4:
                this.rCT = new p(this);
                break;
            case 5:
                this.rCT = new ai(this, 14);
                break;
            case 6:
                this.rCT = new ai(this, 12);
                break;
            case 7:
                this.rCT = new ai(this, 13);
                break;
            case 8:
                this.rCT = new be(this);
                break;
            case 9:
                g.Dr();
                CharSequence aD = bi.aD((String) g.Dq().Db().get(68408, (Object) ""), "");
                g.Dr();
                int a2 = bi.a((Integer) g.Dq().Db().get(7489, Integer.valueOf(0)), 0);
                if (bi.oN(aD)) {
                    z = false;
                }
                this.rCT = new ae(this, z);
                this.rCS.rHB = a2;
                this.rCS.append(aD);
                this.rCS.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        if (SnsUploadUI.this.rCS.getText().toString().trim().length() > 0) {
                            SnsUploadUI.this.enableOptionMenu(true);
                        } else {
                            SnsUploadUI.this.enableOptionMenu(false);
                        }
                    }

                    public final void afterTextChanged(Editable editable) {
                    }
                });
                break;
            case 10:
                this.rCT = new n(this);
                break;
            case 12:
                this.rCT = new o(this);
                break;
            case 13:
                this.rCT = new q(this);
                break;
            case 14:
                this.rCT = new ad(this);
                break;
        }
        this.rCT.F(bundle);
        if (this.rCT instanceof a) {
            View findViewById = findViewById(f.qKu);
            View findViewById2 = findViewById(f.qKB);
            DynamicGridView dynamicGridView = (DynamicGridView) findViewById(f.qLp);
            dynamicGridView.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return SnsUploadUI.b(SnsUploadUI.this);
                }
            });
            a = ((a) this.rCT).a(findViewById, findViewById(f.qHQ), dynamicGridView, findViewById2);
            dynamicGridView.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.rRL.getLayoutParams();
            layoutParams.addRule(3, f.qLp);
            this.rRL.setLayoutParams(layoutParams);
        } else {
            a = this.rCT.bzU();
            this.rCU = (LinearLayout) findViewById(f.qMm);
            this.rCU.setVisibility(0);
            this.rCU.setClipChildren(false);
            if (a != null) {
                this.rCU.addView(a);
            } else {
                this.rCU.setVisibility(8);
            }
        }
        if (this.rCT instanceof aa) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) a.getLayoutParams();
            layoutParams2.width = -1;
            a.setLayoutParams(layoutParams2);
        }
        bCQ();
        this.rRO.xPq = new KeyboardLinearLayout.a() {
            public final void ra(int i) {
                if (i == -3) {
                    x.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_SHOW");
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            SnsUploadSayFooter c = SnsUploadUI.this.rRN;
                            c.setVisibility(0);
                            if (c.opZ != null) {
                                c.opZ.setImageResource(i.e.qFX);
                            }
                            SnsUploadUI.this.rRN.postInvalidate();
                            SnsUploadUI.this.mController.contentView.postInvalidate();
                        }
                    }, 100);
                    return;
                }
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        SnsUploadSayFooter c = SnsUploadUI.this.rRN;
                        if (!c.bCO()) {
                            c.setVisibility(8);
                        }
                        SnsUploadUI.this.rRN.postInvalidate();
                        SnsUploadUI.this.mController.contentView.postInvalidate();
                    }
                }, 200);
                x.d("MicroMsg.SnsUploadUI", "KEYBOARD_STATE_HIDE");
            }
        };
        if (this.rzP == 0) {
            if (!(this.rCT instanceof ah)) {
                x.e("MicroMsg.SnsUploadUI", "!(widget instanceof PicWidget)");
            } else if (VERSION.SDK_INT < 11) {
                x.d("MicroMsg.SnsUploadUI", "sdk not support dragdrop event");
            } else {
                new Runnable() {
                    public final void run() {
                        OnDragListener anonymousClass1 = new OnDragListener() {
                            public final boolean onDrag(View view, DragEvent dragEvent) {
                                boolean z;
                                switch (dragEvent.getAction()) {
                                    case 1:
                                    case 2:
                                    case 4:
                                    case 5:
                                        x.i("MicroMsg.SnsUploadUI", "ACTION: [%s]", Integer.valueOf(dragEvent.getAction()));
                                        z = true;
                                        break;
                                    case 3:
                                        x.i("MicroMsg.SnsUploadUI", "ACTION_DROP");
                                        ClipData clipData = dragEvent.getClipData();
                                        if (clipData == null) {
                                            z = true;
                                            break;
                                        }
                                        int itemCount = clipData.getItemCount();
                                        List arrayList = new ArrayList();
                                        for (int i = 0; i < itemCount; i++) {
                                            Item itemAt = clipData.getItemAt(i);
                                            if (itemAt == null) {
                                                x.e("MicroMsg.SnsUploadUI", "item == null");
                                            } else if (itemAt.getIntent() != null) {
                                                SnsUploadUI.this.startActivity(itemAt.getIntent());
                                            } else if (itemAt.getUri() != null) {
                                                l lVar = new l(SnsUploadUI.this.mController.xRr, itemAt.getUri());
                                                if (lVar.fileType != 0 && lVar.filePath != null) {
                                                    switch (lVar.fileType) {
                                                        case 3:
                                                            arrayList.add(lVar.filePath);
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                }
                                                x.e("MicroMsg.SnsUploadUI", "get file path failed");
                                            }
                                        }
                                        if (arrayList.size() >= 0) {
                                            ((ah) SnsUploadUI.this.rCT).c(arrayList, 0, false);
                                            z = true;
                                            break;
                                        }
                                        x.e("MicroMsg.SnsUploadUI", "no image file available");
                                        return true;
                                        break;
                                    default:
                                        x.e("MicroMsg.SnsUploadUI", "Unknown action type received by OnDragListener.");
                                        z = false;
                                        break;
                                }
                                return z;
                            }
                        };
                        if (SnsUploadUI.this.rRS != null) {
                            SnsUploadUI.this.rRS.setOnDragListener(anonymousClass1);
                        }
                    }
                }.run();
            }
        }
        e.i(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        SnsUploadSayFooter snsUploadSayFooter = this.rRN;
        int i2 = (snsUploadSayFooter.bCO() || snsUploadSayFooter.getVisibility() == 0) ? 1 : 0;
        if (i2 != 0) {
            this.rRN.bCP();
            return true;
        } else if (this.rzP == 9) {
            setResult(0, new Intent());
            finish();
            return true;
        } else {
            h.a((Context) this, j.qSI, 0, j.dDX, j.dEy, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (SnsUploadUI.this.fFZ != null) {
                        SnsUploadUI.this.fFZ.iw(10);
                    }
                    SnsUploadUI.this.setResult(0, new Intent());
                    SnsUploadUI.this.finish();
                }
            }, null, c.brm);
            return true;
        }
    }

    public final void bCQ() {
        if (this.rCT.bzT()) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    protected void onPause() {
        if (this.rzP == 9) {
            String trim = this.rCS.getText().toString().trim();
            g.Dr();
            g.Dq().Db().set(68408, trim);
            if (bi.oN(trim)) {
                g.Dr();
                g.Dq().Db().set(7489, Integer.valueOf(0));
            } else {
                g.Dr();
                g.Dq().Db().set(7489, Integer.valueOf(this.rCS.rHB));
            }
        }
        super.aWY();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.rRN.post(new Runnable() {
            public final void run() {
                com.tencent.mm.compatible.util.j.h(SnsUploadUI.this);
            }
        });
        if (this.rCT != null && (this.rCT instanceof ad)) {
            ad adVar = (ad) this.rCT;
            if (adVar.rAy != null && !bi.oN(adVar.videoPath)) {
                adVar.rAy.aA(adVar.videoPath, false);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.rCT != null) {
            this.rCT.bzV();
        }
        if (this.rRL != null) {
            this.rRL.stop();
        }
        if (this.rRN != null) {
            SnsUploadSayFooter snsUploadSayFooter = this.rRN;
            if (snsUploadSayFooter.oqc != null) {
                snsUploadSayFooter.oqc.tj();
                snsUploadSayFooter.oqc.destroy();
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.rCS != null) {
            this.rCS.clearFocus();
        }
        if (i2 == -1) {
            if (this.rCT.a(i, intent)) {
                bCQ();
            }
            switch (i) {
                case 5:
                    if (intent != null) {
                        this.rRM.a(i, i2, intent, this.rRK);
                        int intExtra = intent.getIntExtra("Ktag_range_index", 0);
                        if (intExtra >= 2) {
                            Iterator it;
                            this.rCy = intent.getStringExtra("Klabel_name_list");
                            this.rCz = intent.getStringExtra("Kother_user_name_list");
                            List list;
                            if (bi.oN(this.rCy)) {
                                list = null;
                            } else {
                                list = Arrays.asList(this.rCy.split(","));
                            }
                            List list2;
                            if (bi.oN(this.rCz)) {
                                list2 = null;
                            } else {
                                list2 = Arrays.asList(this.rCz.split(","));
                            }
                            this.rCY = new ArrayList();
                            this.rCW = 0;
                            if (list != null && list.size() > 0) {
                                Collection hashSet = new HashSet();
                                for (String DU : list) {
                                    List<String> DX = com.tencent.mm.plugin.label.a.a.aVD().DX(com.tencent.mm.plugin.label.a.a.aVD().DU(DU));
                                    if (DX == null || DX.size() == 0) {
                                        x.e("MicroMsg.SnsUploadUI", "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
                                        this.rCY = new ArrayList(hashSet);
                                    } else {
                                        for (String DU2 : DX) {
                                            hashSet.add(DU2);
                                            this.rCW++;
                                            x.d("MicroMsg.SnsUploadUI", "dz:name : %s", DU2);
                                        }
                                    }
                                }
                                this.rCY = new ArrayList(hashSet);
                            }
                            if (list != null) {
                                int i3 = 0;
                                it = list.iterator();
                                while (true) {
                                    int i4 = i3;
                                    if (!it.hasNext()) {
                                        this.rCW = i4;
                                    } else if (bi.oN((String) it.next())) {
                                        i3 = i4;
                                    } else {
                                        i3 = i4 + 1;
                                    }
                                }
                            }
                            this.rCX = 0;
                            if (list2 != null && list2.size() > 0) {
                                for (String DU22 : list2) {
                                    if (!this.rCY.contains(DU22)) {
                                        this.rCY.add(DU22);
                                        this.rCX++;
                                    }
                                }
                            }
                            if (intExtra == 2) {
                                this.rCZ = false;
                                return;
                            } else {
                                this.rCZ = true;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                case 6:
                    if (intent != null) {
                        this.rRK.U(intent);
                        return;
                    }
                    return;
                case 8:
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra("bind_facebook_succ", false);
                        SnsUploadConfigView snsUploadConfigView = this.rxp;
                        if (booleanExtra) {
                            snsUploadConfigView.rRz = true;
                            snsUploadConfigView.iR(true);
                            return;
                        }
                        return;
                    }
                    return;
                case 10:
                    if (intent != null) {
                        this.rRL.U(intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return i.g.qOm;
    }

    public final ArrayList<Exif.a> bAm() {
        if (!(this.rCT instanceof ah)) {
            return null;
        }
        ah ahVar = (ah) this.rCT;
        ArrayList arrayList = ahVar.rBG.rBR;
        ArrayList<Exif.a> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Exif.a aVar = (Exif.a) ahVar.rBI.get((String) it.next());
            if (aVar != null) {
                arrayList2.add(aVar);
            }
        }
        return arrayList2;
    }

    public final boolean bAn() {
        return this.rAC;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SnsUploadUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    this.rRL.bAg();
                    return;
                } else {
                    h.a((Context) this, getString(j.eAc), getString(j.eAg), getString(j.esG), getString(j.dEy), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SnsUploadUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            dialogInterface.dismiss();
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
