package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.f;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.arv;
import com.tencent.mm.protocal.c.bnz;
import com.tencent.mm.protocal.c.boa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView extends BaseSortView {
    String kLP;
    boolean kLW;
    private ListView kLX;
    int kLY = -1;
    b kLZ;
    private a kMa;
    private int kMb = 0;
    private int kMc = 0;

    public static class c {
        public View contentView;
        String iconUrl;
        ImageView ikK;
        TextView kHt;
        public TextView kKK;
        ImageView kMk;
        View kMl;
        String username;
    }

    private static class a implements e {
        public String kMe;
        i kMf;
        WeakReference<EnterpriseBizContactListView> kMg;
        r tipDialog;

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a$3 */
        class AnonymousClass3 implements OnClickListener {
            final /* synthetic */ String gKi;
            final /* synthetic */ Context val$context;

            AnonymousClass3(String str, Context context) {
                this.gKi = str;
                this.val$context = context;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                final k cVar = new com.tencent.mm.plugin.profile.a.c(this.gKi, true);
                as.CN().a(1394, a.this);
                as.CN().a(cVar, 0);
                a aVar = a.this;
                Context context = this.val$context;
                this.val$context.getString(R.l.dGZ);
                aVar.tipDialog = h.a(context, this.val$context.getString(R.l.dHn), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(cVar);
                        as.CN().b(1394, a.this);
                    }
                });
            }
        }

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a$1 */
        class AnonymousClass1 implements OnCreateContextMenuListener {
            final /* synthetic */ int kI;

            AnonymousClass1(int i) {
                this.kI = i;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add(this.kI, 1, 0, R.l.ech);
            }
        }

        public a(EnterpriseBizContactListView enterpriseBizContactListView) {
            this.kMg = new WeakReference(enterpriseBizContactListView);
        }

        protected final void finalize() {
            as.CN().b(1394, (e) this);
            super.finalize();
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0 && kVar.getType() == 1394) {
                bnz bjW = ((com.tencent.mm.plugin.profile.a.c) kVar).bjW();
                boa bjV = ((com.tencent.mm.plugin.profile.a.c) kVar).bjV();
                if (bjV == null || bjV.vUn == null || bjV.vUn.ret != 0) {
                    if (bjV == null || bjV.vUn == null) {
                        x.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(kVar.getType()));
                        return;
                    }
                    x.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(kVar.getType()), Integer.valueOf(bjV.vUn.ret));
                } else if (bjW.wXJ) {
                    com.tencent.mm.sdk.e.c jV = f.jV(bjW.vUh);
                    jV.field_brandFlag |= 1;
                    com.tencent.mm.bp.a arv = new arv();
                    arv.hxs = jV.field_brandFlag;
                    arv.kyG = bjW.vUh;
                    as.Hm();
                    com.tencent.mm.y.c.Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, arv));
                    y.Ml().c(jV, new String[0]);
                    as.Hm();
                    com.tencent.mm.y.c.Fk().XE(jV.field_username);
                    as.Hm();
                    if (com.tencent.mm.y.c.Fk().XP(jV.field_enterpriseFather) <= 0) {
                        as.Hm();
                        com.tencent.mm.y.c.Fk().XE(jV.field_enterpriseFather);
                    } else {
                        as.Hm();
                        com.tencent.mm.y.c.Fj().WZ(jV.field_enterpriseFather);
                    }
                    EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) this.kMg.get();
                    if (enterpriseBizContactListView != null) {
                        enterpriseBizContactListView.refresh();
                    }
                }
            }
        }
    }

    public interface b {
        boolean atb();
    }

    private class d implements Comparator<com.tencent.mm.ui.base.sortview.d> {
        private d() {
        }

        /* synthetic */ d(EnterpriseBizContactListView enterpriseBizContactListView, byte b) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            com.tencent.mm.ui.base.sortview.d dVar = (com.tencent.mm.ui.base.sortview.d) obj;
            com.tencent.mm.ui.base.sortview.d dVar2 = (com.tencent.mm.ui.base.sortview.d) obj2;
            String str = dVar.ysR;
            String str2 = dVar2.ysR;
            int compareToIgnoreCase = (str == null || str2 == null) ? 0 : str.compareToIgnoreCase(str2);
            if (compareToIgnoreCase != 0) {
                if (str.equalsIgnoreCase("#")) {
                    compareToIgnoreCase = 1;
                }
                return str2.equalsIgnoreCase("#") ? -1 : compareToIgnoreCase;
            } else {
                com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) dVar.data;
                com.tencent.mm.plugin.brandservice.a.b bVar2 = (com.tencent.mm.plugin.brandservice.a.b) dVar2.data;
                if (!(str == null || str2 == null || (!str.equalsIgnoreCase("!2") && !str.equalsIgnoreCase("!1")))) {
                    int Ak = bVar.jQP.Ak();
                    int Ak2 = bVar2.jQP.Ak();
                    Object obj3 = ((Ak < 97 || Ak > 122) && (Ak < 65 || Ak > 90)) ? 1 : null;
                    Object obj4 = ((Ak2 < 97 || Ak2 > 122) && (Ak2 < 65 || Ak2 > 90)) ? 1 : null;
                    if (obj3 != null && obj4 == null) {
                        return 1;
                    }
                    if (obj3 == null && obj4 != null) {
                        return -1;
                    }
                }
                int compareToIgnoreCase2 = (bVar.jQP == null || bVar.jQP.vY() == null || bVar.jQP.vY().length() <= 0 || bVar2.jQP == null || bVar2.jQP.vY() == null || bVar2.jQP.vY().length() <= 0) ? 0 : bVar.jQP.vY().compareToIgnoreCase(bVar2.jQP.vY());
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase2 = (bVar.jQP == null || bVar.jQP.field_nickname == null || bVar.jQP.field_nickname.length() <= 0 || bVar2.jQP == null || bVar2.jQP.field_nickname == null || bVar2.jQP.field_nickname.length() <= 0) ? 0 : bVar.jQP.field_nickname.compareToIgnoreCase(bVar2.jQP.field_nickname);
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase = (bVar.jQP == null || bVar.jQP.field_username == null || bVar.jQP.field_username.length() <= 0 || bVar2.jQP == null || bVar2.jQP.field_username == null || bVar2.jQP.field_username.length() <= 0) ? 0 : bVar.jQP.field_username.compareToIgnoreCase(bVar2.jQP.field_username);
                return compareToIgnoreCase == 0 ? 0 : compareToIgnoreCase;
            }
        }
    }

    static /* synthetic */ void a(TextView textView, Context context, String str, int i) {
        if (textView != null && !bi.oN(str)) {
            try {
                textView.setText(new SpannableString(com.tencent.mm.pluginsdk.ui.d.i.c(context, str, i)));
            } catch (Exception e) {
                textView.setText("");
            }
        }
    }

    static /* synthetic */ void a(EnterpriseBizContactListView enterpriseBizContactListView, com.tencent.mm.af.d dVar, int i) {
        com.tencent.mm.af.b jA = y.Ms().jA(enterpriseBizContactListView.kLP);
        long j = jA != null ? jA.field_wwCorpId : 0;
        long j2 = jA != null ? jA.field_wwUserVid : 0;
        long Lp = dVar.Lp();
        g.pWK.h(14507, Long.valueOf(j), Long.valueOf(Lp), Long.valueOf(j2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i));
        x.d("MicroMsg.BrandService.EnterpriseBizContactListView", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", Long.valueOf(j), Long.valueOf(Lp), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i));
    }

    public EnterpriseBizContactListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void refresh() {
        List arrayList = new ArrayList();
        y.Ml();
        Cursor z = com.tencent.mm.af.e.z(this.kLP, this.kLW);
        while (z.moveToNext()) {
            com.tencent.mm.plugin.brandservice.a.b bVar = new com.tencent.mm.plugin.brandservice.a.b();
            if (z != null) {
                ag xVar = new com.tencent.mm.storage.x();
                xVar.b(z);
                com.tencent.mm.af.d dVar = new com.tencent.mm.af.d();
                dVar.b(z);
                bVar.userName = xVar.field_username;
                bVar.jQP = xVar;
                bVar.kKo = dVar;
            }
            if (bVar.jQP != null) {
                com.tencent.mm.ui.base.sortview.d dVar2 = new com.tencent.mm.ui.base.sortview.d();
                dVar2.data = bVar;
                if (bVar.kKo.Lm()) {
                    dVar2.ysR = "!1";
                } else if (bVar.jQP.AS()) {
                    dVar2.ysR = "!2";
                } else {
                    int Ak = bVar.jQP.Ak();
                    if (Ak >= 97 && Ak <= 122) {
                        Ak -= 32;
                    }
                    if (Ak < 65 || Ak > 90) {
                        dVar2.ysR = "#";
                    } else {
                        dVar2.ysR = ((char) Ak);
                    }
                }
                arrayList.add(dVar2);
            }
        }
        z.close();
        this.kLY = arrayList.size();
        Collections.sort(arrayList, new d());
        dd(arrayList);
        super.refresh();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.kMb = (int) motionEvent.getRawX();
            this.kMc = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void atc() {
        this.XC = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object tag = view.getTag();
                if (tag != null && (tag instanceof c)) {
                    c cVar = (c) tag;
                    if (!bi.oN(cVar.username)) {
                        boolean kb = f.kb(cVar.username);
                        boolean eG = f.eG(cVar.username);
                        com.tencent.mm.af.d jV = f.jV(cVar.username);
                        String Lo = jV == null ? null : jV.Lo();
                        if (Lo == null) {
                            Lo = "";
                        }
                        Intent intent;
                        if (kb) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("rawUrl", Lo);
                            intent2.putExtra("useJs", true);
                            intent2.putExtra("srcUsername", cVar.username);
                            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                            intent2.addFlags(67108864);
                            com.tencent.mm.bl.d.b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, jV, 2);
                        } else if (eG) {
                            intent = new Intent();
                            intent.putExtra("Contact_User", cVar.username);
                            intent.addFlags(67108864);
                            intent.putExtra("biz_chat_from_scene", 3);
                            com.tencent.mm.bl.d.a(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", intent);
                        } else {
                            intent = new Intent();
                            intent.addFlags(67108864);
                            intent.putExtra("finish_direct", true);
                            intent.putExtra("Chat_User", cVar.username);
                            intent.putExtra("chat_from_scene", 2);
                            Context context = EnterpriseBizContactListView.this.getContext();
                            x.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                            com.tencent.mm.plugin.brandservice.a.ihN.e(intent, context);
                            EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, jV, 1);
                        }
                    }
                }
            }
        };
        if (this.mMode == 0) {
            this.ysH = new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (EnterpriseBizContactListView.this.kMa == null) {
                        EnterpriseBizContactListView.this.kMa = new a(EnterpriseBizContactListView.this);
                    }
                    a a = EnterpriseBizContactListView.this.kMa;
                    int b = EnterpriseBizContactListView.this.kMb;
                    int c = EnterpriseBizContactListView.this.kMc;
                    if (a.kMf == null) {
                        EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) a.kMg.get();
                        if (enterpriseBizContactListView == null) {
                            return false;
                        }
                        a.kMf = new i(enterpriseBizContactListView.getContext());
                    }
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        return false;
                    }
                    a.kMe = ((c) tag).username;
                    if (bi.oN(a.kMe) || f.eG(a.kMe)) {
                        return false;
                    }
                    a.kMf.zDp = view;
                    a.kMf.a(adapterView, i, j, new AnonymousClass1(i), new com.tencent.mm.ui.base.p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            if (!bi.oN(a.this.kMe) && menuItem.getItemId() == 1) {
                                a aVar = a.this;
                                String str = a.this.kMe;
                                EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) aVar.kMg.get();
                                if (enterpriseBizContactListView != null) {
                                    Context context = enterpriseBizContactListView.getContext();
                                    h.a(context, context.getString(R.l.ebZ), "", context.getString(R.l.ebY), context.getString(R.l.dEy), new AnonymousClass3(str, context), null);
                                }
                            }
                        }
                    }, b, c);
                    return true;
                }
            };
        }
    }

    public static void release() {
        y.Mt().Mf();
    }

    public final boolean a(String str, com.tencent.mm.ui.base.sortview.d dVar) {
        if (!(bi.oN(str) || dVar == null)) {
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) dVar.data;
            if (bVar == null) {
                return false;
            }
            String AX = bVar.jQP.AX();
            String vX = bVar.jQP.vX();
            String vY = bVar.jQP.vY();
            String toUpperCase = str.toUpperCase();
            if (!(bi.oN(AX) || AX.toUpperCase().indexOf(toUpperCase) == -1) || (!(bi.oN(vX) || vX.toUpperCase().indexOf(toUpperCase) == -1) || (!bi.oN(vY) && vY.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), R.i.dgw, this);
    }

    public final VerticalScrollBar atd() {
        return (VerticalScrollBar) findViewById(R.h.cOu);
    }

    public final ListView getListView() {
        this.kLX = (ListView) findViewById(R.h.ctk);
        return this.kLX;
    }

    public final View ate() {
        TextView textView = (TextView) findViewById(R.h.cAB);
        textView.setText(R.l.eci);
        return textView;
    }

    public final com.tencent.mm.ui.base.sortview.c.a atf() {
        return new com.tencent.mm.ui.base.sortview.c.a() {
            public final View a(com.tencent.mm.ui.base.sortview.d dVar, View view, int i, boolean z, boolean z2) {
                c cVar;
                long Wz = bi.Wz();
                Context context = EnterpriseBizContactListView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.i.dgt, null);
                    cVar = new c();
                    cVar.kKK = (TextView) view.findViewById(R.h.bSx);
                    cVar.contentView = view.findViewById(R.h.bYN);
                    cVar.ikK = (ImageView) view.findViewById(R.h.bKr);
                    cVar.kMk = (ImageView) view.findViewById(R.h.cAd);
                    cVar.kHt = (TextView) view.findViewById(R.h.bOX);
                    cVar.kMl = view.findViewById(R.h.cLs);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) dVar.data;
                if (bVar == null) {
                    x.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
                } else {
                    Object obj = null;
                    if (bVar.kKo.Lm()) {
                        obj = 1;
                    }
                    if (EnterpriseBizContactListView.this.ysJ && z) {
                        if (dVar.ysR.equals("!2")) {
                            cVar.kKK.setText(EnterpriseBizContactListView.this.getContext().getString(R.l.ecn));
                            cVar.kKK.setVisibility(0);
                        } else if (!dVar.ysR.equals("!1")) {
                            cVar.kKK.setText(dVar.ysR);
                            cVar.kKK.setVisibility(0);
                        }
                        if (obj == null) {
                            cVar.username = bVar.userName;
                            cVar.ikK.setImageResource(R.k.dyI);
                            EnterpriseBizContactListView.a(cVar.kHt, context, EnterpriseBizContactListView.this.getResources().getString(R.l.ebV), (int) cVar.kHt.getTextSize());
                        } else {
                            cVar.username = bVar.userName;
                            cVar.iconUrl = bVar.kKo.field_brandIconURL;
                            cVar.ikK.setTag(bVar.userName);
                            com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ikK, cVar.username);
                            EnterpriseBizContactListView.a(cVar.kHt, context, bVar.jQP.AX(), (int) cVar.kHt.getTextSize());
                        }
                        x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", Integer.valueOf(bVar.kKo.field_status));
                        cVar.kMk.setVisibility(bVar.kKo.field_status != 1 ? 0 : 8);
                        if (EnterpriseBizContactListView.this.mMode == 0 || !z2) {
                            cVar.kMl.setBackgroundResource(R.g.bDq);
                        } else {
                            cVar.kMl.setBackgroundResource(R.g.bBz);
                        }
                        if (EnterpriseBizContactListView.this.ysK) {
                            cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) EnterpriseBizContactListView.this.getContext().getResources().getDimension(R.f.bvK), cVar.contentView.getPaddingBottom());
                        } else {
                            cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) EnterpriseBizContactListView.this.getContext().getResources().getDimension(R.f.buo), cVar.contentView.getPaddingBottom());
                        }
                        x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", Long.valueOf(bi.bB(Wz)));
                    }
                    cVar.kKK.setVisibility(8);
                    if (obj == null) {
                        cVar.username = bVar.userName;
                        cVar.iconUrl = bVar.kKo.field_brandIconURL;
                        cVar.ikK.setTag(bVar.userName);
                        com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ikK, cVar.username);
                        EnterpriseBizContactListView.a(cVar.kHt, context, bVar.jQP.AX(), (int) cVar.kHt.getTextSize());
                    } else {
                        cVar.username = bVar.userName;
                        cVar.ikK.setImageResource(R.k.dyI);
                        EnterpriseBizContactListView.a(cVar.kHt, context, EnterpriseBizContactListView.this.getResources().getString(R.l.ebV), (int) cVar.kHt.getTextSize());
                    }
                    x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", Integer.valueOf(bVar.kKo.field_status));
                    if (bVar.kKo.field_status != 1) {
                    }
                    cVar.kMk.setVisibility(bVar.kKo.field_status != 1 ? 0 : 8);
                    if (EnterpriseBizContactListView.this.mMode == 0) {
                    }
                    cVar.kMl.setBackgroundResource(R.g.bDq);
                    if (EnterpriseBizContactListView.this.ysK) {
                        cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) EnterpriseBizContactListView.this.getContext().getResources().getDimension(R.f.bvK), cVar.contentView.getPaddingBottom());
                    } else {
                        cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) EnterpriseBizContactListView.this.getContext().getResources().getDimension(R.f.buo), cVar.contentView.getPaddingBottom());
                    }
                    x.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", Long.valueOf(bi.bB(Wz)));
                }
                return view;
            }
        };
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.kLZ != null) {
            this.kLZ.atb();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
