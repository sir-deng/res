package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.gk;
import com.tencent.mm.f.a.gm;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.f.a.nh;
import com.tencent.mm.f.a.qb;
import com.tencent.mm.f.a.qk;
import com.tencent.mm.f.a.ql;
import com.tencent.mm.f.a.qm;
import com.tencent.mm.f.a.rv;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.y.s;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsCommentDetailUI extends MMActivity implements e, com.tencent.mm.plugin.sns.b.h.a, com.tencent.mm.plugin.sns.model.b.b {
    public static int rFV = 34;
    private l contextMenuHelper;
    private String fAR;
    private String gAM;
    private com.tencent.mm.sdk.b.c jil = new com.tencent.mm.sdk.b.c<jt>() {
        {
            this.xmG = jt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            jt jtVar = (jt) bVar;
            if (jtVar instanceof jt) {
                switch (jtVar.fBu.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        SnsCommentDetailUI.this.bBp();
                        break;
                }
            }
            return false;
        }
    };
    private boolean jpY = false;
    private int kZv;
    private int kzv = 0;
    private ClipboardManager mCW;
    private int mScreenHeight;
    private int mScreenWidth;
    private OnClickListener nvF = new OnClickListener() {
        public final void onClick(View view) {
            x.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, view);
        }
    };
    private String oQL = "";
    private LinearLayout qYm;
    private View rFA;
    private b rFB;
    private ScaleAnimation rFC;
    private ScaleAnimation rFD;
    LinearLayout rFE;
    LinearLayout rFF;
    private LinkedList<bku> rFG;
    private int rFH = -1;
    private boolean rFI = false;
    private ar rFJ;
    private String rFK;
    private ar rFL;
    private int rFM = 0;
    private ImageView rFN;
    private k rFO;
    private boolean rFP = false;
    private long rFQ = 0;
    private bg rFR;
    private boolean rFS = false;
    private int rFT;
    private int rFU = 103;
    public int rFW = i.CTRL_INDEX;
    private g rFX;
    private com.tencent.mm.plugin.sns.ui.b.b rFY;
    private SnsTranslateResultView rFZ;
    private long rFt = 0;
    private long rFu = 0;
    private View rFv;
    private TextView rFw;
    private LinearLayout rFx;
    private SnsDetailLuckyHeader rFy;
    private ListView rFz;
    private boolean rGa = false;
    private Dialog rGb = null;
    private boolean rGc = false;
    private af rGd = new af();
    private com.tencent.mm.sdk.b.c rGe = new com.tencent.mm.sdk.b.c<qk>() {
        {
            this.xmG = qk.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qk qkVar = (qk) bVar;
            if (qkVar instanceof qk) {
                String str = qkVar.fIP.id;
                String str2 = qkVar.fIP.result;
                String str3 = qkVar.fIP.fIQ;
                if (qkVar.fIP.type == 1) {
                    SnsCommentDetailUI.a(SnsCommentDetailUI.this, str, str2, str3);
                } else if (qkVar.fIP.type == 2) {
                    SnsCommentDetailUI.a(SnsCommentDetailUI.this, str);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c rGf = new com.tencent.mm.sdk.b.c<ql>() {
        {
            this.xmG = ql.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ql qlVar = (ql) bVar;
            if (qlVar instanceof ql) {
                String str = qlVar.fIR.id;
                if (qlVar.fIR.type == 1) {
                    SnsCommentDetailUI.b(SnsCommentDetailUI.this, str);
                } else if (qlVar.fIR.type == 2) {
                    SnsCommentDetailUI.c(SnsCommentDetailUI.this, str);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c rGg = new com.tencent.mm.sdk.b.c<qm>() {
        {
            this.xmG = qm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qm qmVar = (qm) bVar;
            if (qmVar instanceof qm) {
                String str = qmVar.fIS.id;
                if (qmVar.fIS.type == 1) {
                    SnsCommentDetailUI.d(SnsCommentDetailUI.this, str);
                } else if (qmVar.fIS.type == 2) {
                    SnsCommentDetailUI.e(SnsCommentDetailUI.this, str);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c rGh = new com.tencent.mm.sdk.b.c<gm>() {
        {
            this.xmG = gm.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            gm gmVar = (gm) bVar;
            if (gmVar instanceof gm) {
                SnsCommentDetailUI.a(SnsCommentDetailUI.this, gmVar.fxt.fxw, gmVar.fxt.fxv, gmVar);
            }
            return false;
        }
    };
    private c rGi = new c();
    private OnClickListener rGj = new OnClickListener() {
        public final void onClick(View view) {
            String str = (String) view.getTag();
            x.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:" + str);
            Intent intent = new Intent();
            m e = SnsCommentDetailUI.this.iN(true);
            if (e.xD(32)) {
                k cVar = new com.tencent.mm.plugin.sns.a.b.c(e.bzj(), 1, 2, "", e.bzn(), e.byG());
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(cVar, 0);
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Scene", 37);
                com.tencent.mm.plugin.sns.c.a.ihN.d(intent, SnsCommentDetailUI.this);
                return;
            }
            intent.putExtra("Contact_User", str);
            com.tencent.mm.plugin.sns.c.a.ihN.d(intent, SnsCommentDetailUI.this);
        }
    };
    private OnClickListener rGk = new OnClickListener() {
        public final void onClick(View view) {
            x.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.this.bBo();
            if (SnsCommentDetailUI.this.rFI) {
                SnsCommentDetailUI.this.iM(true);
            }
        }
    };
    private com.tencent.mm.sdk.b.c rGl = new com.tencent.mm.sdk.b.c<qb>() {
        {
            this.xmG = qb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            SnsCommentDetailUI.this.bBn();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c rGm = new com.tencent.mm.sdk.b.c<gk>() {
        {
            this.xmG = gk.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return false;
        }
    };
    boolean rGn = false;
    private LinearLayout rGo = null;
    private boolean rGp = false;
    PhotosContent rGq = null;
    int rGr = 0;
    public com.tencent.mm.y.ak.b.a rGs = new com.tencent.mm.y.ak.b.a() {
        public final void v(String str, final boolean z) {
            new ag(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    if (z && !SnsCommentDetailUI.this.isFinishing() && SnsCommentDetailUI.this.rGr < 5) {
                        SnsCommentDetailUI.this.bBn();
                    }
                    SnsCommentDetailUI snsCommentDetailUI = SnsCommentDetailUI.this;
                    snsCommentDetailUI.rGr++;
                }
            }, 500);
        }
    };
    private bf rGt = null;
    private ao rxB;
    private c rxH;
    private com.tencent.mm.plugin.sns.f.b rxI;
    private r rxK = null;
    private boolean rxx;
    private boolean rxy = false;
    private SnsCommentFooter rxz;
    private OnTouchListener ryR = bi.chk();

    class b extends BaseAdapter {
        Activity activity;
        String fsC;
        public LinkedList<bku> rGY;
        LinkedList<bku> rGZ;

        class a {
            Object aAy;
            ImageView ikK;
            TextView ipP;
            TextView maq;
            TextView ppG;
            SnsTranslateResultView rHb;
            bku rHc;
            String userName;

            a() {
            }
        }

        public b(LinkedList<bku> linkedList, LinkedList<bku> linkedList2, Activity activity, String str) {
            this.rGY = linkedList;
            this.rGZ = linkedList2;
            this.activity = activity;
            this.fsC = str;
        }

        public final int getCount() {
            int i = 0;
            if (this.rGZ.size() > 0) {
                if (this.rGY != null) {
                    i = this.rGY.size();
                }
                return i + 1;
            } else if (this.rGY != null) {
                return this.rGY.size();
            } else {
                return 0;
            }
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence AX;
            com.tencent.mm.storage.x Xt;
            int length;
            CharSequence charSequence;
            int i2;
            CharSequence charSequence2;
            CharSequence charSequence3;
            Object charSequence4;
            String AX2;
            if (this.rGZ.size() > 0) {
                if (i == 0) {
                    return SnsCommentDetailUI.this.qYm;
                }
                i--;
            }
            bku bku = (bku) this.rGY.get(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = v.fw(this.activity).inflate(com.tencent.mm.plugin.sns.i.g.qNm, null);
                view.setOnTouchListener(SnsCommentDetailUI.this.ryR);
                a aVar2 = new a();
                aVar2.ikK = (ImageView) view.findViewById(f.qGB);
                aVar2.ikK.setOnClickListener(SnsCommentDetailUI.this.rGj);
                aVar2.ppG = (TextView) view.findViewById(f.qGK);
                aVar2.ppG.setOnTouchListener(new ab());
                aVar2.ppG.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        x.i("MicroMsg.SnsCommentDetailUI", "onClick nickTv");
                    }
                });
                aVar2.maq = (TextView) view.findViewById(f.qGN);
                aVar2.ipP = (TextView) view.findViewById(f.qGE);
                aVar2.ipP.setOnTouchListener(new ab());
                aVar2.ipP.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        x.i("MicroMsg.SnsCommentDetailUI", "onClick contentTv");
                    }
                });
                aVar2.rHb = (SnsTranslateResultView) view.findViewById(f.qLG);
                aVar2.rHb.setVisibility(8);
                if (SnsCommentDetailUI.this.kZv == 11) {
                    view.findViewById(f.qHL).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFc);
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                aVar = (a) view.getTag();
            }
            aVar.rHc = bku;
            aVar.userName = bku.vPp;
            int i3 = SnsCommentDetailUI.this.kZv == 11 ? 3 : 2;
            int i4 = SnsCommentDetailUI.this.kZv == 11 ? 3 : 2;
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.storage.x Xt2 = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xt(aVar.userName);
            if (i == 0 && this.rGZ.isEmpty()) {
                if (SnsCommentDetailUI.this.kZv == 11) {
                    view.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFd);
                } else {
                    view.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFO);
                }
            } else if (SnsCommentDetailUI.this.kZv == 11) {
                view.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFQ);
            } else {
                view.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFP);
            }
            if (i == 0) {
                view.findViewById(f.qKn).setVisibility(0);
                view.findViewById(f.qKo).setVisibility(8);
                if (SnsCommentDetailUI.this.kZv == 11) {
                    ((ImageView) view.findViewById(f.qKn)).setImageResource(com.tencent.mm.plugin.sns.i.i.qOR);
                }
            } else {
                view.findViewById(f.qKn).setVisibility(4);
                view.findViewById(f.qKo).setVisibility(0);
            }
            com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ikK, bku.vPp, true);
            aVar.ikK.setTag(bku.vPp);
            if (Xt2 != null) {
                AX = Xt2.AX();
            } else {
                Object AX3 = bku.wDh != null ? bku.wDh : bku.vPp;
            }
            m LQ = com.tencent.mm.plugin.sns.storage.h.LQ(SnsCommentDetailUI.this.fAR);
            aVar.ipP.setText(bku.noL + " ");
            String charSequence5 = aVar.ipP.getText().toString();
            if (LQ != null) {
                com.tencent.mm.kernel.g.Dr();
                Xt = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xt(LQ.field_userName);
            } else {
                Xt = null;
            }
            if (bku.wUs == 1) {
                if (Xt != null) {
                    String AX4 = Xt.AX();
                    length = SnsCommentDetailUI.this.getString(j.qQl).length();
                    charSequence4 = SnsCommentDetailUI.this.getString(j.qQl) + AX4 + SnsCommentDetailUI.this.getString(j.qQj) + charSequence5;
                    i2 = length;
                    length = 0;
                    charSequence2 = AX4;
                    charSequence3 = null;
                }
                charSequence4 = charSequence5;
                i2 = 0;
                length = 0;
                charSequence2 = null;
                charSequence3 = null;
            } else {
                if (!bi.oN(bku.wUH)) {
                    Xt = SnsCommentDetailUI.this.rFL.Xv(bku.wUH);
                    AX2 = Xt == null ? bku.wUH : Xt.AX();
                    int length2 = SnsCommentDetailUI.this.getString(j.qSc).length();
                    String str = SnsCommentDetailUI.this.getString(j.qSc) + AX2 + SnsCommentDetailUI.this.getString(j.qQj) + charSequence5;
                    i2 = 0;
                    length = length2;
                    charSequence2 = null;
                    Object charSequence32 = AX2;
                    charSequence4 = str;
                }
                charSequence4 = charSequence5;
                i2 = 0;
                length = 0;
                charSequence2 = null;
                charSequence32 = null;
            }
            aVar.ppG.setText(AX3, BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.d.i.f(aVar.ppG, i3);
            CharSequence jVar = new com.tencent.mm.pluginsdk.ui.d.j(aVar.ppG.getText());
            jVar.a(new n(bku.vPp, SnsCommentDetailUI.this.rFO, i3), AX3, 0, 33);
            aVar.ppG.setText(jVar, BufferType.SPANNABLE);
            aVar.maq.setText(az.l(this.activity, ((long) bku.pgR) * 1000));
            aVar.ipP.setText(charSequence4, BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.d.i.f(aVar.ipP, i4);
            charSequence4 = new com.tencent.mm.pluginsdk.ui.d.j(aVar.ipP.getText());
            if (charSequence2 != null) {
                charSequence4.a(new n(LQ.field_userName, SnsCommentDetailUI.this.rFO, i4), charSequence2, i2, 33);
            } else if (charSequence32 != null) {
                charSequence4.a(new n(bku.wUH, SnsCommentDetailUI.this.rFO, i4), charSequence32, length, 33);
            }
            aVar.ipP.setText(charSequence4, BufferType.SPANNABLE);
            aVar.ipP.setVisibility(0);
            SnsCommentDetailUI.this.contextMenuHelper.a(view, SnsCommentDetailUI.this.rFY.rVF, SnsCommentDetailUI.this.rFY.rVs);
            AX2 = ao.ei(SnsCommentDetailUI.this.fAR, String.valueOf(bku.wUn != 0 ? (long) bku.wUn : bku.wUq));
            if (ao.cf(AX2, 4) && aVar.rHb != null) {
                com.tencent.mm.plugin.sns.model.ao.b KW = ao.KW(AX2);
                if (KW != null) {
                    aVar.rHb.setVisibility(0);
                    if (!KW.hjU) {
                        aVar.rHb.yh(2);
                    } else if (KW.hmT) {
                        aVar.rHb.setVisibility(8);
                    } else {
                        aVar.rHb.a(KW, 2, KW.result, KW.hrN, KW.rdE);
                    }
                } else {
                    aVar.rHb.setVisibility(8);
                }
            }
            view.setClickable(true);
            x.d("MicroMsg.SnsCommentDetailUI", "position " + bku.vPp + " self " + SnsCommentDetailUI.this.gAM + " commentid " + bku.wUn + " snsid " + SnsCommentDetailUI.this.fAR);
            if (SnsCommentDetailUI.this.gAM.equals(bku.vPp)) {
                aVar.aAy = bku;
            } else {
                aVar.aAy = new Object[]{Integer.valueOf(i), bku, bku.vPp, AX3};
            }
            m mVar = new m(SnsCommentDetailUI.this.fAR, bku, bku.vPp, bku.noL, aVar.ipP, 2);
            mVar.tag = aVar;
            view.setTag(mVar);
            view.setOnClickListener(SnsCommentDetailUI.this.nvF);
            return view;
        }
    }

    class c implements Runnable {
        int Dy = -1;
        int lbp;
        private int offset = 0;
        private int rHd = -1;
        private int rHe = 10;

        c() {
        }

        public final void run() {
            this.rHe = 10;
            SnsCommentDetailUI.this.rFI = true;
            this.rHd = SnsCommentDetailUI.this.rxz.getTop();
            int i = this.rHd - this.lbp;
            x.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", Integer.valueOf(SnsCommentDetailUI.this.rFz.getBottom()), Integer.valueOf(SnsCommentDetailUI.this.rFH), Integer.valueOf(this.rHd), Integer.valueOf(SnsCommentDetailUI.this.rxz.getTop()), Integer.valueOf(i));
            if (i == this.offset) {
                SnsCommentDetailUI.this.rFz.setSelectionFromTop(SnsCommentDetailUI.this.rFz.getHeaderViewsCount() + this.Dy, i);
                this.rHe = 0;
                this.offset = 0;
                return;
            }
            int i2 = this.rHe;
            this.rHe = i2 - 1;
            if (i2 > 0) {
                new ag().postDelayed(this, 100);
                this.offset = i;
                return;
            }
            this.offset = 0;
            this.rHe = 0;
        }
    }

    class a extends n {
        a() {
        }

        public final void onClick(View view) {
            SnsCommentDetailUI.this.rFR.rSw.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = SnsCommentDetailUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.ltt);
            if (this.oFf) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI$38 */
    class AnonymousClass38 implements AnimationListener {
        boolean rGN = false;
        final /* synthetic */ LinearLayout rGO;

        AnonymousClass38(LinearLayout linearLayout) {
            this.rGO = linearLayout;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.rGO != null) {
                this.rGO.setPressed(false);
            }
            if (!this.rGN) {
                this.rGN = true;
                if (SnsCommentDetailUI.this.rFA != null) {
                    SnsCommentDetailUI.this.rFA.clearAnimation();
                    SnsCommentDetailUI.this.rFA.setVisibility(8);
                }
            }
            SnsCommentDetailUI.this.rxy = false;
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    static /* synthetic */ int a(SnsCommentDetailUI snsCommentDetailUI, bpb bpb, m mVar) {
        if (bpb.wYj.wfg != 27 || bpb.wYj.wfh.size() < 2) {
            return 0;
        }
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = mVar.field_likeFlag == 1 ? 1 : 0;
        if (snsCommentDetailUI.rFX != null && ((are) bpb.wYj.wfh.get(i5)).kzz == 6) {
            snsCommentDetailUI.rFX.p(mVar.field_snsId, mVar.field_likeFlag == 1);
        }
        if (mVar.field_likeFlag == 1) {
            i = 0;
            i2 = 1;
        } else {
            i = 1;
            i2 = 0;
        }
        are are = (are) bpb.wYj.wfh.get(i2);
        are are2 = (are) bpb.wYj.wfh.get(i);
        final View findViewById = snsCommentDetailUI.rFv.findViewById(f.qLS);
        final View a = snsCommentDetailUI.a(are, i2, false);
        final View a2 = snsCommentDetailUI.a(are2, i, true);
        int[] iArr = new int[2];
        findViewById.getLocationOnScreen(iArr);
        findViewById.setPivotY((float) ((snsCommentDetailUI.mScreenHeight / 2) - iArr[1]));
        findViewById.setCameraDistance(8000.0f);
        float width = ((float) findViewById.getWidth()) / 2.0f;
        float height = ((float) findViewById.getHeight()) / 2.0f;
        if (mVar.field_likeFlag == 1) {
            i3 = -90;
            i4 = 90;
        } else {
            i3 = 90;
            i4 = -90;
        }
        Animation aVar = new com.tencent.mm.plugin.sns.ui.widget.a(findViewById.getContext(), 0.0f, (float) i4, width, height, true);
        aVar.setDuration(187);
        aVar.setInterpolator(new AccelerateInterpolator());
        aVar.setFillAfter(true);
        final float f = width;
        final float f2 = height;
        aVar.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                a2.setVisibility(0);
                a.setVisibility(8);
                SnsCommentDetailUI.this.xT(i);
                Animation aVar = new com.tencent.mm.plugin.sns.ui.widget.a(findViewById.getContext(), (float) i3, 0.0f, f, f2, false);
                aVar.setDuration(187);
                aVar.setInterpolator(new DecelerateInterpolator());
                aVar.setFillAfter(true);
                findViewById.startAnimation(aVar);
            }
        });
        findViewById.startAnimation(aVar);
        snsCommentDetailUI.rxy = true;
        return 374;
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, int i, int i2, gm gmVar) {
        if (i2 == -1) {
            m iN = snsCommentDetailUI.iN(false);
            if (iN != null) {
                bpb byF = iN.byF();
                if (byF.wYj.wfg == 1 && byF.wYj.wfh.size() == 4 && i > 1) {
                    i++;
                }
                if (snsCommentDetailUI.rGq != null) {
                    TagImageView tagImageView = (TagImageView) snsCommentDetailUI.rGq.findViewById(ar.rJX[i]);
                    if (tagImageView != null) {
                        int[] iArr = new int[2];
                        tagImageView.getLocationInWindow(iArr);
                        gmVar.fxu.fpF = iArr[0];
                        gmVar.fxu.fpG = iArr[1];
                        gmVar.fxu.fpH = tagImageView.getWidth();
                        gmVar.fxu.fpI = tagImageView.getHeight();
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, View view) {
        a aVar = view.getTag() instanceof m ? (a) ((m) view.getTag()).tag : null;
        if (aVar == null) {
            return;
        }
        if (aVar.aAy instanceof bku) {
            if (snsCommentDetailUI.rFI) {
                snsCommentDetailUI.iM(false);
            }
            final bku bku = (bku) aVar.aAy;
            final CharSequence charSequence = aVar.ipP.getText().toString();
            Context context = snsCommentDetailUI.mController.xRr;
            String[] strArr = new String[]{snsCommentDetailUI.mController.xRr.getString(j.dED), snsCommentDetailUI.mController.xRr.getString(j.dEH)};
            snsCommentDetailUI.mController.xRr.getString(j.dEy);
            com.tencent.mm.ui.base.h.a(context, null, strArr, new com.tencent.mm.ui.base.h.c() {
                public final void jo(int i) {
                    switch (i) {
                        case 0:
                            SnsCommentDetailUI.this.mCW.setText(charSequence);
                            com.tencent.mm.ui.base.h.bu(SnsCommentDetailUI.this.mController.xRr, SnsCommentDetailUI.this.mController.xRr.getString(j.dEE));
                            String fM = bi.fM(u.Mk(SnsCommentDetailUI.this.fAR));
                            if (bku != null && charSequence != null && fM != null) {
                                int i2 = com.tencent.mm.plugin.secinforeport.a.a.qlf;
                                com.tencent.mm.plugin.secinforeport.a.a.d(4, fM + ":" + bku.wUn, bi.We(charSequence.toString()));
                                return;
                            }
                            return;
                        case 1:
                            int i3;
                            String str = "MicroMsg.SnsCommentDetailUI";
                            StringBuilder append = new StringBuilder("del snsId:").append(SnsCommentDetailUI.this.fAR).append(" commentId:");
                            if (bku != null) {
                                i3 = bku.wUn;
                            } else {
                                i3 = 0;
                            }
                            x.e(str, append.append(i3).toString());
                            final k qVar = new q(u.Mk(SnsCommentDetailUI.this.fAR), u.Ka(SnsCommentDetailUI.this.fAR) ? 4 : 6, bku);
                            com.tencent.mm.kernel.g.Dr();
                            com.tencent.mm.kernel.g.Dp().gRu.a(qVar, 0);
                            SnsCommentDetailUI snsCommentDetailUI = SnsCommentDetailUI.this;
                            Context context = SnsCommentDetailUI.this;
                            SnsCommentDetailUI.this.getString(j.dGZ);
                            snsCommentDetailUI.rxK = com.tencent.mm.ui.base.h.a(context, SnsCommentDetailUI.this.getString(j.qQw), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    com.tencent.mm.kernel.g.Dr();
                                    com.tencent.mm.kernel.g.Dp().gRu.c(qVar);
                                }
                            });
                            return;
                        default:
                            return;
                    }
                }
            });
        } else if (aVar.aAy instanceof Object[]) {
            final Object[] objArr = (Object[]) aVar.aAy;
            SnsCommentFooter snsCommentFooter = snsCommentDetailUI.rxz;
            boolean z = !(snsCommentFooter.raa == null || snsCommentFooter.raa.vPp == null || !snsCommentFooter.raa.vPp.equals((String) objArr[2])) || snsCommentFooter.bBt();
            if (z) {
                snsCommentDetailUI.rxz.a(snsCommentDetailUI.getString(j.qSc) + objArr[3], (bku) objArr[1]);
                snsCommentDetailUI.rxz.iO(true);
                int intValue = ((Integer) objArr[0]).intValue();
                if (ai.n(com.tencent.mm.plugin.sns.storage.h.LR(snsCommentDetailUI.rFK)).wUR.size() > 0) {
                    intValue++;
                    if (intValue > snsCommentDetailUI.rFB.getCount()) {
                        intValue = snsCommentDetailUI.rFB.getCount() - 1;
                    }
                }
                snsCommentDetailUI.rGi.Dy = intValue;
                snsCommentDetailUI.rGi.lbp = view.getHeight();
                snsCommentDetailUI.bzP();
                return;
            }
            String[] strArr2 = new String[]{snsCommentDetailUI.getString(j.qSc) + objArr[3]};
            snsCommentDetailUI.getString(j.dEy);
            com.tencent.mm.ui.base.h.a((Context) snsCommentDetailUI, null, strArr2, new com.tencent.mm.ui.base.h.c() {
                public final void jo(int i) {
                    switch (i) {
                        case 0:
                            SnsCommentDetailUI.this.rxz.a(SnsCommentDetailUI.this.getString(j.qSc) + objArr[3], (bku) objArr[1]);
                            SnsCommentDetailUI.this.rxz.iO(true);
                            int intValue = ((Integer) objArr[0]).intValue();
                            if (ai.n(com.tencent.mm.plugin.sns.storage.h.LR(SnsCommentDetailUI.this.rFK)).wUR.size() > 0) {
                                intValue++;
                                if (intValue > SnsCommentDetailUI.this.rFB.getCount()) {
                                    intValue = SnsCommentDetailUI.this.rFB.getCount() - 1;
                                }
                            }
                            SnsCommentDetailUI.this.rGi.Dy = intValue;
                            SnsCommentDetailUI.this.rGi.run();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ao.cd(str, 4);
        if (snsCommentDetailUI.rFB != null) {
            snsCommentDetailUI.rFB.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str, bku bku, int i) {
        if (str != null && !str.trim().equals("") && u.Mm(snsCommentDetailUI.fAR)) {
            m LQ = com.tencent.mm.plugin.sns.storage.h.LQ(snsCommentDetailUI.fAR);
            bku a = com.tencent.mm.plugin.sns.model.al.a.a(LQ, LQ.xD(32) ? 8 : 2, str, bku, true, i);
            if (ai.m(LQ) != null) {
                b bVar = snsCommentDetailUI.rFB;
                bVar.rGY.add(a);
                bVar.notifyDataSetChanged();
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        SnsCommentDetailUI.this.rFz.setSelection((SnsCommentDetailUI.this.rFz.getHeaderViewsCount() + b.this.rGY.size()) - 1);
                    }
                }, 60);
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str, String str2, String str3) {
        m iN = snsCommentDetailUI.iN(false);
        if (iN != null && iN.byG().equals(str)) {
            if (bi.oN(str2)) {
                snsCommentDetailUI.rFZ.setVisibility(8);
            } else {
                ao.cd(str, 4);
                com.tencent.mm.plugin.sns.model.ao.b KW = ao.KW(str);
                snsCommentDetailUI.rFZ.setVisibility(0);
                snsCommentDetailUI.rFZ.a(KW, 1, str2, str3, KW.rdE);
            }
            snsCommentDetailUI.rFw.setTag(new as(snsCommentDetailUI.fAR, iN.bza(), true, false, 2));
        }
    }

    static /* synthetic */ void b(SnsCommentDetailUI snsCommentDetailUI, String str) {
        if (snsCommentDetailUI.iN(false).byG().equals(str)) {
            snsCommentDetailUI.rFZ.setVisibility(0);
            snsCommentDetailUI.rFZ.yh(1);
        }
    }

    static /* synthetic */ void c(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ao.cd(str, 4);
        if (snsCommentDetailUI.rFB != null) {
            snsCommentDetailUI.rFB.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void d(SnsCommentDetailUI snsCommentDetailUI, String str) {
        m iN = snsCommentDetailUI.iN(false);
        if (iN.byG().equals(str)) {
            ao.ce(str, 4);
            snsCommentDetailUI.rFZ.setVisibility(8);
            snsCommentDetailUI.rFw.setTag(new as(snsCommentDetailUI.fAR, iN.bza(), true, false, 2));
        }
    }

    static /* synthetic */ void e(SnsCommentDetailUI snsCommentDetailUI, String str) {
        ao.ce(str, 4);
        if (snsCommentDetailUI.rFB != null) {
            snsCommentDetailUI.rFB.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void s(SnsCommentDetailUI snsCommentDetailUI) {
        if (snsCommentDetailUI.rxz != null) {
            snsCommentDetailUI.rxz.iO(false);
            if (snsCommentDetailUI.rxz.bBt()) {
                snsCommentDetailUI.rxz.bBz();
            } else {
                snsCommentDetailUI.rxz.state = 0;
            }
        }
    }

    static /* synthetic */ void u(SnsCommentDetailUI snsCommentDetailUI) {
        int i;
        int count = snsCommentDetailUI.rFB.getCount() - 1;
        bku bBA = snsCommentDetailUI.rxz.bBA();
        long j = bBA.wUn != 0 ? (long) bBA.wUn : bBA.wUq;
        if (bBA != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= snsCommentDetailUI.rFB.rGY.size()) {
                    break;
                }
                bku bku = (bku) snsCommentDetailUI.rFB.rGY.get(i);
                if ((bku.wUn != 0 ? (long) bku.wUn : bku.wUq) == j) {
                    break;
                }
                i2 = i + 1;
            }
            snsCommentDetailUI.rGi.lbp = snsCommentDetailUI.bBl();
            if (ai.m(com.tencent.mm.plugin.sns.storage.h.LQ(snsCommentDetailUI.fAR)).wUR.size() > 0) {
                i++;
                if (i > snsCommentDetailUI.rFB.getCount()) {
                    i = snsCommentDetailUI.rFB.getCount() - 1;
                }
            }
            snsCommentDetailUI.rGi.Dy = i;
            snsCommentDetailUI.bzP();
        }
        i = count;
        snsCommentDetailUI.rGi.lbp = snsCommentDetailUI.bBl();
        if (ai.m(com.tencent.mm.plugin.sns.storage.h.LQ(snsCommentDetailUI.fAR)).wUR.size() > 0) {
            i++;
            if (i > snsCommentDetailUI.rFB.getCount()) {
                i = snsCommentDetailUI.rFB.getCount() - 1;
            }
        }
        snsCommentDetailUI.rGi.Dy = i;
        snsCommentDetailUI.bzP();
    }

    static /* synthetic */ void v(SnsCommentDetailUI snsCommentDetailUI) {
        int i = 1;
        if (u.Mm(snsCommentDetailUI.fAR)) {
            m LQ = com.tencent.mm.plugin.sns.storage.h.LQ(snsCommentDetailUI.fAR);
            if (LQ.field_likeFlag == 0) {
                LQ.field_likeFlag = 1;
                com.tencent.mm.plugin.sns.storage.h.a(LQ.byG(), LQ);
                if (LQ.xD(32)) {
                    i = 7;
                }
                com.tencent.mm.plugin.sns.model.al.a.a(LQ, i, "");
                snsCommentDetailUI.rFB.notifyDataSetChanged();
            } else {
                LQ.field_likeFlag = 0;
                com.tencent.mm.plugin.sns.storage.h.a(LQ.byG(), LQ);
                com.tencent.mm.plugin.sns.model.al.a.KV(LQ.byG());
            }
            blf m = ai.m(com.tencent.mm.plugin.sns.storage.h.LQ(snsCommentDetailUI.fAR));
            if (m != null) {
                snsCommentDetailUI.rFG = m.wUR;
                snsCommentDetailUI.g(m.wUR, m.wUU.isEmpty());
                b bVar = snsCommentDetailUI.rFB;
                bVar.rGZ = m.wUR;
                bVar.notifyDataSetChanged();
            }
        }
    }

    private static boolean f(LinkedList<bku> linkedList, LinkedList<bku> linkedList2) {
        if (linkedList == null || linkedList2 == null) {
            return false;
        }
        if (linkedList.size() != linkedList2.size()) {
            return false;
        }
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            if (!((bku) linkedList.get(i)).vPp.equals(((bku) linkedList2.get(i)).vPp)) {
                return false;
            }
        }
        return true;
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
    }

    private void iM(boolean z) {
        this.rFI = false;
        if (this.rxz.bBt()) {
            this.rxz.bBz();
            this.rxz.MB(getString(j.qSG));
        }
        this.rxz.iO(false);
        if (z) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(this.rFz);
        }
    }

    private m iN(boolean z) {
        m LQ;
        if (bi.oN(this.rFK)) {
            LQ = com.tencent.mm.plugin.sns.storage.h.LQ(this.fAR);
            if (LQ == null) {
                finish();
                return null;
            }
            this.rFK = LQ.bza();
            return LQ;
        }
        LQ = com.tencent.mm.plugin.sns.storage.h.LR(this.rFK);
        if (LQ == null) {
            if (z) {
                Toast.makeText(this, j.qRJ, 0).show();
            }
            finish();
            return null;
        }
        this.fAR = LQ.byG();
        return LQ;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        com.tencent.mm.pluginsdk.e.h(this);
        super.onCreate(bundle);
        ae.bvV().a(5, "@__weixintimtline", (com.tencent.mm.plugin.sns.b.h.a) this);
        this.mCW = (ClipboardManager) getSystemService("clipboard");
        this.rFt = System.currentTimeMillis();
        this.contextMenuHelper = new l(this);
        this.rFR = new bg(this, new com.tencent.mm.plugin.sns.ui.bg.a() {
            public final void bBq() {
                SnsCommentDetailUI.this.bBp();
            }
        }, 1, this.rGd);
        this.rFY = new com.tencent.mm.plugin.sns.ui.b.b(this, this.rGd) {
            public final void b(View view, int i, int i2, int i3) {
            }

            public final void bM(Object obj) {
                SnsCommentDetailUI.this.bBo();
                SnsCommentDetailUI.this.rxB.a((View) obj, 2, null);
            }

            public final void bzQ() {
            }

            public final void cE(View view) {
            }

            public final void cD(View view) {
            }

            public final void cB(View view) {
            }

            public final void cC(View view) {
            }

            public final void cF(View view) {
                SnsCommentDetailUI.this.rxH.cA(view);
            }

            public final void bzR() {
                SnsCommentDetailUI.this.rxH.bzC();
            }

            public final void cG(View view) {
                SnsCommentDetailUI.this.rxH.bwW();
                Intent intent = new Intent();
                intent.putExtra("result_finish", true);
                SnsCommentDetailUI.this.setResult(-1, intent);
                SnsCommentDetailUI.this.finish();
            }
        };
        FrameLayout frameLayout = (FrameLayout) findViewById(f.qLO);
        this.rxI = new com.tencent.mm.plugin.sns.f.b(this, this.rFY, frameLayout);
        this.rxH = new c(this, this.rFY, frameLayout, this.rxI);
        this.rFY.aVm();
        this.fAR = bi.aD(getIntent().getStringExtra("INTENT_SNSID"), "");
        if (bi.oN(this.fAR)) {
            this.fAR = u.af("sns_table_", getIntent().getLongExtra("INTENT_SNSID", 0));
        }
        this.rFK = bi.aD(getIntent().getStringExtra("INTENT_SNS_LOCAL_ID"), "");
        if (bi.oN(this.rFK)) {
            int intExtra = getIntent().getIntExtra("INTENT_SNS_LOCAL_ID", -1);
            if (intExtra != -1) {
                this.rFK = u.af("sns_table_", (long) intExtra);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_SNS_TIMELINEOBJECT");
        if (byteArrayExtra != null) {
            bpb bpb = new bpb();
            try {
                bpb.aH(byteArrayExtra);
                if (ae.bwf().eS(new BigInteger(bpb.nMq).longValue()) == null) {
                    x.i("MicroMsg.SnsCommentDetailUI", "info is null, can insert to sns info");
                    com.tencent.mm.sdk.e.c mVar = new m();
                    mVar.field_snsId = new BigInteger(bpb.nMq).longValue();
                    try {
                        mVar.field_content = bpb.toByteArray();
                    } catch (Exception e) {
                    }
                    mVar.field_createTime = bpb.pgR;
                    mVar.field_userName = bpb.kyG;
                    mVar.field_type = bpb.wYj.wfg;
                    mVar.byX();
                    blf blf = new blf();
                    blf.wUN = new bes();
                    try {
                        mVar.field_attrBuf = blf.toByteArray();
                    } catch (IOException e2) {
                    }
                    ae.bwf().b(mVar);
                    x.i("MicroMsg.FTS.SnsComment", "insert sns obj use time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } else {
                    x.i("MicroMsg.SnsCommentDetailUI", "info is not null, can not insert to sns info");
                }
            } catch (IOException e3) {
            }
        }
        m iN = iN(true);
        x.i("MicroMsg.SnsCommentDetailUI", "onCreate()  snsId : " + this.fAR + " localSnsId: " + this.rFK);
        if (iN != null) {
            x.i("MicroMsg.SnsCommentDetailUI", "commentdetail %s", bi.aD(iN.field_userName, ""));
        }
        if (u.Mm(this.fAR)) {
            if (!u.Ka(this.fAR)) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(new com.tencent.mm.plugin.sns.model.l(u.Mk(this.fAR), 0, iN.byD().rko), 0);
            } else if (iN == null) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(new p(u.Mk(this.fAR)), 0);
            } else if (!s.gG(iN.field_userName)) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dp().gRu.a(new p(u.Mk(this.fAR)), 0);
            }
        }
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a((int) i.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(218, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(682, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a((int) JsApiCheckIsSupportFaceDetect.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(683, (e) this);
        this.rFL = ae.bvT();
        this.rxB = new ao(this);
        this.rFJ = new ar(this.mController.xRr);
        this.rFO = new k(this, 1, this.rGd);
        if (iN != null) {
            this.kZv = av.d(iN.byF());
        }
        if (iN != null && iN.xD(32)) {
            this.rFX = new g(2);
            av.d(iN.byF());
        }
        initView();
        if (iN != null && iN.xD(32)) {
            this.rFX.a(0, iN.bza(), iN.bzj(), iN.byW(), this.rFv, iN.field_snsId, this.rGt, ai.m(iN), this.kZv, 2);
        }
        if (this.rFv != null) {
            com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) this.rFv.findViewById(f.image);
            if (iN.byF().wYj != null && iN.byF().wYj.wfg == 15 && (aVar instanceof SightPlayImageView)) {
                z = ((SightPlayImageView) aVar).qAD.btu();
            }
            com.tencent.mm.plugin.sns.a.b.j.a(iN, true, z);
        }
        if (this.rFz != null) {
            this.rFz.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (SnsCommentDetailUI.this.rxH != null) {
                        SnsCommentDetailUI.this.rxH.bwW();
                    }
                    return false;
                }
            });
            com.tencent.mm.sdk.b.a.xmy.b(this.jil);
            com.tencent.mm.sdk.b.a.xmy.b(this.rGe);
            com.tencent.mm.sdk.b.a.xmy.b(this.rGf);
            com.tencent.mm.sdk.b.a.xmy.b(this.rGg);
            com.tencent.mm.sdk.b.a.xmy.b(this.rGh);
            com.tencent.mm.sdk.b.a.xmy.b(this.rGl);
            com.tencent.mm.sdk.b.a.xmy.b(this.rGm);
            com.tencent.mm.pluginsdk.e.i(this);
        }
    }

    public void onDestroy() {
        ae.bvV().a(this, 5);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b((int) i.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(218, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b((int) JsApiCheckIsSupportFaceDetect.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(683, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(682, (e) this);
        ae.bwc().K(this);
        com.tencent.mm.sdk.b.a.xmy.c(this.jil);
        if (this.rFO != null) {
            this.rFO.activity = null;
        }
        ab.bAo();
        if (this.rxz != null) {
            this.rxz.aYy();
        }
        m iN = iN(false);
        if (!(this.rFX == null || iN == null || !iN.xD(32))) {
            this.rFX.t(0, iN.bza(), iN.bzj());
            com.tencent.mm.plugin.sns.storage.a byD = iN.byD();
            String str = byD == null ? "" : byD.rfQ;
            com.tencent.mm.plugin.sns.a.b.i bvZ;
            Object[] objArr;
            if (iN.bxo()) {
                bvZ = ae.bvZ();
                objArr = new Object[1];
                objArr[0] = com.tencent.mm.plugin.sns.a.b.f.a(iN.field_snsId, com.tencent.mm.plugin.sns.data.i.er(iN.field_snsId), str, Long.valueOf(this.rFt), Long.valueOf(System.currentTimeMillis()));
                bvZ.h(14652, objArr);
            } else {
                bvZ = ae.bvZ();
                objArr = new Object[1];
                objArr[0] = com.tencent.mm.plugin.sns.a.b.f.a(iN.field_snsId, com.tencent.mm.plugin.sns.data.i.er(iN.field_snsId), str, Long.valueOf(this.rFt), Long.valueOf(System.currentTimeMillis()));
                bvZ.h(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT, objArr);
            }
            com.tencent.mm.modelsns.b iy = com.tencent.mm.modelsns.b.iy(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
            iy.mF(com.tencent.mm.plugin.sns.data.i.er(iN.field_snsId)).mF(str).mF(this.rFt).mF(System.currentTimeMillis());
            iy.SE();
        }
        this.rFY.aCt();
        com.tencent.mm.sdk.b.a.xmy.c(this.rGe);
        com.tencent.mm.sdk.b.a.xmy.c(this.rGf);
        com.tencent.mm.sdk.b.a.xmy.c(this.rGg);
        com.tencent.mm.sdk.b.a.xmy.c(this.rGh);
        com.tencent.mm.sdk.b.a.xmy.c(this.rGl);
        com.tencent.mm.sdk.b.a.xmy.c(this.rGm);
        super.onDestroy();
    }

    public void onResume() {
        ae.bwa().a((com.tencent.mm.plugin.sns.model.b.b) this);
        if (this.rxz != null) {
            SnsCommentFooter snsCommentFooter = this.rxz;
            if (u.Mm(this.fAR)) {
                if (snsCommentFooter.rHg != null) {
                    snsCommentFooter.rHg.setEnabled(true);
                }
                if (snsCommentFooter.rHf != null) {
                    snsCommentFooter.rHf.setEnabled(true);
                }
            } else {
                if (snsCommentFooter.rHg != null) {
                    snsCommentFooter.rHg.setEnabled(false);
                }
                if (snsCommentFooter.rHf != null) {
                    snsCommentFooter.rHf.setEnabled(false);
                }
            }
        }
        com.tencent.mm.sdk.b.b rvVar = new rv();
        rvVar.fKt.fKu = 0;
        rvVar.fKt.fKv = 1;
        rvVar.fKt.fKw = 0;
        rvVar.fKt.type = 0;
        com.tencent.mm.sdk.b.a.xmy.m(rvVar);
        if (this.rFX != null) {
            this.rFX.onResume();
        }
        m iN = iN(false);
        if (iN != null && iN.xD(32) && iN.bxi()) {
            B(iN);
        }
        super.onResume();
    }

    public void onPause() {
        ae.bwa().b((com.tencent.mm.plugin.sns.model.b.b) this);
        super.onPause();
        this.rxz.oqc.onPause();
        new rv().fKt.type = 1;
        if (this.rFX != null) {
            this.rFX.onPause();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qNk;
    }

    protected final void initView() {
        setMMTitle(j.qQt);
        AnonymousClass17 anonymousClass17 = new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(SnsCommentDetailUI.this.rFz);
            }
        };
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (SnsCommentDetailUI.this.rxz != null) {
                    SnsCommentDetailUI.this.rxz.iO(false);
                }
                SnsCommentDetailUI.this.finish();
                return true;
            }
        });
        this.gAM = com.tencent.mm.y.q.FY();
        if (ae.bvO()) {
            finish();
        }
        final m iN = iN(true);
        if (iN == null) {
            x.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.fAR);
            finish();
            return;
        }
        boolean z;
        x.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.fAR + "localId " + this.rFK + "  username:" + iN.field_userName);
        if (!u.Mm(this.fAR) && iN.bzc()) {
            arf byS = iN.byS();
            findViewById(f.qLk).setVisibility(0);
            TextView textView = (TextView) findViewById(f.qJd);
            switch (byS.wFu) {
                case 201:
                    if (bi.oN(byS.wFC)) {
                        textView.setText(j.qRV);
                    } else {
                        textView.setText(byS.wFC);
                    }
                    findViewById(f.qLl).setVisibility(8);
                    z = false;
                    break;
                case i.CTRL_INDEX /*210*/:
                    if (bi.oN(byS.wFC)) {
                        textView.setText(j.qRX);
                    } else {
                        textView.setText(byS.wFC);
                    }
                    findViewById(f.qLl).setVisibility(8);
                    z = false;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                    if (bi.oN(byS.wFC)) {
                        textView.setText(j.qRW);
                    } else {
                        textView.setText(byS.wFC);
                    }
                    findViewById(f.qLl).setVisibility(8);
                    z = true;
                    break;
                default:
                    if (bi.oN(byS.wFC)) {
                        textView.setText(j.qRY);
                    } else {
                        textView.setText(byS.wFC);
                    }
                    findViewById(f.qLl).setVisibility(0);
                    z = true;
                    break;
            }
        }
        findViewById(f.qLk).setVisibility(8);
        z = false;
        if (z) {
            findViewById(f.qLk).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (!iN.xD(32)) {
                        ai.xb(iN.ruM);
                        ai.wZ(iN.ruM);
                        ae.bwb().buT();
                        Intent intent = new Intent();
                        SnsCommentDetailUI.this.setResult(-1, intent);
                        if (SnsCommentDetailUI.this.jpY) {
                            intent.putExtra("sns_gallery_force_finish", true);
                        }
                        SnsCommentDetailUI.this.finish();
                        SnsCommentDetailUI.this.finish();
                    }
                }
            });
        }
        this.rFz = (ListView) findViewById(f.qGI);
        this.rFz.post(new Runnable() {
            public final void run() {
                SnsCommentDetailUI.this.rFH = SnsCommentDetailUI.this.rFz.getBottom();
                x.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.this.rFH);
            }
        });
        this.rFz.setOnScrollListener(new OnScrollListener() {
            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 1) {
                    SnsCommentDetailUI.this.aWY();
                    SnsCommentDetailUI.s(SnsCommentDetailUI.this);
                }
            }
        });
        this.rFv = v.fw(this.mController.xRr).inflate(com.tencent.mm.plugin.sns.i.g.qNl, null);
        this.rFv.setOnClickListener(this.rGk);
        this.rFz.addHeaderView(this.rFv);
        z = bBn();
        if (z) {
            m iN2 = iN(false);
            if (iN2 != null) {
                this.kZv = av.d(iN2.byF());
            }
            if (this.kZv == 11 && com.tencent.mm.y.q.FY().equals(iN.field_userName)) {
                this.rFy = new SnsDetailLuckyHeader(this);
                this.rFy.setLayoutParams(new LayoutParams(-1, -2));
                this.rFy.setOnClickListener(this.rGk);
            }
            this.rFx = new LinearLayout(this.mController.xRr);
            this.rFx.setLayoutParams(new LayoutParams(-1, -2));
            this.rFx.setOnClickListener(this.rGk);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 2.0f);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 1);
            LinearLayout linearLayout = new LinearLayout(this.mController.xRr);
            linearLayout.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFR);
            linearLayout.setLayoutParams(layoutParams);
            this.qYm = linearLayout;
            if ((iN.field_localPrivate & 1) != 0) {
                findViewById(f.qHI).setVisibility(8);
                View textView2 = new TextView(this);
                textView2.setLayoutParams(new LayoutParams(-1, -2));
                textView2.setText(getString(j.qQz));
                textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                textView2.setGravity(17);
                textView2.setPadding(0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 7.0f), 0, 0);
                this.rFz.addFooterView(textView2);
            }
            if (this.rFy != null) {
                this.rGa = true;
                this.rFz.addHeaderView(this.rFy);
            }
            blf m = ai.m(iN);
            if (m == null) {
                this.rFx.setVisibility(8);
                this.rFB = new b(new LinkedList(), new LinkedList(), this, iN.bza());
            } else {
                this.rFG = m.wUR;
                g(m.wUR, m.wUU.isEmpty());
                if (this.rFy != null) {
                    this.rFy.a(iN, this.rFY);
                }
                this.rFB = new b(m.wUU, m.wUR, this, iN.bza());
            }
            this.rFz.addHeaderView(this.rFx);
            this.rFz.setAdapter(this.rFB);
            this.rxz = (SnsCommentFooter) findViewById(f.qHI);
            this.rxz.rHl = new a() {
                public final void bBr() {
                    if (com.tencent.mm.plugin.sns.lucky.a.m.Kz(iN.bza())) {
                        if (SnsCommentDetailUI.this.mController.xRL != 1 && !SnsCommentDetailUI.this.rxz.bBx()) {
                            SnsCommentDetailUI.u(SnsCommentDetailUI.this);
                        }
                    } else if (SnsCommentDetailUI.this.rGb == null || !SnsCommentDetailUI.this.rGb.isShowing()) {
                        SnsCommentDetailUI.this.rGb = com.tencent.mm.plugin.sns.lucky.ui.a.e(SnsCommentDetailUI.this.mController.xRr, SnsCommentDetailUI.this.rGq.xQ(0));
                    }
                }
            };
            this.rxz.rHm = new d() {
                public final void onShow() {
                    if (!SnsCommentDetailUI.this.rxz.rHi) {
                        SnsCommentDetailUI.u(SnsCommentDetailUI.this);
                    }
                }
            };
            iN2 = iN(true);
            if (!(iN2 == null || iN2.byZ())) {
                this.rxz.setVisibility(8);
            }
            this.rxz.bBu();
            this.rxz.bBy();
            this.rxz.a(new c() {
                public final void Mp(String str) {
                    int i = 1;
                    if (com.tencent.mm.plugin.sns.lucky.a.m.Kz(iN.bza())) {
                        bku bBA = SnsCommentDetailUI.this.rxz.bBA();
                        if (SnsCommentDetailUI.this.rxz.rHh != 1) {
                            i = 0;
                        }
                        SnsCommentDetailUI.a(SnsCommentDetailUI.this, str, bBA, i);
                        SnsCommentDetailUI.this.rxz.iO(false);
                        x.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
                        SnsCommentDetailUI.s(SnsCommentDetailUI.this);
                        new ag().postDelayed(new Runnable() {
                            public final void run() {
                                SnsCommentDetailUI.u(SnsCommentDetailUI.this);
                            }
                        }, 100);
                        return;
                    }
                    com.tencent.mm.plugin.sns.lucky.ui.a.e(SnsCommentDetailUI.this.mController.xRr, SnsCommentDetailUI.this.rGq.xQ(0));
                }
            });
            SnsCommentFooter snsCommentFooter = this.rxz;
            b anonymousClass15 = new b() {
                public final void bBs() {
                    SnsCommentDetailUI.v(SnsCommentDetailUI.this);
                    if (SnsCommentDetailUI.this.rFz.getFirstVisiblePosition() > 1 || SnsCommentDetailUI.this.rFz.getLastVisiblePosition() <= 0) {
                        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.b(SnsCommentDetailUI.this.rFz, 1);
                    }
                }
            };
            int i = iN.field_likeFlag;
            snsCommentFooter.rHf.setVisibility(0);
            snsCommentFooter.rHf.setOnClickListener(new com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass7(anonymousClass15));
            this.rxz.bBB();
            this.rFP = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
            if (this.rFP) {
                this.rFQ = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0);
                if (!(this.rFQ == 0 || this.rFB.rGY == null)) {
                    int i2 = 0;
                    while (i2 < this.rFB.rGY.size()) {
                        bku bku = (bku) this.rFB.rGY.get(i2);
                        if ((bku.wUn != 0 ? (long) bku.wUn : bku.wUq) == this.rFQ) {
                            int i3;
                            this.rFz.setSelection(i2);
                            com.tencent.mm.k.a Xv = this.rFL.Xv(bku.vPp);
                            String AX = Xv != null ? Xv.AX() : bku.wDh != null ? bku.wDh : bku.vPp;
                            this.rxz.a(getString(j.qSc) + AX, bku);
                            if (m.wUR.size() > 0) {
                                i3 = i2 + 1;
                                if (i3 > this.rFB.getCount()) {
                                    i3 = this.rFB.getCount() - 1;
                                }
                            } else {
                                i3 = i2;
                            }
                            this.rGi.Dy = i3;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            if (this.rFP) {
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        SnsCommentDetailUI.this.aWY();
                        SnsCommentDetailUI.this.rGi.lbp = SnsCommentDetailUI.this.bBl();
                        SnsCommentDetailUI.this.rGi.run();
                    }
                }, 100);
            }
            this.rFZ = (SnsTranslateResultView) this.rFv.findViewById(f.qLG);
            this.rFZ.az(((TextView) this.rFv.findViewById(f.caU)).getTextSize());
            this.rFZ.qdX.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFN);
            this.rFZ.qdX.setTag(new as(this.fAR, iN.bza(), false, true, 2));
            this.contextMenuHelper.a(this.rFZ.qdX, this.rFY.rVv, this.rFY.rVs);
            if (ao.cf(this.fAR, 4)) {
                com.tencent.mm.plugin.sns.model.ao.b KW = ao.KW(this.fAR);
                if (KW == null || !KW.hjU) {
                    this.rFZ.setVisibility(8);
                    return;
                }
                this.rFZ.setVisibility(0);
                this.rFZ.a(null, 1, KW.result, KW.hrN, false);
                return;
            }
            this.rFZ.setVisibility(8);
            return;
        }
        x.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader " + z);
        finish();
    }

    private int bBl() {
        if (this.rFz == null || this.rFz.getChildCount() <= 1) {
            return 0;
        }
        View childAt = this.rFz.getChildAt(0);
        if (childAt != null) {
            return childAt.getHeight();
        }
        return 0;
    }

    private LinearLayout xS(int i) {
        if (this.rGo == null) {
            this.rGo = (LinearLayout) v.fw(this).inflate(i, null);
            return this.rGo;
        }
        this.rGn = true;
        return this.rGo;
    }

    private static boolean bBm() {
        return (com.tencent.mm.plugin.sns.model.al.a.bwF() & 1) <= 0;
    }

    private void B(m mVar) {
        int i = 0;
        if (mVar != null && mVar.bxi()) {
            int i2 = com.tencent.mm.plugin.sns.i.e.qFM;
            int parseColor = Color.parseColor("#cdcdcd");
            int parseColor2 = Color.parseColor("#ffffff");
            Button button = (Button) this.rFv.findViewById(f.qHC);
            Button button2 = (Button) this.rFv.findViewById(f.qHD);
            if (button != null && button2 != null) {
                button.setOnClickListener(this.rFY.rVV);
                button2.setOnClickListener(this.rFY.rVW);
                if (mVar.byB().bxk()) {
                    int eu = u.eu(mVar.byB().rlq.rlv, mVar.bzk());
                    if (eu > 0 && eu <= 2) {
                        if (eu == 1) {
                            button2.setBackgroundColor(parseColor2);
                            button2.setTextColor(parseColor);
                            button2.setText(mVar.byB().rlq.xm(1));
                            button.setBackgroundResource(i2);
                            button.setTextColor(WebView.NIGHT_MODE_COLOR);
                            button.setText(mVar.byB().rlq.xl(0));
                        } else if (eu == 2) {
                            button.setBackgroundColor(parseColor2);
                            button.setTextColor(parseColor);
                            button.setText(mVar.byB().rlq.xm(0));
                            button2.setBackgroundResource(i2);
                            button2.setTextColor(WebView.NIGHT_MODE_COLOR);
                            button2.setText(mVar.byB().rlq.xl(1));
                        }
                        if (i != 0) {
                            button.setTextColor(WebView.NIGHT_MODE_COLOR);
                            button.setBackgroundResource(i2);
                            button2.setTextColor(WebView.NIGHT_MODE_COLOR);
                            button2.setBackgroundResource(i2);
                            button.setText(mVar.byB().bxe());
                            button2.setText(mVar.byB().bxf());
                        }
                    }
                }
                i = 1;
                if (i != 0) {
                    button.setTextColor(WebView.NIGHT_MODE_COLOR);
                    button.setBackgroundResource(i2);
                    button2.setTextColor(WebView.NIGHT_MODE_COLOR);
                    button2.setBackgroundResource(i2);
                    button.setText(mVar.byB().bxe());
                    button2.setText(mVar.byB().bxf());
                }
            }
        }
    }

    final boolean bBn() {
        m iN = iN(true);
        if (iN == null) {
            return false;
        }
        x.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.rFv.toString());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        cnE().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        this.mScreenWidth = this.mScreenHeight < this.mScreenWidth ? this.mScreenHeight : this.mScreenWidth;
        this.rFT = ae.bwn();
        bpb byF = iN.byF();
        this.kZv = av.d(byF);
        ImageView imageView = (ImageView) this.rFv.findViewById(f.qGA);
        if (imageView == null || iN == null) {
            x.e("MicroMsg.SnsCommentDetailUI", "unknow error ? " + (imageView == null) + " " + (iN == null));
            return false;
        }
        ((MaskImageButton) imageView).zuL = iN.bza();
        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, iN.getUserName(), true);
        imageView.setTag(iN.getUserName());
        imageView.setOnClickListener(this.rFY.rVt);
        TextView textView = (TextView) this.rFv.findViewById(f.cAs);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.storage.x Xv = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xv(iN.getUserName());
        x.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + iN.getUserName() + " " + iN.byG() + " " + iN.byT());
        if (Xv == null) {
            return false;
        }
        String str;
        int i;
        CharSequence jVar;
        String str2;
        View findViewById;
        com.tencent.mm.plugin.sns.storage.a byD;
        ViewStub viewStub;
        int i2;
        TagImageView tagImageView;
        final List linkedList;
        final com.tencent.mm.plugin.sns.storage.b byB;
        arg arg;
        float a;
        float a2;
        float fromDPToPix;
        int i3;
        arg arg2;
        final PhotosContent photosContent;
        final TagImageView xQ;
        final bpb bpb;
        final m mVar;
        ar arVar;
        PhotosContent photosContent2;
        String bza;
        int hashCode;
        int i4;
        final m mVar2;
        CharSequence charSequence;
        CharSequence charSequence2;
        AsyncTextView asyncTextView;
        AsyncTextView asyncTextView2;
        final com.tencent.mm.storage.x xVar;
        com.tencent.mm.plugin.sns.storage.a byD2;
        Iterator it;
        String str3;
        com.tencent.mm.k.a Xu;
        CharSequence jVar2;
        TextPaint paint;
        blf m;
        Iterator it2;
        Object obj;
        bku bku;
        Object obj2;
        Object obj3;
        StringBuilder append;
        final bpb bpb2;
        ImageButton imageButton;
        m iN2;
        final ImageView imageView2;
        final ImageView imageView3;
        final TextView textView2;
        final TextView textView3;
        final m mVar3;
        if (Xv.AV() == 0) {
            x.i("MicroMsg.SnsCommentDetailUI", "getContact %s", iN.getUserName());
            com.tencent.mm.y.ak.a.GW().a(iN.getUserName(), "", this.rGs);
        }
        String aD = bi.aD(Xv == null ? iN.getUserName() : Xv.AX(), "");
        if (iN.kg() && bi.oN(aD)) {
            com.tencent.mm.plugin.sns.storage.b byB2 = iN.byB();
            if (!(byB2 == null || bi.oN(byB2.fqG))) {
                LinearLayout linearLayout;
                ViewGroup.LayoutParams layoutParams;
                str = byB2.fqG;
                str.length();
                i = this.kZv != 11 ? 3 : 2;
                jVar = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, (CharSequence) str));
                jVar.f(new n(new com.tencent.mm.plugin.sns.data.a(iN.kg(), Xv.getUsername(), iN.bza(), 2), this.rFO, i), str);
                textView.setOnTouchListener(new ab());
                textView.setText(jVar, BufferType.SPANNABLE);
                ((TextView) this.rFv.findViewById(f.qMd)).setText("");
                this.rGt = new bf(this.rFv);
                if (iN.kg()) {
                    this.rGt.setVisibility(8);
                } else {
                    this.rGt.q(Long.valueOf(iN.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.rGt, 0, this.rFK, iN.field_snsId, iN.bzj()));
                    this.rGt.a(iN.byB(), iN.byD());
                    this.rGt.a(this.rFY.rVC, this.rFY.rVR);
                    this.rGt.setVisibility(0);
                }
                str2 = byF.wYg;
                this.rFw = (TextView) this.rFv.findViewById(f.caU);
                this.rFw.setTag(new as(this.fAR, iN.bza(), true, false, 2));
                this.contextMenuHelper.a(this.rFw, this.rFY.rVv, this.rFY.rVs);
                findViewById = this.rFv.findViewById(f.qHB);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                findViewById = this.rFv.findViewById(f.qHE);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                if (iN.kg() || iN.byB() == null || iN.byB().rll != 1 || this.kZv == 12) {
                    aD = str2;
                } else {
                    byD = iN.byD();
                    if (!(byD == null || !byD.bxb() || iN.bzo())) {
                        findViewById.setVisibility(0);
                    }
                    this.rFw.setVisibility(8);
                    this.rFw = (TextView) this.rFv.findViewById(f.qHY);
                    this.rFw.setClickable(false);
                    this.rFw.setLongClickable(false);
                    linearLayout = (LinearLayout) this.rFv.findViewById(f.qIu);
                    linearLayout.setBackground(cnE().getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qFK));
                    layoutParams = new LinearLayout.LayoutParams(((((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12), -2);
                    layoutParams.setMargins(0, com.tencent.mm.bu.a.fromDPToPix(cnE(), 5), 0, 0);
                    linearLayout.setLayoutParams(layoutParams);
                    TextView textView4 = (TextView) this.rFv.findViewById(f.qHU);
                    textView4.setClickable(false);
                    textView4.setLongClickable(false);
                    if (bi.oN(iN.byB().rlm)) {
                        textView4.setVisibility(8);
                    } else {
                        textView4.setText(iN.byB().rlm + " ");
                        com.tencent.mm.pluginsdk.ui.d.i.f(textView4, 2);
                        textView4.setVisibility(0);
                    }
                    if (bi.oN(iN.byB().rln)) {
                        aD = byF.wYg;
                    } else {
                        aD = iN.byB().rln;
                    }
                    this.contextMenuHelper.a(linearLayout, this.rFY.rVJ, this.rFY.rVs);
                    if (iN.byB().bxj() || iN.byB().bxk()) {
                        this.rFv.findViewById(f.qHB).setVisibility(0);
                        B(iN);
                    }
                }
                if (aD != null || aD.equals("")) {
                    this.rFw.setVisibility(8);
                } else {
                    this.rFw.setText(aD + " ");
                    com.tencent.mm.pluginsdk.ui.d.i.f(this.rFw, 2);
                    this.rFw.setVisibility(0);
                }
                av.e(byF);
                viewStub = (ViewStub) this.rFv.findViewById(f.qIt);
                if (!this.rGp) {
                    if (this.kZv == 2) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOe);
                    } else if (this.kZv == 3) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOb);
                    } else if (this.kZv == 4) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOc);
                    } else if (this.kZv == 5) {
                        viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOd);
                    } else if (this.kZv != 6) {
                        if (this.kZv != 1 || this.kZv == 0) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qND);
                        } else if (this.kZv == 9) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qKN);
                        } else if (this.kZv == 11) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qNt);
                        } else if (this.kZv == 12) {
                            viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOh);
                        }
                    }
                    if (this.kZv != 2 || this.kZv == 3 || this.kZv == 4 || this.kZv == 5) {
                        this.rGq = (PhotosContent) viewStub.inflate();
                    } else if (this.kZv == 9) {
                        viewStub.inflate();
                    } else if (this.kZv == 11) {
                        this.rGq = (PhotosContent) viewStub.inflate();
                    } else if (this.kZv == 12) {
                        viewStub.inflate();
                    } else {
                        viewStub.setVisibility(8);
                    }
                    this.rGp = true;
                }
                if (this.kZv != 6) {
                    LinearLayout.LayoutParams layoutParams2;
                    final ak akVar;
                    View findViewById2;
                    boolean z;
                    ViewGroup.LayoutParams layoutParams3;
                    are are;
                    View view;
                    if (this.kZv != 2 || this.kZv == 3 || this.kZv == 4 || this.kZv == 5) {
                        if (this.rGq == null) {
                            this.rGq.bAH();
                            i2 = 0;
                            while (true) {
                                i = i2;
                                if (i < ar.rJT[this.kZv]) {
                                    break;
                                }
                                tagImageView = (TagImageView) this.rGq.findViewById(ar.rJX[i]);
                                this.rGq.a(tagImageView);
                                tagImageView.setOnClickListener(this.rFY.rzz);
                                this.contextMenuHelper.a(tagImageView, this.rFY.rVG, this.rFY.rVs);
                                i2 = i + 1;
                            }
                            this.rGq.xP(this.rFT);
                            linkedList = new LinkedList();
                            if (iN.kg() && this.kZv == 2) {
                                byB = iN.byB();
                                if (byB == null && byB.rll == 1) {
                                    are are2;
                                    i = ((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth();
                                    if (byF.wYj == null || byF.wYj.wfh.size() <= 0) {
                                        are2 = null;
                                    } else {
                                        are2 = (are) byF.wYj.wfh.get(0);
                                    }
                                    i = (((i - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 20);
                                    i2 = (int) ((are2.wES.wFG * ((float) i)) / are2.wES.wFF);
                                    arg = new arg();
                                    arg.wFF = (float) i;
                                    arg.wFG = (float) i2;
                                    arg.wFH = arg.wFF * arg.wFG;
                                    linkedList.add(arg);
                                    layoutParams2 = (LinearLayout.LayoutParams) this.rGq.getLayoutParams();
                                    layoutParams2.leftMargin = com.tencent.mm.bu.a.fromDPToPix(cnE(), 10);
                                    layoutParams2.rightMargin = com.tencent.mm.bu.a.fromDPToPix(cnE(), 10);
                                    this.rGq.setLayoutParams(layoutParams2);
                                    this.rFv.findViewById(f.qIu).setTag(this.rGq.xQ(0));
                                    this.rFv.findViewById(f.qIu).setOnClickListener(this.rFY.rVX);
                                    i2 = 0;
                                    while (true) {
                                        i = i2;
                                        if (i >= ar.rJT[this.kZv]) {
                                            break;
                                        }
                                        this.contextMenuHelper.a((TagImageView) this.rGq.findViewById(ar.rJX[i]), this.rFY.rVJ, this.rFY.rVs);
                                        i2 = i + 1;
                                    }
                                    this.rFv.findViewById(f.qHC).setTag(this.rGq.xQ(0));
                                    this.rFv.findViewById(f.qHD).setTag(this.rGq.xQ(0));
                                } else if (byB != null && byB.rlb > 0.0f && byB.rlc > 0.0f) {
                                    a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlb, 1, byB.rld, byB.rle);
                                    a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlc, 1, byB.rld, byB.rle);
                                    if (byB.rla == 0) {
                                        i2 = ((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth();
                                        if (a < ((float) (((i2 - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)))) {
                                            fromDPToPix = (float) (((i2 - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12));
                                            a = (float) ((int) ((byB.rlc * fromDPToPix) / byB.rlb));
                                        } else {
                                            fromDPToPix = a;
                                            a = a2;
                                        }
                                        arg = new arg();
                                        arg.wFF = fromDPToPix;
                                        arg.wFG = a;
                                        arg.wFH = arg.wFF * arg.wFG;
                                        linkedList.add(arg);
                                    } else if (byB.rla == 1) {
                                        i2 = (((((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12);
                                        i3 = (int) ((((float) i2) * byB.rlc) / byB.rlb);
                                        arg2 = new arg();
                                        if (i2 > 0) {
                                            a = (float) i2;
                                        }
                                        arg2.wFF = a;
                                        if (i3 > 0) {
                                            a2 = (float) i3;
                                        }
                                        arg2.wFG = a2;
                                        arg2.wFH = arg2.wFF * arg2.wFG;
                                        linkedList.add(arg2);
                                    } else if (byB.rla == 2) {
                                        i2 = ((((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12);
                                        i3 = (int) ((((float) i2) * byB.rlc) / byB.rlb);
                                        arg2 = new arg();
                                        if (i2 > 0) {
                                            a = (float) i2;
                                        }
                                        arg2.wFF = a;
                                        if (i3 > 0) {
                                            a2 = (float) i3;
                                        }
                                        arg2.wFG = a2;
                                        arg2.wFH = arg2.wFF * arg2.wFG;
                                        linkedList.add(arg2);
                                    }
                                }
                                if (!bi.oN(byB.rlg)) {
                                    photosContent = this.rGq;
                                    xQ = this.rGq.xQ(0);
                                    d.a("adId", byB.rlg, false, 41, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a() {
                                        public final void bxM() {
                                        }

                                        public final void bxN() {
                                        }

                                        public final void LD(String str) {
                                            MaskImageView maskImageView = (MaskImageView) photosContent.findViewById(f.qIW);
                                            if (maskImageView != null) {
                                                maskImageView.setVisibility(0);
                                                maskImageView.setImageBitmap(BitmapFactory.decodeFile(str));
                                                float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlh, 1, byB.rld, byB.rle);
                                                float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rli, 1, byB.rld, byB.rle);
                                                float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlj, 1, byB.rld, byB.rle);
                                                float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlk, 1, byB.rld, byB.rle);
                                                ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
                                                layoutParams.setMargins((int) ((((float) xQ.getRight()) - a3) - a), (int) ((((float) xQ.getBottom()) - a4) - a2), 0, 0);
                                                maskImageView.setLayoutParams(layoutParams);
                                            }
                                        }
                                    });
                                }
                            }
                            bpb = byF;
                            mVar = iN;
                            this.rFv.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                                boolean rGA = false;

                                public final void onViewAttachedToWindow(View view) {
                                    x.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", Boolean.valueOf(this.rGA));
                                    if (this.rGA) {
                                        this.rGA = false;
                                        if (bpb != null && mVar != null && SnsCommentDetailUI.this.rGq != null) {
                                            ar z = SnsCommentDetailUI.this.rFJ;
                                            PhotosContent photosContent = SnsCommentDetailUI.this.rGq;
                                            bpb bpb = bpb;
                                            String bza = mVar.bza();
                                            SnsCommentDetailUI.this.rFY;
                                            int hashCode = SnsCommentDetailUI.this.hashCode();
                                            int y = SnsCommentDetailUI.this.kZv;
                                            mVar.xD(32);
                                            z.a(photosContent, bpb, bza, hashCode, y, -1, false, an.xHw, linkedList);
                                        }
                                    }
                                }

                                public final void onViewDetachedFromWindow(View view) {
                                    x.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
                                    this.rGA = true;
                                }
                            });
                            arVar = this.rFJ;
                            photosContent2 = this.rGq;
                            bza = iN.bza();
                            hashCode = hashCode();
                            i4 = this.kZv;
                            iN.xD(32);
                            arVar.a(photosContent2, byF, bza, hashCode, i4, -1, false, an.xHw, linkedList);
                        } else {
                            x.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.kZv + ",stub is " + viewStub.toString());
                        }
                    } else if (this.kZv == 11) {
                        this.rGq.bAH();
                        tagImageView = (TagImageView) this.rGq.findViewById(f.qGW);
                        this.rGq.a(tagImageView);
                        tagImageView.setOnClickListener(this.rFY.rzz);
                        aD = iN.bza();
                        List arrayList = new ArrayList();
                        arrayList.add(tagImageView);
                        ap apVar = new ap();
                        apVar.fvn = aD;
                        apVar.index = 0;
                        apVar.rHV = arrayList;
                        apVar.rFe = true;
                        if (tagImageView != null) {
                            tagImageView.setTag(apVar);
                        }
                        textView = (TextView) this.rFv.findViewById(f.qIq);
                        if (com.tencent.mm.y.q.FY().equals(byF.kyG)) {
                            textView.setVisibility(8);
                        } else {
                            blf n = ai.n(iN);
                            if (n.wVf == null || n.wVf.wVH == 0) {
                                textView.setVisibility(8);
                            } else {
                                textView.setText(getString(j.qPF, new Object[]{Integer.valueOf(n.wVf.wVH)}));
                                textView.setVisibility(0);
                            }
                        }
                        arf byS = iN.byS();
                        if (byS == null) {
                            x.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + iN.bza());
                        } else if (com.tencent.mm.y.q.FY().equals(byF.kyG)) {
                            arVar = this.rFJ;
                            photosContent2 = this.rGq;
                            bza = iN.bza();
                            hashCode = hashCode();
                            i4 = this.kZv;
                            iN.xD(32);
                            arVar.a(photosContent2, byF, bza, hashCode, i4, -1, false, an.xHw, true);
                        } else if (com.tencent.mm.plugin.sns.lucky.a.m.h(iN)) {
                            arVar = this.rFJ;
                            photosContent2 = this.rGq;
                            bza = iN.bza();
                            hashCode = hashCode();
                            i4 = this.kZv;
                            iN.xD(32);
                            arVar.a(photosContent2, byF, bza, hashCode, i4, -1, false, an.xHw, false);
                        } else if (byS.fMy == 0) {
                            arVar = this.rFJ;
                            photosContent2 = this.rGq;
                            bza = iN.bza();
                            hashCode = hashCode();
                            i4 = this.kZv;
                            iN.xD(32);
                            arVar.a(photosContent2, byF, bza, hashCode, i4, -1, false, an.xHw, true);
                        } else {
                            x.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + byS.fMy);
                        }
                    } else if (this.kZv == 9) {
                        are are3;
                        this.rGc = true;
                        akVar = new ak();
                        View view2 = this.rFv;
                        findViewById2 = view2.findViewById(f.bTF);
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view2.findViewById(f.image);
                        akVar.rDk = findViewById2;
                        akVar.rqV = (ImageView) view2.findViewById(f.cPs);
                        akVar.rDl = (MMPinProgressBtn) view2.findViewById(f.progress);
                        akVar.rqY = (TextView) view2.findViewById(f.qIe);
                        akVar.rDm = (TextView) view2.findViewById(f.qId);
                        akVar.qBQ = aVar;
                        akVar.a(byF, 0, iN.bza(), iN.kg());
                        akVar.rqY.setVisibility(8);
                        akVar.qBQ.bI(akVar);
                        findViewById2.setTag(akVar);
                        akVar.rDk.setOnClickListener(this.rFY.rVP);
                        if (iN.bxi()) {
                            this.contextMenuHelper.a(findViewById2, this.rFY.rVJ, this.rFY.rVs);
                        } else {
                            this.contextMenuHelper.a(findViewById2, this.rFY.rVI, this.rFY.rVs);
                        }
                        Pair a3 = com.tencent.mm.modelsns.e.a(byF, akVar.qBQ.btp(), iN.kg());
                        if (iN.kg()) {
                            com.tencent.mm.plugin.sns.storage.b byB3 = iN.byB();
                            if (byB3 != null && byB3.rll == 1) {
                                if (byF.wYj == null || byF.wYj.wfh.size() <= 0) {
                                    are3 = null;
                                } else {
                                    are3 = (are) byF.wYj.wfh.get(0);
                                }
                                if (are3 != null) {
                                    i2 = (((((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 20);
                                    a3 = Pair.create(Integer.valueOf(i2), Integer.valueOf((int) ((((float) i2) * are3.wES.wFG) / are3.wES.wFF)));
                                }
                                layoutParams2 = (LinearLayout.LayoutParams) akVar.rDk.getLayoutParams();
                                layoutParams2.leftMargin = com.tencent.mm.bu.a.fromDPToPix(cnE(), 10);
                                layoutParams2.rightMargin = com.tencent.mm.bu.a.fromDPToPix(cnE(), 10);
                                akVar.rDk.setLayoutParams(layoutParams2);
                                this.rFv.findViewById(f.qIu).setTag(akVar);
                                this.rFv.findViewById(f.qIu).setOnClickListener(this.rFY.rVX);
                                this.rFv.findViewById(f.qHC).setTag(akVar);
                                this.rFv.findViewById(f.qHD).setTag(akVar);
                            } else if (byB3 != null && byB3.rlb > 0.0f && byB3.rlc > 0.0f) {
                                float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB3.rlb, 1, byB3.rld, byB3.rle);
                                a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB3.rlc, 1, byB3.rld, byB3.rle);
                                if (byB3.rla == 0) {
                                    i2 = ((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth();
                                    if (a4 >= ((float) (((i2 - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)))) {
                                        a = (float) (((i2 - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12));
                                        fromDPToPix = (float) ((int) ((byB3.rlc * a) / byB3.rlb));
                                    } else {
                                        fromDPToPix = a2;
                                        a = a4;
                                    }
                                    a3 = Pair.create(Integer.valueOf((int) a), Integer.valueOf((int) fromDPToPix));
                                } else if (byB3.rla == 1) {
                                    i2 = (((((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12);
                                    a3 = Pair.create(Integer.valueOf(i2), Integer.valueOf((int) ((((float) i2) * byB3.rlc) / byB3.rlb)));
                                } else if (byB3.rla == 2) {
                                    i2 = ((((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12);
                                    a3 = Pair.create(Integer.valueOf(i2), Integer.valueOf((int) ((((float) i2) * byB3.rlc) / byB3.rlb)));
                                }
                            }
                        }
                        if (a3 != null) {
                            aVar.dx(((Integer) a3.first).intValue(), ((Integer) a3.second).intValue());
                            layoutParams = akVar.rDm.getLayoutParams();
                            layoutParams.width = ((Integer) a3.first).intValue();
                            layoutParams.height = ((Integer) a3.second).intValue();
                            akVar.rDm.setLayoutParams(layoutParams);
                        }
                        if (byF.wYj == null || byF.wYj.wfh.size() <= 0) {
                            are3 = null;
                        } else {
                            are3 = (are) byF.wYj.wfh.get(0);
                        }
                        if (iN.kg()) {
                            mVar2 = iN;
                            akVar.qBQ.a(new com.tencent.mm.plugin.sight.decode.a.b.e() {
                                public final void d(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                                    if (i != -1 && SnsCommentDetailUI.this.rFX != null) {
                                        SnsCommentDetailUI.this.rFX.m(mVar2.field_snsId, false);
                                    }
                                }
                            });
                            if (!this.rFX.ek(iN.field_snsId)) {
                                mVar2 = iN;
                                akVar.qBQ.a(new com.tencent.mm.plugin.sight.decode.a.b.f() {
                                    public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j) {
                                        if (SnsCommentDetailUI.this.rFX != null) {
                                            int bty = (int) bVar.bty();
                                            SnsCommentDetailUI.this.rFX.b(mVar2.field_snsId, bi.Wz(), false);
                                            SnsCommentDetailUI.this.rFX.w(mVar2.field_snsId, bty);
                                            if (j >= 3) {
                                                SnsCommentDetailUI.this.rFX.B(mVar2.field_snsId, mVar2.field_snsId);
                                                akVar.qBQ.a(null);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                        if (byF.wYj != null && byF.wYj.wfh.size() > 0) {
                            ae.bwc();
                            if (com.tencent.mm.plugin.sns.model.g.t(are3)) {
                                if (ae.bwc().u(are3)) {
                                    akVar.rqV.setVisibility(0);
                                    akVar.rDl.setVisibility(8);
                                    akVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this, com.tencent.mm.plugin.sns.i.i.dAT));
                                } else if (ae.bwc().v(are3)) {
                                    akVar.rqV.setVisibility(8);
                                    akVar.rDl.setVisibility(8);
                                } else if (!iN.kg() || ae.bwc().l(iN) > 5) {
                                    ae.bwc().y(are3);
                                    akVar.rqV.setVisibility(0);
                                    akVar.rDl.setVisibility(8);
                                    akVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this, com.tencent.mm.plugin.sns.i.i.dAT));
                                } else {
                                    akVar.rqV.setVisibility(8);
                                    akVar.rDl.setVisibility(8);
                                }
                                if (akVar.qBQ.btq()) {
                                    x.d("MicroMsg.SnsCommentDetailUI", "play video error " + are3.nMq + " " + are3.nlE + " " + are3.wEP);
                                    ae.bwc().y(are3);
                                    akVar.rqV.setVisibility(0);
                                    akVar.rDl.setVisibility(8);
                                    akVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this, com.tencent.mm.plugin.sns.i.i.dAT));
                                }
                            } else if (ae.bwc().w(are3)) {
                                akVar.rqV.setVisibility(8);
                                akVar.rDl.setVisibility(0);
                                akVar.rDl.czF();
                            } else if (iN.kg() && ae.bwc().l(iN) == 5) {
                                ae.bwc().A(are3);
                                akVar.rqV.setVisibility(8);
                                akVar.rDl.setVisibility(0);
                                akVar.rDl.czF();
                            } else {
                                ae.bwc().y(are3);
                                akVar.rqV.setVisibility(0);
                                akVar.rDl.setVisibility(8);
                                akVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this, com.tencent.mm.plugin.sns.i.i.dAT));
                            }
                            aVar.bI(akVar);
                            ae.bwc().a(iN, are3, aVar, hashCode(), 0, an.xHw, iN.kg());
                            findViewById2.setTag(akVar);
                            if (this.rFX != null) {
                                z = iN.kg() ? ae.bwc().l(iN) == 5 : ae.bwc().k(iN) == 5;
                                this.rFX.o(iN.field_snsId, z);
                            }
                        }
                    } else if (this.kZv == 0) {
                        linearLayout = (LinearLayout) this.rFv.findViewById(f.qKO);
                        View xS = xS(com.tencent.mm.plugin.sns.i.g.qNC);
                        if (!this.rGn) {
                            linearLayout.removeView(this.rGq);
                            linearLayout.addView(xS, 3);
                            if (xS.getLayoutParams() != null) {
                                layoutParams3 = new LinearLayout.LayoutParams(xS.getLayoutParams());
                            } else {
                                layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                            }
                            layoutParams3.setMargins(layoutParams3.leftMargin, com.tencent.mm.bu.a.fromDPToPix(this, 12), layoutParams3.rightMargin, layoutParams3.bottomMargin);
                            xS.setLayoutParams(layoutParams3);
                        }
                        if (byF.wYj.wfh.isEmpty()) {
                            xS.setVisibility(8);
                        } else {
                            are = (are) byF.wYj.wfh.get(0);
                            MMImageView mMImageView = (MMImageView) xS.findViewById(f.qIs);
                            ae.bwc().b(are, mMImageView, com.tencent.mm.plugin.sns.i.i.dvy, hashCode(), an.xHw);
                            this.rFN = (ImageView) xS.findViewById(f.state);
                            this.rFN.setOnTouchListener(this.ryR);
                            this.oQL = byF.nMq;
                            bBp();
                            mMImageView.setTag(new r(byF, this.rFK, getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false)));
                            mMImageView.setOnClickListener(this.rFR.rSE);
                            CharSequence charSequence3 = are.nkL;
                            if (!bi.oN(charSequence3)) {
                                ((TextView) xS.findViewById(f.qJm)).setText(charSequence3);
                            }
                            charSequence = are.fpg;
                            if (!bi.oN(charSequence)) {
                                ((TextView) xS.findViewById(f.qLQ)).setText(new SpannableString(charSequence), BufferType.SPANNABLE);
                            }
                            xS.setTag(new r(byF, this.rFK));
                            this.contextMenuHelper.a(xS, this.rFY.rVH, this.rFY.rVs);
                            xS.setOnClickListener(this.rFR.rLk);
                            com.tencent.mm.plugin.sns.data.i.b(mMImageView, this);
                        }
                    } else if (this.kZv == 12) {
                        int width = ((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(cnE(), 82);
                        View findViewById3 = this.rFv.findViewById(f.qLS);
                        layoutParams2 = (LinearLayout.LayoutParams) findViewById3.getLayoutParams();
                        layoutParams2.topMargin = com.tencent.mm.bu.a.fromDPToPix(cnE(), 10);
                        layoutParams2.bottomMargin = 0;
                        layoutParams2.width = width;
                        layoutParams2.height = width;
                        if (findViewById3.getParent() instanceof ViewGroup) {
                            ((ViewGroup) findViewById3.getParent()).setClipChildren(false);
                            ((ViewGroup) findViewById3.getParent()).setClipToPadding(false);
                        }
                        int[] iArr = new int[]{f.qLT, f.qLU};
                        int i5 = f.qLV;
                        i2 = 0;
                        while (true) {
                            i = i2;
                            if (i >= 2) {
                                break;
                            }
                            MaskImageView maskImageView = (MaskImageView) findViewById3.findViewById(iArr[i]);
                            maskImageView.setVisibility(8);
                            maskImageView.setOnTouchListener(new OnTouchListener() {
                                public final boolean onTouch(View view, MotionEvent motionEvent) {
                                    return false;
                                }
                            });
                            i2 = i + 1;
                        }
                        View findViewById4 = findViewById3.findViewById(i5);
                        findViewById4.setBackground(null);
                        findViewById4.setVisibility(8);
                        ((ViewGroup) findViewById4).setClipChildren(false);
                        ak akVar2 = new ak();
                        akVar2.rDk = findViewById4;
                        akVar2.rDj = akVar2.rDk;
                        akVar2.qBQ = (com.tencent.mm.plugin.sight.decode.a.a) akVar2.rDk.findViewById(f.image);
                        akVar2.rqV = (ImageView) akVar2.rDk.findViewById(f.cPs);
                        akVar2.rDl = (MMPinProgressBtn) akVar2.rDk.findViewById(f.progress);
                        akVar2.rDm = (TextView) akVar2.rDk.findViewById(f.qId);
                        akVar2.rqY = (TextView) akVar2.rDk.findViewById(f.qIe);
                        akVar2.rDk.setTag(akVar2);
                        akVar2.rDk.setOnClickListener(null);
                        ((SightPlayImageView) akVar2.qBQ).btL();
                        ((SightPlayImageView) akVar2.qBQ).a(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
                        akVar2.qBQ.dx(width, width);
                        findViewById3.setLayerType(2, null);
                        if (iN.byF().wYj.wfh.size() >= 2) {
                            int i6;
                            if (iN.field_likeFlag == 1) {
                                i6 = 1;
                            } else {
                                i6 = 0;
                            }
                            i2 = 0;
                            while (true) {
                                int i7 = i2;
                                if (i7 >= 2) {
                                    break;
                                }
                                are = (are) iN.byF().wYj.wfh.get(i7);
                                view = (MaskImageView) findViewById3.findViewById(iArr[i7]);
                                ViewGroup.LayoutParams layoutParams4 = view.getLayoutParams();
                                ap apVar2 = new ap();
                                apVar2.fvn = this.rFK;
                                apVar2.index = i7;
                                apVar2.rFe = false;
                                apVar2.rDn = true;
                                apVar2.position = 0;
                                view.setTag(apVar2);
                                if (are.kzz == 2) {
                                    ae.bwc().a(are, view, -1, hashCode(), an.cjH().DI(byF.pgR), 3);
                                } else {
                                    ae.bwc().a(are, view, hashCode(), an.cjH().DI(byF.pgR));
                                }
                                view.a(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
                                layoutParams4.width = width;
                                layoutParams4.height = width;
                                if (i6 == i7 && are.kzz == 2) {
                                    view.setVisibility(0);
                                    final int i8 = i6;
                                    mVar = iN;
                                    view.setOnClickListener(new OnClickListener() {
                                        public final void onClick(View view) {
                                            if (SnsCommentDetailUI.this.rFX != null && i8 > 0) {
                                                SnsCommentDetailUI.this.rFX.em(mVar.field_snsId);
                                            }
                                            SnsCommentDetailUI.this.rFY.rVX.onClick(view);
                                        }
                                    });
                                } else {
                                    view.setOnClickListener(null);
                                }
                                if (are.kzz == 6 && i6 == i7) {
                                    final long j;
                                    z = i6 > 0;
                                    long j2 = iN.field_snsId;
                                    this.rGc = true;
                                    layoutParams = findViewById4.getLayoutParams();
                                    layoutParams.width = width;
                                    layoutParams.height = width;
                                    findViewById4.setVisibility(0);
                                    ae.bwc().a(iN, are, akVar2.qBQ, -1, hashCode(), 0, an.xHw, iN.kg(), true);
                                    akVar2.rDn = true;
                                    akVar2.rDo = i7;
                                    akVar2.rDi = byF;
                                    akVar2.position = 0;
                                    akVar2.fsC = this.rFK;
                                    mVar2 = iN;
                                    akVar2.rDk.setOnClickListener(new OnClickListener() {
                                        public final void onClick(View view) {
                                            if (SnsCommentDetailUI.this.rFX != null && z) {
                                                SnsCommentDetailUI.this.rFX.em(mVar2.field_snsId);
                                            }
                                            SnsCommentDetailUI.this.rFY.rVX.onClick(view);
                                        }
                                    });
                                    final long j3 = j2;
                                    akVar2.qBQ.a(new com.tencent.mm.plugin.sight.decode.a.b.e() {
                                        public final void d(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                                            if (i != -1) {
                                                SnsCommentDetailUI.this.rFX.m(j3, z);
                                            }
                                        }
                                    });
                                    if (this.rFX.ek(((long) i7) + j2)) {
                                        this.rFX.b(j2, bi.Wz(), z);
                                    } else {
                                        j = j2;
                                        final boolean z2 = z;
                                        final int i9 = i7;
                                        akVar = akVar2;
                                        akVar2.qBQ.a(new com.tencent.mm.plugin.sight.decode.a.b.f() {
                                            public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j) {
                                                int bty = (int) bVar.bty();
                                                SnsCommentDetailUI.this.rFX.b(j, bi.Wz(), z2);
                                                SnsCommentDetailUI.this.rFX.a(j, bty, true, z2);
                                                SnsCommentDetailUI.this.rFX.B(j, j + ((long) i9));
                                                akVar.qBQ.a(null);
                                            }
                                        });
                                    }
                                    akVar2.a(byF, 0, this.rFK, iN.kg());
                                    akVar2.rqY.setVisibility(8);
                                    com.tencent.mm.plugin.sns.model.g bwc = ae.bwc();
                                    j = System.nanoTime() - System.nanoTime();
                                    x.i("MicroMsg.SnsCommentDetailUI", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(are)), Long.valueOf(j));
                                    if (com.tencent.mm.plugin.sns.model.g.t(are)) {
                                        if (bwc.u(are)) {
                                            akVar2.rqV.setVisibility(0);
                                            akVar2.rDl.setVisibility(8);
                                            akVar2.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this, com.tencent.mm.plugin.sns.i.i.dAT));
                                            akVar2.rqV.setContentDescription(getString(j.qPM));
                                        } else if (bwc.v(are)) {
                                            akVar2.rqV.setVisibility(8);
                                            akVar2.rDl.setVisibility(8);
                                        } else if (!iN.kg() || bwc.l(iN) > 5) {
                                            bwc.y(are);
                                            akVar2.rqV.setVisibility(0);
                                            akVar2.rDl.setVisibility(8);
                                            akVar2.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this, com.tencent.mm.plugin.sns.i.i.dAT));
                                            akVar2.rqV.setContentDescription(getString(j.qPM));
                                        } else {
                                            akVar2.rqV.setVisibility(8);
                                            akVar2.rDl.setVisibility(8);
                                        }
                                        if (akVar2.qBQ.btq()) {
                                            x.d("MicroMsg.SnsCommentDetailUI", "play video error " + are.nMq + " " + are.nlE + " " + are.wEP + " 0");
                                            bwc.y(are);
                                            akVar2.rqV.setVisibility(0);
                                            akVar2.rDl.setVisibility(8);
                                            akVar2.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this, com.tencent.mm.plugin.sns.i.i.dAT));
                                            akVar2.rqV.setContentDescription(getString(j.qPM));
                                        }
                                    } else if (bwc.w(are)) {
                                        akVar2.rqV.setVisibility(8);
                                        akVar2.rDl.setVisibility(0);
                                        akVar2.rDl.czF();
                                    } else if (iN.kg() && bwc.l(iN) == 5) {
                                        bwc.A(are);
                                        akVar2.rqV.setVisibility(8);
                                        akVar2.rDl.setVisibility(0);
                                        akVar2.rDl.czF();
                                    } else if (bwc.x(are)) {
                                        akVar2.rDl.setVisibility(8);
                                        akVar2.rqV.setImageResource(com.tencent.mm.plugin.sns.i.e.bGg);
                                        akVar2.rqV.setVisibility(0);
                                    } else {
                                        bwc.y(are);
                                        akVar2.rqV.setVisibility(0);
                                        akVar2.rDl.setVisibility(8);
                                        akVar2.rqV.setImageDrawable(com.tencent.mm.bu.a.b(this, com.tencent.mm.plugin.sns.i.i.dAT));
                                        akVar2.rqV.setContentDescription(getString(j.qPM));
                                        if (!iN.kg() && bwc.k(iN) == 4) {
                                            akVar2.rqY.setVisibility(0);
                                        } else if (iN.kg() && bwc.l(iN) == 4) {
                                            akVar2.rqY.setVisibility(0);
                                        }
                                    }
                                    boolean z3 = iN.kg() ? ae.bwc().l(iN) == 5 : ae.bwc().k(iN) == 5;
                                    this.rFX.a(j2, z3, 1, z);
                                }
                                i2 = i7 + 1;
                            }
                            xT(i6);
                        }
                    } else {
                        Object obj4;
                        Object obj5;
                        Object charSequence22;
                        linearLayout = (LinearLayout) this.rFv.findViewById(f.qKO);
                        findViewById2 = xS(com.tencent.mm.plugin.sns.i.g.qNB);
                        view = (MMImageView) findViewById2.findViewById(f.qIs);
                        if (!this.rGn) {
                            linearLayout.removeView(this.rGq);
                            linearLayout.addView(findViewById2, 3);
                            if (findViewById2.getLayoutParams() != null) {
                                layoutParams3 = new LinearLayout.LayoutParams(findViewById2.getLayoutParams());
                            } else {
                                layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                            }
                            layoutParams3.setMargins(layoutParams3.leftMargin, com.tencent.mm.bu.a.fromDPToPix(this, 12), layoutParams3.rightMargin, layoutParams3.bottomMargin);
                            findViewById2.setLayoutParams(layoutParams3);
                        }
                        Object obj6 = null;
                        if (iN.kg()) {
                            if (iN.byB().rll == 2) {
                                obj6 = 1;
                                findViewById2.setTag(iN);
                                findViewById2.setTag(f.qIM, view);
                                findViewById2.setOnClickListener(this.rFY.rWa);
                            }
                            obj4 = null;
                            obj5 = obj6;
                        } else {
                            if (byF.wYj.wfg == 9) {
                                if (byF.wYj.wfh.size() > 0) {
                                    findViewById2.setTag(new r(byF, this.rFK));
                                    findViewById2.setOnClickListener(this.rFR.rSy);
                                    obj4 = null;
                                    obj5 = null;
                                }
                            } else if (byF.wYj.wfg == 10) {
                                if (byF.wYj.wfh.size() > 0) {
                                    findViewById2.setTag(new r(byF, this.rFK));
                                    findViewById2.setOnClickListener(this.rFR.rSA);
                                    obj4 = null;
                                    obj5 = null;
                                }
                            } else if (byF.wYj.wfg == 17) {
                                if (byF.wYj.wfh.size() > 0) {
                                    findViewById2.setTag(new r(byF, this.rFK));
                                    findViewById2.setOnClickListener(this.rFR.rSB);
                                    obj4 = null;
                                    obj5 = null;
                                }
                            } else if (byF.wYj.wfg == 22) {
                                if (byF.wYj.wfh.size() > 0) {
                                    findViewById2.setTag(new r(byF, this.rFK));
                                    findViewById2.setOnClickListener(this.rFR.rSC);
                                    obj4 = null;
                                    obj5 = null;
                                }
                            } else if (byF.wYj.wfg == 23) {
                                if (byF.wYj.wfh.size() > 0) {
                                    findViewById2.setTag(new r(byF, this.rFK));
                                    findViewById2.setOnClickListener(this.rFR.rSD);
                                    obj4 = null;
                                    obj5 = null;
                                }
                            } else if (byF.wYj.wfg == 14) {
                                if (byF.wYj.wfh.size() > 0) {
                                    findViewById2.setTag(new r(byF, this.rFK));
                                    findViewById2.setOnClickListener(this.rFR.rSz);
                                    obj4 = null;
                                    obj5 = null;
                                }
                            } else if (byF.wYj.wfg == 12) {
                                if (byF.wYj.wfh.size() > 0) {
                                    findViewById2.setTag(new r(byF, this.rFK));
                                    findViewById2.setOnClickListener(this.rFR.rSH);
                                    obj4 = null;
                                    obj5 = null;
                                }
                            } else if (byF.wYj.wfg == 13) {
                                if (byF.wYj.wfh.size() > 0) {
                                    findViewById2.setTag(new r(byF, this.rFK));
                                    findViewById2.setOnClickListener(this.rFR.rSI);
                                    obj4 = null;
                                    obj5 = null;
                                }
                            } else if (byF.wYj.wfg == 15) {
                                if (byF.wYj.wfh.size() > 0) {
                                    findViewById2.setTag(new r(byF, this.rFK));
                                    findViewById2.setOnClickListener(this.rFY.rVQ);
                                    obj4 = null;
                                    obj5 = null;
                                }
                            } else if (byF.wYj.wfg == 26) {
                                findViewById2.setTag(new r(byF, this.rFK));
                                findViewById2.setOnClickListener(this.rFR.rSJ);
                                obj4 = null;
                                obj5 = null;
                            } else {
                                findViewById2.setTag(new r(byF, this.rFK));
                                findViewById2.setOnClickListener(this.rFR.rLk);
                                if ((byF.hcR & 1) > 0) {
                                    int obj42 = 1;
                                    obj5 = null;
                                }
                            }
                            obj42 = null;
                            obj5 = null;
                        }
                        if (obj5 != null) {
                            this.contextMenuHelper.a(findViewById2, this.rFY.rVK, this.rFY.rVs);
                        } else {
                            this.contextMenuHelper.a(findViewById2, this.rFY.rVH, this.rFY.rVs);
                        }
                        String MH = bBm() ? av.MH(byF.wYj.nlE) : "";
                        String str4 = byF.wYj.fpg;
                        if (obj5 != null) {
                            charSequence22 = byF.wYj.nkL;
                        } else {
                            charSequence22 = MH;
                        }
                        findViewById2.findViewById(f.state).setVisibility(8);
                        if (!byF.wYj.wfh.isEmpty()) {
                            view.setVisibility(0);
                            are = (are) byF.wYj.wfh.get(0);
                            if (byF.wYj.wfg == 15) {
                                ((ImageView) findViewById2.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.bDT);
                                ((ImageView) findViewById2.findViewById(f.state)).setVisibility(0);
                                ae.bwc().b(are, view, com.tencent.mm.plugin.sns.i.i.dvL, hashCode(), an.cjD().DI(byF.pgR));
                                MH = str4;
                            } else if (byF.wYj.wfg == 5) {
                                str4 = av.MH(are.nlE);
                                str2 = are.fpg;
                                findViewById2.findViewById(f.state).setVisibility(0);
                                ae.bwc().b(are, view, com.tencent.mm.plugin.sns.i.i.dvL, hashCode(), an.xHw);
                                MH = str2;
                                charSequence22 = str4;
                            } else if (byF.wYj.wfg == 18) {
                                findViewById2.findViewById(f.state).setVisibility(0);
                                ((ImageView) findViewById2.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.bHh);
                                view.setVisibility(0);
                                ae.bwc().b(are, view, com.tencent.mm.plugin.sns.i.i.dvL, hashCode(), an.xHw);
                                MH = str4;
                            } else {
                                ae.bwc().b(are, view, hashCode(), an.xHw);
                                MH = str4;
                            }
                        } else if (byF.wYj.wfg == 18) {
                            ((ImageView) findViewById2.findViewById(f.state)).setVisibility(0);
                            ((ImageView) findViewById2.findViewById(f.state)).setImageResource(com.tencent.mm.plugin.sns.i.e.bHh);
                            view.setVisibility(0);
                            ae.bwc().a(view, -1, com.tencent.mm.plugin.sns.i.i.dvL, hashCode());
                            MH = str4;
                        } else if (byF.wYj.wfg == 26) {
                            view.setVisibility(0);
                            ae.bwc().a(view, -1, com.tencent.mm.plugin.sns.i.i.qOS, hashCode());
                            MH = str4;
                        } else {
                            view.setVisibility(0);
                            ae.bwc().a(view, -1, com.tencent.mm.plugin.sns.i.i.dvO, hashCode());
                            MH = str4;
                        }
                        com.tencent.mm.plugin.sns.data.i.b(view, this);
                        if (byF.wYj.wfg == 15) {
                            charSequence22 = "";
                            charSequence = getString(j.qQQ);
                        } else {
                            obj5 = MH;
                        }
                        if (bi.oN(charSequence22)) {
                            findViewById2.findViewById(f.qJm).setVisibility(8);
                        } else {
                            findViewById2.findViewById(f.qJm).setVisibility(0);
                            ((TextView) findViewById2.findViewById(f.qJm)).setText(charSequence22);
                        }
                        textView = (TextView) findViewById2.findViewById(f.qLQ);
                        if (bi.oN(charSequence)) {
                            textView.setVisibility(8);
                        } else {
                            textView.setVisibility(0);
                            if (obj42 != null) {
                                textView.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence, cnE(), textView));
                            } else {
                                textView.setText(charSequence);
                            }
                        }
                    }
                }
                textView = (TextView) this.rFv.findViewById(f.qGz);
                if (iN.kg()) {
                    charSequence = byF.wYh != null ? null : byF.wYh.hxg;
                    jVar = byF.wYh != null ? null : byF.wYh.nYL;
                    textView.setTag(iN.bza());
                    if (bi.oN(charSequence) || !bi.oN(jVar)) {
                        textView.setVisibility(0);
                        if (bi.oN(jVar)) {
                            textView.setTextColor(-11048043);
                            textView.setClickable(true);
                            if (iN.field_snsId == 0 || bi.oN(charSequence)) {
                                textView.setText(jVar);
                            } else {
                                textView.setText(charSequence + "·" + jVar);
                            }
                        } else {
                            textView.setText(charSequence);
                            textView.setClickable(false);
                            textView.setTextColor(-9211021);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    byD = iN.byD();
                    if (byD != null) {
                        jVar = byD.rjX;
                        aD = byD.rjY;
                        textView.setTag(iN.bza());
                        if (!bi.oN(jVar)) {
                            if (bi.oN(aD)) {
                                textView.setVisibility(0);
                                if (!bi.oN(jVar)) {
                                    textView.setTextColor(-11048043);
                                    textView.setClickable(true);
                                    textView.setText(jVar);
                                }
                            } else {
                                textView.setVisibility(0);
                            }
                            textView.setText(jVar);
                            textView.setClickable(false);
                            textView.setTextColor(-9211021);
                        }
                    }
                    textView.setVisibility(8);
                }
                textView.setOnClickListener(this.rFY.rVO);
                ((TextView) this.rFv.findViewById(f.qHo)).setText(az.l(cnE(), ((long) iN.byT()) * 1000));
                asyncTextView = (AsyncTextView) this.rFv.findViewById(f.qGy);
                asyncTextView.setOnClickListener(this.rFY.rVS);
                asyncTextView.setVisibility(8);
                asyncTextView2 = (AsyncTextView) this.rFv.findViewById(f.qGx);
                mVar2 = iN;
                xVar = Xv;
                asyncTextView2.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        k cVar = new com.tencent.mm.plugin.sns.a.b.c(mVar2.bzj(), 24, 2, "", mVar2.bzn(), mVar2.byG());
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dp().gRu.a(cVar, 0);
                        SnsCommentDetailUI.this.rxz.b(xVar.AX(), null);
                        SnsCommentDetailUI.this.rxz.iO(true);
                        SnsCommentDetailUI.this.rFA.setVisibility(8);
                        SnsCommentDetailUI.u(SnsCommentDetailUI.this);
                    }
                });
                asyncTextView2.setVisibility(8);
                if (iN.kg()) {
                    byD2 = iN.byD();
                    asyncTextView.setTag(iN.bza());
                    if (byD2.rjZ != com.tencent.mm.plugin.sns.storage.a.rjL) {
                        if (bi.oN(byD2.rka)) {
                            asyncTextView.setText(byD2.rka);
                            asyncTextView.setVisibility(0);
                        } else {
                            asyncTextView.setVisibility(8);
                        }
                    } else if (byD2.rjZ == com.tencent.mm.plugin.sns.storage.a.rjM) {
                        if (!bi.oN(byD2.rka)) {
                            bza = "";
                            it = byD2.rkc.iterator();
                            while (it.hasNext()) {
                                str3 = (String) it.next();
                                Xu = this.rFL.Xu(str3);
                                if (Xu == null) {
                                    str2 = Xu.AX();
                                    if (bi.oN(str2)) {
                                        bza = bza + str2;
                                    } else {
                                        bza = bza + str3;
                                    }
                                } else {
                                    bza = bza + str3;
                                }
                                if (byD2.rkc.getLast() != str3) {
                                    bza = bza + ",";
                                }
                            }
                            jVar = String.format(byD2.rka, new Object[]{bza});
                            asyncTextView.getTextSize();
                            jVar2 = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d((Context) this, jVar, 1));
                            jVar2.f(null, jVar);
                            paint = asyncTextView.getPaint();
                            if (com.tencent.mm.bu.a.ad(this, (int) Layout.getDesiredWidth(jVar2, 0, jVar2.length(), paint)) > this.rFW) {
                                while (bza.length() > 1) {
                                    bza = bza.substring(0, bza.length() - 2);
                                    jVar2 = String.format(byD2.rka, new Object[]{bza + "..."});
                                    asyncTextView.getTextSize();
                                    charSequence22 = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d((Context) this, jVar2, 1));
                                    charSequence22.f(null, jVar2);
                                    i4 = com.tencent.mm.bu.a.ad(this, (int) Layout.getDesiredWidth(charSequence22, 0, charSequence22.length(), paint));
                                    asyncTextView.setText(charSequence22, BufferType.SPANNABLE);
                                    asyncTextView.setVisibility(0);
                                    if (i4 <= this.rFW) {
                                        break;
                                    }
                                }
                            }
                            asyncTextView.setText(jVar2, BufferType.SPANNABLE);
                            asyncTextView.setVisibility(0);
                        } else {
                            asyncTextView.setVisibility(8);
                        }
                    }
                    if (asyncTextView.getVisibility() != 8 && bi.oN(byD2.rkb)) {
                        asyncTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEJ));
                        asyncTextView.setOnClickListener(null);
                    }
                    if (iN.byF().wYj.wfi != 4) {
                        asyncTextView2.setTag(iN.bza());
                        asyncTextView2.setVisibility(0);
                        asyncTextView2.setText(String.format("%s%s%s", new Object[]{cnE().getResources().getString(j.qQb), str, cnE().getResources().getString(j.qQc)}));
                    } else {
                        asyncTextView2.setVisibility(8);
                    }
                }
                textView = (TextView) this.rFv.findViewById(f.qGR);
                textView.setOnTouchListener(new ab());
                aD = com.tencent.mm.plugin.sns.c.a.ihO.l(this, byF.wYi.nMq);
                if (byF.wYj.wfg == 26) {
                    aD = getString(j.eeR);
                }
                av.a(byF, (Context) this);
                if (com.tencent.mm.plugin.sns.c.a.ihO.cz(aD)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    jVar = new SpannableString(getString(j.qQs) + aD);
                    jVar.setSpan(new a(), 0, jVar.length(), 33);
                    textView.setText(jVar, BufferType.SPANNABLE);
                    if (byF.wYi == null || !com.tencent.mm.pluginsdk.model.app.g.Sg(byF.wYi.nMq)) {
                        textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEJ));
                        textView.setOnTouchListener(null);
                    }
                    textView.setTag(byF);
                }
                textView = (TextView) this.rFv.findViewById(f.qGQ);
                if (iN.getUserName().equals(this.gAM)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setTag(iN.bza() + ";" + iN.byG());
                    textView.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            com.tencent.mm.ui.base.h.a(SnsCommentDetailUI.this, j.qSx, j.dGZ, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    x.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.this.rFK);
                                    m LR = com.tencent.mm.plugin.sns.storage.h.LR(SnsCommentDetailUI.this.rFK);
                                    if (LR == null) {
                                        x.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", SnsCommentDetailUI.this.rFK);
                                    } else if (!LR.xD(32)) {
                                        if (LR.field_snsId == 0) {
                                            ae.bwf().xH(LR.ruM);
                                        } else {
                                            ae.bwe().eE(LR.field_snsId);
                                            com.tencent.mm.kernel.g.Dr();
                                            com.tencent.mm.kernel.g.Dp().gRu.a(new q(LR.field_snsId, 1), 0);
                                            ae.bwf().delete(LR.field_snsId);
                                            ae.bwk().eN(LR.field_snsId);
                                        }
                                        Intent intent = new Intent();
                                        intent.putExtra("sns_gallery_op_id", u.Ml(SnsCommentDetailUI.this.rFK));
                                        SnsCommentDetailUI.this.setResult(-1, intent);
                                        if (SnsCommentDetailUI.this.jpY && !LR.isValid()) {
                                            intent.putExtra("sns_gallery_force_finish", true);
                                        }
                                        bpb byF = LR.byF();
                                        if (byF != null) {
                                            String str = byF.wYi == null ? null : byF.wYi.nMq;
                                            if (!bi.oN(str) && com.tencent.mm.plugin.sns.c.a.ihO.cA(str)) {
                                                String cy = com.tencent.mm.plugin.sns.c.a.ihO.cy(str);
                                                com.tencent.mm.sdk.b.b nhVar = new nh();
                                                nhVar.fGb.appId = str;
                                                nhVar.fGb.fGc = byF.kyG;
                                                nhVar.fGb.ffM = cy;
                                                com.tencent.mm.sdk.b.a.xmy.m(nhVar);
                                            }
                                        }
                                        SnsCommentDetailUI.this.finish();
                                    }
                                }
                            }, null);
                        }
                    });
                }
                textView = (TextView) this.rFv.findViewById(f.qMn);
                m = ai.m(iN);
                if (m != null) {
                    textView.setVisibility(8);
                } else {
                    if (m.wUX.size() > 0) {
                        if (this.gAM.equals(m.vPp)) {
                            textView.setVisibility(8);
                            it2 = m.wUX.iterator();
                            while (it2.hasNext()) {
                                if (this.gAM.equals(((bku) it2.next()).vPp)) {
                                    textView.setVisibility(0);
                                    charSequence = getString(j.qSB);
                                    textView.setVisibility(0);
                                    textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, charSequence, textView.getTextSize()));
                                    break;
                                }
                            }
                        }
                        textView.setVisibility(0);
                        it = m.wUX.iterator();
                        bza = "";
                        obj = null;
                        while (it.hasNext()) {
                            bku = (bku) it.next();
                            if (obj != null) {
                                str3 = bza + "  ";
                                obj2 = 1;
                            } else {
                                obj3 = obj;
                                str3 = bza + ",  ";
                                obj2 = obj3;
                            }
                            if (bku.wDh == null) {
                                append = new StringBuilder().append(str3);
                                aD = bku.wDh;
                            } else {
                                Xu = this.rFL.Xv(bku.vPp);
                                append = new StringBuilder().append(str3);
                                aD = Xu != null ? bku.vPp : Xu.AX();
                            }
                            obj = obj2;
                            bza = append.append(aD).toString();
                        }
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, getString(j.qSA, new Object[]{bza}), textView.getTextSize()));
                    } else {
                        textView.setVisibility(8);
                    }
                    if (m != null || this.gAM == null || !this.gAM.equals(m.vPp) || ((m.wGH != 3 || m.wVc == null) && (m.wGH != 5 || m.wFx == null))) {
                        this.rFv.findViewById(f.qGS).setVisibility(8);
                    } else {
                        this.rFv.findViewById(f.qGS).setVisibility(0);
                        this.rFv.findViewById(f.qGS).setTag(Integer.valueOf(iN.ruM));
                        this.rFv.findViewById(f.qGS).setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                try {
                                    int intValue = ((Integer) view.getTag()).intValue();
                                    Intent intent = new Intent();
                                    intent.putExtra("sns_label_sns_info", intValue);
                                    com.tencent.mm.plugin.sns.c.a.ihN.x(intent, SnsCommentDetailUI.this);
                                } catch (Exception e) {
                                }
                            }
                        });
                    }
                }
                this.rFC = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.rFC.setDuration(150);
                this.rFD = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
                this.rFD.setDuration(150);
                if (this.rFA == null) {
                    this.rFA = this.rFv.findViewById(f.qGC);
                    this.rFA.setVisibility(8);
                }
                this.rFE = (LinearLayout) this.rFv.findViewById(f.qGH);
                mVar2 = iN;
                this.rFE.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (com.tencent.mm.plugin.sns.lucky.a.m.Kz(mVar2.bza())) {
                            SnsCommentDetailUI.this.rxz.raa = null;
                            SnsCommentDetailUI.this.rxz.MB("");
                            SnsCommentDetailUI.this.rxz.rHh = 0;
                            SnsCommentDetailUI.this.rxz.iO(true);
                            SnsCommentDetailUI.this.rFA.setVisibility(8);
                            SnsCommentDetailUI.u(SnsCommentDetailUI.this);
                            return;
                        }
                        com.tencent.mm.plugin.sns.lucky.ui.a.e(SnsCommentDetailUI.this.mController.xRr, SnsCommentDetailUI.this.rGq.xQ(0));
                    }
                });
                this.rFE.setOnTouchListener(this.ryR);
                this.rFF = (LinearLayout) this.rFv.findViewById(f.qHg);
                mVar2 = iN;
                bpb2 = byF;
                this.rFF.setOnClickListener(new OnClickListener() {
                    public final void onClick(final View view) {
                        if (!SnsCommentDetailUI.this.rxy) {
                            if (SnsCommentDetailUI.this.rFX != null && mVar2.field_likeFlag == 0) {
                                SnsCommentDetailUI.this.rFX.el(mVar2.field_snsId);
                            }
                            new ag().postDelayed(new Runnable() {
                                public final void run() {
                                    SnsCommentDetailUI snsCommentDetailUI = SnsCommentDetailUI.this;
                                    LinearLayout linearLayout = (LinearLayout) view;
                                    ImageView imageView = (ImageView) linearLayout.findViewById(f.qHf);
                                    Animation scaleAnimation = new ScaleAnimation(0.9f, 1.5f, 0.9f, 1.5f, 1, 0.5f, 1, 0.5f);
                                    scaleAnimation.setDuration(400);
                                    scaleAnimation.setStartOffset(100);
                                    scaleAnimation.setRepeatCount(0);
                                    imageView.clearAnimation();
                                    imageView.startAnimation(scaleAnimation);
                                    scaleAnimation.setAnimationListener(new AnonymousClass38(linearLayout));
                                    SnsCommentDetailUI.v(SnsCommentDetailUI.this);
                                }
                            }, (long) SnsCommentDetailUI.a(SnsCommentDetailUI.this, bpb2, mVar2));
                        }
                    }
                });
                this.rFF.setOnTouchListener(this.ryR);
                imageButton = (ImageButton) this.rFv.findViewById(f.qHp);
                iN2 = iN(true);
                if (!(iN2 == null || (iN2.byV() & 1) == 0)) {
                    imageButton.setVisibility(8);
                }
                if (!(iN2 == null || iN2.byZ())) {
                    imageButton.setVisibility(8);
                }
                imageView2 = (ImageView) this.rFF.findViewById(f.qHf);
                imageView3 = (ImageView) this.rFE.findViewById(f.qGG);
                textView2 = (TextView) this.rFF.findViewById(f.qHh);
                textView3 = (TextView) this.rFE.findViewById(f.qGO);
                if (this.kZv == 11) {
                    this.rFv.findViewById(f.qGC).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFf);
                    imageButton.setImageResource(com.tencent.mm.plugin.sns.i.e.qFn);
                    imageView2.setImageResource(com.tencent.mm.plugin.sns.i.e.qFo);
                    imageView3.setImageResource(com.tencent.mm.plugin.sns.i.e.qFp);
                    textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEC));
                    textView3.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEC));
                    this.rFF.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFq);
                    this.rFE.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFr);
                }
                mVar3 = iN;
                imageButton.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        x.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.this.rFA.getVisibility());
                        SnsCommentDetailUI.this.rxy = false;
                        bpb byF = mVar3.byF();
                        if (byF != null && byF.wYj.wfg == 21 && !com.tencent.mm.plugin.sns.lucky.a.m.Kz(mVar3.bza())) {
                            com.tencent.mm.plugin.sns.lucky.ui.a.e(SnsCommentDetailUI.this.mController.xRr, SnsCommentDetailUI.this.rGq.xQ(0));
                        } else if (SnsCommentDetailUI.this.rFA.getVisibility() == 0) {
                            SnsCommentDetailUI.this.bBo();
                        } else {
                            SnsCommentDetailUI.this.rFA.setVisibility(0);
                            SnsCommentDetailUI.this.rFA.startAnimation(SnsCommentDetailUI.this.rFC);
                            if (SnsCommentDetailUI.this.kZv == 11) {
                                SnsCommentDetailUI.this.rFv.findViewById(f.qGC).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFf);
                            }
                            if (u.Mm(SnsCommentDetailUI.this.fAR)) {
                                SnsCommentDetailUI.this.rFE.setEnabled(true);
                                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.e.qFg);
                                SnsCommentDetailUI.this.rFF.setEnabled(true);
                                textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                                textView3.setTextColor(SnsCommentDetailUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                                m LQ = com.tencent.mm.plugin.sns.storage.h.LQ(SnsCommentDetailUI.this.fAR);
                                if (SnsCommentDetailUI.this.kZv == 11) {
                                    imageView2.setImageResource(com.tencent.mm.plugin.sns.i.e.qFo);
                                    imageView3.setImageResource(com.tencent.mm.plugin.sns.i.e.qFp);
                                    textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEC));
                                    textView3.setTextColor(SnsCommentDetailUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEC));
                                } else {
                                    imageView2.setImageResource(com.tencent.mm.plugin.sns.i.e.qFg);
                                    textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                                    textView3.setTextColor(SnsCommentDetailUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.white));
                                }
                                if (LQ.field_likeFlag == 0) {
                                    textView2.setText(SnsCommentDetailUI.this.getString(j.qRA));
                                    return;
                                } else {
                                    textView2.setText(SnsCommentDetailUI.this.getString(j.qRa));
                                    return;
                                }
                            }
                            SnsCommentDetailUI.this.rFE.setEnabled(false);
                            SnsCommentDetailUI.this.rFF.setEnabled(false);
                            textView2.setText(SnsCommentDetailUI.this.getString(j.qRA));
                            textView2.setTextColor(SnsCommentDetailUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEB));
                            textView3.setTextColor(SnsCommentDetailUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEB));
                            if (SnsCommentDetailUI.this.kZv == 11) {
                                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.qOI);
                            } else {
                                imageView2.setImageResource(com.tencent.mm.plugin.sns.i.i.qOK);
                            }
                        }
                    }
                });
                return true;
            }
        }
        str = aD;
        str.length();
        if (this.kZv != 11) {
        }
        jVar = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.a((Context) this, (CharSequence) str));
        jVar.f(new n(new com.tencent.mm.plugin.sns.data.a(iN.kg(), Xv.getUsername(), iN.bza(), 2), this.rFO, i), str);
        textView.setOnTouchListener(new ab());
        textView.setText(jVar, BufferType.SPANNABLE);
        ((TextView) this.rFv.findViewById(f.qMd)).setText("");
        this.rGt = new bf(this.rFv);
        if (iN.kg()) {
            this.rGt.setVisibility(8);
        } else {
            this.rGt.q(Long.valueOf(iN.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.rGt, 0, this.rFK, iN.field_snsId, iN.bzj()));
            this.rGt.a(iN.byB(), iN.byD());
            this.rGt.a(this.rFY.rVC, this.rFY.rVR);
            this.rGt.setVisibility(0);
        }
        str2 = byF.wYg;
        this.rFw = (TextView) this.rFv.findViewById(f.caU);
        this.rFw.setTag(new as(this.fAR, iN.bza(), true, false, 2));
        this.contextMenuHelper.a(this.rFw, this.rFY.rVv, this.rFY.rVs);
        findViewById = this.rFv.findViewById(f.qHB);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        findViewById = this.rFv.findViewById(f.qHE);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (iN.kg()) {
        }
        aD = str2;
        if (aD != null) {
        }
        this.rFw.setVisibility(8);
        av.e(byF);
        viewStub = (ViewStub) this.rFv.findViewById(f.qIt);
        if (this.rGp) {
            if (this.kZv == 2) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOe);
            } else if (this.kZv == 3) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOb);
            } else if (this.kZv == 4) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOc);
            } else if (this.kZv == 5) {
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qOd);
            } else if (this.kZv != 6) {
                if (this.kZv != 1) {
                }
                viewStub.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qND);
            }
            if (this.kZv != 2) {
            }
            this.rGq = (PhotosContent) viewStub.inflate();
            this.rGp = true;
        }
        if (this.kZv != 6) {
            if (this.kZv != 2) {
            }
            if (this.rGq == null) {
                x.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.kZv + ",stub is " + viewStub.toString());
            } else {
                this.rGq.bAH();
                i2 = 0;
                while (true) {
                    i = i2;
                    if (i < ar.rJT[this.kZv]) {
                        break;
                    }
                    tagImageView = (TagImageView) this.rGq.findViewById(ar.rJX[i]);
                    this.rGq.a(tagImageView);
                    tagImageView.setOnClickListener(this.rFY.rzz);
                    this.contextMenuHelper.a(tagImageView, this.rFY.rVG, this.rFY.rVs);
                    i2 = i + 1;
                }
                this.rGq.xP(this.rFT);
                linkedList = new LinkedList();
                byB = iN.byB();
                if (byB == null) {
                }
                a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlb, 1, byB.rld, byB.rle);
                a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) byB.rlc, 1, byB.rld, byB.rle);
                if (byB.rla == 0) {
                    i2 = ((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth();
                    if (a < ((float) (((i2 - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)))) {
                        fromDPToPix = a;
                        a = a2;
                    } else {
                        fromDPToPix = (float) (((i2 - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12));
                        a = (float) ((int) ((byB.rlc * fromDPToPix) / byB.rlb));
                    }
                    arg = new arg();
                    arg.wFF = fromDPToPix;
                    arg.wFG = a;
                    arg.wFH = arg.wFF * arg.wFG;
                    linkedList.add(arg);
                } else if (byB.rla == 1) {
                    i2 = (((((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12);
                    i3 = (int) ((((float) i2) * byB.rlc) / byB.rlb);
                    arg2 = new arg();
                    if (i2 > 0) {
                        a = (float) i2;
                    }
                    arg2.wFF = a;
                    if (i3 > 0) {
                        a2 = (float) i3;
                    }
                    arg2.wFG = a2;
                    arg2.wFH = arg2.wFF * arg2.wFG;
                    linkedList.add(arg2);
                } else if (byB.rla == 2) {
                    i2 = ((((WindowManager) cnE().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bu.a.fromDPToPix(cnE(), 50)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12)) - com.tencent.mm.bu.a.fromDPToPix(cnE(), 12);
                    i3 = (int) ((((float) i2) * byB.rlc) / byB.rlb);
                    arg2 = new arg();
                    if (i2 > 0) {
                        a = (float) i2;
                    }
                    arg2.wFF = a;
                    if (i3 > 0) {
                        a2 = (float) i3;
                    }
                    arg2.wFG = a2;
                    arg2.wFH = arg2.wFF * arg2.wFG;
                    linkedList.add(arg2);
                }
                if (bi.oN(byB.rlg)) {
                    photosContent = this.rGq;
                    xQ = this.rGq.xQ(0);
                    d.a("adId", byB.rlg, false, 41, 0, /* anonymous class already generated */);
                }
                bpb = byF;
                mVar = iN;
                this.rFv.addOnAttachStateChangeListener(/* anonymous class already generated */);
                arVar = this.rFJ;
                photosContent2 = this.rGq;
                bza = iN.bza();
                hashCode = hashCode();
                i4 = this.kZv;
                iN.xD(32);
                arVar.a(photosContent2, byF, bza, hashCode, i4, -1, false, an.xHw, linkedList);
            }
        }
        textView = (TextView) this.rFv.findViewById(f.qGz);
        if (iN.kg()) {
            if (byF.wYh != null) {
            }
            if (byF.wYh != null) {
            }
            textView.setTag(iN.bza());
            if (bi.oN(charSequence)) {
            }
            textView.setVisibility(0);
            if (bi.oN(jVar)) {
                textView.setText(charSequence);
                textView.setClickable(false);
                textView.setTextColor(-9211021);
            } else {
                textView.setTextColor(-11048043);
                textView.setClickable(true);
                if (iN.field_snsId == 0) {
                }
                textView.setText(jVar);
            }
        } else {
            byD = iN.byD();
            if (byD != null) {
                jVar = byD.rjX;
                aD = byD.rjY;
                textView.setTag(iN.bza());
                if (bi.oN(jVar)) {
                    if (bi.oN(aD)) {
                        textView.setVisibility(0);
                        if (bi.oN(jVar)) {
                            textView.setTextColor(-11048043);
                            textView.setClickable(true);
                            textView.setText(jVar);
                        }
                    } else {
                        textView.setVisibility(0);
                    }
                    textView.setText(jVar);
                    textView.setClickable(false);
                    textView.setTextColor(-9211021);
                }
            }
            textView.setVisibility(8);
        }
        textView.setOnClickListener(this.rFY.rVO);
        ((TextView) this.rFv.findViewById(f.qHo)).setText(az.l(cnE(), ((long) iN.byT()) * 1000));
        asyncTextView = (AsyncTextView) this.rFv.findViewById(f.qGy);
        asyncTextView.setOnClickListener(this.rFY.rVS);
        asyncTextView.setVisibility(8);
        asyncTextView2 = (AsyncTextView) this.rFv.findViewById(f.qGx);
        mVar2 = iN;
        xVar = Xv;
        asyncTextView2.setOnClickListener(/* anonymous class already generated */);
        asyncTextView2.setVisibility(8);
        if (iN.kg()) {
            byD2 = iN.byD();
            asyncTextView.setTag(iN.bza());
            if (byD2.rjZ != com.tencent.mm.plugin.sns.storage.a.rjL) {
                if (byD2.rjZ == com.tencent.mm.plugin.sns.storage.a.rjM) {
                    if (!bi.oN(byD2.rka)) {
                        bza = "";
                        it = byD2.rkc.iterator();
                        while (it.hasNext()) {
                            str3 = (String) it.next();
                            Xu = this.rFL.Xu(str3);
                            if (Xu == null) {
                                bza = bza + str3;
                            } else {
                                str2 = Xu.AX();
                                if (bi.oN(str2)) {
                                    bza = bza + str3;
                                } else {
                                    bza = bza + str2;
                                }
                            }
                            if (byD2.rkc.getLast() != str3) {
                                bza = bza + ",";
                            }
                        }
                        jVar = String.format(byD2.rka, new Object[]{bza});
                        asyncTextView.getTextSize();
                        jVar2 = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d((Context) this, jVar, 1));
                        jVar2.f(null, jVar);
                        paint = asyncTextView.getPaint();
                        if (com.tencent.mm.bu.a.ad(this, (int) Layout.getDesiredWidth(jVar2, 0, jVar2.length(), paint)) > this.rFW) {
                            while (bza.length() > 1) {
                                bza = bza.substring(0, bza.length() - 2);
                                jVar2 = String.format(byD2.rka, new Object[]{bza + "..."});
                                asyncTextView.getTextSize();
                                charSequence22 = new com.tencent.mm.pluginsdk.ui.d.j(com.tencent.mm.pluginsdk.ui.d.i.d((Context) this, jVar2, 1));
                                charSequence22.f(null, jVar2);
                                i4 = com.tencent.mm.bu.a.ad(this, (int) Layout.getDesiredWidth(charSequence22, 0, charSequence22.length(), paint));
                                asyncTextView.setText(charSequence22, BufferType.SPANNABLE);
                                asyncTextView.setVisibility(0);
                                if (i4 <= this.rFW) {
                                    break;
                                }
                            }
                        }
                        asyncTextView.setText(jVar2, BufferType.SPANNABLE);
                        asyncTextView.setVisibility(0);
                    } else {
                        asyncTextView.setVisibility(8);
                    }
                }
            } else if (bi.oN(byD2.rka)) {
                asyncTextView.setVisibility(8);
            } else {
                asyncTextView.setText(byD2.rka);
                asyncTextView.setVisibility(0);
            }
            asyncTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEJ));
            asyncTextView.setOnClickListener(null);
            if (iN.byF().wYj.wfi != 4) {
                asyncTextView2.setVisibility(8);
            } else {
                asyncTextView2.setTag(iN.bza());
                asyncTextView2.setVisibility(0);
                asyncTextView2.setText(String.format("%s%s%s", new Object[]{cnE().getResources().getString(j.qQb), str, cnE().getResources().getString(j.qQc)}));
            }
        }
        textView = (TextView) this.rFv.findViewById(f.qGR);
        textView.setOnTouchListener(new ab());
        aD = com.tencent.mm.plugin.sns.c.a.ihO.l(this, byF.wYi.nMq);
        if (byF.wYj.wfg == 26) {
            aD = getString(j.eeR);
        }
        av.a(byF, (Context) this);
        if (com.tencent.mm.plugin.sns.c.a.ihO.cz(aD)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            jVar = new SpannableString(getString(j.qQs) + aD);
            jVar.setSpan(new a(), 0, jVar.length(), 33);
            textView.setText(jVar, BufferType.SPANNABLE);
            textView.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEJ));
            textView.setOnTouchListener(null);
            textView.setTag(byF);
        }
        textView = (TextView) this.rFv.findViewById(f.qGQ);
        if (iN.getUserName().equals(this.gAM)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setTag(iN.bza() + ";" + iN.byG());
            textView.setOnClickListener(/* anonymous class already generated */);
        }
        textView = (TextView) this.rFv.findViewById(f.qMn);
        m = ai.m(iN);
        if (m != null) {
            if (m.wUX.size() > 0) {
                textView.setVisibility(8);
            } else if (this.gAM.equals(m.vPp)) {
                textView.setVisibility(8);
                it2 = m.wUX.iterator();
                while (it2.hasNext()) {
                    if (this.gAM.equals(((bku) it2.next()).vPp)) {
                        textView.setVisibility(0);
                        charSequence = getString(j.qSB);
                        textView.setVisibility(0);
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, charSequence, textView.getTextSize()));
                        break;
                    }
                }
            } else {
                textView.setVisibility(0);
                it = m.wUX.iterator();
                bza = "";
                obj = null;
                while (it.hasNext()) {
                    bku = (bku) it.next();
                    if (obj != null) {
                        obj3 = obj;
                        str3 = bza + ",  ";
                        obj2 = obj3;
                    } else {
                        str3 = bza + "  ";
                        obj2 = 1;
                    }
                    if (bku.wDh == null) {
                        Xu = this.rFL.Xv(bku.vPp);
                        append = new StringBuilder().append(str3);
                        if (Xu != null) {
                        }
                    } else {
                        append = new StringBuilder().append(str3);
                        aD = bku.wDh;
                    }
                    obj = obj2;
                    bza = append.append(aD).toString();
                }
                textView.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, getString(j.qSA, new Object[]{bza}), textView.getTextSize()));
            }
            if (m != null) {
            }
            this.rFv.findViewById(f.qGS).setVisibility(8);
        } else {
            textView.setVisibility(8);
        }
        this.rFC = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rFC.setDuration(150);
        this.rFD = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rFD.setDuration(150);
        if (this.rFA == null) {
            this.rFA = this.rFv.findViewById(f.qGC);
            this.rFA.setVisibility(8);
        }
        this.rFE = (LinearLayout) this.rFv.findViewById(f.qGH);
        mVar2 = iN;
        this.rFE.setOnClickListener(/* anonymous class already generated */);
        this.rFE.setOnTouchListener(this.ryR);
        this.rFF = (LinearLayout) this.rFv.findViewById(f.qHg);
        mVar2 = iN;
        bpb2 = byF;
        this.rFF.setOnClickListener(/* anonymous class already generated */);
        this.rFF.setOnTouchListener(this.ryR);
        imageButton = (ImageButton) this.rFv.findViewById(f.qHp);
        iN2 = iN(true);
        imageButton.setVisibility(8);
        imageButton.setVisibility(8);
        imageView2 = (ImageView) this.rFF.findViewById(f.qHf);
        imageView3 = (ImageView) this.rFE.findViewById(f.qGG);
        textView2 = (TextView) this.rFF.findViewById(f.qHh);
        textView3 = (TextView) this.rFE.findViewById(f.qGO);
        if (this.kZv == 11) {
            this.rFv.findViewById(f.qGC).setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFf);
            imageButton.setImageResource(com.tencent.mm.plugin.sns.i.e.qFn);
            imageView2.setImageResource(com.tencent.mm.plugin.sns.i.e.qFo);
            imageView3.setImageResource(com.tencent.mm.plugin.sns.i.e.qFp);
            textView2.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEC));
            textView3.setTextColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEC));
            this.rFF.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFq);
            this.rFE.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFr);
        }
        mVar3 = iN;
        imageButton.setOnClickListener(/* anonymous class already generated */);
        return true;
    }

    private void bBo() {
        if (this.rFA != null && this.rFA.getVisibility() != 8) {
            this.rFA.startAnimation(this.rFD);
            this.rFD.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    x.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
                    if (SnsCommentDetailUI.this.rFA != null) {
                        SnsCommentDetailUI.this.rFA.clearAnimation();
                        SnsCommentDetailUI.this.rFA.setVisibility(8);
                    }
                }
            });
        }
    }

    private void bzP() {
        if (this.mController.xRL == 1 || this.rxz.bBx()) {
            this.rGi.run();
        } else {
            this.rxx = true;
        }
    }

    private void bBp() {
        if (this.rFN != null) {
            this.rFN.setPressed(false);
            if (bg.Jk(this.oQL)) {
                this.rFN.setImageResource(com.tencent.mm.plugin.sns.i.e.bDS);
            } else {
                this.rFN.setImageResource(com.tencent.mm.plugin.sns.i.e.bDT);
            }
        }
    }

    private View a(are are, int i, boolean z) {
        int[] iArr = new int[]{f.qLT, f.qLU};
        int i2 = f.qLV;
        if (z) {
            return this.rFv.findViewById(iArr[i]);
        }
        if (are.kzz == 6) {
            return this.rFv.findViewById(i2);
        }
        if (are.kzz == 2) {
            return this.rFv.findViewById(iArr[i]);
        }
        return null;
    }

    private void xT(int i) {
        View findViewById = this.rFv.findViewById(f.qLM);
        View findViewById2 = this.rFv.findViewById(f.qLL);
        if (findViewById != null && findViewById2 != null) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            ((TextView) this.rFv.findViewById(f.qLY)).setText(null);
            ((TextView) this.rFv.findViewById(f.qLZ)).setText(null);
            ((TextView) this.rFv.findViewById(f.qLW)).setText(null);
            ((TextView) this.rFv.findViewById(f.qLX)).setText(null);
            r1 = new int[3][];
            r1[0] = new int[]{f.qLZ, f.qLX};
            r1[1] = new int[]{f.qLY, f.qLW};
            r1[2] = new int[]{f.qLY, f.qLX};
            com.tencent.mm.plugin.sns.storage.b byB = com.tencent.mm.plugin.sns.storage.h.LQ(this.fAR).byB();
            if (byB.rlo != null && byB.rlo.rlu != null && byB.rlo.rlu.size() >= 2) {
                com.tencent.mm.plugin.sns.storage.b.e eVar = (com.tencent.mm.plugin.sns.storage.b.e) byB.rlo.rlu.get(i);
                if (eVar.rlA >= 0 && eVar.rlA < 3) {
                    int[] iArr = r1[eVar.rlA];
                    TextView textView = (TextView) this.rFv.findViewById(iArr[0]);
                    TextView textView2 = (TextView) this.rFv.findViewById(iArr[1]);
                    if (bi.oN(eVar.title)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        textView.setText(eVar.title);
                    }
                    if (bi.oN(eVar.desc)) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setVisibility(0);
                        textView2.setText(eVar.desc);
                    }
                    ((View) textView.getParent()).setVisibility(0);
                    ((View) textView2.getParent()).setVisibility(0);
                }
            }
        }
    }

    private boolean g(List<bku> list, boolean z) {
        int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 32.0f);
        int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 6.0f);
        int b3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 10.0f);
        int b4 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b((Context) this, 17.0f);
        if (this.rFx == null) {
            return false;
        }
        int i;
        x.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", Integer.valueOf(((WindowManager) this.mController.xRr.getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvK)));
        float f = ((float) i) - (f * 2.0f);
        if (list.size() <= 0) {
            if (this.rFx.getParent() != null) {
                this.rFx.setVisibility(8);
            }
            this.rFx.removeAllViews();
            this.rFx.setVisibility(8);
            this.qYm.setVisibility(8);
            return false;
        }
        this.rFx.getParent();
        this.rFx.removeAllViews();
        this.rFx.setVisibility(0);
        if (this.kZv != 11) {
            this.rFx.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFb);
        } else if (this.rGa) {
            m iN = iN(false);
            if (iN == null) {
                this.rFx.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFd);
            } else if (this.gAM.equals(iN.field_userName)) {
                this.rFx.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFe);
            } else {
                this.rFx.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFd);
            }
        } else {
            this.rFx.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFd);
        }
        this.rFx.setPadding(0, b2, 0, b2);
        View imageView = new ImageView(this.mController.xRr);
        if (this.kZv == 11) {
            imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.qOO);
        } else {
            imageView.setImageResource(com.tencent.mm.plugin.sns.i.i.qON);
        }
        imageView.setPadding(b3, b4, b3, 0);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(false);
        imageView.setFocusable(false);
        this.rFx.addView(imageView);
        b3 = com.tencent.mm.bu.a.fromDPToPix(this.mController.xRr, rFV);
        i = ((int) (f - ((float) b3))) / (b2 + b);
        if (((int) (f - ((float) b3))) % (b2 + b) > b) {
            i++;
        }
        x.d("MicroMsg.SnsCommentDetailUI", "guess size %d", Integer.valueOf(i));
        View iVar = new i(this.mController.xRr);
        iVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        iVar.rxt = i;
        i = 0;
        while (true) {
            b3 = i;
            if (b3 >= list.size()) {
                break;
            }
            bku bku = (bku) list.get(b3);
            View touchImageView = new TouchImageView(this.mController.xRr);
            touchImageView.setScaleType(ScaleType.FIT_XY);
            touchImageView.setImageResource(com.tencent.mm.plugin.sns.i.e.qFh);
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b, b);
            layoutParams2.setMargins(0, b2, b2, 0);
            touchImageView.setLayoutParams(layoutParams2);
            touchImageView.setTag(bku.vPp);
            com.tencent.mm.pluginsdk.ui.a.b.b(touchImageView, bku.vPp, true);
            touchImageView.setOnClickListener(this.rGj);
            iVar.addView(touchImageView);
            i = b3 + 1;
        }
        this.rFx.addView(iVar);
        this.qYm.setVisibility(z ? 8 : 0);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m LQ = com.tencent.mm.plugin.sns.storage.h.LQ(this.fAR);
        blf m = ai.m(LQ);
        g(m.wUR, m.wUU.isEmpty());
        if (this.rFy != null) {
            this.rFy.a(LQ, this.rFY);
        }
        if (this.rGq != null) {
            this.rFT = ae.bwn();
            this.rGq.xP(this.rFT);
        }
    }

    public final void Ky(String str) {
    }

    public final void aE(String str, boolean z) {
    }

    public final void buX() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:" + i);
        if (i == 15) {
            if (this.rFY != null && this.rFY.rVs != null) {
                this.rFY.rVs.onActivityResult(i, i2, intent);
            }
        } else if (i == 16) {
            x.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
            com.tencent.mm.sdk.b.b gkVar = new gk();
            gkVar.fxr.scene = 1;
            com.tencent.mm.sdk.b.a.xmy.m(gkVar);
        } else if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 218 && this.rxK != null) {
            this.rxK.dismiss();
        }
        if (i == 0 && i2 == 0) {
            m LQ = com.tencent.mm.plugin.sns.storage.h.LQ(this.fAR);
            if (LQ == null) {
                x.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.fAR);
                finish();
                return;
            }
            x.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.fAR + "  username:" + LQ.field_userName);
            if (this.rFv == null) {
                x.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
                finish();
                return;
            }
            bBn();
            blf m = ai.m(LQ);
            x.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + m.wUR.size() + " " + m.wUU.size());
            if (m != null) {
                if (!f(this.rFG, m.wUR)) {
                    g(m.wUR, m.wUU.isEmpty());
                    this.rFG = m.wUR;
                }
                if (this.rFy != null) {
                    this.rFy.a(LQ, this.rFY);
                }
                b bVar = this.rFB;
                LinkedList linkedList = m.wUU;
                LinkedList linkedList2 = m.wUR;
                bVar.rGY = linkedList;
                bVar.rGZ = linkedList2;
                this.rFB.notifyDataSetChanged();
            }
        }
    }

    public final void aF(String str, boolean z) {
    }

    public final void onKeyboardStateChanged() {
        if (this.mController.xRL == 2) {
            x.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
            this.rFI = false;
            if (this.rxz.oqd) {
                this.rxz.oqd = false;
            } else if (this.rxz.bBt()) {
                this.rxz.bBz();
                this.rxz.MB(getString(j.qSG));
            }
            if (this.rGc) {
                bBn();
            }
        } else if (this.mController.xRL == 1) {
            bBo();
            this.rxx = false;
            this.rGi.run();
        }
    }
}
