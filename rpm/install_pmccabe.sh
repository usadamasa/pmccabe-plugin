#!/bin/sh

yum install -y wget
#wget https://github.com/usadamasa/pmccabe-plugin/releases/download/v1.0/pmccabe-2.6-2.arm64.rpm
wget https://github.com/usadamasa/pmccabe-plugin/blob/add_rpm/rpm/pmccabe-2.6-2.arm64.rpm
yum localinstall -y pmccabe-2.6-2.arm64.rpm

