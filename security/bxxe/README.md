# blind XXE

This PoC needs an online and an offline part.

* Change hostname in `local/bxxe.xml` and `online/bxxe.dtd` from `bxxe.example.com`
  to a hostname you control and have log access (you can use the `makebxxe` script).

* Upload the content of the `online` directory (`bxxe.dtd`, `exfil.txt`) to the host's
  webroot.

* Create exfiltration secret: `echo -en thisissecret > /tmp/secret.txt`

Usually, blind XXE only works if the exfiltrated file contains no newlines and only
urlsafe characters.
