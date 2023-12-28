package ezvcard.property;

public interface IV4MediaType {

    /**
     * Gets the MEDIATYPE parameter.
     * <p>
     * <b>Supported versions:</b> {@code 4.0}
     * </p>
     *
     * @return the media type or null if not set
     */
    default String getMediaType() {
        return ((VCardProperty) this).parameters.getMediaType();
    }

    /**
     * Sets the MEDIATYPE parameter.
     * <p>
     * <b>Supported versions:</b> {@code 4.0}
     * </p>
     *
     * @param mediaType the media type or null to remove
     */
    default void setMediaType(String mediaType) {
        ((VCardProperty) this).parameters.setMediaType(mediaType);
    }
}
