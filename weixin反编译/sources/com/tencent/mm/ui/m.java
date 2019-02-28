package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class m {
    boolean pEf = true;
    Runnable xQo;

    public final boolean c(Activity activity, Runnable runnable) {
        x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkStorage[%b]", Boolean.valueOf(a.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")));
        if (a.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 32, "", "")) {
            x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper checkPermission checkPhone[%b]", Boolean.valueOf(a.a(activity, "android.permission.READ_PHONE_STATE", 96, "", "")));
            if (a.a(activity, "android.permission.READ_PHONE_STATE", 96, "", "")) {
                x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "start time check launcherUIOnCreate from begin time ==" + (System.currentTimeMillis() - LauncherUI.xPt));
                f.ee(LauncherUI.xPt);
                return true;
            }
            this.xQo = runnable;
            return false;
        }
        this.xQo = runnable;
        return false;
    }

    public final boolean a(final Activity activity, final int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.LauncherUI.LauncherUICheckPermissionHelper";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.chl();
            x.w(str, str2, objArr);
            ah.h(new Runnable() {
                public final void run() {
                    if (m.this.xQo != null) {
                        m.this.xQo.run();
                    }
                }

                public final String toString() {
                    return super.toString() + "|onInitDelay";
                }
            }, 500);
            return true;
        }
        x.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        int i2;
        switch (i) {
            case 32:
            case 64:
            case 96:
                i2 = R.l.eAf;
                if (i == 96) {
                    i2 = R.l.eAe;
                } else if (i == 64) {
                    i2 = R.l.eAc;
                }
                if (iArr[0] == 0) {
                    if (i == 32) {
                        d.pVE.a(462, 0, 1, true);
                    } else if (i == 96) {
                        d.pVE.a(462, 1, 1, true);
                        q.bh(true);
                    } else {
                        d.pVE.a(462, 2, 1, true);
                    }
                    if (this.xQo != null) {
                        this.xQo.run();
                    }
                } else {
                    h.a((Context) activity, activity.getString(i2), activity.getString(R.l.eAg), activity.getString(R.l.esG), activity.getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == 32) {
                                d.pVE.a(462, 3, 1, true);
                            } else if (i == 96) {
                                d.pVE.a(462, 4, 1, true);
                            } else {
                                d.pVE.a(462, 5, 1, true);
                            }
                            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            activity.startActivity(intent);
                            dialogInterface.dismiss();
                            MMAppMgr.b(activity, true);
                            activity.finish();
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == 32) {
                                d.pVE.a(462, 6, 1, true);
                            } else if (i == 96) {
                                d.pVE.a(462, 7, 1, true);
                            } else {
                                d.pVE.a(462, 8, 1, true);
                            }
                            dialogInterface.dismiss();
                            MMAppMgr.b(activity, true);
                            activity.finish();
                        }
                    });
                }
                return true;
            case 33:
            case 70:
            case 97:
                i2 = R.l.eAf;
                if (i == 97) {
                    i2 = R.l.eAe;
                } else if (i == 70) {
                    i2 = R.l.eAc;
                }
                if (iArr[0] != 0) {
                    this.pEf = false;
                    h.a((Context) activity, activity.getString(i2), activity.getString(R.l.eAg), activity.getString(R.l.esG), activity.getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == 33) {
                                d.pVE.a(462, 12, 1, true);
                            } else if (i == 97) {
                                d.pVE.a(462, 13, 1, true);
                            } else {
                                d.pVE.a(462, 14, 1, true);
                            }
                            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            activity.startActivity(intent);
                            dialogInterface.dismiss();
                            m.this.pEf = true;
                            MMAppMgr.b(activity, true);
                            activity.finish();
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == 33) {
                                d.pVE.a(462, 15, 1, true);
                            } else if (i == 97) {
                                d.pVE.a(462, 16, 1, true);
                            } else {
                                d.pVE.a(462, 17, 1, true);
                            }
                            dialogInterface.dismiss();
                            m.this.pEf = true;
                            MMAppMgr.b(activity, true);
                            activity.finish();
                        }
                    });
                } else if (i == 33) {
                    d.pVE.a(462, 9, 1, true);
                } else if (i == 97) {
                    d.pVE.a(462, 10, 1, true);
                } else {
                    d.pVE.a(462, 11, 1, true);
                }
                return true;
            default:
                return false;
        }
    }
}
