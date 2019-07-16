package work.andrd.com.savedjobmvp;

import android.app.Application;

import work.andrd.com.savedjobmvp.savedjob.DaggerSavedJobComponent;
import work.andrd.com.savedjobmvp.savedjob.SavedJobComponent;
import work.andrd.com.savedjobmvp.savedjob.SavedJobModule;


public class App extends Application {

    private static App app;
    private SavedJobComponent savedJobComponent;

    // on create method
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        savedJobComponent = DaggerSavedJobComponent.builder()
                .savedJobModule(new SavedJobModule())
                .build();
    }

    // Getters
    public SavedJobComponent getSavedAppComponent() {
        return this.savedJobComponent;
    }
    public static App getApp() {
        return app;
    }

}
