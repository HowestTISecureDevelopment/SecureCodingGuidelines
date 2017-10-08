# FUNDAMENTALS-5: Minimise the number of permission checks
![Author](https://img.shields.io/badge/Author-Oracle-blue.svg)
![Agree](https://img.shields.io/badge/AGREE-1-green.svg)

Java is primarily an object-capability language. SecurityManager checks should be considered a last resort. Perform security checks at a few defined points and return an object (a capability) that client code retains so that no further permission checks are required.