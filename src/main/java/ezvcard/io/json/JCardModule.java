package ezvcard.io.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.io.scribe.ScribeIndex;
import ezvcard.io.scribe.VCardPropertyScribe;
import ezvcard.property.ProductId;
import ezvcard.property.VCardProperty;

/*
 Copyright (c) 2012-2021, Michael Angstadt
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
 * Module for jackson-databind that serializes and deserializes jCards.
 * </p>
 * <p>
 * <b>Example:</b>
 * </p>
 * 
 * <pre class="brush:java">
 * ObjectMapper mapper = new ObjectMapper();
 * mapper.registerModule(new JCardModule());
 * VCard result = mapper.readValue(..., VCard.class);
 * </pre>
 * @author Buddy Gorven
 */
public class JCardModule extends SimpleModule {
	private static final long serialVersionUID = 6545279961222677077L;
	private static final String MODULE_NAME = "ez-vcard-jcard";
	private static final Version MODULE_VERSION = moduleVersion();

	private final JCardDeserializer deserializer = new JCardDeserializer();
	private final JCardSerializer serializer = new JCardSerializer();

	private ScribeIndex index;

	/**
	 * Creates the module.
	 */
	public JCardModule() {
		super(MODULE_NAME, MODULE_VERSION);

		setScribeIndex(new ScribeIndex());
		addSerializer(serializer);
		addDeserializer(VCard.class, deserializer);
	}

	private static Version moduleVersion() {
		String[] split = Ezvcard.VERSION.split("[.-]");
		if (split.length < 3) {
			/*
			 * This can happen during development if the "ez-vcard.properties"
			 * file has not been filtered by Maven.
			 */
			return new Version(0, 0, 0, "", Ezvcard.GROUP_ID, Ezvcard.ARTIFACT_ID);
		}

		int major = Integer.parseInt(split[0]);
		int minor = Integer.parseInt(split[1]);
		int patch = Integer.parseInt(split[2]);
		String snapshot = (split.length > 3) ? split[3] : "RELEASE";

		return new Version(major, minor, patch, snapshot, Ezvcard.GROUP_ID, Ezvcard.ARTIFACT_ID);
	}

	/**
	 * Gets whether a {@link ProductId} property will be added to each
	 * serialized vCard that marks it as having been generated by this library.
	 * @return true if the property will be added, false if not (defaults to
	 * true)
	 */
	public boolean isAddProdId() {
		return serializer.isAddProdId();
	}

	/**
	 * Sets whether to add a {@link ProductId} property to each serialized vCard
	 * that marks it as having been generated by this library.
	 * @param addProdId true to add the property, false not to (defaults to
	 * true)
	 */
	public void setAddProdId(boolean addProdId) {
		serializer.setAddProdId(addProdId);
	}

	/**
	 * Gets whether properties that do not support jCard will be excluded from
	 * each serialized vCard. jCard only supports properties defined in the
	 * vCard version 4.0 specification.
	 * @return true if the properties will be excluded, false if not (defaults
	 * to true)
	 */
	public boolean isVersionStrict() {
		return serializer.isVersionStrict();
	}

	/**
	 * Sets whether properties that do not support jCard will be excluded from
	 * each serialized vCard. jCard only supports properties defined in the
	 * vCard version 4.0 specification.
	 * @param versionStrict true to exclude such properties, false not to
	 * (defaults to true)
	 */
	public void setVersionStrict(boolean versionStrict) {
		serializer.setVersionStrict(versionStrict);
	}

	/**
	 * <p>
	 * Registers a property scribe. This is the same as calling:
	 * </p>
	 * <p>
	 * {@code getScribeIndex().register(scribe)}
	 * </p>
	 * @param scribe the scribe to register
	 */
	public void registerScribe(VCardPropertyScribe<? extends VCardProperty> scribe) {
		index.register(scribe);
	}

	/**
	 * Gets the scribe index used by the serializer and deserializer.
	 * @return the scribe index
	 */
	public ScribeIndex getScribeIndex() {
		return index;
	}

	/**
	 * Sets the scribe index for the serializer and deserializer to use.
	 * @param index the scribe index
	 */
	public void setScribeIndex(ScribeIndex index) {
		this.index = index;
		serializer.setScribeIndex(index);
		deserializer.setScribeIndex(index);
	}
}
