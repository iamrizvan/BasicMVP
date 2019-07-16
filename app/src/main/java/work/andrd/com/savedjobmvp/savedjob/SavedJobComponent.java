package work.andrd.com.savedjobmvp.savedjob;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = SavedJobModule.class)
public interface SavedJobComponent {
    void inject(MainActivity mainActivity);
}
