package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pluginsdk.model.k.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import java.util.ArrayList;

public final class ad {
    public p fhH;
    private long yLq = -1;
    public SparseBooleanArray yLr = new SparseBooleanArray();

    /* renamed from: com.tencent.mm.ui.chatting.b.ad$3 */
    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ ArrayList yLu;

        AnonymousClass3(ArrayList arrayList) {
            this.yLu = arrayList;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ad.this.aj(this.yLu);
        }
    }

    public ad(p pVar) {
        this.fhH = pVar;
    }

    public final void dq(final String str, final int i) {
        as.Dt().F(new Runnable() {
            public final void run() {
                t.Z(str, i);
            }
        });
    }

    final void aj(ArrayList<String> arrayList) {
        x.v("MicroMsg.ChattingUI.VideoImp", "send video path: %s", arrayList.toString());
        final Runnable kVar = new k(this.fhH.cte().getContext(), arrayList, null, this.fhH.csW().field_username, 2, new a() {
            public final void bZe() {
                ad.this.fhH.dismissDialog();
            }
        });
        Context context = this.fhH.cte().getContext();
        this.fhH.cte().getMMString(R.l.dGZ);
        this.fhH.b(h.a(context, this.fhH.cte().getMMString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                kVar.bZc();
            }
        }));
        e.post(kVar, "ChattingUI_importMultiVideo");
    }

    public final void al(final Intent intent) {
        x.d("MicroMsg.ChattingUI.VideoImp", "sendVedio");
        if (ab.bC(this.fhH.cte().getContext())) {
            Q(intent);
        } else {
            h.a(this.fhH.cte().getContext(), R.l.eTp, R.l.dGZ, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ad.this.Q(intent);
                }
            }, null);
        }
    }

    final void Q(Intent intent) {
        final c cVar = new c();
        cVar.a(this.fhH.cte().getContext(), intent, new c.a() {
            public final void b(int i, String str, String str2, int i2) {
                if (i == -50002) {
                    Toast.makeText(ad.this.fhH.cte().getContext(), ad.this.fhH.cte().getContext().getString(R.l.eTo), 0).show();
                } else if (i < 0) {
                    Toast.makeText(ad.this.fhH.cte().getContext(), ad.this.fhH.cte().getContext().getString(R.l.eTn), 0).show();
                } else {
                    t.b(str, i2, ad.this.fhH.csW().field_username, str2);
                    t.nE(str);
                }
                ad.this.fhH.dismissDialog();
            }
        });
        Context context = this.fhH.cte().getContext();
        this.fhH.cte().getMMString(R.l.dGZ);
        this.fhH.b(h.a(context, this.fhH.cte().getMMString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                cVar.hVc = null;
            }
        }));
    }

    public final void am(Intent intent) {
        x.d("MicroMsg.ChattingUI.VideoImp", "sendVedioFromCustomRecord");
        if (intent == null) {
            x.e("MicroMsg.ChattingUI.VideoImp", "data == null");
            return;
        }
        String stringExtra = intent.getStringExtra("VideoRecorder_ToUser");
        String stringExtra2 = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        x.e("MicroMsg.ChattingUI.VideoImp", "fileName " + stringExtra2 + " length " + intExtra + " user " + stringExtra);
        if (!bi.oN(stringExtra) && !bi.oN(stringExtra2) && intExtra >= 0) {
            if (stringExtra.equals("medianote") && (q.Gc() & 16384) == 0) {
                r rVar = new r();
                rVar.fileName = stringExtra2;
                rVar.hXv = intExtra;
                rVar.fEx = stringExtra;
                rVar.hXn = (String) g.Dq().Db().get(2, (Object) "");
                rVar.hXs = bi.Wx();
                rVar.hXt = bi.Wx();
                rVar.hXp = intExtra;
                rVar.hWd = intExtra;
                o.Ub();
                int nz = s.nz(s.nx(stringExtra2));
                if (nz <= 0) {
                    x.e("MicroMsg.VideoLogic", "get Video size failed :" + stringExtra2);
                    return;
                }
                rVar.hmZ = nz;
                o.Ub();
                stringExtra = s.ny(stringExtra2);
                intExtra = s.nz(stringExtra);
                if (intExtra <= 0) {
                    x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + stringExtra + " size:" + intExtra);
                    return;
                }
                rVar.hXr = intExtra;
                x.d("MicroMsg.VideoLogic", "init record file:" + stringExtra2 + " thumbsize:" + rVar.hXr + " videosize:" + rVar.hmZ);
                rVar.status = 199;
                au auVar = new au();
                auVar.dU(rVar.Uk());
                auVar.setType(43);
                auVar.eS(1);
                auVar.dV(stringExtra2);
                auVar.eR(2);
                auVar.aq(bb.hU(rVar.Uk()));
                rVar.hXw = (int) bb.i(auVar);
                o.Ub().a(rVar);
                return;
            }
            t.b(stringExtra2, intExtra, stringExtra, null);
            t.nE(stringExtra2);
            this.fhH.mT(true);
        }
    }
}
