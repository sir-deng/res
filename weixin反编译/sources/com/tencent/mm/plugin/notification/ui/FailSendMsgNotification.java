package com.tencent.mm.plugin.notification.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.z.d;
import com.tencent.mm.R;
import com.tencent.mm.f.a.kf;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;

@SuppressLint({"InlinedApi"})
public final class FailSendMsgNotification {
    boolean lFv = false;
    public Context mContext;
    private boolean mIsInit = false;
    private int mType;
    public String paA = null;
    public String paB = null;
    private PendingIntent paC = null;
    private PendingIntent paD = null;
    private PendingIntent paE = null;
    private PendingIntent paF = null;
    public boolean paG = false;
    public boolean paH = false;
    public boolean paI = true;
    public d pau = null;
    private Intent pav = null;
    private int paw = 0;
    public a pax = null;
    public b pay = null;
    public c paz = null;
    Notification sx = null;

    public static class FailSendSnsMsgNotificationService extends FailSendMsgNotificationService {
        protected final int bhu() {
            return 2;
        }
    }

    public static abstract class FailSendMsgNotificationService extends Service {
        protected c paJ = new c<kf>() {
            {
                this.xmG = kf.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                if (((kf) bVar).fCt.type != FailSendMsgNotificationService.this.bhu()) {
                    x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, type mismatch, type:%d, getNotificationType:%d", Integer.valueOf(((kf) bVar).fCt.type), Integer.valueOf(FailSendMsgNotificationService.this.bhu()));
                } else {
                    x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotificationService, resend finish, stop service and show notificaiton, type:%d", Integer.valueOf(((kf) bVar).fCt.type));
                    FailSendMsgNotificationService.this.stopForeground(true);
                    if (FailSendMsgNotificationService.this.paK != null) {
                        FailSendMsgNotificationService.this.paK.lFv = false;
                        FailSendMsgNotificationService.this.paK.show();
                    }
                    FailSendMsgNotificationService.this.stopSelf();
                }
                return false;
            }
        };
        protected FailSendMsgNotification paK = null;

        protected abstract int bhu();

        public void onCreate() {
            super.onCreate();
            x.d("MicroMsg.FailSendMsgNotification", "onCreate FailSendMsgNotificationService");
            a.xmy.b(this.paJ);
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        @TargetApi(16)
        public int onStartCommand(Intent intent, int i, int i2) {
            x.d("MicroMsg.FailSendMsgNotification", "onStartCommand");
            if (intent == null || intent.getExtras() == null) {
                x.d("MicroMsg.FailSendMsgNotification", "handle action button, intent is null");
            } else {
                String action = intent.getAction();
                if (bi.oN(action)) {
                    x.d("MicroMsg.FailSendMsgNotification", "handle action button, action is null");
                } else {
                    int i3 = intent.getExtras().getInt("notification_type", -1);
                    x.d("MicroMsg.FailSendMsgNotification", "handle action button, type:%d", Integer.valueOf(i3));
                    if (f.uD(i3) == null) {
                        x.d("MicroMsg.FailSendMsgNotification", "handle action button, notification not exist");
                    } else {
                        x.d("MicroMsg.FailSendMsgNotification", "action:%s", action);
                        this.paK = f.uD(i3);
                        if (action.startsWith("com.tencent.failnotification.omit")) {
                            if (this.paK.pax != null) {
                                x.d("MicroMsg.FailSendMsgNotification", "handle omit action button, type:%d", Integer.valueOf(i3));
                                this.paK.pax.bhf();
                            }
                        } else if (action.startsWith("com.tencent.failnotificaiton.resend")) {
                            if (this.paK.pax != null) {
                                boolean z;
                                String str = "MicroMsg.FailSendMsgNotification";
                                String str2 = "handle resend action button, type:%d, notification==null:%b, notificationBuilder==null:%b";
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(i3);
                                objArr[1] = Boolean.valueOf(this.paK.sx == null);
                                if (this.paK.pau == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                objArr[2] = Boolean.valueOf(z);
                                x.d(str, str2, objArr);
                                if (this.paK != null) {
                                    this.paK.lFv = true;
                                }
                                if (this.paK.sx != null && VERSION.SDK_INT >= 16) {
                                    this.paK.sx.priority = 0;
                                }
                                if (this.paK.sx == null) {
                                    this.paK.show();
                                }
                                startForeground(i3, this.paK.sx);
                                this.paK.pax.bhe();
                                x.d("MicroMsg.FailSendMsgNotification", "finish handle resend action button, type:%d", Integer.valueOf(i3));
                            }
                        } else if (action.startsWith("com.tencent.failnotification.click")) {
                            if (this.paK.pay != null) {
                                x.d("MicroMsg.FailSendMsgNotification", "handle click notification, type:%d", Integer.valueOf(i3));
                                this.paK.pay.bhg();
                            }
                        } else if (action.startsWith("com.tencent.failnotification.dismiss")) {
                            this.paK.paG = false;
                            this.paK.lFv = false;
                            if (this.paK.paz != null) {
                                x.d("MicroMsg.FailSendMsgNotification", "handle notification dismiss");
                                this.paK.paz.onDismiss();
                            }
                            stopSelf();
                        }
                    }
                }
            }
            return 2;
        }

        public void onDestroy() {
            super.onDestroy();
            x.d("MicroMsg.FailSendMsgNotification", "onDestroy FailSendMsgNotificationService");
            a.xmy.c(this.paJ);
        }
    }

    public static class FailSendNormalMsgNotificationService extends FailSendMsgNotificationService {
        protected final int bhu() {
            return 1;
        }
    }

    public FailSendMsgNotification(int i) {
        boolean z;
        this.mType = i;
        this.mContext = ad.getContext();
        this.pau = new d(this.mContext);
        this.paI = true;
        this.paB = "";
        try {
            if (this.paI) {
                bhp();
            }
            bhq();
            this.mIsInit = true;
        } catch (Exception e) {
            x.e("MicroMsg.FailSendMsgNotification", "init FailSendMsgNotification error, e:%s", e.getMessage());
            this.mIsInit = false;
        }
        String str = "MicroMsg.FailSendMsgNotification";
        String str2 = "create FailSendMsgNotification, type:%d, context==null:%b";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        if (this.mContext == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        this.paG = false;
    }

    private void bhp() {
        this.pau.ss = true;
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.omit_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.omit_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.paE = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.pau.a(R.g.bEt, this.mContext.getString(R.l.eyZ), this.paE);
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotificaiton.resend_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotificaiton.resend_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        if (VERSION.SDK_INT >= 16) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        this.paF = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.pau.a(R.g.bEu, this.mContext.getString(R.l.eza), this.paF);
    }

    public final void bhq() {
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.click_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.click_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.paC = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.pau.sa = this.paC;
        intent = new Intent();
        if (this.mType == 1) {
            intent.setAction("com.tencent.failnotification.dismiss_msg");
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
        } else if (this.mType == 2) {
            intent.setAction("com.tencent.failnotification.dismiss_sns");
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
        }
        intent.putExtra("notification_type", this.mType);
        this.paD = PendingIntent.getService(this.mContext, this.mType, intent, 134217728);
        this.pau.sx.deleteIntent = this.paD;
    }

    public final void Ht(String str) {
        this.paA = str;
        show();
    }

    public final void bhr() {
        x.d("MicroMsg.FailSendMsgNotification", "setIsForeground:%b", Boolean.valueOf(false));
        this.lFv = false;
    }

    @TargetApi(16)
    public final void show() {
        if (this.mIsInit) {
            this.pau.c(this.paB);
            this.pau.a(this.mContext.getText(R.l.app_name));
            this.pau.U(VERSION.SDK_INT < 19 ? R.g.bEq : R.g.bEr);
            this.pau.b(this.paA);
            this.pau.p(false);
            this.sx = this.pau.build();
            if (VERSION.SDK_INT >= 16 && !this.lFv) {
                this.sx.priority = 2;
                x.d("MicroMsg.FailSendMsgNotification", "show notification, set priority to max");
            }
            x.d("MicroMsg.FailSendMsgNotification", "show notification, mIsForeground:%b", Boolean.valueOf(this.lFv));
            as.getNotification().a(this.mType, this.sx, false);
            this.paG = true;
            return;
        }
        x.e("MicroMsg.FailSendMsgNotification", "when show notification, is not init yet");
    }

    public final void dismiss() {
        as.getNotification().cancel(this.mType);
        Intent intent = new Intent();
        if (this.mType == 1) {
            intent.setClass(this.mContext, FailSendNormalMsgNotificationService.class);
            this.mContext.stopService(intent);
        } else if (this.mType == 2) {
            intent.setClass(this.mContext, FailSendSnsMsgNotificationService.class);
            this.mContext.stopService(intent);
        }
        this.lFv = false;
        this.paG = false;
    }

    public final void bhs() {
        this.pau.c(2, false);
        this.paH = false;
        show();
        x.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, unLockInNotificationBar");
    }

    public final void bht() {
        this.paI = true;
        this.pau = new d(this.mContext);
        bhp();
        bhq();
    }
}
