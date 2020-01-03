package com.example.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyBinder();
    }

    class MyBinder extends MyAIDLService.Stub {

        @Override
        public String getString() throws RemoteException {
            return "我是从服务器返回的";
        }
    }
}
