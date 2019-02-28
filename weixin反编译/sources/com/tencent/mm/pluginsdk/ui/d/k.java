package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.ayb;
import com.tencent.mm.protocal.c.ayc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.q;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class k {
    static String vBw;

    /* renamed from: com.tencent.mm.pluginsdk.ui.d.k$3 */
    static class AnonymousClass3 implements OnCreateContextMenuListener {
        final /* synthetic */ List vBz;

        public AnonymousClass3(List list) {
            this.vBz = list;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            for (String add : this.vBz) {
                contextMenu.add(0, 0, 0, add);
            }
        }
    }

    private static class a extends BaseAdapter {
        private Context mContext = null;
        private List<String> nua = null;
        private Bundle rG = null;
        private OnDismissListener vBD = null;
        a vBE = null;

        private class b {
            TextView jtn;
            Button mBJ;
            TextView vBG;

            private b() {
            }

            /* synthetic */ b(a aVar, byte b) {
                this();
            }
        }

        public interface a {
            void gj(boolean z);
        }

        private class c {
            TextView jtn;

            private c() {
            }

            /* synthetic */ c(a aVar, byte b) {
                this();
            }
        }

        public a(List<String> list, Context context, OnDismissListener onDismissListener, Bundle bundle) {
            Assert.assertTrue(context != null);
            this.nua = list;
            this.mContext = context;
            this.vBD = onDismissListener;
            this.rG = bundle;
        }

        public final int getCount() {
            return this.nua == null ? 0 : this.nua.size();
        }

        public final Object getItem(int i) {
            return this.nua.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (this.mContext.getString(R.l.dSE).equals((String) this.nua.get(i))) {
                return 1;
            }
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object obj;
            String str = (String) getItem(i);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                Object bVar;
                View view2;
                LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
                View inflate;
                if (itemViewType == 1) {
                    inflate = layoutInflater.inflate(R.i.ddP, viewGroup, false);
                    bVar = new b();
                    ((b) bVar).jtn = (TextView) inflate.findViewById(R.h.title);
                    ((b) bVar).mBJ = (Button) inflate.findViewById(R.h.ccy);
                    ((b) bVar).vBG = (TextView) inflate.findViewById(R.h.cSa);
                    view2 = inflate;
                } else {
                    inflate = layoutInflater.inflate(R.i.ddQ, viewGroup, false);
                    bVar = new c();
                    ((c) bVar).jtn = (TextView) inflate.findViewById(R.h.title);
                    view2 = inflate;
                }
                view2.setTag(bVar);
                view = view2;
                obj = bVar;
            } else {
                obj = view.getTag();
            }
            switch (itemViewType) {
                case 0:
                    c cVar = (c) obj;
                    cVar.jtn.setText(i.b(this.mContext, bi.oM(str), cVar.jtn.getTextSize()));
                    break;
                case 1:
                    b bVar2 = (b) obj;
                    bVar2.jtn.setText(i.b(this.mContext, bi.oM(str), bVar2.jtn.getTextSize()));
                    bVar2.vBG.setText(this.mContext.getString(R.l.dSK));
                    bVar2.mBJ.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (C2Java.isNetworkConnected()) {
                                p.d(a.this.mContext, a.this.rG);
                                if (a.this.vBE != null) {
                                    a.this.vBE.gj(true);
                                    return;
                                }
                                return;
                            }
                            x.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
                            u.makeText(a.this.mContext, a.this.mContext.getString(R.l.eiR), 0).show();
                            if (a.this.vBE != null) {
                                a.this.vBE.gj(false);
                            }
                        }
                    });
                    break;
                default:
                    x.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
                    break;
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.d.k$4 */
    static class AnonymousClass4 implements d {
        final /* synthetic */ Context val$context;

        public AnonymousClass4(Context context) {
            this.val$context = context;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(menuItem.getTitle().toString().replace(" ", "").replace("(", "").replace(")", "").replace("-", "")).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bi.k(this.val$context, intent)) {
                this.val$context.startActivity(intent);
            }
        }
    }

    static /* synthetic */ void a(Activity activity, String str, Bundle bundle) {
        String oM = bi.oM(bundle.getString("Contact_User"));
        if (oM == null) {
            x.e("MicroMsg.MailPhoneMenuHelper", "username is null");
            return;
        }
        com.tencent.mm.storage.x Xv = ((h) g.h(h.class)).Ff().Xv(oM);
        if (Xv == null) {
            x.e("MicroMsg.MailPhoneMenuHelper", "contact is null");
            return;
        }
        int i;
        ArrayList arrayList;
        String[] split;
        String string = bundle.getString("Contact_Mobile_MD5");
        String str2 = Xv.fXz;
        if (!bi.oN(string)) {
            if (string == str) {
                i = 0;
            } else if (!Xv.AT()) {
                i = 1;
            }
            arrayList = new ArrayList();
            if (!bi.oN(str2)) {
                split = str2.split(",");
                for (Object add : split) {
                    arrayList.add(add);
                }
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
            }
            arrayList.add(str);
            if (arrayList.size() + i > 5) {
                a(activity, Xv, oM, arrayList);
                com.tencent.mm.plugin.report.service.g.pWK.h(12040, Xv.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size()));
            }
            Toast.makeText(activity, activity.getString(R.l.evR), 0).show();
            return;
        }
        i = 0;
        arrayList = new ArrayList();
        if (bi.oN(str2)) {
            split = str2.split(",");
            while (r3 < split.length) {
                arrayList.add(add);
            }
            if (arrayList.contains(str)) {
                arrayList.remove(str);
            }
        }
        arrayList.add(str);
        if (arrayList.size() + i > 5) {
            Toast.makeText(activity, activity.getString(R.l.evR), 0).show();
            return;
        }
        a(activity, Xv, oM, arrayList);
        com.tencent.mm.plugin.report.service.g.pWK.h(12040, Xv.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size()));
    }

    static /* synthetic */ void bd(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(WebView.SCHEME_MAILTO));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (bi.k(context, intent)) {
            context.startActivity(intent);
        } else {
            com.tencent.mm.ui.base.h.a(context, R.l.dSy, R.l.dGZ, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    static /* synthetic */ void be(Context context, String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/person");
        intent.putExtra("phone", str);
        if (bi.k(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static void b(final Context context, final String str, final OnDismissListener onDismissListener) {
        if (((q.Gj() & 1) == 0 ? 1 : 0) != 0) {
            com.tencent.mm.ui.base.h.a(context, str, context.getResources().getStringArray(R.c.bqP), "", new c() {
                public final void jo(int i) {
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                    String replace = str.replace(" ", "").replace("#", "@");
                    switch (i) {
                        case 0:
                            Context context = context;
                            Intent intent = new Intent();
                            intent.putExtra("composeType", 4);
                            String substring = replace.substring(0, replace.indexOf(64));
                            intent.putExtra("toList", new String[]{substring + " " + replace});
                            com.tencent.mm.bl.d.b(context, "qqmail", ".ui.ComposeUI", intent);
                            return;
                        case 1:
                            k.bd(context, replace);
                            return;
                        default:
                            return;
                    }
                }
            });
        } else {
            com.tencent.mm.ui.base.h.a(context, str, new String[]{context.getResources().getString(R.l.dQX)}, "", new c() {
                public final void jo(int i) {
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                    String replace = str.replace(" ", "").replace("#", "@");
                    switch (i) {
                        case 0:
                            k.bd(context, replace);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    public static void a(Context context, String str, final OnDismissListener onDismissListener, Bundle bundle) {
        boolean booleanValue;
        boolean z;
        List F;
        if (!(context instanceof Activity)) {
            x.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", bi.chl());
        }
        if (g.Do().CF()) {
            booleanValue = ((Boolean) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false))).booleanValue();
        } else {
            booleanValue = false;
        }
        final int i = bundle != null ? bundle.getInt("fromScene") : 0;
        if (cdd() || cde()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String str2;
            String[] strArr;
            if (bundle == null) {
                str2 = "";
            } else {
                str2 = bundle.getString("Contact_User");
            }
            String oM = bi.oM(str2);
            if (oM == null || oM == "" || oM.endsWith("@chatroom") || q.gt(oM)) {
                strArr = booleanValue ? new String[]{context.getResources().getString(R.l.dSI), context.getResources().getString(R.l.dSJ), context.getResources().getString(R.l.dSD), context.getResources().getString(R.l.dSB)} : new String[]{context.getResources().getString(R.l.dSI), context.getResources().getString(R.l.dSD), context.getResources().getString(R.l.dSB)};
            } else {
                com.tencent.mm.storage.x Xv = ((h) g.h(h.class)).Ff().Xv(oM);
                if (Xv != null) {
                    str2 = Xv.AX();
                    vBw = context.getResources().getString(R.l.dSC, new Object[]{str2});
                    strArr = booleanValue ? new String[]{context.getResources().getString(R.l.dSI), context.getResources().getString(R.l.dSJ), vBw, context.getResources().getString(R.l.dSD), context.getResources().getString(R.l.dSB)} : new String[]{context.getResources().getString(R.l.dSI), vBw, context.getResources().getString(R.l.dSD), context.getResources().getString(R.l.dSB)};
                } else {
                    return;
                }
            }
            F = bi.F(strArr);
        } else {
            F = bi.F(new String[]{context.getResources().getString(R.l.dSI), context.getResources().getString(R.l.dSD)});
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(11621, Integer.valueOf(i), Integer.valueOf(2));
        if (p.us()) {
            F.add(context.getResources().getString(R.l.dSE));
            com.tencent.mm.plugin.report.service.g.pWK.h(11621, Integer.valueOf(i), Integer.valueOf(3));
            if (C2Java.isNetworkConnected()) {
                x.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", Integer.valueOf(bi.a((Integer) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3)));
                g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_WXPHONE_PB_COUNT_INT, Integer.valueOf(r0 - 1));
            }
        }
        final Dialog mVar = new m(context);
        mVar.setTitle(str);
        BaseAdapter aVar = new a(F, context, onDismissListener, bundle);
        aVar.vBE = new a() {
            public final void gj(boolean z) {
                if (z) {
                    mVar.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                }
            }
        };
        mVar.kUZ = aVar;
        com.tencent.mm.ui.base.h.a(context, mVar);
        mVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }
            }
        });
        final String str3 = str;
        final Context context2 = context;
        final OnDismissListener onDismissListener2 = onDismissListener;
        final Bundle bundle2 = bundle;
        mVar.vDf = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final CharSequence replace = str3.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
                String str = (String) F.get(i);
                x.i("MicroMsg.MailPhoneMenuHelper", str);
                Intent intent;
                if (context2.getString(R.l.dSI).equals(str)) {
                    intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(replace).toString()));
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (bi.k(context2, intent)) {
                        context2.startActivity(intent);
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.k(10112, "1");
                    mVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                } else if (context2.getString(R.l.dSJ).equals(str)) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", replace);
                    com.tencent.mm.bl.d.b(context2, "ipcall", ".ui.IPCallDialUI", intent);
                    mVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                } else if (context2.getString(R.l.dSB).equals(str)) {
                    String[] stringArray;
                    if (k.cdd() && k.cde()) {
                        stringArray = context2.getResources().getStringArray(R.c.bqW);
                    } else {
                        stringArray = k.cdd() ? new String[]{context2.getResources().getString(R.l.dSA)} : new String[]{context2.getResources().getString(R.l.dSH)};
                    }
                    context2.getResources().getString(R.l.dSG);
                    com.tencent.mm.ui.base.h.a(context2, str3, stringArray, "", new c() {
                        public final void jo(int i) {
                            if (onDismissListener2 != null) {
                                onDismissListener2.onDismiss(null);
                            }
                            switch (i) {
                                case 0:
                                    if (k.cdd()) {
                                        Context context = context2;
                                        String str = replace;
                                        Intent intent = new Intent("android.intent.action.INSERT");
                                        intent.setType("vnd.android.cursor.dir/contact");
                                        intent.putExtra("phone", str);
                                        context.startActivity(intent);
                                        com.tencent.mm.plugin.report.service.g.pWK.k(10113, "1");
                                        return;
                                    }
                                    k.be(context2, replace);
                                    com.tencent.mm.plugin.report.service.g.pWK.k(10114, "1");
                                    return;
                                case 1:
                                    k.be(context2, replace);
                                    com.tencent.mm.plugin.report.service.g.pWK.k(10114, "1");
                                    return;
                                default:
                                    return;
                            }
                        }
                    }, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            if (onDismissListener2 != null) {
                                onDismissListener2.onDismiss(null);
                            }
                        }
                    });
                    mVar.dismiss();
                } else if (context2.getString(R.l.dSD).equals(str)) {
                    com.tencent.mm.pluginsdk.h.c.a(context2, replace, replace);
                    com.tencent.mm.plugin.report.service.g.pWK.k(10115, "1");
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    mVar.dismiss();
                    Toast.makeText(context2, context2.getString(R.l.dEE), 1).show();
                } else if (context2.getString(R.l.dSE).equals(str)) {
                    x.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                } else if (k.vBw.equals(str)) {
                    k.a((Activity) context2, str3, bundle2);
                    mVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                } else {
                    x.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                    mVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                }
            }
        };
        mVar.show();
    }

    static boolean cdd() {
        Context context = ad.getContext();
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("phone", "10086");
        return bi.k(context, intent);
    }

    static boolean cde() {
        return bi.k(ad.getContext(), new Intent("android.intent.action.PICK", Contacts.CONTENT_URI));
    }

    private static void a(Activity activity, com.tencent.mm.storage.x xVar, String str, ArrayList<String> arrayList) {
        String str2;
        com.tencent.mm.bp.a asp = new asp();
        asp.wGI = str;
        ayc ayc = new ayc();
        ayc.kyA = arrayList.size();
        ayc.wLQ = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str2 = (String) it.next();
            ayb ayb = new ayb();
            ayb.wLP = str2;
            ayc.wLQ.add(ayb);
        }
        asp.wGE = ayc;
        ((h) g.h(h.class)).Fe().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(60, asp));
        ag Xv = ((h) g.h(h.class)).Ff().Xv(str);
        if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
            String str3;
            str2 = "";
            Iterator it2 = arrayList.iterator();
            while (true) {
                str3 = str2;
                if (!it2.hasNext()) {
                    break;
                }
                str2 = (str3 + ((String) it2.next())) + ",";
            }
            xVar.dC(str3);
            ((h) g.h(h.class)).Ff().R(xVar);
        }
        Toast.makeText(activity, activity.getString(R.l.eQB), 0).show();
    }
}
