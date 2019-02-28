package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost {
    private ArrayList<a> _sessionInfoList = new ArrayList();
    private ReentrantLock mLock = new ReentrantLock();

    public class a {
        public long a;
    }

    public a find(long j) {
        a aVar;
        this.mLock.lock();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this._sessionInfoList.size()) {
                aVar = null;
                break;
            }
            aVar = (a) this._sessionInfoList.get(i2);
            if (aVar.a == j) {
                break;
            }
            i = i2 + 1;
        }
        this.mLock.unlock();
        return aVar;
    }

    public void add(long j, Context context) {
        if (find(j) == null) {
            a aVar = new a();
            aVar.a = j;
            this.mLock.lock();
            this._sessionInfoList.add(aVar);
            this.mLock.unlock();
        }
    }

    public void remove(long j) {
        this.mLock.lock();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this._sessionInfoList.size()) {
                break;
            } else if (((a) this._sessionInfoList.get(i2)).a == j) {
                this._sessionInfoList.remove(i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        this.mLock.unlock();
    }
}
