package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI extends MMActivity {
    private TextView emptyTipTv;
    private List<x> osM;
    private List<String> zbA = null;
    private int zbB;
    private ListView zbC;
    private a zbD;
    private HashMap<String, Long> zbE;
    private boolean zbx = true;
    private boolean zby;
    private boolean zbz = false;

    class a extends BaseAdapter {
        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            x xVar = (x) GroupCardSelectUI.this.osM.get(i);
            if (view == null) {
                b bVar2 = new b();
                view = View.inflate(GroupCardSelectUI.this, R.i.dlF, null);
                bVar2.nVM = (TextView) view.findViewById(R.h.cob);
                bVar2.zbG = (TextView) view.findViewById(R.h.coc);
                bVar2.hxJ = (ImageView) view.findViewById(R.h.coa);
                bVar2.plj = (CheckBox) view.findViewById(R.h.cKP);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.hxJ, xVar.field_username);
            bVar.zbG.setText(i.c(GroupCardSelectUI.this, r.gw(xVar.field_username), com.tencent.mm.bu.a.aa(GroupCardSelectUI.this.mController.xRr, R.f.bvL)));
            bVar.nVM.setText("(" + m.gn(xVar.field_username) + ")");
            if (GroupCardSelectUI.this.zbz) {
                bVar.plj.setVisibility(0);
                if (GroupCardSelectUI.this.zbA.contains(xVar.field_username)) {
                    bVar.plj.setChecked(true);
                } else {
                    bVar.plj.setChecked(false);
                }
            }
            return view;
        }

        public final int getCount() {
            return GroupCardSelectUI.this.osM.size();
        }

        public final Object getItem(int i) {
            return GroupCardSelectUI.this.osM.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    class b {
        ImageView hxJ;
        TextView nVM;
        CheckBox plj;
        TextView zbG;

        b() {
        }
    }

    static /* synthetic */ void a(GroupCardSelectUI groupCardSelectUI, x xVar) {
        int i = 1;
        Intent intent;
        if (groupCardSelectUI.zbz) {
            if (groupCardSelectUI.zbA.contains(xVar.field_username)) {
                groupCardSelectUI.zbA.remove(xVar.field_username);
            } else {
                if (!groupCardSelectUI.zbz || groupCardSelectUI.zbA.size() < groupCardSelectUI.zbB) {
                    i = 0;
                } else {
                    h.a(groupCardSelectUI.mController.xRr, groupCardSelectUI.getString(R.l.eJy, new Object[]{Integer.valueOf(groupCardSelectUI.zbB)}), groupCardSelectUI.getString(R.l.dGE), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                if (i == 0) {
                    groupCardSelectUI.zbA.add(xVar.field_username);
                }
            }
            groupCardSelectUI.zbD.notifyDataSetChanged();
        } else if (!groupCardSelectUI.zbx) {
            intent = new Intent();
            as.Hm();
            intent.putExtra("Select_Contact", bi.d(c.Fo().hK(xVar.field_username), ","));
            intent.putExtra("Select_room_name", r.gw(xVar.field_username));
            groupCardSelectUI.setResult(-1, intent);
            groupCardSelectUI.finish();
        } else if (groupCardSelectUI.zby) {
            intent = new Intent();
            intent.putExtra("Select_Conv_User", xVar.field_username);
            groupCardSelectUI.setResult(-1, intent);
            groupCardSelectUI.finish();
        } else {
            intent = new Intent(groupCardSelectUI, ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", xVar.field_username);
            groupCardSelectUI.startActivity(intent);
            groupCardSelectUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.dDs));
        this.zbx = getIntent().getBooleanExtra("group_select_type", true);
        this.zby = getIntent().getBooleanExtra("group_select_need_result", false);
        this.zbz = getIntent().getBooleanExtra("group_multi_select", false);
        if (this.zbz) {
            String stringExtra = getIntent().getStringExtra("already_select_contact");
            if (bi.oN(stringExtra)) {
                this.zbA = new LinkedList();
            } else {
                this.zbA = t.g(stringExtra.split(","));
            }
            this.zbB = getIntent().getIntExtra("max_limit_num", 0);
        }
        cwN();
        initView();
        if (this.zbz) {
            a(1, getString(R.l.dGf), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_User", bi.d(GroupCardSelectUI.this.zbA, ","));
                    GroupCardSelectUI.this.setResult(-1, intent);
                    GroupCardSelectUI.this.finish();
                    return true;
                }
            }, com.tencent.mm.ui.p.b.xSe);
            enableOptionMenu(1, true);
            Xi();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void initView() {
        this.zbC = (ListView) findViewById(R.h.cod);
        this.zbD = new a();
        this.zbC.setAdapter(this.zbD);
        this.zbC.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x xVar = (x) GroupCardSelectUI.this.zbD.getItem(i);
                if (xVar == null) {
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
                    return;
                }
                GroupCardSelectUI.a(GroupCardSelectUI.this, xVar);
                GroupCardSelectUI.this.Xi();
            }
        });
        this.emptyTipTv = (TextView) findViewById(R.h.cnZ);
        if (this.zbD.getCount() <= 0) {
            this.emptyTipTv.setVisibility(0);
        } else {
            this.emptyTipTv.setVisibility(8);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GroupCardSelectUI.this.finish();
                return true;
            }
        });
    }

    private void cwN() {
        as.Hm();
        this.zbE = c.Fk().cjq();
        this.osM = new LinkedList();
        List<x> GJ = s.GJ();
        if (GJ.size() != 0) {
            int i = 0;
            for (x xVar : GJ) {
                int i2;
                if (this.zbE.containsKey(xVar.field_username)) {
                    a(i, xVar, ((Long) this.zbE.get(xVar.field_username)).longValue());
                    i2 = i + 1;
                } else if (com.tencent.mm.k.a.ga(xVar.field_type)) {
                    this.osM.add(xVar);
                } else {
                    i2 = i;
                }
                i = i2;
            }
            GJ.clear();
        }
    }

    private void a(int i, x xVar, long j) {
        int i2 = 0;
        while (i2 < i && j <= ((Long) this.zbE.get(((x) this.osM.get(i2)).field_username)).longValue()) {
            i2++;
        }
        this.osM.add(i2, xVar);
    }

    protected final int getLayoutId() {
        return R.i.dlE;
    }

    private void Xi() {
        if (this.zbz) {
            String format;
            StringBuilder append = new StringBuilder().append(getString(R.l.dGf));
            if (this.zbA.size() > 0) {
                format = String.format("(%s)", new Object[]{Integer.valueOf(this.zbA.size())});
            } else {
                format = "";
            }
            updateOptionMenuText(1, append.append(format).toString());
        }
    }
}
