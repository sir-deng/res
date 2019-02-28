package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c.f.AnonymousClass1;
import com.tencent.mm.plugin.aa.a.c.f.AnonymousClass2;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.x;

public class g implements com.tencent.mm.vending.c.b<f> {
    protected f ijZ;
    public final d ika;
    public final a ikb;
    public final e ikc;
    public final c ikd;
    public final b ike;
    public final f ikf;

    public class a implements com.tencent.mm.vending.h.e<o, Long> {
        public final /* synthetic */ Object call(Object obj) {
            Long l = (Long) obj;
            com.tencent.mm.vending.app.a aVar = g.this.ijZ;
            long longValue = l.longValue();
            String stringExtra = aVar.zKi.getStringExtra("bill_no");
            String stringExtra2 = aVar.zKi.getStringExtra("chatroom");
            int i = aVar.zKi.getIntExtra("enter_scene", 0) == 1 ? com.tencent.mm.plugin.aa.a.a.iiu : com.tencent.mm.plugin.aa.a.a.iiv;
            x.i("MicroMsg.PaylistAAInteractor", "aaPay, payAmount: %s, billNo: %s, chatroom: %s", Long.valueOf(longValue), stringExtra, stringExtra2);
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.a(stringExtra, Long.valueOf(longValue), Integer.valueOf(i), stringExtra2).b(aVar.ijW.iiS));
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public class c implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<Long, String, String>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            com.tencent.mm.vending.app.a aVar = g.this.ijZ;
            long longValue = ((Long) dVar.get(0)).longValue();
            String str = (String) dVar.get(1);
            String str2 = (String) dVar.get(2);
            com.tencent.mm.vending.g.b cAI = com.tencent.mm.vending.g.g.cAI();
            String stringExtra = aVar.zKi.getStringExtra("bill_no");
            int intExtra = aVar.zKi.getIntExtra("enter_scene", 0);
            String stringExtra2 = aVar.zKi.getStringExtra("chatroom");
            cAI.cAH();
            new com.tencent.mm.plugin.aa.a.a.a(stringExtra, longValue, intExtra, stringExtra2, str, str2).Kb().g(new AnonymousClass1(cAI));
            return zLb;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public class e implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<String, String, String>> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            com.tencent.mm.vending.app.a aVar = g.this.ijZ;
            String str = (String) dVar.get(1);
            h.b(str, aVar.zKi.getStringExtra("chatroom"), aVar.zKi.getStringExtra("bill_no"), (String) dVar.get(0), (String) dVar.get(2));
            return zLb;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public class d implements com.tencent.mm.vending.h.e<v, Void> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.app.a aVar = g.this.ijZ;
            String stringExtra = aVar.zKi.getStringExtra("bill_no");
            int intExtra = aVar.zKi.getIntExtra("enter_scene", 0);
            String stringExtra2 = aVar.zKi.getStringExtra("chatroom");
            String stringExtra3 = aVar.zKi.getStringExtra("key_sign");
            int intExtra2 = aVar.zKi.getIntExtra("key_ver", 0);
            x.i("MicroMsg.PaylistAAInteractor", "getPayListDetail, billNo: %s, scene: %s, chatRoom: %s", stringExtra, Integer.valueOf(intExtra), stringExtra2);
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.a(stringExtra, Integer.valueOf(intExtra), stringExtra2, stringExtra3, Integer.valueOf(intExtra2)).b(aVar.ijV.iiE));
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public class f implements com.tencent.mm.vending.h.e<Boolean, Void> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.app.a aVar = g.this.ijZ;
            String stringExtra = aVar.zKi.getStringExtra("bill_no");
            String stringExtra2 = aVar.zKi.getStringExtra("chatroom");
            int intExtra = aVar.zKi.getIntExtra("enter_scene", 0);
            x.i("MicroMsg.PaylistAAInteractor", "urgeAAPay");
            com.tencent.mm.vending.g.b cAI = com.tencent.mm.vending.g.g.cAI();
            cAI.cAH();
            new com.tencent.mm.plugin.aa.a.a.b(stringExtra, stringExtra2, intExtra).Kb().g(new AnonymousClass2(cAI));
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public class b implements com.tencent.mm.vending.h.e<Boolean, Void> {
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.vending.app.a aVar = g.this.ijZ;
            String stringExtra = aVar.zKi.getStringExtra("bill_no");
            int intExtra = aVar.zKi.getIntExtra("enter_scene", 0);
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.a(stringExtra, Integer.valueOf(intExtra), aVar.zKi.getStringExtra("chatroom")).b(aVar.ijX.iiV));
            return null;
        }

        public final String wE() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object WM() {
        return this.ijZ;
    }

    public g() {
        this(new f());
    }

    private g(f fVar) {
        this.ika = new d();
        this.ikb = new a();
        this.ikc = new e();
        this.ikd = new c();
        this.ike = new b();
        this.ikf = new f();
        this.ijZ = fVar;
    }
}
