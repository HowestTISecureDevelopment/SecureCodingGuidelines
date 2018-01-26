#Examples for the examination
Starting with the Example given to us on the contact day.

##Example Contact Dag 2
####1. Dynamic SQL
SQL injection on line 21.
Fixed by implementing prepared statments.
####2. Resources are not released 
Possible DOS attack, use try catch with finally to close the resources.
####3. private function
The public function rs2u does not need to be public, change it to private.
####4. Possible sensitive information in exception
On line 29, there is possible sensitive information into an exception.
##Example application Mattias
####1.Command line injection
on line 22 there is a "possible" command line injection.
Mitigation = just don't
####2. Class should be final
line 8
####3. Possible sensitive information in exception
line 29
