Generate RPM Package
---

pmccabe's package is provided only Debian/Ubuntu.
So installing in CentOS/Fedora, convert deb to rpm.
Getting rpm In the following way, But this way using only **Debian/Ubuntu**.
`alien` command is too difficult to install by yum.

``` bash
# Only Debian
apt-get install -y alien
wget "https://launchpad.net/ubuntu/+source/pmccabe/2.6/+build/1917786/+files/pmccabe_2.6_amd64.deb"
alien --to-rpm pmccabe_2.6_amd64.deb # generate rpm
```
