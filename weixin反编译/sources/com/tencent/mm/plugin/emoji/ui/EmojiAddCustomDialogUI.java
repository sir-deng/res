package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.eo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.tools.a.b;
import com.tencent.mm.ui.tools.a.b.a;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.List;

public class EmojiAddCustomDialogUI extends MMBaseActivity implements e {
    private int itU;
    private String jfL;
    private String lHb;
    private EmojiInfo lHc;
    private i lHd;
    private i lHe;
    private ProgressDialog lzx;
    private Context mContext;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(R.l.ebv));
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        emojiAddCustomDialogUI.getString(R.l.dGZ);
        emojiAddCustomDialogUI.lzx = h.a((Context) emojiAddCustomDialogUI, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        this.mContext = this;
        this.jfL = getIntent().getStringExtra("extra_id");
        this.itU = getIntent().getIntExtra("extra_scence", -1);
        this.lHb = getIntent().getStringExtra("extra_username");
        if (bi.oN(this.jfL)) {
            x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
            finish();
        }
        this.lHc = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(this.jfL);
        as.CN().a(698, (e) this);
        as.CN().a(423, (e) this);
        as.CN().a(703, (e) this);
        this.mHandler.sendEmptyMessageDelayed(1001, 300);
        Context context = this.mContext;
        final EmojiInfo emojiInfo = this.lHc;
        if (context == null) {
            x.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
        } else if (emojiInfo == null) {
            x.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
        } else {
            b aaJ = b.aaJ(emojiInfo.clq());
            aaJ.hX = com.tencent.mm.j.b.zK();
            aaJ.Hf(com.tencent.mm.j.b.zL()).a(new a() {
                public final void a(b bVar) {
                    if (com.tencent.mm.plugin.emoji.model.i.aCl().lCw.lP(false) >= n.aBU()) {
                        x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
                        EmojiAddCustomDialogUI.this.aDe();
                        EmojiAddCustomDialogUI.this.aDn();
                        g.pWK.h(10431, Integer.valueOf(EmojiAddCustomDialogUI.this.itU), EmojiAddCustomDialogUI.this.lHc.Nx(), EmojiAddCustomDialogUI.this.lHc.field_designerID, EmojiAddCustomDialogUI.this.lHc.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.this.lHc.field_size), EmojiAddCustomDialogUI.this.lHb, EmojiAddCustomDialogUI.this.lHc.field_activityid);
                    } else if (emojiInfo.field_catalog == EmojiInfo.xIN || bi.oN(emojiInfo.field_groupId) || (!bi.oN(emojiInfo.field_groupId) && ((c) com.tencent.mm.kernel.g.k(c.class)).getEmojiMgr().yL(emojiInfo.field_groupId))) {
                        EmojiAddCustomDialogUI.i(emojiInfo);
                    } else {
                        as.CN().a(new com.tencent.mm.plugin.emoji.f.g(emojiInfo.field_groupId, (byte) 0), 0);
                    }
                }

                public final void aDo() {
                    EmojiAddCustomDialogUI.this.aDe();
                    EmojiAddCustomDialogUI.this.lHd = h.a(EmojiAddCustomDialogUI.this.mContext, EmojiAddCustomDialogUI.this.mContext.getString(R.l.dZV), "", EmojiAddCustomDialogUI.this.getString(R.l.epx), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            EmojiAddCustomDialogUI.this.finish();
                        }
                    });
                    g.pWK.h(10431, Integer.valueOf(EmojiAddCustomDialogUI.this.itU), EmojiAddCustomDialogUI.this.lHc.Nx(), EmojiAddCustomDialogUI.this.lHc.field_designerID, EmojiAddCustomDialogUI.this.lHc.field_groupId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(EmojiAddCustomDialogUI.this.lHc.field_size), EmojiAddCustomDialogUI.this.lHb, EmojiAddCustomDialogUI.this.lHc.field_activityid);
                }
            });
        }
    }

    protected void onDestroy() {
        as.CN().b(698, (e) this);
        as.CN().b(423, (e) this);
        as.CN().b(703, (e) this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        if (type == 698) {
            if (i2 == -434) {
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
                aDe();
                aDn();
                g.pWK.h(10431, Integer.valueOf(this.itU), this.lHc.Nx(), this.lHc.field_designerID, this.lHc.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.lHc.field_size), this.lHb, this.lHc.field_activityid);
            } else if (i == 0 && i2 == 0) {
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
                eo eoVar = (eo) ((com.tencent.mm.plugin.emoji.f.c) kVar).gLB.hnR.hnY;
                if (eoVar == null || eoVar.vQD == null || eoVar.vQD.size() <= 0) {
                    aDm();
                    return;
                }
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", Integer.valueOf(eoVar.vQD.size()));
                eoVar.vQD.get(0);
                as.CN().a(new f(this.lHc), 0);
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
            } else {
                aDl();
            }
        } else if (type == 423) {
            com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) kVar;
            if (gVar == null || bi.oN(gVar.lEs) || this.lHc == null || bi.oN(this.lHc.field_groupId) || !this.lHc.field_groupId.equalsIgnoreCase(gVar.lEs)) {
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                i(this.lHc);
            } else if (i2 == 4) {
                aDe();
                zk(getString(R.l.dZL));
            } else if (i2 == 8) {
                aDe();
                zk(getString(R.l.dZK));
            } else if (i2 == 9) {
                aDe();
                zk(getString(R.l.dZJ));
            } else if (i2 == -2) {
                aDe();
                zk(getString(R.l.dZM));
            } else {
                aDe();
                zk(getString(R.l.dZI));
            }
        } else if (type != 703) {
        } else {
            if (i == 0 && i2 == 0) {
                aDm();
            } else {
                aDl();
            }
        }
    }

    private void aDl() {
        x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
        aDe();
        h.bu(this.mContext, ad.getContext().getString(R.l.dZI));
        g.pWK.h(10431, Integer.valueOf(this.itU), this.lHc.Nx(), this.lHc.field_designerID, this.lHc.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(this.lHc.field_size), this.lHb, this.lHc.field_activityid);
        finish();
    }

    private void aDm() {
        x.d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
        if (this.lHc.field_catalog != EmojiInfo.xIN) {
            this.lHc.field_catalog = EmojiInfo.xIN;
            int clx = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.clx();
            if (clx < n.aBU()) {
                clx = n.aBU();
            } else {
                clx++;
            }
            this.lHc.field_reserved3 = clx;
            com.tencent.mm.plugin.emoji.model.i.aCl().lCw.p(this.lHc);
            g.pWK.h(10431, Integer.valueOf(this.itU), this.lHc.Nx(), this.lHc.field_designerID, this.lHc.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.lHc.field_size), this.lHb, this.lHc.field_activityid);
            com.tencent.mm.plugin.emoji.e.e.aBy().c(this.lHc, false);
        }
        String str = this.lHc.clq() + "_cover";
        if (!(bi.oN(this.lHc.field_thumbUrl) || com.tencent.mm.a.e.bO(str))) {
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFn = str;
            aVar.hFl = true;
            aVar.hFj = false;
            o.PG().a(this.lHc.field_thumbUrl, null, aVar.PQ());
        }
        com.tencent.mm.storage.emotion.a aVar2 = com.tencent.mm.plugin.emoji.model.i.aCl().lCx;
        if (!com.tencent.mm.storage.emotion.a.ckW()) {
            com.tencent.mm.plugin.emoji.model.i.aCl().lCx.ckX();
        }
        aDe();
        h.bu(this.mContext, ad.getContext().getString(R.l.dDW));
        finish();
    }

    private static void i(EmojiInfo emojiInfo) {
        x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate ");
        List arrayList = new ArrayList();
        arrayList.add(emojiInfo.Nx());
        as.CN().a(new com.tencent.mm.plugin.emoji.f.c(1, arrayList), 0);
    }

    private void aDn() {
        this.lHd = h.a(this.mContext, R.l.ebL, R.l.dEU, R.l.eaO, R.l.dEy, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                g.pWK.h(11596, Integer.valueOf(3));
                intent.setClass(EmojiAddCustomDialogUI.this.mContext, EmojiCustomUI.class);
                EmojiAddCustomDialogUI.this.startActivity(intent);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                EmojiAddCustomDialogUI.this.finish();
            }
        });
        if (this.lHd != null) {
            this.lHd.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    EmojiAddCustomDialogUI.this.finish();
                }
            });
        }
    }

    private void zk(String str) {
        this.lHe = h.b(this, str, "", true);
        this.lHe.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                EmojiAddCustomDialogUI.this.finish();
            }
        });
    }

    protected final void aDe() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1001);
        }
        if (this.lzx != null && this.lzx.isShowing()) {
            this.lzx.dismiss();
        }
    }
}
