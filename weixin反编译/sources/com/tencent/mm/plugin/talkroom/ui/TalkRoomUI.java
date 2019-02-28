package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.a.ln;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.talkroom.model.b;
import com.tencent.mm.pluginsdk.q.o;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomUI extends MMBaseActivity implements e, o {
    private List<String> fBI = new LinkedList();
    private TextView ikn;
    private r ioc;
    private TextView nQV;
    private boolean oad = true;
    private String oae;
    private String oaf;
    private boolean oah = false;
    private int oai = 0;
    private long oaj = 500;
    private long oak = 0;
    private al oal = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            x.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess expired to execute");
            TalkRoomUI.this.aWE();
            return false;
        }
    }, false);
    private al oam = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            x.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
            TalkRoomUI.a(TalkRoomUI.this);
            return false;
        }
    }, false);
    private al oan = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            TalkRoomUI.this.aWF();
            return false;
        }
    }, false);
    private final al oaq = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            short bFF;
            int i = 15;
            int i2 = 0;
            if (TalkRoomUI.this.oai == 3) {
                bFF = b.bFm().bFF();
            } else if (bi.oN(TalkRoomUI.this.oaf)) {
                TalkRoomUI.this.bFM();
                return false;
            } else {
                bFF = b.bFm().bFG();
            }
            if (bFF <= (short) 15) {
                if (!TalkRoomUI.this.siP) {
                    i = 0;
                }
                TalkRoomUI.this.siQ = TalkRoomUI.this.siQ + 1;
                if (TalkRoomUI.this.siQ >= 5) {
                    boolean z;
                    TalkRoomUI talkRoomUI = TalkRoomUI.this;
                    if (TalkRoomUI.this.siP) {
                        z = false;
                    } else {
                        z = true;
                    }
                    talkRoomUI.siP = z;
                    TalkRoomUI.this.siQ = 0;
                }
            } else {
                short s = bFF;
            }
            TalkRoomUI.this.bFM();
            a aVar = TalkRoomUI.this.siM.sjc;
            if (i >= 0) {
                i2 = i > aVar.max ? aVar.max : i;
            }
            aVar.value = i2;
            aVar.sjt = aVar.sji - ((aVar.sji - aVar.sjh) * ((((float) aVar.value) * 1.0f) / ((float) aVar.max)));
            return true;
        }
    }, true);
    private boolean oar = true;
    private Chronometer oaw;
    private int oax = 0;
    private float obl = -1.0f;
    private TextView siI;
    private ImageButton siJ;
    private Button siK;
    private ImageView siL;
    private TalkRoomVolumeMeter siM;
    private TalkRoomAvatarsFrame siN;
    private a siO;
    private boolean siP = true;
    private int siQ = 0;
    private AlphaAnimation siR;
    private AlphaAnimation siS;
    private AlphaAnimation siT;
    private AlphaAnimation siU;
    private float siV = -1.0f;
    private float siW = -1.0f;
    private WakeLock wakeLock;

    private abstract class a {
        float iTW;
        float iTX;
        long sjb;

        public abstract void bFQ();

        private a() {
        }

        /* synthetic */ a(TalkRoomUI talkRoomUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$2 */
    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ k iYT;

        AnonymousClass2(k kVar) {
            this.iYT = kVar;
        }

        public final void onClick(View view) {
            this.iYT.dismiss();
        }
    }

    static /* synthetic */ void a(TalkRoomUI talkRoomUI) {
        if (talkRoomUI.oai == 5) {
            talkRoomUI.oai = 3;
            b.bFm().bFi();
            talkRoomUI.oaq.K(100, 100);
        }
    }

    static /* synthetic */ boolean a(TalkRoomUI talkRoomUI, MotionEvent motionEvent) {
        if (talkRoomUI.obl < 0.0f) {
            talkRoomUI.obl = (((float) talkRoomUI.siJ.getWidth()) - (((float) talkRoomUI.siJ.getPaddingLeft()) * 2.0f)) / 2.0f;
            talkRoomUI.siV = (((float) talkRoomUI.siJ.getWidth()) * 1.0f) / 2.0f;
            talkRoomUI.siW = (((float) talkRoomUI.siJ.getHeight()) * 1.0f) / 2.0f;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return Math.sqrt((double) (((x - talkRoomUI.siV) * (x - talkRoomUI.siV)) + ((y - talkRoomUI.siW) * (y - talkRoomUI.siW)))) < ((double) talkRoomUI.obl);
    }

    private void bFM() {
        if (this.oai == 3 || this.oai == 5) {
            this.siM.jb(true);
        } else if (bi.oN(this.oaf)) {
            this.siM.jb(false);
        } else {
            this.siM.jb(true);
        }
    }

    public void onCreate(Bundle bundle) {
        x.d("MicroMsg.TalkRoomUI", "onCreate");
        super.onCreate(bundle);
        final String stringExtra = getIntent().getStringExtra("enter_room_username");
        x.i("MicroMsg.TalkRoomUI", "onCreate talkRoomName : %s", stringExtra);
        x.d("MicroMsg.TalkRoomUI", "talkRoomName %s ", stringExtra);
        this.oae = stringExtra;
        if (bi.oN(this.oae)) {
            MZ("");
        } else {
            if (s.eX(stringExtra)) {
                List gl = m.gl(stringExtra);
                if (gl == null) {
                    com.tencent.mm.y.ak.a.hhv.Q(stringExtra, "");
                } else {
                    this.fBI = gl;
                }
            } else {
                this.fBI.clear();
                this.fBI.add(stringExtra);
                this.fBI.add(q.FY());
            }
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    b.bFm().co(stringExtra, 0);
                }
            });
        }
        x.d("MicroMsg.TalkRoomUI", "onCreate before initView");
        setContentView(v.fw(ad.getContext()).inflate(R.i.dte, null));
        this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(26, "TalkRoomUI Lock");
        this.ikn = (TextView) findViewById(R.h.cSB);
        this.siI = (TextView) findViewById(R.h.cwa);
        this.nQV = (TextView) findViewById(R.h.bZc);
        this.siK = (Button) findViewById(R.h.cpO);
        this.oaw = (Chronometer) findViewById(R.h.chronometer);
        this.siL = (ImageView) findViewById(R.h.csN);
        this.siO = new a(this);
        this.siK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.a(TalkRoomUI.this, TalkRoomUI.this.getString(R.l.eQS), TalkRoomUI.this.getString(R.l.eQR), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        TalkRoomUI.this.oar = false;
                        b.bFm().aWG();
                        TalkRoomUI.this.finish();
                    }
                }, null);
            }
        });
        findViewById(R.h.cTW).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z;
                Context context = TalkRoomUI.this;
                as.Hm();
                if (bi.a((Integer) c.Db().get(144641, null), 0) > 0) {
                    z = false;
                } else {
                    k kVar = new k(context, R.m.eZo);
                    LinearLayout linearLayout = (LinearLayout) v.fw(ad.getContext()).inflate(R.i.dth, null);
                    linearLayout.setMinimumWidth(10000);
                    Button button = (Button) linearLayout.findViewById(R.h.coL);
                    kVar.setCanceledOnTouchOutside(true);
                    kVar.setOnDismissListener(new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            as.Hm();
                            int a = bi.a((Integer) c.Db().get(144641, null), 0) + 1;
                            as.Hm();
                            c.Db().set(144641, Integer.valueOf(a));
                            TalkRoomUI.this.onBackPressed();
                        }
                    });
                    kVar.setCancelable(false);
                    button.setOnClickListener(new AnonymousClass2(kVar));
                    kVar.setContentView(linearLayout);
                    kVar.show();
                    z = true;
                }
                if (!z) {
                    TalkRoomUI.this.onBackPressed();
                }
            }
        });
        this.siJ = (ImageButton) findViewById(R.h.cvZ);
        this.siJ.setEnabled(false);
        this.siJ.setImageResource(R.g.bGL);
        this.siJ.setOnTouchListener(new OnTouchListener() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
                /*
                r5 = this;
                r4 = 0;
                r0 = r7.getAction();
                switch(r0) {
                    case 0: goto L_0x0009;
                    case 1: goto L_0x006f;
                    case 2: goto L_0x005f;
                    case 3: goto L_0x006f;
                    default: goto L_0x0008;
                };
            L_0x0008:
                return r4;
            L_0x0009:
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r1 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r1 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a(r1, r7);
                r0.oah = r1;
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = r0.oah;
                if (r0 == 0) goto L_0x0008;
            L_0x001c:
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = r0.siJ;
                r1 = com.tencent.mm.R.g.bGK;
                r0.setImageResource(r1);
                r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
                r1 = com.tencent.mm.R.l.eRj;
                r2 = new com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$13$1;
                r2.<init>();
                com.tencent.mm.sdk.platformtools.as.b(r0, r1, r2);
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r1 = 1;
                r0.oai = r1;
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0.bFM();
                r0 = "MicroMsg.TalkRoomUI";
                r1 = "micBtn pressed down";
                com.tencent.mm.sdk.platformtools.x.i(r0, r1);
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r2 = com.tencent.mm.sdk.platformtools.bi.Wz();
                r0.oak = r2;
                r0 = com.tencent.mm.plugin.talkroom.model.b.bFm();
                r0.bFz();
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0.aWF();
                goto L_0x0008;
            L_0x005f:
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = r0.oah;
                if (r0 == 0) goto L_0x0008;
            L_0x0067:
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.a(r0, r7);
                if (r0 != 0) goto L_0x0008;
            L_0x006f:
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = r0.oah;
                if (r0 == 0) goto L_0x0008;
            L_0x0077:
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0.oah = r4;
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = r0.oai;
                r1 = 5;
                if (r0 != r1) goto L_0x00a0;
            L_0x0085:
                r0 = "MicroMsg.TalkRoomUI";
                r1 = "cancel during seize-success prepare time";
                com.tencent.mm.sdk.platformtools.x.i(r0, r1);
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = r0.oal;
                r0.TN();
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = r0.oam;
                r0.TN();
            L_0x00a0:
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = r0.siJ;
                r1 = com.tencent.mm.R.g.bGJ;
                r0.setImageResource(r1);
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0.oai = r4;
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0.bFM();
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0 = r0.oaq;
                r0.TN();
                r0 = com.tencent.mm.plugin.talkroom.model.b.bFm();
                r0.bFA();
                r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
                r1 = com.tencent.mm.R.l.eRl;
                r2 = new com.tencent.mm.plugin.talkroom.ui.TalkRoomUI$13$2;
                r2.<init>();
                com.tencent.mm.sdk.platformtools.as.b(r0, r1, r2);
                r0 = com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.this;
                r0.aWF();
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.13.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
        this.siM = (TalkRoomVolumeMeter) findViewById(R.h.cYB);
        final a anonymousClass14 = new a() {
            public final void bFQ() {
                TalkRoomUI.this.onBackPressed();
            }
        };
        findViewById(R.h.cSN).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                a aVar = anonymousClass14;
                int action = motionEvent.getAction();
                if (action == 0) {
                    aVar.iTW = motionEvent.getX();
                    aVar.iTX = motionEvent.getY();
                    aVar.sjb = bi.Wz();
                    return true;
                }
                if (action == 1 || action == 3) {
                    float abs = Math.abs(motionEvent.getX() - aVar.iTW);
                    float y = aVar.iTX - motionEvent.getY();
                    if (y >= 100.0f && y / abs > 2.0f && y / ((float) bi.bB(aVar.sjb)) > 0.6f) {
                        aVar.bFQ();
                        return true;
                    }
                }
                return false;
            }
        });
        this.siN = (TalkRoomAvatarsFrame) findViewById(R.h.bLK);
        this.ikn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                TalkRoomUI.this.onBackPressed();
            }
        });
        this.siR = new AlphaAnimation(0.0f, 1.0f);
        this.siR.setDuration(300);
        this.siR.setFillAfter(true);
        this.siS = new AlphaAnimation(1.0f, 0.0f);
        this.siS.setDuration(300);
        this.siS.setFillAfter(true);
        this.siT = new AlphaAnimation(0.0f, 1.0f);
        this.siT.setDuration(300);
        this.siT.setFillAfter(true);
        this.siU = new AlphaAnimation(1.0f, 0.0f);
        this.siU.setDuration(300);
        this.siU.setFillAfter(true);
        as.CN().a(364, (e) this);
        x.d("MicroMsg.TalkRoomUI", "onCreate before getServer");
        b.bFm().a((o) this);
        x.d("MicroMsg.TalkRoomUI", "onCreate end");
    }

    protected void onResume() {
        super.onResume();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("isTalkroom", true).putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.acquire();
        this.ikn.setText(i.b(this, com.tencent.mm.plugin.talkroom.model.h.aA(this, this.oae), this.ikn.getTextSize()));
        b.bFl().sha.shf = true;
        b.bFl();
        x.v("MicroMsg.TalkRoomDisplayMgr", "yy dismissStatusBar");
        b.bFl();
        com.tencent.mm.plugin.talkroom.model.c.bFs();
        com.tencent.mm.sdk.b.b lnVar = new ln();
        lnVar.fDI.fDJ = true;
        com.tencent.mm.sdk.b.a.xmy.a(lnVar, getMainLooper());
        x.d("MicroMsg.TalkRoomUI", "TalkRoom req pause auto download logic");
    }

    protected void onPause() {
        super.onPause();
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), WXApp.WXAPP_BROADCAST_PERMISSION);
        this.wakeLock.release();
        this.oaq.TN();
        b.bFl().sha.shf = false;
        b.bFl();
        com.tencent.mm.plugin.talkroom.model.c cVar = b.bFl().sha;
        if (cVar.oad) {
            cVar.MU(ad.getContext().getString(R.l.eQY));
        } else if (bi.oN(cVar.nZA)) {
            cVar.MU(com.tencent.mm.plugin.talkroom.model.h.aA(ad.getContext(), b.bFm().shV));
        } else {
            String string = ad.getContext().getString(R.l.eRe, new Object[]{com.tencent.mm.y.r.gw(cVar.nZA)});
            com.tencent.mm.plugin.talkroom.model.c.bFs();
            cVar.MU(string);
        }
        com.tencent.mm.sdk.b.b lnVar = new ln();
        lnVar.fDI.fDJ = false;
        com.tencent.mm.sdk.b.a.xmy.a(lnVar, getMainLooper());
        x.d("MicroMsg.TalkRoomUI", "TalkRoom cancel pause auto download logic");
    }

    protected void onDestroy() {
        b.bFm().b((o) this);
        as.CN().b(364, (e) this);
        if (this.ioc != null && this.ioc.isShowing()) {
            this.ioc.cancel();
        }
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25) {
            as.Hn().fA(3);
            return true;
        } else if (i != 24) {
            return super.onKeyDown(i, keyEvent);
        } else {
            as.Hn().fz(3);
            return true;
        }
    }

    public final void aWH() {
        this.oad = false;
        this.siJ.setEnabled(true);
        this.siJ.setImageResource(R.g.bGJ);
        this.siK.setVisibility(0);
        aWF();
        bFO();
        bFN();
    }

    public final void M(String str, int i, int i2) {
        x.f("MicroMsg.TalkRoomUI", "onInitFailed %s", str);
        String str2 = "";
        if (i == 4) {
            if (i2 != -1) {
                this.oar = false;
                finish();
                return;
            }
            str2 = getString(R.l.eQV);
        }
        MZ(str2);
    }

    public final void sf(int i) {
        x.i("MicroMsg.TalkRoomUI", "onSeizeMicFailed");
        if (i == 340) {
            if (this.oai == 3) {
                this.oai = 4;
            } else {
                return;
            }
        } else if (this.oai == 1) {
            this.oai = 2;
        } else {
            return;
        }
        bFM();
        aWF();
        com.tencent.mm.sdk.platformtools.as.a(ad.getContext(), R.l.eRk, new com.tencent.mm.sdk.platformtools.as.a() {
            public final void vi() {
            }
        });
    }

    public final void aWI() {
        x.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess");
        if (this.oai == 1) {
            this.oai = 5;
            if (bi.bB(this.oak) < this.oaj) {
                x.i("MicroMsg.TalkRoomUI", "onSeizeMicSuccess waiting to execute");
                long bB = this.oaj - bi.bB(this.oak);
                this.oal.K(bB, bB);
                return;
            }
            aWE();
        }
    }

    private void aWE() {
        if (this.oai == 5) {
            this.oal.TN();
            aWF();
            bFM();
            com.tencent.mm.sdk.platformtools.as.b(ad.getContext(), R.l.eRh, new com.tencent.mm.sdk.platformtools.as.a() {
                public final void vi() {
                    TalkRoomUI.this.oam.TN();
                    TalkRoomUI.a(TalkRoomUI.this);
                }
            });
            this.oam.K(1000, 1000);
        }
    }

    public final void j(int i, int i2, String str) {
        x.f("MicroMsg.TalkRoomUI", "errType %d, errCode %d, errInfo %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        MZ("");
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if (kVar.getType() == 364 && this.ioc != null && this.ioc.isShowing()) {
            this.ioc.cancel();
        }
    }

    private void MZ(String str) {
        if (this.oar) {
            this.oar = false;
            b.bFm().aWG();
            if (bi.oN(str)) {
                if (ao.isConnected(getApplication())) {
                    str = getString(R.l.eQV);
                } else {
                    str = getString(R.l.eQW);
                }
            }
            if (!isFinishing()) {
                h.a((Context) this, str, "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        TalkRoomUI.this.finish();
                    }
                });
                return;
            }
            return;
        }
        x.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void Es(String str) {
        x.d("MicroMsg.TalkRoomUI", "onCurMember %s", str);
        this.oaf = str;
        bFM();
        aWF();
        if (bi.oN(str)) {
            this.oaq.TN();
            return;
        }
        com.tencent.mm.sdk.platformtools.as.b(ad.getContext(), R.l.eRi, new com.tencent.mm.sdk.platformtools.as.a() {
            public final void vi() {
            }
        });
        this.oaq.K(100, 100);
    }

    public final void aWJ() {
        if (this.oar) {
            this.oar = false;
            finish();
            return;
        }
        x.i("MicroMsg.TalkRoomUI", "alertToFinish has exit, ignore ");
    }

    public final void aWK() {
        aWF();
    }

    public final void aWL() {
        aWF();
    }

    public final void aWM() {
        c(getString(R.l.eQZ), R.e.btW);
    }

    private void bFN() {
        List<bot> aWi = b.bFm().aWi();
        List linkedList = new LinkedList();
        for (bot bot : aWi) {
            linkedList.add(bot.kyG);
        }
        TalkRoomAvatarsFrame talkRoomAvatarsFrame = this.siN;
        if (talkRoomAvatarsFrame.siC != null) {
            a aVar = talkRoomAvatarsFrame.siC;
            aVar.siG = linkedList;
            aVar.notifyDataSetChanged();
        }
    }

    public final void dm(String str, String str2) {
        x.i("MicroMsg.TalkRoomUI", "add %s,  del %s", str, str2);
        bFN();
        if (!this.oad) {
            bFO();
            if (!bi.oN(str)) {
                cp(getString(R.l.eQM, new Object[]{com.tencent.mm.y.r.gw(str)}), R.e.btV);
                this.oan.K(3000, 3000);
            }
            if (!bi.oN(str2)) {
                cp(getString(R.l.eQQ, new Object[]{com.tencent.mm.y.r.gw(str2)}), R.e.btV);
                this.oan.K(3000, 3000);
            }
        }
    }

    private void aWF() {
        if (!this.oad) {
            if (b.bFm().sij) {
                c(getString(R.l.eQX), R.e.btW);
                this.siN.MY(null);
                this.siL.setImageResource(R.g.bGF);
                bFP();
                return;
            }
            switch (this.oai) {
                case 0:
                    if (bi.oN(this.oaf)) {
                        CharSequence string;
                        if (b.bFm().aWi().size() == 1) {
                            string = getString(R.l.eRg);
                        } else {
                            string = "";
                        }
                        c(string, R.e.btV);
                        this.siN.MY(null);
                        this.siL.setImageResource(R.g.bGF);
                        bFP();
                        return;
                    }
                    cp(com.tencent.mm.y.r.gw(this.oaf), R.e.btV);
                    this.siN.MY(this.oaf);
                    this.siL.setImageResource(R.g.bGF);
                    yF(1);
                    return;
                case 1:
                    c(getString(R.l.eQL), R.e.btV);
                    this.siL.setImageResource(R.g.bGI);
                    return;
                case 2:
                    c(getString(R.l.eRa), R.e.btW);
                    this.siL.setImageResource(R.g.bGH);
                    return;
                case 3:
                case 5:
                    c(getString(R.l.eRb), R.e.btV);
                    this.siN.MY(q.FY());
                    this.siL.setImageResource(R.g.bGG);
                    yF(2);
                    return;
                case 4:
                    c(getString(R.l.eRd), R.e.btW);
                    this.siL.setImageResource(R.g.bGH);
                    bFP();
                    return;
                default:
                    return;
            }
        }
    }

    private void bFO() {
        x.i("MicroMsg.TalkRoomUI", "displayCount %d", Integer.valueOf(b.bFm().aWi().size()));
        this.nQV.setText(String.valueOf(r0));
    }

    private void cp(String str, int i) {
        c(i.b(this, str, this.siI.getTextSize()), i);
    }

    private void c(CharSequence charSequence, int i) {
        if (bi.oN(charSequence.toString())) {
            this.siI.startAnimation(this.siU);
            return;
        }
        this.siI.setTextColor(getResources().getColor(i));
        this.siI.setText(charSequence);
        this.siI.startAnimation(this.siT);
    }

    private void yF(int i) {
        if (i == 0 || this.oax != i) {
            this.oaw.setVisibility(0);
            this.oaw.startAnimation(this.siR);
            this.oaw.setBase(bi.Wz());
            this.oaw.start();
            this.oax = i;
        }
    }

    private void bFP() {
        if (this.oax != 0) {
            this.oaw.stop();
            this.oax = 0;
            this.oaw.startAnimation(this.siS);
        }
    }
}
