package com.example.fakestore.core

import android.app.Application

class FakeApiApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DefaultApiClient.init()
    }
}