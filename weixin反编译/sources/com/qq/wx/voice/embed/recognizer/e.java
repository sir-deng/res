package com.qq.wx.voice.embed.recognizer;

public final class e {
    public Grammar bgt;
    g bgu;
    byte[] c;
    public boolean d;
    public boolean e;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            if (e.this.bgt.begin() != 0) {
                e.this.bgu.a(-102);
            } else if (e.this.bgt.recognize(e.this.c, e.this.c.length) != 0) {
                e.this.bgu.a(-103);
            } else if (e.this.bgt.end() != 0) {
                e.this.bgu.a(-104);
            } else {
                a aVar = new a();
                if (e.this.bgt.getResult(aVar) != 0) {
                    e.this.bgu.a(-105);
                }
                g gVar = e.this.bgu;
                gVar.b.sendMessage(gVar.b.obtainMessage(200, aVar));
            }
        }
    }

    public e() {
        this.bgt = null;
        this.bgu = new g();
        this.c = null;
        this.d = false;
        this.e = false;
        this.bgt = new Grammar();
    }

    public final int a(c cVar, byte[] bArr) {
        if (!this.d) {
            return -304;
        }
        if (!this.e) {
            return -302;
        }
        this.bgu.bgv = cVar;
        this.c = bArr;
        if (this.c == null) {
            return -301;
        }
        try {
            new Thread(new a()).start();
            return 0;
        } catch (Exception e) {
            return -302;
        }
    }
}
