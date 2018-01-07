# MUTABLE-8: Define wrapper methods around modifiable internal state
![Author](https://img.shields.io/badge/Author-Oracle-blue.svg)


If a state that is internal to a class must be publicly accessible and modifiable, declare a private field and enable access to it via public wrapper methods. If the state is only intended to be accessed by subclasses, declare a private field and enable access via protected wrapper methods. Wrapper methods allow input validation to occur prior to the setting of a new value:

        public final class WrappedState {
            // private immutable object
            private String state;

            // wrapper method
            public String getState() {
                return state;
            }

            // wrapper method
            public void setState(final String newState) {
                this.state = requireValidation(newState);
            }

            private static String requireValidation(final String state) {
                if (...) {
                    throw new IllegalArgumentException("...");
                }
                return state;
            }
        }

Make additional defensive copies in getState and setState if the internal state is mutable, as described in Guideline [6-2](../g6_02). 

Where possible make methods for operations that make sense in the context of the interface of the class rather than merely exposing internal implementation.

## Classic getters/setters?
![Author](https://img.shields.io/badge/Author-Robin.Peiremans-blue.svg)
![Date](https://img.shields.io/badge/Date-20180101-lightgrey.svg)
![Agree](https://img.shields.io/badge/AGREE-1-green.svg)

This looks like the classic use of getters and setters to access an object's data, or am I missing something here?
