package me.sdkssh.gitprofilemanager.wrapper;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import me.sdkssh.gitprofilemanager.persistents.ProfileSettings;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileWrapper extends DialogWrapper {
    private final JPanel panel = new JPanel(new GridBagLayout());
    private final List<JButton> buttons = new ArrayList<>();
    private Map<String, String> profiles;
    private String choosenprofile;

    protected ProfileWrapper(@Nullable Project project) {
        super(project);
    }

    @Override
    protected void init() {
        setTitle("Git Profile Choose");
        Map<String, String> profiles = ProfileSettings.getInstance().getState().accounts;
        this.profiles = profiles;
        if(!profiles.isEmpty()){
            profiles.entrySet().forEach((v) -> {
                JButton button = new JButton();
                button.setText(v.getValue());
                button.addActionListener(actionEvent -> {
                    choosenprofile = v.getKey();
                });
                buttons.add(button);
            });
        }
        super.init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        return panel;
    }
}
