package com.tencent.mm.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.remoteservice.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Constructor;

public class RemoteService extends Service {
    private a xjx = new a() {
        public final void a(String str, String str2, Bundle bundle, b bVar) {
            try {
                a aVar;
                Class loadClass = RemoteService.this.getClassLoader().loadClass(str);
                Constructor[] constructors = loadClass.getConstructors();
                if (constructors.length > 0) {
                    Object[] objArr = new Object[constructors[0].getParameterTypes().length];
                    objArr[0] = null;
                    aVar = (a) constructors[0].newInstance(objArr);
                } else {
                    aVar = (a) loadClass.newInstance();
                }
                aVar.xju = bVar;
                aVar.xjt = RemoteService.this;
                aVar.onCallback(str2, bundle, false);
            } catch (Throwable e) {
                x.e("MicroMsg.RemoveService", "exception:%s", bi.i(e));
            }
        }
    };

    public IBinder onBind(Intent intent) {
        new StringBuilder("onBind, threadId:").append(Thread.currentThread().getId());
        return this.xjx;
    }

    public void onRebind(Intent intent) {
        new StringBuilder("onRebind, threadId:").append(Thread.currentThread().getId());
        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        new StringBuilder("onUnbind, threadId:").append(Thread.currentThread().getId());
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        new StringBuilder("onDestroy, threadId:").append(Thread.currentThread().getId());
        super.onDestroy();
    }
}
