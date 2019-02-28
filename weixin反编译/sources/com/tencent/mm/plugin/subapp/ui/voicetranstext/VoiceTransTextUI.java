package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.kg;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class VoiceTransTextUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.VoiceTransTextUI";
    private long gBK;
    private int iN;
    private int jKi;
    private int jKj;
    private ScrollView jmE = null;
    private View lzm = null;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                VoiceTransTextUI.this.iY(true);
            } else if (i == 2) {
                VoiceTransTextUI.this.iY(false);
            }
        }
    };
    private Button moC = null;
    private long pFa = 0;
    private bl saY;
    private a sbe;
    private c sbf;
    private b sbg;
    private com.tencent.mm.modelvoice.b sbh;
    private volatile boolean sbj = false;
    private boolean sbk = false;
    private al sbl;
    private View sfk = null;
    private View sfl = null;
    private LinearLayout sfm = null;
    private TextView sfn = null;
    private int sfo = 6;
    private boolean sfp = false;
    private p sfq;
    private au sfr;
    private c sfs;
    private boolean sft = false;
    private boolean sfu = false;
    private int sfv;
    private OnTouchListener sfw;
    private OnClickListener sfx = new OnClickListener() {
        public final void onClick(View view) {
            VoiceTransTextUI.this.finish();
        }
    };
    private ClipboardManager sfy;
    private OnLongClickListener sfz = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            x.d("MicroMsg.VoiceTransTextUI", "onLongClick");
            h.a(VoiceTransTextUI.this, "", new String[]{VoiceTransTextUI.this.getString(R.l.dED)}, "", new h.c() {
                public final void jo(int i) {
                    if (i == 0 && VoiceTransTextUI.this.sfy != null && VoiceTransTextUI.this.sfn != null) {
                        VoiceTransTextUI.this.sfy.setText(VoiceTransTextUI.this.sfn.getText());
                    }
                }
            });
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.VoiceTransTextUI$9 */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] sfE = new int[a.bFb().length];
        static final /* synthetic */ int[] sfF = new int[b.bFc().length];

        static {
            try {
                sfF[b.sfL - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                sfF[b.sfM - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                sfF[b.sfN - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                sfE[a.sfG - 1] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                sfE[a.sfH - 1] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                sfE[a.sfI - 1] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                sfE[a.sfJ - 1] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private enum b {
        ;

        public static int[] bFc() {
            return (int[]) sfO.clone();
        }

        static {
            sfL = 1;
            sfM = 2;
            sfN = 3;
            sfO = new int[]{sfL, sfM, sfN};
        }
    }

    private enum a {
        ;

        public static int[] bFb() {
            return (int[]) sfK.clone();
        }

        static {
            sfG = 1;
            sfH = 2;
            sfI = 3;
            sfJ = 4;
            sfK = new int[]{sfG, sfH, sfI, sfJ};
        }
    }

    static /* synthetic */ void l(VoiceTransTextUI voiceTransTextUI) {
        voiceTransTextUI.jKi = 0;
        voiceTransTextUI.jKj = 0;
        voiceTransTextUI.sft = false;
        voiceTransTextUI.sfu = false;
        voiceTransTextUI.mHandler.removeMessages(0);
    }

    public void onCreate(Bundle bundle) {
        int i;
        bl blVar = null;
        super.onCreate(bundle);
        this.iN = ViewConfiguration.get(this.mController.xRr).getScaledTouchSlop();
        this.sfy = (ClipboardManager) getSystemService("clipboard");
        this.lzm = findViewById(R.h.cXl);
        this.sfk = findViewById(R.h.cXg);
        this.sfl = findViewById(R.h.cXk);
        this.sfn = (TextView) findViewById(R.h.cXi);
        this.moC = (Button) findViewById(R.h.cXh);
        this.sfm = (LinearLayout) findViewById(R.h.cXj);
        this.jmE = (ScrollView) findViewById(R.h.ckp);
        this.sfw = new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        VoiceTransTextUI.this.pFa = bi.Wz();
                        VoiceTransTextUI.this.jKi = view.getScrollY();
                        VoiceTransTextUI.this.jKj = VoiceTransTextUI.this.jKi;
                        VoiceTransTextUI.this.mHandler.removeMessages(0);
                        if (VoiceTransTextUI.this.sft) {
                            VoiceTransTextUI.this.sft = false;
                            VoiceTransTextUI.this.sfu = true;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                    case 4:
                        if (Math.abs(VoiceTransTextUI.this.jKj - view.getScrollY()) > VoiceTransTextUI.this.iN) {
                            VoiceTransTextUI.this.mHandler.sendMessage(VoiceTransTextUI.this.mHandler.obtainMessage(0, view));
                        }
                        if ((bi.Wz() - VoiceTransTextUI.this.pFa) < 800 && Math.abs(VoiceTransTextUI.this.jKj - view.getScrollY()) <= VoiceTransTextUI.this.iN && !VoiceTransTextUI.this.sfu) {
                            VoiceTransTextUI.this.mHandler.removeMessages(0);
                            VoiceTransTextUI.l(VoiceTransTextUI.this);
                            VoiceTransTextUI.this.finish();
                        }
                        VoiceTransTextUI.this.sfu = false;
                        break;
                }
                return false;
            }
        };
        this.sfn.setOnLongClickListener(this.sfz);
        this.sfn.setOnClickListener(this.sfx);
        this.gBK = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1);
        if (this.gBK < 0) {
            i = 0;
        } else {
            x.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", Long.valueOf(this.gBK));
            bm UL = m.UL();
            if (this.gBK >= 0) {
                bl blVar2 = new bl();
                Cursor a = UL.gLA.a("VoiceTransText", null, "msgId=?", new String[]{String.valueOf(r6)}, null, null, null, 2);
                if (a.moveToFirst()) {
                    blVar2.b(a);
                }
                a.close();
                blVar = blVar2;
            }
            this.saY = blVar;
            if (this.saY == null || bi.oN(this.saY.field_content)) {
                String string = getIntent().getExtras().getString("voice_trans_text_img_path");
                if (bi.oN(string)) {
                    i = 0;
                } else {
                    this.sfq = m.UK().oj(string);
                    if (this.sfq != null) {
                        x.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
                        i = 1;
                    } else {
                        as.Hm();
                        this.sfr = com.tencent.mm.y.c.Fh().dI(this.gBK);
                        if (this.sfr != null) {
                            x.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                }
            } else {
                x.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
                i = 1;
            }
        }
        if (i == 0) {
            x.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
            return;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dtU;
    }

    protected final void initView() {
        Object obj;
        setMMTitle(R.l.eUn);
        this.moC.setOnClickListener(this);
        if (this.saY == null || bi.oN(this.saY.field_content)) {
            obj = null;
        } else {
            aO(b.sfL, this.saY.field_content);
            if (!(this.jmE == null || this.sfm == null)) {
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        VoiceTransTextUI.this.jmE.setPadding(0, 0, 0, 0);
                        VoiceTransTextUI.this.sfm.setGravity(17);
                    }
                }, 5);
            }
            obj = 1;
        }
        if (obj == null) {
            aO(b.sfM, null);
            yA(a.sfG);
        }
    }

    private void yA(int i) {
        bEX();
        switch (AnonymousClass9.sfE[i - 1]) {
            case 1:
                x.i("MicroMsg.VoiceTransTextUI", "net check");
                if (wh() > 0) {
                    x.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", Long.valueOf(wh()));
                    this.sbe = new a(bEY(), bEZ(), bFa().getFormat(), wh(), getFileName());
                } else {
                    x.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", Long.valueOf(wh()));
                    this.sbe = new a(bEY(), bEZ(), getFileName());
                }
                as.CN().a(this.sbe, 0);
                as.CN().a(this.sbe.getType(), (e) this);
                if (this.sfs == null) {
                    if (this.sfs == null) {
                        this.sfs = new c<kg>() {
                            {
                                this.xmG = kg.class.getName().hashCode();
                            }

                            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                                kg kgVar = (kg) bVar;
                                x.i("MicroMsg.VoiceTransTextUI", "receive notify, process----> may be pass.");
                                if (VoiceTransTextUI.this.sbe != null && !VoiceTransTextUI.this.sbk && (kgVar instanceof kg) && kgVar.fCu.fCv == VoiceTransTextUI.this.sbe.sfi) {
                                    x.i("MicroMsg.VoiceTransTextUI", "");
                                    if (VoiceTransTextUI.this.sbj) {
                                        x.i("MicroMsg.VoiceTransTextUI", "has new result! but need wait. so, wait.");
                                        VoiceTransTextUI.this.sfp = true;
                                    } else {
                                        new ag(VoiceTransTextUI.this.getMainLooper()).post(new Runnable() {
                                            public final void run() {
                                                x.i("MicroMsg.VoiceTransTextUI", "notify has new trans, so pull");
                                                if (VoiceTransTextUI.this.sbl != null) {
                                                    VoiceTransTextUI.this.sbl.TN();
                                                }
                                                VoiceTransTextUI.this.yA(a.sfJ);
                                            }
                                        });
                                    }
                                }
                                return false;
                            }
                        };
                    }
                    com.tencent.mm.sdk.b.a.xmy.b(this.sfs);
                    return;
                }
                return;
            case 2:
                x.i("MicroMsg.VoiceTransTextUI", "net upload");
                if (this.sbe == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
                    return;
                } else if (bFa() == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
                    return;
                } else {
                    this.sbf = new c(bEY(), this.sbe.sfg, bFa().getFormat(), getFileName());
                    as.CN().a(this.sbf, 0);
                    as.CN().a(this.sbf.getType(), (e) this);
                    return;
                }
            case 3:
                x.i("MicroMsg.VoiceTransTextUI", "net upload more");
                if (this.sbf == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
                    return;
                }
                this.sbf = new c(this.sbf);
                as.CN().a(this.sbf, 0);
                as.CN().a(this.sbf.getType(), (e) this);
                return;
            case 4:
                this.sfp = false;
                if (this.sbj) {
                    x.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
                    return;
                }
                x.i("MicroMsg.VoiceTransTextUI", "net get");
                if (this.sbe == null) {
                    x.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
                    return;
                }
                this.sbj = true;
                this.sbg = new b(bEY());
                as.CN().a(this.sbg, 0);
                as.CN().a(this.sbg.getType(), (e) this);
                return;
            default:
                return;
        }
    }

    private void aO(int i, String str) {
        while (true) {
            CharSequence str2;
            switch (AnonymousClass9.sfF[i - 1]) {
                case 1:
                    if (!bi.oN(str2)) {
                        this.sfm.setVisibility(0);
                        this.sfk.setVisibility(8);
                        this.moC.setVisibility(4);
                        this.sfl.setVisibility(8);
                        this.sfn.setText(str2);
                        iY(true);
                        break;
                    }
                    i = b.sfN;
                    str2 = null;
                case 2:
                    this.sfm.setVisibility(0);
                    this.sfk.setVisibility(0);
                    this.moC.setVisibility(0);
                    if (str2 != null) {
                        this.sfn.setText(str2);
                        iY(false);
                        break;
                    }
                    break;
                case 3:
                    this.sfm.setVisibility(8);
                    this.sfk.setVisibility(8);
                    this.moC.setHeight(0);
                    this.moC.setVisibility(8);
                    this.sfl.setVisibility(0);
                    break;
                default:
                    break;
            }
        }
        if (i == b.sfL || i == b.sfN) {
            this.jmE.setOnTouchListener(this.sfw);
            this.lzm.setOnClickListener(this.sfx);
            return;
        }
        this.jmE.setOnTouchListener(null);
        this.lzm.setOnClickListener(null);
    }

    private void bEX() {
        x.d("MicroMsg.VoiceTransTextUI", "cancel all net");
        if (this.sbe != null) {
            as.CN().c(this.sbe);
            as.CN().b(this.sbe.getType(), (e) this);
        }
        if (this.sbf != null) {
            as.CN().c(this.sbf);
            as.CN().b(this.sbf.getType(), (e) this);
        }
        if (this.sbg != null) {
            as.CN().c(this.sbg);
            as.CN().b(this.sbg.getType(), (e) this);
        }
    }

    private String bEY() {
        if (this.sfq != null) {
            return this.sfq.clientId;
        }
        return this.sfr.field_talker + this.sfr.field_msgId + "T" + this.sfr.field_createTime;
    }

    private int bEZ() {
        if (this.sfq != null) {
            return this.sfq.hmZ;
        }
        return o.nz(this.sfr.field_imgPath);
    }

    private long wh() {
        return this.sfq == null ? -1 : this.sfq.fGj;
    }

    private String getFileName() {
        if (this.sfq != null) {
            return this.sfq.fileName;
        }
        return this.sfr.field_imgPath;
    }

    private com.tencent.mm.modelvoice.b bFa() {
        if (this.sbh == null) {
            if (this.sfq != null) {
                this.sbh = q.nX(this.sfq.fileName);
            } else if (this.sfr != null) {
                this.sbh = q.nX(this.sfr.field_imgPath);
            } else {
                x.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
            }
        }
        return this.sbh;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = null;
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 546:
                    if (this.sbe.mState == a.sfe) {
                        x.i("MicroMsg.VoiceTransTextUI", "check result: done");
                        if (this.sbe.bEU()) {
                            str2 = this.sbe.sff.xcd;
                        }
                        MT(str2);
                        return;
                    } else if (this.sbe.mState == a.sfd) {
                        if (this.sbe.sff != null && bi.oN(this.sbe.sff.xcd)) {
                            aO(b.sfM, this.sbe.sff.xcd);
                        }
                        x.i("MicroMsg.VoiceTransTextUI", "check result: processing");
                        yA(a.sfJ);
                        return;
                    } else if (this.sbe.mState == a.sfc) {
                        x.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
                        yA(a.sfH);
                        return;
                    } else if (this.sbe.sfh != null) {
                        this.sfo = this.sbe.sfh.wOD;
                        return;
                    } else {
                        return;
                    }
                case 547:
                    if (this.sbf.bEW()) {
                        x.i("MicroMsg.VoiceTransTextUI", "succeed upload");
                        yA(a.sfJ);
                        return;
                    }
                    x.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", Integer.valueOf(this.sbf.sfg.vPt), Integer.valueOf(this.sbf.sfg.vPu));
                    yA(a.sfI);
                    return;
                case 548:
                    this.sfo = this.sbg.sfj;
                    this.sbj = false;
                    if (!this.sbg.isComplete() && this.sbg.bEU()) {
                        aO(b.sfM, this.sbg.sff.xcd);
                        x.d("MicroMsg.VoiceTransTextUI", "result valid:%s", this.sbg.sff.xcd);
                    } else if (!this.sbg.bEU()) {
                        x.d("MicroMsg.VoiceTransTextUI", "result not valid");
                    }
                    if (this.sbg.isComplete()) {
                        x.i("MicroMsg.VoiceTransTextUI", "succeed get");
                        if (this.sbg.bEU()) {
                            str2 = this.sbg.sff.xcd;
                        }
                        MT(str2);
                        return;
                    } else if (this.sfp) {
                        x.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
                        yA(a.sfJ);
                        return;
                    } else {
                        x.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", Integer.valueOf(this.sfo));
                        final int i3 = this.sfo;
                        if (!this.sbk) {
                            if (this.sbl == null) {
                                this.sbl = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                                    public final boolean uG() {
                                        if (!VoiceTransTextUI.this.sbk) {
                                            x.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", Integer.valueOf(i3));
                                            VoiceTransTextUI.this.yA(a.sfJ);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            long j = (long) (i3 * 1000);
                            this.sbl.K(j, j);
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
        this.sbk = true;
        aO(b.sfN, null);
    }

    private void MT(String str) {
        this.sbk = true;
        if (!bi.oN(str)) {
            bm UL = m.UL();
            bl blVar = new bl();
            blVar.field_msgId = this.gBK;
            blVar.Yu(bEY());
            blVar.field_content = str;
            UL.a(blVar);
        }
        aO(b.sfL, str);
    }

    protected void onDestroy() {
        bEX();
        if (this.sbl != null) {
            this.sbl.TN();
        }
        if (this.sfs != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.sfs);
            this.sfs = null;
        }
        super.onDestroy();
    }

    public void onClick(View view) {
        finish();
    }

    private void iY(final boolean z) {
        if (this.jmE != null && this.sfm != null) {
            this.mHandler.postDelayed(new Runnable() {
                public final void run() {
                    if (VoiceTransTextUI.this.jmE.getMeasuredHeight() >= VoiceTransTextUI.this.sfm.getMeasuredHeight()) {
                        VoiceTransTextUI.this.jmE.fullScroll(130);
                        int scrollY = VoiceTransTextUI.this.jmE.getScrollY();
                        VoiceTransTextUI.this.sfv = VoiceTransTextUI.this.jmE.getPaddingTop();
                        VoiceTransTextUI.this.sfv = VoiceTransTextUI.this.sfv - scrollY;
                        if (z) {
                            VoiceTransTextUI.this.jmE.setPadding(0, 0, 0, 0);
                            VoiceTransTextUI.this.moC.setVisibility(8);
                            VoiceTransTextUI.this.moC.setHeight(0);
                        } else if (VoiceTransTextUI.this.sfv > 0) {
                            VoiceTransTextUI.this.jmE.setPadding(0, VoiceTransTextUI.this.sfv, 0, 0);
                        }
                    }
                }
            }, 5);
        }
    }
}
