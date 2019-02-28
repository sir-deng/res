package com.tencent.mm.ay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.bx.h;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.l.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import junit.framework.Assert;

public final class n extends j {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS packageinfo ( id int  PRIMARY KEY, version int  , name text  , size int  , packname text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE TABLE IF NOT EXISTS packageinfo2 ( localId text  PRIMARY KEY , id int  , version int  , name text  , size int  , packname text  , status int  , type int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    public h hiZ;

    public n(h hVar) {
        this.hiZ = hVar;
    }

    public final boolean a(m mVar) {
        if (mVar == null) {
            return false;
        }
        mVar.fEo = -1;
        if (((int) this.hiZ.insert("packageinfo2", "localId", mVar.vP())) == -1) {
            return false;
        }
        doNotify();
        return true;
    }

    public final boolean b(m mVar) {
        Assert.assertTrue(mVar != null);
        ContentValues vP = mVar.vP();
        if (vP.size() > 0) {
            if (this.hiZ.update("packageinfo2", vP, "id= ? and type =?", new String[]{mVar.id, mVar.fwH}) > 0) {
                doNotify();
                return true;
            }
        }
        doNotify();
        return false;
    }

    public final boolean il(int i) {
        boolean fD = this.hiZ.fD("packageinfo2", "update packageinfo2 set status = 2 where status = 1 and type = " + i + ";");
        doNotify();
        return fD;
    }

    public final m be(int i, int i2) {
        m mVar = null;
        Cursor a = this.hiZ.a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.id = \"" + bi.oL(String.valueOf(i)) + "\" and packageinfo2.type" + " = \"" + bi.oL(String.valueOf(i2)) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                mVar = new m();
                mVar.b(a);
            }
            a.close();
        }
        return mVar;
    }

    public final boolean im(int i) {
        if (this.hiZ.delete("packageinfo2", "type =?", new String[]{String.valueOf(i)}) <= 0) {
            return false;
        }
        doNotify();
        return true;
    }

    public final m[] in(int i) {
        Cursor a = this.hiZ.a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=" + i, null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            m mVar = new m();
            mVar.b(a);
            arrayList.add(mVar);
        }
        a.close();
        return (m[]) arrayList.toArray(new m[arrayList.size()]);
    }

    public static String QL() {
        return a.Fz();
    }

    public static String bf(int i, int i2) {
        return i + "_" + i2 + "_thumb.jpg";
    }

    public final String bg(int i, int i2) {
        switch (i2) {
            case 0:
                return "";
            case 1:
                return i + "_session_bg.zip";
            case 2:
                return i + "_emoji_art.temp";
            case 5:
                return "brand_i18n.apk";
            case 7:
                return i + "_configlist.cfg";
            case 8:
                return i + "_regiondata.temp";
            case 9:
                return "_speex_upload.cfg";
            case 12:
                return "_rcpt_addr";
            case 18:
                return be(i, i2).version + "_feature.zip";
            case 19:
                return "_report_reason.temp";
            case 20:
                return "_pluginDesc.cfg";
            case 21:
                return "_trace_config.cfg";
            case 23:
                return "permissioncfg.cfg";
            case 26:
                return "ipcallCountryCodeConfig.cfg";
            case 36:
                return i + "_sensewhere.xml";
            default:
                return "";
        }
    }

    public final String bh(int i, int i2) {
        switch (i2) {
            case 0:
                return "";
            case 1:
                String str = a.Fz() + i + "_session_bg/";
                try {
                    File file = new File(str);
                    if (file.exists()) {
                        return str;
                    }
                    file.mkdirs();
                    return str;
                } catch (Throwable e) {
                    x.e("MicroMsg.PackageInfoStorage", "exception:%s", bi.i(e));
                    x.e("MicroMsg.PackageInfoStorage", "can not create dir, dir = " + str);
                    return str;
                }
            case 2:
                return "";
            case 18:
                return a.Fz() + bg(i, i2).replace(".zip", "");
            default:
                return "";
        }
    }

    public final void bi(int i, int i2) {
        b.deleteFile(a.Fz() + bg(i, i2));
        m be = be(i, i2);
        if (be != null) {
            be.status = 5;
            r.QO().b(be);
        }
    }

    public static int bn(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels > displayMetrics.widthPixels ? 1 : 0;
        if (displayMetrics.density <= 1.0f) {
            if (i != 0) {
                return 4;
            }
            return 2;
        } else if (i != 0) {
            return 3;
        } else {
            return 1;
        }
    }

    public static String D(String str, boolean z) {
        if (z) {
            return a.Fz() + str + "_chatting_bg_vertical.jpg";
        }
        return a.Fz() + str + "_chatting_bg_horizontal.jpg";
    }

    public final String Q(String str, int i) {
        switch (i) {
            case 1:
            case 2:
                return D(str, false);
            case 3:
            case 4:
                return D(str, true);
            default:
                return null;
        }
    }
}
