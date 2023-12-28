package ezvcard.property;

import java.util.List;

import ezvcard.parameter.Pid;

public interface IV4Pids {
    /**
     * <p>
     * Gets the list that stores this property's PID (property ID) parameter
     * values.
     * </p>
     * <p>
     * PIDs can exist on any property where multiple instances are allowed (such
     * as {@link Email} or {@link Address}, but not {@link StructuredName}
     * because only 1 instance of this property is allowed per vCard).
     * </p>
     * <p>
     * When used in conjunction with the {@link ClientPidMap} property, it
     * allows an individual property instance to be uniquely identifiable. This
     * feature is made use of when two different versions of the same vCard have
     * to be merged together (called "synchronizing").
     * </p>
     * <p>
     * <b>Supported versions:</b> {@code 4.0}
     * </p>
     *
     * @return the PID parameter values (this list is mutable)
     * @throws IllegalStateException if one or more parameter values cannot be
     *                               parsed as PIDs. If this happens, you may use the
     *                               {@link VCardProperty#getParameters(String)} method to retrieve the raw values.
     * @see <a href="http://tools.ietf.org/html/rfc6350#page-19">RFC 6350
     * p.19</a>
     */
    default List<Pid> getPids() {
        return ((VCardProperty) this).parameters.getPids();
    }
}
