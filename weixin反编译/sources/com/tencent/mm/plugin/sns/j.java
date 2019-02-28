package com.tencent.mm.plugin.sns;

import android.database.Cursor;
import com.tencent.mm.f.a.mq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends c<mq> {
    public j() {
        this.xmG = mq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mq mqVar = (mq) bVar;
        if (mqVar instanceof mq) {
            List linkedList = new LinkedList();
            mqVar.fFr.fFs = null;
            mqVar.fFr.fFt = null;
            mqVar.fFr.fFu = null;
            x.i("MicroMsg.RecentlySnsMediaObjListener", "recently username " + mqVar.fFq.username);
            if (!bi.oN(mqVar.fFq.username)) {
                g.Dr();
                boolean z = mqVar.fFq.username.equals((String) g.Dq().Db().get(2, null));
                n bwf = ae.bwf();
                String str = ("select *,rowid from SnsInfo " + n.aG(mqVar.fFq.username, z)) + " AND type in ( 1 , 15)" + n.rvc + " limit 3";
                x.d("MicroMsg.SnsInfoStorage", "getUserNewerInfo " + str);
                Cursor rawQuery = bwf.gLA.rawQuery(str, null);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        int i = 0;
                        do {
                            m mVar = new m();
                            mVar.b(rawQuery);
                            if (mVar.field_type != 21) {
                                Iterator it = mVar.byF().wYj.wfh.iterator();
                                while (it.hasNext()) {
                                    are are = (are) it.next();
                                    if (are.kzz == 2 || are.kzz == 6) {
                                        i++;
                                        linkedList.add(are);
                                        if (i >= 3) {
                                            break;
                                        }
                                    }
                                    i = i;
                                }
                            }
                        } while (rawQuery.moveToNext());
                        rawQuery.close();
                        if (linkedList.size() > 0) {
                            mqVar.fFr.fFs = (are) linkedList.get(0);
                        }
                        if (linkedList.size() > 1) {
                            mqVar.fFr.fFt = (are) linkedList.get(1);
                        }
                        if (linkedList.size() > 2) {
                            mqVar.fFr.fFu = (are) linkedList.get(2);
                        }
                    } else {
                        rawQuery.close();
                    }
                }
            }
            return true;
        }
        x.f("MicroMsg.RecentlySnsMediaObjListener", "mismatched event");
        return false;
    }
}
