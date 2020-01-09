package com.example.android.androidadvanceddemo.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.example.android.androidadvanceddemo.R;
import com.example.android.androidadvanceddemo.databinding.ActivityHandlerBinding;

import java.lang.ref.WeakReference;

public class HandlerActivity extends AppCompatActivity {

    ActivityHandlerBinding binding;

    Handler handler1 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    binding.textView.setText("Thread1改变了UI线程");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_handler);
        Thread1 thread1 = new Thread1(HandlerActivity.this);
        binding.startThread1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread1.start();
            }
        });
        Thread2 thread = new Thread2();
        thread.start();
        binding.button4.setOnClickListener(view -> {
            thread.getHandler().sendEmptyMessage(1);
        });
        binding.button5.setOnClickListener(view -> {
            System.out.println("hl------isAlive1=" + thread.isAlive());
            System.out.println("hl------isAlive2=" + thread1.isAlive());
        });

        //子线程发送消息到子线程
        Thread03 thread03 = new Thread03();
        binding.button6.setOnClickListener(view -> {
            if (thread03.getLooper() != null) {
                new Thread04(thread03.getHandler()).start();
            }
        });

        binding.button7.setOnClickListener(view -> {
            thread03.start();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler1.removeCallbacksAndMessages(null);
    }

    static class Thread1 extends Thread {
        private WeakReference<Activity> activityWeakReference;

        public Thread1(Activity activity) {
            this.activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            super.run();
            try {
                Thread.sleep(5000);//模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ((HandlerActivity) activityWeakReference.get()).handler1.sendEmptyMessage(1);
        }
    }

    static class Thread2 extends Thread {
        Handler handler;

        public Handler getHandler() {
            return handler;
        }

        @Override
        public void run() {
            super.run();
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what) {
                        case 1:
                            System.out.println("hl-----子线程收到来自主线程的消息");
                            break;
                        default:
                            break;
                    }
                }
            };
            Looper.loop();
        }
    }

    static class Thread03 extends Thread {
        Handler handler;
        Looper looper;

        public Handler getHandler() {
            return handler;
        }

        public Looper getLooper() {
            return looper;
        }

        @Override
        public void run() {
            Looper.prepare();
            looper = Looper.myLooper();
            handler = new Handler(){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what) {
                        case 1:
                            System.out.println("hl-----子线程收到来自子线程2的消息");
                            break;
                        default:
                            break;
                    }
                }
            };
            Looper.loop();
        }
    }

    static class Thread04 extends Thread {
        Handler handler;

        public Thread04(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void run() {
            super.run();
            handler.sendEmptyMessage(1);
        }
    }
}
