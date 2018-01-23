# INJECT-8: Take care interpreting untrusted code
![Author](https://img.shields.io/badge/Author-Oracle-blue.svg)


Code can be hidden in a number of places. If the source is not trusted to supply code, then a secure sandbox must be constructed to run it in. Some examples of components or APIs that can potentially execute untrusted code include:

- Scripts run through the javax.script scripting API or similar.
- LiveConnect interfaces with JavaScript running in the browser. The JavaScript running on a web page will not usually have been verified with an object code signing certificate.
- By default the Oracle implementation of the XSLT interpreter enables extensions to call Java code. Set the javax.xml.XMLConstants.FEATURE_SECURE_PROCESSING feature to disable it.
- Long Term Persistence of JavaBeans Components supports execution of Java statements.
- Java Sound will load code through the javax.sound.midi.MidiSystem.getSoundbank methods.
- RMI may allow loading of remote code specified by remote connection. On the Oracle JDK, this is disabled by default but may be enabled or disabled through the java.rmi.server.useCodebaseOnly system property.
- LDAP (RFC 2713) allows loading of remote code in a server response. On the Oracle JDK, this is disabled by default but may be enabled or disabled through the com.sun.jndi.ldap.object.trustURLCodebase system property.
- Many SQL implementations allow execution of code with effects outside of the database itself.

## Question
![Author](https://img.shields.io/badge/Author-Jürgen.Taverniers-blue.svg)
![Date](https://img.shields.io/badge/Date-20180115-lightgrey.svg)
![CHECKED BY LECTOR](https://img.shields.io/badge/CHECKED_BY_LECTOR-PENDING-orange.svg)
![Agree](https://img.shields.io/badge/AGREE-0-green.svg)
![Disagree](https://img.shields.io/badge/DISAGREE-0-red.svg)

Is this comparable to g0_03 by restricting code to the least privileges needed, using SecurityManager. Or are there other best practices in creating a sandbox?

## ExampleG3G08
![Author](https://img.shields.io/badge/Author-Jürgen.Taverniers-blue.svg)
![Date](https://img.shields.io/badge/Date-20180123-lightgrey.svg)
![CHECKED BY LECTOR](https://img.shields.io/badge/CHECKED_BY_LECTOR-PENDING-orange.svg)
![Agree](https://img.shields.io/badge/AGREE-0-green.svg)
![Disagree](https://img.shields.io/badge/DISAGREE-0-red.svg)

Prevent untrusted code from exiting...