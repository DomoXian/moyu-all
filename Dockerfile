FROM maven:alpine
ADD build.sh /home/admin/
ADD . /home/admin/app/

USER admin
WORKDIR /home/admin/
