package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;

public class SnsSelectContactDialog extends MMBaseActivity {
    private List<String> hkf = new LinkedList();
    private GridView rKV = null;
    private a rKW = null;

    class a extends BaseAdapter {
        private Context context;
        private List<String> hkf;
        private int rwu = 0;
        private int type;

        public a(Context context, int i) {
            this.hkf = i;
            this.context = context;
            this.type = 0;
            refresh();
        }

        public final void refresh() {
            if (this.hkf == null) {
                this.rwu = 0;
            } else {
                this.rwu = this.hkf.size();
            }
            this.rwu++;
            notifyDataSetChanged();
        }

        public final int getCount() {
            return this.rwu;
        }

        public final Object getItem(int i) {
            return this.hkf.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                View inflate;
                b bVar2 = new b();
                if (this.type == 0) {
                    inflate = View.inflate(this.context, g.qOj, null);
                } else {
                    inflate = View.inflate(this.context, g.qNd, null);
                }
                bVar2.lHW = (ImageView) inflate.findViewById(f.image);
                bVar2.rKY = (ImageView) inflate.findViewById(f.qID);
                inflate.setTag(bVar2);
                view = inflate;
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            view.setVisibility(0);
            if (i == this.rwu - 1) {
                bVar.lHW.setBackgroundDrawable(null);
                bVar.lHW.setImageResource(e.qFL);
                bVar.rKY.setVisibility(8);
                if (this.hkf.size() >= v.xva) {
                    view.setVisibility(8);
                }
            } else {
                bVar.lHW.setBackgroundDrawable(null);
                bVar.rKY.setVisibility(0);
                if (this.type == 0) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(bVar.lHW, (String) this.hkf.get(i));
                } else {
                    bVar.lHW.setImageBitmap(d.d((String) this.hkf.get(i), ae.bwn(), ae.bwn(), true));
                }
            }
            bVar.lHW.setScaleType(ScaleType.CENTER_CROP);
            return view;
        }
    }

    static class b {
        ImageView lHW;
        ImageView rKY;

        b() {
        }
    }

    static /* synthetic */ void b(SnsSelectContactDialog snsSelectContactDialog) {
        Intent intent = new Intent();
        String str = bi.d(snsSelectContactDialog.hkf, ",") + ", " + q.FY();
        intent.putExtra("Contact_Compose", true);
        intent.putExtra("Add_get_from_sns", snsSelectContactDialog.bCa());
        intent.putExtra("List_Type", 1);
        intent.putExtra("Add_address_titile", snsSelectContactDialog.getString(j.dDz));
        intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
        intent.putExtra("Block_list", str);
        intent.putExtra("sns_address_count", snsSelectContactDialog.hkf.size());
        com.tencent.mm.plugin.sns.c.a.ihN.a(intent, (Activity) snsSelectContactDialog, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.qNi);
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (stringExtra == null || stringExtra.equals("")) {
            this.hkf.clear();
        } else {
            this.hkf = bi.F(stringExtra.split(","));
        }
        this.rKV = (GridView) findViewById(f.qHO);
        this.rKW = new a(this, this.hkf);
        this.rKV.setAdapter(this.rKW);
        this.rKV.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == SnsSelectContactDialog.this.rKW.getCount() - 1) {
                    SnsSelectContactDialog.b(SnsSelectContactDialog.this);
                } else {
                    SnsSelectContactDialog.this.hkf.remove(i);
                }
                SnsSelectContactDialog.this.rKW.refresh();
            }
        });
        this.rKV.setSelection(this.rKW.getCount() - 1);
        ((ImageButton) findViewById(f.bWm)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", bi.d(SnsSelectContactDialog.this.hkf, ","));
                SnsSelectContactDialog.this.setResult(-1, intent);
                SnsSelectContactDialog.this.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", bi.d(this.hkf, ","));
            setResult(-1, intent);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private boolean MF(String str) {
        for (Object equals : s.hhb) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (s.eX(str) || s.gI(str)) {
            return false;
        }
        if (this.hkf == null || !this.hkf.contains(str)) {
            return true;
        }
        return false;
    }

    private String bCa() {
        as Fk = ((h) com.tencent.mm.kernel.g.h(h.class)).Fk();
        String str = s.hgU;
        List linkedList = new LinkedList();
        for (Object add : s.hhb) {
            linkedList.add(add);
        }
        linkedList.add("weixin");
        linkedList.add("officialaccounts");
        linkedList.add("helper_entry");
        linkedList.add("filehelper");
        Cursor c = Fk.c(str, linkedList, "*");
        if (c.getCount() == 0) {
            c.close();
            return "";
        }
        List linkedList2 = new LinkedList();
        c.moveToFirst();
        do {
            ak aeVar = new com.tencent.mm.storage.ae();
            aeVar.b(c);
            if (MF(aeVar.field_username)) {
                linkedList2.add(aeVar.field_username);
                if (linkedList2.size() >= 10) {
                    break;
                }
            }
        } while (c.moveToNext());
        c.close();
        return bi.d(linkedList2, ";");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        List<String> F = bi.F(intent.getStringExtra("Select_Contact").split(","));
                        if (F != null) {
                            if (this.hkf == null) {
                                this.hkf = new LinkedList();
                            }
                            for (String str : F) {
                                if (!this.hkf.contains(str)) {
                                    this.hkf.add(str);
                                }
                            }
                            x.d("MicroMsg.SnsSelectContactDialog", "withList count " + this.hkf.size());
                            if (this.rKW != null) {
                                x.d("MicroMsg.SnsSelectContactDialog", "refresh alertAdapter");
                                this.rKW.refresh();
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Select_Contact", bi.d(this.hkf, ","));
                            setResult(-1, intent2);
                            finish();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
