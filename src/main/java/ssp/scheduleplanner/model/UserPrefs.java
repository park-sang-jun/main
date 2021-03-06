package ssp.scheduleplanner.model;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import ssp.scheduleplanner.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs {

    private GuiSettings guiSettings;
    //private Path schedulePlannerFilePath = Paths.get("data" , "addressbook.xml");
    private Path schedulePlannerFilePath = Paths.get("scheduleplanner.xml");

    public UserPrefs() {
        setGuiSettings(1000, 700, 0, 0);
    }

    public GuiSettings getGuiSettings() {
        return guiSettings == null ? new GuiSettings() : guiSettings;
    }

    public void updateLastUsedGuiSetting(GuiSettings guiSettings) {
        this.guiSettings = guiSettings;
    }

    public void setGuiSettings(double width, double height, int x, int y) {
        guiSettings = new GuiSettings(width, height, x, y);
    }

    public Path getSchedulePlannerFilePath() {
        return schedulePlannerFilePath;
    }

    public void setSchedulePlannerFilePath(Path schedulePlannerFilePath) {
        this.schedulePlannerFilePath = schedulePlannerFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return Objects.equals(guiSettings, o.guiSettings)
                && Objects.equals(schedulePlannerFilePath, o.schedulePlannerFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, schedulePlannerFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings.toString());
        sb.append("\nLocal data file location : " + schedulePlannerFilePath);
        return sb.toString();
    }

}
