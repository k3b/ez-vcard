Changes

Build
    bugfix HCard-Generation-geo (if locale is "de-DE")
    refactored: Replaced code-duplicates with interface default-functions
    api: added syntactical shugar: addXxx/setXxx return this to allow call-chaining
    build:
        added gradle(-submodul)-build support (parallel to pom.xml)
        updated libs (mockito:1.10.19->5.8.0; equalsverifier:1.7.6->3.15.5)
    docs: 
        updated README.md (Android compatibility, Gradle build). 
        created history.md
