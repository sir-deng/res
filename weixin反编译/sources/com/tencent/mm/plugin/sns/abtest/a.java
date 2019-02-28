package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.bq;
import com.tencent.mm.f.a.gf;
import com.tencent.mm.f.a.ps;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.a.f;
import com.tencent.mm.y.a.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Arrays;

public final class a {
    private static Context context = null;
    private static boolean qTp = false;
    private static String qTq = "0";
    private static OnClickListener qTr = null;
    private static int qTs = -1;
    private static int qTt = -1;
    private static long qTu = 0;
    private static View qTv = null;
    private static b qTw = null;
    private static c qTx = null;
    private static com.tencent.mm.sdk.b.c qTy = new com.tencent.mm.sdk.b.c<ps>() {
        {
            this.xmG = ps.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ps psVar = (ps) bVar;
            if (psVar instanceof ps) {
                boolean z = psVar.fIn.fIo;
                long j = psVar.fIn.fxi;
                x.d("MicroMsg.NotInteresetABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", Boolean.valueOf(z), Long.valueOf(j));
                if (!(j == 0 || a.qTu == 0 || a.qTu != j)) {
                    if (z) {
                        a.qTs = 4;
                    } else {
                        a.qTs = 3;
                    }
                    a.akX();
                }
            }
            return false;
        }
    };
    private static com.tencent.mm.sdk.b.c qTz = new com.tencent.mm.sdk.b.c<gf>() {
        {
            this.xmG = gf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            gf gfVar = (gf) bVar;
            if (gfVar instanceof gf) {
                boolean z = gfVar.fxg.fxh;
                long j = gfVar.fxg.fxi;
                x.d("MicroMsg.NotInteresetABTestManager", "notInterestFinishEventListener callback, isNotInterest:%b, sndId:%d", Boolean.valueOf(z), Long.valueOf(j));
                if (!(j == 0 || a.qTu == 0 || j != a.qTu)) {
                    if (z) {
                        a.qTs = 2;
                    } else {
                        a.qTs = 1;
                    }
                    a.akX();
                }
            }
            return false;
        }
    };

    static /* synthetic */ void a(View view, Context context, m mVar) {
        if (context != null) {
            if (mVar != null) {
                qTu = mVar.field_snsId;
            }
            b bVar = qTw;
            if (view != null && !bVar.qTV) {
                com.tencent.mm.sdk.b.a.xmy.m(new bq());
                if (bVar.qTT) {
                    bVar.buD();
                    return;
                }
                if (bVar.jSO == 0) {
                    bVar.jSO = e.ec(context);
                }
                if (bVar.MP == 0) {
                    bVar.MP = e.eb(context);
                }
                if (bVar.qTO == 0) {
                    bVar.qTO = view.getMeasuredHeight();
                    if (bVar.qTO <= 0) {
                        bVar.qTO = com.tencent.mm.bu.a.fromDPToPix(context, 15);
                    }
                }
                if (bVar.qTP <= 0) {
                    bVar.qTP = com.tencent.mm.bu.a.fromDPToPix(context, 8);
                }
                if (bVar.qTQ <= 0) {
                    bVar.qTQ = com.tencent.mm.bu.a.fromDPToPix(context, 3);
                }
                if (bVar.mScreenHeight == 0) {
                    bVar.mScreenHeight = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
                    bVar.mScreenHeight -= bVar.MP;
                    bVar.mScreenHeight -= bVar.jSO;
                }
                if (bVar.qTR == 0) {
                    bVar.qTR = com.tencent.mm.bu.a.fromDPToPix(context, 150);
                }
                if (bVar.qTS == 0) {
                    bVar.qTS = com.tencent.mm.bu.a.fromDPToPix(context, 13);
                }
                bVar.qTH = new NotInterestMenu(context);
                if (bVar.qTC != null) {
                    bVar.qTH.qTC = bVar.qTC;
                }
                bVar.qTH.qTD = bVar.qTJ;
                bVar.qTH.qEj = mVar;
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                x.d("MicroMsg.NotInterestMenuHelper", "hateLocation: %s", Arrays.toString(iArr));
                int i = (((iArr[1] - bVar.jSO) - bVar.MP) + bVar.qTO) - bVar.qTP;
                x.d("MicroMsg.NotInterestMenuHelper", "getDownModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickDownPadding:%d", Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.jSO), Integer.valueOf(bVar.MP), Integer.valueOf(bVar.qTO), Integer.valueOf(bVar.qTP));
                x.d("MicroMsg.NotInterestMenuHelper", "isEnoughHeightToDownMenu, y:%d, menuHeight:%d, screenHeight:%d", Integer.valueOf(i), Integer.valueOf(bVar.qTR), Integer.valueOf(bVar.mScreenHeight));
                if (bVar.qTR + i <= bVar.mScreenHeight) {
                    bVar.qTH.setBackgroundResource(i.e.qFu);
                    bVar.qTW = true;
                } else {
                    bVar.qTH.setBackgroundResource(i.e.qFv);
                    i = (((iArr[1] - bVar.jSO) - bVar.MP) - bVar.qTR) + bVar.qTQ;
                    x.d("MicroMsg.NotInterestMenuHelper", "getUpModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickUpPadding:%d, mMenuHeight:%d", Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.jSO), Integer.valueOf(bVar.MP), Integer.valueOf(bVar.qTO), Integer.valueOf(bVar.qTQ), Integer.valueOf(bVar.qTR));
                    bVar.qTW = false;
                }
                if (bVar.qTU == null) {
                    bVar.qTU = new AbsoluteLayout(context);
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bVar.qTU.setBackgroundDrawable(context.getResources().getDrawable(i.e.qEZ));
                    bVar.qTU.setPadding(bVar.qTS, 0, bVar.qTS, 0);
                    bVar.qTU.setLayoutParams(layoutParams);
                }
                if (bVar.qTI != null) {
                    bVar.qTI.addView(bVar.qTU);
                }
                bVar.qTU.addView(bVar.qTH, new AbsoluteLayout.LayoutParams(-1, -2, 0, i));
                bVar.qTH.setVisibility(4);
                if (bVar.qTW) {
                    bVar.qTH.startAnimation(bVar.qTK);
                } else {
                    bVar.qTH.startAnimation(bVar.qTL);
                }
            }
        }
    }

    static /* synthetic */ void akX() {
        if (qTp && qTu != 0) {
            String str = qTs + "|" + qTt + "|" + qTu;
            g.Ip().ih("7").hjV = 4;
            g.Ip().ih("7").result = str;
            f.a(g.Ip().ih("7"));
            x.d("MicroMsg.NotInteresetABTestManager", "report not interest abtest, scene:%d, result:%s", Integer.valueOf(4), str);
        }
        qTt = -1;
        qTs = -1;
        qTu = 0;
    }

    static /* synthetic */ void b(Context context, m mVar) {
        if (mVar != null && context != null) {
            a(mVar);
            String str = mVar.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str);
            intent.putExtra("sns_permission_snsinfo_svr_id", mVar.field_snsId);
            intent.putExtra("sns_permission_block_scene", 6);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
    }

    static /* synthetic */ void c(Context context, m mVar) {
        if (mVar != null && context != null) {
            a(mVar);
            Intent intent = new Intent();
            x.i("MicroMsg.NotInteresetABTestManager", "expose id " + mVar.byG());
            intent.putExtra("showShare", false);
            intent.putExtra("k_expose_msg_id", mVar == null ? 0 : mVar.field_snsId);
            intent.putExtra("k_username", mVar == null ? "" : mVar.field_userName);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public static void d(Context context, ViewGroup viewGroup) {
        if (g.Ip().ih("7") != null) {
            qTp = true;
            qTq = g.Ip().ih("7").value;
            x.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", qTq);
            qTv = viewGroup;
            qTw = new b(viewGroup);
            context = context;
            com.tencent.mm.sdk.b.a.xmy.b(qTy);
            com.tencent.mm.sdk.b.a.xmy.b(qTz);
            qTr = new OnClickListener() {
                public final void onClick(View view) {
                    if (view.getTag() instanceof m) {
                        a.a(view, view.getContext(), (m) view.getTag());
                    }
                }
            };
            qTx = new c() {
                public final void c(m mVar) {
                    a.a(a.context, mVar);
                }

                public final void d(m mVar) {
                    a.b(a.context, mVar);
                }

                public final void e(m mVar) {
                    a.c(a.context, mVar);
                }
            };
            qTw.qTC = qTx;
        }
    }

    public static void buz() {
        if (qTw != null) {
            qTw.buD();
        }
    }

    private static void a(m mVar) {
        boolean equals = qTq.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        if (mVar.field_type == 1) {
            if (equals) {
                qTt = 5;
            } else {
                qTt = 0;
            }
        } else if (mVar.field_type == 2) {
            if (equals) {
                qTt = 4;
            } else {
                qTt = 1;
            }
        } else if (mVar.field_type == 15) {
            if (!equals) {
                qTt = 2;
            }
        } else if (!com.tencent.mm.plugin.sns.data.i.f(mVar)) {
        } else {
            if (equals) {
                qTt = 6;
            } else {
                qTt = 3;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, com.tencent.mm.plugin.sns.storage.m r7) {
        /*
        r0 = 2;
        r1 = 1;
        r2 = qTp;
        if (r2 == 0) goto L_0x004c;
    L_0x0006:
        if (r7 == 0) goto L_0x004c;
    L_0x0008:
        if (r6 == 0) goto L_0x004c;
    L_0x000a:
        r2 = r7.field_snsId;
        qTu = r2;
        a(r7);
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.class;
        r2.<init>(r6, r3);
        r3 = "sns_info_svr_id";
        r4 = qTu;
        r2.putExtra(r3, r4);
        r3 = "sns_info_not_interest_scene";
        r4 = qTp;
        if (r4 == 0) goto L_0x006a;
    L_0x0027:
        r4 = qTq;
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
        if (r4 != 0) goto L_0x006a;
    L_0x002f:
        r4 = qTq;
        r5 = "1";
        r4 = r4.equals(r5);
        if (r4 != 0) goto L_0x0045;
    L_0x003a:
        r4 = qTq;
        r5 = "2";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x004d;
    L_0x0045:
        r0 = r1;
    L_0x0046:
        r2.putExtra(r3, r0);
        r6.startActivity(r2);
    L_0x004c:
        return;
    L_0x004d:
        r4 = qTq;
        r5 = "3";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x006a;
    L_0x0058:
        r4 = com.tencent.mm.plugin.sns.data.i.f(r7);
        if (r4 == 0) goto L_0x0060;
    L_0x005e:
        r0 = 4;
        goto L_0x0046;
    L_0x0060:
        r4 = r7.field_type;
        if (r4 != r1) goto L_0x0066;
    L_0x0064:
        r0 = 3;
        goto L_0x0046;
    L_0x0066:
        r1 = r7.field_type;
        if (r1 == r0) goto L_0x0046;
    L_0x006a:
        r0 = 0;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.abtest.a.a(android.content.Context, com.tencent.mm.plugin.sns.storage.m):void");
    }

    public static void a(ContextMenu contextMenu, m mVar) {
        if (qTp && qTq.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) && mVar != null && !mVar.xD(32) && !mVar.field_userName.equals(ae.bvL()) && mVar.field_type != 15) {
            contextMenu.add(0, 13, 0, j.qRe);
        }
    }

    public static void a(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (qTp && !bi.oN(qTq) && !qTq.equals("0")) {
            cVar.rUE = (ImageView) view.findViewById(i.f.qKz);
            cVar.rUE.setVisibility(8);
            cVar.rUF = false;
            if (!qTq.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                cVar.rUE.setOnClickListener(qTr);
            }
        }
    }

    public static void b(m mVar) {
        if (qTp) {
            qTu = mVar.field_snsId;
            a(mVar);
        }
    }

    public static void clean() {
        qTt = -1;
        qTs = -1;
        qTu = 0;
        qTr = null;
        qTx = null;
        qTv = null;
        context = null;
        qTp = false;
        qTq = "0";
        f.im("7");
        com.tencent.mm.sdk.b.a.xmy.c(qTy);
        com.tencent.mm.sdk.b.a.xmy.c(qTz);
    }
}
