package ezvcard.util;

import static ezvcard.util.StringUtils.NEWLINE;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import ezvcard.VCard;
import ezvcard.parameter.AddressType;
import ezvcard.parameter.EmailType;
import ezvcard.parameter.ExpertiseLevel;
import ezvcard.parameter.HobbyLevel;
import ezvcard.parameter.InterestLevel;
import ezvcard.parameter.TelephoneType;
import ezvcard.property.Address;
import ezvcard.property.Birthday;
import ezvcard.property.Birthplace;
import ezvcard.property.CalendarRequestUri;
import ezvcard.property.CalendarUri;
import ezvcard.property.Deathdate;
import ezvcard.property.Deathplace;
import ezvcard.property.Expertise;
import ezvcard.property.Hobby;
import ezvcard.property.Impp;
import ezvcard.property.Interest;
import ezvcard.property.OrgDirectory;
import ezvcard.property.Revision;
import ezvcard.property.StructuredName;
import ezvcard.property.Telephone;
import ezvcard.property.Timezone;
import ezvcard.property.Uid;

public class VCardUtils {

    /**
     * Creates a demo VCard where every property (except media Photo and Sound) has some value
     *
     * @return generated VCard
     */
    public static VCard createFullDemoVCard() {
        VCard vcard = new VCard();

        StructuredName n = new StructuredName();
        n.setFamily("Claus");
        n.setGiven("Santa");
        n.getAdditionalNames().add("Saint Nicholas");
        n.getAdditionalNames().add("Father Christmas");
        n.getPrefixes().add("Mr");
        n.getPrefixes().add("Dr");
        n.getSuffixes().add("M.D.");
        n.setSortAs("Claus");
        vcard.setStructuredName(n);

        vcard.setClassification("public");

        vcard.setMailer("Thunderbird");

        vcard.setFormattedName("Santa Claus");

        vcard.setNickname("Kris Kringle");

        vcard.addTitle("Manager");

        vcard.addRole("Executive");
        vcard.addRole("Team Builder");

        vcard.addEmail("johndoe@hotmail.com", EmailType.HOME, EmailType.WORK);

        vcard.addEmail("doe.john@company.com", EmailType.WORK);

        Telephone tel = new Telephone(new TelUri.Builder("+1-555-222-3333").extension("101").build());
        vcard.addTelephoneNumber(tel);

        tel = new Telephone(new TelUri.Builder("+1-555-333-4444").build());
        tel.getTypes().add(TelephoneType.WORK);
        vcard.addTelephoneNumber(tel);

        vcard.addTelephoneNumber("(555) 111-2222", TelephoneType.HOME, TelephoneType.VOICE, TelephoneType.PREF);

        Address adr = new Address();
        adr.setStreetAddress("123 Main St");
        adr.setExtendedAddress("Apt 11");
        adr.setLocality("Austin");
        adr.setRegion("Tx");
        adr.setPostalCode("12345");
        adr.setCountry("USA");
        adr.setLabel("123 Main St." + NEWLINE + "Austin TX, 12345" + NEWLINE + "USA");
        adr.getTypes().add(AddressType.HOME);
        vcard.addAddress(adr);

        adr = new Address();
        adr.setPoBox("123");
        adr.setStreetAddress("456 Wall St.");
        adr.setLocality("New York");
        adr.setRegion("NY");
        adr.setPostalCode("11111");
        adr.setCountry("USA");
        adr.getTypes().add(AddressType.PREF);
        adr.getTypes().add(AddressType.WORK);
        vcard.addAddress(adr);

        vcard.setOrganization("Google", "GMail");

        Birthday bday = new Birthday(LocalDate.of(1970, 3, 8));
        vcard.setBirthday(bday);

        vcard.addUrl("http://company.com");

        vcard.setCategories("business owner", "jolly");

        vcard.addImpp(Impp.aim("myhandle"));
        vcard.addImpp(Impp.yahoo("myhandle@yahoo.com"));

        vcard.addNote("I am proficient in Tiger-Crane Style," + NEWLINE + "and I am more than proficient in the exquisite art of the Samurai sword.");

        vcard.setGeo(123.456, -98.123);

        vcard.setTimezone(new Timezone(ZoneOffset.ofHours(-6), "America/Chicago"));

        vcard.setUid(new Uid("urn:uuid:ffce1595-cbe9-4418-9d0d-b015655d45f6"));

        vcard.setRevision(new Revision(LocalDateTime.of(2000, 3, 15, 13, 22, 44).toInstant(ZoneOffset.UTC)));

        vcard.addProperty(new Birthplace("NorthPole"));
        vcard.addProperty(new Deathplace("NorthPole"));
        vcard.addProperty(new Deathdate(LocalDate.of(2270, 12, 31)));
        vcard.addProperty(new CalendarUri("http://NorthPole.org"));
        vcard.addProperty(new CalendarRequestUri("http://NorthPole.org"));

        vcard.addProperty(new OrgDirectory("http://NorthPole.org"));

        vcard.addProperty(new Expertise("deliver presents").setLevel(ExpertiseLevel.EXPERT));
        vcard.addProperty(new Expertise("fashion clothing").setLevel(ExpertiseLevel.BEGINNER));

        vcard.addProperty(new Hobby("collecting cards").setLevel(HobbyLevel.MEDIUM));
        vcard.addProperty(new Interest("singing xmas songs").setLevel(InterestLevel.HIGH));

        vcard.addProperty(Impp.xmpp("@santa@NorthPole.org"));

        return vcard;
    }
}
