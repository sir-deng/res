package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.be.b;
import com.tencent.mm.be.e;
import com.tencent.mm.be.l;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.a.f;
import com.tencent.mm.y.a.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class FMessageConversationUI extends MMActivity {
    private d kHD = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            e.e(FMessageConversationUI.this.sdj, FMessageConversationUI.this.ptC);
        }
    };
    private String ptC;
    private b scR;
    private ListView sdg;
    private a sdh;
    private TextView sdi;
    private long sdj;

    class a {
        ImageView jSg;
        TextView jtn;

        public a(View view) {
            this.jSg = (ImageView) view.findViewById(R.h.ciL);
            this.jtn = (TextView) view.findViewById(R.h.ciM);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eis);
        try {
            as.getNotification().xf();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FMessageConversationUI", e, "try cancel notification fail", new Object[0]);
        }
        if (as.Hp()) {
            initView();
        } else {
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        as.Hm();
        c.Db().set(143618, Integer.valueOf(0));
    }

    protected void onResume() {
        super.onResume();
        if (!as.Hp()) {
            finish();
        } else if (this.sdi != null && bi.PZ()) {
            this.sdi.setText(R.l.eiv);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        f.im("1");
        l.TE().Tr();
        if (this.scR != null) {
            l.TE().j(this.scR);
        }
    }

    protected final void initView() {
        int i;
        boolean z = true;
        if (g.Ip().ih("1") != null) {
            int i2;
            String str = g.Ip().ih("1").value;
            boolean i22;
            if (str.equals("0")) {
                i22 = 0;
            } else if (str.equals("1")) {
                i22 = true;
            } else {
                i22 = true;
            }
            f.il("1");
            i = i22;
        } else {
            boolean i3 = true;
        }
        this.scR = new b(this.mController.xRr);
        l.TE().c(this.scR);
        this.scR.xQN = new com.tencent.mm.ui.o.a() {
            public final void XF() {
            }

            public final void XE() {
                if (FMessageConversationUI.this.scR.getCount() >= 0) {
                    FMessageConversationUI.this.enableOptionMenu(0, true);
                } else {
                    FMessageConversationUI.this.enableOptionMenu(0, false);
                }
            }
        };
        this.sdg = (ListView) findViewById(R.h.ciG);
        if (i3 != 0) {
            View inflate = LayoutInflater.from(this.mController.xRr).inflate(R.i.diB, null);
            inflate.findViewById(R.h.ciP).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.bl.d.b(FMessageConversationUI.this.mController.xRr, "search", ".ui.FTSAddFriendUI", new Intent().putExtra("Search_Scene", 2).putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, 0));
                }
            });
            this.sdg.addHeaderView(inflate);
        }
        this.sdg.setAdapter(this.scR);
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.sdg.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < FMessageConversationUI.this.sdg.getHeaderViewsCount()) {
                    x.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
                } else {
                    View view2 = view;
                    lVar.a(view2, i - FMessageConversationUI.this.sdg.getHeaderViewsCount(), j, FMessageConversationUI.this, FMessageConversationUI.this.kHD);
                }
                return true;
            }
        });
        Context context = this.mController.xRr;
        b bVar = this.scR;
        if (this.sdg.getHeaderViewsCount() <= 0) {
            z = false;
        }
        this.sdh = new a(context, bVar, z);
        this.sdg.setOnItemClickListener(this.sdh);
        View findViewById;
        if (i3 == 0) {
            findViewById = findViewById(R.h.ciE);
            findViewById.setVisibility(0);
            ((TextView) findViewById(R.h.cet)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    as.Hm();
                    if (bi.oN((String) c.Db().get(6, null))) {
                        Intent intent = new Intent(FMessageConversationUI.this.mController.xRr, BindMContactIntroUI.class);
                        intent.putExtra("key_upload_scene", 5);
                        MMWizardActivity.A(FMessageConversationUI.this, intent);
                        return;
                    }
                    FMessageConversationUI.this.startActivity(new Intent(FMessageConversationUI.this, MobileFriendUI.class));
                }
            });
            this.sdg.setEmptyView(findViewById);
        } else {
            findViewById = findViewById(R.h.ciF);
            findViewById.setVisibility(0);
            this.sdi = (TextView) findViewById.findViewById(R.h.ciO);
            ListView listView = (ListView) findViewById.findViewById(R.h.ciN);
            listView.setAdapter(new BaseAdapter() {
                public final View getView(int i, View view, ViewGroup viewGroup) {
                    a aVar;
                    if (view == null || view.getTag() == null) {
                        view = LayoutInflater.from(FMessageConversationUI.this.mController.xRr).inflate(R.i.diA, null);
                        aVar = new a(view);
                        view.setTag(aVar);
                    } else {
                        aVar = (a) view.getTag();
                    }
                    if (i == 0) {
                        aVar.jSg.setImageResource(R.k.dyL);
                        aVar.jtn.setText(R.l.ehG);
                    }
                    return view;
                }

                public final long getItemId(int i) {
                    return (long) i;
                }

                public final Object getItem(int i) {
                    return Integer.valueOf(i);
                }

                public final int getCount() {
                    return 1;
                }
            });
            listView.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != 0) {
                        return;
                    }
                    if (m.NT() != com.tencent.mm.modelfriend.m.a.SUCC) {
                        Intent intent = new Intent(FMessageConversationUI.this.mController.xRr, BindMContactIntroUI.class);
                        intent.putExtra("key_upload_scene", 5);
                        MMWizardActivity.A(FMessageConversationUI.this.mController.xRr, intent);
                        return;
                    }
                    FMessageConversationUI.this.startActivity(new Intent(FMessageConversationUI.this.mController.xRr, MobileFriendUI.class));
                }
            });
            this.sdg.setEmptyView(findViewById);
        }
        addTextOptionMenu(0, getString(R.l.eve), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(FMessageConversationUI.this, AddMoreFriendsUI.class);
                intent.putExtra("invite_friend_scene", 3);
                FMessageConversationUI.this.startActivity(intent);
                return true;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FMessageConversationUI.this.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.diz;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        b bVar = (b) this.scR.getItem(adapterContextMenuInfo.position);
        if (bVar == null) {
            x.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        if (!bi.oN(bVar.field_displayName)) {
            contextMenu.setHeaderTitle(i.a((Context) this, bVar.field_displayName));
        }
        contextMenu.add(0, 0, 0, R.l.dEH);
        this.sdj = bVar.field_fmsgSysRowId;
        this.ptC = bVar.field_talker;
    }
}
