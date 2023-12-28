package ezvcard.property;

import java.util.List;

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
 * Defines the person's full name in a human-readable format.
 * </p>
 * 
 * <p>
 * <b>Code sample</b>
 * </p>
 * 
 * <pre class="brush:java">
 * VCard vcard = new VCard();
 * 
 * FormattedName fn = new FormattedName("Dr. Gregory House M.D.");
 * vcard.setFormattedName(fn);
 * </pre>
 * 
 * <p>
 * <b>Property name:</b> {@code FN}
 * </p>
 * <p>
 * <b>Supported versions:</b> {@code 2.1, 3.0, 4.0}
 * </p>
 * @author Michael Angstadt
 * @see <a href="http://tools.ietf.org/html/rfc6350#page-28">RFC 6350 p.28</a>
 * @see <a href="http://tools.ietf.org/html/rfc2426#page-8">RFC 2426 p.8</a>
 * @see <a href="http://www.imc.org/pdi/vcard-21.doc">vCard 2.1 p.9</a>
 */
public class FormattedName extends TextProperty
		implements HasAltId, IPref, IV4Type {
	/**
	 * Creates a formatted name property.
	 * @param name the person's name (e.g. "John Doe")
	 */
	public FormattedName(String name) {
		super(name);
	}

	/**
	 * Copy constructor.
	 * @param original the property to make a copy of
	 */
	public FormattedName(FormattedName original) {
		super(original);
	}

	@Override
	public String getLanguage() {
		return super.getLanguage();
	}

	@Override
	public void setLanguage(String language) {
		super.setLanguage(language);
	}

	@Override
	public List<Pid> getPids() {
		return super.getPids();
	}

	@Override
	public FormattedName copy() {
		return new FormattedName(this);
	}
}
