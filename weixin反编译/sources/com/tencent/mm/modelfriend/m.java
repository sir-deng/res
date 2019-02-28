package com.tencent.mm.modelfriend;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.be.e;
import com.tencent.mm.be.f;
import com.tencent.mm.be.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class m {
    private static Map<String, String> hxQ = null;

    public enum a {
        NO_INIT,
        SET_MOBILE,
        SUCC,
        SUCC_UNLOAD
    }

    public static void NQ() {
        as.Hm();
        c.Db().set(12322, Boolean.valueOf(true));
    }

    public static boolean NR() {
        if (as.Hm() != null) {
            as.Hm();
            if (c.Db() != null) {
                as.Hm();
                return bi.a((Boolean) c.Db().get(12322, Boolean.valueOf(true)), true);
            }
        }
        x.e("MicroMsg.FriendLogic", "[arthurdan.UploadPhone] Notice!!!! MMCore.getAccStg() is null!!!");
        return false;
    }

    public static boolean NS() {
        x.i("MicroMsg.FriendLogic", "isTipInMobileFriend, state %s", NT().toString());
        if (NT() != a.SUCC) {
            return false;
        }
        as.Hm();
        x.i("MicroMsg.FriendLogic", "USERINFO_UPLOAD_ADDR_LOOK_UP %B", Boolean.valueOf(bi.a((Boolean) c.Db().get(12322, Boolean.valueOf(false)), false)));
        if (bi.a((Boolean) c.Db().get(12322, Boolean.valueOf(false)), false)) {
            return false;
        }
        return true;
    }

    public static a NT() {
        try {
            as.Hm();
            String str = (String) c.Db().get(4097, (Object) "");
            as.Hm();
            String str2 = (String) c.Db().get(6, (Object) "");
            boolean GB = q.GB();
            x.i("MicroMsg.FriendLogic", "isUpload " + GB + " stat " + q.Gc());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && str2 == null) {
                return a.NO_INIT;
            }
            if (str != null && str2 == null) {
                return a.SET_MOBILE;
            }
            if (GB) {
                return a.SUCC;
            }
            return a.SUCC_UNLOAD;
        } catch (Exception e) {
            return a.NO_INIT;
        }
    }

    public static void NU() {
        as.Hm();
        c.Db().set(4097, "");
        as.Hm();
        c.Db().set(6, "");
    }

    public static String NV() {
        as.Hm();
        return (String) c.Db().get(6, (Object) "");
    }

    public static boolean NW() {
        if (as.Hp()) {
            int i;
            if (NT() == a.SUCC) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 == 0) {
                x.i("MicroMsg.FriendLogic", "canSyncAddrBook userBindOpMobile: %b", Boolean.valueOf(false));
                return false;
            }
            if (NR()) {
                return true;
            }
            x.i("MicroMsg.FriendLogic", "canSyncAddrBook isUploadContact: %b", Boolean.valueOf(NR()));
            return false;
        }
        x.i("MicroMsg.FriendLogic", "canSyncAddrBook isAccHasReady: %b", Boolean.valueOf(as.Hp()));
        return false;
    }

    public static Bitmap a(String str, Context context) {
        return com.tencent.mm.pluginsdk.a.a(str, context, false);
    }

    public static boolean a(String str, Context context, byte[] bArr) {
        return com.tencent.mm.pluginsdk.a.b(str, context, bArr);
    }

    public static void NX() {
        com.tencent.mm.sdk.e.m OJ = af.OJ();
        int delete = OJ.hiZ.delete("addr_upload2", null, null);
        x.d("MicroMsg.AddrUploadStorage", "delete addr_upload2");
        if (delete > 0) {
            OJ.b(5, OJ, null);
        }
    }

    public static void NY() {
        HashSet hashSet = new HashSet();
        Iterator it = l.TD().Tw().iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            as.Hm();
            com.tencent.mm.storage.au.a Fq = c.Fh().Fq(fVar.field_msgContent);
            if (Fq != null && (Fq.scene == 10 || Fq.scene == 11)) {
                hashSet.add(fVar.field_talker);
            }
        }
        x.d("MicroMsg.FriendLogic", "deleteMobileFMessage, delete fmsg and fconv, talker size = " + hashSet.size());
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            e.e(0, (String) it2.next());
        }
    }

    public static void K(List<String> list) {
        if (list.size() != 0) {
            HashSet hashSet = new HashSet();
            Iterator it = l.TD().Tw().iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                as.Hm();
                com.tencent.mm.storage.au.a Fq = c.Fh().Fq(fVar.field_msgContent);
                if (Fq != null) {
                    String str = Fq.xHJ;
                    String str2 = Fq.xHI;
                    if ((Fq.scene == 10 || Fq.scene == 11) && (list.contains(str) || list.contains(str2))) {
                        hashSet.add(fVar.field_talker);
                    }
                }
            }
            x.d("MicroMsg.FriendLogic", "deleteMobileFMessage(md5List), delete fmsg and fconv, talker size = " + hashSet.size());
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                e.e(0, (String) it2.next());
            }
        }
    }

    public static String lb(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        c OJ = af.OJ();
        Cursor a = OJ.hiZ.a("select addr_upload2.realname from addr_upload2 where addr_upload2.id = \"" + b.kS(str) + "\"", null, 2);
        if (a == null) {
            return "";
        }
        String str2 = "";
        if (a.moveToFirst()) {
            str2 = a.getString(0);
        }
        a.close();
        return str2;
    }

    public static void L(List<b> list) {
        if (list == null) {
            x.e("MicroMsg.FriendLogic", "sync address book failed, null info list");
        } else {
            af.OJ().H(list);
        }
    }

    public static void M(List<String> list) {
        if (list == null) {
            x.e("MicroMsg.FriendLogic", "set uploaded mobile contact failed, null info list");
        } else {
            af.OJ().J(list);
        }
    }

    public static List<String> NZ() {
        Cursor a = af.OJ().hiZ.a("select addr_upload2.md5 from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 1", null, 2);
        List<String> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(0));
        }
        a.close();
        return arrayList;
    }

    public static List<String> Oa() {
        Cursor a = af.OJ().hiZ.a("select addr_upload2.moblie from addr_upload2 where addr_upload2.uploadtime = 0 AND addr_upload2.type = 0", null, 2);
        List<String> arrayList = new ArrayList();
        while (a.moveToNext()) {
            String II = com.tencent.mm.pluginsdk.a.II(a.getString(0));
            if (com.tencent.mm.pluginsdk.a.RG(II)) {
                arrayList.add(II);
            }
        }
        a.close();
        return arrayList;
    }

    public static boolean hG(int i) {
        ab hJ = af.OM().hJ(i);
        boolean hK = af.OO().hK(i);
        if (hJ == null) {
            return false;
        }
        if (hJ.hyz == 1 || hK) {
            return true;
        }
        return false;
    }
}
