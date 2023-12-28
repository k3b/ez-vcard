package ezvcard.property;

import ezvcard.parameter.VCardParameters;

public interface IIndex {
    /**
     * <p>
     * Gets the sorted position of this property when it is grouped together
     * with other properties of the same type. Properties with low index values
     * are put at the beginning of the sorted list. Properties with high index
     * values are put at the end of the list.
     * </p>
     * <p>
     * <b>Supported versions:</b> {@code 4.0}
     * </p>
     *
     * @return the index or null if not set
     * @throws IllegalStateException if the parameter value cannot be parsed as
     *                               an integer. If this happens, you may use the
     *                               {@link VCardParameters#first(String)} method to retrieve its raw value.
     * @see <a href="https://tools.ietf.org/html/rfc6715#page-7">RFC 6715
     * p.7</a>
     */
    default Integer getIndex() {
        return ((VCardProperty) this).parameters.getIndex();
    }

    /**
     * <p>
     * Sets the sorted position of this property when it is grouped together
     * with other properties of the same type. Properties with low index values
     * are put at the beginning of the sorted list. Properties with high index
     * values are put at the end of the list.
     * </p>
     * <p>
     * <b>Supported versions:</b> {@code 4.0}
     * </p>
     *
     * @param index the index or null to remove
     * @throws IllegalStateException if the parameter value is malformed and
     *                               cannot be parsed. If this happens, you may use the
     *                               {@link VCardParameters#first(String)} method to retrieve its raw value.
     * @see <a href="https://tools.ietf.org/html/rfc6715#page-7">RFC 6715
     * p.7</a>
     */
    default void setIndex(Integer index) {
        ((VCardProperty) this).parameters.setIndex(index);
    }
}
