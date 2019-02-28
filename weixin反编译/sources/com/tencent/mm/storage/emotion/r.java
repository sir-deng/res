package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;

public final class r extends i<q> implements a {
    public static final String[] gLy = new String[]{i.a(q.gKN, "SmileyInfo")};
    private static final String[] xJj = new String[]{"key", "cnValue", "qqValue", "enValue", "twValue", "thValue", "eggIndex", DownloadInfo.FILENAME};
    private static final String[] xJk = new String[]{"key"};
    public e gLA;

    public r(e eVar) {
        this(eVar, q.gKN, "SmileyInfo");
    }

    private r(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gLA = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final ArrayList<String> aBD() {
        Throwable e;
        ArrayList<String> arrayList = new ArrayList();
        Cursor a;
        try {
            a = this.gLA.a("SmileyInfo", xJk, "flag=?", new String[]{"0"}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            arrayList.add(a.getString(0));
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.NewSmileyInfoStorage", bi.i(e));
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return arrayList;
    }

    public final ArrayList<q> aBC() {
        Throwable e;
        ArrayList<q> arrayList = new ArrayList();
        Cursor a;
        try {
            a = this.gLA.a("SmileyInfo", xJj, "flag=?", new String[]{"0"}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            q qVar = new q();
                            qVar.b(a);
                            qVar.field_position = -1;
                            arrayList.add(qVar);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.NewSmileyInfoStorage", bi.i(e));
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return arrayList;
    }
}
