package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.VoipWarningDialog;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;
import com.tencent.pb.common.c.g;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b implements com.tencent.mm.plugin.voip.ui.b {
    private static final String ffG;
    private static final String ffH;
    private int mStatus = -1;
    private c sBH;
    private BaseSmallView sBI;
    private al sBJ;
    private WakeLock sBK;
    private long sBL = -1;
    private boolean sBM = false;
    private OnClickListener sBN = new OnClickListener() {
        public final void onClick(View view) {
            if (b.this.sBI != null) {
                b.this.sBI.setOnClickListener(null);
            }
            b.this.syA = new al(new a() {
                public final boolean uG() {
                    x.i("MicroMsg.Voip.VoipSmallWindow", "click small view and time is up we remove it..");
                    b.this.bJA();
                    if (b.this.syA != null) {
                        b.this.syA.TN();
                    }
                    return true;
                }
            }, false);
            b.this.syA.K(2000, 2000);
            Intent intent = new Intent(ad.getContext(), VideoActivity.class);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ad.getContext().startActivity(intent);
        }
    };
    private al sBO;
    private CaptureView srU;
    private com.tencent.mm.storage.x srY;
    private boolean srZ;
    private boolean ssa;
    private int sse = 1;
    private long ssf = -1;
    private boolean stk = false;
    private al syA;

    static {
        String yM = q.yM();
        ffG = yM;
        ffH = o.getString(yM.hashCode());
    }

    public b(c cVar, int i, com.tencent.mm.storage.x xVar, boolean z, boolean z2, boolean z3) {
        x.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", com.tencent.mm.plugin.voip.b.b.zg(i), xVar.field_username, Boolean.valueOf(z));
        this.srY = xVar;
        this.sBH = cVar;
        this.ssa = z;
        this.srZ = z2;
        this.stk = z3;
        dU(0, i);
        this.sBK = ((PowerManager) ad.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
        this.sBK.acquire();
    }

    public final void zc(int i) {
    }

    public final void setMute(boolean z) {
    }

    public final void dU(int i, int i2) {
        Integer num = null;
        x.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", com.tencent.mm.plugin.voip.b.b.zg(i2));
        if (i2 == this.mStatus) {
            x.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
            return;
        }
        this.mStatus = i2;
        String string;
        switch (i2) {
            case 0:
            case 2:
            case 4:
                x.i("MicroMsg.Voip.VoipSmallWindow", "showVideoInviting");
                if (this.sBI != null) {
                    num = (Integer) this.sBI.getTag();
                }
                if (num == null || !(num.intValue() == 0 || 2 == num.intValue() || 4 == num.intValue())) {
                    string = ad.getContext().getString(R.l.eWi);
                    f(string, string, "", true);
                    if (this.sBH != null) {
                        this.sBH.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            case 1:
            case 3:
            case 5:
            case 257:
            case 259:
                if (2 == this.sse) {
                    zn(R.l.eUs);
                }
                bJA();
                string = ad.getContext().getString(R.l.eWp);
                f(string, r.gw(this.srY.field_username), string, true);
                bJy();
                if (this.sBH != null) {
                    this.sBH.a(this, 2);
                    return;
                }
                return;
            case 6:
            case GameJsApiLaunchApplication.CTRL_BYTE /*260*/:
                x.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
                this.sBM = true;
                if (-1 == this.sBL) {
                    this.sBL = System.currentTimeMillis();
                }
                if (this.sBH != null) {
                    this.sBH.a(this, 2);
                }
                if (com.tencent.mm.compatible.f.b.aM(ad.getContext())) {
                    bJw();
                } else {
                    x.e("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking, permission denied");
                    VoipWarningDialog.a(ad.getContext(), new VoipWarningDialog.a() {
                        public final void a(VoipWarningDialog voipWarningDialog) {
                            voipWarningDialog.finish();
                            String string = ad.getContext().getString(R.l.eWi);
                            b.this.f(string, r.gw(b.this.srY.field_username), string, false);
                            if (com.tencent.mm.plugin.voip.b.b.zl(b.this.mStatus) || com.tencent.mm.plugin.voip.b.b.zj(b.this.mStatus)) {
                                b.this.bJw();
                            }
                        }

                        public final void b(VoipWarningDialog voipWarningDialog) {
                            voipWarningDialog.finish();
                        }
                    });
                    if (!d.bGT().sti) {
                        d.bGT().sti = true;
                        as.Hm();
                        if (System.currentTimeMillis() - com.tencent.mm.y.c.Db().DF(327950) > 86400000) {
                            String str = "have not permission to showing floating window\n";
                            as.Hm();
                            com.tencent.mm.y.c.Db().setLong(327950, System.currentTimeMillis());
                            x.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + str.length());
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.vHl).append("\n");
                            stringBuilder.append("#accinfo.revision=").append(e.REV).append("\n");
                            stringBuilder.append("#accinfo.uin=").append(ar.hhz.H("last_login_uin", ffH)).append("\n");
                            stringBuilder.append("#accinfo.dev=").append(ffG).append("\n");
                            stringBuilder.append("#accinfo.build=").append(e.TIME).append(":").append(e.HOSTNAME).append(":").append(f.fei).append("\n");
                            Date date = new Date();
                            stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
                            stringBuilder.append("#accinfo.content:\n");
                            Intent intent = new Intent();
                            intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                            intent.setAction("uncatch_exception");
                            intent.putExtra("exceptionWriteSdcard", false);
                            intent.putExtra("exceptionPid", Process.myPid());
                            String str2 = "userName";
                            string = ar.hhz.H("login_weixin_username", "");
                            if (bi.oN(string)) {
                                string = ar.hhz.H("login_user_name", "never_login_crash");
                            }
                            intent.putExtra(str2, string);
                            intent.putExtra("tag", "float_window_permission");
                            intent.putExtra("exceptionMsg", Base64.encodeToString((stringBuilder.toString() + str).getBytes(), 2));
                            ad.getContext().startService(intent);
                        }
                    }
                }
                string = ad.getContext().getString(R.l.eWi);
                f(string, r.gw(this.srY.field_username), string, false);
                return;
            case 7:
            case 261:
                x.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
                if (-1 == this.sBL) {
                    this.sBL = System.currentTimeMillis();
                }
                if (2 == this.sse) {
                    zn(R.l.eUs);
                }
                bJA();
                if (this.sBH != null) {
                    this.sBH.a(this, 2);
                }
                this.sBJ = new al(new a() {
                    public final boolean uG() {
                        x.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + b.this.mStatus);
                        if (b.this.mStatus == 8 || b.this.mStatus == 262 || !com.tencent.mm.plugin.voip.b.d.bJa()) {
                            as.getNotification().cancel(40);
                            x.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking...CALLING_STATE_FINISH state..cancel notification..");
                            if (b.this.sBJ == null || b.this.sBJ.cgx()) {
                                return false;
                            }
                            b.this.sBJ.TN();
                            return false;
                        }
                        x.i("MicroMsg.Voip.VoipSmallWindow", "show voice talking, first timer trigger..");
                        String h = b.this.bJz();
                        b.this.f(h, r.gw(b.this.srY.field_username), h, false);
                        return true;
                    }
                }, true);
                this.sBJ.K(5000, 5000);
                string = bJz();
                f(string, r.gw(this.srY.field_username), string, false);
                bJy();
                if (4101 == i) {
                    zn(R.l.eWc);
                    return;
                }
                return;
            case 8:
            case 262:
                int i3;
                switch (i) {
                    case 4099:
                        if (!this.ssa) {
                            i3 = R.l.eUr;
                            break;
                        } else {
                            i3 = R.l.eWh;
                            break;
                        }
                    case 4105:
                        i3 = R.l.eVR;
                        break;
                    case 4106:
                        i3 = R.l.eWa;
                        break;
                    default:
                        bJA();
                        return;
                }
                zn(i3);
                bJA();
                return;
            case 256:
            case 258:
                x.i("MicroMsg.Voip.VoipSmallWindow", "showCalledVideoInviting");
                if (this.sBI != null) {
                    num = (Integer) this.sBI.getTag();
                }
                if (num == null || !(256 == num.intValue() || 258 == num.intValue())) {
                    string = ad.getContext().getString(R.l.eWi);
                    f(string, string, "", true);
                    if (this.sBH != null) {
                        this.sBH.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void zn(int i) {
        Context context = ad.getContext();
        Toast.makeText(context, context.getString(i), 1).show();
    }

    private void bJw() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "show mini..");
        bJA();
        Context context = ad.getContext();
        d.bGT();
        this.sBI = new a(context, m.jp(false));
        this.sBI.ff(this.ssf);
        context = ad.getContext();
        d.bGT();
        int height = (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 5) + com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 7.0f);
        int b = (int) (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 7.0f)) + (m.jp(true) * ((float) height)));
        this.sBI.dY(b, height);
        this.sBI.setOnClickListener(this.sBN);
        x.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
        Point point = new Point(b, height);
        x.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
        if (com.tencent.mm.plugin.voip.b.b.zl(this.mStatus) || com.tencent.mm.plugin.voip.b.b.zj(this.mStatus)) {
            if (this.sBJ != null) {
                this.sBJ.TN();
            }
            if (this.sBO != null) {
                this.sBO.TN();
            }
            if (this.syA != null) {
                this.syA.TN();
            }
            as.getNotification().cancel(40);
            WindowManager windowManager = (WindowManager) ad.getContext().getSystemService("window");
            LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = 2002;
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 51;
            context = ad.getContext();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.width = point.x;
            layoutParams.height = point.y;
            point = d.bGT().sth;
            if (point == null) {
                as.Hm();
                int i = com.tencent.mm.y.c.Db().getInt(327947, 0);
                b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 5.0f);
                layoutParams.x = (displayMetrics.widthPixels - layoutParams.width) - b;
                layoutParams.y = b + i;
            } else {
                layoutParams.x = point.x;
                layoutParams.y = point.y;
            }
            if (this.srU != null) {
                if (this.srU.getParent() != null && (this.srU.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.srU.getParent()).removeView(this.srU);
                }
                this.sBI.a(this.srU);
            }
            this.sBI.setTag(Integer.valueOf(this.mStatus));
            try {
                windowManager.addView(this.sBI, layoutParams);
                return;
            } catch (Exception e) {
                x.e("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager failed: %s", e.getMessage());
                return;
            }
        }
        x.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
    }

    public final String bJx() {
        String format;
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.ssf);
        if (this.ssf == -1) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 3600) {
            format = String.format(Locale.US, "%d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        } else {
            format = String.format(Locale.US, "%d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        if (g.Bf(format)) {
            return "00:00";
        }
        return format;
    }

    private void bJy() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
        boolean z = false;
        if (this.mStatus == 261 || this.mStatus == 7) {
            this.sBO = new al(new a() {
                public final boolean uG() {
                    d.bGU().Nj(b.this.bJx());
                    return true;
                }
            }, true);
            this.sBO.K(1000, 1000);
            z = true;
        }
        Intent intent = new Intent();
        intent.setClass(ad.getContext(), VideoActivity.class);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("Voip_User", this.srY.field_username);
        intent.putExtra("Voip_Outcall", this.srZ);
        intent.putExtra("Voip_VideoCall", this.ssa);
        intent.putExtra("Voip_Is_Talking", z);
        d.bGU().a(intent, new com.tencent.mm.plugin.voip.ui.a() {
            public final boolean aTJ() {
                if (com.tencent.mm.plugin.voip.b.b.zl(b.this.mStatus) || com.tencent.mm.plugin.voip.b.b.zj(b.this.mStatus)) {
                    return true;
                }
                return false;
            }

            public final void a(Intent intent, h hVar) {
                if (intent.getBooleanExtra("Voip_Is_Talking", false)) {
                    hVar.Nj(b.this.bJx());
                } else {
                    hVar.Nj(ad.getContext().getString(R.l.ewY));
                }
            }
        });
    }

    private String bJz() {
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.ssf);
        if (this.ssf == -1) {
            currentTimeMillis = 0;
        }
        String string = ad.getContext().getString(R.l.eWp);
        if (currentTimeMillis >= 3600) {
            return string + String.format(Locale.US, "    %d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        return string + String.format(Locale.US, "    %d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
    }

    public final void f(final String str, final String str2, final String str3, boolean z) {
        x.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + str + ",title:" + str2 + ",content:" + str3 + ",breathEffect:" + z);
        x.j("MicroMsg.Voip.VoipSmallWindow", "breathEffect " + z, new Object[0]);
        if (z) {
            this.sBJ = new al(new a() {
                private int mCount = 0;

                public final boolean uG() {
                    x.i("MicroMsg.Voip.VoipSmallWindow", "time out ,status is " + b.this.mStatus);
                    this.mCount++;
                    if (b.this.mStatus == 8 || b.this.mStatus == 262 || !com.tencent.mm.plugin.voip.b.d.bJa()) {
                        x.i("MicroMsg.Voip.VoipSmallWindow", "CALLING_STATE_FINISH state..cancel notification..");
                        as.getNotification().cancel(40);
                        if (!(b.this.sBJ == null || b.this.sBJ.cgx())) {
                            b.this.sBJ.TN();
                        }
                        return false;
                    }
                    b.this.f(str + (this.mCount % 2 == 1 ? " " : ""), str2, str3, false);
                    return true;
                }
            }, true);
            this.sBJ.K(5000, 5000);
        }
        Intent intent = new Intent();
        intent.setClass(ad.getContext(), VideoActivity.class);
        intent.putExtra("Voip_User", this.srY.field_username);
        intent.putExtra("Voip_Outcall", this.srZ);
        intent.putExtra("Voip_VideoCall", this.ssa);
        Notification a = com.tencent.mm.plugin.voip.b.d.a(new Builder(ad.getContext()).setTicker(str).setWhen(System.currentTimeMillis()).setContentTitle(str2).setContentText(str3).setContentIntent(PendingIntent.getActivity(ad.getContext(), 40, intent, 134217728)).setOngoing(true));
        a.icon = VERSION.SDK_INT < 19 ? R.g.bEq : R.g.bEr;
        as.getNotification().a(40, a, false);
    }

    private void bJA() {
        x.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView");
        if (this.sBJ != null) {
            this.sBJ.TN();
        }
        x.i("MicroMsg.Voip.VoipSmallWindow", "remove small view..cancel notification first..");
        as.getNotification().cancel(40);
        if (this.sBI != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.sBI.getLayoutParams();
            d.bGT().sth = new Point(layoutParams.x, layoutParams.y);
            this.sBI.uninit();
            try {
                ((WindowManager) ad.getContext().getSystemService("window")).removeView(this.sBI);
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.Voip.VoipSmallWindow", "remove failed", e);
            }
            this.sBI = null;
        }
        d.bGU().Nj(ad.getContext().getString(R.l.ewk));
        if (this.sBO != null) {
            this.sBO.TN();
        }
        d.bGU().dismiss();
    }

    public final void aP(int i, String str) {
        int i2;
        if (i == GameJsApiGetGameCommInfo.CTRL_BYTE) {
            Toast.makeText(ad.getContext(), str, 1).show();
        }
        x.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = R.l.eVu;
        } else if (i == 233) {
            d.bGT().bIe();
            i2 = R.l.eVt;
        } else {
            i2 = i == bd.CTRL_BYTE ? (!com.tencent.mm.aq.b.PZ() || this.ssa) ? R.l.eVv : R.l.eVx : i == JsApiGetSetting.CTRL_INDEX ? R.l.eVH : i == com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX ? R.l.eVw : 0;
        }
        if (i2 == 0) {
            zn(R.l.eVs);
        } else {
            zn(i2);
        }
    }

    public final void Ni(String str) {
    }

    public final void b(int i, int i2, int[] iArr) {
        if ((GameJsApiLaunchApplication.CTRL_BYTE == this.mStatus || 6 == this.mStatus) && this.sBI != null) {
            this.sBI.b(i, i2, iArr);
        }
    }

    public final void bHJ() {
        if (this.sBI != null) {
            this.sBI.bHJ();
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if ((GameJsApiLaunchApplication.CTRL_BYTE == this.mStatus || 6 == this.mStatus) && this.sBI != null) {
            this.sBI.a(bArr, j, i, i2, i3, i4, i5);
        }
    }

    public final Context bIK() {
        return null;
    }

    public final void uninit() {
        int i = 3;
        x.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
        if (-1 != this.sBL) {
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
            Object[] objArr = new Object[3];
            if (this.sBM) {
                i = 2;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Long.valueOf((System.currentTimeMillis() - this.sBL) / 1000);
            objArr[2] = Integer.valueOf(this.stk ? 1 : 2);
            gVar.h(11620, objArr);
        }
        if (this.sBK != null && this.sBK.isHeld()) {
            this.sBK.release();
        }
        bJA();
        if (this.sBJ != null) {
            this.sBJ.TN();
        }
        if (this.sBO != null) {
            this.sBO.TN();
        }
        x.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
        as.getNotification().cancel(40);
        this.srU = null;
    }

    public final void ff(long j) {
        this.ssf = j;
        if (this.sBI != null) {
            this.sBI.ff(j);
        } else if (261 == this.mStatus || 7 == this.mStatus) {
            String bJz = bJz();
            f(bJz, r.gw(this.srY.field_username), bJz, false);
        }
    }

    public final void bIL() {
        Toast.makeText(ad.getContext(), R.l.eVO, 1).show();
    }

    public final void aVo() {
    }

    public final void a(CaptureView captureView) {
        this.srU = captureView;
        if (this.sBI != null && this.srU != null) {
            if (this.srU.getParent() != null && (this.srU.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.srU.getParent()).removeView(this.srU);
            }
            this.sBI.a(captureView);
        }
    }
}
