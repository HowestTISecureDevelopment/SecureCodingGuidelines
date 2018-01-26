# 9 Access Control
![Author](https://img.shields.io/badge/Author-Oracle-blue.svg)
![UKN](https://img.shields.io/badge/UKN-Xavier-Depoorter-red.svg)


Although Java is largely an object-capability language, a stack-based access control mechanism is used to securely provide more conventional APIs.

 - ACCESS-1: [Understand how permissions are checked](g9_01)
 - ACCESS-2: [Beware of callback methods](g9_02)
 - ACCESS-3: [Safely invoke java.security.AccessController.doPrivileged](g9_03)
 - ACCESS-4: [Know how to restrict privileges through doPrivileged](g9_04)
 - ACCESS-5: [Be careful caching results of potentially privileged operations](g9_05)
 - ACCESS-6: [Understand how to transfer context](g9_06)
 - ACCESS-7: [Understand how thread construction transfers context](g9_07)
 - ACCESS-8: [Safely invoke standard APIs that bypass SecurityManager checks depending on the immediate caller's class loader](g9_08)
 - ACCESS-9: [Safely invoke standard APIs that perform tasks using the immediate caller's class loader instance](g9_09)
 - ACCESS-10: [Be aware of standard APIs that perform Java language access checks against the immediate caller](g9_10)
 - ACCESS-11: [Be aware java.lang.reflect.Method.invoke is ignored for checking the immediate caller](g9_11)
 - ACCESS-12: [Avoid using caller-sensitive method names in interface classes](g9_12)
 - ACCESS-13: [Avoid returning the results of privileged operations](g9_13)
