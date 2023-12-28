package ezvcard.property;

import java.util.List;

import ezvcard.SupportedVersions;
import ezvcard.VCardVersion;
import ezvcard.parameter.Pid;

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
 * Defines a language that the person speaks.
 * </p>
 * 
 * <p>
 * <b>Code sample</b>
 * </p>
 * 
 * <pre class="brush:java">
 * VCard vcard = new VCard();
 * 
 * Language lang = new Language("en");
 * lang.setPref(1); //most preferred
 * vcard.addLanguage(lang);
 * 
 * lang = new Language("fr");
 * lang.setPref(2); //second-most preferred
 * vcard.addLanguage(lang);
 * </pre>
 * 
 * <p>
 * <b>Property name:</b> {@code LANG}
 * </p>
 * <p>
 * <b>Supported versions:</b> {@code 4.0}
 * </p>
 * 
 * @author Michael Angstadt
 * @see <a href="http://tools.ietf.org/html/rfc6350#page-37">RFC 6350 p.37</a>
 */
@SupportedVersions(VCardVersion.V4_0)
public class Language extends TextProperty
		implements HasAltId, IPref, IV4Type {
	/**
	 * Creates a language property.
	 * @param language the language (e.g. "en-ca")
	 */
	public Language(String language) {
		super(language);
	}

	/**
	 * Copy constructor.
	 * @param original the property to make a copy of
	 */
	public Language(Language original) {
		super(original);
	}

	@Override
	public List<Pid> getPids() {
		return super.getPids();
	}

	@Override
	public Language copy() {
		return new Language(this);
	}
}
