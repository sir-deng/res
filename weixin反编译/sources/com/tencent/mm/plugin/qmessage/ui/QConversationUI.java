package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.plugin.qmessage.a.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bb.a;
import com.tencent.mm.y.s;
import com.tencent.mm.y.t;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import junit.framework.Assert;

public class QConversationUI extends MMActivity implements e {
    private TextView emptyTipTv;
    private boolean isDeleteCancel = false;
    private d kHD = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            QConversationUI.a(QConversationUI.this, QConversationUI.this.ptC);
        }
    };
    private x lLc;
    private boolean otn = false;
    private String ptA;
    private boolean ptB = false;
    private String ptC;
    private ListView ptv;
    private c ptw;
    private c ptx;
    private boolean pty = false;
    private String ptz;

    static /* synthetic */ void a(QConversationUI qConversationUI, int i) {
        if (i <= 0) {
            qConversationUI.emptyTipTv.setVisibility(0);
            qConversationUI.ptv.setVisibility(8);
            return;
        }
        qConversationUI.emptyTipTv.setVisibility(8);
        qConversationUI.ptv.setVisibility(0);
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, final String str) {
        as.Hm();
        cg Fc = com.tencent.mm.y.c.Fh().Fc(str);
        as.Hm();
        com.tencent.mm.y.c.Fe().b(new com.tencent.mm.ax.d(str, Fc.field_msgSvrId));
        qConversationUI.isDeleteCancel = false;
        qConversationUI.getString(R.l.dGZ);
        final ProgressDialog a = h.a((Context) qConversationUI, qConversationUI.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                QConversationUI.this.isDeleteCancel = true;
            }
        });
        bb.a(str, new a() {
            public final boolean HH() {
                return QConversationUI.this.isDeleteCancel;
            }

            public final void HG() {
                as.Hm();
                com.tencent.mm.y.c.Fk().XE(str);
                if (a != null) {
                    a.dismiss();
                }
            }
        });
    }

    static /* synthetic */ void a(QConversationUI qConversationUI, String str, String str2) {
        if (str == null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "jacks open QQ appId == null");
            return;
        }
        f aZ = g.aZ(str, true);
        if (aZ == null || !p.m(qConversationUI.mController.xRr, aZ.field_packageName)) {
            if (bi.oN(str2)) {
                str2 = p.w(qConversationUI.mController.xRr, str, "message");
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            com.tencent.mm.bl.d.b(qConversationUI.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
        } else if (aZ.field_status == 3) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QConversationUI", "requestAppShow fail, app is in blacklist, packageName = " + aZ.field_packageName);
        } else if (p.b(qConversationUI.mController.xRr, aZ)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "jacks open QQ");
            Intent intent2 = new Intent("android.intent.action.MAIN", null);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent2.setClassName(aZ.field_packageName, av(qConversationUI.mController.xRr, aZ.field_packageName));
            intent2.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
            as.Hm();
            Object obj = com.tencent.mm.y.c.Db().get(9, null);
            int intValue = (obj == null || !(obj instanceof Integer)) ? 0 : ((Integer) obj).intValue();
            if (intValue != 0) {
                try {
                    byte[] bytes = String.valueOf(intValue).getBytes(ProtocolPackage.ServerEncoding);
                    byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                    int length = bytes2.length;
                    intValue = 0;
                    int i = 0;
                    while (intValue < length) {
                        byte b = bytes2[intValue];
                        if (i >= bytes.length) {
                            break;
                        }
                        int i2 = i + 1;
                        bytes[i] = (byte) (b ^ bytes[i]);
                        intValue++;
                        i = i2;
                    }
                    intent2.putExtra("tencent_gif", bytes);
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
                }
            }
            try {
                qConversationUI.startActivity(intent2);
            } catch (Exception e2) {
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QConversationUI", "The app %s signature is incorrect.", aZ.field_appName);
            Toast.makeText(qConversationUI.mController.xRr, qConversationUI.getString(R.l.emB, new Object[]{g.a(qConversationUI.mController.xRr, aZ, null)}), 1).show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dtj;
    }

    public void onDestroy() {
        this.ptw.aUU();
        if (this.ptx != null) {
            as.CN().c(this.ptx);
            as.CN().b(this.ptx.getType(), (e) this);
            this.ptx = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        bkI();
        as.Hm();
        com.tencent.mm.y.c.Fk().a(this.ptw);
        this.ptw.a(null, null);
    }

    private static void bkI() {
        as.Hm();
        cg sM = com.tencent.mm.y.c.Fh().sM(2);
        if (sM != null && sM.field_msgId > 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + sM.field_createTime);
            as.Hm();
            com.tencent.mm.y.c.Db().set(12295, Long.valueOf(sM.field_createTime));
        }
        as.Hm();
        ae XF = com.tencent.mm.y.c.Fk().XF("qmessage");
        if (XF == null || bi.oM(XF.field_username).length() <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
            return;
        }
        XF.eP(0);
        as.Hm();
        if (com.tencent.mm.y.c.Fk().a(XF, XF.field_username) == -1) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
        }
    }

    public void onPause() {
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.QConversationUI", "on pause");
        as.Hm();
        com.tencent.mm.y.c.Fk().b(this.ptw);
        bkI();
        this.ptw.onPause();
        super.onPause();
    }

    protected final void initView() {
        this.otn = getIntent().getBooleanExtra("finish_direct", false);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "isFromSearch  " + this.otn);
        as.Hm();
        this.lLc = com.tencent.mm.y.c.Ff().Xv("qmessage");
        String str = "can not find qmessage";
        boolean z = this.lLc != null && ((int) this.lLc.gKO) > 0;
        Assert.assertTrue(str, z);
        this.ptv = (ListView) findViewById(R.h.cSC);
        this.emptyTipTv = (TextView) findViewById(R.h.ceo);
        this.emptyTipTv.setText(R.l.ebN);
        this.ptw = new c(this, new o.a() {
            public final void XE() {
                QConversationUI qConversationUI = QConversationUI.this;
                String AW = QConversationUI.this.lLc.AW();
                int hy = t.hy(s.hgW);
                if (hy <= 0) {
                    qConversationUI.setMMTitle(AW);
                } else {
                    qConversationUI.setMMTitle(AW + "(" + hy + ")");
                }
                QConversationUI.a(QConversationUI.this, QConversationUI.this.ptw.getCount());
            }

            public final void XF() {
            }
        });
        this.ptw.a(new MMSlideDelView.c() {
            public final int ci(View view) {
                return QConversationUI.this.ptv.getPositionForView(view);
            }
        });
        this.ptw.a(new MMSlideDelView.f() {
            public final void t(View view, int i) {
                QConversationUI.this.ptv.performItemClick(view, i, 0);
            }
        });
        this.ptw.a(new MMSlideDelView.e() {
            public final void bp(Object obj) {
                if (obj == null) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.QConversationUI", "onItemDel object null");
                } else {
                    QConversationUI.a(QConversationUI.this, obj.toString());
                }
            }
        });
        this.ptv.setAdapter(this.ptw);
        this.ptv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ae aeVar = (ae) QConversationUI.this.ptw.getItem(i);
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", aeVar.field_username);
                intent.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.qmessage.a.ihN.e(intent, QConversationUI.this.mController.xRr);
            }
        });
        final i iVar = new i(this);
        this.ptv.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < QConversationUI.this.ptv.getHeaderViewsCount()) {
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.QConversationUI", "on header view long click, ignore");
                    return true;
                }
                iVar.a(view, i, j, QConversationUI.this, QConversationUI.this.kHD, 0, 0);
                return true;
            }
        });
        com.tencent.mm.plugin.qmessage.a.pta.ep(HardCoderJNI.FUNC_REG_ANR_CALLBACK);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                QConversationUI.this.goBack();
                return true;
            }
        });
        AnonymousClass12 anonymousClass12 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(QConversationUI.this.ptv);
            }
        };
        as.Hm();
        this.ptz = (String) com.tencent.mm.y.c.Db().get(77, (Object) "");
        as.Hm();
        this.ptA = (String) com.tencent.mm.y.c.Db().get(78, (Object) "");
        if (this.ptx == null) {
            this.ptx = new c();
            as.CN().a(this.ptx.getType(), (e) this);
        }
        as.CN().a(this.ptx, 0);
        bkJ();
        com.tencent.mm.plugin.qmessage.a.pta.ep(HardCoderJNI.FUNC_REG_ANR_CALLBACK);
    }

    private static String av(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
        }
        return null;
    }

    private void bkJ() {
        this.mController.removeAllOptionMenu();
        if (!bi.oN(this.ptz)) {
            this.pty = true;
            addIconOptionMenu(0, R.l.dCt, R.k.cEt, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (!bi.oN(QConversationUI.this.ptz)) {
                        QConversationUI.a(QConversationUI.this, QConversationUI.this.ptz, QConversationUI.this.ptA);
                    }
                    return true;
                }
            });
        }
        addIconOptionMenu(2, R.l.dCu, R.k.dvn, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", QConversationUI.this.lLc.field_username);
                intent.putExtra("Chat_Readonly", true);
                com.tencent.mm.plugin.qmessage.a.ihN.d(intent, QConversationUI.this.mController.xRr);
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        if (this.otn) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.qmessage.a.ihN.s(intent, this);
        overridePendingTransition(R.a.bpQ, R.a.bql);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        ae aeVar = (ae) this.ptw.getItem(((AdapterContextMenuInfo) contextMenuInfo).position);
        as.Hm();
        contextMenu.setHeaderTitle(com.tencent.mm.y.c.Ff().Xv(aeVar.field_username).AX());
        contextMenu.add(0, 0, 0, R.l.euC);
        this.ptC = aeVar.field_username;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = null;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (kVar.getType()) {
            case 630:
                if (i == 0 && i2 == 0) {
                    adh adh;
                    Object obj;
                    String str3;
                    c cVar = (c) kVar;
                    if (cVar.hTp != null) {
                        adh = (adh) cVar.hTp.hnR.hnY;
                        if (adh != null) {
                            obj = adh.wsz;
                            if (cVar.hTp != null) {
                                adh = (adh) cVar.hTp.hnR.hnY;
                                if (adh != null) {
                                    str3 = adh.vTU;
                                    if (cVar.hTp != null) {
                                        adh = (adh) cVar.hTp.hnR.hnY;
                                        if (adh != null) {
                                            str2 = adh.wsA;
                                        }
                                    }
                                    if (!bi.oN(str2)) {
                                        this.ptz = str2;
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().set(77, str2);
                                    }
                                    this.ptA = str3;
                                    as.Hm();
                                    com.tencent.mm.y.c.Db().set(78, str3);
                                    if (!this.pty) {
                                        bkJ();
                                    }
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj, str3, str2);
                                    return;
                                }
                            }
                            str3 = null;
                            if (cVar.hTp != null) {
                                adh = (adh) cVar.hTp.hnR.hnY;
                                if (adh != null) {
                                    str2 = adh.wsA;
                                }
                            }
                            if (bi.oN(str2)) {
                                this.ptz = str2;
                                as.Hm();
                                com.tencent.mm.y.c.Db().set(77, str2);
                            }
                            this.ptA = str3;
                            as.Hm();
                            com.tencent.mm.y.c.Db().set(78, str3);
                            if (this.pty) {
                                bkJ();
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj, str3, str2);
                            return;
                        }
                    }
                    String obj2 = null;
                    if (cVar.hTp != null) {
                        adh = (adh) cVar.hTp.hnR.hnY;
                        if (adh != null) {
                            str3 = adh.vTU;
                            if (cVar.hTp != null) {
                                adh = (adh) cVar.hTp.hnR.hnY;
                                if (adh != null) {
                                    str2 = adh.wsA;
                                }
                            }
                            if (bi.oN(str2)) {
                                this.ptz = str2;
                                as.Hm();
                                com.tencent.mm.y.c.Db().set(77, str2);
                            }
                            this.ptA = str3;
                            as.Hm();
                            com.tencent.mm.y.c.Db().set(78, str3);
                            if (this.pty) {
                                bkJ();
                            }
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj2, str3, str2);
                            return;
                        }
                    }
                    str3 = null;
                    if (cVar.hTp != null) {
                        adh = (adh) cVar.hTp.hnR.hnY;
                        if (adh != null) {
                            str2 = adh.wsA;
                        }
                    }
                    if (bi.oN(str2)) {
                        this.ptz = str2;
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(77, str2);
                    }
                    this.ptA = str3;
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(78, str3);
                    if (this.pty) {
                        bkJ();
                    }
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", obj2, str3, str2);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
