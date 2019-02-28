package com.tencent.mm.modelsimple;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.j.g;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b implements Runnable {
    private String fAd;
    private Account hOk;
    private a hOl;
    private Looper hOm;
    private Context mContext;
    private String username;

    public class a {
        private final String TAG = "MicroMsg.BatchOperation";
        private final ContentResolver hOn;
        ArrayList<ContentProviderOperation> hOo;

        public a(ContentResolver contentResolver) {
            this.hOn = contentResolver;
            this.hOo = new ArrayList();
        }

        public final void a(ContentProviderOperation contentProviderOperation) {
            this.hOo.add(contentProviderOperation);
        }

        public final void execute() {
            if (this.hOo.size() == 0) {
                x.d("MicroMsg.BatchOperation", "no batch operation");
            } else if (com.tencent.mm.pluginsdk.g.a.aZ(b.this.mContext, "android.permission.READ_CONTACTS")) {
                try {
                    this.hOn.applyBatch("com.android.contacts", this.hOo);
                } catch (OperationApplicationException e) {
                    x.e("MicroMsg.BatchOperation", "apply batch operation failed", e.toString());
                } catch (RemoteException e2) {
                    x.e("MicroMsg.BatchOperation", "apply batch operation failed", e2.toString());
                } catch (Exception e3) {
                    x.e("MicroMsg.BatchOperation", "apply batch operation failed", e3.toString());
                }
                this.hOo.clear();
            } else {
                x.e("MicroMsg.BatchOperation", "no contact permission");
            }
        }
    }

    public b(Context context, Account account) {
        this(context, account, null, null);
    }

    public b(Context context, Account account, String str) {
        this(context, account, str, null);
    }

    public b(Context context, Account account, String str, String str2) {
        this.mContext = context;
        this.hOk = account;
        this.username = str;
        this.fAd = str2;
        x.i("MicroMsg.ContactsOperations", "username = " + str + ", " + str2);
    }

    public final void run() {
        Looper.prepare();
        this.hOm = Looper.myLooper();
        x.i("MicroMsg.ContactsOperations", "start time:" + System.currentTimeMillis());
        com.tencent.mm.modelfriend.b kU;
        if (bi.oN(this.username) && bi.oN(this.fAd)) {
            RG();
        } else if (bi.oN(this.fAd)) {
            kU = af.OJ().kU(this.username);
            if (!(kU == null || bi.oN(kU.hxd))) {
                mw(kU.hxd);
            }
            quit();
        } else {
            kU = af.OJ().kU(this.username);
            com.tencent.mm.modelfriend.b kU2 = (kU == null || bi.oN(kU.hxd)) ? af.OJ().kU(this.fAd) : kU;
            if (kU2 == null || bi.oN(kU2.hxd)) {
                x.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
            } else {
                try {
                    if (com.tencent.mm.pluginsdk.g.a.aZ(this.mContext, "android.permission.READ_CONTACTS")) {
                        Cursor query = this.mContext.getContentResolver().query(RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.hOk.name).appendQueryParameter("account_type", this.hOk.type).build(), new String[]{"sync1", "_id"}, "deleted=\"0\" AND sync1=\"" + kU2.hxd + "\"", null, null);
                        if (query == null || query.getCount() == 0) {
                            String NC = bi.oN(kU2.Nz()) ? kU2.NC() : kU2.Nz();
                            this.hOl = new a(this.mContext.getContentResolver());
                            d(NC, kU2.NF(), kU2.hxd, this.username);
                            this.hOl.execute();
                        }
                        if (query != null) {
                            query.close();
                        }
                    } else {
                        x.e("MicroMsg.ContactsOperations", "no contact permission");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                }
            }
            quit();
        }
        x.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
        Looper.loop();
    }

    private void quit() {
        if (this.hOm != null) {
            this.hOm.quit();
        }
    }

    private synchronized void RG() {
        Throwable e;
        Object obj;
        String username;
        ag Xv;
        if (as.Hp()) {
            List<com.tencent.mm.modelfriend.b> kW = af.OJ().kW("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + bi.oL("") + "\" )");
            if (kW.size() == 0) {
                x.e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
                quit();
            } else {
                Map hashMap = new HashMap();
                Uri build = RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.hOk.name).appendQueryParameter("account_type", this.hOk.type).build();
                if (com.tencent.mm.pluginsdk.g.a.aZ(this.mContext, "android.permission.READ_CONTACTS")) {
                    Cursor query;
                    try {
                        query = this.mContext.getContentResolver().query(build, new String[]{"sync1", "_id"}, "deleted=\"0\"", null, null);
                        if (query == null) {
                            try {
                                x.e("MicroMsg.ContactsOperations", "query get no user");
                            } catch (Exception e2) {
                                e = e2;
                                x.printErrStackTrace("MicroMsg.ContactsOperations", e, "", "");
                                if (query != null) {
                                    query.close();
                                }
                                if (!mx("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                                }
                                obj = null;
                                this.hOl = new a(this.mContext.getContentResolver());
                                for (com.tencent.mm.modelfriend.b bVar : kW) {
                                    username = bVar.getUsername();
                                    as.Hm();
                                    Xv = c.Ff().Xv(username);
                                    if (Xv == null) {
                                    }
                                    mw(bVar.hxd);
                                }
                                this.hOl.execute();
                                quit();
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (mx("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") || mx("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip")) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            this.hOl = new a(this.mContext.getContentResolver());
                            for (com.tencent.mm.modelfriend.b bVar2 : kW) {
                                username = bVar2.getUsername();
                                as.Hm();
                                Xv = c.Ff().Xv(username);
                                if (Xv == null && com.tencent.mm.k.a.ga(Xv.field_type)) {
                                    String NC = bi.oN(bVar2.Nz()) ? bVar2.NC() : bVar2.Nz();
                                    String NF = bVar2.NF();
                                    String str = bVar2.hxd;
                                    String str2 = Xv.signature;
                                    if (hashMap.get(str) == null || obj != null) {
                                        if (hashMap.get(str) != null) {
                                            mw(str);
                                        }
                                        d(NC, NF, str, username);
                                    }
                                    this.hOl.execute();
                                } else {
                                    mw(bVar2.hxd);
                                }
                            }
                            this.hOl.execute();
                            quit();
                        } else {
                            if (query.moveToFirst()) {
                                do {
                                    hashMap.put(query.getString(0), Long.valueOf(query.getLong(1)));
                                } while (query.moveToNext());
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (mx("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                            }
                            obj = null;
                            this.hOl = new a(this.mContext.getContentResolver());
                            for (com.tencent.mm.modelfriend.b bVar22 : kW) {
                                username = bVar22.getUsername();
                                as.Hm();
                                Xv = c.Ff().Xv(username);
                                if (Xv == null) {
                                }
                                mw(bVar22.hxd);
                            }
                            this.hOl.execute();
                            quit();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        query = null;
                    }
                } else {
                    x.e("MicroMsg.ContactsOperations", "no contact permission");
                }
            }
        } else {
            x.d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
            quit();
        }
    }

    private void d(String str, String str2, String str3, String str4) {
        x.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + str + ", phoneNum:" + str2 + ", " + str3 + ", username:" + str4);
        Builder newInsert = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
        newInsert.withValue("account_name", this.hOk.name);
        newInsert.withValue("account_type", this.hOk.type);
        newInsert.withValue("sync1", str3);
        this.hOl.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
        newInsert.withValue("data1", str);
        this.hOl.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
        newInsert.withValue("data3", this.mContext.getString(R.l.dXC));
        newInsert.withValue("data4", str3);
        this.hOl.a(newInsert.build());
        if ("1".equals(g.Af().getValue("VOIPCallType"))) {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
            newInsert.withValue("data3", this.mContext.getString(R.l.dXE));
            newInsert.withValue("data4", str3);
            this.hOl.a(newInsert.build());
        } else {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
            newInsert.withValue("data3", this.mContext.getString(R.l.dXD));
            newInsert.withValue("data4", str3);
            this.hOl.a(newInsert.build());
        }
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
        newInsert.withValue("data3", this.mContext.getString(R.l.dXF));
        newInsert.withValue("data4", str3);
        this.hOl.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(R.l.app_name));
        newInsert.withValue("data3", "");
        newInsert.withValue("data4", str3);
        this.hOl.a(newInsert.build());
    }

    private void mw(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
        } else if (com.tencent.mm.pluginsdk.g.a.aZ(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", "_id"}, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[]{"vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", str}, null);
            } catch (Throwable e) {
                x.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", e.getMessage(), bi.i(e));
                query = null;
            }
            if (query == null) {
                x.e("MicroMsg.ContactsOperations", "get null cursor");
                return;
            }
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex("contact_id");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        columnIndex = query.getColumnIndex("_id");
                        String string2 = columnIndex >= 0 ? query.getString(columnIndex) : "";
                        if (!(bi.oN(string) || bi.oN(string2))) {
                            this.mContext.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{string2});
                            this.mContext.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{string, "com.tencent.mm.account"});
                        }
                    } while (query.moveToNext());
                }
            } catch (Exception e2) {
                x.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + e2.getMessage());
            }
            query.close();
        } else {
            x.e("MicroMsg.ContactsOperations", "no contact permission");
        }
    }

    private boolean mx(String str) {
        Exception e;
        boolean z = false;
        if (com.tencent.mm.pluginsdk.g.a.aZ(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                boolean z2;
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id"}, "mimetype= ?", new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            x.d("MicroMsg.ContactsOperations", "has minetype:" + str);
                            z2 = true;
                            z = z2;
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        x.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                        z = true;
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                }
                z2 = false;
                z = z2;
            } catch (Exception e3) {
                e = e3;
                query = null;
            }
            if (query != null) {
                query.close();
            }
        } else {
            x.e("MicroMsg.ContactsOperations", "no contact permission");
        }
        return z;
    }
}
