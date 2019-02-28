package com.tencent.mm.pluginsdk.cmd;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecoveryConsoleUI extends MMActivity implements OnItemClickListener {
    List<Map<String, String>> lzC;
    ListView phN;
    List<a> vjp;
    SimpleAdapter vjq;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Recovery Console");
        this.vjp = b.bYV();
        this.lzC = new ArrayList(this.vjp.size());
        for (a aVar : this.vjp) {
            HashMap hashMap = new HashMap();
            hashMap.put("title", getString(aVar.vju));
            this.lzC.add(hashMap);
        }
        this.vjq = new SimpleAdapter(this, this.lzC, f.dnz, new String[]{"title"}, new int[]{16908310});
        this.phN = (ListView) findViewById(16908298);
        this.phN.setAdapter(this.vjq);
        this.phN.setOnItemClickListener(this);
    }

    protected final int getLayoutId() {
        return f.cws;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = (a) this.vjp.get(i);
        if (aVar.vjv != null) {
            aVar.vjv.a(this, aVar.fNi.split(" +"));
        } else {
            b.aU(this, aVar.fNi);
        }
    }
}
