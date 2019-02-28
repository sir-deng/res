package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.e;
import com.tencent.mm.ap.a.c.i;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.cr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FTSEmojiDetailPageUI extends MMActivity implements e {
    private String designerName;
    private String fCV;
    private int fqY;
    private String frQ;
    private String fvS;
    private int hfV;
    private l jAo;
    private ProgressBar ksa;
    private EmojiInfo kvY;
    private String lDB;
    private a lDu = new a() {
        public final void h(EmojiInfo emojiInfo) {
            if (emojiInfo == null || FTSEmojiDetailPageUI.this.kvY == null || !FTSEmojiDetailPageUI.this.kvY.Nx().equals(emojiInfo.Nx())) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
                return;
            }
            x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", FTSEmojiDetailPageUI.this.kvY.Nx());
            ah.y(new Runnable() {
                public final void run() {
                    FTSEmojiDetailPageUI.this.eE(false);
                }
            });
        }
    };
    private String lKA;
    private String lKB;
    private c lKC = new c<cr>() {
        {
            this.xmG = cr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cr crVar = (cr) bVar;
            if (FTSEmojiDetailPageUI.this.kvY != null && crVar.frL.frM.equals(FTSEmojiDetailPageUI.this.kvY.Nx())) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiDownloadListener callback %s", FTSEmojiDetailPageUI.this.kvY.Nx());
                ah.y(new Runnable() {
                    public final void run() {
                        FTSEmojiDetailPageUI.this.eE(false);
                    }
                });
            }
            return false;
        }
    };
    private i lKD = new i() {
        public final void a(String str, Bitmap bitmap, Object... objArr) {
            x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", str);
            if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(FTSEmojiDetailPageUI.this.kvY.field_encrypturl)) {
                File file = new File(objArr[0].toString());
                if (file.exists()) {
                    FTSEmojiDetailPageUI.this.kvY.field_md5 = g.i(file);
                    FTSEmojiDetailPageUI fTSEmojiDetailPageUI = FTSEmojiDetailPageUI.this;
                    as.Hm();
                    fTSEmojiDetailPageUI.fCV = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", FTSEmojiDetailPageUI.this.kvY.field_md5);
                    FileOp.x(file.getAbsolutePath(), FTSEmojiDetailPageUI.this.fCV);
                    ah.y(new Runnable() {
                        public final void run() {
                            FTSEmojiDetailPageUI.this.eE(false);
                        }
                    });
                }
            }
        }
    };
    private d lKE = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    FTSEmojiDetailPageUI.h(FTSEmojiDetailPageUI.this);
                    return;
                case 2:
                    FTSEmojiDetailPageUI.g(FTSEmojiDetailPageUI.this);
                    return;
                default:
                    return;
            }
        }
    };
    private MMAnimateView lKn;
    private Button lKo;
    private Button lKp;
    private TextView lKq;
    private ImageView lKr;
    private View lKs;
    private boolean lKt;
    private boolean lKu;
    private String lKv;
    private String lKw;
    private String lKx;
    private String lKy;
    private String lKz;
    private int scene;
    private int type;

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2) {
        com.tencent.mm.bb.g.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.lKv, fTSEmojiDetailPageUI.lDB, 2, 0);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra("emoji_activity_id", str2);
        intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        com.tencent.mm.bl.d.a((Context) fTSEmojiDetailPageUI, ".ui.transmit.SelectConversationUI", intent, 0);
        fTSEmojiDetailPageUI.overridePendingTransition(R.a.bqo, R.a.bqa);
    }

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2, String str3, String str4) {
        com.tencent.mm.bb.g.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.lKv, fTSEmojiDetailPageUI.lDB, 1, 0);
        EmojiInfo YB = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(str);
        as.Hm();
        String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", str);
        if (YB == null && com.tencent.mm.a.e.bO(I)) {
            int i = p.Vw(I) ? EmojiInfo.xIP : EmojiInfo.xIO;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.xIH;
            emojiInfo.field_type = i;
            emojiInfo.field_size = com.tencent.mm.a.e.bN(I);
            emojiInfo.field_temp = 1;
            emojiInfo.field_designerID = str2;
            emojiInfo.field_thumbUrl = str3;
            emojiInfo.field_activityid = str4;
            com.tencent.mm.plugin.emoji.model.i.aCl().lCw.n(emojiInfo);
            YB = emojiInfo;
        }
        if (YB != null) {
            boolean a = com.tencent.mm.plugin.emoji.model.i.aCh().a(fTSEmojiDetailPageUI, YB, 18, q.FY());
            x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "doAddAction %b", Boolean.valueOf(a));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI r9) {
        /*
        r8 = 27;
        r3 = 3;
        r1 = 1;
        r2 = 0;
        r4 = r9.scene;
        r5 = r9.lKv;
        r6 = r9.lDB;
        r0 = r9.type;
        switch(r0) {
            case 2: goto L_0x00a8;
            case 3: goto L_0x00b3;
            case 4: goto L_0x00be;
            default: goto L_0x0010;
        };
    L_0x0010:
        r0 = r2;
    L_0x0011:
        r7 = r9.aDT();
        if (r7 == 0) goto L_0x0018;
    L_0x0017:
        r0 = 4;
    L_0x0018:
        com.tencent.mm.bb.g.a(r4, r5, r6, r3, r0);
        r0 = r9.aDT();
        if (r0 == 0) goto L_0x00c9;
    L_0x0021:
        r0 = new android.os.Bundle;
        r0.<init>();
        r2 = "stat_scene";
        r3 = 8;
        r0.putInt(r2, r3);
        r2 = "stat_search_id";
        r3 = r9.lKv;
        r0.putString(r2, r3);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r9.lKv;
        r2 = r2.append(r3);
        r3 = ":";
        r2 = r2.append(r3);
        r3 = r9.lDB;
        r2 = r2.append(r3);
        r3 = ":";
        r2 = r2.append(r3);
        r3 = r9.scene;
        r3 = java.lang.String.valueOf(r3);
        r2 = r2.append(r3);
        r3 = ":";
        r2 = r2.append(r3);
        r3 = r9.type;
        r3 = java.lang.String.valueOf(r3);
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = "key_username";
        r5 = r9.lKB;
        r3.putExtra(r4, r5);
        r4 = "key_can_swipe_back";
        r3.putExtra(r4, r1);
        r1 = "key_from_scene";
        r4 = 6;
        r3.putExtra(r1, r4);
        r1 = "key_scene_note";
        r3.putExtra(r1, r2);
        r1 = "_stat_obj";
        r3.putExtra(r1, r0);
        r0 = r9.mController;
        r0 = r0.xRr;
        r1 = "appbrand";
        r2 = ".ui.AppBrandProfileUI";
        com.tencent.mm.bl.d.b(r0, r1, r2, r3);
    L_0x00a7:
        return;
    L_0x00a8:
        r0 = r9.frQ;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x00b0:
        r0 = r1;
        goto L_0x0011;
    L_0x00b3:
        r0 = r9.fvS;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x00bb:
        r0 = 2;
        goto L_0x0011;
    L_0x00be:
        r0 = r9.lKy;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x00c6:
        r0 = r3;
        goto L_0x0011;
    L_0x00c9:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "preceding_scence";
        r3 = r9.getIntent();
        r4 = "preceding_scence";
        r2 = r3.getIntExtra(r4, r2);
        r0.putExtra(r1, r2);
        r1 = "download_entrance_scene";
        r0.putExtra(r1, r8);
        r1 = "searchID";
        r2 = r9.lKv;
        r4 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.getLong(r2, r4);
        r0.putExtra(r1, r2);
        r1 = "docID";
        r2 = r9.lDB;
        r0.putExtra(r1, r2);
        r1 = r9.type;
        switch(r1) {
            case 2: goto L_0x0101;
            case 3: goto L_0x0127;
            case 4: goto L_0x014b;
            default: goto L_0x0100;
        };
    L_0x0100:
        goto L_0x00a7;
    L_0x0101:
        r1 = com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.class;
        r0.setClass(r9, r1);
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r1);
        r1 = "extra_scence";
        r2 = r9.scene;
        r0.putExtra(r1, r2);
        r1 = "extra_type";
        r2 = r9.type;
        r0.putExtra(r1, r2);
        r1 = "extra_id";
        r2 = r9.frQ;
        r0.putExtra(r1, r2);
    L_0x0123:
        r9.startActivity(r0);
        goto L_0x00a7;
    L_0x0127:
        r1 = com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.class;
        r0.setClass(r9, r1);
        r1 = "extra_scence";
        r0.putExtra(r1, r8);
        r1 = "id";
        r2 = r9.fvS;
        r0.putExtra(r1, r2);
        r1 = "name";
        r2 = r9.designerName;
        r0.putExtra(r1, r2);
        r1 = "headurl";
        r2 = r9.lKA;
        r0.putExtra(r1, r2);
        goto L_0x0123;
    L_0x014b:
        r1 = r9.lKy;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x00a7;
    L_0x0153:
        r1 = "rawUrl";
        r2 = r9.lKy;
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = "webview";
        r3 = ".ui.tools.WebViewUI";
        com.tencent.mm.bl.d.b(r1, r2, r3, r0);
        goto L_0x00a7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.b(com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI):void");
    }

    static /* synthetic */ void c(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        if (fTSEmojiDetailPageUI.lKu) {
            arrayList.add(Integer.valueOf(1));
            arrayList2.add(fTSEmojiDetailPageUI.getString(R.l.eHt));
        }
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(fTSEmojiDetailPageUI.getString(R.l.eaB));
        if (fTSEmojiDetailPageUI.jAo == null) {
            fTSEmojiDetailPageUI.jAo = new l(fTSEmojiDetailPageUI.mController.xRr);
        }
        fTSEmojiDetailPageUI.jAo.rQF = new com.tencent.mm.ui.base.p.c() {
            public final void a(n nVar) {
                nVar.setHeaderTitle((CharSequence) "");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        nVar.f(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        };
        fTSEmojiDetailPageUI.jAo.rQG = fTSEmojiDetailPageUI.lKE;
        fTSEmojiDetailPageUI.jAo.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                FTSEmojiDetailPageUI.this.jAo = null;
            }
        });
        h.a(fTSEmojiDetailPageUI.mController.xRr, fTSEmojiDetailPageUI.jAo.bCH());
    }

    static /* synthetic */ void g(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        x.d("MicroMsg.FTS.FTSEmojiDetailPageUI", "ApplicationLanguage" + w.cfV());
        String str = fTSEmojiDetailPageUI.getString(R.l.ekC) + w.cfV();
        Intent intent = new Intent();
        intent.putExtra("title", fTSEmojiDetailPageUI.getString(R.l.eaB));
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.bl.d.b(fTSEmojiDetailPageUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void h(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        if (FileOp.bO(fTSEmojiDetailPageUI.fCV)) {
            k.h(fTSEmojiDetailPageUI.fCV, fTSEmojiDetailPageUI);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lKo = (Button) findViewById(R.h.cdo);
        this.lKp = (Button) findViewById(R.h.cdK);
        this.lKn = (MMAnimateView) findViewById(R.h.cdD);
        this.ksa = (ProgressBar) findViewById(R.h.ctC);
        this.lKq = (TextView) findViewById(R.h.cdN);
        this.lKr = (ImageView) findViewById(R.h.cdM);
        this.lKs = findViewById(R.h.bottom_bar);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FTSEmojiDetailPageUI.this.finish();
                return false;
            }
        });
        this.lKo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.this.kvY.Nx(), FTSEmojiDetailPageUI.this.kvY.field_designerID, FTSEmojiDetailPageUI.this.kvY.field_thumbUrl, FTSEmojiDetailPageUI.this.kvY.field_activityid);
            }
        });
        this.lKp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.this.kvY.Nx(), FTSEmojiDetailPageUI.this.kvY.field_activityid);
            }
        });
        this.lKs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FTSEmojiDetailPageUI.b(FTSEmojiDetailPageUI.this);
            }
        });
        addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FTSEmojiDetailPageUI.c(FTSEmojiDetailPageUI.this);
                return true;
            }
        });
        this.type = getIntent().getIntExtra("extra_type", 0);
        this.scene = getIntent().getIntExtra("extra_scence", 0);
        this.kvY = new EmojiInfo();
        this.kvY.field_designerID = getIntent().getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.kvY.field_name = getIntent().getStringExtra("extra_emoji_name");
        this.kvY.field_aeskey = getIntent().getStringExtra("extra_aeskey");
        this.kvY.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
        this.kvY.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
        this.kvY.field_md5 = getIntent().getStringExtra("extra_md5");
        this.kvY.field_groupId = getIntent().getStringExtra("extra_product_id");
        this.frQ = this.kvY.field_groupId;
        this.lKx = getIntent().getStringExtra("extra_product_name");
        this.lKw = getIntent().getStringExtra("productUrl");
        this.lKy = getIntent().getStringExtra("extra_article_url");
        this.lKz = getIntent().getStringExtra("extra_article_name");
        this.fvS = this.kvY.field_designerID;
        this.designerName = getIntent().getStringExtra("name");
        this.lKA = getIntent().getStringExtra("headurl");
        this.lKB = getIntent().getStringExtra("weapp_user_name");
        this.hfV = getIntent().getIntExtra("weapp_version", 0);
        this.fqY = getIntent().getIntExtra("source_type", 0);
        this.lKv = getIntent().getStringExtra("searchID");
        this.lDB = getIntent().getStringExtra("docID");
        this.lKt = getIntent().getBooleanExtra("disableAddSticker", false);
        this.lKu = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
        String stringExtra = getIntent().getStringExtra("activityId");
        if (!bi.oN(stringExtra)) {
            this.kvY.field_activityid = stringExtra;
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.lKC);
        com.tencent.mm.plugin.emoji.model.i.aCf().lDh = this.lDu;
        com.tencent.mm.bb.g.g(this.scene, this.lKv, this.lDB);
        eE(true);
        x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", this.fCV);
        com.tencent.mm.bb.g.g(this.scene, this.lKv, this.lDB);
    }

    protected void onResume() {
        super.onResume();
        aDS();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            EmojiInfo emojiInfo;
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            EmojiInfo YB = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(this.kvY.Nx());
            if (YB == null) {
                as.Hm();
                String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", this.kvY.Nx());
                if (com.tencent.mm.a.e.bO(I)) {
                    int i3 = p.Vw(I) ? EmojiInfo.xIP : EmojiInfo.xIO;
                    EmojiInfo emojiInfo2 = new EmojiInfo();
                    emojiInfo2.field_md5 = this.kvY.Nx();
                    emojiInfo2.field_catalog = EmojiInfo.xIH;
                    emojiInfo2.field_type = i3;
                    emojiInfo2.field_size = com.tencent.mm.a.e.bN(I);
                    emojiInfo2.field_temp = 1;
                    if (!bi.oN(this.kvY.field_activityid)) {
                        emojiInfo2.field_activityid = this.kvY.field_activityid;
                    }
                    emojiInfo2.field_designerID = this.kvY.field_designerID;
                    emojiInfo2.field_thumbUrl = this.kvY.field_thumbUrl;
                    YB = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.n(emojiInfo2);
                }
                emojiInfo = YB;
            } else {
                YB.field_designerID = this.kvY.field_designerID;
                YB.field_thumbUrl = this.kvY.field_thumbUrl;
                emojiInfo = YB;
            }
            for (String str : bi.F(bi.aD(stringExtra, "").split(","))) {
                if (emojiInfo != null) {
                    com.tencent.mm.plugin.emoji.model.i.aCh().a(str, emojiInfo, null);
                    if (!bi.oN(stringExtra2)) {
                        f.aZN().dq(stringExtra2, str);
                    }
                }
            }
            com.tencent.mm.ui.snackbar.a.h(this, this.mController.xRr.getString(R.l.eip));
        }
    }

    private void eE(boolean z) {
        if (z) {
            setMMTitle(this.kvY.getName());
        }
        switch (this.type) {
            case 2:
                o.PG().a(this.lKw, this.lKr);
                this.lKq.setText(this.lKx);
                this.fCV = this.kvY.clq();
                break;
            case 3:
                o.PG().a(this.lKA, this.lKr);
                this.lKq.setText(this.designerName);
                this.fCV = this.kvY.clq();
                break;
            case 4:
                this.lKr.setVisibility(8);
                if (!bi.oN(this.lKz)) {
                    this.lKq.setText(this.lKz);
                    break;
                } else {
                    this.lKq.setText(R.l.eJg);
                    break;
                }
        }
        if (FileOp.bO(this.fCV)) {
            this.ksa.setVisibility(8);
            this.lKn.setVisibility(0);
            EmojiInfo YB = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(this.kvY.Nx());
            if (YB == null || (YB.field_reserved4 & EmojiInfo.xJc) != EmojiInfo.xJc) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
                this.lKn.cY(this.fCV, null);
            } else {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
                this.lKn.g(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(YB), "");
            }
            aDS();
            EmojiInfo YB2 = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(this.kvY.Nx());
            if (YB2 == null) {
                YB = this.kvY;
            } else {
                YB = YB2;
            }
            if (YB.field_catalog == EmojiInfo.xIN || bi.oN(YB.field_groupId) || ((!bi.oN(YB.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yL(YB.field_groupId)) || this.type == 4)) {
                this.lKp.setEnabled(true);
            } else {
                String str = this.kvY.field_groupId;
                as.CN().a(423, (e) this);
                as.CN().a(new com.tencent.mm.plugin.emoji.f.g(str, (byte) 0), 0);
            }
        } else if (z) {
            if (this.type == 4) {
                File file = new File(getCacheDir(), g.s(this.kvY.field_encrypturl.getBytes()));
                if (file.exists()) {
                    this.kvY.field_md5 = g.i(file);
                    as.Hm();
                    String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", this.kvY.field_md5);
                    if (!FileOp.bO(I)) {
                        FileOp.x(file.getAbsolutePath(), I);
                    }
                    this.fCV = I;
                    eE(false);
                } else {
                    com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                    aVar.hFl = true;
                    aVar.hFn = file.getAbsolutePath();
                    aVar.hFO = new Object[]{file.getAbsolutePath()};
                    com.tencent.mm.plugin.emoji.model.i.aBL().a(this.kvY.field_encrypturl, null, aVar.PQ(), this.lKD);
                }
            } else {
                this.lKn.setVisibility(8);
                this.ksa.setVisibility(0);
                this.lKo.setText(R.l.eax);
                this.lKp.setText(R.l.eET);
                this.lKo.setEnabled(false);
                this.lKp.setEnabled(false);
                com.tencent.mm.plugin.emoji.model.i.aCf().g(this.kvY);
            }
        }
        if (this.lKt) {
            this.lKo.setVisibility(8);
        }
    }

    private void aDS() {
        EmojiInfo YB = com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YB(this.kvY.Nx());
        if (YB == null) {
            YB = this.kvY;
        }
        if (YB.field_catalog == EmojiGroupInfo.xIG) {
            this.lKo.setEnabled(false);
            this.lKo.setText(R.l.dDW);
            return;
        }
        this.lKo.setText(R.l.eax);
        if (com.tencent.mm.a.e.bO(this.fCV)) {
            this.lKo.setEnabled(true);
        } else {
            this.lKo.setEnabled(false);
        }
    }

    private boolean aDT() {
        if (bi.oN(this.lKB) || this.fqY != 1) {
            return false;
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dja;
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.lKC);
        com.tencent.mm.plugin.emoji.model.i.aCf().lDh = null;
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.emoji.f.g) {
            as.CN().b(423, (e) this);
            com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) kVar;
            if (gVar == null || bi.oN(gVar.lEs) || this.kvY == null || bi.oN(this.kvY.field_groupId) || !this.kvY.field_groupId.equalsIgnoreCase(gVar.lEs)) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                this.lKp.setEnabled(true);
            } else {
                this.lKp.setEnabled(false);
            }
        }
    }
}
