# MUTABLE-9: Make public static fields final
![Author](https://img.shields.io/badge/Author-Oracle-blue.svg)


Callers can trivially access and modify public non-final static fields. Neither accesses nor modifications can be guarded against, and newly set values cannot be validated. Fields with subclassable types may be set to objects with malicious implementations. Always declare public static fields as final.

        public class Files {
            public static final String separator = "/";
            public static final String pathSeparator = ":";
        }

If using an interface instead of a class, the modifiers "public static final" can be omitted to improve readability, as the constants are implicitly public, static, and final. Constants can alternatively be defined using an enum declaration.

Protected static fields suffer from the same problem as their public equivalents but also tend to indicate confused design.

## Example
![Author](https://img.shields.io/badge/Author-Robin.Peiremans-blue.svg)
![Date](https://img.shields.io/badge/Date-20180101-lightgrey.svg)

The `UnsafeFiles` class allows anyone to change the value of `separator`, without any validation. This could lead to unexpected results, as shown in the example.

The `SafeFiles` doesn't allow this public modification.
