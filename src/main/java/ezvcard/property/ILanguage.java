package ezvcard.property;

public interface ILanguage {
    /**
     * Gets the language that the property value is written in.
     * @return the language or null if not set
     */
    default String getLanguage() {
        return ((VCardProperty) this).parameters.getLanguage();
    }

    /**
     * Sets the language that the property value is written in.
     * @param language the language or null to remove
     */
    default void setLanguage(String language) {
        ((VCardProperty) this).parameters.setLanguage(language);
    }
}
