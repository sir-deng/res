package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.afc;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class p extends i<o> implements a {
    public static final String[] gLy = new String[]{i.a(o.gKN, "GetEmotionListCache")};
    private e gLA;

    public p(e eVar) {
        this(eVar, o.gKN, "GetEmotionListCache");
    }

    private p(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gLA = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    private boolean YJ(String str) {
        if (this.gLA.delete("GetEmotionListCache", "reqType=?", new String[]{str}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean a(int i, aci aci) {
        boolean z = false;
        if (aci == null) {
            return z;
        }
        try {
            this.gLA.delete("GetEmotionListCache", "reqType=?", new String[]{String.valueOf(i)});
            c oVar = new o(String.valueOf(i), aci.toByteArray());
            x.d("MicroMsg.emoji.Storage", "insert cache: %d", Integer.valueOf(i));
            return b(oVar);
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.Storage", "exception:%s", bi.i(e));
            return z;
        }
    }

    public final aci DT(int i) {
        aci aci = null;
        Cursor a = this.gLA.a("GetEmotionListCache", null, "reqType=?", new String[]{String.valueOf(i)}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            o oVar = new o(a);
            try {
                aci aci2 = new aci();
                aci2.aH(oVar.field_cache);
                x.d("MicroMsg.emoji.Storage", "succed get cache: %d", Integer.valueOf(i));
                aci = aci2;
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", bi.i(e));
            }
        }
        if (a != null) {
            a.close();
        }
        return aci;
    }

    public final boolean a(String str, afc afc) {
        boolean z = false;
        if (afc == null) {
            return z;
        }
        try {
            YJ(str);
            return b(new o(str, afc.toByteArray()));
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.Storage", "exception:%s", bi.i(e));
            return z;
        }
    }

    public final afc YK(String str) {
        afc afc = null;
        Cursor a = this.gLA.a("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null, 2);
        if (a != null && a.moveToFirst()) {
            o oVar = new o(a);
            try {
                afc afc2 = new afc();
                afc2.aH(oVar.field_cache);
                x.d("MicroMsg.emoji.Storage", "succed get designerID cache: %s", str);
                afc = afc2;
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.Storage", "exception:%s", bi.i(e));
            }
        }
        if (a != null) {
            a.close();
        }
        return afc;
    }

    public final bkc aBG() {
        Throwable e;
        Cursor query;
        try {
            bkc bkc;
            query = this.gLA.query("GetEmotionListCache", null, "reqType=?", new String[]{"Smiley_panel_req_type"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        o oVar = new o(query);
                        bkc = new bkc();
                        bkc.aH(oVar.field_cache);
                        if (query != null) {
                            return bkc;
                        }
                        query.close();
                        return bkc;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.Storage", "exception:%s", bi.i(e));
                        if (query == null) {
                            return null;
                        }
                        query.close();
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            bkc = null;
            if (query != null) {
                return bkc;
            }
            query.close();
            return bkc;
        } catch (Exception e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    public final boolean b(bkc bkc) {
        boolean z = false;
        if (bkc == null) {
            return z;
        }
        try {
            YJ("Smiley_panel_req_type");
            return b(new o("Smiley_panel_req_type", bkc.toByteArray()));
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.Storage", "exception:%s", bi.i(e));
            return z;
        }
    }

    public final aca YL(String str) {
        Throwable e;
        if (bi.oN(str)) {
            x.w("MicroMsg.emoji.Storage", "getEmotionActivityByID failed. activityID is null.");
            return null;
        }
        aca aca;
        Cursor query;
        try {
            query = this.gLA.query("GetEmotionListCache", null, "reqType=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        o oVar = new o(query);
                        aca = new aca();
                        aca.aH(oVar.field_cache);
                        if (query != null) {
                            query.close();
                        }
                        return aca;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.Storage", "exception:%s", bi.i(e));
                        if (query != null) {
                            query.close();
                            aca = null;
                        } else {
                            aca = null;
                        }
                        return aca;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            aca = null;
            if (query != null) {
                query.close();
            }
        } catch (IOException e3) {
            e = e3;
            query = null;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return aca;
    }

    public final boolean a(String str, aca aca) {
        boolean z = false;
        if (aca == null) {
            return z;
        }
        try {
            YJ(str);
            return b(new o(str, aca.toByteArray()));
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.Storage", "exception:%s", bi.i(e));
            return z;
        }
    }
}
