package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.aa.a.c.b;
import com.tencent.mm.plugin.aa.ui.a.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.q;
import java.util.List;

public class AAQueryListUI extends BaseAAPresenterActivity {
    private AAQueryListH5UrlFooterView ikA;
    private String ikB;
    private b ikt = ((b) q(b.class));
    private ListView iku;
    private b ikv;
    private Dialog ikw;
    private boolean ikx = false;
    private boolean iky = false;
    private View ikz;
    private int mode = 1;

    static /* synthetic */ void k(AAQueryListUI aAQueryListUI) {
        if (bi.oN(aAQueryListUI.ikB)) {
            x.i("MicroMsg.AAQueryListUI", "empty h5 url!");
            aAQueryListUI.ikA.setVisibility(8);
            return;
        }
        TextView textView = aAQueryListUI.ikA.iks;
        textView.setClickable(true);
        textView.setOnTouchListener(new l(aAQueryListUI));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(aAQueryListUI.getString(i.uNA));
        spannableStringBuilder.setSpan(new a(new a() {
            public final void WX() {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", AAQueryListUI.this.ikB);
                d.b(AAQueryListUI.this, "webview", ".ui.tools.WebViewUI", intent);
            }
        }), 0, spannableStringBuilder.length(), 18);
        textView.setText(spannableStringBuilder);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AAQueryListUI.this.finish();
                return false;
            }
        });
        setMMTitle(i.uNK);
        addIconOptionMenu(0, e.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                g gVar = new g(AAQueryListUI.this, g.zCt, false);
                gVar.rQF = new c() {
                    public final void a(n nVar) {
                        nVar.add(0, 1, 1, i.uNL);
                        nVar.add(1, 2, 1, i.uNM);
                    }
                };
                gVar.rQG = new p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                x.i("MicroMsg.AAQueryListUI", "go to launch list: %d", Integer.valueOf(AAQueryListUI.this.mode));
                                if (AAQueryListUI.this.mode != 1) {
                                    AAQueryListUI.this.mode = 1;
                                    AAQueryListUI.this.setMMTitle(i.uNK);
                                    AAQueryListUI.this.ikv.mode = AAQueryListUI.this.mode;
                                    AAQueryListUI.this.ikv.WY();
                                    AAQueryListUI.this.ikv.notifyDataSetChanged();
                                    AAQueryListUI.this.d(true, AAQueryListUI.this.mode);
                                    return;
                                }
                                return;
                            case 2:
                                x.i("MicroMsg.AAQueryListUI", "go to pay query list: %d", Integer.valueOf(AAQueryListUI.this.mode));
                                if (AAQueryListUI.this.mode != 2) {
                                    AAQueryListUI.this.setMMTitle(i.uNN);
                                    AAQueryListUI.this.ikv.mode = AAQueryListUI.this.mode;
                                    AAQueryListUI.this.ikv.WY();
                                    AAQueryListUI.this.ikv.notifyDataSetChanged();
                                    AAQueryListUI.this.mode = 2;
                                    AAQueryListUI.this.d(true, AAQueryListUI.this.mode);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                gVar.bUX();
                return true;
            }
        });
        this.iku = (ListView) findViewById(f.ukI);
        this.iku.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (AAQueryListUI.this.iku.getLastVisiblePosition() == AAQueryListUI.this.iku.getCount() - 1 && AAQueryListUI.this.iku.getCount() > 0 && !AAQueryListUI.this.iky && !AAQueryListUI.this.ikx) {
                    AAQueryListUI.this.iku.addFooterView(AAQueryListUI.this.ikz);
                    AAQueryListUI.this.d(false, AAQueryListUI.this.mode);
                }
            }
        });
        this.iku.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (AAQueryListUI.this.ikv != null) {
                    if (i < 0 || i >= AAQueryListUI.this.ikv.getCount()) {
                        x.i("MicroMsg.AAQueryListUI", "click out of bound! %s", Integer.valueOf(i));
                        return;
                    }
                    int top = view.getTop();
                    k kVar = (k) AAQueryListUI.this.ikv.getItem(i);
                    if (kVar != null) {
                        if (!bi.oN(kVar.vJU)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", kVar.vJU);
                            d.b(AAQueryListUI.this, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (!bi.oN(kVar.vJI)) {
                            String str = null;
                            if (kVar.vJT == 2) {
                                str = q.FY();
                            }
                            Intent intent2 = new Intent(AAQueryListUI.this, PaylistAAUI.class);
                            intent2.putExtra("bill_no", kVar.vJI);
                            intent2.putExtra("launcher_user_name", str);
                            intent2.putExtra("enter_scene", 4);
                            intent2.putExtra("chatroom", kVar.vJJ);
                            intent2.putExtra("item_position", i);
                            intent2.putExtra("item_offset", top);
                            AAQueryListUI.this.startActivityForResult(intent2, 1);
                        }
                    }
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(13721, Integer.valueOf(5), Integer.valueOf(3));
            }
        });
        this.ikz = new AAQueryListLoadingMoreView(this);
        this.ikA = new AAQueryListH5UrlFooterView(this);
        this.ikw = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        this.ikv = new b(this, this.mode);
        this.iku.setAdapter(this.ikv);
        this.iku.setVisibility(4);
        d(false, this.mode);
    }

    private void d(final boolean z, int i) {
        if (this.ikx) {
            x.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
            return;
        }
        if (z) {
            this.iky = false;
            this.iku.removeFooterView(this.ikA);
        }
        this.ikx = true;
        com.tencent.mm.vending.g.g.t(Boolean.valueOf(z), Integer.valueOf(i)).b(this.ikt.ijL).e(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.vending.j.d<List, String, Boolean>>() {
            public final /* synthetic */ Object call(Object obj) {
                com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
                List list = (List) dVar.get(0);
                x.i("MicroMsg.AAQueryListUI", "record list size: %s, h5Url: %s, lastFlag: %s", Integer.valueOf(list.size()), dVar.get(1), dVar.get(2));
                if (!bi.oN((String) dVar.get(1))) {
                    AAQueryListUI.this.ikB = (String) dVar.get(1);
                }
                if (z) {
                    AAQueryListUI.this.ikv.WY();
                }
                b f = AAQueryListUI.this.ikv;
                x.i("MicroMsg.AAQueryListAdapter", "addNewRecord: %s", list);
                if (list != null && list.size() > 0) {
                    x.i("MicroMsg.AAQueryListAdapter", "addNewRecord size: %s", Integer.valueOf(list.size()));
                    f.dataList.addAll(list);
                    f.notifyDataSetChanged();
                }
                if (AAQueryListUI.this.ikw != null) {
                    AAQueryListUI.this.ikw.dismiss();
                    AAQueryListUI.this.ikw = null;
                }
                if (AAQueryListUI.this.iku.getVisibility() != 0) {
                    AAQueryListUI.this.iku.setVisibility(0);
                }
                AAQueryListUI.this.ikx = false;
                if (!((Boolean) dVar.get(2)).booleanValue()) {
                    AAQueryListUI.this.iky = true;
                }
                if (AAQueryListUI.this.iku.getFooterViewsCount() > 0) {
                    AAQueryListUI.this.iku.removeFooterView(AAQueryListUI.this.ikz);
                }
                if (AAQueryListUI.this.iky) {
                    AAQueryListUI.k(AAQueryListUI.this);
                    if (AAQueryListUI.this.ikA.getVisibility() == 0) {
                        AAQueryListUI.this.iku.addFooterView(AAQueryListUI.this.ikA, null, false);
                    }
                }
                return zLb;
            }
        }).a(new com.tencent.mm.vending.g.d.a() {
            public final void aW(Object obj) {
                x.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", obj);
                if (AAQueryListUI.this.ikw != null) {
                    AAQueryListUI.this.ikw.dismiss();
                    AAQueryListUI.this.ikw = null;
                }
                AAQueryListUI.this.ikx = false;
                if (AAQueryListUI.this.iku.getFooterViewsCount() > 0) {
                    AAQueryListUI.this.iku.removeFooterView(AAQueryListUI.this.ikz);
                }
                if (obj instanceof String) {
                    Toast.makeText(AAQueryListUI.this, obj.toString(), 1).show();
                } else {
                    Toast.makeText(AAQueryListUI.this, i.uPO, 1).show();
                }
            }
        });
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uHt;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("close_aa", false);
            int intExtra = intent.getIntExtra("item_position", 0);
            int intExtra2 = intent.getIntExtra("item_offset", 0);
            if (booleanExtra) {
                this.iku.setSelectionFromTop(intExtra, intExtra2);
                d(true, this.mode);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
