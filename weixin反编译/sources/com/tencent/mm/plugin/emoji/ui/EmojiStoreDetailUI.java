package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ap.a.c.i;
import com.tencent.mm.ap.a.c.j;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.ct;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.view.SmileySubGrid;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.File;
import java.util.ArrayList;

public class EmojiStoreDetailUI extends MMActivity implements OnClickListener, e, com.tencent.mm.sdk.e.j.a {
    private View klX;
    private long lDA = 0;
    private String lDB = "";
    private com.tencent.mm.plugin.emoji.h.b lDE;
    private String lEs;
    private String lEt;
    private String lEu;
    private st lGN = new st();
    private String lGO = "";
    private int lGv;
    private com.tencent.mm.sdk.b.c lGz = new com.tencent.mm.sdk.b.c<ct>() {
        {
            this.xmG = ct.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ct ctVar = (ct) bVar;
            if (!(EmojiStoreDetailUI.this.lEs == null || ctVar.frP.frQ == null || !ctVar.frP.frQ.equals(EmojiStoreDetailUI.this.lEs))) {
                EmojiStoreDetailUI.this.h(ctVar.frP.frQ, ctVar.frP.status, ctVar.frP.progress, ctVar.frP.frR);
            }
            return false;
        }
    };
    private TextView lIA;
    private View lIB;
    private EmojiDetailScrollView lIC;
    private BannerEmojiView lID;
    private TextView lIE;
    private MMAutoSizeTextView lIF;
    private TextView lIG;
    private TextView lIH;
    private TextView lII;
    private EmojiDetailGridView lIJ;
    private ImageView lIK;
    private View lIL;
    private TextView lIM;
    private TextView lIN;
    private int lIO;
    private View lIP;
    private ProgressBar lIQ;
    private View lIR;
    private ImageView lIS;
    private TextView lIT;
    private View lIU;
    private View lIV;
    private MMCopiableTextView lIW;
    private Button lIX;
    private DonorsAvatarView lIY;
    private TextView lIZ;
    private int lIp;
    private String lIq;
    private boolean lIr;
    private boolean lIs = false;
    private int lIt = -1;
    private l lIu;
    private g lIv;
    private o lIw;
    private a lIx;
    private ack lIy = null;
    private boolean lIz;
    private int lJa;
    private int lJb;
    private int lJc;
    private String lJd;
    private boolean lJe;
    private int lJf;
    private int lJg = -1;
    private String lJh;
    private String[] lJi = new String[1];
    private boolean lJj = false;
    private View lJk;
    private boolean lJl = true;
    private acc lJm;
    private boolean lJn = false;
    private boolean lJo = true;
    private OnClickListener lJp = new OnClickListener() {
        public final void onClick(View view) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + w.cfV());
            String str = EmojiStoreDetailUI.this.getString(R.l.eam) + w.cfV();
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            d.b(EmojiStoreDetailUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    };
    private OnClickListener lJq = new OnClickListener() {
        public final void onClick(View view) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "ApplicationLanguage" + w.cfV());
            String str = EmojiStoreDetailUI.this.getString(R.l.dZU) + w.cfV();
            Intent intent = new Intent();
            intent.putExtra("title", EmojiStoreDetailUI.this.getString(R.l.eaB));
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("neverGetA8Key", true);
            d.b(EmojiStoreDetailUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    };
    private OnClickListener lJr = new OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardUI.class);
            intent.putExtra("extra_id", EmojiStoreDetailUI.this.lEs);
            intent.putExtra("extra_name", EmojiStoreDetailUI.this.lGN.whv);
            if (!(EmojiStoreDetailUI.this.lGN == null || EmojiStoreDetailUI.this.lGN.whQ == null)) {
                intent.putExtra("name", EmojiStoreDetailUI.this.lGN.whQ.nkW);
            }
            intent.putExtra("scene", EmojiStoreDetailUI.this.lJc);
            intent.putExtra("pageType", 1);
            intent.putExtra("searchID", EmojiStoreDetailUI.this.lDA);
            EmojiStoreDetailUI.this.startActivity(intent);
            com.tencent.mm.plugin.report.service.g.pWK.h(12738, EmojiStoreDetailUI.this.lEs, Integer.valueOf(1), Integer.valueOf(EmojiStoreDetailUI.this.lJc), Integer.valueOf(0));
        }
    };
    private OnClickListener lJs = new OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(EmojiStoreDetailUI.this, EmojiStoreV2RewardDetailUI.class);
            intent.putExtra("extra_id", EmojiStoreDetailUI.this.lEs);
            intent.putExtra("extra_iconurl", EmojiStoreDetailUI.this.lGN.nlA);
            intent.putExtra("extra_name", EmojiStoreDetailUI.this.lGN.whv);
            if (EmojiStoreDetailUI.this.lGN.whQ != null) {
                intent.putExtra("name", EmojiStoreDetailUI.this.lGN.whQ.nkW);
            }
            EmojiStoreDetailUI.this.startActivity(intent);
        }
    };
    private i lJt = new i() {
        public final void a(String str, Bitmap bitmap, Object... objArr) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "[cpan] on image load complete url:%s", str);
            if (bitmap != null) {
                EmojiStoreDetailUI.this.ph(1006);
            }
        }
    };
    private i lJu = new i() {
        public final void a(String str, Bitmap bitmap, Object... objArr) {
            if (bitmap != null && objArr != null && objArr.length > 0 && EmojiStoreDetailUI.this.mHandler != null) {
                Object obj;
                int intValue = ((Integer) objArr[0]).intValue();
                as.Hm();
                String H = EmojiLogic.H(com.tencent.mm.y.c.Fw(), EmojiStoreDetailUI.this.lEs, str);
                String a = EmojiStoreDetailUI.this.lEs;
                String str2 = ((awi) EmojiStoreDetailUI.this.lGN.whL.get(intValue)).wKw;
                com.tencent.mm.bu.a.getDensity(EmojiStoreDetailUI.this.mContext);
                EmojiInfo a2 = EmojiLogic.a(a, 8, str2, true);
                com.tencent.mm.plugin.emoji.e.e aBy = com.tencent.mm.plugin.emoji.e.e.aBy();
                if (com.tencent.mm.a.e.bO(H)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int bN = com.tencent.mm.a.e.bN(H);
                    int i = bN > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT ? WXMediaMessage.DESCRIPTION_LENGTH_LIMIT : bN;
                    Object d = com.tencent.mm.a.e.d(H, 0, bN);
                    byte[] aesCryptEcb = AesEcb.aesCryptEcb(com.tencent.mm.a.e.d(H, 0, i), aBy.aBz().getBytes(), true, false);
                    if (bi.by(aesCryptEcb) || bi.by((byte[]) d)) {
                        i = -1;
                    } else {
                        System.arraycopy(aesCryptEcb, 0, d, 0, i);
                        i = com.tencent.mm.a.e.b(H, d, bN);
                    }
                    if (i == 0) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        com.tencent.mm.plugin.report.service.g.pWK.a(252, 6, 1, false);
                        x.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", Integer.valueOf(d.length), Long.valueOf(r10));
                        obj = 1;
                    } else {
                        x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                        com.tencent.mm.plugin.report.service.g.pWK.a(252, 3, 1, false);
                        obj = null;
                    }
                } else {
                    x.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file do no exsit.");
                    obj = null;
                }
                if (a2 != null) {
                    if (obj != null) {
                        a2.field_reserved4 = EmojiInfo.xJc;
                    } else {
                        a2.field_reserved4 = 0;
                    }
                    final EmojiInfo emojiInfo = a2;
                    final int i2 = intValue;
                    EmojiStoreDetailUI.this.mHandler.post(new Runnable() {
                        public final void run() {
                            SmileySubGrid q = EmojiStoreDetailUI.this.lIJ;
                            EmojiInfo emojiInfo = emojiInfo;
                            if (q.zNo == i2 && q.zNp) {
                                q.r(emojiInfo);
                                return;
                            }
                            x.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "not show:%d, needData: %B, so do not refresh", Integer.valueOf(r2), Boolean.valueOf(q.zNp));
                        }
                    });
                    return;
                }
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "ignore no call back preview loader. ");
            }
        }
    };
    private j lJv = new j() {
        public final void bn(long j) {
            com.tencent.mm.plugin.report.service.g.pWK.k(10930, EmojiStoreDetailUI.this.lEs + "," + j);
        }
    };
    private com.tencent.mm.pluginsdk.model.i.a lJw = new com.tencent.mm.pluginsdk.model.i.a() {
        public final void u(ArrayList<q> arrayList) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "[onQueryFinish]");
            EmojiStoreDetailUI.this.lJf = 12;
            if (arrayList != null && arrayList.size() > 0) {
                q qVar = (q) arrayList.get(0);
                if (qVar.vkp == 10232) {
                    EmojiStoreDetailUI.this.lIt = 4;
                    EmojiStoreDetailUI.this.lJh = qVar.vkm;
                } else {
                    EmojiStoreDetailUI.this.lIt = 10;
                    EmojiStoreDetailUI.this.lJg = qVar.vkp;
                }
                EmojiStoreDetailUI.this.ph(1002);
            }
        }
    };
    private int ljP;
    private ProgressBar lzi;
    private ProgressDialog lzx;
    private Context mContext;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    EmojiStoreDetailUI.e(EmojiStoreDetailUI.this);
                    return;
                case 1002:
                    EmojiStoreDetailUI.this.aDG();
                    return;
                case 1003:
                    EmojiStoreDetailUI.this.aDJ();
                    return;
                case 1004:
                    if (EmojiStoreDetailUI.this.lIH.getVisibility() == 0) {
                        EmojiStoreDetailUI.this.lIH.setVisibility(8);
                        EmojiStoreDetailUI.this.lIL.setVisibility(0);
                        EmojiStoreDetailUI.this.lIK.setVisibility(0);
                    }
                    EmojiStoreDetailUI.this.lzi.setProgress(EmojiStoreDetailUI.this.sm);
                    return;
                case 1005:
                    EmojiStoreDetailUI.this.lIC.scrollTo(0, 0);
                    return;
                case 1006:
                    EmojiStoreDetailUI.this.eB(false);
                    return;
                case 1007:
                    EmojiStoreDetailUI.this.aDH();
                    return;
                default:
                    x.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
                    return;
            }
        }
    };
    private int mNumColumns;
    private int sm;

    class a extends BaseAdapter {
        public int getCount() {
            return EmojiStoreDetailUI.this.lGN == null ? 0 : EmojiStoreDetailUI.this.lGN.whB;
        }

        public Object getItem(int i) {
            if (EmojiStoreDetailUI.this.lGN == null || EmojiStoreDetailUI.this.lGN.whL == null || EmojiStoreDetailUI.this.lGN.whL.size() <= 0 || EmojiStoreDetailUI.this.lGN.whL.get(i) == null || ((awi) EmojiStoreDetailUI.this.lGN.whL.get(i)).wKw == null) {
                return null;
            }
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", Integer.valueOf(i));
            String a = EmojiStoreDetailUI.this.lEs;
            String str = ((awi) EmojiStoreDetailUI.this.lGN.whL.get(i)).wKw;
            com.tencent.mm.bu.a.getDensity(EmojiStoreDetailUI.this.mContext);
            EmojiInfo a2 = EmojiLogic.a(a, 8, str, false);
            if (a2 == null) {
                x.d("MicroMsg.emoji.EmojiStoreDetailUI", "detail preview emoji is null.");
                com.tencent.mm.ap.o.PG().a(((awi) EmojiStoreDetailUI.this.lGN.whL.get(i)).wKw, null, f.b(EmojiStoreDetailUI.this.lEs, ((awi) EmojiStoreDetailUI.this.lGN.whL.get(i)).wKw, Integer.valueOf(i)), EmojiStoreDetailUI.this.lJu, EmojiStoreDetailUI.this.lJv, null, null, null, null);
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.k(10930, EmojiStoreDetailUI.this.lEs + ",0");
                if (com.tencent.mm.plugin.emoji.e.e.aBy().isEnable()) {
                    a2.field_reserved4 = EmojiInfo.xJc;
                }
            }
            pi(i);
            return a2;
        }

        private void pi(int i) {
            int[] iArr = new int[]{i - 1, i + 1, i - 4, i + 4};
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 4) {
                    int i4 = iArr[i3];
                    if (EmojiStoreDetailUI.this.lGN != null && i4 >= 0 && i4 < EmojiStoreDetailUI.this.lGN.whK) {
                        as.Hm();
                        if (!com.tencent.mm.a.e.bO(EmojiLogic.H(com.tencent.mm.y.c.Fw(), EmojiStoreDetailUI.this.lEs, ((awi) EmojiStoreDetailUI.this.lGN.whL.get(i4)).wKw))) {
                            com.tencent.mm.ap.o.PG().a(((awi) EmojiStoreDetailUI.this.lGN.whL.get(i4)).wKw, null, f.b(EmojiStoreDetailUI.this.lEs, ((awi) EmojiStoreDetailUI.this.lGN.whL.get(i4)).wKw, Integer.valueOf(i4)), EmojiStoreDetailUI.this.lJu, EmojiStoreDetailUI.this.lJv, null, null, null, null);
                        }
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(EmojiStoreDetailUI.this.mContext).inflate(R.i.dfP, null);
                c cVar2 = new c(view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            if (EmojiStoreDetailUI.this.lIJ.zNq) {
                cVar.lJA.setBackgroundResource(R.g.bGs);
            } else {
                cVar.lJA.setBackgroundDrawable(null);
            }
            String str = "";
            if (EmojiStoreDetailUI.this.lGN.whC != null) {
                str = n.a((bet) EmojiStoreDetailUI.this.lGN.whC.get(i));
            }
            com.tencent.mm.ap.o.PG().a(str, cVar.lJA, f.cn(EmojiStoreDetailUI.this.lEs, str));
            return view;
        }
    }

    class b extends a {
        private ArrayList<EmojiInfo> lJz;

        public final /* synthetic */ Object getItem(int i) {
            return pg(i);
        }

        public b() {
            super();
            this.lJz = new ArrayList();
            this.lJz = (ArrayList) com.tencent.mm.plugin.emoji.model.i.aCl().lCw.yK(com.tencent.mm.plugin.emoji.h.a.aEi());
        }

        public final int getCount() {
            return this.lJz == null ? 0 : this.lJz.size();
        }

        private EmojiInfo pg(int i) {
            return this.lJz == null ? null : (EmojiInfo) this.lJz.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(EmojiStoreDetailUI.this.mContext).inflate(R.i.dfP, null);
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            cVar.lJA.setBackgroundResource(R.g.bGs);
            EmojiInfo pg = pg(i);
            com.tencent.mm.ap.o.PG().a((bi.oN(pg.wl()) ? pg.getName() : pg.wl()).split("\\.")[0], cVar.lJA, f.aBA());
            return view;
        }
    }

    class c {
        SquareImageView lJA;

        public c(View view) {
            this.lJA = (SquareImageView) view.findViewById(R.h.cbq);
            this.lJA.setScaleType(ScaleType.FIT_CENTER);
        }
    }

    static /* synthetic */ void e(EmojiStoreDetailUI emojiStoreDetailUI) {
        if (!com.tencent.mm.plugin.emoji.h.a.zu(emojiStoreDetailUI.lEs)) {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable() && com.tencent.mm.plugin.emoji.model.i.aCl().lCx.Yw(emojiStoreDetailUI.lEs)) {
                if (com.tencent.mm.plugin.emoji.model.i.aCl().lCw.yS(emojiStoreDetailUI.lEs) > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    as.Hm();
                    File file = new File(stringBuilder.append(com.tencent.mm.y.c.Fw()).append(emojiStoreDetailUI.lEs).toString());
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length <= 0) {
                            com.tencent.mm.plugin.emoji.model.i.aCl().lCx.Yx(emojiStoreDetailUI.lEs);
                            com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YE(emojiStoreDetailUI.lEs);
                        } else {
                            emojiStoreDetailUI.lIz = true;
                            emojiStoreDetailUI.lIt = 7;
                            emojiStoreDetailUI.aDJ();
                            return;
                        }
                    }
                }
                com.tencent.mm.plugin.emoji.model.i.aCl().lCw.YE(emojiStoreDetailUI.lEs);
            }
            emojiStoreDetailUI.lIz = false;
        }
    }

    static /* synthetic */ void u(EmojiStoreDetailUI emojiStoreDetailUI) {
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(emojiStoreDetailUI.mContext, com.tencent.mm.ui.widget.g.zCt, false);
        gVar.rQF = new com.tencent.mm.ui.base.p.c() {
            public final void a(com.tencent.mm.ui.base.n nVar) {
                nVar.a(1001, EmojiStoreDetailUI.this.getString(R.l.eYv), R.k.dxb);
                nVar.a(1000, EmojiStoreDetailUI.this.getString(R.l.eYu), R.k.dwQ);
            }
        };
        gVar.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1000:
                        k.a(EmojiStoreDetailUI.this.mController.xRr, EmojiStoreDetailUI.this.lGN.whv + EmojiStoreDetailUI.this.getString(R.l.ebh), EmojiStoreDetailUI.this.lGN.whw, EmojiStoreDetailUI.this.lGN.nlA, EmojiStoreDetailUI.this.lGN.whO, EmojiLogic.yU(EmojiStoreDetailUI.this.lEs), 4);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13224, Integer.valueOf(0), Integer.valueOf(1), EmojiStoreDetailUI.this.lEs, "");
                        return;
                    case 1001:
                        k.cv(EmojiStoreDetailUI.this.mController.xRr);
                        EmojiStoreDetailUI.this.mController.xRr.overridePendingTransition(R.a.bqo, R.a.bqa);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13224, Integer.valueOf(0), Integer.valueOf(2), EmojiStoreDetailUI.this.lEs, "");
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUX();
        com.tencent.mm.plugin.report.service.g.pWK.h(13224, Integer.valueOf(0), Integer.valueOf(0), "", "");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lJe = com.tencent.mm.y.q.Gk();
        this.lDE = new com.tencent.mm.plugin.emoji.h.b(2003);
        Intent intent = getIntent();
        this.lEs = getIntent().getStringExtra("extra_id");
        this.lGv = getIntent().getIntExtra("preceding_scence", -1);
        this.lEt = getIntent().getStringExtra("extra_name");
        this.lIp = getIntent().getIntExtra("call_by", -1);
        Object stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lEs = EmojiLogic.yO(stringExtra);
            this.lGv = 0;
            this.lGv = 10;
            com.tencent.mm.plugin.report.service.g.pWK.h(10993, Integer.valueOf(3), this.lEs);
        }
        if (TextUtils.isEmpty(this.lEs)) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
            finish();
        }
        if (this.lGv == -1) {
            x.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
            finish();
        }
        this.lJl = intent.getBooleanExtra("check_clickflag", true);
        this.lJd = intent.getStringExtra("cdn_client_id");
        this.lJc = intent.getIntExtra("download_entrance_scene", 0);
        this.lDA = intent.getLongExtra("searchID", 0);
        this.lDB = bi.aD(intent.getStringExtra("docID"), "");
        stringExtra = intent.getStringExtra("extra_copyright");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lGN.whF = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_coverurl");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lGN.whD = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_description");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lGN.whw = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lGN.why = stringExtra;
        }
        int intExtra = intent.getIntExtra("extra_type", -1);
        if (intExtra != -1) {
            this.lGN.whz = intExtra;
        }
        intExtra = intent.getIntExtra("extra_flag", -1);
        if (intExtra != -1) {
            this.lGN.whA = intExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_type");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lGN.whH = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_num");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lGN.whG = stringExtra;
        }
        if (this.lJe) {
            this.lJh = intent.getStringExtra("google_price");
            if (TextUtils.isEmpty(this.lJh)) {
                this.lJf = 11;
                com.tencent.mm.pluginsdk.model.i.a(this, this.lJi, this.lJw);
            }
        }
        this.lIr = intent.getBooleanExtra("reward_tip", false);
        this.lJi[0] = this.lEs;
        this.lGN.vPI = this.lEs;
        this.lGN.whv = this.lEt;
        this.lGN.whN = this.lIq;
        this.lGN.kzy = -1;
        this.mContext = this;
        initView();
        if (com.tencent.mm.plugin.emoji.h.a.zu(this.lEs)) {
            Context context = this.mController.xRr;
            st stVar = new st();
            stVar.vPI = EmojiGroupInfo.xIE;
            stVar.whv = context.getString(R.l.ebr);
            stVar.whw = context.getString(R.l.ebp);
            stVar.whx = context.getString(R.l.ebn);
            stVar.why = "";
            stVar.whz = 0;
            stVar.whA = 1;
            stVar.whD = "";
            stVar.whE = 0;
            stVar.whF = context.getString(R.l.ebo);
            stVar.whI = "";
            stVar.whG = "";
            stVar.whH = "";
            stVar.whM = context.getString(R.l.ebq);
            this.lGN = stVar;
            this.lJn = true;
            this.lJm = EmojiLogic.aCb();
            aDF();
        } else {
            com.tencent.mm.storage.emotion.i YH = com.tencent.mm.plugin.emoji.model.i.aCl().lCA.YH(this.lEs);
            if (!(YH == null || YH.field_content == null)) {
                ace ace = new ace();
                try {
                    ace.aH(YH.field_content);
                    this.lGN = ace.wrI;
                    this.lGO = YH.field_lan;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmojiStoreDetailUI", "exception:%s", bi.i(e));
                }
            }
            if (this.lGN == null) {
                this.lIu = new l(this.lEs, this.lGv);
            } else if (bi.oN(this.lGO) || !this.lGO.equalsIgnoreCase(w.eM(this.mContext))) {
                this.lIu = new l(this.lEs, this.lGv);
            } else {
                this.lIu = new l(this.lEs, this.lGv, this.lGN.kzy);
            }
            as.CN().a(this.lIu, 0);
            if (this.lIp == -1 || this.lIp == 3) {
                this.lIB.setVisibility(8);
                this.klX.setVisibility(8);
                getString(R.l.dGZ);
                this.lzx = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(EmojiStoreDetailUI.this.lIu);
                        EmojiStoreDetailUI.this.lIA.setText(R.l.eaL);
                        EmojiStoreDetailUI.this.aDC();
                    }
                });
            }
            aDD();
            if (this.lJl) {
                as.CN().a(new com.tencent.mm.plugin.emoji.f.k(this.lEs), 0);
            } else {
                this.lJn = true;
                this.lJm = EmojiLogic.aCb();
            }
        }
        aDG();
        com.tencent.mm.plugin.emoji.model.i.aCl().lCx.c(this);
        com.tencent.mm.sdk.b.a.xmy.b(this.lGz);
        as.CN().a(423, (e) this);
        as.CN().a(822, (e) this);
        h(this.lEs, getIntent().getIntExtra("extra_status", -1), getIntent().getIntExtra("extra_progress", 0), this.lJd);
        this.lJo = true;
        com.tencent.mm.plugin.report.service.g.pWK.h(12740, Integer.valueOf(1), "", this.lEs, "", Integer.valueOf(this.lJc));
        if (this.lIr && this.lIC != null) {
            this.mHandler.postDelayed(new Runnable() {
                public final void run() {
                    EmojiStoreDetailUI.this.lIC.fullScroll(130);
                }
            }, 0);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.cdR;
    }

    protected final void initView() {
        if (!bi.oN(this.lEt)) {
            setMMTitle(this.lEt);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmojiStoreDetailUI.this.finish();
                return true;
            }
        });
        this.ljP = com.tencent.mm.bu.a.aa(this.mContext, R.f.bwZ);
        this.lJa = getResources().getDimensionPixelSize(R.f.bwY);
        this.lJa = com.tencent.mm.bu.a.aa(this.mContext, R.f.bwY);
        this.mNumColumns = 4;
        this.lIC = (EmojiDetailScrollView) findViewById(R.h.cJo);
        this.klX = findViewById(R.h.empty);
        this.lIA = (TextView) this.klX.findViewById(R.h.ceh);
        this.lIB = findViewById(R.h.cdR);
        this.lID = (BannerEmojiView) findViewById(R.h.cdC);
        this.lID.setMinimumHeight((int) (((float) (((this.lID.getRight() - this.lID.getLeft()) - this.lID.getPaddingRight()) - this.lID.getPaddingLeft())) * 0.56f));
        this.lIE = (TextView) findViewById(R.h.cea);
        this.lIF = (MMAutoSizeTextView) findViewById(R.h.ceb);
        this.lIG = (TextView) findViewById(R.h.cds);
        this.lIH = (TextView) findViewById(R.h.cec);
        this.lII = (TextView) findViewById(R.h.cdv);
        this.lIO = com.tencent.mm.bu.a.eB(this.mController.xRr);
        this.lIP = findViewById(R.h.cdn);
        this.lIJ = (EmojiDetailGridView) findViewById(R.h.cdz);
        if (com.tencent.mm.plugin.emoji.h.a.zu(this.lEs)) {
            this.lIx = new b();
        } else {
            this.lIx = new a();
        }
        this.lIL = findViewById(R.h.cdI);
        this.lzi = (ProgressBar) findViewById(R.h.cdx);
        this.lIK = (ImageView) findViewById(R.h.cdq);
        this.lIK.setOnClickListener(this);
        this.lIL.setVisibility(8);
        this.lIK.setVisibility(8);
        this.lzi.setProgress(0);
        this.lIJ.setAdapter(this.lIx);
        this.lIJ.setColumnWidth(this.lJa);
        this.lIJ.setNumColumns(this.mNumColumns);
        this.lIJ.setHorizontalSpacing(this.ljP);
        this.lIJ.setVerticalSpacing(this.ljP);
        this.lIJ.lHY = this.lIC;
        this.lIJ.zNn = true;
        this.lIH.setOnClickListener(this);
        this.lIM = (TextView) findViewById(R.h.cdL);
        this.lIN = (TextView) findViewById(R.h.cdr);
        this.lIM.setOnClickListener(this.lJp);
        this.lIN.setOnClickListener(this.lJq);
        this.lIQ = (ProgressBar) findViewById(R.h.cdy);
        this.lIQ.setVisibility(this.lJe ? 0 : 8);
        this.lJk = findViewById(R.h.cdF);
        this.lIU = findViewById(R.h.cdu);
        this.lIR = findViewById(R.h.caW);
        this.lIS = (ImageView) findViewById(R.h.cbb);
        this.lIT = (TextView) findViewById(R.h.cbk);
        this.lIV = findViewById(R.h.cdJ);
        this.lIW = (MMCopiableTextView) findViewById(R.h.cIa);
        this.lIX = (Button) findViewById(R.h.cIb);
        this.lIZ = (TextView) findViewById(R.h.cIf);
        this.lIY = (DonorsAvatarView) findViewById(R.h.cHZ);
        this.lIX.setOnClickListener(this.lJr);
        this.lIZ.setOnClickListener(this.lJs);
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        as.CN().a(412, (e) this);
        as.CN().a(521, (e) this);
        this.lJj = false;
        if (!this.lJo) {
            aDD();
            ph(1007);
        }
        aDE();
        this.lJo = false;
        ph(1001);
    }

    protected void onPause() {
        super.onPause();
        as.CN().b(412, (e) this);
        as.CN().b(521, (e) this);
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.emoji.model.i.aCl().lCx.j(this);
        com.tencent.mm.sdk.b.a.xmy.c(this.lGz);
        as.CN().b(423, (e) this);
        as.CN().b(822, (e) this);
        if (this.lIJ != null) {
            this.lIJ.release();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(DownloadInfo.STATUS, this.lIt);
        bundle.putInt("progress", this.sm);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.lIt = bundle.getInt(DownloadInfo.STATUS);
        this.sm = bundle.getInt("progress");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.h.cec) {
            String stringExtra;
            if (this.lIt == 7) {
                stringExtra = getIntent().getStringExtra("to_talker_name");
                if (bi.oN(stringExtra) || !this.lIs) {
                    this.lDE.n(this);
                    com.tencent.mm.plugin.report.service.g.pWK.h(12069, Integer.valueOf(2), this.lEs);
                } else {
                    com.tencent.mm.plugin.emoji.h.b.a(stringExtra, this.lEs, (Activity) this);
                }
                x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
                com.tencent.mm.plugin.report.service.g.pWK.k(11076, "0, ");
                return;
            }
            switch (this.lIt) {
                case -1:
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                case 0:
                case 3:
                    aDM();
                    this.lIt = 6;
                    aDJ();
                    com.tencent.mm.plugin.report.service.g.pWK.h(12066, Integer.valueOf(1), Integer.valueOf(this.lJc), "", this.lEs, Long.valueOf(this.lDA), this.lDB);
                    return;
                case 4:
                    if (!this.lJj) {
                        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", this.lEs, this.lGN.why, this.lGN.whH);
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", this.lEs);
                        if (this.lJe) {
                            intent.putExtra("key_currency_type", "");
                            intent.putExtra("key_price", this.lJh);
                        } else {
                            intent.putExtra("key_currency_type", this.lGN.whH);
                            intent.putExtra("key_price", this.lGN.whG);
                        }
                        d.b(this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                        com.tencent.mm.plugin.report.service.g.pWK.h(12066, Integer.valueOf(2), Integer.valueOf(this.lJc), "", this.lEs, Long.valueOf(this.lDA), this.lDB);
                        this.lJj = true;
                        return;
                    }
                    return;
                case 5:
                    this.lIt = 3;
                    aDJ();
                    return;
                case 10:
                case 12:
                    switch (this.lJg) {
                        case 10233:
                            stringExtra = getString(R.l.eai);
                            break;
                        case 10234:
                            stringExtra = getString(R.l.ead);
                            break;
                        case 10235:
                            stringExtra = getString(R.l.ebG);
                            break;
                        default:
                            stringExtra = getString(R.l.ebK);
                            break;
                    }
                    h.b(this, stringExtra, null, true);
                    return;
                case 11:
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                default:
                    x.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", Integer.valueOf(this.lIt));
                    return;
            }
        } else if (id == R.h.cdx) {
            aDL();
        } else if (id == R.h.cdq) {
            aDL();
        } else {
            x.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.lzx != null && this.lzx.isShowing()) {
            this.lzx.dismiss();
        }
        switch (kVar.getType()) {
            case 412:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
                l lVar = (l) kVar;
                if (lVar == null || bi.oN(lVar.lEs) || !lVar.lEs.equalsIgnoreCase(this.lEs)) {
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0) {
                    if (i2 == 0) {
                        this.lGN = lVar.aCz();
                        ph(1002);
                        return;
                    } else if (i2 == 1) {
                        aDB();
                        return;
                    } else {
                        this.lIA.setText(R.l.eaK);
                        aDC();
                        return;
                    }
                } else if (i2 == 5) {
                    if (!(lVar == null || lVar.aCz() == null)) {
                        this.lGN.whA = lVar.aCz().whA;
                    }
                    ph(1002);
                    return;
                } else if (i2 == 1) {
                    aDB();
                    return;
                } else {
                    this.lIC.setVisibility(8);
                    this.klX.setVisibility(0);
                    this.lIA.setText(R.l.eaL);
                    aDC();
                    return;
                }
            case 423:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
                g gVar = (g) kVar;
                if (gVar == null || bi.oN(gVar.lEs) || !gVar.lEs.equalsIgnoreCase(this.lEs)) {
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.lJd = gVar.hCY;
                    this.lIt = 6;
                    aDJ();
                    return;
                } else {
                    this.lIt = -1;
                    aDJ();
                    String str2 = this.lEt;
                    h.a((Context) this, String.format(getString(R.l.eaG), new Object[]{str2}), "", new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            EmojiStoreDetailUI.this.lIv = new g(EmojiStoreDetailUI.this.lEs, EmojiStoreDetailUI.this.lEu, EmojiStoreDetailUI.this.lEt);
                            EmojiStoreDetailUI.this.aDM();
                            EmojiStoreDetailUI.this.lIt = 6;
                            EmojiStoreDetailUI.this.aDJ();
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
            case 521:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
                com.tencent.mm.plugin.emoji.f.k kVar2 = (com.tencent.mm.plugin.emoji.f.k) kVar;
                if (kVar2 == null || bi.oN(kVar2.lEi) || !kVar2.lEi.equalsIgnoreCase(this.lEs)) {
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                } else {
                    if (i == 0 && i2 == 0) {
                        this.lJm = (acc) kVar2.gLB.hnR.hnY;
                    } else {
                        this.lJm = null;
                    }
                    this.lJn = true;
                    aDK();
                }
                this.lJn = true;
                aDK();
                return;
            case 822:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
                if (i == 0 && i2 == 0) {
                    this.lIy = ((o) kVar).aCD();
                    ph(1007);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void aDB() {
        this.klX.setVisibility(0);
        this.lIB.setVisibility(8);
        this.lIC.setVisibility(8);
        this.lIA.setText(R.l.eah);
    }

    private void aDC() {
        x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
        if (this.lGN == null || this.lGN.whA == 0) {
            this.klX.setVisibility(0);
            this.lIB.setVisibility(8);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        String str;
        String stringExtra;
        if (i == 2001) {
            str = "";
            int intExtra;
            if (intent != null) {
                intExtra = intent.getIntExtra("key_err_code", 0);
                x.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:" + intExtra);
                stringExtra = intent.getStringExtra("key_err_msg");
                x.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:" + stringExtra);
            } else {
                stringExtra = str;
                intExtra = 0;
            }
            this.lJj = false;
            if (i2 != -1) {
                this.lIt = -1;
                aDJ();
                if (com.tencent.mm.y.q.Gk()) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 2, 1, false);
                }
            } else if (intent != null && intExtra == 0) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                if (stringArrayListExtra == null || !stringArrayListExtra.contains(this.lEs)) {
                    this.lIt = -1;
                    aDJ();
                    ze(stringExtra);
                    return;
                }
                for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                    if (this.lEs.equals(stringArrayListExtra.get(i3))) {
                        this.lEu = (String) stringArrayListExtra2.get(i3);
                    }
                }
                this.lGN.whA = 1;
                aDM();
                this.lIt = 6;
                h.bu(this, stringExtra);
                if (com.tencent.mm.y.q.Gk()) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 4, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 0, 1, false);
                }
            } else if (intent != null && intExtra == 100000002) {
                aDM();
                this.lIt = 6;
                this.lIx.notifyDataSetChanged();
                if (com.tencent.mm.y.q.Gk()) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 7, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 3, 1, false);
                }
            } else if (intent == null || intExtra != 1) {
                this.lIt = -1;
                aDJ();
                ze(stringExtra);
                if (com.tencent.mm.y.q.Gk()) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 5, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 1, 1, false);
                }
            } else {
                this.lIt = -1;
                aDJ();
                if (com.tencent.mm.y.q.Gk()) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(166, 2, 1, false);
                }
            }
        } else if (i == 2002) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                if (!bi.oN(stringExtra)) {
                    x.d("MicroMsg.emoji.EmojiStoreDetailUI", ".." + stringExtra);
                    String str2 = this.lEs;
                    String str3 = this.lGN.whv;
                    String str4 = this.lGN.whw;
                    String str5 = this.lGN.nlA;
                    String str6 = this.lGN.whO;
                    int i4 = this.lGN.whA;
                    str = new StringBuffer(getResources().getString(R.l.dET)).append(str3).toString();
                    com.tencent.mm.pluginsdk.ui.applet.e.a aVar = new com.tencent.mm.pluginsdk.ui.applet.e.a(this);
                    aVar.bT(stringExtra).SU(str).Co(R.l.dGL);
                    aVar.SV(str5).cbF();
                    aVar.SX(getString(R.l.dUm)).a(new com.tencent.mm.plugin.emoji.e.k.AnonymousClass1(stringExtra, str2, str3, str4, str5, str6, i4, this)).pDT.show();
                }
            }
        } else if (i == this.lDE.jQy && i2 == -1) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", intent.getStringExtra("Select_Conv_User"));
            com.tencent.mm.plugin.emoji.h.b.a(intent, this.lEs, (Activity) this);
            com.tencent.mm.plugin.report.service.g.pWK.h(12069, Integer.valueOf(3), this.lEs);
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        ph(1001);
    }

    private void ze(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.eal);
        }
        h.a((Context) this, str, "", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void aDD() {
        this.lIy = com.tencent.mm.plugin.emoji.model.i.aCl().lCB.YI(this.lEs);
    }

    private void aDE() {
        if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.lGN.whA, 64) && com.tencent.mm.plugin.emoji.e.n.aBR()) {
            this.lIw = new o(this.lEs, o.lEP);
            as.CN().a(this.lIw, 0);
        }
    }

    private boolean aDF() {
        boolean aDF = com.tencent.mm.plugin.emoji.h.a.aDF();
        this.lIz = aDF;
        this.lIt = aDF ? 7 : 3;
        return aDF;
    }

    private void aDG() {
        if (!bi.oN(this.lGN.whv)) {
            setMMTitle(this.lGN.whv);
        }
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", this.lGN.whI);
        this.lIB.setVisibility(0);
        this.klX.setVisibility(8);
        eB(true);
        this.lIF.setText(this.lGN.whv);
        this.lIG.setText(this.lGN.whF);
        this.lII.setText(this.lGN.whw);
        if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.lGN.whz, 1)) {
            this.lIE.setVisibility(8);
        } else {
            this.lIE.setVisibility(0);
            this.lIE.setText(R.l.ebJ);
        }
        aDI();
        aDJ();
        aDK();
        if (com.tencent.mm.plugin.emoji.h.a.zu(this.lEs) || !(this.lGN.whL == null || this.lGN.whL.size() <= 0 || ((awi) this.lGN.whL.get(0)).wKw == null)) {
            this.lIJ.zNq = true;
            this.lJk.setVisibility(0);
        } else {
            this.lJk.setVisibility(8);
            this.lIJ.zNq = false;
        }
        this.lIJ.lEs = this.lEs;
        if (this.lIx != null) {
            this.lIx.notifyDataSetInvalidated();
        }
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", this.lGN.whA);
        if ((this.lGN.whA & 16) == 16) {
            addIconOptionMenu(0, R.k.dAb, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    x.d("MicroMsg.emoji.EmojiStoreDetailUI", "on shard click.");
                    EmojiStoreDetailUI.u(EmojiStoreDetailUI.this);
                    return true;
                }
            });
        }
        this.lIF.setMaxWidth((((this.lIO - this.lIP.getWidth()) - (com.tencent.mm.bu.a.aa(this.mController.xRr, R.f.bvK) * 2)) - this.lIE.getWidth()) - (com.tencent.mm.bu.a.aa(this.mController.xRr, R.f.bvz) * 2));
        this.lIF.setVisibility(8);
        this.lIF.setVisibility(0);
        if (this.lGN.whQ == null || this.lGN.whQ.wrt == 0 || this.lJc == 6) {
            this.lIU.setVisibility(8);
            this.lIR.setVisibility(8);
        } else {
            this.lIU.setVisibility(0);
            this.lIR.setVisibility(0);
            com.tencent.mm.ap.o.PG().a(this.lGN.whQ.whR, this.lIS, f.co(this.lEs, this.lGN.whQ.whR));
            this.lIT.setText(this.lGN.whQ.nkW);
            this.lIR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(EmojiStoreDetailUI.this.mController.xRr, EmojiStoreV2DesignerUI.class);
                    intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, EmojiStoreDetailUI.this.lGN.whQ.wrt);
                    intent.putExtra("name", EmojiStoreDetailUI.this.lGN.whQ.nkW);
                    intent.putExtra("headurl", EmojiStoreDetailUI.this.lGN.whQ.whR);
                    intent.putExtra("rediret_url", EmojiStoreDetailUI.this.lGN.whO);
                    intent.putExtra("searchID", EmojiStoreDetailUI.this.lDA);
                    intent.putExtra("extra_scence", 26);
                    EmojiStoreDetailUI.this.mController.xRr.startActivity(intent);
                }
            });
        }
        LayoutParams layoutParams;
        if ((this.lGN.whA & 32) == 32) {
            layoutParams = (LayoutParams) this.lIN.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.lIM.getLayoutParams();
            this.lIN.setVisibility(0);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 3;
            layoutParams.leftMargin = com.tencent.mm.bu.a.aa(this.mController.xRr, R.f.bvK);
            this.lIN.setLayoutParams(layoutParams);
            this.lIN.setGravity(3);
            layoutParams2.weight = 1.0f;
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = com.tencent.mm.bu.a.aa(this.mController.xRr, R.f.bvK);
            this.lIM.setLayoutParams(layoutParams2);
            this.lIM.setGravity(5);
        } else {
            layoutParams = (LayoutParams) this.lIM.getLayoutParams();
            layoutParams.gravity = 17;
            this.lIM.setLayoutParams(layoutParams);
            this.lIM.setGravity(17);
            this.lIN.setVisibility(8);
        }
        aDH();
    }

    private void eB(boolean z) {
        EmojiInfo emojiInfo;
        String str;
        if (bi.oN(this.lGN.whD)) {
            emojiInfo = null;
        } else if (z) {
            str = this.lEs;
            String str2 = this.lGN.whD;
            com.tencent.mm.bu.a.getDensity(this.mContext);
            emojiInfo = EmojiLogic.a(str, str2, this.lJt);
        } else {
            str = this.lEs;
            String str3 = this.lGN.whD;
            com.tencent.mm.bu.a.getDensity(this.mContext);
            emojiInfo = EmojiLogic.a(str, 4, str3, true);
        }
        if (!(emojiInfo == null || this.lID == null)) {
            this.lID.cY(emojiInfo.clq(), null);
        }
        if (com.tencent.mm.plugin.emoji.h.a.zu(this.lEs)) {
            this.lID.setImageResource(R.g.bHd);
        }
    }

    public final void aDH() {
        if (!com.tencent.mm.plugin.emoji.a.a.e.cs(this.lGN.whA, 64) || !com.tencent.mm.plugin.emoji.e.n.aBR()) {
            this.lIV.setVisibility(8);
        } else if (this.lIy != null) {
            this.lIV.setVisibility(0);
            this.lIX.setText(R.l.eaW);
            this.lIW.setText(this.lIy.wsa.whV);
            this.lIW.setLongClickable(false);
            if (this.lIy.wrJ > 0) {
                this.lIZ.setVisibility(0);
                String valueOf = String.valueOf(this.lIy.wrJ);
                Object format = String.format(getString(R.l.eaY), new Object[]{Integer.valueOf(this.lIy.wrJ)});
                CharSequence spannableString = new SpannableString(format);
                int indexOf = format.indexOf(valueOf);
                if (indexOf >= 0) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.e.bsd)), indexOf, valueOf.length() + indexOf, 33);
                }
                this.lIZ.setText(spannableString);
            } else {
                this.lIZ.setVisibility(8);
            }
            if (this.lIy.wrK == null || this.lIy.wrK.size() <= 0) {
                this.lIY.setVisibility(8);
                return;
            }
            this.lIY.setVisibility(0);
            this.lIY.b(this.lEs, this.lIy.wrK);
        } else {
            this.lIV.setVisibility(8);
            aDE();
        }
    }

    private void aDI() {
        if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.lGN.whz, 8)) {
            this.lJb = 0;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.lGN.whz, 4)) {
            this.lJb = 0;
        } else if (this.lJe || !TextUtils.isEmpty(this.lGN.why)) {
            this.lJb = 1;
        } else {
            this.lJb = 0;
        }
        x.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", Integer.valueOf(this.lGN.whA));
        if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.lGN.whA, 8) && com.tencent.mm.plugin.emoji.a.a.e.pc(this.lGN.whz)) {
            this.lIt = 8;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.lGN.whA, 1) || com.tencent.mm.plugin.emoji.a.a.e.cs(this.lGN.whz, 8)) {
            this.lIt = 3;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.pc(this.lGN.whz)) {
            this.lIt = 0;
        } else if (!this.lJe && (TextUtils.isEmpty(this.lGN.whG) || this.lGN.whG.equals("0"))) {
            this.lIt = 0;
        } else if (!this.lJe) {
            this.lIt = 4;
        } else if (TextUtils.isEmpty(this.lJh)) {
            this.lIt = this.lJf;
        } else {
            this.lIt = 4;
        }
        if (this.lIz) {
            this.lIt = 7;
        }
    }

    private void aDJ() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r6 = 3;
        r5 = 4;
        r3 = 1;
        r2 = 8;
        r4 = 0;
    L_0x0006:
        r0 = r7.lEs;
        r0 = com.tencent.mm.plugin.emoji.h.a.zu(r0);
        if (r0 == 0) goto L_0x0011;
    L_0x000e:
        r7.aDF();
    L_0x0011:
        r0 = r7.lIt;
        switch(r0) {
            case -1: goto L_0x01b5;
            case 0: goto L_0x0052;
            case 1: goto L_0x0016;
            case 2: goto L_0x0016;
            case 3: goto L_0x00c6;
            case 4: goto L_0x007a;
            case 5: goto L_0x0140;
            case 6: goto L_0x00ef;
            case 7: goto L_0x010e;
            case 8: goto L_0x002a;
            case 9: goto L_0x0016;
            case 10: goto L_0x0187;
            case 11: goto L_0x0158;
            case 12: goto L_0x0187;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = "MicroMsg.emoji.EmojiStoreDetailUI";
        r1 = "unknow product status:%d";
        r2 = new java.lang.Object[r3];
        r3 = r7.lIt;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r4] = r3;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
    L_0x0029:
        return;
    L_0x002a:
        r0 = r7.lIQ;
        r0.setVisibility(r2);
        r0 = r7.lIH;
        r1 = r7.getResources();
        r2 = com.tencent.mm.R.e.bsc;
        r1 = r1.getColorStateList(r2);
        r0.setTextColor(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.g.bAf;
        r0.setBackgroundResource(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.l.eaI;
        r0.setText(r1);
        r0 = r7.lIH;
        r0.setEnabled(r4);
        goto L_0x0029;
    L_0x0052:
        r0 = r7.lIQ;
        r0.setVisibility(r2);
        r0 = r7.lIH;
        r1 = r7.getResources();
        r2 = com.tencent.mm.R.e.bum;
        r1 = r1.getColorStateList(r2);
        r0.setTextColor(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.g.bAc;
        r0.setBackgroundResource(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.l.eaF;
        r0.setText(r1);
        r0 = r7.lIH;
        r0.setEnabled(r3);
        goto L_0x0029;
    L_0x007a:
        r0 = r7.lIQ;
        r0.setVisibility(r2);
        r0 = r7.lIH;
        r1 = r7.getResources();
        r2 = com.tencent.mm.R.e.bum;
        r1 = r1.getColorStateList(r2);
        r0.setTextColor(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.g.bAc;
        r0.setBackgroundResource(r1);
        r0 = r7.lIH;
        r0.setEnabled(r3);
        r0 = r7.lJe;
        if (r0 == 0) goto L_0x00b9;
    L_0x009e:
        r0 = r7.lJh;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x00b0;
    L_0x00a6:
        r0 = r7.lIH;
        r1 = "";
        r0.setText(r1);
        goto L_0x0029;
    L_0x00b0:
        r0 = r7.lIH;
        r1 = r7.lJh;
        r0.setText(r1);
        goto L_0x0029;
    L_0x00b9:
        r0 = r7.lIH;
        r1 = r7.lGN;
        r1 = r1.why;
        r0.setText(r1);
        r7.lIt = r5;
        goto L_0x0029;
    L_0x00c6:
        r0 = r7.lIQ;
        r0.setVisibility(r2);
        r0 = r7.lIH;
        r1 = r7.getResources();
        r2 = com.tencent.mm.R.e.bum;
        r1 = r1.getColorStateList(r2);
        r0.setTextColor(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.g.bAc;
        r0.setBackgroundResource(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.l.eaF;
        r0.setText(r1);
        r0 = r7.lIH;
        r0.setEnabled(r3);
        goto L_0x0029;
    L_0x00ef:
        r0 = r7.lIQ;
        r0.setVisibility(r2);
        r0 = r7.lIH;
        r0.setEnabled(r4);
        r0 = r7.lIL;
        r0.setVisibility(r4);
        r0 = r7.lIK;
        r0.setVisibility(r4);
        r0 = r7.lIH;
        r0.setVisibility(r5);
        r0 = r7.lIp;
        if (r0 == r6) goto L_0x0029;
    L_0x010c:
        goto L_0x0029;
    L_0x010e:
        r0 = r7.lIQ;
        r0.setVisibility(r2);
        r0 = r7.lIH;
        r0.setEnabled(r3);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.g.bAc;
        r0.setBackgroundResource(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.l.ebu;
        r0.setText(r1);
        r0 = r7.lIL;
        r0.setVisibility(r2);
        r0 = r7.lzi;
        r0.setProgress(r4);
        r0 = r7.lIK;
        r0.setVisibility(r5);
        r0 = r7.lIH;
        r0.setVisibility(r4);
        r0 = r7.lIp;
        if (r0 == r6) goto L_0x0029;
    L_0x013e:
        goto L_0x0029;
    L_0x0140:
        r0 = r7.lIQ;
        r0.setVisibility(r2);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.g.bAc;
        r0.setBackgroundResource(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.l.eaF;
        r0.setText(r1);
        r0 = r7.lIH;
        r0.setEnabled(r3);
    L_0x0158:
        r0 = r7.lIQ;
        r0.setVisibility(r4);
        r0 = r7.lIH;
        r0.setVisibility(r4);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.g.bIa;
        r0.setBackgroundResource(r1);
        r0 = r7.lIH;
        r1 = "";
        r0.setText(r1);
        r0 = r7.lIH;
        r0.setEnabled(r4);
        r0 = r7.lIL;
        r0.setVisibility(r2);
        r0 = r7.lzi;
        r0.setProgress(r4);
        r0 = r7.lIK;
        r0.setVisibility(r5);
        goto L_0x0029;
    L_0x0187:
        r0 = r7.lIQ;
        r0.setVisibility(r2);
        r0 = r7.lIH;
        r0.setVisibility(r4);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.g.bAc;
        r0.setBackgroundResource(r1);
        r0 = r7.lIH;
        r1 = com.tencent.mm.R.l.eaR;
        r0.setText(r1);
        r0 = r7.lIH;
        r0.setEnabled(r3);
        r0 = r7.lIL;
        r0.setVisibility(r2);
        r0 = r7.lzi;
        r0.setProgress(r4);
        r0 = r7.lIK;
        r0.setVisibility(r5);
        goto L_0x0029;
    L_0x01b5:
        r7.aDI();
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.aDJ():void");
    }

    private void aDK() {
        if (!this.lJn) {
            return;
        }
        if (this.lJm != null && (this.lJm.wrH & 1) == 1) {
            return;
        }
        if ((this.lGN == null || !com.tencent.mm.plugin.emoji.a.a.e.cs(this.lGN.whA, 1)) && this.lJm != null && !TextUtils.isEmpty(this.lJm.wrG)) {
            this.lIH.setText(this.lJm.wrG);
            this.lIH.setTextColor(this.mController.xRr.getResources().getColor(R.e.bsK));
            this.lIH.setBackgroundDrawable(null);
            this.lIH.setEnabled(false);
        }
    }

    private void aDL() {
        h.a((Context) this, R.l.eaA, 0, R.l.ebi, R.l.eaC, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (com.tencent.mm.plugin.emoji.h.a.zu(EmojiStoreDetailUI.this.lEs)) {
                    x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks stop tuzi downloading");
                    com.tencent.mm.plugin.emoji.f.a.aCq().aCs();
                } else {
                    as.CN().c(EmojiStoreDetailUI.this.lIv);
                }
                if (!TextUtils.isEmpty(EmojiStoreDetailUI.this.lJd)) {
                    com.tencent.mm.modelcdntran.g.MP().kL(EmojiStoreDetailUI.this.lJd);
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onClickClose] cancel RecvTask. CdnClientId:%s", EmojiStoreDetailUI.this.lJd);
                }
                if (com.tencent.mm.plugin.emoji.a.a.e.cs(EmojiStoreDetailUI.this.lGN.whA, 1) || com.tencent.mm.plugin.emoji.a.a.e.pc(EmojiStoreDetailUI.this.lGN.whz)) {
                    EmojiStoreDetailUI.this.lIt = 3;
                } else {
                    EmojiStoreDetailUI.this.lIt = -1;
                }
                com.tencent.mm.plugin.emoji.model.i.aCn().g(EmojiStoreDetailUI.this.lEs, EmojiStoreDetailUI.this.lIt, 0, EmojiStoreDetailUI.this.lJd);
                EmojiStoreDetailUI.this.lIL.setVisibility(8);
                EmojiStoreDetailUI.this.lzi.setProgress(0);
                EmojiStoreDetailUI.this.lIK.setVisibility(4);
                EmojiStoreDetailUI.this.lIH.setVisibility(0);
                EmojiStoreDetailUI.this.lIp;
                EmojiStoreDetailUI.this.aDJ();
                as.CN().a(new com.tencent.mm.plugin.emoji.f.q(EmojiStoreDetailUI.this.lEs, 2), 0);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void h(String str, int i, int i2, String str2) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        if (!bi.oN(str) && str.equals(this.lEs)) {
            if (!TextUtils.isEmpty(str2)) {
                this.lJd = str2;
            }
            if (i == -1) {
                if (this.lIt != -1) {
                    this.lIt = -1;
                    ph(1003);
                }
            } else if (i == 7) {
                this.lIt = 7;
                ph(1003);
            } else if (i != 6) {
                x.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
            } else if (!TextUtils.isEmpty(str) && str.equals(this.lEs)) {
                this.lIt = 6;
                this.sm = i2;
                ph(1004);
            }
        }
    }

    private void aDM() {
        if (com.tencent.mm.plugin.emoji.h.a.zu(this.lEs)) {
            com.tencent.mm.plugin.emoji.f.a.aCq();
            com.tencent.mm.plugin.emoji.f.a.aCr();
            return;
        }
        this.lIv = new g(this.lEs, this.lEu, this.lEt);
        as.CN().a(this.lIv, 0);
        switch (this.lGv) {
            case 9:
                com.tencent.mm.plugin.report.service.g.pWK.h(11598, Integer.valueOf(2), this.lEs);
                return;
            case 10:
                com.tencent.mm.plugin.report.service.g.pWK.h(11598, Integer.valueOf(1), this.lEs);
                return;
            case 11:
                com.tencent.mm.plugin.report.service.g.pWK.h(11598, Integer.valueOf(3), this.lEs);
                return;
            default:
                return;
        }
    }

    public final void ph(int i) {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(i);
        }
    }
}
