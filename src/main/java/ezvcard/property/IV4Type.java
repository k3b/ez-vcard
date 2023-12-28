package ezvcard.property;

public interface IV4Type {
    /**
     * Gets the vCard 4.0 TYPE parameter. This should NOT be used to get the
     * TYPE parameter for 2.1/3.0 vCards. Use {@link ezvcard.util.DataUri#getContentType()} instead.
     * <p>
     * <b>Supported versions:</b> {@code 4.0}
     * </p>
     *
     * @return the TYPE value (typically, this will be either "work" or "home")
     * or null if it doesn't exist
     */
    default String getType() {
        return ((VCardProperty) this).parameters.getType();
    }

    /**
     * Sets the vCard 4.0 TYPE parameter. This should NOT be used to set the
     * TYPE parameter for 2.1/3.0 vCards. Use {@link BinaryProperty#setContentType} instead.
     * <p>
     * <b>Supported versions:</b> {@code 4.0}
     * </p>
     *
     * @param type the TYPE value (should be either "work" or "home") or null to
     *             remove
     */
    default void setType(String type) {
        ((VCardProperty) this).parameters.setType(type);
    }
}
