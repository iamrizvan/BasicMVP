package work.andrd.com.savedjobmvp.savedjob;


import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class SavedJobModule {

    @Singleton
    @Provides
 SavedJobPresenter providePresenter()
 {
       return  new SavedJobPresenter();
 }
}
