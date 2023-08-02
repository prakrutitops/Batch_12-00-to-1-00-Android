package com.example.realmdb

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyRealmConfiguration : Application()
{
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        var config = RealmConfiguration.Builder()
            .name("tops.db")
            .deleteRealmIfMigrationNeeded()
            .schemaVersion(1)
            .build()

        Realm.setDefaultConfiguration(config)

    }

}