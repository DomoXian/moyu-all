FROM maven:alpine
ADD build.sh /home/admin/
ADD . /home/admin/app/
WORKDIR /home/admin/
