package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.cr;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;

public class EmojiStoreV2SingleProductDialogUI extends MMBaseActivity {
    private String beo;
    public String gBJ;
    private i ien;
    private int itU;
    private long lDA;
    private a lDh = new a() {
        public final void h(EmojiInfo emojiInfo) {
            if (emojiInfo == null || EmojiStoreV2SingleProductDialogUI.this.lMH == null || !EmojiStoreV2SingleProductDialogUI.this.lMH.wgP.equals(emojiInfo.Nx())) {
                x.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "somethings error.");
            } else {
                EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this);
            }
        }
    };
    private sf lMH = new sf();
    private EmojiInfo lMI;
    private View lMJ;
    private MMAnimateView lMK;
    private ImageView lML;
    private Button lMM;
    private Button lMN;
    private OnClickListener lMO = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            EmojiStoreV2SingleProductDialogUI.a(EmojiStoreV2SingleProductDialogUI.this, EmojiStoreV2SingleProductDialogUI.this.lMH);
            g gVar = g.pWK;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.itU);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = EmojiStoreV2SingleProductDialogUI.this.lMH == null ? "" : EmojiStoreV2SingleProductDialogUI.this.lMH.wgP;
            objArr[3] = Long.valueOf(EmojiStoreV2SingleProductDialogUI.this.lDA);
            gVar.h(12787, objArr);
        }
    };
    private OnClickListener lMP = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            EmojiStoreV2SingleProductDialogUI.b(EmojiStoreV2SingleProductDialogUI.this, EmojiStoreV2SingleProductDialogUI.this.lMH);
            g gVar = g.pWK;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(EmojiStoreV2SingleProductDialogUI.this.itU);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = EmojiStoreV2SingleProductDialogUI.this.lMH == null ? "" : EmojiStoreV2SingleProductDialogUI.this.lMH.wgP;
            objArr[3] = Long.valueOf(EmojiStoreV2SingleProductDialogUI.this.lDA);
            gVar.h(12787, objArr);
        }
    };
    private View.OnClickListener lMQ = new View.OnClickListener() {
        public final void onClick(View view) {
            EmojiStoreV2SingleProductDialogUI.this.setResult(0);
            EmojiStoreV2SingleProductDialogUI.this.finish();
            EmojiStoreV2SingleProductDialogUI.this.overridePendingTransition(R.a.bqk, R.a.bql);
        }
    };
    private com.tencent.mm.ap.a.c.i lMR = new com.tencent.mm.ap.a.c.i() {
        public final void a(String str, Bitmap bitmap, Object... objArr) {
            if (bitmap != null && objArr != null && objArr.length > 0 && EmojiStoreV2SingleProductDialogUI.this.mHandler != null && objArr[0] != null && (objArr[0] instanceof sf)) {
                sf sfVar = (sf) objArr[0];
                if (EmojiStoreV2SingleProductDialogUI.this.lMH != null && sfVar != null && sfVar.wgP.equals(EmojiStoreV2SingleProductDialogUI.this.lMH.wgP)) {
                    EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this);
                }
            }
        }
    };
    private c lMS = new c<cr>() {
        {
            this.xmG = cr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cr crVar = (cr) bVar;
            if (crVar != null && (crVar instanceof cr) && EmojiStoreV2SingleProductDialogUI.this.lMH != null && crVar.frL.frM.equals(EmojiStoreV2SingleProductDialogUI.this.lMH.wgP)) {
                EmojiStoreV2SingleProductDialogUI.e(EmojiStoreV2SingleProductDialogUI.this);
            }
            return false;
        }
    };
    private ProgressBar lvk;
    private ag mHandler = new ag();

    static /* synthetic */ void a(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI, sf sfVar) {
        if (bi.oN(emojiStoreV2SingleProductDialogUI.gBJ)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("Retr_Msg_Type", 5);
            intent.putExtra("Retr_Msg_thumb_path", sfVar.wgP);
            intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
            d.a((Context) emojiStoreV2SingleProductDialogUI, ".ui.transmit.SelectConversationUI", intent, 9001);
            emojiStoreV2SingleProductDialogUI.overridePendingTransition(R.a.bqo, R.a.bqa);
            return;
        }
        emojiStoreV2SingleProductDialogUI.a(emojiStoreV2SingleProductDialogUI.gBJ, sfVar);
    }

    static /* synthetic */ void b(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI, sf sfVar) {
        if (sfVar != null) {
            EmojiInfo YB = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(sfVar.wgP);
            as.Hm();
            String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), sfVar.vPI, sfVar.wgP);
            if (YB == null && e.bO(I)) {
                int i = p.Vw(I) ? EmojiInfo.xIP : EmojiInfo.xIO;
                EmojiInfo emojiInfo = new EmojiInfo();
                emojiInfo.field_md5 = sfVar.wgP;
                emojiInfo.field_catalog = EmojiInfo.xIH;
                emojiInfo.field_type = i;
                emojiInfo.field_size = e.bN(I);
                emojiInfo.field_temp = 1;
                emojiInfo.field_designerID = sfVar.wgQ;
                emojiInfo.field_thumbUrl = sfVar.phv;
                com.tencent.mm.plugin.emoji.model.i.aCl().lCw.n(emojiInfo);
                YB = emojiInfo;
            }
            if (YB != null) {
                com.tencent.mm.plugin.emoji.model.i.aCh().a(emojiStoreV2SingleProductDialogUI, YB, 5, q.FY());
                return;
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "add failed");
    }

    static /* synthetic */ void e(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        if (emojiStoreV2SingleProductDialogUI.mHandler != null) {
            emojiStoreV2SingleProductDialogUI.mHandler.post(new Runnable() {
                public final void run() {
                    EmojiStoreV2SingleProductDialogUI.this.lvk.setVisibility(8);
                    EmojiStoreV2SingleProductDialogUI.this.lMK.setVisibility(0);
                    EmojiStoreV2SingleProductDialogUI.this.lMI = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(EmojiStoreV2SingleProductDialogUI.this.lMH.wgP);
                    if (EmojiStoreV2SingleProductDialogUI.this.lMI == null || (EmojiStoreV2SingleProductDialogUI.this.lMI.field_reserved4 & EmojiInfo.xJc) != EmojiInfo.xJc) {
                        EmojiStoreV2SingleProductDialogUI.this.lMK.cY(EmojiStoreV2SingleProductDialogUI.this.beo, null);
                    } else {
                        EmojiStoreV2SingleProductDialogUI.this.lMK.g(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(EmojiStoreV2SingleProductDialogUI.this.lMI), "");
                    }
                    EmojiStoreV2SingleProductDialogUI.this.aDS();
                    EmojiStoreV2SingleProductDialogUI.this.lMM.setEnabled(true);
                    EmojiStoreV2SingleProductDialogUI.this.lMM.setTextColor(EmojiStoreV2SingleProductDialogUI.this.getResources().getColor(R.e.bsE));
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        View view;
        String str;
        i.a aVar;
        i ale;
        com.tencent.mm.ap.a.a aBL;
        String str2;
        super.onCreate(bundle);
        setContentView(R.i.bHc);
        this.itU = getIntent().getIntExtra("scene", 0);
        this.lDA = getIntent().getLongExtra("searchID", 0);
        this.gBJ = getIntent().getStringExtra("Select_Conv_User");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("extra_object");
        if (byteArrayExtra != null) {
            try {
                this.lMH = (sf) this.lMH.aH(byteArrayExtra);
                if (this.lMH != null) {
                    this.lMI = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(this.lMH.wgP);
                    if (!(this.lMI == null || bi.oN(this.lMI.field_groupId) || !bi.oN(this.lMH.vPI))) {
                        this.lMH.vPI = this.lMI.field_groupId;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", e, "", new Object[0]);
            }
            com.tencent.mm.sdk.b.a.xmy.b(this.lMS);
            com.tencent.mm.plugin.emoji.model.i.aCf().lDh = this.lDh;
            this.lMJ = v.fw(this).inflate(R.i.dgh, null);
            this.lvk = (ProgressBar) this.lMJ.findViewById(R.h.cce);
            this.lMK = (MMAnimateView) this.lMJ.findViewById(R.h.ccc);
            this.lML = (ImageView) this.lMJ.findViewById(R.h.cbZ);
            this.lML.setOnClickListener(this.lMQ);
            view = this.lMJ;
            str = "";
            if ((this instanceof Activity) || !isFinishing()) {
                aVar = new i.a(this);
                aVar.Zm(str);
                aVar.dk(view);
                aVar.mp(true);
                ale = aVar.ale();
                ale.show();
                h.a(this, ale);
            } else {
                ale = null;
            }
            this.ien = ale;
            this.ien.a(getString(R.l.dGL), false, this.lMO);
            this.ien.b(getString(R.l.dDW), false, this.lMP);
            this.ien.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    EmojiStoreV2SingleProductDialogUI.this.setResult(0);
                    EmojiStoreV2SingleProductDialogUI.this.finish();
                }
            });
            this.lMM = this.ien.getButton(-1);
            this.lMM.setTextColor(getResources().getColor(R.e.bsE));
            this.lMN = this.ien.getButton(-2);
            as.Hm();
            this.beo = EmojiLogic.I(com.tencent.mm.y.c.Fw(), this.lMH.vPI, this.lMH.wgP);
            if (e.bN(this.beo) <= 0) {
                this.lMK.setVisibility(0);
                this.lvk.setVisibility(8);
                this.lMI = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(this.lMH.wgP);
                if (this.lMI == null && (this.lMI.field_reserved4 & EmojiInfo.xJc) == EmojiInfo.xJc) {
                    this.lMK.g(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.lMI), "");
                } else {
                    this.lMK.cY(this.beo, null);
                }
                aDS();
            }
            this.lMK.setVisibility(8);
            this.lvk.setVisibility(0);
            this.lMN.setText(R.l.eax);
            this.lMM.setText(R.l.dGL);
            this.lMN.setEnabled(false);
            this.lMN.setTextColor(getResources().getColor(R.e.bsG));
            this.lMM.setEnabled(false);
            this.lMM.setTextColor(getResources().getColor(R.e.bsG));
            aBL = com.tencent.mm.plugin.emoji.model.i.aBL();
            str2 = this.lMH.nlE;
            str = this.lMH.nlE;
            aBL.a(str2, null, f.h(this.beo, this.lMH), this.lMR);
            return;
        }
        setResult(0);
        finish();
        com.tencent.mm.sdk.b.a.xmy.b(this.lMS);
        com.tencent.mm.plugin.emoji.model.i.aCf().lDh = this.lDh;
        this.lMJ = v.fw(this).inflate(R.i.dgh, null);
        this.lvk = (ProgressBar) this.lMJ.findViewById(R.h.cce);
        this.lMK = (MMAnimateView) this.lMJ.findViewById(R.h.ccc);
        this.lML = (ImageView) this.lMJ.findViewById(R.h.cbZ);
        this.lML.setOnClickListener(this.lMQ);
        view = this.lMJ;
        str = "";
        if (this instanceof Activity) {
        }
        aVar = new i.a(this);
        aVar.Zm(str);
        aVar.dk(view);
        aVar.mp(true);
        ale = aVar.ale();
        ale.show();
        h.a(this, ale);
        this.ien = ale;
        this.ien.a(getString(R.l.dGL), false, this.lMO);
        this.ien.b(getString(R.l.dDW), false, this.lMP);
        this.ien.setOnDismissListener(/* anonymous class already generated */);
        this.lMM = this.ien.getButton(-1);
        this.lMM.setTextColor(getResources().getColor(R.e.bsE));
        this.lMN = this.ien.getButton(-2);
        as.Hm();
        this.beo = EmojiLogic.I(com.tencent.mm.y.c.Fw(), this.lMH.vPI, this.lMH.wgP);
        if (e.bN(this.beo) <= 0) {
            this.lMK.setVisibility(8);
            this.lvk.setVisibility(0);
            this.lMN.setText(R.l.eax);
            this.lMM.setText(R.l.dGL);
            this.lMN.setEnabled(false);
            this.lMN.setTextColor(getResources().getColor(R.e.bsG));
            this.lMM.setEnabled(false);
            this.lMM.setTextColor(getResources().getColor(R.e.bsG));
            aBL = com.tencent.mm.plugin.emoji.model.i.aBL();
            str2 = this.lMH.nlE;
            str = this.lMH.nlE;
            aBL.a(str2, null, f.h(this.beo, this.lMH), this.lMR);
            return;
        }
        this.lMK.setVisibility(0);
        this.lvk.setVisibility(8);
        this.lMI = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(this.lMH.wgP);
        if (this.lMI == null) {
        }
        this.lMK.cY(this.beo, null);
        aDS();
    }

    protected void onResume() {
        super.onResume();
        aDS();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9001 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bi.oN(stringExtra) && this.lMH != null) {
                x.d("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "UserName:%s ,MD5:%s", stringExtra, this.lMH.wgP);
                a(stringExtra, this.lMH);
                com.tencent.mm.plugin.messenger.a.f.aZN().dq(intent.getStringExtra("custom_send_text"), stringExtra);
            }
        }
    }

    private void aDS() {
        this.lMI = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(this.lMH.wgP);
        if (this.lMI != null && this.lMI.field_catalog == EmojiGroupInfo.xIG && bi.oN(this.lMI.field_groupId)) {
            this.lMN.setEnabled(false);
            this.lMN.setText(R.l.dDW);
            this.lMN.setTextColor(getResources().getColor(R.e.bsG));
        } else if (e.bO(this.beo)) {
            this.lMN.setEnabled(true);
            this.lMN.setText(R.l.eax);
            this.lMN.setTextColor(getResources().getColor(R.e.bsE));
        } else {
            this.lMN.setEnabled(false);
            this.lMN.setEnabled(false);
            this.lMN.setText(R.l.eax);
            this.lMN.setTextColor(getResources().getColor(R.e.bsG));
        }
    }

    private void a(String str, sf sfVar) {
        if (bi.oN(str) || sfVar == null) {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "username or emoji is null.");
            return;
        }
        EmojiInfo emojiInfo;
        EmojiInfo YB = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(sfVar.wgP);
        if (YB == null) {
            as.Hm();
            String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), sfVar.vPI, sfVar.wgP);
            if (e.bO(I)) {
                YB = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.b(sfVar.wgP, "", EmojiInfo.xIH, p.Vw(I) ? EmojiInfo.xIP : EmojiInfo.xIO, e.bN(I), "");
                YB.field_designerID = sfVar.wgQ;
                YB.field_thumbUrl = sfVar.phv;
            }
            emojiInfo = YB;
        } else {
            YB.field_designerID = sfVar.wgQ;
            YB.field_thumbUrl = sfVar.phv;
            emojiInfo = YB;
        }
        for (String str2 : bi.F(bi.aD(str, "").split(","))) {
            if (emojiInfo != null) {
                com.tencent.mm.plugin.emoji.model.i.aCh().a(str2, emojiInfo, null);
                setResult(-1);
                finish();
                overridePendingTransition(R.a.bqk, R.a.bql);
            }
        }
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.lMS);
        com.tencent.mm.plugin.emoji.model.i.aCf().lDh = null;
        super.onDestroy();
    }
}
