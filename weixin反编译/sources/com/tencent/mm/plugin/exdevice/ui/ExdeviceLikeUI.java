package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.y.r;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI extends MMActivity {
    private String mAppName;
    private ArrayList<e> mai;
    private boolean maj;
    private ListView mak;
    private a mal;
    private final int mam = 30;

    class a extends BaseAdapter {

        class a {
            ImageView ikl;
            TextView ipk;
            NoMeasuredTextView mao;
            TextView maq;

            a() {
            }
        }

        a() {
        }

        public final int getCount() {
            return ExdeviceLikeUI.this.mai == null ? 0 : ExdeviceLikeUI.this.mai.size();
        }

        public final Object getItem(int i) {
            return ExdeviceLikeUI.this.mai.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            a aVar;
            e eVar = (e) ExdeviceLikeUI.this.mai.get(i);
            if (view == null) {
                if (ExdeviceLikeUI.this.maj) {
                    inflate = LayoutInflater.from(ExdeviceLikeUI.this).inflate(R.i.dgS, viewGroup, false);
                } else {
                    inflate = LayoutInflater.from(ExdeviceLikeUI.this).inflate(R.i.dgR, viewGroup, false);
                }
                a aVar2 = new a();
                aVar2.ikl = (ImageView) inflate.findViewById(R.h.ceW);
                aVar2.mao = (NoMeasuredTextView) inflate.findViewById(R.h.cfI);
                aVar2.ipk = (TextView) inflate.findViewById(R.h.cfB);
                aVar2.maq = (TextView) inflate.findViewById(R.h.cfA);
                aVar2.mao.O(ExdeviceLikeUI.this.getResources().getDimension(R.f.bvL));
                aVar2.mao.setTextColor(ExdeviceLikeUI.this.getResources().getColor(R.e.black));
                aVar2.mao.cqk();
                aVar2.mao.yoG = true;
                inflate.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                inflate = view;
            }
            b.p(aVar.ikl, eVar.field_username);
            aVar.mao.setText(i.b(ExdeviceLikeUI.this, r.gw(eVar.field_username), aVar.mao.gu.getTextSize()));
            if (!bi.oN(eVar.field_liketips) && aVar.ipk != null) {
                aVar.ipk.setVisibility(0);
                aVar.ipk.setText(eVar.field_liketips);
            } else if (aVar.ipk != null) {
                aVar.ipk.setVisibility(8);
            }
            if (((int) ((((System.currentTimeMillis() / 1000) - ((long) eVar.field_timestamp)) / 60) + 1)) <= 30) {
                aVar.maq.setText(ExdeviceLikeUI.this.getString(R.l.edw, new Object[]{Integer.valueOf(r3)}));
            } else {
                aVar.maq.setText(n.c(ExdeviceLikeUI.this, ((long) eVar.field_timestamp) * 1000, true));
            }
            return inflate;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAppName = getIntent().getStringExtra("app_username");
        String stringExtra = getIntent().getStringExtra("key_rank_info");
        String stringExtra2 = getIntent().getStringExtra("key_rank_semi");
        this.maj = getIntent().getBooleanExtra("key_is_like_read_only", false);
        if (bi.oN(stringExtra)) {
            stringExtra2 = getIntent().getStringExtra("rank_id");
            Assert.assertTrue(!bi.oN(stringExtra2));
            this.mai = ad.aEW().zJ(stringExtra2);
        } else {
            ArrayList arrayList;
            String str = this.mAppName;
            x.d("MicroMsg.ExdeviceMsgXmlParser", stringExtra);
            if (bi.oN(stringExtra)) {
                x.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
            } else {
                com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(stringExtra, stringExtra2);
                if (I != null) {
                    Map map = I.hcK;
                    ArrayList arrayList2 = new ArrayList();
                    if (!(map == null || map.isEmpty())) {
                        int i = 0;
                        while (true) {
                            stringExtra = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                            if (bi.oN(stringExtra)) {
                                break;
                            }
                            stringExtra2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".rankid");
                            String str2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".liketip");
                            String str3 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".timestamp");
                            e eVar = new e();
                            eVar.field_appusername = str;
                            eVar.field_rankID = stringExtra2;
                            eVar.field_username = stringExtra;
                            eVar.field_timestamp = bi.getInt(str3, 0);
                            eVar.field_liketips = str2;
                            arrayList2.add(eVar);
                            i++;
                        }
                        x.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", Integer.valueOf(i));
                        arrayList = arrayList2;
                        this.mai = arrayList;
                    }
                }
            }
            arrayList = null;
            this.mai = arrayList;
        }
        this.mak = (ListView) findViewById(R.h.cff);
        this.mak.setEmptyView(findViewById(R.h.empty));
        this.mal = new a();
        this.mak.setAdapter(this.mal);
        if (!this.maj) {
            this.mak.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    e eVar = (e) ExdeviceLikeUI.this.mal.getItem(i);
                    Intent intent = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", eVar.field_appusername);
                    intent.putExtra("rank_id", eVar.field_rankID);
                    intent.putExtra("device_type", 1);
                    ExdeviceLikeUI.this.startActivity(intent);
                    ExdeviceLikeUI.this.finish();
                }
            });
        }
        setMMTitle(R.l.edx);
        if (!this.maj) {
            addTextOptionMenu(0, getString(R.l.edv), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", ExdeviceLikeUI.this.mAppName);
                    intent.putExtra("rank_id", "#");
                    intent.putExtra("key_is_latest", true);
                    intent.putExtra("device_type", 1);
                    ExdeviceLikeUI.this.startActivity(intent);
                    ExdeviceLikeUI.this.finish();
                    return false;
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExdeviceLikeUI.this.finish();
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dgT;
    }
}
