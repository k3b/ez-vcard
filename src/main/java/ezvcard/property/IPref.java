package ezvcard.property;

/**
 * Default implementation for {@link #getPref()} and {@link #setPref(Integer)} which affectes
 * the property's preference value.
 */
public interface IPref {
    /**
     * <p>
     * Gets this property's preference value. The lower this number is, the more
     * "preferred" the property instance is compared with other properties of
     * the same type. If a property doesn't have a preference value, then it is
     * considered the least preferred.
     * </p>
     * <p>
     * In the vCard below, the {@link Address} on the second row is the most
     * preferred because it has the lowest PREF value.
     * </p>
     *
     * <pre>
     * ADR;TYPE=work;PREF=2:;;1600 Amphitheatre Parkway;Mountain View;CA;94043
     * ADR;TYPE=work;PREF=1:;;One Microsoft Way;Redmond;WA;98052
     * ADR;TYPE=home:;;123 Maple St;Hometown;KS;12345
     * </pre>
     *
     * <p>
     * <b>Supported versions:</b> {@code 4.0}
     * </p>
     *
     * @return the preference value or null if not set
     * @throws IllegalStateException if the parameter value cannot be parsed as
     *                               an integer. If this happens, you may use the
     *                               {@link VCardProperty#getParameter(String)} method to retrieve its raw value.
     * @see <a href="http://tools.ietf.org/html/rfc6350#page-17">RFC 6350
     * p.17</a>
     */
    default Integer getPref() {
        return ((VCardProperty) this).parameters.getPref();
    }

    /**
     * <p>
     * Sets this property's preference value. The lower this number is, the more
     * "preferred" the property instance is compared with other properties of
     * the same type. If a property doesn't have a preference value, then it is
     * considered the least preferred.
     * </p>
     * <p>
     * In the vCard below, the {@link Address} on the second row is the most
     * preferred because it has the lowest PREF value.
     * </p>
     *
     * <pre>
     * ADR;TYPE=work;PREF=2:;;1600 Amphitheatre Parkway;Mountain View;CA;94043
     * ADR;TYPE=work;PREF=1:;;One Microsoft Way;Redmond;WA;98052
     * ADR;TYPE=home:;;123 Maple St;Hometown;KS;12345
     * </pre>
     *
     * <p>
     * <b>Supported versions:</b> {@code 4.0}
     * </p>
     *
     * @param pref the preference value or null to remove
     * @see <a href="http://tools.ietf.org/html/rfc6350#page-17">RFC 6350
     * p.17</a>
     */
    default <T extends VCardProperty> T setPref(Integer pref) {
        ((VCardProperty) this).parameters.setPref(pref);
        return (T) this;
    }
}
