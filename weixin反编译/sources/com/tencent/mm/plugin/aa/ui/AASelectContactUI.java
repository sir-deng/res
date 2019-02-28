package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AASelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> ikP;
    private HashSet<String> ikQ;
    private long ikR;
    private int ikS;
    private CheckBox ikT;
    private View ikU;
    private String title;

    static /* synthetic */ void a(AASelectContactUI aASelectContactUI, List list) {
        if (aASelectContactUI.ikQ != null) {
            aASelectContactUI.ikQ.clear();
        } else {
            aASelectContactUI.ikQ = new HashSet();
        }
        aASelectContactUI.ikQ.addAll(list);
        aASelectContactUI.ikT.setChecked(true);
        aASelectContactUI.cwP().notifyDataSetChanged();
    }

    protected final void Xc() {
        super.Xc();
        this.title = getIntent().getStringExtra("titile");
        this.ikR = getIntent().getLongExtra("max_select_num", 20);
        this.ikS = getIntent().getIntExtra("select_type", 1);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!s.eX(this.chatroomName)) {
            x.i("MicroMsg.AASelectContactUI", "is single chat");
        }
        this.ikQ = new HashSet();
        this.ikP = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bi.oN(stringExtra)) {
            this.ikP.addAll(Arrays.asList(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bi.oN(stringExtra)) {
            this.ikQ.addAll(bi.F(stringExtra.split(",")));
            Xi();
        }
        this.ikT = (CheckBox) findViewById(f.uDJ);
        this.ikU = findViewById(f.uDK);
        this.ikU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (AASelectContactUI.this.ikT.isChecked()) {
                    if (AASelectContactUI.this.ikQ != null) {
                        AASelectContactUI.this.ikQ.clear();
                    } else {
                        AASelectContactUI.this.ikQ = new HashSet();
                    }
                    AASelectContactUI.this.ikT.setChecked(false);
                    AASelectContactUI.this.cwP().notifyDataSetChanged();
                } else {
                    final List oS = h.oS(AASelectContactUI.this.chatroomName);
                    if (((long) oS.size()) > AASelectContactUI.this.ikR) {
                        com.tencent.mm.ui.base.h.a(AASelectContactUI.this.mController.xRr, AASelectContactUI.this.getString(i.uNP, new Object[]{Long.valueOf(AASelectContactUI.this.ikR)}), "", new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AASelectContactUI.a(AASelectContactUI.this, oS);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        AASelectContactUI.a(AASelectContactUI.this, oS);
                    }
                }
                g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(6));
            }
        });
        if (this.ikQ.size() == h.oS(this.chatroomName).size()) {
            this.ikT.setChecked(true);
        } else {
            this.ikT.setChecked(false);
        }
        this.ikT.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AASelectContactUI.this.Xi();
            }
        });
    }

    protected final void initView() {
        super.initView();
        a(1, getString(i.dGf), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (((long) AASelectContactUI.this.ikQ.size()) > AASelectContactUI.this.ikR) {
                    com.tencent.mm.ui.base.h.b(AASelectContactUI.this.mController.xRr, AASelectContactUI.this.getString(i.uPY, new Object[]{Long.valueOf(AASelectContactUI.this.ikR)}), "", true);
                    g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(8));
                    g.pWK.h(13722, Integer.valueOf(3));
                } else if (AASelectContactUI.this.ikQ.size() <= 0) {
                    com.tencent.mm.ui.base.h.b(AASelectContactUI.this.mController.xRr, AASelectContactUI.this.getString(i.uNS, new Object[]{Integer.valueOf(1)}), "", true);
                    g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(9));
                } else {
                    List linkedList = new LinkedList();
                    linkedList.addAll(AASelectContactUI.this.ikQ);
                    AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", bi.d(linkedList, ",")));
                    AASelectContactUI.this.finish();
                    AASelectContactUI.this.aWY();
                    g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(8));
                }
                return true;
            }
        }, b.xSe);
        Xi();
        this.otF.vrh = this;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (AASelectContactUI.this.ikQ == null || AASelectContactUI.this.ikQ.size() <= 0 || ((long) AASelectContactUI.this.ikQ.size()) > AASelectContactUI.this.ikR || (AASelectContactUI.this.ikQ.size() == 1 && AASelectContactUI.this.ikQ.contains(q.FY()))) {
                    AASelectContactUI.this.finish();
                } else {
                    com.tencent.mm.ui.base.h.a(AASelectContactUI.this, AASelectContactUI.this.getString(i.uNO), null, AASelectContactUI.this.getString(i.uNR), AASelectContactUI.this.getString(i.uNQ), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (((long) AASelectContactUI.this.ikQ.size()) > AASelectContactUI.this.ikR) {
                                com.tencent.mm.ui.base.h.b(AASelectContactUI.this.mController.xRr, AASelectContactUI.this.getString(i.uPY, new Object[]{Long.valueOf(AASelectContactUI.this.ikR)}), "", true);
                                g.pWK.h(13722, Integer.valueOf(3));
                                return;
                            }
                            List linkedList = new LinkedList();
                            linkedList.addAll(AASelectContactUI.this.ikQ);
                            AASelectContactUI.this.setResult(-1, AASelectContactUI.this.getIntent().putExtra("Select_Contact", bi.d(linkedList, ",")));
                            AASelectContactUI.this.finish();
                            g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(11));
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AASelectContactUI.this.finish();
                            g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(10));
                        }
                    });
                }
                g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(7));
                return true;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bi.oN(stringExtra)) {
            this.ikP.addAll(bi.F(stringExtra.split(",")));
        }
    }

    protected final boolean Xd() {
        return false;
    }

    protected final boolean Xe() {
        return false;
    }

    protected final String Xf() {
        return this.title;
    }

    protected final o Xg() {
        return new d(this, this.chatroomName);
    }

    protected final m Xh() {
        return new e(this, this.chatroomName);
    }

    public final void jd(int i) {
        n cwP = cwP();
        a GF = cwP.GF(i - this.pxs.getHeaderViewsCount());
        if (GF != null && GF.jQP != null) {
            x.i("MicroMsg.AASelectContactUI", "ClickUser=%s", GF.jQP.field_username);
            String str = GF.jQP.field_username;
            if (str.equals(q.FY())) {
                g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(4));
            } else {
                g.pWK.h(13721, Integer.valueOf(2), Integer.valueOf(5));
            }
            cwV();
            if (this.ikQ.contains(str)) {
                this.ikQ.remove(str);
            } else {
                this.ikQ.add(str);
            }
            if (this.ikQ.size() == h.oS(this.chatroomName).size()) {
                this.ikT.setChecked(true);
            } else {
                this.ikT.setChecked(false);
            }
            cwP.notifyDataSetChanged();
            Xi();
        }
    }

    public final boolean a(a aVar) {
        if (!aVar.zbR || aVar.jQP == null) {
            return false;
        }
        return this.ikQ.contains(aVar.jQP.field_username);
    }

    public final boolean b(a aVar) {
        if (!aVar.zbR || aVar.jQP == null) {
            return false;
        }
        return this.ikP.contains(aVar.jQP.field_username);
    }

    private void Xi() {
        if (this.ikQ.size() > 0) {
            updateOptionMenuText(1, getString(i.uNw, new Object[]{Integer.valueOf(this.ikQ.size())}));
        } else {
            updateOptionMenuText(1, getString(i.dGf));
        }
        if (this.ikQ.size() == 1 && this.ikQ.contains(q.FY())) {
            enableOptionMenu(1, false);
        } else {
            enableOptionMenu(1, true);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public final void oW(String str) {
        this.ikQ.remove(str);
        cwP().notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uHw;
    }
}
