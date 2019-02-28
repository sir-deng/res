package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMScrollGridView;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class FacingCreateChatRoomAllInOneUI extends MMActivity implements e {
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2));
            if (z) {
                Location location = new Location(f2, f, (int) d2, i, "", "");
                if (!location.bZJ()) {
                    FacingCreateChatRoomAllInOneUI.this.prn = location;
                    FacingCreateChatRoomAllInOneUI.this.prk = true;
                    FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
                }
            } else {
                FacingCreateChatRoomAllInOneUI.this.prk = false;
            }
            return false;
        }
    };
    private boolean kFP = false;
    private String liu;
    private ProgressDialog lzx;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 10001:
                    if (FacingCreateChatRoomAllInOneUI.this.prA != null) {
                        FacingCreateChatRoomAllInOneUI.this.prA.I(FacingCreateChatRoomAllInOneUI.this.prx);
                        return;
                    }
                    return;
                case 10002:
                    FacingCreateChatRoomAllInOneUI.d(FacingCreateChatRoomAllInOneUI.this);
                    return;
                default:
                    return;
            }
        }
    };
    private a prA;
    private View prB;
    private TextView prC;
    private MMScrollGridView prD;
    private View prE;
    private View prF;
    private Button prG;
    private MMCallBackScrollView prH;
    private TextView prI;
    private boolean prJ = false;
    private ah prK = new ah();
    private al prL = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this);
            return false;
        }
    }, false);
    private com.tencent.mm.plugin.pwdgroup.a.a prM;
    private com.tencent.mm.plugin.pwdgroup.a.a prN;
    private int prO;
    private Animation prP;
    private AnimationSet prQ;
    private Animation prR;
    public OnMenuItemClickListener prS = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            FacingCreateChatRoomAllInOneUI.this.finish();
            return false;
        }
    };
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a prT = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a() {
        public final void h(boolean z, String str) {
            x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", Boolean.valueOf(z), str);
            FacingCreateChatRoomAllInOneUI.this.pro = str;
            if (z) {
                FacingCreateChatRoomAllInOneUI.this.prj = true;
                FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
            }
        }
    };
    private OnClickListener prU = new OnClickListener() {
        public final void onClick(View view) {
            FacingCreateChatRoomAllInOneUI.this.prv = false;
            FacingCreateChatRoomAllInOneUI.d(FacingCreateChatRoomAllInOneUI.this);
        }
    };
    public com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a prV = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a() {
        public final void input(String str) {
            if (FacingCreateChatRoomAllInOneUI.this.prp == null) {
                return;
            }
            if (FacingCreateChatRoomAllInOneUI.this.pri || FacingCreateChatRoomAllInOneUI.this.prm) {
                MMPwdInputView g = FacingCreateChatRoomAllInOneUI.this.prp;
                g.TA();
                g.input(str);
                FacingCreateChatRoomAllInOneUI.this.vn(a.psb);
                return;
            }
            FacingCreateChatRoomAllInOneUI.this.prp.input(str);
        }

        public final void TA() {
            if (FacingCreateChatRoomAllInOneUI.this.prp != null) {
                FacingCreateChatRoomAllInOneUI.this.prp.TA();
            }
        }

        public final void delete() {
            if (FacingCreateChatRoomAllInOneUI.this.prp == null) {
                return;
            }
            if (FacingCreateChatRoomAllInOneUI.this.pri || FacingCreateChatRoomAllInOneUI.this.prm) {
                FacingCreateChatRoomAllInOneUI.this.prp.TA();
                FacingCreateChatRoomAllInOneUI.this.vn(a.psb);
                return;
            }
            MMPwdInputView g = FacingCreateChatRoomAllInOneUI.this.prp;
            if (g.msL > 0) {
                g.lke.deleteCharAt(g.msL - 1);
            }
            g.bkC();
            g.bkB();
        }
    };
    private al prW = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            FacingCreateChatRoomAllInOneUI.this.prj = false;
            FacingCreateChatRoomAllInOneUI.this.vn(a.pse);
            return true;
        }
    }, false);
    private c prh;
    private boolean pri = false;
    private boolean prj;
    private boolean prk;
    private boolean prl;
    private boolean prm = false;
    private Location prn;
    private String pro;
    private MMPwdInputView prp;
    private View prq;
    private ProgressBar prr;
    private TextView prs;
    private MMKeyBoardView prt;
    private TextView pru;
    private boolean prv = false;
    private boolean prw = false;
    private LinkedList<uw> prx = new LinkedList();
    private HashMap<String, uw> pry = new HashMap();
    private LinkedList<uw> prz = new LinkedList();

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI$10 */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] psa = new int[a.bkA().length];

        static {
            try {
                psa[a.psb - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                psa[a.psc - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                psa[a.psd - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                psa[a.pse - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private enum a {
        ;

        public static int[] bkA() {
            return (int[]) psf.clone();
        }

        static {
            psb = 1;
            psc = 2;
            psd = 3;
            pse = 4;
            psf = new int[]{psb, psc, psd, pse};
        }
    }

    static /* synthetic */ void a(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        if (facingCreateChatRoomAllInOneUI.kFP || facingCreateChatRoomAllInOneUI.prn == null) {
            x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cancel refresh chat room member.");
            return;
        }
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryDoSearchScene]-----------");
        facingCreateChatRoomAllInOneUI.prM = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.pro, facingCreateChatRoomAllInOneUI.liu, facingCreateChatRoomAllInOneUI.prn.hzq, facingCreateChatRoomAllInOneUI.prn.hzr, facingCreateChatRoomAllInOneUI.prn.accuracy, facingCreateChatRoomAllInOneUI.prn.fBZ, facingCreateChatRoomAllInOneUI.prn.mac, facingCreateChatRoomAllInOneUI.prn.fCb);
        as.CN().a(facingCreateChatRoomAllInOneUI.prM, 0);
    }

    static /* synthetic */ void d(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        facingCreateChatRoomAllInOneUI.getString(R.l.dGZ);
        facingCreateChatRoomAllInOneUI.lzx = h.a((Context) facingCreateChatRoomAllInOneUI, facingCreateChatRoomAllInOneUI.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().cancel(653);
            }
        });
        facingCreateChatRoomAllInOneUI.bkx();
        as.CN().a(new com.tencent.mm.plugin.pwdgroup.a.a(1, facingCreateChatRoomAllInOneUI.pro, facingCreateChatRoomAllInOneUI.liu, facingCreateChatRoomAllInOneUI.prn.hzq, facingCreateChatRoomAllInOneUI.prn.hzr, facingCreateChatRoomAllInOneUI.prn.accuracy, facingCreateChatRoomAllInOneUI.prn.fBZ, facingCreateChatRoomAllInOneUI.prn.mac, facingCreateChatRoomAllInOneUI.prn.fCb), 0);
    }

    static /* synthetic */ void e(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryGetChatRoomUser]");
        if (facingCreateChatRoomAllInOneUI.prW != null) {
            facingCreateChatRoomAllInOneUI.prW.TN();
        }
        if (facingCreateChatRoomAllInOneUI.prk) {
            if (facingCreateChatRoomAllInOneUI.prj) {
                facingCreateChatRoomAllInOneUI.vn(a.psc);
            }
            if (facingCreateChatRoomAllInOneUI.prk && facingCreateChatRoomAllInOneUI.prj && !facingCreateChatRoomAllInOneUI.prl) {
                x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "do tryGetChatRoomUser");
                facingCreateChatRoomAllInOneUI.prl = true;
                facingCreateChatRoomAllInOneUI.prj = false;
                facingCreateChatRoomAllInOneUI.prN = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.pro, "", facingCreateChatRoomAllInOneUI.prn.hzq, facingCreateChatRoomAllInOneUI.prn.hzr, facingCreateChatRoomAllInOneUI.prn.accuracy, facingCreateChatRoomAllInOneUI.prn.fBZ, facingCreateChatRoomAllInOneUI.prn.mac, facingCreateChatRoomAllInOneUI.prn.fCb);
                as.CN().a(facingCreateChatRoomAllInOneUI.prN, 0);
                return;
            }
            return;
        }
        x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "tryGetChatRoomUser location is no ready.");
        facingCreateChatRoomAllInOneUI.vn(a.psc);
        if (facingCreateChatRoomAllInOneUI.prW != null) {
            facingCreateChatRoomAllInOneUI.prW.K(15000, 15000);
        }
    }

    protected final int getLayoutId() {
        return R.i.dhv;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
            bkv();
        }
    }

    private void bkv() {
        this.prh = c.OV();
        this.prh.a(this.gAn, true);
        as.CN().a(653, (e) this);
        initView();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    bkv();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAc), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            FacingCreateChatRoomAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            FacingCreateChatRoomAllInOneUI.this.finish();
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            FacingCreateChatRoomAllInOneUI.this.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    protected void onResume() {
        if (this.prh != null) {
            this.prh.a(this.gAn, true);
        }
        if (this.prJ) {
            bkw();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.prh != null) {
            this.prh.c(this.gAn);
        }
        if (this.prJ) {
            bkx();
        }
        super.onPause();
    }

    protected void onDestroy() {
        as.CN().b(653, (e) this);
        if (this.prh != null) {
            this.prh.c(this.gAn);
        }
        if (!this.prw) {
            as.CN().cancel(653);
            if (this.prn != null) {
                this.prN = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.pro, "", this.prn.hzq, this.prn.hzr, this.prn.accuracy, this.prn.fBZ, this.prn.mac, this.prn.fCb);
                as.CN().a(this.prN, 0);
            }
        }
        if (this.prJ) {
            bkx();
        }
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setMMTitle(R.l.ehJ);
        setBackBtn(this.prS);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.g.bER));
        }
        this.prq = findViewById(R.h.cge);
        this.prr = (ProgressBar) findViewById(R.h.cgd);
        this.prs = (TextView) findViewById(R.h.cgf);
        this.prt = (MMKeyBoardView) findViewById(R.h.cgc);
        this.pru = (TextView) findViewById(R.h.cgb);
        this.prp = (MMPwdInputView) findViewById(R.h.cfZ);
        this.prp.psU = this.prT;
        this.prp.requestFocus();
        this.prt.prV = this.prV;
        vn(a.psb);
        this.prB = findViewById(R.h.cfS);
        this.prC = (TextView) findViewById(R.h.cfU);
        this.prD = (MMScrollGridView) findViewById(R.h.cfT);
        this.prD.setVisibility(4);
        this.prG = (Button) findViewById(R.h.cfV);
        this.prG.setOnClickListener(this.prU);
        this.prE = findViewById(R.h.cfW);
        this.prF = findViewById(R.h.cfX);
        this.prC.setText(R.l.eeI);
        this.prH = (MMCallBackScrollView) findViewById(R.h.cgg);
        this.prI = (TextView) findViewById(R.h.cga);
        this.prH.psl = new com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.a() {
            public final void bp(int i) {
                if (FacingCreateChatRoomAllInOneUI.this.prF == null) {
                    return;
                }
                if (i == 0) {
                    FacingCreateChatRoomAllInOneUI.this.prF.setVisibility(4);
                } else {
                    FacingCreateChatRoomAllInOneUI.this.prF.setVisibility(0);
                }
            }
        };
        this.prA = new a(this);
        this.prD.setAdapter(this.prA);
        this.prA.I(this.prx);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (kVar.getType()) {
            case 653:
                com.tencent.mm.plugin.pwdgroup.a.a aVar = (com.tencent.mm.plugin.pwdgroup.a.a) kVar;
                int i3 = aVar.prg;
                if (i3 == 0) {
                    this.prl = false;
                    if (this.prJ) {
                        if (this.prL != null) {
                            this.prL.K(3000, 3000);
                        }
                        if (i == 0 && i2 == 0) {
                            final LinkedList linkedList = aVar.bku().vNu;
                            this.prK.F(new Runnable() {
                                public final void run() {
                                    int size;
                                    int i;
                                    uw uwVar;
                                    if (FacingCreateChatRoomAllInOneUI.this.prz != null) {
                                        FacingCreateChatRoomAllInOneUI.this.prz.clear();
                                    }
                                    if (FacingCreateChatRoomAllInOneUI.this.pry != null) {
                                        FacingCreateChatRoomAllInOneUI.this.pry.clear();
                                    }
                                    if (linkedList != null && linkedList.size() > 0) {
                                        size = linkedList.size();
                                        for (i = 0; i < size; i++) {
                                            uwVar = (uw) linkedList.get(i);
                                            if (!bi.oN(uwVar.wjz)) {
                                                FacingCreateChatRoomAllInOneUI.this.pry.put(uwVar.wjz, uwVar);
                                            }
                                        }
                                    }
                                    size = FacingCreateChatRoomAllInOneUI.this.prx.size();
                                    for (i = 0; i < size; i++) {
                                        uwVar = (uw) FacingCreateChatRoomAllInOneUI.this.prx.get(i);
                                        if (FacingCreateChatRoomAllInOneUI.this.pry.containsKey(uwVar.wjz)) {
                                            FacingCreateChatRoomAllInOneUI.this.pry.remove(uwVar.wjz);
                                        } else {
                                            x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", uwVar.wjz);
                                        }
                                    }
                                    if (FacingCreateChatRoomAllInOneUI.this.pry != null && FacingCreateChatRoomAllInOneUI.this.pry.size() > 0) {
                                        for (Entry value : FacingCreateChatRoomAllInOneUI.this.pry.entrySet()) {
                                            FacingCreateChatRoomAllInOneUI.this.prz.add((uw) value.getValue());
                                            x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", uwVar.wjz);
                                        }
                                    }
                                    FacingCreateChatRoomAllInOneUI.this.prx.addAll(FacingCreateChatRoomAllInOneUI.this.prz);
                                    FacingCreateChatRoomAllInOneUI.this.mHandler.sendEmptyMessage(10001);
                                }
                            });
                            this.liu = aVar.bku().wgO;
                            return;
                        }
                        return;
                    } else if (i == 0 && i2 == 0) {
                        vn(a.psb);
                        this.prO = this.pru.getHeight();
                        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", Integer.valueOf(this.prO));
                        this.prP = AnimationUtils.loadAnimation(this, R.a.bpY);
                        this.prR = AnimationUtils.loadAnimation(this, R.a.bpW);
                        this.prQ = new AnimationSet(true);
                        this.prQ.addAnimation(AnimationUtils.loadAnimation(this, R.a.bqs));
                        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-this.prO));
                        translateAnimation.setDuration(300);
                        this.prQ.addAnimation(translateAnimation);
                        this.prP.setDuration(200);
                        this.prQ.setDuration(300);
                        this.prR.setDuration(300);
                        this.prP.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.prQ.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.prR.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.prQ.setFillAfter(true);
                        translateAnimation.setFillAfter(true);
                        this.prQ.setAnimationListener(new AnimationListener() {
                            public final void onAnimationStart(Animation animation) {
                                FacingCreateChatRoomAllInOneUI.this.prB.setVisibility(4);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                FacingCreateChatRoomAllInOneUI.this.prI.setVisibility(8);
                                FacingCreateChatRoomAllInOneUI.this.prp.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.prD.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.prE.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.prB.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.prq.setVisibility(8);
                                FacingCreateChatRoomAllInOneUI.this.prt.setVisibility(8);
                                FacingCreateChatRoomAllInOneUI.this.prp.clearAnimation();
                                FacingCreateChatRoomAllInOneUI.this.prD.clearAnimation();
                                FacingCreateChatRoomAllInOneUI.this.prB.clearAnimation();
                            }
                        });
                        this.prp.setVisibility(4);
                        this.prp.setAnimation(translateAnimation);
                        this.prt.startAnimation(this.prP);
                        this.prq.startAnimation(this.prP);
                        this.pru.startAnimation(this.prP);
                        this.prE.startAnimation(this.prR);
                        this.prB.startAnimation(this.prQ);
                        this.prE.setVisibility(4);
                        this.prt.setVisibility(8);
                        this.pru.setVisibility(8);
                        this.prJ = true;
                        bkw();
                        return;
                    } else if (i2 == -431) {
                        this.pri = true;
                        vn(a.psd);
                        return;
                    } else {
                        this.pri = true;
                        vn(a.pse);
                        return;
                    }
                } else if (i3 == 3) {
                    if (i != 0 || i2 != 0) {
                        if (i2 == -431) {
                            vn(a.psd);
                            this.pri = true;
                            return;
                        }
                        vn(a.pse);
                        return;
                    }
                    return;
                } else if (i3 != 1) {
                    aVF();
                    return;
                } else if (i == 0 && i2 == 0) {
                    aVF();
                    x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", aVar.bku().wfN);
                    this.prw = true;
                    finish();
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", r0);
                    com.tencent.mm.plugin.pwdgroup.a.ihN.e(intent, (Context) this);
                    return;
                } else if (i2 == -432 && !this.prv) {
                    this.prv = true;
                    this.mHandler.sendEmptyMessageDelayed(10002, 3000);
                    return;
                } else if (i2 == -23) {
                    aVF();
                    zk(getString(R.l.eeJ));
                    if (this.prL != null) {
                        this.prL.K(3000, 3000);
                        return;
                    }
                    return;
                } else {
                    aVF();
                    com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
                    if (eC != null) {
                        eC.a(this.mController.xRr, null, null);
                    } else {
                        zk(getString(R.l.eBT));
                    }
                    if (this.prL != null) {
                        this.prL.K(3000, 3000);
                        return;
                    }
                    return;
                }
            default:
                x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
                return;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void hp(boolean z) {
        if (this.prt != null) {
            this.prt.hq(z);
        }
    }

    private void vn(int i) {
        if (this.prs != null) {
            switch (AnonymousClass10.psa[i - 1]) {
                case 1:
                    hp(true);
                    this.pri = false;
                    this.prm = false;
                    this.prr.setVisibility(8);
                    this.prs.setVisibility(8);
                    return;
                case 2:
                    hp(false);
                    this.prs.setText(R.l.eBU);
                    this.prr.setVisibility(0);
                    this.prs.setVisibility(8);
                    return;
                case 3:
                    hp(true);
                    this.prr.setVisibility(8);
                    this.prs.setVisibility(0);
                    this.prs.setText(R.l.eBS);
                    bky();
                    return;
                case 4:
                    hp(true);
                    this.prr.setVisibility(8);
                    this.prs.setVisibility(0);
                    this.prs.setText(R.l.eBT);
                    bky();
                    return;
                default:
                    x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
                    return;
            }
        }
    }

    private void aVF() {
        if (this.lzx != null && this.lzx.isShowing()) {
            this.lzx.dismiss();
        }
    }

    private void zk(String str) {
        h.a((Context) this, str, "", getString(R.l.dGf), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void bkw() {
        this.kFP = false;
        if (this.prL != null) {
            this.prL.K(0, 0);
        }
    }

    private void bkx() {
        this.kFP = true;
        if (this.prL != null) {
            this.prL.TN();
        }
        as.CN().c(this.prM);
    }

    private void bky() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.a.bpP);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.a.bpO);
        loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                FacingCreateChatRoomAllInOneUI.this.prp.TA();
                FacingCreateChatRoomAllInOneUI.this.prp.startAnimation(loadAnimation2);
            }
        });
        loadAnimation2.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (FacingCreateChatRoomAllInOneUI.this.prt != null) {
                    FacingCreateChatRoomAllInOneUI.this.prt.hq(true);
                }
            }
        });
        if (this.prp != null) {
            this.prp.startAnimation(loadAnimation);
        }
        if (this.prt != null) {
            this.prt.hq(false);
        }
    }
}
