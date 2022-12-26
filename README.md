# File-Integrity-Monitoring-System
This is a CLI based demo of File Integrity Monitoring System short for FIM. Which looks after any illict changes made in your
testing directory.

There are many ways to check the integrity of files but this program implements a very basic file attribute to monitor the activity
that is by calculating cryptographic checksum in this case SHA3-512 hashsing algorithm of the files of a given folder and comparing 
them with a good baseline.

