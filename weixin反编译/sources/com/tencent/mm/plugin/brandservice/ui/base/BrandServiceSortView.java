package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.af.f;
import com.tencent.mm.af.m;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.k;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrandServiceSortView extends BaseSortView implements OnCreateContextMenuListener, OnItemLongClickListener, com.tencent.mm.plugin.brandservice.a.d.a, com.tencent.mm.ui.base.sortview.BaseSortView.a {
    private boolean OQ;
    private String jPV;
    public boolean kLK;
    private HashMap<String, SpannableString> kMS = new HashMap();
    private d kMT = new d();
    private int kMU = 251658241;
    private boolean kMV = false;
    private ListView kMW;
    public a kMX;
    private String kMY;
    private View kMZ;
    private int kMb = 0;
    private int kMc = 0;
    private i kMf;
    private TextView kNa;
    private p.d kNb = new p.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            if (bi.oN(BrandServiceSortView.this.jPV)) {
                x.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
            } else if (menuItem.getItemId() == 0) {
                x.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", Integer.valueOf(i));
                as.Hm();
                com.tencent.mm.storage.x Xv = c.Ff().Xv(BrandServiceSortView.this.jPV);
                BrandServiceSortView.a(BrandServiceSortView.this, f.jV(BrandServiceSortView.this.jPV), BrandServiceSortView.this.getContext(), Xv, menuItem.getGroupId());
            }
        }
    };

    public interface a {
        boolean atb();
    }

    public static class b implements com.tencent.mm.af.m.a.a {
        static Bitmap kNe = null;
        public View contentView;
        String iconUrl;
        ImageView ikK;
        TextView kHt;
        public TextView kKK;
        ImageView kMk;
        View kMl;
        String username;

        public b() {
            y.Mt().a(this);
        }

        public final void atm() {
            if (this.ikK != null) {
                Bitmap d = m.d(this.username, this.iconUrl, 0);
                if (d == null) {
                    this.ikK.setImageResource(R.g.bAa);
                } else if (bi.oN(this.username) || this.ikK.getTag() == null) {
                    x.e("MicroMsg.BrandServiceSortView", "error in refreshAvatar, %s", this.username);
                } else if (this.username.equals(this.ikK.getTag())) {
                    this.ikK.setImageBitmap(d);
                }
            }
        }

        public final void kl(String str) {
            if (str != null && str.equals(this.username)) {
                ah.y(new Runnable() {
                    public final void run() {
                        b.this.atm();
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, TextView textView, Context context, String str, int i) {
        if (textView == null) {
            x.w("MicroMsg.BrandServiceSortView", "display area is null");
        } else if (bi.oN(str)) {
            x.w("MicroMsg.BrandServiceSortView", "remark is null");
        } else {
            SpannableString spannableString = (SpannableString) brandServiceSortView.kMS.get(str);
            if (spannableString == null) {
                try {
                    x.d("MicroMsg.BrandServiceSortView", "new one %s", str);
                    CharSequence spannableString2 = new SpannableString(com.tencent.mm.pluginsdk.ui.d.i.c(context, str, i));
                    brandServiceSortView.kMS.put(str, spannableString2);
                    textView.setText(spannableString2);
                    return;
                } catch (Exception e) {
                    x.w("MicroMsg.BrandServiceSortView", "error, set empty str");
                    textView.setText("");
                    return;
                }
            }
            x.v("MicroMsg.BrandServiceSortView", "match one %s", str);
            textView.setText(spannableString);
        }
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, com.tencent.mm.af.d dVar, final Context context, com.tencent.mm.storage.x xVar, final int i) {
        x.i("MicroMsg.BrandServiceSortView", "showRemoveBizAlertDialog");
        if (dVar == null || context == null || !(context instanceof Activity) || xVar == null) {
            x.e("MicroMsg.BrandServiceSortView", "bizInfo(%s) or context(%s) or contact(%s) is null", dVar, context, xVar);
            return;
        }
        final String str = xVar.field_username;
        as.Dt().F(new Runnable() {
            public final void run() {
                com.tencent.mm.af.d jN = y.Ml().jN(str);
                as.Hm();
                ((h) g.h(h.class)).a(jN, (Activity) context, c.Ff().Xv(str), false, new Runnable() {
                    public final void run() {
                        List list = BrandServiceSortView.this.ysG.ysI;
                        if (i >= 0 && list != null && i < list.size()) {
                            list.remove(i);
                            ah.y(BrandServiceSortView.this.ysG.ysP);
                        }
                    }
                });
            }
        });
    }

    public BrandServiceSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        M(false);
        refresh();
        d dVar = this.kMT;
        if (!(this == null || dVar.kKq.contains(this))) {
            x.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
            dVar.kKq.add(this);
        }
        this.kMf = new i(getContext());
        this.ysL = this;
        this.XC = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof b)) {
                    x.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
                    return;
                }
                b bVar = (b) tag;
                if (bi.oN(bVar.username)) {
                    x.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
                    return;
                }
                com.tencent.mm.bb.d.lW(bVar.username);
                com.tencent.mm.ui.contact.x.m(BrandServiceSortView.this.kMY, 12, 4, i - 1);
                if (BrandServiceSortView.this.kLK) {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Contact", bVar.username);
                    intent.putExtra("Select_Conv_User", bVar.username);
                    if (BrandServiceSortView.this.getContext() instanceof Activity) {
                        Activity activity = (Activity) BrandServiceSortView.this.getContext();
                        activity.setResult(-1, intent);
                        activity.finish();
                        return;
                    }
                }
                String str = bVar.username;
                Context context = BrandServiceSortView.this.getContext();
                x.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                Intent putExtra = new Intent().putExtra("Chat_User", str);
                putExtra.putExtra("finish_direct", true);
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                com.tencent.mm.plugin.brandservice.a.ihN.e(putExtra, context);
            }
        };
        this.ysH = this;
    }

    public final void refresh() {
        List list;
        List list2;
        this.kMT.init();
        d dVar = this.kMT;
        switch (this.kMU) {
            case 2:
                list = dVar.kKs;
                break;
            default:
                list = dVar.kKt;
                break;
        }
        if (list != null) {
            List arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) list.get(i2);
                    if (!(bVar == null || bVar.jQP == null)) {
                        com.tencent.mm.ui.base.sortview.d dVar2 = new com.tencent.mm.ui.base.sortview.d();
                        dVar2.data = bVar;
                        i = bVar.jQP.field_showHead;
                        if (i >= 97 && i <= 122) {
                            i -= 32;
                        }
                        if (i < 65 || i > 90) {
                            dVar2.ysR = "#";
                        } else {
                            dVar2.ysR = ((char) i);
                        }
                        arrayList.add(dVar2);
                    }
                    i = i2 + 1;
                } else {
                    list2 = arrayList;
                }
            }
        } else {
            list2 = null;
        }
        dd(list2);
        super.refresh();
    }

    public final void release() {
        if (as.Hp()) {
            y.Mt().Mf();
        }
        d dVar = this.kMT;
        if (this == null) {
            x.w("MicroMsg.BrandService.BrandServiceMgr", "removeListener:onChange is null");
            dVar.kKq.remove(null);
        }
        e eVar = this.kMT;
        as.CN().b(387, eVar);
        if (eVar.kKr) {
            List arrayList = new ArrayList(eVar.kKs.size() + eVar.kKt.size());
            for (com.tencent.mm.plugin.brandservice.a.b add : eVar.kKs) {
                arrayList.add(add);
            }
            for (com.tencent.mm.plugin.brandservice.a.b add2 : eVar.kKt) {
                arrayList.add(add2);
            }
            as.CN().a(new k(arrayList), 0);
        }
    }

    public final boolean a(String str, com.tencent.mm.ui.base.sortview.d dVar) {
        if (!(bi.oN(str) || dVar == null)) {
            this.kMY = str;
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) dVar.data;
            if (bVar == null || bVar.jQP == null) {
                x.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
                return false;
            }
            com.tencent.mm.storage.x xVar = bVar.jQP;
            String AX = xVar.AX();
            String vX = xVar.vX();
            String vY = xVar.vY();
            String toUpperCase = str.toUpperCase();
            if (!(bi.oN(AX) || AX.toUpperCase().indexOf(toUpperCase) == -1) || (!(bi.oN(vX) || vX.toUpperCase().indexOf(toUpperCase) == -1) || (!bi.oN(vY) && vY.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), R.i.dbK, this);
    }

    public final VerticalScrollBar atd() {
        return (VerticalScrollBar) findViewById(R.h.cOu);
    }

    public final ListView getListView() {
        this.kMW = (ListView) findViewById(R.h.ctk);
        if (this.kMZ == null) {
            this.kMZ = inflate(getContext(), R.i.dfm, null);
            if (!(this.kMW == null || this.kMZ == null)) {
                this.kNa = (TextView) this.kMZ.findViewById(R.h.bZc);
                this.kMW.addFooterView(this.kMZ, null, false);
            }
        }
        return this.kMW;
    }

    public final View ate() {
        return findViewById(R.h.cAB);
    }

    public final com.tencent.mm.ui.base.sortview.c.a atf() {
        return new com.tencent.mm.ui.base.sortview.c.a() {
            public final View a(com.tencent.mm.ui.base.sortview.d dVar, View view, int i, boolean z, boolean z2) {
                b bVar;
                long Wz = bi.Wz();
                Context context = BrandServiceSortView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.i.dbJ, null);
                    bVar = new b();
                    bVar.kKK = (TextView) view.findViewById(R.h.bSx);
                    bVar.contentView = view.findViewById(R.h.bYN);
                    bVar.ikK = (ImageView) view.findViewById(R.h.bKr);
                    bVar.kMk = (ImageView) view.findViewById(R.h.cAd);
                    bVar.kHt = (TextView) view.findViewById(R.h.bOX);
                    bVar.kMl = view.findViewById(R.h.cLs);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                com.tencent.mm.plugin.brandservice.a.b bVar2 = (com.tencent.mm.plugin.brandservice.a.b) dVar.data;
                if (bVar2 == null) {
                    x.e("MicroMsg.BrandServiceSortView", "should not be empty");
                } else {
                    if (BrandServiceSortView.this.ysJ && z) {
                        bVar.kKK.setText(dVar.ysR);
                        bVar.kKK.setVisibility(0);
                    } else {
                        bVar.kKK.setVisibility(8);
                    }
                    bVar.username = bVar2.userName;
                    bVar.iconUrl = bVar2.kKo.field_brandIconURL;
                    bVar.ikK.setTag(bVar2.userName);
                    bVar.atm();
                    BrandServiceSortView.a(BrandServiceSortView.this, bVar.kHt, context, bVar2.jQP.AX(), (int) bVar.kHt.getTextSize());
                    x.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", Integer.valueOf(bVar2.kKo.field_status));
                    ImageView imageView = bVar.kMk;
                    int i2 = (BrandServiceSortView.this.kMV && bVar2.kKo.field_status == 1) ? 0 : 8;
                    imageView.setVisibility(i2);
                    if (BrandServiceSortView.this.mMode == 0 && z2) {
                        bVar.kMl.setBackgroundResource(R.g.bBz);
                    } else {
                        bVar.kMl.setBackgroundResource(R.g.bDq);
                    }
                    if (BrandServiceSortView.this.ysK) {
                        bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) BrandServiceSortView.this.getContext().getResources().getDimension(R.f.buo), bVar.contentView.getPaddingBottom());
                    } else {
                        bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) BrandServiceSortView.this.getContext().getResources().getDimension(R.f.bvK), bVar.contentView.getPaddingBottom());
                    }
                    x.v("MicroMsg.BrandServiceSortView", "get view use %d ms", Long.valueOf(bi.bB(Wz)));
                }
                return view;
            }
        };
    }

    public final void asP() {
        refresh();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.kMb = (int) motionEvent.getRawX();
            this.kMc = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.kMf.zDp = view;
        this.kMf.a(adapterView, i, j, this, this.kNb, this.kMb, this.kMc);
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (contextMenuInfo == null) {
            x.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
            return;
        }
        x.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        com.tencent.mm.ui.base.sortview.d dVar = (com.tencent.mm.ui.base.sortview.d) ((AdapterView) view).getItemAtPosition(adapterContextMenuInfo.position);
        if (dVar == null || dVar.data == null) {
            x.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", dVar);
            return;
        }
        ag agVar = ((com.tencent.mm.plugin.brandservice.a.b) dVar.data).jQP;
        if (agVar == null) {
            x.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
            return;
        }
        this.jPV = agVar.field_username;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(getContext(), agVar.AX()));
        com.tencent.mm.af.d jV = f.jV(agVar.field_username);
        if (jV != null && !jV.Lj()) {
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.euv);
        }
    }

    public final void ak(List<com.tencent.mm.ui.base.sortview.d> list) {
        if (this.kNa != null && list != null) {
            this.kNa.setText(getContext().getString(R.l.dNn, new Object[]{Integer.valueOf(list.size())}));
        }
    }

    public final void M(boolean z) {
        this.OQ = z;
        BaseSortView.n(this.kNa, z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.kMX != null) {
            this.kMX.atb();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
