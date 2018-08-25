package lokovsek.example.jure_lokovsek.simplechecklist;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Jure_Lokovsek on 26. 03. 2018.
 */

public class MyRealmApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().name("checklist.realm").schemaVersion(0).build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
