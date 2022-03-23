package me.sdkssh.gitprofilemanager.persistents;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import me.sdkssh.gitprofilemanager.persistents.state.ProfileState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "GitProfileManager",
        storages = @Storage(value = "gitprofilemanager.xml")
)
public class ProfileSettings implements PersistentStateComponent<ProfileState> {

    private ProfileState pluginState;

    @Override
    public @Nullable ProfileState getState() {
        return pluginState;
    }

    @Override
    public void loadState(@NotNull ProfileState state) {
        pluginState = state;
    }

    public static ProfileSettings getInstance(){
        return ServiceManager.getService(ProfileSettings.class);
    }
}
