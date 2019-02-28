package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ao.b;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.List;

public final class h implements e {
    private Context context;
    private ProgressDialog laU;
    a zmC;

    public interface a {
        void nt(boolean z);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.zmC = aVar;
    }

    final void n(Cursor cursor) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                o oVar = new o();
                oVar.b(cursor);
                arrayList.add(oVar.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(oVar);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.context;
        String string = this.context.getResources().getString(R.l.enI);
        this.context.getResources().getString(R.l.dEy);
        com.tencent.mm.ui.base.h.a(context, string, arrayList, arrayList2, new d() {
            public final void cr(int i, int i2) {
                if (i2 != -1) {
                    h.this.aaw(((o) arrayList3.get(i2)).field_googlegmail);
                }
            }
        });
    }

    final void aaw(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        final k bVar = new b(arrayList);
        as.CN().a(bVar, 0);
        Context context = this.context;
        this.context.getString(R.l.eql);
        this.laU = com.tencent.mm.ui.base.h.a(context, this.context.getString(R.l.eqj), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(bVar);
                h.this.zmC.nt(false);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.SendInviteGoogleContact";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        if (kVar.getType() == 489) {
            if (this.laU != null) {
                this.laU.dismiss();
                this.laU = null;
            }
            as.CN().b(489, (e) this);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
                com.tencent.mm.ui.base.h.a(this.context, R.l.eqi, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        h.this.zmC.nt(true);
                    }
                });
                return;
            }
            x.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
            this.zmC.nt(false);
        }
    }
}
