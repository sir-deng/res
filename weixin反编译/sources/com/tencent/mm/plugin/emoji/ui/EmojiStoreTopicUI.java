package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.bu.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;

public class EmojiStoreTopicUI extends BaseEmojiStoreUI {
    private int itU;
    private int lJB;
    private String lJC;
    private String lJD;
    private String lJE;
    private String lJF;
    private String lJG;

    static /* synthetic */ void c(EmojiStoreTopicUI emojiStoreTopicUI) {
        g gVar = new g(emojiStoreTopicUI.mController.xRr, g.zCt, false);
        gVar.rQF = new c() {
            public final void a(n nVar) {
                nVar.a(1001, EmojiStoreTopicUI.this.getString(R.l.eYv), R.k.dxb);
                nVar.a(1000, EmojiStoreTopicUI.this.getString(R.l.eYu), R.k.dwQ);
            }
        };
        gVar.rQG = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1000:
                        Context context = EmojiStoreTopicUI.this.mController.xRr;
                        String a = EmojiStoreTopicUI.this.lJC;
                        String e = EmojiStoreTopicUI.this.lJE;
                        String b = EmojiStoreTopicUI.this.lJD;
                        i.aCh();
                        k.a(context, a, e, b, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0", EmojiLogic.a(EmojiStoreTopicUI.this.lJB, EmojiStoreTopicUI.this.lJC, EmojiStoreTopicUI.this.lJE, EmojiStoreTopicUI.this.lJD, EmojiStoreTopicUI.this.lJF, 0), 13);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13224, Integer.valueOf(1), Integer.valueOf(1), "", Integer.valueOf(EmojiStoreTopicUI.this.lJB));
                        return;
                    case 1001:
                        k.cv(EmojiStoreTopicUI.this.mController.xRr);
                        EmojiStoreTopicUI.this.mController.xRr.overridePendingTransition(R.a.bqo, R.a.bqa);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13224, Integer.valueOf(1), Integer.valueOf(2), "", Integer.valueOf(EmojiStoreTopicUI.this.lJB));
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUX();
        com.tencent.mm.plugin.report.service.g.pWK.h(13224, Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(emojiStoreTopicUI.lJB));
    }

    protected final void aCN() {
        super.aCN();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.pWK.h(12740, Integer.valueOf(3), "", "", Integer.valueOf(this.lJB), Integer.valueOf(this.itU));
    }

    protected final void initView() {
        this.lJB = getIntent().getIntExtra("topic_id", -1);
        this.lJC = getIntent().getStringExtra("topic_name");
        this.lJF = getIntent().getStringExtra("topic_ad_url");
        this.lJD = getIntent().getStringExtra("topic_icon_url");
        this.lJE = getIntent().getStringExtra("topic_desc");
        this.lJG = getIntent().getStringExtra("sns_object_data");
        this.itU = getIntent().getIntExtra("extra_scence", 0);
        if (!bi.oN(this.lJG)) {
            this.lJB = EmojiLogic.yW(this.lJG);
            this.lJC = EmojiLogic.yX(this.lJG);
            this.lJD = EmojiLogic.yZ(this.lJG);
            this.lJE = EmojiLogic.yY(this.lJG);
            this.lJF = EmojiLogic.za(this.lJG);
        }
        setMMTitle(this.lJC);
        super.initView();
        addIconOptionMenu(0, R.k.dAb, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                x.d("MicroMsg.emoji.EmojiStoreTopicUI", "on shard click.");
                if (bi.oN(EmojiStoreTopicUI.this.lJC) || bi.oN(EmojiStoreTopicUI.this.lJD)) {
                    x.i("MicroMsg.emoji.EmojiStoreTopicUI", "name or url is null.");
                } else {
                    EmojiStoreTopicUI.c(EmojiStoreTopicUI.this);
                }
                return true;
            }
        });
        showOptionMenu(0, false);
        zj(this.lJF);
    }

    protected final void zj(String str) {
        if (this.lGc != null && this.lGd != null && !bi.oN(str)) {
            a.getDensity(this);
            EmojiInfo a = EmojiLogic.a("Toptic", 8, str, true);
            if (a == null) {
                o.PG().a(str, null, f.c("Toptic", str, "Toptic", "BANNER"), new com.tencent.mm.ap.a.c.i() {
                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        EmojiBaseActivity emojiBaseActivity = EmojiStoreTopicUI.this;
                        if (emojiBaseActivity.lHh != null) {
                            emojiBaseActivity.lHh.sendEmptyMessage(HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION);
                        }
                    }
                });
                return;
            }
            this.lGd.cY(a.clq(), null);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void a(com.tencent.mm.plugin.emoji.model.f fVar, boolean z, boolean z2) {
        super.a(fVar, z, z2);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        aDe();
        if (i == 2002 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bi.oN(stringExtra)) {
                x.d("MicroMsg.emoji.EmojiStoreTopicUI", ".." + stringExtra);
                int i3 = this.lJB;
                String str = this.lJC;
                String str2 = this.lJE;
                String str3 = this.lJD;
                String str4 = this.lJF;
                i.aCh();
                k.a(this, stringExtra, 26, i3, str, str2, str3, str4, 0, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void a(boolean z, com.tencent.mm.plugin.emoji.model.f fVar, boolean z2, boolean z3) {
        super.a(z, fVar, z2, z3);
    }

    protected final int aCX() {
        return 7;
    }

    public final int aCY() {
        return this.lJB;
    }

    protected final boolean aDf() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a aCQ() {
        return new com.tencent.mm.plugin.emoji.a.f(this.mController.xRr);
    }

    protected final boolean aCV() {
        if (bi.oN(this.lJF)) {
            return false;
        }
        return true;
    }

    protected final boolean aCU() {
        return false;
    }

    public final void l(Message message) {
        super.l(message);
        if (message.what == HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION) {
            zj(this.lJF);
        }
    }

    protected final int aCO() {
        return 11;
    }

    protected final int aCP() {
        return 14;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        super.a(i, i2, str, kVar);
        if (this.lGg) {
            showOptionMenu(0, false);
        } else {
            showOptionMenu(0, true);
        }
    }
}
