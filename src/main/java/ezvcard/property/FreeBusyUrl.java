package ezvcard.property;

import ezvcard.SupportedVersions;
import ezvcard.VCardVersion;

/*
 Copyright (c) 2012-2023, Michael Angstadt
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met: 

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer. 
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

 The views and conclusions contained in the software and documentation are those
 of the authors and should not be interpreted as representing official policies, 
 either expressed or implied, of the FreeBSD Project.
 */

/**
 * <p>
 * Defines a URL that shows when the person is free/busy on their calendar.
 * </p>
 * 
 * <p>
 * <b>Code sample</b>
 * </p>
 * 
 * <pre class="brush:java">
 * VCard vcard = new VCard();
 * 
 * FreeBusyUrl fburl = new FreeBusyUrl("http://www.example.com/freebusy/janedoe");
 * vcard.addFbUrl(fburl);
 * </pre>
 * 
 * <p>
 * <b>Property name:</b> {@code FBURL}
 * </p>
 * <p>
 * <b>Supported versions:</b> {@code 4.0}
 * </p>
 * @author Michael Angstadt
 * @see <a href="http://tools.ietf.org/html/rfc6350#page-49">RFC 6350 p.49</a>
 */
@SupportedVersions(VCardVersion.V4_0)
public class FreeBusyUrl extends UriProperty
        implements HasAltId, IPref, IV4Type, IV4Pids, IV4MediaType {
    /**
     * Creates a free/busy URL property.
     *
     * @param uri the URI
     */
    public FreeBusyUrl(String uri) {
        super(uri);
    }

    /**
	 * Copy constructor.
	 * @param original the property to make a copy of
	 */
	public FreeBusyUrl(FreeBusyUrl original) {
		super(original);
	}

	@Override
	public FreeBusyUrl copy() {
		return new FreeBusyUrl(this);
	}
}
