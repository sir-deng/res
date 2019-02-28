package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.label.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.widget.i;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI extends ContactLabelBaseUI implements OnCreateContextMenuListener, OnItemClickListener, e, d {
    private ListView Fv;
    private int RE;
    private int kMb = 0;
    private int kMc = 0;
    private i kMf;
    private View lIB;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            x.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", Integer.valueOf(message.what));
            switch (message.what) {
                case 5001:
                    ContactLabelManagerUI.this.gn(false);
                    return;
                case 5002:
                    ContactLabelManagerUI.this.DY(ContactLabelManagerUI.this.getString(R.l.dHn));
                    return;
                case 5003:
                    ContactLabelManagerUI.this.aVF();
                    return;
                default:
                    return;
            }
        }
    };
    private b nUG = b.Normal;
    private View nUH;
    private View nUI;
    private a nUJ;
    private ArrayList<z> nUK = new ArrayList();
    private HashMap<Integer, Integer> nUL = new HashMap();
    private boolean nUM = true;
    private OnClickListener nUN = new OnClickListener() {
        public final void onClick(View view) {
            ContactLabelManagerUI.b(ContactLabelManagerUI.this);
        }
    };
    private com.tencent.mm.sdk.e.j.a nUO = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, l lVar) {
            if (!bi.oN(str)) {
                ContactLabelManagerUI.this.gn(false);
            }
        }
    };
    private com.tencent.mm.sdk.e.m.b nUP = new com.tencent.mm.sdk.e.m.b() {
        public final void a(int i, m mVar, Object obj) {
            x.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", Integer.valueOf(i), obj);
            if (ContactLabelManagerUI.this.mHandler != null) {
                ContactLabelManagerUI.this.mHandler.removeMessages(5001);
                ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(5001, 400);
            }
        }
    };

    class a extends BaseAdapter {
        ArrayList<z> mData;

        a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            return sb(i);
        }

        public final int getCount() {
            return this.mData == null ? 0 : this.mData.size();
        }

        public final z sb(int i) {
            return (this.mData == null || i > this.mData.size()) ? null : (z) this.mData.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(ContactLabelManagerUI.this).inflate(R.i.deV, viewGroup, false);
                cVar = new c(view);
                LayoutParams layoutParams = cVar.nVN.getLayoutParams();
                layoutParams.height = (int) (((float) com.tencent.mm.bu.a.ab(ContactLabelManagerUI.this, R.f.bvS)) * com.tencent.mm.bu.a.ey(ContactLabelManagerUI.this));
                cVar.nVN.setLayoutParams(layoutParams);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            z sb = sb(i);
            cVar.nVL.setText(com.tencent.mm.pluginsdk.ui.d.i.c(ContactLabelManagerUI.this.mController.xRr, sb.field_labelName, ContactLabelManagerUI.this.RE));
            if (ContactLabelManagerUI.this.nUL == null || !ContactLabelManagerUI.this.nUL.containsKey(Integer.valueOf(sb.field_labelID))) {
                cVar.nVM.setVisibility(0);
                cVar.nVM.setText("(0)");
            } else {
                cVar.nVM.setVisibility(0);
                cVar.nVM.setText("(" + ContactLabelManagerUI.this.nUL.get(Integer.valueOf(sb.field_labelID)) + ")");
            }
            return view;
        }
    }

    public enum b {
        Normal,
        Empty
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, b bVar) {
        contactLabelManagerUI.nUG = bVar;
        switch (contactLabelManagerUI.nUG) {
            case Normal:
                contactLabelManagerUI.lIB.setVisibility(0);
                contactLabelManagerUI.nUH.setVisibility(8);
                return;
            case Empty:
                contactLabelManagerUI.lIB.setVisibility(8);
                contactLabelManagerUI.nUH.setVisibility(0);
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelManagerUI", "unkonw mode:%s", contactLabelManagerUI.nUG);
                return;
        }
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, z zVar) {
        if (zVar == null) {
            x.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteScene] can not do scene. lable is null");
            return;
        }
        contactLabelManagerUI.DY(contactLabelManagerUI.getString(R.l.esK));
        as.CN().a(new com.tencent.mm.plugin.label.b.b(zVar.field_labelID), 0);
    }

    static /* synthetic */ void b(ContactLabelManagerUI contactLabelManagerUI) {
        if (contactLabelManagerUI.nUK == null || contactLabelManagerUI.nUK.isEmpty()) {
            g.pWK.h(11347, Integer.valueOf(1), Integer.valueOf(0));
        } else {
            g.pWK.h(11347, Integer.valueOf(1), Integer.valueOf(1));
        }
        x.i("MicroMsg.Label.ContactLabelManagerUI", "dz[dealAddLabel]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.p(s.zcz, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelManagerUI.getString(R.l.esH));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 5);
        com.tencent.mm.bl.d.a((Context) contactLabelManagerUI, ".ui.contact.SelectContactUI", intent, 7001);
    }

    protected final int getLayoutId() {
        return R.i.deW;
    }

    protected final void initView() {
        this.RE = com.tencent.mm.bu.a.aa(this.mController.xRr, R.f.bvL);
        setMMTitle(getString(R.l.esI));
        addTextOptionMenu(0, getString(R.l.esO), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelManagerUI.b(ContactLabelManagerUI.this);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelManagerUI.this.finish();
                return false;
            }
        });
        this.nUJ = new a();
        this.lIB = findViewById(R.h.csp);
        this.nUH = findViewById(R.h.csj);
        this.nUI = findViewById(R.h.csq);
        this.nUI.setOnClickListener(this.nUN);
        this.Fv = (ListView) findViewById(R.h.cso);
        this.kMf = new i(this);
        this.Fv.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    ContactLabelManagerUI.this.kMb = (int) motionEvent.getRawX();
                    ContactLabelManagerUI.this.kMc = (int) motionEvent.getRawY();
                }
                return false;
            }
        });
        this.Fv.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                ContactLabelManagerUI.this.kMf.a(view, i, j, ContactLabelManagerUI.this, ContactLabelManagerUI.this, ContactLabelManagerUI.this.kMb, ContactLabelManagerUI.this.kMc);
                return true;
            }
        });
        this.Fv.setAdapter(this.nUJ);
        this.Fv.setOnItemClickListener(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        as.Dt().F(new Runnable() {
            public final void run() {
                as.CN().a(new c(), 0);
            }
        });
        com.tencent.mm.plugin.label.e.aVC().c(this.nUO);
    }

    protected void onResume() {
        as.CN().a(636, (e) this);
        as.Hm();
        com.tencent.mm.y.c.Ff().a(this.nUP);
        gn(true);
        super.onResume();
    }

    protected void onPause() {
        as.CN().b(636, (e) this);
        as.Hm();
        com.tencent.mm.y.c.Ff().b(this.nUP);
        super.onPause();
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.label.e.aVC().j(this.nUO);
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.nUJ != null && i >= 0) {
            z sb = this.nUJ.sb(i);
            if (sb != null) {
                String str = sb.field_labelID;
                String str2 = sb.field_labelName;
                Intent intent = new Intent();
                intent.putExtra("label_id", str);
                intent.putExtra("label_name", str2);
                intent.setClass(this, ContactLabelEditUI.class);
                startActivity(intent);
                if (!bi.oN(str)) {
                    return;
                }
                if (this.nUK == null || this.nUK.isEmpty()) {
                    g.pWK.h(11347, Integer.valueOf(1), Integer.valueOf(0));
                    return;
                }
                g.pWK.h(11347, Integer.valueOf(1), Integer.valueOf(1));
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = ((AdapterContextMenuInfo) contextMenuInfo).position;
        if (this.nUJ != null && i >= 0) {
            z sb = this.nUJ.sb(i);
            if (sb != null) {
                contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.i.a(view.getContext(), sb.field_labelName));
                contextMenu.add(0, 0, 0, getString(R.l.dEH));
                contextMenu.add(0, 1, 1, getString(R.l.dEQ));
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int i2 = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (this.nUJ != null && i2 >= 0) {
            final z sb = this.nUJ.sb(i2);
            switch (i) {
                case 0:
                    h.a((Context) this, getString(R.l.esJ), "", getString(R.l.dEH), getString(R.l.dEy), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (sb == null) {
                                return;
                            }
                            if (sb.field_isTemporary) {
                                ContactLabelManagerUI.this.Ec(sb.field_labelID);
                            } else {
                                ContactLabelManagerUI.a(ContactLabelManagerUI.this, sb);
                            }
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                case 1:
                    Intent intent = new Intent();
                    intent.setClass(this, ContactLabelEditUI.class);
                    intent.putExtra("label_id", sb.field_labelID);
                    intent.putExtra("label_name", sb.field_labelName);
                    startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (kVar.getType()) {
            case 636:
                if (i == 0 && i2 == 0) {
                    Ec(((com.tencent.mm.plugin.label.b.b) kVar).nUl);
                    return;
                }
                x.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
                aVK();
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
                return;
        }
    }

    private synchronized void gn(final boolean z) {
        x.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", String.valueOf(z));
        if (z && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(5002, 400);
        }
        as.Dt().F(new Runnable() {
            public final void run() {
                ContactLabelManagerUI.this.nUK = com.tencent.mm.plugin.label.e.aVC().ciV();
                if (ContactLabelManagerUI.this.nUK == null || ContactLabelManagerUI.this.nUK.size() <= 0) {
                    x.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
                    if (ContactLabelManagerUI.this.nUM) {
                        g.pWK.h(11346, Integer.valueOf(1), Integer.valueOf(0));
                        ContactLabelManagerUI.this.nUM = false;
                    }
                    ah.y(new Runnable() {
                        public final void run() {
                            ContactLabelManagerUI.a(ContactLabelManagerUI.this, b.Empty);
                            if (z && ContactLabelManagerUI.this.mHandler != null) {
                                ContactLabelManagerUI.this.mHandler.removeMessages(5002);
                                ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(5003, 0);
                            }
                        }
                    });
                    return;
                }
                x.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
                if (ContactLabelManagerUI.this.nUM) {
                    g.pWK.h(11346, Integer.valueOf(1), Integer.valueOf(1));
                    ContactLabelManagerUI.this.nUM = false;
                }
                if (ContactLabelManagerUI.this.nUK != null && ContactLabelManagerUI.this.nUK.size() > 0) {
                    int size = ContactLabelManagerUI.this.nUK.size();
                    com.tencent.mm.plugin.label.e.aVC().aVx();
                    for (int i = 0; i < size; i++) {
                        int i2 = ((z) ContactLabelManagerUI.this.nUK.get(i)).field_labelID;
                        ArrayList Xl = com.tencent.mm.plugin.label.e.aVC().Xl(String.valueOf(i2));
                        if (Xl == null || Xl.size() <= 0) {
                            ContactLabelManagerUI.this.nUL.put(Integer.valueOf(i2), Integer.valueOf(0));
                        } else {
                            ContactLabelManagerUI.this.nUL.put(Integer.valueOf(i2), Integer.valueOf(Xl.size()));
                        }
                    }
                }
                ah.y(new Runnable() {
                    public final void run() {
                        ContactLabelManagerUI.a(ContactLabelManagerUI.this, b.Normal);
                        a k = ContactLabelManagerUI.this.nUJ;
                        k.mData = ContactLabelManagerUI.this.nUK;
                        k.notifyDataSetChanged();
                        ContactLabelManagerUI.this.nUJ.notifyDataSetInvalidated();
                        if (z && ContactLabelManagerUI.this.mHandler != null) {
                            ContactLabelManagerUI.this.mHandler.removeMessages(5002);
                            ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(5003, 400);
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|updateData";
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 7001:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    x.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", stringExtra);
                    if (!bi.oN(stringExtra)) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this, ContactLabelEditUI.class);
                        intent2.putExtra("Select_Contact", stringExtra);
                        startActivity(intent2);
                        break;
                    }
                    break;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void Ec(String str) {
        if (com.tencent.mm.plugin.label.e.aVC().iI(str)) {
            aVF();
            gn(false);
            return;
        }
        x.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
        aVK();
    }

    private void aVK() {
        aVF();
        zk(getString(R.l.dYz));
    }
}
